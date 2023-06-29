package com.baidu.tieba.homepage.concern.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.au9;
import com.baidu.tieba.ew5;
import com.baidu.tieba.gx5;
import com.baidu.tieba.lv7;
import com.baidu.tieba.r95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Userlike.DataReq;
import tbclient.Userlike.UserlikeReqIdl;
/* loaded from: classes6.dex */
public class ConcernPageRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_TYPE_LOAD_MORE = 2;
    public static final int LOAD_TYPE_UPDATE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public ew5 adInfo;
    public int isNewFeed;
    public int loadType;
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
        this.isNewFeed = 0;
    }

    private String buildAdParam() {
        InterceptResult invokeV;
        int e;
        String d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            boolean isEmpty = TextUtils.isEmpty(this.pageTag);
            if (isEmpty) {
                e = 0;
            } else {
                e = au9.f().e("CONCERN");
            }
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            String str = "";
            if (isEmpty) {
                d = "";
            } else {
                d = au9.f().d("CONCERN");
            }
            ew5 ew5Var = this.adInfo;
            if (ew5Var != null && !isEmpty) {
                str = ew5Var.b;
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
        int i;
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.page_tag = this.pageTag;
                if (lv7.I()) {
                    if (!lv7.B()) {
                        builder.page_tag = lv7.w();
                    } else {
                        builder.page_tag = lv7.v();
                    }
                }
                builder.last_req_unix = Long.valueOf(r95.p().r(r95.t("concern_data_res_request_time"), 0L));
                int i2 = 1;
                if (UbsABTestHelper.isConcernForumCardShow()) {
                    i = r95.p().q("key_home_concern_all_status", 0);
                } else {
                    i = 1;
                }
                builder.follow_type = Integer.valueOf(i);
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    gx5.a(builder, true);
                }
                if (this.loadType > 0) {
                    builder.load_type = Integer.valueOf(this.loadType);
                } else {
                    if (!TextUtils.isEmpty(this.pageTag)) {
                        i2 = 2;
                    }
                    builder.load_type = Integer.valueOf(i2);
                }
                builder.ad_ext_params = buildAdParam();
                builder.is_newfeed = Integer.valueOf(this.isNewFeed);
                UserlikeReqIdl.Builder builder2 = new UserlikeReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public int getLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.loadType;
        }
        return invokeV.intValue;
    }

    public String getPageTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.pageTag;
        }
        return (String) invokeV.objValue;
    }

    public void setAdInfo(ew5 ew5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ew5Var) == null) {
            this.adInfo = ew5Var;
        }
    }

    public void setIsNewFeed(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.isNewFeed = i;
        }
    }

    public void setLoadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.loadType = i;
        }
    }

    public void setPageTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.pageTag = str;
        }
    }
}
