package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ ar b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ar arVar, String str) {
        this.b = arVar;
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
