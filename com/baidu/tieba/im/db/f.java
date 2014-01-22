package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ int e;
    final /* synthetic */ d f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar, String str, String str2, String str3, int i) {
        this.f = dVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.e = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z = false;
        if (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c)) {
            return false;
        }
        String str = "tb_group_msg_" + this.a;
        try {
            SQLiteDatabase a = s.a();
            if (a == null) {
                z = false;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", this.c);
                contentValues.put("msg_status", Integer.valueOf(this.e));
                if (a.update(str, contentValues, "mid=?", new String[]{this.b}) > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            by.a(e, "GroupMsgDao.updateState", new Object[0]);
            e.printStackTrace();
            return z;
        }
    }
}
