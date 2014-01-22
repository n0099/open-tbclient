package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.util.by;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class l {
    private static l a;
    private StringBuffer b = new StringBuffer();
    private SQLiteStatement c;

    private l() {
        this.b.append("INSERT INTO ");
        this.b.append("tb_group_news");
        this.b.append("(");
        this.b.append("cmd");
        this.b.append(",");
        this.b.append(PushConstants.EXTRA_CONTENT);
        this.b.append(",");
        this.b.append("content_status");
        this.b.append(",");
        this.b.append("ext");
        this.b.append(",");
        this.b.append(PushConstants.EXTRA_GID);
        this.b.append(",");
        this.b.append("notice_id");
        this.b.append(",");
        this.b.append("time");
        this.b.append(") VALUES(?,?,?,?,?,?,?)");
        this.c = r.a(this.b.toString());
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (a == null) {
                a = new l();
            }
            lVar = a;
        }
        return lVar;
    }

    public synchronized void a(String str) {
        try {
            SQLiteDatabase a2 = s.a();
            if (!TextUtils.isEmpty(str) && a2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 2);
                com.baidu.adp.lib.g.e.d("count:" + a2.update("tb_group_news", contentValues, "cmd=?", new String[]{str}) + " cmd:" + str);
            }
        } catch (Exception e) {
            by.a(e, "GroupNewsDao.markReadByCmd", new Object[0]);
            e.printStackTrace();
        }
    }

    public synchronized int a(String str, int i) {
        Cursor cursor = null;
        int i2 = 0;
        synchronized (this) {
            SQLiteDatabase a2 = s.a();
            if (a2 != null) {
                try {
                    String format = String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, "" + i);
                    com.baidu.adp.lib.g.e.d("sql:" + format);
                    cursor = a2.rawQuery(format, null);
                    if (cursor.moveToFirst()) {
                        i2 = cursor.getInt(0);
                    } else {
                        i2 = -1;
                    }
                    com.baidu.tieba.util.p.a(cursor);
                } catch (SQLiteException e) {
                    by.a(e, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e.printStackTrace();
                    com.baidu.tieba.util.p.a(cursor);
                } catch (Exception e2) {
                    by.a(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e2.printStackTrace();
                    com.baidu.tieba.util.p.a(cursor);
                }
            }
        }
        return i2;
    }

    public synchronized int b(String str) {
        Cursor cursor = null;
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a2 = s.a();
            if (a2 != null) {
                try {
                    try {
                        String format = String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str);
                        com.baidu.adp.lib.g.e.d("sql:" + format);
                        cursor = a2.rawQuery(format, null);
                        if (cursor.moveToFirst()) {
                            i = cursor.getInt(0);
                        } else {
                            i = -1;
                        }
                        com.baidu.tieba.util.p.a(cursor);
                    } catch (SQLiteException e) {
                        by.a(e, "GroupNewsDao.getCountByCmd", new Object[0]);
                        e.printStackTrace();
                        com.baidu.tieba.util.p.a(cursor);
                    }
                } catch (Exception e2) {
                    by.a(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e2.printStackTrace();
                    com.baidu.tieba.util.p.a(cursor);
                }
            }
        }
        return i;
    }

    public synchronized void a(String str, com.baidu.tieba.im.a<Integer> aVar) {
        com.baidu.tieba.im.m.a(new m(this, str), aVar);
    }

    public synchronized void a(long j, int i, int i2, String str, com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> aVar) {
        com.baidu.tieba.im.m.a(new n(this, j, i, i2, str), aVar);
    }

    public synchronized void a(ValidateItemData validateItemData, com.baidu.tieba.im.a<Boolean> aVar) {
        if (validateItemData != null) {
            com.baidu.tieba.im.m.a(new o(this, validateItemData), aVar);
        }
    }

    public Boolean a(LinkedList<GroupNewsPojo> linkedList) {
        Boolean bool = false;
        SQLiteDatabase a2 = s.a();
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
                            contentValues.put(PushConstants.EXTRA_CONTENT, next.getContent());
                            contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put(PushConstants.EXTRA_GID, next.getGid());
                            contentValues.put("notice_id", next.getNotice_id());
                            contentValues.put("time", Long.valueOf(next.getTime()));
                            if (a2.update("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                                a(next);
                            }
                            bool = Boolean.valueOf(bool.booleanValue() & true);
                        }
                        a2.setTransactionSuccessful();
                        a2.endTransaction();
                        return bool;
                    } catch (Exception e) {
                        by.a(e, "GroupNewsDao.updateData", new Object[0]);
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

    public synchronized LinkedList<GroupNewsPojo> a(long j, int i, int i2, String str) {
        LinkedList<GroupNewsPojo> linkedList;
        Cursor cursor = null;
        synchronized (this) {
            if (i2 < 0) {
                i2 = 0;
            }
            linkedList = new LinkedList<>();
            if (i <= 0) {
                i = 20;
            }
            SQLiteDatabase a2 = s.a();
            if (a2 != null) {
                try {
                    if (j <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            String str2 = "select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2;
                            com.baidu.adp.lib.g.e.d("sql:" + str2);
                            cursor = a2.rawQuery(str2, null);
                        } else {
                            String format = String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str);
                            com.baidu.adp.lib.g.e.d("sql:" + format);
                            cursor = a2.rawQuery(format, null);
                            com.baidu.adp.lib.g.e.d(" test sql:" + format);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        String str3 = "select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2;
                        com.baidu.adp.lib.g.e.d("sql:" + str3);
                        cursor = a2.rawQuery(str3, new String[]{String.valueOf(j)});
                    } else {
                        String str4 = "select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2;
                        com.baidu.adp.lib.g.e.d("sql:" + str4);
                        cursor = a2.rawQuery(str4, new String[]{String.valueOf(j), str});
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex("cmd")));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_CONTENT)));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex(PushConstants.EXTRA_GID)));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            linkedList.add(groupNewsPojo);
                        }
                    }
                    com.baidu.tieba.util.p.a(cursor);
                } catch (Exception e) {
                    by.a(e, "GroupNewsDao.getAllByCmd", new Object[0]);
                    e.printStackTrace();
                    com.baidu.tieba.util.p.a(cursor);
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
        com.baidu.adp.lib.g.e.d("before unique size:" + size);
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
            com.baidu.adp.lib.g.e.d("after unique size:" + linkedList2.size());
        }
        return linkedList2;
    }

    public synchronized void b(String str, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new p(this, str), aVar);
    }

    public synchronized boolean a(String str, String str2) {
        boolean z = true;
        synchronized (this) {
            try {
                SQLiteDatabase a2 = s.a();
                if (a2 != null) {
                    a2.delete("tb_group_news", "gid = ? AND cmd = ?", new String[]{str, str2});
                } else {
                    z = false;
                }
            } catch (Exception e) {
                by.a(e, "GroupNewsDao.deleteByGidAndCmd", new Object[0]);
                e.printStackTrace();
                z = false;
            }
        }
        return z;
    }

    public synchronized int b(String str, int i) {
        int i2;
        SQLiteDatabase a2;
        try {
            a2 = s.a();
        } catch (Exception e) {
            by.a(e, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && a2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content_status", (Integer) 3);
            i2 = a2.update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
            com.baidu.adp.lib.g.e.d("count:" + i2);
        }
        i2 = 0;
        return i2;
    }

    public synchronized void a(List<UpdatesItemData> list, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new q(this, list), aVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r7.c == null) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long a(GroupNewsPojo groupNewsPojo) {
        long j = -1;
        try {
            if (this.c == null) {
                this.c = r.a(this.b.toString());
            }
            SQLiteDatabase a2 = s.a();
            if (a2 == null || !a2.isOpen()) {
                by.a("GroupNewsDao.insertByStatement", -10, "db is invalid", new Object[0]);
                b();
            } else {
                this.c.clearBindings();
                r.a(this.c, 1, groupNewsPojo.getCmd());
                r.a(this.c, 2, groupNewsPojo.getContent());
                this.c.bindLong(3, groupNewsPojo.getContent_status());
                r.a(this.c, 4, groupNewsPojo.getExt());
                r.a(this.c, 5, groupNewsPojo.getGid());
                r.a(this.c, 6, groupNewsPojo.getNotice_id());
                this.c.bindLong(7, groupNewsPojo.getTime());
                j = this.c.executeInsert();
            }
        } catch (Exception e) {
            by.a(e, "GroupNewsDao.insertByStatement", new Object[0]);
        }
        return j;
    }

    public void b() {
        try {
            if (this.c != null) {
                this.c.close();
                this.c = null;
            }
        } catch (Exception e) {
            by.a(e, "GroupNewsDao.resetStatement", new Object[0]);
        }
    }
}
