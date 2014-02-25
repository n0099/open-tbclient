package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.c<PersonalSettingItemData> {
    final /* synthetic */ l a;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j) {
        this.a = lVar;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public PersonalSettingItemData b() {
        return a.a(TiebaApplication.A(), String.valueOf(this.c));
    }
}
