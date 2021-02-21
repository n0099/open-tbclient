package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    private static j kFn;

    public static synchronized j cVK() {
        j jVar;
        synchronized (j.class) {
            if (kFn == null) {
                synchronized (j.class) {
                    if (kFn == null) {
                        kFn = new j();
                    }
                }
            }
            jVar = kFn;
        }
        return jVar;
    }

    private j() {
    }

    public boolean bo(String str, int i) {
        try {
            return h.cVG().b("tb_message_center", "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.deleteByGid", new Object[0]);
            return false;
        }
    }

    public LinkedList<ImMessageCenterPojo> cVL() {
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor rawQuery = h.cVG().rawQuery("SELECT * FROM tb_message_center", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.f.b.toLong(rawQuery.getString(rawQuery.getColumnIndex("pull_msgid")), 0L));
                imMessageCenterPojo.setGid(rawQuery.getString(rawQuery.getColumnIndex("gid")));
                imMessageCenterPojo.setGroup_name(rawQuery.getString(rawQuery.getColumnIndex("group_name")));
                imMessageCenterPojo.setNameShow(rawQuery.getString(rawQuery.getColumnIndex("group_name_show")));
                imMessageCenterPojo.setGroup_head(rawQuery.getString(rawQuery.getColumnIndex("group_head")));
                imMessageCenterPojo.setCustomGroupType(rawQuery.getInt(rawQuery.getColumnIndex("custom_group_type")));
                imMessageCenterPojo.setIsFriend(rawQuery.getInt(rawQuery.getColumnIndex("is_friend")));
                imMessageCenterPojo.setUnread_count(rawQuery.getInt(rawQuery.getColumnIndex("unread_count")));
                imMessageCenterPojo.setLast_rid(rawQuery.getLong(rawQuery.getColumnIndex("last_msgId")));
                imMessageCenterPojo.setLast_user_name(rawQuery.getString(rawQuery.getColumnIndex("last_user_name")));
                imMessageCenterPojo.setLast_content_time(rawQuery.getLong(rawQuery.getColumnIndex("last_content_time")));
                imMessageCenterPojo.setSend_status(rawQuery.getInt(rawQuery.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                imMessageCenterPojo.setLast_content(rawQuery.getString(rawQuery.getColumnIndex("last_content")));
                imMessageCenterPojo.setPulled_msgId(rawQuery.getLong(rawQuery.getColumnIndex("pull_msgid")));
                imMessageCenterPojo.setIs_hidden(rawQuery.getInt(rawQuery.getColumnIndex("is_hidden")));
                a(imMessageCenterPojo, rawQuery.getString(rawQuery.getColumnIndex("ext2")));
                linkedList.add(imMessageCenterPojo);
            }
        }
        com.baidu.adp.lib.util.n.close(rawQuery);
        return linkedList;
    }

    public LinkedList<ImMessageCenterPojo> cVM() {
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        Cursor rawQuery = h.cVG().rawQuery("SELECT * FROM tb_message_center", null);
        if (rawQuery != null) {
            while (rawQuery.moveToNext()) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.f.b.toLong(rawQuery.getString(rawQuery.getColumnIndex("pull_msgid")), 0L));
                imMessageCenterPojo.setGid(rawQuery.getString(rawQuery.getColumnIndex("gid")));
                imMessageCenterPojo.setGroup_name(rawQuery.getString(rawQuery.getColumnIndex("group_name")));
                imMessageCenterPojo.setNameShow(rawQuery.getString(rawQuery.getColumnIndex("group_name_show")));
                imMessageCenterPojo.setGroup_head(rawQuery.getString(rawQuery.getColumnIndex("group_head")));
                imMessageCenterPojo.setCustomGroupType(rawQuery.getInt(rawQuery.getColumnIndex("custom_group_type")));
                imMessageCenterPojo.setIsFriend(rawQuery.getInt(rawQuery.getColumnIndex("is_friend")));
                imMessageCenterPojo.setUnread_count(rawQuery.getInt(rawQuery.getColumnIndex("unread_count")));
                imMessageCenterPojo.setLast_rid(rawQuery.getLong(rawQuery.getColumnIndex("last_msgId")));
                imMessageCenterPojo.setLast_user_name(rawQuery.getString(rawQuery.getColumnIndex("last_user_name")));
                imMessageCenterPojo.setLast_content_time(rawQuery.getLong(rawQuery.getColumnIndex("last_content_time")));
                imMessageCenterPojo.setSend_status(rawQuery.getInt(rawQuery.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                imMessageCenterPojo.setLast_content(rawQuery.getString(rawQuery.getColumnIndex("last_content")));
                imMessageCenterPojo.setPulled_msgId(rawQuery.getLong(rawQuery.getColumnIndex("pull_msgid")));
                imMessageCenterPojo.setIs_hidden(rawQuery.getInt(rawQuery.getColumnIndex("is_hidden")));
                imMessageCenterPojo.setSent_msgId(rawQuery.getLong(rawQuery.getColumnIndex("sent_mid")));
                imMessageCenterPojo.setRead_msgId(rawQuery.getLong(rawQuery.getColumnIndex("read_mid")));
                imMessageCenterPojo.setUserType(rawQuery.getInt(rawQuery.getColumnIndex("user_type")));
                imMessageCenterPojo.setSid(rawQuery.getLong(rawQuery.getColumnIndex(UbcStatConstant.KEY_CONTENT_EXT_SID)));
                imMessageCenterPojo.setTaskId(rawQuery.getString(rawQuery.getColumnIndex("task_id")));
                imMessageCenterPojo.setServiceId(rawQuery.getString(rawQuery.getColumnIndex(Constants.EXTRA_SERVICE)));
                imMessageCenterPojo.setPushIds(rawQuery.getString(rawQuery.getColumnIndex("ext1")));
                a(imMessageCenterPojo, rawQuery.getString(rawQuery.getColumnIndex("ext2")));
                linkedList.add(imMessageCenterPojo);
            }
        }
        com.baidu.adp.lib.util.n.close(rawQuery);
        return linkedList;
    }

    public ImMessageCenterPojo bp(String str, int i) {
        Cursor cursor;
        ImMessageCenterPojo imMessageCenterPojo;
        try {
            cursor = h.cVG().rawQuery("select * from tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        } catch (Exception e) {
            e = e;
            cursor = null;
            imMessageCenterPojo = null;
        } catch (Throwable th) {
            th = th;
            cursor = null;
            com.baidu.adp.lib.util.n.close(cursor);
            throw th;
        }
        if (cursor != null) {
            try {
                try {
                } catch (Exception e2) {
                    e = e2;
                    imMessageCenterPojo = null;
                }
                if (cursor.moveToNext()) {
                    imMessageCenterPojo = new ImMessageCenterPojo();
                    try {
                        imMessageCenterPojo.setPulled_msgId(com.baidu.adp.lib.f.b.toLong(cursor.getString(cursor.getColumnIndex("pull_msgid")), 0L));
                        imMessageCenterPojo.setGid(cursor.getString(cursor.getColumnIndex("gid")));
                        imMessageCenterPojo.setGroup_name(cursor.getString(cursor.getColumnIndex("group_name")));
                        imMessageCenterPojo.setNameShow(cursor.getString(cursor.getColumnIndex("group_name_show")));
                        imMessageCenterPojo.setGroup_head(cursor.getString(cursor.getColumnIndex("group_head")));
                        imMessageCenterPojo.setCustomGroupType(cursor.getInt(cursor.getColumnIndex("custom_group_type")));
                        imMessageCenterPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                        imMessageCenterPojo.setUnread_count(cursor.getInt(cursor.getColumnIndex("unread_count")));
                        imMessageCenterPojo.setLast_rid(cursor.getLong(cursor.getColumnIndex("last_msgId")));
                        imMessageCenterPojo.setLast_user_name(cursor.getString(cursor.getColumnIndex("last_user_name")));
                        imMessageCenterPojo.setLast_content_time(cursor.getLong(cursor.getColumnIndex("last_content_time")));
                        imMessageCenterPojo.setSend_status(cursor.getInt(cursor.getColumnIndex(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS)));
                        imMessageCenterPojo.setLast_content(cursor.getString(cursor.getColumnIndex("last_content")));
                        imMessageCenterPojo.setPulled_msgId(cursor.getLong(cursor.getColumnIndex("pull_msgid")));
                        imMessageCenterPojo.setIs_hidden(cursor.getInt(cursor.getColumnIndex("is_hidden")));
                        imMessageCenterPojo.setSent_msgId(cursor.getLong(cursor.getColumnIndex("sent_mid")));
                        imMessageCenterPojo.setRead_msgId(cursor.getLong(cursor.getColumnIndex("read_mid")));
                        imMessageCenterPojo.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                        imMessageCenterPojo.setSid(cursor.getLong(cursor.getColumnIndex(UbcStatConstant.KEY_CONTENT_EXT_SID)));
                        imMessageCenterPojo.setTaskId(cursor.getString(cursor.getColumnIndex("task_id")));
                        imMessageCenterPojo.setServiceId(cursor.getString(cursor.getColumnIndex(Constants.EXTRA_SERVICE)));
                        imMessageCenterPojo.setPushIds(cursor.getString(cursor.getColumnIndex("ext1")));
                        a(imMessageCenterPojo, cursor.getString(cursor.getColumnIndex("ext2")));
                        com.baidu.adp.lib.util.n.close(cursor);
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "ImMessageCenterDao.getGroupInfo", new Object[0]);
                        com.baidu.adp.lib.util.n.close(cursor);
                        return imMessageCenterPojo;
                    }
                    return imMessageCenterPojo;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.n.close(cursor);
                throw th;
            }
        }
        imMessageCenterPojo = null;
        com.baidu.adp.lib.util.n.close(cursor);
        return imMessageCenterPojo;
    }

    public LinkedList<ImMessageCenterPojo> cVN() {
        Cursor cursor;
        LinkedList<ImMessageCenterPojo> linkedList = new LinkedList<>();
        try {
            try {
                cursor = h.cVG().rawQuery("SELECT * FROM tb_message_center WHERE  custom_group_type IN (?,?,?,?,?)", new String[]{String.valueOf(1), String.valueOf(2), String.valueOf(4), String.valueOf(-2)});
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
                            com.baidu.adp.lib.util.n.close(cursor);
                            return null;
                        }
                    }
                }
                com.baidu.adp.lib.util.n.close(cursor);
                return linkedList;
            } catch (Throwable th) {
                th = th;
                com.baidu.adp.lib.util.n.close((Cursor) null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.n.close((Cursor) null);
            throw th;
        }
    }

    public void d(ImMessageCenterPojo imMessageCenterPojo) {
        a(imMessageCenterPojo, 1);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, int i) {
        a(imMessageCenterPojo, i, 1);
    }

    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, int i2) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gid", imMessageCenterPojo.getGid());
            contentValues.put(UbcStatConstant.KEY_CONTENT_EXT_SID, Long.valueOf(imMessageCenterPojo.getSid()));
            contentValues.put("task_id", imMessageCenterPojo.getTaskId());
            contentValues.put(Constants.EXTRA_SERVICE, imMessageCenterPojo.getServiceId());
            if (i2 == 2) {
                contentValues.put("ext1", imMessageCenterPojo.getPushIds());
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                contentValues.put("group_name_show", imMessageCenterPojo.getNameShow());
            }
            a(contentValues, imMessageCenterPojo);
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
                        Cursor rawQuery = h.cVG().rawQuery("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                        if (rawQuery != null && rawQuery.moveToNext()) {
                            int i3 = unread_count + rawQuery.getInt(rawQuery.getColumnIndex("unread_count"));
                            if (i3 > 0) {
                                contentValues.put("unread_count", Integer.valueOf(i3));
                            }
                        } else {
                            contentValues.put("unread_count", Integer.valueOf(unread_count));
                        }
                        com.baidu.adp.lib.util.n.close(rawQuery);
                    } catch (Exception e) {
                        BdLog.e(e);
                        com.baidu.adp.lib.util.n.close((Cursor) null);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.util.n.close((Cursor) null);
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
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
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
            contentValues.put("user_type", Integer.valueOf(imMessageCenterPojo.getUserType()));
            BdLog.i("sql-" + contentValues);
            if (h.cVG().b("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) == 0) {
                BdLog.i("insert");
                h.cVG().b("tb_message_center", (String) null, contentValues);
            }
        }
    }

    public void b(ImMessageCenterPojo imMessageCenterPojo, int i) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid())) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("gid", imMessageCenterPojo.getGid());
            if (!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) {
                contentValues.put("group_name", imMessageCenterPojo.getGroup_name());
            }
            if (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                contentValues.put("group_name_show", imMessageCenterPojo.getNameShow());
            }
            a(contentValues, imMessageCenterPojo);
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
                        Cursor rawQuery = h.cVG().rawQuery("SELECT * FROM tb_message_center WHERE gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())});
                        if (rawQuery != null && rawQuery.moveToNext()) {
                            int i2 = unread_count + rawQuery.getInt(rawQuery.getColumnIndex("unread_count"));
                            if (i2 > 0) {
                                contentValues.put("unread_count", Integer.valueOf(i2));
                            }
                        } else {
                            contentValues.put("unread_count", Integer.valueOf(unread_count));
                        }
                        com.baidu.adp.lib.util.n.close(rawQuery);
                    } catch (Exception e) {
                        BdLog.e(e);
                        com.baidu.adp.lib.util.n.close((Cursor) null);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.util.n.close((Cursor) null);
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
            contentValues.put(TableDefine.PaCmdQueueColumns.COLUMN_SEND_STATUS, Integer.valueOf(imMessageCenterPojo.getSend_status()));
            contentValues.put("is_hidden", Integer.valueOf(imMessageCenterPojo.getIs_hidden()));
            contentValues.put("is_friend", Integer.valueOf(imMessageCenterPojo.getIsFriend()));
            if (imMessageCenterPojo.getPulled_msgId() != 0) {
                contentValues.put("pull_msgid", Long.valueOf(imMessageCenterPojo.getPulled_msgId()));
            }
            BdLog.i("sql-" + contentValues);
            if (h.cVG().b("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{imMessageCenterPojo.getGid(), String.valueOf(imMessageCenterPojo.getCustomGroupType())}) == 0) {
                BdLog.i("insert");
                h.cVG().b("tb_message_center", (String) null, contentValues);
            }
        }
    }

    public void bq(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("unread_count", (Integer) 0);
            h.cVG().b("tb_message_center", contentValues, "gid=? AND custom_group_type=?", new String[]{str, String.valueOf(i)});
        }
    }

    public boolean cVO() {
        return h.cVG().b("tb_message_center", "custom_group_type=? AND is_friend!=?", new String[]{String.valueOf(2), String.valueOf(1)});
    }

    private void a(ContentValues contentValues, ImMessageCenterPojo imMessageCenterPojo) {
        if (contentValues != null && imMessageCenterPojo != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(imMessageCenterPojo.getBjhAvatar())) {
                    jSONObject.put("bjhAvatar", imMessageCenterPojo.getBjhAvatar());
                }
                contentValues.put("ext2", jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo, String str) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(str)) {
            try {
                imMessageCenterPojo.setBjhAvatar(new JSONObject(str).optString("bjhAvatar", null));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
