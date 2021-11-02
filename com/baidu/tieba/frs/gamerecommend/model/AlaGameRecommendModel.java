package com.baidu.tieba.frs.gamerecommend.model;

import b.a.e.l.e.n;
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
/* loaded from: classes9.dex */
public class AlaGameRecommendModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIRST_PN = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public String f48628e;

    /* renamed from: f  reason: collision with root package name */
    public int f48629f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48630g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48631h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f48632i;
    public HttpMessageListener j;
    public b k;
    public b.a.r0.x0.e2.d.a l;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AlaGameRecommendModel f48633a;

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
            this.f48633a = alaGameRecommendModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003401 && (httpResponsedMessage instanceof AlaGameRecommendReponseMessage) && httpResponsedMessage.getOrginalMessage().getTag() == this.f48633a.f48632i) {
                AlaGameRecommendReponseMessage alaGameRecommendReponseMessage = (AlaGameRecommendReponseMessage) httpResponsedMessage;
                if (alaGameRecommendReponseMessage.hasError() || alaGameRecommendReponseMessage.getError() != 0) {
                    if (this.f48633a.k != null) {
                        this.f48633a.k.b(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString(), this.f48633a.f48631h);
                    }
                } else {
                    b.a.r0.x0.e2.c.a data = alaGameRecommendReponseMessage.getData();
                    if (data == null) {
                        return;
                    }
                    this.f48633a.f48630g = data.f25701a;
                    if (this.f48633a.f48631h) {
                        AlaGameRecommendModel.D(this.f48633a);
                    }
                    this.f48633a.l.c(this.f48633a.f48629f, data);
                    if (this.f48633a.k != null) {
                        this.f48633a.k.a(this.f48633a.f48630g, this.f48633a.l.a());
                    }
                }
                this.f48633a.f48631h = false;
            }
        }
    }

    /* loaded from: classes9.dex */
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
        this.f48628e = str;
        this.k = bVar;
        this.f48632i = BdUniqueId.gen();
        this.l = new b.a.r0.x0.e2.d.a();
        F();
        registerListener();
    }

    public static /* synthetic */ int D(AlaGameRecommendModel alaGameRecommendModel) {
        int i2 = alaGameRecommendModel.f48629f;
        alaGameRecommendModel.f48629f = i2 + 1;
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
            this.f48631h = false;
            this.f48629f = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.f48628e);
            httpMessage.addParam("recom_pn", this.f48629f);
            httpMessage.setTag(this.f48632i);
            MessageManager.getInstance().sendMessage(httpMessage);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void loadMore() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.f48630g && !this.f48631h) {
            this.f48631h = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            httpMessage.addParam("forum_id", this.f48628e);
            httpMessage.addParam("recom_pn", this.f48629f + 1);
            httpMessage.setTag(this.f48632i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            MessageManager.getInstance().unRegisterListener(this.j);
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.j = new a(this, CmdConfigHttp.CMD_GET_GAME_RECOMMEND_TAB_INFO);
            MessageManager.getInstance().registerListener(this.j);
        }
    }
}
