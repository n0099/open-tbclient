package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public abstract class il7 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> v0;
    public static HashSet<Integer> w0;
    public transient /* synthetic */ FieldHolder $fh;
    public e97 A;
    public FrsTopView B;
    public View C;
    public View D;
    public View E;
    public FrsVoiceRoomListLayout F;
    public EMTextView G;
    public boolean H;
    public SignActivityInfo I;
    public PopupWindow J;
    public View K;
    public TextView L;
    public TextView M;
    public ImageView N;
    public PopupWindow O;
    public BarImageView P;
    public UserIconBox Q;
    public ArrayList<mx4> R;
    public vk7 S;
    public uk7 T;
    public FrsLikeRecommendLayout U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public FrsViewData Z;
    public TbPageContext a;
    public ThreadData a0;
    public FrsFragment b;
    public int b0;
    public Handler c;
    public int c0;
    public View d;
    public int d0;
    public TextView e;
    public int e0;
    public TextView f;
    public int f0;
    public TextView g;
    public int g0;
    public List<TBSpecificationBtn> h;
    public int h0;
    public List<TBSpecificationBtn> i;
    public boolean i0;
    public TextView j;
    public boolean j0;
    public ImageView k;
    public wx4 k0;
    public ImageView l;
    public boolean l0;
    public View m;
    public boolean m0;
    public TextView n;
    public boolean n0;
    public TextView o;
    public boolean o0;
    public RelativeLayout p;
    public boolean p0;
    public RelativeLayout q;
    public float q0;
    public View r;
    public ViewGroup r0;
    public TextView s;
    public je7 s0;
    public RelativeLayout t;
    public boolean t0;
    public View u;
    public final Runnable u0;
    public RelativeLayout v;
    public LinearGradientView w;
    public TbImageView x;
    public ServiceAreaView y;
    public FrameLayout z;

    public abstract void A();

    public abstract void D(boolean z, float f);

    public abstract void E();

    public abstract void F();

    public abstract void G();

    public abstract void H();

    public abstract void I(View.OnClickListener onClickListener);

    public abstract void J(ForumData forumData, FrsViewData frsViewData);

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void T(sn snVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, snVar) == null) {
        }
    }

    public abstract void U(View view2, boolean z);

    public abstract void W();

    public abstract void Y();

    public abstract void a0();

    public abstract void b();

    public abstract void c(int i);

    public abstract String e();

    public abstract SignActivityInfo l();

    public abstract void p();

    public abstract boolean s();

    public abstract boolean u();

    public abstract void x(boolean z);

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        /* loaded from: classes4.dex */
        public class a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    b bVar = this.a;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.a, Key.SCALE_X, 0.0f, bVar.b);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                }
            }
        }

        public b(il7 il7Var, View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var, view2, Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                a aVar = new a(this);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, Key.SCALE_X, 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(aVar);
                ofFloat.start();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ il7 a;

        public a(il7 il7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = il7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            PopupWindow popupWindow;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (popupWindow = this.a.J) != null && popupWindow.isShowing()) {
                il7 il7Var = this.a;
                if (!il7Var.m0) {
                    lg.d(il7Var.J, il7Var.a.getPageActivity());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947857429, "Lcom/baidu/tieba/il7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947857429, "Lcom/baidu/tieba/il7;");
                return;
            }
        }
        v0 = new HashMap<>();
        w0 = new HashSet<>();
        v0.put(1, "c0117");
        v0.put(2, "c0124");
        v0.put(3, "c0125");
        v0.put(4, "c0126");
        v0.put(5, "c0127");
    }

    public il7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t0 = false;
        this.u0 = new a(this);
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            q();
            p();
        }
    }

    public BarImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.P;
        }
        return (BarImageView) invokeV.objValue;
    }

    public TextView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        wx4 wx4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.i0 || (wx4Var = this.k0) == null) {
                return "";
            }
            return wx4Var.c();
        }
        return (String) invokeV.objValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.n0;
        }
        return invokeV.booleanValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.n;
        }
        return (TextView) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.i0 = true;
            N(this.n0 ? 1 : 0);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            PopupWindow popupWindow = this.O;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.O.dismiss();
            }
            PopupWindow popupWindow2 = this.J;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.J.dismiss();
            }
        }
    }

    public void r() {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (frsLikeRecommendLayout = this.U) != null && frsLikeRecommendLayout.getVisibility() == 0) {
            this.U.j();
        }
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.o0;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int[] iArr = new int[2];
            try {
                this.N.getLocationOnScreen(iArr);
                if (iArr[0] < 160 || iArr[1] < 105) {
                    return false;
                }
                return true;
            } catch (NullPointerException unused) {
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.m0 = true;
            w0.clear();
        }
    }

    public void C(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
            D(false, f);
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i == 0) {
                this.n0 = false;
                H();
                return;
            }
            this.n0 = true;
            G();
        }
    }

    public void O(SignData signData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, signData) == null) && signData != null) {
            if (signData.forum_rank == -2) {
                N(signData.is_signed);
                a(false);
                return;
            }
            a(true);
            N(signData.is_signed);
        }
    }

    public void Q(uk7 uk7Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, uk7Var) == null) && uk7Var != null && (list = this.h) != null) {
            this.T = uk7Var;
            uk7Var.g(list);
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.h0 = i;
        }
    }

    public void S(vk7 vk7Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, vk7Var) == null) && vk7Var != null && (list = this.i) != null) {
            this.S = vk7Var;
            vk7Var.j(list);
        }
    }

    public void a(boolean z) {
        vk7 vk7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && (vk7Var = this.S) != null) {
            vk7Var.k(z);
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048628, this, z) == null) && !z) {
            q();
            p();
        }
    }

    public void K(TextView textView, TextView textView2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, textView, textView2) == null) {
            textView.setText(String.valueOf(this.f0));
            String string = this.a.getString(R.string.experience_divider);
            String string2 = this.a.getString(R.string.member_count_unit);
            int i = this.g0;
            if (i >= 10000) {
                if (i % 10000 == 0) {
                    textView2.setText(string + String.valueOf(this.g0 / 10000) + string2);
                    return;
                }
                textView2.setText(string + String.valueOf(i / 10000.0f) + string2);
                return;
            }
            textView2.setText(string + String.valueOf(this.g0));
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 0) {
                this.l0 = false;
                this.t0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.l0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            x(this.l0);
        }
    }

    public void V(List<do9> list) {
        ForumData forum;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, list) != null) || this.a == null || this.Z == null || TextUtils.isEmpty(this.W) || ListUtils.isEmpty(list) || (forum = this.Z.getForum()) == null || forum.getThemeColorInfo() == null || !d(forum.getThemeColorInfo())) {
        }
    }

    public final boolean d(ThemeColorInfo themeColorInfo) {
        InterceptResult invokeL;
        ThemeElement themeElement;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, themeColorInfo)) == null) {
            if (themeColorInfo == null || (themeElement = themeColorInfo.day) == null || themeColorInfo.dark == null || themeColorInfo.night == null || StringUtils.isNull(themeElement.font_color) || StringUtils.isNull(themeColorInfo.dark.font_color) || StringUtils.isNull(themeColorInfo.night.font_color)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void M(int i, String str, int i2, float f, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Float.valueOf(f), Boolean.valueOf(z)}) == null) {
            this.X = str;
            this.b0 = i2;
            if (i == 0) {
                this.l0 = false;
                this.t0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.l0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.t0) {
                    Y();
                    this.t0 = true;
                }
            }
            x(this.l0);
        }
    }

    public void X(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            view2.setPivotX(0.0f);
            b bVar = new b(this, view2, f2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(bVar);
            ofFloat.start();
        }
    }

    public void Z(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            if (new BigDecimal(f + "").compareTo(new BigDecimal(f2 + "")) == 0) {
                return;
            }
            view2.setPivotX(0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, f, f2);
            ofFloat.setDuration(1000L);
            ofFloat.start();
        }
    }
}
