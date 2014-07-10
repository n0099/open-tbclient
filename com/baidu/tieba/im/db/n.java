package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class n {
    private static n a;

    private n() {
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new n();
            }
            nVar = a;
        }
        return nVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [70=5] */
    public synchronized int b() {
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            Cursor cursor = null;
            if (a2 != null) {
                try {
                    cursor = a2.rawQuery("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
                    if (cursor == null || !cursor.moveToNext()) {
                        com.baidu.adp.lib.util.m.a(cursor);
                    } else {
                        i = cursor.getInt(0);
                        com.baidu.adp.lib.util.m.a(cursor);
                    }
                } catch (SQLiteException e) {
                    e.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        }
        return i;
    }

    public synchronized void c() {
        a(g.a());
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase == null) {
            try {
                sQLiteDatabase = g.a();
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.markAllReaded", new Object[0]);
                return;
            }
        }
        if (sQLiteDatabase != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isread", (Integer) 1);
            if (sQLiteDatabase != null) {
                sQLiteDatabase.update("tb_new_friends", contentValues, null, null);
            }
        }
    }

    public synchronized boolean a(long j) {
        return a(g.a(), j);
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.a();
        }
        if (sQLiteDatabase != null) {
            try {
                return sQLiteDatabase.delete("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)}) != 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [158=4] */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r2.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z = true;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.a();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.rawQuery("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                    if (cursor != null) {
                    }
                    z = false;
                    com.baidu.adp.lib.util.m.a(cursor);
                    return z;
                } catch (SQLiteException e) {
                    e.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                    return false;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                    return false;
                }
            } catch (Throwable th) {
                com.baidu.adp.lib.util.m.a(cursor);
                throw th;
            }
        }
        return false;
    }

    public boolean b(long j) {
        return b(g.a(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [202=5] */
    private long b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.a();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor2 = sQLiteDatabase.rawQuery("select * from tb_new_friends", new String[0]);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToNext()) {
                                long j = cursor2.getLong(cursor2.getColumnIndex(SapiAccountManager.SESSION_UID));
                                com.baidu.adp.lib.util.m.a(cursor2);
                                return j;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            cursor3 = cursor2;
                            try {
                                e.printStackTrace();
                                com.baidu.adp.lib.util.m.a(cursor3);
                                return 0L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor3;
                                com.baidu.adp.lib.util.m.a(cursor);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.m.a(cursor2);
                            return 0L;
                        }
                    }
                    com.baidu.adp.lib.util.m.a(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.util.m.a(cursor);
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
                com.baidu.adp.lib.util.m.a(cursor);
                throw th;
            }
        }
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [238=5] */
    private int c(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = g.a();
        }
        Cursor cursor = null;
        try {
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.m.a(cursor);
        }
        if (sQLiteDatabase != null) {
            cursor = sQLiteDatabase.rawQuery("select * from tb_new_friends", new String[0]);
            if (cursor == null || !cursor.moveToFirst()) {
                com.baidu.adp.lib.util.m.a(cursor);
            } else {
                i = cursor.getCount();
            }
        }
        return i;
    }

    public synchronized void a(com.baidu.tieba.im.data.k kVar) {
        SQLiteDatabase a2 = g.a();
        a2.beginTransaction();
        try {
            a(g.a(), kVar);
            a2.setTransactionSuccessful();
            a2.endTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            a2.endTransaction();
        }
    }

    public synchronized void a(List<com.baidu.tieba.im.data.k> list) {
        SQLiteDatabase a2 = g.a();
        a2.beginTransaction();
        try {
            for (com.baidu.tieba.im.data.k kVar : list) {
                a(g.a(), kVar);
            }
            a2.setTransactionSuccessful();
            a2.endTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            a2.endTransaction();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, com.baidu.tieba.im.data.k kVar) {
        if (kVar != null && kVar.a() != 0 && !TextUtils.isEmpty(kVar.b())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = g.a();
            }
            if (sQLiteDatabase != null) {
                a(sQLiteDatabase, kVar.a());
                if (c(sQLiteDatabase) >= 200) {
                    a(b(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SapiAccountManager.SESSION_UID, Long.valueOf(kVar.a()));
                    contentValues.put("uname", kVar.b());
                    contentValues.put("uportrait", kVar.c());
                    contentValues.put("ucontent", kVar.d());
                    contentValues.put("ustatus", Integer.valueOf(kVar.e()));
                    contentValues.put("isread", Integer.valueOf(kVar.f()));
                    sQLiteDatabase.insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [339=4] */
    public synchronized List<com.baidu.tieba.im.data.k> d() {
        ArrayList arrayList;
        Cursor cursor = null;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            arrayList = new ArrayList();
            if (a2 != null) {
                try {
                    try {
                        cursor = a2.rawQuery("select * from tb_new_friends ORDER BY _id DESC", null);
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
                                kVar.a(cursor.getInt(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                                kVar.c(cursor.getString(cursor.getColumnIndex("ucontent")));
                                kVar.b(cursor.getInt(cursor.getColumnIndex("isread")));
                                kVar.a(cursor.getString(cursor.getColumnIndex("uname")));
                                kVar.b(cursor.getString(cursor.getColumnIndex("uportrait")));
                                kVar.a(cursor.getInt(cursor.getColumnIndex("ustatus")));
                                arrayList.add(kVar);
                            }
                        }
                        com.baidu.adp.lib.util.m.a(cursor);
                    } catch (Exception e) {
                        e.printStackTrace();
                        com.baidu.adp.lib.util.m.a(cursor);
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        }
        return arrayList;
    }

    public synchronized int b(com.baidu.tieba.im.data.k kVar) {
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                a2.beginTransaction();
                try {
                    if (b(a2, kVar.a())) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("ustatus", Integer.valueOf(kVar.e()));
                        contentValues.put("isread", Integer.valueOf(kVar.f()));
                        int update = a2.update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(kVar.a())});
                        try {
                            a2.setTransactionSuccessful();
                            i = update;
                        } catch (Exception e) {
                            i = update;
                            e = e;
                            e.printStackTrace();
                            a2.endTransaction();
                            return i;
                        }
                    } else {
                        a(a2, kVar);
                        a2.setTransactionSuccessful();
                    }
                    a2.endTransaction();
                } catch (Exception e2) {
                    e = e2;
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [416=4] */
    public synchronized List<com.baidu.tieba.im.data.k> e() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        SQLiteDatabase a2 = g.a();
        if (a2 != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = a2.rawQuery("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
                            kVar.a(cursor.getInt(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                            kVar.c(cursor.getString(cursor.getColumnIndex("ucontent")));
                            kVar.b(cursor.getInt(cursor.getColumnIndex("isread")));
                            kVar.a(cursor.getString(cursor.getColumnIndex("uname")));
                            kVar.b(cursor.getString(cursor.getColumnIndex("uportrait")));
                            kVar.a(cursor.getInt(cursor.getColumnIndex("ustatus")));
                            arrayList.add(kVar);
                        }
                        a(a2);
                    }
                    com.baidu.adp.lib.util.m.a(cursor);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            } catch (SQLiteException e2) {
                e2.printStackTrace();
                com.baidu.adp.lib.util.m.a(cursor);
            }
        }
        return arrayList;
    }
}
