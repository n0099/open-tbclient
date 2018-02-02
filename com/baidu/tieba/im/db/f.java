package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private static String abO = null;
    private static volatile SQLiteDatabase abK = null;
    public static HashMap<String, SQLiteDatabase> exn = new HashMap<>();

    public static synchronized SQLiteDatabase aGE() {
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
                if (exn.containsKey(str)) {
                    sQLiteDatabase = exn.get(str);
                } else if (abK != null && str.equals(abO) && abK.isOpen()) {
                    sQLiteDatabase = abK;
                } else {
                    if (abK != null) {
                        n.i(abK);
                    }
                    e eVar = new e(TbadkCoreApplication.getInst().getApp(), str);
                    abO = str;
                    abK = eVar.getWritableDatabase();
                    sQLiteDatabase = abK;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> aGF() {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        SQLiteDatabase aGE = aGE();
        LinkedList<String> linkedList = new LinkedList<>();
        if (aGE != null) {
            try {
                cursor2 = aGE.rawQuery("select * from sqlite_master where type='table'", null);
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
                            n.i(cursor);
                            return linkedList;
                        } catch (Throwable th2) {
                            th = th2;
                            n.i(cursor);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        cursor = cursor2;
                        th = th3;
                        n.i(cursor);
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
        n.i(cursor2);
        return linkedList;
    }

    public static void ne(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                g.aGG().aGH();
                Iterator<String> it = aGF().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            g.aGG().update("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            g.aGG().a(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            g.aGG().endTransaction();
        }
    }
}
