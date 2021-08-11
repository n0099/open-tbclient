package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import c.a.o0.b1.c;
import c.a.o0.b1.w;
import c.a.p0.f1.c.d;
import c.a.p0.x2.l0.b;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes7.dex */
public class ConcernPageRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c adInfo;
    public String pageTag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernPageRequestMessage() {
        super(CmdConfigHttp.CMD_CONCERN_PAGE, 309474);
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

    private String buildAdParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            boolean isEmpty = TextUtils.isEmpty(this.pageTag);
            int e2 = isEmpty ? 0 : b.f().e("CONCERN");
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            String str = "";
            String d2 = isEmpty ? "" : b.f().d("CONCERN");
            c cVar = this.adInfo;
            if (cVar != null && !isEmpty) {
                str = cVar.f12552b;
            }
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.g(e2);
            b2.d(cuidGalaxy2);
            b2.e(str);
            b2.c(d2);
            return b2.a();
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
                if (d.J()) {
                    if (!d.C()) {
                        builder.page_tag = d.x();
                    } else {
                        builder.page_tag = d.w();
                    }
                }
                builder.last_req_unix = Long.valueOf(c.a.o0.s.d0.b.j().l(c.a.o0.s.d0.b.n("concern_data_res_request_time"), 0L));
                int i2 = 1;
                builder.follow_type = Integer.valueOf(c.a.o0.b.d.i() ? c.a.o0.s.d0.b.j().k("key_home_concern_all_status", 0) : 1);
                if (z) {
                    w.a(builder, true);
                }
                if (!TextUtils.isEmpty(this.pageTag)) {
                    i2 = 2;
                }
                builder.load_type = Integer.valueOf(i2);
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

    public void setAdInfo(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.adInfo = cVar;
        }
    }

    public void setPageTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.pageTag = str;
        }
    }
}
