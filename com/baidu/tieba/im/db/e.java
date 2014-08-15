package com.baidu.tieba.im.db;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e extends SQLiteOpenHelper {
    public e(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 7);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
            b(sQLiteDatabase);
            a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid INTEGER NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.createTables", new Object[0]);
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL, group_name TEXT, group_head TEXT, custom_group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, send_status int, last_content TEXT, is_friend int, pull_msgid TEXT,is_hidden int,is_delete int);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @SuppressLint({"Override"})
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            TbadkApplication.m252getInst().getApp().deleteDatabase(String.valueOf(TbadkApplication.getCurrentAccount()) + ".db");
            a(sQLiteDatabase);
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.onDowngrade", new Object[0]);
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                try {
                    h(sQLiteDatabase);
                    c(sQLiteDatabase);
                    d(sQLiteDatabase);
                    e(sQLiteDatabase);
                    f(sQLiteDatabase);
                    i(sQLiteDatabase);
                    return;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.onUpgrade", new Object[0]);
                    TbadkApplication.m252getInst().getApp().deleteDatabase(String.valueOf(TbadkApplication.getCurrentAccount()) + ".db");
                    a(sQLiteDatabase);
                    return;
                }
            case 2:
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                e(sQLiteDatabase);
                f(sQLiteDatabase);
                i(sQLiteDatabase);
                return;
            case 3:
                d(sQLiteDatabase);
                e(sQLiteDatabase);
                f(sQLiteDatabase);
                i(sQLiteDatabase);
                return;
            case 4:
                e(sQLiteDatabase);
                f(sQLiteDatabase);
                i(sQLiteDatabase);
                return;
            case 5:
                f(sQLiteDatabase);
                i(sQLiteDatabase);
                return;
            case 6:
                i(sQLiteDatabase);
                return;
            default:
                return;
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            LinkedList<String> g = g(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && next.startsWith("tb_group_msg_")) {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD rid BIGINT;");
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD is_delete int default 0;");
                            sQLiteDatabase.execSQL("UPDATE " + next + " SET read_flag=0 WHERE read_flag is null");
                            sQLiteDatabase.execSQL("UPDATE " + next + " SET rid=mid WHERE rid is null");
                        } catch (Exception e) {
                            TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg2to3", new Object[0]);
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD custom_group_type int default 0;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg4to5", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid INTEGER NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
        if (sQLiteDatabase != null) {
            LinkedList<String> g = g(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && (next.startsWith(o.b) || next.startsWith(n.b))) {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD is_friend int default 1;");
                        } catch (Exception e) {
                            TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg5to6", new Object[0]);
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private LinkedList<String> g(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Throwable th;
        Exception exc;
        Cursor cursor2 = null;
        LinkedList<String> linkedList = new LinkedList<>();
        if (sQLiteDatabase != null) {
            try {
                cursor2 = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor2 != null) {
                    while (cursor2.moveToNext()) {
                        try {
                            linkedList.add(cursor2.getString(cursor2.getColumnIndex("name")));
                        } catch (Exception e) {
                            cursor = cursor2;
                            exc = e;
                            try {
                                TiebaStatic.printDBExceptionLog(exc, "ImDatabaseHelper.getAllTable", new Object[0]);
                                exc.printStackTrace();
                                com.baidu.adp.lib.util.m.a(cursor);
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                com.baidu.adp.lib.util.m.a(cursor);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            cursor = cursor2;
                            th = th3;
                            com.baidu.adp.lib.util.m.a(cursor);
                            throw th;
                        }
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
        com.baidu.adp.lib.util.m.a(cursor2);
        return linkedList;
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            LinkedList<String> g = g(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = g.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && next.startsWith("tb_group_msg_")) {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD read_flag int default 0;");
                        } catch (Exception e) {
                            TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg1to2", new Object[0]);
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center RENAME TO test_table_temp;");
                    b(sQLiteDatabase);
                    sQLiteDatabase.execSQL("INSERT INTO tb_message_center SELECT gid,group_name,group_head,custom_group_type,group_ext,unread_count,last_msgId,last_user_name,last_content_time,'send_status' as send_status,last_content,'is_friend' as is_friend,'pull_msgid' as pull_msgid,is_hidden,is_delete FROM test_table_temp;");
                    sQLiteDatabase.execSQL("DROP TABLE test_table_temp;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.messageCenter6to7", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                    a(sQLiteDatabase);
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.beginTransaction();
                    f.a.put(String.valueOf(TbadkApplication.getCurrentAccount()) + ".db", sQLiteDatabase);
                    l.a();
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    sQLiteDatabase.endTransaction();
                    f.a.remove(String.valueOf(TbadkApplication.getCurrentAccount()) + ".db");
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public static void a(SQLiteStatement sQLiteStatement, int i, String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindString(i, str);
        }
    }
}
