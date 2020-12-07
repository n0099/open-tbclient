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
    private final CustomMessageListener iPb;
    public final com.baidu.adp.base.d jrh;
    public final com.baidu.adp.base.d jri;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.iPb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jrh = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jri = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jrk.refresh();
                }
            }
        };
        frsFragment.registerListener(this.iPb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cCJ = this.jrk.cCJ();
            if (this.iTn != null && this.iTo != null && this.iSV != null && cCJ != null && cCJ.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cCJ.getForum().getId())) {
                    cCJ.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cCJ.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bLB() >= 0) {
                        cCJ.getForum().setUser_level(wVar.bLB());
                    }
                    if (z) {
                        this.iTo.a(cCJ, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jrk.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dOf().bd(this.jrk.getForumName(), false);
                    cCJ.getForum().setLike(0);
                    this.iTo.cKR();
                    TbadkCoreApplication.getInst().delLikeForum(this.jrk.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cCJ.deleteLikeFeedForum(wVar.getFid());
                    this.iTo.j(cCJ);
                    this.jsu.a(cCJ, this.iTn.cJi());
                }
                if (cCJ.getForum().getBannerListData() != null) {
                    cCJ.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.iSV.cDr();
            }
        }
    }
}
