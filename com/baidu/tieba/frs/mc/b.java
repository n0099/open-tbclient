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
    private final CustomMessageListener iWI;
    public final com.baidu.adp.base.e jyZ;
    public final com.baidu.adp.base.e jza;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.iWI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                    b.this.b((w) customResponsedMessage.getData());
                }
            }
        };
        this.jyZ = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jza = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.e
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jzc.refresh();
                }
            }
        };
        frsFragment.registerListener(this.iWI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(w wVar) {
        if (wVar != null) {
            FrsViewData cBN = this.jzc.cBN();
            if (this.jaT != null && this.jaU != null && this.jaB != null && cBN != null && cBN.getForum() != null && wVar.getFid() != null) {
                boolean z = wVar.isLike() == 1;
                if (wVar.getFid().equals(cBN.getForum().getId())) {
                    cBN.getForum().setLike(wVar.isLike());
                    if (!StringUtils.isNULL(wVar.getLevelName())) {
                        cBN.getForum().setLevelName(wVar.getLevelName());
                    }
                    if (wVar.bKd() >= 0) {
                        cBN.getForum().setUser_level(wVar.bKd());
                    }
                    if (z) {
                        this.jaU.a(cBN, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jzc.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dKh().bd(this.jzc.getForumName(), false);
                    cBN.getForum().setLike(0);
                    this.jaU.cKb();
                    TbadkCoreApplication.getInst().delLikeForum(this.jzc.getForumName());
                    return;
                }
                if (wVar.isLike() == 1) {
                    cBN.deleteLikeFeedForum(wVar.getFid());
                    this.jaU.j(cBN);
                    this.jAl.a(cBN, this.jaT.cIs());
                }
                if (cBN.getForum().getBannerListData() != null) {
                    cBN.getForum().getBannerListData().setFeedForumLiked(wVar.getFid(), wVar.isLike());
                }
                this.jaB.cCv();
            }
        }
    }
}
