package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class a {
    private String HEAD;
    private Class<? extends ChatMessage> kbX;
    List<String> kbY = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, Class<? extends ChatMessage> cls) {
        this.HEAD = str;
        this.kbX = cls;
    }

    public int Ms(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = h.cRb().rawQuery("select count(*) from " + (this.HEAD + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor == null || !cursor.moveToNext()) {
                    com.baidu.adp.lib.util.n.close(cursor);
                } else {
                    i = cursor.getInt(0);
                }
            } catch (SQLiteException e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getUnreadcount", new Object[0]);
                e.printStackTrace();
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getUnreadcount", new Object[0]);
                e2.printStackTrace();
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
        return i;
    }

    public long Mt(String str) {
        long j = 0;
        Cursor cursor = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cursor = h.cRb().rawQuery("select max(mid) from " + (this.HEAD + str), null);
                if (cursor == null || !cursor.moveToNext()) {
                    com.baidu.adp.lib.util.n.close(cursor);
                } else {
                    j = cursor.getLong(0);
                }
            } catch (SQLiteException e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e.printStackTrace();
                My(str);
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e2.printStackTrace();
            } finally {
                com.baidu.adp.lib.util.n.close(cursor);
            }
        }
        return j;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x0174 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0176 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x0178 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public CommonMsgPojo Mu(String str) {
        Throwable th;
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        if (!TextUtils.isEmpty(str)) {
            ?? sb = new StringBuilder();
            ?? r2 = this.HEAD;
            try {
                try {
                    cursor = h.cRb().rawQuery("select * from " + sb.append(r2).append(str).toString() + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                        if (cursor == null || !cursor.moveToNext()) {
                            com.baidu.adp.lib.util.n.close(cursor);
                            r2 = cursor;
                        } else {
                            commonMsgPojo2.setGid(str);
                            commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo2.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                            commonMsgPojo2.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo2.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            com.baidu.adp.lib.util.n.close(cursor);
                            commonMsgPojo = commonMsgPojo2;
                            r2 = cursor;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        My(str);
                        com.baidu.adp.lib.util.n.close(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x017d */
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
        ?? r2 = this.HEAD + str;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    cursor = h.cRb().rawQuery("select * from " + ((String) r2) + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    cursor = h.cRb().rawQuery("select * from " + ((String) r2) + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex("content")));
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e2.printStackTrace();
                            My(str);
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedHashMap;
                        } catch (Exception e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e.printStackTrace();
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

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:41:0x029e */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    public LinkedList<ChatMessage> b(long j, String str, String str2, int i) {
        Throwable th;
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        SQLiteException e2;
        if (j == 0) {
            return null;
        }
        String valueOf = String.valueOf(j);
        if (i <= 0) {
            i = 20;
        }
        LinkedList<ChatMessage> linkedList = new LinkedList<>();
        ?? sb = new StringBuilder();
        ?? r5 = this.HEAD;
        String sb2 = sb.append(r5).append(valueOf).toString();
        try {
            try {
                if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                    if (TextUtils.isEmpty(str)) {
                        cursor = h.cRb().rawQuery("select * from " + sb2 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{String.valueOf(0)});
                    } else {
                        cursor = h.cRb().rawQuery("select * from " + sb2 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{str, String.valueOf(0)});
                    }
                } else {
                    cursor = h.cRb().rawQuery("select * from " + sb2 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i, new String[]{str2, String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            ChatMessage newInstance = this.kbX.newInstance();
                            newInstance.setGroupId(String.valueOf(com.baidu.tieba.im.sendmessage.a.kox));
                            newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            newInstance.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                            newInstance.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                            newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                            newInstance.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                            MsgLocalData msgLocalData = new MsgLocalData();
                            newInstance.setLocalData(msgLocalData);
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                            newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            com.baidu.tieba.im.util.e.u(newInstance);
                            newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            int columnIndex = cursor.getColumnIndex("read_count");
                            if (columnIndex >= 0) {
                                newInstance.setReadCountPv(cursor.getInt(columnIndex));
                            }
                            linkedList.addFirst(newInstance);
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            cursor2 = cursor;
                            try {
                                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAll", new Object[0]);
                                e2.printStackTrace();
                                My(valueOf);
                                com.baidu.adp.lib.util.n.close(cursor2);
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                r5 = cursor2;
                                com.baidu.adp.lib.util.n.close((Cursor) r5);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(cursor);
                            return linkedList;
                        }
                    }
                }
                com.baidu.adp.lib.util.n.close(cursor);
            } catch (Throwable th3) {
                th = th3;
                com.baidu.adp.lib.util.n.close((Cursor) r5);
                throw th;
            }
        } catch (SQLiteException e5) {
            cursor2 = null;
            e2 = e5;
        } catch (Exception e6) {
            cursor = null;
            e = e6;
        } catch (Throwable th4) {
            r5 = 0;
            th = th4;
            com.baidu.adp.lib.util.n.close((Cursor) r5);
            throw th;
        }
        return linkedList;
    }

    public boolean a(long j, long j2, String str, String str2, int i) {
        Boolean bool;
        if (j == 0 || j2 == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        String valueOf = String.valueOf(j);
        if (TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
            valueOf = String.valueOf(j2);
        }
        String str3 = this.HEAD + valueOf;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
            if (h.cRb().a(str3, contentValues, "mid=?", new String[]{str}) > 0) {
                bool = true;
            } else {
                bool = false;
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
            e.printStackTrace();
            bool = false;
        }
        return bool.booleanValue();
    }

    public void m(long j, boolean z) {
        String str = this.HEAD + j;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
            h.cRb().a(str, contentValues, "uid!=?", new String[]{"0"});
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
            e.printStackTrace();
        }
    }

    public boolean a(long j, List<CommonMsgPojo> list, boolean z) {
        if (list == null || j == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
            return false;
        }
        String valueOf = String.valueOf(j);
        String str = this.HEAD + valueOf;
        if (this.kbY == null) {
            this.kbY = cQQ();
        }
        if (!this.kbY.contains(valueOf)) {
            My(valueOf);
            this.kbY.add(valueOf);
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = h.cRb().MI(" INSERT INTO " + str + "(content" + Constants.ACCEPT_TIME_SEPARATOR_SP + "create_time" + Constants.ACCEPT_TIME_SEPARATOR_SP + "ext" + Constants.ACCEPT_TIME_SEPARATOR_SP + "mid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "uid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "user_info" + Constants.ACCEPT_TIME_SEPARATOR_SP + "to_uid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "to_user_info" + Constants.ACCEPT_TIME_SEPARATOR_SP + IMConstants.MSG_STATUS + Constants.ACCEPT_TIME_SEPARATOR_SP + "msg_type" + Constants.ACCEPT_TIME_SEPARATOR_SP + "rid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "read_flag" + Constants.ACCEPT_TIME_SEPARATOR_SP + "is_delete" + Constants.ACCEPT_TIME_SEPARATOR_SP + "is_friend) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            for (CommonMsgPojo commonMsgPojo : list) {
                if (z && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                    h.cRb().a(str, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("content", commonMsgPojo.getContent());
                contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                contentValues.put("ext", commonMsgPojo.getExt());
                contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                contentValues.put("uid", commonMsgPojo.getUid());
                contentValues.put("user_info", commonMsgPojo.getUser_info());
                contentValues.put("to_uid", commonMsgPojo.getToUid());
                contentValues.put("to_user_info", commonMsgPojo.getToUser_info());
                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(commonMsgPojo.getMsg_status()));
                contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                contentValues.put("is_friend", Integer.valueOf(commonMsgPojo.getIsFriend()));
                if (h.cRb().a(str, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
                    sQLiteStatement.clearBindings();
                    sQLiteStatement.bindString(1, commonMsgPojo.getContent());
                    sQLiteStatement.bindLong(2, commonMsgPojo.getCreate_time());
                    sQLiteStatement.bindString(3, commonMsgPojo.getExt());
                    sQLiteStatement.bindLong(4, commonMsgPojo.getMid());
                    sQLiteStatement.bindString(5, commonMsgPojo.getUid());
                    sQLiteStatement.bindString(6, commonMsgPojo.getUser_info());
                    sQLiteStatement.bindString(7, commonMsgPojo.getToUid());
                    sQLiteStatement.bindString(8, commonMsgPojo.getToUser_info());
                    sQLiteStatement.bindLong(9, commonMsgPojo.getMsg_status());
                    sQLiteStatement.bindLong(10, commonMsgPojo.getMsg_type());
                    sQLiteStatement.bindLong(11, commonMsgPojo.getRid());
                    sQLiteStatement.bindLong(12, commonMsgPojo.getRead_flag());
                    sQLiteStatement.bindLong(13, commonMsgPojo.getIs_delete());
                    sQLiteStatement.bindLong(14, commonMsgPojo.getIsFriend());
                    sQLiteStatement.executeInsert();
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
            e.printStackTrace();
            Boolean.valueOf(false);
        } finally {
            com.baidu.adp.lib.util.n.close((Cursor) null);
            com.baidu.adp.lib.util.n.close(sQLiteStatement);
        }
        Boolean bool = true;
        return bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void l(LinkedList<String> linkedList) {
        Cursor cursor;
        Iterator<String> it;
        if (linkedList != null && linkedList.size() != 0) {
            LinkedList linkedList2 = new LinkedList();
            try {
                cursor = h.cRb().rawQuery("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    try {
                        try {
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                linkedList2.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        } catch (Exception e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.close(cursor);
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.close(cursor);
                        throw th;
                    }
                }
                com.baidu.adp.lib.util.n.close(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                com.baidu.adp.lib.util.n.close(cursor);
                throw th;
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !linkedList2.contains(next)) {
                    My(next);
                }
            }
        }
        return null;
    }

    public boolean fn(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            h.cRb().a(this.HEAD + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean fo(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h.cRb().a(this.HEAD + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean Mv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.kbY == null) {
            this.kbY = cQQ();
        }
        if (this.kbY != null && this.kbY.contains(str)) {
            Iterator<String> it = this.kbY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.kbY.remove(next);
                    break;
                }
            }
        }
        return h.cRb().MH("DROP TABLE IF EXISTS " + (this.HEAD + str));
    }

    public boolean Mw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.kbY == null) {
            this.kbY = cQQ();
        }
        if (this.kbY != null && this.kbY.contains(str)) {
            Iterator<String> it = this.kbY.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.kbY.remove(next);
                    break;
                }
            }
        }
        return h.cRb().MH("delete from " + (this.HEAD + str));
    }

    public boolean Mx(String str) {
        try {
            m(Long.parseLong(str), true);
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
            return false;
        }
    }

    public synchronized void My(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.cRb().MH("CREATE TABLE IF NOT EXISTS " + (this.HEAD + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT, is_friend int default 1, read_count LONG default -1);");
        }
    }

    public LinkedList<String> cQQ() {
        Cursor cursor = null;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            cursor = h.cRb().rawQuery("select * from sqlite_master where type='table'", null);
            if (cursor != null) {
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    if (string.startsWith(this.HEAD)) {
                        linkedList.add(string.subSequence(this.HEAD.length(), string.length()).toString());
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
            e.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.n.close(cursor);
        }
        return linkedList;
    }

    public void cQR() {
        this.kbY = null;
    }

    public boolean ba(String str, int i) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            String str2 = this.HEAD + str;
            if (i < 1000) {
                i = 1000;
            }
            cursor = h.cRb().rawQuery("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
            try {
                try {
                    String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                    com.baidu.adp.lib.util.n.close(cursor);
                    if (string != null) {
                        h.cRb().a(str2, "mid<?", new String[]{string});
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

    public LinkedList<ChatMessage> b(Map<String, com.baidu.tieba.im.db.pojo.a> map, int i) {
        Cursor cursor = null;
        if (map == null || map.size() <= 0) {
            return null;
        }
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM(");
        Iterator<String> it = keySet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            sb.append("SELECT * FROM ").append(this.HEAD + it.next()).append(" WHERE ").append("msg_type").append(" = 7").append(" AND ").append("is_delete").append(" = ").append(0);
            int i3 = i2 + 1;
            if (i2 != map.size() - 1) {
                sb.append(" UNION ALL ");
            }
            i2 = i3;
        }
        sb.append(") ORDER BY ").append("create_time").append(" DESC LIMIT ?");
        LinkedList<ChatMessage> linkedList = new LinkedList<>();
        try {
            cursor = h.cRb().rawQuery(sb.toString(), new String[]{String.valueOf(i)});
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    ChatMessage newInstance = this.kbX.newInstance();
                    newInstance.setObjContent(map.get(cursor.getString(cursor.getColumnIndex("uid"))));
                    newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                    newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                    newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                    newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                    newInstance.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                    newInstance.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                    newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                    newInstance.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                    MsgLocalData msgLocalData = new MsgLocalData();
                    newInstance.setLocalData(msgLocalData);
                    msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                    newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                    newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                    newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                    int columnIndex = cursor.getColumnIndex("read_count");
                    if (columnIndex >= 0) {
                        newInstance.setReadCountPv(cursor.getInt(columnIndex));
                    }
                    linkedList.add(newInstance);
                }
            }
        } catch (SQLiteException e) {
            TiebaStatic.printDBExceptionLog(e, "OfficialMsgDao.getOfficialMsgByGid", new Object[0]);
            e.printStackTrace();
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "OfficialMsgDao.getOfficialMsgByGid", new Object[0]);
            e2.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.n.close(cursor);
        }
        return linkedList;
    }
}
