package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.sapi2.SapiAccountManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m {
    private static m aYo;

    private m() {
    }

    public static synchronized m Ne() {
        m mVar;
        synchronized (m.class) {
            if (aYo == null) {
                aYo = new m();
            }
            mVar = aYo;
        }
        return mVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [68=5] */
    public int Nf() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = g.MU().rawQuery("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return i;
    }

    public void Ng() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", (Integer) 1);
        g.MU().update("tb_new_friends", contentValues, null, null);
    }

    public boolean V(long j) {
        return a(f.MS(), j);
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        try {
            return g.MU().a("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [130=4] */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r2.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z = true;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.MS();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = g.MU().rawQuery("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                        if (cursor != null) {
                        }
                        z = false;
                        t.b(cursor);
                        return z;
                    } catch (Exception e) {
                        e.printStackTrace();
                        t.b(cursor);
                        return false;
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                    t.b(cursor);
                    return false;
                }
            } catch (Throwable th) {
                t.b(cursor);
                throw th;
            }
        }
        return false;
    }

    public boolean W(long j) {
        return b(f.MS(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=5] */
    private long C(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.MS();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor2 = g.MU().rawQuery("select * from tb_new_friends", new String[0]);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToNext()) {
                                long j = cursor2.getLong(cursor2.getColumnIndex(SapiAccountManager.SESSION_UID));
                                t.b(cursor2);
                                return j;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            cursor3 = cursor2;
                            try {
                                e.printStackTrace();
                                t.b(cursor3);
                                return 0L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor3;
                                t.b(cursor);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            t.b(cursor2);
                            return 0L;
                        }
                    }
                    t.b(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                    t.b(cursor);
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
                t.b(cursor);
                throw th;
            }
        }
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=5] */
    private int D(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.MS();
        }
        Cursor cursor = null;
        try {
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            t.b(cursor);
        }
        if (sQLiteDatabase != null) {
            cursor = g.MU().rawQuery("select * from tb_new_friends", new String[0]);
            if (cursor == null || !cursor.moveToFirst()) {
                t.b(cursor);
            } else {
                i = cursor.getCount();
            }
        }
        return i;
    }

    public void b(com.baidu.tieba.im.data.b bVar) {
        try {
            a(f.MS(), bVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ar(List<com.baidu.tieba.im.data.b> list) {
        try {
            for (com.baidu.tieba.im.data.b bVar : list) {
                a(f.MS(), bVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null && bVar.getId() != 0 && !TextUtils.isEmpty(bVar.getName())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = f.MS();
            }
            if (sQLiteDatabase != null) {
                a(sQLiteDatabase, bVar.getId());
                if (D(sQLiteDatabase) >= 200) {
                    V(C(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SapiAccountManager.SESSION_UID, Long.valueOf(bVar.getId()));
                    contentValues.put("uname", bVar.getName());
                    contentValues.put("uportrait", bVar.getPortrait());
                    contentValues.put("ucontent", bVar.getContent());
                    contentValues.put("ustatus", Integer.valueOf(bVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(bVar.MF()));
                    g.MU().insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [293=4] */
    public List<com.baidu.tieba.im.data.b> Nh() {
        Cursor cursor = null;
        SQLiteDatabase MS = f.MS();
        ArrayList arrayList = new ArrayList();
        try {
            if (MS != null) {
                cursor = g.MU().rawQuery("select * from tb_new_friends ORDER BY _id DESC", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                        bVar.setId(cursor.getInt(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                        bVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                        bVar.fE(cursor.getInt(cursor.getColumnIndex("isread")));
                        bVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                        bVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                        bVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        arrayList.add(bVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return arrayList;
    }

    public int c(com.baidu.tieba.im.data.b bVar) {
        int i = 0;
        SQLiteDatabase MS = f.MS();
        if (MS != null) {
            try {
                if (b(MS, bVar.getId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ustatus", Integer.valueOf(bVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(bVar.MF()));
                    i = g.MU().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(bVar.getId())});
                } else {
                    a(MS, bVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=4] */
    public List<com.baidu.tieba.im.data.b> Ni() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = g.MU().rawQuery("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                    bVar.setId(cursor.getInt(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                    bVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    bVar.fE(cursor.getInt(cursor.getColumnIndex("isread")));
                    bVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                    bVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                    bVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    arrayList.add(bVar);
                }
                Ng();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [389=4] */
    public synchronized com.baidu.tieba.im.data.b X(long j) {
        com.baidu.tieba.im.data.b bVar;
        bVar = new com.baidu.tieba.im.data.b();
        Cursor cursor = null;
        try {
            try {
                cursor = g.MU().rawQuery("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                if (cursor != null && cursor.moveToNext()) {
                    bVar.fE(cursor.getInt(cursor.getColumnIndex("isread")));
                    bVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    bVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    bVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                    bVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                }
                t.b(cursor);
            } catch (SQLiteException e) {
                e.printStackTrace();
                t.b(cursor);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            t.b(cursor);
        }
        return bVar;
    }
}
