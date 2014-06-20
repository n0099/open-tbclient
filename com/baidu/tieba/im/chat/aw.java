package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.tieba.im.b<LinkedList<String>> {
    final /* synthetic */ w b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(w wVar, String str) {
        this.b = wVar;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public LinkedList<String> a() {
        return com.baidu.tieba.im.db.n.d().a(this.c, 2, (String) null, 1000);
    }
}
