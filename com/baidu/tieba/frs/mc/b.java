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
    private final CustomMessageListener cTZ;
    public final com.baidu.adp.base.d dmT;
    public final com.baidu.adp.base.d dmU;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.cTZ = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dmT = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dmU = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dmW.refresh();
                }
            }
        };
        frsFragment.registerListener(this.cTZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l apE = this.dmW.apE();
            if (this.cXp != null && this.cXq != null && this.cXh != null && apE != null && apE.aVq() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(apE.aVq().getId())) {
                    apE.aVq().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        apE.aVq().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.boz() >= 0) {
                        apE.aVq().setUser_level(rVar.boz());
                    }
                    if (z) {
                        this.cXq.a(apE, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dmW.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bpQ().T(this.dmW.getForumName(), false);
                    apE.aVq().setLike(0);
                    this.cXq.avk();
                    TbadkCoreApplication.getInst().delLikeForum(this.dmW.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    apE.sK(rVar.getFid());
                    this.cXq.f(apE);
                    this.dnT.a(apE, this.cXp.aun());
                }
                if (apE.aVq().getBannerListData() != null) {
                    apE.aVq().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.cXh.aqk();
            }
        }
    }
}
