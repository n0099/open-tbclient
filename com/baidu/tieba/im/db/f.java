package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String cq = null;
    private static volatile SQLiteDatabase cm = null;
    public static HashMap<String, SQLiteDatabase> aYe = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase MN() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = String.valueOf(TbadkCoreApplication.getCurrentAccount()) + ".db";
                if (aYe.containsKey(str)) {
                    sQLiteDatabase = aYe.get(str);
                } else if (cm != null && str.equals(cq) && cm.isOpen()) {
                    sQLiteDatabase = cm;
                } else {
                    if (cm != null) {
                        t.i(cm);
                    }
                    e eVar = new e(TbadkCoreApplication.m255getInst().getApp(), str);
                    cq = str;
                    cm = eVar.getWritableDatabase();
                    sQLiteDatabase = cm;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> MO() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase MN = MN();
        LinkedList<String> linkedList = new LinkedList<>();
        if (MN != null) {
            try {
                cursor2 = MN.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor2 != null) {
                    try {
                        cursor2.moveToFirst();
                        while (cursor2.moveToNext()) {
                            linkedList.add(cursor2.getString(cursor2.getColumnIndex("name")));
                        }
                    } catch (Exception e) {
                        cursor = cursor2;
                        exc = e;
                        try {
                            TiebaStatic.printDBExceptionLog(exc, "ImDatabaseManager.getAllTables", new Object[0]);
                            exc.printStackTrace();
                            t.b(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            t.b(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        t.b(cursor);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                cursor = null;
                exc = e2;
            } catch (Throwable th4) {
                cursor = null;
                th = th4;
            }
        }
        t.b(cursor2);
        return linkedList;
    }

    public static void gt(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.MP().MQ();
                Iterator<String> it = MO().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.MP().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.MP().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.MP().endTransaction();
        }
    }
}
