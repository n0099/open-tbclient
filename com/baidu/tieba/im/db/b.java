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
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.r;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b {
    private static b a;
    private AtomicInteger b = new AtomicInteger(0);

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (a == null) {
                a = new b();
            }
            bVar = a;
        }
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=5] */
    public synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                Cursor cursor = null;
                if (a2 != null) {
                    try {
                        String str3 = "select count(*) from " + str2 + " WHERE read_flag=? AND is_delete=?";
                        com.baidu.adp.lib.util.f.e("sql:" + str3);
                        cursor = a2.rawQuery(str3, new String[]{String.valueOf(1), String.valueOf(0)});
                        if (cursor == null || !cursor.moveToNext()) {
                            r.a(cursor);
                        } else {
                            i = cursor.getInt(0);
                            r.a(cursor);
                        }
                    } catch (SQLiteException e) {
                        cb.a(e, "GroupMsgDao.getUnreadcount", new Object[0]);
                        e.printStackTrace();
                        r.a(cursor);
                    } catch (Exception e2) {
                        cb.a(e2, "GroupMsgDao.getUnreadcount", new Object[0]);
                        e2.printStackTrace();
                        r.a(cursor);
                    }
                }
            }
        }
        return i;
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_flag", (Integer) 0);
                if (a2 != null) {
                    a2.update(str2, contentValues, null, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                cb.a(e, "GroupMsgDao.markAllReaded", new Object[0]);
                a(str, 0L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [157=5] */
    public synchronized long c(String str) {
        Cursor cursor = null;
        long j = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                if (a2 != null) {
                    try {
                        try {
                            String str3 = "select max(mid) from " + str2;
                            com.baidu.adp.lib.util.f.e("sql:" + str3);
                            cursor = a2.rawQuery(str3, null);
                            if (cursor == null || !cursor.moveToNext()) {
                                r.a(cursor);
                            } else {
                                j = cursor.getLong(0);
                                r.a(cursor);
                            }
                        } catch (Exception e) {
                            cb.a(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                            e.printStackTrace();
                            r.a(cursor);
                        }
                    } catch (SQLiteException e2) {
                        cb.a(e2, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e2.printStackTrace();
                        a(str, 0L);
                        r.a(cursor);
                    }
                }
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [229=5] */
    public synchronized CommonMsgPojo d(String str) {
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                try {
                    if (a2 != null) {
                        try {
                            String str3 = "select * from " + str2 + " WHERE is_delete=? ORDER BY mid DESC LIMIT 1";
                            com.baidu.adp.lib.util.f.e("sql:" + str3);
                            cursor = a2.rawQuery(str3, new String[]{String.valueOf(0)});
                            try {
                                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    r.a(cursor);
                                } else {
                                    commonMsgPojo2.setGid(str);
                                    commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                    commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                    commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                    commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                    commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                    commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                    commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                                    commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                    commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                    commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                    commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                    r.a(cursor);
                                    commonMsgPojo = commonMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                e.printStackTrace();
                                cb.a(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                                a(str, 0L);
                                r.a(cursor);
                                return commonMsgPojo;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                cb.a(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [303=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0171 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r4v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.StringBuilder] */
    public synchronized LinkedList<String> a(String str, int i, String str2, int i2) {
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        LinkedList<String> linkedList = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                if (i2 <= 0) {
                    i2 = 20;
                }
                LinkedList<String> linkedList2 = new LinkedList<>();
                ?? r2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                try {
                    if (a2 == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (TextUtils.isEmpty(str2)) {
                                String str3 = "select * from " + r2 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2;
                                com.baidu.adp.lib.util.f.e("sql:" + str3);
                                cursor = a2.rawQuery(str3, new String[]{String.valueOf(i), String.valueOf(0)});
                            } else {
                                String str4 = "select * from " + r2 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2;
                                com.baidu.adp.lib.util.f.e("sql:" + str4);
                                cursor = a2.rawQuery(str4, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        linkedList2.add(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        e2.printStackTrace();
                                        cb.a(e2, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                                        r.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        cb.a(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [411=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x024e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r4v21, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v36, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.StringBuilder] */
    public synchronized LinkedList<CommonMsgPojo> a(String str, String str2, String str3, int i) {
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        LinkedList<CommonMsgPojo> linkedList = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                if (i <= 0) {
                    i = 20;
                }
                LinkedList<CommonMsgPojo> linkedList2 = new LinkedList<>();
                ?? r2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                try {
                    if (a2 == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (!TextUtils.isEmpty(str3) && !SocialConstants.FALSE.equals(str3)) {
                                String str4 = "select * from " + r2 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.f.e("sql:" + str4);
                                cursor = a2.rawQuery(str4, new String[]{str3, String.valueOf(0)});
                            } else if (TextUtils.isEmpty(str2)) {
                                String str5 = "select * from " + r2 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.f.e("sql:" + str5);
                                cursor = a2.rawQuery(str5, new String[]{String.valueOf(0)});
                            } else {
                                String str6 = "select * from " + r2 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.f.e("sql:" + str6);
                                cursor = a2.rawQuery(str6, new String[]{str2, String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                                        commonMsgPojo.setGid(str);
                                        commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                        commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                        commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                        commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                        commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                        commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                        commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                                        commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                        commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                        commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                        commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                        commonMsgPojo.checkRidAndSelf();
                                        linkedList2.add(commonMsgPojo);
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        e2.printStackTrace();
                                        cb.a(e2, "GroupMsgDao.getAll", new Object[0]);
                                        a(str, 0L);
                                        r.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        cb.a(e, "GroupMsgDao.getAll", new Object[0]);
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

    public synchronized boolean b(String str, String str2, String str3, int i) {
        Boolean bool;
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String str4 = "tb_group_msg_" + str;
                try {
                    SQLiteDatabase a2 = g.a();
                    if (a2 == null) {
                        bool = false;
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("mid", str3);
                        contentValues.put("msg_status", Integer.valueOf(i));
                        if (a2.update(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
                            bool = true;
                        } else {
                            bool = false;
                        }
                    }
                } catch (Exception e) {
                    cb.a(e, "GroupMsgDao.updateState", new Object[0]);
                    e.printStackTrace();
                    bool = false;
                }
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public synchronized boolean a(String str, LinkedList<CommonMsgPojo> linkedList, boolean z) {
        Cursor cursor;
        Boolean bool;
        SQLiteStatement sQLiteStatement = null;
        boolean z2 = false;
        synchronized (this) {
            if (linkedList != null) {
                this.b.addAndGet(linkedList.size());
                if (!TextUtils.isEmpty(str) && linkedList != null && linkedList.size() != 0 && (TextUtils.isEmpty(str) || !str.equals(String.valueOf(com.baidu.tieba.im.chat.q.a)))) {
                    String str2 = "tb_group_msg_" + str;
                    SQLiteDatabase a2 = g.a();
                    if (a2 == null) {
                        bool = false;
                    } else {
                        try {
                            a2.beginTransaction();
                            if (this.b.get() >= 20) {
                                cursor = a2.rawQuery("select * from " + str2 + " ORDER BY mid desc limit 1000, 1", null);
                                try {
                                    try {
                                        String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                                        r.a(cursor);
                                        if (string != null) {
                                            a2.delete(str2, "mid<?", new String[]{string});
                                        }
                                        this.b.set(0);
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        cb.a(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                        Boolean.valueOf(false);
                                        r.a(cursor);
                                        r.a(sQLiteStatement);
                                        a2.endTransaction();
                                        bool = true;
                                        z2 = bool.booleanValue();
                                        return z2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r.a(cursor);
                                    r.a(sQLiteStatement);
                                    a2.endTransaction();
                                    throw th;
                                }
                            } else {
                                cursor = null;
                            }
                            sQLiteStatement = a2.compileStatement(" INSERT INTO " + str2 + "(" + PushConstants.EXTRA_CONTENT + ",create_time,ext,mid,msg_status,msg_type," + SapiAccountManager.SESSION_UID + ",user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                            Iterator<CommonMsgPojo> it = linkedList.iterator();
                            while (it.hasNext()) {
                                CommonMsgPojo next = it.next();
                                if (z && next.isSelf() && next.getRid() != 0) {
                                    a2.delete(str2, "mid=?", new String[]{String.valueOf(next.getRid())});
                                }
                                ContentValues contentValues = new ContentValues();
                                contentValues.put(PushConstants.EXTRA_CONTENT, next.getContent());
                                contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                contentValues.put("ext", next.getExt());
                                contentValues.put("mid", Long.valueOf(next.getMid()));
                                contentValues.put("msg_status", Integer.valueOf(next.getMsg_status()));
                                contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                                contentValues.put(SapiAccountManager.SESSION_UID, next.getUid());
                                contentValues.put("user_info", next.getUser_info());
                                contentValues.put("rid", Long.valueOf(next.getRid()));
                                contentValues.put("read_flag", Integer.valueOf(next.getRead_flag()));
                                contentValues.put("is_delete", Integer.valueOf(next.getIs_delete()));
                                if (a2.update(str2, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) == 0) {
                                    sQLiteStatement.clearBindings();
                                    sQLiteStatement.bindString(1, next.getContent());
                                    sQLiteStatement.bindLong(2, next.getCreate_time());
                                    sQLiteStatement.bindString(3, next.getExt());
                                    sQLiteStatement.bindLong(4, next.getMid());
                                    sQLiteStatement.bindLong(5, next.getMsg_status());
                                    sQLiteStatement.bindLong(6, next.getMsg_type());
                                    sQLiteStatement.bindString(7, next.getUid());
                                    sQLiteStatement.bindString(8, next.getUser_info());
                                    sQLiteStatement.bindLong(9, next.getRid());
                                    sQLiteStatement.bindLong(10, next.getRead_flag());
                                    sQLiteStatement.bindLong(11, next.getIs_delete());
                                    sQLiteStatement.executeInsert();
                                }
                            }
                            a2.setTransactionSuccessful();
                            r.a(cursor);
                            r.a(sQLiteStatement);
                            a2.endTransaction();
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = null;
                            r.a(cursor);
                            r.a(sQLiteStatement);
                            a2.endTransaction();
                            throw th;
                        }
                        bool = true;
                    }
                    z2 = bool.booleanValue();
                }
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x0064, TryCatch #1 {, blocks: (B:5:0x0004, B:9:0x000c, B:18:0x003b, B:19:0x003e, B:20:0x0046, B:22:0x004c, B:24:0x005e, B:38:0x008b, B:40:0x00a6, B:33:0x0081, B:36:0x0087, B:37:0x008a), top: B:47:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Void a(LinkedHashMap<String, Long> linkedHashMap) {
        Cursor cursor;
        if (linkedHashMap != null) {
            if (linkedHashMap.size() != 0) {
                try {
                    SQLiteDatabase a2 = g.a();
                    LinkedList linkedList = new LinkedList();
                    if (a2 != null) {
                        try {
                            cursor = a2.rawQuery("select * from sqlite_master where type='table'", null);
                            if (cursor != null) {
                                try {
                                    cursor.moveToFirst();
                                    while (cursor.moveToNext()) {
                                        linkedList.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    cb.a(e, "GroupMsgDao.createMsgTable", new Object[0]);
                                    r.a(cursor);
                                    while (r4.hasNext()) {
                                    }
                                    return null;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                            e.printStackTrace();
                            cb.a(e, "GroupMsgDao.createMsgTable", new Object[0]);
                            r.a(cursor);
                            while (r4.hasNext()) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            r.a((Cursor) null);
                            throw th;
                        }
                    } else {
                        cursor = null;
                    }
                    com.baidu.adp.lib.util.f.e("haveTables:" + linkedList);
                    r.a(cursor);
                    for (Map.Entry<String, Long> entry : linkedHashMap.entrySet()) {
                        if (TextUtils.isEmpty(entry.getKey())) {
                            com.baidu.adp.lib.util.f.b("gid is null");
                        } else if (!linkedList.contains("tb_group_msg_" + entry.getKey())) {
                            a(entry.getKey(), entry.getValue().longValue());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    public synchronized boolean a(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase a2 = g.a();
                    String str3 = "tb_group_msg_" + str;
                    if (a2 != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_delete", (Integer) 1);
                        a2.update(str3, contentValues, "mid=?", new String[]{str2});
                        z = true;
                    }
                } catch (Exception e) {
                    cb.a(e, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
                }
            }
        }
        return z;
    }

    public synchronized boolean b(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase a2 = g.a();
                    String str3 = "tb_group_msg_" + str;
                    if (a2 != null) {
                        a2.delete(str3, "mid=?", new String[]{str2});
                        z = true;
                    }
                } catch (Exception e) {
                    cb.a(e, "GroupMsgDao.deleteMsgByMid", new Object[0]);
                }
            }
        }
        return z;
    }

    public synchronized boolean e(String str) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase a2 = g.a();
                    String str2 = "tb_group_msg_" + str;
                    if (a2 != null) {
                        a2.execSQL("DROP TABLE IF EXISTS " + str2);
                        z = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    cb.a(e, "GroupMsgDao.deleteMsgTableById", new Object[0]);
                }
            }
        }
        return z;
    }

    private synchronized void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = g.a();
                if (a2 != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, " + SapiAccountManager.SESSION_UID + " TEXT, user_info blob, create_time BIGINT, msg_type int, msg_status int, " + PushConstants.EXTRA_CONTENT + " blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);";
                    com.baidu.adp.lib.util.f.e("sql:" + str3);
                    a2.execSQL(str3);
                    if (j != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("mid", Long.valueOf(j));
                        contentValues.put("rid", Long.valueOf(j));
                        contentValues.put("is_delete", (Integer) 1);
                        a2.insert(str2, null, contentValues);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            cb.a(e, "GroupMsgDao.createMsgTable", new Object[0]);
        }
    }
}
