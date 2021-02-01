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
public class g {
    private static String databaseName = null;
    private static volatile SQLiteDatabase database = null;
    public static HashMap<String, SQLiteDatabase> kER = new HashMap<>();

    public static synchronized SQLiteDatabase cVx() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (g.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
            }
            if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                sQLiteDatabase = null;
            } else {
                String str = TbadkCoreApplication.getCurrentAccount() + ".db";
                if (kER.containsKey(str)) {
                    sQLiteDatabase = kER.get(str);
                } else if (database != null && str.equals(databaseName) && database.isOpen()) {
                    sQLiteDatabase = database;
                } else {
                    if (database != null) {
                        com.baidu.adp.lib.util.n.close(database);
                    }
                    f fVar = new f(TbadkCoreApplication.getInst().getApp(), str);
                    databaseName = str;
                    database = fVar.getWritableDatabase();
                    sQLiteDatabase = database;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> cVy() {
        Cursor cursor = null;
        SQLiteDatabase cVx = cVx();
        LinkedList<String> linkedList = new LinkedList<>();
        if (cVx != null) {
            try {
                cursor = cVx.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.getAllTables", new Object[0]);
                e.printStackTrace();
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
        return linkedList;
    }

    public static void MP(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                h.cVz().cVA();
                Iterator<String> it = cVy().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.equals("tb_message_center")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("is_hidden", (Integer) 1);
                            h.cVz().b("tb_message_center", contentValues, null, null);
                        } else if (!next.equals("tb_new_friends")) {
                            h.cVz().b(next, (String) null, (String[]) null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        } finally {
            h.cVz().cVB();
        }
    }
}
