package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ga7 extends u97 {
    public static /* synthetic */ Interceptable $ic = null;
    public static u97 d = null;
    public static String e = "tb_private_msg_";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947787276, "Lcom/baidu/tieba/ga7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947787276, "Lcom/baidu/tieba/ga7;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ga7() {
        super("tb_private_msg_", PersonalChatMessage.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (Class) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static synchronized ga7 w() {
        InterceptResult invokeV;
        ga7 ga7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (ga7.class) {
                if (d == null) {
                    d = new ga7();
                }
                ga7Var = (ga7) d;
            }
            return ga7Var;
        }
        return (ga7) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public CommonMsgPojo x(String str, int i) {
        InterceptResult invokeLI;
        Cursor cursor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            Cursor cursor2 = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                try {
                    cursor = ba7.d().e("select * from " + (e + str) + " WHERE is_delete=? AND msg_type= ?", new String[]{String.valueOf(0), String.valueOf(i)});
                    try {
                        CommonMsgPojo commonMsgPojo = new CommonMsgPojo();
                        if (cursor != null && cursor.moveToNext()) {
                            commonMsgPojo.setGid(str);
                            commonMsgPojo.setUid(cursor.getString(cursor.getColumnIndex("uid")));
                            commonMsgPojo.setUser_info(cursor.getString(cursor.getColumnIndex("user_info")));
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
                            gj.a(cursor);
                            return commonMsgPojo;
                        }
                    } catch (SQLiteException e2) {
                        e = e2;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                        e.printStackTrace();
                        b(str);
                        gj.a(cursor);
                        return null;
                    } catch (Exception e3) {
                        e = e3;
                        TiebaStatic.printDBExceptionLog(e, "PersonalMsgDao.getMsgContextByMsgType", new Object[0]);
                        e.printStackTrace();
                        gj.a(cursor);
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = i;
                    gj.a(cursor2);
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
                gj.a(cursor2);
                throw th;
            }
            gj.a(cursor);
            return null;
        }
        return (CommonMsgPojo) invokeLI.objValue;
    }

    public boolean y(long j, long j2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str})) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            Boolean bool = Boolean.FALSE;
            if (j == 0 || TbadkCoreApplication.getCurrentAccount() == null) {
                return false;
            }
            String valueOf = String.valueOf(j);
            String str2 = e + valueOf;
            if (this.c == null) {
                this.c = i();
            }
            if (!this.c.contains(valueOf)) {
                b(valueOf);
                this.c.add(valueOf);
            }
            try {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("content", str);
                    if (ba7.d().update(str2, contentValues, "mid=?", new String[]{String.valueOf(j2)}) == 1) {
                        bool = Boolean.TRUE;
                    }
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "PersonalMsgDao.updateGamePlayMsg", new Object[0]);
                    e2.printStackTrace();
                    bool = Boolean.FALSE;
                }
                gj.a(null);
                gj.c(null);
                return bool.booleanValue();
            } catch (Throwable th) {
                gj.a(null);
                gj.c(null);
                throw th;
            }
        }
        return invokeCommon.booleanValue;
    }
}
