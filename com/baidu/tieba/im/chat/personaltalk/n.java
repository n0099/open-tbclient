package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.b<PersonalSettingItemData> {
    final /* synthetic */ k b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar, long j) {
        this.b = kVar;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public PersonalSettingItemData a() {
        return a.a().b(TbadkApplication.getCurrentAccount(), String.valueOf(this.c));
    }
}
