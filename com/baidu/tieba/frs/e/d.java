package com.baidu.tieba.frs.e;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes.dex */
public class d extends s {
    private final CustomMessageListener bQk;
    public final com.baidu.adp.base.g cgd;
    public final com.baidu.adp.base.g cge;

    public d(FrsActivity frsActivity) {
        super(frsActivity);
        this.bQk = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.cgd = new f(this);
        this.cge = new g(this);
        this.bZY.registerListener(this.bQk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(y yVar) {
        if (yVar != null) {
            com.baidu.tieba.tbadkCore.p acr = this.bZY.acr();
            if (this.bSh != null && this.bSj != null && this.bSi != null && this.bRW != null && acr != null && acr.aOk() != null && yVar.getFid() != null) {
                boolean z = yVar.isLike() == 1;
                if (yVar.getFid().equals(acr.aOk().getId())) {
                    acr.aOk().setLike(yVar.isLike());
                    if (!StringUtils.isNULL(yVar.getLevelName())) {
                        acr.aOk().setLevelName(yVar.getLevelName());
                    }
                    if (yVar.getUserLevel() >= 0) {
                        acr.aOk().setUser_level(yVar.getUserLevel());
                    }
                    if (z) {
                        this.bSi.a(acr, false);
                        this.bSj.ex(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bZY.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.bkd().R(this.bZY.getForumName(), false);
                    acr.aOk().setLike(0);
                    this.bSi.ahv();
                    this.bSj.ex(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bZY.getForumName());
                    return;
                }
                if (yVar.isLike() == 1) {
                    acr.rr(yVar.getFid());
                    this.bSi.i(acr);
                    this.bSm.a(this.bRW.acW(), acr, this.bSh.agx());
                }
                if (acr.aOk().getBannerListData() != null) {
                    acr.aOk().getBannerListData().setFeedForumLiked(yVar.getFid(), yVar.isLike());
                }
                this.bRW.acT();
            }
        }
    }
}
