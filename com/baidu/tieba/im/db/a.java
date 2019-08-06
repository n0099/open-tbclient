package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
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
/* loaded from: classes.dex */
public abstract class a {
    private String gFe;
    private Class<? extends ChatMessage> gFf;
    List<String> gFg = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, Class<? extends ChatMessage> cls) {
        this.gFe = str;
        this.gFf = cls;
    }

    public int yI(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = h.bCU().b("select count(*) from " + (this.gFe + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor == null || !cursor.moveToNext()) {
                    com.baidu.adp.lib.util.n.e(cursor);
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
                com.baidu.adp.lib.util.n.e(cursor);
            }
        }
        return i;
    }

    public long yJ(String str) {
        long j = 0;
        Cursor cursor = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cursor = h.bCU().b("select max(mid) from " + (this.gFe + str), null);
                if (cursor == null || !cursor.moveToNext()) {
                    com.baidu.adp.lib.util.n.e(cursor);
                } else {
                    j = cursor.getLong(0);
                }
            } catch (SQLiteException e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e.printStackTrace();
                yO(str);
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e2.printStackTrace();
            } finally {
                com.baidu.adp.lib.util.n.e(cursor);
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
    public CommonMsgPojo yK(String str) {
        Throwable th;
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        if (!TextUtils.isEmpty(str)) {
            ?? sb = new StringBuilder();
            ?? r2 = this.gFe;
            try {
                try {
                    cursor = h.bCU().b("select * from " + sb.append(r2).append(str).toString() + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                        if (cursor == null || !cursor.moveToNext()) {
                            com.baidu.adp.lib.util.n.e(cursor);
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
                            commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                            commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo2.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            com.baidu.adp.lib.util.n.e(cursor);
                            commonMsgPojo = commonMsgPojo2;
                            r2 = cursor;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        yO(str);
                        com.baidu.adp.lib.util.n.e(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        com.baidu.adp.lib.util.n.e(cursor);
                        r2 = cursor;
                        return commonMsgPojo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.baidu.adp.lib.util.n.e(r2);
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
                com.baidu.adp.lib.util.n.e(r2);
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
        ?? r2 = this.gFe + str;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    cursor = h.bCU().b("select * from " + ((String) r2) + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    cursor = h.bCU().b("select * from " + ((String) r2) + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex("content")));
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e2.printStackTrace();
                            yO(str);
                            com.baidu.adp.lib.util.n.e(cursor);
                            return linkedHashMap;
                        } catch (Exception e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.e(cursor);
                            return linkedHashMap;
                        }
                    }
                }
                com.baidu.adp.lib.util.n.e(cursor);
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.util.n.e(r2);
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
            com.baidu.adp.lib.util.n.e(r2);
            throw th;
        }
        return linkedHashMap;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x028e */
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
        ?? r5 = this.gFe;
        String sb2 = sb.append(r5).append(valueOf).toString();
        try {
            try {
                if (TextUtils.isEmpty(str2) || "0".equals(str2)) {
                    if (TextUtils.isEmpty(str)) {
                        cursor = h.bCU().b("select * from " + sb2 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{String.valueOf(0)});
                    } else {
                        cursor = h.bCU().b("select * from " + sb2 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{str, String.valueOf(0)});
                    }
                } else {
                    cursor = h.bCU().b("select * from " + sb2 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i, new String[]{str2, String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            ChatMessage newInstance = this.gFf.newInstance();
                            newInstance.setGroupId(String.valueOf(com.baidu.tieba.im.sendmessage.a.gQl));
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
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex("msg_status"))));
                            newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            com.baidu.tieba.im.util.e.z(newInstance);
                            newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            linkedList.addFirst(newInstance);
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            cursor2 = cursor;
                            try {
                                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAll", new Object[0]);
                                e2.printStackTrace();
                                yO(valueOf);
                                com.baidu.adp.lib.util.n.e(cursor2);
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                r5 = cursor2;
                                com.baidu.adp.lib.util.n.e(r5);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            com.baidu.adp.lib.util.n.e(cursor);
                            return linkedList;
                        }
                    }
                }
                com.baidu.adp.lib.util.n.e(cursor);
            } catch (Throwable th3) {
                th = th3;
                com.baidu.adp.lib.util.n.e(r5);
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
            com.baidu.adp.lib.util.n.e(r5);
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
        String str3 = this.gFe + valueOf;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            contentValues.put("msg_status", Integer.valueOf(i));
            if (h.bCU().a(str3, contentValues, "mid=?", new String[]{str}) > 0) {
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

    public void h(long j, boolean z) {
        String str = this.gFe + j;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
            h.bCU().a(str, contentValues, "uid!=?", new String[]{"0"});
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
        String str = this.gFe + valueOf;
        if (this.gFg == null) {
            this.gFg = bCJ();
        }
        if (!this.gFg.contains(valueOf)) {
            yO(valueOf);
            this.gFg.add(valueOf);
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = h.bCU().yY(" INSERT INTO " + str + "(content" + Constants.ACCEPT_TIME_SEPARATOR_SP + "create_time" + Constants.ACCEPT_TIME_SEPARATOR_SP + "ext" + Constants.ACCEPT_TIME_SEPARATOR_SP + "mid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "uid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "user_info" + Constants.ACCEPT_TIME_SEPARATOR_SP + "to_uid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "to_user_info" + Constants.ACCEPT_TIME_SEPARATOR_SP + "msg_status" + Constants.ACCEPT_TIME_SEPARATOR_SP + "msg_type" + Constants.ACCEPT_TIME_SEPARATOR_SP + "rid" + Constants.ACCEPT_TIME_SEPARATOR_SP + "read_flag" + Constants.ACCEPT_TIME_SEPARATOR_SP + "is_delete" + Constants.ACCEPT_TIME_SEPARATOR_SP + "is_friend) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            for (CommonMsgPojo commonMsgPojo : list) {
                if (z && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                    h.bCU().a(str, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
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
                contentValues.put("msg_status", Integer.valueOf(commonMsgPojo.getMsg_status()));
                contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                contentValues.put("is_friend", Integer.valueOf(commonMsgPojo.getIsFriend()));
                if (h.bCU().a(str, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
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
            com.baidu.adp.lib.util.n.e(null);
            com.baidu.adp.lib.util.n.a(sQLiteStatement);
        }
        Boolean bool = true;
        return bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void p(LinkedList<String> linkedList) {
        Cursor cursor;
        Iterator<String> it;
        if (linkedList != null && linkedList.size() != 0) {
            LinkedList linkedList2 = new LinkedList();
            try {
                cursor = h.bCU().b("select * from sqlite_master where type='table'", null);
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
                            com.baidu.adp.lib.util.n.e(cursor);
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.adp.lib.util.n.e(cursor);
                        throw th;
                    }
                }
                com.baidu.adp.lib.util.n.e(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                com.baidu.adp.lib.util.n.e(cursor);
                throw th;
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !linkedList2.contains(next)) {
                    yO(next);
                }
            }
        }
        return null;
    }

    public boolean di(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            h.bCU().a(this.gFe + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean dj(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            h.bCU().a(this.gFe + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean yL(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.gFg == null) {
            this.gFg = bCJ();
        }
        if (this.gFg != null && this.gFg.contains(str)) {
            Iterator<String> it = this.gFg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.gFg.remove(next);
                    break;
                }
            }
        }
        return h.bCU().yX("DROP TABLE IF EXISTS " + (this.gFe + str));
    }

    public boolean yM(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.gFg == null) {
            this.gFg = bCJ();
        }
        if (this.gFg != null && this.gFg.contains(str)) {
            Iterator<String> it = this.gFg.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.gFg.remove(next);
                    break;
                }
            }
        }
        return h.bCU().yX("delete from " + (this.gFe + str));
    }

    public boolean yN(String str) {
        try {
            h(Long.parseLong(str), true);
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
            return false;
        }
    }

    public synchronized void yO(String str) {
        if (!TextUtils.isEmpty(str)) {
            h.bCU().yX("CREATE TABLE IF NOT EXISTS " + (this.gFe + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, msg_status int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT, is_friend int default 1);");
        }
    }

    public LinkedList<String> bCJ() {
        Cursor cursor = null;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            cursor = h.bCU().b("select * from sqlite_master where type='table'", null);
            if (cursor != null) {
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    if (string.startsWith(this.gFe)) {
                        linkedList.add(string.subSequence(this.gFe.length(), string.length()).toString());
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
            e.printStackTrace();
        } finally {
            com.baidu.adp.lib.util.n.e(cursor);
        }
        return linkedList;
    }

    public void bCK() {
        this.gFg = null;
    }

    public boolean aF(String str, int i) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            String str2 = this.gFe + str;
            if (i < 1000) {
                i = 1000;
            }
            cursor = h.bCU().b("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
            try {
                try {
                    String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                    com.baidu.adp.lib.util.n.e(cursor);
                    if (string != null) {
                        h.bCU().a(str2, "mid<?", new String[]{string});
                    }
                    com.baidu.adp.lib.util.n.e(cursor);
                    return true;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                    com.baidu.adp.lib.util.n.e(cursor);
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                com.baidu.adp.lib.util.n.e(cursor2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            com.baidu.adp.lib.util.n.e(cursor2);
            throw th;
        }
    }
}
