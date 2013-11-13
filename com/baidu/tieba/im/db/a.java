package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static String f1601a = "tb_group_msg_";
    private static a b;
    private AtomicInteger c = new AtomicInteger(0);

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=4] */
    public synchronized int a(String str) {
        int i = 0;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = f1601a + str;
                SQLiteDatabase a2 = m.a();
                Cursor cursor = null;
                if (a2 != null) {
                    try {
                        String str3 = "select count(*) from " + str2 + " WHERE read_flag=?";
                        com.baidu.adp.lib.h.d.d("sql:" + str3);
                        cursor = a2.rawQuery(str3, new String[]{String.valueOf(1)});
                        if (cursor == null || !cursor.moveToNext()) {
                            com.baidu.tieba.util.o.a(cursor);
                        } else {
                            i = cursor.getInt(0);
                            com.baidu.tieba.util.o.a(cursor);
                        }
                    } catch (SQLiteException e) {
                        e.printStackTrace();
                        com.baidu.tieba.util.o.a(cursor);
                    } catch (Exception e2) {
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
                SQLiteDatabase a2 = m.a();
                ContentValues contentValues = new ContentValues();
                contentValues.put("read_flag", (Integer) 0);
                a2.update(f1601a + str, contentValues, null, null);
            } catch (Exception e) {
                e.printStackTrace();
                d(str);
            }
        }
    }

    public synchronized GroupMsgPojo c(String str) {
        Cursor cursor;
        GroupMsgPojo groupMsgPojo = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                String str2 = f1601a + str;
                SQLiteDatabase a2 = m.a();
                try {
                    if (a2 != null) {
                        try {
                            String str3 = "select * from " + str2 + " ORDER BY mid DESC LIMIT 1";
                            com.baidu.adp.lib.h.d.d("sql:" + str3);
                            cursor = a2.rawQuery(str3, null);
                            try {
                                GroupMsgPojo groupMsgPojo2 = new GroupMsgPojo();
                                if (cursor == null || !cursor.moveToNext()) {
                                    com.baidu.tieba.util.o.a(cursor);
                                } else {
                                    groupMsgPojo2.setGid(str);
                                    groupMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                    groupMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                    groupMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                    groupMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                    groupMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                    groupMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                    groupMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                                    groupMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                    com.baidu.tieba.util.o.a(cursor);
                                    groupMsgPojo = groupMsgPojo2;
                                }
                            } catch (SQLiteException e) {
                                e = e;
                                e.printStackTrace();
                                d(str);
                                com.baidu.tieba.util.o.a(cursor);
                                return groupMsgPojo;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                com.baidu.tieba.util.o.a(cursor);
                                return groupMsgPojo;
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
        return groupMsgPojo;
    }

    public synchronized void a(String str, int i, String str2, int i2, com.baidu.tieba.im.a<LinkedList<String>> aVar) {
        com.baidu.tieba.im.m.a(new b(this, str, i2, str2, i), aVar);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:40:0x0171 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
    public synchronized LinkedList<GroupMsgPojo> a(String str, String str2, int i) {
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        LinkedList<GroupMsgPojo> linkedList = null;
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                if (i <= 0) {
                    i = 20;
                }
                LinkedList<GroupMsgPojo> linkedList2 = new LinkedList<>();
                ?? r2 = f1601a + str;
                SQLiteDatabase a2 = m.a();
                try {
                    if (a2 == null) {
                        linkedList = linkedList2;
                    } else {
                        try {
                            if (TextUtils.isEmpty(str2)) {
                                String str3 = "select * from " + ((String) r2) + " ORDER BY mid DESC LIMIT " + i;
                                com.baidu.adp.lib.h.d.d("sql:" + str3);
                                cursor = a2.rawQuery(str3, null);
                            } else {
                                String str4 = "select * from " + ((String) r2) + " WHERE mid<? ORDER BY mid DESC LIMIT " + i;
                                com.baidu.adp.lib.h.d.d("sql:" + str4);
                                cursor = a2.rawQuery(str4, new String[]{str2});
                            }
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    try {
                                        GroupMsgPojo groupMsgPojo = new GroupMsgPojo();
                                        groupMsgPojo.setGid(str);
                                        groupMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                        groupMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                                        groupMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                        groupMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                                        groupMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                                        groupMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                        groupMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                                        groupMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                                        linkedList2.add(groupMsgPojo);
                                    } catch (SQLiteException e3) {
                                        e2 = e3;
                                        e2.printStackTrace();
                                        d(str);
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
        com.baidu.tieba.im.m.a(new c(this, str, str2, str3, i), aVar);
    }

    public synchronized void a(String str, LinkedList<GroupMsgPojo> linkedList, boolean z, com.baidu.tieba.im.a<Boolean> aVar) {
        if (linkedList != null) {
            this.c.addAndGet(linkedList.size());
            com.baidu.tieba.im.m.a(new d(this, str, linkedList, z), aVar);
        }
    }

    public synchronized void a(LinkedList<String> linkedList, com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.m.a(new e(this, linkedList), aVar);
    }

    public synchronized void a(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new f(this, str, str2), aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String str2 = f1601a + str;
                SQLiteDatabase a2 = m.a();
                if (a2 != null) {
                    String str3 = "CREATE TABLE IF NOT EXISTS " + str2 + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, msg_status int, content blob, ext blob,read_flag int);";
                    com.baidu.adp.lib.h.d.d("sql:" + str3);
                    a2.execSQL(str3);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
