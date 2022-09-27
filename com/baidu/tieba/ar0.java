package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.player.constants.PlayerStatus;
import com.baidu.nadcore.player.layer.LayerContainer;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class ar0 implements cw0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean z;
    public transient /* synthetic */ FieldHolder $fh;
    public qx0 a;
    @Nullable
    public ow0 b;
    public LayerContainer c;
    public bx0 d;
    public ViewGroup e;
    public gy0 f;
    public AudioManager g;
    public b h;
    public boolean i;
    @Nullable
    public String j;
    public boolean k;
    public ViewGroup.LayoutParams l;
    public ms0 m;
    public final rt0 n;
    public final mt0 o;
    public final ht0 p;
    public final jt0 q;
    @NonNull
    public String r;
    public boolean s;
    public float t;
    public int u;
    public uu0 v;
    public boolean w;
    public int x;
    public final tu0 y;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ar0 b;

        public a(ar0 ar0Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ar0Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if ((i == -2 || i == -1) && this.b.Y()) {
                    this.b.f0(2);
                    this.b.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar0 a;

        public b(ar0 ar0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar0Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.d0(i);
            }
        }

        public /* synthetic */ b(ar0 ar0Var, a aVar) {
            this(ar0Var);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements yu0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ar0 a;

        public c(ar0 ar0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ar0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ar0Var;
        }

        @Override // com.baidu.tieba.yu0
        public void a(ut0 ut0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ut0Var) == null) {
                this.a.y().b(ut0Var);
            }
        }

        @Override // com.baidu.tieba.yu0
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public /* synthetic */ c(ar0 ar0Var, a aVar) {
            this(ar0Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947624650, "Lcom/baidu/tieba/ar0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947624650, "Lcom/baidu/tieba/ar0;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ar0(@NonNull tu0 tu0Var, @Nullable Context context) {
        this(tu0Var, context, new ow0(zq0.a()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((tu0) objArr2[0], (Context) objArr2[1], (ow0) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? z : invokeV.booleanValue;
    }

    @Nullable
    public ow0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (ow0) invokeV.objValue;
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.w = z2;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    public void B0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            dz0.g(M0("setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX));
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return;
            }
            this.x = i;
            ow0Var.q0(i);
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return 0;
            }
            return ow0Var.P();
        }
        return invokeV.intValue;
    }

    public void C0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r = str;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return 0;
            }
            return ow0Var.Q();
        }
        return invokeV.intValue;
    }

    public void D0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            E0(str, true);
        }
    }

    @NonNull
    public abstract uu0 E();

    public void E0(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z2) == null) {
            dz0.g(M0("setVideoUrl = " + str));
            this.a.b = str;
            z().p(this.a.b, z2, B());
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.x : invokeV.intValue;
    }

    public void F0(@Nullable ow0 ow0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, ow0Var) == null) || ow0Var == null) {
            return;
        }
        e(ow0Var);
    }

    public float G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.t : invokeV.floatValue;
    }

    public abstract void G0(@NonNull Context context);

    @NonNull
    public rt0 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : (rt0) invokeV.objValue;
    }

    public void H0(Context context, @Nullable ow0 ow0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, ow0Var) == null) {
            J0();
            F0(ow0Var);
            G0(context);
            I0(context);
        }
    }

    @NonNull
    public PlayerStatus I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ow0 ow0Var = this.b;
            return ow0Var == null ? PlayerStatus.IDLE : ow0Var.R();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
        }
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var != null) {
                return ow0Var.S();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            H().b(this.d);
            z().b(this.d);
            q().b(this.d);
            t().b(this.d);
        }
    }

    public qx0 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.a : (qx0) invokeV.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            dz0.g(M0("start()"));
            l();
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ow0 ow0Var = this.b;
            return ow0Var == null ? "" : ow0Var.V();
        }
        return (String) invokeV.objValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            dz0.g(M0("stop()"));
            if (this.b == null) {
                return;
            }
            a();
            q().i();
            t().g();
            H().j(w());
            ju0.a(getActivity(), false);
        }
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var != null) {
                return ow0Var.W();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public String M0(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(this.r)) {
                str2 = "Player@" + System.identityHashCode(this);
            } else {
                str2 = this.r;
            }
            sb.append(str2);
            sb.append("=>");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m = new ms0();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            bx0 createMessenger = zq0.d().createMessenger();
            this.d = createMessenger;
            createMessenger.b(new c(this, null));
            py0.c().a(this);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? I() == PlayerStatus.COMPLETE : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? I() == PlayerStatus.ERROR : invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? I() == PlayerStatus.PAUSE : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? T() : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? I() == PlayerStatus.PLAYING : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? I() == PlayerStatus.PREPARED : invokeV.booleanValue;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            AudioManager audioManager = this.g;
            if (audioManager != null && (bVar = this.h) != null) {
                audioManager.abandonAudioFocus(bVar);
                dz0.g(M0("abandonAudioFocus()"));
                this.g = null;
                this.h = null;
            }
            this.i = false;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? I() == PlayerStatus.STOP : invokeV.booleanValue;
    }

    public void b(@NonNull hw0 hw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hw0Var) == null) {
            this.c.a(hw0Var);
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public void c(@NonNull hw0 hw0Var, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, hw0Var, layoutParams) == null) {
            this.c.b(hw0Var, layoutParams);
        }
    }

    public void c0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            dz0.g(M0("mute(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return;
            }
            ow0Var.X(z2);
        }
    }

    public void d(@NonNull by0 by0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, by0Var) == null) {
            this.f.a(by0Var);
        }
    }

    public void d0(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i) == null) || (activity = getActivity()) == null || X()) {
            return;
        }
        activity.runOnUiThread(new a(this, i));
    }

    public void e(@NonNull ow0 ow0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, ow0Var) == null) {
            k();
            dz0.g(M0("attachKernelLayer(" + System.identityHashCode(ow0Var) + "), kernel = " + System.identityHashCode(ow0Var.T())));
            this.b = ow0Var;
            ow0Var.j0(this);
            this.c.c(ow0Var);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            f0(0);
        }
    }

    public void f(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, viewGroup) == null) {
            g(viewGroup, true);
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            dz0.g(M0("pause(" + i + SmallTailInfo.EMOTION_SUFFIX));
            if (this.b == null) {
                return;
            }
            a();
            q().d(i);
            t().d();
            H().g();
        }
    }

    public void g(@NonNull ViewGroup viewGroup, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, viewGroup, z2) == null) {
            j(z2);
            dz0.g(M0("attachToContainer(" + System.identityHashCode(viewGroup) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.e = viewGroup;
            viewGroup.addView(this.c, this.l);
            z().k();
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            dz0.g(M0("release()"));
            H().j(w());
            h0();
            ju0.a(getActivity(), false);
            y().r();
            a();
            j0();
            this.f.c();
            this.c.i();
            j(false);
            i0();
            this.e = null;
        }
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup == null || !(viewGroup.getContext() instanceof Activity)) {
                return null;
            }
            return (Activity) this.e.getContext();
        }
        return (Activity) invokeV.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, context) == null) {
            this.l = new ViewGroup.LayoutParams(-1, -1);
            this.a = new qx0();
            O();
            this.f = new gy0(this);
            LayerContainer i = i(context);
            this.c = i;
            i.d(this);
            this.c.setClickable(true);
            N();
        }
    }

    public void h0() {
        ow0 ow0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (ow0Var = this.b) == null) {
            return;
        }
        ow0Var.Y();
        this.b.t0();
        this.b.a0();
    }

    public LayerContainer i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, context)) == null) ? new LayerContainer(context) : (LayerContainer) invokeL.objValue;
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            py0.c().g(this);
            this.d.release();
        }
    }

    public void j(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) && (this.c.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.c.getParent();
            viewGroup.removeView(this.c);
            dz0.g(M0("detachFromContainer(" + z2 + "), parent = " + System.identityHashCode(viewGroup)));
            if (z2) {
                this.c.h();
                z().l();
            }
            this.e = null;
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            H().a();
            z().a();
            q().a();
            t().a();
        }
    }

    @Nullable
    public ow0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.b != null) {
                dz0.g(M0("detachKernelLayer = " + System.identityHashCode(this.b)));
                ow0 ow0Var = this.b;
                this.c.f(ow0Var, true);
                ow0Var.j0(null);
                this.b = null;
                return ow0Var;
            }
            return null;
        }
        return (ow0) invokeV.objValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || this.i) {
            return;
        }
        if (this.g == null) {
            this.g = (AudioManager) m().getSystemService("audio");
        }
        if (this.g != null) {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            this.i = this.g.requestAudioFocus(this.h, 3, 2) == 1;
            dz0.g(M0("requestAudioFocus()"));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            dz0.g(M0("doPlay(), status = " + I()));
            if (this.b == null || W()) {
                return;
            }
            if (!X()) {
                k0();
            }
            ju0.a(getActivity(), true);
            q().h();
            t().f();
            dz0.g(M0("doPlay, url = " + L()));
            H().i();
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            dz0.g(M0("resume()"));
            if (this.b != null && W()) {
                if (!X()) {
                    k0();
                }
                q().e();
                t().e();
                H().h();
            }
        }
    }

    @NonNull
    public Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? zq0.b() : (Context) invokeV.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            dz0.g(M0("resumeFromError()"));
            ow0 ow0Var = this.b;
            if (ow0Var != null) {
                ow0Var.u0();
            }
            B0(F());
            D0(this.a.b);
            n0(false);
        }
    }

    @Nullable
    public ViewGroup n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.e : (ViewGroup) invokeV.objValue;
    }

    public void n0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            dz0.g(M0("resumePlayer(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return;
            }
            if (z2) {
                qx0 qx0Var = this.a;
                qx0Var.d = 0;
                qx0Var.e = 0;
                qx0Var.f = 0;
            } else {
                this.a.d = ow0Var.P();
                this.a.e = this.b.M();
                this.a.f = this.b.Q();
            }
            if (W()) {
                l0();
            } else {
                K0();
            }
        }
    }

    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? "CyberNetPlayer" : (String) invokeV.objValue;
    }

    public void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            q().f(i * 1000, 3);
        }
    }

    @Override // com.baidu.tieba.cw0
    public void onBufferingUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            z().f(i);
        }
    }

    @Override // com.baidu.tieba.cw0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            a();
            z().g();
            H().f(w());
        }
    }

    @Override // com.baidu.tieba.cw0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048647, this, i, i2, obj)) == null) {
            z().h(i, i2, obj);
            H().d(i, i2, obj);
            ju0.a(getActivity(), false);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.cw0
    public boolean onInfo(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048648, this, i, i2, obj)) == null) {
            z().i(i, i2, obj);
            H().e(i, i2, obj);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.cw0
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048649, this, i, i2, obj)) == null) {
            z().j(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.cw0
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            z().m();
        }
    }

    @Override // com.baidu.tieba.cw0
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            z().n();
        }
    }

    @Override // com.baidu.tieba.cw0
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048652, this, i, i2, i3, i4) == null) {
            z().o(i, i2, i3, i4);
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return 0;
            }
            return ow0Var.L();
        }
        return invokeV.intValue;
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i) == null) {
            q().f(i, 3);
        }
    }

    @NonNull
    public ht0 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.p : (ht0) invokeV.objValue;
    }

    public void q0(@NonNull ut0 ut0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, ut0Var) == null) {
            this.d.d(ut0Var);
        }
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return this.a.e;
            }
            return ow0Var.M();
        }
        return invokeV.intValue;
    }

    public void r0(@Nullable String str) {
        ow0 ow0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048658, this, str) == null) || (ow0Var = this.b) == null) {
            return;
        }
        ow0Var.g0(str);
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            ow0 ow0Var = this.b;
            if (ow0Var == null) {
                return this.a.e * 1000;
            }
            return ow0Var.N();
        }
        return invokeV.intValue;
    }

    public void s0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z2) == null) {
            z = z2;
            w0(z2);
        }
    }

    @NonNull
    public final jt0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.q : (jt0) invokeV.objValue;
    }

    public void t0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) && z2 && this.b != null) {
            dz0.g(M0("setHasReplaceUrl(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.b.v0(null);
        }
    }

    @Nullable
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public void u0(@Nullable wu0 wu0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, wu0Var) == null) {
            this.d.a(wu0Var);
        }
    }

    @NonNull
    public LayerContainer v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.c : (LayerContainer) invokeV.objValue;
    }

    public void v0(boolean z2) {
        ow0 ow0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048666, this, z2) == null) || (ow0Var = this.b) == null) {
            return;
        }
        ow0Var.k0(z2);
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.u : invokeV.intValue;
    }

    public void w0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            dz0.g(M0("setMuteMode(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.s = z2;
            ow0 ow0Var = this.b;
            if (ow0Var != null) {
                ow0Var.X(z2);
            }
            if (z2) {
                a();
            } else if (Y()) {
                k0();
            }
        }
    }

    public bx0 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.d : (bx0) invokeV.objValue;
    }

    public void x0(@Nullable String str) {
        ow0 ow0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, str) == null) || (ow0Var = this.b) == null) {
            return;
        }
        ow0Var.m0(str);
    }

    @NonNull
    public ms0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.m : (ms0) invokeV.objValue;
    }

    public void y0(gs0 gs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, gs0Var) == null) {
            y().s(gs0Var);
        }
    }

    public mt0 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.o : (mt0) invokeV.objValue;
    }

    public void z0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048674, this, f) == null) {
            this.t = f;
            ow0 ow0Var = this.b;
            if (ow0Var != null) {
                ow0Var.o0(f);
                dz0.g(M0("setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ar0(@NonNull tu0 tu0Var, @Nullable Context context, @Nullable ow0 ow0Var) {
        this(tu0Var, context, ow0Var, "", "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu0Var, context, ow0Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((tu0) objArr2[0], (Context) objArr2[1], (ow0) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public ar0(@NonNull tu0 tu0Var, @Nullable Context context, @Nullable ow0 ow0Var, @NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tu0Var, context, ow0Var, str, str2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.k = false;
        this.n = new rt0();
        this.o = new mt0();
        this.p = new ht0();
        this.q = new jt0();
        this.s = false;
        this.t = 1.0f;
        this.u = 0;
        this.w = false;
        this.x = 2;
        this.y = tu0Var;
        this.r = str;
        this.j = str2;
        dz0.g(M0("BDVideoPlayer(" + context + ",  kernelLayer@" + System.identityHashCode(ow0Var) + ", key@" + this.r + SmallTailInfo.EMOTION_SUFFIX));
        context = context == null ? m() : context;
        h(context);
        P();
        H0(context, ow0Var);
    }
}
