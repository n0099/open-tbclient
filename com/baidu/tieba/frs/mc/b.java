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
    public final com.baidu.adp.base.e jGB;
    public final com.baidu.adp.base.e jGC;
    private final CustomMessageListener jem;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.jem = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jGB = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jGC = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jGE.refresh();
                }
            }
        };
        frsFragment.registerListener(this.jem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cDm = this.jGE.cDm();
            if (this.jix != null && this.jiy != null && this.jif != null && cDm != null && cDm.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cDm.getForum().getId())) {
                    cDm.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cDm.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bKG() >= 0) {
                        cDm.getForum().setUser_level(wVar.bKG());
                    }
                    if (z) {
                        this.jiy.a(cDm, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jGE.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dMI().bd(this.jGE.getForumName(), false);
                    cDm.getForum().setLike(0);
                    this.jiy.cLC();
                    TbadkCoreApplication.getInst().delLikeForum(this.jGE.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cDm.deleteLikeFeedForum(wVar.getFid());
                    this.jiy.j(cDm);
                    this.jHM.a(cDm, this.jix.cJS());
                }
                if (cDm.getForum().getBannerListData() != null) {
                    cDm.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.jif.cDU();
            }
        }
    }
}
