package com.baidu.tieba.im.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.bg;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class l extends SQLiteOpenHelper {
    public l(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            bg.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        com.baidu.adp.lib.h.d.d("CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_group_news(notice_id TEXT NOT NULL UNIQUE, cmd TEXT, gid TEXT, time long, content TEXT, content_status int, ext TEXT);");
        com.baidu.adp.lib.h.d.d("CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL UNIQUE, group_name TEXT, group_head TEXT, group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, orderCol TEXT, last_content TEXT, type int, ext TEXT,is_hidden int,is_delete int);");
        a(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS tb_message_center(gid TEXT NOT NULL UNIQUE, group_name TEXT, group_head TEXT, group_type int, group_ext TEXT, unread_count int, last_msgId TEXT, last_user_name TEXT, last_content_time long, orderCol TEXT, last_content TEXT, type int, ext TEXT,is_hidden int,is_delete int);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                b(sQLiteDatabase);
                return;
            default:
                return;
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        if (sQLiteDatabase != null) {
            LinkedList linkedList = new LinkedList();
            if (sQLiteDatabase != null) {
                try {
                    cursor = sQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            linkedList.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    com.baidu.tieba.util.o.a(cursor);
                }
            }
            com.baidu.adp.lib.h.d.d("haveTables:" + linkedList);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (TextUtils.isEmpty(str)) {
                    com.baidu.adp.lib.h.d.a("gid is null");
                } else if (str.startsWith(a.f1592a)) {
                    try {
                        sQLiteDatabase.execSQL("ALTER TABLE " + str + " ADD read_flag int;");
                    } catch (Exception e2) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
                        com.baidu.adp.lib.h.d.a("升级" + str + "失败！");
                    }
                }
            }
        }
    }
}
