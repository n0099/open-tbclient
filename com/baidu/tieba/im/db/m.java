package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static m a;

    private m() {
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (a == null) {
                a = new m();
            }
            mVar = a;
        }
        return mVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [68=5] */
    public int b() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = g.a().a("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.m.a(cursor);
        }
        return i;
    }

    public void c() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", (Integer) 1);
        g.a().a("tb_new_friends", contentValues, null, null);
    }

    public boolean a(long j) {
        return a(f.a(), j);
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        try {
            return g.a().a("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        if (r2.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z = true;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.a();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = g.a().a("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
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
        return b(f.a(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=5] */
    private long a(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.a();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor2 = g.a().a("select * from tb_new_friends", new String[0]);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=5] */
    private int b(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.a();
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
            cursor = g.a().a("select * from tb_new_friends", new String[0]);
            if (cursor == null || !cursor.moveToFirst()) {
                com.baidu.adp.lib.util.m.a(cursor);
            } else {
                i = cursor.getCount();
            }
        }
        return i;
    }

    public void a(com.baidu.tieba.im.data.k kVar) {
        try {
            a(f.a(), kVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(List<com.baidu.tieba.im.data.k> list) {
        try {
            for (com.baidu.tieba.im.data.k kVar : list) {
                a(f.a(), kVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, com.baidu.tieba.im.data.k kVar) {
        if (kVar != null && kVar.a() != 0 && !TextUtils.isEmpty(kVar.b())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = f.a();
            }
            if (sQLiteDatabase != null) {
                a(sQLiteDatabase, kVar.a());
                if (b(sQLiteDatabase) >= 200) {
                    a(a(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SapiAccountManager.SESSION_UID, Long.valueOf(kVar.a()));
                    contentValues.put("uname", kVar.b());
                    contentValues.put("uportrait", kVar.c());
                    contentValues.put("ucontent", kVar.d());
                    contentValues.put("ustatus", Integer.valueOf(kVar.e()));
                    contentValues.put("isread", Integer.valueOf(kVar.f()));
                    g.a().a("tb_new_friends", (String) null, contentValues);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [293=4] */
    public List<com.baidu.tieba.im.data.k> d() {
        Cursor cursor = null;
        SQLiteDatabase a2 = f.a();
        ArrayList arrayList = new ArrayList();
        try {
            if (a2 != null) {
                cursor = g.a().a("select * from tb_new_friends ORDER BY _id DESC", null);
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.m.a(cursor);
        }
        return arrayList;
    }

    public int b(com.baidu.tieba.im.data.k kVar) {
        int i = 0;
        SQLiteDatabase a2 = f.a();
        if (a2 != null) {
            try {
                if (b(a2, kVar.a())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ustatus", Integer.valueOf(kVar.e()));
                    contentValues.put("isread", Integer.valueOf(kVar.f()));
                    i = g.a().a("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(kVar.a())});
                } else {
                    a(a2, kVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=4] */
    public List<com.baidu.tieba.im.data.k> e() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = g.a().a("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
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
                c();
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.m.a(cursor);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [389=4] */
    public synchronized com.baidu.tieba.im.data.k c(long j) {
        com.baidu.tieba.im.data.k kVar;
        kVar = new com.baidu.tieba.im.data.k();
        Cursor cursor = null;
        try {
            try {
                cursor = g.a().a("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                if (cursor != null && cursor.moveToNext()) {
                    kVar.b(cursor.getInt(cursor.getColumnIndex("isread")));
                    kVar.a(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    kVar.c(cursor.getString(cursor.getColumnIndex("ucontent")));
                    kVar.a(cursor.getString(cursor.getColumnIndex("uname")));
                    kVar.b(cursor.getString(cursor.getColumnIndex("uportrait")));
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
        return kVar;
    }
}
