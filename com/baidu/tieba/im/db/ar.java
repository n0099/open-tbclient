package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ar {
    private static ar b;
    private AtomicInteger c = new AtomicInteger(0);
    List<String> a = null;

    private ar() {
    }

    public static synchronized ar a() {
        ar arVar;
        synchronized (ar.class) {
            if (b == null) {
                b = new ar();
            }
            arVar = b;
        }
        return arVar;
    }

    public synchronized int b() {
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a = s.a();
            Cursor cursor = null;
            if (a != null) {
                try {
                    try {
                        String str = "select personal_gid from tb_personal_id";
                        com.baidu.adp.lib.h.e.d("sql:" + str);
                        cursor = a.rawQuery(str, new String[0]);
                        if (cursor != null && cursor.moveToNext()) {
                            i = cursor.getInt(0);
                        }
                        com.baidu.tieba.util.o.a(cursor);
                    } catch (Exception e) {
                        e.printStackTrace();
                        com.baidu.tieba.util.o.a(cursor);
                    }
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                    com.baidu.tieba.util.o.a(cursor);
                }
            }
        }
        return i;
    }

    public synchronized void a(int i) {
        SQLiteDatabase a = s.a();
        try {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("personal_gid", Integer.valueOf(i));
                if (a != null) {
                    int update = a.update("tb_personal_id", contentValues, null, null);
                    com.baidu.adp.lib.h.e.d("num:" + update);
                    if (update == 0) {
                        a.insert("tb_personal_id", null, contentValues);
                    }
                }
                com.baidu.tieba.util.o.a((Cursor) null);
            } catch (Exception e) {
                e.printStackTrace();
                com.baidu.tieba.util.o.a((Cursor) null);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
            com.baidu.tieba.util.o.a((Cursor) null);
        }
    }

    public synchronized void a(String str) {
        ContentValues contentValues;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.adp.lib.h.e.d("uid:" + str);
            try {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = s.a();
                new ContentValues().put("read_flag", (Integer) 0);
                if (a != null) {
                    com.baidu.adp.lib.h.e.d("num:" + a.update(str2, contentValues, null, null));
                }
            } catch (Exception e) {
                e.printStackTrace();
                d(str);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [227=4] */
    public synchronized long b(String str) {
        Cursor cursor = null;
        long j = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = s.a();
                if (a != null) {
                    try {
                        try {
                            String str3 = "select max(mid) from " + str2;
                            com.baidu.adp.lib.h.e.d("sql:" + str3);
                            cursor = a.rawQuery(str3, null);
                            if (cursor == null || !cursor.moveToNext()) {
                                com.baidu.tieba.util.o.a(cursor);
                            } else {
                                j = cursor.getLong(0);
                                com.baidu.tieba.util.o.a(cursor);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            com.baidu.tieba.util.o.a(cursor);
                        }
                    } catch (SQLiteException e2) {
                        e2.printStackTrace();
                        d(str);
                        com.baidu.tieba.util.o.a(cursor);
                    }
                }
            }
        }
        return j;
    }

    public synchronized CommonMsgPojo c(String str) {
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = s.a();
                try {
                    if (a != null) {
                        try {
                            String str3 = "select * from " + str2 + " WHERE is_delete=? ORDER BY mid DESC LIMIT 1";
                            com.baidu.adp.lib.h.e.d("sql:" + str3);
                            cursor = a.rawQuery(str3, new String[]{String.valueOf(0)});
                            try {
                                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    com.baidu.tieba.util.o.a(cursor);
                                } else {
                                    commonMsgPojo2.setGid(str);
                                    commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex("uid")));
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
                                    com.baidu.tieba.util.o.a(cursor);
                                    commonMsgPojo = commonMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                e.printStackTrace();
                                d(str);
                                com.baidu.tieba.util.o.a(cursor);
                                return commonMsgPojo;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                com.baidu.tieba.util.o.a(cursor);
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
                            com.baidu.tieba.util.o.a(cursor);
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

    public synchronized void a(String str, int i, String str2, int i2, com.baidu.tieba.im.a<LinkedList<String>> aVar) {
        com.baidu.tieba.im.m.a(new as(this, str, i2, str2, i), aVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0285 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public synchronized LinkedList<CommonMsgPojo> a(long j, String str, String str2, int i) {
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
                SQLiteDatabase a = s.a();
                try {
                    if (a == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (TextUtils.isEmpty(str2) || SocialConstants.FALSE.equals(str2)) {
                                if (TextUtils.isEmpty(str)) {
                                    String str3 = "select * from " + ((String) r2) + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                    com.baidu.adp.lib.h.e.d("sql:" + str3);
                                    cursor = a.rawQuery(str3, new String[]{String.valueOf(0)});
                                } else {
                                    String str4 = "select * from " + ((String) r2) + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                    com.baidu.adp.lib.h.e.d("sql:" + str4);
                                    cursor = a.rawQuery(str4, new String[]{str, String.valueOf(0)});
                                }
                            } else {
                                String str5 = "select * from " + ((String) r2) + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
                                com.baidu.adp.lib.h.e.d("sql:" + str5);
                                cursor = a.rawQuery(str5, new String[]{str2, String.valueOf(0)});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                                        commonMsgPojo.setGid(String.valueOf(com.baidu.tieba.im.chat.a.a));
                                        commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                                        commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                        commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                        commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                        commonMsgPojo.setUid(String.valueOf(cursor.getLong(cursor.getColumnIndex("uid"))));
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
                                        e2.printStackTrace();
                                        d(valueOf);
                                        com.baidu.tieba.util.o.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    } catch (Exception e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        com.baidu.tieba.util.o.a(cursor);
                                        linkedList = linkedList2;
                                        return linkedList;
                                    }
                                }
                            }
                            com.baidu.tieba.util.o.a(cursor);
                        } catch (SQLiteException e5) {
                            cursor = null;
                            e2 = e5;
                        } catch (Exception e6) {
                            cursor = null;
                            e = e6;
                        } catch (Throwable th) {
                            r2 = 0;
                            th = th;
                            com.baidu.tieba.util.o.a((Cursor) r2);
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

    public synchronized void a(long j, long j2, String str, String str2, int i, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new at(this, j, j2, str2, i, str), aVar);
    }

    public synchronized void a(long j, boolean z) {
        synchronized (this) {
            String str = "tb_private_msg_" + j;
            try {
                SQLiteDatabase a = s.a();
                if (a != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
                    a.update(str, contentValues, "uid!=?", new String[]{SocialConstants.FALSE});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void a(long j, long j2, LinkedList<CommonMsgPojo> linkedList, boolean z, com.baidu.tieba.im.a<Boolean> aVar) {
        if (linkedList != null) {
            this.c.addAndGet(linkedList.size());
            com.baidu.tieba.im.m.a(new au(this, j, j2, linkedList, z), aVar);
        }
    }

    public synchronized void a(LinkedList<String> linkedList, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new av(this, linkedList), aVar);
    }

    public synchronized void a(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new aw(this, str, str2), aVar);
    }

    public synchronized void b(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new ax(this, str, str2), aVar);
    }

    public synchronized void a(String str, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new ay(this, str), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_private_msg_" + str;
                SQLiteDatabase a = s.a();
                if (a != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, msg_status int, " + PushConstants.EXTRA_CONTENT + " blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);";
                    com.baidu.adp.lib.h.e.d("sql:" + str3);
                    a.execSQL(str3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> c() {
        Cursor cursor = null;
        SQLiteDatabase a = s.a();
        LinkedList<String> linkedList = new LinkedList<>();
        if (a != null) {
            try {
                cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME));
                        com.baidu.adp.lib.h.e.d("see table name:" + string);
                        if (string.startsWith("tb_private_msg_")) {
                            String charSequence = string.subSequence("tb_private_msg_".length(), string.length()).toString();
                            com.baidu.adp.lib.h.e.d("see table id:" + charSequence + "name:" + string);
                            linkedList.add(charSequence);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                com.baidu.tieba.util.o.a(cursor);
            }
        }
        com.baidu.adp.lib.h.e.d("haveTables:" + linkedList);
        return linkedList;
    }
}
