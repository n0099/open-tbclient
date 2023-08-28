package com.baidu.tieba.im.biz.aibot.inputslice;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.CommonTbJsBridge;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.di;
import com.baidu.tieba.f8c;
import com.baidu.tieba.hc8;
import com.baidu.tieba.ic8;
import com.baidu.tieba.im.biz.aibot.data.AibotChatDetail;
import com.baidu.tieba.im.biz.aibot.inputslice.InputSlice;
import com.baidu.tieba.im.biz.aibot.keyboardtool.PanelType;
import com.baidu.tieba.immessagecenter.slice.Slice;
import com.baidu.tieba.immessagecenter.slice.SliceFragment;
import com.baidu.tieba.impersonal.databinding.SliceInputBinding;
import com.baidu.tieba.jc8;
import com.baidu.tieba.kc8;
import com.baidu.tieba.mc8;
import com.baidu.tieba.nc8;
import com.baidu.tieba.zb8;
import com.baidu.tieba.zi8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\nH\u0016J\u0010\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u000201H\u0002J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u00020\nH\u0016J\b\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000201H\u0002J\b\u0010<\u001a\u000201H\u0002J\u0012\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J$\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u00042\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\b\u0010D\u001a\u000201H\u0016J\b\u0010E\u001a\u000201H\u0016J\b\u0010F\u001a\u000201H\u0016J\u0010\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\u001dH\u0002J\b\u0010I\u001a\u000201H\u0016J\u000e\u0010J\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010K\u001a\u0002012\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0010\u0010M\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010N\u001a\u0002012\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J(\u0010Q\u001a\u0002012\u001e\u0010O\u001a\u001a\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001cH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006R"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/inputslice/InputSlice;", "Lcom/baidu/tieba/immessagecenter/slice/SliceFragment;", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputPanel;", "mParentRootView", "Landroid/view/ViewGroup;", "mBodyView", "mUid", "", "(Landroid/view/ViewGroup;Landroid/view/ViewGroup;Ljava/lang/String;)V", "INPUT_VIEW_MAX_LENGTH", "", "START_HEIGHT", "", "chatDetail", "Lcom/baidu/tieba/im/biz/aibot/data/AibotChatDetail;", "mChatChangeHeight", "mInputChangeHeight", "mInputComCallback", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "getMInputComCallback", "()Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;", "setMInputComCallback", "(Lcom/baidu/tieba/im/biz/aibot/keyboardtool/InputComCallback;)V", "mInputText", "mInputViewHeight", "mIsKeyBoardShow", "", "mKeyboardCallBack", "Lrx/functions/Action4;", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/PanelType;", "mKeyboardHelper", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/KeyboardHelper;", "mKeyboardStateListener", "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/OnKeyboardStateListener;", "mLastPanelType", "mOnClickListener", "Landroid/view/View$OnClickListener;", "mPanelType", "mTextInputLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mTextInputListener", "Landroid/text/TextWatcher;", "sliceInputBinding", "Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;", "getSliceInputBinding", "()Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;", "setSliceInputBinding", "(Lcom/baidu/tieba/impersonal/databinding/SliceInputBinding;)V", "afterSendTextMsg", "", CommonTbJsBridge.CHANGE_SKIN_TYPE, WriteMulitImageActivityConfig.SKIN_TYPE, "checkSendIconClickAble", "canSend", "createDraft", "getInoutViewDiffHeight", "getPanelHeight", "getViewContainer", "Landroid/view/View;", "initEdittextParam", "initKeyboardHelper", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", MissionEvent.MESSAGE_DESTROY, "onSoftKeyboardClosed", "onSoftKeyboardOpened", "refreshState", "panel", "reset", "setChatDetail", "setDraft", MediaTrackConfig.AE_IMPORT_DRAFT, "setInputViewConfig", "setOnInputStateChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/tieba/im/biz/aibot/keyboardtool/OnInputPanelStateChangedListener;", "setOnLayoutAnimatorHandleListener", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputSlice extends SliceFragment implements jc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ViewGroup e;
    public final ViewGroup f;
    public final String g;
    public SliceInputBinding h;
    public f8c<PanelType, PanelType, Float, Float> i;
    public final kc8 j;
    public PanelType k;
    public final int l;
    public final float m;
    public PanelType n;
    public hc8 o;
    public String p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public final nc8 u;
    public final View.OnClickListener v;
    public final TextWatcher w;
    public final ViewTreeObserver.OnGlobalLayoutListener x;

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

    @Override // com.baidu.tieba.gc8
    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.jc8
    public void w1(mc8 mc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, mc8Var) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements nc8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputSlice a;

        @Override // com.baidu.tieba.nc8
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
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

        @Override // com.baidu.tieba.nc8
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                zb8.a.a(2, this.a.g);
                TbSingleton.getInstance().setKeyboardHeight(i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements TextWatcher {
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

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (StringUtils.isNull(s.toString())) {
                    this.a.d2(false);
                } else {
                    this.a.d2(true);
                }
                this.a.p = s.toString();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.a.s == 0 && this.a.g2().c.getLineCount() != 0) {
                    InputSlice inputSlice = this.a;
                    inputSlice.s = inputSlice.g2().c.getHeight() / this.a.g2().c.getLineCount();
                }
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
        this.j = new kc8();
        PanelType panelType = PanelType.NONE;
        this.k = panelType;
        this.l = 400;
        this.n = panelType;
        this.q = 66;
        this.u = new b(this);
        this.v = new View.OnClickListener() { // from class: com.baidu.tieba.cc8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    InputSlice.j2(InputSlice.this, view2);
                }
            }
        };
        this.w = new c(this);
        this.x = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.dc8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    InputSlice.k2(InputSlice.this);
                }
            }
        };
    }

    public final void m2(AibotChatDetail chatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, chatDetail) == null) {
            Intrinsics.checkNotNullParameter(chatDetail, "chatDetail");
            try {
                o2(chatDetail);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public final void n2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.p = str;
            g2().c.setText(str);
        }
    }

    @Override // com.baidu.tieba.jc8
    public void o1(f8c<PanelType, PanelType, Float, Float> listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.i = listener;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            i2();
            h2();
            super.onActivityCreated(bundle);
        }
    }

    public final void p2(hc8 hc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, hc8Var) == null) {
            Intrinsics.checkNotNullParameter(hc8Var, "<set-?>");
            this.o = hc8Var;
        }
    }

    public final void q2(SliceInputBinding sliceInputBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, sliceInputBinding) == null) {
            Intrinsics.checkNotNullParameter(sliceInputBinding, "<set-?>");
            this.h = sliceInputBinding;
        }
    }

    public static final void j2(InputSlice this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(view2, this$0.g2().c)) {
                this$0.l2(PanelType.INPUT_KEYBOARD);
            } else if (Intrinsics.areEqual(view2, this$0.g2().d)) {
                this$0.c2();
            }
        }
    }

    public static final void k2(InputSlice this$0) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.t) {
                i = kc8.l;
            } else {
                i = 0;
            }
            kc8.r = Math.abs(this$0.q - this$0.g2().c.getHeight());
            if (this$0.q > this$0.g2().c.getHeight()) {
                this$0.r = (i + this$0.q) - this$0.g2().c.getHeight();
                hc8 f2 = this$0.f2();
                if (f2 != null) {
                    f2.b(this$0.r, 0.1f);
                }
            } else if (this$0.q < this$0.g2().c.getHeight()) {
                this$0.r = (i + this$0.g2().c.getHeight()) - this$0.q;
                hc8 f22 = this$0.f2();
                if (f22 != null) {
                    f22.b(this$0.r, 0.1f);
                }
            }
            this$0.q = this$0.g2().c.getHeight();
        }
    }

    @Override // com.baidu.tieba.jc8
    public View B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            RelativeLayout root = g2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "sliceInputBinding.root");
            return root;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gc8
    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return kc8.m;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.gc8
    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return Math.abs(this.s - g2().c.getHeight());
        }
        return invokeV.intValue;
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !di.isEmpty(this.p)) {
            hc8 f2 = f2();
            if (f2 != null) {
                String str = this.p;
                Intrinsics.checkNotNull(str);
                f2.a(str);
            }
            g2().c.setText((CharSequence) null);
        }
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.p != null) {
            TbSingleton.getInstance().setAiBotDraft(this.g, this.p);
        }
    }

    @Override // com.baidu.tieba.jc8
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l2(PanelType.INPUT_KEYBOARD);
            this.t = true;
            this.r = kc8.l;
            hc8 f2 = f2();
            if (f2 != null) {
                f2.b(kc8.l, 0.25f);
            }
        }
    }

    public final hc8 f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            hc8 hc8Var = this.o;
            if (hc8Var != null) {
                return hc8Var;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mInputComCallback");
            return null;
        }
        return (hc8) invokeV.objValue;
    }

    public final SliceInputBinding g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SliceInputBinding sliceInputBinding = this.h;
            if (sliceInputBinding != null) {
                return sliceInputBinding;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sliceInputBinding");
            return null;
        }
        return (SliceInputBinding) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jc8
    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            l2(PanelType.NONE);
            this.t = false;
            this.r = 0;
            hc8 f2 = f2();
            if (f2 != null) {
                f2.b(0, 0.25f);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            e2();
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            super.changeSkinType(i);
            if (StringUtils.isNull(this.p)) {
                d2(false);
            } else {
                d2(true);
            }
            EMManager.from(g2().b).setCorner(R.string.J_X01).setBackGroundRealColor(SkinManager.getColor(0, (int) R.color.CAM_X0201));
            g2().c.setTextColor(SkinManager.getColor(0, (int) R.color.CAM_X0105));
        }
    }

    public final void l2(PanelType panelType) {
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, panelType) != null) || this.n == panelType) {
            return;
        }
        this.k = panelType;
        float f2 = this.m;
        int i = a.$EnumSwitchMapping$0[panelType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                f = f2;
            } else {
                f2 = this.m;
                f = -kc8.l;
            }
        } else {
            f2 = -kc8.l;
            f = this.m;
        }
        f8c<PanelType, PanelType, Float, Float> f8cVar = this.i;
        if (f8cVar != null) {
            Intrinsics.checkNotNull(f8cVar);
            f8cVar.call(this.k, this.n, Float.valueOf(f2), Float.valueOf(f));
        }
        this.n = this.k;
    }

    public final void d2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (!z) {
                g2().d.setAlpha(0.5f);
                g2().d.setClickable(false);
                return;
            }
            g2().d.setAlpha(1.0f);
            g2().d.setClickable(true);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            g2().getRoot().setOnClickListener(this.v);
            g2().c.setOnClickListener(this.v);
            g2().d.setOnClickListener(this.v);
            g2().c.addTextChangedListener(this.w);
            g2().c.getViewTreeObserver().addOnGlobalLayoutListener(this.x);
            if (!di.isEmpty(TbSingleton.getInstance().getAiBotDraft(this.g))) {
                String aiBotDraft = TbSingleton.getInstance().getAiBotDraft(this.g);
                Intrinsics.checkNotNull(aiBotDraft);
                n2(aiBotDraft);
            }
        }
    }

    public final void i2() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && getContext() != null && (context = getContext()) != null) {
            if (TbSingleton.getInstance().getKeyboardHeight() == 0) {
                TbSingleton.getInstance().setKeyboardHeight((ic8.b(context) / 5) * 2);
            }
            kc8 kc8Var = this.j;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            kc8Var.k(requireContext);
            kc8Var.i(this.e);
            kc8Var.f(this.f);
            kc8Var.g(this);
            kc8Var.l(TbSingleton.getInstance().getKeyboardHeight());
            kc8Var.n(true);
            kc8Var.m(this.u);
        }
    }

    public final void o2(AibotChatDetail aibotChatDetail) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aibotChatDetail) == null) {
            g2().c.setHint(aibotChatDetail.getConfigData().getInputBoxPromptText());
            g2().c.setFilters(new InputFilter[]{new zi8(getPageContext(), this.l)});
            if (Build.VERSION.SDK_INT >= 29 && (ContextCompat.getDrawable(requireContext(), R.drawable.obfuscated_res_0x7f0801e8) instanceof GradientDrawable)) {
                Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.obfuscated_res_0x7f0801e8);
                if (drawable != null) {
                    GradientDrawable gradientDrawable = (GradientDrawable) drawable;
                    gradientDrawable.setColor(Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()));
                    g2().c.setTextCursorDrawable(gradientDrawable);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
            }
            WebPManager.setPureDrawableByColorInt(g2().d, R.drawable.obfuscated_res_0x7f081397, Color.parseColor(aibotChatDetail.getConfigData().getThemeColor()), WebPManager.ResourceStateType.NORMAL);
        }
    }

    @Override // com.baidu.tieba.immessagecenter.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, inflater, viewGroup, bundle)) == null) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            SliceInputBinding c2 = SliceInputBinding.c(inflater, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(c2, "inflate(inflater, container, false)");
            q2(c2);
            RelativeLayout root = g2().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "sliceInputBinding.root");
            return root;
        }
        return (View) invokeLLL.objValue;
    }
}
