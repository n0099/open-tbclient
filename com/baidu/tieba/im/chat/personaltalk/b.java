package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.gson.Gson;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ a a;
    private final /* synthetic */ PersonalSettingItemData b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.a = aVar;
        this.b = personalSettingItemData;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        this.a.c().a(this.c, new Gson().toJson(this.b));
        return null;
    }
}
