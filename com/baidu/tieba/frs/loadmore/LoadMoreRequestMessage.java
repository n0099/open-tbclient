package com.baidu.tieba.frs.loadmore;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.by6;
import com.baidu.tieba.ik8;
import com.baidu.tieba.lk8;
import com.baidu.tieba.ti5;
import com.baidu.tieba.wj5;
import com.baidu.tieba.xg;
import com.baidu.tieba.yi;
import com.baidu.tieba.yi5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThreadList.AdParam;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
/* loaded from: classes4.dex */
public class LoadMoreRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String adFloorInfo;
    public String forumName;
    public long forum_id;
    public boolean isBrandForum;
    public int loadCount;
    public long mLastClickTid;
    public int mPageType;
    public int mSortType;
    public int need_abstract;
    public int pn;
    public int refreshCount;
    public int requestTimes;
    public int st_type;
    public String thread_ids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreRequestMessage() {
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
        this.adFloorInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.thread_ids = this.thread_ids;
            builder.forum_id = Long.valueOf(this.forum_id);
            String d = by6.e().d("frs_feed");
            builder.ad_bear_sid = d;
            builder.ad_bear_context = ti5.g(d, ti5.f());
            builder.ad_bear_sid_price = Double.valueOf(ti5.i());
            builder.has_ad_bear = Integer.valueOf(ti5.n(builder.ad_bear_sid) ? 1 : 0);
            builder.need_abstract = Integer.valueOf(this.need_abstract);
            builder.user_id = Long.valueOf(xg.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            builder.forum_name = this.forumName;
            builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            int l = yi.l(TbadkCoreApplication.getInst());
            int j = yi.j(TbadkCoreApplication.getInst());
            builder.pn = Integer.valueOf(this.pn);
            builder.st_type = Integer.valueOf(this.st_type);
            builder.scr_h = Integer.valueOf(j);
            builder.scr_w = Integer.valueOf(l);
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            } else {
                i = 1;
            }
            builder.q_type = Integer.valueOf(i);
            builder.last_click_tid = Long.valueOf(this.mLastClickTid);
            builder.sort_type = Integer.valueOf(this.mSortType);
            builder.request_times = Integer.valueOf(this.requestTimes);
            builder.ad_context_list = lk8.f().d("FRS");
            AdExtParam.a b = AdExtParam.a.b();
            b.e(this.adFloorInfo);
            builder.ad_ext_params = b.a();
            wj5.c(builder, true, false, true);
            builder.app_pos = ik8.e().a();
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.load_count = Integer.valueOf(this.loadCount);
            builder2.refresh_count = Integer.valueOf(this.refreshCount);
            builder.ad_param = builder2.build(false);
            builder.app_transmit_data = yi5.b();
            ThreadListReqIdl.Builder builder3 = new ThreadListReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        }
        return invokeZ.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.forum_id;
        }
        return invokeV.longValue;
    }

    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mPageType;
        }
        return invokeV.intValue;
    }

    public boolean isBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.isBrandForum;
        }
        return invokeV.booleanValue;
    }

    public void setAdFloorInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.adFloorInfo = str;
        }
    }

    public void setBrandForum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.isBrandForum = z;
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.forum_id = j;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setLastClickTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mLastClickTid = j;
        }
    }

    public void setLoadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.loadCount = i;
        }
    }

    public void setNeedAbstract(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.need_abstract = i;
        }
    }

    public void setPageNumber(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.pn = i;
        }
    }

    public void setPageType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mPageType = i;
        }
    }

    public void setRefreshCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.refreshCount = i;
        }
    }

    public void setRequestTimes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.requestTimes = i;
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mSortType = i;
        }
    }

    public void setStType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.st_type = i;
        }
    }

    public void setThreadIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.thread_ids = str;
        }
    }
}
