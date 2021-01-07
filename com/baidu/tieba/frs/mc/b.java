package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes2.dex */
public class b extends j {
    public final com.baidu.adp.base.e jDF;
    public final com.baidu.adp.base.e jDG;
    private final CustomMessageListener jbp;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.jbp = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jDF = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jDG = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jDI.refresh();
                }
            }
        };
        frsFragment.registerListener(this.jbp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cFF = this.jDI.cFF();
            if (this.jfA != null && this.jfB != null && this.jfi != null && cFF != null && cFF.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cFF.getForum().getId())) {
                    cFF.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cFF.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bNV() >= 0) {
                        cFF.getForum().setUser_level(wVar.bNV());
                    }
                    if (z) {
                        this.jfB.a(cFF, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jDI.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dNZ().bd(this.jDI.getForumName(), false);
                    cFF.getForum().setLike(0);
                    this.jfB.cNT();
                    TbadkCoreApplication.getInst().delLikeForum(this.jDI.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cFF.deleteLikeFeedForum(wVar.getFid());
                    this.jfB.j(cFF);
                    this.jER.a(cFF, this.jfA.cMk());
                }
                if (cFF.getForum().getBannerListData() != null) {
                    cFF.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.jfi.cGn();
            }
        }
    }
}
