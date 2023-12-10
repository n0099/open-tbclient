package com.baidu.tieba.im.biz.aibot.inputslice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.net.FastRequest;
import com.baidu.tieba.R;
import com.baidu.tieba.bs8;
import com.baidu.tieba.c09;
import com.baidu.tieba.cr8;
import com.baidu.tieba.cs8;
import com.baidu.tieba.f59;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.biz.aibot.inputslice.InputSlice;
import com.baidu.tieba.im.biz.aibot.keyboardtool.PanelType;
import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.baidu.tieba.impersonal.databinding.SliceInputBinding;
import com.baidu.tieba.lr8;
import com.baidu.tieba.lu4;
import com.baidu.tieba.rd;
import com.baidu.tieba.uoc;
import com.baidu.tieba.wr8;
import com.baidu.tieba.xr8;
import com.baidu.tieba.yr8;
import com.baidu.tieba.zq8;
import com.baidu.tieba.zr8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u0006H\u0016J\u0010\u0010[\u001a\u00020X2\u0006\u0010\\\u001a\u00020'H\u0002J\b\u0010]\u001a\u00020XH\u0002J\b\u0010^\u001a\u00020\u0006H\u0016J\b\u0010_\u001a\u00020\u0006H\u0016J\b\u0010`\u001a\u00020aH\u0016J\b\u0010b\u001a\u00020XH\u0003J\b\u0010c\u001a\u00020XH\u0002JA\u0010d\u001a\u00020X2\u0006\u0010e\u001a\u00020V2\u0006\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u00142\u0006\u0010h\u001a\u00020\"2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010j\u001a\u00020\"¢\u0006\u0002\u0010kJ\u0010\u0010l\u001a\u00020X2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010m\u001a\u00020'2\u0006\u0010n\u001a\u00020.H\u0002J\b\u0010o\u001a\u00020'H\u0002J\u0012\u0010p\u001a\u00020X2\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\u0010\u0010s\u001a\u00020X2\u0006\u0010t\u001a\u00020uH\u0016J$\u0010v\u001a\u00020a2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u00142\b\u0010q\u001a\u0004\u0018\u00010rH\u0016J\b\u0010z\u001a\u00020XH\u0016J\u0010\u0010{\u001a\u00020X2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010|\u001a\u00020X2\u0006\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020'H\u0016J\b\u0010\u007f\u001a\u00020XH\u0016J\t\u0010\u0080\u0001\u001a\u00020XH\u0016J\u0007\u0010\u0081\u0001\u001a\u00020XJ\u0011\u0010\u0082\u0001\u001a\u00020X2\u0006\u0010n\u001a\u00020.H\u0002J\t\u0010\u0083\u0001\u001a\u00020XH\u0002J\t\u0010\u0084\u0001\u001a\u00020XH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020X2\u0007\u0010\u0086\u0001\u001a\u00020\"H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020X2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0088\u0001\u001a\u00020X2\u0007\u0010\u0089\u0001\u001a\u00020'H\u0002J\u0007\u0010\u008a\u0001\u001a\u00020XJ\u0007\u0010\u008b\u0001\u001a\u00020XJ\u0015\u0010\u008c\u0001\u001a\u00020X2\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J*\u0010\u008f\u0001\u001a\u00020X2\u001f\u0010\u008d\u0001\u001a\u001a\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0-H\u0016J\u0007\u0010\u0090\u0001\u001a\u00020XR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010,\u001a\u001c\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010L\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010A\"\u0004\bN\u0010CR\u001a\u0010O\u001a\u00020PX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0091\u0001"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice;", "Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputPanel;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "()V", "APPLY_WHITELIST_USER", "", "APPROVED_USER", "APPROVE_REJECT_USER", "APPROVING_USER", "INPUT_VIEW_MAX_LENGTH", "START_HEIGHT", "", "alertBuilder", "Lcom/baidu/tbadk/core/dialog/TBAlertBuilder;", "applyInternalRequest", "Lcom/baidu/tbadk/net/FastRequest;", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "mBodyView", "Landroid/view/ViewGroup;", "mChatChangeHeight", "mHybridNotifyListener", "Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "getMHybridNotifyListener", "()Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "mInputChangeHeight", "mInputComCallback", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "getMInputComCallback", "()Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "setMInputComCallback", "(Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;)V", "mInputText", "", "mInputView", "Landroid/widget/EditText;", "mInputViewHeight", "mIsKeyBoardShow", "", "getMIsKeyBoardShow", "()Z", "setMIsKeyBoardShow", "(Z)V", "mKeyboardCallBack", "Lrx/functions/Action4;", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/PanelType;", "mKeyboardHelper", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/KeyboardHelper;", "mKeyboardStateListener", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/OnKeyboardStateListener;", "mLastPanelType", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "mPageSource", "getMPageSource", "()Ljava/lang/Integer;", "setMPageSource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mPageState", "mPaid", "getMPaid", "()Ljava/lang/String;", "setMPaid", "(Ljava/lang/String;)V", "mPanelType", "mParentRootView", "mSoftKeyListener", "Landroid/view/View$OnKeyListener;", "mTextInputLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mTextInputListener", "Landroid/text/TextWatcher;", "mUid", "getMUid", "setMUid", "sliceInputBinding", "Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;", "getSliceInputBinding", "()Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;", "setSliceInputBinding", "(Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;)V", "wrapper", "Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;", "afterSendTextMsg", "", CommonTbJsBridge.CHANGE_SKIN_TYPE, WriteMulitImageActivityConfig.SKIN_TYPE, "checkSendIconClickAble", "canSend", "createDraft", "getInoutViewDiffHeight", "getPanelHeight", "getViewContainer", "Landroid/view/View;", "initEdittextParam", "initKeyboardHelper", "initViewParams", "wrap", "parentRootView", "bodyView", "uid", AiBotChatDispatcher.AI_SINGLE_FROM, "paid", "(Lcom/baidu/tieba/im/biz/aibot/AibotChatPageWrapper;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "inputViewShowState", "interceptInputRefresh", "panel", "isChatPageState", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", MissionEvent.MESSAGE_DESTROY, "onSetChatDetail", "onSetPageState", "state", "refreshPage", "onSoftKeyboardClosed", "onSoftKeyboardOpened", "refreshInputData", "refreshState", "requestApplyInternal", "reset", "setDraft", MediaTrackConfig.AE_IMPORT_DRAFT, "setInputViewConfig", "setInputViewLimit", Constants.EXTRA_CONFIG_LIMIT, "setInputViewWithNormal", "setInputViewWithOneLine", "setOnInputStateChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/OnInputPanelStateChangedListener;", "setOnLayoutAnimatorHandleListener", "showInternalDialog", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputSlice extends SliceFragment implements yr8, cr8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewGroup A;
    public String B;
    public String C;
    public zq8 D;
    public Integer E;
    public EditText F;
    public final cs8 G;
    public final View.OnClickListener H;
    public final View.OnTouchListener I;
    public final TextWatcher J;
    public final ViewTreeObserver.OnGlobalLayoutListener K;
    public final lu4.d L;
    public final View.OnKeyListener M;
    public SliceInputBinding e;
    public uoc<PanelType, PanelType, Float, Float> f;
    public final zr8 g;
    public PanelType h;
    public AibotChatDetail i;
    public final int j;
    public final float k;
    public PanelType l;
    public wr8 m;
    public String n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public TBAlertBuilder s;
    public FastRequest t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public int y;
    public ViewGroup z;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-559082504, "Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-559082504, "Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice$a;");
                    return;
                }
            }
            int[] iArr = new int[PanelType.values().length];
            iArr[PanelType.NONE.ordinal()] = 1;
            iArr[PanelType.INPUT_KEYBOARD.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.baidu.tieba.yr8
    public void b2(bs8 bs8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bs8Var) == null) {
        }
    }

    @Override // com.baidu.tieba.vr8
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements lu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        @Override // com.baidu.tieba.lu4.d
        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "aibot.unqualifiedUserClick" : (String) invokeV.objValue;
        }

        public b(InputSlice inputSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputSlice;
        }

        @Override // com.baidu.tieba.lu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.w3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements cs8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        @Override // com.baidu.tieba.cs8
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public c(InputSlice inputSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputSlice;
        }

        @Override // com.baidu.tieba.cs8
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                String X2 = this.a.X2();
                if (X2 != null) {
                    lr8.a.b(2, X2, this.a.W2());
                }
                TbSingleton.getInstance().setKeyboardHeight(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        public d(InputSlice inputSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputSlice;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !Intrinsics.areEqual(view2, this.a.Y2().e)) {
                return;
            }
            this.a.S2();
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
            }
        }

        public e(InputSlice inputSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputSlice;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (StringUtils.isNull(s.toString())) {
                    this.a.T2(false);
                } else {
                    this.a.T2(true);
                }
                this.a.n = s.toString();
                this.a.U2();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.a.q == 0 && this.a.Y2().d.getLineCount() != 0) {
                    InputSlice inputSlice = this.a;
                    inputSlice.q = inputSlice.Y2().d.getHeight() / this.a.Y2().d.getLineCount();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends FastRequest.b<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice d;

        public f(InputSlice inputSlice) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputSlice};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = inputSlice;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: l */
        public void f(int i, String errMsg, Unit unit) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, errMsg, unit) == null) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                super.f(i, errMsg, unit);
                String string = TbadkCoreApplication.getInst().getString(R.string.internal_testing_experience_error);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(\n   …testing_experience_error)");
                f59.a(this.d.getPageContext().getPageActivity(), Boolean.FALSE, string);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.net.FastRequest.b
        /* renamed from: m */
        public void i(Unit result) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, result) == null) {
                Intrinsics.checkNotNullParameter(result, "result");
                super.i(result);
                String string = TbadkCoreApplication.getInst().getString(R.string.internal_testing_experience_success);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(\n   …sting_experience_success)");
                f59.a(this.d.getPageContext().getPageActivity(), Boolean.TRUE, string);
                this.d.Y2().d.setHint(R.string.internal_testing_experience_qualification_progress);
                AibotChatDetail aibotChatDetail = this.d.i;
                if (aibotChatDetail != null) {
                    aibotChatDetail.setAuditStatus(this.d.w);
                }
                EMManager.from(this.d.Y2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0614));
                this.d.o3(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSlice() {
        super(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((Slice) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = new zr8();
        PanelType panelType = PanelType.NONE;
        this.h = panelType;
        this.j = 400;
        this.l = panelType;
        this.o = 66;
        this.v = 1;
        this.w = 2;
        this.x = 3;
        this.y = 2;
        this.E = 0;
        this.G = new c(this);
        this.H = new d(this);
        this.I = new View.OnTouchListener() { // from class: com.baidu.tieba.sr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? InputSlice.f3(InputSlice.this, view2, motionEvent) : invokeLL.booleanValue;
            }
        };
        this.J = new e(this);
        this.K = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.or8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    InputSlice.i3(InputSlice.this);
                }
            }
        };
        this.L = new b(this);
        this.M = new View.OnKeyListener() { // from class: com.baidu.tieba.rr8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i3, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view2, i3, keyEvent)) == null) ? InputSlice.h3(InputSlice.this, view2, i3, keyEvent) : invokeLIL.booleanValue;
            }
        };
    }

    public final void a3() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && getContext() != null && this.z != null && this.A != null && (context = getContext()) != null) {
            if (TbSingleton.getInstance().getKeyboardHeight() == 0) {
                TbSingleton.getInstance().setKeyboardHeight((xr8.b(context) / 5) * 2);
            }
            zr8 zr8Var = this.g;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            zr8Var.l(requireContext);
            ViewGroup viewGroup = this.z;
            if (viewGroup != null) {
                this.g.j(viewGroup);
            }
            ViewGroup viewGroup2 = this.A;
            if (viewGroup2 != null) {
                this.g.g(viewGroup2);
            }
            zr8 zr8Var2 = this.g;
            zr8Var2.h(this);
            zr8Var2.o(TbSingleton.getInstance().getKeyboardHeight());
            zr8Var2.q(true);
            zr8Var2.p(this.G);
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            Y2().d.setVisibility(8);
            if (Y2().e.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = Y2().e.getLayoutParams();
                if (layoutParams != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(8, R.id.obfuscated_res_0x7f0911b2);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            Y2().c.setVisibility(0);
            if (rd.isEmpty(this.n)) {
                p3();
            } else {
                Y2().c.setText(this.n);
            }
        }
    }

    @Override // com.baidu.tieba.cr8
    public void O(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            try {
                this.i = chatDetail;
                n3(chatDetail);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.changeSkinType(i);
            if (StringUtils.isNull(this.n)) {
                T2(false);
            } else {
                T2(true);
            }
            TBAlertBuilder tBAlertBuilder = this.s;
            if (tBAlertBuilder != null) {
                Intrinsics.checkNotNull(tBAlertBuilder);
                tBAlertBuilder.onChangeSkinType();
            }
        }
    }

    public final boolean d3(PanelType panelType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, panelType)) == null) {
            if (!e3() && panelType != PanelType.NONE) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void m3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.n = str;
            Y2().d.setText(str);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            this.g.n();
        }
    }

    public final void r3(wr8 wr8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, wr8Var) == null) {
            this.m = wr8Var;
        }
    }

    public final void s3(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, num) == null) {
            this.E = num;
        }
    }

    public final void t3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.C = str;
        }
    }

    public final void u3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.B = str;
        }
    }

    public final void v3(SliceInputBinding sliceInputBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, sliceInputBinding) == null) {
            Intrinsics.checkNotNullParameter(sliceInputBinding, "<set-?>");
            this.e = sliceInputBinding;
        }
    }

    @Override // com.baidu.tieba.yr8
    public void y(uoc<PanelType, PanelType, Float, Float> listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.f = listener;
        }
    }

    public static final void x3(InputSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.l3();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (((r5 == null || r5.getAuditStatus() != r4.u) ? false : false) != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean f3(final InputSlice this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(view2, this$0.Y2().c)) {
                this$0.Y2().d.setVisibility(0);
            }
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action != 0) {
                if (action == 1) {
                    view2.performClick();
                }
            } else {
                AibotChatDetail aibotChatDetail = this$0.i;
                if (aibotChatDetail != null && aibotChatDetail.getAuditStatus() == this$0.x) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    AibotChatDetail aibotChatDetail2 = this$0.i;
                }
                this$0.l3();
                if (!this$0.e3()) {
                    lr8.a.c(7);
                    if (this$0.Y2().d.isFocusable()) {
                        wr8 wr8Var = this$0.m;
                        if (wr8Var != null) {
                            wr8Var.b();
                        }
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.qr8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    InputSlice.g3(InputSlice.this);
                                }
                            }
                        }, 240L);
                    }
                } else if (this$0.Y2().d.isFocusable()) {
                    SpanGroupEditText spanGroupEditText = this$0.Y2().d;
                    spanGroupEditText.requestFocus();
                    BdUtilHelper.showSoftKeyPad(spanGroupEditText.getContext(), spanGroupEditText);
                    if (this$0.g.m() && !this$0.d3(PanelType.INPUT_KEYBOARD)) {
                        this$0.k3(PanelType.INPUT_KEYBOARD);
                        this$0.p3();
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static final void g3(InputSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SpanGroupEditText spanGroupEditText = this$0.Y2().d;
            spanGroupEditText.requestFocus();
            BdUtilHelper.showSoftKeyPad(spanGroupEditText.getContext(), spanGroupEditText);
            if (this$0.g.m() && !this$0.d3(PanelType.INPUT_KEYBOARD)) {
                this$0.k3(PanelType.INPUT_KEYBOARD);
                this$0.p3();
            }
        }
    }

    public final void T2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (!z) {
                Y2().e.setAlpha(0.5f);
                Y2().e.setClickable(false);
                return;
            }
            Y2().e.setAlpha(1.0f);
            Y2().e.setClickable(true);
        }
    }

    public final void o3(boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            ImageView imageView = Y2().e;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            Y2().d.setFocusable(!z);
            SpanGroupEditText spanGroupEditText = Y2().d;
            if (z) {
                i2 = 17;
            } else {
                i2 = GravityCompat.START;
            }
            spanGroupEditText.setGravity(i2);
        }
    }

    public static final boolean h3(InputSlice this$0, View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65548, null, this$0, view2, i, keyEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (keyEvent.getAction() == 0 && i == 6 && !this$0.d3(PanelType.NONE)) {
                this$0.k3(PanelType.NONE);
                this$0.q3();
                return false;
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public static final void i3(InputSlice this$0) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.r) {
                i = zr8.m;
            } else {
                i = 0;
            }
            zr8.s = Math.abs(this$0.o - this$0.Y2().d.getHeight());
            if (this$0.o > this$0.Y2().d.getHeight()) {
                int height = (i + this$0.o) - this$0.Y2().d.getHeight();
                this$0.p = height;
                wr8 wr8Var = this$0.m;
                if (wr8Var != null) {
                    wr8Var.a(height, 0.1f, "1");
                }
            } else if (this$0.o < this$0.Y2().d.getHeight()) {
                int height2 = (i + this$0.Y2().d.getHeight()) - this$0.o;
                this$0.p = height2;
                wr8 wr8Var2 = this$0.m;
                if (wr8Var2 != null) {
                    wr8Var2.a(height2, 0.1f, "1");
                }
            }
            this$0.o = this$0.Y2().d.getHeight();
        }
    }

    public final void n3(AibotChatDetail aibotChatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, aibotChatDetail) == null) {
            c3(aibotChatDetail);
            Y2().d.setFilters(new InputFilter[]{new c09(getPageContext(), this.j)});
            if (Build.VERSION.SDK_INT >= 29 && (ContextCompat.getDrawable(requireContext(), R.drawable.obfuscated_res_0x7f0801ef) instanceof GradientDrawable)) {
                Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.obfuscated_res_0x7f0801ef);
                if (drawable != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                    gradientDrawable.setColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                    Y2().d.setTextCursorDrawable(gradientDrawable);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            }
            j3();
            WebPManager.setPureDrawableByColorInt(Y2().e, R.drawable.obfuscated_res_0x7f0813f1, Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()), WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.yr8
    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RelativeLayout root = Y2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "sliceInputBinding.root");
            return root;
        }
        return (View) invokeV.objValue;
    }

    public final void U2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.n != null) {
            TbSingleton.getInstance().setAiBotDraft(this.B, this.n);
        }
    }

    public final boolean V2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.r;
        }
        return invokeV.booleanValue;
    }

    public final Integer W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.E;
        }
        return (Integer) invokeV.objValue;
    }

    public final String X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public final SliceInputBinding Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SliceInputBinding sliceInputBinding = this.e;
            if (sliceInputBinding != null) {
                return sliceInputBinding;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sliceInputBinding");
            return null;
        }
        return (SliceInputBinding) invokeV.objValue;
    }

    public final boolean e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.y == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vr8
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return Math.abs(this.q - Y2().d.getHeight());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            lu4.b.a().e(this.L);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.vr8
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return zr8.n;
        }
        return invokeV.intValue;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !rd.isEmpty(this.n)) {
            wr8 wr8Var = this.m;
            if (wr8Var != null) {
                String str = this.n;
                Intrinsics.checkNotNull(str);
                wr8Var.c(str, "1");
            }
            Y2().d.setText((CharSequence) null);
            p3();
        }
    }

    @Override // com.baidu.tieba.yr8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.r = true;
            zq8 zq8Var = this.D;
            if (zq8Var != null) {
                zq8Var.e();
            }
            if (d3(PanelType.INPUT_KEYBOARD)) {
                return;
            }
            k3(PanelType.INPUT_KEYBOARD);
            p3();
            int i = zr8.m;
            this.p = i;
            wr8 wr8Var = this.m;
            if (wr8Var != null) {
                wr8Var.a(i, 0.25f, "1");
            }
        }
    }

    @Override // com.baidu.tieba.yr8
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.r = false;
            zq8 zq8Var = this.D;
            if (zq8Var != null) {
                zq8Var.h();
            }
            if (d3(PanelType.NONE)) {
                return;
            }
            k3(PanelType.NONE);
            q3();
            this.p = 0;
            wr8 wr8Var = this.m;
            if (wr8Var != null) {
                wr8Var.a(0, 0.25f, "1");
            }
        }
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (!rd.isEmpty(TbSingleton.getInstance().getAiBotDraft(this.B))) {
                String aiBotDraft = TbSingleton.getInstance().getAiBotDraft(this.B);
                Intrinsics.checkNotNull(aiBotDraft);
                m3(aiBotDraft);
            } else {
                m3("");
            }
            q3();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void Z2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            Y2().getRoot().setOnClickListener(this.H);
            Y2().d.setOnTouchListener(this.I);
            Y2().c.setOnTouchListener(this.I);
            Y2().e.setOnClickListener(this.H);
            Y2().d.addTextChangedListener(this.J);
            Y2().d.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
            Y2().d.setOnKeyListener(this.M);
        }
    }

    public final void l3() {
        AibotChatDetail aibotChatDetail;
        AibotChatDetail.UserInfo userInfo;
        String uk;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.t == null) {
                this.t = new FastRequest(getPageContext(), CmdConfigHttp.CMD_HTTP_APPLY_INNTERNAL, TbConfig.GET_AIBOT_APPLY_INTERNAL);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (aibotChatDetail = this.i) != null && (userInfo = aibotChatDetail.getUserInfo()) != null && (uk = userInfo.getUk()) != null) {
                FastRequest fastRequest = this.t;
                Intrinsics.checkNotNull(fastRequest);
                fastRequest.P("user_id", currentAccount);
                fastRequest.P("type", "aichat");
                fastRequest.P(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER, uk);
                fastRequest.R(new f(this));
                fastRequest.Q();
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Y2().d.setVisibility(0);
            if (Y2().e.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = Y2().e.getLayoutParams();
                if (layoutParams != null) {
                    ((RelativeLayout.LayoutParams) layoutParams).addRule(8, R.id.obfuscated_res_0x7f0911bd);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                }
            }
            Y2().c.setVisibility(8);
        }
    }

    public final void b3(zq8 wrap, ViewGroup parentRootView, ViewGroup bodyView, String uid, Integer num, String paid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{wrap, parentRootView, bodyView, uid, num, paid}) == null) {
            Intrinsics.checkNotNullParameter(wrap, "wrap");
            Intrinsics.checkNotNullParameter(parentRootView, "parentRootView");
            Intrinsics.checkNotNullParameter(bodyView, "bodyView");
            Intrinsics.checkNotNullParameter(uid, "uid");
            Intrinsics.checkNotNullParameter(paid, "paid");
            this.D = wrap;
            this.z = parentRootView;
            this.A = bodyView;
            this.B = uid;
            this.E = num;
            this.C = paid;
        }
    }

    public final void c3(AibotChatDetail aibotChatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aibotChatDetail) == null) {
            int auditStatus = aibotChatDetail.getAuditStatus();
            if (auditStatus == this.u) {
                SpanGroupEditText spanGroupEditText = Y2().d;
                String string = getString(R.string.internal_testing_experience_to_use);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.inter…esting_experience_to_use)");
                String string2 = getString(R.string.internal_testing_experience_to_chat);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.inter…sting_experience_to_chat)");
                spanGroupEditText.setHint(string + aibotChatDetail.getUserInfo().getName() + string2);
                spanGroupEditText.setHintTextColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                o3(true);
                EMManager.from(Y2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0901));
            } else if (auditStatus == this.v) {
                Y2().d.setHint(aibotChatDetail.getConfigData().getInputBoxPromptText());
                o3(false);
            } else if (auditStatus == this.w) {
                SpanGroupEditText spanGroupEditText2 = Y2().d;
                spanGroupEditText2.setHint(R.string.internal_testing_experience_qualification_progress);
                spanGroupEditText2.setHintTextColor(spanGroupEditText2.getResources().getColor(R.color.CAM_X0608));
                o3(true);
                EMManager.from(Y2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0614));
            } else if (auditStatus == this.x) {
                SpanGroupEditText spanGroupEditText3 = Y2().d;
                String string3 = getString(R.string.internal_testing_experience_to_use);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.inter…esting_experience_to_use)");
                String string4 = getString(R.string.internal_testing_experience_to_chat);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.inter…sting_experience_to_chat)");
                spanGroupEditText3.setHint(string3 + aibotChatDetail.getUserInfo().getName() + string4);
                spanGroupEditText3.setHintTextColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                o3(true);
                EMManager.from(Y2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0901));
            } else {
                Y2().d.setHint(aibotChatDetail.getConfigData().getInputBoxPromptText());
                o3(false);
            }
        }
    }

    @Override // com.baidu.tieba.cr8
    public void e2(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.y = i;
            if (this.F != null && !e3()) {
                h();
            }
        }
    }

    public final void k3(PanelType panelType) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, panelType) != null) || this.l == panelType) {
            return;
        }
        this.h = panelType;
        float f3 = this.k;
        int i = a.$EnumSwitchMapping$0[panelType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                f2 = f3;
            } else {
                f3 = this.k;
                f2 = -zr8.m;
            }
        } else {
            f3 = -zr8.m;
            f2 = this.k;
        }
        uoc<PanelType, PanelType, Float, Float> uocVar = this.f;
        if (uocVar != null) {
            Intrinsics.checkNotNull(uocVar);
            uocVar.b(this.h, this.l, Float.valueOf(f3), Float.valueOf(f2));
        }
        this.l = this.h;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
            a3();
            Z2();
            EMManager.from(Y2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0201));
            Y2().d.setTextColor(SkinManager.getColor(0, (int) R.color.CAM_X0105));
            Y2().d.setShowSoftInputOnFocus(false);
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048605, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            SliceInputBinding c2 = SliceInputBinding.c(inflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(inflater, container, false)");
            v3(c2);
            this.F = Y2().d;
            lu4.b.a().c(this.L);
            RelativeLayout root = Y2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "sliceInputBinding.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }

    public final void w3() {
        AibotChatDetail aibotChatDetail;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && (aibotChatDetail = this.i) != null) {
            int auditStatus = aibotChatDetail.getAuditStatus();
            if (auditStatus == this.u || auditStatus == this.x) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = TbadkApplication.getInst().getString(R.string.internal_testing_experience_desc);
                Intrinsics.checkNotNullExpressionValue(string, "getInst().getString(\n   …_testing_experience_desc)");
                String format = String.format(string, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(getPageContext().getPageActivity());
                this.s = tBAlertBuilder;
                Intrinsics.checkNotNull(tBAlertBuilder);
                tBAlertBuilder.setTitle(R.string.internal_testing_experience_title);
                TBAlertBuilder tBAlertBuilder2 = this.s;
                Intrinsics.checkNotNull(tBAlertBuilder2);
                tBAlertBuilder2.setDescStr(format);
                TBAlertBuilder tBAlertBuilder3 = this.s;
                Intrinsics.checkNotNull(tBAlertBuilder3);
                tBAlertBuilder3.setDescLightStyle(true);
                TBAlertBuilder tBAlertBuilder4 = this.s;
                Intrinsics.checkNotNull(tBAlertBuilder4);
                tBAlertBuilder4.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09ee, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.internal_testing_experience_confirm, TBAlertConfig.OperateBtnStyle.MAIN_BG, new View.OnClickListener() { // from class: com.baidu.tieba.pr8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            InputSlice.x3(InputSlice.this, view2);
                        }
                    }
                }));
                TBAlertBuilder tBAlertBuilder5 = this.s;
                Intrinsics.checkNotNull(tBAlertBuilder5);
                tBAlertBuilder5.setAutoClose();
                TBAlertBuilder tBAlertBuilder6 = this.s;
                Intrinsics.checkNotNull(tBAlertBuilder6);
                tBAlertBuilder6.setCancelable(false);
                TBAlertBuilder tBAlertBuilder7 = this.s;
                Intrinsics.checkNotNull(tBAlertBuilder7);
                tBAlertBuilder7.show();
            } else if (auditStatus == this.w) {
                String string2 = TbadkCoreApplication.getInst().getString(R.string.internal_testing_experience_success);
                Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(\n   …sting_experience_success)");
                f59.a(getPageContext().getPageActivity(), Boolean.TRUE, string2);
            }
        }
    }
}
