package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends CustomMessageListener {
    final /* synthetic */ k btA;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(k kVar, int i) {
        super(i);
        this.btA = kVar;
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
            cVar = this.btA.bth;
            if (cVar != null) {
                cVar2 = this.btA.bth;
                if (cVar2.Su() != null) {
                    cVar3 = this.btA.bth;
                    if (cVar3.Su().RI() != null) {
                        cVar4 = this.btA.bth;
                        if (cVar4.Su().RI().RN() != null) {
                            cVar5 = this.btA.bth;
                            int size = cVar5.Su().RI().RN().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                cVar8 = this.btA.bth;
                                if (cVar8.Su().RI().RN().get(i) != null) {
                                    cVar9 = this.btA.bth;
                                    if (cVar9.Su().RI().RN().get(i).getForumId() == eVar.getForumId()) {
                                        cVar10 = this.btA.bth;
                                        cVar10.Su().RI().RN().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                cVar7 = this.btA.bth;
                                cVar7.Su().RI().RN().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.view.e eVar2 = this.btA.btg;
                            cVar6 = this.btA.bth;
                            eVar2.b(cVar6.Su().RI().RN(), this.btA.btf.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
