package com.baidu.tieba.hottopicselect;

import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.b0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.GetSugTopic.DataReq;
import tbclient.GetSugTopic.GetSugTopicReqIdl;
/* loaded from: classes5.dex */
public class HotTopicSelectNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f33660common;
    public long fid;
    public String firstDir;
    public boolean isVideoTopic;
    public String prefix;
    public String secondDir;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicSelectNetMessage() {
        super(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
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
        this.firstDir = "";
        this.secondDir = "";
        this.fid = 0L;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f45657common = getCommon();
            builder.fid = Long.valueOf(this.fid);
            String str = this.prefix;
            if (str != null) {
                builder.prefix = str;
            }
            String str2 = this.firstDir;
            if (str2 != null) {
                builder.first_dir = str2;
            }
            String str3 = this.secondDir;
            if (str3 != null) {
                builder.second_dir = str3;
            }
            builder.is_video_topic = Integer.valueOf(this.isVideoTopic ? 1 : 0);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                b0.a(builder, true);
            }
            GetSugTopicReqIdl.Builder builder2 = new GetSugTopicReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public CommonReq getCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33660common : (CommonReq) invokeV.objValue;
    }

    public long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.fid : invokeV.longValue;
    }

    public String getFirstDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.firstDir : (String) invokeV.objValue;
    }

    public String getPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.prefix : (String) invokeV.objValue;
    }

    public String getSecondDir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.secondDir : (String) invokeV.objValue;
    }

    public boolean isVideoTopic() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.isVideoTopic : invokeV.booleanValue;
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, commonReq) == null) {
            this.f33660common = commonReq;
        }
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.fid = j;
        }
    }

    public void setFirstDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.firstDir = str;
        }
    }

    public void setPrefix(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.prefix = str;
        }
    }

    public void setSecondDir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.secondDir = str;
        }
    }

    public void setVideoTopic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isVideoTopic = z;
        }
    }
}
