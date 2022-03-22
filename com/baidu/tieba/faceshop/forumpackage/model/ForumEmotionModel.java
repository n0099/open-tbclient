package com.baidu.tieba.faceshop.forumpackage.model;

import c.a.d.a.f;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
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
/* loaded from: classes5.dex */
public class ForumEmotionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUM_PER_PAGE = 10;
    public static final int PAGE_START = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32151b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a.p0.a1.z.b.b f32152c;

    /* renamed from: d  reason: collision with root package name */
    public final HttpMessageListener f32153d;

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumEmotionModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumEmotionModel forumEmotionModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumEmotionModel, Integer.valueOf(i)};
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
                forumEmotionModel.f32151b = forumEmotionData != null && forumEmotionData.has_more == 1;
                if (bVar != null) {
                    if (forumEmotionCenterResponseMessage.getStatusCode() == 200) {
                        if (forumEmotionCenterResponseMessage.getError() == 0 && forumEmotionCenterResponseMessage.data != null) {
                            if (this.a.a == 1) {
                                bVar.t0(forumEmotionCenterResponseMessage.data);
                                return;
                            } else {
                                bVar.P(forumEmotionCenterResponseMessage.data);
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

    /* loaded from: classes5.dex */
    public interface b {
        void P(ForumEmotionData forumEmotionData);

        void onFailed(String str);

        void t0(ForumEmotionData forumEmotionData);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f32151b = true;
        this.f32152c = new c.a.p0.a1.z.b.b();
        this.f32153d = new a(this, CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        registerTask();
        this.f32153d.setTag(getUniqueId());
        this.f32153d.setSelfListener(true);
        registerListener(this.f32153d);
    }

    public c.a.p0.a1.z.b.b A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32152c : (c.a.p0.a1.z.b.b) invokeV.objValue;
    }

    public void B(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            int i = this.a + 1;
            this.a = i;
            httpMessage.addParam(Config.PACKAGE_NAME, i);
            httpMessage.addParam("rn", 10);
            httpMessage.addParam("forum_type", this.f32152c.a() == 1 ? "like_forum" : "all_forum");
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }

    public void C(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.a = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            httpMessage.addParam(Config.PACKAGE_NAME, this.a);
            httpMessage.addParam("rn", 10);
            httpMessage.addParam("forum_type", this.f32152c.a() == 1 ? "like_forum" : "all_forum");
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f32151b : invokeV.booleanValue;
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

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE, TbConfig.SERVER_ADDRESS + "c/e/meme/forumPackage");
            tbHttpMessageTask.setResponsedClass(ForumEmotionCenterResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }
}
