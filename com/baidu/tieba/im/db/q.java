package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.r;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class q {
    private static q b;
    private AtomicInteger c = new AtomicInteger(0);
    List<String> a = null;

    private q() {
    }

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (b == null) {
                b = new q();
            }
            qVar = b;
        }
        return qVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [76=4] */
    public final synchronized int b() {
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a = g.a();
            Cursor cursor = null;
            if (a != null) {
                try {
                    String str = "select personal_gid from tb_personal_id";
                    com.baidu.adp.lib.util.e.e("sql:" + str);
                    cursor = a.rawQuery(str, new String[0]);
                    if (cursor != null && cursor.moveToNext()) {
                        i = cursor.getInt(0);
                    }
                    r.a(cursor);
                } catch (SQLiteException e) {
                    cb.a(e, "PersonalMsgDao.getPersonalGidSync", new Object[0]);
                    e.printStackTrace();
                    r.a(cursor);
                } catch (Exception e2) {
                    cb.a(e2, "PersonalMsgDao.getPersonalGidSync", new Object[0]);
                    e2.printStackTrace();
                    r.a(cursor);
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4] */
    public final synchronized void a(int i) {
        SQLiteDatabase a = g.a();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("personal_gid", Integer.valueOf(i));
                if (a != null) {
                    int update = a.update("tb_personal_id", contentValues, null, null);
                    com.baidu.adp.lib.util.e.e("num:" + update);
                    if (update == 0) {
                        a.insert("tb_personal_id", null, contentValues);
                    }
                }
                r.a((Cursor) null);
            } catch (Exception e) {
                cb.a(e, "PersonalMsgDao.setPersonalGidSync", new Object[0]);
                e.printStackTrace();
                r.a((Cursor) null);
            }
        } catch (SQLiteException e2) {
            cb.a(e2, "PersonalMsgDao.setPersonalGidSync", new Object[0]);
            e2.printStackTrace();
            r.a((Cursor) null);
        }
    }

    public final synchronized void a(String str) {
        ContentValues contentValues;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.util.e.e("uid:" + str);
            try {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = g.a();
                new ContentValues().put("read_flag", (Integer) 0);
                if (a != null) {
                    com.baidu.adp.lib.util.e.e("num:" + a.update(str2, contentValues, null, null));
                }
            } catch (Exception e) {
                cb.a(e, "PersonalMsgDao.markAllReaded", new Object[0]);
                e.printStackTrace();
                e(str);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [234=5] */
    public final synchronized long b(String str) {
        Cursor cursor = null;
        long j = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = g.a();
                if (a != null) {
                    try {
                        String str3 = "select max(mid) from " + str2;
                        com.baidu.adp.lib.util.e.e("sql:" + str3);
                        cursor = a.rawQuery(str3, null);
                        if (cursor == null || !cursor.moveToNext()) {
                            r.a(cursor);
                        } else {
                            j = cursor.getLong(0);
                            r.a(cursor);
                        }
                    } catch (SQLiteException e) {
                        cb.a(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        e(str);
                        r.a(cursor);
                    } catch (Exception e2) {
                        cb.a(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                        e2.printStackTrace();
                        r.a(cursor);
                    }
                }
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [310=5] */
    public final synchronized CommonMsgPojo c(String str) {
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = g.a();
                try {
                    if (a != null) {
                        try {
                            String str3 = "select * from " + str2 + " WHERE is_delete=? ORDER BY mid DESC LIMIT 1";
                            com.baidu.adp.lib.util.e.e("sql:" + str3);
                            cursor = a.rawQuery(str3, new String[]{String.valueOf(0)});
                            try {
                                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    r.a(cursor);
                                } else {
                                    commonMsgPojo2.setGid(str);
                                    commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                                    commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                    commonMsgPojo2.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                                    commonMsgPojo2.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                                    commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                    commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                    commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                    commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                    commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                    commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                    commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                    commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                    commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                    r.a(cursor);
                                    commonMsgPojo = commonMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                cb.a(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                                e.printStackTrace();
                                e(str);
                                r.a(cursor);
                                return commonMsgPojo;
                            } catch (Exception e2) {
                                e = e2;
                                cb.a(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                                e.printStackTrace();
                                r.a(cursor);
                                return commonMsgPojo;
                            }
                        } catch (SQLiteException e3) {
                            e = e3;
                            cursor = null;
                        } catch (Exception e4) {
                            e = e4;
                            cursor = null;
                        } catch (Throwable th) {
                            cursor = null;
                            th = th;
                            r.a(cursor);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return commonMsgPojo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [385=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0138 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.StringBuilder] */
    public final synchronized LinkedList<String> a(String str, int i, String str2, int i2) {
        Throwable th;
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        LinkedList<String> linkedList = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                LinkedList<String> linkedList2 = new LinkedList<>();
                ?? r2 = "tb_private_msg_" + str;
                SQLiteDatabase a = g.a();
                if (a == null) {
                    linkedList = linkedList2;
                } else {
                    try {
                        try {
                            if (TextUtils.isEmpty(null)) {
                                String str3 = "select * from " + r2 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT 1000";
                                com.baidu.adp.lib.util.e.e("sql:" + str3);
                                cursor = a.rawQuery(str3, new String[]{String.valueOf(2), String.valueOf(0)});
                            } else {
                                String str4 = "select * from " + r2 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT 1000";
                                com.baidu.adp.lib.util.e.e("sql:" + str4);
                                cursor = a.rawQuery(str4, new String[]{null, String.valueOf(2), String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        linkedList2.add(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        cb.a(e2, new StringBuilder("PersonalMsgDao.getAllByMsgType2").toString(), new Object[0]);
                                        e2.printStackTrace();
                                        e(str);
                                        r.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        cb.a(e, new StringBuilder("PersonalMsgDao.getAllByMsgType2").toString(), new Object[0]);
                                        e.printStackTrace();
                                        r.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    }
                                }
                            }
                            r.a(cursor);
                        } catch (Throwable th2) {
                            th = th2;
                            r.a((Cursor) r2);
                            throw th;
                        }
                    } catch (SQLiteException e5) {
                        cursor = null;
                        e2 = e5;
                    } catch (Exception e6) {
                        cursor = null;
                        e = e6;
                    } catch (Throwable th3) {
                        r2 = 0;
                        th = th3;
                        r.a((Cursor) r2);
                        throw th;
                    }
                    linkedList = linkedList2;
                }
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [499=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x023c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.StringBuilder] */
    public final synchronized LinkedList<CommonMsgPojo> a(long j, String str, String str2, int i) {
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        LinkedList<CommonMsgPojo> linkedList = null;
        synchronized (this) {
            if (j != 0) {
                String valueOf = String.valueOf(j);
                if (i <= 0) {
                    i = 20;
                }
                LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
                ?? r2 = "tb_private_msg_" + valueOf;
                SQLiteDatabase a = g.a();
                try {
                    if (a == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (!TextUtils.isEmpty(str2) && !SocialConstants.FALSE.equals(str2)) {
                                String str3 = "select * from " + r2 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.e.e("sql:" + str3);
                                cursor = a.rawQuery(str3, new String[]{str2, String.valueOf(0)});
                            } else if (TextUtils.isEmpty(str)) {
                                String str4 = "select * from " + r2 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.e.e("sql:" + str4);
                                cursor = a.rawQuery(str4, new String[]{String.valueOf(0)});
                            } else {
                                String str5 = "select * from " + r2 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.e.e("sql:" + str5);
                                cursor = a.rawQuery(str5, new String[]{str, String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                                        commonMsgPojo.setGid(String.valueOf(com.baidu.tieba.im.chat.q.a));
                                        commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                        commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                        commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                        commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                        commonMsgPojo.setUid(String.valueOf(cursor.getLong(cursor.getColumnIndex(SapiAccountManager.SESSION_UID))));
                                        commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                        commonMsgPojo.setToUid(String.valueOf(cursor.getLong(cursor.getColumnIndex("to_uid"))));
                                        commonMsgPojo.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                                        commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                        commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                        commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                        commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                        commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                        commonMsgPojo.checkRidAndSelf();
                                        linkedList2.add(commonMsgPojo);
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        cb.a(e2, "PersonalMsgDao.getAll", new Object[0]);
                                        e2.printStackTrace();
                                        e(valueOf);
                                        r.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        cb.a(e, "PersonalMsgDao.getAll", new Object[0]);
                                        e.printStackTrace();
                                        r.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    }
                                }
                            }
                            r.a(cursor);
                        } catch (SQLiteException e5) {
                            cursor = null;
                            e2 = e5;
                        } catch (Exception e6) {
                            cursor = null;
                            e = e6;
                        } catch (Throwable th) {
                            r2 = 0;
                            th = th;
                            r.a((Cursor) r2);
                            throw th;
                        }
                        linkedList = linkedList2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return linkedList;
    }

    public final synchronized boolean a(long j, long j2, String str, String str2, int i) {
        Boolean bool;
        boolean z = false;
        synchronized (this) {
            if (j != 0 && j2 != 0 && TiebaApplication.v() != null) {
                String valueOf = String.valueOf(j);
                if (TiebaApplication.v().equals(valueOf)) {
                    valueOf = String.valueOf(j2);
                }
                String str3 = "tb_private_msg_" + valueOf;
                try {
                    SQLiteDatabase a = g.a();
                    if (a == null) {
                        bool = false;
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("mid", str2);
                        contentValues.put("msg_status", Integer.valueOf(i));
                        if (a.update(str3, contentValues, "mid=?", new String[]{str}) > 0) {
                            bool = true;
                        } else {
                            bool = false;
                        }
                    }
                } catch (Exception e) {
                    cb.a(e, "PersonalMsgDao.updateState", new Object[0]);
                    e.printStackTrace();
                    bool = false;
                }
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final synchronized void a(long j, boolean z) {
        String str = "tb_private_msg_" + j;
        try {
            SQLiteDatabase a = g.a();
            if (a != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", (Integer) 1);
                a.update(str, contentValues, "uid!=?", new String[]{SocialConstants.FALSE});
            }
        } catch (Exception e) {
            cb.a(e, "PersonalMsgDao.updateState", new Object[0]);
            e.printStackTrace();
        }
    }

    public final synchronized boolean a(long j, long j2, LinkedList<CommonMsgPojo> linkedList, boolean z) {
        boolean z2;
        Boolean bool;
        if (linkedList == null) {
            z2 = false;
        } else {
            this.c.addAndGet(linkedList.size());
            if (j == 0 || j2 == 0 || TiebaApplication.v() == null) {
                z2 = false;
            } else {
                String valueOf = String.valueOf(j);
                if (TiebaApplication.v().equals(valueOf)) {
                    valueOf = String.valueOf(j2);
                }
                String str = "tb_private_msg_" + valueOf;
                if (this.a == null) {
                    this.a = c();
                }
                if (!this.a.contains(valueOf)) {
                    e(valueOf);
                    this.a.add(valueOf);
                }
                SQLiteDatabase a = g.a();
                SQLiteStatement sQLiteStatement = null;
                if (a == null) {
                    bool = false;
                } else {
                    Cursor cursor = null;
                    try {
                        a.beginTransaction();
                        if (this.c.get() >= 20) {
                            cursor = a.rawQuery("select * from " + str + " ORDER BY mid desc limit 1000, 1", null);
                            String str2 = null;
                            if (cursor.moveToNext()) {
                                str2 = cursor.getString(cursor.getColumnIndex("mid"));
                            }
                            r.a(cursor);
                            if (str2 != null) {
                                a.delete(str, "mid<?", new String[]{str2});
                            }
                            this.c.set(0);
                        }
                        sQLiteStatement = a.compileStatement(" INSERT INTO " + str + "(content,create_time,ext,mid,uid,user_info,to_uid,to_user_info,msg_status,msg_type,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
                        Iterator<CommonMsgPojo> it = linkedList.iterator();
                        while (it.hasNext()) {
                            CommonMsgPojo next = it.next();
                            if (z && next.isSelf() && next.getRid() != 0) {
                                a.delete(str, "mid=?", new String[]{String.valueOf(next.getRid())});
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put(PushConstants.EXTRA_CONTENT, next.getContent());
                            contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put("mid", Long.valueOf(next.getMid()));
                            contentValues.put(SapiAccountManager.SESSION_UID, next.getUid());
                            contentValues.put("user_info", next.getUser_info());
                            contentValues.put("to_uid", next.getToUid());
                            contentValues.put("to_user_info", next.getToUser_info());
                            contentValues.put("msg_status", Integer.valueOf(next.getMsg_status()));
                            contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                            contentValues.put("rid", Long.valueOf(next.getRid()));
                            contentValues.put("read_flag", Integer.valueOf(next.getRead_flag()));
                            contentValues.put("is_delete", Integer.valueOf(next.getIs_delete()));
                            if (a.update(str, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) == 0) {
                                sQLiteStatement.clearBindings();
                                sQLiteStatement.bindString(1, next.getContent());
                                sQLiteStatement.bindLong(2, next.getCreate_time());
                                sQLiteStatement.bindString(3, next.getExt());
                                sQLiteStatement.bindLong(4, next.getMid());
                                sQLiteStatement.bindString(5, next.getUid());
                                sQLiteStatement.bindString(6, next.getUser_info());
                                sQLiteStatement.bindString(7, next.getToUid());
                                sQLiteStatement.bindString(8, next.getToUser_info());
                                sQLiteStatement.bindLong(9, next.getMsg_status());
                                sQLiteStatement.bindLong(10, next.getMsg_type());
                                sQLiteStatement.bindLong(11, next.getRid());
                                sQLiteStatement.bindLong(12, next.getRead_flag());
                                sQLiteStatement.bindLong(13, next.getIs_delete());
                                sQLiteStatement.executeInsert();
                            }
                        }
                        a.setTransactionSuccessful();
                        r.a(cursor);
                        r.a(sQLiteStatement);
                        a.endTransaction();
                    } catch (Exception e) {
                        cb.a(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                        e.printStackTrace();
                        Boolean.valueOf(false);
                        r.a(cursor);
                        r.a(sQLiteStatement);
                        a.endTransaction();
                    }
                    bool = true;
                }
                z2 = bool.booleanValue();
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0048 A[Catch: all -> 0x005a, TryCatch #2 {, blocks: (B:5:0x0004, B:9:0x000c, B:18:0x003b, B:19:0x003e, B:20:0x0042, B:22:0x0048, B:24:0x0054, B:38:0x0081, B:40:0x0087, B:33:0x0077, B:36:0x007d, B:37:0x0080), top: B:49:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Void a(LinkedList<String> linkedList) {
        Cursor cursor;
        Iterator<String> it;
        if (linkedList != null) {
            if (linkedList.size() != 0) {
                SQLiteDatabase a = g.a();
                LinkedList linkedList2 = new LinkedList();
                if (a != null) {
                    try {
                        cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                        if (cursor != null) {
                            try {
                                try {
                                    cursor.moveToFirst();
                                    while (cursor.moveToNext()) {
                                        linkedList2.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    cb.a(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                                    e.printStackTrace();
                                    r.a(cursor);
                                    it = linkedList.iterator();
                                    while (it.hasNext()) {
                                    }
                                    return null;
                                }
                            } catch (Throwable th) {
                                th = th;
                                r.a(cursor);
                                throw th;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                        cb.a(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                        e.printStackTrace();
                        r.a(cursor);
                        it = linkedList.iterator();
                        while (it.hasNext()) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                        r.a(cursor);
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                com.baidu.adp.lib.util.e.e("haveTables:" + linkedList2);
                r.a(cursor);
                it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (TextUtils.isEmpty(next)) {
                        com.baidu.adp.lib.util.e.b("gid is null");
                    } else if (!linkedList2.contains(next)) {
                        e(next);
                    }
                }
            }
        }
        return null;
    }

    public final synchronized boolean a(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    SQLiteDatabase a = g.a();
                    String str3 = "tb_private_msg_" + str;
                    if (a != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_delete", (Integer) 1);
                        a.update(str3, contentValues, "mid=?", new String[]{str2});
                        z = true;
                    }
                }
            } catch (Exception e) {
                cb.a(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            }
        }
        return z;
    }

    public final synchronized boolean b(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    SQLiteDatabase a = g.a();
                    String str3 = "tb_private_msg_" + str;
                    if (a != null) {
                        a.delete(str3, "mid=?", new String[]{str2});
                        z = true;
                    }
                }
            } catch (Exception e) {
                cb.a(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            }
        }
        return z;
    }

    public final synchronized boolean d(String str) {
        boolean z = true;
        synchronized (this) {
            try {
                a(Long.parseLong(str), true);
            } catch (Exception e) {
                cb.a(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
                com.baidu.adp.lib.util.e.b(e.toString());
                z = false;
            }
        }
        return z;
    }

    private synchronized void e(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = g.a();
                if (a != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, msg_status int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);";
                    com.baidu.adp.lib.util.e.e("sql:" + str3);
                    a.execSQL(str3);
                }
            }
        } catch (Exception e) {
            cb.a(e, "PersonalMsgDao.createMsgTable", new Object[0]);
            e.printStackTrace();
        }
    }

    public static LinkedList<String> c() {
        Cursor cursor = null;
        SQLiteDatabase a = g.a();
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            if (a != null) {
                cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME));
                        com.baidu.adp.lib.util.e.e("see table name:" + string);
                        if (string.startsWith("tb_private_msg_")) {
                            String charSequence = string.subSequence(15, string.length()).toString();
                            com.baidu.adp.lib.util.e.e("see table id:" + charSequence + "name:" + string);
                            linkedList.add(charSequence);
                        }
                    }
                }
            }
            com.baidu.adp.lib.util.e.e("haveTables:" + linkedList);
        } catch (Exception e) {
            cb.a(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
            e.printStackTrace();
        } finally {
            r.a(cursor);
        }
        return linkedList;
    }
}
