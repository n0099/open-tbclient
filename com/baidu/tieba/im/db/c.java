package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c aWH;

    private c() {
    }

    public static synchronized c Mu() {
        c cVar;
        synchronized (c.class) {
            if (aWH == null) {
                aWH = new c();
            }
            cVar = aWH;
        }
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [83=5] */
    public int gh(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = g.My().rawQuery("select count(*) from " + ("tb_group_msg_" + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor == null || !cursor.moveToNext()) {
                    t.b(cursor);
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
                t.b(cursor);
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [167=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00a8 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v5 */
    public long gi(String str) {
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
                Cursor rawQuery = g.My().rawQuery("select max(mid) from " + str2, null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.moveToNext()) {
                            j = rawQuery.getLong(0);
                            cursor = g.My().rawQuery("select count(*) from " + str2, null);
                            if (cursor != null && cursor.moveToNext()) {
                                i = cursor.getInt(0);
                            }
                            if (i == 1 || j % 100 == 0) {
                                t.b(cursor);
                                return j;
                            }
                            long af = com.baidu.tieba.im.util.h.af(j);
                            t.b(cursor);
                            return af;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        cursor2 = cursor;
                        try {
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                            e.printStackTrace();
                            gm(str);
                            t.b(cursor2);
                            return 0L;
                        } catch (Throwable th) {
                            th = th;
                            r4 = cursor2;
                            t.b((Cursor) r4);
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        t.b(cursor);
                        return 0L;
                    }
                }
                j = 0;
                cursor = g.My().rawQuery("select count(*) from " + str2, null);
                if (cursor != null) {
                    i = cursor.getInt(0);
                }
                if (i == 1) {
                }
                t.b(cursor);
                return j;
            } catch (Throwable th2) {
                th = th2;
                t.b((Cursor) r4);
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
            t.b((Cursor) r4);
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x012f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0131 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0133 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x0017 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public CommonMsgPojo gj(String str) {
        Throwable th;
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        if (!TextUtils.isEmpty(str)) {
            ?? r2 = "tb_group_msg_";
            try {
                try {
                    cursor = g.My().rawQuery("select * from " + ("tb_group_msg_" + str) + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                        if (cursor == null || !cursor.moveToNext()) {
                            t.b(cursor);
                            r2 = cursor;
                        } else {
                            commonMsgPojo2.setGid(str);
                            commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                            commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                            commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                            commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            t.b(cursor);
                            commonMsgPojo = commonMsgPojo2;
                            r2 = cursor;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        gm(str);
                        t.b(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        t.b(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    t.b((Cursor) r2);
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
                t.b((Cursor) r2);
                throw th;
            }
        }
        return commonMsgPojo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [292=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0151 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.StringBuilder] */
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
                    cursor = g.My().rawQuery("select * from " + r2 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    cursor = g.My().rawQuery("select * from " + r2 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                            t.b(cursor);
                            return linkedHashMap;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                            t.b(cursor);
                            return linkedHashMap;
                        }
                    }
                }
                t.b(cursor);
            } catch (Throwable th2) {
                th = th2;
                t.b((Cursor) r2);
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
            t.b((Cursor) r2);
            throw th;
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [465=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x020d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v28, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.StringBuilder] */
    public LinkedList<ChatMessage> a(String str, String str2, String str3, int i) {
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
                if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
                    cursor = g.My().rawQuery("select * from " + r2 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i, new String[]{str3, String.valueOf(0)});
                } else if (TextUtils.isEmpty(str2)) {
                    cursor = g.My().rawQuery("select * from " + r2 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{String.valueOf(0)});
                } else {
                    cursor = g.My().rawQuery("select * from " + r2 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{str2, String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            CommonGroupChatMessage commonGroupChatMessage = new CommonGroupChatMessage();
                            commonGroupChatMessage.setGroupId(str);
                            commonGroupChatMessage.setContent(cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                            commonGroupChatMessage.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonGroupChatMessage.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            commonGroupChatMessage.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            MsgLocalData msgLocalData = new MsgLocalData();
                            commonGroupChatMessage.setLocalData(msgLocalData);
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex("msg_status"))));
                            commonGroupChatMessage.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonGroupChatMessage.setUserId(cursor.getColumnIndex(SapiAccountManager.SESSION_UID));
                            commonGroupChatMessage.setUserInfo((UserData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                            commonGroupChatMessage.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            com.baidu.tieba.im.util.i.u(commonGroupChatMessage);
                            linkedList.addFirst(commonGroupChatMessage);
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            e2.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getAll", new Object[0]);
                            gm(str);
                            t.b(cursor);
                            return linkedList;
                        } catch (Exception e4) {
                            e = e4;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                            t.b(cursor);
                            return linkedList;
                        }
                    }
                }
                t.b(cursor);
            } catch (Throwable th2) {
                th = th2;
                t.b((Cursor) r2);
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
            t.b((Cursor) r2);
            throw th;
        }
        return linkedList;
    }

    public boolean b(String str, String str2, String str3, int i) {
        Boolean bool = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        String str4 = "tb_group_msg_" + str;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str3);
            contentValues.put("msg_status", Integer.valueOf(i));
            if (g.My().update(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
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

    public boolean a(String str, List<CommonMsgPojo> list, boolean z) {
        SQLiteStatement sQLiteStatement;
        if (list == null || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return false;
        }
        String str2 = "tb_group_msg_" + str;
        SQLiteStatement sQLiteStatement2 = null;
        try {
            try {
                SQLiteStatement compileStatement = g.My().compileStatement(" INSERT INTO " + str2 + "(" + CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT + ",create_time,ext,mid,msg_status,msg_type," + SapiAccountManager.SESSION_UID + ",user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                try {
                    for (CommonMsgPojo commonMsgPojo : list) {
                        if (z && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                            g.My().a(str2, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                        }
                        if (commonMsgPojo.getContent() == null) {
                            commonMsgPojo.setContent("");
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, commonMsgPojo.getContent());
                        contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                        contentValues.put("ext", commonMsgPojo.getExt());
                        contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                        contentValues.put("msg_status", Integer.valueOf(commonMsgPojo.getMsg_status()));
                        contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                        contentValues.put(SapiAccountManager.SESSION_UID, commonMsgPojo.getUid());
                        contentValues.put("user_info", commonMsgPojo.getUser_info());
                        contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                        contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                        contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                        if (g.My().update(str2, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, TextUtils.isEmpty(commonMsgPojo.getContent()) ? "" : commonMsgPojo.getContent());
                            compileStatement.bindLong(2, commonMsgPojo.getCreate_time());
                            compileStatement.bindString(3, TextUtils.isEmpty(commonMsgPojo.getExt()) ? "" : commonMsgPojo.getExt());
                            compileStatement.bindLong(4, commonMsgPojo.getMid());
                            compileStatement.bindLong(5, commonMsgPojo.getMsg_status());
                            compileStatement.bindLong(6, commonMsgPojo.getMsg_type());
                            compileStatement.bindString(7, TextUtils.isEmpty(commonMsgPojo.getUid()) ? "" : commonMsgPojo.getUid());
                            compileStatement.bindString(8, TextUtils.isEmpty(commonMsgPojo.getUser_info()) ? "" : commonMsgPojo.getUser_info());
                            compileStatement.bindLong(9, commonMsgPojo.getRid());
                            compileStatement.bindLong(10, commonMsgPojo.getRead_flag());
                            compileStatement.bindLong(11, commonMsgPojo.getIs_delete());
                            g.My().b(compileStatement);
                        }
                    }
                    t.b((Cursor) null);
                    t.a(compileStatement);
                    return true;
                } catch (Exception e) {
                    e = e;
                    sQLiteStatement = compileStatement;
                    try {
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                        t.b((Cursor) null);
                        t.a(sQLiteStatement);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        sQLiteStatement2 = sQLiteStatement;
                        t.b((Cursor) null);
                        t.a(sQLiteStatement2);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                t.b((Cursor) null);
                t.a(sQLiteStatement2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            sQLiteStatement = null;
        }
    }

    public void an(List<ImMessageCenterPojo> list) {
        Cursor cursor = null;
        if (list != null && list.size() != 0) {
            LinkedList linkedList = new LinkedList();
            try {
                cursor = g.My().rawQuery("select * from sqlite_master where type='table'", null);
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
                t.b(cursor);
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (!linkedList.contains("tb_group_msg_" + imMessageCenterPojo.getGid())) {
                    gm(imMessageCenterPojo.getGid());
                }
            }
        }
    }

    public boolean aw(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            g.My().update("tb_group_msg_" + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean ax(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            g.My().a("tb_group_msg_" + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean gk(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                g.My().gs("DROP TABLE IF EXISTS " + ("tb_group_msg_" + str));
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.deleteMsgTableById", new Object[0]);
            }
        }
        return false;
    }

    public void gm(String str) {
        if (!TextUtils.isEmpty(str)) {
            g.My().gs("CREATE TABLE IF NOT EXISTS " + ("tb_group_msg_" + str) + "(mid BIGINT PRIMARY KEY, " + SapiAccountManager.SESSION_UID + " TEXT, user_info blob, create_time BIGINT, msg_type int, msg_status int, " + CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT + " blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);");
        }
    }

    public boolean w(String str, int i) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            String str2 = "tb_group_msg_" + str;
            if (i < 1000) {
                i = 1000;
            }
            cursor = g.My().rawQuery("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
            try {
                try {
                    String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                    t.b(cursor);
                    if (string != null) {
                        g.My().a(str2, "mid<?", new String[]{string});
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
