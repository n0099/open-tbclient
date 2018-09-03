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
    public final com.baidu.adp.base.d dDq;
    public final com.baidu.adp.base.d dDr;
    private final CustomMessageListener diX;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.diX = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dDq = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dDr = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void i(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dDt.refresh();
                }
            }
        };
        frsFragment.registerListener(this.diX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l auC = this.dDt.auC();
            if (this.dmz != null && this.dmA != null && this.dmo != null && auC != null && auC.aZg() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(auC.aZg().getId())) {
                    auC.aZg().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        auC.aZg().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bsB() >= 0) {
                        auC.aZg().setUser_level(rVar.bsB());
                    }
                    if (z) {
                        this.dmA.a(auC, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dDt.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.btS().T(this.dDt.getForumName(), false);
                    auC.aZg().setLike(0);
                    this.dmA.aAC();
                    TbadkCoreApplication.getInst().delLikeForum(this.dDt.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    auC.tF(rVar.getFid());
                    this.dmA.h(auC);
                    this.dEq.a(auC, this.dmz.azI());
                }
                if (auC.aZg().getBannerListData() != null) {
                    auC.aZg().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dmo.avj();
            }
        }
    }
}
