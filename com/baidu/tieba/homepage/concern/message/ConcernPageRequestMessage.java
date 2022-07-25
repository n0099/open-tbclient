package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.db8;
import com.repackage.ud5;
import com.repackage.ws6;
import com.repackage.xc5;
import com.repackage.yt4;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes3.dex */
public class ConcernPageRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xc5 adInfo;
    public String pageTag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernPageRequestMessage() {
        super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
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

    private String buildAdParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            boolean isEmpty = TextUtils.isEmpty(this.pageTag);
            int e = isEmpty ? 0 : db8.f().e("CONCERN");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            String str = "";
            String d = isEmpty ? "" : db8.f().d("CONCERN");
            xc5 xc5Var = this.adInfo;
            if (xc5Var != null && !isEmpty) {
                str = xc5Var.b;
            }
            AdExtParam.a b = AdExtParam.a.b();
            b.g(e);
            b.d(cuidGalaxy2);
            b.e(str);
            b.c(d);
            return b.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.page_tag = this.pageTag;
                if (ws6.H()) {
                    if (!ws6.A()) {
                        builder.page_tag = ws6.v();
                    } else {
                        builder.page_tag = ws6.u();
                    }
                }
                builder.last_req_unix = Long.valueOf(yt4.k().m(yt4.o("concern_data_res_request_time"), 0L));
                int i = 1;
                builder.follow_type = Integer.valueOf(UbsABTestHelper.isConcernForumCardShow() ? yt4.k().l("key_home_concern_all_status", 0) : 1);
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    ud5.a(builder, true);
                }
                if (!TextUtils.isEmpty(this.pageTag)) {
                    i = 2;
                }
                builder.load_type = Integer.valueOf(i);
                builder.ad_ext_params = buildAdParam();
                UserlikeReqIdl.Builder builder2 = new UserlikeReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public String getPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pageTag : (String) invokeV.objValue;
    }

    public void setAdInfo(xc5 xc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xc5Var) == null) {
            this.adInfo = xc5Var;
        }
    }

    public void setPageTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.pageTag = str;
        }
    }
}
