package com.baidu.tieba.godSquare.model.req;

import c.a.p0.b1.w;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetHotGod.DataReq;
import tbclient.GetHotGod.GetHotGodReqIdl;
/* loaded from: classes7.dex */
public class GodSquareRequestMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int rn = 30;
    public transient /* synthetic */ FieldHolder $fh;
    public int pn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GodSquareRequestMsg() {
        super(CmdConfigHttp.CMD_GET_HOT_GOD, 309315);
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
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = 30;
            if (z) {
                w.a(builder, true);
            }
            GetHotGodReqIdl.Builder builder2 = new GetHotGodReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
