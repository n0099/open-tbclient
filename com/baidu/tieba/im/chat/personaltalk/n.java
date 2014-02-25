package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    final /* synthetic */ l a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, long j) {
        this.a = lVar;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData != null) {
            this.a.f = personalSettingItemData.isAcceptNotify();
        }
        ax axVar = new ax();
        axVar.a(this.b);
        com.baidu.tieba.im.messageCenter.e.a().a(axVar);
    }
}
