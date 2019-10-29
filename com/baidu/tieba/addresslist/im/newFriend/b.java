package com.baidu.tieba.addresslist.im.newFriend;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.adp.lib.util.n;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.db.g;
import com.baidu.tieba.im.db.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private static b dkA;

    private b() {
    }

    public static synchronized b aEl() {
        b bVar;
        synchronized (b.class) {
            if (dkA == null) {
                dkA = new b();
            }
            bVar = dkA;
        }
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [72=4] */
    public int aEm() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = h.bAs().rawQuery("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            n.close(cursor);
        }
        return i;
    }

    public void aEn() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", (Integer) 1);
        h.bAs().a("tb_new_friends", contentValues, null, null);
    }

    public boolean bJ(long j) {
        return a(g.bAq(), j);
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        try {
            return h.bAs().a("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r2.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z = true;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.bAq();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = h.bAs().rawQuery("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null) {
                    }
                    z = false;
                    n.close(cursor);
                    return z;
                } catch (SQLiteException e) {
                    e.printStackTrace();
                    n.close(cursor);
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    n.close(cursor);
                    return false;
                }
            } catch (Throwable th) {
                n.close(cursor);
                throw th;
            }
        }
        return false;
    }

    public boolean bK(long j) {
        return b(g.bAq(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [177=4] */
    private long G(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.bAq();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor2 = h.bAs().rawQuery("select * from tb_new_friends", new String[0]);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToNext()) {
                                long j = cursor2.getLong(cursor2.getColumnIndex("uid"));
                                n.close(cursor2);
                                return j;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            cursor3 = cursor2;
                            try {
                                e.printStackTrace();
                                n.close(cursor3);
                                return 0L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor3;
                                n.close(cursor);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            n.close(cursor2);
                            return 0L;
                        }
                    }
                    n.close(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                    n.close(cursor);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
                cursor2 = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
                n.close(cursor);
                throw th;
            }
        }
        return 0L;
    }

    private int H(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.bAq();
        }
        Cursor cursor = null;
        try {
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            n.close(cursor);
        }
        if (sQLiteDatabase != null) {
            cursor = h.bAs().rawQuery("select * from tb_new_friends", new String[0]);
            if (cursor == null || !cursor.moveToFirst()) {
                n.close(cursor);
            } else {
                i = cursor.getCount();
            }
        }
        return i;
    }

    public void g(com.baidu.tieba.im.data.a aVar) {
        try {
            a(g.bAq(), aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aV(List<com.baidu.tieba.im.data.a> list) {
        try {
            for (com.baidu.tieba.im.data.a aVar : list) {
                a(g.bAq(), aVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, com.baidu.tieba.im.data.a aVar) throws Exception {
        if (aVar != null && aVar.getId() != 0 && !TextUtils.isEmpty(aVar.getName())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = g.bAq();
            }
            if (sQLiteDatabase != null) {
                a(sQLiteDatabase, aVar.getId());
                if (H(sQLiteDatabase) >= 200) {
                    bJ(G(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", Long.valueOf(aVar.getId()));
                    contentValues.put(BdStatsConstant.StatsKey.UNAME, aVar.getName());
                    contentValues.put("uportrait", aVar.getPortrait());
                    contentValues.put("ucontent", aVar.getContent());
                    contentValues.put("ustatus", Integer.valueOf(aVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(aVar.bAc()));
                    h.bAs().a("tb_new_friends", (String) null, contentValues);
                }
            }
        }
    }

    public List<com.baidu.tieba.im.data.a> aEo() {
        Cursor cursor = null;
        SQLiteDatabase bAq = g.bAq();
        ArrayList arrayList = new ArrayList();
        try {
            if (bAq != null) {
                cursor = h.bAs().rawQuery("select * from tb_new_friends ORDER BY _id DESC", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                        aVar.setId(cursor.getLong(cursor.getColumnIndex("uid")));
                        if (aVar.getId() < 0) {
                            i(aVar);
                        }
                        aVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                        aVar.tW(cursor.getInt(cursor.getColumnIndex("isread")));
                        aVar.setName(cursor.getString(cursor.getColumnIndex(BdStatsConstant.StatsKey.UNAME)));
                        aVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                        aVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        arrayList.add(aVar);
                    }
                }
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            n.close(cursor);
        }
        return arrayList;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0054 -> B:15:0x004e). Please submit an issue!!! */
    public int h(com.baidu.tieba.im.data.a aVar) {
        int i = 0;
        SQLiteDatabase bAq = g.bAq();
        if (bAq != null) {
            try {
                if (b(bAq, aVar.getId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ustatus", Integer.valueOf(aVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(aVar.bAc()));
                    i = h.bAs().a("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(aVar.getId())});
                } else {
                    a(bAq, aVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    private int i(com.baidu.tieba.im.data.a aVar) {
        int i = 0;
        SQLiteDatabase bAq = g.bAq();
        if (bAq != null) {
            try {
                if (b(bAq, aVar.getId())) {
                    ContentValues contentValues = new ContentValues();
                    long correctUserIdAfterOverflowCut = UtilHelper.getCorrectUserIdAfterOverflowCut(aVar.getId());
                    contentValues.put("uid", Long.valueOf(correctUserIdAfterOverflowCut));
                    i = h.bAs().a("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(aVar.getId())});
                    aVar.setId(correctUserIdAfterOverflowCut);
                    return i;
                }
                return 0;
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return 0;
    }

    public List<com.baidu.tieba.im.data.a> aEp() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = h.bAs().rawQuery("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    com.baidu.tieba.im.data.a aVar = new com.baidu.tieba.im.data.a();
                    aVar.setId(cursor.getLong(cursor.getColumnIndex("uid")));
                    aVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    aVar.tW(cursor.getInt(cursor.getColumnIndex("isread")));
                    aVar.setName(cursor.getString(cursor.getColumnIndex(BdStatsConstant.StatsKey.UNAME)));
                    aVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                    aVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    arrayList.add(aVar);
                }
                aEn();
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            n.close(cursor);
        }
        return arrayList;
    }

    public synchronized com.baidu.tieba.im.data.a bL(long j) {
        com.baidu.tieba.im.data.a aVar;
        aVar = new com.baidu.tieba.im.data.a();
        Cursor cursor = null;
        try {
            try {
                cursor = h.bAs().rawQuery("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                if (cursor != null && cursor.moveToNext()) {
                    aVar.tW(cursor.getInt(cursor.getColumnIndex("isread")));
                    aVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    aVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    aVar.setName(cursor.getString(cursor.getColumnIndex(BdStatsConstant.StatsKey.UNAME)));
                    aVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                }
                n.close(cursor);
            } catch (Exception e) {
                e.printStackTrace();
                n.close(cursor);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
            n.close(cursor);
        }
        return aVar;
    }
}
