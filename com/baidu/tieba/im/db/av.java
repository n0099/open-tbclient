package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends SingleRunnable<LinkedList<String>> {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ int e;
    final /* synthetic */ au f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar, String str, int i, String str2, int i2) {
        this.f = auVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.e = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<String> b() {
        Cursor cursor = null;
        if (TextUtils.isEmpty(this.a)) {
            return null;
        }
        int i = this.b;
        if (i <= 0) {
            i = 20;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        String str = "tb_private_msg_" + this.a;
        SQLiteDatabase a = s.a();
        try {
        } catch (SQLiteException e) {
            by.a(e, "PersonalMsgDao.getAllByMsgType" + this.e, new Object[0]);
            e.printStackTrace();
            this.f.d(this.a);
        } catch (Exception e2) {
            by.a(e2, "PersonalMsgDao.getAllByMsgType" + this.e, new Object[0]);
            e2.printStackTrace();
        } finally {
            com.baidu.tieba.util.p.a(cursor);
        }
        if (a == null) {
            return linkedList;
        }
        if (TextUtils.isEmpty(this.c)) {
            String str2 = "select * from " + str + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
            com.baidu.adp.lib.g.e.d("sql:" + str2);
            cursor = a.rawQuery(str2, new String[]{String.valueOf(this.e), String.valueOf(0)});
        } else {
            String str3 = "select * from " + str + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
            com.baidu.adp.lib.g.e.d("sql:" + str3);
            cursor = a.rawQuery(str3, new String[]{this.c, String.valueOf(this.e), String.valueOf(0)});
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {
                linkedList.add(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
            }
        }
        return linkedList;
    }
}
