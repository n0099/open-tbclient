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
    public final com.baidu.adp.base.d gHM;
    public final com.baidu.adp.base.d gHN;
    private final CustomMessageListener glD;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.glD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.gHM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.gHN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.gHP.refresh();
                }
            }
        };
        frsFragment.registerListener(this.glD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData bEz = this.gHP.bEz();
            if (this.gpz != null && this.gpA != null && this.gpj != null && bEz != null && bEz.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bEz.getForum().getId())) {
                    bEz.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bEz.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.cJf() >= 0) {
                        bEz.getForum().setUser_level(uVar.cJf());
                    }
                    if (z) {
                        this.gpA.a(bEz, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.gHP.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.cKw().aA(this.gHP.getForumName(), false);
                    bEz.getForum().setLike(0);
                    this.gpA.bKZ();
                    TbadkCoreApplication.getInst().delLikeForum(this.gHP.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bEz.deleteLikeFeedForum(uVar.getFid());
                    this.gpA.i(bEz);
                    this.gJf.a(bEz, this.gpz.bJD());
                }
                if (bEz.getForum().getBannerListData() != null) {
                    bEz.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.gpj.bFe();
            }
        }
    }
}
