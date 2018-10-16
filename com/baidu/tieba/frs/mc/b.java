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
    public final com.baidu.adp.base.d dSc;
    public final com.baidu.adp.base.d dSd;
    private final CustomMessageListener dwS;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.dwS = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dSc = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dSd = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dSf.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dwS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l azR = this.dSf.azR();
            if (this.dAx != null && this.dAy != null && this.dAn != null && azR != null && azR.beT() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(azR.beT().getId())) {
                    azR.beT().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        azR.beT().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.byv() >= 0) {
                        azR.beT().setUser_level(rVar.byv());
                    }
                    if (z) {
                        this.dAy.a(azR, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dSf.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bzN().ab(this.dSf.getForumName(), false);
                    azR.beT().setLike(0);
                    this.dAy.aGd();
                    TbadkCoreApplication.getInst().delLikeForum(this.dSf.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    azR.uO(rVar.getFid());
                    this.dAy.h(azR);
                    this.dTc.a(azR, this.dAx.aFk());
                }
                if (azR.beT().getBannerListData() != null) {
                    azR.beT().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dAn.aAx();
            }
        }
    }
}
