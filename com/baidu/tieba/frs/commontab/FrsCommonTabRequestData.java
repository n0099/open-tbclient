package com.baidu.tieba.frs.commontab;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.dt6;
import com.baidu.tieba.ri;
import com.baidu.tieba.x85;
import com.baidu.tieba.ye5;
import com.baidu.tieba.zd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
/* loaded from: classes4.dex */
public class FrsCommonTabRequestData extends OrmObject implements x85 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adExtParams;
    public long fid;
    public int isDefaultNavTab;
    public int isGeneralTab;
    public long lastThreadId;
    public int pn;
    public int requestTimes;
    public int rn;
    public int sortType;
    public int tabId;
    public String tabName;
    public int tabType;

    public FrsCommonTabRequestData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.rn = 30;
        this.lastThreadId = -1L;
        this.isDefaultNavTab = 0;
        this.isGeneralTab = 0;
        this.sortType = 0;
    }

    @Override // com.baidu.tieba.z85
    public Object g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tab_id = Integer.valueOf(this.tabId);
            builder.tab_type = Integer.valueOf(this.tabType);
            builder.forum_id = Long.valueOf(this.fid);
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = Integer.valueOf(this.rn);
            builder.tab_name = this.tabName;
            builder.request_times = Integer.valueOf(this.requestTimes);
            builder.is_general_tab = Integer.valueOf(this.isGeneralTab);
            builder.sort_type = Integer.valueOf(this.sortType);
            String d = dt6.e().d("frs_feed");
            builder.ad_bear_sid = d;
            builder.ad_bear_context = zd5.g(d, zd5.f());
            builder.ad_bear_sid_price = Double.valueOf(zd5.i());
            builder.has_ad_bear = Integer.valueOf(zd5.n(builder.ad_bear_sid) ? 1 : 0);
            long j = this.lastThreadId;
            if (j >= 0) {
                builder.last_thread_id = Long.valueOf(j);
            }
            builder.scr_h = Integer.valueOf(ri.i(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(ri.k(TbadkCoreApplication.getInst()));
            builder.scr_dip = Integer.valueOf((int) ri.h(TbadkCoreApplication.getInst()));
            builder.is_default_navtab = Integer.valueOf(this.isDefaultNavTab);
            builder.ad_ext_params = this.adExtParams;
            ye5.c(builder, true, false, true);
            GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    @Override // com.baidu.tieba.w85
    public HashMap<String, Object> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w85
    public HashMap<String, String> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }
}
