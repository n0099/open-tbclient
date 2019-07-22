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
    public final com.baidu.adp.base.d fLY;
    public final com.baidu.adp.base.d fLZ;
    private final CustomMessageListener fqq;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.fqq = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.fLY = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fLZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fMb.refresh();
                }
            }
        };
        frsFragment.registerListener(this.fqq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            FrsViewData bmo = this.fMb.bmo();
            if (this.fug != null && this.fuh != null && this.ftP != null && bmo != null && bmo.getForum() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(bmo.getForum().getId())) {
                    bmo.getForum().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        bmo.getForum().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.cmV() >= 0) {
                        bmo.getForum().setUser_level(rVar.cmV());
                    }
                    if (z) {
                        this.fuh.a(bmo, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fMb.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cop().aA(this.fMb.getForumName(), false);
                    bmo.getForum().setLike(0);
                    this.fuh.bsB();
                    TbadkCoreApplication.getInst().delLikeForum(this.fMb.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    bmo.deleteLikeFeedForum(rVar.getFid());
                    this.fuh.i(bmo);
                    this.fNk.a(bmo, this.fug.brm());
                }
                if (bmo.getForum().getBannerListData() != null) {
                    bmo.getForum().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.ftP.bmS();
            }
        }
    }
}
