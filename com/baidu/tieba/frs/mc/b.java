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
            FrsViewData bOW = this.hro.bOW();
            if (this.gYM != null && this.gYN != null && this.gYw != null && bOW != null && bOW.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bOW.getForum().getId())) {
                    bOW.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bOW.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.cTF() >= 0) {
                        bOW.getForum().setUser_level(uVar.cTF());
                    }
                    if (z) {
                        this.gYN.a(bOW, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.hro.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.cVp().aG(this.hro.getForumName(), false);
                    bOW.getForum().setLike(0);
                    this.gYN.bVx();
                    TbadkCoreApplication.getInst().delLikeForum(this.hro.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bOW.deleteLikeFeedForum(uVar.getFid());
                    this.gYN.i(bOW);
                    this.hsB.a(bOW, this.gYM.bTY());
                }
                if (bOW.getForum().getBannerListData() != null) {
                    bOW.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.gYw.bPC();
            }
        }
    }
}
