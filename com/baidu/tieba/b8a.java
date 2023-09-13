package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.searchrecforum.message.SearchRecForumRequestMessage;
import com.baidu.tieba.searchrecforum.message.SearchRecForumResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b8a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public boolean b;
    public boolean c;
    public HttpResponsedMessage d;
    public b e;
    public final HttpMessageListener f;

    /* loaded from: classes5.dex */
    public interface b {
        void a(e8a e8aVar);

        void onFail();
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b8a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b8a b8aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b8aVar, Integer.valueOf(i)};
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
            this.a = b8aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (this.a.c) {
                    this.a.d = httpResponsedMessage;
                } else {
                    this.a.f(httpResponsedMessage);
                }
            }
        }
    }

    public b8a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdUniqueId.gen();
        this.b = false;
        this.c = false;
        this.f = new a(this, CmdConfigHttp.CMD_GET_SEARCH_BACK_INTEREST_FORUM);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_SEARCH_BACK_INTEREST_FORUM, TbConfig.SERVER_ADDRESS + "c/f/excellent/getRecomForum");
        tbHttpMessageTask.setResponsedClass(SearchRecForumResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.f);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !a8a.d().e()) {
            return;
        }
        if (this.b) {
            MessageManager.getInstance().removeHttpMessage(this.a);
        }
        this.b = true;
        SearchRecForumRequestMessage searchRecForumRequestMessage = new SearchRecForumRequestMessage();
        searchRecForumRequestMessage.setParams(a8a.d().c());
        searchRecForumRequestMessage.setTag(this.a);
        MessageManager.getInstance().sendMessage(searchRecForumRequestMessage);
    }

    public void h(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.e = bVar;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c) {
            f(this.d);
            this.c = false;
            this.d = null;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
        }
    }

    public final void f(HttpResponsedMessage httpResponsedMessage) {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, httpResponsedMessage) == null) {
            this.b = false;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003526 && (httpResponsedMessage instanceof SearchRecForumResponsedMessage)) {
                if (httpResponsedMessage.getError() != 0 && (bVar = this.e) != null) {
                    bVar.onFail();
                    return;
                }
                a8a.d().i(false);
                b bVar2 = this.e;
                if (bVar2 != null) {
                    bVar2.a(((SearchRecForumResponsedMessage) httpResponsedMessage).data);
                }
            }
        }
    }
}
