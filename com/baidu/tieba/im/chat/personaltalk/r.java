package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    private final /* synthetic */ long aPi;
    final /* synthetic */ n aSM;
    private final /* synthetic */ PersonalTalkSettingActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSM = nVar;
        this.aPi = j;
        this.aSN = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.aSM.aSI = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aPi);
        this.aSN.sendMessage(requestQueryUserInfoMessage);
    }
}
