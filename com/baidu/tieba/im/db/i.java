package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1671a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar, String str, String str2) {
        this.c = dVar;
        this.f1671a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (TextUtils.isEmpty(this.f1671a)) {
            return false;
        }
        SQLiteDatabase a2 = s.a();
        String str = d.f1666a + this.f1671a;
        if (a2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            a2.update(str, contentValues, "mid=?", new String[]{this.b});
            return true;
        }
        return false;
    }
}
