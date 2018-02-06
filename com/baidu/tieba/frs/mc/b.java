package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
/* loaded from: classes2.dex */
public class b extends h {
    private final CustomMessageListener dBz;
    public final com.baidu.adp.base.d dSS;
    public final com.baidu.adp.base.d dST;

    public b(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dBz = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                    b.this.b((r) customResponsedMessage.getData());
                }
            }
        };
        this.dSS = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dST = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dSV.refresh();
                }
            }
        };
        iVar.registerListener(this.dBz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(r rVar) {
        if (rVar != null) {
            l avl = this.dSV.avl();
            if (this.dEF != null && this.dEG != null && this.dEx != null && avl != null && avl.bas() != null && rVar.getFid() != null) {
                boolean z = rVar.isLike() == 1;
                if (rVar.getFid().equals(avl.bas().getId())) {
                    avl.bas().setLike(rVar.isLike());
                    if (!StringUtils.isNULL(rVar.getLevelName())) {
                        avl.bas().setLevelName(rVar.getLevelName());
                    }
                    if (rVar.btq() >= 0) {
                        avl.bas().setUser_level(rVar.btq());
                    }
                    if (z) {
                        this.dEG.a(avl, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dSV.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.buI().Z(this.dSV.getForumName(), false);
                    avl.bas().setLike(0);
                    this.dEG.aAn();
                    TbadkCoreApplication.getInst().delLikeForum(this.dSV.getForumName());
                    return;
                }
                if (rVar.isLike() == 1) {
                    avl.sC(rVar.getFid());
                    this.dEG.f(avl);
                    this.dTP.a(avl, this.dEF.azx());
                }
                if (avl.bas().getBannerListData() != null) {
                    avl.bas().getBannerListData().setFeedForumLiked(rVar.getFid(), rVar.isLike());
                }
                this.dEx.avN();
            }
        }
    }
}
