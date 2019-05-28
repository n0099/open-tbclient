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
    public final com.baidu.adp.base.d fGX;
    public final com.baidu.adp.base.d fGY;
    private final CustomMessageListener fls;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.fls = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.fGX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fGY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fHa.refresh();
                }
            }
        };
        frsFragment.registerListener(this.fls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            FrsViewData bkm = this.fHa.bkm();
            if (this.fph != null && this.fpi != null && this.foQ != null && bkm != null && bkm.getForum() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(bkm.getForum().getId())) {
                    bkm.getForum().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        bkm.getForum().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.ckd() >= 0) {
                        bkm.getForum().setUser_level(rVar.ckd());
                    }
                    if (z) {
                        this.fpi.a(bkm, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fHa.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.clw().aw(this.fHa.getForumName(), false);
                    bkm.getForum().setLike(0);
                    this.fpi.bqy();
                    TbadkCoreApplication.getInst().delLikeForum(this.fHa.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    bkm.deleteLikeFeedForum(rVar.getFid());
                    this.fpi.i(bkm);
                    this.fIk.a(bkm, this.fph.bpj());
                }
                if (bkm.getForum().getBannerListData() != null) {
                    bkm.getForum().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.foQ.bkQ();
            }
        }
    }
}
