package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1520a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int e;
    final /* synthetic */ a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str, String str2, String str3, int i) {
        this.f = aVar;
        this.f1520a = str;
        this.b = str2;
        this.c = str3;
        this.e = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z = false;
        if (TextUtils.isEmpty(this.f1520a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            return false;
        }
        String str = a.f1510a + this.f1520a;
        try {
            SQLiteDatabase a2 = m.a();
            if (a2 == null) {
                z = false;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", this.c);
                contentValues.put("msg_status", Integer.valueOf(this.e));
                if (a2.update(str, contentValues, "mid=?", new String[]{this.b}) > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }
}
