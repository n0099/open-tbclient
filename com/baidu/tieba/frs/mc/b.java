package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.u;
/* loaded from: classes16.dex */
public class b extends j {
    private final CustomMessageListener hBG;
    public final com.baidu.adp.base.d hZZ;
    public final com.baidu.adp.base.d iaa;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hBG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.hZZ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.iaa = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.iac.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hBG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData cbZ = this.iac.cbZ();
            if (this.hFS != null && this.hFT != null && this.hFz != null && cbZ != null && cbZ.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(cbZ.getForum().getId())) {
                    cbZ.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        cbZ.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.diA() >= 0) {
                        cbZ.getForum().setUser_level(uVar.diA());
                    }
                    if (z) {
                        this.hFT.a(cbZ, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.iac.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dki().aS(this.iac.getForumName(), false);
                    cbZ.getForum().setLike(0);
                    this.hFT.ciW();
                    TbadkCoreApplication.getInst().delLikeForum(this.iac.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    cbZ.deleteLikeFeedForum(uVar.getFid());
                    this.hFT.i(cbZ);
                    this.ibn.a(cbZ, this.hFS.chr());
                }
                if (cbZ.getForum().getBannerListData() != null) {
                    cbZ.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.hFz.ccH();
            }
        }
    }
}
