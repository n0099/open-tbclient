package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.w;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String nD = null;
    private static volatile SQLiteDatabase nz = null;
    public static HashMap<String, SQLiteDatabase> bfh = new HashMap<>();

    public static synchronized SQLiteDatabase Rp() {
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
                if (bfh.containsKey(str)) {
                    sQLiteDatabase = bfh.get(str);
                } else if (nz != null && str.equals(nD) && nz.isOpen()) {
                    sQLiteDatabase = nz;
                } else {
                    if (nz != null) {
                        w.i(nz);
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

    public static LinkedList<String> Rq() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase Rp = Rp();
        LinkedList<String> linkedList = new LinkedList<>();
        if (Rp != null) {
            try {
                cursor2 = Rp.rawQuery("select * from sqlite_master where type='table'", null);
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
                            w.b(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            w.b(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        w.b(cursor);
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
        w.b(cursor2);
        return linkedList;
    }

    public static void hc(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.Rr().Rs();
                Iterator<String> it = Rq().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.Rr().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.Rr().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.Rr().endTransaction();
        }
    }
}
