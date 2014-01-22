package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends SingleRunnable<PersonalSettingItemData> {
    final /* synthetic */ long a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j) {
        this.b = lVar;
        this.a = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public PersonalSettingItemData b() {
        return a.a(TiebaApplication.A(), String.valueOf(this.a));
    }
}
