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
import com.baidu.tieba.ao8;
import com.baidu.tieba.bo8;
import com.baidu.tieba.br6;
import com.baidu.tieba.eo8;
import com.baidu.tieba.gf5;
import com.baidu.tieba.gl8;
import com.baidu.tieba.gu5;
import com.baidu.tieba.ho8;
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
import com.baidu.tieba.kh5;
import com.baidu.tieba.lo8;
import com.baidu.tieba.lq8;
import com.baidu.tieba.mo8;
import com.baidu.tieba.no8;
import com.baidu.tieba.pn8;
import com.baidu.tieba.po8;
import com.baidu.tieba.qo8;
import com.baidu.tieba.ro8;
import com.baidu.tieba.ue5;
import com.baidu.tieba.uoc;
import com.baidu.tieba.uua;
import com.baidu.tieba.ve5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.vo8;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.tieba.ze5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class InputToolFragment extends SliceFragment implements ao8, mo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public eo8 A;
    public View B;
    public ViewGroup C;
    public no8 D;
    public boolean E;
    public int F;
    public int G;
    @Nullable
    public ro8 H;
    @Nullable
    public h I;
    public ViewTreeObserver.OnGlobalLayoutListener J;
    public FragmentInputToolBinding e;
    public GroupInputTool f;
    public gf5 g;
    public EditorTools h;
    public LinearLayout.LayoutParams i;
    public ze5 j;
    public kh5 k;
    public ue5 l;
    public int m;
    @Nullable
    public ISendVoiceView n;
    @Nullable
    public GroupChatRobotTopHeadView o;
    public vo8 p;
    @Nullable
    public pn8 q;
    public int r;
    public int s;
    public boolean t;
    public long u;
    public long v;
    public long w;
    @Nullable
    public lq8 x;
    @Nullable
    public InputDelegate y;
    @Nullable
    public ho8 z;

    /* loaded from: classes6.dex */
    public interface h {
        int A();
    }

    @Override // com.baidu.tieba.mo8
    public View A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo8
    public void p2(@Nullable po8 po8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, po8Var) == null) {
        }
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
                    new BdTopToast(this.a.a.getContext()).setContent(this.a.a.getContext().getString(R.string.obfuscated_res_0x7f0f0f32)).setIcon(false).show((ViewGroup) this.a.a.getView());
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
                if (this.a.x3()) {
                    if (TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                    boolean matches = bo8.a.matcher(charSequence.toString()).matches();
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
    public class a implements ro8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ InputToolFragment b;

        @Override // com.baidu.tieba.ro8
        public /* synthetic */ void d() {
            qo8.a(this);
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

        @Override // com.baidu.tieba.ro8
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                ro8 ro8Var = this.b.H;
                if (ro8Var != null) {
                    ro8Var.b(i);
                }
                if (i < lo8.b(this.a) / 2) {
                    TbSingleton.getInstance().setKeyboardHeight(i);
                }
            }
        }

        @Override // com.baidu.tieba.ro8
        public void f() {
            ro8 ro8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (ro8Var = this.b.H) != null) {
                ro8Var.f();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.b.x3() && this.a != null && editable != null && editable.length() > 1 && this.a.length() > 1 && this.a.charAt(0) == '0') {
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
                    i = no8.l;
                } else if (this.a.w3() && TbSingleton.getInstance().getEmotionBoardHeight() != 0) {
                    i = TbSingleton.getInstance().getEmotionBoardHeight();
                } else {
                    i = 0;
                }
                if (this.a.y.o() == 0) {
                    this.a.y.K();
                }
                if (this.a.F != this.a.g.i().getHeight()) {
                    this.a.G = i;
                    if (this.a.y != null) {
                        this.a.y.V(PanelType.INPUTCHANGE, this.a.G);
                    }
                }
                InputToolFragment inputToolFragment = this.a;
                inputToolFragment.F = inputToolFragment.g.i().getHeight();
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

    @Override // com.baidu.tieba.ko8
    public int k() {
        InterceptResult invokeV;
        gf5 gf5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.y != null && (gf5Var = this.g) != null && gf5Var.i() != null && this.y.o() != 0) {
                return Math.abs(this.y.o() - this.g.i().getHeight());
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.e.e.setPageContext(getPageContext());
            this.e.e.A(TbadkCoreApplication.getInst().getSkinType());
            vo8 vo8Var = new vo8(this);
            this.p = vo8Var;
            vo8Var.x(this.e.e);
        }
    }

    public void A3(@Nullable h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.I = hVar;
        }
    }

    public void B3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.t = z;
        }
    }

    public void C3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.s = i;
            D3();
        }
    }

    public void E3(ro8 ro8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ro8Var) == null) {
            this.H = ro8Var;
        }
    }

    @Override // com.baidu.tieba.ao8
    public void G0(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            RelativeLayout relativeLayout = this.e.c;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            relativeLayout.setVisibility(i);
        }
    }

    public void G3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            gu5.b(arguments);
            this.v = arguments.getLong("roomId");
            this.w = arguments.getLong("forumId");
        }
    }

    public final void p3(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, spanGroupEditText) == null) {
            spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000), new c(this)});
        }
    }

    public final void v3(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, spanGroupEditText) == null) {
            spanGroupEditText.addTextChangedListener(new d(this));
        }
    }

    @Override // com.baidu.tieba.mo8
    public void w2(@NonNull PanelType panelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, panelType) == null) {
            if (panelType == PanelType.INPUT_KEYBOARD) {
                this.f.f0(true);
            } else {
                this.f.f0(false);
            }
        }
    }

    @Override // com.baidu.tieba.mo8
    public void y(@NonNull uoc<PanelType, PanelType, Float, Float> uocVar) {
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, uocVar) == null) && (inputDelegate = this.y) != null) {
            inputDelegate.X(uocVar);
        }
    }

    public void y3(@NonNull pn8 pn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, pn8Var) == null) {
            this.q = pn8Var;
        }
    }

    public void z3(@NonNull lq8 lq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, lq8Var) == null) {
            this.x = lq8Var;
        }
    }

    public void F3(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, viewGroup) == null) && view2 != null && viewGroup != null) {
            this.B = view2;
            this.C = viewGroup;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            o3();
            q3();
            t3();
            s3();
            pn8 pn8Var = this.q;
            if (pn8Var != null) {
                pn8Var.w1();
            }
        }
    }

    @Override // com.baidu.tieba.ko8
    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h hVar = this.I;
            if (hVar != null) {
                return hVar.A();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.mo8
    public View C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e.c;
        }
        return (View) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            pn8 pn8Var = this.q;
            if (pn8Var != null) {
                return pn8Var.N();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void V2() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (i = this.m) > 0) {
            String str = null;
            if (i == 1) {
                long j = this.w;
                if (j != 0) {
                    str = String.valueOf(j);
                }
            }
            br6.b().c(new gl8(str));
        }
    }

    public GroupChatKeyboardLayout W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.e.b;
        }
        return (GroupChatKeyboardLayout) invokeV.objValue;
    }

    public ze5 X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.j;
        }
        return (ze5) invokeV.objValue;
    }

    @Nullable
    public GroupInputTool Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.f;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    @NonNull
    public GroupChatUserReplyView Z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.e.g;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout a3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Nullable
    public InputDelegate b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.y;
        }
        return (InputDelegate) invokeV.objValue;
    }

    @NonNull
    public gf5 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.g;
        }
        return (gf5) invokeV.objValue;
    }

    @NonNull
    public RelativeLayout d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.e.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo8
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.E = true;
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.V(PanelType.INPUT_KEYBOARD, -10086);
            }
        }
    }

    @Nullable
    public NoSlidingLinearLayout e3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.e.f;
        }
        return (NoSlidingLinearLayout) invokeV.objValue;
    }

    @NonNull
    public GroupChatUserReplyView f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.e.h;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public vo8 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.p;
        }
        return (vo8) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mo8
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.E = false;
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null && !inputDelegate.F()) {
                this.y.V(PanelType.NONE, -10086);
            }
        }
    }

    @NonNull
    public GroupChatRobotFloorView h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.e.e;
        }
        return (GroupChatRobotFloorView) invokeV.objValue;
    }

    public boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.f.R();
        }
        return invokeV.booleanValue;
    }

    public kh5 j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.k;
        }
        return (kh5) invokeV.objValue;
    }

    @Nullable
    public ISendVoiceView k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.n;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.o;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public EditorTools m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.h;
        }
        return (EditorTools) invokeV.objValue;
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.o = (GroupChatRobotTopHeadView) this.e.d.findViewById(R.id.obfuscated_res_0x7f0911bc);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onDestroy();
            V2();
        }
    }

    public final void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            u3();
            n3();
            r3();
        }
    }

    @Override // com.baidu.tieba.ko8
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return no8.m;
        }
        return invokeV.intValue;
    }

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            GroupInputTool groupInputTool = new GroupInputTool(this);
            this.f = groupInputTool;
            this.y = new InputDelegate(InputDelegate.SOURCE.ROOM, this, groupInputTool, this.x, this.v, this.w);
        }
    }

    public boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.f.c0();
        }
        return invokeV.booleanValue;
    }

    public boolean x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    public void D3() {
        ve5 ve5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i = this.s;
            if (i == 0) {
                this.r = SkinManager.getColor(R.color.CAM_X0212);
            } else if (i == 1) {
                this.r = uua.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
            } else {
                this.r = SkinManager.getColor(R.color.CAM_X0212);
            }
            gf5 gf5Var = this.g;
            if (gf5Var != null && (ve5Var = gf5Var.m) != null && (ve5Var instanceof EditText)) {
                EMManager.from((EditText) ve5Var).setTextSize(R.dimen.T_X06).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0209).setBackGroundRealColor(this.r);
            }
        }
    }

    public final void s3() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && (context = getContext()) != null && this.B != null) {
            this.D = new no8();
            if (TbSingleton.getInstance().getKeyboardHeight() == 0 && TbadkCoreApplication.getInst().getKeyboardHeight() != 0) {
                TbSingleton.getInstance().setKeyboardHeight(TbadkCoreApplication.getInst().getKeyboardHeight());
            }
            no8 no8Var = this.D;
            no8Var.l(context);
            no8Var.j(this.B);
            no8Var.g(this.C);
            no8Var.h(this);
            no8Var.m(TbSingleton.getInstance().getKeyboardHeight());
            no8Var.o(true);
            no8Var.n(new a(this, context));
        }
    }

    public void H3(@NonNull ho8 ho8Var, @NonNull eo8 eo8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, ho8Var, eo8Var) == null) {
            this.z = ho8Var;
            this.A = eo8Var;
            if (ho8Var != null && eo8Var != null) {
                this.f.r0(ho8Var.d(), this.A.a());
                this.w = this.A.a();
            }
            vo8 vo8Var = this.p;
            if (vo8Var != null) {
                vo8Var.A(this.z, this.A);
            }
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.e0(this.z, this.A);
            }
        }
    }

    public void U2(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
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

    @SuppressLint({"ClickableViewAccessibility"})
    public void n3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            gf5 gf5Var = new gf5(getContext(), true, false);
            this.g = gf5Var;
            gf5Var.l(true);
            if (this.g.i() != null && this.g.i().getViewTreeObserver() != null) {
                this.g.i().getViewTreeObserver().addOnGlobalLayoutListener(this.J);
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, ue5.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                ue5 ue5Var = (ue5) runTask.getData();
                this.l = ue5Var;
                ve5 ve5Var = ue5Var.m;
                if (ve5Var != null && (ve5Var instanceof ISendVoiceView)) {
                    this.n = (ISendVoiceView) ve5Var;
                }
                ue5 ue5Var2 = this.l;
                ue5Var2.l = 1;
                this.h.f(ue5Var2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.h.k(arrayList);
            ue5 u = this.h.u(5);
            if (u != null) {
                u.g(true);
                u.f(true);
                u.d = 0;
            }
            this.h.f(this.g);
            ze5 ze5Var = new ze5(getContext());
            this.j = ze5Var;
            this.h.f(ze5Var);
            kh5 kh5Var = new kh5(getContext(), true);
            this.k = kh5Var;
            this.h.f(kh5Var);
            this.h.h();
            this.e.c.addView(this.h, new ViewGroup.LayoutParams(-1, -2));
            ve5 ve5Var2 = this.g.m;
            if (ve5Var2 instanceof EditText) {
                EMManager.from((EditText) ve5Var2).setTextSize(R.dimen.T_X06).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0209).setRealBorderColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.r));
            }
            this.h.F(TbadkCoreApplication.getInst().getSkinType());
            this.e.b.setBlank(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5, BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            this.e.b.setOnTouchListener(new b(this));
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048613, this, i, i2, intent) == null) {
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048616, this, layoutInflater, viewGroup, bundle)) == null) {
            FragmentInputToolBinding c2 = FragmentInputToolBinding.c(layoutInflater, viewGroup, false);
            this.e = c2;
            return c2.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            super.onChangeSkinType(i);
            this.h.F(i);
            D3();
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

    public void r3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.g.i() != null && getContext() != null) {
            SpanGroupEditText i = this.g.i();
            i.setId(R.id.obfuscated_res_0x7f090f04);
            i.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            i.setMinHeight(getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            i.setMaxLines(5);
            i.setMinLines(1);
            i.setGravity(48);
            i.setIncludeFontPadding(false);
            i.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.T_X06));
            i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            WriteVideoUtil.setCursorColor(i, R.drawable.edittext_cursor);
            i.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            i.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004));
            p3(i);
            v3(i);
        }
    }
}
