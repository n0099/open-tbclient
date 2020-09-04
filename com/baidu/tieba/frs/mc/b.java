package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.v;
/* loaded from: classes16.dex */
public class b extends j {
    private final CustomMessageListener hPb;
    public final com.baidu.adp.base.d iop;
    public final com.baidu.adp.base.d ioq;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hPb = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.iop = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.ioq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.ios.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hPb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cmx = this.ios.cmx();
            if (this.hTo != null && this.hTp != null && this.hSV != null && cmx != null && cmx.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cmx.getForum().getId())) {
                    cmx.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cmx.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dua() >= 0) {
                        cmx.getForum().setUser_level(vVar.dua());
                    }
                    if (z) {
                        this.hTp.a(cmx, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.ios.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dvK().aW(this.ios.getForumName(), false);
                    cmx.getForum().setLike(0);
                    this.hTp.ctB();
                    TbadkCoreApplication.getInst().delLikeForum(this.ios.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cmx.deleteLikeFeedForum(vVar.getFid());
                    this.hTp.i(cmx);
                    this.ipC.a(cmx, this.hTo.crX());
                }
                if (cmx.getForum().getBannerListData() != null) {
                    cmx.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.hSV.cnf();
            }
        }
    }
}
