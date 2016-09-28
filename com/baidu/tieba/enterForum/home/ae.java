package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bHk = lVar;
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
            cVar = this.bHk.bGT;
            if (cVar != null) {
                cVar2 = this.bHk.bGT;
                if (cVar2.Yg() != null) {
                    cVar3 = this.bHk.bGT;
                    if (cVar3.Yg().Xu() != null) {
                        cVar4 = this.bHk.bGT;
                        if (cVar4.Yg().Xu().Xz() != null) {
                            cVar5 = this.bHk.bGT;
                            int size = cVar5.Yg().Xu().Xz().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                cVar8 = this.bHk.bGT;
                                if (cVar8.Yg().Xu().Xz().get(i) != null) {
                                    cVar9 = this.bHk.bGT;
                                    if (cVar9.Yg().Xu().Xz().get(i).getForumId() == eVar.getForumId()) {
                                        cVar10 = this.bHk.bGT;
                                        cVar10.Yg().Xu().Xz().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                cVar7 = this.bHk.bGT;
                                cVar7.Yg().Xu().Xz().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.d.e eVar2 = this.bHk.bGS;
                            cVar6 = this.bHk.bGT;
                            eVar2.b(cVar6.Yg().Xu().Xz(), this.bHk.bGR.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
