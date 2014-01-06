package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends SingleRunnable<PersonalSettingItemData> {
    final /* synthetic */ long a;
    final /* synthetic */ k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, long j) {
        this.b = kVar;
        this.a = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public PersonalSettingItemData b() {
        return a.a(TiebaApplication.A(), String.valueOf(this.a));
    }
}
