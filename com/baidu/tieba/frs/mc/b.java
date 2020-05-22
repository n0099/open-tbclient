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
    public final com.baidu.adp.base.d hGa;
    public final com.baidu.adp.base.d hGb;
    private final CustomMessageListener hjB;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hjB = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.hGa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.hGb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.hGd.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hjB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData bVs = this.hGd.bVs();
            if (this.hny != null && this.hnz != null && this.hni != null && bVs != null && bVs.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bVs.getForum().getId())) {
                    bVs.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bVs.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.daK() >= 0) {
                        bVs.getForum().setUser_level(uVar.daK());
                    }
                    if (z) {
                        this.hnz.a(bVs, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.hGd.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dcu().aT(this.hGd.getForumName(), false);
                    bVs.getForum().setLike(0);
                    this.hnz.cbW();
                    TbadkCoreApplication.getInst().delLikeForum(this.hGd.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bVs.deleteLikeFeedForum(uVar.getFid());
                    this.hnz.i(bVs);
                    this.hHp.a(bVs, this.hny.cav());
                }
                if (bVs.getForum().getBannerListData() != null) {
                    bVs.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.hni.bVZ();
            }
        }
    }
}
