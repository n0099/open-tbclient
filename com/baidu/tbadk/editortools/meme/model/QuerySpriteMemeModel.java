package com.baidu.tbadk.editortools.meme.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.editortools.meme.model.QuerySpriteMemeModel;
import com.baidu.tbadk.editortools.meme.model.QuerySpriteMemeModel$spriteMemeQueryListener$2;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.xf5;
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
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\"\u0018\u00002\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J\u0006\u00100\u001a\u00020.J\u0006\u00101\u001a\u00020.J\b\u00102\u001a\u00020.H\u0002J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020.H\u0002J\b\u00105\u001a\u00020.H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u001d\u001a\u00020\nX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\n )*\u0004\u0018\u00010(0(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000e¨\u00067"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel;", "", "()V", "forumId", "", "getForumId", "()J", "setForumId", "(J)V", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "", "getForumName", "()Ljava/lang/String;", "setForumName", "(Ljava/lang/String;)V", "memeId", "getMemeId", "setMemeId", "pn", "", "query", "getQuery", "setQuery", "queryCallback", "Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel$QueryCallback;", "getQueryCallback", "()Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel$QueryCallback;", "setQueryCallback", "(Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel$QueryCallback;)V", "scene", "getScene$annotations", "getScene", "setScene", "spriteMemeQueryListener", "com/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel$spriteMemeQueryListener$2$1", "getSpriteMemeQueryListener", "()Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel$spriteMemeQueryListener$2$1;", "spriteMemeQueryListener$delegate", "Lkotlin/Lazy;", "tag", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "tid", "getTid", "setTid", "cancelRequest", "", "firstRequest", MissionEvent.MESSAGE_DESTROY, "refreshNext", "registerHttpTask", "registerListener", "requestData", "unRegisterTaskAndListener", "QueryCallback", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuerySpriteMemeModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public long b;
    public String c;
    public int d;
    public long e;
    public String f;
    public a g;
    public final Lazy h;

    /* loaded from: classes5.dex */
    public interface a {
        void a(xf5 xf5Var, String str);

        void onError();
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
        }
    }

    public final void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
        }
    }

    public QuerySpriteMemeModel() {
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
        this.c = "";
        this.d = 1;
        this.f = "";
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<QuerySpriteMemeModel$spriteMemeQueryListener$2.a>(this) { // from class: com.baidu.tbadk.editortools.meme.model.QuerySpriteMemeModel$spriteMemeQueryListener$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ QuerySpriteMemeModel this$0;

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

            /* loaded from: classes5.dex */
            public static final class a extends HttpMessageListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ QuerySpriteMemeModel a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public a(QuerySpriteMemeModel querySpriteMemeModel) {
                    super(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_QUERY);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {querySpriteMemeModel};
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
                    this.a = querySpriteMemeModel;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    Unit unit;
                    Message<?> orginalMessage;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                        String str = "";
                        if (httpResponsedMessage != null && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage instanceof HttpMessage)) {
                            Object obj = ((HttpMessage) orginalMessage).getParams().get("query");
                            if (obj instanceof String) {
                                str = obj;
                            }
                        }
                        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003582 && (httpResponsedMessage instanceof SpriteMemeQueryRespondedMessage)) {
                            SpriteMemeQueryRespondedMessage spriteMemeQueryRespondedMessage = (SpriteMemeQueryRespondedMessage) httpResponsedMessage;
                            if (spriteMemeQueryRespondedMessage.getError() != 0) {
                                TbLog defaultLog = DefaultLog.getInstance();
                                defaultLog.i("sprite_meme_query_tag", "请求结束，返回错误。错误码为：" + spriteMemeQueryRespondedMessage.getError());
                                QuerySpriteMemeModel.a d = this.a.d();
                                if (d != null) {
                                    d.onError();
                                    return;
                                }
                                return;
                            }
                            xf5 spriteMemeQueryData = spriteMemeQueryRespondedMessage.getSpriteMemeQueryData();
                            if (spriteMemeQueryData != null) {
                                QuerySpriteMemeModel querySpriteMemeModel = this.a;
                                DefaultLog.getInstance().i("sprite_meme_query_tag", "请求结束，有返回数据");
                                QuerySpriteMemeModel.a d2 = querySpriteMemeModel.d();
                                if (d2 != null) {
                                    d2.a(spriteMemeQueryData, str);
                                    unit = Unit.INSTANCE;
                                } else {
                                    unit = null;
                                }
                                if (unit != null) {
                                    return;
                                }
                            }
                            QuerySpriteMemeModel querySpriteMemeModel2 = this.a;
                            DefaultLog.getInstance().i("sprite_meme_query_tag", "请求结束，返回数据为空");
                            QuerySpriteMemeModel.a d3 = querySpriteMemeModel2.d();
                            if (d3 != null) {
                                d3.onError();
                                Unit unit2 = Unit.INSTANCE;
                                return;
                            }
                            return;
                        }
                        DefaultLog.getInstance().i("sprite_meme_query_tag", "请求结束，数据不合法");
                        QuerySpriteMemeModel.a d4 = this.a.d();
                        if (d4 != null) {
                            d4.onError();
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
        g();
        h();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_QUERY, TbConfig.SERVER_ADDRESS + "c/f/sprite/queryMeme");
            tbHttpMessageTask.setResponsedClass(SpriteMemeQueryRespondedMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e().setTag(null);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = 1;
            i();
        }
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (a) invokeV.objValue;
    }

    public final QuerySpriteMemeModel$spriteMemeQueryListener$2.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (QuerySpriteMemeModel$spriteMemeQueryListener$2.a) this.h.getValue();
        }
        return (QuerySpriteMemeModel$spriteMemeQueryListener$2.a) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.d++;
            i();
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            e().setSelfListener(true);
            e().setTag(this.a);
            MessageManager.getInstance().registerListener(e());
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_HTTP_SPRITE_MEME_QUERY);
            this.a = BdUniqueId.gen();
            e().setTag(this.a);
            httpMessage.setTag(this.a);
            httpMessage.addParam("query", this.c);
            httpMessage.addParam("scene", this.f);
            httpMessage.addParam("forum_id", this.b);
            httpMessage.addParam("pn", this.d);
            if (Intrinsics.areEqual("use_same", this.f)) {
                httpMessage.addParam(EmotionUbcHelper.MEME_ID, this.e);
            }
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.b = j;
        }
    }

    public final void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.e = j;
        }
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.c = str;
        }
    }

    public final void n(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.f = str;
        }
    }
}
