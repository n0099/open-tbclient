package com.baidu.tieba.im.chat.notify;
/* loaded from: classes.dex */
final class i extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.b = hVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.b("-1000", true);
        return null;
    }
}
