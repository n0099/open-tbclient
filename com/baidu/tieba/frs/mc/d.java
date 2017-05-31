package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class d extends w {
    private final CustomMessageListener bSa;
    public final com.baidu.adp.base.f cea;
    public final com.baidu.adp.base.f ceb;

    public d(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bSa = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.cea = new f(this);
        this.ceb = new g(this);
        rVar.registerListener(this.bSa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.t tVar) {
        if (tVar != null) {
            com.baidu.tieba.tbadkCore.n aau = this.bTw.aau();
            if (this.bUj != null && this.bUk != null && this.bUa != null && aau != null && aau.aIz() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(aau.aIz().getId())) {
                    aau.aIz().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        aau.aIz().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.getUserLevel() >= 0) {
                        aau.aIz().setUser_level(tVar.getUserLevel());
                    }
                    if (z) {
                        this.bUk.a(aau, false);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.bTw.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bgf().S(this.bTw.getForumName(), false);
                    aau.aIz().setLike(0);
                    this.bUk.adZ();
                    TbadkCoreApplication.m9getInst().delLikeForum(this.bTw.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    aau.qd(tVar.getFid());
                    this.bUk.f(aau);
                    this.bUm.a(this.bUa.getListView(), aau, this.bUj.ada());
                }
                if (aau.aIz().getBannerListData() != null) {
                    aau.aIz().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.bUa.aaH();
            }
        }
    }
}
