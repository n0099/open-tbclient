package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.im.message.ax;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements com.baidu.tieba.im.a<PersonalSettingItemData> {
    final /* synthetic */ l a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, long j) {
        this.a = lVar;
        this.b = j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(PersonalSettingItemData personalSettingItemData) {
        PersonalSettingItemData personalSettingItemData2 = personalSettingItemData;
        if (personalSettingItemData2 != null) {
            this.a.f = personalSettingItemData2.isAcceptNotify();
        }
        ax axVar = new ax();
        axVar.a(this.b);
        com.baidu.tieba.im.messageCenter.d.a().a(axVar);
    }
}
