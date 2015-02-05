package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.model.ValidateModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    private static d aYd;

    public static d MM() {
        if (aYd == null) {
            aYd = new d();
        }
        return aYd;
    }

    public void gp(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("content_status", (Integer) 2);
                g.MP().update("tb_group_news", contentValues, "cmd=?", new String[]{str});
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.markReadByCmd", new Object[0]);
            e.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=4] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r8v0 int)] */
    public int x(String str, int i) {
        Cursor cursor = null;
        int i2 = 0;
        try {
            cursor = g.MP().rawQuery(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' ) and content_status = %2$s", str, new StringBuilder().append(i).toString()), null);
            i2 = cursor.moveToFirst() ? cursor.getInt(0) : -1;
        } catch (SQLiteException e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getNewCountByCmd", new Object[0]);
            e.printStackTrace();
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getNewCountByCmd", new Object[0]);
            e2.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [107=4] */
    public int gq(String str) {
        Cursor cursor = null;
        int i = 0;
        try {
            cursor = g.MP().rawQuery(String.format("select count(*) from tb_group_news WHERE cmd IN ( '%1$s' )", str), null);
            i = cursor.moveToFirst() ? cursor.getInt(0) : -1;
        } catch (SQLiteException e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getCountByCmd", new Object[0]);
            e.printStackTrace();
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "GroupNewsDao.getCountByCmd", new Object[0]);
            e2.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return i;
    }

    public boolean a(ValidateItemData validateItemData) {
        int i;
        int i2 = 0;
        if (validateItemData == null) {
            return false;
        }
        List<ValidateItemData> convertToValidateItemDataList = ValidateModel.convertToValidateItemDataList(a(0L, Integer.MAX_VALUE, 0, "apply_join_group"));
        int size = convertToValidateItemDataList.size();
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        int i3 = 0;
        while (i2 < size) {
            ValidateItemData validateItemData2 = convertToValidateItemDataList.get(i2);
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
        BdLog.i("affectCount:" + i3);
        return k(linkedList).booleanValue();
    }

    public Boolean k(LinkedList<GroupNewsPojo> linkedList) {
        ValidateItemData convertToValidateItemData;
        Boolean bool = false;
        if (linkedList == null || linkedList.size() == 0) {
            return false;
        }
        try {
            try {
                g.MP().MQ();
                Iterator<GroupNewsPojo> it = linkedList.iterator();
                List<ValidateItemData> list = null;
                LinkedList<GroupNewsPojo> linkedList2 = null;
                while (it.hasNext()) {
                    GroupNewsPojo next = it.next();
                    if (next.getCmd().equals("apply_join_group")) {
                        if (linkedList2 == null && (list = ValidateModel.convertToValidateItemDataList((linkedList2 = a(0L, Integer.MAX_VALUE, 0, "apply_join_group")))) == null) {
                            list = new LinkedList();
                        }
                        if (list != null && (convertToValidateItemData = ValidateModel.convertToValidateItemData(next)) != null) {
                            for (ValidateItemData validateItemData : list) {
                                if (convertToValidateItemData.getUserId() != null && convertToValidateItemData.getUserId().equals(validateItemData.getUserId()) && convertToValidateItemData.getGroupId() != null && convertToValidateItemData.getGroupId().equals(validateItemData.getGroupId())) {
                                    gs(validateItemData.getNotice_id());
                                }
                            }
                        }
                    }
                    List list2 = list;
                    LinkedList<GroupNewsPojo> linkedList3 = linkedList2;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(com.baidu.tbadk.core.frameworkData.a.CMD, next.getCmd());
                    contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, next.getContent());
                    contentValues.put("content_status", Integer.valueOf(next.getContent_status()));
                    contentValues.put("ext", next.getExt());
                    contentValues.put("gid", next.getGid());
                    contentValues.put("notice_id", next.getNotice_id());
                    contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, Long.valueOf(next.getTime()));
                    if (g.MP().update("tb_group_news", contentValues, "notice_id=?", new String[]{next.getNotice_id()}) == 0) {
                        a(next);
                    }
                    bool = Boolean.valueOf(bool.booleanValue() & true);
                    linkedList2 = linkedList3;
                    list = list2;
                }
                g.MP().endTransaction();
                return bool;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.updateData", new Object[0]);
                e.printStackTrace();
                g.MP().endTransaction();
                return false;
            }
        } catch (Throwable th) {
            g.MP().endTransaction();
            throw th;
        }
    }

    public LinkedList<GroupNewsPojo> a(long j, int i, int i2, String str) {
        Cursor cursor = null;
        if (i2 < 0) {
            i2 = 0;
        }
        LinkedList<GroupNewsPojo> linkedList = new LinkedList<>();
        if (i <= 0) {
            i = 20;
        }
        try {
            if (j <= 0) {
                if (TextUtils.isEmpty(str)) {
                    cursor = g.MP().rawQuery("select * from tb_group_news ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, null);
                } else {
                    cursor = g.MP().rawQuery(String.format("select * from tb_group_news WHERE cmd IN ( '%1$s' ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, str), null);
                }
            } else if (TextUtils.isEmpty(str)) {
                cursor = g.MP().rawQuery("select * from tb_group_news WHERE time <=? ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j)});
            } else {
                cursor = g.MP().rawQuery("select * from tb_group_news WHERE time <=? AND cmd IN ( ? ) ORDER BY time DESC LIMIT " + i + " OFFSET " + i2, new String[]{String.valueOf(j), str});
            }
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    GroupNewsPojo groupNewsPojo = new GroupNewsPojo();
                    groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.CMD)));
                    groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                    groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                    groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                    groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                    groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                    groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME)));
                    linkedList.add(groupNewsPojo);
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getAllByCmd", new Object[0]);
            e.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return l(linkedList);
    }

    private LinkedList<GroupNewsPojo> l(LinkedList<GroupNewsPojo> linkedList) {
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
                y((String) arrayList.get(i3), 3);
            }
        }
        return linkedList2;
    }

    public GroupNewsPojo gr(String str) {
        Cursor cursor;
        Throwable th;
        GroupNewsPojo groupNewsPojo;
        GroupNewsPojo groupNewsPojo2 = null;
        try {
            cursor = g.MP().rawQuery("select * from tb_group_news WHERE notice_id = ?", new String[]{str});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            groupNewsPojo = new GroupNewsPojo();
                        } catch (Exception e) {
                            e = e;
                        }
                        try {
                            groupNewsPojo.setCmd(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.CMD)));
                            groupNewsPojo.setContent(cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                            groupNewsPojo.setContent_status(cursor.getInt(cursor.getColumnIndex("content_status")));
                            groupNewsPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            groupNewsPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            groupNewsPojo.setNotice_id(cursor.getString(cursor.getColumnIndex("notice_id")));
                            groupNewsPojo.setTime(cursor.getLong(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME)));
                            groupNewsPojo2 = groupNewsPojo;
                        } catch (Exception e2) {
                            groupNewsPojo2 = groupNewsPojo;
                            e = e2;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.getByNoticeId", new Object[0]);
                            t.b(cursor);
                            return groupNewsPojo2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        t.b(cursor);
                        throw th;
                    }
                }
            }
            t.b(cursor);
        } catch (Exception e3) {
            e = e3;
            cursor = null;
        } catch (Throwable th3) {
            cursor = null;
            th = th3;
            t.b(cursor);
            throw th;
        }
        return groupNewsPojo2;
    }

    public boolean gs(String str) {
        Boolean bool;
        Boolean.valueOf(false);
        try {
            g.MP().a("tb_group_news", "notice_id = ?", new String[]{str});
            bool = true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByNoticeId", new Object[0]);
            e.printStackTrace();
            bool = false;
        }
        return bool.booleanValue();
    }

    public int y(String str, int i) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("content_status", (Integer) 3);
            return g.MP().update("tb_group_news", contentValues, "notice_id= ?", new String[]{str});
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.hideByNoticeIdSync", new Object[0]);
            e.printStackTrace();
            return 0;
        }
    }

    public boolean aq(List<UpdatesItemData> list) {
        Boolean bool;
        if (list == null || list.isEmpty()) {
            Boolean bool2 = false;
            return bool2.booleanValue();
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                UpdatesItemData updatesItemData = list.get(i);
                if (updatesItemData != null) {
                    g.MP().a("tb_group_news", "notice_id=?", new String[]{updatesItemData.getNotice_id()});
                }
            }
            bool = false;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.deleteByUpdatesData", new Object[0]);
            e.printStackTrace();
            bool = false;
        }
        return bool.booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [535=4] */
    private long a(GroupNewsPojo groupNewsPojo) {
        long j = -1;
        SQLiteStatement sQLiteStatement = null;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("INSERT INTO ");
            stringBuffer.append("tb_group_news");
            stringBuffer.append("(");
            stringBuffer.append(com.baidu.tbadk.core.frameworkData.a.CMD);
            stringBuffer.append(",");
            stringBuffer.append(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            stringBuffer.append(",");
            stringBuffer.append("content_status");
            stringBuffer.append(",");
            stringBuffer.append("ext");
            stringBuffer.append(",");
            stringBuffer.append("gid");
            stringBuffer.append(",");
            stringBuffer.append("notice_id");
            stringBuffer.append(",");
            stringBuffer.append(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            stringBuffer.append(") VALUES(?,?,?,?,?,?,?)");
            sQLiteStatement = g.MP().compileStatement(stringBuffer.toString());
            if (sQLiteStatement != null) {
                sQLiteStatement.clearBindings();
                e.a(sQLiteStatement, 1, groupNewsPojo.getCmd());
                e.a(sQLiteStatement, 2, groupNewsPojo.getContent());
                sQLiteStatement.bindLong(3, groupNewsPojo.getContent_status());
                e.a(sQLiteStatement, 4, groupNewsPojo.getExt());
                e.a(sQLiteStatement, 5, groupNewsPojo.getGid());
                e.a(sQLiteStatement, 6, groupNewsPojo.getNotice_id());
                sQLiteStatement.bindLong(7, groupNewsPojo.getTime());
                j = sQLiteStatement.executeInsert();
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupNewsDao.insertByStatement", new Object[0]);
        } finally {
            t.a(sQLiteStatement);
        }
        return j;
    }

    public boolean w(String str, int i) {
        Cursor cursor;
        Cursor cursor2 = null;
        if (i < 1000) {
            i = 1000;
        }
        try {
            cursor = g.MP().rawQuery("SELECT * FROM tb_group_news ORDER BY notice_id DESC LIMIT " + i + ", 1", null);
            try {
                try {
                    String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("notice_id")) : null;
                    t.b(cursor);
                    if (string != null) {
                        g.MP().a("tb_group_news", "notice_id<?", new String[]{string});
                    }
                    t.b(cursor);
                    return true;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                    t.b(cursor);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                t.b(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            t.b(cursor2);
            throw th;
        }
    }
}
