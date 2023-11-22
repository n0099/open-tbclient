package com.baidu.tieba.ad.incentivevideo.net;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CustomToast;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.b36;
import com.baidu.tieba.bt5;
import com.baidu.tieba.e36;
import com.baidu.tieba.v26;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GetAdFreeTimeModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public HttpMessageListener b;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GetAdFreeTimeModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetAdFreeTimeModel getAdFreeTimeModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getAdFreeTimeModel, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = getAdFreeTimeModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            b36 adIncentiveVideoTaskData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || bt5.a() || httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003548 || !(httpResponsedMessage instanceof GetAdFreeTimeResMsg) || (adIncentiveVideoTaskData = ((GetAdFreeTimeResMsg) httpResponsedMessage).getAdIncentiveVideoTaskData()) == null) {
                return;
            }
            long j = JavaTypesHelper.toLong(adIncentiveVideoTaskData.a(), 0L) * 1000;
            long j2 = JavaTypesHelper.toLong(adIncentiveVideoTaskData.b(), 0L) * 1000;
            this.a.V(j);
            this.a.R(j2);
            this.a.U(j, j2);
        }
    }

    public GetAdFreeTimeModel() {
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
        this.a = BdUniqueId.gen();
        this.b = new a(this, CmdConfigHttp.CMD_GET_AD_FREE_TIME, true);
        setUniqueId(this.a);
        S();
        registerListener();
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_AD_FREE_TIME, TbConfig.SERVER_ADDRESS + "c/s/getAdFreeTime");
            tbHttpMessageTask.setResponsedClass(GetAdFreeTimeResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void R(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048576, this, j) == null) && j > 0) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921746));
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            loadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_AD_FREE_TIME);
            MessageManager.getInstance().unRegisterListener(this.b);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_AD_FREE_TIME);
            httpMessage.addParam("request_key", v26.i().k());
            sendMessage(httpMessage);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setTag(this.a);
            MessageManager.getInstance().registerListener(this.b);
        }
    }

    public final void U(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (e36.L().Q()) {
                e36.L().N(j);
            } else if (j2 > 0) {
                e36.L().b0(j2);
                e36.L().U(j2);
                e36.L().c0();
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_FLOAT_SHOW).param("uid", TbadkCoreApplication.getCurrentAccountId()));
            }
        }
    }

    public final void V(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && j > 0) {
            CustomToast.newInstance().showToast(String.format(TbadkCoreApplication.getInst().getString(R.string.incentive_video_free_time_tip), String.valueOf((int) ((j / 1000) / 60))));
        }
    }
}
