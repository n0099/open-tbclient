package com.baidu.tieba.enterForum.tabfeed.message;

import c.a.e.e.p.l;
import c.a.q0.d1.a0;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Tabfeedlist.DataReq;
import tbclient.Tabfeedlist.TabfeedlistReqIdl;
/* loaded from: classes7.dex */
public class TabFeedListRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_RN = 30;
    public static final int LOAD_TYPE_LOADMORE = 2;
    public static final int LOAD_TYPE_REFRESH = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int loadType;
    public int pn;
    public String tabCode;
    public String tabName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabFeedListRequestMessage() {
        super(CmdConfigHttp.CMD_TAB_FEED_LIST, 309651);
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
                builder.load_type = Integer.valueOf(this.loadType);
                builder.pn = Integer.valueOf(this.pn);
                builder.rn = 30;
                builder.tab_name = this.tabName;
                builder.tab_code = this.tabCode;
                builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
                builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
                builder.scr_d = Integer.valueOf((int) l.h(TbadkCoreApplication.getInst()));
                if (z) {
                    a0.a(builder, true);
                }
                TabfeedlistReqIdl.Builder builder2 = new TabfeedlistReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }
}
