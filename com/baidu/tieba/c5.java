package com.baidu.tieba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes5.dex */
public interface c5 {

    /* loaded from: classes5.dex */
    public interface a {
        void onDatabaseCreated(SQLiteDatabase sQLiteDatabase);
    }

    boolean dropDatabase(Context context);

    SQLiteDatabase getWritableDatabase();

    void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2);

    void setOnCreateCallback(a aVar);
}
