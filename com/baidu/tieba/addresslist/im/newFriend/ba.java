package com.baidu.tieba.addresslist.im.newFriend;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ba {
    private static ba aAu;

    private ba() {
    }

    public static synchronized ba FW() {
        ba baVar;
        synchronized (ba.class) {
            if (aAu == null) {
                aAu = new ba();
            }
            baVar = aAu;
        }
        return baVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [71=5] */
    public int FX() {
        int i = 0;
        Cursor cursor = null;
        try {
            cursor = com.baidu.tieba.im.db.g.Rq().rawQuery("select count(*) from tb_new_friends WHERE  ( isread=? and ustatus=? ) or (isread=? and ustatus=? )", new String[]{String.valueOf(0), String.valueOf(1), String.valueOf(0), String.valueOf(4)});
            if (cursor != null && cursor.moveToNext()) {
                i = cursor.getInt(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.w.b(cursor);
        }
        return i;
    }

    public void FY() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("isread", (Integer) 1);
        com.baidu.tieba.im.db.g.Rq().update("tb_new_friends", contentValues, null, null);
    }

    public boolean H(long j) {
        return a(com.baidu.tieba.im.db.f.Ro(), j);
    }

    private boolean a(SQLiteDatabase sQLiteDatabase, long j) {
        try {
            return com.baidu.tieba.im.db.g.Rq().a("tb_new_friends", "uid = ?", new String[]{String.valueOf(j)});
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [133=4] */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (r2.moveToFirst() != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean b(SQLiteDatabase sQLiteDatabase, long j) {
        boolean z = true;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = com.baidu.tieba.im.db.f.Ro();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = com.baidu.tieba.im.db.g.Rq().rawQuery("select * from tb_new_friends WHERE uid=?", new String[]{String.valueOf(j)});
                        if (cursor != null) {
                        }
                        z = false;
                        com.baidu.adp.lib.util.w.b(cursor);
                        return z;
                    } catch (Exception e) {
                        e.printStackTrace();
                        com.baidu.adp.lib.util.w.b(cursor);
                        return false;
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.w.b(cursor);
                    return false;
                }
            } catch (Throwable th) {
                com.baidu.adp.lib.util.w.b(cursor);
                throw th;
            }
        }
        return false;
    }

    public boolean I(long j) {
        return b(com.baidu.tieba.im.db.f.Ro(), j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [176=5] */
    private long p(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Cursor cursor2;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = com.baidu.tieba.im.db.f.Ro();
        }
        if (sQLiteDatabase != null) {
            Cursor cursor3 = null;
            try {
                try {
                    cursor2 = com.baidu.tieba.im.db.g.Rq().rawQuery("select * from tb_new_friends", new String[0]);
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToNext()) {
                                long j = cursor2.getLong(cursor2.getColumnIndex("uid"));
                                com.baidu.adp.lib.util.w.b(cursor2);
                                return j;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            cursor3 = cursor2;
                            try {
                                e.printStackTrace();
                                com.baidu.adp.lib.util.w.b(cursor3);
                                return 0L;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor3;
                                com.baidu.adp.lib.util.w.b(cursor);
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            com.baidu.adp.lib.util.w.b(cursor2);
                            return 0L;
                        }
                    }
                    com.baidu.adp.lib.util.w.b(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.util.w.b(cursor);
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
                com.baidu.adp.lib.util.w.b(cursor);
                throw th;
            }
        }
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [211=5] */
    private int q(SQLiteDatabase sQLiteDatabase) {
        int i = 0;
        if (sQLiteDatabase == null) {
            sQLiteDatabase = com.baidu.tieba.im.db.f.Ro();
        }
        Cursor cursor = null;
        try {
        } catch (SQLiteException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.w.b(cursor);
        }
        if (sQLiteDatabase != null) {
            cursor = com.baidu.tieba.im.db.g.Rq().rawQuery("select * from tb_new_friends", new String[0]);
            if (cursor == null || !cursor.moveToFirst()) {
                com.baidu.adp.lib.util.w.b(cursor);
            } else {
                i = cursor.getCount();
            }
        }
        return i;
    }

    public void g(com.baidu.tieba.im.data.b bVar) {
        try {
            a(com.baidu.tieba.im.db.f.Ro(), bVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void z(List<com.baidu.tieba.im.data.b> list) {
        try {
            for (com.baidu.tieba.im.data.b bVar : list) {
                a(com.baidu.tieba.im.db.f.Ro(), bVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, com.baidu.tieba.im.data.b bVar) {
        if (bVar != null && bVar.getId() != 0 && !TextUtils.isEmpty(bVar.getName())) {
            if (sQLiteDatabase == null) {
                sQLiteDatabase = com.baidu.tieba.im.db.f.Ro();
            }
            if (sQLiteDatabase != null) {
                a(sQLiteDatabase, bVar.getId());
                if (q(sQLiteDatabase) >= 200) {
                    H(p(sQLiteDatabase));
                }
                if (sQLiteDatabase != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("uid", Long.valueOf(bVar.getId()));
                    contentValues.put("uname", bVar.getName());
                    contentValues.put("uportrait", bVar.getPortrait());
                    contentValues.put("ucontent", bVar.getContent());
                    contentValues.put("ustatus", Integer.valueOf(bVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(bVar.Rb()));
                    com.baidu.tieba.im.db.g.Rq().insert("tb_new_friends", null, contentValues);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [296=4] */
    public List<com.baidu.tieba.im.data.b> FZ() {
        Cursor cursor = null;
        SQLiteDatabase Ro = com.baidu.tieba.im.db.f.Ro();
        ArrayList arrayList = new ArrayList();
        try {
            if (Ro != null) {
                cursor = com.baidu.tieba.im.db.g.Rq().rawQuery("select * from tb_new_friends ORDER BY _id DESC", null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                        bVar.setId(cursor.getInt(cursor.getColumnIndex("uid")));
                        bVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                        bVar.fY(cursor.getInt(cursor.getColumnIndex("isread")));
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
            com.baidu.adp.lib.util.w.b(cursor);
        }
        return arrayList;
    }

    public int h(com.baidu.tieba.im.data.b bVar) {
        int i = 0;
        SQLiteDatabase Ro = com.baidu.tieba.im.db.f.Ro();
        if (Ro != null) {
            try {
                if (b(Ro, bVar.getId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ustatus", Integer.valueOf(bVar.getStatus()));
                    contentValues.put("isread", Integer.valueOf(bVar.Rb()));
                    i = com.baidu.tieba.im.db.g.Rq().update("tb_new_friends", contentValues, "uid=?", new String[]{String.valueOf(bVar.getId())});
                } else {
                    a(Ro, bVar);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [358=4] */
    public List<com.baidu.tieba.im.data.b> Ga() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = com.baidu.tieba.im.db.g.Rq().rawQuery("select * from tb_new_friends WHERE isread=? ORDER BY _id DESC", new String[]{String.valueOf(0)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    com.baidu.tieba.im.data.b bVar = new com.baidu.tieba.im.data.b();
                    bVar.setId(cursor.getInt(cursor.getColumnIndex("uid")));
                    bVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    bVar.fY(cursor.getInt(cursor.getColumnIndex("isread")));
                    bVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                    bVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                    bVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    arrayList.add(bVar);
                }
                FY();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.w.b(cursor);
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [392=4] */
    public synchronized com.baidu.tieba.im.data.b J(long j) {
        com.baidu.tieba.im.data.b bVar;
        bVar = new com.baidu.tieba.im.data.b();
        Cursor cursor = null;
        try {
            try {
                cursor = com.baidu.tieba.im.db.g.Rq().rawQuery("select * from tb_new_friends where uid=?", new String[]{String.valueOf(j)});
                if (cursor != null && cursor.moveToNext()) {
                    bVar.fY(cursor.getInt(cursor.getColumnIndex("isread")));
                    bVar.setStatus(cursor.getInt(cursor.getColumnIndex("ustatus")));
                    bVar.setContent(cursor.getString(cursor.getColumnIndex("ucontent")));
                    bVar.setName(cursor.getString(cursor.getColumnIndex("uname")));
                    bVar.setPortrait(cursor.getString(cursor.getColumnIndex("uportrait")));
                }
                com.baidu.adp.lib.util.w.b(cursor);
            } catch (SQLiteException e) {
                e.printStackTrace();
                com.baidu.adp.lib.util.w.b(cursor);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            com.baidu.adp.lib.util.w.b(cursor);
        }
        return bVar;
    }
}
