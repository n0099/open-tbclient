package com.baidu.tieba.im.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class r extends SQLiteOpenHelper {
    public r(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            bd.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        com.baidu.adp.lib.h.e.d("CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
        com.baidu.adp.lib.h.e.d("CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL UNIQUE, group_name TEXT, group_head TEXT, group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, orderCol TEXT, last_content TEXT, type int, ext TEXT,is_hidden int,is_delete int);");
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL UNIQUE, group_name TEXT, group_head TEXT, group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, orderCol TEXT, last_content TEXT, type int, ext TEXT,is_hidden int,is_delete int);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        try {
            TiebaApplication.h().deleteDatabase(TiebaApplication.B() + ".db");
            a(sQLiteDatabase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                try {
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                    return;
                } catch (Exception e) {
                    com.baidu.adp.lib.h.e.a("im数据库升级失败， 删除数据库。 重新建立数据库");
                    TiebaApplication.h().deleteDatabase(TiebaApplication.B() + ".db");
                    a(sQLiteDatabase);
                    return;
                }
            case 2:
                b(sQLiteDatabase);
                return;
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
                        com.baidu.adp.lib.h.e.a("gid is null");
                    } else if (next.startsWith(d.f1666a)) {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD rid BIGINT;");
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD is_delete int default 0;");
                            sQLiteDatabase.execSQL("UPDATE " + next + " SET read_flag=0 WHERE read_flag is null");
                            sQLiteDatabase.execSQL("UPDATE " + next + " SET rid=mid WHERE rid is null");
                        } catch (Exception e) {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                            com.baidu.adp.lib.h.e.a("升级" + next + "失败！");
                        }
                    }
                }
                sQLiteDatabase.setTransactionSuccessful();
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    private LinkedList<String> c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            if (sQLiteDatabase != null) {
                cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                    }
                }
            }
            com.baidu.adp.lib.h.e.d("haveTables:" + linkedList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.baidu.tieba.util.o.a(cursor);
        }
        return linkedList;
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            LinkedList<String> c = c(sQLiteDatabase);
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<String> it = c.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next)) {
                        com.baidu.adp.lib.h.e.a("gid is null");
                    } else if (next.startsWith(d.f1666a)) {
                        try {
                            sQLiteDatabase.execSQL("ALTER TABLE " + next + " ADD read_flag int default 0;");
                        } catch (Exception e) {
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + next);
                            com.baidu.adp.lib.h.e.a("升级" + next + "失败！");
                        }
                    }
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

    public static SQLiteStatement a(String str) {
        SQLiteDatabase a2 = s.a();
        if (a2 == null) {
            return null;
        }
        return a2.compileStatement(str);
    }
}
