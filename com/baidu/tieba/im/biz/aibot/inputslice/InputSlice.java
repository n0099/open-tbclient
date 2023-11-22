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
import com.baidu.tieba.co8;
import com.baidu.tieba.gu4;
import com.baidu.tieba.im.base.core.slice.Slice;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.biz.aibot.inputslice.InputSlice;
import com.baidu.tieba.im.biz.aibot.keyboardtool.PanelType;
import com.baidu.tieba.impersonal.databinding.SliceInputBinding;
import com.baidu.tieba.no8;
import com.baidu.tieba.oo8;
import com.baidu.tieba.po8;
import com.baidu.tieba.pw8;
import com.baidu.tieba.qd;
import com.baidu.tieba.qo8;
import com.baidu.tieba.s19;
import com.baidu.tieba.so8;
import com.baidu.tieba.to8;
import com.baidu.tieba.un8;
import com.baidu.tieba.zjc;
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
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010D\u001a\u00020EH\u0002J\u0010\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u000bH\u0016J\u0010\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020)H\u0002J\b\u0010J\u001a\u00020EH\u0002J\b\u0010K\u001a\u00020\u000bH\u0016J\b\u0010L\u001a\u00020\u000bH\u0016J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020EH\u0003J\b\u0010P\u001a\u00020EH\u0002J\u0010\u0010Q\u001a\u00020E2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010R\u001a\u00020)2\u0006\u0010S\u001a\u00020,H\u0002J\b\u0010T\u001a\u00020)H\u0002J\u0012\u0010U\u001a\u00020E2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\u0010\u0010X\u001a\u00020E2\u0006\u0010Y\u001a\u00020ZH\u0016J$\u0010[\u001a\u00020N2\u0006\u0010\\\u001a\u00020]2\b\u0010^\u001a\u0004\u0018\u00010\u00052\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010_\u001a\u00020EH\u0016J\u0010\u0010`\u001a\u00020E2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010a\u001a\u00020E2\u0006\u0010b\u001a\u00020\u000b2\u0006\u0010c\u001a\u00020)H\u0016J\b\u0010d\u001a\u00020EH\u0016J\b\u0010e\u001a\u00020EH\u0016J\u0010\u0010f\u001a\u00020E2\u0006\u0010S\u001a\u00020,H\u0002J\b\u0010g\u001a\u00020EH\u0002J\b\u0010h\u001a\u00020EH\u0016J\u0010\u0010i\u001a\u00020E2\u0006\u0010j\u001a\u00020\bH\u0002J\u0010\u0010k\u001a\u00020E2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010l\u001a\u00020E2\u0006\u0010m\u001a\u00020)H\u0002J\u0012\u0010n\u001a\u00020E2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J(\u0010q\u001a\u00020E2\u001e\u0010o\u001a\u001a\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110+H\u0016J\u0006\u0010r\u001a\u00020ER\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010*\u001a\u001c\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020?X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006s"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice;", "Lcom/baidu/tieba/im/base/core/slice/SliceFragment;", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputPanel;", "Lcom/baidu/tieba/im/biz/aibot/IPageChangeNotify;", "mParentRootView", "Landroid/view/ViewGroup;", "mBodyView", "mUid", "", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Ljava/lang/String;)V", "APPLY_WHITELIST_USER", "", "APPROVED_USER", "APPROVE_REJECT_USER", "APPROVING_USER", "INPUT_VIEW_MAX_LENGTH", "START_HEIGHT", "", "alertBuilder", "Lcom/baidu/tbadk/core/dialog/TBAlertBuilder;", "applyInternalRequest", "Lcom/baidu/tbadk/net/FastRequest;", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "mChatChangeHeight", "mHybridNotifyListener", "Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "getMHybridNotifyListener", "()Lcom/baidu/tbadk/browser/utils/HybridNotifyManager$HybridNotifyListener;", "mInputChangeHeight", "mInputComCallback", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "getMInputComCallback", "()Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "setMInputComCallback", "(Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;)V", "mInputText", "mInputView", "Landroid/widget/EditText;", "mInputViewHeight", "mIsKeyBoardShow", "", "mKeyboardCallBack", "Lrx/functions/Action4;", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/PanelType;", "mKeyboardHelper", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/KeyboardHelper;", "mKeyboardStateListener", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/OnKeyboardStateListener;", "mLastPanelType", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mOnTouchListener", "Landroid/view/View$OnTouchListener;", "mPageState", "mPanelType", "mSoftKeyListener", "Landroid/view/View$OnKeyListener;", "mTextInputLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mTextInputListener", "Landroid/text/TextWatcher;", "sliceInputBinding", "Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;", "getSliceInputBinding", "()Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;", "setSliceInputBinding", "(Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;)V", "afterSendTextMsg", "", CommonTbJsBridge.CHANGE_SKIN_TYPE, WriteMulitImageActivityConfig.SKIN_TYPE, "checkSendIconClickAble", "canSend", "createDraft", "getInoutViewDiffHeight", "getPanelHeight", "getViewContainer", "Landroid/view/View;", "initEdittextParam", "initKeyboardHelper", "inputViewShowState", "interceptInputRefresh", "panel", "isChatPageState", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", MissionEvent.MESSAGE_DESTROY, "onSetChatDetail", "onSetPageState", "state", "refreshPage", "onSoftKeyboardClosed", "onSoftKeyboardOpened", "refreshState", "requestApplyInternal", "reset", "setDraft", MediaTrackConfig.AE_IMPORT_DRAFT, "setInputViewConfig", "setInputViewLimit", Constants.EXTRA_CONFIG_LIMIT, "setOnInputStateChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/OnInputPanelStateChangedListener;", "setOnLayoutAnimatorHandleListener", "showInternalDialog", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputSlice extends SliceFragment implements po8, un8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int A;
    public int B;
    public EditText C;
    public final to8 D;
    public final View.OnClickListener E;
    public final View.OnTouchListener F;
    public final TextWatcher G;
    public final ViewTreeObserver.OnGlobalLayoutListener H;
    public final gu4.d I;
    public final View.OnKeyListener J;
    public final ViewGroup e;
    public final ViewGroup f;
    public final String g;
    public SliceInputBinding h;
    public zjc<PanelType, PanelType, Float, Float> i;
    public final qo8 j;
    public PanelType k;
    public AibotChatDetail l;
    public final int m;
    public final float n;
    public PanelType o;
    public no8 p;
    public String q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public TBAlertBuilder v;
    public FastRequest w;
    public final int x;
    public final int y;
    public final int z;

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

    @Override // com.baidu.tieba.po8
    public void P1(so8 so8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, so8Var) == null) {
        }
    }

    @Override // com.baidu.tieba.mo8
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements gu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        @Override // com.baidu.tieba.gu4.d
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

        @Override // com.baidu.tieba.gu4.c
        public void a(String data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                this.a.b3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements to8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        @Override // com.baidu.tieba.to8
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

        @Override // com.baidu.tieba.to8
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                co8.a.a(2, this.a.g);
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !Intrinsics.areEqual(view2, this.a.K2().d)) {
                return;
            }
            this.a.G2();
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
                    this.a.H2(false);
                } else {
                    this.a.H2(true);
                }
                this.a.q = s.toString();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.a.t == 0 && this.a.K2().c.getLineCount() != 0) {
                    InputSlice inputSlice = this.a;
                    inputSlice.t = inputSlice.K2().c.getHeight() / this.a.K2().c.getLineCount();
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
                s19.a(this.d.getPageContext().getPageActivity(), Boolean.FALSE, string);
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
                s19.a(this.d.getPageContext().getPageActivity(), Boolean.TRUE, string);
                this.d.K2().c.setHint(R.string.internal_testing_experience_qualification_progress);
                AibotChatDetail aibotChatDetail = this.d.l;
                if (aibotChatDetail != null) {
                    aibotChatDetail.setAuditStatus(this.d.z);
                }
                EMManager.from(this.d.K2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0614));
                this.d.Y2(true);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputSlice(ViewGroup mParentRootView, ViewGroup mBodyView, String mUid) {
        super(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mParentRootView, mBodyView, mUid};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Slice) objArr2[0], ((Integer) objArr2[1]).intValue(), (DefaultConstructorMarker) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mParentRootView, "mParentRootView");
        Intrinsics.checkNotNullParameter(mBodyView, "mBodyView");
        Intrinsics.checkNotNullParameter(mUid, "mUid");
        this.e = mParentRootView;
        this.f = mBodyView;
        this.g = mUid;
        this.j = new qo8();
        PanelType panelType = PanelType.NONE;
        this.k = panelType;
        this.m = 400;
        this.o = panelType;
        this.r = 66;
        this.y = 1;
        this.z = 2;
        this.A = 3;
        this.B = 2;
        this.D = new c(this);
        this.E = new d(this);
        this.F = new View.OnTouchListener() { // from class: com.baidu.tieba.io8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view2, motionEvent)) == null) ? InputSlice.Q2(InputSlice.this, view2, motionEvent) : invokeLL.booleanValue;
            }
        };
        this.G = new e(this);
        this.H = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.fo8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    InputSlice.T2(InputSlice.this);
                }
            }
        };
        this.I = new b(this);
        this.J = new View.OnKeyListener() { // from class: com.baidu.tieba.jo8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i3, KeyEvent keyEvent) {
                InterceptResult invokeLIL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeLIL = interceptable2.invokeLIL(1048576, this, view2, i3, keyEvent)) == null) ? InputSlice.S2(InputSlice.this, view2, i3, keyEvent) : invokeLIL.booleanValue;
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        if (((r5 == null || r5.getAuditStatus() != r4.x) ? false : false) != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean Q2(final InputSlice this$0, View view2, MotionEvent motionEvent) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, this$0, view2, motionEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action != 0) {
                if (action == 1) {
                    view2.performClick();
                }
            } else {
                AibotChatDetail aibotChatDetail = this$0.l;
                if (aibotChatDetail != null && aibotChatDetail.getAuditStatus() == this$0.A) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    AibotChatDetail aibotChatDetail2 = this$0.l;
                }
                this$0.V2();
                if (!this$0.P2()) {
                    co8.a.b(7);
                    if (this$0.K2().c.isFocusable()) {
                        no8 J2 = this$0.J2();
                        if (J2 != null) {
                            J2.a();
                        }
                        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ho8
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    InputSlice.R2(InputSlice.this);
                                }
                            }
                        }, 240L);
                    }
                } else if (this$0.K2().c.isFocusable()) {
                    SpanGroupEditText spanGroupEditText = this$0.K2().c;
                    spanGroupEditText.requestFocus();
                    BdUtilHelper.showSoftKeyPad(spanGroupEditText.getContext(), spanGroupEditText);
                    if (this$0.j.m() && !this$0.O2(PanelType.INPUT_KEYBOARD)) {
                        this$0.U2(PanelType.INPUT_KEYBOARD);
                    }
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.un8
    public void N(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            try {
                this.l = chatDetail;
                X2(chatDetail);
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public final boolean O2(PanelType panelType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, panelType)) == null) {
            if (!P2() && panelType != PanelType.NONE) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.q = str;
            K2().c.setText(str);
        }
    }

    public final void Z2(no8 no8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, no8Var) == null) {
            Intrinsics.checkNotNullParameter(no8Var, "<set-?>");
            this.p = no8Var;
        }
    }

    public final void a3(SliceInputBinding sliceInputBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, sliceInputBinding) == null) {
            Intrinsics.checkNotNullParameter(sliceInputBinding, "<set-?>");
            this.h = sliceInputBinding;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            super.changeSkinType(i);
            if (StringUtils.isNull(this.q)) {
                H2(false);
            } else {
                H2(true);
            }
            TBAlertBuilder tBAlertBuilder = this.v;
            if (tBAlertBuilder != null) {
                Intrinsics.checkNotNull(tBAlertBuilder);
                tBAlertBuilder.onChangeSkinType();
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, newConfig) == null) {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            super.onConfigurationChanged(newConfig);
            this.j.n();
        }
    }

    @Override // com.baidu.tieba.po8
    public void y(zjc<PanelType, PanelType, Float, Float> listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.i = listener;
        }
    }

    public static final void c3(InputSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.V2();
        }
    }

    public static final void R2(InputSlice this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SpanGroupEditText spanGroupEditText = this$0.K2().c;
            spanGroupEditText.requestFocus();
            BdUtilHelper.showSoftKeyPad(spanGroupEditText.getContext(), spanGroupEditText);
            if (this$0.j.m() && !this$0.O2(PanelType.INPUT_KEYBOARD)) {
                this$0.U2(PanelType.INPUT_KEYBOARD);
            }
        }
    }

    public final void H2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (!z) {
                K2().d.setAlpha(0.5f);
                K2().d.setClickable(false);
                return;
            }
            K2().d.setAlpha(1.0f);
            K2().d.setClickable(true);
        }
    }

    public final void Y2(boolean z) {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            ImageView imageView = K2().d;
            if (z) {
                i = 8;
            } else {
                i = 0;
            }
            imageView.setVisibility(i);
            K2().c.setFocusable(!z);
            this.u = !z;
            SpanGroupEditText spanGroupEditText = K2().c;
            if (z) {
                i2 = 17;
            } else {
                i2 = GravityCompat.START;
            }
            spanGroupEditText.setGravity(i2);
        }
    }

    public static final boolean S2(InputSlice this$0, View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65545, null, this$0, view2, i, keyEvent)) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (keyEvent.getAction() == 0 && i == 6 && !this$0.O2(PanelType.NONE)) {
                this$0.U2(PanelType.NONE);
                return false;
            }
            return false;
        }
        return invokeLLIL.booleanValue;
    }

    public static final void T2(InputSlice this$0) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.u) {
                i = qo8.m;
            } else {
                i = 0;
            }
            qo8.s = Math.abs(this$0.r - this$0.K2().c.getHeight());
            if (this$0.r > this$0.K2().c.getHeight()) {
                this$0.s = (i + this$0.r) - this$0.K2().c.getHeight();
                no8 J2 = this$0.J2();
                if (J2 != null) {
                    J2.c(this$0.s, 0.1f);
                }
            } else if (this$0.r < this$0.K2().c.getHeight()) {
                this$0.s = (i + this$0.K2().c.getHeight()) - this$0.r;
                no8 J22 = this$0.J2();
                if (J22 != null) {
                    J22.c(this$0.s, 0.1f);
                }
            }
            this$0.r = this$0.K2().c.getHeight();
        }
    }

    public final void X2(AibotChatDetail aibotChatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aibotChatDetail) == null) {
            N2(aibotChatDetail);
            K2().c.setFilters(new InputFilter[]{new pw8(getPageContext(), this.m)});
            if (Build.VERSION.SDK_INT >= 29 && (ContextCompat.getDrawable(requireContext(), R.drawable.obfuscated_res_0x7f0801ec) instanceof GradientDrawable)) {
                Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.obfuscated_res_0x7f0801ec);
                if (drawable != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                    gradientDrawable.setColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                    K2().c.setTextCursorDrawable(gradientDrawable);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            }
            WebPManager.setPureDrawableByColorInt(K2().d, R.drawable.obfuscated_res_0x7f0813cb, Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()), WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.po8
    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RelativeLayout root = K2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "sliceInputBinding.root");
            return root;
        }
        return (View) invokeV.objValue;
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !qd.isEmpty(this.q)) {
            no8 J2 = J2();
            if (J2 != null) {
                String str = this.q;
                Intrinsics.checkNotNull(str);
                J2.b(str);
            }
            K2().c.setText((CharSequence) null);
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.q != null) {
            TbSingleton.getInstance().setAiBotDraft(this.g, this.q);
        }
    }

    public final no8 J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            no8 no8Var = this.p;
            if (no8Var != null) {
                return no8Var;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mInputComCallback");
            return null;
        }
        return (no8) invokeV.objValue;
    }

    public final SliceInputBinding K2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            SliceInputBinding sliceInputBinding = this.h;
            if (sliceInputBinding != null) {
                return sliceInputBinding;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sliceInputBinding");
            return null;
        }
        return (SliceInputBinding) invokeV.objValue;
    }

    public final boolean P2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.B == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.mo8
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return Math.abs(this.t - K2().c.getHeight());
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.po8
    public void n() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || O2(PanelType.INPUT_KEYBOARD)) {
            return;
        }
        U2(PanelType.INPUT_KEYBOARD);
        this.u = true;
        this.s = qo8.m;
        no8 J2 = J2();
        if (J2 != null) {
            J2.c(qo8.m, 0.25f);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            I2();
            gu4.b.a().e(this.I);
            super.onDestroy();
        }
    }

    @Override // com.baidu.tieba.mo8
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return qo8.n;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.po8
    public void x() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || O2(PanelType.NONE)) {
            return;
        }
        U2(PanelType.NONE);
        this.u = false;
        this.s = 0;
        no8 J2 = J2();
        if (J2 != null) {
            J2.c(0, 0.25f);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            K2().getRoot().setOnClickListener(this.E);
            K2().c.setOnTouchListener(this.F);
            K2().d.setOnClickListener(this.E);
            K2().c.addTextChangedListener(this.G);
            K2().c.getViewTreeObserver().addOnGlobalLayoutListener(this.H);
            K2().c.setOnKeyListener(this.J);
            if (!qd.isEmpty(TbSingleton.getInstance().getAiBotDraft(this.g))) {
                String aiBotDraft = TbSingleton.getInstance().getAiBotDraft(this.g);
                Intrinsics.checkNotNull(aiBotDraft);
                W2(aiBotDraft);
            }
        }
    }

    public final void M2() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && getContext() != null && (context = getContext()) != null) {
            if (TbSingleton.getInstance().getKeyboardHeight() == 0) {
                TbSingleton.getInstance().setKeyboardHeight((oo8.b(context) / 5) * 2);
            }
            qo8 qo8Var = this.j;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            qo8Var.l(requireContext);
            qo8Var.j(this.e);
            qo8Var.g(this.f);
            qo8Var.h(this);
            qo8Var.o(TbSingleton.getInstance().getKeyboardHeight());
            qo8Var.q(true);
            qo8Var.p(this.D);
        }
    }

    public final void N2(AibotChatDetail aibotChatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aibotChatDetail) == null) {
            int auditStatus = aibotChatDetail.getAuditStatus();
            if (auditStatus == this.x) {
                SpanGroupEditText spanGroupEditText = K2().c;
                String string = getString(R.string.internal_testing_experience_to_use);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.inter…esting_experience_to_use)");
                String string2 = getString(R.string.internal_testing_experience_to_chat);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.inter…sting_experience_to_chat)");
                spanGroupEditText.setHint(string + aibotChatDetail.getUserInfo().getName() + string2);
                spanGroupEditText.setHintTextColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                Y2(true);
                EMManager.from(K2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0901));
            } else if (auditStatus == this.y) {
                K2().c.setHint(aibotChatDetail.getConfigData().getInputBoxPromptText());
                Y2(false);
            } else if (auditStatus == this.z) {
                SpanGroupEditText spanGroupEditText2 = K2().c;
                spanGroupEditText2.setHint(R.string.internal_testing_experience_qualification_progress);
                spanGroupEditText2.setHintTextColor(spanGroupEditText2.getResources().getColor(R.color.CAM_X0608));
                Y2(true);
                EMManager.from(K2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0614));
            } else if (auditStatus == this.A) {
                SpanGroupEditText spanGroupEditText3 = K2().c;
                String string3 = getString(R.string.internal_testing_experience_to_use);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.inter…esting_experience_to_use)");
                String string4 = getString(R.string.internal_testing_experience_to_chat);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.inter…sting_experience_to_chat)");
                spanGroupEditText3.setHint(string3 + aibotChatDetail.getUserInfo().getName() + string4);
                spanGroupEditText3.setHintTextColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                Y2(true);
                EMManager.from(K2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0901));
            } else {
                K2().c.setHint(aibotChatDetail.getConfigData().getInputBoxPromptText());
                Y2(false);
            }
        }
    }

    @Override // com.baidu.tieba.un8
    public void S1(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.B = i;
            if (this.C != null && !P2()) {
                x();
            }
        }
    }

    public final void U2(PanelType panelType) {
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, panelType) != null) || this.o == panelType) {
            return;
        }
        this.k = panelType;
        float f3 = this.n;
        int i = a.$EnumSwitchMapping$0[panelType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                f2 = f3;
            } else {
                f3 = this.n;
                f2 = -qo8.m;
            }
        } else {
            f3 = -qo8.m;
            f2 = this.n;
        }
        zjc<PanelType, PanelType, Float, Float> zjcVar = this.i;
        if (zjcVar != null) {
            Intrinsics.checkNotNull(zjcVar);
            zjcVar.b(this.k, this.o, Float.valueOf(f3), Float.valueOf(f2));
        }
        this.o = this.k;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            M2();
            L2();
            EMManager.from(K2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0201));
            K2().c.setTextColor(SkinManager.getColor(0, (int) R.color.CAM_X0105));
            K2().c.setShowSoftInputOnFocus(false);
            super.onActivityCreated(bundle);
        }
    }

    public final void V2() {
        AibotChatDetail aibotChatDetail;
        AibotChatDetail.UserInfo userInfo;
        String uk;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.w == null) {
                this.w = new FastRequest(getPageContext(), CmdConfigHttp.CMD_HTTP_APPLY_INNTERNAL, TbConfig.GET_AIBOT_APPLY_INTERNAL);
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && (aibotChatDetail = this.l) != null && (userInfo = aibotChatDetail.getUserInfo()) != null && (uk = userInfo.getUk()) != null) {
                FastRequest fastRequest = this.w;
                Intrinsics.checkNotNull(fastRequest);
                fastRequest.P("user_id", currentAccount);
                fastRequest.P("type", "aichat");
                fastRequest.P(DBTableDefine.GroupMessageColumns.COLUMN_FROM_USER, uk);
                fastRequest.R(new f(this));
                fastRequest.Q();
            }
        }
    }

    public final void b3() {
        AibotChatDetail aibotChatDetail;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (aibotChatDetail = this.l) != null) {
            int auditStatus = aibotChatDetail.getAuditStatus();
            if (auditStatus == this.x || auditStatus == this.A) {
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
                this.v = tBAlertBuilder;
                Intrinsics.checkNotNull(tBAlertBuilder);
                tBAlertBuilder.setTitle(R.string.internal_testing_experience_title);
                TBAlertBuilder tBAlertBuilder2 = this.v;
                Intrinsics.checkNotNull(tBAlertBuilder2);
                tBAlertBuilder2.setDescStr(format);
                TBAlertBuilder tBAlertBuilder3 = this.v;
                Intrinsics.checkNotNull(tBAlertBuilder3);
                tBAlertBuilder3.setDescLightStyle(true);
                TBAlertBuilder tBAlertBuilder4 = this.v;
                Intrinsics.checkNotNull(tBAlertBuilder4);
                tBAlertBuilder4.setOperateBtn(new TBAlertConfig.OperateBtnConfig((int) R.string.obfuscated_res_0x7f0f09e4, TBAlertConfig.OperateBtnStyle.SECONDARY), new TBAlertConfig.OperateBtnConfig((int) R.string.internal_testing_experience_confirm, TBAlertConfig.OperateBtnStyle.MAIN_BG, new View.OnClickListener() { // from class: com.baidu.tieba.go8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            InputSlice.c3(InputSlice.this, view2);
                        }
                    }
                }));
                TBAlertBuilder tBAlertBuilder5 = this.v;
                Intrinsics.checkNotNull(tBAlertBuilder5);
                tBAlertBuilder5.setAutoClose();
                TBAlertBuilder tBAlertBuilder6 = this.v;
                Intrinsics.checkNotNull(tBAlertBuilder6);
                tBAlertBuilder6.setCancelable(false);
                TBAlertBuilder tBAlertBuilder7 = this.v;
                Intrinsics.checkNotNull(tBAlertBuilder7);
                tBAlertBuilder7.show();
            } else if (auditStatus == this.z) {
                String string2 = TbadkCoreApplication.getInst().getString(R.string.internal_testing_experience_success);
                Intrinsics.checkNotNullExpressionValue(string2, "getInst().getString(\n   …sting_experience_success)");
                s19.a(getPageContext().getPageActivity(), Boolean.TRUE, string2);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048603, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            SliceInputBinding c2 = SliceInputBinding.c(inflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(inflater, container, false)");
            a3(c2);
            this.C = K2().c;
            gu4.b.a().c(this.I);
            RelativeLayout root = K2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "sliceInputBinding.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }
}
