package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class d extends w {
    private final CustomMessageListener bKS;
    public final com.baidu.adp.base.f bXI;
    public final com.baidu.adp.base.f bXJ;

    public d(FrsActivity frsActivity) {
        super(frsActivity);
        this.bKS = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.bXI = new f(this);
        this.bXJ = new g(this);
        this.bST.registerListener(this.bKS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tieba.tbadkCore.n Zr = this.bST.Zr();
            if (this.bMO != null && this.bMQ != null && this.bMP != null && this.bMD != null && Zr != null && Zr.aJw() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(Zr.aJw().getId())) {
                    Zr.aJw().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        Zr.aJw().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.getUserLevel() >= 0) {
                        Zr.aJw().setUser_level(vVar.getUserLevel());
                    }
                    if (z) {
                        this.bMP.a(Zr, false);
                        this.bMQ.dQ(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bST.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bgh().V(this.bST.getForumName(), false);
                    Zr.aJw().setLike(0);
                    this.bMP.adU();
                    this.bMQ.dQ(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bST.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    Zr.pP(vVar.getFid());
                    this.bMP.h(Zr);
                    this.bMT.a(this.bMD.getListView(), Zr, this.bMO.acR());
                }
                if (Zr.aJw().getBannerListData() != null) {
                    Zr.aJw().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.bMD.ZV();
            }
        }
    }
}
