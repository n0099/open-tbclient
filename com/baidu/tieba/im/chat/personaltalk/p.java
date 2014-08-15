package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.RequestQueryUserInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    final /* synthetic */ l a;
    private final /* synthetic */ long b;
    private final /* synthetic */ PersonalTalkSettingActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = lVar;
        this.b = j;
        this.c = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.a.e = personalSettingItemData.isAcceptNotify();
        }
        RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
        requestQueryUserInfoMessage.setReqUserId(this.b);
        this.c.sendMessage(requestQueryUserInfoMessage);
    }
}
