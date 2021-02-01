package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class b extends j {
    public final com.baidu.adp.base.e jEE;
    public final com.baidu.adp.base.e jEF;
    private final CustomMessageListener jcp;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.jcp = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jEE = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jEF = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jEH.refresh();
                }
            }
        };
        frsFragment.registerListener(this.jcp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cCZ = this.jEH.cCZ();
            if (this.jgz != null && this.jgA != null && this.jgh != null && cCZ != null && cCZ.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cCZ.getForum().getId())) {
                    cCZ.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cCZ.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bKx() >= 0) {
                        cCZ.getForum().setUser_level(wVar.bKx());
                    }
                    if (z) {
                        this.jgA.a(cCZ, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jEH.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dMs().bd(this.jEH.getForumName(), false);
                    cCZ.getForum().setLike(0);
                    this.jgA.cLp();
                    TbadkCoreApplication.getInst().delLikeForum(this.jEH.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cCZ.deleteLikeFeedForum(wVar.getFid());
                    this.jgA.j(cCZ);
                    this.jFP.a(cCZ, this.jgz.cJF());
                }
                if (cCZ.getForum().getBannerListData() != null) {
                    cCZ.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.jgh.cDH();
            }
        }
    }
}
