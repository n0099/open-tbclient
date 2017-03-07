package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bFb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bFb = lVar;
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
            enterForumModel = this.bFb.bEJ;
            if (enterForumModel != null) {
                enterForumModel2 = this.bFb.bEJ;
                if (enterForumModel2.VM() != null) {
                    enterForumModel3 = this.bFb.bEJ;
                    if (enterForumModel3.VM().Va() != null) {
                        enterForumModel4 = this.bFb.bEJ;
                        if (enterForumModel4.VM().Va().Vf() != null) {
                            enterForumModel5 = this.bFb.bEJ;
                            int size = enterForumModel5.VM().Va().Vf().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                enterForumModel8 = this.bFb.bEJ;
                                if (enterForumModel8.VM().Va().Vf().get(i) != null) {
                                    enterForumModel9 = this.bFb.bEJ;
                                    if (enterForumModel9.VM().Va().Vf().get(i).getForumId() == eVar.getForumId()) {
                                        enterForumModel10 = this.bFb.bEJ;
                                        enterForumModel10.VM().Va().Vf().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                enterForumModel7 = this.bFb.bEJ;
                                enterForumModel7.VM().Va().Vf().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.c.e eVar2 = this.bFb.bEI;
                            enterForumModel6 = this.bFb.bEJ;
                            eVar2.b(enterForumModel6.VM().Va().Vf(), this.bFb.bEH.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
