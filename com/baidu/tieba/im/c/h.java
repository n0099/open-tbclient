package com.baidu.tieba.im.c;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.ac;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ b b;
    private final /* synthetic */ LinkedHashMap c;
    private final /* synthetic */ LinkedHashMap d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        this.b = bVar;
        this.c = linkedHashMap;
        this.d = linkedHashMap2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c.size() > 0) {
            ac.a().a(this.c);
        }
        return com.baidu.tieba.im.db.c.a().a(this.d);
    }
}
