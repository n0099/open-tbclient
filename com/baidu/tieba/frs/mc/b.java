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
    private final CustomMessageListener eVg;
    public final com.baidu.adp.base.d fqB;
    public final com.baidu.adp.base.d fqC;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.eVg = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.fqB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fqC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fqE.refresh();
                }
            }
        };
        frsFragment.registerListener(this.eVg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            FrsViewData bcP = this.fqE.bcP();
            if (this.eYV != null && this.eYW != null && this.eYE != null && bcP != null && bcP.getForum() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(bcP.getForum().getId())) {
                    bcP.getForum().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        bcP.getForum().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.cbW() >= 0) {
                        bcP.getForum().setUser_level(rVar.cbW());
                    }
                    if (z) {
                        this.eYW.a(bcP, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fqE.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cdq().au(this.fqE.getForumName(), false);
                    bcP.getForum().setLike(0);
                    this.eYW.bjd();
                    TbadkCoreApplication.getInst().delLikeForum(this.fqE.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    bcP.deleteLikeFeedForum(rVar.getFid());
                    this.eYW.h(bcP);
                    this.frO.a(bcP, this.eYV.bhN());
                }
                if (bcP.getForum().getBannerListData() != null) {
                    bcP.getForum().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.eYE.bdv();
            }
        }
    }
}
