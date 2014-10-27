package com.baidu.tieba.game;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bf {
    private static bf aIX = new bf();

    public static bf HG() {
        return aIX;
    }

    private bf() {
    }

    public boolean p(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        SQLiteDatabase P = TiebaDatabase.getInstance().getMainDBDatabaseManager().P();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gameId", gameInfoData.getGameId());
            contentValues.put("gameName", gameInfoData.getGameName());
            contentValues.put("gameType", Integer.valueOf(gameInfoData.getGameType()));
            contentValues.put("iconUrl", gameInfoData.getIconUrl());
            contentValues.put("gameLink", gameInfoData.getGameLink());
            contentValues.put("packageName", gameInfoData.getPackageName());
            contentValues.put("launcherActivity", gameInfoData.getLauncherActivity());
            if (gameInfoData.getGameType() == 2) {
                contentValues.put("installTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            } else if (gameInfoData.getGameType() == 1) {
                contentValues.put("downloadTime", new StringBuilder(String.valueOf(System.currentTimeMillis())).toString());
            }
            if (P.update("local_game", contentValues, "gameId=?", new String[]{gameInfoData.getGameId()}) == 0) {
                P.insert("local_game", "gameId", contentValues);
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean ai(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        SQLiteDatabase P = TiebaDatabase.getInstance().getMainDBDatabaseManager().P();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gameLink", str2);
            return P.update("local_game", contentValues, "gameId=?", new String[]{str}) != 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean fu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return TiebaDatabase.getInstance().getMainDBDatabaseManager().P().delete("local_game", "gameId=?", new String[]{str}) > 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [177=4] */
    public GameInfoData fv(String str) {
        Cursor cursor;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().P().query("local_game", null, "packageName=?", new String[]{str}, null, null, null);
            if (cursor == null) {
                return null;
            }
            try {
                if (cursor.moveToNext()) {
                    GameInfoData gameInfoData = new GameInfoData();
                    gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("gameId")));
                    gameInfoData.setGameName(cursor.getString(cursor.getColumnIndex("gameName")));
                    gameInfoData.setGameType(cursor.getInt(cursor.getColumnIndex("gameType")));
                    gameInfoData.setGameLink(cursor.getString(cursor.getColumnIndex("gameLink")));
                    gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("packageName")));
                    gameInfoData.setLauncherActivity(cursor.getString(cursor.getColumnIndex("launcherActivity")));
                    gameInfoData.setInstallTime(com.baidu.adp.lib.g.c.a(cursor.getString(cursor.getColumnIndex("installTime")), 0L));
                    gameInfoData.setDownloadTime(com.baidu.adp.lib.g.c.a(cursor.getString(cursor.getColumnIndex("downloadTime")), 0L));
                    gameInfoData.setIconUrl(cursor.getString(cursor.getColumnIndex("iconUrl")));
                    return gameInfoData;
                }
                return null;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    com.baidu.adp.lib.util.p.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [218=4] */
    public List<GameInfoData> HH() {
        Cursor cursor;
        try {
            cursor = TiebaDatabase.getInstance().getMainDBDatabaseManager().P().query("local_game", null, null, null, null, null, null);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    GameInfoData gameInfoData = new GameInfoData();
                    gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("gameId")));
                    gameInfoData.setGameName(cursor.getString(cursor.getColumnIndex("gameName")));
                    gameInfoData.setGameType(cursor.getInt(cursor.getColumnIndex("gameType")));
                    gameInfoData.setGameLink(cursor.getString(cursor.getColumnIndex("gameLink")));
                    gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("packageName")));
                    gameInfoData.setLauncherActivity(cursor.getString(cursor.getColumnIndex("launcherActivity")));
                    gameInfoData.setInstallTime(com.baidu.adp.lib.g.c.a(cursor.getString(cursor.getColumnIndex("installTime")), 0L));
                    gameInfoData.setDownloadTime(com.baidu.adp.lib.g.c.a(cursor.getString(cursor.getColumnIndex("downloadTime")), 0L));
                    gameInfoData.setIconUrl(cursor.getString(cursor.getColumnIndex("iconUrl")));
                    arrayList.add(gameInfoData);
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    com.baidu.adp.lib.util.p.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}
