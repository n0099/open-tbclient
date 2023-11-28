package com.baidu.tieba.im.biz.aibot;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.kv8;
import com.baidu.tieba.lv8;
import com.baidu.tieba.mv8;
import com.baidu.tieba.pv8;
import com.baidu.tieba.rd;
import com.baidu.tieba.vu8;
import com.baidu.tieba.yr8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u0091\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u001f\u0018\u0000 A2\u00020\u0001:\u0001AB7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ&\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u000205J\u001e\u00106\u001a\u0004\u0018\u00010\u001b2\u0006\u00107\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b09J\b\u0010:\u001a\u000200H\u0016J\u0006\u0010;\u001a\u000200J\u0014\u0010<\u001a\u0002002\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110=J\u0016\u0010>\u001a\u0002002\u0006\u0010?\u001a\u00020\u00062\u0006\u00104\u001a\u00020@R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010 R\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "Lcom/baidu/tieba/im/base/core/slice/Slice;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "botUk", "", "fromPage", "fid", "isShowBotList", "", "(Lcom/baidu/tbadk/TbPageContext;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getBotUk", "()Ljava/lang/String;", "setBotUk", "(Ljava/lang/String;)V", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "classMap", "", "", "Ljava/lang/Class;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "context", "Landroid/content/Context;", "firstBotList", "", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$BotList;", "getFirstBotList", "()Ljava/util/List;", "internalMsgReceiveListener", "com/baidu/tieba/im/biz/aibot/AibotChatRepo$internalMsgReceiveListener$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo$internalMsgReceiveListener$1;", "isFirstRequest", "()Z", "setFirstRequest", "(Z)V", "msgReceiveListener", "Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "getMsgReceiveListener", "()Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;", "setMsgReceiveListener", "(Lcom/baidu/tieba/im/lib/socket/listener/MsgReceiveListener;)V", "request", "Lcom/baidu/tbadk/net/FastRequest;", "sessionId", "", "fetchMsgs", "", "beginMsgId", "endMsgId", "count", WebChromeClient.KEY_ARG_CALLBACK, "Lcom/baidu/tieba/im/lib/socket/listener/FetchMsgsCallback;", "findBotDataByUk", "uk", "dataList", "", MissionEvent.MESSAGE_DESTROY, "onRequestDetailSuccess", "requestChatDetail", "Lcom/baidu/tbadk/net/FastRequest$Callback;", "sendMsgWithJson", "json", "Lcom/baidu/tieba/im/lib/socket/listener/SendMsgCallback;", "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatRepo extends Slice {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<BaseFragmentActivity> j;
    public String k;
    public final String l;
    public final String m;
    public final boolean n;
    public final Context o;
    public FastRequest p;
    public AibotChatDetail q;
    public long r;
    public final List<AibotChatDetail.BotList> s;
    public boolean t;
    public lv8 u;
    public a v;
    public final Map<Integer, Class<? extends TbBaseMsg>> w;

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
    public static final class a implements lv8 {
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

        @Override // com.baidu.tieba.lv8
        public void a(int i, TreeSet<TbBaseMsg> msgSet) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, msgSet) == null) {
                Intrinsics.checkNotNullParameter(msgSet, "msgSet");
                lv8 i0 = this.a.i0();
                if (i0 != null) {
                    i0.a(i, msgSet);
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
                this.e.q = result;
                this.e.r = result.getUserInfo().getPaid();
                if (this.e.j0()) {
                    this.e.h0().clear();
                    this.e.h0().addAll(result.getBotList());
                    this.e.o0(false);
                }
                this.d.i(result);
                this.e.k0();
            }
        }
    }

    public AibotChatRepo(TbPageContext<BaseFragmentActivity> pageContext, String botUk, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, botUk, str, str2, Boolean.valueOf(z)};
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
        this.l = str;
        this.m = str2;
        this.n = z;
        Activity pageActivity = pageContext.getPageActivity();
        Intrinsics.checkNotNullExpressionValue(pageActivity, "pageContext.pageActivity");
        this.o = pageActivity;
        this.s = new ArrayList();
        this.t = true;
        this.v = new a(this);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, TbTextMsg.class);
        this.w = linkedHashMap;
    }

    public final void f0(long j, long j2, int i, kv8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), callback}) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            vu8.a.b(this.r, j, j2, i, callback);
        }
    }

    public final AibotChatDetail.BotList g0(String uk, List<AibotChatDetail.BotList> dataList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uk, dataList)) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            for (AibotChatDetail.BotList botList : dataList) {
                if (rd.isEquals(botList.getUk(), uk)) {
                    return botList;
                }
            }
            return null;
        }
        return (AibotChatDetail.BotList) invokeLL.objValue;
    }

    public final List<AibotChatDetail.BotList> h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.s;
        }
        return (List) invokeV.objValue;
    }

    public final lv8 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.u;
        }
        return (lv8) invokeV.objValue;
    }

    public final boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vu8.a.g(this.r, this.v);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.Slice, com.baidu.tieba.im.base.core.slice.ability.LifecycleAbility
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            vu8.a.k(this.r, this.v);
        }
    }

    public final void l0(FastRequest.b<AibotChatDetail> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, callback) == null) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (this.p == null) {
                this.p = new FastRequest(this.j, CmdConfigHttp.CMD_HTTP_AIBOT_CHAT_DETAIL, TbConfig.GET_AIBOT_CHAT_DETAIL);
            }
            FastRequest fastRequest = this.p;
            if (fastRequest != null) {
                fastRequest.P("chat_uk", this.k);
                fastRequest.R(new b(callback, this));
                if (!rd.isEmpty(this.l)) {
                    String str = this.l;
                    Intrinsics.checkNotNull(str);
                    fastRequest.P(GuildActivityConfig.FROM_PAGE, str);
                }
                if (!rd.isEmpty(this.m) && this.n) {
                    String str2 = this.m;
                    Intrinsics.checkNotNull(str2);
                    fastRequest.P("fid", str2);
                    fastRequest.P("recent_bots", yr8.d.a().e(this.m));
                }
                fastRequest.Q();
            }
        }
    }

    public final void m0(String json, mv8 callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, json, callback) == null) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(callback, "callback");
            Map<String, Object> b2 = pv8.b(DataExt.toMap(json));
            Object obj = b2.get("type");
            if (obj != null) {
                Class<? extends TbBaseMsg> cls = this.w.get(Integer.valueOf((int) ((Long) obj).longValue()));
                Intrinsics.checkNotNull(cls);
                vu8.a.h((TbBaseMsg) DataExt.toEntity(b2, cls), callback);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
    }

    public final void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.k = str;
        }
    }

    public final void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.t = z;
        }
    }

    public final void p0(lv8 lv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, lv8Var) == null) {
            this.u = lv8Var;
        }
    }
}
