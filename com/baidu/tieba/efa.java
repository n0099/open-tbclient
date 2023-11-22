package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.recentforum.data.RecentForumRespondedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
/* loaded from: classes5.dex */
public final class efa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public boolean b;
    public a c;
    public boolean d;
    public final b e;

    /* loaded from: classes5.dex */
    public interface a {
        void a(oe8 oe8Var);

        void onFail();
    }

    /* loaded from: classes5.dex */
    public static final class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ efa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(efa efaVar) {
            super(CmdConfigHttp.CMD_RECENT_FORUM);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {efaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = efaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003572 && (httpResponsedMessage instanceof RecentForumRespondedMessage)) {
                    RecentForumRespondedMessage recentForumRespondedMessage = (RecentForumRespondedMessage) httpResponsedMessage;
                    if (recentForumRespondedMessage.getError() != 0) {
                        this.a.g(false);
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.i("RecentForumLog", "请求结束，返回错误，错误码为：" + recentForumRespondedMessage.getError());
                        a a = this.a.a();
                        if (a != null) {
                            a.onFail();
                            return;
                        }
                        return;
                    }
                    this.a.g(false);
                    oe8 data = recentForumRespondedMessage.getData();
                    Unit unit = null;
                    if (data != null) {
                        efa efaVar = this.a;
                        DefaultLog.getInstance().i("RecentForumLog", "请求结束，有返回数据");
                        a a2 = efaVar.a();
                        if (a2 != null) {
                            a2.a(data);
                            unit = Unit.INSTANCE;
                        }
                    }
                    if (unit == null) {
                        DefaultLog.getInstance().i("RecentForumLog", "请求结束，返回数据为空");
                        return;
                    }
                    return;
                }
                this.a.g(false);
                DefaultLog.getInstance().i("RecentForumLog", "请求结束，数据不合法");
                a a3 = this.a.a();
                if (a3 != null) {
                    a3.onFail();
                }
            }
        }
    }

    public efa(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bdUniqueId;
        this.e = new b(this);
        e();
    }

    public final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (a) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_RECENT_FORUM);
            MessageManager.getInstance().unRegisterListener(this.e);
            this.d = true;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d();
            this.e.setSelfListener(true);
            this.e.setTag(this.a);
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    public final boolean b(s78 s78Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s78Var)) == null) {
            if (this.d) {
                e();
                this.d = false;
                DefaultLog.getInstance().i("RecentForumLog", "重新注册");
            }
            if (this.b) {
                DefaultLog.getInstance().i("RecentForumLog", "上一次请求正在执行，不请求");
                return false;
            }
            this.b = true;
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_RECENT_FORUM);
            String str = null;
            if (s78Var != null) {
                str = s78Var.a().toString();
                httpMessage.addParam("forum_frscsm", str);
            }
            httpMessage.setTag(this.a);
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("RecentForumLog", "开始请求，请求参数：" + str);
            MessageManager.getInstance().sendMessage(httpMessage);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECENT_FORUM, TbConfig.SERVER_ADDRESS + "c/f/excellent/getRecentForum");
            tbHttpMessageTask.setResponsedClass(RecentForumRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.c = aVar;
        }
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.b = z;
        }
    }
}
