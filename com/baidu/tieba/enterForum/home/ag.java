package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends CustomMessageListener {
    final /* synthetic */ l bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(l lVar, int i) {
        super(i);
        this.bHc = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.enterForum.c.c cVar;
        com.baidu.tieba.enterForum.c.c cVar2;
        com.baidu.tieba.enterForum.c.c cVar3;
        com.baidu.tieba.enterForum.c.c cVar4;
        com.baidu.tieba.enterForum.c.c cVar5;
        boolean z;
        com.baidu.tieba.enterForum.c.c cVar6;
        com.baidu.tieba.enterForum.c.c cVar7;
        com.baidu.tieba.enterForum.c.c cVar8;
        com.baidu.tieba.enterForum.c.c cVar9;
        com.baidu.tieba.enterForum.c.c cVar10;
        com.baidu.tbadk.data.e eVar = (com.baidu.tbadk.data.e) customResponsedMessage.getData();
        if (eVar != null) {
            cVar = this.bHc.bGK;
            if (cVar != null) {
                cVar2 = this.bHc.bGK;
                if (cVar2.XN() != null) {
                    cVar3 = this.bHc.bGK;
                    if (cVar3.XN().Xb() != null) {
                        cVar4 = this.bHc.bGK;
                        if (cVar4.XN().Xb().Xg() != null) {
                            cVar5 = this.bHc.bGK;
                            int size = cVar5.XN().Xb().Xg().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                cVar8 = this.bHc.bGK;
                                if (cVar8.XN().Xb().Xg().get(i) != null) {
                                    cVar9 = this.bHc.bGK;
                                    if (cVar9.XN().Xb().Xg().get(i).getForumId() == eVar.getForumId()) {
                                        cVar10 = this.bHc.bGK;
                                        cVar10.XN().Xb().Xg().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                cVar7 = this.bHc.bGK;
                                cVar7.XN().Xb().Xg().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.e.e eVar2 = this.bHc.bGJ;
                            cVar6 = this.bHc.bGK;
                            eVar2.b(cVar6.XN().Xb().Xg(), this.bHc.bGI.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
