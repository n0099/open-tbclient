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
    public final com.baidu.adp.base.e jES;
    public final com.baidu.adp.base.e jET;
    private final CustomMessageListener jcD;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.jcD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jES = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jET = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jEV.refresh();
                }
            }
        };
        frsFragment.registerListener(this.jcD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cDg = this.jEV.cDg();
            if (this.jgN != null && this.jgO != null && this.jgv != null && cDg != null && cDg.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cDg.getForum().getId())) {
                    cDg.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cDg.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bKC() >= 0) {
                        cDg.getForum().setUser_level(wVar.bKC());
                    }
                    if (z) {
                        this.jgO.a(cDg, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jEV.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dMA().bd(this.jEV.getForumName(), false);
                    cDg.getForum().setLike(0);
                    this.jgO.cLw();
                    TbadkCoreApplication.getInst().delLikeForum(this.jEV.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cDg.deleteLikeFeedForum(wVar.getFid());
                    this.jgO.j(cDg);
                    this.jGd.a(cDg, this.jgN.cJM());
                }
                if (cDg.getForum().getBannerListData() != null) {
                    cDg.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.jgv.cDO();
            }
        }
    }
}
