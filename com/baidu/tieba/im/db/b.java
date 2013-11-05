package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends SingleRunnable<LinkedList<String>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1519a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ int e;
    final /* synthetic */ a f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, int i, String str2, int i2) {
        this.f = aVar;
        this.f1519a = str;
        this.b = i;
        this.c = str2;
        this.e = i2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<String> b() {
        Cursor cursor = null;
        if (TextUtils.isEmpty(this.f1519a)) {
            return null;
        }
        int i = this.b;
        if (i <= 0) {
            i = 20;
        }
        LinkedList<String> linkedList = new LinkedList<>();
        String str = a.f1510a + this.f1519a;
        SQLiteDatabase a2 = m.a();
        try {
        } catch (SQLiteException e) {
            e.printStackTrace();
            this.f.d(this.f1519a);
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.tieba.util.g.a(cursor);
        }
        if (a2 == null) {
            return linkedList;
        }
        if (TextUtils.isEmpty(this.c)) {
            String str2 = "select * from " + str + " WHERE msg_type=? ORDER BY mid DESC LIMIT " + i;
            com.baidu.adp.lib.h.d.d("sql:" + str2);
            cursor = a2.rawQuery(str2, new String[]{String.valueOf(this.e)});
        } else {
            String str3 = "select * from " + str + " WHERE mid <=? AND msg_type=? ORDER BY mid DESC LIMIT " + i;
            com.baidu.adp.lib.h.d.d("sql:" + str3);
            cursor = a2.rawQuery(str3, new String[]{this.c, String.valueOf(this.e)});
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {
                linkedList.add(cursor.getString(cursor.getColumnIndex("content")));
            }
        }
        return linkedList;
    }
}
