package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(as asVar, String str) {
        this.b = asVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        try {
            this.b.a(Long.parseLong(this.a), true);
            return true;
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a(e.toString());
            return false;
        }
    }
}
