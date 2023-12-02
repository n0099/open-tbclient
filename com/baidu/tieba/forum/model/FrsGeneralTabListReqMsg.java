package com.baidu.tieba.forum.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.ec7;
import com.baidu.tieba.v88;
import com.baidu.tieba.ws5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.GeneralTabList.DataReq;
import tbclient.GeneralTabList.GeneralTabListReqIdl;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0014H\u0014J\b\u0010?\u001a\u00020\u001bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\u001a\u0010$\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR\u001a\u0010*\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001a\u0010-\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010\u001eR\u001a\u00100\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001a\u00103\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u001a\u00106\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0007\"\u0004\b8\u0010\tR\u001a\u00109\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001e¨\u0006@"}, d2 = {"Lcom/baidu/tieba/forum/model/FrsGeneralTabListReqMsg;", "Lcom/baidu/adp/framework/message/NetMessage;", "Lcom/baidu/tieba/feed/model/IGetFeedLoadType;", "()V", "adExtParams", "", "getAdExtParams", "()Ljava/lang/String;", "setAdExtParams", "(Ljava/lang/String;)V", "forumId", "", "getForumId", "()J", "setForumId", "(J)V", "frsCommonInfo", "getFrsCommonInfo", "setFrsCommonInfo", "isDefaultNavTab", "", "()Z", "setDefaultNavTab", "(Z)V", "isGeneralTab", "setGeneralTab", "isNewFrs", "", "()I", "setNewFrs", "(I)V", "is_video_doublerow", "set_video_doublerow", "lastThreadId", "getLastThreadId", "setLastThreadId", "loadType", "getLoadType", "setLoadType", "pn", "getPn", "setPn", "requestTimes", "getRequestTimes", "setRequestTimes", "rn", "getRn", "setRn", "sortType", "getSortType", "setSortType", "tabId", "getTabId", "setTabId", "tabName", "getTabName", "setTabName", "tabType", "getTabType", "setTabType", HttpClientWrap.c, "", "isShortConnection", "getFeedLoadType", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsGeneralTabListReqMsg extends NetMessage implements ec7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adExtParams;
    public long forumId;
    public String frsCommonInfo;
    public boolean isDefaultNavTab;
    public boolean isGeneralTab;
    public int isNewFrs;
    public int is_video_doublerow;
    public long lastThreadId;
    public int loadType;
    public int pn;
    public int requestTimes;
    public int rn;
    public int sortType;
    public int tabId;
    public String tabName;
    public int tabType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsGeneralTabListReqMsg() {
        super(CmdConfigHttp.CMD_FRS_COMMON_TAB, 309622);
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
        this.rn = 30;
        this.tabName = "";
        this.isGeneralTab = true;
        this.adExtParams = "";
        this.frsCommonInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Integer num;
        Integer num2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.tab_id = Integer.valueOf(this.tabId);
            builder.tab_type = Integer.valueOf(this.tabType);
            builder.forum_id = Long.valueOf(this.forumId);
            builder.pn = Integer.valueOf(this.pn);
            builder.rn = Integer.valueOf(this.rn);
            builder.tab_name = this.tabName;
            builder.request_times = Integer.valueOf(this.requestTimes);
            Integer num3 = 1;
            if (this.isGeneralTab) {
                num = num3;
            } else {
                num = 0;
            }
            builder.is_general_tab = num;
            builder.sort_type = Integer.valueOf(this.sortType);
            String d = v88.e().d("frs_feed");
            builder.ad_bear_sid = d;
            builder.ad_bear_context = ws5.g(d, ws5.f());
            builder.ad_bear_sid_price = Double.valueOf(ws5.i());
            if (ws5.n(builder.ad_bear_sid)) {
                num2 = num3;
            } else {
                num2 = 0;
            }
            builder.has_ad_bear = num2;
            long j = this.lastThreadId;
            if (j >= 0) {
                builder.last_thread_id = Long.valueOf(j);
            }
            builder.scr_h = Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.scr_w = Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_dip = Integer.valueOf((int) BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            if (!this.isDefaultNavTab) {
                num3 = 0;
            }
            builder.is_default_navtab = num3;
            builder.ad_ext_params = this.adExtParams;
            builder.frs_common_info = this.frsCommonInfo;
            builder.is_newfrs = Integer.valueOf(this.isNewFrs);
            builder.is_video_doublerow = Integer.valueOf(this.is_video_doublerow);
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true, false, true);
            GeneralTabListReqIdl.Builder builder2 = new GeneralTabListReqIdl.Builder();
            builder2.data = builder.build(false);
            GeneralTabListReqIdl build = builder2.build(false);
            Intrinsics.checkNotNullExpressionValue(build, "idl.build(false)");
            return build;
        }
        return invokeZ.objValue;
    }

    public final String getAdExtParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.adExtParams;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ec7
    public int getFeedLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.loadType;
        }
        return invokeV.intValue;
    }

    public final long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public final String getFrsCommonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.frsCommonInfo;
        }
        return (String) invokeV.objValue;
    }

    public final long getLastThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.lastThreadId;
        }
        return invokeV.longValue;
    }

    public final int getLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.loadType;
        }
        return invokeV.intValue;
    }

    public final int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.pn;
        }
        return invokeV.intValue;
    }

    public final int getRequestTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.requestTimes;
        }
        return invokeV.intValue;
    }

    public final int getRn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.rn;
        }
        return invokeV.intValue;
    }

    public final int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.sortType;
        }
        return invokeV.intValue;
    }

    public final int getTabId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.tabId;
        }
        return invokeV.intValue;
    }

    public final String getTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.tabName;
        }
        return (String) invokeV.objValue;
    }

    public final int getTabType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.tabType;
        }
        return invokeV.intValue;
    }

    public final boolean isDefaultNavTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.isDefaultNavTab;
        }
        return invokeV.booleanValue;
    }

    public final boolean isGeneralTab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.isGeneralTab;
        }
        return invokeV.booleanValue;
    }

    public final int isNewFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isNewFrs;
        }
        return invokeV.intValue;
    }

    public final int is_video_doublerow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.is_video_doublerow;
        }
        return invokeV.intValue;
    }

    public final void setAdExtParams(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adExtParams = str;
        }
    }

    public final void setDefaultNavTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.isDefaultNavTab = z;
        }
    }

    public final void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.forumId = j;
        }
    }

    public final void setFrsCommonInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.frsCommonInfo = str;
        }
    }

    public final void setGeneralTab(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.isGeneralTab = z;
        }
    }

    public final void setLastThreadId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.lastThreadId = j;
        }
    }

    public final void setLoadType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.loadType = i;
        }
    }

    public final void setNewFrs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.isNewFrs = i;
        }
    }

    public final void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.pn = i;
        }
    }

    public final void setRequestTimes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.requestTimes = i;
        }
    }

    public final void setRn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.rn = i;
        }
    }

    public final void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.sortType = i;
        }
    }

    public final void setTabId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.tabId = i;
        }
    }

    public final void setTabName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tabName = str;
        }
    }

    public final void setTabType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.tabType = i;
        }
    }

    public final void set_video_doublerow(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.is_video_doublerow = i;
        }
    }
}
