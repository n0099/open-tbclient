package com.baidu.tieba.im.chat;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as extends com.baidu.tieba.im.b<LinkedHashMap<String, String>> {
    final /* synthetic */ w a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(w wVar, String str) {
        this.a = wVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public LinkedHashMap<String, String> a() {
        return com.baidu.tieba.im.db.c.a().a(this.b, 2, (String) null, 1000);
    }
}
