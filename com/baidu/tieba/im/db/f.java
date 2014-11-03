package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String aE = null;
    private static volatile SQLiteDatabase aA = null;
    public static HashMap<String, SQLiteDatabase> aVr = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase MC() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (f.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = String.valueOf(TbadkApplication.getCurrentAccount()) + ".db";
                if (aVr.containsKey(str)) {
                    sQLiteDatabase = aVr.get(str);
                } else if (aA != null && str.equals(aE) && aA.isOpen()) {
                    sQLiteDatabase = aA;
                } else {
                    if (aA != null) {
                        com.baidu.adp.lib.util.p.g(aA);
                    }
                    e eVar = new e(TbadkApplication.m251getInst().getApp(), str);
                    aE = str;
                    aA = eVar.getWritableDatabase();
                    sQLiteDatabase = aA;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> MD() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase MC = MC();
        LinkedList<String> linkedList = new LinkedList<>();
        if (MC != null) {
            try {
                cursor2 = MC.rawQuery("select * from sqlite_master where type='table'", null);
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
                            com.baidu.adp.lib.util.p.a(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.adp.lib.util.p.a(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        com.baidu.adp.lib.util.p.a(cursor);
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
        com.baidu.adp.lib.util.p.a(cursor2);
        return linkedList;
    }

    public static void gb(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.ME().MF();
                Iterator<String> it = MD().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.ME().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.ME().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.ME().endTransaction();
        }
    }
}
