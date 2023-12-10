package com.baidu.tieba.im.biz.aibot;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.UiUtils;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.module.imaibot.AibotArgs;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.R;
import com.baidu.tieba.ar8;
import com.baidu.tieba.cr8;
import com.baidu.tieba.ds8;
import com.baidu.tieba.dx;
import com.baidu.tieba.fk5;
import com.baidu.tieba.fs8;
import com.baidu.tieba.hr8;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.biz.aibot.AibotChatFragment;
import com.baidu.tieba.im.biz.aibot.backgroundslice.BackgroundSlice;
import com.baidu.tieba.im.biz.aibot.backslice.BackSlice;
import com.baidu.tieba.im.biz.aibot.chatslice.ChatSlice;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.biz.aibot.inputslice.InputSlice;
import com.baidu.tieba.im.biz.aibot.navbarslice.NavBarSlice;
import com.baidu.tieba.im.biz.aibot.sugslice.AibotSugHandler;
import com.baidu.tieba.im.biz.aibot.sugslice.AibotSugSlice;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.immessagecenter.service.MessageCenterAIBotService;
import com.baidu.tieba.impersonal.databinding.FragmentAibotChatBinding;
import com.baidu.tieba.kr8;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.lq8;
import com.baidu.tieba.lr8;
import com.baidu.tieba.mr8;
import com.baidu.tieba.nr8;
import com.baidu.tieba.pv8;
import com.baidu.tieba.qt5;
import com.baidu.tieba.qv8;
import com.baidu.tieba.rd;
import com.baidu.tieba.rv8;
import com.baidu.tieba.uv8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wr8;
import com.baidu.tieba.zq8;
import com.baidu.tieba.zr8;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a*\u0007\u0018\u001d',/25\u0018\u0000 \u008c\u00012\u00020\u00012\u00020\u0002:\u0002\u008c\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020;H\u0002J\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000fJ\u0006\u0010K\u001a\u00020\u0011J\u0010\u0010L\u001a\u00020;2\u0006\u0010M\u001a\u00020;H\u0002J\b\u0010N\u001a\u00020IH\u0002J\b\u0010O\u001a\u00020IH\u0002J\b\u0010P\u001a\u00020IH\u0002J\b\u0010Q\u001a\u00020\u0011H\u0002J\b\u0010R\u001a\u00020\u0011H\u0002J\u0010\u0010S\u001a\u00020I2\u0006\u0010T\u001a\u00020;H\u0016J \u0010U\u001a\u00020I2\u0006\u0010V\u001a\u00020;2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u000fH\u0002J\u0010\u0010Z\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000fH\u0016J\u0012\u0010[\u001a\u00020I2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010^\u001a\u00020IH\u0016J\b\u0010_\u001a\u00020IH\u0016J\u0012\u0010`\u001a\u00020I2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J$\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\b\u0010g\u001a\u00020IH\u0016J\u0018\u0010h\u001a\u00020\u00112\u0006\u0010i\u001a\u00020;2\u0006\u0010j\u001a\u00020kH\u0016J\b\u0010l\u001a\u00020IH\u0014J\b\u0010m\u001a\u00020IH\u0016J\b\u0010n\u001a\u00020IH\u0016J\b\u0010o\u001a\u00020IH\u0016J\b\u0010p\u001a\u00020IH\u0016J\u0010\u0010q\u001a\u0004\u0018\u00010\u00072\u0006\u0010r\u001a\u00020sJ \u0010t\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000f2\u0006\u0010u\u001a\u00020\u000f2\b\u0010v\u001a\u0004\u0018\u00010\u0007J\b\u0010w\u001a\u00020IH\u0002J\u0018\u0010x\u001a\u00020I2\u0006\u0010y\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020\u000fH\u0016J\u001e\u0010{\u001a\u00020I2\u0006\u0010y\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u000fJ\u000e\u0010|\u001a\u00020I2\u0006\u0010}\u001a\u00020\u000fJ\b\u0010~\u001a\u00020IH\u0002J\u0011\u0010\u007f\u001a\u00020I2\u0007\u0010\u0080\u0001\u001a\u00020\u0011H\u0002J\u001b\u0010\u0081\u0001\u001a\u00020I2\u0007\u0010\u0082\u0001\u001a\u00020;2\u0007\u0010\u0083\u0001\u001a\u00020\u000fH\u0002J\t\u0010\u0084\u0001\u001a\u00020IH\u0002J\u001b\u0010\u0085\u0001\u001a\u00020I2\u0007\u0010\u0086\u0001\u001a\u00020\u000f2\u0007\u0010\u0087\u0001\u001a\u00020\u0011H\u0016J$\u0010\u0088\u0001\u001a\u00020I2\u0007\u0010\u0089\u0001\u001a\u00020;2\u0006\u0010G\u001a\u00020;2\b\u0010y\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u008a\u0001\u001a\u00020I2\u0007\u0010\u008b\u0001\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u00020>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\b?\u0010@R\u000e\u0010C\u001a\u00020DX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u008d\u0001"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment;", "Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;", "()V", "aibotSugSlice", "Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugSlice;", "argsData", "Lcom/baidu/tbadk/module/imaibot/AibotArgs;", "backSlice", "Lcom/baidu/tieba/im/biz/aibot/backslice/BackSlice;", "bgSlice", "Lcom/baidu/tieba/im/biz/aibot/backgroundslice/BackgroundSlice;", "binding", "Lcom/baidu/tieba/impersonal/databinding/FragmentAibotChatBinding;", "botUk", "", "canBackToPersonPage", "", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "chatPageBgUrl", "chatSlice", "Lcom/baidu/tieba/im/biz/aibot/chatslice/ChatSlice;", "fetchMsgsCallback", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$fetchMsgsCallback$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$fetchMsgsCallback$1;", "fid", "fromPage", "getDetailCallback", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$getDetailCallback$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$getDetailCallback$1;", "isFirstRequest", "mInputSlice", "Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice;", "mKeyboardHeightCallback", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "mMsgJsBridgeListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "msgReciveListener", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$msgReciveListener$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$msgReciveListener$1;", "navBarSlice", "Lcom/baidu/tieba/im/biz/aibot/navbarslice/NavBarSlice;", "onNotifyClosePage", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyClosePage$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyClosePage$1;", "onNotifyPageChangeBot", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageChangeBot$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageChangeBot$1;", "onNotifyPageHideBackArea", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageHideBackArea$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageHideBackArea$1;", "onNotifyPageState", "com/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageState$1", "Lcom/baidu/tieba/im/biz/aibot/AibotChatFragment$onNotifyPageState$1;", "pageChangeList", "", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", AiBotChatDispatcher.AI_SINGLE_PAGE_STATE, "", "paid", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "getProcessor", "()Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "processor$delegate", "Lkotlin/Lazy;", "repo", "Lcom/baidu/tieba/im/biz/aibot/AibotChatRepo;", "uid", "changeToChatPageState", "toPageType", "createNewPageDataAndRefresh", "", "uk", "getAibotPermission", "getPageState", "state", "hideError", "hideLoading", "initInputSlice", "isChatDetailInit", "isChatPageState", "notifyBackHide", "height", "notifyBottomHeightChange", "totalHeight", "duration", "", "actionType", "notifyLocateBot", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onBackLastPage", "onBgScrolled", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", MissionEvent.MESSAGE_DESTROY, "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onNetRefreshButtonClicked", MissionEvent.MESSAGE_PAUSE, "onResume", "onSoftKeyboardClosed", "onSoftKeyboardOpened", "refreshArgsData", "data", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail$BotList;", "refreshPageData", "pid", "argData", "registerProcessorHandler", "sendMsg", RemoteMessageConst.MessageBody.MSG_CONTENT, "type", "sendMsgNotifyAllLocalPage", "sendTextMsg", "content", "setPageDetailData", "setPageState", "refreshPage", "showError", "errno", StatConstants.KEY_EXT_ERR_MSG, "showLoading", "showTopToast", "showText", "status", "sugClickEvent", "from", "sugHeightUpdateNotifyChatList", UserSettingForceListListener.FORCE_LIST_ITEM_SHOW_KEY, "Companion", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotChatFragment extends SliceFragment implements zq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e A;
    public final a B;
    public final b C;
    public final j D;
    public final g E;
    public final h F;
    public final i G;
    public final wr8 H;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public AibotArgs k;
    public FragmentAibotChatBinding l;
    public InputSlice m;
    public BackgroundSlice n;
    public NavBarSlice o;
    public AibotChatRepo p;
    public ChatSlice q;
    public AibotSugSlice r;
    public BackSlice s;
    public final Lazy t;
    public AibotChatDetail u;
    public int v;
    public List<cr8> w;
    public boolean x;
    public boolean y;
    public final CustomMessageListener z;

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

    @Override // com.baidu.tieba.zq8
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    public final boolean k3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? i2 == 2 : invokeI.booleanValue;
    }

    public final int n3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) ? i2 == 1 ? 1 : 2 : invokeI.intValue;
    }

    /* loaded from: classes6.dex */
    public static final class a implements pv8 {
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

        @Override // com.baidu.tieba.pv8
        public void a(int i, String errMsg, TreeSet<TbBaseMsg> fetchedMsgs) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errMsg, fetchedMsgs) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(fetchedMsgs, "fetchedMsgs");
                if (i == 0) {
                    kr8 kr8Var = kr8.a;
                    AibotChatDetail aibotChatDetail = this.a.u;
                    ChatSlice chatSlice = null;
                    if (aibotChatDetail == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                        aibotChatDetail = null;
                    }
                    HashMap<String, Object> b = kr8Var.b(fetchedMsgs, aibotChatDetail.getUserInfo().getPaid());
                    ChatSlice chatSlice2 = this.a.q;
                    if (chatSlice2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    } else {
                        chatSlice = chatSlice2;
                    }
                    chatSlice.m0().a("fetchHistoryMsgs", b);
                }
                ar8.a.a("AibotChatFragment", "fetchMsgsCallback", Integer.valueOf(i), errMsg, Integer.valueOf(fetchedMsgs.size()));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends FastRequest.b<AibotChatDetail> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment d;

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
            this.d = aibotChatFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, AibotChatDetail aibotChatDetail) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048579, this, i, errMsg, aibotChatDetail) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, aibotChatDetail);
                if (rd.isEquals("1", this.d.h)) {
                    return;
                }
                this.d.C3(i, errMsg);
            }
        }

        @Override // com.baidu.tbadk.net.FastRequest.b
        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.h();
                this.d.p3();
                if (this.d.y) {
                    this.d.D3();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(AibotChatDetail result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                ar8.a.a("getDetailCallback onSuccess 开始", result);
                this.d.u = result;
                this.d.A3();
                ChatStatusManager inst = ChatStatusManager.getInst();
                String str = this.d.g;
                String str2 = null;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uid");
                    str = null;
                }
                inst.setCurId(0, str);
                this.d.hideLoading();
                this.d.y = false;
                if (!result.getBotList().isEmpty()) {
                    BackgroundSlice backgroundSlice = this.d.n;
                    if (backgroundSlice == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                        backgroundSlice = null;
                    }
                    AibotChatRepo aibotChatRepo = this.d.p;
                    if (aibotChatRepo == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("repo");
                        aibotChatRepo = null;
                    }
                    backgroundSlice.j0(aibotChatRepo.h0());
                    BackgroundSlice backgroundSlice2 = this.d.n;
                    if (backgroundSlice2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                        backgroundSlice2 = null;
                    }
                    String str3 = this.d.e;
                    if (str3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("botUk");
                    } else {
                        str2 = str3;
                    }
                    backgroundSlice2.y0(str2);
                }
                ar8.a.a("getDetailCallback onSuccess 结束", result);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements wr8 {
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

        @Override // com.baidu.tieba.wr8
        public void a(int i, float f, String actionType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), actionType}) == null) {
                Intrinsics.checkNotNullParameter(actionType, "actionType");
                this.a.t3(i, f, actionType);
            }
        }

        @Override // com.baidu.tieba.wr8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.L(1, 2, null);
            }
        }

        @Override // com.baidu.tieba.wr8
        public void c(String text, String type) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, text, type) == null) {
                Intrinsics.checkNotNullParameter(text, "text");
                Intrinsics.checkNotNullParameter(type, "type");
                FragmentAibotChatBinding fragmentAibotChatBinding = this.a.l;
                String str = null;
                if (fragmentAibotChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentAibotChatBinding = null;
                }
                fragmentAibotChatBinding.h.setVisibility(8);
                AibotChatFragment aibotChatFragment = this.a;
                String str2 = aibotChatFragment.e;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("botUk");
                } else {
                    str = str2;
                }
                aibotChatFragment.y3(text, type, str);
            }
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
            ChatSlice chatSlice;
            AibotChatRepo aibotChatRepo;
            ChatSlice chatSlice2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && !customResponsedMessage.hasError() && (customResponsedMessage.getData() instanceof JSONObject)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    JSONObject jSONObject = (JSONObject) data;
                    String optString = jSONObject.optString("chatType");
                    long optLong = jSONObject.optLong("chatId", 0L);
                    int optInt = jSONObject.optInt("webViewCode");
                    String optString2 = jSONObject.optString("botUk");
                    String sendType = jSONObject.optString("sendType");
                    String sendText = jSONObject.optString("sendText");
                    if (customResponsedMessage.getCmd() == 2921830) {
                        String str = this.a.e;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("botUk");
                            str = null;
                        }
                        if (rd.isEquals(optString2, str)) {
                            AibotChatFragment aibotChatFragment = this.a;
                            Intrinsics.checkNotNullExpressionValue(sendText, "sendText");
                            Intrinsics.checkNotNullExpressionValue(sendType, "sendType");
                            aibotChatFragment.x3(sendText, sendType);
                        }
                    }
                    int i = 0;
                    ar8.a.a("AibotChatFragment", "mMsgJsBridgeListener", optString, Long.valueOf(optLong), jSONObject);
                    if (Intrinsics.areEqual("AISingleChat", optString)) {
                        AibotChatDetail aibotChatDetail = this.a.u;
                        if (aibotChatDetail == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                            aibotChatDetail = null;
                        }
                        if (aibotChatDetail.getUserInfo().getPaid() == optLong) {
                            if (customResponsedMessage.getCmd() == 2921816) {
                                if (!this.a.isResumed()) {
                                    return;
                                }
                                ChatSlice chatSlice3 = this.a.q;
                                if (chatSlice3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                                    chatSlice2 = null;
                                } else {
                                    chatSlice2 = chatSlice3;
                                }
                                WebView innerWebView = chatSlice2.o0().getInnerWebView();
                                if (innerWebView != null) {
                                    i = innerWebView.hashCode();
                                }
                                if (optInt == i) {
                                    AibotChatFragment aibotChatFragment2 = this.a;
                                    String optString3 = jSONObject.optString("msg");
                                    Intrinsics.checkNotNullExpressionValue(optString3, "params.optString(\"msg\")");
                                    aibotChatFragment2.z3(optString3);
                                    return;
                                }
                                return;
                            } else if (customResponsedMessage.getCmd() == 2921817) {
                                kr8 kr8Var = kr8.a;
                                AibotChatRepo aibotChatRepo2 = this.a.p;
                                if (aibotChatRepo2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("repo");
                                    aibotChatRepo = null;
                                } else {
                                    aibotChatRepo = aibotChatRepo2;
                                }
                                Object data2 = customResponsedMessage.getData();
                                if (data2 != null) {
                                    kr8Var.a(aibotChatRepo, (JSONObject) data2, this.a.B);
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                            } else if (customResponsedMessage.getCmd() != 2921820) {
                                return;
                            } else {
                                ChatSlice chatSlice4 = this.a.q;
                                if (chatSlice4 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                                    chatSlice = null;
                                } else {
                                    chatSlice = chatSlice4;
                                }
                                chatSlice.l0(jSONObject);
                                return;
                            }
                        }
                    }
                    ar8.a.a("AibotChatFragment", "mMsgJsBridgeListener", "命中return逻辑");
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements qv8 {
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
                AibotSugSlice aibotSugSlice = this$0.r;
                Integer num = null;
                if (aibotSugSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                    aibotSugSlice = null;
                }
                List<AbilityItem> abilityItems = tbBaseMsg.getAbilityItems();
                Intrinsics.checkNotNull(abilityItems);
                aibotSugSlice.n0(abilityItems);
                this$0.E3(true);
                lr8 lr8Var = lr8.a;
                String str = this$0.f;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paid");
                    str = null;
                }
                AibotArgs aibotArgs = this$0.k;
                if (aibotArgs != null) {
                    num = aibotArgs.getPageSource();
                }
                lr8Var.b(3, str, num);
            }
        }

        @Override // com.baidu.tieba.qv8
        public void a(int i, TreeSet<TbBaseMsg> msgSet) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, msgSet) == null) {
                Intrinsics.checkNotNullParameter(msgSet, "msgSet");
                kr8 kr8Var = kr8.a;
                AibotChatDetail aibotChatDetail = this.a.u;
                ChatSlice chatSlice = null;
                if (aibotChatDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                    aibotChatDetail = null;
                }
                HashMap<String, Object> b = kr8Var.b(msgSet, aibotChatDetail.getUserInfo().getPaid());
                ChatSlice chatSlice2 = this.a.q;
                if (chatSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                } else {
                    chatSlice = chatSlice2;
                }
                chatSlice.m0().a("receiveNewMsgs", b);
                ar8.a.a("AibotChatFragment", "msgReciveListener", Integer.valueOf(i), b);
                if (this.a.s3()) {
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
                            UiUtils.runOnUiThread(new Runnable() { // from class: com.baidu.tieba.xq8
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
    public static final class f implements fs8 {
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

        @Override // com.baidu.tieba.fs8
        public void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) != null) {
                return;
            }
            BackgroundSlice backgroundSlice = this.a.n;
            if (backgroundSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                backgroundSlice = null;
            }
            backgroundSlice.o0(f);
        }

        @Override // com.baidu.tieba.fs8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            BackgroundSlice backgroundSlice = this.a.n;
            if (backgroundSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                backgroundSlice = null;
            }
            backgroundSlice.B0();
        }

        @Override // com.baidu.tieba.fs8
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            BackgroundSlice backgroundSlice = this.a.n;
            if (backgroundSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                backgroundSlice = null;
            }
            backgroundSlice.p0();
        }

        @Override // com.baidu.tieba.fs8
        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("orientation", i);
                ChatSlice chatSlice = this.a.q;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                nr8 m0 = chatSlice.m0();
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "msg.toString()");
                m0.c("clientScrollOrientation", jSONObject2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class g extends mr8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(AibotChatFragment aibotChatFragment) {
            super("aibot.closePage");
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

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.c.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class h extends mr8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AibotChatFragment aibotChatFragment) {
            super("aibot.changeBot");
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

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                boolean z = true;
                ar8.a.a("AibotChatFragment onChangeBot");
                if (data.length() != 0) {
                    z = false;
                }
                if (z) {
                    return;
                }
                try {
                    String uk = new JSONObject(data).optString("bot_uk");
                    BackgroundSlice backgroundSlice = this.c.n;
                    String str = null;
                    if (backgroundSlice == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                        backgroundSlice = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(uk, "uk");
                    backgroundSlice.x0(uk);
                    String str2 = this.c.e;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("botUk");
                    } else {
                        str = str2;
                    }
                    if (!rd.isEquals(uk, str)) {
                        this.c.l3(uk);
                    }
                } catch (JSONException e) {
                    if (!TbadkApplication.getInst().isDebugMode()) {
                        DefaultLog.getInstance().e("AibotChatFragment", "json解析异常 " + e.getMessage());
                        return;
                    }
                    throw new IllegalArgumentException("json解析异常");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class i extends mr8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(AibotChatFragment aibotChatFragment) {
            super("aibot.hideBackArea");
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

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                ar8.a.a("AibotChatFragment onHideBackArea");
                BackSlice backSlice = this.c.s;
                if (backSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backSlice");
                    backSlice = null;
                }
                backSlice.f0();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class j extends mr8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AibotChatFragment aibotChatFragment) {
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

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                boolean z = false;
                ar8.a.a("AibotChatFragment onNotifyPageState");
                if (data.length() == 0) {
                    z = true;
                }
                if (z) {
                    return;
                }
                try {
                    this.c.v = this.c.n3(new JSONObject(data).optInt(AiBotChatDispatcher.AI_SINGLE_PAGE_STATE));
                    this.c.B3(true);
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
    public static final class k implements rv8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AibotChatFragment a;

        public k(AibotChatFragment aibotChatFragment) {
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

        @Override // com.baidu.tieba.rv8
        public void a(int i, String errMsg, TbBaseMsg tbMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, errMsg, tbMsg) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("sendStatus", Integer.valueOf(i));
                String a = dx.a(DataExt.toJson(uv8.c(tbMsg, false)));
                Intrinsics.checkNotNullExpressionValue(a, "getEncodeValue(tbMsg.toF…essedMap(false).toJson())");
                hashMap.put("msg", a);
                ChatSlice chatSlice = this.a.q;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                chatSlice.m0().a("sendMsg", hashMap);
                ar8.a.a("sendTextMsg onResult", hashMap);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Slice) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new InputSlice();
        this.t = LazyKt__LazyJVMKt.lazy(AibotChatFragment$processor$2.INSTANCE);
        this.v = 2;
        this.w = new ArrayList();
        this.y = true;
        this.z = new d(this);
        this.A = new e(this);
        this.B = new a(this);
        this.C = new b(this);
        this.D = new j(this);
        this.E = new g(this);
        this.F = new h(this);
        this.G = new i(this);
        this.H = new c(this);
    }

    public static final void F3(boolean z, AibotChatFragment this$0) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65538, null, z, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z) {
                FragmentAibotChatBinding fragmentAibotChatBinding = this$0.l;
                if (fragmentAibotChatBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentAibotChatBinding = null;
                }
                i2 = fragmentAibotChatBinding.h.getHeight();
            } else {
                i2 = 0;
            }
            zr8.r = i2;
            this$0.t3(zr8.m + zr8.s, 0.1f, "1");
        }
    }

    @Override // com.baidu.tieba.zq8
    public void K(String showText, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048582, this, showText, z) == null) {
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

    public final void E3(final boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && this.m.V2()) {
            FragmentAibotChatBinding fragmentAibotChatBinding = this.l;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            fragmentAibotChatBinding.h.post(new Runnable() { // from class: com.baidu.tieba.yq8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        AibotChatFragment.F3(z, this);
                    }
                }
            });
        }
    }

    public final AibotArgs u3(AibotChatDetail.BotList data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            AibotArgs aibotArgs = this.k;
            if (aibotArgs != null) {
                aibotArgs.setChatPageBgUrl(data.getBackground());
            }
            return this.k;
        }
        return (AibotArgs) invokeL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public boolean onKeyDown(int i2, KeyEvent event) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, event)) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (i2 == 4 && s3() && this.x) {
                L(3, 1, null);
                return true;
            }
            return super.onKeyDown(i2, event);
        }
        return invokeIL.booleanValue;
    }

    public final void A3() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<cr8> list = this.w;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            for (cr8 cr8Var : this.w) {
                AibotChatDetail aibotChatDetail = this.u;
                if (aibotChatDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                    aibotChatDetail = null;
                }
                cr8Var.O(aibotChatDetail);
            }
        }
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            NavBarSlice navBarSlice = this.o;
            if (navBarSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBarSlice");
                navBarSlice = null;
            }
            navBarSlice.g0();
            showLoadingView(getView());
            LoadingView loadingView = this.loadingView;
            if (loadingView != null) {
                loadingView.getAttachedView().setClickable(false);
                this.loadingView.cancelCenterVertical();
                this.loadingView.setLayoutMarginWithHeaderHeightAndPercent(0, 0.4f);
            }
        }
    }

    @Override // com.baidu.tieba.zq8
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BackSlice backSlice = this.s;
            BackgroundSlice backgroundSlice = null;
            if (backSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backSlice");
                backSlice = null;
            }
            if (!backSlice.g0()) {
                BackSlice backSlice2 = this.s;
                if (backSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backSlice");
                    backSlice2 = null;
                }
                BackgroundSlice backgroundSlice2 = this.n;
                if (backgroundSlice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                } else {
                    backgroundSlice = backgroundSlice2;
                }
                backSlice2.h0(backgroundSlice.q0());
            }
        }
    }

    public final void hideLoading() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            FragmentAibotChatBinding fragmentAibotChatBinding = this.l;
            NavBarSlice navBarSlice = null;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            fragmentAibotChatBinding.c.setVisibility(0);
            hideLoadingView(getView());
            this.loadingView = null;
            NavBarSlice navBarSlice2 = this.o;
            if (navBarSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBarSlice");
            } else {
                navBarSlice = navBarSlice2;
            }
            navBarSlice.f0();
        }
    }

    public final void B3(boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            List<cr8> list = this.w;
            boolean z3 = false;
            if (list != null && !list.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return;
            }
            for (cr8 cr8Var : this.w) {
                cr8Var.e2(this.v, z);
            }
            if (r3()) {
                AibotChatDetail aibotChatDetail = this.u;
                Integer num = null;
                if (aibotChatDetail == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatDetail");
                    aibotChatDetail = null;
                }
                List<AbilityItem> defaultSug = aibotChatDetail.getDefaultSug();
                if (((defaultSug == null || defaultSug.isEmpty()) ? true : true) && s3()) {
                    lr8 lr8Var = lr8.a;
                    String str = this.f;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("paid");
                        str = null;
                    }
                    AibotArgs aibotArgs = this.k;
                    if (aibotArgs != null) {
                        num = aibotArgs.getPageSource();
                    }
                    lr8Var.b(3, str, num);
                }
            }
        }
    }

    public final void C3(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
            ar8.a.a("showError", Integer.valueOf(i2), str);
            hideLoadingView(getView());
            this.loadingView = null;
            if (i2 == 2930005) {
                showNetRefreshViewNoClickWithTitle(getView(), str, false);
            } else {
                showNetRefreshView(getView(), null, false);
            }
            fk5 fk5Var = this.mRefreshView;
            if (fk5Var != null) {
                fk5Var.getAttachedView().setClickable(false);
                this.mRefreshView.l(UtilHelper.getStatusBarHeight());
                this.mRefreshView.e(R.color.transparent);
            }
        }
    }

    @Override // com.baidu.tieba.zq8
    public void G() {
        FragmentActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.baidu.tieba.zq8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            BackSlice backSlice = this.s;
            if (backSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backSlice");
                backSlice = null;
            }
            backSlice.f0();
        }
    }

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            AibotChatDetail aibotChatDetail = this.u;
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

    public final lq8 o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return (lq8) this.t.getValue();
        }
        return (lq8) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onNetRefreshButtonClicked();
            ar8.a.a("onNetRefreshButtonClicked");
            AibotChatRepo aibotChatRepo = this.p;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            aibotChatRepo.l0(this.C);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            ar8.a.a(MissionEvent.MESSAGE_PAUSE);
            ChatStatusManager.getInst().setIsOpen(0, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onResume();
            ar8.a.a("onResume");
            ChatStatusManager.getInst().setIsOpen(0, true);
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            hideNetRefreshView(getView());
            FragmentAibotChatBinding fragmentAibotChatBinding = null;
            this.mRefreshView = null;
            FragmentAibotChatBinding fragmentAibotChatBinding2 = this.l;
            if (fragmentAibotChatBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAibotChatBinding = fragmentAibotChatBinding2;
            }
            fragmentAibotChatBinding.c.setVisibility(4);
        }
    }

    public final boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.u != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.v == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void w3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            o3().a(new AibotSugHandler(this));
            o3().a(new hr8(this));
        }
    }

    @Override // com.baidu.tieba.zq8
    public void L(int i2, int i3, String str) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i2, i3, str) == null) {
            if (2 == i2 && !s3()) {
                lr8.a.c(6);
            }
            if (2 == i2 && !m3()) {
                this.m.w3();
                return;
            }
            String str2 = null;
            if (2 == i2 && s3()) {
                lr8 lr8Var = lr8.a;
                String str3 = this.f;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paid");
                    str3 = null;
                }
                AibotArgs aibotArgs = this.k;
                if (aibotArgs != null) {
                    num = aibotArgs.getPageSource();
                } else {
                    num = null;
                }
                lr8Var.b(4, str3, num);
            }
            if (k3(i3) && s3()) {
                if (str != null) {
                    String str4 = this.e;
                    if (str4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("botUk");
                    } else {
                        str2 = str4;
                    }
                    y3(str, "3", str2);
                }
            } else if (!k3(i3) && !s3()) {
                if (str != null) {
                    String str5 = this.e;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("botUk");
                    } else {
                        str2 = str5;
                    }
                    y3(str, "2", str2);
                }
            } else {
                this.v = i3;
                B3(true);
                ChatSlice chatSlice = this.q;
                if (chatSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                    chatSlice = null;
                }
                AibotSugSlice aibotSugSlice = this.r;
                if (aibotSugSlice == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                    aibotSugSlice = null;
                }
                AibotChatDetail.TopicInfo i0 = aibotSugSlice.i0();
                if (i0 != null) {
                    str2 = i0.getTopicName();
                }
                chatSlice.x0(new ChatSlice.PageStateExt(str2, str));
            }
        }
    }

    @Override // com.baidu.tieba.zq8
    public void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("componentName", "bottomBackButton");
            jSONObject2.put("isHidden", 1);
            jSONObject2.put("height", i2);
            jSONArray.put(jSONObject2);
            jSONObject.put("notifyUIChange", jSONArray);
            ChatSlice chatSlice = this.q;
            if (chatSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                chatSlice = null;
            }
            nr8 m0 = chatSlice.m0();
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "msgJson.toString()");
            m0.c("aibotNA.notifyUIChange", jSONObject3);
        }
    }

    public final void l3(String uk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, uk) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            AibotChatRepo aibotChatRepo = this.p;
            AibotChatRepo aibotChatRepo2 = null;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            List<AibotChatDetail.BotList> h0 = aibotChatRepo.h0();
            AibotChatRepo aibotChatRepo3 = this.p;
            if (aibotChatRepo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo3 = null;
            }
            AibotChatDetail.BotList g0 = aibotChatRepo3.g0(uk, h0);
            if (g0 != null) {
                v3(g0.getUk(), String.valueOf(g0.getPaid()), u3(g0));
            }
            AibotChatRepo aibotChatRepo4 = this.p;
            if (aibotChatRepo4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo4 = null;
            }
            aibotChatRepo4.n0(uk);
            AibotChatRepo aibotChatRepo5 = this.p;
            if (aibotChatRepo5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
            } else {
                aibotChatRepo2 = aibotChatRepo5;
            }
            aibotChatRepo2.l0(this.C);
        }
    }

    @Override // com.baidu.tieba.zq8
    public void v0(String uk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, uk) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            String str = this.e;
            ChatSlice chatSlice = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str = null;
            }
            if (!rd.isEquals(uk, str)) {
                l3(uk);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bot_uk", uk);
            ChatSlice chatSlice2 = this.q;
            if (chatSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
            } else {
                chatSlice = chatSlice2;
            }
            nr8 m0 = chatSlice.m0();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "msg.toString()");
            m0.c("clientChangeBotMsg", jSONObject2);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ar8.a.a("onActivityCreated 开始");
            NavBarSlice navBarSlice = new NavBarSlice();
            FragmentAibotChatBinding fragmentAibotChatBinding = this.l;
            BackgroundSlice backgroundSlice = null;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            ViewGroup viewGroup = fragmentAibotChatBinding.g;
            Intrinsics.checkNotNullExpressionValue(viewGroup, "binding.navbarSlice");
            G2(viewGroup, navBarSlice);
            this.w.add(navBarSlice);
            this.o = navBarSlice;
            AibotArgs aibotArgs = this.k;
            if (aibotArgs != null) {
                TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
                Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
                String str2 = this.e;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("botUk");
                    str = null;
                } else {
                    str = str2;
                }
                AibotChatRepo aibotChatRepo = new AibotChatRepo(pageContext, str, this.h, this.i, aibotArgs.getShowBotList());
                FragmentAibotChatBinding fragmentAibotChatBinding2 = this.l;
                if (fragmentAibotChatBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentAibotChatBinding2 = null;
                }
                ViewGroup root = fragmentAibotChatBinding2.getRoot();
                Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                G2(root, aibotChatRepo);
                aibotChatRepo.l0(this.C);
                aibotChatRepo.p0(this.A);
                this.p = aibotChatRepo;
            }
            BackgroundSlice backgroundSlice2 = new BackgroundSlice(this, this.k);
            FragmentAibotChatBinding fragmentAibotChatBinding3 = this.l;
            if (fragmentAibotChatBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding3 = null;
            }
            ViewGroup viewGroup2 = fragmentAibotChatBinding3.i;
            Intrinsics.checkNotNullExpressionValue(viewGroup2, "binding.viewBg");
            G2(viewGroup2, backgroundSlice2);
            if (!this.w.contains(backgroundSlice2)) {
                this.w.add(backgroundSlice2);
            }
            this.n = backgroundSlice2;
            FragmentAibotChatBinding fragmentAibotChatBinding4 = this.l;
            if (fragmentAibotChatBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding4 = null;
            }
            fragmentAibotChatBinding4.d.setEventCallback(new f(this));
            String str3 = this.e;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str3 = null;
            }
            String str4 = this.f;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paid");
                str4 = null;
            }
            AibotChatRepo aibotChatRepo2 = this.p;
            if (aibotChatRepo2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo2 = null;
            }
            ChatSlice chatSlice = new ChatSlice(str3, str4, aibotChatRepo2, this.k);
            FragmentAibotChatBinding fragmentAibotChatBinding5 = this.l;
            if (fragmentAibotChatBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding5 = null;
            }
            ViewGroup viewGroup3 = fragmentAibotChatBinding5.e;
            Intrinsics.checkNotNullExpressionValue(viewGroup3, "binding.chatSlice");
            G2(viewGroup3, chatSlice);
            if (!this.w.contains(chatSlice)) {
                this.w.add(chatSlice);
            }
            this.q = chatSlice;
            TbPageContext<BaseFragmentActivity> pageContext2 = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext2, "pageContext");
            FragmentAibotChatBinding fragmentAibotChatBinding6 = this.l;
            if (fragmentAibotChatBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding6 = null;
            }
            FrameLayout frameLayout = fragmentAibotChatBinding6.h;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.sugSlice");
            AibotSugSlice aibotSugSlice = new AibotSugSlice(pageContext2, frameLayout, o3());
            FragmentAibotChatBinding fragmentAibotChatBinding7 = this.l;
            if (fragmentAibotChatBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding7 = null;
            }
            ViewGroup viewGroup4 = fragmentAibotChatBinding7.h;
            Intrinsics.checkNotNullExpressionValue(viewGroup4, "binding.sugSlice");
            G2(viewGroup4, aibotSugSlice);
            if (!this.w.contains(aibotSugSlice)) {
                this.w.add(aibotSugSlice);
            }
            this.r = aibotSugSlice;
            q3();
            BackSlice backSlice = new BackSlice(this, this.k);
            FragmentAibotChatBinding fragmentAibotChatBinding8 = this.l;
            if (fragmentAibotChatBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding8 = null;
            }
            ViewGroup viewGroup5 = fragmentAibotChatBinding8.b;
            Intrinsics.checkNotNullExpressionValue(viewGroup5, "binding.bottomBackSlice");
            G2(viewGroup5, backSlice);
            this.s = backSlice;
            AibotArgs aibotArgs2 = this.k;
            if (aibotArgs2 != null) {
                int n3 = n3(aibotArgs2.getPageState());
                this.v = n3;
                if (n3 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.x = z;
                B3(false);
                BackgroundSlice backgroundSlice3 = this.n;
                if (backgroundSlice3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bgSlice");
                } else {
                    backgroundSlice = backgroundSlice3;
                }
                backgroundSlice.k0(aibotArgs2.getChatPageBgUrl(), aibotArgs2.getPersonPageBgUrl(), false);
            }
            w3();
            ar8.a.a("onActivityCreated 结束");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        AibotArgs aibotArgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            super.onCreate(bundle);
            ar8.a.a("onCreate 开始");
            String string = requireArguments().getString("botUk");
            String str = "";
            if (string == null) {
                string = "";
            }
            String string2 = requireArguments().getString("paid");
            if (string2 != null) {
                str = string2;
            }
            Serializable serializable = requireArguments().getSerializable("argsData");
            if (serializable instanceof AibotArgs) {
                aibotArgs = (AibotArgs) serializable;
            } else {
                aibotArgs = null;
            }
            v3(string, str, aibotArgs);
            registerListener(2921816, this.z);
            registerListener(2921817, this.z);
            registerListener(2921820, this.z);
            registerListener(2921830, this.z);
            mr8.b.a(this.D);
            mr8.b.a(this.F);
            mr8.b.a(this.G);
            mr8.b.a(this.E);
            ar8.a.a("onCreate 结束");
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            FragmentAibotChatBinding it = FragmentAibotChatBinding.c(inflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this.l = it;
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            FragmentAibotChatBinding fragmentAibotChatBinding = this.l;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            ViewCommonUtil.setViewMargin(fragmentAibotChatBinding.g, -1, statusBarHeight, -1, -1);
            RelativeLayout root = it.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "inflate(inflater, contai…h, -1, -1)\n        }.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onDestroy();
            ar8.a.a(MissionEvent.MESSAGE_DESTROY);
            zr8.r = 0;
            MessageManager.getInstance().unRegisterListener(this.z);
            mr8.b.b(this.D);
            mr8.b.b(this.F);
            mr8.b.b(this.G);
            mr8.b.b(this.E);
            this.w.clear();
        }
    }

    public final void q3() {
        String str;
        Integer num;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            InputSlice inputSlice = this.m;
            FragmentAibotChatBinding fragmentAibotChatBinding = this.l;
            if (fragmentAibotChatBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding = null;
            }
            RelativeLayout root = fragmentAibotChatBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            FragmentAibotChatBinding fragmentAibotChatBinding2 = this.l;
            if (fragmentAibotChatBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAibotChatBinding2 = null;
            }
            LinearLayout linearLayout = fragmentAibotChatBinding2.c;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.bottomView");
            String str3 = this.g;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uid");
                str = null;
            } else {
                str = str3;
            }
            AibotArgs aibotArgs = this.k;
            if (aibotArgs != null) {
                num = aibotArgs.getPageSource();
            } else {
                num = null;
            }
            String str4 = this.f;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paid");
                str2 = null;
            } else {
                str2 = str4;
            }
            inputSlice.b3(this, root, linearLayout, str, num, str2);
            this.m.r3(this.H);
            qt5.a(getChildFragmentManager(), R.id.obfuscated_res_0x7f0911b3, this.m);
            if (!this.w.contains(this.m)) {
                this.w.add(this.m);
            }
        }
    }

    public final void t3(int i2, float f2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), str}) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("height", Integer.valueOf(i2));
            hashMap.put("animationDuration", Float.valueOf(f2));
            hashMap.put("actionType", str);
            ChatSlice chatSlice = this.q;
            if (chatSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
                chatSlice = null;
            }
            chatSlice.m0().a("keyboardHeightChange", hashMap);
            ar8.a.a("heightChange", hashMap);
        }
    }

    public final void v3(String uk, String pid, AibotArgs aibotArgs) {
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, uk, pid, aibotArgs) == null) {
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(pid, "pid");
            this.e = uk;
            this.f = pid;
            String str = null;
            if (uk == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                uk = null;
            }
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(uk);
            Intrinsics.checkNotNullExpressionValue(bdUidFromBdUK, "getBdUidFromBdUK(botUk)");
            this.g = bdUidFromBdUK;
            MessageCenterAIBotService a2 = MessageCenterAIBotService.b.a();
            String str2 = this.f;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paid");
                str2 = null;
            }
            String str3 = this.e;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("botUk");
                str3 = null;
            }
            a2.h(str2, str3);
            MessageCenterAIBotService a3 = MessageCenterAIBotService.b.a();
            String str4 = this.g;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("uid");
                str4 = null;
            }
            a3.g(str4);
            InputSlice inputSlice = this.m;
            if (inputSlice != null) {
                String str5 = this.g;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uid");
                    str5 = null;
                }
                inputSlice.u3(str5);
            }
            InputSlice inputSlice2 = this.m;
            if (inputSlice2 != null) {
                String str6 = this.f;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paid");
                    str6 = null;
                }
                inputSlice2.t3(str6);
            }
            InputSlice inputSlice3 = this.m;
            if (inputSlice3 != null) {
                if (aibotArgs != null) {
                    num = aibotArgs.getPageSource();
                } else {
                    num = null;
                }
                inputSlice3.s3(num);
            }
            this.k = aibotArgs;
            if (aibotArgs != null) {
                this.i = String.valueOf(aibotArgs.getForumId());
                this.h = String.valueOf(aibotArgs.getPageSource());
                this.j = aibotArgs.getChatPageBgUrl();
                Long forumId = aibotArgs.getForumId();
                if (forumId != null) {
                    long longValue = forumId.longValue();
                    ds8 a4 = ds8.d.a();
                    String valueOf = String.valueOf(longValue);
                    String str7 = this.e;
                    if (str7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("botUk");
                        str7 = null;
                    }
                    String str8 = this.f;
                    if (str8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("paid");
                    } else {
                        str = str8;
                    }
                    a4.f(valueOf, str7, str, this.j);
                }
            }
        }
    }

    public void x3(String msgContent, String type) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, msgContent, type) == null) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            Intrinsics.checkNotNullParameter(type, "type");
            if (!m3()) {
                return;
            }
            ar8.a.a("sendMsg", msgContent);
            AibotSugSlice aibotSugSlice = this.r;
            ChatSlice chatSlice = null;
            if (aibotSugSlice == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aibotSugSlice");
                aibotSugSlice = null;
            }
            aibotSugSlice.l0();
            E3(false);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", msgContent);
            jSONObject.put("type", type);
            ChatSlice chatSlice2 = this.q;
            if (chatSlice2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatSlice");
            } else {
                chatSlice = chatSlice2;
            }
            nr8 m0 = chatSlice.m0();
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "msg.toString()");
            m0.c("aiChatInputMsg", jSONObject2);
        }
    }

    public final void y3(String msgContent, String type, String uk) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048612, this, msgContent, type, uk) == null) {
            Intrinsics.checkNotNullParameter(msgContent, "msgContent");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(uk, "uk");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("botUk", uk);
                jSONObject.put("sendType", type);
                jSONObject.put("sendText", msgContent);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921830, jSONObject));
        }
    }

    public final void z3(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            ar8.a.a("sendTextMsg", content);
            AibotChatRepo aibotChatRepo = this.p;
            if (aibotChatRepo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repo");
                aibotChatRepo = null;
            }
            aibotChatRepo.m0(content, new k(this));
        }
    }
}
