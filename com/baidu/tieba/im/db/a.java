package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.f.r;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class a {
    private String b;
    private Class<? extends ChatMessage> c;
    private AtomicInteger d = new AtomicInteger(0);
    List<String> a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, Class<? extends ChatMessage> cls) {
        this.b = str;
        this.c = cls;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [76=4] */
    public synchronized int a() {
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a = g.a();
            Cursor cursor = null;
            if (a != null) {
                try {
                    String str = "select personal_gid from tb_personal_id";
                    BdLog.d("sql:" + str);
                    cursor = a.rawQuery(str, new String[0]);
                    if (cursor != null && cursor.moveToNext()) {
                        i = cursor.getInt(0);
                    }
                    com.baidu.tbadk.core.util.m.a(cursor);
                } catch (SQLiteException e) {
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getPersonalGidSync", new Object[0]);
                    e.printStackTrace();
                    com.baidu.tbadk.core.util.m.a(cursor);
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getPersonalGidSync", new Object[0]);
                    e2.printStackTrace();
                    com.baidu.tbadk.core.util.m.a(cursor);
                }
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [112=4] */
    public synchronized void a(int i) {
        SQLiteDatabase a = g.a();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("personal_gid", Integer.valueOf(i));
                if (a != null) {
                    int update = a.update("tb_personal_id", contentValues, null, null);
                    BdLog.d("num:" + update);
                    if (update == 0) {
                        a.insert("tb_personal_id", null, contentValues);
                    }
                }
                com.baidu.tbadk.core.util.m.a((Cursor) null);
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.setPersonalGidSync", new Object[0]);
                e.printStackTrace();
                com.baidu.tbadk.core.util.m.a((Cursor) null);
            }
        } catch (SQLiteException e2) {
            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.setPersonalGidSync", new Object[0]);
            e2.printStackTrace();
            com.baidu.tbadk.core.util.m.a((Cursor) null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [158=5] */
    public synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = String.valueOf(this.b) + str;
                SQLiteDatabase a = g.a();
                Cursor cursor = null;
                if (a != null) {
                    try {
                        try {
                            String str3 = "select count(*) from " + str2 + " WHERE read_flag=? AND is_delete=?";
                            BdLog.d("sql:" + str3);
                            cursor = a.rawQuery(str3, new String[]{String.valueOf(1), String.valueOf(0)});
                            if (cursor == null || !cursor.moveToNext()) {
                                com.baidu.tbadk.core.util.m.a(cursor);
                            } else {
                                i = cursor.getInt(0);
                                com.baidu.tbadk.core.util.m.a(cursor);
                            }
                        } catch (SQLiteException e) {
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getUnreadcount", new Object[0]);
                            e.printStackTrace();
                            com.baidu.tbadk.core.util.m.a(cursor);
                        }
                    } catch (Exception e2) {
                        TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getUnreadcount", new Object[0]);
                        e2.printStackTrace();
                        com.baidu.tbadk.core.util.m.a(cursor);
                    }
                }
            }
        }
        return i;
    }

    public synchronized void b(String str) {
        ContentValues contentValues;
        if (!TextUtils.isEmpty(str)) {
            BdLog.d("uid:" + str);
            try {
                String str2 = String.valueOf(this.b) + str;
                SQLiteDatabase a = g.a();
                new ContentValues().put("read_flag", (Integer) 0);
                if (a != null) {
                    BdLog.d("num:" + a.update(str2, contentValues, null, null));
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markAllReaded", new Object[0]);
                e.printStackTrace();
                f(str);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [234=5] */
    public synchronized long c(String str) {
        Cursor cursor = null;
        long j = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = String.valueOf(this.b) + str;
                SQLiteDatabase a = g.a();
                if (a != null) {
                    try {
                        try {
                            String str3 = "select max(mid) from " + str2;
                            BdLog.d("sql:" + str3);
                            cursor = a.rawQuery(str3, null);
                            if (cursor == null || !cursor.moveToNext()) {
                                com.baidu.tbadk.core.util.m.a(cursor);
                            } else {
                                j = cursor.getLong(0);
                                com.baidu.tbadk.core.util.m.a(cursor);
                            }
                        } catch (Exception e) {
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                            e.printStackTrace();
                            com.baidu.tbadk.core.util.m.a(cursor);
                        }
                    } catch (SQLiteException e2) {
                        TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                        e2.printStackTrace();
                        f(str);
                        com.baidu.tbadk.core.util.m.a(cursor);
                    }
                }
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [310=5] */
    public synchronized CommonMsgPojo d(String str) {
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = String.valueOf(this.b) + str;
                SQLiteDatabase a = g.a();
                try {
                    if (a != null) {
                        try {
                            String str3 = "select * from " + str2 + " WHERE is_delete=? ORDER BY mid DESC LIMIT 1";
                            BdLog.d("sql:" + str3);
                            cursor = a.rawQuery(str3, new String[]{String.valueOf(0)});
                            try {
                                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    com.baidu.tbadk.core.util.m.a(cursor);
                                } else {
                                    commonMsgPojo2.setGid(str);
                                    commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                                    commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                    commonMsgPojo2.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                                    commonMsgPojo2.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                                    commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                    commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                    commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                    commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                    commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                    commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                    commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                    commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                    commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                    com.baidu.tbadk.core.util.m.a(cursor);
                                    commonMsgPojo = commonMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                                e.printStackTrace();
                                f(str);
                                com.baidu.tbadk.core.util.m.a(cursor);
                                return commonMsgPojo;
                            } catch (Exception e2) {
                                e = e2;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                                e.printStackTrace();
                                com.baidu.tbadk.core.util.m.a(cursor);
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
                            com.baidu.tbadk.core.util.m.a(cursor);
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
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x018f */
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
                ?? r2 = String.valueOf(this.b) + str;
                SQLiteDatabase a = g.a();
                try {
                    if (a == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (TextUtils.isEmpty(str2)) {
                                String str3 = "select * from " + r2 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2;
                                BdLog.d("sql:" + str3);
                                cursor = a.rawQuery(str3, new String[]{String.valueOf(i), String.valueOf(0)});
                            } else {
                                String str4 = "select * from " + r2 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2;
                                BdLog.d("sql:" + str4);
                                cursor = a.rawQuery(str4, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        linkedList2.add(cursor.getString(cursor.getColumnIndex("content")));
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                                        e2.printStackTrace();
                                        f(str);
                                        com.baidu.tbadk.core.util.m.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                                        e.printStackTrace();
                                        com.baidu.tbadk.core.util.m.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    }
                                }
                            }
                            com.baidu.tbadk.core.util.m.a(cursor);
                        } catch (SQLiteException e5) {
                            cursor = null;
                            e2 = e5;
                        } catch (Exception e6) {
                            cursor = null;
                            e = e6;
                        } catch (Throwable th) {
                            r2 = 0;
                            th = th;
                            com.baidu.tbadk.core.util.m.a((Cursor) r2);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [604=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x02ab */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7 */
    public synchronized LinkedList<ChatMessage> a(long j, String str, String str2, int i) {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        SQLiteException e2;
        LinkedList<ChatMessage> linkedList = null;
        synchronized (this) {
            if (j != 0) {
                String valueOf = String.valueOf(j);
                if (i <= 0) {
                    i = 20;
                }
                LinkedList<ChatMessage> linkedList2 = new LinkedList<>();
                String str3 = String.valueOf(this.b) + valueOf;
                ?? a = g.a();
                try {
                    if (a == 0) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                                String str4 = "select * from " + str3 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
                                BdLog.d("sql:" + str4);
                                cursor = a.rawQuery(str4, new String[]{str2, String.valueOf(0)});
                            } else if (TextUtils.isEmpty(str)) {
                                String str5 = "select * from " + str3 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                BdLog.d("sql:" + str5);
                                cursor = a.rawQuery(str5, new String[]{String.valueOf(0)});
                            } else {
                                String str6 = "select * from " + str3 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                BdLog.d("sql:" + str6);
                                cursor = a.rawQuery(str6, new String[]{str, String.valueOf(0)});
                            }
                            try {
                                Gson gson = new Gson();
                                if (cursor != null) {
                                    while (cursor.moveToNext()) {
                                        ChatMessage newInstance = this.c.newInstance();
                                        newInstance.setGroupId(String.valueOf(x.a));
                                        newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                        newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                                        newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                                        newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                                        newInstance.setUserId(cursor.getLong(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                                        newInstance.setUserInfo((UserData) gson.fromJson(cursor.getString(cursor.getColumnIndex("user_info")), (Class<Object>) UserData.class));
                                        newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                                        newInstance.setToUserInfo((UserData) gson.fromJson(cursor.getString(cursor.getColumnIndex("to_user_info")), (Class<Object>) UserData.class));
                                        MsgLocalData msgLocalData = new MsgLocalData();
                                        newInstance.setLocalData(msgLocalData);
                                        msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex("msg_status"))));
                                        newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                        newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                                        r.g(newInstance);
                                        linkedList2.addFirst(newInstance);
                                    }
                                }
                                com.baidu.tbadk.core.util.m.a(cursor);
                            } catch (SQLiteException e3) {
                                e2 = e3;
                                cursor2 = cursor;
                                try {
                                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAll", new Object[0]);
                                    e2.printStackTrace();
                                    f(valueOf);
                                    com.baidu.tbadk.core.util.m.a(cursor2);
                                    linkedList = linkedList2;
                                    return linkedList;
                                } catch (Throwable th) {
                                    th = th;
                                    a = cursor2;
                                    com.baidu.tbadk.core.util.m.a((Cursor) a);
                                    throw th;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                                e.printStackTrace();
                                com.baidu.tbadk.core.util.m.a(cursor);
                                linkedList = linkedList2;
                                return linkedList;
                            }
                        } catch (SQLiteException e5) {
                            cursor2 = null;
                            e2 = e5;
                        } catch (Exception e6) {
                            cursor = null;
                            e = e6;
                        } catch (Throwable th2) {
                            a = 0;
                            th = th2;
                            com.baidu.tbadk.core.util.m.a((Cursor) a);
                            throw th;
                        }
                        linkedList = linkedList2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
        return linkedList;
    }

    public synchronized boolean a(long j, long j2, String str, String str2, int i) {
        Boolean bool;
        boolean z = false;
        synchronized (this) {
            if (j != 0 && j2 != 0 && TbadkApplication.getCurrentAccount() != null) {
                String valueOf = String.valueOf(j);
                if (TbadkApplication.getCurrentAccount().equals(valueOf)) {
                    valueOf = String.valueOf(j2);
                }
                String str3 = String.valueOf(this.b) + valueOf;
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
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                    e.printStackTrace();
                    bool = false;
                }
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public synchronized void a(long j, boolean z) {
        synchronized (this) {
            String str = String.valueOf(this.b) + j;
            try {
                SQLiteDatabase a = g.a();
                if (a != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
                    a.update(str, contentValues, "uid!=?", new String[]{"0"});
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean a(long j, long j2, LinkedList<CommonMsgPojo> linkedList, boolean z) {
        boolean z2;
        Boolean bool;
        if (linkedList == null) {
            z2 = false;
        } else {
            this.d.addAndGet(linkedList.size());
            if (j == 0 || j2 == 0 || TbadkApplication.getCurrentAccount() == null) {
                z2 = false;
            } else {
                String valueOf = String.valueOf(j);
                if (TbadkApplication.getCurrentAccount().equals(valueOf)) {
                    valueOf = String.valueOf(j2);
                }
                String str = String.valueOf(this.b) + valueOf;
                if (this.a == null) {
                    this.a = b();
                }
                if (!this.a.contains(valueOf)) {
                    f(valueOf);
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
                        if (this.d.get() >= 20) {
                            cursor = a.rawQuery("select * from " + str + " ORDER BY mid desc limit 1000, 1", null);
                            String str2 = null;
                            if (cursor.moveToNext()) {
                                str2 = cursor.getString(cursor.getColumnIndex("mid"));
                            }
                            com.baidu.tbadk.core.util.m.a(cursor);
                            if (str2 != null) {
                                a.delete(str, "mid<?", new String[]{str2});
                            }
                            this.d.set(0);
                        }
                        sQLiteStatement = a.compileStatement(" INSERT INTO " + str + "(content,create_time,ext,mid," + SapiAccountManager.SESSION_UID + ",user_info,to_uid,to_user_info,msg_status,msg_type,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
                        Iterator<CommonMsgPojo> it = linkedList.iterator();
                        while (it.hasNext()) {
                            CommonMsgPojo next = it.next();
                            if (z && next.isSelf() && next.getRid() != 0) {
                                a.delete(str, "mid=?", new String[]{String.valueOf(next.getRid())});
                            }
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("content", next.getContent());
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
                        com.baidu.tbadk.core.util.m.a(cursor);
                        com.baidu.tbadk.core.util.m.a(sQLiteStatement);
                        a.endTransaction();
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                        e.printStackTrace();
                        Boolean.valueOf(false);
                        com.baidu.tbadk.core.util.m.a(cursor);
                        com.baidu.tbadk.core.util.m.a(sQLiteStatement);
                        a.endTransaction();
                    }
                    bool = true;
                }
                z2 = bool.booleanValue();
            }
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a A[Catch: all -> 0x005d, TryCatch #3 {, blocks: (B:5:0x0004, B:9:0x000c, B:18:0x003d, B:19:0x0040, B:20:0x0044, B:22:0x004a, B:24:0x0056, B:38:0x0086, B:40:0x008c, B:33:0x007c, B:36:0x0082, B:37:0x0085), top: B:50:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Void a(LinkedList<String> linkedList) {
        Cursor cursor;
        Iterator<String> it;
        if (linkedList != null) {
            if (linkedList.size() != 0) {
                try {
                    SQLiteDatabase a = g.a();
                    LinkedList linkedList2 = new LinkedList();
                    if (a != null) {
                        try {
                            cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                            if (cursor != null) {
                                try {
                                    cursor.moveToFirst();
                                    while (cursor.moveToNext()) {
                                        linkedList2.add(cursor.getString(cursor.getColumnIndex("name")));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                                    e.printStackTrace();
                                    com.baidu.tbadk.core.util.m.a(cursor);
                                    it = linkedList.iterator();
                                    while (it.hasNext()) {
                                    }
                                    return null;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor = null;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                            e.printStackTrace();
                            com.baidu.tbadk.core.util.m.a(cursor);
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.tbadk.core.util.m.a((Cursor) null);
                            throw th;
                        }
                    } else {
                        cursor = null;
                    }
                    BdLog.d("haveTables:" + linkedList2);
                    com.baidu.tbadk.core.util.m.a(cursor);
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (TextUtils.isEmpty(next)) {
                            BdLog.e("gid is null");
                        } else if (!linkedList2.contains(next)) {
                            f(next);
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
            try {
                if (!TextUtils.isEmpty(str)) {
                    SQLiteDatabase a = g.a();
                    String str3 = String.valueOf(this.b) + str;
                    if (a != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("is_delete", (Integer) 1);
                        a.update(str3, contentValues, "mid=?", new String[]{str2});
                        z = true;
                    }
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            }
        }
        return z;
    }

    public synchronized boolean b(String str, String str2) {
        boolean z = false;
        synchronized (this) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    SQLiteDatabase a = g.a();
                    String str3 = String.valueOf(this.b) + str;
                    if (a != null) {
                        a.delete(str3, "mid=?", new String[]{str2});
                        z = true;
                    }
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            }
        }
        return z;
    }

    public synchronized boolean e(String str) {
        boolean z = true;
        synchronized (this) {
            try {
                a(Long.parseLong(str), true);
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
                BdLog.e(e.toString());
                z = false;
            }
        }
        return z;
    }

    private synchronized void f(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = String.valueOf(this.b) + str;
                SQLiteDatabase a = g.a();
                if (a != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, " + SapiAccountManager.SESSION_UID + " TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, msg_status int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);";
                    BdLog.d("sql:" + str3);
                    a.execSQL(str3);
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
            e.printStackTrace();
        }
    }

    public LinkedList<String> b() {
        Cursor cursor = null;
        SQLiteDatabase a = g.a();
        LinkedList<String> linkedList = new LinkedList<>();
        if (a != null) {
            try {
                cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex("name"));
                        BdLog.d("see table name:" + string);
                        if (string.startsWith(this.b)) {
                            String charSequence = string.subSequence(this.b.length(), string.length()).toString();
                            BdLog.d("see table id:" + charSequence + "name:" + string);
                            linkedList.add(charSequence);
                        }
                    }
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
                e.printStackTrace();
            } finally {
                com.baidu.tbadk.core.util.m.a(cursor);
            }
        }
        BdLog.d("haveTables:" + linkedList);
        return linkedList;
    }

    public void c() {
        this.a = null;
    }
}
