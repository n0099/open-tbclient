package com.baidu.tieba.im.biz.aibot;

import android.os.Bundle;
import android.view.KeyEvent;
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
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.UserSettingForceListListener;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.loading.LoadingView;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.ad8;
import com.baidu.tieba.ah8;
import com.baidu.tieba.ax5;
import com.baidu.tieba.eh8;
import com.baidu.tieba.im.biz.aibot.AibotChatFragment;
import com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice;
import com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotArgs;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.biz.aibot.inputslice.InputSlice;
import com.baidu.tieba.im.biz.aibot.navbarslice.NavBarSlice;
import com.baidu.tieba.im.biz.aibot.sugslice.AibotSugHandler;
import com.baidu.tieba.im.biz.aibot.sugslice.AibotSugSlice;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.service.MessageCenterAIBotService;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.impersonal.databinding.FragmentAibotChatBinding;
import com.baidu.tieba.jc8;
import com.baidu.tieba.jd8;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.md8;
import com.baidu.tieba.mg;
import com.baidu.tieba.nc8;
import com.baidu.tieba.oc8;
import com.baidu.tieba.p10;
import com.baidu.tieba.qc8;
import com.baidu.tieba.uc8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wn5;
import com.baidu.tieba.xc8;
import com.baidu.tieba.yc8;
import com.baidu.tieba.yg8;
import com.baidu.tieba.zc8;
import com.baidu.tieba.zg8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018*\u0004\u0015\u0018!&\u0018\u0000 i2\u00020\u00012\u00020\u0002:\u0001iB\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u00020,H\u0002J\u0006\u00109\u001a\u00020\u000fJ\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020,H\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J\b\u0010?\u001a\u00020\u000fH\u0002J\u0018\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020,2\u0006\u0010B\u001a\u00020CH\u0002J\u0012\u0010D\u001a\u00020=2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0012\u0010G\u001a\u00020=2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J$\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\b\u0010N\u001a\u00020=H\u0016J\u0018\u0010O\u001a\u00020\u000f2\u0006\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020=H\u0014J\b\u0010T\u001a\u00020=H\u0016J\b\u0010U\u001a\u00020=H\u0016J\b\u0010V\u001a\u00020=H\u0002J\u0010\u0010W\u001a\u00020=2\u0006\u0010X\u001a\u00020\rH\u0016J\u000e\u0010Y\u001a\u00020=2\u0006\u0010Z\u001a\u00020\rJ\b\u0010[\u001a\u00020=H\u0002J\u0010\u0010\\\u001a\u00020=2\u0006\u0010]\u001a\u00020\u000fH\u0002J\u0018\u0010^\u001a\u00020=2\u0006\u0010_\u001a\u00020,2\u0006\u0010`\u001a\u00020\rH\u0002J\b\u0010a\u001a\u00020=H\u0002J\u0018\u0010b\u001a\u00020=2\u0006\u0010c\u001a\u00020\r2\u0006\u0010d\u001a\u00020\u000fH\u0016J\"\u0010e\u001a\u00020=2\u0006\u0010f\u001a\u00020,2\u0006\u00108\u001a\u00020,2\b\u0010X\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010g\u001a\u00020=2\u0006\u0010h\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006j"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment;", "Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;", "()V", "aibotSugSlice", "Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;", "argsData", "Lcom/baidu/tieba/im/biz/aibot/data/AibotArgs;", "bgSlice", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "binding", "Lcom/baidu/tieba/impersonal/databinding/FragmentAibotChatBinding;", "botUk", "", "canBackToPersonPage", "", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "chatSlice", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;", "fetchMsgsCallback", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$fetchMsgsCallback$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$fetchMsgsCallback$1;", "getDetailCallback", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$getDetailCallback$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$getDetailCallback$1;", "mInputSlice", "Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice;", "mKeyboardHeightCallback", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "mMsgJsBridgeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "msgReciveListener", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$msgReciveListener$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$msgReciveListener$1;", "navBarSlice", "Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;", "onNotifyPageState", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageState$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageState$1;", "pageChangeList", "", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", AiBotChatDispatcher.AI_SINGLE_PAGE_STATE, "", "paid", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "getProcessor", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "processor$delegate", "Lkotlin/Lazy;", "repo", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "uid", "changeToChatPageState", "toPageType", "getAibotPermission", "getPageState", "state", "hideLoading", "", "initInputSlice", "isChatPageState", "notifyBottomHeightChange", "totalHeight", "duration", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNetRefreshButtonClicked", MissionEvent.MESSAGE_PAUSE, "onResume", "registerProcessorHandler", "sendMsg", RemoteMessageConst.MessageBody.MSG_CONTENT, "sendTextMsg", "content", "setPageDetailData", "setPageState", "refreshPage", "showError", "errno", StatConstants.KEY_EXT_ERR_MSG, "showLoading", "showTopToast", "showText", "status", "sugClickEvent", "from", "sugHeightUpdateNotifyChatList", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatFragment extends SliceFragment implements nc8 {
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
    public int r;
    public List<qc8> s;
    public boolean t;
    public final CustomMessageListener u;
    public final e v;
    public final a w;
    public final b x;
    public final f y;
    public final jd8 z;

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

    public final boolean r2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) ? i == 2 : invokeI.booleanValue;
    }

    public final int t2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i)) == null) ? i == 1 ? 1 : 2 : invokeI.intValue;
    }

    /* loaded from: classes6.dex */
    public static final class a implements yg8 {
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

        @Override // com.baidu.tieba.yg8
        public void a(int i, String errMsg, TreeSet<TbBaseMsg> fetchedMsgs) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errMsg, fetchedMsgs) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(fetchedMsgs, "fetchedMsgs");
                if (i == 0) {
                    xc8 xc8Var = xc8.a;
                    AibotChatDetail aibotChatDetail = this.a.q;
                    ChatSlice chatSlice = null;
                    if (aibotChatDetail == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                        aibotChatDetail = null;
                    }
                    HashMap<String, Object> b = xc8Var.b(fetchedMsgs, aibotChatDetail.getUserInfo().getPaid());
                    ChatSlice chatSlice2 = this.a.n;
                    if (chatSlice2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    } else {
                        chatSlice = chatSlice2;
                    }
                    chatSlice.i0().a("fetchHistoryMsgs", b);
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
        /* renamed from: g */
        public void b(int i, String errMsg, AibotChatDetail aibotChatDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, errMsg, aibotChatDetail) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.b(i, errMsg, aibotChatDetail);
                this.b.D2(i, errMsg);
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.e();
                this.b.E2();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: h */
        public void f(AibotChatDetail result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.f(result);
                oc8.a.a("getDetailCallback onSuccess 开始", result);
                this.b.q = result;
                this.b.B2();
                ChatStatusManager inst = ChatStatusManager.getInst();
                String str = this.b.g;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uid");
                    str = null;
                }
                inst.setCurId(0, str);
                this.b.hideLoading();
                oc8.a.a("getDetailCallback onSuccess 结束", result);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements jd8 {
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

        @Override // com.baidu.tieba.jd8
        public void b(String text) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, text) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                FragmentAibotChatBinding fragmentAibotChatBinding = this.a.i;
                if (fragmentAibotChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentAibotChatBinding = null;
                }
                fragmentAibotChatBinding.f.setVisibility(8);
                this.a.z2(text);
            }
        }

        @Override // com.baidu.tieba.jd8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z(1, 2, null);
            }
        }

        @Override // com.baidu.tieba.jd8
        public void c(int i, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) != null) {
                return;
            }
            this.a.x2(i, f);
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
                    if (!Intrinsics.areEqual("AISingleChat", optString)) {
                        return;
                    }
                    AibotChatDetail aibotChatDetail = this.a.q;
                    ChatSlice chatSlice = null;
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
                            aibotChatFragment.A2(optString2);
                            return;
                        } else if (customResponsedMessage.getCmd() == 2921817) {
                            xc8 xc8Var = xc8.a;
                            AibotChatRepo aibotChatRepo2 = this.a.m;
                            if (aibotChatRepo2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("repo");
                            } else {
                                aibotChatRepo = aibotChatRepo2;
                            }
                            Object data2 = customResponsedMessage.getData();
                            if (data2 != null) {
                                xc8Var.a(aibotChatRepo, (JSONObject) data2, this.a.w);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        } else if (customResponsedMessage.getCmd() != 2921820) {
                            return;
                        } else {
                            ChatSlice chatSlice2 = this.a.n;
                            if (chatSlice2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                            } else {
                                chatSlice = chatSlice2;
                            }
                            chatSlice.h0(jSONObject);
                            return;
                        }
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements zg8 {
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
                aibotSugSlice.k0(abilityItems);
                this$0.F2(true);
            }
        }

        @Override // com.baidu.tieba.zg8
        public void a(int i, TreeSet<TbBaseMsg> msgSet) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, msgSet) == null) {
                Intrinsics.checkNotNullParameter(msgSet, "msgSet");
                xc8 xc8Var = xc8.a;
                AibotChatDetail aibotChatDetail = this.a.q;
                ChatSlice chatSlice = null;
                if (aibotChatDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                    aibotChatDetail = null;
                }
                HashMap<String, Object> b = xc8Var.b(msgSet, aibotChatDetail.getUserInfo().getPaid());
                ChatSlice chatSlice2 = this.a.n;
                if (chatSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                } else {
                    chatSlice = chatSlice2;
                }
                chatSlice.i0().a("receiveNewMsgs", b);
                if (this.a.w2()) {
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
                            mg.g(new Runnable() { // from class: com.baidu.tieba.lc8
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
    }

    /* loaded from: classes6.dex */
    public static final class f extends zc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(AibotChatFragment aibotChatFragment) {
            super("aibot.notifyPageState");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aibotChatFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = aibotChatFragment;
        }

        @Override // com.baidu.tieba.hz4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                boolean z = false;
                oc8.a.a("AibotChatFragment onNotifyPageState");
                if (data.length() == 0) {
                    z = true;
                }
                if (z) {
                    return;
                }
                try {
                    this.c.r = this.c.t2(new JSONObject(data).optInt(AiBotChatDispatcher.AI_SINGLE_PAGE_STATE));
                    this.c.C2(true);
                } catch (JSONException e) {
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        TbLog defaultLog = DefaultLog.getInstance();
                        defaultLog.e("AibotChatFragment", "json解析异常 " + e.getMessage());
                        return;
                    }
                    throw new IllegalArgumentException("json解析异常");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements ah8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        public g(AibotChatFragment aibotChatFragment) {
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

        @Override // com.baidu.tieba.ah8
        public void a(int i, String errMsg, TbBaseMsg tbMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errMsg, tbMsg) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("sendStatus", Integer.valueOf(i));
                String a = p10.a(DataExt.toJson(eh8.c(tbMsg, false)));
                Intrinsics.checkNotNullExpressionValue(a, "getEncodeValue(tbMsg.toF…essedMap(false).toJson())");
                hashMap.put("msg", a);
                ChatSlice chatSlice = this.a.n;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                chatSlice.i0().a("sendMsg", hashMap);
                oc8.a.a("sendTextMsg onResult", hashMap);
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
        this.r = 2;
        this.s = new ArrayList();
        this.u = new d(this);
        this.v = new e(this);
        this.w = new a(this);
        this.x = new b(this);
        this.y = new f(this);
        this.z = new c(this);
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
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
            inputSlice2.B2(this.z);
            FragmentManager childFragmentManager = getChildFragmentManager();
            InputSlice inputSlice3 = this.j;
            if (inputSlice3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
                inputSlice3 = null;
            }
            ax5.a(childFragmentManager, R.id.obfuscated_res_0x7f091143, inputSlice3);
            List<qc8> list = this.s;
            InputSlice inputSlice4 = this.j;
            if (inputSlice4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
                inputSlice4 = null;
            }
            if (!list.contains(inputSlice4)) {
                List<qc8> list2 = this.s;
                InputSlice inputSlice5 = this.j;
                if (inputSlice5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
                } else {
                    inputSlice = inputSlice5;
                }
                list2.add(inputSlice);
            }
        }
    }

    public static final void G2(boolean z, AibotChatFragment this$0) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65538, null, z, this$0) == null) {
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
            md8.r = i;
            this$0.x2(md8.m + md8.s, 0.1f);
        }
    }

    @Override // com.baidu.tieba.nc8
    public void y(String showText, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, showText, z) == null) {
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

    public final void F2(final boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && md8.q) {
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            fragmentAibotChatBinding.f.post(new Runnable() { // from class: com.baidu.tieba.mc8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AibotChatFragment.G2(z, this);
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048587, this, i, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (i == 4 && w2() && this.t) {
                z(3, 1, null);
                return true;
            }
            return super.onKeyDown(i, event);
        }
        return invokeIL.booleanValue;
    }

    public final void A2(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            oc8.a.a("sendTextMsg", content);
            AibotChatRepo aibotChatRepo = this.m;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            aibotChatRepo.g0(content, new g(this));
        }
    }

    public final void C2(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            List<qc8> list = this.s;
            if (list != null && !list.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return;
            }
            for (qc8 qc8Var : this.s) {
                qc8Var.A1(this.r, z);
            }
        }
    }

    public final void B2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            List<qc8> list = this.s;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            for (qc8 qc8Var : this.s) {
                AibotChatDetail aibotChatDetail = this.q;
                if (aibotChatDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                    aibotChatDetail = null;
                }
                qc8Var.B(aibotChatDetail);
            }
        }
    }

    public final void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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
            navBarSlice.c0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            oc8.a.a(MissionEvent.MESSAGE_DESTROY);
            md8.r = 0;
            MessageManager.getInstance().unRegisterListener(this.u);
            zc8.b.b(this.y);
            this.s.clear();
        }
    }

    public final void D2(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) {
            oc8.a.a("showError", Integer.valueOf(i), str);
            hideLoadingView(getView());
            this.loadingView = null;
            if (i == 2930005) {
                showNetRefreshViewNoClickWithTitle(getView(), str, false);
            } else {
                showNetRefreshView(getView(), null, false);
            }
            wn5 wn5Var = this.mRefreshView;
            if (wn5Var != null) {
                wn5Var.getAttachedView().setClickable(false);
                this.mRefreshView.k(UtilHelper.getStatusBarHeight());
                this.mRefreshView.e(R.color.transparent);
            }
        }
    }

    public final void x2(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("height", Integer.valueOf(i));
            hashMap.put("animationDuration", Float.valueOf(f2));
            ChatSlice chatSlice = this.n;
            if (chatSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                chatSlice = null;
            }
            chatSlice.i0().a("keyboardHeightChange", hashMap);
            oc8.a.a("heightChange", hashMap);
        }
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
            navBarSlice.d0();
            showLoadingView(getView());
            LoadingView loadingView = this.loadingView;
            if (loadingView != null) {
                loadingView.getAttachedView().setClickable(false);
                this.loadingView.cancelCenterVertical();
                this.loadingView.setLayoutMarginWithHeaderHeightAndPercent(0, 0.4f);
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onActivityCreated(bundle);
            oc8.a.a("onActivityCreated 开始");
            NavBarSlice navBarSlice = new NavBarSlice();
            FragmentAibotChatBinding fragmentAibotChatBinding = this.i;
            BackgroundSlice backgroundSlice = null;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            ViewGroup viewGroup = fragmentAibotChatBinding.e;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "binding.navbarSlice");
            W1(viewGroup, navBarSlice);
            this.s.add(navBarSlice);
            this.l = navBarSlice;
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            String str = this.e;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str = null;
            }
            AibotChatRepo aibotChatRepo = new AibotChatRepo(pageContext, str);
            FragmentAibotChatBinding fragmentAibotChatBinding2 = this.i;
            if (fragmentAibotChatBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding2 = null;
            }
            ViewGroup root = fragmentAibotChatBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            W1(root, aibotChatRepo);
            aibotChatRepo.f0(this.x);
            aibotChatRepo.h0(this.v);
            this.m = aibotChatRepo;
            BackgroundSlice backgroundSlice2 = new BackgroundSlice();
            FragmentAibotChatBinding fragmentAibotChatBinding3 = this.i;
            if (fragmentAibotChatBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding3 = null;
            }
            ViewGroup viewGroup2 = fragmentAibotChatBinding3.g;
            Intrinsics.checkNotNullExpressionValue(viewGroup2, "binding.viewBg");
            W1(viewGroup2, backgroundSlice2);
            if (!this.s.contains(backgroundSlice2)) {
                this.s.add(backgroundSlice2);
            }
            this.k = backgroundSlice2;
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
            FragmentAibotChatBinding fragmentAibotChatBinding4 = this.i;
            if (fragmentAibotChatBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding4 = null;
            }
            ViewGroup viewGroup3 = fragmentAibotChatBinding4.c;
            Intrinsics.checkNotNullExpressionValue(viewGroup3, "binding.chatSlice");
            W1(viewGroup3, chatSlice);
            if (!this.s.contains(chatSlice)) {
                this.s.add(chatSlice);
            }
            this.n = chatSlice;
            TbPageContext<BaseFragmentActivity> pageContext2 = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext2, "pageContext");
            FragmentAibotChatBinding fragmentAibotChatBinding5 = this.i;
            if (fragmentAibotChatBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding5 = null;
            }
            FrameLayout frameLayout = fragmentAibotChatBinding5.f;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.sugSlice");
            AibotSugSlice aibotSugSlice = new AibotSugSlice(pageContext2, frameLayout, u2());
            FragmentAibotChatBinding fragmentAibotChatBinding6 = this.i;
            if (fragmentAibotChatBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding6 = null;
            }
            ViewGroup viewGroup4 = fragmentAibotChatBinding6.f;
            Intrinsics.checkNotNullExpressionValue(viewGroup4, "binding.sugSlice");
            W1(viewGroup4, aibotSugSlice);
            if (!this.s.contains(aibotSugSlice)) {
                this.s.add(aibotSugSlice);
            }
            this.o = aibotSugSlice;
            v2();
            AibotArgs aibotArgs = this.h;
            if (aibotArgs != null) {
                int t2 = t2(aibotArgs.getPageState());
                this.r = t2;
                if (t2 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.t = z;
                C2(false);
                BackgroundSlice backgroundSlice3 = this.k;
                if (backgroundSlice3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                } else {
                    backgroundSlice = backgroundSlice3;
                }
                backgroundSlice.d0(aibotArgs.getChatPageBgUrl(), aibotArgs.getPersonPageBgUrl(), false);
            }
            y2();
            oc8.a.a("onActivityCreated 结束");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            oc8.a.a("onCreate 开始");
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
            registerListener(2921816, this.u);
            registerListener(2921817, this.u);
            registerListener(2921820, this.u);
            zc8.b.a(this.y);
            oc8.a.a("onCreate 结束");
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, inflater, viewGroup, bundle)) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onNetRefreshButtonClicked();
            oc8.a.a("onNetRefreshButtonClicked");
            AibotChatRepo aibotChatRepo = this.m;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            aibotChatRepo.f0(this.x);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPause();
            oc8.a.a(MissionEvent.MESSAGE_PAUSE);
            ChatStatusManager.getInst().setIsOpen(0, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            oc8.a.a("onResume");
            ChatStatusManager.getInst().setIsOpen(0, true);
        }
    }

    public final boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            AibotChatDetail aibotChatDetail = this.q;
            if (aibotChatDetail == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                aibotChatDetail = null;
            }
            int auditStatus = aibotChatDetail.getAuditStatus();
            if (auditStatus != 0 && auditStatus != 2 && auditStatus != 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final jc8 u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return (jc8) this.p.getValue();
        }
        return (jc8) invokeV.objValue;
    }

    public final boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.r == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            u2().a(new AibotSugHandler(this));
            u2().a(new uc8(this));
        }
    }

    @Override // com.baidu.tieba.nc8
    public void z(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048600, this, i, i2, str) == null) {
            if (2 == i && !w2()) {
                yc8.a.b(6);
            }
            String str2 = null;
            InputSlice inputSlice = null;
            if (2 == i && !s2()) {
                InputSlice inputSlice2 = this.j;
                if (inputSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInputSlice");
                } else {
                    inputSlice = inputSlice2;
                }
                inputSlice.D2();
            } else if (r2(i2) && w2()) {
                if (str != null) {
                    z2(str);
                }
            } else if (!r2(i2) && !w2()) {
                if (str != null) {
                    z2(str);
                }
            } else {
                this.r = i2;
                C2(true);
                ChatSlice chatSlice = this.n;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                AibotSugSlice aibotSugSlice = this.o;
                if (aibotSugSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                    aibotSugSlice = null;
                }
                AibotChatDetail.TopicInfo f0 = aibotSugSlice.f0();
                if (f0 != null) {
                    str2 = f0.getTopicName();
                }
                chatSlice.q0(new ChatSlice.PageStateExt(str2, str));
            }
        }
    }

    public void z2(String msgContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, msgContent) == null) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            if (!s2()) {
                return;
            }
            oc8.a.a("sendMsg", msgContent);
            AibotSugSlice aibotSugSlice = this.o;
            ChatSlice chatSlice = null;
            if (aibotSugSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                aibotSugSlice = null;
            }
            aibotSugSlice.i0();
            F2(false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", msgContent);
            ChatSlice chatSlice2 = this.n;
            if (chatSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
            } else {
                chatSlice = chatSlice2;
            }
            ad8 i0 = chatSlice.i0();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "msg.toString()");
            i0.c("aiChatInputMsg", jSONObject2);
        }
    }
}
