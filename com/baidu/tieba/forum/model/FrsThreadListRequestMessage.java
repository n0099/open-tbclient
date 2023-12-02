package com.baidu.tieba.forum.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.http.HttpClientWrap;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.bt5;
import com.baidu.tieba.jja;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.v88;
import com.baidu.tieba.ws5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.ThreadList.AdParam;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001a\u0010\u001f\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\"\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\u001a\u0010%\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019R\u001a\u0010(\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0019R\u001a\u0010+\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u001a\u0010.\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0017\"\u0004\b0\u0010\u0019R\u001a\u00101\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019R\u001a\u00104\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0017\"\u0004\b6\u0010\u0019R\u001a\u00107\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\b¨\u0006>"}, d2 = {"Lcom/baidu/tieba/forum/model/FrsThreadListRequestMessage;", "Lcom/baidu/adp/framework/message/NetMessage;", "()V", "adFloorInfo", "", "getAdFloorInfo", "()Ljava/lang/String;", "setAdFloorInfo", "(Ljava/lang/String;)V", "forumId", "", "getForumId", "()J", "setForumId", "(J)V", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "getForumName", "setForumName", "frsCommonInfo", "getFrsCommonInfo", "setFrsCommonInfo", "isGood", "", "()I", "setGood", "(I)V", "isNewFrs", "setNewFrs", "lastClickTid", "getLastClickTid", "setLastClickTid", "loadCount", "getLoadCount", "setLoadCount", "needAbstract", "getNeedAbstract", "setNeedAbstract", "pageType", "getPageType", "setPageType", "pn", "getPn", "setPn", "refreshCount", "getRefreshCount", "setRefreshCount", "requestTimes", "getRequestTimes", "setRequestTimes", "sortType", "getSortType", "setSortType", "stType", "getStType", "setStType", "threadIds", "getThreadIds", "setThreadIds", HttpClientWrap.c, "", "isShortConnection", "", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FrsThreadListRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adFloorInfo;
    public long forumId;
    public String forumName;
    public String frsCommonInfo;
    public int isGood;
    public int isNewFrs;
    public long lastClickTid;
    public int loadCount;
    public int needAbstract;
    public int pageType;
    public int pn;
    public int refreshCount;
    public int requestTimes;
    public int sortType;
    public int stType;
    public String threadIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsThreadListRequestMessage() {
        super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
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
        this.threadIds = "";
        this.forumName = "";
        this.adFloorInfo = "";
        this.frsCommonInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.thread_ids = this.threadIds;
            builder.forum_id = Long.valueOf(this.forumId);
            String d = v88.e().d("frs_feed");
            builder.ad_bear_sid = d;
            builder.ad_bear_context = ws5.g(d, ws5.f());
            builder.ad_bear_sid_price = Double.valueOf(ws5.i());
            int i2 = 1;
            if (ws5.n(builder.ad_bear_sid)) {
                i = 1;
            } else {
                i = 0;
            }
            builder.has_ad_bear = i;
            builder.need_abstract = Integer.valueOf(this.needAbstract);
            builder.user_id = Long.valueOf(JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L));
            builder.forum_name = this.forumName;
            builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
            builder.pn = Integer.valueOf(this.pn);
            builder.st_type = Integer.valueOf(this.stType);
            builder.scr_h = Integer.valueOf(equipmentHeight);
            builder.scr_w = Integer.valueOf(equipmentWidth);
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i2 = 2;
            }
            builder.q_type = i2;
            builder.last_click_tid = Long.valueOf(this.lastClickTid);
            builder.sort_type = Integer.valueOf(this.sortType);
            builder.request_times = Integer.valueOf(this.requestTimes);
            builder.frs_common_info = this.frsCommonInfo;
            builder.ad_context_list = jja.f().d("FRS");
            AdExtParam.a b = AdExtParam.a.b();
            b.e(this.adFloorInfo);
            builder.ad_ext_params = b.a();
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true, false, true);
            builder.app_pos = LocationCacheData.getInstance().createAppPosInfo();
            builder.is_newfrs = Integer.valueOf(this.isNewFrs);
            builder.is_goodtab = Integer.valueOf(this.isGood);
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.load_count = Integer.valueOf(this.loadCount);
            builder2.refresh_count = Integer.valueOf(this.refreshCount);
            builder.ad_param = builder2.build(false);
            builder.app_transmit_data = bt5.b();
            ThreadListReqIdl.Builder builder3 = new ThreadListReqIdl.Builder();
            builder3.data = builder.build(false);
            ThreadListReqIdl build = builder3.build(false);
            Intrinsics.checkNotNullExpressionValue(build, "idl.build(false)");
            return build;
        }
        return invokeZ.objValue;
    }

    public final String getAdFloorInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.adFloorInfo;
        }
        return (String) invokeV.objValue;
    }

    public final long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public final String getFrsCommonInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.frsCommonInfo;
        }
        return (String) invokeV.objValue;
    }

    public final long getLastClickTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.lastClickTid;
        }
        return invokeV.longValue;
    }

    public final int getLoadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.loadCount;
        }
        return invokeV.intValue;
    }

    public final int getNeedAbstract() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.needAbstract;
        }
        return invokeV.intValue;
    }

    public final int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.pageType;
        }
        return invokeV.intValue;
    }

    public final int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.pn;
        }
        return invokeV.intValue;
    }

    public final int getRefreshCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.refreshCount;
        }
        return invokeV.intValue;
    }

    public final int getRequestTimes() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.requestTimes;
        }
        return invokeV.intValue;
    }

    public final int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.sortType;
        }
        return invokeV.intValue;
    }

    public final int getStType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.stType;
        }
        return invokeV.intValue;
    }

    public final String getThreadIds() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.threadIds;
        }
        return (String) invokeV.objValue;
    }

    public final int isGood() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.isGood;
        }
        return invokeV.intValue;
    }

    public final int isNewFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isNewFrs;
        }
        return invokeV.intValue;
    }

    public final void setAdFloorInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adFloorInfo = str;
        }
    }

    public final void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.forumId = j;
        }
    }

    public final void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.forumName = str;
        }
    }

    public final void setFrsCommonInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.frsCommonInfo = str;
        }
    }

    public final void setGood(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.isGood = i;
        }
    }

    public final void setLastClickTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.lastClickTid = j;
        }
    }

    public final void setLoadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.loadCount = i;
        }
    }

    public final void setNeedAbstract(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.needAbstract = i;
        }
    }

    public final void setNewFrs(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.isNewFrs = i;
        }
    }

    public final void setPageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.pageType = i;
        }
    }

    public final void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.pn = i;
        }
    }

    public final void setRefreshCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
            this.refreshCount = i;
        }
    }

    public final void setRequestTimes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.requestTimes = i;
        }
    }

    public final void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.sortType = i;
        }
    }

    public final void setStType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.stType = i;
        }
    }

    public final void setThreadIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.threadIds = str;
        }
    }
}
