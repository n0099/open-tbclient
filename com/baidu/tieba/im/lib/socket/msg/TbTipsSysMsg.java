package com.baidu.tieba.im.lib.socket.msg;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.lib.socket.msg.TbSysMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class TbTipsSysMsg extends TbSysMsg {
    public static /* synthetic */ Interceptable $ic;
    public static final List<Integer> MSG_TYPE_LIST;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("msg_content")
    public String msgContent;
    @SerializedName("managerTips")
    public String tips;
    @Nullable
    @SerializedName("user_to")
    public TbSysMsg.User userTo;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-817296482, "Lcom/baidu/tieba/im/lib/socket/msg/TbTipsSysMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-817296482, "Lcom/baidu/tieba/im/lib/socket/msg/TbTipsSysMsg;");
                return;
            }
        }
        MSG_TYPE_LIST = Arrays.asList(-7014, Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_CURRENCY_TIPS), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_TIPS));
    }

    public TbTipsSysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    public static TbTipsSysMsg createManagerTips(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            TbTipsSysMsg tbTipsSysMsg = new TbTipsSysMsg();
            tbTipsSysMsg.setType(-7014);
            tbTipsSysMsg.tips = str;
            return tbTipsSysMsg;
        }
        return (TbTipsSysMsg) invokeL.objValue;
    }

    @NonNull
    public String getTips() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (-7014 == getType()) {
                if (TextUtils.isEmpty(this.tips)) {
                    return "";
                }
                return this.tips;
            } else if (7017 == getType()) {
                if (TextUtils.isEmpty(this.msgContent)) {
                    return "";
                }
                return this.msgContent;
            } else if (getMsgConf() == null) {
                return "";
            } else {
                return getMsgConf().getLowVersionContent();
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im.lib.socket.msg.TbSysMsg
    public boolean isIgnore() {
        InterceptResult invokeV;
        TbSysMsg.User user;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getType() == -7014) {
                return false;
            }
            if (getType() == 7017 && (user = this.userTo) != null) {
                return !TextUtils.equals(String.valueOf(user.getUserId()), TbadkCoreApplication.getCurrentAccount());
            }
            if (getMsgConf() != null && getMsgConf().getLowVersionType() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
