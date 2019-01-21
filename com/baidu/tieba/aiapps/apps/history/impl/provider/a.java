package com.baidu.tieba.aiapps.apps.history.impl.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;
import com.baidu.tieba.aiapps.apps.history.impl.a.b;
/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {
    private b bHC;

    public a(Context context) {
        super(context, "aiapps_history_db", (SQLiteDatabase.CursorFactory) null, 1);
        this.bHC = new b();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.bHC.onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public Cursor a(@Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return this.bHC.a(getReadableDatabase(), strArr, str, strArr2, str2);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.bHC.a(uri, getWritableDatabase(), contentValues);
    }

    public String getType() {
        return "vnd.android.cursor.all/aiapphistory";
    }

    public int b(String str, String[] strArr) {
        return this.bHC.a(getWritableDatabase(), str, strArr);
    }

    public int a(ContentValues contentValues, String str, String[] strArr) {
        return this.bHC.a(getWritableDatabase(), contentValues, str, strArr);
    }
}
