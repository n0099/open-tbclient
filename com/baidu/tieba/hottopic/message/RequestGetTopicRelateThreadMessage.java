package com.baidu.tieba.hottopic.message;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qc5;
import tbclient.CommonReq;
import tbclient.GetTopicRelateThread.DataReq;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadReqIdl;
/* loaded from: classes3.dex */
public class RequestGetTopicRelateThreadMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1039common;
    public Long last_id;
    public Integer page_no;
    public Integer pmy_source;
    public Long pmy_topic_id;
    public Integer q_type;
    public Integer rn;
    public Double scr_dip;
    public Integer scr_h;
    public Integer scr_w;
    public Integer sort_type;
    public Long topic_id;
    public String topic_name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestGetTopicRelateThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD, 309005);
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
                builder.f1236common = getCommon();
                builder.topic_id = getTopicId();
                builder.topic_name = getTopicName();
                builder.rn = getRn();
                builder.page_no = getPageNo();
                builder.last_id = getLastId();
                builder.scr_w = getScrW();
                builder.scr_h = getScrH();
                builder.scr_dip = getScrDip();
                builder.q_type = getQType();
                builder.pmy_topic_id = getPmy_topic_id();
                builder.pmy_source = getPmy_source();
                builder.sort_type = getSort_type();
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    qc5.a(builder, true);
                }
                GetTopicRelateThreadReqIdl.Builder builder2 = new GetTopicRelateThreadReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public CommonReq getCommon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1039common : (CommonReq) invokeV.objValue;
    }

    public Long getLastId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.last_id : (Long) invokeV.objValue;
    }

    public Integer getPageNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.page_no : (Integer) invokeV.objValue;
    }

    public Integer getPmy_source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.pmy_source : (Integer) invokeV.objValue;
    }

    public Long getPmy_topic_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.pmy_topic_id : (Long) invokeV.objValue;
    }

    public Integer getQType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q_type : (Integer) invokeV.objValue;
    }

    public Integer getRn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.rn : (Integer) invokeV.objValue;
    }

    public Double getScrDip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.scr_dip : (Double) invokeV.objValue;
    }

    public Integer getScrH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.scr_h : (Integer) invokeV.objValue;
    }

    public Integer getScrW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.scr_w : (Integer) invokeV.objValue;
    }

    public Integer getSort_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.sort_type : (Integer) invokeV.objValue;
    }

    public Long getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.topic_id : (Long) invokeV.objValue;
    }

    public String getTopicName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.topic_name : (String) invokeV.objValue;
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, commonReq) == null) {
            this.f1039common = commonReq;
        }
    }

    public void setLastId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, l) == null) {
            this.last_id = l;
        }
    }

    public void setPageNo(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, num) == null) {
            this.page_no = num;
        }
    }

    public void setPmy_source(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, num) == null) {
            this.pmy_source = num;
        }
    }

    public void setPmy_topic_id(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, l) == null) {
            this.pmy_topic_id = l;
        }
    }

    public void setQType(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, num) == null) {
            this.q_type = num;
        }
    }

    public void setRn(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, num) == null) {
            this.rn = num;
        }
    }

    public void setScrDip(Double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, d) == null) {
            this.scr_dip = d;
        }
    }

    public void setScrH(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, num) == null) {
            this.scr_h = num;
        }
    }

    public void setScrW(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, num) == null) {
            this.scr_w = num;
        }
    }

    public void setSort_type(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, num) == null) {
            this.sort_type = num;
        }
    }

    public void setTopicId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, l) == null) {
            this.topic_id = l;
        }
    }

    public void setTopicName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.topic_name = str;
        }
    }
}
