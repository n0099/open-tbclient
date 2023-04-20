package com.baidu.tieba.faceshop.forumpackage.model;

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
import com.baidu.tieba.a9;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.message.ForumEmotionCenterResponseMessage;
import com.baidu.tieba.uu6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ForumEmotionModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NUM_PER_PAGE = 10;
    public static final int PAGE_START = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public boolean b;
    public final uu6 c;
    public final HttpMessageListener d;

    /* loaded from: classes4.dex */
    public interface b {
        void B0(ForumEmotionData forumEmotionData);

        void onFailed(String str);

        void r1(ForumEmotionData forumEmotionData);
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

    /* loaded from: classes4.dex */
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
            boolean z;
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
                if (forumEmotionData != null && forumEmotionData.has_more == 1) {
                    z = true;
                } else {
                    z = false;
                }
                forumEmotionModel.b = z;
                if (bVar != null) {
                    if (forumEmotionCenterResponseMessage.getStatusCode() == 200) {
                        if (forumEmotionCenterResponseMessage.getError() == 0 && forumEmotionCenterResponseMessage.data != null) {
                            if (this.a.a == 1) {
                                bVar.r1(forumEmotionCenterResponseMessage.data);
                                return;
                            } else {
                                bVar.B0(forumEmotionCenterResponseMessage.data);
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
                super((a9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.b = true;
        this.c = new uu6();
        this.d = new a(this, CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
        registerTask();
        this.d.setTag(getUniqueId());
        this.d.setSelfListener(true);
        registerListener(this.d);
    }

    public uu6 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (uu6) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void T(b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            int i = this.a + 1;
            this.a = i;
            httpMessage.addParam("pn", i);
            httpMessage.addParam("rn", 10);
            if (this.c.a() == 1) {
                str = "like_forum";
            } else {
                str = "all_forum";
            }
            httpMessage.addParam("forum_type", str);
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
    }

    public void U(b bVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.a = 1;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_EMOTION_PACKAGE);
            httpMessage.addParam("pn", this.a);
            httpMessage.addParam("rn", 10);
            if (this.c.a() == 1) {
                str = "like_forum";
            } else {
                str = "all_forum";
            }
            httpMessage.addParam("forum_type", str);
            httpMessage.setExtra(bVar);
            sendMessage(httpMessage);
        }
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
