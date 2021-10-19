package com.baidu.tieba.ala.alasquare.special_forum.model;

import c.a.e.l.e.n;
import c.a.r0.w.f.g.c.d;
import c.a.r0.w.f.g.c.e;
import c.a.r0.w.f.g.c.f;
import c.a.r0.w.f.g.c.g;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alasquare.special_forum.message.AlaSpecialConcernResponse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class SpecialConcernTabModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49570e;

    /* renamed from: f  reason: collision with root package name */
    public b f49571f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f49572g;

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f49573h;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SpecialConcernTabModel f49574a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SpecialConcernTabModel specialConcernTabModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {specialConcernTabModel, Integer.valueOf(i2)};
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
            this.f49574a = specialConcernTabModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021094 && (httpResponsedMessage instanceof AlaSpecialConcernResponse)) {
                AlaSpecialConcernResponse alaSpecialConcernResponse = (AlaSpecialConcernResponse) httpResponsedMessage;
                if (alaSpecialConcernResponse.isSuccess()) {
                    if (this.f49574a.f49570e == 1) {
                        this.f49574a.f49572g.clear();
                    }
                    boolean z = alaSpecialConcernResponse.hasMore;
                    if (ListUtils.isEmpty(alaSpecialConcernResponse.followList)) {
                        if (this.f49574a.f49570e == 1) {
                            this.f49574a.f49572g.add(new e());
                        }
                    } else {
                        for (d dVar : alaSpecialConcernResponse.followList) {
                            f fVar = new f();
                            fVar.f25994e = dVar.f25989a;
                            fVar.f25995f = dVar.f25990b;
                            fVar.f25996g = false;
                            this.f49574a.f49572g.add(fVar);
                        }
                    }
                    if (!ListUtils.isEmpty(alaSpecialConcernResponse.recommendList)) {
                        g gVar = new g();
                        if (!ListUtils.isEmpty(alaSpecialConcernResponse.followList)) {
                            gVar.f25998e = false;
                        } else {
                            gVar.f25998e = true;
                        }
                        this.f49574a.f49572g.add(gVar);
                        for (d dVar2 : alaSpecialConcernResponse.recommendList) {
                            f fVar2 = new f();
                            fVar2.f25994e = dVar2.f25989a;
                            fVar2.f25995f = dVar2.f25990b;
                            fVar2.f25996g = true;
                            this.f49574a.f49572g.add(fVar2);
                        }
                    }
                    SpecialConcernTabModel.x(this.f49574a);
                    if (this.f49574a.f49571f != null) {
                        this.f49574a.f49571f.b(this.f49574a.f49572g, z, alaSpecialConcernResponse.totalFollowCount);
                    }
                } else if (this.f49574a.f49571f != null) {
                    this.f49574a.f49571f.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str);

        void b(List<n> list, boolean z, int i2);
    }

    public SpecialConcernTabModel(TbPageContext tbPageContext) {
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
        this.f49570e = 1;
        this.f49573h = new a(this, AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
        this.f49572g = new ArrayList();
        MessageManager.getInstance().registerListener(this.f49573h);
    }

    public static /* synthetic */ int x(SpecialConcernTabModel specialConcernTabModel) {
        int i2 = specialConcernTabModel.f49570e;
        specialConcernTabModel.f49570e = i2 + 1;
        return i2;
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_SPECIAL_CONCERN_TAB);
            httpMessage.addParam("pn", i2);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            A(this.f49570e + 1);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f49570e = 1;
            A(1);
        }
    }

    public void D(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f49571f = bVar;
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

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.f49573h);
        }
    }
}
