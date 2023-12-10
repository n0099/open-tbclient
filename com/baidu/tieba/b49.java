package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.PicCreateInfoData;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.PicQueryInfoData;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.ku5;
import com.baidu.tieba.uo8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class b49 extends mq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;
    public FastRequest c;
    public FastRequest d;
    public GroupChatFragment e;
    public final ku5 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947595138, "Lcom/baidu/tieba/b49;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947595138, "Lcom/baidu/tieba/b49;");
        }
    }

    @Override // com.baidu.tieba.mq8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pic_gen_commit" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class b extends FastRequest.b<PicQueryInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b49 d;
        public final /* synthetic */ uo8.e e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ ku5.c<Void> g;

        /* loaded from: classes5.dex */
        public static final class a extends TypeToken<AbilityItem> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }
        }

        public b(b49 b49Var, uo8.e eVar, boolean z, ku5.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b49Var, eVar, Boolean.valueOf(z), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = b49Var;
            this.e = eVar;
            this.f = z;
            this.g = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, PicQueryInfoData picQueryInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, picQueryInfoData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, picQueryInfoData);
                this.d.l(R.string.obfuscated_res_0x7f0f0520);
                this.e.onFail();
                this.d.i().h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(PicQueryInfoData result) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                Integer status = result.getStatus();
                if (status != null) {
                    i = status.intValue();
                } else {
                    i = 2;
                }
                String str = null;
                if (i != 1) {
                    if (i == 2) {
                        this.d.l(R.string.obfuscated_res_0x7f0f0520);
                        this.e.onFail();
                        this.d.i().h();
                    } else if (i == 3) {
                        Object abilityItem = result.getAbilityItem();
                        if (abilityItem != null) {
                            str = DataExt.toJson(abilityItem);
                        }
                        Object fromJson = new Gson().fromJson(str, new a().getType());
                        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(str, type)");
                        this.e.a((AbilityItem) fromJson);
                        this.e.onFinish();
                        this.d.i().h();
                    }
                } else if (this.f) {
                    this.d.l(R.string.obfuscated_res_0x7f0f0521);
                    this.e.onFail();
                    this.d.i().h();
                } else {
                    this.g.a(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends FastRequest.b<PicCreateInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uo8.e d;
        public final /* synthetic */ b49 e;

        public a(uo8.e eVar, b49 b49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, b49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = eVar;
            this.e = b49Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, PicCreateInfoData picCreateInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, errMsg, picCreateInfoData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, picCreateInfoData);
                this.e.l(R.string.obfuscated_res_0x7f0f0520);
                this.d.onFail();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.h();
                this.d.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(PicCreateInfoData result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                if (result.getRequestId() == null) {
                    this.e.l(R.string.obfuscated_res_0x7f0f0520);
                    this.d.onFail();
                    return;
                }
                b49 b49Var = this.e;
                String requestId = result.getRequestId();
                Intrinsics.checkNotNull(requestId);
                b49Var.j(requestId, this.d);
            }
        }
    }

    public b49(ChatPage chatPage) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatPage};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(chatPage, "chatPage");
        this.b = chatPage;
        GroupChatFragment K0 = chatPage.K0();
        Intrinsics.checkNotNullExpressionValue(K0, "chatPage.groupChatFragment");
        this.e = K0;
        this.f = new ku5(15, 2000, TimeUnit.MILLISECONDS);
    }

    public final void h(uo8.e eVar) {
        InputDelegate b3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (this.c == null) {
                this.c = new FastRequest(this.e.getPageContext(), CmdConfigHttp.CMD_REQUEST_CREATE_MEME, TbConfig.REQUEST_SPRITE_CREATE_MEME);
            }
            InputToolFragment q3 = this.e.q3();
            String str = (q3 == null || (b3 = q3.b3()) == null || (str = b3.t()) == null) ? "" : "";
            FastRequest fastRequest = this.c;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.P("prompt", str);
            fastRequest.R(new a(eVar, this));
            fastRequest.Q();
        }
    }

    @Override // com.baidu.tieba.mq8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (obj instanceof uo8.e) {
                h((uo8.e) obj);
            }
        }
    }

    public final void j(final String str, final uo8.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, eVar) == null) {
            this.f.i(new ku5.c() { // from class: com.baidu.tieba.z39
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ku5.c
                public final void a(boolean z, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                        b49.k(b49.this, str, eVar, z, (ku5.c) obj);
                    }
                }
            });
        }
    }

    public static final void k(b49 this$0, String requestId, uo8.e callback, boolean z, ku5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{this$0, requestId, callback, Boolean.valueOf(z), cVar}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(requestId, "$requestId");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            if (this$0.d == null) {
                this$0.d = new FastRequest(this$0.e.getPageContext(), CmdConfigHttp.CMD_REQUEST_QUERY_MEME, TbConfig.REQUEST_SPRITE_QUERY_MEME);
            }
            FastRequest fastRequest = this$0.d;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.U(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.P(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, requestId);
            fastRequest.R(new b(this$0, callback, z, cVar));
            fastRequest.Q();
        }
    }

    public final ku5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (ku5) invokeV.objValue;
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b.w1(i);
        }
    }
}
