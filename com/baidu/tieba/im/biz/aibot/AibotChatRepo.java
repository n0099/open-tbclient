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
import com.baidu.tieba.ah8;
import com.baidu.tieba.eh8;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.kg8;
import com.baidu.tieba.yg8;
import com.baidu.tieba.zg8;
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
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0012\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020$J\b\u0010%\u001a\u00020\u001fH\u0016J\u0006\u0010&\u001a\u00020\u001fJ\u0014\u0010'\u001a\u00020\u001f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0(J\u0016\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "Lcom/baidu/tieba/immessagecenter/slice/Slice;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "botUk", "", "(Lcom/baidu/tbadk/TbPageContext;Ljava/lang/String;)V", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "classMap", "", "", "Ljava/lang/Class;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "context", "Landroid/content/Context;", "internalMsgReceiveListener", "com/baidu/tieba/im/biz/aibot/AibotChatRepo$internalMsgReceiveListener$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo$internalMsgReceiveListener$1;", "msgReceiveListener", "Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "getMsgReceiveListener", "()Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "setMsgReceiveListener", "(Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;)V", "request", "Lcom/baidu/tbadk/net/FastRequest;", "sessionId", "", "fetchMsgs", "", "beginMsgId", "endMsgId", "count", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/im/lib/socket/listener/FetchMsgsCallback;", MissionEvent.MESSAGE_DESTROY, "onRequestDetailSuccess", "requestChatDetail", "Lcom/baidu/tbadk/net/FastRequest$Callback;", "sendMsgWithJson", "json", "Lcom/baidu/tieba/im/lib/socket/listener/SendMsgCallback;", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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
    public zg8 p;
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
    public static final class a implements zg8 {
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

        @Override // com.baidu.tieba.zg8
        public void a(int i, TreeSet<TbBaseMsg> msgSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, msgSet) == null) {
                Intrinsics.checkNotNullParameter(msgSet, "msgSet");
                zg8 d0 = this.a.d0();
                if (d0 != null) {
                    d0.a(i, msgSet);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends FastRequest.b<AibotChatDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FastRequest.b<AibotChatDetail> b;
        public final /* synthetic */ AibotChatRepo c;

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
            this.b = bVar;
            this.c = aibotChatRepo;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void b(int i, String errMsg, AibotChatDetail aibotChatDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048580, this, i, errMsg, aibotChatDetail) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, aibotChatDetail);
                this.b.b(i, errMsg, aibotChatDetail);
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.d();
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                super.e();
                this.b.e();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(AibotChatDetail result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.f(result);
                this.c.n = result;
                this.c.o = result.getUserInfo().getPaid();
                this.b.f(result);
                this.c.e0();
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

    public final void g0(String json, ah8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, json, callback) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Map<String, Object> b2 = eh8.b(DataExt.toMap(json));
            Object obj = b2.get("type");
            if (obj != null) {
                Class<? extends TbBaseMsg> cls = this.r.get(Integer.valueOf((int) ((Long) obj).longValue()));
                Intrinsics.checkNotNull(cls);
                kg8.a.g((TbBaseMsg) DataExt.toEntity(b2, cls), callback);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    public final void c0(long j, long j2, int i, yg8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            kg8.a.b(this.o, j, j2, i, callback);
        }
    }

    public final zg8 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p;
        }
        return (zg8) invokeV.objValue;
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            kg8.a.f(this.o, this.q);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.Slice, com.baidu.tieba.immessagecenter.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDestroy();
            kg8.a.j(this.o, this.q);
        }
    }

    public final void f0(FastRequest.b<AibotChatDetail> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (this.m == null) {
                this.m = new FastRequest(this.j, CmdConfigHttp.CMD_HTTP_AIBOT_CHAT_DETAIL, TbConfig.GET_AIBOT_CHAT_DETAIL);
            }
            FastRequest fastRequest = this.m;
            Intrinsics.checkNotNull(fastRequest);
            fastRequest.N("chat_uk", this.k);
            fastRequest.P(new b(callback, this));
            fastRequest.O();
        }
    }

    public final void h0(zg8 zg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zg8Var) == null) {
            this.p = zg8Var;
        }
    }
}
