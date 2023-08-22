package com.baidu.tieba.im.lib.socket.msg;

import com.baidu.tieba.im.lib.socket.msg.data.AbilityEffectItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbEffectGuidanceSysMsg extends TbNoUISysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7019;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("one_key_conversation")
    public AbilityEffectItem oneKeyConversation;

    public TbEffectGuidanceSysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        setType(7019);
    }

    public AbilityEffectItem getOneKeyConversation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.oneKeyConversation;
        }
        return (AbilityEffectItem) invokeV.objValue;
    }
}
