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
    public final com.baidu.adp.base.d dSd;
    public final com.baidu.adp.base.d dSe;
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
        this.dSd = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dSe = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dSg.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dwS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l azS = this.dSg.azS();
            if (this.dAx != null && this.dAy != null && this.dAn != null && azS != null && azS.beT() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(azS.beT().getId())) {
                    azS.beT().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        azS.beT().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.byv() >= 0) {
                        azS.beT().setUser_level(rVar.byv());
                    }
                    if (z) {
                        this.dAy.a(azS, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dSg.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bzN().ab(this.dSg.getForumName(), false);
                    azS.beT().setLike(0);
                    this.dAy.aGd();
                    TbadkCoreApplication.getInst().delLikeForum(this.dSg.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    azS.uO(rVar.getFid());
                    this.dAy.h(azS);
                    this.dTd.a(azS, this.dAx.aFk());
                }
                if (azS.beT().getBannerListData() != null) {
                    azS.beT().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dAn.aAy();
            }
        }
    }
}
