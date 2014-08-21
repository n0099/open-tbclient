package com.baidu.tieba.game;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ak {
    private static ak a = new ak();

    public static ak a() {
        return a;
    }

    private ak() {
    }

    public boolean a(com.baidu.tbadk.game.b bVar) {
        if (bVar == null) {
            return false;
        }
        SQLiteDatabase a2 = com.baidu.tbadk.j.a().b().a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gameId", bVar.a());
            contentValues.put("gameName", bVar.b());
            contentValues.put("gameType", Integer.valueOf(bVar.c()));
            contentValues.put("iconUrl", bVar.d());
            contentValues.put("gameLink", bVar.h());
            contentValues.put("packageName", bVar.n());
            contentValues.put("launcherActivity", bVar.o());
            if (bVar.c() == 2) {
                contentValues.put("installTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            } else if (bVar.c() == 1) {
                contentValues.put("downloadTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            }
            if (a2.update("local_game", contentValues, "gameId=?", new String[]{bVar.a()}) == 0) {
                a2.insert("local_game", "gameId", contentValues);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return com.baidu.tbadk.j.a().b().a().delete("local_game", "gameId=?", new String[]{str}) > 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [157=4] */
    public com.baidu.tbadk.game.b b(String str) {
        Cursor cursor;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cursor = com.baidu.tbadk.j.a().b().a().query("local_game", null, "packageName=?", new String[]{str}, null, null, null);
            if (cursor == null) {
                return null;
            }
            try {
                if (cursor.moveToNext()) {
                    com.baidu.tbadk.game.b bVar = new com.baidu.tbadk.game.b();
                    bVar.a(cursor.getString(cursor.getColumnIndex("gameId")));
                    bVar.b(cursor.getString(cursor.getColumnIndex("gameName")));
                    bVar.a(cursor.getInt(cursor.getColumnIndex("gameType")));
                    bVar.f(cursor.getString(cursor.getColumnIndex("gameLink")));
                    bVar.j(cursor.getString(cursor.getColumnIndex("packageName")));
                    bVar.k(cursor.getString(cursor.getColumnIndex("launcherActivity")));
                    bVar.a(com.baidu.adp.lib.e.c.a(cursor.getString(cursor.getColumnIndex("installTime")), 0L));
                    bVar.b(com.baidu.adp.lib.e.c.a(cursor.getString(cursor.getColumnIndex("downloadTime")), 0L));
                    bVar.c(cursor.getString(cursor.getColumnIndex("iconUrl")));
                    return bVar;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public List<com.baidu.tbadk.game.b> b() {
        Cursor cursor;
        try {
            cursor = com.baidu.tbadk.j.a().b().a().query("local_game", null, null, null, null, null, null);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    com.baidu.tbadk.game.b bVar = new com.baidu.tbadk.game.b();
                    bVar.a(cursor.getString(cursor.getColumnIndex("gameId")));
                    bVar.b(cursor.getString(cursor.getColumnIndex("gameName")));
                    bVar.a(cursor.getInt(cursor.getColumnIndex("gameType")));
                    bVar.f(cursor.getString(cursor.getColumnIndex("gameLink")));
                    bVar.j(cursor.getString(cursor.getColumnIndex("packageName")));
                    bVar.k(cursor.getString(cursor.getColumnIndex("launcherActivity")));
                    bVar.a(com.baidu.adp.lib.e.c.a(cursor.getString(cursor.getColumnIndex("installTime")), 0L));
                    bVar.b(com.baidu.adp.lib.e.c.a(cursor.getString(cursor.getColumnIndex("downloadTime")), 0L));
                    bVar.c(cursor.getString(cursor.getColumnIndex("iconUrl")));
                    arrayList.add(bVar);
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
