package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bxV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bxV = lVar;
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
            enterForumModel = this.bxV.bxD;
            if (enterForumModel != null) {
                enterForumModel2 = this.bxV.bxD;
                if (enterForumModel2.UO() != null) {
                    enterForumModel3 = this.bxV.bxD;
                    if (enterForumModel3.UO().Uc() != null) {
                        enterForumModel4 = this.bxV.bxD;
                        if (enterForumModel4.UO().Uc().Uh() != null) {
                            enterForumModel5 = this.bxV.bxD;
                            int size = enterForumModel5.UO().Uc().Uh().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                enterForumModel8 = this.bxV.bxD;
                                if (enterForumModel8.UO().Uc().Uh().get(i) != null) {
                                    enterForumModel9 = this.bxV.bxD;
                                    if (enterForumModel9.UO().Uc().Uh().get(i).getForumId() == eVar.getForumId()) {
                                        enterForumModel10 = this.bxV.bxD;
                                        enterForumModel10.UO().Uc().Uh().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                enterForumModel7 = this.bxV.bxD;
                                enterForumModel7.UO().Uc().Uh().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.c.e eVar2 = this.bxV.bxC;
                            enterForumModel6 = this.bxV.bxD;
                            eVar2.b(enterForumModel6.UO().Uc().Uh(), this.bxV.bxB.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
