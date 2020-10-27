package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes22.dex */
public class b extends j {
    public final com.baidu.adp.base.d iWU;
    public final com.baidu.adp.base.d iWV;
    private final CustomMessageListener ixy;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.ixy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.iWU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.iWV = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.iWX.refresh();
                }
            }
        };
        frsFragment.registerListener(this.ixy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cwo = this.iWX.cwo();
            if (this.iBL != null && this.iBM != null && this.iBs != null && cwo != null && cwo.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cwo.getForum().getId())) {
                    cwo.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cwo.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dEM() >= 0) {
                        cwo.getForum().setUser_level(vVar.dEM());
                    }
                    if (z) {
                        this.iBM.a(cwo, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.iWX.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dGw().bc(this.iWX.getForumName(), false);
                    cwo.getForum().setLike(0);
                    this.iBM.cDw();
                    TbadkCoreApplication.getInst().delLikeForum(this.iWX.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cwo.deleteLikeFeedForum(vVar.getFid());
                    this.iBM.i(cwo);
                    this.iYh.a(cwo, this.iBL.cBQ());
                }
                if (cwo.getForum().getBannerListData() != null) {
                    cwo.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.iBs.cwW();
            }
        }
    }
}
