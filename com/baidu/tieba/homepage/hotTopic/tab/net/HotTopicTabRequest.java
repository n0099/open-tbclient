package com.baidu.tieba.homepage.hotTopic.tab.net;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.cj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.HotThreadList.DataReq;
import tbclient.HotThreadList.HotThreadListReqIdl;
/* loaded from: classes4.dex */
public class HotTopicTabRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HOT_COMMENT_TAB_ID = "2";
    public static final String HOT_TAB_CODE_ALL = "all";
    public static final String HOT_THREAD_TAB_ID = "1";
    public static final String HOT_TOPIC_TAB_ID = "3";
    public transient /* synthetic */ FieldHolder $fh;
    public String tabCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicTabRequest() {
        super(CmdConfigHttp.CMD_HOT_TOPIC_TAB, 309661);
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
        this.tabCode = "all";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            if (UbsABTestHelper.isNewHomeHotTopicTab()) {
                builder.tab_id = "3";
                builder.tab_code = "all";
            } else {
                builder.tab_id = "1";
                builder.tab_code = this.tabCode;
            }
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                cj5.a(builder, true);
            }
            HotThreadListReqIdl.Builder builder2 = new HotThreadListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.tabCode = str;
        }
    }
}
