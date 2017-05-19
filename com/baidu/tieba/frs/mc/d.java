package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class d extends w {
    private final CustomMessageListener bMn;
    public final com.baidu.adp.base.f bXP;
    public final com.baidu.adp.base.f bXQ;

    public d(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bMn = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.bXP = new f(this);
        this.bXQ = new g(this);
        rVar.registerListener(this.bMn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.t tVar) {
        if (tVar != null) {
            com.baidu.tieba.tbadkCore.n Zq = this.bNK.Zq();
            if (this.bOw != null && this.bOx != null && this.bOn != null && Zq != null && Zq.aHE() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(Zq.aHE().getId())) {
                    Zq.aHE().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        Zq.aHE().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.getUserLevel() >= 0) {
                        Zq.aHE().setUser_level(tVar.getUserLevel());
                    }
                    if (z) {
                        this.bOx.a(Zq, false);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bNK.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.beL().V(this.bNK.getForumName(), false);
                    Zq.aHE().setLike(0);
                    this.bOx.acW();
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bNK.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    Zq.pP(tVar.getFid());
                    this.bOx.f(Zq);
                    this.bOz.a(this.bOn.getListView(), Zq, this.bOw.abW());
                }
                if (Zq.aHE().getBannerListData() != null) {
                    Zq.aHE().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.bOn.ZE();
            }
        }
    }
}
