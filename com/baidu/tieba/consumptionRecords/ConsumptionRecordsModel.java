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
/* loaded from: classes4.dex */
public class ConsumptionRecordsModel extends BdBaseModel<ConsumptionRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f14606e;

    /* renamed from: f  reason: collision with root package name */
    public int f14607f;

    /* renamed from: g  reason: collision with root package name */
    public int f14608g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<d.a.q0.d0.a> f14609h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.q0.d0.b f14610i;
    public boolean j;
    public b k;
    public HttpMessageListener l;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConsumptionRecordsModel f14611a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ConsumptionRecordsModel consumptionRecordsModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {consumptionRecordsModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14611a = consumptionRecordsModel;
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
                        this.f14611a.E(getUserOrderHttpResponseMessage.getOrderList(), getUserOrderHttpResponseMessage.getRecommendInfo(), getUserOrderHttpResponseMessage.getHasMore());
                    }
                    if (this.f14611a.k != null) {
                        this.f14611a.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f14611a.f14609h, this.f14611a.f14610i, this.f14611a.j);
                        return;
                    }
                    return;
                }
                ConsumptionRecordsModel.w(this.f14611a);
                if (this.f14611a.k != null) {
                    this.f14611a.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f14611a.f14609h, this.f14611a.f14610i, this.f14611a.j);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(int i2, String str, ArrayList<d.a.q0.d0.a> arrayList, d.a.q0.d0.b bVar, boolean z);

        void b();
    }

    public ConsumptionRecordsModel(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f14606e = 0;
        this.f14607f = 1;
        this.f14608g = 1;
        this.j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GET_USER_ORDER);
        this.unique_id = bdUniqueId;
        registerTask();
        this.l.setSelfListener(true);
        registerListener(this.l);
    }

    public static /* synthetic */ int w(ConsumptionRecordsModel consumptionRecordsModel) {
        int i2 = consumptionRecordsModel.f14606e;
        consumptionRecordsModel.f14606e = i2 - 1;
        return i2;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            this.f14606e = 1;
            newGetUserOrderRequestMessage.setPn(1);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.f14607f);
            newGetUserOrderRequestMessage.setShowMember(this.f14608g);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.j) {
                b bVar = this.k;
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            }
            this.f14606e++;
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            newGetUserOrderRequestMessage.setPn(this.f14606e);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.f14607f);
            newGetUserOrderRequestMessage.setShowMember(this.f14608g);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public final void E(ArrayList<d.a.q0.d0.a> arrayList, d.a.q0.d0.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, arrayList, bVar, z) == null) {
            if (bVar != null) {
                this.f14610i = bVar;
            }
            this.j = z;
            if (arrayList == null) {
                return;
            }
            if (this.f14609h == null) {
                this.f14609h = new ArrayList<>();
            }
            if (this.f14606e == 1) {
                this.f14609h.clear();
            }
            this.f14609h.addAll(arrayList);
        }
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            cancelMessage();
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_USER_ORDER, TbConfig.SERVER_ADDRESS + TbConfig.GET_USER_ORDER);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(GetUserOrderHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void setShowMember(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.f14608g = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f14607f = i2;
        }
    }
}
