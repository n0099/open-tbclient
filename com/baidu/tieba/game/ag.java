package com.baidu.tieba.game;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ag {
    private static ag a = new ag();

    public static ag a() {
        return a;
    }

    private ag() {
    }

    public boolean a(ab abVar) {
        if (abVar == null) {
            return false;
        }
        SQLiteDatabase a2 = com.baidu.tbadk.j.a().b().a();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gameId", abVar.a());
            contentValues.put("gameName", abVar.b());
            contentValues.put("gameType", Integer.valueOf(abVar.c()));
            contentValues.put("iconUrl", abVar.d());
            contentValues.put("gameLink", abVar.h());
            contentValues.put("packageName", abVar.n());
            contentValues.put("launcherActivity", abVar.o());
            if (abVar.c() == 2) {
                contentValues.put("installTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            } else if (abVar.c() == 1) {
                contentValues.put("downloadTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            }
            if (a2.update("local_game", contentValues, "gameId=?", new String[]{abVar.a()}) == 0) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [156=4] */
    public ab b(String str) {
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
                    ab abVar = new ab();
                    abVar.a(cursor.getString(cursor.getColumnIndex("gameId")));
                    abVar.b(cursor.getString(cursor.getColumnIndex("gameName")));
                    abVar.a(cursor.getInt(cursor.getColumnIndex("gameType")));
                    abVar.f(cursor.getString(cursor.getColumnIndex("gameLink")));
                    abVar.j(cursor.getString(cursor.getColumnIndex("packageName")));
                    abVar.k(cursor.getString(cursor.getColumnIndex("launcherActivity")));
                    abVar.a(com.baidu.adp.lib.e.b.a(cursor.getString(cursor.getColumnIndex("installTime")), 0L));
                    abVar.b(com.baidu.adp.lib.e.b.a(cursor.getString(cursor.getColumnIndex("downloadTime")), 0L));
                    abVar.c(cursor.getString(cursor.getColumnIndex("iconUrl")));
                    return abVar;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=4] */
    public List<ab> b() {
        Cursor cursor;
        try {
            cursor = com.baidu.tbadk.j.a().b().a().query("local_game", null, null, null, null, null, null);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    ab abVar = new ab();
                    abVar.a(cursor.getString(cursor.getColumnIndex("gameId")));
                    abVar.b(cursor.getString(cursor.getColumnIndex("gameName")));
                    abVar.a(cursor.getInt(cursor.getColumnIndex("gameType")));
                    abVar.f(cursor.getString(cursor.getColumnIndex("gameLink")));
                    abVar.j(cursor.getString(cursor.getColumnIndex("packageName")));
                    abVar.k(cursor.getString(cursor.getColumnIndex("launcherActivity")));
                    abVar.a(com.baidu.adp.lib.e.b.a(cursor.getString(cursor.getColumnIndex("installTime")), 0L));
                    abVar.b(com.baidu.adp.lib.e.b.a(cursor.getString(cursor.getColumnIndex("downloadTime")), 0L));
                    abVar.c(cursor.getString(cursor.getColumnIndex("iconUrl")));
                    arrayList.add(abVar);
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
