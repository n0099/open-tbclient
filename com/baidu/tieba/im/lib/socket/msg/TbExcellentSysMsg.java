package com.baidu.tieba.im.lib.socket.msg;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
/* loaded from: classes6.dex */
public class TbExcellentSysMsg extends TbNoticeModifySysMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MSG_TYPE = 7018;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("excellent_msg_op")
    public int excellentMsgOp;
    @SerializedName("top_bubble_info")
    public TopBubbleData topButtonInfo;

    public TbExcellentSysMsg() {
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
        setType(7018);
    }

    public int getExcellentMsgOp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.excellentMsgOp;
        }
        return invokeV.intValue;
    }

    public TopBubbleData getTopButtonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.topButtonInfo;
        }
        return (TopBubbleData) invokeV.objValue;
    }
}
