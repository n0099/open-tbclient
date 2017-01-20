package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes.dex */
public class d extends r {
    private final CustomMessageListener bDS;
    public final com.baidu.adp.base.f bSb;
    public final com.baidu.adp.base.f bSc;

    public d(FrsActivity frsActivity) {
        super(frsActivity);
        this.bDS = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.bSb = new f(this);
        this.bSc = new g(this);
        this.bLZ.registerListener(this.bDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            com.baidu.tieba.tbadkCore.n XW = this.bLZ.XW();
            if (this.bFQ != null && this.bFS != null && this.bFR != null && this.bFF != null && XW != null && XW.aJY() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(XW.aJY().getId())) {
                    XW.aJY().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        XW.aJY().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.getUserLevel() >= 0) {
                        XW.aJY().setUser_level(vVar.getUserLevel());
                    }
                    if (z) {
                        this.bFR.a(XW, false);
                        this.bFS.dO(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bLZ.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bfG().U(this.bLZ.getForumName(), false);
                    XW.aJY().setLike(0);
                    this.bFR.acZ();
                    this.bFS.dO(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bLZ.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    XW.qp(vVar.getFid());
                    this.bFR.h(XW);
                    this.bFV.a(this.bFF.Iv(), XW, this.bFQ.aca());
                }
                if (XW.aJY().getBannerListData() != null) {
                    XW.aJY().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.bFF.Yy();
            }
        }
    }
}
