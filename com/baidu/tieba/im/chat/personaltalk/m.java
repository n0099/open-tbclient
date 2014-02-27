package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends com.baidu.tieba.im.b<PersonalSettingItemData> {
    final /* synthetic */ l a;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, long j) {
        this.a = lVar;
        this.c = j;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ PersonalSettingItemData a() {
        return a.a(TiebaApplication.v(), String.valueOf(this.c));
    }
}
