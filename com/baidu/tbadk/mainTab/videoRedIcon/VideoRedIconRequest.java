package com.baidu.tbadk.mainTab.videoRedIcon;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.qq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.VideoRedIcon.DataReq;
import tbclient.VideoRedIcon.VideoRedIconReqIdl;
/* loaded from: classes3.dex */
public class VideoRedIconRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_VIDEO_TAB = "video_tab";
    public transient /* synthetic */ FieldHolder $fh;
    public String callFrom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoRedIconRequest() {
        super(CmdConfigHttp.CMD_VIDEO_TAB_RED_ICON, 309708);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            if (!TextUtils.isEmpty(this.callFrom)) {
                builder.call_from = this.callFrom;
            }
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                qq5.a(builder, true);
            }
            VideoRedIconReqIdl.Builder builder2 = new VideoRedIconReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.callFrom = str;
        }
    }
}
