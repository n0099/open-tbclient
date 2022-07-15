package com.baidu.tieba.barselect.data;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.td5;
import tbclient.ElectionInfo.DataReq;
import tbclient.ElectionInfo.ElectionInfoReqIdl;
/* loaded from: classes3.dex */
public class VoteElectionRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long fid;
    public int pn;
    public int rn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteElectionRequestMessage() {
        super(CmdConfigHttp.CMD_BAR_ELECTION, 309642);
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
            builder.fid = Long.valueOf(this.fid);
            builder.rn = Integer.valueOf(this.rn);
            builder.pn = Integer.valueOf(this.pn);
            td5.a(builder, false);
            ElectionInfoReqIdl.Builder builder2 = new ElectionInfoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setFid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.fid = j;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.pn = i;
        }
    }

    public void setRn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.rn = i;
        }
    }
}
