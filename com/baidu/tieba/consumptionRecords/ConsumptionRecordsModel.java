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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ConsumptionRecordsModel extends BdBaseModel<ConsumptionRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f31686b;

    /* renamed from: c  reason: collision with root package name */
    public int f31687c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<c.a.p0.k0.a> f31688d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.p0.k0.b f31689e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31690f;

    /* renamed from: g  reason: collision with root package name */
    public b f31691g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f31692h;

    /* loaded from: classes5.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && ((z = httpResponsedMessage instanceof GetUserOrderHttpResponseMessage))) {
                if (httpResponsedMessage.getError() == 0) {
                    if (z) {
                        GetUserOrderHttpResponseMessage getUserOrderHttpResponseMessage = (GetUserOrderHttpResponseMessage) httpResponsedMessage;
                        this.a.G(getUserOrderHttpResponseMessage.getOrderList(), getUserOrderHttpResponseMessage.getRecommendInfo(), getUserOrderHttpResponseMessage.getHasMore());
                    }
                    if (this.a.f31691g != null) {
                        this.a.f31691g.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.f31688d, this.a.f31689e, this.a.f31690f);
                        return;
                    }
                    return;
                }
                ConsumptionRecordsModel.y(this.a);
                if (this.a.f31691g != null) {
                    this.a.f31691g.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.f31688d, this.a.f31689e, this.a.f31690f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b(int i, String str, ArrayList<c.a.p0.k0.a> arrayList, c.a.p0.k0.b bVar, boolean z);
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
        this.f31686b = 1;
        this.f31687c = 1;
        this.f31690f = false;
        this.f31692h = new a(this, CmdConfigHttp.CMD_GET_USER_ORDER);
        this.unique_id = bdUniqueId;
        registerTask();
        this.f31692h.setSelfListener(true);
        registerListener(this.f31692h);
    }

    public static /* synthetic */ int y(ConsumptionRecordsModel consumptionRecordsModel) {
        int i = consumptionRecordsModel.a;
        consumptionRecordsModel.a = i - 1;
        return i;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            this.a = 1;
            newGetUserOrderRequestMessage.setPn(1);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.f31686b);
            newGetUserOrderRequestMessage.setShowMember(this.f31687c);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.f31690f) {
                b bVar = this.f31691g;
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
            newGetUserOrderRequestMessage.setOrderType(this.f31686b);
            newGetUserOrderRequestMessage.setShowMember(this.f31687c);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public final void G(ArrayList<c.a.p0.k0.a> arrayList, c.a.p0.k0.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, arrayList, bVar, z) == null) {
            if (bVar != null) {
                this.f31689e = bVar;
            }
            this.f31690f = z;
            if (arrayList == null) {
                return;
            }
            if (this.f31688d == null) {
                this.f31688d = new ArrayList<>();
            }
            if (this.a == 1) {
                this.f31688d.clear();
            }
            this.f31688d.addAll(arrayList);
        }
    }

    public void H(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f31691g = bVar;
        }
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

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.f31692h);
        }
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f31686b : invokeV.intValue;
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

    public void setShowMember(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f31687c = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.f31686b = i;
        }
    }
}
