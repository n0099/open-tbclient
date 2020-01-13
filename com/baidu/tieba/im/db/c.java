package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c hvN;

    private c() {
    }

    public static synchronized c bSI() {
        c cVar;
        synchronized (c.class) {
            if (hvN == null) {
                hvN = new c();
            }
            cVar = hvN;
        }
        return cVar;
    }

    public int Cs(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = h.bSP().rawQuery("select count(*) from " + ("tb_group_msg_" + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor == null || !cursor.moveToNext()) {
                    com.baidu.adp.lib.util.n.close(cursor);
                } else {
                    i = cursor.getInt(0);
                }
            } catch (SQLiteException e) {
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getUnreadcount", new Object[0]);
                e.printStackTrace();
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getUnreadcount", new Object[0]);
                e2.printStackTrace();
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
        return i;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00b9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public long Ct(String str) {
        Cursor cursor;
        long j;
        Cursor cursor2 = null;
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        ?? r4 = "tb_group_msg_";
        String str2 = "tb_group_msg_" + str;
        try {
            try {
                Cursor rawQuery = h.bSP().rawQuery("select max(mid) from " + str2, null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToNext()) {
                            j = rawQuery.getLong(0);
                            cursor = h.bSP().rawQuery("select count(*) from " + str2, null);
                            if (cursor != null && cursor.moveToNext()) {
                                i = cursor.getInt(0);
                            }
                            if (i == 1 || j % 100 == 0) {
                                com.baidu.adp.lib.util.n.close(cursor);
                                return j;
                            }
                            long ec = com.baidu.tieba.im.util.d.ec(j);
                            com.baidu.adp.lib.util.n.close(cursor);
                            return ec;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        cursor2 = cursor;
                        try {
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                            e.printStackTrace();
                            Cy(str);
                            com.baidu.adp.lib.util.n.close(cursor2);
                            return 0L;
                        } catch (Throwable th) {
                            th = th;
                            r4 = cursor2;
                            com.baidu.adp.lib.util.n.close((Cursor) r4);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.close(cursor);
                        return 0L;
                    }
                }
                j = 0;
                cursor = h.bSP().rawQuery("select count(*) from " + str2, null);
                if (cursor != null) {
                    i = cursor.getInt(0);
                }
                if (i == 1) {
                }
                com.baidu.adp.lib.util.n.close(cursor);
                return j;
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.n.close((Cursor) r4);
                throw th;
            }
        } catch (SQLiteException e3) {
            e = e3;
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            r4 = 0;
            com.baidu.adp.lib.util.n.close((Cursor) r4);
            throw th;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x014b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x014d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x014f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x001c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public CommonMsgPojo Cu(String str) {
        Throwable th;
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        if (!TextUtils.isEmpty(str)) {
            ?? r2 = "tb_group_msg_";
            try {
                try {
                    cursor = h.bSP().rawQuery("select * from " + ("tb_group_msg_" + str) + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                        if (cursor == null || !cursor.moveToNext()) {
                            com.baidu.adp.lib.util.n.close(cursor);
                            r2 = cursor;
                        } else {
                            commonMsgPojo2.setGid(str);
                            commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            com.baidu.adp.lib.util.n.close(cursor);
                            commonMsgPojo = commonMsgPojo2;
                            r2 = cursor;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        Cy(str);
                        com.baidu.adp.lib.util.n.close(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        com.baidu.adp.lib.util.n.close(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.util.n.close((Cursor) r2);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                com.baidu.adp.lib.util.n.close((Cursor) r2);
                throw th;
            }
        }
        return commonMsgPojo;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x017b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.database.Cursor] */
    public LinkedHashMap<String, String> a(String str, int i, String str2, int i2) {
        Throwable th;
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i2 <= 0) {
            i2 = 20;
        }
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        ?? r2 = "tb_group_msg_" + str;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    cursor = h.bSP().rawQuery("select * from " + ((String) r2) + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    cursor = h.bSP().rawQuery("select * from " + ((String) r2) + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex("content")));
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedHashMap;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedHashMap;
                        }
                    }
                }
                com.baidu.adp.lib.util.n.close(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.n.close((Cursor) r2);
                throw th;
            }
        } catch (SQLiteException e5) {
            cursor = null;
            e2 = e5;
        } catch (Exception e6) {
            cursor = null;
            e = e6;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            com.baidu.adp.lib.util.n.close((Cursor) r2);
            throw th;
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x0245 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.database.Cursor] */
    public LinkedList<ChatMessage> f(String str, String str2, String str3, int i) {
        Throwable th;
        Cursor cursor;
        Exception e;
        SQLiteException e2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i <= 0) {
            i = 20;
        }
        LinkedList<ChatMessage> linkedList = new LinkedList<>();
        ?? r2 = "tb_group_msg_" + str;
        try {
            try {
                if (TextUtils.isEmpty(str3) || "0".equals(str3)) {
                    if (TextUtils.isEmpty(str2)) {
                        cursor = h.bSP().rawQuery("select * from " + ((String) r2) + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{String.valueOf(0)});
                    } else {
                        cursor = h.bSP().rawQuery("select * from " + ((String) r2) + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{str2, String.valueOf(0)});
                    }
                } else {
                    cursor = h.bSP().rawQuery("select * from " + ((String) r2) + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i, new String[]{str3, String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            CommonGroupChatMessage commonGroupChatMessage = new CommonGroupChatMessage();
                            commonGroupChatMessage.setGroupId(str);
                            commonGroupChatMessage.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonGroupChatMessage.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonGroupChatMessage.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            commonGroupChatMessage.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            MsgLocalData msgLocalData = new MsgLocalData();
                            commonGroupChatMessage.setLocalData(msgLocalData);
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                            commonGroupChatMessage.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonGroupChatMessage.setUserId(cursor.getColumnIndex("uid"));
                            commonGroupChatMessage.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                            commonGroupChatMessage.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            com.baidu.tieba.im.util.e.u(commonGroupChatMessage);
                            linkedList.addFirst(commonGroupChatMessage);
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getAll", new Object[0]);
                            Cy(str);
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedList;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedList;
                        }
                    }
                }
                com.baidu.adp.lib.util.n.close(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.n.close((Cursor) r2);
                throw th;
            }
        } catch (SQLiteException e5) {
            cursor = null;
            e2 = e5;
        } catch (Exception e6) {
            cursor = null;
            e = e6;
        } catch (Throwable th3) {
            r2 = 0;
            th = th3;
            com.baidu.adp.lib.util.n.close((Cursor) r2);
            throw th;
        }
        return linkedList;
    }

    public boolean g(String str, String str2, String str3, int i) {
        Boolean bool = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        String str4 = "tb_group_msg_" + str;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str3);
            contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
            if (h.bSP().a(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
                bool = true;
            } else {
                bool = false;
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.updateState", new Object[0]);
            e.printStackTrace();
        }
        return bool.booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [591=4] */
    public boolean a(String str, List<CommonMsgPojo> list, boolean z) {
        SQLiteStatement sQLiteStatement;
        SQLiteStatement CI;
        if (list == null || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return false;
        }
        String str2 = "tb_group_msg_" + str;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            try {
                CI = h.bSP().CI(" INSERT INTO " + str2 + "(content" + Constants.ACCEPT_TIME_SEPARATOR_SP + "create_time" + Constants.ACCEPT_TIME_SEPARATOR_SP + "ext" + Constants.ACCEPT_TIME_SEPARATOR_SP + "mid" + Constants.ACCEPT_TIME_SEPARATOR_SP + IMConstants.MSG_STATUS + Constants.ACCEPT_TIME_SEPARATOR_SP + "msg_type" + Constants.ACCEPT_TIME_SEPARATOR_SP + "uid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "user_info" + Constants.ACCEPT_TIME_SEPARATOR_SP + "rid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "read_flag" + Constants.ACCEPT_TIME_SEPARATOR_SP + "is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            } catch (Exception e) {
                e = e;
                sQLiteStatement = null;
            }
            try {
                for (CommonMsgPojo commonMsgPojo : list) {
                    if (z && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                        h.bSP().a(str2, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                    }
                    if (commonMsgPojo.getContent() == null) {
                        commonMsgPojo.setContent("");
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content", commonMsgPojo.getContent());
                    contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                    contentValues.put("ext", commonMsgPojo.getExt());
                    contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                    contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(commonMsgPojo.getMsg_status()));
                    contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                    contentValues.put("uid", commonMsgPojo.getUid());
                    contentValues.put("user_info", commonMsgPojo.getUser_info());
                    contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                    contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                    contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                    if (h.bSP().a(str2, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
                        CI.clearBindings();
                        CI.bindString(1, TextUtils.isEmpty(commonMsgPojo.getContent()) ? "" : commonMsgPojo.getContent());
                        CI.bindLong(2, commonMsgPojo.getCreate_time());
                        CI.bindString(3, TextUtils.isEmpty(commonMsgPojo.getExt()) ? "" : commonMsgPojo.getExt());
                        CI.bindLong(4, commonMsgPojo.getMid());
                        CI.bindLong(5, commonMsgPojo.getMsg_status());
                        CI.bindLong(6, commonMsgPojo.getMsg_type());
                        CI.bindString(7, TextUtils.isEmpty(commonMsgPojo.getUid()) ? "" : commonMsgPojo.getUid());
                        CI.bindString(8, TextUtils.isEmpty(commonMsgPojo.getUser_info()) ? "" : commonMsgPojo.getUser_info());
                        CI.bindLong(9, commonMsgPojo.getRid());
                        CI.bindLong(10, commonMsgPojo.getRead_flag());
                        CI.bindLong(11, commonMsgPojo.getIs_delete());
                        h.bSP().a(CI);
                    }
                }
                com.baidu.adp.lib.util.n.close((Cursor) null);
                com.baidu.adp.lib.util.n.close(CI);
                return true;
            } catch (Exception e2) {
                e = e2;
                sQLiteStatement = CI;
                try {
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                    com.baidu.adp.lib.util.n.close((Cursor) null);
                    com.baidu.adp.lib.util.n.close(sQLiteStatement);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    sQLiteStatement2 = sQLiteStatement;
                    com.baidu.adp.lib.util.n.close((Cursor) null);
                    com.baidu.adp.lib.util.n.close(sQLiteStatement2);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.n.close((Cursor) null);
            com.baidu.adp.lib.util.n.close(sQLiteStatement2);
            throw th;
        }
    }

    public void cU(List<ImMessageCenterPojo> list) {
        Cursor cursor = null;
        if (list != null && list.size() != 0) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = h.bSP().rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.createMsgTable", new Object[0]);
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (!linkedList.contains("tb_group_msg_" + imMessageCenterPojo.getGid())) {
                    Cy(imMessageCenterPojo.getGid());
                }
            }
        }
    }

    public boolean dr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            h.bSP().a("tb_group_msg_" + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean ds(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            h.bSP().a("tb_group_msg_" + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean Cv(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                h.bSP().CH("DROP TABLE IF EXISTS " + ("tb_group_msg_" + str));
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.dropMsgTableById", new Object[0]);
            }
        }
        return false;
    }

    public boolean Cw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            h.bSP().CH("delete from " + ("tb_group_msg_" + str));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.deleteMsgTableById", new Object[0]);
            return false;
        }
    }

    public void Cy(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.bSP().CH("CREATE TABLE IF NOT EXISTS " + ("tb_group_msg_" + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);");
        }
    }

    public boolean aM(String str, int i) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            String str2 = "tb_group_msg_" + str;
            if (i < 1000) {
                i = 1000;
            }
            cursor = h.bSP().rawQuery("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
            try {
                try {
                    String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                    com.baidu.adp.lib.util.n.close(cursor);
                    if (string != null) {
                        h.bSP().a(str2, "mid<?", new String[]{string});
                    }
                    com.baidu.adp.lib.util.n.close(cursor);
                    return true;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                    com.baidu.adp.lib.util.n.close(cursor);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                com.baidu.adp.lib.util.n.close(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.n.close(cursor2);
            throw th;
        }
    }
}
