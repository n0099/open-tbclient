package com.baidu.tieba.frs.commontab;

import c.a.d.f.p.n;
import c.a.s0.d1.b0;
import c.a.s0.l0.b.g;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
/* loaded from: classes12.dex */
public class FrsCommonTabRequestData extends OrmObject implements g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adExtParams;
    public long fid;
    public int isDefaultNavTab;
    public int isGeneralTab;
    public long lastThreadId;
    public int pn;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    @Override // c.a.s0.l0.b.i
    public Object e(boolean z) {
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
            builder.is_general_tab = Integer.valueOf(this.isGeneralTab);
            builder.sort_type = Integer.valueOf(this.sortType);
            long j2 = this.lastThreadId;
            if (j2 >= 0) {
                builder.last_thread_id = Long.valueOf(j2);
            }
            builder.scr_h = Integer.valueOf(n.i(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(n.k(TbadkCoreApplication.getInst()));
            builder.scr_dip = Integer.valueOf((int) n.h(TbadkCoreApplication.getInst()));
            builder.is_default_navtab = Integer.valueOf(this.isDefaultNavTab);
            builder.ad_ext_params = this.adExtParams;
            b0.c(builder, true, false, true);
            GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    @Override // c.a.s0.l0.b.f
    public HashMap<String, Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // c.a.s0.l0.b.f
    public HashMap<String, String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }
}
