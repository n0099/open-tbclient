package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class i {
    private static i bUk;

    public static synchronized i abc() {
        i iVar;
        synchronized (i.class) {
            if (bUk == null) {
                synchronized (i.class) {
                    if (bUk == null) {
                        bUk = new i();
                    }
                }
            }
            iVar = bUk;
        }
        return iVar;
    }

    private i() {
    }

    public boolean K(String str, int i) {
        try {
            return g.aaX().a("tb_message_center", "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
            return false;
        }
    }

    public LinkedList<ImMessageCenterPojo> abd() {
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor rawQuery = g.aaX().rawQuery("SELECT * FROM tb_message_center", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.h.b.c(rawQuery.getString(rawQuery.getColumnIndex("pull_msgid")), 0L));
                imMessageCenterPojo.setGid(rawQuery.getString(rawQuery.getColumnIndex("gid")));
                imMessageCenterPojo.setGroup_name(rawQuery.getString(rawQuery.getColumnIndex("group_name")));
                imMessageCenterPojo.setGroup_head(rawQuery.getString(rawQuery.getColumnIndex("group_head")));
                imMessageCenterPojo.setCustomGroupType(rawQuery.getInt(rawQuery.getColumnIndex("custom_group_type")));
                imMessageCenterPojo.setIsFriend(rawQuery.getInt(rawQuery.getColumnIndex("is_friend")));
                imMessageCenterPojo.setUnread_count(rawQuery.getInt(rawQuery.getColumnIndex("unread_count")));
                imMessageCenterPojo.setLast_rid(rawQuery.getLong(rawQuery.getColumnIndex("last_msgId")));
                imMessageCenterPojo.setLast_user_name(rawQuery.getString(rawQuery.getColumnIndex("last_user_name")));
                imMessageCenterPojo.setLast_content_time(rawQuery.getLong(rawQuery.getColumnIndex("last_content_time")));
                imMessageCenterPojo.setSend_status(rawQuery.getInt(rawQuery.getColumnIndex("send_status")));
                imMessageCenterPojo.setLast_content(rawQuery.getString(rawQuery.getColumnIndex("last_content")));
                imMessageCenterPojo.setPulled_msgId(rawQuery.getLong(rawQuery.getColumnIndex("pull_msgid")));
                imMessageCenterPojo.setIs_hidden(rawQuery.getInt(rawQuery.getColumnIndex("is_hidden")));
                linkedList.add(imMessageCenterPojo);
            }
        }
        com.baidu.adp.lib.util.o.b(rawQuery);
        return linkedList;
    }

    public LinkedList<ImMessageCenterPojo> abe() {
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor rawQuery = g.aaX().rawQuery("SELECT * FROM tb_message_center", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.h.b.c(rawQuery.getString(rawQuery.getColumnIndex("pull_msgid")), 0L));
                imMessageCenterPojo.setGid(rawQuery.getString(rawQuery.getColumnIndex("gid")));
                imMessageCenterPojo.setGroup_name(rawQuery.getString(rawQuery.getColumnIndex("group_name")));
                imMessageCenterPojo.setGroup_head(rawQuery.getString(rawQuery.getColumnIndex("group_head")));
                imMessageCenterPojo.setCustomGroupType(rawQuery.getInt(rawQuery.getColumnIndex("custom_group_type")));
                imMessageCenterPojo.setIsFriend(rawQuery.getInt(rawQuery.getColumnIndex("is_friend")));
                imMessageCenterPojo.setUnread_count(rawQuery.getInt(rawQuery.getColumnIndex("unread_count")));
                imMessageCenterPojo.setLast_rid(rawQuery.getLong(rawQuery.getColumnIndex("last_msgId")));
                imMessageCenterPojo.setLast_user_name(rawQuery.getString(rawQuery.getColumnIndex("last_user_name")));
                imMessageCenterPojo.setLast_content_time(rawQuery.getLong(rawQuery.getColumnIndex("last_content_time")));
                imMessageCenterPojo.setSend_status(rawQuery.getInt(rawQuery.getColumnIndex("send_status")));
                imMessageCenterPojo.setLast_content(rawQuery.getString(rawQuery.getColumnIndex("last_content")));
                imMessageCenterPojo.setPulled_msgId(rawQuery.getLong(rawQuery.getColumnIndex("pull_msgid")));
                imMessageCenterPojo.setIs_hidden(rawQuery.getInt(rawQuery.getColumnIndex("is_hidden")));
                imMessageCenterPojo.setSent_msgId(rawQuery.getLong(rawQuery.getColumnIndex("sent_mid")));
                imMessageCenterPojo.setRead_msgId(rawQuery.getLong(rawQuery.getColumnIndex("read_mid")));
                imMessageCenterPojo.setUserType(rawQuery.getInt(rawQuery.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                imMessageCenterPojo.setSid(rawQuery.getLong(rawQuery.getColumnIndex("sid")));
                imMessageCenterPojo.setTaskId(rawQuery.getString(rawQuery.getColumnIndex(InterviewLiveActivityConfig.KEY_TASK_ID)));
                imMessageCenterPojo.setPushIds(rawQuery.getString(rawQuery.getColumnIndex("ext1")));
                linkedList.add(imMessageCenterPojo);
            }
        }
        com.baidu.adp.lib.util.o.b(rawQuery);
        return linkedList;
    }

    public ImMessageCenterPojo L(String str, int i) {
        Cursor cursor;
        ImMessageCenterPojo imMessageCenterPojo;
        Exception e;
        try {
            cursor = g.aaX().rawQuery("select * from tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        } catch (Exception e2) {
            cursor = null;
            imMessageCenterPojo = null;
            e = e2;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            com.baidu.adp.lib.util.o.b(cursor);
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
                        imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.h.b.c(cursor.getString(cursor.getColumnIndex("pull_msgid")), 0L));
                        imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                        imMessageCenterPojo.setGroup_name(cursor.getString(cursor.getColumnIndex("group_name")));
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
                        imMessageCenterPojo.setSent_msgId(cursor.getLong(cursor.getColumnIndex("sent_mid")));
                        imMessageCenterPojo.setRead_msgId(cursor.getLong(cursor.getColumnIndex("read_mid")));
                        imMessageCenterPojo.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                        imMessageCenterPojo.setSid(cursor.getLong(cursor.getColumnIndex("sid")));
                        imMessageCenterPojo.setTaskId(cursor.getString(cursor.getColumnIndex(InterviewLiveActivityConfig.KEY_TASK_ID)));
                        imMessageCenterPojo.setPushIds(cursor.getString(cursor.getColumnIndex("ext1")));
                        com.baidu.adp.lib.util.o.b(cursor);
                    } catch (Exception e4) {
                        e = e4;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getGroupInfo", new Object[0]);
                        com.baidu.adp.lib.util.o.b(cursor);
                        return imMessageCenterPojo;
                    }
                    return imMessageCenterPojo;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.o.b(cursor);
                throw th;
            }
        }
        imMessageCenterPojo = null;
        com.baidu.adp.lib.util.o.b(cursor);
        return imMessageCenterPojo;
    }

    public LinkedList<ImMessageCenterPojo> abf() {
        Cursor cursor;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        try {
            try {
                cursor = g.aaX().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type IN (?,?,?,?,?)", new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(4), String.valueOf(-2)});
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                            imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                            imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                            linkedList.add(imMessageCenterPojo);
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getShrinkData", new Object[0]);
                            com.baidu.adp.lib.util.o.b(cursor);
                            return null;
                        }
                    }
                }
                com.baidu.adp.lib.util.o.b(cursor);
                return linkedList;
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.util.o.b((Cursor) null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.o.b((Cursor) null);
            throw th;
        }
    }

    public void c(ImMessageCenterPojo imMessageCenterPojo) {
        a(imMessageCenterPojo, 1);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, int i) {
        a(imMessageCenterPojo, i, 1);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, int i2) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gid", imMessageCenterPojo.getGid());
            contentValues.put("sid", Long.valueOf(imMessageCenterPojo.getSid()));
            contentValues.put(InterviewLiveActivityConfig.KEY_TASK_ID, imMessageCenterPojo.getTaskId());
            if (i2 == 2) {
                contentValues.put("ext1", imMessageCenterPojo.getPushIds());
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_head())) {
                contentValues.put("group_head", imMessageCenterPojo.getGroup_head());
            }
            contentValues.put("custom_group_type", Integer.valueOf(imMessageCenterPojo.getCustomGroupType()));
            int unread_count = imMessageCenterPojo.getUnread_count();
            if (i == 2) {
                contentValues.put("unread_count", Integer.valueOf(unread_count));
            } else if (i == 3 && unread_count > 0) {
                try {
                    try {
                        Cursor rawQuery = g.aaX().rawQuery("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                        if (rawQuery != null && rawQuery.moveToNext()) {
                            int i3 = unread_count + rawQuery.getInt(rawQuery.getColumnIndex("unread_count"));
                            if (i3 > 0) {
                                contentValues.put("unread_count", Integer.valueOf(i3));
                            }
                        } else {
                            contentValues.put("unread_count", Integer.valueOf(unread_count));
                        }
                        com.baidu.adp.lib.util.o.b(rawQuery);
                    } catch (Exception e) {
                        BdLog.e(e);
                        com.baidu.adp.lib.util.o.b((Cursor) null);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.util.o.b((Cursor) null);
                    throw th;
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
            if (imMessageCenterPojo.getSent_msgId() > 0) {
                contentValues.put("sent_mid", Long.valueOf(imMessageCenterPojo.getSent_msgId()));
            }
            if (imMessageCenterPojo.getRead_msgId() > 0) {
                contentValues.put("read_mid", Long.valueOf(imMessageCenterPojo.getRead_msgId()));
            }
            contentValues.put(OfficalBarChatActivityConfig.USER_TYPE, Integer.valueOf(imMessageCenterPojo.getUserType()));
            BdLog.i("sql-" + contentValues);
            if (g.aaX().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) == 0) {
                BdLog.i("insert");
                g.aaX().insert("tb_message_center", null, contentValues);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0181 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(ImMessageCenterPojo imMessageCenterPojo, int i) {
        Cursor cursor;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gid", imMessageCenterPojo.getGid());
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
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
                                cursor = g.aaX().rawQuery("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                                if (cursor != null) {
                                    try {
                                        if (cursor.moveToNext()) {
                                            int i2 = unread_count + cursor.getInt(cursor.getColumnIndex("unread_count"));
                                            if (i2 > 0) {
                                                contentValues.put("unread_count", Integer.valueOf(i2));
                                            }
                                            com.baidu.adp.lib.util.o.b(cursor);
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        BdLog.e(e);
                                        com.baidu.adp.lib.util.o.b(cursor);
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
                                        if (g.aaX().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                                        }
                                    }
                                }
                                contentValues.put("unread_count", Integer.valueOf(unread_count));
                                com.baidu.adp.lib.util.o.b(cursor);
                            } catch (Exception e2) {
                                e = e2;
                                cursor = null;
                            } catch (Throwable th) {
                                th = th;
                                r1 = 0;
                                com.baidu.adp.lib.util.o.b((Cursor) r1);
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
            if (g.aaX().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) != 0) {
                BdLog.i("insert");
                g.aaX().insert("tb_message_center", null, contentValues);
            }
        }
    }

    public void M(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread_count", (Integer) 0);
            g.aaX().update("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        }
    }
}
