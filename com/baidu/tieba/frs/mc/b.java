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
    private final CustomMessageListener gUP;
    public final com.baidu.adp.base.d hrl;
    public final com.baidu.adp.base.d hrm;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.gUP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.hrl = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.hrm = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.hro.refresh();
                }
            }
        };
        frsFragment.registerListener(this.gUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData bOX = this.hro.bOX();
            if (this.gYM != null && this.gYN != null && this.gYw != null && bOX != null && bOX.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bOX.getForum().getId())) {
                    bOX.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bOX.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.cTG() >= 0) {
                        bOX.getForum().setUser_level(uVar.cTG());
                    }
                    if (z) {
                        this.gYN.a(bOX, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.hro.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.cVq().aG(this.hro.getForumName(), false);
                    bOX.getForum().setLike(0);
                    this.gYN.bVy();
                    TbadkCoreApplication.getInst().delLikeForum(this.hro.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bOX.deleteLikeFeedForum(uVar.getFid());
                    this.gYN.i(bOX);
                    this.hsB.a(bOX, this.gYM.bTZ());
                }
                if (bOX.getForum().getBannerListData() != null) {
                    bOX.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.gYw.bPD();
            }
        }
    }
}
