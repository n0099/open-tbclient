package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a97 {
    public static /* synthetic */ Interceptable $ic;
    public static a97 a;
    public transient /* synthetic */ FieldHolder $fh;

    public a97() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized a97 h() {
        InterceptResult invokeV;
        a97 a97Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (a97.class) {
                if (a == null) {
                    a = new a97();
                }
                a97Var = a;
            }
            return a97Var;
        }
        return (a97) invokeV.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        f97.d().c("CREATE TABLE IF NOT EXISTS " + ("tb_group_msg_" + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT);");
    }

    public void b(List<ImMessageCenterPojo> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || list == null || list.size() == 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        Cursor cursor = null;
        try {
            try {
                cursor = f97.d().e("select * from sqlite_master where type='table'", null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    while (cursor.moveToNext()) {
                        linkedList.add(cursor.getString(cursor.getColumnIndex("name")));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.createMsgTable", new Object[0]);
            }
            for (ImMessageCenterPojo imMessageCenterPojo : list) {
                if (!linkedList.contains("tb_group_msg_" + imMessageCenterPojo.getGid())) {
                    a(imMessageCenterPojo.getGid());
                }
            }
        } finally {
            fj.a(cursor);
        }
    }

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f97.d().delete("tb_group_msg_" + str, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.deleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f97 d = f97.d();
                d.c("delete from " + ("tb_group_msg_" + str));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.deleteMsgTableById", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                f97 d = f97.d();
                d.c("DROP TABLE IF EXISTS " + ("tb_group_msg_" + str));
            } catch (Exception e) {
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.dropMsgTableById", new Object[0]);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public LinkedHashMap<String, String> f(String str, int i, String str2, int i2) {
        InterceptResult invokeCommon;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)})) == null) {
            Cursor cursor = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i3 = i2 <= 0 ? 20 : i2;
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            String str3 = "tb_group_msg_" + str;
            try {
                try {
                    if (TextUtils.isEmpty(str2)) {
                        e = f97.d().e("select * from " + str3 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{String.valueOf(i), String.valueOf(0)});
                    } else {
                        e = f97.d().e("select * from " + str3 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                    }
                    Cursor cursor2 = e;
                    if (cursor2 != null) {
                        while (cursor2.moveToNext()) {
                            try {
                                linkedHashMap.put(cursor2.getString(cursor2.getColumnIndex("mid")), cursor2.getString(cursor2.getColumnIndex("content")));
                            } catch (SQLiteException e2) {
                                e = e2;
                                cursor = cursor2;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                                fj.a(cursor);
                                return linkedHashMap;
                            } catch (Exception e3) {
                                e = e3;
                                cursor = cursor2;
                                e.printStackTrace();
                                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAllByMsgType" + i, new Object[0]);
                                fj.a(cursor);
                                return linkedHashMap;
                            } catch (Throwable th) {
                                th = th;
                                cursor = cursor2;
                                fj.a(cursor);
                                throw th;
                            }
                        }
                    }
                    fj.a(cursor2);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
            return linkedHashMap;
        }
        return (LinkedHashMap) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0112 A[EXC_TOP_SPLITTER, LOOP:0: B:53:0x0112->B:28:0x0118, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList<ChatMessage> g(String str, String str2, String str3, int i) {
        InterceptResult invokeLLLI;
        Cursor cursor;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048582, this, str, str2, str3, i)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i2 = i <= 0 ? 20 : i;
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            String str4 = "tb_group_msg_" + str;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    fj.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                fj.a(cursor2);
                throw th;
            }
            if (!TextUtils.isEmpty(str3) && !"0".equals(str3)) {
                e = f97.d().e("select * from " + str4 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str3, String.valueOf(0)});
                cursor = e;
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
                            fc7.q(commonGroupChatMessage);
                            linkedList.addFirst(commonGroupChatMessage);
                        } catch (SQLiteException e4) {
                            e = e4;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                            a(str);
                            fj.a(cursor);
                            return linkedList;
                        } catch (Exception e5) {
                            e = e5;
                            e.printStackTrace();
                            TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getAll", new Object[0]);
                            fj.a(cursor);
                            return linkedList;
                        }
                    }
                }
                fj.a(cursor);
                return linkedList;
            }
            if (TextUtils.isEmpty(str2)) {
                e = f97.d().e("select * from " + str4 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
            } else {
                e = f97.d().e("select * from " + str4 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
            }
            cursor = e;
            if (cursor != null) {
            }
            fj.a(cursor);
            return linkedList;
        }
        return (LinkedList) invokeLLLI.objValue;
    }

    public long i(String str) {
        InterceptResult invokeL;
        long j;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048583, this, str)) != null) {
            return invokeL.longValue;
        }
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        String str2 = "tb_group_msg_" + str;
        Cursor cursor = null;
        try {
            try {
                Cursor e2 = f97.d().e("select max(mid) from " + str2, null);
                if (e2 != null) {
                    try {
                        if (e2.moveToNext()) {
                            j = e2.getLong(0);
                            e = f97.d().e("select count(*) from " + str2, null);
                            if (((e == null && e.moveToNext()) ? e.getInt(0) : 0) == 1 || j % 100 == 0) {
                                fj.a(e);
                                return j;
                            }
                            long a2 = ec7.a(j);
                            fj.a(e);
                            return a2;
                        }
                    } catch (SQLiteException e3) {
                        e = e3;
                        cursor = e2;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        a(str);
                        fj.a(cursor);
                        return 0L;
                    } catch (Exception e4) {
                        e = e4;
                        cursor = e2;
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getMaxLastMid", new Object[0]);
                        e.printStackTrace();
                        fj.a(cursor);
                        return 0L;
                    } catch (Throwable th) {
                        th = th;
                        cursor = e2;
                        fj.a(cursor);
                        throw th;
                    }
                }
                j = 0;
                e = f97.d().e("select count(*) from " + str2, null);
                if (((e == null && e.moveToNext()) ? e.getInt(0) : 0) == 1) {
                }
                fj.a(e);
                return j;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e5) {
            e = e5;
        } catch (Exception e6) {
            e = e6;
        }
    }

    public CommonMsgPojo j(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "tb_group_msg_" + str;
            try {
                try {
                    cursor = f97.d().e("select * from " + str2 + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                        if (cursor != null && cursor.moveToNext()) {
                            commonMsgPojo.setGid(str);
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            fj.a(cursor);
                            return commonMsgPojo;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        a(str);
                        fj.a(cursor);
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getNewestMsgContext", new Object[0]);
                        fj.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = str2;
                    fj.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e3) {
                e = e3;
                cursor = null;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                fj.a(cursor2);
                throw th;
            }
            fj.a(cursor);
            return null;
        }
        return (CommonMsgPojo) invokeL.objValue;
    }

    public int k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = f97.d().e("select count(*) from " + ("tb_group_msg_" + str) + " WHERE read_flag=? AND is_delete=?", new String[]{String.valueOf(1), String.valueOf(0)});
                        if (cursor != null && cursor.moveToNext()) {
                            return cursor.getInt(0);
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.getUnreadcount", new Object[0]);
                        e.printStackTrace();
                    }
                } catch (SQLiteException e2) {
                    TiebaStatic.printDBExceptionLog(e2, "GroupMsgDao.getUnreadcount", new Object[0]);
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                fj.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00fe A[Catch: all -> 0x0102, Exception -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0107, all -> 0x0102, blocks: (B:27:0x00d4, B:37:0x00fe), top: B:102:0x00d4 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x019b A[Catch: all -> 0x024b, Exception -> 0x0250, TryCatch #13 {Exception -> 0x0250, all -> 0x024b, blocks: (B:34:0x00f6, B:43:0x010c, B:45:0x019b, B:48:0x01ab), top: B:100:0x00f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(String str, List<CommonMsgPojo> list, boolean z) {
        InterceptResult invokeLLZ;
        Cursor cursor;
        SQLiteStatement sQLiteStatement;
        Iterator<CommonMsgPojo> it;
        String str2;
        SQLiteStatement sQLiteStatement2;
        SQLiteStatement sQLiteStatement3;
        ContentValues contentValues;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLLZ = interceptable.invokeLLZ(1048586, this, str, list, z)) != null) {
            return invokeLLZ.booleanValue;
        }
        String str4 = "is_delete";
        String str5 = "read_flag";
        String str6 = "rid";
        if (list == null || TextUtils.isEmpty(str) || list == null || list.size() == 0) {
            return false;
        }
        String str7 = "tb_group_msg_" + str;
        try {
            sQLiteStatement = f97.d().a(" INSERT INTO " + str7 + "(content,create_time,ext,mid," + IMConstants.MSG_STATUS + ",msg_type,uid,user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            try {
                Iterator<CommonMsgPojo> it2 = list.iterator();
                while (it2.hasNext()) {
                    CommonMsgPojo next = it2.next();
                    try {
                        if (z) {
                            try {
                                if (next.isSelf() && next.getRid() != 0) {
                                    it = it2;
                                    str2 = str4;
                                    sQLiteStatement2 = sQLiteStatement;
                                    try {
                                        f97.d().delete(str7, "mid=?", new String[]{String.valueOf(next.getRid())});
                                        String str8 = "";
                                        if (next.getContent() == null) {
                                            next.setContent("");
                                        }
                                        contentValues = new ContentValues();
                                        contentValues.put("content", next.getContent());
                                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                        contentValues.put("ext", next.getExt());
                                        contentValues.put("mid", Long.valueOf(next.getMid()));
                                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                                        contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                                        contentValues.put("uid", next.getUid());
                                        contentValues.put("user_info", next.getUser_info());
                                        contentValues.put(str6, Long.valueOf(next.getRid()));
                                        contentValues.put(str5, Integer.valueOf(next.getRead_flag()));
                                        String str9 = str5;
                                        String str10 = str2;
                                        contentValues.put(str10, Integer.valueOf(next.getIs_delete()));
                                        String str11 = str6;
                                        if (f97.d().update(str7, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                                            sQLiteStatement2.clearBindings();
                                            sQLiteStatement3 = sQLiteStatement2;
                                            try {
                                                sQLiteStatement3.bindString(1, TextUtils.isEmpty(next.getContent()) ? "" : next.getContent());
                                                str3 = str7;
                                                sQLiteStatement3.bindLong(2, next.getCreate_time());
                                                sQLiteStatement3.bindString(3, TextUtils.isEmpty(next.getExt()) ? "" : next.getExt());
                                                sQLiteStatement3.bindLong(4, next.getMid());
                                                sQLiteStatement3.bindLong(5, next.getMsg_status());
                                                sQLiteStatement3.bindLong(6, next.getMsg_type());
                                                sQLiteStatement3.bindString(7, TextUtils.isEmpty(next.getUid()) ? "" : next.getUid());
                                                if (!TextUtils.isEmpty(next.getUser_info())) {
                                                    str8 = next.getUser_info();
                                                }
                                                sQLiteStatement3.bindString(8, str8);
                                                sQLiteStatement3.bindLong(9, next.getRid());
                                                sQLiteStatement3.bindLong(10, next.getRead_flag());
                                                sQLiteStatement3.bindLong(11, next.getIs_delete());
                                                f97.d().insert(sQLiteStatement3);
                                            } catch (Exception e) {
                                                e = e;
                                                sQLiteStatement = sQLiteStatement3;
                                                try {
                                                    e.printStackTrace();
                                                    TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                                    fj.a(null);
                                                    fj.c(sQLiteStatement);
                                                    return false;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    cursor = null;
                                                    fj.a(cursor);
                                                    fj.c(sQLiteStatement);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                sQLiteStatement = sQLiteStatement3;
                                                cursor = null;
                                                fj.a(cursor);
                                                fj.c(sQLiteStatement);
                                                throw th;
                                            }
                                        } else {
                                            str3 = str7;
                                            sQLiteStatement3 = sQLiteStatement2;
                                        }
                                        it2 = it;
                                        sQLiteStatement = sQLiteStatement3;
                                        str7 = str3;
                                        str4 = str10;
                                        str5 = str9;
                                        str6 = str11;
                                    } catch (Exception e2) {
                                        e = e2;
                                        sQLiteStatement = sQLiteStatement2;
                                        e.printStackTrace();
                                        TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.insertOrUpdate", new Object[0]);
                                        fj.a(null);
                                        fj.c(sQLiteStatement);
                                        return false;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        sQLiteStatement = sQLiteStatement2;
                                        cursor = null;
                                        fj.a(cursor);
                                        fj.c(sQLiteStatement);
                                        throw th;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        String str82 = "";
                        if (next.getContent() == null) {
                        }
                        contentValues = new ContentValues();
                        contentValues.put("content", next.getContent());
                        contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                        contentValues.put("ext", next.getExt());
                        contentValues.put("mid", Long.valueOf(next.getMid()));
                        contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                        contentValues.put("msg_type", Integer.valueOf(next.getMsg_type()));
                        contentValues.put("uid", next.getUid());
                        contentValues.put("user_info", next.getUser_info());
                        contentValues.put(str6, Long.valueOf(next.getRid()));
                        contentValues.put(str5, Integer.valueOf(next.getRead_flag()));
                        String str92 = str5;
                        String str102 = str2;
                        contentValues.put(str102, Integer.valueOf(next.getIs_delete()));
                        String str112 = str6;
                        if (f97.d().update(str7, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                        }
                        it2 = it;
                        sQLiteStatement = sQLiteStatement3;
                        str7 = str3;
                        str4 = str102;
                        str5 = str92;
                        str6 = str112;
                    } catch (Exception e4) {
                        e = e4;
                        sQLiteStatement3 = sQLiteStatement2;
                    } catch (Throwable th5) {
                        th = th5;
                        sQLiteStatement3 = sQLiteStatement2;
                    }
                    str2 = str4;
                    sQLiteStatement2 = sQLiteStatement;
                    it = it2;
                }
                fj.a(null);
                fj.c(sQLiteStatement);
                return true;
            } catch (Exception e5) {
                e = e5;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e6) {
            e = e6;
            sQLiteStatement = null;
        } catch (Throwable th7) {
            th = th7;
            cursor = null;
            sQLiteStatement = null;
            fj.a(cursor);
            fj.c(sQLiteStatement);
            throw th;
        }
    }

    public boolean m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", (Integer) 1);
                f97.d().update("tb_group_msg_" + str, contentValues, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.markDeleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean n(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            Cursor cursor = null;
            cursor = null;
            try {
                try {
                    str2 = "tb_group_msg_" + str;
                    if (i < 1000) {
                        i = 1000;
                    }
                    e = f97.d().e("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String string = e.moveToNext() ? e.getString(e.getColumnIndex("mid")) : null;
                fj.a(e);
                if (string != null) {
                    f97.d().delete(str2, "mid<?", new String[]{string});
                }
                fj.a(e);
                return true;
            } catch (Exception e3) {
                e = e3;
                cursor = e;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                fj.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = e;
                fj.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean o(String str, String str2, String str3, int i) {
        InterceptResult invokeLLLI;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048589, this, str, str2, str3, i)) == null) {
            Boolean bool2 = Boolean.FALSE;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return false;
            }
            String str4 = "tb_group_msg_" + str;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", str3);
                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
                if (f97.d().update(str4, contentValues, "mid=?", new String[]{str2}) > 0) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                bool2 = bool;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
            return bool2.booleanValue();
        }
        return invokeLLLI.booleanValue;
    }
}
