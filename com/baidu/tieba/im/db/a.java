package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.adp.lib.util.t;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    private String aXZ;
    private Class<? extends ChatMessage> aYa;
    List<String> aYb = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str, Class<? extends ChatMessage> cls) {
        this.aXZ = str;
        this.aYa = cls;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [78=5] */
    public int gm(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = g.MU().rawQuery("select count(*) from " + (String.valueOf(this.aXZ) + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                if (cursor == null || !cursor.moveToNext()) {
                    t.b(cursor);
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
                t.b(cursor);
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [146=5] */
    public long gn(String str) {
        long j = 0;
        Cursor cursor = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                cursor = g.MU().rawQuery("select max(mid) from " + (String.valueOf(this.aXZ) + str), null);
                if (cursor == null || !cursor.moveToNext()) {
                    t.b(cursor);
                } else {
                    j = cursor.getLong(0);
                }
            } catch (SQLiteException e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e.printStackTrace();
                gr(str);
            } catch (Exception e2) {
                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                e2.printStackTrace();
            } finally {
                t.b(cursor);
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [206=5] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:26:0x015a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x015c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:30:0x015e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x001b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public CommonMsgPojo go(String str) {
        Throwable th;
        Cursor cursor;
        CommonMsgPojo commonMsgPojo = null;
        if (!TextUtils.isEmpty(str)) {
            ?? valueOf = String.valueOf(this.aXZ);
            try {
                try {
                    cursor = g.MU().rawQuery("select * from " + (((String) valueOf) + str) + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo();
                        if (cursor == null || !cursor.moveToNext()) {
                            t.b(cursor);
                            valueOf = cursor;
                        } else {
                            commonMsgPojo2.setGid(str);
                            commonMsgPojo2.setUid(cursor.getString(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                            commonMsgPojo2.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo2.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                            commonMsgPojo2.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo2.setContent(cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                            commonMsgPojo2.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo2.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo2.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo2.setMsg_status(cursor.getInt(cursor.getColumnIndex("msg_status")));
                            commonMsgPojo2.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo2.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo2.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo2.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo2.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            t.b(cursor);
                            commonMsgPojo = commonMsgPojo2;
                            valueOf = cursor;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        gr(str);
                        t.b(cursor);
                        valueOf = cursor;
                        return commonMsgPojo;
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        t.b(cursor);
                        valueOf = cursor;
                        return commonMsgPojo;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    t.b((Cursor) valueOf);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th3) {
                valueOf = 0;
                th = th3;
                t.b((Cursor) valueOf);
                throw th;
            }
        }
        return commonMsgPojo;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [274=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x0158 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.StringBuilder] */
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
        ?? r2 = String.valueOf(this.aXZ) + str;
        try {
            try {
                if (TextUtils.isEmpty(str2)) {
                    cursor = g.MU().rawQuery("select * from " + r2 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{String.valueOf(i), String.valueOf(0)});
                } else {
                    cursor = g.MU().rawQuery("select * from " + r2 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e2.printStackTrace();
                            gr(str);
                            t.b(cursor);
                            return linkedHashMap;
                        } catch (Exception e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                            e.printStackTrace();
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [454=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x0252 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v6 */
    public LinkedList<ChatMessage> a(long j, String str, String str2, int i) {
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
        ?? valueOf2 = String.valueOf(this.aXZ);
        String str3 = ((String) valueOf2) + valueOf;
        try {
            try {
                if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                    cursor = g.MU().rawQuery("select * from " + str3 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i, new String[]{str2, String.valueOf(0)});
                } else if (TextUtils.isEmpty(str)) {
                    cursor = g.MU().rawQuery("select * from " + str3 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{String.valueOf(0)});
                } else {
                    cursor = g.MU().rawQuery("select * from " + str3 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i, new String[]{str, String.valueOf(0)});
                }
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            ChatMessage newInstance = this.aYa.newInstance();
                            newInstance.setGroupId(String.valueOf(com.baidu.tieba.im.c.a.boy));
                            newInstance.setContent(cursor.getString(cursor.getColumnIndex(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT)));
                            newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            newInstance.setUserId(cursor.getLong(cursor.getColumnIndex(SapiAccountManager.SESSION_UID)));
                            newInstance.setUserInfo((UserData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("user_info")), UserData.class));
                            newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                            newInstance.setToUserInfo((UserData) com.baidu.adp.lib.a.b.a.a.i.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                            MsgLocalData msgLocalData = new MsgLocalData();
                            newInstance.setLocalData(msgLocalData);
                            msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex("msg_status"))));
                            newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                            com.baidu.tieba.im.util.i.u(newInstance);
                            newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            linkedList.addFirst(newInstance);
                        } catch (SQLiteException e3) {
                            e2 = e3;
                            cursor2 = cursor;
                            try {
                                TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getAll", new Object[0]);
                                e2.printStackTrace();
                                gr(valueOf);
                                t.b(cursor2);
                                return linkedList;
                            } catch (Throwable th2) {
                                th = th2;
                                valueOf2 = cursor2;
                                t.b((Cursor) valueOf2);
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            t.b(cursor);
                            return linkedList;
                        }
                    }
                }
                t.b(cursor);
            } catch (Throwable th3) {
                th = th3;
                t.b((Cursor) valueOf2);
                throw th;
            }
        } catch (SQLiteException e5) {
            cursor2 = null;
            e2 = e5;
        } catch (Exception e6) {
            cursor = null;
            e = e6;
        } catch (Throwable th4) {
            valueOf2 = 0;
            th = th4;
            t.b((Cursor) valueOf2);
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
        String str3 = String.valueOf(this.aXZ) + valueOf;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mid", str2);
            contentValues.put("msg_status", Integer.valueOf(i));
            if (g.MU().update(str3, contentValues, "mid=?", new String[]{str}) > 0) {
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

    public void a(long j, boolean z) {
        String str = String.valueOf(this.aXZ) + j;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", Integer.valueOf(z ? 1 : 0));
            g.MU().update(str, contentValues, "uid!=?", new String[]{"0"});
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
        String str = String.valueOf(this.aXZ) + valueOf;
        if (this.aYb == null) {
            this.aYb = MM();
        }
        if (!this.aYb.contains(valueOf)) {
            gr(valueOf);
            this.aYb.add(valueOf);
        }
        SQLiteStatement sQLiteStatement = null;
        try {
            sQLiteStatement = g.MU().compileStatement(" INSERT INTO " + str + "(" + CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT + ",create_time,ext,mid," + SapiAccountManager.SESSION_UID + ",user_info,to_uid,to_user_info,msg_status,msg_type,rid,read_flag,is_delete,is_friend) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
            for (CommonMsgPojo commonMsgPojo : list) {
                if (z && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                    g.MU().a(str, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, commonMsgPojo.getContent());
                contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                contentValues.put("ext", commonMsgPojo.getExt());
                contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                contentValues.put(SapiAccountManager.SESSION_UID, commonMsgPojo.getUid());
                contentValues.put("user_info", commonMsgPojo.getUser_info());
                contentValues.put("to_uid", commonMsgPojo.getToUid());
                contentValues.put("to_user_info", commonMsgPojo.getToUser_info());
                contentValues.put("msg_status", Integer.valueOf(commonMsgPojo.getMsg_status()));
                contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                contentValues.put("is_friend", Integer.valueOf(commonMsgPojo.getIsFriend()));
                if (g.MU().update(str, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
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
            t.b((Cursor) null);
            t.a(sQLiteStatement);
        }
        Boolean bool = true;
        return bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void j(LinkedList<String> linkedList) {
        Cursor cursor;
        Iterator<String> it;
        if (linkedList != null && linkedList.size() != 0) {
            LinkedList linkedList2 = new LinkedList();
            try {
                cursor = g.MU().rawQuery("select * from sqlite_master where type='table'", null);
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
                            t.b(cursor);
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                            }
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        t.b(cursor);
                        throw th;
                    }
                }
                t.b(cursor);
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                t.b(cursor);
                throw th;
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !linkedList2.contains(next)) {
                    gr(next);
                }
            }
        }
        return null;
    }

    public boolean az(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_delete", (Integer) 1);
            g.MU().update(String.valueOf(this.aXZ) + str, contentValues, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean aA(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            g.MU().a(String.valueOf(this.aXZ) + str, "mid=?", new String[]{str2});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }

    public boolean gp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.aYb == null) {
            this.aYb = MM();
        }
        if (this.aYb != null && this.aYb.contains(str)) {
            Iterator<String> it = this.aYb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.equals(str)) {
                    this.aYb.remove(next);
                    break;
                }
            }
        }
        return g.MU().gx("DROP TABLE IF EXISTS " + (String.valueOf(this.aXZ) + str));
    }

    public boolean gq(String str) {
        try {
            a(Long.parseLong(str), true);
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void gr(String str) {
        if (!TextUtils.isEmpty(str)) {
            g.MU().gx("CREATE TABLE IF NOT EXISTS " + (String.valueOf(this.aXZ) + str) + "(mid BIGINT PRIMARY KEY, " + SapiAccountManager.SESSION_UID + " TEXT, user_info blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, msg_status int, " + CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT + " blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT, is_friend int default 1);");
        }
    }

    public LinkedList<String> MM() {
        Cursor cursor = null;
        LinkedList<String> linkedList = new LinkedList<>();
        try {
            cursor = g.MU().rawQuery("select * from sqlite_master where type='table'", null);
            if (cursor != null) {
                cursor.moveToFirst();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(cursor.getColumnIndex("name"));
                    if (string.startsWith(this.aXZ)) {
                        linkedList.add(string.subSequence(this.aXZ.length(), string.length()).toString());
                    }
                }
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
            e.printStackTrace();
        } finally {
            t.b(cursor);
        }
        return linkedList;
    }

    public void MN() {
        this.aYb = null;
    }

    public boolean w(String str, int i) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                String str2 = String.valueOf(this.aXZ) + str;
                if (i < 1000) {
                    i = 1000;
                }
                cursor = g.MU().rawQuery("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
                try {
                    String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                    t.b(cursor);
                    if (string != null) {
                        g.MU().a(str2, "mid<?", new String[]{string});
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
                cursor2 = 1000;
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
