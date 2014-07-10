package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    final /* synthetic */ k a;
    private final /* synthetic */ long b;
    private final /* synthetic */ PersonalTalkSettingActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = kVar;
        this.b = j;
        this.c = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.a.f = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.b);
        this.c.sendMessage(requestQueryUserInfoMessage);
    }
}
