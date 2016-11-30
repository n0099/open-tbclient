package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bKe = lVar;
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
            cVar = this.bKe.bJN;
            if (cVar != null) {
                cVar2 = this.bKe.bJN;
                if (cVar2.Zi() != null) {
                    cVar3 = this.bKe.bJN;
                    if (cVar3.Zi().Yw() != null) {
                        cVar4 = this.bKe.bJN;
                        if (cVar4.Zi().Yw().YB() != null) {
                            cVar5 = this.bKe.bJN;
                            int size = cVar5.Zi().Yw().YB().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                cVar8 = this.bKe.bJN;
                                if (cVar8.Zi().Yw().YB().get(i) != null) {
                                    cVar9 = this.bKe.bJN;
                                    if (cVar9.Zi().Yw().YB().get(i).getForumId() == eVar.getForumId()) {
                                        cVar10 = this.bKe.bJN;
                                        cVar10.Zi().Yw().YB().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                cVar7 = this.bKe.bJN;
                                cVar7.Zi().Yw().YB().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.d.e eVar2 = this.bKe.bJM;
                            cVar6 = this.bKe.bJN;
                            eVar2.b(cVar6.Zi().Yw().YB(), this.bKe.bJL.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
