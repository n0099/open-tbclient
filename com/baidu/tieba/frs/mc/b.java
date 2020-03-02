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
    public final com.baidu.adp.base.d gGC;
    public final com.baidu.adp.base.d gGD;
    private final CustomMessageListener gkI;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.gkI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.gGC = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.gGD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.gGF.refresh();
                }
            }
        };
        frsFragment.registerListener(this.gkI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bEp = this.gGF.bEp();
            if (this.goC != null && this.goD != null && this.gom != null && bEp != null && bEp.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bEp.getForum().getId())) {
                    bEp.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bEp.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.cIK() >= 0) {
                        bEp.getForum().setUser_level(tVar.cIK());
                    }
                    if (z) {
                        this.goD.a(bEp, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.gGF.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cKb().aA(this.gGF.getForumName(), false);
                    bEp.getForum().setLike(0);
                    this.goD.bKL();
                    TbadkCoreApplication.getInst().delLikeForum(this.gGF.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bEp.deleteLikeFeedForum(tVar.getFid());
                    this.goD.i(bEp);
                    this.gHU.a(bEp, this.goC.bJp());
                }
                if (bEp.getForum().getBannerListData() != null) {
                    bEp.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.gom.bET();
            }
        }
    }
}
