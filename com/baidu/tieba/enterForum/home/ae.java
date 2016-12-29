package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bqi = lVar;
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
            cVar = this.bqi.bpR;
            if (cVar != null) {
                cVar2 = this.bqi.bpR;
                if (cVar2.Tv() != null) {
                    cVar3 = this.bqi.bpR;
                    if (cVar3.Tv().SH() != null) {
                        cVar4 = this.bqi.bpR;
                        if (cVar4.Tv().SH().SM() != null) {
                            cVar5 = this.bqi.bpR;
                            int size = cVar5.Tv().SH().SM().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                cVar8 = this.bqi.bpR;
                                if (cVar8.Tv().SH().SM().get(i) != null) {
                                    cVar9 = this.bqi.bpR;
                                    if (cVar9.Tv().SH().SM().get(i).getForumId() == eVar.getForumId()) {
                                        cVar10 = this.bqi.bpR;
                                        cVar10.Tv().SH().SM().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                cVar7 = this.bqi.bpR;
                                cVar7.Tv().SH().SM().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.d.e eVar2 = this.bqi.bpQ;
                            cVar6 = this.bqi.bpR;
                            eVar2.b(cVar6.Tv().SH().SM(), this.bqi.bpP.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
