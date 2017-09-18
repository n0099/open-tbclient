package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
public class c extends i {
    public final com.baidu.adp.base.d cDT;
    public final com.baidu.adp.base.d cDU;
    private final CustomMessageListener cng;

    public c(com.baidu.tieba.frs.f fVar) {
        super(fVar);
        this.cng = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof o)) {
                    c.this.b((o) customResponsedMessage.getData());
                }
            }
        };
        this.cDT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.cDU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.c.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    c.this.cws.refresh();
                }
            }
        };
        fVar.registerListener(this.cng);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar) {
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.i ahq = this.cws.ahq();
            if (this.cqf != null && this.cqg != null && this.cpW != null && ahq != null && ahq.aPg() != null && oVar.getFid() != null) {
                boolean z = oVar.isLike() == 1;
                if (oVar.getFid().equals(ahq.aPg().getId())) {
                    ahq.aPg().setLike(oVar.isLike());
                    if (!StringUtils.isNULL(oVar.getLevelName())) {
                        ahq.aPg().setLevelName(oVar.getLevelName());
                    }
                    if (oVar.getUserLevel() >= 0) {
                        ahq.aPg().setUser_level(oVar.getUserLevel());
                    }
                    if (z) {
                        this.cqg.a(ahq, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.cws.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bqv().ab(this.cws.getForumName(), false);
                    ahq.aPg().setLike(0);
                    this.cqg.alS();
                    TbadkCoreApplication.getInst().delLikeForum(this.cws.getForumName());
                    return;
                }
                if (oVar.isLike() == 1) {
                    ahq.rV(oVar.getFid());
                    this.cqg.f(ahq);
                    this.cqh.a(this.cpW.getListView(), ahq, this.cqf.akZ());
                }
                if (ahq.aPg().getBannerListData() != null) {
                    ahq.aPg().getBannerListData().setFeedForumLiked(oVar.getFid(), oVar.isLike());
                }
                this.cpW.ahH();
            }
        }
    }
}
