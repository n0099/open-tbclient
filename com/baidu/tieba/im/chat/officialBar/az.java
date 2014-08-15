package com.baidu.tieba.im.chat.officialBar;

import com.baidu.gson.Gson;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ay a;
    private final /* synthetic */ OfficialSettingItemData b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(ay ayVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.a = ayVar;
        this.b = officialSettingItemData;
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
