package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class d extends z {
    private final CustomMessageListener bZv;
    public final com.baidu.adp.base.f cmn;
    public final com.baidu.adp.base.f cmo;

    public d(com.baidu.tieba.frs.r rVar) {
        super(rVar);
        this.bZv = new e(this, CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS);
        this.cmn = new f(this);
        this.cmo = new g(this);
        rVar.registerListener(this.bZv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.tbadkCore.t tVar) {
        if (tVar != null) {
            com.baidu.tieba.tbadkCore.n aek = this.cbE.aek();
            if (this.ccs != null && this.cct != null && this.ccj != null && aek != null && aek.aMt() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(aek.aMt().getId())) {
                    aek.aMt().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        aek.aMt().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.getUserLevel() >= 0) {
                        aek.aMt().setUser_level(tVar.getUserLevel());
                    }
                    if (z) {
                        this.cct.a(aek, false);
                        TbadkCoreApplication.m9getInst().addLikeForum(this.cbE.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bkt().X(this.cbE.getForumName(), false);
                    aek.aMt().setLike(0);
                    this.cct.ahN();
                    TbadkCoreApplication.m9getInst().delLikeForum(this.cbE.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    aek.rb(tVar.getFid());
                    this.cct.f(aek);
                    this.ccu.a(this.ccj.getListView(), aek, this.ccs.agT());
                }
                if (aek.aMt().getBannerListData() != null) {
                    aek.aMt().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.ccj.aey();
            }
        }
    }
}
