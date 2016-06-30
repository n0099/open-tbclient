package com.baidu.tbadk.coreExtra.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "game.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c.xj().o(sQLiteDatabase);
        d.xl().o(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        switch (i) {
            case 1:
                d.xl().o(sQLiteDatabase);
                return;
            default:
                return;
        }
    }
}
