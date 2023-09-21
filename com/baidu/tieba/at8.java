package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ce8;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.InputToolFragment;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.PicCreateInfoData;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.data.PicQueryInfoData;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.GroupChatFragment;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.ChatPage;
import com.baidu.tieba.vx5;
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
public final class at8 extends uf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatPage b;
    public FastRequest c;
    public FastRequest d;
    public GroupChatFragment e;
    public final vx5 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947626820, "Lcom/baidu/tieba/at8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947626820, "Lcom/baidu/tieba/at8;");
        }
    }

    @Override // com.baidu.tieba.uf8
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "pic_gen_commit" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static final class b extends FastRequest.b<PicQueryInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at8 c;
        public final /* synthetic */ ce8.e d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ vx5.c<Void> f;

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

        public b(at8 at8Var, ce8.e eVar, boolean z, vx5.c<Void> cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at8Var, eVar, Boolean.valueOf(z), cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = at8Var;
            this.d = eVar;
            this.e = z;
            this.f = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: i */
        public void d(int i, String errMsg, PicQueryInfoData picQueryInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, picQueryInfoData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.d(i, errMsg, picQueryInfoData);
                this.c.l(R.string.obfuscated_res_0x7f0f0510);
                this.d.onFail();
                this.c.i().h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: j */
        public void g(PicQueryInfoData result) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.g(result);
                Integer status = result.getStatus();
                if (status != null) {
                    i = status.intValue();
                } else {
                    i = 2;
                }
                String str = null;
                if (i != 1) {
                    if (i == 2) {
                        this.c.l(R.string.obfuscated_res_0x7f0f0510);
                        this.d.onFail();
                        this.c.i().h();
                    } else if (i == 3) {
                        Object abilityItem = result.getAbilityItem();
                        if (abilityItem != null) {
                            str = DataExt.toJson(abilityItem);
                        }
                        Object fromJson = new Gson().fromJson(str, new a().getType());
                        Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(str, type)");
                        this.d.a((AbilityItem) fromJson);
                        this.d.onFinish();
                        this.c.i().h();
                    }
                } else if (this.e) {
                    this.c.l(R.string.obfuscated_res_0x7f0f0511);
                    this.d.onFail();
                    this.c.i().h();
                } else {
                    this.f.call(false, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class a extends FastRequest.b<PicCreateInfoData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ce8.e c;
        public final /* synthetic */ at8 d;

        public a(ce8.e eVar, at8 at8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, at8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = eVar;
            this.d = at8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: i */
        public void d(int i, String errMsg, PicCreateInfoData picCreateInfoData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, errMsg, picCreateInfoData) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.d(i, errMsg, picCreateInfoData);
                this.d.l(R.string.obfuscated_res_0x7f0f0510);
                this.c.onFail();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.f();
                this.c.onStart();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: j */
        public void g(PicCreateInfoData result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.g(result);
                if (result.getRequestId() == null) {
                    this.d.l(R.string.obfuscated_res_0x7f0f0510);
                    this.c.onFail();
                    return;
                }
                at8 at8Var = this.d;
                String requestId = result.getRequestId();
                Intrinsics.checkNotNull(requestId);
                at8Var.j(requestId, this.c);
            }
        }
    }

    public at8(ChatPage chatPage) {
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
        GroupChatFragment J0 = chatPage.J0();
        Intrinsics.checkNotNullExpressionValue(J0, "chatPage.groupChatFragment");
        this.e = J0;
        this.f = new vx5(15, 2000, TimeUnit.MILLISECONDS);
    }

    public final void h(ce8.e eVar) {
        InputDelegate r2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (this.c == null) {
                this.c = new FastRequest(this.e.getPageContext(), CmdConfigHttp.CMD_REQUEST_CREATE_MEME, TbConfig.REQUEST_SPRITE_CREATE_MEME);
            }
            InputToolFragment M2 = this.e.M2();
            String str = (M2 == null || (r2 = M2.r2()) == null || (str = r2.s()) == null) ? "" : "";
            FastRequest fastRequest = this.c;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.S(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.N("prompt", str);
            fastRequest.P(new a(eVar, this));
            fastRequest.O();
        }
    }

    @Override // com.baidu.tieba.uf8
    public void b(AbilityItem abilityItem, BaseItem<? extends TbBaseMsg> baseItem, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, abilityItem, baseItem, obj) == null) {
            Intrinsics.checkNotNullParameter(abilityItem, "abilityItem");
            if (obj instanceof ce8.e) {
                h((ce8.e) obj);
            }
        }
    }

    public final void j(final String str, final ce8.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, eVar) == null) {
            this.f.i(new vx5.c() { // from class: com.baidu.tieba.ys8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.vx5.c
                public final void call(boolean z, Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, obj) == null) {
                        at8.k(at8.this, str, eVar, z, (vx5.c) obj);
                    }
                }
            });
        }
    }

    public static final void k(at8 this$0, String requestId, ce8.e callback, boolean z, vx5.c cVar) {
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
            fastRequest.S(HttpMessageTask.HTTP_METHOD.POST);
            fastRequest.N(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, requestId);
            fastRequest.P(new b(this$0, callback, z, cVar));
            fastRequest.O();
        }
    }

    public final vx5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (vx5) invokeV.objValue;
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.b.v1(i);
        }
    }
}
