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
import com.baidu.tieba.view.headcard.data.QuizCardRespondedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tbclient.QuizInfo;
/* loaded from: classes5.dex */
public final class a7b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public a b;
    public BdUniqueId c;
    public final b d;

    /* loaded from: classes5.dex */
    public interface a {
        void a(QuizInfo quizInfo, t6b t6bVar);

        void onError(int i, String str);
    }

    /* loaded from: classes5.dex */
    public static final class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a7b a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a7b a7bVar) {
            super(CmdConfigHttp.CMD_HTTP_FORUM_QUIZ_CARD_RESULT);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a7bVar};
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
            this.a = a7bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003579 && (httpResponsedMessage instanceof QuizCardRespondedMessage)) {
                    QuizCardRespondedMessage quizCardRespondedMessage = (QuizCardRespondedMessage) httpResponsedMessage;
                    if (quizCardRespondedMessage.getError() != 0) {
                        a a = this.a.a();
                        if (a != null) {
                            int error = quizCardRespondedMessage.getError();
                            String errorString = quizCardRespondedMessage.getErrorString();
                            Intrinsics.checkNotNullExpressionValue(errorString, "responsedMessage.errorString");
                            a.onError(error, errorString);
                        }
                        TbLog defaultLog = DefaultLog.getInstance();
                        String b = this.a.b();
                        defaultLog.i(b, "请求结束，返回错误，错误码为：" + quizCardRespondedMessage.getError());
                        return;
                    }
                    TbLog defaultLog2 = DefaultLog.getInstance();
                    String b2 = this.a.b();
                    defaultLog2.i(b2, "请求结束，返回数据，quzi：" + quizCardRespondedMessage.getQuizInfo() + "，dialog：" + quizCardRespondedMessage.getDialogData());
                    a a2 = this.a.a();
                    if (a2 != null) {
                        a2.a(quizCardRespondedMessage.getQuizInfo(), quizCardRespondedMessage.getDialogData());
                        return;
                    }
                    return;
                }
                a a3 = this.a.a();
                if (a3 != null) {
                    a3.onError(-1, "");
                }
                DefaultLog.getInstance().i(this.a.b(), "请求结束，数据不合法");
            }
        }
    }

    public a7b() {
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
        this.a = "QuizInfoModel";
        this.d = new b(this);
        e();
    }

    public final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (a) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.d);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdUniqueId bdUniqueId = this.c;
            if (bdUniqueId != null) {
                this.d.setTag(bdUniqueId);
                this.d.setSelfListener(true);
            }
            MessageManager.getInstance().registerListener(this.d);
        }
    }

    public final void c(String quizId, String product, String quizOptionId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, quizId, product, quizOptionId) == null) {
            Intrinsics.checkNotNullParameter(quizId, "quizId");
            Intrinsics.checkNotNullParameter(product, "product");
            Intrinsics.checkNotNullParameter(quizOptionId, "quizOptionId");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_FORUM_QUIZ_CARD_RESULT);
            httpMessage.addParam("quiz_id", quizId);
            httpMessage.addParam("product", product);
            httpMessage.addParam("quiz_option_id", quizOptionId);
            BdUniqueId bdUniqueId = this.c;
            if (bdUniqueId != null) {
                httpMessage.setTag(bdUniqueId);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_FORUM_QUIZ_CARD_RESULT, TbConfig.SERVER_ADDRESS + "c/f/matchActivity/quiz");
            tbHttpMessageTask.setResponsedClass(QuizCardRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void g(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public final void h(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
        }
    }
}
