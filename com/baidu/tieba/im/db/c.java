package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.f.q;
import com.baidu.tieba.person.PersonInfoActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class c {
    private static c a;
    private AtomicInteger b = new AtomicInteger(0);

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [89=4] */
    public final synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                Cursor cursor = null;
                if (imDataBase != null) {
                    try {
                        try {
                            String str3 = "select count(*) from " + str2 + " WHERE read_flag=? AND is_delete=?";
                            com.baidu.adp.lib.util.f.e("sql:" + str3);
                            cursor = imDataBase.rawQuery(str3, new String[]{String.valueOf(1), String.valueOf(0)});
                            if (cursor == null || !cursor.moveToNext()) {
                                com.baidu.tbadk.core.util.l.a(cursor);
                            } else {
                                i = cursor.getInt(0);
                                com.baidu.tbadk.core.util.l.a(cursor);
                            }
                        } catch (Exception e) {
                            TiebaStatic.a(e, "GroupMsgDao.getUnreadcount", new Object[0]);
                            e.printStackTrace();
                            com.baidu.tbadk.core.util.l.a(cursor);
                        }
                    } catch (SQLiteException e2) {
                        TiebaStatic.a(e2, "GroupMsgDao.getUnreadcount", new Object[0]);
                        e2.printStackTrace();
                        com.baidu.tbadk.core.util.l.a(cursor);
                    }
                }
            }
        }
        return i;
    }

    public final synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_flag", (Integer) 0);
                if (imDataBase != null) {
                    imDataBase.update(str2, contentValues, null, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.a(e, "GroupMsgDao.markAllReaded", new Object[0]);
                a(str, 0L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [163=5] */
    public final synchronized long c(String str) {
        Cursor cursor = null;
        long j = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                if (imDataBase != null) {
                    try {
                        try {
                            String str3 = "select max(mid) from " + str2;
                            com.baidu.adp.lib.util.f.e("sql:" + str3);
                            cursor = imDataBase.rawQuery(str3, null);
                            if (cursor == null || !cursor.moveToNext()) {
                                com.baidu.tbadk.core.util.l.a(cursor);
                            } else {
                                j = cursor.getLong(0);
                                com.baidu.tbadk.core.util.l.a(cursor);
                            }
                        } catch (Exception e) {
                            TiebaStatic.a(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                            e.printStackTrace();
                            com.baidu.tbadk.core.util.l.a(cursor);
                        }
                    } catch (SQLiteException e2) {
                        TiebaStatic.a(e2, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e2.printStackTrace();
                        a(str, 0L);
                        com.baidu.tbadk.core.util.l.a(cursor);
                    }
                }
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [235=5] */
    public final synchronized CommonMsgPojo d(String str) {
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                try {
                    if (imDataBase != null) {
                        try {
                            String str3 = "select * from " + str2 + " WHERE is_delete=? ORDER BY mid DESC LIMIT 1";
                            com.baidu.adp.lib.util.f.e("sql:" + str3);
                            cursor = imDataBase.rawQuery(str3, new String[]{String.valueOf(0)});
                            try {
                                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    com.baidu.tbadk.core.util.l.a(cursor);
                                } else {
                                    commonMsgPojo2.setGid(str);
                                    commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                    commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                    commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                    commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                    commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                    commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                    commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                                    commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                    commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                    commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                    commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                    com.baidu.tbadk.core.util.l.a(cursor);
                                    commonMsgPojo = commonMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                e.printStackTrace();
                                TiebaStatic.a(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                                a(str, 0L);
                                com.baidu.tbadk.core.util.l.a(cursor);
                                return commonMsgPojo;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                TiebaStatic.a(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                                com.baidu.tbadk.core.util.l.a(cursor);
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
                            com.baidu.tbadk.core.util.l.a(cursor);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [309=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x0135 */
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
                ?? r2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                if (imDataBase == null) {
                    linkedList = linkedList2;
                } else {
                    try {
                        try {
                            if (TextUtils.isEmpty(null)) {
                                String str3 = "select * from " + r2 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT 1000";
                                com.baidu.adp.lib.util.f.e("sql:" + str3);
                                cursor = imDataBase.rawQuery(str3, new String[]{String.valueOf(2), String.valueOf(0)});
                            } else {
                                String str4 = "select * from " + r2 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT 1000";
                                com.baidu.adp.lib.util.f.e("sql:" + str4);
                                cursor = imDataBase.rawQuery(str4, new String[]{null, String.valueOf(2), String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        linkedList2.add(cursor.getString(cursor.getColumnIndex("content")));
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        e2.printStackTrace();
                                        TiebaStatic.a(e2, new StringBuilder("GroupMsgDao.getAllByMsgType2").toString(), new Object[0]);
                                        com.baidu.tbadk.core.util.l.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        TiebaStatic.a(e, new StringBuilder("GroupMsgDao.getAllByMsgType2").toString(), new Object[0]);
                                        com.baidu.tbadk.core.util.l.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    }
                                }
                            }
                            com.baidu.tbadk.core.util.l.a(cursor);
                        } catch (Throwable th2) {
                            th = th2;
                            com.baidu.tbadk.core.util.l.a((Cursor) r2);
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
                        com.baidu.tbadk.core.util.l.a((Cursor) r2);
                        throw th;
                    }
                    linkedList = linkedList2;
                }
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [516=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x020f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.StringBuilder] */
    public final synchronized LinkedList<com.baidu.tieba.im.message.a.a> a(String str, String str2, String str3, int i) {
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        LinkedList<com.baidu.tieba.im.message.a.a> linkedList = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                if (i <= 0) {
                    i = 20;
                }
                LinkedList<com.baidu.tieba.im.message.a.a> linkedList2 = new LinkedList<>();
                ?? r2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                try {
                    if (imDataBase == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
                                String str4 = "select * from " + r2 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.f.e("sql:" + str4);
                                cursor = imDataBase.rawQuery(str4, new String[]{str3, String.valueOf(0)});
                            } else if (TextUtils.isEmpty(str2)) {
                                String str5 = "select * from " + r2 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.f.e("sql:" + str5);
                                cursor = imDataBase.rawQuery(str5, new String[]{String.valueOf(0)});
                            } else {
                                String str6 = "select * from " + r2 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                com.baidu.adp.lib.util.f.e("sql:" + str6);
                                cursor = imDataBase.rawQuery(str6, new String[]{str2, String.valueOf(0)});
                            }
                        } catch (SQLiteException e3) {
                            cursor = null;
                            e2 = e3;
                        } catch (Exception e4) {
                            cursor = null;
                            e = e4;
                        } catch (Throwable th) {
                            r2 = 0;
                            th = th;
                            com.baidu.tbadk.core.util.l.a((Cursor) r2);
                            throw th;
                        }
                        try {
                            Gson gson = new Gson();
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    com.baidu.tieba.im.message.a.b bVar = new com.baidu.tieba.im.message.a.b();
                                    bVar.a(str);
                                    bVar.d(cursor.getString(cursor.getColumnIndex("content")));
                                    bVar.h(cursor.getLong(cursor.getColumnIndex("create_time")));
                                    bVar.b((Object) cursor.getString(cursor.getColumnIndex("ext")));
                                    bVar.f(cursor.getLong(cursor.getColumnIndex("mid")));
                                    MsgLocalData msgLocalData = new MsgLocalData();
                                    bVar.a(msgLocalData);
                                    msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex("msg_status"))));
                                    bVar.e(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                    bVar.g(cursor.getColumnIndex("uid"));
                                    bVar.a((UserData) gson.fromJson(cursor.getString(cursor.getColumnIndex("user_info")), (Class<Object>) UserData.class));
                                    bVar.e(cursor.getLong(cursor.getColumnIndex("rid")));
                                    q.f(bVar);
                                    linkedList2.addFirst(bVar);
                                }
                            }
                            com.baidu.tbadk.core.util.l.a(cursor);
                        } catch (SQLiteException e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            TiebaStatic.a(e2, "GroupMsgDao.getAll", new Object[0]);
                            a(str, 0L);
                            com.baidu.tbadk.core.util.l.a(cursor);
                            linkedList = linkedList2;
                            return linkedList;
                        } catch (Exception e6) {
                            e = e6;
                            e.printStackTrace();
                            TiebaStatic.a(e, "GroupMsgDao.getAll", new Object[0]);
                            com.baidu.tbadk.core.util.l.a(cursor);
                            linkedList = linkedList2;
                            return linkedList;
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

    public final synchronized boolean b(String str, String str2, String str3, int i) {
        Boolean bool;
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                String str4 = "tb_group_msg_" + str;
                try {
                    SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                    if (imDataBase == null) {
                        bool = false;
                    } else {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("mid", str3);
                        contentValues.put("msg_status", Integer.valueOf(i));
                        if (imDataBase.update(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
                            bool = true;
                        } else {
                            bool = false;
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.a(e, "GroupMsgDao.updateState", new Object[0]);
                    e.printStackTrace();
                    bool = false;
                }
                z = bool.booleanValue();
            }
        }
        return z;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x0271 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final synchronized boolean a(String str, LinkedList<CommonMsgPojo> linkedList, boolean z) {
        Cursor cursor;
        Boolean bool;
        SQLiteStatement sQLiteStatement = null;
        boolean z2 = false;
        synchronized (this) {
            if (linkedList != null) {
                this.b.addAndGet(linkedList.size());
                if (!TextUtils.isEmpty(str) && linkedList != null && linkedList.size() != 0 && (TextUtils.isEmpty(str) || !str.equals(String.valueOf(x.a)))) {
                    ?? r1 = "tb_group_msg_";
                    String str2 = "tb_group_msg_" + str;
                    SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                    try {
                        if (imDataBase == null) {
                            bool = false;
                        } else {
                            try {
                                imDataBase.beginTransaction();
                                if (this.b.get() >= 20) {
                                    cursor = imDataBase.rawQuery("select * from " + str2 + " ORDER BY mid desc limit 1000, 1", null);
                                    try {
                                        String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                                        com.baidu.tbadk.core.util.l.a(cursor);
                                        if (string != null) {
                                            imDataBase.delete(str2, "mid<?", new String[]{string});
                                        }
                                        this.b.set(0);
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                        TiebaStatic.a(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                        Boolean.valueOf(false);
                                        com.baidu.tbadk.core.util.l.a(cursor);
                                        com.baidu.tbadk.core.util.l.a(sQLiteStatement);
                                        imDataBase.endTransaction();
                                        bool = true;
                                        z2 = bool.booleanValue();
                                        return z2;
                                    }
                                } else {
                                    cursor = null;
                                }
                                sQLiteStatement = imDataBase.compileStatement(" INSERT INTO " + str2 + "(content,create_time,ext,mid,msg_status,msg_type,uid,user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                                Iterator<CommonMsgPojo> it = linkedList.iterator();
                                while (it.hasNext()) {
                                    CommonMsgPojo next = it.next();
                                    if (z && next.isSelf() && next.getRid() != 0) {
                                        imDataBase.delete(str2, "mid=?", new String[]{String.valueOf(next.getRid())});
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("content", next.getContent());
                                    contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                    contentValues.put("ext", next.getExt());
                                    contentValues.put("mid", Long.valueOf(next.getMid()));
                                    contentValues.put("msg_status", Integer.valueOf(next.getMsg_status()));
                                    contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                                    contentValues.put("uid", next.getUid());
                                    contentValues.put("user_info", next.getUser_info());
                                    contentValues.put("rid", Long.valueOf(next.getRid()));
                                    contentValues.put("read_flag", Integer.valueOf(next.getRead_flag()));
                                    contentValues.put("is_delete", Integer.valueOf(next.getIs_delete()));
                                    if (imDataBase.update(str2, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) == 0) {
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
                                imDataBase.setTransactionSuccessful();
                                com.baidu.tbadk.core.util.l.a(cursor);
                                com.baidu.tbadk.core.util.l.a(sQLiteStatement);
                                imDataBase.endTransaction();
                            } catch (Exception e2) {
                                e = e2;
                                cursor = null;
                            } catch (Throwable th) {
                                th = th;
                                r1 = 0;
                                com.baidu.tbadk.core.util.l.a((Cursor) r1);
                                com.baidu.tbadk.core.util.l.a((SQLiteStatement) null);
                                imDataBase.endTransaction();
                                throw th;
                            }
                            bool = true;
                        }
                        z2 = bool.booleanValue();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: all -> 0x0064, TryCatch #1 {, blocks: (B:5:0x0004, B:9:0x000c, B:18:0x003b, B:19:0x003e, B:20:0x0046, B:22:0x004c, B:24:0x005e, B:38:0x008b, B:40:0x00a6, B:33:0x0081, B:36:0x0087, B:37:0x008a), top: B:47:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Void a(LinkedHashMap<String, Long> linkedHashMap) {
        Cursor cursor;
        if (linkedHashMap != null) {
            if (linkedHashMap.size() != 0) {
                try {
                    SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                    LinkedList linkedList = new LinkedList();
                    if (imDataBase != null) {
                        try {
                            cursor = imDataBase.rawQuery("select * from sqlite_master where type='table'", null);
                            if (cursor != null) {
                                try {
                                    cursor.moveToFirst();
                                    while (cursor.moveToNext()) {
                                        linkedList.add(cursor.getString(cursor.getColumnIndex(PersonInfoActivity.TAG_NAME)));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    TiebaStatic.a(e, "GroupMsgDao.createMsgTable", new Object[0]);
                                    com.baidu.tbadk.core.util.l.a(cursor);
                                    while (r4.hasNext()) {
                                    }
                                    return null;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                            e.printStackTrace();
                            TiebaStatic.a(e, "GroupMsgDao.createMsgTable", new Object[0]);
                            com.baidu.tbadk.core.util.l.a(cursor);
                            while (r4.hasNext()) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.tbadk.core.util.l.a((Cursor) null);
                            throw th;
                        }
                    } else {
                        cursor = null;
                    }
                    com.baidu.adp.lib.util.f.e("haveTables:" + linkedList);
                    com.baidu.tbadk.core.util.l.a(cursor);
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

    public final synchronized boolean a(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                    String str3 = "tb_group_msg_" + str;
                    if (imDataBase != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_delete", (Integer) 1);
                        imDataBase.update(str3, contentValues, "mid=?", new String[]{str2});
                        z = true;
                    }
                } catch (Exception e) {
                    TiebaStatic.a(e, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
                }
            }
        }
        return z;
    }

    public final synchronized boolean b(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                    String str3 = "tb_group_msg_" + str;
                    if (imDataBase != null) {
                        imDataBase.delete(str3, "mid=?", new String[]{str2});
                        z = true;
                    }
                } catch (Exception e) {
                    TiebaStatic.a(e, "GroupMsgDao.deleteMsgByMid", new Object[0]);
                }
            }
        }
        return z;
    }

    public final synchronized boolean e(String str) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                    String str2 = "tb_group_msg_" + str;
                    if (imDataBase != null) {
                        imDataBase.execSQL("DROP TABLE IF EXISTS " + str2);
                        z = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    TiebaStatic.a(e, "GroupMsgDao.deleteMsgTableById", new Object[0]);
                }
            }
        }
        return z;
    }

    private synchronized void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase imDataBase = ImDatabaseManager.getImDataBase();
                if (imDataBase != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, msg_status int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);";
                    com.baidu.adp.lib.util.f.e("sql:" + str3);
                    imDataBase.execSQL(str3);
                    if (j != 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("mid", Long.valueOf(j));
                        contentValues.put("rid", Long.valueOf(j));
                        contentValues.put("is_delete", (Integer) 1);
                        imDataBase.insert(str2, null, contentValues);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.a(e, "GroupMsgDao.createMsgTable", new Object[0]);
        }
    }
}
