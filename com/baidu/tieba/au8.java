package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.request.MessageExt;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.GroupChatRoomPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes5.dex */
public class au8 {
    public static /* synthetic */ Interceptable $ic;
    public static au8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public au8() {
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

    public static synchronized au8 j() {
        InterceptResult invokeV;
        au8 au8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (au8.class) {
                if (a == null) {
                    a = new au8();
                }
                au8Var = a;
            }
            return au8Var;
        }
        return (au8) invokeV.objValue;
    }

    public final boolean a(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            boolean z = false;
            if (StringUtils.isNull(str) || StringUtils.isNull(str2)) {
                return false;
            }
            Cursor cursor = null;
            try {
                fu8 e = fu8.e();
                cursor = e.g("SELECT * FROM SQLITE_MASTER WHERE NAME = ? AND SQL LIKE ?", new String[]{str, "%" + str2 + "%"});
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        z = true;
                    }
                }
                return z;
            } catch (SQLiteException e2) {
                e2.printStackTrace();
                return false;
            } finally {
                sd.a(cursor);
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean e(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, str, j)) == null) {
            c();
            boolean z = false;
            Cursor cursor = null;
            try {
                cursor = fu8.e().g("select * from " + str + " WHERE room_id" + RFC1522Codec.PREFIX, new String[]{String.valueOf(j)});
                if (cursor != null) {
                    if (cursor.moveToNext()) {
                        z = true;
                    }
                }
                return z;
            } catch (SQLiteException e) {
                e.printStackTrace();
                return false;
            } finally {
                sd.a(cursor);
            }
        }
        return invokeLJ.booleanValue;
    }

    @WorkerThread
    public List<GroupChatRoomPojo> h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            c();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str3 = "tb_group_chat_room_" + str;
            o(str3);
            return g("select * from " + str3 + " WHERE forum_Id" + RFC1522Codec.PREFIX, new String[]{str2});
        }
        return (List) invokeLL.objValue;
    }

    @Nullable
    @WorkerThread
    public List<GroupChatRoomPojo> i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str3 = "tb_group_chat_room_" + str;
            o(str3);
            return g("select * from " + str3 + " WHERE forum_name" + RFC1522Codec.PREFIX, new String[]{str2});
        }
        return (List) invokeLL.objValue;
    }

    public void b(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        o("tb_group_chat_room_" + str);
    }

    public final void o(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && m().contains(str) && !a(str, "exit_time")) {
            n(str, "exit_time", "LONG", "1");
        }
    }

    public final void c() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && GlobalBuildConfig.isDebug()) {
            try {
                if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                    z = true;
                } else {
                    z = false;
                }
                gu5.e(z, "请勿在主线程进行db操作，需要调整到子线程！");
            } catch (Exception e) {
                BdLog.e(Log.getStackTraceString(e));
            }
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = "tb_group_chat_room_" + str;
            if (m().contains(str2)) {
                if (!a(str2, "exit_time")) {
                    n(str2, "exit_time", "LONG", "1");
                    return;
                }
                return;
            }
            fu8.e().d("CREATE TABLE IF NOT EXISTS " + str2 + "(room_id LONG primary key, name TEXT, avatar TEXT, forum_Id TEXT, forum_name TEXT, " + MessageExt.KEY_LATEST_MSG_ID + " LONG, exit_time LONG DEFAULT 1, timestamp LONG, " + DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM + " LONG, top_time LONG, " + TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE + " INTEGER DEFAULT 0, no_disturb INTEGER DEFAULT 0);");
        }
    }

    @Nullable
    @WorkerThread
    public GroupChatRoomPojo f(String str, long j) {
        InterceptResult invokeLJ;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048581, this, str, j)) == null) {
            c();
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "tb_group_chat_room_" + str;
            o(str2);
            try {
                cursor = fu8.e().g("select * from " + str2 + " WHERE room_id" + RFC1522Codec.PREFIX, new String[]{String.valueOf(j)});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                GroupChatRoomPojo groupChatRoomPojo = new GroupChatRoomPojo();
                                groupChatRoomPojo.setRoomId(j);
                                groupChatRoomPojo.setName(cursor.getString(cursor.getColumnIndex("name")));
                                groupChatRoomPojo.setAvatar(cursor.getString(cursor.getColumnIndex("avatar")));
                                groupChatRoomPojo.setForumId(cursor.getString(cursor.getColumnIndex("forum_Id")));
                                groupChatRoomPojo.setForumName(cursor.getString(cursor.getColumnIndex("forum_name")));
                                groupChatRoomPojo.Q(cursor.getLong(cursor.getColumnIndex(MessageExt.KEY_LATEST_MSG_ID)));
                                groupChatRoomPojo.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                                groupChatRoomPojo.setDeleteTime(cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM)));
                                groupChatRoomPojo.setTopTime(cursor.getLong(cursor.getColumnIndex("top_time")));
                                groupChatRoomPojo.setIsSubscribe(cursor.getInt(cursor.getColumnIndex(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE)));
                                groupChatRoomPojo.setNoDisturb(cursor.getInt(cursor.getColumnIndex("no_disturb")));
                                groupChatRoomPojo.setLastExitChatRoomTime(cursor.getLong(cursor.getColumnIndex("exit_time")));
                                sd.a(cursor);
                                return groupChatRoomPojo;
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "GroupChatRoomPojo#getGroupChatRoomPojo", new Object[0]);
                            sd.a(cursor);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        sd.a(cursor2);
                        throw th;
                    }
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                sd.a(cursor2);
                throw th;
            }
            sd.a(cursor);
            return null;
        }
        return (GroupChatRoomPojo) invokeLJ.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x00d4 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    public final List<GroupChatRoomPojo> g(String str, String[] strArr) {
        InterceptResult invokeLL;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, strArr)) == null) {
            c();
            ?? r1 = 0;
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    cursor = fu8.e().g(str, strArr);
                    if (cursor != null) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            while (cursor.moveToNext()) {
                                GroupChatRoomPojo groupChatRoomPojo = new GroupChatRoomPojo();
                                groupChatRoomPojo.setRoomId(cursor.getLong(cursor.getColumnIndex("room_id")));
                                groupChatRoomPojo.setName(cursor.getString(cursor.getColumnIndex("name")));
                                groupChatRoomPojo.setAvatar(cursor.getString(cursor.getColumnIndex("avatar")));
                                groupChatRoomPojo.setForumId(cursor.getString(cursor.getColumnIndex("forum_Id")));
                                groupChatRoomPojo.setForumName(cursor.getString(cursor.getColumnIndex("forum_name")));
                                groupChatRoomPojo.Q(cursor.getLong(cursor.getColumnIndex(MessageExt.KEY_LATEST_MSG_ID)));
                                groupChatRoomPojo.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
                                groupChatRoomPojo.setDeleteTime(cursor.getLong(cursor.getColumnIndex(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM)));
                                groupChatRoomPojo.setTopTime(cursor.getLong(cursor.getColumnIndex("top_time")));
                                groupChatRoomPojo.setIsSubscribe(cursor.getInt(cursor.getColumnIndex(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE)));
                                groupChatRoomPojo.setNoDisturb(cursor.getInt(cursor.getColumnIndex("no_disturb")));
                                groupChatRoomPojo.setLastExitChatRoomTime(cursor.getLong(cursor.getColumnIndex("exit_time")));
                                arrayList.add(groupChatRoomPojo);
                            }
                            sd.a(cursor);
                            return arrayList;
                        } catch (SQLiteException e) {
                            e = e;
                            TiebaStatic.printDBExceptionLog(e, "GroupChatRoomPojo#getGroupChatRoomPojo", new Object[0]);
                            sd.a(cursor);
                            return null;
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    sd.a(r1);
                    throw th;
                }
                sd.a(cursor);
                return null;
            } catch (Throwable th2) {
                th = th2;
                r1 = str;
            }
        } else {
            return (List) invokeLL.objValue;
        }
    }

    public final boolean p(String str, GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, groupChatRoomPojo)) == null) {
            c();
            String str2 = "tb_group_chat_room_" + str;
            d(str);
            try {
                if (!e(str2, groupChatRoomPojo.getRoomId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("room_id", Long.valueOf(groupChatRoomPojo.getRoomId()));
                    contentValues.put("name", groupChatRoomPojo.getName());
                    contentValues.put("avatar", groupChatRoomPojo.getAvatar());
                    contentValues.put("forum_Id", groupChatRoomPojo.getForumId());
                    contentValues.put("forum_name", groupChatRoomPojo.getForumName());
                    contentValues.put(MessageExt.KEY_LATEST_MSG_ID, Long.valueOf(groupChatRoomPojo.getLatestMsgId()));
                    contentValues.put("timestamp", Long.valueOf(groupChatRoomPojo.getTimestamp()));
                    contentValues.put(DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM, Long.valueOf(groupChatRoomPojo.getDeleteTime()));
                    contentValues.put("top_time", Long.valueOf(groupChatRoomPojo.getTopTime()));
                    contentValues.put(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, Integer.valueOf(groupChatRoomPojo.O()));
                    contentValues.put("no_disturb", Integer.valueOf(groupChatRoomPojo.P()));
                    long lastExitChatRoomTime = groupChatRoomPojo.getLastExitChatRoomTime();
                    if (lastExitChatRoomTime > 0) {
                        contentValues.put("exit_time", Long.valueOf(lastExitChatRoomTime));
                    }
                    if (fu8.e().f(str2, null, contentValues) == -1) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#insertGroupChatRoomPojo", new Object[0]);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public List<GroupChatRoomPojo> k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            c();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "tb_group_chat_room_" + str;
            o(str2);
            return g("select * from " + str2, null);
        }
        return (List) invokeL.objValue;
    }

    @WorkerThread
    public List<GroupChatRoomPojo> l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            c();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String str2 = "tb_group_chat_room_" + str;
            o(str2);
            return g("select * from " + str2 + " WHERE " + TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE + RFC1522Codec.PREFIX, new String[]{String.valueOf(1)});
        }
        return (List) invokeL.objValue;
    }

    public final LinkedList<String> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            c();
            LinkedList<String> linkedList = new LinkedList<>();
            Cursor cursor = null;
            try {
                try {
                    cursor = fu8.e().g("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        while (cursor.moveToNext()) {
                            String string = cursor.getString(cursor.getColumnIndex("name"));
                            if (string.startsWith("tb_group_chat_room_")) {
                                linkedList.add(string);
                            }
                        }
                    }
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao.getTables", new Object[0]);
                    e.printStackTrace();
                }
                return linkedList;
            } finally {
                sd.a(cursor);
            }
        }
        return (LinkedList) invokeV.objValue;
    }

    public final boolean n(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048588, this, str, str2, str3, str4)) == null) {
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
                String str5 = "ALTER TABLE " + str + " ADD COLUMN " + str2 + " " + str3;
                if (!StringUtils.isNull(str4)) {
                    str5 = str5 + " DEFAULT " + str4;
                }
                return fu8.e().d(str5);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean q(@NonNull String str, @NonNull GroupChatRoomPojo groupChatRoomPojo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, groupChatRoomPojo)) == null) {
            c();
            String str2 = "tb_group_chat_room_" + str;
            d(str);
            try {
                if (e(str2, groupChatRoomPojo.getRoomId())) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("name", groupChatRoomPojo.getName());
                    contentValues.put("avatar", groupChatRoomPojo.getAvatar());
                    contentValues.put("forum_Id", groupChatRoomPojo.getForumId());
                    contentValues.put("forum_name", groupChatRoomPojo.getForumName());
                    contentValues.put(MessageExt.KEY_LATEST_MSG_ID, Long.valueOf(groupChatRoomPojo.getLatestMsgId()));
                    contentValues.put("timestamp", Long.valueOf(groupChatRoomPojo.getTimestamp()));
                    contentValues.put(TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, Integer.valueOf(groupChatRoomPojo.O()));
                    long lastExitChatRoomTime = groupChatRoomPojo.getLastExitChatRoomTime();
                    if (lastExitChatRoomTime > 0) {
                        contentValues.put("exit_time", Long.valueOf(lastExitChatRoomTime));
                    }
                    if (fu8.e().i(str2, contentValues, "room_id=?", new String[]{String.valueOf(groupChatRoomPojo.getRoomId())}) != 1) {
                        return false;
                    }
                    return true;
                }
                return p(str, groupChatRoomPojo);
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#updateGroupChatRoomPojo", new Object[0]);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public boolean r(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, long j, long j2, long j3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, str2, str3, str4, str5, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z)})) == null) {
            return s(str, str2, str3, str4, str5, j, j2, j3, z, 0L);
        }
        return invokeCommon.booleanValue;
    }

    public boolean s(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, long j, long j2, long j3, boolean z, long j4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, str2, str3, str4, str5, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(j4)})) == null) {
            GroupChatRoomPojo groupChatRoomPojo = new GroupChatRoomPojo();
            groupChatRoomPojo.setName(str2);
            groupChatRoomPojo.setRoomId(j);
            groupChatRoomPojo.setForumName(str5);
            groupChatRoomPojo.setForumId(str4);
            groupChatRoomPojo.setAvatar(str3);
            groupChatRoomPojo.Q(j2);
            groupChatRoomPojo.setTimestamp(j3);
            groupChatRoomPojo.setIsSubscribe(z ? 1 : 0);
            groupChatRoomPojo.setLastExitChatRoomTime(j4);
            return q(str, groupChatRoomPojo);
        }
        return invokeCommon.booleanValue;
    }

    public boolean t(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{str, Long.valueOf(j), str2, str3, Long.valueOf(j2)})) == null) {
            return v(str, j, str2, str3, DBTableDefine.GroupInfoColumns.COLUMN_DELETE_TIEM, j2);
        }
        return invokeCommon.booleanValue;
    }

    public boolean w(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{str, Long.valueOf(j), str2, str3, Boolean.valueOf(z)})) == null) {
            return u(str, j, str2, str3, "no_disturb", z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean x(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{str, Long.valueOf(j), str2, str3, Boolean.valueOf(z)})) == null) {
            return u(str, j, str2, str3, TableDefine.ZhiDaColumns.COLUMN_IS_SUBSCRIBE, z);
        }
        return invokeCommon.booleanValue;
    }

    public boolean y(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Long.valueOf(j), str2, str3, Long.valueOf(j2)})) == null) {
            return v(str, j, str2, str3, "top_time", j2);
        }
        return invokeCommon.booleanValue;
    }

    public final boolean u(String str, long j, @NonNull String str2, @NonNull String str3, String str4, boolean z) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, Long.valueOf(j), str2, str3, str4, Boolean.valueOf(z)})) == null) {
            c();
            String str5 = "tb_group_chat_room_" + str;
            d(str);
            try {
                if (!e(str5, j)) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                contentValues.put(str4, Integer.valueOf(i));
                contentValues.put("name", str2);
                contentValues.put("avatar", str3);
                if (fu8.e().i(str5, contentValues, "room_id=?", new String[]{String.valueOf(j)}) != 1) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#updateIntField", new Object[0]);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    public final boolean v(@NonNull String str, long j, @NonNull String str2, @NonNull String str3, String str4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{str, Long.valueOf(j), str2, str3, str4, Long.valueOf(j2)})) == null) {
            c();
            String str5 = "tb_group_chat_room_" + str;
            d(str);
            try {
                if (!e(str5, j)) {
                    return false;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put(str4, Long.valueOf(j2));
                contentValues.put("name", str2);
                contentValues.put("avatar", str3);
                if (fu8.e().i(str5, contentValues, "room_id=?", new String[]{String.valueOf(j)}) != 1) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "GroupChatRoomDao#updateLongField", new Object[0]);
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }
}
