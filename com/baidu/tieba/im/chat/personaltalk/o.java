package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.b<PersonalSettingItemData> {
    final /* synthetic */ l a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, long j) {
        this.a = lVar;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public PersonalSettingItemData a() {
        return a.a().b(TbadkApplication.getCurrentAccount(), String.valueOf(this.b));
    }
}
