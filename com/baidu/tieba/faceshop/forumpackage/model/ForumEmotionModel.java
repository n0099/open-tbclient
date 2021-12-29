package com.baidu.tieba.faceshop.forumpackage.model;

import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.message.ForumEmotionCenterResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class ForumEmotionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUM_PER_PAGE = 10;
    public static final int PAGE_START = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44613e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44614f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.t0.y0.y.b.b f44615g;

    /* renamed from: h  reason: collision with root package name */
    public final HttpMessageListener f44616h;

    /* loaded from: classes12.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumEmotionModel forumEmotionModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionModel, Integer.valueOf(i2)};
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
            this.a = forumEmotionModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Object extra;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003389 && (httpResponsedMessage instanceof ForumEmotionCenterResponseMessage)) {
                b bVar = null;
                if (httpResponsedMessage.getOrginalMessage() != null && (extra = httpResponsedMessage.getOrginalMessage().getExtra()) != null && (extra instanceof b)) {
                    bVar = (b) extra;
                }
                ForumEmotionCenterResponseMessage forumEmotionCenterResponseMessage = (ForumEmotionCenterResponseMessage) httpResponsedMessage;
                ForumEmotionModel forumEmotionModel = this.a;
                ForumEmotionData forumEmotionData = forumEmotionCenterResponseMessage.data;
                forumEmotionModel.f44614f = forumEmotionData != null && forumEmotionData.has_more == 1;
                if (bVar != null) {
                    if (forumEmotionCenterResponseMessage.getStatusCode() == 200) {
                        if (forumEmotionCenterResponseMessage.getError() == 0 && forumEmotionCenterResponseMessage.data != null) {
                            if (this.a.f44613e == 1) {
                                bVar.onRefreshSuccess(forumEmotionCenterResponseMessage.data);
                                return;
                            } else {
                                bVar.onLoadMoreSuccess(forumEmotionCenterResponseMessage.data);
                                return;
                            }
                        }
                        bVar.onFailed(forumEmotionCenterResponseMessage.getErrorString());
                        return;
                    }
                    bVar.onFailed(forumEmotionCenterResponseMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface b {
        void onFailed(String str);

        void onLoadMoreSuccess(ForumEmotionData forumEmotionData);

        void onRefreshSuccess(ForumEmotionData forumEmotionData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f44613e = 1;
        this.f44614f = true;
        this.f44615g = new c.a.t0.y0.y.b.b();
        this.f44616h = new a(this, CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        registerTask();
        this.f44616h.setTag(getUniqueId());
        this.f44616h.setSelfListener(true);
        registerListener(this.f44616h);
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f44613e = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            httpMessage.addParam("pn", this.f44613e);
            httpMessage.addParam("rn", 10);
            httpMessage.addParam("forum_type", this.f44615g.a() == 1 ? "like_forum" : "all_forum");
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44614f : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE, TbConfig.SERVER_ADDRESS + "c/e/meme/forumPackage");
            tbHttpMessageTask.setResponsedClass(ForumEmotionCenterResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public c.a.t0.y0.y.b.b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f44615g : (c.a.t0.y0.y.b.b) invokeV.objValue;
    }

    public void z(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            int i2 = this.f44613e + 1;
            this.f44613e = i2;
            httpMessage.addParam("pn", i2);
            httpMessage.addParam("rn", 10);
            httpMessage.addParam("forum_type", this.f44615g.a() == 1 ? "like_forum" : "all_forum");
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }
}
