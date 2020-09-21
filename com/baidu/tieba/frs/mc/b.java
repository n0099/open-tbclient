package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes21.dex */
public class b extends j {
    private final CustomMessageListener hWb;
    public final com.baidu.adp.base.d ivF;
    public final com.baidu.adp.base.d ivG;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hWb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.ivF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.ivG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.ivI.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hWb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cpJ = this.ivI.cpJ();
            if (this.iao != null && this.iap != null && this.hZV != null && cpJ != null && cpJ.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cpJ.getForum().getId())) {
                    cpJ.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cpJ.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dxT() >= 0) {
                        cpJ.getForum().setUser_level(vVar.dxT());
                    }
                    if (z) {
                        this.iap.a(cpJ, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.ivI.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dzD().aW(this.ivI.getForumName(), false);
                    cpJ.getForum().setLike(0);
                    this.iap.cwS();
                    TbadkCoreApplication.getInst().delLikeForum(this.ivI.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cpJ.deleteLikeFeedForum(vVar.getFid());
                    this.iap.i(cpJ);
                    this.iwS.a(cpJ, this.iao.cvm());
                }
                if (cpJ.getForum().getBannerListData() != null) {
                    cpJ.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.hZV.cqr();
            }
        }
    }
}
