package com.baidu.tieba.homepage.video.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.ej;
import com.baidu.tieba.fh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecomVideo.DataReq;
import tbclient.RecomVideo.RecomVideoReqIdl;
/* loaded from: classes4.dex */
public class VideoTabRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int load_type;
    public int new_net_type;
    public int page_thread_count;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTabRequestMessage() {
        super(CmdConfigHttp.CMD_VIDEO_TAB, 309648);
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
            builder.scr_w = Integer.valueOf(ej.k(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(ej.i(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(ej.h(TbadkCoreApplication.getInst()));
            builder.new_net_type = Integer.valueOf(this.new_net_type);
            builder.load_type = Integer.valueOf(this.load_type);
            builder.page_thread_count = Integer.valueOf(this.page_thread_count);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                fh5.a(builder, true);
            }
            RecomVideoReqIdl.Builder builder2 = new RecomVideoReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
