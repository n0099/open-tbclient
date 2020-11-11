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
    private final CustomMessageListener iDv;
    public final com.baidu.adp.base.d jcR;
    public final com.baidu.adp.base.d jcS;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.iDv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                    b.this.b((v) customResponsedMessage.getData());
                }
            }
        };
        this.jcR = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.jcS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void callback(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.jcU.refresh();
                }
            }
        };
        frsFragment.registerListener(this.iDv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v vVar) {
        if (vVar != null) {
            FrsViewData cyP = this.jcU.cyP();
            if (this.iHI != null && this.iHJ != null && this.iHp != null && cyP != null && cyP.getForum() != null && vVar.getFid() != null) {
                boolean z = vVar.isLike() == 1;
                if (vVar.getFid().equals(cyP.getForum().getId())) {
                    cyP.getForum().setLike(vVar.isLike());
                    if (!StringUtils.isNULL(vVar.getLevelName())) {
                        cyP.getForum().setLevelName(vVar.getLevelName());
                    }
                    if (vVar.dHo() >= 0) {
                        cyP.getForum().setUser_level(vVar.dHo());
                    }
                    if (z) {
                        this.iHJ.a(cyP, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.jcU.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.e.dIY().bc(this.jcU.getForumName(), false);
                    cyP.getForum().setLike(0);
                    this.iHJ.cFX();
                    TbadkCoreApplication.getInst().delLikeForum(this.jcU.getForumName());
                    return;
                }
                if (vVar.isLike() == 1) {
                    cyP.deleteLikeFeedForum(vVar.getFid());
                    this.iHJ.i(cyP);
                    this.jee.a(cyP, this.iHI.cEr());
                }
                if (cyP.getForum().getBannerListData() != null) {
                    cyP.getForum().getBannerListData().setFeedForumLiked(vVar.getFid(), vVar.isLike());
                }
                this.iHp.czx();
            }
        }
    }
}
