package com.baidu.tbadk.coreExtra.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.game.GameInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d alw;

    private d() {
    }

    public static synchronized d yI() {
        d dVar;
        synchronized (d.class) {
            if (alw == null) {
                alw = new d();
            }
            dVar = alw;
        }
        return dVar;
    }

    public boolean b(GameInfoData gameInfoData) {
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (gameInfoData == null || yF == null || TextUtils.isEmpty(currentAccount) || TextUtils.isEmpty(gameInfoData.getGameId())) {
            return false;
        }
        try {
            o(yF);
            ContentValues contentValues = new ContentValues();
            contentValues.put("game_id", gameInfoData.getGameId());
            contentValues.put("game_package", gameInfoData.getPackageName());
            contentValues.put("game_status", Integer.valueOf(gameInfoData.getUpStatus()));
            contentValues.put("status_up", (Integer) 0);
            if (yF.update("table_game_status" + currentAccount, contentValues, "game_id = ?", new String[]{gameInfoData.getGameId()}) == 0) {
                yF.insert("table_game_status" + currentAccount, null, contentValues);
                return true;
            }
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameStatusDao.addGameInfoItem", new Object[0]);
            return false;
        }
    }

    public boolean v(String str, int i) {
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(str) || yF == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("game_status", Integer.valueOf(i));
            contentValues.put("status_up", (Integer) 0);
            if (yF.update("table_game_status" + currentAccount, contentValues, "game_id = ?", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameStatusDao.updateState", new Object[0]);
        }
        return false;
    }

    public boolean w(String str, int i) {
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(str) || yF == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status_up", (Integer) 1);
            if (yF.update("table_game_status" + currentAccount, contentValues, "game_id = ?", new String[]{str}) > 0) {
                return true;
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameStatusDao.signUpSuccess", new Object[0]);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=4] */
    public boolean es(String str) {
        Cursor cursor;
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (TextUtils.isEmpty(str) || yF == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            cursor = yF.query("table_game_status" + currentAccount, new String[]{"count(*)"}, "game_id = ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.getCount() > 0) {
                            if (yF.delete("table_game_status" + currentAccount, "game_id = ?", new String[]{str}) > 0) {
                                o.a(cursor);
                                return true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GameStatusDao.deleteItem", new Object[0]);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [212=4] */
    public GameInfoData et(String str) {
        Cursor cursor;
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (yF == null || TextUtils.isEmpty(currentAccount)) {
            return null;
        }
        try {
            cursor = yF.query("table_game_status" + currentAccount, null, "game_package= ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            GameInfoData gameInfoData = new GameInfoData();
                            gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("game_id")));
                            gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("game_package")));
                            o.a(cursor);
                            return gameInfoData;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GameStatusDao.getGameItemByPackageName", new Object[0]);
                        o.a(cursor);
                        return null;
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
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [249=4] */
    public GameInfoData eu(String str) {
        Cursor cursor;
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (yF == null || TextUtils.isEmpty(currentAccount)) {
            return null;
        }
        try {
            cursor = yF.query("table_game_status" + currentAccount, null, "game_id= ?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            GameInfoData gameInfoData = new GameInfoData();
                            gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("game_id")));
                            gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("game_package")));
                            gameInfoData.setUpStatus(cursor.getInt(cursor.getColumnIndex("game_status")));
                            gameInfoData.setCurrentStatusUpSuccess(cursor.getInt(cursor.getColumnIndex("status_up")) == 1);
                            o.a(cursor);
                            return gameInfoData;
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GameStatusDao.getGameItemByPackageName", new Object[0]);
                        o.a(cursor);
                        return null;
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
        return null;
    }

    public List<GameInfoData> yJ() {
        Cursor cursor = null;
        SQLiteDatabase yF = b.yF();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (yF == null || TextUtils.isEmpty(currentAccount)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            cursor = yF.query("table_game_status" + currentAccount, null, "status_up= ?", new String[]{"0"}, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    GameInfoData gameInfoData = new GameInfoData();
                    gameInfoData.setGameId(cursor.getString(cursor.getColumnIndex("game_id")));
                    gameInfoData.setPackageName(cursor.getString(cursor.getColumnIndex("game_package")));
                    gameInfoData.setUpStatus(cursor.getInt(cursor.getColumnIndex("game_status")));
                    arrayList.add(gameInfoData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "GameStatusDao.getGameItemByPackageName", new Object[0]);
        } finally {
            o.a(cursor);
        }
        return arrayList;
    }

    public void o(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_game_status" + currentAccount + "(game_id TEXT PRIMARY KEY, game_status INTEGER,game_package TEXT,status_up INTEGER );");
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GameStatusDao.createTable", new Object[0]);
            BdLog.e("create table wrong " + e.toString());
        }
    }
}
