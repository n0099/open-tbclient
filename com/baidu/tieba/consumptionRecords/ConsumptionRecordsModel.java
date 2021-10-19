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
/* loaded from: classes7.dex */
public class ConsumptionRecordsModel extends BdBaseModel<ConsumptionRecordsActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f50067e;

    /* renamed from: f  reason: collision with root package name */
    public int f50068f;

    /* renamed from: g  reason: collision with root package name */
    public int f50069g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<c.a.r0.e0.a> f50070h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.r0.e0.b f50071i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f50072j;
    public b k;
    public HttpMessageListener l;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConsumptionRecordsModel f50073a;

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
            this.f50073a = consumptionRecordsModel;
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
                        this.f50073a.E(getUserOrderHttpResponseMessage.getOrderList(), getUserOrderHttpResponseMessage.getRecommendInfo(), getUserOrderHttpResponseMessage.getHasMore());
                    }
                    if (this.f50073a.k != null) {
                        this.f50073a.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f50073a.f50070h, this.f50073a.f50071i, this.f50073a.f50072j);
                        return;
                    }
                    return;
                }
                ConsumptionRecordsModel.w(this.f50073a);
                if (this.f50073a.k != null) {
                    this.f50073a.k.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f50073a.f50070h, this.f50073a.f50071i, this.f50073a.f50072j);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str, ArrayList<c.a.r0.e0.a> arrayList, c.a.r0.e0.b bVar, boolean z);

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
        this.f50067e = 0;
        this.f50068f = 1;
        this.f50069g = 1;
        this.f50072j = false;
        this.l = new a(this, CmdConfigHttp.CMD_GET_USER_ORDER);
        this.unique_id = bdUniqueId;
        registerTask();
        this.l.setSelfListener(true);
        registerListener(this.l);
    }

    public static /* synthetic */ int w(ConsumptionRecordsModel consumptionRecordsModel) {
        int i2 = consumptionRecordsModel.f50067e;
        consumptionRecordsModel.f50067e = i2 - 1;
        return i2;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            this.f50067e = 1;
            newGetUserOrderRequestMessage.setPn(1);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.f50068f);
            newGetUserOrderRequestMessage.setShowMember(this.f50069g);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.f50072j) {
                b bVar = this.k;
                if (bVar != null) {
                    bVar.b();
                    return;
                }
                return;
            }
            this.f50067e++;
            NewGetUserOrderRequestMessage newGetUserOrderRequestMessage = new NewGetUserOrderRequestMessage();
            newGetUserOrderRequestMessage.setPn(this.f50067e);
            newGetUserOrderRequestMessage.setRn(10);
            newGetUserOrderRequestMessage.setOrderType(this.f50068f);
            newGetUserOrderRequestMessage.setShowMember(this.f50069g);
            sendMessage(newGetUserOrderRequestMessage);
        }
    }

    public final void E(ArrayList<c.a.r0.e0.a> arrayList, c.a.r0.e0.b bVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, arrayList, bVar, z) == null) {
            if (bVar != null) {
                this.f50071i = bVar;
            }
            this.f50072j = z;
            if (arrayList == null) {
                return;
            }
            if (this.f50070h == null) {
                this.f50070h = new ArrayList<>();
            }
            if (this.f50067e == 1) {
                this.f50070h.clear();
            }
            this.f50070h.addAll(arrayList);
        }
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.k = bVar;
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
            MessageManager.getInstance().unRegisterListener(this.l);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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
            this.f50069g = i2;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.f50068f = i2;
        }
    }
}
