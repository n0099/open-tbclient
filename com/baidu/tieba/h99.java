package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.write.write.checkquestion.message.CheckIsQuestionThreadRequestMsg;
import com.baidu.tieba.write.write.checkquestion.message.CheckIsQuestionThreadRespondedMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class h99 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h99 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public b b;
    public final HttpMessageListener c;

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h99 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h99 h99Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h99Var, Integer.valueOf(i)};
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
            this.a = h99Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.a.a = false;
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003544 && (httpResponsedMessage instanceof CheckIsQuestionThreadRespondedMsg)) {
                    if (httpResponsedMessage.getError() != 0) {
                        if (this.a.b != null) {
                            this.a.b.a(false);
                        }
                    } else if (this.a.b != null) {
                        this.a.b.a(((CheckIsQuestionThreadRespondedMsg) httpResponsedMessage).isQuestionThread());
                    }
                } else if (this.a.b != null) {
                    this.a.b.a(false);
                }
            }
        }
    }

    public h99() {
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
        this.a = false;
        this.c = new a(this, CmdConfigHttp.CMD_CHECK_IS_QUESTION_THREAD);
        d();
    }

    public static h99 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d == null) {
                synchronized (h99.class) {
                    if (d == null) {
                        d = new h99();
                    }
                }
            }
            return d;
        }
        return (h99) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.c);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHECK_IS_QUESTION_THREAD, TbConfig.SERVER_ADDRESS + "c/s/checkIsQuestionThread");
            tbHttpMessageTask.setResponsedClass(CheckIsQuestionThreadRespondedMsg.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public void g(String str, String str2, b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048579, this, str, str2, bVar) != null) || this.a) {
            return;
        }
        this.b = bVar;
        this.a = true;
        CheckIsQuestionThreadRequestMsg checkIsQuestionThreadRequestMsg = new CheckIsQuestionThreadRequestMsg(CmdConfigHttp.CMD_CHECK_IS_QUESTION_THREAD);
        checkIsQuestionThreadRequestMsg.addParam(MissonDetailsActivityConfig.THREAD_TITLE, str);
        checkIsQuestionThreadRequestMsg.addParam("thread_content", str2);
        MessageManager.getInstance().sendMessage(checkIsQuestionThreadRequestMsg);
    }
}
