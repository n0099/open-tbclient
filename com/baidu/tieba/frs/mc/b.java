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
    private final CustomMessageListener dIg;
    public final com.baidu.adp.base.d edj;
    public final com.baidu.adp.base.d edk;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.dIg = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.edj = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.edk = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.edm.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dIg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l aCl = this.edm.aCl();
            if (this.dLK != null && this.dLL != null && this.dLA != null && aCl != null && aCl.bhx() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(aCl.bhx().getId())) {
                    aCl.bhx().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        aCl.bhx().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bBj() >= 0) {
                        aCl.bhx().setUser_level(rVar.bBj());
                    }
                    if (z) {
                        this.dLL.a(aCl, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.edm.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bCD().ac(this.edm.getForumName(), false);
                    aCl.bhx().setLike(0);
                    this.dLL.aIx();
                    TbadkCoreApplication.getInst().delLikeForum(this.edm.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    aCl.vM(rVar.getFid());
                    this.dLL.i(aCl);
                    this.eej.a(aCl, this.dLK.aHE());
                }
                if (aCl.bhx().getBannerListData() != null) {
                    aCl.bhx().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dLA.aCR();
            }
        }
    }
}
