package com.baidu.tieba.homepage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMyPost.DataReq;
import tbclient.GetMyPost.GetMyPostReqIdl;
/* loaded from: classes6.dex */
public class RequestGetMyPostNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bFrom;
    public int callFrom;
    public String frsCommonInfo;
    public boolean hideErrorToast;
    public int isNewFrs;
    public long mForumId;
    public long mPostId;
    public int mQType;
    public double mScrDip;
    public int mScrH;
    public int mScrW;
    public long mThreadId;
    public int proZone;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestGetMyPostNetMessage() {
        super(CmdConfigHttp.CMD_GET_MY_POST, 303111);
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
            builder.forum_id = Long.valueOf(this.mForumId);
            builder.thread_id = Long.valueOf(this.mThreadId);
            builder.post_id = Long.valueOf(this.mPostId);
            builder.scr_w = Integer.valueOf(this.mScrW);
            builder.scr_h = Integer.valueOf(this.mScrH);
            builder.scr_dip = Double.valueOf(this.mScrDip);
            builder.q_type = Integer.valueOf(this.mQType);
            builder.bfrom = this.bFrom;
            builder.call_from = Integer.valueOf(this.callFrom);
            builder.frs_common_info = this.frsCommonInfo;
            builder.is_newfrs = Integer.valueOf(this.isNewFrs);
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
            GetMyPostReqIdl.Builder builder2 = new GetMyPostReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getCallFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.callFrom;
        }
        return invokeV.intValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mForumId;
        }
        return invokeV.longValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bFrom;
        }
        return (String) invokeV.objValue;
    }

    public long getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mPostId;
        }
        return invokeV.longValue;
    }

    public int getProZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.proZone;
        }
        return invokeV.intValue;
    }

    public int getQType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mQType;
        }
        return invokeV.intValue;
    }

    public long getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mThreadId;
        }
        return invokeV.longValue;
    }

    public boolean showErrorToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return !this.hideErrorToast;
        }
        return invokeV.booleanValue;
    }

    public void setBFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.bFrom = str;
        }
    }

    public void setCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.callFrom = i;
        }
    }

    public void setFrsCommonInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.frsCommonInfo = str;
        }
    }

    public void setHideErrorToast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.hideErrorToast = z;
        }
    }

    public void setIsNewFrs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.isNewFrs = i;
        }
    }

    public void setProZone(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.proZone = i;
        }
    }

    public void setParams(long j, long j2, long j3, int i, int i2, double d, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d), Integer.valueOf(i3)}) == null) {
            this.mPostId = j2;
            this.mThreadId = j;
            this.mForumId = j3;
            this.mScrW = i;
            this.mScrH = i2;
            this.mScrDip = d;
            this.mQType = i3;
        }
    }
}
