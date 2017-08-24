package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String pv = null;
    private static volatile SQLiteDatabase pq = null;
    public static HashMap<String, SQLiteDatabase> doK = new HashMap<>();

    public static synchronized SQLiteDatabase auv() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (doK.containsKey(str)) {
                    sQLiteDatabase = doK.get(str);
                } else if (pq != null && str.equals(pv) && pq.isOpen()) {
                    sQLiteDatabase = pq;
                } else {
                    if (pq != null) {
                        m.i(pq);
                    }
                    e eVar = new e(TbadkCoreApplication.getInst().getApp(), str);
                    pv = str;
                    pq = eVar.getWritableDatabase();
                    sQLiteDatabase = pq;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> auw() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase auv = auv();
        LinkedList<String> linkedList = new LinkedList<>();
        if (auv != null) {
            try {
                cursor2 = auv.rawQuery("select * from sqlite_master where type='table'", null);
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
                            m.e(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            m.e(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        m.e(cursor);
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
        m.e(cursor2);
        return linkedList;
    }

    public static void mh(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.aux().auy();
                Iterator<String> it = auw().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.aux().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.aux().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.aux().endTransaction();
        }
    }
}
