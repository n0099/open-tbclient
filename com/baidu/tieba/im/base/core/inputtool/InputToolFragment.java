package com.baidu.tieba.im.base.core.inputtool;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.R;
import com.baidu.tieba.a88;
import com.baidu.tieba.ae5;
import com.baidu.tieba.e88;
import com.baidu.tieba.ea8;
import com.baidu.tieba.f88;
import com.baidu.tieba.g88;
import com.baidu.tieba.i58;
import com.baidu.tieba.i78;
import com.baidu.tieba.i88;
import com.baidu.tieba.im.base.core.databinding.FragmentInputToolBinding;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.inputtool.keyboardtool.PanelType;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotFloorView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatRobotTopHeadView;
import com.baidu.tieba.im.base.core.inputtool.robotfloor.GroupChatUserReplyView;
import com.baidu.tieba.im.base.core.inputtool.utility.GroupChatKeyboardLayout;
import com.baidu.tieba.im.base.core.inputtool.utility.NoSlidingLinearLayout;
import com.baidu.tieba.im.base.core.slice.SliceFragment;
import com.baidu.tieba.im.chat.ISendVoiceView;
import com.baidu.tieba.j88;
import com.baidu.tieba.k88;
import com.baidu.tieba.nf5;
import com.baidu.tieba.o88;
import com.baidu.tieba.od5;
import com.baidu.tieba.pd5;
import com.baidu.tieba.t78;
import com.baidu.tieba.td5;
import com.baidu.tieba.u78;
import com.baidu.tieba.vca;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.wo6;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.tieba.x6c;
import com.baidu.tieba.x78;
import com.baidu.tieba.zr5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class InputToolFragment extends SliceFragment implements t78, f88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public x78 A;
    public View B;
    public ViewGroup C;
    public g88 D;
    public boolean E;
    public int F;
    public int G;
    @Nullable
    public k88 H;
    @Nullable
    public h I;
    public ViewTreeObserver.OnGlobalLayoutListener J;
    public FragmentInputToolBinding e;
    public GroupInputTool f;
    public ae5 g;
    public EditorTools h;
    public LinearLayout.LayoutParams i;
    public td5 j;
    public nf5 k;
    public od5 l;
    public int m;
    @Nullable
    public ISendVoiceView n;
    @Nullable
    public GroupChatRobotTopHeadView o;
    public o88 p;
    @Nullable
    public i78 q;
    public int r;
    public int s;
    public boolean t;
    public long u;
    public long v;
    public long w;
    @Nullable
    public ea8 x;
    @Nullable
    public InputDelegate y;
    @Nullable
    public a88 z;

    /* loaded from: classes6.dex */
    public interface h {
        int x();
    }

    @Override // com.baidu.tieba.f88
    public void M1(@Nullable i88 i88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, i88Var) == null) {
        }
    }

    @Override // com.baidu.tieba.f88
    public View W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class c implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputToolFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a.getContext() != null) {
                    new BdTopToast(this.a.a.getContext()).setContent(this.a.a.getContext().getString(R.string.obfuscated_res_0x7f0f0f11)).setIcon(false).show((ViewGroup) this.a.a.getView());
                }
            }
        }

        public c(InputToolFragment inputToolFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputToolFragment;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (this.a.T2()) {
                    if (TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                    boolean matches = u78.a.matcher(charSequence.toString()).matches();
                    if (!matches) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (this.a.u == 0 || currentTimeMillis - this.a.u > 5000) {
                            this.a.u = currentTimeMillis;
                            SafeHandler.getInst().post(new a(this));
                        }
                    }
                    if (!matches) {
                        return "";
                    }
                    return charSequence;
                }
                this.a.u = 0L;
                return charSequence;
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements k88 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ InputToolFragment b;

        @Override // com.baidu.tieba.k88
        public /* synthetic */ void c() {
            j88.a(this);
        }

        public a(InputToolFragment inputToolFragment, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = inputToolFragment;
            this.a = context;
        }

        @Override // com.baidu.tieba.k88
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                k88 k88Var = this.b.H;
                if (k88Var != null) {
                    k88Var.b(i);
                }
                if (i < e88.b(this.a) / 2) {
                    TbSingleton.getInstance().setKeyboardHeight(i);
                }
            }
        }

        @Override // com.baidu.tieba.k88
        public void g() {
            k88 k88Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (k88Var = this.b.H) != null) {
                k88Var.g();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputToolFragment a;

        public b(InputToolFragment inputToolFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputToolFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 0 && this.a.y != null && this.a.y.e()) {
                    this.a.y.D();
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence a;
        public final /* synthetic */ InputToolFragment b;

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public d(InputToolFragment inputToolFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = inputToolFragment;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.b.T2() && this.a != null && editable != null && editable.length() > 1 && this.a.length() > 1 && this.a.charAt(0) == '0') {
                editable.delete(0, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
                this.a = charSequence;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ InputToolFragment d;

        public e(InputToolFragment inputToolFragment, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = inputToolFragment;
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int animatedFraction = (int) (valueAnimator.getAnimatedFraction() * this.a);
                int i2 = this.b;
                if (i2 > this.c) {
                    i = i2 - animatedFraction;
                } else {
                    i = i2 + animatedFraction;
                }
                if (this.d.i != null) {
                    this.d.i.height = i;
                    this.d.e.d.setLayoutParams(this.d.i);
                    this.d.e.d.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AnimatorListenerAdapter a;
        public final /* synthetic */ InputToolFragment b;

        public f(InputToolFragment inputToolFragment, AnimatorListenerAdapter animatorListenerAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment, animatorListenerAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = inputToolFragment;
            this.a = animatorListenerAdapter;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                AnimatorListenerAdapter animatorListenerAdapter = this.a;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationCancel(animator);
                }
                if (this.b.i != null) {
                    this.b.i.height = -2;
                    this.b.e.d.setLayoutParams(this.b.i);
                    this.b.e.d.requestLayout();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                AnimatorListenerAdapter animatorListenerAdapter = this.a;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
                if (this.b.i != null) {
                    this.b.i.height = -2;
                    this.b.e.d.setLayoutParams(this.b.i);
                    this.b.e.d.requestLayout();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) && (animatorListenerAdapter = this.a) != null) {
                animatorListenerAdapter.onAnimationRepeat(animator);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            AnimatorListenerAdapter animatorListenerAdapter;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, animator) == null) && (animatorListenerAdapter = this.a) != null) {
                animatorListenerAdapter.onAnimationStart(animator);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ InputToolFragment a;

        public g(InputToolFragment inputToolFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {inputToolFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = inputToolFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.E) {
                    i = g88.l;
                } else if (this.a.S2() && TbSingleton.getInstance().getEmotionBoardHeight() != 0) {
                    i = TbSingleton.getInstance().getEmotionBoardHeight();
                } else {
                    i = 0;
                }
                if (this.a.y.o() == 0) {
                    this.a.y.K();
                }
                if (this.a.F != this.a.g.h().getHeight()) {
                    this.a.G = i;
                    if (this.a.y != null) {
                        this.a.y.V(PanelType.INPUTCHANGE, this.a.G);
                    }
                }
                InputToolFragment inputToolFragment = this.a;
                inputToolFragment.F = inputToolFragment.g.h().getHeight();
            }
        }
    }

    public InputToolFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = null;
        this.m = -1;
        this.n = null;
        this.r = R.color.CAM_X0212;
        this.t = false;
        this.u = 0L;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.J = new g(this);
    }

    public void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.e.setPageContext(getPageContext());
            this.e.e.A(TbadkCoreApplication.getInst().getSkinType());
            o88 o88Var = new o88(this);
            this.p = o88Var;
            o88Var.x(this.e.e);
        }
    }

    @Override // com.baidu.tieba.d88
    public int h() {
        InterceptResult invokeV;
        ae5 ae5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.y != null && (ae5Var = this.g) != null && ae5Var.h() != null && this.y.o() != 0) {
                return Math.abs(this.y.o() - this.g.h().getHeight());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void L2(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, spanGroupEditText) == null) {
            spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000), new c(this)});
        }
    }

    public final void R2(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, spanGroupEditText) == null) {
            spanGroupEditText.addTextChangedListener(new d(this));
        }
    }

    public void U2(@NonNull i78 i78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, i78Var) == null) {
            this.q = i78Var;
        }
    }

    public void V2(@NonNull ea8 ea8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, ea8Var) == null) {
            this.x = ea8Var;
        }
    }

    public void W2(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, hVar) == null) {
            this.I = hVar;
        }
    }

    public void X2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.t = z;
        }
    }

    public void Y2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.s = i;
            Z2();
        }
    }

    public void a3(k88 k88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, k88Var) == null) {
            this.H = k88Var;
        }
    }

    public void c3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            zr5.b(arguments);
            this.v = arguments.getLong("roomId");
            this.w = arguments.getLong("forumId");
        }
    }

    @Override // com.baidu.tieba.f88
    public void t(@NonNull x6c<PanelType, PanelType, Float, Float> x6cVar) {
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, x6cVar) == null) && (inputDelegate = this.y) != null) {
            inputDelegate.X(x6cVar);
        }
    }

    @Override // com.baidu.tieba.t78
    public void u0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            RelativeLayout relativeLayout = this.e.c;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }
    }

    public void b3(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, view2, viewGroup) == null) && view2 != null && viewGroup != null) {
            this.B = view2;
            this.C = viewGroup;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            K2();
            M2();
            P2();
            O2();
            i78 i78Var = this.q;
            if (i78Var != null) {
                i78Var.c1();
            }
        }
    }

    @Nullable
    public NoSlidingLinearLayout A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e.f;
        }
        return (NoSlidingLinearLayout) invokeV.objValue;
    }

    @NonNull
    public GroupChatUserReplyView B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e.h;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public o88 C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return (o88) invokeV.objValue;
    }

    @NonNull
    public GroupChatRobotFloorView D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e.e;
        }
        return (GroupChatRobotFloorView) invokeV.objValue;
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f.R();
        }
        return invokeV.booleanValue;
    }

    public nf5 F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.k;
        }
        return (nf5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.n;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.o;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            i78 i78Var = this.q;
            if (i78Var != null) {
                return i78Var.I();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public EditorTools I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (EditorTools) invokeV.objValue;
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.o = (GroupChatRobotTopHeadView) this.e.d.findViewById(R.id.obfuscated_res_0x7f091155);
        }
    }

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Q2();
            J2();
            N2();
        }
    }

    public final void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            GroupInputTool groupInputTool = new GroupInputTool(this);
            this.f = groupInputTool;
            this.y = new InputDelegate(InputDelegate.SOURCE.ROOM, this, groupInputTool, this.x, this.v, this.w);
        }
    }

    public boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.f.c0();
        }
        return invokeV.booleanValue;
    }

    public boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f88
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.E = true;
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.V(PanelType.INPUT_KEYBOARD, -10086);
            }
        }
    }

    @Override // com.baidu.tieba.d88
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return g88.m;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onDestroy();
            r2();
        }
    }

    public final void r2() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (i = this.m) > 0) {
            String str = null;
            if (i == 1) {
                long j = this.w;
                if (j != 0) {
                    str = String.valueOf(j);
                }
            }
            wo6.b().c(new i58(str));
        }
    }

    @Override // com.baidu.tieba.f88
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.E = false;
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null && !inputDelegate.F()) {
                this.y.V(PanelType.NONE, -10086);
            }
        }
    }

    public GroupChatKeyboardLayout s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.e.b;
        }
        return (GroupChatKeyboardLayout) invokeV.objValue;
    }

    public td5 t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.j;
        }
        return (td5) invokeV.objValue;
    }

    @Nullable
    public GroupInputTool u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.f;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    @NonNull
    public GroupChatUserReplyView v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.e.g;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.e.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d88
    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            h hVar = this.I;
            if (hVar != null) {
                return hVar.x();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public InputDelegate x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.y;
        }
        return (InputDelegate) invokeV.objValue;
    }

    @NonNull
    public ae5 y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.g;
        }
        return (ae5) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f88
    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.e.c;
        }
        return (View) invokeV.objValue;
    }

    @NonNull
    public RelativeLayout z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.e.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ae5 ae5Var = new ae5(getContext(), true, false);
            this.g = ae5Var;
            ae5Var.k(true);
            if (this.g.h() != null && this.g.h().getViewTreeObserver() != null) {
                this.g.h().getViewTreeObserver().addOnGlobalLayoutListener(this.J);
            }
            EditorTools editorTools = new EditorTools(getContext());
            this.h = editorTools;
            editorTools.setId(R.id.group_chat_input_tool_view);
            this.h.setMoreButtonAtEnd(true);
            this.h.setBarLauncherType(9);
            this.h.setBarMaxLauCount(1);
            this.h.setBackgroundColorId(R.color.CAM_X0204);
            this.h.setBarBackgroundColorId(R.color.CAM_X0207);
            this.h.setDeskBackgroundColorId(R.color.CAM_X0206);
            this.h.setMoreDeskBgColorId(R.color.CAM_X0206);
            this.h.setViewDisplayTime(15L, 20L);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, od5.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                od5 od5Var = (od5) runTask.getData();
                this.l = od5Var;
                pd5 pd5Var = od5Var.m;
                if (pd5Var != null && (pd5Var instanceof ISendVoiceView)) {
                    this.n = (ISendVoiceView) pd5Var;
                }
                od5 od5Var2 = this.l;
                od5Var2.l = 1;
                this.h.d(od5Var2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.h.h(arrayList);
            od5 p = this.h.p(5);
            if (p != null) {
                p.g(true);
                p.f(true);
                p.d = 0;
            }
            this.h.d(this.g);
            td5 td5Var = new td5(getContext());
            this.j = td5Var;
            this.h.d(td5Var);
            nf5 nf5Var = new nf5(getContext(), true);
            this.k = nf5Var;
            this.h.d(nf5Var);
            this.h.f();
            this.e.c.addView(this.h, new ViewGroup.LayoutParams(-1, -2));
            pd5 pd5Var2 = this.g.m;
            if (pd5Var2 instanceof EditText) {
                EMManager.from((EditText) pd5Var2).setTextSize(R.dimen.T_X06).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0209).setRealBorderColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.r));
            }
            this.h.z(TbadkCoreApplication.getInst().getSkinType());
            this.e.b.setBlank(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5, BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            this.e.b.setOnTouchListener(new b(this));
        }
    }

    public void N2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.g.h() != null && getContext() != null) {
            SpanGroupEditText h2 = this.g.h();
            h2.setId(R.id.obfuscated_res_0x7f090ead);
            h2.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            h2.setMinHeight(getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            h2.setMaxLines(5);
            h2.setMinLines(1);
            h2.setGravity(48);
            h2.setIncludeFontPadding(false);
            h2.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.T_X06));
            h2.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            h2.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            WriteVideoUtil.setCursorColor(h2, R.drawable.edittext_cursor);
            h2.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            h2.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004));
            L2(h2);
            R2(h2);
        }
    }

    public final void O2() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (context = getContext()) != null && this.B != null) {
            this.D = new g88();
            if (TbSingleton.getInstance().getKeyboardHeight() == 0 && TbadkCoreApplication.getInst().getKeyboardHeight() != 0) {
                TbSingleton.getInstance().setKeyboardHeight(TbadkCoreApplication.getInst().getKeyboardHeight());
            }
            g88 g88Var = this.D;
            g88Var.l(context);
            g88Var.j(this.B);
            g88Var.g(this.C);
            g88Var.h(this);
            g88Var.m(TbSingleton.getInstance().getKeyboardHeight());
            g88Var.o(true);
            g88Var.n(new a(this, context));
        }
    }

    public void Z2() {
        pd5 pd5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            int i = this.s;
            if (i == 0) {
                this.r = SkinManager.getColor(R.color.CAM_X0212);
            } else if (i == 1) {
                this.r = vca.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
            } else {
                this.r = SkinManager.getColor(R.color.CAM_X0212);
            }
            ae5 ae5Var = this.g;
            if (ae5Var != null && (pd5Var = ae5Var.m) != null && (pd5Var instanceof EditText)) {
                EMManager.from((EditText) pd5Var).setTextSize(R.dimen.T_X06).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0209).setBackGroundRealColor(this.r);
            }
        }
    }

    public void d3(@NonNull a88 a88Var, @NonNull x78 x78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, a88Var, x78Var) == null) {
            this.z = a88Var;
            this.A = x78Var;
            if (a88Var != null && x78Var != null) {
                this.f.r0(a88Var.d(), this.A.a());
                this.w = this.A.a();
            }
            o88 o88Var = this.p;
            if (o88Var != null) {
                o88Var.A(this.z, this.A);
            }
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.e0(this.z, this.A);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048612, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.H(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, layoutInflater, viewGroup, bundle)) == null) {
            FragmentInputToolBinding c2 = FragmentInputToolBinding.c(layoutInflater, viewGroup, false);
            this.e = c2;
            return c2.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            super.onChangeSkinType(i);
            this.h.z(i);
            Z2();
            this.e.f.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0608));
            this.e.e.A(i);
            this.e.h.d(i);
            this.e.g.d(i);
            GroupChatRobotTopHeadView groupChatRobotTopHeadView = this.o;
            if (groupChatRobotTopHeadView != null) {
                groupChatRobotTopHeadView.d(i);
            }
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.I(i);
            }
        }
    }

    public void q2(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
            int max = Math.max(i2, i);
            int i3 = max - ((i2 + i) - max);
            if (this.e.d.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                this.i = (LinearLayout.LayoutParams) this.e.d.getLayoutParams();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.setDuration(j);
            ofInt.addUpdateListener(new e(this, i3, i, i2));
            ofInt.addListener(new f(this, animatorListenerAdapter));
            ofInt.setTarget(this.e.d);
            ofInt.start();
        }
    }
}
