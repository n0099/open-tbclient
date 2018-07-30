package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes2.dex */
public class b extends h {
    public final com.baidu.adp.base.d dDt;
    public final com.baidu.adp.base.d dDu;
    private final CustomMessageListener diZ;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.diZ = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dDt = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dDu = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dDw.refresh();
                }
            }
        };
        frsFragment.registerListener(this.diZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l auD = this.dDw.auD();
            if (this.dmB != null && this.dmC != null && this.dmq != null && auD != null && auD.aZl() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(auD.aZl().getId())) {
                    auD.aZl().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        auD.aZl().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bsA() >= 0) {
                        auD.aZl().setUser_level(rVar.bsA());
                    }
                    if (z) {
                        this.dmC.a(auD, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dDw.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.btR().T(this.dDw.getForumName(), false);
                    auD.aZl().setLike(0);
                    this.dmC.aAF();
                    TbadkCoreApplication.getInst().delLikeForum(this.dDw.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    auD.tB(rVar.getFid());
                    this.dmC.h(auD);
                    this.dEt.a(auD, this.dmB.azL());
                }
                if (auD.aZl().getBannerListData() != null) {
                    auD.aZl().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dmq.avk();
            }
        }
    }
}
