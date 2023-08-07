package com.baidu.tieba.homepage.personalize.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.y25;
import com.baidu.tieba.yu5;
import com.baidu.tieba.zy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.Personalized.DataReq;
import tbclient.Personalized.PersonalizedReqIdl;
/* loaded from: classes6.dex */
public class RecPersonalizeRequest extends NetMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LOAD_TYPE_LOAD_MORE = 2;
    public static final int LOAD_TYPE_UPDATE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public String adFloorInfo;
    public int isNewFeed;
    public int loadType;
    public int needForumlist;
    public int pn;
    public int preAdThreadCount;
    public long pushTid;
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
        this.requestTime = 0;
        this.sourceFrom = "";
        this.adFloorInfo = "";
        this.pushTid = -1L;
        this.isNewFeed = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            int i = 1;
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true, false, true);
            builder.need_tags = 0;
            builder.load_type = Integer.valueOf(this.loadType);
            builder.page_thread_count = Integer.valueOf(this.threadCount);
            builder.pre_ad_thread_count = Integer.valueOf(this.preAdThreadCount);
            builder.pn = Integer.valueOf(this.pn);
            builder.sug_count = Integer.valueOf(this.suggestCount);
            builder.tag_code = 0;
            builder.scr_w = Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst()));
            builder.scr_h = Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()));
            builder.scr_dip = Double.valueOf(BdUtilHelper.getEquipmentDensity(TbadkCoreApplication.getInst()));
            if (TbImageHelper.getInstance().isShowBigImage()) {
                i = 2;
            }
            builder.q_type = Integer.valueOf(i);
            builder.need_forumlist = Integer.valueOf(this.needForumlist);
            builder.new_net_type = Integer.valueOf(BdNetTypeUtil.netType());
            builder.new_install = Integer.valueOf(TbadkCoreApplication.getInst().checkNewUser() ? 1 : 0);
            builder.request_times = Integer.valueOf(this.requestTime);
            builder.invoke_source = this.sourceFrom;
            builder.ad_context_list = zy9.f().d("HOME");
            builder.app_pos = LocationCacheData.getInstance().createRecReqAppPosInfo();
            if (TbSingleton.getInstance().getPbToHomeUpdateData() != null) {
                y25 pbToHomeUpdateData = TbSingleton.getInstance().getPbToHomeUpdateData();
                builder.from_tid = Long.valueOf(JavaTypesHelper.toLong(pbToHomeUpdateData.a, 0L));
                builder.query_eqid = pbToHomeUpdateData.b;
                builder.first_dir = pbToHomeUpdateData.c;
                builder.second_dir = pbToHomeUpdateData.d;
                TbSingleton.getInstance().setPbToHomeUpdateData(null);
            }
            AdExtParam.a b = AdExtParam.a.b();
            b.e(this.adFloorInfo);
            builder.ad_ext_params = b.a();
            builder.app_transmit_data = yu5.b();
            long j = this.pushTid;
            if (j != -1) {
                builder.push_tid = Long.valueOf(j);
            }
            builder.is_newfeed = Integer.valueOf(this.isNewFeed);
            PersonalizedReqIdl.Builder builder2 = new PersonalizedReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
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

    public int getNeedForumlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.needForumlist;
        }
        return invokeV.intValue;
    }

    public void setAdFloorInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.adFloorInfo = str;
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

    public void setNeedForumlist(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            if (i != 1) {
                this.needForumlist = 0;
            } else {
                this.needForumlist = i;
            }
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.pn = i;
        }
    }

    public void setPreAdThreadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.preAdThreadCount = i;
        }
    }

    public void setPushTid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.pushTid = j;
        }
    }

    public void setRequestTime(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.requestTime = i;
        }
    }

    public void setSourceFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.sourceFrom = str;
        }
    }

    public void setSuggestCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.suggestCount = i;
        }
    }

    public void setThreadCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i > 0) {
                this.threadCount = i;
            } else {
                this.threadCount = 0;
            }
        }
    }
}
