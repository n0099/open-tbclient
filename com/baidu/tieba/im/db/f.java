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
    private static String nF = null;
    private static volatile SQLiteDatabase nB = null;
    public static HashMap<String, SQLiteDatabase> bUc = new HashMap<>();

    public static synchronized SQLiteDatabase aaV() {
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
                if (bUc.containsKey(str)) {
                    sQLiteDatabase = bUc.get(str);
                } else if (nB != null && str.equals(nF) && nB.isOpen()) {
                    sQLiteDatabase = nB;
                } else {
                    if (nB != null) {
                        com.baidu.adp.lib.util.o.h(nB);
                    }
                    e eVar = new e(TbadkCoreApplication.m411getInst().getApp(), str);
                    nF = str;
                    nB = eVar.getWritableDatabase();
                    sQLiteDatabase = nB;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> aaW() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase aaV = aaV();
        LinkedList<String> linkedList = new LinkedList<>();
        if (aaV != null) {
            try {
                cursor2 = aaV.rawQuery("select * from sqlite_master where type='table'", null);
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

    public static void iz(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.aaX().aaY();
                Iterator<String> it = aaW().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.aaX().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.aaX().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.aaX().endTransaction();
        }
    }
}
