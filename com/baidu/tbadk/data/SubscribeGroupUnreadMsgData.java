package com.baidu.tbadk.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Loop.ChatroomMessageTabData;
/* loaded from: classes5.dex */
public class SubscribeGroupUnreadMsgData extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4434967430479553722L;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isHaveUnreadMsg;
    public String timeStamp;

    public SubscribeGroupUnreadMsgData() {
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

    public String getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.timeStamp;
        }
        return (String) invokeV.objValue;
    }

    public boolean isHaveUnreadMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isHaveUnreadMsg;
        }
        return invokeV.booleanValue;
    }

    public void parse(ChatroomMessageTabData chatroomMessageTabData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, chatroomMessageTabData, str) == null) && chatroomMessageTabData != null && !TextUtils.isEmpty(str)) {
            this.timeStamp = str;
            this.isHaveUnreadMsg = chatroomMessageTabData.have_new_msg.booleanValue();
        }
    }
}
