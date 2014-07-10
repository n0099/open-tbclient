package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import com.baidu.tieba.im.validate.ValidateItemData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d a;
    private StringBuffer b = new StringBuffer();
    private SQLiteStatement c;

    private d() {
        this.b.append("INSERT INTO ");
        this.b.append("tb_group_news");
        this.b.append("(");
        this.b.append(com.baidu.tbadk.core.frameworkData.a.CMD);
        this.b.append(",");
        this.b.append("content");
        this.b.append(",");
        this.b.append("content_status");
        this.b.append(",");
        this.b.append("ext");
        this.b.append(",");
        this.b.append("gid");
        this.b.append(",");
        this.b.append("notice_id");
        this.b.append(",");
        this.b.append("time");
        this.b.append(") VALUES(?,?,?,?,?,?,?)");
        this.c = f.a(this.b.toString());
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

    public synchronized void a(String str) {
        try {
            SQLiteDatabase a2 = g.a();
            if (!TextUtils.isEmpty(str) && a2 != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 2);
                a2.update("tb_group_news", contentValues, "cmd=?", new String[]{str});
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.markReadByCmd", new Object[0]);
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [115=4] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r9v0 int)] */
    public synchronized int a(String str, int i) {
        Cursor cursor = null;
        int i2 = 0;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                try {
                    try {
                        cursor = a2.rawQuery(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, new StringBuilder().append(i).toString()), null);
                        i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                        com.baidu.adp.lib.util.m.a(cursor);
                    } catch (SQLiteException e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                        e.printStackTrace();
                        com.baidu.adp.lib.util.m.a(cursor);
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [149=4] */
    public synchronized int b(String str) {
        Cursor cursor = null;
        int i = 0;
        synchronized (this) {
            SQLiteDatabase a2 = g.a();
            if (a2 != null) {
                try {
                    try {
                        cursor = a2.rawQuery(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str), null);
                        i = cursor.moveToFirst() ? cursor.getInt(0) : -1;
                        com.baidu.adp.lib.util.m.a(cursor);
                    } catch (SQLiteException e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getCountByCmd", new Object[0]);
                        e.printStackTrace();
                        com.baidu.adp.lib.util.m.a(cursor);
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
                    e2.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
                }
            }
        }
        return i;
    }

    public synchronized boolean a(ValidateItemData validateItemData) {
        boolean booleanValue;
        synchronized (this) {
            if (validateItemData == null) {
                booleanValue = false;
            } else {
                List<ValidateItemData> a2 = com.baidu.tieba.im.validate.n.a(a(0L, Integer.MAX_VALUE, 0, "apply_join_group"));
                int size = a2.size();
                LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    ValidateItemData validateItemData2 = a2.get(i);
                    if (validateItemData2.getGroupId().equals(validateItemData.getGroupId()) && validateItemData2.getUserId().equals(validateItemData.getUserId()) && validateItemData.isPass()) {
                        validateItemData2.setPass(true);
                        if (validateItemData.isShown()) {
                            validateItemData2.setShown(true);
                        }
                        linkedList.add(validateItemData2.toGroupNewsPojo());
                    }
                }
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
                            contentValues.put(com.baidu.tbadk.core.frameworkData.a.CMD, next.getCmd());
                            contentValues.put("content", next.getContent());
                            contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                            contentValues.put("ext", next.getExt());
                            contentValues.put("gid", next.getGid());
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
                        TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.updateData", new Object[0]);
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
                            cursor = a2.rawQuery("select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, null);
                        } else {
                            cursor = a2.rawQuery(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str), null);
                        }
                    } else if (TextUtils.isEmpty(str)) {
                        cursor = a2.rawQuery("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j)});
                    } else {
                        cursor = a2.rawQuery("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j), str});
                    }
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.CMD)));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex("time")));
                            linkedList.add(groupNewsPojo);
                        }
                    }
                    com.baidu.adp.lib.util.m.a(cursor);
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getAllByCmd", new Object[0]);
                    e.printStackTrace();
                    com.baidu.adp.lib.util.m.a(cursor);
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
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByNoticeId", new Object[0]);
            e.printStackTrace();
            bool = false;
        }
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
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByGidAndCmd", new Object[0]);
                e.printStackTrace();
                z = false;
            }
        }
        return z;
    }

    public synchronized int b(String str, int i) {
        int i2 = 0;
        synchronized (this) {
            try {
                SQLiteDatabase a2 = g.a();
                if (!TextUtils.isEmpty(str) && a2 != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content_status", (Integer) 3);
                    i2 = a2.update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
                e.printStackTrace();
            }
        }
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
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
                e.printStackTrace();
                bool = false;
            }
            if (a2 == null) {
                Boolean bool3 = false;
                booleanValue = bool3.booleanValue();
            } else {
                int size = list.size();
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
                TiebaStatic.printDBExceptionLog("GroupNewsDao.insertByStatement", -10, "db is invalid", new Object[0]);
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
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.insertByStatement", new Object[0]);
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
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.resetStatement", new Object[0]);
        }
    }
}
