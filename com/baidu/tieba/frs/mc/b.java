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
    private final CustomMessageListener dEJ;
    public final com.baidu.adp.base.d dZM;
    public final com.baidu.adp.base.d dZN;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.dEJ = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dZM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dZN = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dZP.refresh();
                }
            }
        };
        frsFragment.registerListener(this.dEJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l aAZ = this.dZP.aAZ();
            if (this.dIn != null && this.dIo != null && this.dId != null && aAZ != null && aAZ.bgi() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(aAZ.bgi().getId())) {
                    aAZ.bgi().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        aAZ.bgi().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.bzL() >= 0) {
                        aAZ.bgi().setUser_level(rVar.bzL());
                    }
                    if (z) {
                        this.dIo.a(aAZ, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dZP.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bBd().ad(this.dZP.getForumName(), false);
                    aAZ.bgi().setLike(0);
                    this.dIo.aHl();
                    TbadkCoreApplication.getInst().delLikeForum(this.dZP.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    aAZ.vt(rVar.getFid());
                    this.dIo.i(aAZ);
                    this.eaM.a(aAZ, this.dIn.aGs());
                }
                if (aAZ.bgi().getBannerListData() != null) {
                    aAZ.bgi().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dId.aBF();
            }
        }
    }
}
