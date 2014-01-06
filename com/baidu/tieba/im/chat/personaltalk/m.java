package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.am;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    final /* synthetic */ long a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(k kVar, long j) {
        this.b = kVar;
        this.a = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.b.f = personalSettingItemData.isAcceptNotify();
        }
        am amVar = new am();
        amVar.a(this.a);
        com.baidu.tieba.im.messageCenter.e.a().a(amVar);
    }
}
