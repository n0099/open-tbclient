package com.baidu.tieba.consumptionRecords;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.r56;
import com.baidu.tieba.s56;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ConsumptionRecordsModel extends BdBaseModel<ConsumptionRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public ArrayList<r56> d;
    public s56 e;
    public boolean f;
    public b g;
    public HttpMessageListener h;

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b(int i, String str, ArrayList<r56> arrayList, s56 s56Var, boolean z);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ConsumptionRecordsModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConsumptionRecordsModel consumptionRecordsModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumptionRecordsModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = consumptionRecordsModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || httpResponsedMessage == null || !((z = httpResponsedMessage instanceof GetUserOrderHttpResponseMessage))) {
                return;
            }
            if (httpResponsedMessage.getError() != 0) {
                ConsumptionRecordsModel.z(this.a);
                if (this.a.g != null) {
                    this.a.g.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.d, this.a.e, this.a.f);
                    return;
                }
                return;
            }
            if (z) {
                GetUserOrderHttpResponseMessage getUserOrderHttpResponseMessage = (GetUserOrderHttpResponseMessage) httpResponsedMessage;
                this.a.H(getUserOrderHttpResponseMessage.getOrderList(), getUserOrderHttpResponseMessage.getRecommendInfo(), getUserOrderHttpResponseMessage.getHasMore());
            }
            if (this.a.g != null) {
                this.a.g.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.d, this.a.e, this.a.f);
            }
        }
    }

    public ConsumptionRecordsModel(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 1;
        this.c = 1;
        this.f = false;
        this.h = new a(this, CmdConfigHttp.CMD_GET_USER_ORDER);
        this.unique_id = bdUniqueId;
        registerTask();
        this.h.setSelfListener(true);
        registerListener(this.h);
    }

    public static /* synthetic */ int z(ConsumptionRecordsModel consumptionRecordsModel) {
        int i = consumptionRecordsModel.a;
        consumptionRecordsModel.a = i - 1;
        return i;
    }

    public void I(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public void setShowMember(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.c = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.b = i;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            this.a = 1;
            newGetUserOrderRequestMessage.setPn(1);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.b);
            newGetUserOrderRequestMessage.setShowMember(this.c);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.h);
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.f) {
                b bVar = this.g;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            this.a++;
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            newGetUserOrderRequestMessage.setPn(this.a);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.b);
            newGetUserOrderRequestMessage.setShowMember(this.c);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_USER_ORDER, TbConfig.SERVER_ADDRESS + TbConfig.GET_USER_ORDER);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(GetUserOrderHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void H(ArrayList<r56> arrayList, s56 s56Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, arrayList, s56Var, z) == null) {
            if (s56Var != null) {
                this.e = s56Var;
            }
            this.f = z;
            if (arrayList == null) {
                return;
            }
            if (this.d == null) {
                this.d = new ArrayList<>();
            }
            if (this.a == 1) {
                this.d.clear();
            }
            this.d.addAll(arrayList);
        }
    }
}
