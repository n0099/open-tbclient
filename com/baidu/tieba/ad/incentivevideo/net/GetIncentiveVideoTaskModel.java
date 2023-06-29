package com.baidu.tieba.ad.incentivevideo.net;

import android.content.Context;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.a66;
import com.baidu.tieba.h95;
import com.baidu.tieba.r66;
import com.baidu.tieba.rw5;
import com.baidu.tieba.x66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GetIncentiveVideoTaskModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Context b;
    public BdUniqueId c;
    public HttpMessageListener d;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GetIncentiveVideoTaskModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(GetIncentiveVideoTaskModel getIncentiveVideoTaskModel, int i, boolean z) {
            super(i, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {getIncentiveVideoTaskModel, Integer.valueOf(i), Boolean.valueOf(z)};
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
            this.a = getIncentiveVideoTaskModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            x66 adIncentiveVideoTaskData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && !rw5.a() && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003547 && (httpResponsedMessage instanceof GetIncentiveVideoTaskResMsg) && (adIncentiveVideoTaskData = ((GetIncentiveVideoTaskResMsg) httpResponsedMessage).getAdIncentiveVideoTaskData()) != null && !StringUtils.isNull(adIncentiveVideoTaskData.c())) {
                a66.a(adIncentiveVideoTaskData.c());
                int i = 1;
                r66.i().m(1);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_NO_AD_INVOKE_SDK).param("obj_source", this.a.Z());
                if (this.a.a == 6) {
                    i = 2;
                }
                TiebaStatic.log(param.param("obj_param1", i).param("fid", this.a.Y()).param("tid", this.a.a0()));
            }
        }
    }

    public GetIncentiveVideoTaskModel(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, CmdConfigHttp.CMD_GET_INCENTIVE_VIDEO_TASK, true);
        this.a = i;
        this.b = context;
        TbPageContext currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(context);
        if (currentPageContext != null) {
            this.c = currentPageContext.getUniqueId();
        }
        setUniqueId(this.c);
        b0();
        registerListener();
    }

    public final String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i = this.a;
            if (i == 3 || i == 2 || i == 4 || i == 5) {
                Context context = this.b;
                if (context instanceof h95) {
                    return ((h95) context).w0();
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.a;
            if (i == 1) {
                return 1;
            }
            if (i == 3 || i == 2) {
                return 2;
            }
            if (i != 4 && i != 5) {
                return 0;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public final String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.a;
            if (i == 3 || i == 2 || i == 4 || i == 5) {
                Context context = this.b;
                if (context instanceof h95) {
                    return ((h95) context).r1();
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            loadData();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_INCENTIVE_VIDEO_TASK);
            MessageManager.getInstance().unRegisterListener(this.d);
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_INCENTIVE_VIDEO_TASK));
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.d.setTag(this.c);
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_INCENTIVE_VIDEO_TASK, TbConfig.SERVER_ADDRESS + "c/s/activateTask");
            tbHttpMessageTask.setResponsedClass(GetIncentiveVideoTaskResMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
