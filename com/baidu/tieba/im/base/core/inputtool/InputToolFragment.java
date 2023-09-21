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
import com.baidu.tieba.adc;
import com.baidu.tieba.de8;
import com.baidu.tieba.fia;
import com.baidu.tieba.hl5;
import com.baidu.tieba.id8;
import com.baidu.tieba.ij5;
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
import com.baidu.tieba.jd8;
import com.baidu.tieba.jj5;
import com.baidu.tieba.md8;
import com.baidu.tieba.nj5;
import com.baidu.tieba.nu6;
import com.baidu.tieba.pd8;
import com.baidu.tieba.rx5;
import com.baidu.tieba.td8;
import com.baidu.tieba.tf8;
import com.baidu.tieba.ud8;
import com.baidu.tieba.uj5;
import com.baidu.tieba.vd8;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.WriteVideoUtil;
import com.baidu.tieba.xa8;
import com.baidu.tieba.xc8;
import com.baidu.tieba.xd8;
import com.baidu.tieba.yd8;
import com.baidu.tieba.zd8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class InputToolFragment extends SliceFragment implements id8, ud8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public md8 A;
    public View B;
    public ViewGroup C;
    public vd8 D;
    @Nullable
    public zd8 E;
    @Nullable
    public g F;
    public FragmentInputToolBinding e;
    public GroupInputTool f;
    public uj5 g;
    public EditorTools h;
    public LinearLayout.LayoutParams i;
    public nj5 j;
    public hl5 k;
    public ij5 l;
    public int m;
    @Nullable
    public ISendVoiceView n;
    @Nullable
    public GroupChatRobotTopHeadView o;
    public de8 p;
    @Nullable
    public xc8 q;
    public int r;
    public int s;
    public boolean t;
    public long u;
    public long v;
    public long w;
    @Nullable
    public tf8 x;
    @Nullable
    public InputDelegate y;
    @Nullable
    public pd8 z;

    /* loaded from: classes6.dex */
    public interface g {
        int u();
    }

    @Override // com.baidu.tieba.ud8
    public void M1(@Nullable xd8 xd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xd8Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ud8
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
                    new BdTopToast(this.a.a.getContext()).setContent(this.a.a.getContext().getString(R.string.obfuscated_res_0x7f0f0f04)).setIcon(false).show((ViewGroup) this.a.a.getView());
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
                if (this.a.M2()) {
                    if (TextUtils.isEmpty(charSequence)) {
                        return charSequence;
                    }
                    boolean matches = jd8.a.matcher(charSequence.toString()).matches();
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
    public class a implements zd8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ InputToolFragment b;

        @Override // com.baidu.tieba.zd8
        public /* synthetic */ void c() {
            yd8.a(this);
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

        @Override // com.baidu.tieba.zd8
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                zd8 zd8Var = this.b.E;
                if (zd8Var != null) {
                    zd8Var.b(i);
                }
                if (i < td8.b(this.a) / 2) {
                    TbSingleton.getInstance().setKeyboardHeight(i);
                }
            }
        }

        @Override // com.baidu.tieba.zd8
        public void g() {
            zd8 zd8Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (zd8Var = this.b.E) != null) {
                zd8Var.g();
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
                    this.a.y.C();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, editable) == null) && this.b.M2() && this.a != null && editable != null && editable.length() > 1 && this.a.length() > 1 && this.a.charAt(0) == '0') {
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
    }

    public void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.e.e.setPageContext(getPageContext());
            this.e.e.A(TbadkCoreApplication.getInst().getSkinType());
            de8 de8Var = new de8(this);
            this.p = de8Var;
            de8Var.w(this.e.e);
        }
    }

    public final void F2(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, spanGroupEditText) == null) {
            spanGroupEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000), new c(this)});
        }
    }

    public final void L2(@NonNull SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, spanGroupEditText) == null) {
            spanGroupEditText.addTextChangedListener(new d(this));
        }
    }

    public void N2(@NonNull xc8 xc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, xc8Var) == null) {
            this.q = xc8Var;
        }
    }

    public void O2(@NonNull tf8 tf8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tf8Var) == null) {
            this.x = tf8Var;
        }
    }

    public void P2(@Nullable g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.F = gVar;
        }
    }

    public void Q2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.t = z;
        }
    }

    public void R2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.s = i;
            S2();
        }
    }

    public void T2(zd8 zd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, zd8Var) == null) {
            this.E = zd8Var;
        }
    }

    public void V2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.m = i;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
            super.onCreate(bundle);
            Bundle arguments = getArguments();
            rx5.b(arguments);
            this.v = arguments.getLong("roomId");
            this.w = arguments.getLong("forumId");
        }
    }

    @Override // com.baidu.tieba.ud8
    public void s(@NonNull adc<PanelType, PanelType, Float, Float> adcVar) {
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, adcVar) == null) && (inputDelegate = this.y) != null) {
            inputDelegate.V(adcVar);
        }
    }

    @Override // com.baidu.tieba.id8
    public void v0(boolean z) {
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

    public void U2(View view2, ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048598, this, view2, viewGroup) == null) && view2 != null && viewGroup != null) {
            this.B = view2;
            this.C = viewGroup;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@Nullable View view2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            E2();
            G2();
            J2();
            I2();
            xc8 xc8Var = this.q;
            if (xc8Var != null) {
                xc8Var.d1();
            }
        }
    }

    @Nullable
    public ISendVoiceView A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.n;
        }
        return (ISendVoiceView) invokeV.objValue;
    }

    @Nullable
    public GroupChatRobotTopHeadView B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.o;
        }
        return (GroupChatRobotTopHeadView) invokeV.objValue;
    }

    public EditorTools C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (EditorTools) invokeV.objValue;
    }

    public final void E2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.o = (GroupChatRobotTopHeadView) this.e.d.findViewById(R.id.obfuscated_res_0x7f09113b);
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            K2();
            D2();
            H2();
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            xc8 xc8Var = this.q;
            if (xc8Var != null) {
                return xc8Var.H();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            GroupInputTool groupInputTool = new GroupInputTool(this);
            this.f = groupInputTool;
            this.y = new InputDelegate(InputDelegate.SOURCE.ROOM, this, groupInputTool, this.x, this.v, this.w);
        }
    }

    public boolean M2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.t;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ud8
    public void l() {
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (inputDelegate = this.y) != null) {
            inputDelegate.T(PanelType.INPUT_KEYBOARD);
        }
    }

    public final void l2() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (i = this.m) > 0) {
            String str = null;
            if (i == 1) {
                long j = this.w;
                if (j != 0) {
                    str = String.valueOf(j);
                }
            }
            nu6.b().b(new xa8(str));
        }
    }

    public GroupChatKeyboardLayout m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e.b;
        }
        return (GroupChatKeyboardLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd8
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return vd8.l;
        }
        return invokeV.intValue;
    }

    public nj5 n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.j;
        }
        return (nj5) invokeV.objValue;
    }

    @Nullable
    public GroupInputTool o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.f;
        }
        return (GroupInputTool) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onDestroy();
            l2();
        }
    }

    @NonNull
    public GroupChatUserReplyView p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.e.g;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    @Nullable
    public RelativeLayout q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.e.c;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ud8
    public void r() {
        InputDelegate inputDelegate;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (inputDelegate = this.y) != null && !inputDelegate.E()) {
            this.y.T(PanelType.NONE);
        }
    }

    @Nullable
    public InputDelegate r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.y;
        }
        return (InputDelegate) invokeV.objValue;
    }

    @NonNull
    public uj5 s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.g;
        }
        return (uj5) invokeV.objValue;
    }

    @NonNull
    public RelativeLayout t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.e.d;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.tieba.sd8
    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            g gVar = this.F;
            if (gVar != null) {
                return gVar.u();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public NoSlidingLinearLayout u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.e.f;
        }
        return (NoSlidingLinearLayout) invokeV.objValue;
    }

    @NonNull
    public GroupChatUserReplyView v2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.e.h;
        }
        return (GroupChatUserReplyView) invokeV.objValue;
    }

    public de8 w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.p;
        }
        return (de8) invokeV.objValue;
    }

    @NonNull
    public GroupChatRobotFloorView x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.e.e;
        }
        return (GroupChatRobotFloorView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ud8
    public View y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.e.c;
        }
        return (View) invokeV.objValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.f.P();
        }
        return invokeV.booleanValue;
    }

    public hl5 z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.k;
        }
        return (hl5) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            uj5 uj5Var = new uj5(getContext(), true, false);
            this.g = uj5Var;
            uj5Var.j(true);
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
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001301, ij5.class, getContext());
            if (runTask != null && runTask.getData() != null) {
                ij5 ij5Var = (ij5) runTask.getData();
                this.l = ij5Var;
                jj5 jj5Var = ij5Var.m;
                if (jj5Var != null && (jj5Var instanceof ISendVoiceView)) {
                    this.n = (ISendVoiceView) jj5Var;
                }
                ij5 ij5Var2 = this.l;
                ij5Var2.l = 1;
                this.h.d(ij5Var2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            this.h.h(arrayList);
            ij5 p = this.h.p(5);
            if (p != null) {
                p.f(true);
                p.e(true);
                p.d = 0;
            }
            this.h.d(this.g);
            nj5 nj5Var = new nj5(getContext());
            this.j = nj5Var;
            this.h.d(nj5Var);
            hl5 hl5Var = new hl5(getContext(), true);
            this.k = hl5Var;
            this.h.d(hl5Var);
            this.h.f();
            this.e.c.addView(this.h, new ViewGroup.LayoutParams(-1, -2));
            jj5 jj5Var2 = this.g.m;
            if (jj5Var2 instanceof EditText) {
                EMManager.from((EditText) jj5Var2).setTextSize(R.dimen.T_X06).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0209).setRealBorderColor(SkinManager.getColor(TbadkCoreApplication.getInst().getSkinType(), this.r));
            }
            this.h.z(TbadkCoreApplication.getInst().getSkinType());
            this.e.b.setBlank(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5, BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5, 0, BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
            this.e.b.setOnTouchListener(new b(this));
        }
    }

    public void H2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.g.g() != null && getContext() != null) {
            SpanGroupEditText g2 = this.g.g();
            g2.setId(R.id.obfuscated_res_0x7f090e93);
            g2.setType(SpanGroupEditText.EDIT_TEXT_TYPE.TYPE_DEFAULT);
            g2.setMinHeight(getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X003));
            g2.setMaxLines(5);
            g2.setMinLines(1);
            g2.setGravity(48);
            g2.setIncludeFontPadding(false);
            g2.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.T_X06));
            g2.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            g2.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            WriteVideoUtil.setCursorColor(g2, R.drawable.edittext_cursor);
            g2.setLineSpacing(BdUtilHelper.getDimens(getContext(), R.dimen.M_T_X002), 1.0f);
            g2.setPadding(BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004), BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X006), BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004));
            F2(g2);
            L2(g2);
        }
    }

    public final void I2() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (context = getContext()) != null && this.B != null) {
            this.D = new vd8();
            if (TbSingleton.getInstance().getKeyboardHeight() == 0 && TbadkCoreApplication.getInst().getKeyboardHeight() != 0) {
                TbSingleton.getInstance().setKeyboardHeight(TbadkCoreApplication.getInst().getKeyboardHeight());
            }
            vd8 vd8Var = this.D;
            vd8Var.k(context);
            vd8Var.i(this.B);
            vd8Var.f(this.C);
            vd8Var.g(this);
            vd8Var.l(TbSingleton.getInstance().getKeyboardHeight());
            vd8Var.n(true);
            vd8Var.m(new a(this, context));
        }
    }

    public void S2() {
        jj5 jj5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            int i = this.s;
            if (i == 0) {
                this.r = SkinManager.getColor(R.color.CAM_X0212);
            } else if (i == 1) {
                this.r = fia.a(SkinManager.getColor(R.color.CAM_X0302), 0.06f);
            } else {
                this.r = SkinManager.getColor(R.color.CAM_X0212);
            }
            uj5 uj5Var = this.g;
            if (uj5Var != null && (jj5Var = uj5Var.m) != null && (jj5Var instanceof EditText)) {
                EMManager.from((EditText) jj5Var).setTextSize(R.dimen.T_X06).setCorner(R.string.J_X07).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0209).setBackGroundRealColor(this.r);
            }
        }
    }

    public void W2(@NonNull pd8 pd8Var, @NonNull md8 md8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, pd8Var, md8Var) == null) {
            this.z = pd8Var;
            this.A = md8Var;
            if (pd8Var != null && md8Var != null) {
                this.f.o0(pd8Var.d(), this.A.a());
                this.w = this.A.a();
            }
            de8 de8Var = this.p;
            if (de8Var != null) {
                de8Var.z(this.z, this.A);
            }
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.c0(this.z, this.A);
            }
        }
    }

    public void k2(int i, int i2, long j, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), animatorListenerAdapter}) == null) {
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

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048609, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            InputDelegate inputDelegate = this.y;
            if (inputDelegate != null) {
                inputDelegate.G(i, i2, intent);
            }
        }
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            FragmentInputToolBinding c2 = FragmentInputToolBinding.c(layoutInflater, viewGroup, false);
            this.e = c2;
            return c2.getRoot();
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.im.base.core.slice.SliceFragment, com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            super.onChangeSkinType(i);
            this.h.z(i);
            S2();
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
                inputDelegate.H(i);
            }
        }
    }
}
