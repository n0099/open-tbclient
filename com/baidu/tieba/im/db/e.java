package com.baidu.tieba.im.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class e extends SQLiteOpenHelper {
    public e(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 11);
    }

    private void e(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL(str);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        s(sQLiteDatabase);
    }

    private void s(SQLiteDatabase sQLiteDatabase) {
        try {
            e(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
            t(sQLiteDatabase);
            u(sQLiteDatabase);
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.createTables", new Object[0]);
        }
    }

    private void t(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            e(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL, group_name TEXT, group_head TEXT, custom_group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, send_status int, last_content TEXT, is_friend int, pull_msgid TEXT,is_hidden int,is_delete int, sent_mid long, read_mid long, sid long, task_id TEXT, ext1 TEXT, ext2 TEXT, user_type int default 1);");
        }
    }

    private void u(SQLiteDatabase sQLiteDatabase) {
        e(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid LONG NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
    }

    private void v(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            e(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL, group_name TEXT, group_head TEXT, custom_group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, send_status int, last_content TEXT, is_friend int, pull_msgid TEXT,is_hidden int,is_delete int);");
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            TbadkCoreApplication.m9getInst().getApp().deleteDatabase(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + ".db");
            s(sQLiteDatabase);
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
                    B(sQLiteDatabase);
                    w(sQLiteDatabase);
                    x(sQLiteDatabase);
                    y(sQLiteDatabase);
                    z(sQLiteDatabase);
                    C(sQLiteDatabase);
                    D(sQLiteDatabase);
                    E(sQLiteDatabase);
                    F(sQLiteDatabase);
                    G(sQLiteDatabase);
                    return;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.onUpgrade", new Object[0]);
                    TbadkCoreApplication.m9getInst().getApp().deleteDatabase(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + ".db");
                    s(sQLiteDatabase);
                    return;
                }
            case 2:
                w(sQLiteDatabase);
                x(sQLiteDatabase);
                y(sQLiteDatabase);
                z(sQLiteDatabase);
                C(sQLiteDatabase);
                D(sQLiteDatabase);
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 3:
                x(sQLiteDatabase);
                y(sQLiteDatabase);
                z(sQLiteDatabase);
                C(sQLiteDatabase);
                D(sQLiteDatabase);
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 4:
                y(sQLiteDatabase);
                z(sQLiteDatabase);
                C(sQLiteDatabase);
                D(sQLiteDatabase);
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 5:
                z(sQLiteDatabase);
                C(sQLiteDatabase);
                D(sQLiteDatabase);
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 6:
                C(sQLiteDatabase);
                D(sQLiteDatabase);
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 7:
                D(sQLiteDatabase);
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 8:
                E(sQLiteDatabase);
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 9:
                F(sQLiteDatabase);
                G(sQLiteDatabase);
                return;
            case 10:
                G(sQLiteDatabase);
                return;
            default:
                return;
        }
    }

    private void w(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            LinkedList<String> A = A(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = A.iterator();
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

    private void x(SQLiteDatabase sQLiteDatabase) {
    }

    private void y(SQLiteDatabase sQLiteDatabase) {
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

    private void z(SQLiteDatabase sQLiteDatabase) {
        e(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid INTEGER NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
        if (sQLiteDatabase != null) {
            LinkedList<String> A = A(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = A.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && (next.startsWith(l.cYU) || next.startsWith(k.cYU))) {
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

    private LinkedList<String> A(SQLiteDatabase sQLiteDatabase) {
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

    private void B(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            LinkedList<String> A = A(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = A.iterator();
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

    private void C(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center RENAME TO test_table_temp;");
                    v(sQLiteDatabase);
                    sQLiteDatabase.execSQL("INSERT INTO tb_message_center SELECT gid,group_name,group_head,custom_group_type,group_ext,unread_count,last_msgId,last_user_name,last_content_time,'send_status' as send_status,last_content,'is_friend' as is_friend,'pull_msgid' as pull_msgid,is_hidden,is_delete FROM test_table_temp;");
                    sQLiteDatabase.execSQL("DROP TABLE test_table_temp;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.messageCenter6to7", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                    s(sQLiteDatabase);
                }
                sQLiteDatabase.setTransactionSuccessful();
                try {
                    sQLiteDatabase.beginTransaction();
                    f.cZa.put(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + ".db", sQLiteDatabase);
                    j.ass();
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    sQLiteDatabase.endTransaction();
                    f.cZa.remove(String.valueOf(TbadkCoreApplication.getCurrentAccount()) + ".db");
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void D(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD sent_mid long default 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD read_mid long default 0;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg7to8", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void E(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD user_type int default  1;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg8to9", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void F(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_new_friends RENAME TO tb_new_friends_tmp;");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_new_friends(_id INTEGER primary key autoincrement, uid LONG NOT NULL, uname TEXT, ustatus INTEGER, uportrait TEXT, ucontent TEXT,isread INTEGER);");
                    sQLiteDatabase.execSQL("INSERT INTO tb_new_friends SELECT _id,uid,uname,ustatus,uportrait,ucontent,isread FROM tb_new_friends_tmp WHERE uid > 0;");
                    sQLiteDatabase.execSQL("DROP TABLE tb_new_friends_tmp;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg9to10", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_new_friends");
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private void G(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.beginTransaction();
                try {
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD sid long default 0;");
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD task_id TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD ext1 TEXT;");
                    sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD ext2 TEXT;");
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "ImDatabaseHelper.groupMsg9to10", new Object[0]);
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_new_friends");
                }
                sQLiteDatabase.setTransactionSuccessful();
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
