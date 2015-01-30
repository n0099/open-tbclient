package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.PersonalMsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements com.baidu.tieba.im.g<com.baidu.tieba.im.data.b> {
    final /* synthetic */ PersonalChatActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(PersonalChatActivity personalChatActivity) {
        this.aSN = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    /* renamed from: a */
    public void onReturnDataInUI(com.baidu.tieba.im.data.b bVar) {
        PersonalMsglistModel personalMsglistModel;
        PersonalMsglistModel personalMsglistModel2;
        PersonalChatView personalChatView;
        PersonalChatView personalChatView2;
        personalMsglistModel = this.aSN.aSI;
        PersonalMsglistModel.CardStatus currentStatus = personalMsglistModel.getCurrentStatus(bVar);
        personalMsglistModel2 = this.aSN.aSI;
        personalMsglistModel2.setCardStatus(currentStatus);
        if (currentStatus != PersonalMsglistModel.CardStatus.AGREE) {
            personalChatView = this.aSN.aSJ;
            personalChatView.a(currentStatus, false, new String[0]);
            return;
        }
        String content = bVar.getContent();
        personalChatView2 = this.aSN.aSJ;
        personalChatView2.a(currentStatus, false, content);
    }
}
