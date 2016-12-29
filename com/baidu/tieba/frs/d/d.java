package com.baidu.tieba.frs.d;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.tbadkCore.x;
/* loaded from: classes.dex */
public class d extends s {
    public final com.baidu.adp.base.g bLM;
    public final com.baidu.adp.base.g bLN;
    private final CustomMessageListener bwo;

    public d(FrsActivity frsActivity) {
        super(frsActivity);
        this.bwo = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.bLM = new f(this);
        this.bLN = new g(this);
        this.bFI.registerListener(this.bwo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(x xVar) {
        if (xVar != null) {
            com.baidu.tieba.tbadkCore.o WF = this.bFI.WF();
            if (this.byr != null && this.byt != null && this.bys != null && this.byg != null && WF != null && WF.aIk() != null && xVar.getFid() != null) {
                boolean z = xVar.isLike() == 1;
                if (xVar.getFid().equals(WF.aIk().getId())) {
                    WF.aIk().setLike(xVar.isLike());
                    if (!StringUtils.isNULL(xVar.getLevelName())) {
                        WF.aIk().setLevelName(xVar.getLevelName());
                    }
                    if (xVar.getUserLevel() >= 0) {
                        WF.aIk().setUser_level(xVar.getUserLevel());
                    }
                    if (z) {
                        this.bys.a(WF, false);
                        this.byt.eh(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bFI.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bdT().U(this.bFI.getForumName(), false);
                    WF.aIk().setLike(0);
                    this.bys.abS();
                    this.byt.eh(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bFI.getForumName());
                    return;
                }
                if (xVar.isLike() == 1) {
                    WF.pV(xVar.getFid());
                    this.bys.i(WF);
                    this.byw.a(this.byg.Xm(), WF, this.byr.aaU());
                }
                if (WF.aIk().getBannerListData() != null) {
                    WF.aIk().getBannerListData().setFeedForumLiked(xVar.getFid(), xVar.isLike());
                }
                this.byg.Xj();
            }
        }
    }
}
