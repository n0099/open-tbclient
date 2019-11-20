package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.t;
/* loaded from: classes4.dex */
public class b extends j {
    public final com.baidu.adp.base.d fNe;
    public final com.baidu.adp.base.d fNf;
    private final CustomMessageListener fqY;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.fqY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof t)) {
                    b.this.b((t) customResponsedMessage.getData());
                }
            }
        };
        this.fNe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.fNf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.fNh.refresh();
                }
            }
        };
        frsFragment.registerListener(this.fqY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar) {
        if (tVar != null) {
            FrsViewData bkn = this.fNh.bkn();
            if (this.fuO != null && this.fuP != null && this.fux != null && bkn != null && bkn.getForum() != null && tVar.getFid() != null) {
                boolean z = tVar.isLike() == 1;
                if (tVar.getFid().equals(bkn.getForum().getId())) {
                    bkn.getForum().setLike(tVar.isLike());
                    if (!StringUtils.isNULL(tVar.getLevelName())) {
                        bkn.getForum().setLevelName(tVar.getLevelName());
                    }
                    if (tVar.clO() >= 0) {
                        bkn.getForum().setUser_level(tVar.clO());
                    }
                    if (z) {
                        this.fuP.a(bkn, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.fNh.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.d.cnj().av(this.fNh.getForumName(), false);
                    bkn.getForum().setLike(0);
                    this.fuP.bqC();
                    TbadkCoreApplication.getInst().delLikeForum(this.fNh.getForumName());
                    return;
                }
                if (tVar.isLike() == 1) {
                    bkn.deleteLikeFeedForum(tVar.getFid());
                    this.fuP.i(bkn);
                    this.fOr.a(bkn, this.fuO.bpn());
                }
                if (bkn.getForum().getBannerListData() != null) {
                    bkn.getForum().getBannerListData().setFeedForumLiked(tVar.getFid(), tVar.isLike());
                }
                this.fux.bkQ();
            }
        }
    }
}
