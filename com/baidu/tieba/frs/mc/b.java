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
    private final CustomMessageListener iEj;
    public final com.baidu.adp.base.d jdE;
    public final com.baidu.adp.base.d jdF;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.iEj = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.jdE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jdF = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jdH.refresh();
                }
            }
        };
        frsFragment.registerListener(this.iEj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cys = this.jdH.cys();
            if (this.iIw != null && this.iIx != null && this.iId != null && cys != null && cys.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cys.getForum().getId())) {
                    cys.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cys.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dHf() >= 0) {
                        cys.getForum().setUser_level(vVar.dHf());
                    }
                    if (z) {
                        this.iIx.a(cys, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jdH.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dIP().bc(this.jdH.getForumName(), false);
                    cys.getForum().setLike(0);
                    this.iIx.cFC();
                    TbadkCoreApplication.getInst().delLikeForum(this.jdH.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cys.deleteLikeFeedForum(vVar.getFid());
                    this.iIx.j(cys);
                    this.jeR.a(cys, this.iIw.cDV());
                }
                if (cys.getForum().getBannerListData() != null) {
                    cys.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.iId.cza();
            }
        }
    }
}
