package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends CustomMessageListener {
    final /* synthetic */ k bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(k kVar, int i) {
        super(i);
        this.bvO = kVar;
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
            cVar = this.bvO.bvw;
            if (cVar != null) {
                cVar2 = this.bvO.bvw;
                if (cVar2.Tc() != null) {
                    cVar3 = this.bvO.bvw;
                    if (cVar3.Tc().Sp() != null) {
                        cVar4 = this.bvO.bvw;
                        if (cVar4.Tc().Sp().Su() != null) {
                            cVar5 = this.bvO.bvw;
                            int size = cVar5.Tc().Sp().Su().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                cVar8 = this.bvO.bvw;
                                if (cVar8.Tc().Sp().Su().get(i) != null) {
                                    cVar9 = this.bvO.bvw;
                                    if (cVar9.Tc().Sp().Su().get(i).getForumId() == eVar.getForumId()) {
                                        cVar10 = this.bvO.bvw;
                                        cVar10.Tc().Sp().Su().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                cVar7 = this.bvO.bvw;
                                cVar7.Tc().Sp().Su().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.view.e eVar2 = this.bvO.bvv;
                            cVar6 = this.bvO.bvw;
                            eVar2.b(cVar6.Tc().Sp().Su(), this.bvO.bvu.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
