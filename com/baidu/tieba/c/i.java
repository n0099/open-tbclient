package com.baidu.tieba.c;

import android.database.sqlite.SQLiteDatabase;
/* loaded from: classes.dex */
public class i {
    private int a;
    private boolean b = false;
    private j e = null;
    private String c = "tieba_database.db";
    private String d = o.a + "/tieba/" + this.c;

    public i() {
        this.a = 1;
        this.a = 5;
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            a(sQLiteDatabase, "CREATE TABLE if not exists pb_photo(key varchar(50) Primary Key,image blob,date Integer)");
            a(sQLiteDatabase, "CREATE INDEX if not exists pb_photo_index ON pb_photo(date)");
            a(sQLiteDatabase, "CREATE TABLE if not exists friend_photo(key varchar(50) Primary Key,image blob,date Integer)");
            a(sQLiteDatabase, "CREATE INDEX if not exists friend_photo_index ON friend_photo(date)");
        }
        b();
    }

    private void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b();
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL(str);
        } catch (Exception e) {
            ae.a(3, getClass().getName(), "ExecSQL", str);
        }
    }

    private void b() {
        if (this.e != null) {
            try {
                this.e.a();
            } catch (Exception e) {
                ae.b(getClass().getName(), "onCreateDatabase", e.getMessage());
            }
        }
    }

    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = null;
        if (o.c()) {
            this.b = o.b(this.c);
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(this.d, (SQLiteDatabase.CursorFactory) null);
            if (sQLiteDatabase != null) {
                if (this.b) {
                    int version = sQLiteDatabase.getVersion();
                    if (version != this.a) {
                        a(sQLiteDatabase, version, this.a);
                        sQLiteDatabase.setVersion(this.a);
                    }
                } else {
                    a(sQLiteDatabase);
                    sQLiteDatabase.setVersion(this.a);
                }
            }
        }
        return sQLiteDatabase;
    }

    public void a(j jVar) {
        this.e = jVar;
    }
}
