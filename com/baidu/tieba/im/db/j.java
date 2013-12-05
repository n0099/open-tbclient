package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1672a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar, String str, String str2) {
        this.c = dVar;
        this.f1672a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (TextUtils.isEmpty(this.f1672a)) {
            return false;
        }
        SQLiteDatabase a2 = s.a();
        String str = d.f1666a + this.f1672a;
        if (a2 != null) {
            a2.delete(str, "mid=?", new String[]{this.b});
            return true;
        }
        return false;
    }
}
