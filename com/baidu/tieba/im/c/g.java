package com.baidu.tieba.im.c;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.ab;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ f b;
    private final /* synthetic */ LinkedHashMap c;
    private final /* synthetic */ LinkedHashMap d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        this.b = fVar;
        this.c = linkedHashMap;
        this.d = linkedHashMap2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c.size() > 0) {
            ab.a().a(this.c);
        }
        return com.baidu.tieba.im.db.c.a().a(this.d);
    }
}
