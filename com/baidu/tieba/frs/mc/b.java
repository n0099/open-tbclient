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
    public final com.baidu.adp.base.d fGW;
    public final com.baidu.adp.base.d fGX;
    private final CustomMessageListener flr;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.flr = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.fGW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fGX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fGZ.refresh();
                }
            }
        };
        frsFragment.registerListener(this.flr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            FrsViewData bkj = this.fGZ.bkj();
            if (this.fpg != null && this.fph != null && this.foP != null && bkj != null && bkj.getForum() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(bkj.getForum().getId())) {
                    bkj.getForum().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        bkj.getForum().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.ckb() >= 0) {
                        bkj.getForum().setUser_level(rVar.ckb());
                    }
                    if (z) {
                        this.fph.a(bkj, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fGZ.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.clu().aw(this.fGZ.getForumName(), false);
                    bkj.getForum().setLike(0);
                    this.fph.bqv();
                    TbadkCoreApplication.getInst().delLikeForum(this.fGZ.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    bkj.deleteLikeFeedForum(rVar.getFid());
                    this.fph.i(bkj);
                    this.fIj.a(bkj, this.fpg.bpg());
                }
                if (bkj.getForum().getBannerListData() != null) {
                    bkj.getForum().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.foP.bkN();
            }
        }
    }
}
