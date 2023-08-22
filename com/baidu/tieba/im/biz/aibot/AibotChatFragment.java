package com.baidu.tieba.im.biz.aibot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.bc8;
import com.baidu.tieba.cg8;
import com.baidu.tieba.dn5;
import com.baidu.tieba.ew5;
import com.baidu.tieba.hc8;
import com.baidu.tieba.im.biz.aibot.AibotChatFragment;
import com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice;
import com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotArgs;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.biz.aibot.inputslice.InputSlice;
import com.baidu.tieba.im.biz.aibot.navbarslice.NavBarSlice;
import com.baidu.tieba.im.biz.aibot.sugslice.AibotSugHandler;
import com.baidu.tieba.im.biz.aibot.sugslice.AibotSugSlice;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.service.MessageCenterAIBotService;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.impersonal.databinding.FragmentAibotChatBinding;
import com.baidu.tieba.kc8;
import com.baidu.tieba.lg;
import com.baidu.tieba.nb8;
import com.baidu.tieba.o10;
import com.baidu.tieba.rb8;
import com.baidu.tieba.sb8;
import com.baidu.tieba.vb8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wf8;
import com.baidu.tieba.xf8;
import com.baidu.tieba.yb8;
import com.baidu.tieba.yf8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0003\u0013\u0016\u001f\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001RB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\u0018\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J\u0012\u00105\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\u0012\u00108\u001a\u00020.2\b\u00106\u001a\u0004\u0018\u000107H\u0016J$\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010>2\b\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u0010?\u001a\u00020.H\u0016J\b\u0010@\u001a\u00020.H\u0014J\b\u0010A\u001a\u00020.H\u0016J\b\u0010B\u001a\u00020.H\u0016J\b\u0010C\u001a\u00020.H\u0002J\u0010\u0010D\u001a\u00020.2\u0006\u0010E\u001a\u00020\rH\u0016J\u000e\u0010F\u001a\u00020.2\u0006\u0010G\u001a\u00020\rJ\u0018\u0010H\u001a\u00020.2\u0006\u0010I\u001a\u0002022\u0006\u0010J\u001a\u00020\rH\u0002J\b\u0010K\u001a\u00020.H\u0002J\u0018\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020\r2\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020OH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment;", "Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;", "()V", "aibotSugSlice", "Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;", "argsData", "Lcom/baidu/tieba/im/biz/aibot/data/AibotArgs;", "bgSlice", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "binding", "Lcom/baidu/tieba/impersonal/databinding/FragmentAibotChatBinding;", "botUk", "", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "chatSlice", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;", "fetchMsgsCallback", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$fetchMsgsCallback$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$fetchMsgsCallback$1;", "getDetailCallback", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$getDetailCallback$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$getDetailCallback$1;", "mInputSlice", "Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice;", "mKeyboardHeightCallback", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "mMsgJsBridgeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "msgReciveListener", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$msgReciveListener$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$msgReciveListener$1;", "navBarSlice", "Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;", "paid", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "getProcessor", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "processor$delegate", "Lkotlin/Lazy;", "repo", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "uid", "hideLoading", "", "initInputSlice", "notifyBottomHeightChange", "totalHeight", "", "duration", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onNetRefreshButtonClicked", MissionEvent.MESSAGE_PAUSE, "onResume", "registerProcessorHandler", "sendMsg", RemoteMessageConst.MessageBody.MSG_CONTENT, "sendTextMsg", "content", "showError", "errno", StatConstants.KEY_EXT_ERR_MSG, "showLoading", "showTopToast", "showText", "status", "", "sugHeightUpdateNotifyChatList", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatFragment extends SliceFragment implements rb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String e;
    public String f;
    public String g;
    public AibotArgs h;
    public FragmentAibotChatBinding i;
    public InputSlice j;
    public BackgroundSlice k;
    public NavBarSlice l;
    public AibotChatRepo m;
    public ChatSlice n;
    public AibotSugSlice o;
    public final Lazy p;
    public AibotChatDetail q;
    public final CustomMessageListener r;
    public final e s;
    public final a t;
    public final b u;
    public final hc8 v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1561730147, "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1561730147, "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment;");
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements wf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        public a(AibotChatFragment aibotChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aibotChatFragment;
        }

        @Override // com.baidu.tieba.wf8
        public void a(int i, String errMsg, TreeSet<TbBaseMsg> fetchedMsgs) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errMsg, fetchedMsgs) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(fetchedMsgs, "fetchedMsgs");
                if (i == 0) {
                    yb8 yb8Var = yb8.a;
                    AibotChatDetail aibotChatDetail = this.a.q;
                    ChatSlice chatSlice = null;
                    if (aibotChatDetail == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                        aibotChatDetail = null;
                    }
                    HashMap<String, Object> b = yb8Var.b(fetchedMsgs, aibotChatDetail.getUserInfo().getPaid());
                    ChatSlice chatSlice2 = this.a.n;
                    if (chatSlice2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    } else {
                        chatSlice = chatSlice2;
                    }
                    chatSlice.e0().a("fetchHistoryMsgs", b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends FastRequest.b<AibotChatDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment b;

        public b(AibotChatFragment aibotChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aibotChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: f */
        public void b(int i, String errMsg, AibotChatDetail aibotChatDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, errMsg, aibotChatDetail) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, aibotChatDetail);
                this.b.r2(i, errMsg);
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.d();
                this.b.s2();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: g */
        public void e(AibotChatDetail result) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.e(result);
                sb8.a.a("getDetailCallback onSuccess 开始", result);
                this.b.q = result;
                BackgroundSlice backgroundSlice = this.b.k;
                String str = null;
                if (backgroundSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                    backgroundSlice = null;
                }
                backgroundSlice.Z(result.getConfigData().getChatBackground());
                ChatSlice chatSlice = this.b.n;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                chatSlice.j0(result);
                List<AbilityItem> defaultSug = result.getDefaultSug();
                if (defaultSug != null && !defaultSug.isEmpty()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    AibotSugSlice aibotSugSlice = this.b.o;
                    if (aibotSugSlice == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                        aibotSugSlice = null;
                    }
                    aibotSugSlice.e0(result.getDefaultSug());
                }
                InputSlice inputSlice = this.b.j;
                if (inputSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
                    inputSlice = null;
                }
                inputSlice.m2(result);
                ChatStatusManager inst = ChatStatusManager.getInst();
                String str2 = this.b.g;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uid");
                } else {
                    str = str2;
                }
                inst.setCurId(0, str);
                this.b.hideLoading();
                sb8.a.a("getDetailCallback onSuccess 结束", result);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements hc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        public c(AibotChatFragment aibotChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aibotChatFragment;
        }

        @Override // com.baidu.tieba.hc8
        public void a(String text) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, text) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                FragmentAibotChatBinding fragmentAibotChatBinding = this.a.i;
                if (fragmentAibotChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentAibotChatBinding = null;
                }
                fragmentAibotChatBinding.f.setVisibility(8);
                this.a.T(text);
            }
        }

        @Override // com.baidu.tieba.hc8
        public void b(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) != null) {
                return;
            }
            this.a.o2(i, f);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AibotChatFragment aibotChatFragment) {
            super(0);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
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
            this.a = aibotChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof JSONObject)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    JSONObject jSONObject = (JSONObject) data;
                    String optString = jSONObject.optString("chatType");
                    long optLong = jSONObject.optLong("chatId", 0L);
                    if (Intrinsics.areEqual("AISingleChat", optString)) {
                        AibotChatDetail aibotChatDetail = this.a.q;
                        AibotChatRepo aibotChatRepo = null;
                        if (aibotChatDetail == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                            aibotChatDetail = null;
                        }
                        if (aibotChatDetail.getUserInfo().getPaid() == optLong) {
                            if (customResponsedMessage.getCmd() == 2921816) {
                                AibotChatFragment aibotChatFragment = this.a;
                                String optString2 = jSONObject.optString("msg");
                                Intrinsics.checkNotNullExpressionValue(optString2, "params.optString(\"msg\")");
                                aibotChatFragment.q2(optString2);
                                return;
                            } else if (customResponsedMessage.getCmd() == 2921817) {
                                yb8 yb8Var = yb8.a;
                                AibotChatRepo aibotChatRepo2 = this.a.m;
                                if (aibotChatRepo2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                                } else {
                                    aibotChatRepo = aibotChatRepo2;
                                }
                                Object data2 = customResponsedMessage.getData();
                                if (data2 != null) {
                                    yb8Var.a(aibotChatRepo, (JSONObject) data2, this.a.t);
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements xf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        public e(AibotChatFragment aibotChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aibotChatFragment;
        }

        public static final void b(AibotChatFragment this$0, TbBaseMsg tbBaseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, this$0, tbBaseMsg) == null) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                AibotSugSlice aibotSugSlice = this$0.o;
                if (aibotSugSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                    aibotSugSlice = null;
                }
                List<AbilityItem> abilityItems = tbBaseMsg.getAbilityItems();
                Intrinsics.checkNotNull(abilityItems);
                aibotSugSlice.e0(abilityItems);
                this$0.t2(true);
            }
        }

        @Override // com.baidu.tieba.xf8
        public void a(int i, TreeSet<TbBaseMsg> msgSet) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, msgSet) == null) {
                Intrinsics.checkNotNullParameter(msgSet, "msgSet");
                yb8 yb8Var = yb8.a;
                AibotChatDetail aibotChatDetail = this.a.q;
                ChatSlice chatSlice = null;
                if (aibotChatDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                    aibotChatDetail = null;
                }
                HashMap<String, Object> b = yb8Var.b(msgSet, aibotChatDetail.getUserInfo().getPaid());
                ChatSlice chatSlice2 = this.a.n;
                if (chatSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                } else {
                    chatSlice = chatSlice2;
                }
                chatSlice.e0().a("receiveNewMsgs", b);
                Iterator<TbBaseMsg> descendingIterator = msgSet.descendingIterator();
                while (descendingIterator.hasNext()) {
                    final TbBaseMsg next = descendingIterator.next();
                    List<AbilityItem> abilityItems = next.getAbilityItems();
                    if (abilityItems != null && !abilityItems.isEmpty()) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (!z) {
                        final AibotChatFragment aibotChatFragment = this.a;
                        lg.g(new Runnable() { // from class: com.baidu.tieba.pb8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    AibotChatFragment.e.b(AibotChatFragment.this, next);
                                }
                            }
                        });
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements yf8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        public f(AibotChatFragment aibotChatFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aibotChatFragment;
        }

        @Override // com.baidu.tieba.yf8
        public void a(int i, String errMsg, TbBaseMsg tbMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errMsg, tbMsg) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("sendStatus", Integer.valueOf(i));
                String a = o10.a(DataExt.toJson(cg8.c(tbMsg, false)));
                Intrinsics.checkNotNullExpressionValue(a, "getEncodeValue(tbMsg.toF…essedMap(false).toJson())");
                hashMap.put("msg", a);
                ChatSlice chatSlice = this.a.n;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                chatSlice.e0().a("sendMsg", hashMap);
                sb8.a.a("sendTextMsg onResult", hashMap);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AibotChatFragment() {
        super(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Slice) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.p = LazyKt__LazyJVMKt.lazy(AibotChatFragment$processor$2.INSTANCE);
        this.r = new d(this);
        this.s = new e(this);
        this.t = new a(this);
        this.u = new b(this);
        this.v = new c(this);
    }

    public final void t2(final boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048592, this, z) == null) && kc8.p) {
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            fragmentAibotChatBinding.f.post(new Runnable() { // from class: com.baidu.tieba.qb8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AibotChatFragment.u2(z, this);
                    }
                }
            });
        }
    }

    public static final void u2(boolean z, AibotChatFragment this$0) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65553, null, z, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z) {
                FragmentAibotChatBinding fragmentAibotChatBinding = this$0.i;
                if (fragmentAibotChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentAibotChatBinding = null;
                }
                i = fragmentAibotChatBinding.f.getHeight();
            } else {
                i = 0;
            }
            kc8.q = i;
            this$0.o2(kc8.l + kc8.r, 0.1f);
        }
    }

    @Override // com.baidu.tieba.rb8
    public void y(String showText, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, showText, z) == null) {
            Intrinsics.checkNotNullParameter(showText, "showText");
            if (getContext() != null && getView() != null) {
                BdTopToast icon = new BdTopToast(getContext()).setContent(showText).setIcon(z);
                View view2 = getView();
                if (view2 != null) {
                    icon.show((ViewGroup) view2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    @Override // com.baidu.tieba.rb8
    public void T(String msgContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, msgContent) == null) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            sb8.a.a("sendMsg", msgContent);
            AibotSugSlice aibotSugSlice = this.o;
            ChatSlice chatSlice = null;
            if (aibotSugSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                aibotSugSlice = null;
            }
            aibotSugSlice.d0();
            t2(false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", msgContent);
            ChatSlice chatSlice2 = this.n;
            if (chatSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
            } else {
                chatSlice = chatSlice2;
            }
            bc8 e0 = chatSlice.e0();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "msg.toString()");
            e0.c("aiChatInputMsg", jSONObject2);
        }
    }

    public final void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            NavBarSlice navBarSlice = null;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            fragmentAibotChatBinding.b.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
            NavBarSlice navBarSlice2 = this.l;
            if (navBarSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBarSlice");
            } else {
                navBarSlice = navBarSlice2;
            }
            navBarSlice.Z();
        }
    }

    public final nb8 m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (nb8) this.p.getValue();
        }
        return (nb8) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            sb8.a.a(MissionEvent.MESSAGE_DESTROY);
            kc8.q = 0;
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onNetRefreshButtonClicked();
            sb8.a.a("onNetRefreshButtonClicked");
            AibotChatRepo aibotChatRepo = this.m;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            aibotChatRepo.d0(this.u);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            sb8.a.a(MissionEvent.MESSAGE_PAUSE);
            ChatStatusManager.getInst().setIsOpen(0, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            sb8.a.a("onResume");
            ChatStatusManager.getInst().setIsOpen(0, true);
        }
    }

    public final void p2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            m2().a(new AibotSugHandler(this));
            m2().a(new vb8(this));
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            InputSlice inputSlice = null;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            RelativeLayout root = fragmentAibotChatBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            FragmentAibotChatBinding fragmentAibotChatBinding2 = this.i;
            if (fragmentAibotChatBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding2 = null;
            }
            LinearLayout linearLayout = fragmentAibotChatBinding2.b;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomView");
            String str = this.g;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uid");
                str = null;
            }
            InputSlice inputSlice2 = new InputSlice(root, linearLayout, str);
            this.j = inputSlice2;
            if (inputSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
                inputSlice2 = null;
            }
            inputSlice2.p2(this.v);
            FragmentManager childFragmentManager = getChildFragmentManager();
            InputSlice inputSlice3 = this.j;
            if (inputSlice3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
            } else {
                inputSlice = inputSlice3;
            }
            ew5.a(childFragmentManager, R.id.obfuscated_res_0x7f091141, inputSlice);
        }
    }

    public final void s2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            hideNetRefreshView(getView());
            NavBarSlice navBarSlice = null;
            this.mRefreshView = null;
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            fragmentAibotChatBinding.b.setVisibility(4);
            NavBarSlice navBarSlice2 = this.l;
            if (navBarSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBarSlice");
            } else {
                navBarSlice = navBarSlice2;
            }
            navBarSlice.a0();
            showLoadingView(getView());
            LoadingView loadingView = this.loadingView;
            if (loadingView != null) {
                loadingView.getAttachedView().setClickable(false);
                this.loadingView.cancelCenterVertical();
                this.loadingView.setLayoutMarginWithHeaderHeightAndPercent(0, 0.4f);
            }
        }
    }

    public final void o2(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("height", Integer.valueOf(i));
            hashMap.put("animationDuration", Float.valueOf(f2));
            ChatSlice chatSlice = this.n;
            if (chatSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                chatSlice = null;
            }
            chatSlice.e0().a("keyboardHeightChange", hashMap);
            sb8.a.a("heightChange", hashMap);
        }
    }

    public final void r2(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i, str) == null) {
            sb8.a.a("showError", Integer.valueOf(i), str);
            hideLoadingView(getView());
            this.loadingView = null;
            if (i == 2930005) {
                showNetRefreshViewNoClickWithTitle(getView(), str, false);
            } else {
                showNetRefreshView(getView(), null, false);
            }
            dn5 dn5Var = this.mRefreshView;
            if (dn5Var != null) {
                dn5Var.getAttachedView().setClickable(false);
                this.mRefreshView.k(UtilHelper.getStatusBarHeight());
                this.mRefreshView.e(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String backgroundUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onActivityCreated(bundle);
            sb8.a.a("onActivityCreated 开始");
            NavBarSlice navBarSlice = new NavBarSlice();
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            FragmentAibotChatBinding fragmentAibotChatBinding2 = null;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            ViewGroup viewGroup = fragmentAibotChatBinding.e;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "binding.navbarSlice");
            U1(viewGroup, navBarSlice);
            this.l = navBarSlice;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            String str = this.e;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str = null;
            }
            AibotChatRepo aibotChatRepo = new AibotChatRepo(pageContext, str);
            FragmentAibotChatBinding fragmentAibotChatBinding3 = this.i;
            if (fragmentAibotChatBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding3 = null;
            }
            ViewGroup root = fragmentAibotChatBinding3.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            U1(root, aibotChatRepo);
            aibotChatRepo.d0(this.u);
            aibotChatRepo.f0(this.s);
            this.m = aibotChatRepo;
            FragmentAibotChatBinding fragmentAibotChatBinding4 = this.i;
            if (fragmentAibotChatBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding4 = null;
            }
            RelativeLayout relativeLayout = fragmentAibotChatBinding4.g;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.wallBackground");
            BackgroundSlice backgroundSlice = new BackgroundSlice(relativeLayout);
            FragmentAibotChatBinding fragmentAibotChatBinding5 = this.i;
            if (fragmentAibotChatBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding5 = null;
            }
            ViewGroup root2 = fragmentAibotChatBinding5.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
            U1(root2, backgroundSlice);
            this.k = backgroundSlice;
            AibotArgs aibotArgs = this.h;
            if (aibotArgs != null && (backgroundUrl = aibotArgs.getBackgroundUrl()) != null) {
                BackgroundSlice backgroundSlice2 = this.k;
                if (backgroundSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                    backgroundSlice2 = null;
                }
                backgroundSlice2.Z(backgroundUrl);
            }
            String str2 = this.e;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str2 = null;
            }
            AibotChatRepo aibotChatRepo2 = this.m;
            if (aibotChatRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo2 = null;
            }
            ChatSlice chatSlice = new ChatSlice(str2, aibotChatRepo2, this.h);
            FragmentAibotChatBinding fragmentAibotChatBinding6 = this.i;
            if (fragmentAibotChatBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding6 = null;
            }
            ViewGroup viewGroup2 = fragmentAibotChatBinding6.c;
            Intrinsics.checkNotNullExpressionValue(viewGroup2, "binding.chatSlice");
            U1(viewGroup2, chatSlice);
            this.n = chatSlice;
            TbPageContext<BaseFragmentActivity> pageContext2 = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext2, "pageContext");
            FragmentAibotChatBinding fragmentAibotChatBinding7 = this.i;
            if (fragmentAibotChatBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding7 = null;
            }
            FrameLayout frameLayout = fragmentAibotChatBinding7.f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.sugSlice");
            AibotSugSlice aibotSugSlice = new AibotSugSlice(pageContext2, frameLayout, m2());
            FragmentAibotChatBinding fragmentAibotChatBinding8 = this.i;
            if (fragmentAibotChatBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAibotChatBinding2 = fragmentAibotChatBinding8;
            }
            ViewGroup viewGroup3 = fragmentAibotChatBinding2.f;
            Intrinsics.checkNotNullExpressionValue(viewGroup3, "binding.sugSlice");
            U1(viewGroup3, aibotSugSlice);
            this.o = aibotSugSlice;
            n2();
            p2();
            sb8.a.a("onActivityCreated 结束");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            sb8.a.a("onCreate 开始");
            String string = requireArguments().getString("botUk");
            String str = "";
            if (string == null) {
                string = "";
            }
            this.e = string;
            String string2 = requireArguments().getString("paid");
            if (string2 != null) {
                str = string2;
            }
            this.f = str;
            String str2 = this.e;
            AibotArgs aibotArgs = null;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str2 = null;
            }
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(str2);
            Intrinsics.checkNotNullExpressionValue(bdUidFromBdUK, "getBdUidFromBdUK(botUk)");
            this.g = bdUidFromBdUK;
            MessageCenterAIBotService a2 = MessageCenterAIBotService.b.a();
            String str3 = this.f;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paid");
                str3 = null;
            }
            String str4 = this.e;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str4 = null;
            }
            a2.h(str3, str4);
            MessageCenterAIBotService a3 = MessageCenterAIBotService.b.a();
            String str5 = this.g;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uid");
                str5 = null;
            }
            a3.g(str5);
            Serializable serializable = requireArguments().getSerializable("argsData");
            if (serializable instanceof AibotArgs) {
                aibotArgs = (AibotArgs) serializable;
            }
            this.h = aibotArgs;
            registerListener(2921816, this.r);
            registerListener(2921817, this.r);
            sb8.a.a("onCreate 结束");
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentAibotChatBinding it = FragmentAibotChatBinding.c(inflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.i = it;
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            ViewCommonUtil.setViewMargin(fragmentAibotChatBinding.e, -1, statusBarHeight, -1, -1);
            RelativeLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…h, -1, -1)\n        }.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    public final void q2(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            sb8.a.a("sendTextMsg", content);
            AibotChatRepo aibotChatRepo = this.m;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            aibotChatRepo.e0(content, new f(this));
        }
    }
}
