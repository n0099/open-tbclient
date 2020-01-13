package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes7.dex */
public class b extends j {
    public final com.baidu.adp.base.d gEB;
    public final com.baidu.adp.base.d gEC;
    private final CustomMessageListener giF;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.giF = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.gEB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.gEC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.gEE.refresh();
                }
            }
        };
        frsFragment.registerListener(this.giF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bCK = this.gEE.bCK();
            if (this.gmz != null && this.gmA != null && this.gmj != null && bCK != null && bCK.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bCK.getForum().getId())) {
                    bCK.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bCK.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.cHc() >= 0) {
                        bCK.getForum().setUser_level(tVar.cHc());
                    }
                    if (z) {
                        this.gmA.a(bCK, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.gEE.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cIt().aA(this.gEE.getForumName(), false);
                    bCK.getForum().setLike(0);
                    this.gmA.bJi();
                    TbadkCoreApplication.getInst().delLikeForum(this.gEE.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bCK.deleteLikeFeedForum(tVar.getFid());
                    this.gmA.i(bCK);
                    this.gFT.a(bCK, this.gmz.bHL());
                }
                if (bCK.getForum().getBannerListData() != null) {
                    bCK.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.gmj.bDo();
            }
        }
    }
}
