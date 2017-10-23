package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class b extends h {
    public final com.baidu.adp.base.d cEA;
    public final com.baidu.adp.base.d cEB;
    private final CustomMessageListener cnr;

    public b(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cnr = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    b.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.cEA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cEB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.cwW.refresh();
                }
            }
        };
        fVar.registerListener(this.cnr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i ahf = this.cwW.ahf();
            if (this.cqq != null && this.cqr != null && this.cqh != null && ahf != null && ahf.aMU() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(ahf.aMU().getId())) {
                    ahf.aMU().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        ahf.aMU().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        ahf.aMU().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cqr.a(ahf, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cwW.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bpi().Y(this.cwW.getForumName(), false);
                    ahf.aMU().setLike(0);
                    this.cqr.alR();
                    TbadkCoreApplication.getInst().delLikeForum(this.cwW.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    ahf.rE(oVar.getFid());
                    this.cqr.f(ahf);
                    this.cqs.a(this.cqh.getListView(), ahf, this.cqq.akY());
                }
                if (ahf.aMU().getBannerListData() != null) {
                    ahf.aMU().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.cqh.ahv();
            }
        }
    }
}
