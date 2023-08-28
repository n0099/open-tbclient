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
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.banner.data.FrsHeadBannerData;
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
/* loaded from: classes6.dex */
public abstract class hw7 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<Integer, String> p0;
    public static HashSet<Integer> q0;
    public transient /* synthetic */ FieldHolder $fh;
    public CoverFlowView<FrsHeadBannerData> A;
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
    public ImageView L;
    public PopupWindow M;
    public BarImageView N;
    public UserIconBox O;
    public ArrayList<i15> P;
    public uv7 Q;
    public tv7 R;
    public FrsLikeRecommendLayout S;

    /* renamed from: T  reason: collision with root package name */
    public String f1128T;
    public String U;
    public String V;
    public FrsViewData W;
    public ThreadData X;
    public int Y;
    public int Z;
    public TbPageContext a;
    public int a0;
    public FrsFragment b;
    public int b0;
    public Handler c;
    public int c0;
    public View d;
    public boolean d0;
    public TextView e;
    public boolean e0;
    public TextView f;
    public t15 f0;
    public TextView g;
    public boolean g0;
    public List<TBSpecificationBtn> h;
    public boolean h0;
    public List<TBSpecificationBtn> i;
    public boolean i0;
    public TextView j;
    public boolean j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public float l0;
    public View m;
    public ViewGroup m0;
    public TextView n;
    public zo7 n0;
    public TextView o;
    public boolean o0;
    public RelativeLayout p;
    public RelativeLayout q;
    public View r;
    public TextView s;
    public RelativeLayout t;
    public View u;
    public RelativeLayout v;
    public LinearGradientView w;
    public TbImageView x;
    public ServiceAreaView y;
    public FrameLayout z;

    public abstract void B();

    public abstract void E(boolean z, float f);

    public abstract void F();

    public abstract void G();

    public abstract void H();

    public abstract void I();

    public abstract void J(View.OnClickListener onClickListener);

    public abstract void K(ForumData forumData, FrsViewData frsViewData);

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void T(ln lnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, lnVar) == null) {
        }
    }

    public abstract void V();

    public abstract void X();

    public abstract void Z();

    public abstract void b();

    public abstract void c(int i);

    public abstract void d();

    public abstract String f();

    public abstract SignActivityInfo m();

    public abstract void q();

    public abstract boolean t();

    public abstract boolean v();

    public abstract void y(boolean z);

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Animator.AnimatorListener {
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

        /* renamed from: com.baidu.tieba.hw7$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0329a implements Animator.AnimatorListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

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

            public C0329a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    a aVar = this.a;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar.a, Key.SCALE_X, 0.0f, aVar.b);
                    ofFloat.setDuration(300L);
                    ofFloat.start();
                }
            }
        }

        public a(hw7 hw7Var, View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hw7Var, view2, Float.valueOf(f)};
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
                C0329a c0329a = new C0329a(this);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, Key.SCALE_X, 1.0f, 0.0f);
                ofFloat.setDuration(300L);
                ofFloat.addListener(c0329a);
                ofFloat.start();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947838209, "Lcom/baidu/tieba/hw7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947838209, "Lcom/baidu/tieba/hw7;");
                return;
            }
        }
        p0 = new HashMap<>();
        q0 = new HashSet<>();
        p0.put(1, "c0117");
        p0.put(2, "c0124");
        p0.put(3, "c0125");
        p0.put(4, "c0126");
        p0.put(5, "c0127");
    }

    public hw7() {
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
        this.o0 = false;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r();
            q();
        }
    }

    public BarImageView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.N;
        }
        return (BarImageView) invokeV.objValue;
    }

    public TextView h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.m;
        }
        return (View) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        t15 t15Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (this.d0 || (t15Var = this.f0) == null) {
                return "";
            }
            return t15Var.c();
        }
        return (String) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.n;
        }
        return (TextView) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.d0 = true;
            N(this.i0 ? 1 : 0);
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.g0;
        }
        return invokeV.booleanValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            PopupWindow popupWindow2 = this.J;
            if (popupWindow2 != null && popupWindow2.isShowing()) {
                this.J.dismiss();
            }
        }
    }

    public void s() {
        FrsLikeRecommendLayout frsLikeRecommendLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (frsLikeRecommendLayout = this.S) != null && frsLikeRecommendLayout.getVisibility() == 0) {
            this.S.l();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.j0;
        }
        return invokeV.booleanValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int[] iArr = new int[2];
            try {
                this.L.getLocationOnScreen(iArr);
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

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.h0 = true;
            q0.clear();
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !z) {
            r();
            q();
        }
    }

    public void D(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
            E(false, f);
        }
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i == 0) {
                this.i0 = false;
                I();
                return;
            }
            this.i0 = true;
            H();
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

    public void Q(tv7 tv7Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, tv7Var) == null) && tv7Var != null && (list = this.h) != null) {
            this.R = tv7Var;
            tv7Var.g(list);
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.c0 = i;
        }
    }

    public void S(uv7 uv7Var) {
        List<TBSpecificationBtn> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, uv7Var) == null) && uv7Var != null && (list = this.i) != null) {
            this.Q = uv7Var;
            uv7Var.j(list);
        }
    }

    public void a(boolean z) {
        uv7 uv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048602, this, z) == null) && (uv7Var = this.Q) != null) {
            uv7Var.k(z);
        }
    }

    public void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (i == 0) {
                this.g0 = false;
                this.o0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
            }
            y(this.g0);
        }
    }

    public void U(List<pea> list) {
        ForumData forum;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, list) != null) || this.a == null || this.W == null || TextUtils.isEmpty(this.U) || ListUtils.isEmpty(list) || (forum = this.W.getForum()) == null || forum.getThemeColorInfo() == null || !e(forum.getThemeColorInfo())) {
        }
    }

    public final boolean e(ThemeColorInfo themeColorInfo) {
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
            this.V = str;
            this.Y = i2;
            if (i == 0) {
                this.g0 = false;
                this.o0 = false;
                this.p.setVisibility(0);
                this.q.setVisibility(8);
            } else {
                this.g0 = true;
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                if (z && !this.o0) {
                    X();
                    this.o0 = true;
                }
            }
            y(this.g0);
        }
    }

    public void W(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            view2.setPivotX(0.0f);
            a aVar = new a(this, view2, f2);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, f, 1.0f);
            ofFloat.setDuration(400L);
            ofFloat.addListener(aVar);
            ofFloat.start();
        }
    }

    public void Y(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
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
