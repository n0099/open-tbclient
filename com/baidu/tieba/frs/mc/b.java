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
    private final CustomMessageListener cUc;
    public final com.baidu.adp.base.d dmW;
    public final com.baidu.adp.base.d dmX;

    public b(FrsFragment frsFragment) {
        super(frsFragment);
        this.cUc = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dmW = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dmX = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void f(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dmZ.refresh();
                }
            }
        };
        frsFragment.registerListener(this.cUc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l apE = this.dmZ.apE();
            if (this.cXs != null && this.cXt != null && this.cXk != null && apE != null && apE.aVq() != null && rVar.getFid() != null) {
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
                        this.cXt.a(apE, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dmZ.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.bpQ().T(this.dmZ.getForumName(), false);
                    apE.aVq().setLike(0);
                    this.cXt.avk();
                    TbadkCoreApplication.getInst().delLikeForum(this.dmZ.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    apE.sK(rVar.getFid());
                    this.cXt.f(apE);
                    this.dnW.a(apE, this.cXs.aun());
                }
                if (apE.aVq().getBannerListData() != null) {
                    apE.aVq().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.cXk.aqk();
            }
        }
    }
}
