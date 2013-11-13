package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.validate.ValidateItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f1615a;

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f1615a == null) {
                f1615a = new g();
            }
            gVar = f1615a;
        }
        return gVar;
    }

    public synchronized void a(String str) {
        try {
            SQLiteDatabase a2 = m.a();
            if (!TextUtils.isEmpty(str) && a2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 2);
                com.baidu.adp.lib.h.d.d("count:" + a2.update("tb_group_news", contentValues, "cmd=?", new String[]{str}) + " cmd:" + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized int a(String str, int i) {
        Cursor cursor = null;
        int i2 = 0;
        synchronized (this) {
            SQLiteDatabase a2 = m.a();
            if (a2 != null) {
                try {
                    try {
                        String format = String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i);
                        com.baidu.adp.lib.h.d.d("sql:" + format);
                        cursor = a2.rawQuery(format, null);
                        if (cursor.moveToFirst()) {
                            i2 = cursor.getInt(0);
                        } else {
                            i2 = -1;
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
        return i2;
    }

    public synchronized void a(long j, int i, String str, com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.m.a(new h(this, j, i, str), aVar);
    }

    public synchronized void a(ValidateItemData validateItemData, com.baidu.tieba.im.a<Boolean> aVar) {
        if (validateItemData != null) {
            com.baidu.tieba.im.m.a(new i(this, validateItemData), aVar);
        }
    }

    public Boolean a(LinkedList<GroupNewsPojo> linkedList) {
        Boolean bool = false;
        SQLiteDatabase a2 = m.a();
        if (a2 != null && linkedList != null) {
            try {
                if (linkedList.size() != 0) {
                    try {
                        a2.beginTransaction();
                        Iterator<GroupNewsPojo> it = linkedList.iterator();
                        while (it.hasNext()) {
                            GroupNewsPojo next = it.next();
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("cmd", next.getCmd());
                            contentValues.put("content", next.getContent());
                            contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put(PushConstants.EXTRA_GID, next.getGid());
                            contentValues.put("notice_id", next.getNotice_id());
                            contentValues.put("time", Long.valueOf(next.getTime()));
                            if (a2.update("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                                a2.insert("tb_group_news", null, contentValues);
                            }
                            bool = Boolean.valueOf(bool.booleanValue() & true);
                        }
                        a2.setTransactionSuccessful();
                        a2.endTransaction();
                        return bool;
                    } catch (Exception e) {
                        e.printStackTrace();
                        a2.endTransaction();
                        return false;
                    }
                }
            } catch (Throwable th) {
                a2.endTransaction();
                throw th;
            }
        }
        return false;
    }

    public synchronized LinkedList<GroupNewsPojo> a(long j, int i, String str) {
        LinkedList<GroupNewsPojo> linkedList;
        Cursor cursor = null;
        synchronized (this) {
            linkedList = new LinkedList<>();
            if (i <= 0) {
                i = 20;
            }
            SQLiteDatabase a2 = m.a();
            if (a2 != null) {
                try {
                    if (j <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            String str2 = "select * from tb_group_news ORDER BY time DESC LIMIT " + i;
                            com.baidu.adp.lib.h.d.d("sql:" + str2);
                            cursor = a2.rawQuery(str2, null);
                        } else {
                            String format = String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i, str);
                            com.baidu.adp.lib.h.d.d("sql:" + format);
                            cursor = a2.rawQuery(format, null);
                            com.baidu.adp.lib.h.d.d(" test sql:" + format);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        String str3 = "select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i;
                        com.baidu.adp.lib.h.d.d("sql:" + str3);
                        cursor = a2.rawQuery(str3, new String[]{String.valueOf(j)});
                    } else {
                        String str4 = "select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i;
                        com.baidu.adp.lib.h.d.d("sql:" + str4);
                        cursor = a2.rawQuery(str4, new String[]{String.valueOf(j), str});
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_GID)));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            linkedList.add(groupNewsPojo);
                        }
                    }
                    com.baidu.tieba.util.o.a(cursor);
                } catch (Exception e) {
                    e.printStackTrace();
                    com.baidu.tieba.util.o.a(cursor);
                }
                linkedList = b(linkedList);
            }
        }
        return linkedList;
    }

    private LinkedList<GroupNewsPojo> b(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList<GroupNewsPojo> linkedList2 = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        int size = linkedList.size();
        com.baidu.adp.lib.h.d.d("before unique size:" + size);
        for (int i = 0; i < size; i++) {
            GroupNewsPojo groupNewsPojo = linkedList.get(i);
            boolean z = false;
            for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                if (linkedList2.get(i2).getContent().equals(groupNewsPojo.getContent())) {
                    z = true;
                }
            }
            if (z) {
                arrayList.add(groupNewsPojo.getNotice_id());
            } else {
                linkedList2.add(groupNewsPojo);
            }
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                b((String) arrayList.get(i3), 3);
            }
            com.baidu.adp.lib.h.d.d("after unique size:" + linkedList2.size());
        }
        return linkedList2;
    }

    public synchronized GroupNewsPojo b(String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2;
        GroupNewsPojo groupNewsPojo = null;
        synchronized (this) {
            SQLiteDatabase a2 = m.a();
            if (a2 != null) {
                try {
                    cursor = a2.rawQuery("select * from tb_group_news WHERE notice_id = ?", new String[]{str});
                    if (cursor != null) {
                        GroupNewsPojo groupNewsPojo2 = null;
                        while (cursor.moveToNext()) {
                            try {
                                try {
                                    GroupNewsPojo groupNewsPojo3 = new GroupNewsPojo();
                                    try {
                                        groupNewsPojo3.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                                        groupNewsPojo3.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                        groupNewsPojo3.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                                        groupNewsPojo3.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                                        groupNewsPojo3.setGid(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_GID)));
                                        groupNewsPojo3.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                                        groupNewsPojo3.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                                        groupNewsPojo2 = groupNewsPojo3;
                                    } catch (Exception e) {
                                        cursor2 = cursor;
                                        e = e;
                                        groupNewsPojo = groupNewsPojo3;
                                        try {
                                            e.printStackTrace();
                                            com.baidu.tieba.util.o.a(cursor2);
                                            return groupNewsPojo;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor = cursor2;
                                            com.baidu.tieba.util.o.a(cursor);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    com.baidu.tieba.util.o.a(cursor);
                                    throw th;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                groupNewsPojo = groupNewsPojo2;
                                cursor2 = cursor;
                            }
                        }
                        groupNewsPojo = groupNewsPojo2;
                    }
                    com.baidu.tieba.util.o.a(cursor);
                } catch (Exception e3) {
                    e = e3;
                    cursor2 = null;
                } catch (Throwable th4) {
                    cursor = null;
                    th = th4;
                }
            }
        }
        return groupNewsPojo;
    }

    public synchronized void a(String str, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new j(this, str), aVar);
    }

    public synchronized int b(String str, int i) {
        int i2;
        SQLiteDatabase a2;
        try {
            a2 = m.a();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && a2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content_status", (Integer) 3);
            i2 = a2.update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
            com.baidu.adp.lib.h.d.d("count:" + i2);
        }
        i2 = 0;
        return i2;
    }

    public synchronized void a(List<UpdatesItemData> list, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new k(this, list), aVar);
    }
}
