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
    public final com.baidu.adp.base.d fOB;
    public final com.baidu.adp.base.d fOC;
    private final CustomMessageListener fsD;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.fsD = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.fOB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fOC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fOE.refresh();
                }
            }
        };
        frsFragment.registerListener(this.fsD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bnj = this.fOE.bnj();
            if (this.fws != null && this.fwt != null && this.fwb != null && bnj != null && bnj.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bnj.getForum().getId())) {
                    bnj.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bnj.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.coa() >= 0) {
                        bnj.getForum().setUser_level(tVar.coa());
                    }
                    if (z) {
                        this.fwt.a(bnj, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fOE.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cpu().aA(this.fOE.getForumName(), false);
                    bnj.getForum().setLike(0);
                    this.fwt.btB();
                    TbadkCoreApplication.getInst().delLikeForum(this.fOE.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bnj.deleteLikeFeedForum(tVar.getFid());
                    this.fwt.i(bnj);
                    this.fPO.a(bnj, this.fws.bsl());
                }
                if (bnj.getForum().getBannerListData() != null) {
                    bnj.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.fwb.bnN();
            }
        }
    }
}
