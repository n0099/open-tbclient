package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str) {
        this.b = tVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (TextUtils.isEmpty(this.a)) {
            return false;
        }
        return Boolean.valueOf(this.b.a(this.a));
    }
}
