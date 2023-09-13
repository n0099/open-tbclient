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
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes6.dex */
public abstract class if8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Class<? extends ChatMessage> b;
    public List<String> c;

    public if8(String str, Class<? extends ChatMessage> cls) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cls};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.a = str;
        this.b = cls;
    }

    public boolean c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                qf8.d().delete(this.a + str, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0071: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0071 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void a(LinkedList<String> linkedList) {
        InterceptResult invokeL;
        Cursor cursor;
        Cursor cursor2;
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, linkedList)) == null) {
            Cursor cursor3 = null;
            if (linkedList == null || linkedList.size() == 0) {
                return null;
            }
            LinkedList linkedList2 = new LinkedList();
            try {
                try {
                    cursor = qf8.d().e("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        try {
                            cursor.moveToFirst();
                            while (cursor.moveToNext()) {
                                linkedList2.add(cursor.getString(cursor.getColumnIndex("name")));
                            }
                        } catch (Exception e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                            e.printStackTrace();
                            fi.a(cursor);
                            it = linkedList.iterator();
                            while (it.hasNext()) {
                            }
                            return null;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor3 = cursor2;
                    fi.a(cursor3);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                fi.a(cursor3);
                throw th;
            }
            fi.a(cursor);
            it = linkedList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && !linkedList2.contains(next)) {
                    b(next);
                }
            }
            return null;
        }
        return (Void) invokeL.objValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (this.c == null) {
                this.c = i();
            }
            List<String> list = this.c;
            if (list != null && list.contains(str)) {
                Iterator<String> it = this.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (next.equals(str)) {
                        this.c.remove(next);
                        break;
                    }
                }
            }
            String str2 = this.a + str;
            return qf8.d().c("delete from " + str2);
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
            if (this.c == null) {
                this.c = i();
            }
            List<String> list = this.c;
            if (list != null && list.contains(str)) {
                Iterator<String> it = this.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (next.equals(str)) {
                        this.c.remove(next);
                        break;
                    }
                }
            }
            String str2 = this.a + str;
            return qf8.d().c("DROP TABLE IF EXISTS " + str2);
        }
        return invokeL.booleanValue;
    }

    public long j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            Cursor cursor = null;
            try {
                try {
                    cursor = qf8.d().e("select max(mid) from " + (this.a + str), null);
                    if (cursor != null && cursor.moveToNext()) {
                        return cursor.getLong(0);
                    }
                } catch (SQLiteException e) {
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                    e.printStackTrace();
                    b(str);
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getMaxLastMid", new Object[0]);
                    e2.printStackTrace();
                }
                return 0L;
            } finally {
                fi.a(cursor);
            }
        }
        return invokeL.longValue;
    }

    public synchronized void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                qf8.d().c("CREATE TABLE IF NOT EXISTS " + (this.a + str) + "(mid BIGINT PRIMARY KEY, uid TEXT, " + SourceConstant.SOURCE_USER_INFO + " blob, to_uid TEXT, to_user_info blob, create_time BIGINT, msg_type int, " + IMConstants.MSG_STATUS + " int, content blob, ext blob, read_flag int default 0, is_delete int default 0, rid BIGINT, is_friend int default 1, read_count LONG default -1);");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0117 A[EXC_TOP_SPLITTER, LOOP:0: B:56:0x0117->B:29:0x011d, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList<CommonMsgPojo> f(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Cursor cursor;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) {
            Cursor cursor2 = null;
            if (j == 0) {
                return null;
            }
            String valueOf = String.valueOf(j);
            if (i <= 0) {
                i2 = 20;
            } else {
                i2 = i;
            }
            LinkedList<CommonMsgPojo> linkedList = new LinkedList<>();
            String str3 = this.a + valueOf;
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    fi.a(cursor2);
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
                fi.a(cursor2);
                throw th;
            }
            if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                e = qf8.d().e("select * from " + str3 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
                cursor = e;
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        try {
                            CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                            commonMsgPojo.setGid(String.valueOf(gi8.j));
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setUid(String.valueOf(cursor.getLong(cursor.getColumnIndex("uid"))));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex(SourceConstant.SOURCE_USER_INFO)));
                            commonMsgPojo.setToUid(String.valueOf(cursor.getLong(cursor.getColumnIndex("to_uid"))));
                            commonMsgPojo.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            commonMsgPojo.checkRidAndSelf();
                            linkedList.add(commonMsgPojo);
                        } catch (SQLiteException e4) {
                            e = e4;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            b(valueOf);
                            fi.a(cursor);
                            return linkedList;
                        } catch (Exception e5) {
                            e = e5;
                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                            e.printStackTrace();
                            fi.a(cursor);
                            return linkedList;
                        }
                    }
                }
                fi.a(cursor);
                return linkedList;
            }
            if (TextUtils.isEmpty(str)) {
                e = qf8.d().e("select * from " + str3 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
            } else {
                e = qf8.d().e("select * from " + str3 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str, String.valueOf(0)});
            }
            cursor = e;
            if (cursor != null) {
            }
            fi.a(cursor);
            return linkedList;
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public LinkedHashMap<String, String> g(String str, int i, String str2, int i2) {
        InterceptResult invokeCommon;
        int i3;
        Cursor cursor;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), str2, Integer.valueOf(i2)})) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (i2 <= 0) {
                i3 = 20;
            } else {
                i3 = i2;
            }
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            String str3 = this.a + str;
            try {
                try {
                    if (TextUtils.isEmpty(str2)) {
                        e = qf8.d().e("select * from " + str3 + " WHERE msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{String.valueOf(i), String.valueOf(0)});
                    } else {
                        e = qf8.d().e("select * from " + str3 + " WHERE mid <=? AND msg_type=? AND is_delete=? ORDER BY rid DESC LIMIT " + i3, new String[]{str2, String.valueOf(i), String.valueOf(0)});
                    }
                    cursor = e;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                linkedHashMap.put(cursor.getString(cursor.getColumnIndex("mid")), cursor.getString(cursor.getColumnIndex("content")));
                            } catch (SQLiteException e2) {
                                e = e2;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                                e.printStackTrace();
                                b(str);
                                fi.a(cursor);
                                return linkedHashMap;
                            } catch (Exception e3) {
                                e = e3;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAllByMsgType" + i, new Object[0]);
                                e.printStackTrace();
                                fi.a(cursor);
                                return linkedHashMap;
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fi.a(cursor2);
                    throw th;
                }
            } catch (SQLiteException e4) {
                e = e4;
                cursor = null;
            } catch (Exception e5) {
                e = e5;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                fi.a(cursor2);
                throw th;
            }
            fi.a(cursor);
            return linkedHashMap;
        }
        return (LinkedHashMap) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x011b A[EXC_TOP_SPLITTER, LOOP:0: B:65:0x011b->B:32:0x0213, LOOP_START, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public LinkedList<ChatMessage> h(long j, String str, String str2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Cursor cursor;
        String str3;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i)})) == null) {
            Cursor cursor2 = null;
            if (j == 0) {
                return null;
            }
            String valueOf = String.valueOf(j);
            if (i <= 0) {
                i2 = 20;
            } else {
                i2 = i;
            }
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            String str4 = this.a + valueOf;
            try {
                try {
                    try {
                        str3 = valueOf;
                    } catch (Throwable th) {
                        th = th;
                        fi.a(cursor2);
                        throw th;
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    str3 = valueOf;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                cursor2 = null;
                fi.a(cursor2);
                throw th;
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                } catch (SQLiteException e4) {
                    e = e4;
                    cursor = null;
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                    e.printStackTrace();
                    b(str3);
                    fi.a(cursor);
                    return linkedList;
                }
                if (!"0".equals(str2)) {
                    e = qf8.d().e("select * from " + str4 + " WHERE rid<? AND is_delete=? ORDER BY rid DESC LIMIT " + i2, new String[]{str2, String.valueOf(0)});
                    cursor = e;
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                ChatMessage newInstance = this.b.newInstance();
                                newInstance.setGroupId(String.valueOf(gi8.j));
                                newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                                newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                                newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                                newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                                newInstance.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                                newInstance.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex(SourceConstant.SOURCE_USER_INFO)), UserData.class));
                                newInstance.setToUserId(cursor.getLong(cursor.getColumnIndex("to_uid")));
                                newInstance.setToUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex("to_user_info")), UserData.class));
                                MsgLocalData msgLocalData = new MsgLocalData();
                                newInstance.setLocalData(msgLocalData);
                                msgLocalData.setStatus(Short.valueOf((short) cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS))));
                                msgLocalData.setErrorString(cursor.getString(cursor.getColumnIndex("ext")));
                                newInstance.setErrorString(cursor.getString(cursor.getColumnIndex("ext")));
                                newInstance.setMsgType(cursor.getInt(cursor.getColumnIndex("msg_type")));
                                newInstance.setRecordId(cursor.getLong(cursor.getColumnIndex("rid")));
                                wj8.s(newInstance);
                                wj8.g(newInstance);
                                wj8.f(newInstance);
                                newInstance.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                                int columnIndex = cursor.getColumnIndex("read_count");
                                if (columnIndex >= 0) {
                                    newInstance.setReadCountPv(cursor.getInt(columnIndex));
                                }
                                linkedList.addFirst(newInstance);
                            } catch (SQLiteException e5) {
                                e = e5;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                                e.printStackTrace();
                                b(str3);
                                fi.a(cursor);
                                return linkedList;
                            } catch (Exception e6) {
                                e = e6;
                                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getAll", new Object[0]);
                                e.printStackTrace();
                                fi.a(cursor);
                                return linkedList;
                            }
                        }
                    }
                    fi.a(cursor);
                    return linkedList;
                }
            }
            if (TextUtils.isEmpty(str)) {
                e = qf8.d().e("select * from " + str4 + " WHERE is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{String.valueOf(0)});
            } else {
                e = qf8.d().e("select * from " + str4 + " WHERE mid<? AND is_delete=? ORDER BY rid DESC, mid DESC LIMIT " + i2, new String[]{str, String.valueOf(0)});
            }
            cursor = e;
            if (cursor != null) {
            }
            fi.a(cursor);
            return linkedList;
        }
        return (LinkedList) invokeCommon.objValue;
    }

    public LinkedList<String> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            LinkedList<String> linkedList = new LinkedList<>();
            Cursor cursor = null;
            try {
                try {
                    cursor = qf8.d().e("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("name"));
                            if (string.startsWith(this.a)) {
                                linkedList.add(string.subSequence(this.a.length(), string.length()).toString());
                            }
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getChatUserIdSync", new Object[0]);
                    e.printStackTrace();
                }
                return linkedList;
            } finally {
                fi.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    public CommonMsgPojo k(String str) {
        InterceptResult invokeL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = this.a + str;
            try {
                try {
                    cursor = qf8.d().e("select * from " + str2 + " WHERE is_delete=? ORDER BY rid DESC LIMIT 1", new String[]{String.valueOf(0)});
                    try {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                        if (cursor != null && cursor.moveToNext()) {
                            commonMsgPojo.setGid(str);
                            commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex(SourceConstant.SOURCE_USER_INFO)));
                            commonMsgPojo.setToUid(cursor.getString(cursor.getColumnIndex("to_uid")));
                            commonMsgPojo.setToUser_info(cursor.getString(cursor.getColumnIndex("to_user_info")));
                            commonMsgPojo.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            commonMsgPojo.setCreate_time(cursor.getLong(cursor.getColumnIndex("create_time")));
                            commonMsgPojo.setExt(cursor.getString(cursor.getColumnIndex("ext")));
                            commonMsgPojo.setMid(cursor.getLong(cursor.getColumnIndex("mid")));
                            commonMsgPojo.setMsg_status(cursor.getInt(cursor.getColumnIndex(IMConstants.MSG_STATUS)));
                            commonMsgPojo.setMsg_type(cursor.getInt(cursor.getColumnIndex("msg_type")));
                            commonMsgPojo.setRid(cursor.getLong(cursor.getColumnIndex("rid")));
                            commonMsgPojo.setRead_flag(cursor.getInt(cursor.getColumnIndex("read_flag")));
                            commonMsgPojo.setIs_delete(cursor.getInt(cursor.getColumnIndex("is_delete")));
                            commonMsgPojo.setIsFriend(cursor.getInt(cursor.getColumnIndex("is_friend")));
                            fi.a(cursor);
                            return commonMsgPojo;
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        b(str);
                        fi.a(cursor);
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getNewestMsgContext", new Object[0]);
                        e.printStackTrace();
                        fi.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = str2;
                    fi.a(cursor2);
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
                fi.a(cursor2);
                throw th;
            }
            fi.a(cursor);
            return null;
        }
        return (CommonMsgPojo) invokeL.objValue;
    }

    public LinkedList<ChatMessage> l(Map<String, yf8> map, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, map, i)) == null) {
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
                sb.append("SELECT * FROM ");
                sb.append(this.a + it.next());
                sb.append(" WHERE ");
                sb.append("msg_type");
                sb.append(" = 7");
                sb.append(" AND ");
                sb.append("is_delete");
                sb.append(" = ");
                sb.append(0);
                int i3 = i2 + 1;
                if (i2 != map.size() - 1) {
                    sb.append(" UNION ALL ");
                }
                i2 = i3;
            }
            sb.append(") ORDER BY ");
            sb.append("create_time");
            sb.append(" DESC LIMIT ?");
            LinkedList<ChatMessage> linkedList = new LinkedList<>();
            try {
                try {
                    cursor = qf8.d().e(sb.toString(), new String[]{String.valueOf(i)});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            ChatMessage newInstance = this.b.newInstance();
                            newInstance.setObjContent(map.get(cursor.getString(cursor.getColumnIndex("uid"))));
                            newInstance.setContent(cursor.getString(cursor.getColumnIndex("content")));
                            newInstance.setTime(cursor.getLong(cursor.getColumnIndex("create_time")));
                            newInstance.setExtra(cursor.getString(cursor.getColumnIndex("ext")));
                            newInstance.setMsgId(cursor.getLong(cursor.getColumnIndex("mid")));
                            newInstance.setUserId(cursor.getLong(cursor.getColumnIndex("uid")));
                            newInstance.setUserInfo((UserData) OrmObject.objectWithJsonStr(cursor.getString(cursor.getColumnIndex(SourceConstant.SOURCE_USER_INFO)), UserData.class));
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
                }
                return linkedList;
            } finally {
                fi.a(cursor);
            }
        }
        return (LinkedList) invokeLI.objValue;
    }

    public int m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                try {
                    try {
                        cursor = qf8.d().e("select count(*) from " + (this.a + str) + " WHERE read_flag=? AND is_delete" + RFC1522Codec.PREFIX, new String[]{String.valueOf(1), String.valueOf(0)});
                        if (cursor != null && cursor.moveToNext()) {
                            return cursor.getInt(0);
                        }
                    } catch (Exception e) {
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getUnreadcount", new Object[0]);
                        e.printStackTrace();
                    }
                } catch (SQLiteException e2) {
                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.getUnreadcount", new Object[0]);
                    e2.printStackTrace();
                }
                return 0;
            } finally {
                fi.a(cursor);
            }
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:26|27|(4:(3:77|78|(12:83|84|85|30|31|(5:62|63|64|65|66)(1:33)|34|(1:38)|39|40|41|42))|40|41|42)|29|30|31|(0)(0)|34|(2:36|38)|39|24) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x02c8, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x02c9, code lost:
        r3 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x02cf, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x02d0, code lost:
        r3 = r23;
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0201 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x028f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean n(long j, List<CommonMsgPojo> list, boolean z) {
        InterceptResult invokeCommon;
        Cursor cursor;
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        String str;
        String str2;
        SQLiteStatement sQLiteStatement3;
        ContentValues contentValues;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), list, Boolean.valueOf(z)})) == null) {
            String str4 = "rid";
            String str5 = "msg_type";
            if (list == null) {
                return false;
            }
            if (j != 0 && TbadkCoreApplication.getCurrentAccount() != null) {
                String valueOf = String.valueOf(j);
                String str6 = this.a + valueOf;
                if (this.c == null) {
                    this.c = i();
                }
                if (!this.c.contains(valueOf)) {
                    b(valueOf);
                    this.c.add(valueOf);
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(" INSERT INTO ");
                    sb.append(str6);
                    sb.append("(");
                    sb.append("content");
                    sb.append(",");
                    sb.append("create_time");
                    sb.append(",");
                    sb.append("ext");
                    sb.append(",");
                    sb.append("mid");
                    sb.append(",");
                    sb.append("uid");
                    sb.append(",");
                    sb.append(SourceConstant.SOURCE_USER_INFO);
                    sb.append(",");
                    sb.append("to_uid");
                    sb.append(",");
                    sb.append("to_user_info");
                    sb.append(",");
                    sb.append(IMConstants.MSG_STATUS);
                    sb.append(",");
                    sb.append("msg_type");
                    sb.append(",");
                    sb.append("rid");
                    sb.append(",");
                    String str7 = "read_flag";
                    sb.append(str7);
                    sb.append(",");
                    String str8 = "is_delete";
                    try {
                        sb.append(str8);
                        sb.append(",");
                        sb.append("is_friend");
                        String str9 = "is_friend";
                        sb.append(") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
                        sQLiteStatement = qf8.d().a(sb.toString());
                        try {
                            Iterator<CommonMsgPojo> it = list.iterator();
                            long j2 = 0;
                            while (it.hasNext()) {
                                CommonMsgPojo next = it.next();
                                Iterator<CommonMsgPojo> it2 = it;
                                try {
                                    if (z) {
                                        try {
                                            if (next.isSelf() && next.getRid() != 0) {
                                                sQLiteStatement2 = sQLiteStatement;
                                                try {
                                                    str = str8;
                                                    str2 = str7;
                                                    qf8.d().delete(str6, "mid=?", new String[]{String.valueOf(next.getRid())});
                                                    contentValues = new ContentValues();
                                                    contentValues.put("content", next.getContent());
                                                    contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                                    contentValues.put("ext", next.getExt());
                                                    contentValues.put("mid", Long.valueOf(next.getMid()));
                                                    contentValues.put("uid", next.getUid());
                                                    contentValues.put(SourceConstant.SOURCE_USER_INFO, next.getUser_info());
                                                    contentValues.put("to_uid", next.getToUid());
                                                    contentValues.put("to_user_info", next.getToUser_info());
                                                    contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                                                    contentValues.put(str5, Integer.valueOf(next.getMsg_type()));
                                                    contentValues.put("ext", next.getExt());
                                                    contentValues.put(str4, Long.valueOf(next.getRid()));
                                                    String str10 = str2;
                                                    contentValues.put(str10, Integer.valueOf(next.getRead_flag()));
                                                    String str11 = str;
                                                    contentValues.put(str11, Integer.valueOf(next.getIs_delete()));
                                                    String str12 = str9;
                                                    contentValues.put(str12, Integer.valueOf(next.getIsFriend()));
                                                    str9 = str12;
                                                    String str13 = str4;
                                                    if (qf8.d().update(str6, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                                                        try {
                                                            sQLiteStatement2.clearBindings();
                                                            sQLiteStatement3 = sQLiteStatement2;
                                                            try {
                                                                sQLiteStatement3.bindString(1, next.getContent());
                                                                str3 = str5;
                                                                sQLiteStatement3.bindLong(2, next.getCreate_time());
                                                                sQLiteStatement3.bindString(3, next.getExt());
                                                                sQLiteStatement3.bindLong(4, next.getMid());
                                                                sQLiteStatement3.bindString(5, next.getUid());
                                                                sQLiteStatement3.bindString(6, next.getUser_info());
                                                                sQLiteStatement3.bindString(7, next.getToUid());
                                                                sQLiteStatement3.bindString(8, next.getToUser_info());
                                                                sQLiteStatement3.bindLong(9, next.getMsg_status());
                                                                sQLiteStatement3.bindLong(10, next.getMsg_type());
                                                                sQLiteStatement3.bindLong(11, next.getRid());
                                                                sQLiteStatement3.bindLong(12, next.getRead_flag());
                                                                sQLiteStatement3.bindLong(13, next.getIs_delete());
                                                                sQLiteStatement3.bindLong(14, next.getIsFriend());
                                                                sQLiteStatement3.executeInsert();
                                                            } catch (Exception e) {
                                                                e = e;
                                                                sQLiteStatement = sQLiteStatement3;
                                                                try {
                                                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                                    e.printStackTrace();
                                                                    fi.a(null);
                                                                    fi.c(sQLiteStatement);
                                                                    return true;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    cursor = null;
                                                                    fi.a(cursor);
                                                                    fi.c(sQLiteStatement);
                                                                    throw th;
                                                                }
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                sQLiteStatement = sQLiteStatement3;
                                                                cursor = null;
                                                                fi.a(cursor);
                                                                fi.c(sQLiteStatement);
                                                                throw th;
                                                            }
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            sQLiteStatement3 = sQLiteStatement2;
                                                            sQLiteStatement = sQLiteStatement3;
                                                            TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                            e.printStackTrace();
                                                            fi.a(null);
                                                            fi.c(sQLiteStatement);
                                                            return true;
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            sQLiteStatement3 = sQLiteStatement2;
                                                            sQLiteStatement = sQLiteStatement3;
                                                            cursor = null;
                                                            fi.a(cursor);
                                                            fi.c(sQLiteStatement);
                                                            throw th;
                                                        }
                                                    } else {
                                                        str3 = str5;
                                                        sQLiteStatement3 = sQLiteStatement2;
                                                    }
                                                    if (next.getMsg_type() == 34 && j2 < next.getCreate_time()) {
                                                        j2 = next.getCreate_time();
                                                    }
                                                    long j3 = j2;
                                                    s(str6, j3);
                                                    j2 = j3;
                                                    sQLiteStatement = sQLiteStatement3;
                                                    str8 = str11;
                                                    str5 = str3;
                                                    str7 = str10;
                                                    str4 = str13;
                                                    it = it2;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    sQLiteStatement = sQLiteStatement2;
                                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                                    e.printStackTrace();
                                                    fi.a(null);
                                                    fi.c(sQLiteStatement);
                                                    return true;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    sQLiteStatement = sQLiteStatement2;
                                                    cursor = null;
                                                    fi.a(cursor);
                                                    fi.c(sQLiteStatement);
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    }
                                    s(str6, j3);
                                    j2 = j3;
                                    sQLiteStatement = sQLiteStatement3;
                                    str8 = str11;
                                    str5 = str3;
                                    str7 = str10;
                                    str4 = str13;
                                    it = it2;
                                } catch (Exception e5) {
                                    e = e5;
                                    sQLiteStatement = sQLiteStatement3;
                                    TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                                    e.printStackTrace();
                                    fi.a(null);
                                    fi.c(sQLiteStatement);
                                    return true;
                                } catch (Throwable th6) {
                                    th = th6;
                                    sQLiteStatement = sQLiteStatement3;
                                    cursor = null;
                                    fi.a(cursor);
                                    fi.c(sQLiteStatement);
                                    throw th;
                                }
                                str = str8;
                                sQLiteStatement2 = sQLiteStatement;
                                str2 = str7;
                                contentValues = new ContentValues();
                                contentValues.put("content", next.getContent());
                                contentValues.put("create_time", Long.valueOf(next.getCreate_time()));
                                contentValues.put("ext", next.getExt());
                                contentValues.put("mid", Long.valueOf(next.getMid()));
                                contentValues.put("uid", next.getUid());
                                contentValues.put(SourceConstant.SOURCE_USER_INFO, next.getUser_info());
                                contentValues.put("to_uid", next.getToUid());
                                contentValues.put("to_user_info", next.getToUser_info());
                                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(next.getMsg_status()));
                                contentValues.put(str5, Integer.valueOf(next.getMsg_type()));
                                contentValues.put("ext", next.getExt());
                                contentValues.put(str4, Long.valueOf(next.getRid()));
                                String str102 = str2;
                                contentValues.put(str102, Integer.valueOf(next.getRead_flag()));
                                String str112 = str;
                                contentValues.put(str112, Integer.valueOf(next.getIs_delete()));
                                String str122 = str9;
                                contentValues.put(str122, Integer.valueOf(next.getIsFriend()));
                                str9 = str122;
                                String str132 = str4;
                                if (qf8.d().update(str6, contentValues, "mid=?", new String[]{String.valueOf(next.getMid())}) != 0) {
                                }
                                if (next.getMsg_type() == 34) {
                                    j2 = next.getCreate_time();
                                }
                                long j32 = j2;
                            }
                            fi.a(null);
                            fi.c(sQLiteStatement);
                            return true;
                        } catch (Exception e6) {
                            e = e6;
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        sQLiteStatement = null;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.insertOrUpdate", new Object[0]);
                        e.printStackTrace();
                        fi.a(null);
                        fi.c(sQLiteStatement);
                        return true;
                    } catch (Throwable th8) {
                        th = th8;
                        cursor = null;
                        sQLiteStatement = null;
                        fi.a(cursor);
                        fi.c(sQLiteStatement);
                        throw th;
                    }
                } catch (Exception e8) {
                    e = e8;
                } catch (Throwable th9) {
                    th = th9;
                }
            } else {
                return false;
            }
        } else {
            return invokeCommon.booleanValue;
        }
    }

    public boolean o(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_delete", (Integer) 1);
                qf8.d().update(this.a + str, contentValues, "mid=?", new String[]{str2});
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public void s(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, str, j) == null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("ext", "expired");
                qf8 d = qf8.d();
                d.update(str, contentValues, "msg_type=? and create_time<?", new String[]{PayUVEventType.PAY_SPLIT_ORDER_MOTIFY_BTN_CLICK, "" + j});
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
        }
    }

    public void t(long j, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            String str = this.a + j;
            try {
                ContentValues contentValues = new ContentValues();
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put("is_delete", Integer.valueOf(i));
                qf8.d().update(str, contentValues, "uid!=?", new String[]{"0"});
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
        }
    }

    public boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            try {
                t(Long.parseLong(str), true);
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.c = null;
        }
    }

    public boolean r(String str, int i) {
        InterceptResult invokeLI;
        String str2;
        Cursor e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i)) == null) {
            Cursor cursor = null;
            String str3 = null;
            cursor = null;
            try {
                try {
                    str2 = this.a + str;
                    if (i < 1000) {
                        i = 1000;
                    }
                    e = qf8.d().e("SELECT * FROM " + str2 + " ORDER BY mid DESC LIMIT " + i + ", 1", null);
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (e.moveToNext()) {
                    str3 = e.getString(e.getColumnIndex("mid"));
                }
                fi.a(e);
                if (str3 != null) {
                    qf8.d().delete(str2, "mid<?", new String[]{str3});
                }
                fi.a(e);
                return true;
            } catch (Exception e3) {
                e = e3;
                cursor = e;
                e.printStackTrace();
                TiebaStatic.printDBExceptionLog(e, "shrink", new Object[0]);
                fi.a(cursor);
                return false;
            } catch (Throwable th2) {
                th = th2;
                cursor = e;
                fi.a(cursor);
                throw th;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean u(long j, long j2, String str, String str2, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Integer.valueOf(i)})) == null) {
            return v(j, j2, str, str2, i, null);
        }
        return invokeCommon.booleanValue;
    }

    public boolean v(long j, long j2, String str, String str2, int i, String str3) {
        InterceptResult invokeCommon;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Integer.valueOf(i), str3})) == null) {
            Boolean bool2 = Boolean.FALSE;
            if (j == 0 || j2 == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            String valueOf = String.valueOf(j);
            if (TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                valueOf = String.valueOf(j2);
            }
            String str4 = this.a + valueOf;
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mid", str2);
                contentValues.put(IMConstants.MSG_STATUS, Integer.valueOf(i));
                if (str3 != null) {
                    contentValues.put("ext", str3);
                }
                if (qf8.d().update(str4, contentValues, "mid=?", new String[]{str}) > 0) {
                    bool = Boolean.TRUE;
                } else {
                    bool = Boolean.FALSE;
                }
                bool2 = bool;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.updateState", new Object[0]);
                e.printStackTrace();
            }
            return bool2.booleanValue();
        }
        return invokeCommon.booleanValue;
    }
}
