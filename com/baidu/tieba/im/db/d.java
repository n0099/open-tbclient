package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d {
    private static d a;
    private AtomicInteger b = new AtomicInteger(0);

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=4] */
    public synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = s.a();
                Cursor cursor = null;
                if (a2 != null) {
                    try {
                        try {
                            String str3 = "select count(*) from " + str2 + " WHERE read_flag=? AND is_delete=?";
                            com.baidu.adp.lib.h.e.d("sql:" + str3);
                            cursor = a2.rawQuery(str3, new String[]{String.valueOf(1), String.valueOf(0)});
                            if (cursor == null || !cursor.moveToNext()) {
                                com.baidu.tieba.util.o.a(cursor);
                            } else {
                                i = cursor.getInt(0);
                                com.baidu.tieba.util.o.a(cursor);
                            }
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
        }
        return i;
    }

    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = s.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_flag", (Integer) 0);
                if (a2 != null) {
                    a2.update(str2, contentValues, null, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                a(str, 0L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [154=4] */
    public synchronized long c(String str) {
        Cursor cursor = null;
        long j = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = s.a();
                if (a2 != null) {
                    try {
                        try {
                            String str3 = "select max(mid) from " + str2;
                            com.baidu.adp.lib.h.e.d("sql:" + str3);
                            cursor = a2.rawQuery(str3, null);
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
                        a(str, 0L);
                        com.baidu.tieba.util.o.a(cursor);
                    }
                }
            }
        }
        return j;
    }

    public synchronized CommonMsgPojo d(String str) {
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = s.a();
                try {
                    if (a2 != null) {
                        try {
                            String str3 = "select * from " + str2 + " WHERE is_delete=? ORDER BY mid DESC LIMIT 1";
                            com.baidu.adp.lib.h.e.d("sql:" + str3);
                            cursor = a2.rawQuery(str3, new String[]{String.valueOf(0)});
                            try {
                                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    com.baidu.tieba.util.o.a(cursor);
                                } else {
                                    commonMsgPojo2.setGid(str);
                                    commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
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
                                    com.baidu.tieba.util.o.a(cursor);
                                    commonMsgPojo = commonMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                e.printStackTrace();
                                a(str, 0L);
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
        com.baidu.tieba.im.m.a(new e(this, str, i2, str2, i), aVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x025b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
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
                SQLiteDatabase a2 = s.a();
                try {
                    if (a2 == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (TextUtils.isEmpty(str3) || SocialConstants.FALSE.equals(str3)) {
                                if (TextUtils.isEmpty(str2)) {
                                    String str4 = "select * from " + ((String) r2) + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                    com.baidu.adp.lib.h.e.d("sql:" + str4);
                                    cursor = a2.rawQuery(str4, new String[]{String.valueOf(0)});
                                } else {
                                    String str5 = "select * from " + ((String) r2) + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i;
                                    com.baidu.adp.lib.h.e.d("sql:" + str5);
                                    cursor = a2.rawQuery(str5, new String[]{str2, String.valueOf(0)});
                                }
                            } else {
                                String str6 = "select * from " + ((String) r2) + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i;
                                com.baidu.adp.lib.h.e.d("sql:" + str6);
                                cursor = a2.rawQuery(str6, new String[]{str3, String.valueOf(0)});
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
                                        commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                                        commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                        commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                                        commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                                        commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                                        commonMsgPojo.checkRidAndSelf();
                                        linkedList2.add(commonMsgPojo);
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        e2.printStackTrace();
                                        a(str, 0L);
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

    public synchronized void a(String str, String str2, String str3, int i, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new f(this, str, str2, str3, i), aVar);
    }

    public synchronized void a(String str, LinkedList<CommonMsgPojo> linkedList, boolean z, com.baidu.tieba.im.a<Boolean> aVar) {
        if (linkedList != null) {
            this.b.addAndGet(linkedList.size());
            com.baidu.tieba.im.m.a(new g(this, str, linkedList, z), aVar);
        }
    }

    public synchronized void a(LinkedHashMap<String, Long> linkedHashMap, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new h(this, linkedHashMap), aVar);
    }

    public synchronized void a(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new i(this, str, str2), aVar);
    }

    public synchronized void b(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new j(this, str, str2), aVar);
    }

    public synchronized void a(String str, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new k(this, str), aVar);
    }

    public synchronized boolean e(String str) {
        boolean z = false;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    SQLiteDatabase a2 = s.a();
                    String str2 = "tb_group_msg_" + str;
                    if (a2 != null) {
                        a2.execSQL("DROP TABLE IF EXISTS " + str2);
                        z = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, long j) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = "tb_group_msg_" + str;
                SQLiteDatabase a2 = s.a();
                if (a2 != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, msg_status int, " + PushConstants.EXTRA_CONTENT + " blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);";
                    com.baidu.adp.lib.h.e.d("sql:" + str3);
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
        }
    }
}
