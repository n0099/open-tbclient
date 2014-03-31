package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.person.PersonInfoActivity;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ImDatabaseManager {
    private static String databaseName = null;
    private static volatile SQLiteDatabase database = null;

    private ImDatabaseManager() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized SQLiteDatabase getImDataBase() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (ImDatabaseManager.class) {
            try {
            } catch (Exception e) {
                TiebaStatic.a(e, "ImDatabaseHelper.getImDataBase", new Object[0]);
                com.baidu.adp.lib.util.f.b("ImDatabaseHelper", "ImDatabaseHelper", "error = " + e.getMessage());
            }
            if (TextUtils.isEmpty(TbadkApplication.E())) {
                com.baidu.adp.lib.util.f.b("没有登录");
                sQLiteDatabase = null;
            } else {
                String str = String.valueOf(TbadkApplication.E()) + ".db";
                if (database != null && str.equals(databaseName) && database.isOpen()) {
                    sQLiteDatabase = database;
                } else {
                    if (database != null) {
                        com.baidu.tbadk.core.util.l.a(database);
                        com.baidu.adp.lib.util.f.c("读取数据文件错误或者没有打开或者要切换数据库，关闭当前数据库，重新开启。cur data：" + databaseName + " should data:" + str);
                    }
                    f fVar = new f(TbadkApplication.j().b(), str);
                    databaseName = str;
                    database = fVar.getWritableDatabase();
                    sQLiteDatabase = database;
                }
            }
        }
        return sQLiteDatabase;
    }

    public static LinkedList<String> getAllTables() {
        Cursor cursor = null;
        SQLiteDatabase imDataBase = getImDataBase();
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            if (imDataBase != null) {
                cursor = imDataBase.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex(PersonInfoActivity.TAG_NAME)));
                    }
                }
            }
            com.baidu.adp.lib.util.f.e("haveTables:" + linkedList);
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseManager.getAllTables", new Object[0]);
            e.printStackTrace();
        } finally {
            com.baidu.tbadk.core.util.l.a(cursor);
        }
        return linkedList;
    }

    public static void deleteImDb(String str) {
        SQLiteDatabase imDataBase;
        try {
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> it = getAllTables().iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (next != null) {
                        if (next.startsWith(n.b)) {
                            String charSequence = next.subSequence(n.b.length(), next.length()).toString();
                            com.baidu.adp.lib.util.f.e("see table id:" + charSequence + "name:" + next);
                            n.d().a(com.baidu.adp.lib.f.b.a(charSequence, 0L), true);
                        } else if (next.startsWith("tb_group_msg_")) {
                            SQLiteDatabase imDataBase2 = getImDataBase();
                            if (imDataBase2 != null) {
                                com.baidu.adp.lib.util.f.e("DROP TABLE IF EXISTS " + next);
                                imDataBase2.execSQL("DROP TABLE IF EXISTS " + next);
                            }
                        } else if (!next.startsWith("tb_personal_id") && (imDataBase = getImDataBase()) != null) {
                            com.baidu.adp.lib.util.f.e("CLEAR TABLE:" + next);
                            imDataBase.delete(next, null, null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseManager.deleteImDb", new Object[0]);
            e.printStackTrace();
        }
    }
}
