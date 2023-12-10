package com.baidu.tieba.forum.hybrid.biz;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.bl5;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.common.JSONKt;
import com.baidu.tieba.forum.hybrid.biz.ChatRoomSocketBiz;
import com.baidu.tieba.forum.hybrid.manager.BizBase;
import com.baidu.tieba.forum.hybrid.manager.WrapListener;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.o19;
import com.baidu.tieba.p19;
import com.baidu.tieba.sk7;
import com.baidu.tieba.y49;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/forum/hybrid/biz/ChatRoomSocketBiz;", "Lcom/baidu/tieba/forum/hybrid/manager/BizBase;", "Lcom/baidu/tieba/forum/hybrid/manager/Clean;", "Lcom/baidu/tieba/forum/hybrid/manager/ResumeListener;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;)V", "entranceService", "Lcom/baidu/tieba/immessagecenter/chatgroup/ChatMessageDispatchService;", "mCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/baidu/tieba/immessagecenter/chatgroup/data/ChatRoomInfo;", "mUpdateLatestMsgListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "keyListeners", "", "Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", "()[Lcom/baidu/tieba/forum/hybrid/manager/WrapListener;", MissionEvent.MESSAGE_DESTROY, "", MissionEvent.MESSAGE_PAUSE, "onResume", "reenterChatRoom", "requestChatListData", "data", "", "Companion", "forum_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChatRoomSocketBiz extends BizBase implements sk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p19 f;
    public final ConcurrentHashMap<Long, ChatRoomInfo> g;
    public final CustomMessageListener h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1260429153, "Lcom/baidu/tieba/forum/hybrid/biz/ChatRoomSocketBiz;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1260429153, "Lcom/baidu/tieba/forum/hybrid/biz/ChatRoomSocketBiz;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements bl5 {
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

        @Override // com.baidu.tieba.bl5
        public void a(int i, long j, List<Long> roomIdList, int i2, String errMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), roomIdList, Integer.valueOf(i2), errMsg}) == null) {
                Intrinsics.checkNotNullParameter(roomIdList, "roomIdList");
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                TbLog hybridLog = HybridLog.getInstance();
                hybridLog.i("ChatRoom", "新frs群聊建联结果：" + i2 + WebvttCueParser.CHAR_SPACE + errMsg);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatRoomSocketBiz a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ChatRoomSocketBiz chatRoomSocketBiz) {
            super(2921773);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {chatRoomSocketBiz};
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
            this.a = chatRoomSocketBiz;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921773 && (customResponsedMessage.getData() instanceof y49)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    y49 y49Var = (y49) data;
                    ChatRoomInfo chatRoomInfo = (ChatRoomInfo) this.a.g.get(Long.valueOf(y49Var.b));
                    if (chatRoomInfo != null) {
                        ChatRoomSocketBiz chatRoomSocketBiz = this.a;
                        chatRoomInfo.setUnreadNum(0);
                        JSONObject jSONObject = new JSONObject();
                        JSONKt.c(jSONObject, String.valueOf(y49Var.b), chatRoomInfo.toJSONObject());
                        chatRoomSocketBiz.d().invoke("frsPageNa.chatListData", jSONObject);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.immessagecenter.chatgroup.message.ChatGroupLatestMsgData");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatRoomSocketBiz(TbPageContext<BaseFragmentActivity> pageContext, TbWebView webView) {
        super(pageContext, webView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f = o19.a();
        this.g = new ConcurrentHashMap<>();
        this.h = new b(this);
        p19 p19Var = this.f;
        if (p19Var != null) {
            p19Var.b(pageContext.getPageActivity(), 1);
        }
        p19 p19Var2 = this.f;
        if (p19Var2 != null) {
            p19Var2.d(new p19.a() { // from class: com.baidu.tieba.ok7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.p19.a
                public final void a(Map map) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, map) == null) {
                        ChatRoomSocketBiz.k(ChatRoomSocketBiz.this, map);
                    }
                }
            });
        }
        p19 p19Var3 = this.f;
        if (p19Var3 != null) {
            p19Var3.a(new a());
        }
        pageContext.registerListener(this.h);
    }

    public static final void k(ChatRoomSocketBiz this$0, Map it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "it");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : it.entrySet()) {
                if (entry.getValue() != null) {
                    JSONKt.c(jSONObject, String.valueOf(entry.getKey()), ((ChatRoomInfo) entry.getValue()).toJSONObject());
                }
            }
            this$0.d().invoke("frsPageNa.chatListData", jSONObject);
        }
    }

    public final void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            JSONKt.a(str, new Function1<JSONObject, Unit>(this) { // from class: com.baidu.tieba.forum.hybrid.biz.ChatRoomSocketBiz$requestChatListData$1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ChatRoomSocketBiz this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
                    invoke2(jSONObject);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x0089 A[SYNTHETIC] */
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(JSONObject it) {
                    p19 p19Var;
                    long j;
                    int optInt;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, it) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        long optLong = it.optLong("groupId", 0L);
                        ArrayList arrayList = new ArrayList();
                        JSONArray optJSONArray = it.optJSONArray("roomIds");
                        this.this$0.g.clear();
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                Object item = optJSONArray.opt(i);
                                if (item instanceof Long) {
                                    Intrinsics.checkNotNullExpressionValue(item, "item");
                                    j = ((Number) item).longValue();
                                } else if (item instanceof String) {
                                    Intrinsics.checkNotNullExpressionValue(item, "item");
                                    j = Long.parseLong((String) item);
                                } else if (item instanceof JSONObject) {
                                    JSONObject jSONObject = (JSONObject) item;
                                    long optLong2 = jSONObject.optLong("roomId");
                                    optInt = jSONObject.optInt("unreadNum");
                                    j = optLong2;
                                    if (j == 0) {
                                        ChatRoomInfo chatRoomInfo = new ChatRoomInfo();
                                        chatRoomInfo.setRoomId(j);
                                        chatRoomInfo.setUnreadNum(optInt);
                                        arrayList.add(chatRoomInfo);
                                        this.this$0.g.put(Long.valueOf(j), chatRoomInfo);
                                    }
                                } else {
                                    j = 0;
                                }
                                optInt = 0;
                                if (j == 0) {
                                }
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            HybridLog.getInstance().i("ChatRoom", "新frs群聊开始建联：" + optLong + WebvttCueParser.CHAR_SPACE + arrayList);
                            p19Var = this.this$0.f;
                            if (p19Var != null) {
                                p19Var.c(optLong, arrayList);
                            }
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.rk7
    public WrapListener[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new WrapListener[]{e().invoke("frsPage.startGetChatListData", new ChatRoomSocketBiz$keyListeners$1(this))} : (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sk7
    public void onDestroy() {
        p19 p19Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (p19Var = this.f) != null) {
            p19Var.onDestroy();
        }
    }
}
