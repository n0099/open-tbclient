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
    private static m aVA;

    private m() {
    }

    public static synchronized m MO() {
        m mVar;
        synchronized (m.class) {
            if (aVA == null) {
                aVA = new m();
            }
            mVar = aVA;
        }
        return mVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [68=5] */
    public int MP() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = g.ME().rawQuery("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.p.a(cursor);
        }
        return i;
    }

    public void MQ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", (Integer) 1);
        g.ME().update("tb_new_friends", contentValues, null, null);
    }

    public boolean O(long j) {
        return a(f.MC(), j);
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        try {
            return g.ME().a("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
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
            sQLiteDatabase = f.MC();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = g.ME().rawQuery("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                        if (cursor != null) {
                        }
                        z = false;
                        com.baidu.adp.lib.util.p.a(cursor);
                        return z;
                    } catch (Exception e) {
                        e.printStackTrace();
                        com.baidu.adp.lib.util.p.a(cursor);
                        return false;
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.p.a(cursor);
                    return false;
                }
            } catch (Throwable th) {
                com.baidu.adp.lib.util.p.a(cursor);
                throw th;
            }
        }
        return false;
    }

    public boolean P(long j) {
        return b(f.MC(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=5] */
    private long y(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.MC();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor2 = g.ME().rawQuery("select * from tb_new_friends", new String[0]);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToNext()) {
                                long j = cursor2.getLong(cursor2.getColumnIndex(SapiAccountManager.SESSION_UID));
                                com.baidu.adp.lib.util.p.a(cursor2);
                                return j;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            cursor3 = cursor2;
                            try {
                                e.printStackTrace();
                                com.baidu.adp.lib.util.p.a(cursor3);
                                return 0L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor3;
                                com.baidu.adp.lib.util.p.a(cursor);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.p.a(cursor2);
                            return 0L;
                        }
                    }
                    com.baidu.adp.lib.util.p.a(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.util.p.a(cursor);
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
                com.baidu.adp.lib.util.p.a(cursor);
                throw th;
            }
        }
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [208=5] */
    private int z(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = f.MC();
        }
        Cursor cursor = null;
        try {
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.p.a(cursor);
        }
        if (sQLiteDatabase != null) {
            cursor = g.ME().rawQuery("select * from tb_new_friends", new String[0]);
            if (cursor == null || !cursor.moveToFirst()) {
                com.baidu.adp.lib.util.p.a(cursor);
            } else {
                i = cursor.getCount();
            }
        }
        return i;
    }

    public void a(com.baidu.tieba.im.data.e eVar) {
        try {
            a(f.MC(), eVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void U(List<com.baidu.tieba.im.data.e> list) {
        try {
            for (com.baidu.tieba.im.data.e eVar : list) {
                a(f.MC(), eVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, com.baidu.tieba.im.data.e eVar) {
        if (eVar != null && eVar.getId() != 0 && !TextUtils.isEmpty(eVar.getName())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = f.MC();
            }
            if (sQLiteDatabase != null) {
                a(sQLiteDatabase, eVar.getId());
                if (z(sQLiteDatabase) >= 200) {
                    O(y(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(SapiAccountManager.SESSION_UID, Long.valueOf(eVar.getId()));
                    contentValues.put("uname", eVar.getName());
                    contentValues.put("uportrait", eVar.getPortrait());
                    contentValues.put("ucontent", eVar.getContent());
                    contentValues.put("ustatus", Integer.valueOf(eVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(eVar.Mr()));
                    g.ME().insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [293=4] */
    public List<com.baidu.tieba.im.data.e> MR() {
        Cursor cursor = null;
        SQLiteDatabase MC = f.MC();
        ArrayList arrayList = new ArrayList();
        try {
            if (MC != null) {
                cursor = g.ME().rawQuery("select * from tb_new_friends ORDER BY _id DESC", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                        eVar.setId(cursor.getInt(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                        eVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                        eVar.fw(cursor.getInt(cursor.getColumnIndex("isread")));
                        eVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                        eVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                        eVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                        arrayList.add(eVar);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.p.a(cursor);
        }
        return arrayList;
    }

    public int b(com.baidu.tieba.im.data.e eVar) {
        int i = 0;
        SQLiteDatabase MC = f.MC();
        if (MC != null) {
            try {
                if (b(MC, eVar.getId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ustatus", Integer.valueOf(eVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(eVar.Mr()));
                    i = g.ME().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(eVar.getId())});
                } else {
                    a(MC, eVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [355=4] */
    public List<com.baidu.tieba.im.data.e> MS() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = g.ME().rawQuery("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    com.baidu.tieba.im.data.e eVar = new com.baidu.tieba.im.data.e();
                    eVar.setId(cursor.getInt(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                    eVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    eVar.fw(cursor.getInt(cursor.getColumnIndex("isread")));
                    eVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                    eVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                    eVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    arrayList.add(eVar);
                }
                MQ();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.p.a(cursor);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [389=4] */
    public synchronized com.baidu.tieba.im.data.e Q(long j) {
        com.baidu.tieba.im.data.e eVar;
        eVar = new com.baidu.tieba.im.data.e();
        Cursor cursor = null;
        try {
            try {
                cursor = g.ME().rawQuery("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                if (cursor != null && cursor.moveToNext()) {
                    eVar.fw(cursor.getInt(cursor.getColumnIndex("isread")));
                    eVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    eVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    eVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                    eVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                }
                com.baidu.adp.lib.util.p.a(cursor);
            } catch (SQLiteException e) {
                e.printStackTrace();
                com.baidu.adp.lib.util.p.a(cursor);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.adp.lib.util.p.a(cursor);
        }
        return eVar;
    }
}
