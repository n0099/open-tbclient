package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bEU = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        EnterForumModel enterForumModel;
        EnterForumModel enterForumModel2;
        EnterForumModel enterForumModel3;
        EnterForumModel enterForumModel4;
        EnterForumModel enterForumModel5;
        boolean z;
        EnterForumModel enterForumModel6;
        EnterForumModel enterForumModel7;
        EnterForumModel enterForumModel8;
        EnterForumModel enterForumModel9;
        EnterForumModel enterForumModel10;
        com.baidu.tbadk.data.e eVar = (com.baidu.tbadk.data.e) customResponsedMessage.getData();
        if (eVar != null) {
            enterForumModel = this.bEU.bEC;
            if (enterForumModel != null) {
                enterForumModel2 = this.bEU.bEC;
                if (enterForumModel2.Wk() != null) {
                    enterForumModel3 = this.bEU.bEC;
                    if (enterForumModel3.Wk().Vy() != null) {
                        enterForumModel4 = this.bEU.bEC;
                        if (enterForumModel4.Wk().Vy().VD() != null) {
                            enterForumModel5 = this.bEU.bEC;
                            int size = enterForumModel5.Wk().Vy().VD().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                enterForumModel8 = this.bEU.bEC;
                                if (enterForumModel8.Wk().Vy().VD().get(i) != null) {
                                    enterForumModel9 = this.bEU.bEC;
                                    if (enterForumModel9.Wk().Vy().VD().get(i).getForumId() == eVar.getForumId()) {
                                        enterForumModel10 = this.bEU.bEC;
                                        enterForumModel10.Wk().Vy().VD().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                enterForumModel7 = this.bEU.bEC;
                                enterForumModel7.Wk().Vy().VD().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.c.e eVar2 = this.bEU.bEB;
                            enterForumModel6 = this.bEU.bEC;
                            eVar2.b(enterForumModel6.Wk().Vy().VD(), this.bEU.bEA.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
