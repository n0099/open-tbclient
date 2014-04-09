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
public final class f extends SQLiteOpenHelper {
    public f(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 5);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            com.baidu.adp.lib.util.f.e("CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
            com.baidu.adp.lib.util.f.e("CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL UNIQUE, group_name TEXT, group_head TEXT, group_type int, custom_group_type int, isread int,group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, orderCol TEXT, last_content TEXT, type int, ext TEXT,is_hidden int,is_delete int);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL UNIQUE, group_name TEXT, group_head TEXT, group_type int, custom_group_type int, isread int,group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, orderCol TEXT, last_content TEXT, type int, ext TEXT,is_hidden int,is_delete int);");
            com.baidu.adp.lib.util.f.e("CREATE TABLE IF NOT EXISTS tb_personal_id(personal_gid int);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_personal_id(personal_gid int);");
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseHelper.createTables", new Object[0]);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @SuppressLint({"Override"})
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            TbadkApplication.j().b().deleteDatabase(String.valueOf(TbadkApplication.E()) + ".db");
            a(sQLiteDatabase);
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseHelper.onDowngrade", new Object[0]);
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036 A[Catch: all -> 0x0125, TRY_ENTER, TRY_LEAVE, TryCatch #5 {Exception -> 0x004a, blocks: (B:6:0x0007, B:11:0x001b, B:12:0x001e, B:15:0x0031, B:40:0x0101, B:20:0x0046, B:17:0x0036, B:18:0x0039, B:19:0x0043, B:45:0x010c, B:14:0x0023, B:39:0x00f2, B:7:0x000b, B:8:0x0012, B:10:0x0018, B:24:0x007d, B:26:0x0089, B:31:0x0094, B:33:0x009c, B:36:0x00bd), top: B:56:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                if (sQLiteDatabase != null) {
                    try {
                        LinkedList<String> c = c(sQLiteDatabase);
                        sQLiteDatabase.beginTransaction();
                        Iterator<String> it = c.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (TextUtils.isEmpty(next)) {
                                com.baidu.adp.lib.util.f.b("gid is null");
                            } else if (next.startsWith("tb_group_msg_")) {
                                try {
                                    sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD read_flag int default 0;");
                                } catch (Exception e) {
                                    TiebaStatic.a(e, "ImDatabaseHelper.groupMsg1to2", new Object[0]);
                                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                                    com.baidu.adp.lib.util.f.b("升级" + next + "失败！");
                                }
                            }
                        }
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e2) {
                        TiebaStatic.a(e2, "ImDatabaseHelper.onUpgrade", new Object[0]);
                        com.baidu.adp.lib.util.f.b("im数据库升级失败， 删除数据库。 重新建立数据库");
                        TbadkApplication.j().b().deleteDatabase(String.valueOf(TbadkApplication.E()) + ".db");
                        a(sQLiteDatabase);
                        return;
                    }
                }
                b(sQLiteDatabase);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.beginTransaction();
                        com.baidu.adp.lib.util.f.e("CREATE TABLE IF NOT EXISTS tb_personal_id(personal_gid int);");
                        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tb_personal_id(personal_gid int);");
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                    } catch (Exception e3) {
                        TiebaStatic.a(e3, "ImDatabaseHelper.groupMsg3to4", new Object[0]);
                        com.baidu.adp.lib.util.f.b(e3.toString());
                        sQLiteDatabase.endTransaction();
                    }
                }
                if (sQLiteDatabase == null) {
                    sQLiteDatabase.beginTransaction();
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD custom_group_type int default 0;");
                        sQLiteDatabase.execSQL("ALTER TABLE tb_message_center ADD isread int default 0;");
                    } catch (Exception e4) {
                        TiebaStatic.a(e4, "ImDatabaseHelper.groupMsg4to5", new Object[0]);
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS tb_message_center");
                        com.baidu.adp.lib.util.f.b("升级tb_message_center失败！");
                        com.baidu.adp.lib.util.f.b("升级isread失败！");
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    sQLiteDatabase.endTransaction();
                    return;
                }
                return;
            case 2:
                b(sQLiteDatabase);
                if (sQLiteDatabase != null) {
                }
                if (sQLiteDatabase == null) {
                }
                break;
            case 3:
                if (sQLiteDatabase != null) {
                }
                if (sQLiteDatabase == null) {
                }
                break;
            case 4:
                if (sQLiteDatabase == null) {
                }
                break;
            default:
                return;
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            LinkedList<String> c = c(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = c.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next)) {
                        com.baidu.adp.lib.util.f.b("gid is null");
                    } else if (next.startsWith("tb_group_msg_")) {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD rid BIGINT;");
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD is_delete int default 0;");
                            sQLiteDatabase.execSQL("UPDATE " + next + " SET read_flag=0 WHERE read_flag is null");
                            sQLiteDatabase.execSQL("UPDATE " + next + " SET rid=mid WHERE rid is null");
                        } catch (Exception e) {
                            TiebaStatic.a(e, "ImDatabaseHelper.groupMsg2to3", new Object[0]);
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                            com.baidu.adp.lib.util.f.b("升级" + next + "失败！");
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private static LinkedList<String> c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        LinkedList<String> linkedList = new LinkedList<>();
        if (sQLiteDatabase != null) {
            try {
                cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            } catch (Exception e) {
                TiebaStatic.a(e, "ImDatabaseHelper.getAllTable", new Object[0]);
                e.printStackTrace();
            } finally {
                com.baidu.tbadk.core.util.l.a(cursor);
            }
        }
        com.baidu.adp.lib.util.f.e("haveTables:" + linkedList);
        return linkedList;
    }

    public static void a(SQLiteStatement sQLiteStatement, int i, String str) {
        if (str == null) {
            sQLiteStatement.bindNull(i);
        } else {
            sQLiteStatement.bindString(i, str);
        }
    }

    public static SQLiteStatement a(String str) {
        try {
            SQLiteDatabase a = g.a();
            if (a == null) {
                return null;
            }
            return a.compileStatement(str);
        } catch (Exception e) {
            TiebaStatic.a(e, "ImDatabaseHelper.getStatementForSql", new Object[0]);
            return null;
        }
    }
}
