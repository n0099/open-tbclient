package com.baidu.tieba.homepage;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetMyPost.DataReq;
import tbclient.GetMyPost.GetMyPostReqIdl;
/* loaded from: classes7.dex */
public class RequestGetMyPostNetMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String bFrom;
    public int callFrom;
    public boolean hideErrorToast;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            GetMyPostReqIdl.Builder builder2 = new GetMyPostReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getProZone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.proZone : invokeV.intValue;
    }

    public void setBFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.bFrom = str;
        }
    }

    public void setCallFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.callFrom = i2;
        }
    }

    public void setHideErrorToast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.hideErrorToast = z;
        }
    }

    public void setParams(long j2, long j3, long j4, int i2, int i3, double d2, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(i2), Integer.valueOf(i3), Double.valueOf(d2), Integer.valueOf(i4)}) == null) {
            this.mPostId = j3;
            this.mThreadId = j2;
            this.mForumId = j4;
            this.mScrW = i2;
            this.mScrH = i3;
            this.mScrDip = d2;
            this.mQType = i4;
        }
    }

    public void setProZone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.proZone = i2;
        }
    }

    public boolean showErrorToast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.hideErrorToast : invokeV.booleanValue;
    }
}
