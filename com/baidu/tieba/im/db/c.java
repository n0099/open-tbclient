package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import cn.jingling.lib.file.Shared;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.validate.ValidateItemData;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.util.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c a;
    private StringBuffer b = new StringBuffer();
    private SQLiteStatement c;

    private c() {
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
        this.c = f.a(this.b.toString());
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

    public synchronized void a(String str) {
        try {
            SQLiteDatabase a2 = g.a();
            if (!TextUtils.isEmpty(str) && a2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 2);
                com.baidu.adp.lib.util.f.e("count:" + a2.update("tb_group_news", contentValues, "cmd=?", new String[]{str}) + " cmd:" + str);
            }
        } catch (Exception e) {
            cb.a(e, "GroupNewsDao.markReadByCmd", new Object[0]);
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [116=4] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r9v0 int)] */
    public synchronized int a(String str, int i) {
        Cursor cursor = null;
        int i2 = 0;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                try {
                    try {
                        String format = String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, new StringBuilder().append(i).toString());
                        com.baidu.adp.lib.util.f.e("sql:" + format);
                        cursor = a2.rawQuery(format, null);
                        i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                        r.a(cursor);
                    } catch (SQLiteException e) {
                        cb.a(e, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                        e.printStackTrace();
                        r.a(cursor);
                    }
                } catch (Exception e2) {
                    cb.a(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e2.printStackTrace();
                    r.a(cursor);
                }
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [150=4] */
    public synchronized int b(String str) {
        Cursor cursor = null;
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                try {
                    try {
                        String format = String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str);
                        com.baidu.adp.lib.util.f.e("sql:" + format);
                        cursor = a2.rawQuery(format, null);
                        i = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                        r.a(cursor);
                    } catch (SQLiteException e) {
                        cb.a(e, "GroupNewsDao.getCountByCmd", new Object[0]);
                        e.printStackTrace();
                        r.a(cursor);
                    }
                } catch (Exception e2) {
                    cb.a(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e2.printStackTrace();
                    r.a(cursor);
                }
            }
        }
        return i;
    }

    public synchronized boolean a(ValidateItemData validateItemData) {
        boolean booleanValue;
        int i;
        int i2 = 0;
        synchronized (this) {
            if (validateItemData == null) {
                booleanValue = false;
            } else {
                List<ValidateItemData> a2 = com.baidu.tieba.im.validate.l.a(a(0L, Shared.INFINITY, 0, "apply_join_group"));
                int size = a2.size();
                LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
                int i3 = 0;
                while (i2 < size) {
                    ValidateItemData validateItemData2 = a2.get(i2);
                    if (validateItemData2.getGroupId().equals(validateItemData.getGroupId()) && validateItemData2.getUserId().equals(validateItemData.getUserId()) && validateItemData.isPass()) {
                        validateItemData2.setPass(true);
                        if (validateItemData.isShown()) {
                            validateItemData2.setShown(true);
                        }
                        linkedList.add(validateItemData2.toGroupNewsPojo());
                        i = i3 + 1;
                    } else {
                        i = i3;
                    }
                    i2++;
                    i3 = i;
                }
                com.baidu.adp.lib.util.f.e("affectCount:" + i3);
                booleanValue = a(linkedList).booleanValue();
            }
        }
        return booleanValue;
    }

    public Boolean a(LinkedList<GroupNewsPojo> linkedList) {
        Boolean bool = false;
        SQLiteDatabase a2 = g.a();
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
                        cb.a(e, "GroupNewsDao.updateData", new Object[0]);
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
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                try {
                    if (j <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            String str2 = "select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2;
                            com.baidu.adp.lib.util.f.e("sql:" + str2);
                            cursor = a2.rawQuery(str2, null);
                        } else {
                            String format = String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str);
                            com.baidu.adp.lib.util.f.e("sql:" + format);
                            cursor = a2.rawQuery(format, null);
                            com.baidu.adp.lib.util.f.e(" test sql:" + format);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        String str3 = "select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2;
                        com.baidu.adp.lib.util.f.e("sql:" + str3);
                        cursor = a2.rawQuery(str3, new String[]{String.valueOf(j)});
                    } else {
                        String str4 = "select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2;
                        com.baidu.adp.lib.util.f.e("sql:" + str4);
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
                    r.a(cursor);
                } catch (Exception e) {
                    cb.a(e, "GroupNewsDao.getAllByCmd", new Object[0]);
                    e.printStackTrace();
                    r.a(cursor);
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
        com.baidu.adp.lib.util.f.e("before unique size:" + size);
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
            com.baidu.adp.lib.util.f.e("after unique size:" + linkedList2.size());
        }
        return linkedList2;
    }

    public synchronized boolean c(String str) {
        Boolean bool;
        Boolean.valueOf(false);
        try {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                a2.delete("tb_group_news", "notice_id = ?", new String[]{str});
                bool = true;
            } else {
                bool = false;
            }
        } catch (Exception e) {
            cb.a(e, "GroupNewsDao.deleteByNoticeId", new Object[0]);
            e.printStackTrace();
            bool = false;
        }
        com.baidu.adp.lib.util.f.e("noticeid: " + str + " success:" + bool);
        return bool.booleanValue();
    }

    public synchronized boolean a(String str, String str2) {
        boolean z = true;
        synchronized (this) {
            try {
                SQLiteDatabase a2 = g.a();
                if (a2 != null) {
                    a2.delete("tb_group_news", "gid = ? AND cmd = ?", new String[]{str, str2});
                } else {
                    z = false;
                }
            } catch (Exception e) {
                cb.a(e, "GroupNewsDao.deleteByGidAndCmd", new Object[0]);
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
            a2 = g.a();
        } catch (Exception e) {
            cb.a(e, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(str) && a2 != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("content_status", (Integer) 3);
            i2 = a2.update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
            com.baidu.adp.lib.util.f.e("count:" + i2);
        }
        i2 = 0;
        return i2;
    }

    public synchronized boolean a(List<UpdatesItemData> list) {
        boolean booleanValue;
        Boolean bool;
        SQLiteDatabase a2;
        if (list == null || list.isEmpty()) {
            Boolean bool2 = false;
            booleanValue = bool2.booleanValue();
        } else {
            try {
                a2 = g.a();
            } catch (Exception e) {
                cb.a(e, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
                e.printStackTrace();
                bool = false;
            }
            if (a2 == null) {
                Boolean bool3 = false;
                booleanValue = bool3.booleanValue();
            } else {
                int size = list.size();
                com.baidu.adp.lib.util.f.e("size:" + size);
                for (int i = 0; i < size; i++) {
                    UpdatesItemData updatesItemData = list.get(i);
                    if (updatesItemData != null) {
                        a2.delete("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                    }
                }
                bool = false;
                booleanValue = bool.booleanValue();
            }
        }
        return booleanValue;
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
                this.c = f.a(this.b.toString());
            }
            SQLiteDatabase a2 = g.a();
            if (a2 == null || !a2.isOpen()) {
                cb.a("GroupNewsDao.insertByStatement", -10, "db is invalid", new Object[0]);
                b();
            } else {
                this.c.clearBindings();
                f.a(this.c, 1, groupNewsPojo.getCmd());
                f.a(this.c, 2, groupNewsPojo.getContent());
                this.c.bindLong(3, groupNewsPojo.getContent_status());
                f.a(this.c, 4, groupNewsPojo.getExt());
                f.a(this.c, 5, groupNewsPojo.getGid());
                f.a(this.c, 6, groupNewsPojo.getNotice_id());
                this.c.bindLong(7, groupNewsPojo.getTime());
                j = this.c.executeInsert();
            }
        } catch (Exception e) {
            cb.a(e, "GroupNewsDao.insertByStatement", new Object[0]);
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
            cb.a(e, "GroupNewsDao.resetStatement", new Object[0]);
        }
    }
}
