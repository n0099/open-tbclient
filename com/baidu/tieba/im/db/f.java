package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String dB = null;
    private static volatile SQLiteDatabase dx = null;
    public static HashMap<String, SQLiteDatabase> cfl = new HashMap<>();

    public static synchronized SQLiteDatabase aer() {
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
                if (cfl.containsKey(str)) {
                    sQLiteDatabase = cfl.get(str);
                } else if (dx != null && str.equals(dB) && dx.isOpen()) {
                    sQLiteDatabase = dx;
                } else {
                    if (dx != null) {
                        com.baidu.adp.lib.util.o.h(dx);
                    }
                    e eVar = new e(TbadkCoreApplication.m11getInst().getApp(), str);
                    dB = str;
                    dx = eVar.getWritableDatabase();
                    sQLiteDatabase = dx;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> aes() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase aer = aer();
        LinkedList<String> linkedList = new LinkedList<>();
        if (aer != null) {
            try {
                cursor2 = aer.rawQuery("select * from sqlite_master where type='table'", null);
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
                            com.baidu.adp.lib.util.o.a(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.util.o.a(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        com.baidu.adp.lib.util.o.a(cursor);
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
        com.baidu.adp.lib.util.o.a(cursor2);
        return linkedList;
    }

    public static void jk(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.aet().aeu();
                Iterator<String> it = aes().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.aet().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.aet().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.aet().endTransaction();
        }
    }
}
