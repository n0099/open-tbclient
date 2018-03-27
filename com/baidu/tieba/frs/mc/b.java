package com.baidu.tieba.frs.mc;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.m;
import com.baidu.tieba.tbadkCore.s;
/* loaded from: classes2.dex */
public class b extends h {
    private final CustomMessageListener dBq;
    public final com.baidu.adp.base.d dSL;
    public final com.baidu.adp.base.d dSM;

    public b(com.baidu.tieba.frs.i iVar) {
        super(iVar);
        this.dBq = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.frs.mc.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof s)) {
                    b.this.b((s) customResponsedMessage.getData());
                }
            }
        };
        this.dSL = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.2
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                if (obj instanceof Boolean) {
                    ((Boolean) obj).booleanValue();
                }
            }
        };
        this.dSM = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.mc.b.3
            @Override // com.baidu.adp.base.d
            public void ak(Object obj) {
                boolean z = false;
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
                if (!z) {
                    b.this.dSO.refresh();
                }
            }
        };
        iVar.registerListener(this.dBq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s sVar) {
        if (sVar != null) {
            m avl = this.dSO.avl();
            if (this.dEw != null && this.dEx != null && this.dEo != null && avl != null && avl.bas() != null && sVar.getFid() != null) {
                boolean z = sVar.isLike() == 1;
                if (sVar.getFid().equals(avl.bas().getId())) {
                    avl.bas().setLike(sVar.isLike());
                    if (!StringUtils.isNULL(sVar.getLevelName())) {
                        avl.bas().setLevelName(sVar.getLevelName());
                    }
                    if (sVar.btq() >= 0) {
                        avl.bas().setUser_level(sVar.btq());
                    }
                    if (z) {
                        this.dEx.a(avl, false);
                        TbadkCoreApplication.getInst().addLikeForum(this.dSO.getForumName());
                        return;
                    }
                    com.baidu.tieba.tbadkCore.c.buI().Y(this.dSO.getForumName(), false);
                    avl.bas().setLike(0);
                    this.dEx.aAo();
                    TbadkCoreApplication.getInst().delLikeForum(this.dSO.getForumName());
                    return;
                }
                if (sVar.isLike() == 1) {
                    avl.sC(sVar.getFid());
                    this.dEx.f(avl);
                    this.dTI.a(avl, this.dEw.azy());
                }
                if (avl.bas().getBannerListData() != null) {
                    avl.bas().getBannerListData().setFeedForumLiked(sVar.getFid(), sVar.isLike());
                }
                this.dEo.avO();
            }
        }
    }
}
