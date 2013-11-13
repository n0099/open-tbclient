package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1614a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, String str, String str2) {
        this.c = aVar;
        this.f1614a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (TextUtils.isEmpty(this.f1614a)) {
            return false;
        }
        SQLiteDatabase a2 = m.a();
        String str = a.f1601a + this.f1614a;
        if (a2 != null) {
            a2.delete(str, "mid=?", new String[]{this.b});
            return true;
        }
        return false;
    }
}
