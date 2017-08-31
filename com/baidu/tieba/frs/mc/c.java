package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class c extends i {
    public final com.baidu.adp.base.d cDb;
    public final com.baidu.adp.base.d cDc;
    private final CustomMessageListener cmo;

    public c(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cmo = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    c.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.cDb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cDc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    c.this.cvA.refresh();
                }
            }
        };
        fVar.registerListener(this.cmo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i ahf = this.cvA.ahf();
            if (this.cpn != null && this.cpo != null && this.cpe != null && ahf != null && ahf.aOV() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(ahf.aOV().getId())) {
                    ahf.aOV().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        ahf.aOV().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        ahf.aOV().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cpo.a(ahf, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cvA.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bqk().ab(this.cvA.getForumName(), false);
                    ahf.aOV().setLike(0);
                    this.cpo.alH();
                    TbadkCoreApplication.getInst().delLikeForum(this.cvA.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    ahf.rT(oVar.getFid());
                    this.cpo.f(ahf);
                    this.cpp.a(this.cpe.getListView(), ahf, this.cpn.akO());
                }
                if (ahf.aOV().getBannerListData() != null) {
                    ahf.aOV().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.cpe.ahw();
            }
        }
    }
}
