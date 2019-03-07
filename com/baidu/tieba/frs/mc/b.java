package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes4.dex */
public class b extends j {
    private final CustomMessageListener eVy;
    public final com.baidu.adp.base.d fqQ;
    public final com.baidu.adp.base.d fqR;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.eVy = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.fqQ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fqR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fqT.refresh();
                }
            }
        };
        frsFragment.registerListener(this.eVy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            FrsViewData bcR = this.fqT.bcR();
            if (this.eZk != null && this.eZl != null && this.eYT != null && bcR != null && bcR.getForum() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(bcR.getForum().getId())) {
                    bcR.getForum().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        bcR.getForum().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.cbX() >= 0) {
                        bcR.getForum().setUser_level(rVar.cbX());
                    }
                    if (z) {
                        this.eZl.a(bcR, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fqT.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cdr().at(this.fqT.getForumName(), false);
                    bcR.getForum().setLike(0);
                    this.eZl.bjf();
                    TbadkCoreApplication.getInst().delLikeForum(this.fqT.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    bcR.deleteLikeFeedForum(rVar.getFid());
                    this.eZl.h(bcR);
                    this.fsd.a(bcR, this.eZk.bhP());
                }
                if (bcR.getForum().getBannerListData() != null) {
                    bcR.getForum().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.eYT.bdx();
            }
        }
    }
}
