package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes4.dex */
public class b extends j {
    public final com.baidu.adp.base.d fNV;
    public final com.baidu.adp.base.d fNW;
    private final CustomMessageListener frQ;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.frQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.fNV = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fNW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fNY.refresh();
                }
            }
        };
        frsFragment.registerListener(this.frQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bkp = this.fNY.bkp();
            if (this.fvF != null && this.fvG != null && this.fvo != null && bkp != null && bkp.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bkp.getForum().getId())) {
                    bkp.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bkp.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.clQ() >= 0) {
                        bkp.getForum().setUser_level(tVar.clQ());
                    }
                    if (z) {
                        this.fvG.a(bkp, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fNY.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cnl().av(this.fNY.getForumName(), false);
                    bkp.getForum().setLike(0);
                    this.fvG.bqE();
                    TbadkCoreApplication.getInst().delLikeForum(this.fNY.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bkp.deleteLikeFeedForum(tVar.getFid());
                    this.fvG.i(bkp);
                    this.fPi.a(bkp, this.fvF.bpp());
                }
                if (bkp.getForum().getBannerListData() != null) {
                    bkp.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.fvo.bkS();
            }
        }
    }
}
