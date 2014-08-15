package com.baidu.tieba.im.groupInfo;

import com.baidu.gson.Gson;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ y a;
    private final /* synthetic */ GroupSettingItemData b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, GroupSettingItemData groupSettingItemData, String str) {
        this.a = yVar;
        this.b = groupSettingItemData;
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
