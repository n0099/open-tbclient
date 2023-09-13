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
/* loaded from: classes5.dex */
public abstract class cu0 implements ez0 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean z;
    public transient /* synthetic */ FieldHolder $fh;
    public s01 a;
    @Nullable
    public qz0 b;
    public LayerContainer c;
    public d01 d;
    public ViewGroup e;
    public i11 f;
    public AudioManager g;
    public b h;
    public boolean i;
    @Nullable
    public String j;
    public boolean k;
    public ViewGroup.LayoutParams l;
    public ov0 m;
    public final tw0 n;
    public final ow0 o;
    public final jw0 p;
    public final lw0 q;
    @NonNull
    public String r;
    public boolean s;
    public float t;
    public int u;
    public wx0 v;
    public boolean w;
    public int x;
    public final vx0 y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947687115, "Lcom/baidu/tieba/cu0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947687115, "Lcom/baidu/tieba/cu0;");
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

    @NonNull
    public abstract wx0 E();

    public abstract void G0(@NonNull Context context);

    public void I0(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @NonNull
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? "CyberNetPlayer" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ cu0 b;

        public a(cu0 cu0Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu0Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cu0Var;
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

    /* loaded from: classes5.dex */
    public class b implements AudioManager.OnAudioFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu0 a;

        public b(cu0 cu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu0Var;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.d0(i);
            }
        }

        public /* synthetic */ b(cu0 cu0Var, a aVar) {
            this(cu0Var);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ay0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu0 a;

        @Override // com.baidu.tieba.ay0
        public int getExpectOrder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(cu0 cu0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu0Var;
        }

        @Override // com.baidu.tieba.ay0
        public void a(ww0 ww0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ww0Var) == null) {
                this.a.y().b(ww0Var);
            }
        }

        public /* synthetic */ c(cu0 cu0Var, a aVar) {
            this(cu0Var);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cu0(@NonNull vx0 vx0Var, @Nullable Context context) {
        this(vx0Var, context, new qz0(bu0.a()));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vx0Var, context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((vx0) objArr2[0], (Context) objArr2[1], (qz0) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void g(@NonNull ViewGroup viewGroup, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048626, this, viewGroup, z2) == null) {
            j(z2);
            f21.g(M0("attachToContainer(" + System.identityHashCode(viewGroup) + StringUtil.ARRAY_ELEMENT_SEPARATOR + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.e = viewGroup;
            viewGroup.addView(this.c, this.l);
            z().k();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cu0(@NonNull vx0 vx0Var, @Nullable Context context, @Nullable qz0 qz0Var) {
        this(vx0Var, context, qz0Var, "", "");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vx0Var, context, qz0Var};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((vx0) objArr2[0], (Context) objArr2[1], (qz0) objArr2[2], (String) objArr2[3], (String) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public cu0(@NonNull vx0 vx0Var, @Nullable Context context, @Nullable qz0 qz0Var, @NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vx0Var, context, qz0Var, str, str2};
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
        this.n = new tw0();
        this.o = new ow0();
        this.p = new jw0();
        this.q = new lw0();
        this.s = false;
        this.t = 1.0f;
        this.u = 0;
        this.w = false;
        this.x = 2;
        this.y = vx0Var;
        this.r = str;
        this.j = str2;
        f21.g(M0("BDVideoPlayer(" + context + ",  kernelLayer@" + System.identityHashCode(qz0Var) + ", key@" + this.r + SmallTailInfo.EMOTION_SUFFIX));
        context = context == null ? m() : context;
        h(context);
        P();
        H0(context, qz0Var);
    }

    public static boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return z;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public qz0 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (qz0) invokeV.objValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return 0;
            }
            return qz0Var.Q();
        }
        return invokeV.intValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return 0;
            }
            return qz0Var.R();
        }
        return invokeV.intValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public float G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.t;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public tw0 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.n;
        }
        return (tw0) invokeV.objValue;
    }

    @NonNull
    public PlayerStatus I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return PlayerStatus.IDLE;
            }
            return qz0Var.S();
        }
        return (PlayerStatus) invokeV.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var != null) {
                return qz0Var.T();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public s01 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.a;
        }
        return (s01) invokeV.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            f21.g(M0("start()"));
            l();
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return "";
            }
            return qz0Var.X();
        }
        return (String) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var != null) {
                return qz0Var.Y();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.m = new ov0();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            d01 createMessenger = bu0.d().createMessenger();
            this.d = createMessenger;
            createMessenger.b(new c(this, null));
            r11.c().a(this);
        }
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (I() == PlayerStatus.COMPLETE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (I() == PlayerStatus.ERROR) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (I() == PlayerStatus.PAUSE) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return T();
        }
        return invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (I() == PlayerStatus.PLAYING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (I() == PlayerStatus.PREPARED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void a() {
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            AudioManager audioManager = this.g;
            if (audioManager != null && (bVar = this.h) != null) {
                audioManager.abandonAudioFocus(bVar);
                f21.g(M0("abandonAudioFocus()"));
                this.g = null;
                this.h = null;
            }
            this.i = false;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (I() == PlayerStatus.STOP) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            f0(0);
        }
    }

    @Nullable
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null && (viewGroup.getContext() instanceof Activity)) {
                return (Activity) this.e.getContext();
            }
            return null;
        }
        return (Activity) invokeV.objValue;
    }

    public void h0() {
        qz0 qz0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && (qz0Var = this.b) != null) {
            qz0Var.a0();
            this.b.v0();
            this.b.c0();
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            r11.c().g(this);
            this.d.release();
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

    @NonNull
    public Context m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return bu0.b();
        }
        return (Context) invokeV.objValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            f21.g(M0("resumeFromError()"));
            qz0 qz0Var = this.b;
            if (qz0Var != null) {
                qz0Var.w0();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.e;
        }
        return (ViewGroup) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ez0
    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            a();
            z().g();
            H().f(w());
        }
    }

    @Override // com.baidu.tieba.ez0
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            z().m();
        }
    }

    @Override // com.baidu.tieba.ez0
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            z().n();
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return 0;
            }
            return qz0Var.M();
        }
        return invokeV.intValue;
    }

    @NonNull
    public jw0 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.p;
        }
        return (jw0) invokeV.objValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return this.a.e;
            }
            return qz0Var.N();
        }
        return invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return this.a.e * 1000;
            }
            return qz0Var.O();
        }
        return invokeV.intValue;
    }

    @NonNull
    public final lw0 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.q;
        }
        return (lw0) invokeV.objValue;
    }

    @Nullable
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public LayerContainer v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.c;
        }
        return (LayerContainer) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.u;
        }
        return invokeV.intValue;
    }

    public d01 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.d;
        }
        return (d01) invokeV.objValue;
    }

    @NonNull
    public ov0 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.m;
        }
        return (ov0) invokeV.objValue;
    }

    public ow0 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.o;
        }
        return (ow0) invokeV.objValue;
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.w = z2;
        }
    }

    public void C0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.r = str;
        }
    }

    public void D0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            E0(str, true);
        }
    }

    public void F0(@Nullable qz0 qz0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, qz0Var) == null) && qz0Var != null) {
            e(qz0Var);
        }
    }

    public void b(@NonNull jz0 jz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, jz0Var) == null) {
            this.c.a(jz0Var);
        }
    }

    public void d(@NonNull d11 d11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, d11Var) == null) {
            this.f.a(d11Var);
        }
    }

    public void d0(int i) {
        Activity activity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048621, this, i) == null) && (activity = getActivity()) != null && !X()) {
            activity.runOnUiThread(new a(this, i));
        }
    }

    public void f(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, viewGroup) == null) {
            g(viewGroup, true);
        }
    }

    public LayerContainer i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, context)) == null) {
            return new LayerContainer(context);
        }
        return (LayerContainer) invokeL.objValue;
    }

    public void o0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            q().f(i * 1000, 3);
        }
    }

    @Override // com.baidu.tieba.ez0
    public void onBufferingUpdate(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            z().f(i);
        }
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i) == null) {
            q().f(i, 3);
        }
    }

    public void q0(@NonNull ww0 ww0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, ww0Var) == null) {
            this.d.d(ww0Var);
        }
    }

    public void r0(@Nullable String str) {
        qz0 qz0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048658, this, str) == null) && (qz0Var = this.b) != null) {
            qz0Var.i0(str);
        }
    }

    public void s0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z2) == null) {
            z = z2;
            w0(z2);
        }
    }

    public void u0(@Nullable yx0 yx0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, yx0Var) == null) {
            this.d.a(yx0Var);
        }
    }

    public void v0(boolean z2) {
        qz0 qz0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048666, this, z2) != null) || (qz0Var = this.b) == null) {
            return;
        }
        qz0Var.m0(z2);
    }

    public void x0(@Nullable String str) {
        qz0 qz0Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048670, this, str) == null) && (qz0Var = this.b) != null) {
            qz0Var.o0(str);
        }
    }

    public void y0(iv0 iv0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, iv0Var) == null) {
            y().s(iv0Var);
        }
    }

    public void B0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            f21.g(M0("setVideoScalingMode(" + i + SmallTailInfo.EMOTION_SUFFIX));
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return;
            }
            this.x = i;
            qz0Var.s0(i);
        }
    }

    public void c0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            f21.g(M0("mute(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return;
            }
            qz0Var.Z(z2);
        }
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, context) == null) {
            this.l = new ViewGroup.LayoutParams(-1, -1);
            this.a = new s01();
            O();
            this.f = new i11(this);
            LayerContainer i = i(context);
            this.c = i;
            i.d(this);
            this.c.setClickable(true);
            N();
        }
    }

    public void t0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048662, this, z2) == null) && z2 && this.b != null) {
            f21.g(M0("setHasReplaceUrl(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.b.x0(null);
        }
    }

    public void w0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            f21.g(M0("setMuteMode(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            this.s = z2;
            qz0 qz0Var = this.b;
            if (qz0Var != null) {
                qz0Var.Z(z2);
            }
            if (z2) {
                a();
            } else if (Y()) {
                k0();
            }
        }
    }

    public void z0(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048674, this, f) == null) {
            this.t = f;
            qz0 qz0Var = this.b;
            if (qz0Var != null) {
                qz0Var.q0(f);
                f21.g(M0("setSpeed(" + f + SmallTailInfo.EMOTION_SUFFIX));
            }
        }
    }

    public void E0(@NonNull String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z2) == null) {
            f21.g(M0("setVideoUrl = " + str));
            this.a.b = str;
            z().p(this.a.b, z2, B());
        }
    }

    public void H0(Context context, @Nullable qz0 qz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, context, qz0Var) == null) {
            J0();
            F0(qz0Var);
            G0(context);
            I0(context);
        }
    }

    public void c(@NonNull jz0 jz0Var, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048618, this, jz0Var, layoutParams) == null) {
            this.c.b(jz0Var, layoutParams);
        }
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

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            f21.g(M0("stop()"));
            if (this.b == null) {
                return;
            }
            a();
            q().i();
            t().g();
            H().j(w());
            lx0.a(getActivity(), false);
        }
    }

    @Nullable
    public qz0 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.b == null) {
                return null;
            }
            f21.g(M0("detachKernelLayer = " + System.identityHashCode(this.b)));
            qz0 qz0Var = this.b;
            this.c.f(qz0Var, true);
            qz0Var.l0(null);
            this.b = null;
            return qz0Var;
        }
        return (qz0) invokeV.objValue;
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            f21.g(M0("resume()"));
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

    public void e(@NonNull qz0 qz0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, qz0Var) == null) {
            k();
            f21.g(M0("attachKernelLayer(" + System.identityHashCode(qz0Var) + "), kernel = " + System.identityHashCode(qz0Var.U())));
            this.b = qz0Var;
            qz0Var.l0(this);
            this.c.c(qz0Var);
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            f21.g(M0("pause(" + i + SmallTailInfo.EMOTION_SUFFIX));
            if (this.b == null) {
                return;
            }
            a();
            q().d(i);
            t().d();
            H().g();
        }
    }

    public void j(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) && (this.c.getParent() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) this.c.getParent();
            viewGroup.removeView(this.c);
            f21.g(M0("detachFromContainer(" + z2 + "), parent = " + System.identityHashCode(viewGroup)));
            if (z2) {
                this.c.h();
                z().l();
            }
            this.e = null;
        }
    }

    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            f21.g(M0("release()"));
            H().j(w());
            k();
            h0();
            lx0.a(getActivity(), false);
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

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048636, this) != null) || this.i) {
            return;
        }
        if (this.g == null) {
            this.g = (AudioManager) m().getSystemService("audio");
        }
        if (this.g != null) {
            if (this.h == null) {
                this.h = new b(this, null);
            }
            boolean z2 = true;
            if (this.g.requestAudioFocus(this.h, 3, 2) != 1) {
                z2 = false;
            }
            this.i = z2;
            f21.g(M0("requestAudioFocus()"));
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            f21.g(M0("doPlay(), status = " + I()));
            if (this.b != null && !W()) {
                if (!X()) {
                    k0();
                }
                lx0.a(getActivity(), true);
                q().h();
                t().f();
                f21.g(M0("doPlay, url = " + L()));
                H().i();
            }
        }
    }

    public void n0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            f21.g(M0("resumePlayer(" + z2 + SmallTailInfo.EMOTION_SUFFIX));
            qz0 qz0Var = this.b;
            if (qz0Var == null) {
                return;
            }
            if (z2) {
                s01 s01Var = this.a;
                s01Var.d = 0;
                s01Var.e = 0;
                s01Var.f = 0;
            } else {
                this.a.d = qz0Var.Q();
                this.a.e = this.b.N();
                this.a.f = this.b.R();
            }
            if (W()) {
                l0();
            } else {
                K0();
            }
        }
    }

    @Override // com.baidu.tieba.ez0
    public boolean onError(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048647, this, i, i2, obj)) == null) {
            z().h(i, i2, obj);
            H().d(i, i2, obj);
            lx0.a(getActivity(), false);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.ez0
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

    @Override // com.baidu.tieba.ez0
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048649, this, i, i2, obj)) == null) {
            z().j(i, i2, obj);
            return true;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.tieba.ez0
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048652, this, i, i2, i3, i4) == null) {
            z().o(i, i2, i3, i4);
        }
    }
}
