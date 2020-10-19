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
    public final com.baidu.adp.base.d iKy;
    public final com.baidu.adp.base.d iKz;
    private final CustomMessageListener ila;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.ila = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.iKy = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.iKz = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.iKB.refresh();
                }
            }
        };
        frsFragment.registerListener(this.ila);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cth = this.iKB.cth();
            if (this.ipp != null && this.ipq != null && this.ioW != null && cth != null && cth.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cth.getForum().getId())) {
                    cth.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cth.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dBE() >= 0) {
                        cth.getForum().setUser_level(vVar.dBE());
                    }
                    if (z) {
                        this.ipq.a(cth, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.iKB.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dDo().ba(this.iKB.getForumName(), false);
                    cth.getForum().setLike(0);
                    this.ipq.cAp();
                    TbadkCoreApplication.getInst().delLikeForum(this.iKB.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cth.deleteLikeFeedForum(vVar.getFid());
                    this.ipq.i(cth);
                    this.iLL.a(cth, this.ipp.cyJ());
                }
                if (cth.getForum().getBannerListData() != null) {
                    cth.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.ioW.ctP();
            }
        }
    }
}
