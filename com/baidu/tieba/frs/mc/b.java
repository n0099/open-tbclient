package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes9.dex */
public class b extends j {
    public final com.baidu.adp.base.d gGA;
    public final com.baidu.adp.base.d gGB;
    private final CustomMessageListener gkG;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.gkG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.gGA = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.gGB = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.gGD.refresh();
                }
            }
        };
        frsFragment.registerListener(this.gkG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bEn = this.gGD.bEn();
            if (this.goA != null && this.goB != null && this.gok != null && bEn != null && bEn.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bEn.getForum().getId())) {
                    bEn.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bEn.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.cII() >= 0) {
                        bEn.getForum().setUser_level(tVar.cII());
                    }
                    if (z) {
                        this.goB.a(bEn, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.gGD.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cJZ().aA(this.gGD.getForumName(), false);
                    bEn.getForum().setLike(0);
                    this.goB.bKJ();
                    TbadkCoreApplication.getInst().delLikeForum(this.gGD.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bEn.deleteLikeFeedForum(tVar.getFid());
                    this.goB.i(bEn);
                    this.gHS.a(bEn, this.goA.bJn());
                }
                if (bEn.getForum().getBannerListData() != null) {
                    bEn.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.gok.bER();
            }
        }
    }
}
