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
    public final com.baidu.adp.base.d hUa;
    public final com.baidu.adp.base.d hUb;
    private final CustomMessageListener hvU;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hvU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.hUa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.hUb = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.hUd.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hvU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData bYB = this.hUd.bYB();
            if (this.hAc != null && this.hAd != null && this.hzK != null && bYB != null && bYB.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bYB.getForum().getId())) {
                    bYB.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bYB.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.dfq() >= 0) {
                        bYB.getForum().setUser_level(uVar.dfq());
                    }
                    if (z) {
                        this.hAd.a(bYB, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.hUd.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dgY().aV(this.hUd.getForumName(), false);
                    bYB.getForum().setLike(0);
                    this.hAd.cfw();
                    TbadkCoreApplication.getInst().delLikeForum(this.hUd.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bYB.deleteLikeFeedForum(uVar.getFid());
                    this.hAd.i(bYB);
                    this.hVo.a(bYB, this.hAc.cdR());
                }
                if (bYB.getForum().getBannerListData() != null) {
                    bYB.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.hzK.bZj();
            }
        }
    }
}
