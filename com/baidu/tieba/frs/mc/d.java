package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class d extends w {
    private final CustomMessageListener bNj;
    public final com.baidu.adp.base.f bZZ;
    public final com.baidu.adp.base.f caa;

    public d(FrsActivity frsActivity) {
        super(frsActivity);
        this.bNj = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.bZZ = new f(this);
        this.caa = new g(this);
        this.bVk.registerListener(this.bNj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tieba.tbadkCore.n aas = this.bVk.aas();
            if (this.bPf != null && this.bPh != null && this.bPg != null && this.bOU != null && aas != null && aas.aKx() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(aas.aKx().getId())) {
                    aas.aKx().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        aas.aKx().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.getUserLevel() >= 0) {
                        aas.aKx().setUser_level(vVar.getUserLevel());
                    }
                    if (z) {
                        this.bPg.a(aas, false);
                        this.bPh.ea(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bVk.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bhj().V(this.bVk.getForumName(), false);
                    aas.aKx().setLike(0);
                    this.bPg.aeV();
                    this.bPh.ea(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bVk.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    aas.pQ(vVar.getFid());
                    this.bPg.h(aas);
                    this.bPk.a(this.bOU.getListView(), aas, this.bPf.adS());
                }
                if (aas.aKx().getBannerListData() != null) {
                    aas.aKx().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.bOU.aaW();
            }
        }
    }
}
