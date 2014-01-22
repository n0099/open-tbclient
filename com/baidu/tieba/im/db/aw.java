package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends SingleRunnable<Boolean> {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ String c;
    final /* synthetic */ int e;
    final /* synthetic */ String f;
    final /* synthetic */ au g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar, long j, long j2, String str, int i, String str2) {
        this.g = auVar;
        this.a = j;
        this.b = j2;
        this.c = str;
        this.e = i;
        this.f = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z;
        if (this.a == 0 || this.b == 0 || TiebaApplication.A() == null) {
            return false;
        }
        String valueOf = String.valueOf(this.a);
        if (TiebaApplication.A().equals(valueOf)) {
            valueOf = String.valueOf(this.b);
        }
        String str = "tb_private_msg_" + valueOf;
        try {
            SQLiteDatabase a = s.a();
            if (a == null) {
                z = false;
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", this.c);
                contentValues.put("msg_status", Integer.valueOf(this.e));
                if (a.update(str, contentValues, "mid=?", new String[]{this.f}) > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            by.a(e, "PersonalMsgDao.updateState", new Object[0]);
            e.printStackTrace();
            return false;
        }
    }
}
