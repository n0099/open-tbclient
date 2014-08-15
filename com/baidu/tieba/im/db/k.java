package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class k {
    private static k a;

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                synchronized (k.class) {
                    if (a == null) {
                        a = new k();
                    }
                }
            }
            kVar = a;
        }
        return kVar;
    }

    private k() {
    }

    public boolean a(String str, int i) {
        try {
            return g.a().a("tb_message_center", "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
            return false;
        }
    }

    public LinkedList<ImMessageCenterPojo> b() {
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor a2 = g.a().a("SELECT * FROM tb_message_center", null);
        if (a2 != null) {
            while (a2.moveToNext()) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.e.b.a(a2.getString(a2.getColumnIndex("pull_msgid")), 0L));
                imMessageCenterPojo.setGid(a2.getString(a2.getColumnIndex("gid")));
                imMessageCenterPojo.setGroup_name(a2.getString(a2.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME)));
                imMessageCenterPojo.setGroup_head(a2.getString(a2.getColumnIndex("group_head")));
                imMessageCenterPojo.setCustomGroupType(a2.getInt(a2.getColumnIndex("custom_group_type")));
                imMessageCenterPojo.setIsFriend(a2.getInt(a2.getColumnIndex("is_friend")));
                imMessageCenterPojo.setUnread_count(a2.getInt(a2.getColumnIndex("unread_count")));
                imMessageCenterPojo.setLast_rid(a2.getLong(a2.getColumnIndex("last_msgId")));
                imMessageCenterPojo.setLast_user_name(a2.getString(a2.getColumnIndex("last_user_name")));
                imMessageCenterPojo.setLast_content_time(a2.getLong(a2.getColumnIndex("last_content_time")));
                imMessageCenterPojo.setSend_status(a2.getInt(a2.getColumnIndex("send_status")));
                imMessageCenterPojo.setLast_content(a2.getString(a2.getColumnIndex("last_content")));
                imMessageCenterPojo.setPulled_msgId(a2.getLong(a2.getColumnIndex("pull_msgid")));
                imMessageCenterPojo.setIs_hidden(a2.getInt(a2.getColumnIndex("is_hidden")));
                linkedList.add(imMessageCenterPojo);
            }
        }
        com.baidu.adp.lib.util.m.a(a2);
        return linkedList;
    }

    public ImMessageCenterPojo b(String str, int i) {
        Cursor cursor;
        ImMessageCenterPojo imMessageCenterPojo;
        Exception e;
        try {
            cursor = g.a().a("select * from tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        } catch (Exception e2) {
            cursor = null;
            imMessageCenterPojo = null;
            e = e2;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            com.baidu.adp.lib.util.m.a(cursor);
            throw th;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Exception e3) {
                    imMessageCenterPojo = null;
                    e = e3;
                }
                if (cursor.moveToNext()) {
                    imMessageCenterPojo = new ImMessageCenterPojo();
                    try {
                        imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.e.b.a(cursor.getString(cursor.getColumnIndex("pull_msgid")), 0L));
                        imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                        imMessageCenterPojo.setGroup_name(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME)));
                        imMessageCenterPojo.setGroup_head(cursor.getString(cursor.getColumnIndex("group_head")));
                        imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                        imMessageCenterPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                        imMessageCenterPojo.setUnread_count(cursor.getInt(cursor.getColumnIndex("unread_count")));
                        imMessageCenterPojo.setLast_rid(cursor.getLong(cursor.getColumnIndex("last_msgId")));
                        imMessageCenterPojo.setLast_user_name(cursor.getString(cursor.getColumnIndex("last_user_name")));
                        imMessageCenterPojo.setLast_content_time(cursor.getLong(cursor.getColumnIndex("last_content_time")));
                        imMessageCenterPojo.setSend_status(cursor.getInt(cursor.getColumnIndex("send_status")));
                        imMessageCenterPojo.setLast_content(cursor.getString(cursor.getColumnIndex("last_content")));
                        imMessageCenterPojo.setPulled_msgId(cursor.getLong(cursor.getColumnIndex("pull_msgid")));
                        imMessageCenterPojo.setIs_hidden(cursor.getInt(cursor.getColumnIndex("is_hidden")));
                        com.baidu.adp.lib.util.m.a(cursor);
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getGroupInfo", new Object[0]);
                        com.baidu.adp.lib.util.m.a(cursor);
                        return imMessageCenterPojo;
                    }
                    return imMessageCenterPojo;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.m.a(cursor);
                throw th;
            }
        }
        imMessageCenterPojo = null;
        com.baidu.adp.lib.util.m.a(cursor);
        return imMessageCenterPojo;
    }

    public LinkedList<ImMessageCenterPojo> c() {
        Cursor cursor;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        try {
            cursor = g.a().a("SELECT * FROM tb_message_center WHERE  custom_group_type IN (?,?,?,?,?)", new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(4), String.valueOf(-2)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    try {
                        try {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                            linkedList.add(imMessageCenterPojo);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getShrinkData", new Object[0]);
                            com.baidu.adp.lib.util.m.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.m.a(cursor);
                        throw th;
                    }
                }
            }
            com.baidu.adp.lib.util.m.a(cursor);
            return linkedList;
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.adp.lib.util.m.a(cursor);
            throw th;
        }
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        a(imMessageCenterPojo, 1);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0197 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i) {
        Cursor cursor;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gid", imMessageCenterPojo.getGid());
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                contentValues.put(com.baidu.tbadk.core.frameworkData.a.GROUP_NAME, imMessageCenterPojo.getGroup_name());
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
            }
            contentValues.put("custom_group_type", Integer.valueOf(imMessageCenterPojo.getCustomGroupType()));
            int unread_count = imMessageCenterPojo.getUnread_count();
            if (i == 2) {
                contentValues.put("unread_count", Integer.valueOf(unread_count));
            } else {
                ?? r1 = 3;
                if (i == 3) {
                    try {
                        if (unread_count > 0) {
                            try {
                                cursor = g.a().a("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                                if (cursor != null) {
                                    try {
                                        if (cursor.moveToNext()) {
                                            int i2 = unread_count + cursor.getInt(cursor.getColumnIndex("unread_count"));
                                            if (i2 > 0) {
                                                contentValues.put("unread_count", Integer.valueOf(i2));
                                            }
                                            com.baidu.adp.lib.util.m.a(cursor);
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        BdLog.e(e);
                                        com.baidu.adp.lib.util.m.a(cursor);
                                        contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
                                        if (imMessageCenterPojo.getLast_user_name() != null) {
                                        }
                                        if (imMessageCenterPojo.getLast_content_time() != 0) {
                                        }
                                        if (imMessageCenterPojo.getLast_content() != null) {
                                        }
                                        contentValues.put("send_status", Integer.valueOf(imMessageCenterPojo.getSend_status()));
                                        contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
                                        contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
                                        if (imMessageCenterPojo.getPulled_msgId() != 0) {
                                        }
                                        BdLog.i("sql-" + contentValues);
                                        if (g.a().a("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                                        }
                                    }
                                }
                                contentValues.put("unread_count", Integer.valueOf(unread_count));
                                com.baidu.adp.lib.util.m.a(cursor);
                            } catch (Exception e2) {
                                e = e2;
                                cursor = null;
                            } catch (Throwable th) {
                                th = th;
                                r1 = 0;
                                com.baidu.adp.lib.util.m.a((Cursor) r1);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            contentValues.put("last_msgId", Long.valueOf(imMessageCenterPojo.getLast_rid()));
            if (imMessageCenterPojo.getLast_user_name() != null) {
                contentValues.put("last_user_name", imMessageCenterPojo.getLast_user_name());
            }
            if (imMessageCenterPojo.getLast_content_time() != 0) {
                contentValues.put("last_content_time", Long.valueOf(imMessageCenterPojo.getLast_content_time()));
            }
            if (imMessageCenterPojo.getLast_content() != null) {
                contentValues.put("last_content", imMessageCenterPojo.getLast_content());
            }
            contentValues.put("send_status", Integer.valueOf(imMessageCenterPojo.getSend_status()));
            contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
            contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
            if (imMessageCenterPojo.getPulled_msgId() != 0) {
                contentValues.put("pull_msgid", Long.valueOf(imMessageCenterPojo.getPulled_msgId()));
            }
            BdLog.i("sql-" + contentValues);
            if (g.a().a("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                BdLog.i("insert");
                g.a().a("tb_message_center", (String) null, contentValues);
            }
        }
    }

    public void c(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread_count", (Integer) 0);
            g.a().a("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        }
    }
}
