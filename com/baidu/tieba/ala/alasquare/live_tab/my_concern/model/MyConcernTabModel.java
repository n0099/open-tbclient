package com.baidu.tieba.ala.alasquare.live_tab.my_concern.model;

import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.AlaLiveTabMyConcernResponse;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class MyConcernTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49469e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f49470f;

    /* renamed from: g  reason: collision with root package name */
    public b f49471g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.r0.v.d.c.f.c.b f49472h;

    /* renamed from: i  reason: collision with root package name */
    public HttpMessageListener f49473i;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MyConcernTabModel f49474a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MyConcernTabModel myConcernTabModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myConcernTabModel, Integer.valueOf(i2)};
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
            this.f49474a = myConcernTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021140 && (httpResponsedMessage instanceof AlaLiveTabMyConcernResponse)) {
                AlaLiveTabMyConcernResponse alaLiveTabMyConcernResponse = (AlaLiveTabMyConcernResponse) httpResponsedMessage;
                boolean z = ListUtils.isEmpty(alaLiveTabMyConcernResponse.followList) && ListUtils.isEmpty(alaLiveTabMyConcernResponse.recommendList) && ListUtils.isEmpty(alaLiveTabMyConcernResponse.followCloseList) && alaLiveTabMyConcernResponse.followStatus == 0;
                if (alaLiveTabMyConcernResponse.getError() != 0 || !alaLiveTabMyConcernResponse.isSuccess() || z) {
                    if (this.f49474a.f49471g != null) {
                        this.f49474a.f49471g.b(this.f49474a.f49469e == 1);
                        return;
                    }
                    return;
                }
                this.f49474a.f49472h.e(alaLiveTabMyConcernResponse, this.f49474a.f49469e == 1);
                if (this.f49474a.f49471g != null) {
                    this.f49474a.f49471g.a(this.f49474a.f49472h.h(), alaLiveTabMyConcernResponse.hasMore, this.f49474a.f49469e == 1);
                }
                this.f49474a.f49469e = alaLiveTabMyConcernResponse.pn + 1;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<n> list, boolean z, boolean z2);

        void b(boolean z);
    }

    public MyConcernTabModel(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49469e = 1;
        this.f49473i = new a(this, AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
        this.f49470f = tbPageContext;
        this.f49472h = new c.a.r0.v.d.c.f.c.b(this.f49470f);
        D();
        MessageManager.getInstance().registerListener(this.f49473i);
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST);
            httpMessage.addParam("pn", i2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A(this.f49469e);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49469e = 1;
            this.f49472h.a();
            A(1);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_TAB_SUB_MY_CONCERN_LIST, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_TAB_SUB_MY_CONCERN_LIST);
            tbHttpMessageTask.setIsNeedLogin(true);
            tbHttpMessageTask.setIsNeedTbs(true);
            tbHttpMessageTask.setIsUseCurrentBDUSS(true);
            tbHttpMessageTask.setResponsedClass(AlaLiveTabMyConcernResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void E(Class<? extends BaseCardInfo> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            this.f49472h.j(cls);
        }
    }

    public void F(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f49471g = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f49472h.a();
            if (this.f49473i != null) {
                MessageManager.getInstance().unRegisterListener(this.f49473i);
            }
        }
    }
}
