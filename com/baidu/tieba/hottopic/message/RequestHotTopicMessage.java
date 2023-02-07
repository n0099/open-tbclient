package com.baidu.tieba.hottopic.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.yo5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.Hottopic.DataReq;
import tbclient.Hottopic.HottopicReqIdl;
/* loaded from: classes4.dex */
public class RequestHotTopicMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int call_from;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1077common;
    public Long fid;
    public String first_dir;
    public Integer q_type;
    public Double scr_dip;
    public Integer scr_h;
    public Integer scr_w;
    public String second_dir;
    public Integer sort_type;
    public Long topic_id;
    public String topic_name;
    public long topic_tid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestHotTopicMessage() {
        super(CmdConfigHttp.CMD_HOT_TOPIC, 303050);
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
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.f1312common = getCommon();
                builder.topic_id = getTopicId();
                builder.topic_name = getTopicName();
                builder.scr_w = getScrW();
                builder.scr_h = getSrcH();
                builder.scr_dip = getSrcDip();
                builder.q_type = getQType();
                builder.sort_type = getSort_type();
                builder.fid = getFid();
                builder.first_dir = getFirst_dir();
                builder.second_dir = getSecond_dir();
                builder.call_from = Integer.valueOf(getCall_from());
                builder.topic_tid = Long.valueOf(getTopic_tid());
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    yo5.a(builder, true);
                }
                HottopicReqIdl.Builder builder2 = new HottopicReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public int getCall_from() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.call_from;
        }
        return invokeV.intValue;
    }

    public CommonReq getCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f1077common;
        }
        return (CommonReq) invokeV.objValue;
    }

    public Long getFid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fid;
        }
        return (Long) invokeV.objValue;
    }

    public String getFirst_dir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.first_dir;
        }
        return (String) invokeV.objValue;
    }

    public Integer getQType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q_type;
        }
        return (Integer) invokeV.objValue;
    }

    public Integer getScrW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.scr_w;
        }
        return (Integer) invokeV.objValue;
    }

    public String getSecond_dir() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.second_dir;
        }
        return (String) invokeV.objValue;
    }

    public Integer getSort_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.sort_type;
        }
        return (Integer) invokeV.objValue;
    }

    public Double getSrcDip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.scr_dip;
        }
        return (Double) invokeV.objValue;
    }

    public Integer getSrcH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.scr_h;
        }
        return (Integer) invokeV.objValue;
    }

    public Long getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.topic_id;
        }
        return (Long) invokeV.objValue;
    }

    public String getTopicName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.topic_name;
        }
        return (String) invokeV.objValue;
    }

    public long getTopic_tid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.topic_tid;
        }
        return invokeV.longValue;
    }

    public void setCall_from(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.call_from = i;
        }
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, commonReq) == null) {
            this.f1077common = commonReq;
        }
    }

    public void setFid(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, l) == null) {
            this.fid = l;
        }
    }

    public void setFirst_dir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.first_dir = str;
        }
    }

    public void setQType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, num) == null) {
            this.q_type = num;
        }
    }

    public void setScrH(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, num) == null) {
            this.scr_h = num;
        }
    }

    public void setScrW(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, num) == null) {
            this.scr_w = num;
        }
    }

    public void setSecond_dir(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.second_dir = str;
        }
    }

    public void setSort_type(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, num) == null) {
            this.sort_type = num;
        }
    }

    public void setSrcDip(Double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, d) == null) {
            this.scr_dip = d;
        }
    }

    public void setTopicId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, l) == null) {
            this.topic_id = l;
        }
    }

    public void setTopicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.topic_name = str;
        }
    }

    public void setTopic_tid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.topic_tid = j;
        }
    }
}
