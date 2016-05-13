package com.baidu.tbadk.coreExtra.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MangaCategoryActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c agx;

    private c() {
    }

    public static synchronized c xf() {
        c cVar;
        synchronized (c.class) {
            if (agx == null) {
                agx = new c();
            }
            cVar = agx;
        }
        return cVar;
    }

    private ContentValues a(GameInfoData gameInfoData) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("game_id", gameInfoData.getGameId());
        contentValues.put("game_name", gameInfoData.getGameName());
        contentValues.put("game_type", Integer.valueOf(gameInfoData.getGameType()));
        contentValues.put("icon_url", gameInfoData.getIconUrl());
        contentValues.put("player_num", Integer.valueOf(gameInfoData.getPlayerNum()));
        contentValues.put("package_link", gameInfoData.getPackageLink());
        contentValues.put("package_size", gameInfoData.getPackageSize());
        contentValues.put("game_link", gameInfoData.getGameLink());
        contentValues.put(PbActivityConfig.KEY_MARK, Integer.valueOf(gameInfoData.getMark()));
        contentValues.put("bundle_id", gameInfoData.getBundleId());
        contentValues.put("introduce", gameInfoData.getIntroduce());
        contentValues.put("launch_component", gameInfoData.getLauncherActivity());
        contentValues.put("andr_pk_name", gameInfoData.getPackageName());
        contentValues.put("day_downloads", Integer.valueOf(gameInfoData.getDayDownloads()));
        contentValues.put("secret_key", gameInfoData.getSecretKey());
        contentValues.put("superscript_color", gameInfoData.getSuperscriptColor());
        contentValues.put("star", Integer.valueOf(gameInfoData.getStar()));
        contentValues.put("category_id", Integer.valueOf(gameInfoData.getCategoryId()));
        contentValues.put(MangaCategoryActivityConfig.CATEGORY_NAME, gameInfoData.getCategoryName());
        contentValues.put("version", gameInfoData.getVersion());
        contentValues.put("deadline", Long.valueOf(gameInfoData.getDeadline()));
        contentValues.put("editor_rec", gameInfoData.getEditorRec());
        contentValues.put("app_id", gameInfoData.getApp_id());
        contentValues.put("current_Time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("label", (Integer) 0);
        return contentValues;
    }

    public boolean b(GameInfoData gameInfoData) {
        SQLiteDatabase xe = b.xe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (gameInfoData == null || xe == null || TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(gameInfoData.getGameId())) {
            return false;
        }
        try {
            o(xe);
            ContentValues a = a(gameInfoData);
            if (xe.update("table_download" + currentAccount, a, "game_id = ?", new String[]{gameInfoData.getGameId()}) == 0) {
                xe.insert("table_download" + currentAccount, null, a);
                return true;
            }
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.addGameInfoItem", new Object[0]);
            return false;
        }
    }

    public boolean v(String str, int i) {
        SQLiteDatabase xe = b.xe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(str) || xe == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("label", Integer.valueOf(i));
            if (xe.update("table_download" + currentAccount, contentValues, "game_id = ?", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.updateToFinish", new Object[0]);
        }
        return false;
    }

    public boolean eg(String str) {
        SQLiteDatabase xe = b.xe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(str) || xe == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_Time", Long.valueOf(System.currentTimeMillis()));
            if (xe.update("table_download" + currentAccount, contentValues, "game_id = ?", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.updateDownloadTime", new Object[0]);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [198=4] */
    public boolean eh(String str) {
        Cursor cursor;
        SQLiteDatabase xe = b.xe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(str) || xe == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            cursor = xe.query("table_download" + currentAccount, new String[]{"count(*)"}, "game_id = ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.getCount() > 0) {
                            if (xe.delete("table_download" + currentAccount, "game_id = ?", new String[]{str}) > 0) {
                                o.a(cursor);
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.deleteItem", new Object[0]);
                        o.a(cursor);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    o.a(cursor);
                    throw th;
                }
            }
            o.a(cursor);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            o.a(cursor);
            throw th;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [252=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x0191 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.StringBuilder] */
    public GameInfoData ei(String str) {
        Cursor cursor;
        SQLiteDatabase xe = b.xe();
        ?? currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (xe != null) {
            try {
                if (!TextUtils.isEmpty(currentAccount)) {
                    try {
                        cursor = xe.query("table_download" + currentAccount, null, "andr_pk_name= ?", new String[]{str}, null, null, null);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    GameInfoData gameInfoData = new GameInfoData();
                                    gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("game_id")));
                                    gameInfoData.setGameName(cursor.getString(cursor.getColumnIndex("game_name")));
                                    gameInfoData.setGameType(cursor.getInt(cursor.getColumnIndex("game_type")));
                                    gameInfoData.setIconUrl(cursor.getString(cursor.getColumnIndex("icon_url")));
                                    gameInfoData.setPlayerNum(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("player_num"))));
                                    gameInfoData.setPackageLink(cursor.getString(cursor.getColumnIndex("package_link")));
                                    gameInfoData.setPackageSize(cursor.getString(cursor.getColumnIndex("package_size")));
                                    gameInfoData.setGameLink(cursor.getString(cursor.getColumnIndex("game_link")));
                                    gameInfoData.setMark(cursor.getInt(cursor.getColumnIndex(PbActivityConfig.KEY_MARK)));
                                    gameInfoData.setBundleId(cursor.getString(cursor.getColumnIndex("bundle_id")));
                                    gameInfoData.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                                    gameInfoData.setLauncherActivity(cursor.getString(cursor.getColumnIndex("launch_component")));
                                    gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("andr_pk_name")));
                                    gameInfoData.setDayDownloads(cursor.getInt(cursor.getColumnIndex("day_downloads")));
                                    gameInfoData.setSecretKey(cursor.getString(cursor.getColumnIndex("secret_key")));
                                    gameInfoData.setSuperscriptColor(cursor.getString(cursor.getColumnIndex("superscript_color")));
                                    gameInfoData.setStar(cursor.getInt(cursor.getColumnIndex("star")));
                                    gameInfoData.setCategoryId(cursor.getInt(cursor.getColumnIndex("category_id")));
                                    gameInfoData.setCategoryName(cursor.getString(cursor.getColumnIndex(MangaCategoryActivityConfig.CATEGORY_NAME)));
                                    gameInfoData.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                                    gameInfoData.setDeadline(cursor.getInt(cursor.getColumnIndex("deadline")));
                                    gameInfoData.setEditorRec(cursor.getString(cursor.getColumnIndex("editor_rec")));
                                    gameInfoData.setApp_id(cursor.getString(cursor.getColumnIndex("app_id")));
                                    o.a(cursor);
                                    return gameInfoData;
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.getGameItemByPackageName", new Object[0]);
                                o.a(cursor);
                                return null;
                            }
                        }
                        o.a(cursor);
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        currentAccount = 0;
                        o.a((Cursor) currentAccount);
                        throw th;
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x01a3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.StringBuilder] */
    public List<GameInfoData> xg() {
        Cursor cursor;
        SQLiteDatabase xe = b.xe();
        ?? currentAccount = TbadkCoreApplication.getCurrentAccount();
        ArrayList arrayList = new ArrayList();
        if (xe != null) {
            try {
                if (!TextUtils.isEmpty(currentAccount)) {
                    try {
                        cursor = xe.query("table_download" + currentAccount, null, "label=0 OR label=1", null, null, null, "current_Time DESC");
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                try {
                                    GameInfoData gameInfoData = new GameInfoData();
                                    gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("game_id")));
                                    gameInfoData.setGameName(cursor.getString(cursor.getColumnIndex("game_name")));
                                    gameInfoData.setGameType(cursor.getInt(cursor.getColumnIndex("game_type")));
                                    gameInfoData.setIconUrl(cursor.getString(cursor.getColumnIndex("icon_url")));
                                    gameInfoData.setPlayerNum(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("player_num"))));
                                    gameInfoData.setPackageLink(cursor.getString(cursor.getColumnIndex("package_link")));
                                    gameInfoData.setPackageSize(cursor.getString(cursor.getColumnIndex("package_size")));
                                    gameInfoData.setGameLink(cursor.getString(cursor.getColumnIndex("game_link")));
                                    gameInfoData.setMark(cursor.getInt(cursor.getColumnIndex(PbActivityConfig.KEY_MARK)));
                                    gameInfoData.setBundleId(cursor.getString(cursor.getColumnIndex("bundle_id")));
                                    gameInfoData.setIntroduce(cursor.getString(cursor.getColumnIndex("introduce")));
                                    gameInfoData.setLauncherActivity(cursor.getString(cursor.getColumnIndex("launch_component")));
                                    gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("andr_pk_name")));
                                    gameInfoData.setDayDownloads(cursor.getInt(cursor.getColumnIndex("day_downloads")));
                                    gameInfoData.setSecretKey(cursor.getString(cursor.getColumnIndex("secret_key")));
                                    gameInfoData.setSuperscriptColor(cursor.getString(cursor.getColumnIndex("superscript_color")));
                                    gameInfoData.setStar(cursor.getInt(cursor.getColumnIndex("star")));
                                    gameInfoData.setCategoryId(cursor.getInt(cursor.getColumnIndex("category_id")));
                                    gameInfoData.setCategoryName(cursor.getString(cursor.getColumnIndex(MangaCategoryActivityConfig.CATEGORY_NAME)));
                                    gameInfoData.setVersion(cursor.getString(cursor.getColumnIndex("version")));
                                    gameInfoData.setDeadline(cursor.getInt(cursor.getColumnIndex("deadline")));
                                    gameInfoData.setEditorRec(cursor.getString(cursor.getColumnIndex("editor_rec")));
                                    gameInfoData.setApp_id(cursor.getString(cursor.getColumnIndex("app_id")));
                                    int i = cursor.getInt(cursor.getColumnIndex("label"));
                                    if (i == 0) {
                                        gameInfoData.setGamestatus(0);
                                    } else if (i == 1) {
                                        gameInfoData.setGamestatus(1);
                                    }
                                    arrayList.add(gameInfoData);
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.getGameDownloadList", new Object[0]);
                                    o.a(cursor);
                                    return arrayList;
                                }
                            }
                        }
                        o.a(cursor);
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                    } catch (Throwable th) {
                        th = th;
                        currentAccount = 0;
                        o.a((Cursor) currentAccount);
                        throw th;
                    }
                    return arrayList;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return arrayList;
    }

    public List<GameInfoData> dj(int i) {
        Cursor cursor;
        SQLiteDatabase xe = b.xe();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        ArrayList arrayList = new ArrayList();
        if (xe == null || TextUtils.isEmpty(currentAccount)) {
            return arrayList;
        }
        if (i == 3 || i == 2) {
            try {
                cursor = xe.query("table_download" + currentAccount, null, "label=" + i, null, "current_TimeDESC", null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            try {
                                GameInfoData gameInfoData = new GameInfoData();
                                gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("game_id")));
                                gameInfoData.setApp_id(cursor.getString(cursor.getColumnIndex("app_id")));
                                arrayList.add(gameInfoData);
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GameDownloadDao.getAllFinishList", new Object[0]);
                                o.a(cursor);
                                return arrayList;
                            }
                        } catch (Throwable th) {
                            th = th;
                            o.a(cursor);
                            throw th;
                        }
                    }
                }
                o.a(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                o.a(cursor);
                throw th;
            }
            return arrayList;
        }
        return arrayList;
    }

    public void o(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_download" + currentAccount + "(game_id TEXT PRIMARY KEY, game_name TEXT, game_type INTEGER, icon_url TEXT, player_num TEXT, package_link TEXT, package_size TEXT, game_link TEXT, " + PbActivityConfig.KEY_MARK + " INTEGER, bundle_id TEXT, introduce TEXT, launch_component TEXT, andr_pk_name TEXT, day_downloads TEXT, secret_key TEXT, superscript_color TEXT, star INTEGER, category_id INTEGER, " + MangaCategoryActivityConfig.CATEGORY_NAME + " TEXT, version INTEGER, deadline TEXT, editor_rec TEXT, app_id TEXT, current_Time LONG, label INTEGER );");
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameDbHelper.createTables", new Object[0]);
            BdLog.e("create table wrong " + e.toString());
        }
    }
}
