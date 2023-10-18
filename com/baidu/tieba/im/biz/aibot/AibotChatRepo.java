package com.baidu.tieba.im.biz.aibot;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.ef8;
import com.baidu.tieba.ff8;
import com.baidu.tieba.gf8;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.jf8;
import com.baidu.tieba.pe8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u001fH\u0016J\u0006\u0010&\u001a\u00020\u001fJ\u0014\u0010'\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0(J\u0016\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "botUk", "", "(Lcom/baidu/tbadk/TbPageContext;Ljava/lang/String;)V", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "classMap", "", "", "Ljava/lang/Class;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "context", "Landroid/content/Context;", "internalMsgReceiveListener", "com/baidu/tieba/im/biz/aibot/AibotChatRepo$internalMsgReceiveListener$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo$internalMsgReceiveListener$1;", "msgReceiveListener", "Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "getMsgReceiveListener", "()Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "setMsgReceiveListener", "(Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;)V", "request", "Lcom/baidu/tbadk/net/FastRequest;", "sessionId", "", "fetchMsgs", "", "beginMsgId", "endMsgId", "count", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/im/lib/socket/listener/FetchMsgsCallback;", MissionEvent.MESSAGE_DESTROY, "onRequestDetailSuccess", "requestChatDetail", "Lcom/baidu/tbadk/net/FastRequest$Callback;", "sendMsgWithJson", "json", "Lcom/baidu/tieba/im/lib/socket/listener/SendMsgCallback;", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatRepo extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> j;
    public final String k;
    public final Context l;
    public FastRequest m;
    public AibotChatDetail n;
    public long o;
    public ff8 p;
    public a q;
    public final Map<Integer, Class<? extends TbBaseMsg>> r;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2004076613, "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2004076613, "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements ff8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatRepo a;

        public a(AibotChatRepo aibotChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatRepo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aibotChatRepo;
        }

        @Override // com.baidu.tieba.ff8
        public void a(int i, TreeSet<TbBaseMsg> msgSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, msgSet) == null) {
                Intrinsics.checkNotNullParameter(msgSet, "msgSet");
                ff8 g0 = this.a.g0();
                if (g0 != null) {
                    g0.a(i, msgSet);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends FastRequest.b<AibotChatDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b<AibotChatDetail> d;
        public final /* synthetic */ AibotChatRepo e;

        public b(FastRequest.b<AibotChatDetail> bVar, AibotChatRepo aibotChatRepo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, aibotChatRepo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = bVar;
            this.e = aibotChatRepo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, AibotChatDetail aibotChatDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, errMsg, aibotChatDetail) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, aibotChatDetail);
                this.d.f(i, errMsg, aibotChatDetail);
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.g();
                this.d.g();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.h();
                this.d.h();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(AibotChatDetail result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                this.e.n = result;
                this.e.o = result.getUserInfo().getPaid();
                this.d.i(result);
                this.e.h0();
            }
        }
    }

    public AibotChatRepo(TbPageContext<BaseFragmentActivity> pageContext, String botUk) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, botUk};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(botUk, "botUk");
        this.j = pageContext;
        this.k = botUk;
        Activity pageActivity = pageContext.getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
        this.l = pageActivity;
        this.q = new a(this);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, TbTextMsg.class);
        this.r = linkedHashMap;
    }

    public final void j0(String json, gf8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, json, callback) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Map<String, Object> b2 = jf8.b(DataExt.toMap(json));
            Object obj = b2.get("type");
            if (obj != null) {
                Class<? extends TbBaseMsg> cls = this.r.get(Integer.valueOf((int) ((Long) obj).longValue()));
                Intrinsics.checkNotNull(cls);
                pe8.a.h((TbBaseMsg) DataExt.toEntity(b2, cls), callback);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    public final void f0(long j, long j2, int i, ef8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            pe8.a.b(this.o, j, j2, i, callback);
        }
    }

    public final ff8 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return (ff8) invokeV.objValue;
    }

    public final void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            pe8.a.g(this.o, this.q);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            pe8.a.k(this.o, this.q);
        }
    }

    public final void i0(FastRequest.b<AibotChatDetail> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (this.m == null) {
                this.m = new FastRequest(this.j, CmdConfigHttp.CMD_HTTP_AIBOT_CHAT_DETAIL, TbConfig.GET_AIBOT_CHAT_DETAIL);
            }
            FastRequest fastRequest = this.m;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.O("chat_uk", this.k);
            fastRequest.Q(new b(callback, this));
            fastRequest.P();
        }
    }

    public final void k0(ff8 ff8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ff8Var) == null) {
            this.p = ff8Var;
        }
    }
}
