package com.baidu.tieba.homepage.personalize.data;

import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.l;
import c.a.q0.d1.g;
import c.a.q0.d1.z;
import c.a.q0.s.q.g1;
import c.a.r0.z2.j0.a;
import c.a.r0.z2.l0.b;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataReq;
import tbclient.Personalized.PersonalizedReqIdl;
/* loaded from: classes7.dex */
public class RecPersonalizeRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_TYPE_LOAD_MORE = 2;
    public static final int LOAD_TYPE_UPDATE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String adFloorInfo;
    public int loadType;
    public int needForumlist;
    public int pn;
    public int preAdThreadCount;
    public int requestTime;
    public String sourceFrom;
    public int suggestCount;
    public int threadCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecPersonalizeRequest() {
        super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
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
        this.requestTime = 0;
        this.sourceFrom = "";
        this.adFloorInfo = "";
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            z.c(builder, true, false, true);
            builder.need_tags = 0;
            builder.load_type = Integer.valueOf(this.loadType);
            builder.page_thread_count = Integer.valueOf(this.threadCount);
            builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
            builder.pn = Integer.valueOf(this.pn);
            builder.sug_count = Integer.valueOf(this.suggestCount);
            builder.tag_code = 0;
            builder.scr_w = Integer.valueOf(l.k(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(l.i(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(l.h(TbadkCoreApplication.getInst()));
            builder.q_type = Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1);
            builder.need_forumlist = Integer.valueOf(this.needForumlist);
            builder.new_net_type = Integer.valueOf(j.I());
            builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
            builder.request_times = Integer.valueOf(this.requestTime);
            builder.invoke_source = this.sourceFrom;
            builder.ad_context_list = b.f().d("NEWINDEX");
            builder.app_pos = a.e().c();
            if (TbSingleton.getInstance().getPbToHomeUpdateData() != null) {
                g1 pbToHomeUpdateData = TbSingleton.getInstance().getPbToHomeUpdateData();
                builder.from_tid = Long.valueOf(c.a.e.e.m.b.g(pbToHomeUpdateData.f14219a, 0L));
                builder.query_eqid = pbToHomeUpdateData.f14220b;
                builder.first_dir = pbToHomeUpdateData.f14221c;
                builder.second_dir = pbToHomeUpdateData.f14222d;
                TbSingleton.getInstance().setPbToHomeUpdateData(null);
            }
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.e(this.adFloorInfo);
            builder.ad_ext_params = b2.a();
            builder.app_transmit_data = g.b();
            PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public int getLoadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.loadType : invokeV.intValue;
    }

    public int getNeedForumlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.needForumlist : invokeV.intValue;
    }

    public void setAdFloorInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.adFloorInfo = str;
        }
    }

    public void setLoadType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.loadType = i2;
        }
    }

    public void setNeedForumlist(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 != 1) {
                this.needForumlist = 0;
            } else {
                this.needForumlist = i2;
            }
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.pn = i2;
        }
    }

    public void setPreAdThreadCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.preAdThreadCount = i2;
        }
    }

    public void setRequestTime(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.requestTime = i2;
        }
    }

    public void setSourceFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.sourceFrom = str;
        }
    }

    public void setSuggestCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.suggestCount = i2;
        }
    }

    public void setThreadCount(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (i2 > 0) {
                this.threadCount = i2;
            } else {
                this.threadCount = 0;
            }
        }
    }
}
