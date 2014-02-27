package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(int i) {
        this.a = i;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Void a() {
        if (TiebaApplication.z() != null) {
            com.baidu.tieba.im.db.q.a().a(this.a);
            return null;
        }
        return null;
    }
}
