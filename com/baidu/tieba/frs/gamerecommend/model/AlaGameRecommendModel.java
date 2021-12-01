package com.baidu.tieba.frs.gamerecommend.model;

import c.a.d.m.e.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.frs.gamerecommend.message.AlaGameRecommendReponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f44383e;

    /* renamed from: f  reason: collision with root package name */
    public int f44384f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44385g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f44386h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f44387i;

    /* renamed from: j  reason: collision with root package name */
    public HttpMessageListener f44388j;

    /* renamed from: k  reason: collision with root package name */
    public b f44389k;
    public c.a.r0.d1.f2.d.a l;

    /* loaded from: classes10.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaGameRecommendModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AlaGameRecommendModel alaGameRecommendModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaGameRecommendModel, Integer.valueOf(i2)};
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
            this.a = alaGameRecommendModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.a.f44387i) {
                AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                    if (this.a.f44389k != null) {
                        this.a.f44389k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.a.f44386h);
                    }
                } else {
                    c.a.r0.d1.f2.c.a data = alaGameRecommendReponseMessage.getData();
                    if (data == null) {
                        return;
                    }
                    this.a.f44385g = data.a;
                    if (this.a.f44386h) {
                        AlaGameRecommendModel.D(this.a);
                    }
                    this.a.l.c(this.a.f44384f, data);
                    if (this.a.f44389k != null) {
                        this.a.f44389k.a(this.a.f44385g, this.a.l.a());
                    }
                }
                this.a.f44386h = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(boolean z, List<n> list);

        void b(int i2, String str, boolean z);
    }

    public AlaGameRecommendModel(String str, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44383e = str;
        this.f44389k = bVar;
        this.f44387i = BdUniqueId.gen();
        this.l = new c.a.r0.d1.f2.d.a();
        F();
        registerListener();
    }

    public static /* synthetic */ int D(AlaGameRecommendModel alaGameRecommendModel) {
        int i2 = alaGameRecommendModel.f44384f;
        alaGameRecommendModel.f44384f = i2 + 1;
        return i2;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO, TbConfig.SERVER_ADDRESS + "c/f/game/gameForumRecomTab");
            tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? !ListUtils.isEmpty(this.l.a()) : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.f44386h = false;
            this.f44384f = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.f44383e);
            httpMessage.addParam("recom_pn", this.f44384f);
            httpMessage.setTag(this.f44387i);
            MessageManager.getInstance().sendMessage(httpMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f44385g && !this.f44386h) {
            this.f44386h = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.f44383e);
            httpMessage.addParam("recom_pn", this.f44384f + 1);
            httpMessage.setTag(this.f44387i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            MessageManager.getInstance().unRegisterListener(this.f44388j);
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f44388j = new a(this, CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            MessageManager.getInstance().registerListener(this.f44388j);
        }
    }
}
