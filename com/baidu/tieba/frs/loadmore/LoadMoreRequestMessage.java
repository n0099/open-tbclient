package com.baidu.tieba.frs.loadmore;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.d.f.p.n;
import c.a.q0.c1.b0;
import c.a.q0.c1.i;
import c.a.r0.j3.k0.a;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ThreadList.AdParam;
import tbclient.ThreadList.DataReq;
import tbclient.ThreadList.ThreadListReqIdl;
/* loaded from: classes5.dex */
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
    public int st_type;
    public String thread_ids;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreRequestMessage() {
        super(CmdConfigHttp.FRS_LOAD_MORE_CMD, 301002);
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
        this.adFloorInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.thread_ids = this.thread_ids;
            builder.forum_id = Long.valueOf(this.forum_id);
            builder.need_abstract = Integer.valueOf(this.need_abstract);
            builder.user_id = Long.valueOf(b.g(TbadkCoreApplication.getCurrentAccount(), 0L));
            builder.forum_name = this.forumName;
            builder.scr_dip = Double.valueOf(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            int k = n.k(TbadkCoreApplication.getInst());
            int i2 = n.i(TbadkCoreApplication.getInst());
            builder.pn = Integer.valueOf(this.pn);
            builder.st_type = Integer.valueOf(this.st_type);
            builder.scr_h = Integer.valueOf(i2);
            builder.scr_w = Integer.valueOf(k);
            builder.q_type = Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            builder.last_click_tid = Long.valueOf(this.mLastClickTid);
            builder.sort_type = Integer.valueOf(this.mSortType);
            builder.ad_context_list = c.a.r0.j3.m0.b.f().d("FRS");
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.e(this.adFloorInfo);
            builder.ad_ext_params = b2.a();
            b0.c(builder, true, false, true);
            builder.app_pos = a.e().a();
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.load_count = Integer.valueOf(this.loadCount);
            builder2.refresh_count = Integer.valueOf(this.refreshCount);
            builder.ad_param = builder2.build(false);
            builder.app_transmit_data = i.b();
            ThreadListReqIdl.Builder builder3 = new ThreadListReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        }
        return invokeZ.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forum_id : invokeV.longValue;
    }

    public int getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPageType : invokeV.intValue;
    }

    public boolean isBrandForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isBrandForum : invokeV.booleanValue;
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

    public void setForumId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            this.forum_id = j2;
        }
    }

    public void setForumName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.forumName = str;
        }
    }

    public void setLastClickTid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.mLastClickTid = j2;
        }
    }

    public void setLoadCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.loadCount = i2;
        }
    }

    public void setNeedAbstract(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.need_abstract = i2;
        }
    }

    public void setPageNumber(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.pn = i2;
        }
    }

    public void setPageType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.mPageType = i2;
        }
    }

    public void setRefreshCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.refreshCount = i2;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mSortType = i2;
        }
    }

    public void setStType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.st_type = i2;
        }
    }

    public void setThreadIds(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.thread_ids = str;
        }
    }
}
