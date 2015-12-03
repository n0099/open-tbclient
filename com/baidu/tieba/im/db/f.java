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
    private static String nD = null;
    private static volatile SQLiteDatabase nz = null;
    public static HashMap<String, SQLiteDatabase> bMu = new HashMap<>();

    public static synchronized SQLiteDatabase Xe() {
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
                if (bMu.containsKey(str)) {
                    sQLiteDatabase = bMu.get(str);
                } else if (nz != null && str.equals(nD) && nz.isOpen()) {
                    sQLiteDatabase = nz;
                } else {
                    if (nz != null) {
                        com.baidu.adp.lib.util.o.h(nz);
                    }
                    e eVar = new e(TbadkCoreApplication.m411getInst().getApp(), str);
                    nD = str;
                    nz = eVar.getWritableDatabase();
                    sQLiteDatabase = nz;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> Xf() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase Xe = Xe();
        LinkedList<String> linkedList = new LinkedList<>();
        if (Xe != null) {
            try {
                cursor2 = Xe.rawQuery("select * from sqlite_master where type='table'", null);
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
                            com.baidu.adp.lib.util.o.b(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.util.o.b(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        com.baidu.adp.lib.util.o.b(cursor);
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
        com.baidu.adp.lib.util.o.b(cursor2);
        return linkedList;
    }

    public static void il(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.Xg().Xh();
                Iterator<String> it = Xf().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.Xg().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.Xg().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.Xg().endTransaction();
        }
    }
}
