package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes2.dex */
public class b extends h {
    private final CustomMessageListener dBn;
    public final com.baidu.adp.base.d dSG;
    public final com.baidu.adp.base.d dSH;

    public b(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dBn = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dSG = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dSH = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dSJ.refresh();
                }
            }
        };
        iVar.registerListener(this.dBn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l avk = this.dSJ.avk();
            if (this.dEt != null && this.dEu != null && this.dEl != null && avk != null && avk.bar() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(avk.bar().getId())) {
                    avk.bar().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        avk.bar().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.btp() >= 0) {
                        avk.bar().setUser_level(rVar.btp());
                    }
                    if (z) {
                        this.dEu.a(avk, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dSJ.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.buH().Y(this.dSJ.getForumName(), false);
                    avk.bar().setLike(0);
                    this.dEu.aAm();
                    TbadkCoreApplication.getInst().delLikeForum(this.dSJ.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    avk.sC(rVar.getFid());
                    this.dEu.f(avk);
                    this.dTD.a(avk, this.dEt.azw());
                }
                if (avk.bar().getBannerListData() != null) {
                    avk.bar().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dEl.avM();
            }
        }
    }
}
