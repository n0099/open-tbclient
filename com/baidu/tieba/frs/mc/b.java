package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes22.dex */
public class b extends j {
    private final CustomMessageListener iPd;
    public final com.baidu.adp.base.d jrj;
    public final com.baidu.adp.base.d jrk;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.iPd = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jrj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jrk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jrm.refresh();
                }
            }
        };
        frsFragment.registerListener(this.iPd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cCK = this.jrm.cCK();
            if (this.iTp != null && this.iTq != null && this.iSX != null && cCK != null && cCK.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cCK.getForum().getId())) {
                    cCK.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cCK.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bLC() >= 0) {
                        cCK.getForum().setUser_level(wVar.bLC());
                    }
                    if (z) {
                        this.iTq.a(cCK, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jrm.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dOg().bd(this.jrm.getForumName(), false);
                    cCK.getForum().setLike(0);
                    this.iTq.cKS();
                    TbadkCoreApplication.getInst().delLikeForum(this.jrm.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cCK.deleteLikeFeedForum(wVar.getFid());
                    this.iTq.j(cCK);
                    this.jsw.a(cCK, this.iTp.cJj());
                }
                if (cCK.getForum().getBannerListData() != null) {
                    cCK.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.iSX.cDs();
            }
        }
    }
}
