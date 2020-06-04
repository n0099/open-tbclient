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
    public final com.baidu.adp.base.d hGN;
    public final com.baidu.adp.base.d hGO;
    private final CustomMessageListener hjM;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hjM = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                    b.this.b((u) customResponsedMessage.getData());
                }
            }
        };
        this.hGN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.hGO = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.hGQ.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hjM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar) {
        if (uVar != null) {
            FrsViewData bVu = this.hGQ.bVu();
            if (this.hnJ != null && this.hnK != null && this.hnt != null && bVu != null && bVu.getForum() != null && uVar.getFid() != null) {
                boolean z = uVar.isLike() == 1;
                if (uVar.getFid().equals(bVu.getForum().getId())) {
                    bVu.getForum().setLike(uVar.isLike());
                    if (!StringUtils.isNULL(uVar.getLevelName())) {
                        bVu.getForum().setLevelName(uVar.getLevelName());
                    }
                    if (uVar.dba() >= 0) {
                        bVu.getForum().setUser_level(uVar.dba());
                    }
                    if (z) {
                        this.hnK.a(bVu, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.hGQ.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dcJ().aT(this.hGQ.getForumName(), false);
                    bVu.getForum().setLike(0);
                    this.hnK.cce();
                    TbadkCoreApplication.getInst().delLikeForum(this.hGQ.getForumName());
                    return;
                }
                if (uVar.isLike() == 1) {
                    bVu.deleteLikeFeedForum(uVar.getFid());
                    this.hnK.i(bVu);
                    this.hIc.a(bVu, this.hnJ.caD());
                }
                if (bVu.getForum().getBannerListData() != null) {
                    bVu.getForum().getBannerListData().setFeedForumLiked(uVar.getFid(), uVar.isLike());
                }
                this.hnt.bWb();
            }
        }
    }
}
