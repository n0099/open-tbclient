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
    public final com.baidu.adp.base.d gGO;
    public final com.baidu.adp.base.d gGP;
    private final CustomMessageListener gkV;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.gkV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.gGO = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.gGP = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.gGR.refresh();
                }
            }
        };
        frsFragment.registerListener(this.gkV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bEq = this.gGR.bEq();
            if (this.goP != null && this.goQ != null && this.goz != null && bEq != null && bEq.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bEq.getForum().getId())) {
                    bEq.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bEq.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.cIL() >= 0) {
                        bEq.getForum().setUser_level(tVar.cIL());
                    }
                    if (z) {
                        this.goQ.a(bEq, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.gGR.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cKc().aA(this.gGR.getForumName(), false);
                    bEq.getForum().setLike(0);
                    this.goQ.bKM();
                    TbadkCoreApplication.getInst().delLikeForum(this.gGR.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bEq.deleteLikeFeedForum(tVar.getFid());
                    this.goQ.i(bEq);
                    this.gIg.a(bEq, this.goP.bJq());
                }
                if (bEq.getForum().getBannerListData() != null) {
                    bEq.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.goz.bEU();
            }
        }
    }
}
