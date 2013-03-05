package com.baidu.tieba.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class h extends SQLiteOpenHelper {
    public h(Context context) {
        super(context, "baidu_tieba.db", (SQLiteDatabase.CursorFactory) null, 6);
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            ag.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TABLE if not exists cash_data(type int,account varchar(30),data TEXT)");
        a(sQLiteDatabase, "CREATE TABLE if not exists account_data(id,account,password,bduss,isactive int,tbs,time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists search_data(key, account, time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost int,forumName varchar(30),forumId varchar(30),threadId varchar(30))");
        a(sQLiteDatabase, "CREATE TABLE if not exists draft_box(account varchar(30),type int,forum_id varchar(20),forum_name TEXT,thread_id varchar(30),floor_id TEXT,title TEXT,content TEXT, time long)");
        a(sQLiteDatabase, "CREATE TABLE if not exists setting(account varchar(30),frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone)");
        a(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        a(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            a(sQLiteDatabase, "CREATE TABLE if not exists chunk_upload_data(account varchar(30),md5,total_length,chunk_no,time)");
        }
        if (i < 3) {
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD subPost int");
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD forumName varchar(30)");
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD forumId varchar(30)");
            a(sQLiteDatabase, "ALTER TABLE mark_data ADD threadId varchar(30)");
        }
        if (i < 4) {
            a(sQLiteDatabase, "ALTER TABLE setting ADD remind_tone");
        }
        if (i < 5) {
            a(sQLiteDatabase, "CREATE TABLE if not exists frs_image_forums(forum_name)");
        }
        if (i < 6) {
            a(sQLiteDatabase, "CREATE TABLE if not exists search_post_data(key, account, time)");
        }
    }
}
