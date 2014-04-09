package com.baidu.tieba.im.c;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.x;
import com.baidu.tieba.im.m;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
final class g extends m<Void> {
    final /* synthetic */ f b;
    private final /* synthetic */ LinkedHashMap c;
    private final /* synthetic */ LinkedHashMap d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2) {
        this.b = fVar;
        this.c = linkedHashMap;
        this.d = linkedHashMap2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        if (this.c.size() > 0) {
            x.a();
            LinkedHashMap linkedHashMap = this.c;
            if (linkedHashMap != null && linkedHashMap.size() != 0) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    x.a((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                }
            }
        }
        return com.baidu.tieba.im.db.c.a().a(this.d);
    }
}
