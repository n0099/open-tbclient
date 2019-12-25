package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes6.dex */
public class b extends j {
    public final com.baidu.adp.base.d gBr;
    public final com.baidu.adp.base.d gBs;
    private final CustomMessageListener gfv;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.gfv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.gBr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.gBs = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.gBu.refresh();
                }
            }
        };
        frsFragment.registerListener(this.gfv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bBI = this.gBu.bBI();
            if (this.gjp != null && this.gjq != null && this.gja != null && bBI != null && bBI.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bBI.getForum().getId())) {
                    bBI.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bBI.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.cFY() >= 0) {
                        bBI.getForum().setUser_level(tVar.cFY());
                    }
                    if (z) {
                        this.gjq.a(bBI, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.gBu.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cHp().aA(this.gBu.getForumName(), false);
                    bBI.getForum().setLike(0);
                    this.gjq.bIg();
                    TbadkCoreApplication.getInst().delLikeForum(this.gBu.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bBI.deleteLikeFeedForum(tVar.getFid());
                    this.gjq.i(bBI);
                    this.gCE.a(bBI, this.gjp.bGJ());
                }
                if (bBI.getForum().getBannerListData() != null) {
                    bBI.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.gja.bCm();
            }
        }
    }
}
