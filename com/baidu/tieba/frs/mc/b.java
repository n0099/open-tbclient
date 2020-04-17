package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes9.dex */
public class b extends j {
    private final CustomMessageListener gUJ;
    public final com.baidu.adp.base.d hrf;
    public final com.baidu.adp.base.d hrg;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.gUJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.hrf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.hrg = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.hri.refresh();
                }
            }
        };
        frsFragment.registerListener(this.gUJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData bOY = this.hri.bOY();
            if (this.gYG != null && this.gYH != null && this.gYq != null && bOY != null && bOY.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bOY.getForum().getId())) {
                    bOY.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bOY.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.cTI() >= 0) {
                        bOY.getForum().setUser_level(uVar.cTI());
                    }
                    if (z) {
                        this.gYH.a(bOY, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.hri.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.cVs().aG(this.hri.getForumName(), false);
                    bOY.getForum().setLike(0);
                    this.gYH.bVz();
                    TbadkCoreApplication.getInst().delLikeForum(this.hri.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bOY.deleteLikeFeedForum(uVar.getFid());
                    this.gYH.i(bOY);
                    this.hsv.a(bOY, this.gYG.bUa());
                }
                if (bOY.getForum().getBannerListData() != null) {
                    bOY.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.gYq.bPE();
            }
        }
    }
}
