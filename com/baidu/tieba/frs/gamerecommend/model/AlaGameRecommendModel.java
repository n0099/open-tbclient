package com.baidu.tieba.frs.gamerecommend.model;

import c.a.e.l.e.n;
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
/* loaded from: classes7.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f51086e;

    /* renamed from: f  reason: collision with root package name */
    public int f51087f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51088g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51089h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f51090i;

    /* renamed from: j  reason: collision with root package name */
    public HttpMessageListener f51091j;
    public b k;
    public c.a.q0.v0.t1.d.a l;

    /* loaded from: classes7.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameRecommendModel f51092a;

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
            this.f51092a = alaGameRecommendModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f51092a.f51090i) {
                AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                    if (this.f51092a.k != null) {
                        this.f51092a.k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f51092a.f51089h);
                    }
                } else {
                    c.a.q0.v0.t1.c.a data = alaGameRecommendReponseMessage.getData();
                    if (data == null) {
                        return;
                    }
                    this.f51092a.f51088g = data.f27172a;
                    if (this.f51092a.f51089h) {
                        AlaGameRecommendModel.D(this.f51092a);
                    }
                    this.f51092a.l.c(this.f51092a.f51087f, data);
                    if (this.f51092a.k != null) {
                        this.f51092a.k.a(this.f51092a.f51088g, this.f51092a.l.a());
                    }
                }
                this.f51092a.f51089h = false;
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f51086e = str;
        this.k = bVar;
        this.f51090i = BdUniqueId.gen();
        this.l = new c.a.q0.v0.t1.d.a();
        G();
        registerListener();
    }

    public static /* synthetic */ int D(AlaGameRecommendModel alaGameRecommendModel) {
        int i2 = alaGameRecommendModel.f51087f;
        alaGameRecommendModel.f51087f = i2 + 1;
        return i2;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f51089h = false;
            this.f51087f = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.f51086e);
            httpMessage.addParam("recom_pn", this.f51087f);
            httpMessage.setTag(this.f51090i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO, TbConfig.SERVER_ADDRESS + "c/f/game/gameForumRecomTab");
            tbHttpMessageTask.setResponsedClass(AlaGameRecommendReponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !ListUtils.isEmpty(this.l.a()) : invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.f51088g && !this.f51089h) {
            this.f51089h = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.f51086e);
            httpMessage.addParam("recom_pn", this.f51087f + 1);
            httpMessage.setTag(this.f51090i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            MessageManager.getInstance().unRegisterListener(this.f51091j);
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f51091j = new a(this, CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            MessageManager.getInstance().registerListener(this.f51091j);
        }
    }
}
