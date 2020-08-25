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
    private final CustomMessageListener hOV;
    public final com.baidu.adp.base.d ioj;
    public final com.baidu.adp.base.d iok;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.hOV = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.ioj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.iok = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.iom.refresh();
                }
            }
        };
        frsFragment.registerListener(this.hOV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cmw = this.iom.cmw();
            if (this.hTi != null && this.hTj != null && this.hSP != null && cmw != null && cmw.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cmw.getForum().getId())) {
                    cmw.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cmw.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dtV() >= 0) {
                        cmw.getForum().setUser_level(vVar.dtV());
                    }
                    if (z) {
                        this.hTj.a(cmw, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.iom.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dvF().aW(this.iom.getForumName(), false);
                    cmw.getForum().setLike(0);
                    this.hTj.ctA();
                    TbadkCoreApplication.getInst().delLikeForum(this.iom.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cmw.deleteLikeFeedForum(vVar.getFid());
                    this.hTj.i(cmw);
                    this.ipw.a(cmw, this.hTi.crW());
                }
                if (cmw.getForum().getBannerListData() != null) {
                    cmw.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.hSP.cne();
            }
        }
    }
}
