package com.baidu.tieba.aiapps.apps.history.impl.a;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
/* loaded from: classes4.dex */
public class b {
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_aiapps_history( _id INTEGER PRIMARY KEY AUTOINCREMENT,app_id TEXT NOT NULL UNIQUE ,app_key TEXT NOT NULL ,app_title TEXT ,app_icon_url TEXT ,app_desc TEXT ,app_access_time LONG ,app_type INTEGER )");
        x(sQLiteDatabase);
    }

    private void x(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS delete_old_aiapps_history");
            sQLiteDatabase.execSQL("CREATE TRIGGER delete_old_aiapps_history AFTER INSERT ON table_aiapps_history WHEN (select count(*) from table_aiapps_history)>300 BEGIN  DELETE FROM table_aiapps_history WHERE _id IN (SELECT _id FROM  table_aiapps_history ORDER BY app_access_time LIMIT (SELECT count(*) -300 FROM table_aiapps_history)); END;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cursor a(SQLiteDatabase sQLiteDatabase, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return sQLiteDatabase.query("table_aiapps_history", strArr, str, strArr2, null, null, str2);
    }

    public Uri a(Uri uri, SQLiteDatabase sQLiteDatabase, ContentValues contentValues) {
        return ContentUris.withAppendedId(uri, sQLiteDatabase.insertWithOnConflict("table_aiapps_history", null, contentValues, 5));
    }

    public int a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        return sQLiteDatabase.delete("table_aiapps_history", str, strArr);
    }

    public int a(SQLiteDatabase sQLiteDatabase, ContentValues contentValues, String str, String[] strArr) {
        return sQLiteDatabase.update("table_aiapps_history", contentValues, str, strArr);
    }
}
