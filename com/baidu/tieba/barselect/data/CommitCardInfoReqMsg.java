package com.baidu.tieba.barselect.data;

import c.a.q0.d1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommitCardInfo.CommitCardInfoReqIdl;
import tbclient.CommitCardInfo.DataReq;
/* loaded from: classes7.dex */
public class CommitCardInfoReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int card_type;
    public String image_info;
    public String resource_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommitCardInfoReqMsg() {
        super(CmdConfigHttp.CMD_COMMIT_CARD_INFO, 309643);
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
            builder.resource_id = this.resource_id;
            builder.card_type = Integer.valueOf(this.card_type);
            builder.image_info = this.image_info;
            if (z) {
                z.a(builder, true);
            }
            CommitCardInfoReqIdl.Builder builder2 = new CommitCardInfoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
