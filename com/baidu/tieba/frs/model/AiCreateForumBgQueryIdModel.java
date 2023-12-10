package com.baidu.tieba.frs.model;

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
import com.baidu.tieba.frs.model.AiCreateForumBgQueryIdModel;
import com.baidu.tieba.frs.model.AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2;
import com.baidu.tieba.l28;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\n\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J&\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0013H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel;", "", "()V", "queryCallback", "Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel$QueryCallback;", "getQueryCallback", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel$QueryCallback;", "setQueryCallback", "(Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel$QueryCallback;)V", "submitTextForAIPicQueryListener", "com/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2$1", "getSubmitTextForAIPicQueryListener", "()Lcom/baidu/tieba/frs/model/AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2$1;", "submitTextForAIPicQueryListener$delegate", "Lkotlin/Lazy;", "tag", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "destroy", "", "registerHttpTask", "registerListener", "requestData", "style", "", "prompt", "styleName", "fid", "", "unRegisterTaskAndListener", "QueryCallback", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AiCreateForumBgQueryIdModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public a b;
    public final Lazy c;

    /* loaded from: classes6.dex */
    public interface a {
        void a(l28 l28Var);

        void onError();
    }

    public AiCreateForumBgQueryIdModel() {
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
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2.a>(this) { // from class: com.baidu.tieba.frs.model.AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AiCreateForumBgQueryIdModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes6.dex */
            public static final class a extends HttpMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AiCreateForumBgQueryIdModel a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(AiCreateForumBgQueryIdModel aiCreateForumBgQueryIdModel) {
                    super(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_QUERY_ID_MESSAGE);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aiCreateForumBgQueryIdModel};
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
                    this.a = aiCreateForumBgQueryIdModel;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    Unit unit;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003585 && (httpResponsedMessage instanceof AiCreateForumBgQueryIdRespondedMessage)) {
                            AiCreateForumBgQueryIdRespondedMessage aiCreateForumBgQueryIdRespondedMessage = (AiCreateForumBgQueryIdRespondedMessage) httpResponsedMessage;
                            if (aiCreateForumBgQueryIdRespondedMessage.getError() != 0) {
                                TbLog defaultLog = DefaultLog.getInstance();
                                defaultLog.i("AiCreateForumBgQueryIdModel", "请求结束，返回错误。错误码为：" + aiCreateForumBgQueryIdRespondedMessage.getError());
                                AiCreateForumBgQueryIdModel.a a = this.a.a();
                                if (a != null) {
                                    a.onError();
                                    return;
                                }
                                return;
                            }
                            l28 queryIdData = aiCreateForumBgQueryIdRespondedMessage.getQueryIdData();
                            if (queryIdData != null) {
                                AiCreateForumBgQueryIdModel aiCreateForumBgQueryIdModel = this.a;
                                DefaultLog.getInstance().i("AiCreateForumBgQueryIdModel", "请求结束，有返回数据");
                                AiCreateForumBgQueryIdModel.a a2 = aiCreateForumBgQueryIdModel.a();
                                if (a2 != null) {
                                    a2.a(queryIdData);
                                    unit = Unit.INSTANCE;
                                } else {
                                    unit = null;
                                }
                                if (unit != null) {
                                    return;
                                }
                            }
                            AiCreateForumBgQueryIdModel aiCreateForumBgQueryIdModel2 = this.a;
                            DefaultLog.getInstance().i("AiCreateForumBgQueryIdModel", "请求结束，返回数据为空");
                            AiCreateForumBgQueryIdModel.a a3 = aiCreateForumBgQueryIdModel2.a();
                            if (a3 != null) {
                                a3.onError();
                                Unit unit2 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        DefaultLog.getInstance().i("AiCreateForumBgQueryIdModel", "请求结束，数据不合法");
                        AiCreateForumBgQueryIdModel.a a4 = this.a.a();
                        if (a4 != null) {
                            a4.onError();
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
        c();
        d();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_QUERY_ID_MESSAGE, TbConfig.SERVER_ADDRESS + "c/f/forum/submitTextForAIPic");
            tbHttpMessageTask.setResponsedClass(AiCreateForumBgQueryIdRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (a) invokeV.objValue;
    }

    public final AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2.a) this.c.getValue();
        }
        return (AiCreateForumBgQueryIdModel$submitTextForAIPicQueryListener$2.a) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b().setSelfListener(true);
            b().setTag(this.a);
            MessageManager.getInstance().registerListener(b());
        }
    }

    public final void e(String style, String prompt, String styleName, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048580, this, style, prompt, styleName, i) == null) {
            Intrinsics.checkNotNullParameter(style, "style");
            Intrinsics.checkNotNullParameter(prompt, "prompt");
            Intrinsics.checkNotNullParameter(styleName, "styleName");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_AI_CREATE_FORUM_BG_QUERY_ID_MESSAGE);
            b().setTag(this.a);
            httpMessage.setTag(this.a);
            httpMessage.addParam("style", style);
            httpMessage.addParam("prompt", prompt);
            httpMessage.addParam("name", styleName);
            httpMessage.addParam("forum_id", i);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.b = aVar;
        }
    }
}
