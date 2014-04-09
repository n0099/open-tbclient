package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.at;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    final /* synthetic */ k a;
    private final /* synthetic */ long b;
    private final /* synthetic */ PersonalTalkSettingActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(k kVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.a = kVar;
        this.b = j;
        this.c = personalTalkSettingActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(PersonalSettingItemData personalSettingItemData) {
        PersonalSettingItemData personalSettingItemData2 = personalSettingItemData;
        if (personalSettingItemData2 != null) {
            this.a.f = personalSettingItemData2.isAcceptNotify();
        }
        at atVar = new at();
        atVar.b(this.b);
        this.c.sendMessage(atVar);
    }
}
