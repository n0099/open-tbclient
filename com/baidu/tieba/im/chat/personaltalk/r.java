package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    private final /* synthetic */ long aOU;
    final /* synthetic */ n aSy;
    private final /* synthetic */ PersonalTalkSettingActivity aSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(n nVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSy = nVar;
        this.aOU = j;
        this.aSz = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    /* renamed from: a */
    public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.aSy.aSu = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.aOU);
        this.aSz.sendMessage(requestQueryUserInfoMessage);
    }
}
