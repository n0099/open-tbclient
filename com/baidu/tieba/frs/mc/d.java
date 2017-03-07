package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.frs.FrsActivity;
/* loaded from: classes.dex */
public class d extends u {
    private final CustomMessageListener bKZ;
    public final com.baidu.adp.base.f bZj;
    public final com.baidu.adp.base.f bZk;

    public d(FrsActivity frsActivity) {
        super(frsActivity);
        this.bKZ = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.bZj = new f(this);
        this.bZk = new g(this);
        this.bTf.registerListener(this.bKZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.v vVar) {
        if (vVar != null) {
            com.baidu.tieba.tbadkCore.n YV = this.bTf.YV();
            if (this.bMY != null && this.bNa != null && this.bMZ != null && this.bMN != null && YV != null && YV.aJp() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(YV.aJp().getId())) {
                    YV.aJp().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        YV.aJp().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.getUserLevel() >= 0) {
                        YV.aJp().setUser_level(vVar.getUserLevel());
                    }
                    if (z) {
                        this.bMZ.a(YV, false);
                        this.bNa.dO(true);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bTf.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bft().V(this.bTf.getForumName(), false);
                    YV.aJp().setLike(0);
                    this.bMZ.adZ();
                    this.bNa.dO(false);
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bTf.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    YV.py(vVar.getFid());
                    this.bMZ.h(YV);
                    this.bNd.a(this.bMN.getListView(), YV, this.bMY.acX());
                }
                if (YV.aJp().getBannerListData() != null) {
                    YV.aJp().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.bMN.Zx();
            }
        }
    }
}
