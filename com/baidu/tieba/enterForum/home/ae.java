package com.baidu.tieba.enterForum.home;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ l bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(l lVar, int i) {
        super(i);
        this.bHl = lVar;
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
            enterForumModel = this.bHl.bGT;
            if (enterForumModel != null) {
                enterForumModel2 = this.bHl.bGT;
                if (enterForumModel2.Xl() != null) {
                    enterForumModel3 = this.bHl.bGT;
                    if (enterForumModel3.Xl().Wz() != null) {
                        enterForumModel4 = this.bHl.bGT;
                        if (enterForumModel4.Xl().Wz().WE() != null) {
                            enterForumModel5 = this.bHl.bGT;
                            int size = enterForumModel5.Xl().Wz().WE().size();
                            int i = 0;
                            while (true) {
                                if (i >= size) {
                                    z = false;
                                    break;
                                }
                                enterForumModel8 = this.bHl.bGT;
                                if (enterForumModel8.Xl().Wz().WE().get(i) != null) {
                                    enterForumModel9 = this.bHl.bGT;
                                    if (enterForumModel9.Xl().Wz().WE().get(i).getForumId() == eVar.getForumId()) {
                                        enterForumModel10 = this.bHl.bGT;
                                        enterForumModel10.Xl().Wz().WE().remove(i);
                                        z = true;
                                        break;
                                    }
                                }
                                i++;
                            }
                            if (!z) {
                                enterForumModel7 = this.bHl.bGT;
                                enterForumModel7.Xl().Wz().WE().add(0, eVar);
                            }
                            com.baidu.tieba.enterForum.c.e eVar2 = this.bHl.bGS;
                            enterForumModel6 = this.bHl.bGT;
                            eVar2.b(enterForumModel6.Xl().Wz().WE(), this.bHl.bGR.getPageContext());
                        }
                    }
                }
            }
        }
    }
}
