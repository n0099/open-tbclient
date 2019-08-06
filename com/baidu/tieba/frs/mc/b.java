package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes4.dex */
public class b extends j {
    public final com.baidu.adp.base.d fMM;
    public final com.baidu.adp.base.d fMN;
    private final CustomMessageListener fqP;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.fqP = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.fMM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fMN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fMP.refresh();
                }
            }
        };
        frsFragment.registerListener(this.fqP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bmy = this.fMP.bmy();
            if (this.fuF != null && this.fuG != null && this.fuo != null && bmy != null && bmy.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bmy.getForum().getId())) {
                    bmy.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bmy.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.cnn() >= 0) {
                        bmy.getForum().setUser_level(tVar.cnn());
                    }
                    if (z) {
                        this.fuG.a(bmy, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fMP.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.coH().aA(this.fMP.getForumName(), false);
                    bmy.getForum().setLike(0);
                    this.fuG.bsO();
                    TbadkCoreApplication.getInst().delLikeForum(this.fMP.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bmy.deleteLikeFeedForum(tVar.getFid());
                    this.fuG.i(bmy);
                    this.fNY.a(bmy, this.fuF.brz());
                }
                if (bmy.getForum().getBannerListData() != null) {
                    bmy.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.fuo.bnc();
            }
        }
    }
}
