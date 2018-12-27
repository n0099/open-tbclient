package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes6.dex */
public class b extends h {
    private final CustomMessageListener dHx;
    public final com.baidu.adp.base.d ecD;
    public final com.baidu.adp.base.d ecE;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.dHx = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.ecD = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.ecE = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.ecG.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dHx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l aBO = this.ecG.aBO();
            if (this.dLb != null && this.dLc != null && this.dKR != null && aBO != null && aBO.bgT() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(aBO.bgT().getId())) {
                    aBO.bgT().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        aBO.bgT().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bAA() >= 0) {
                        aBO.bgT().setUser_level(rVar.bAA());
                    }
                    if (z) {
                        this.dLc.a(aBO, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.ecG.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bBU().ad(this.ecG.getForumName(), false);
                    aBO.bgT().setLike(0);
                    this.dLc.aIa();
                    TbadkCoreApplication.getInst().delLikeForum(this.ecG.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    aBO.vw(rVar.getFid());
                    this.dLc.i(aBO);
                    this.edD.a(aBO, this.dLb.aHh());
                }
                if (aBO.bgT().getBannerListData() != null) {
                    aBO.bgT().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dKR.aCu();
            }
        }
    }
}
