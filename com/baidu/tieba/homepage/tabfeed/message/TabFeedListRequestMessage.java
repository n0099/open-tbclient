package com.baidu.tieba.homepage.tabfeed.message;

import c.a.d.f.p.n;
import c.a.q0.c1.b0;
import c.a.q0.r.l;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ActivityPage.ActivityPageReqIdl;
import tbclient.ActivityPage.DataReq;
/* loaded from: classes5.dex */
public class TabFeedListRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_RN = 20;
    public static final int LOAD_TYPE_LOADMORE = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int loadType;
    public int pn;
    public String tabCode;
    public String tabName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedListRequestMessage() {
        super(CmdConfigHttp.CMD_HOME_TAB_ACTIVITY_LIST, 309655);
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
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.activity_name = this.tabCode;
                builder.pn = Integer.valueOf(this.pn);
                builder.rn = 20;
                builder.scr_h = Integer.valueOf(n.i(TbadkCoreApplication.getInst()));
                builder.scr_w = Integer.valueOf(n.k(TbadkCoreApplication.getInst()));
                builder.scr_dip = Integer.valueOf((int) n.h(TbadkCoreApplication.getInst()));
                builder.q_type = Integer.valueOf(l.c().e());
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    b0.a(builder, true);
                }
                ActivityPageReqIdl.Builder builder2 = new ActivityPageReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }
}
