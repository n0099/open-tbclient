package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.sdk.container.filedownloader.MaterialLoadErrorCode;
import com.baidu.sdk.container.filedownloader.MaterialLoader;
import com.baidu.sdk.container.widget.AbsCountDownView;
import com.baidu.sdk.container.widget.AdView;
import com.baidu.sdk.container.widget.BDSplashActionView;
import com.baidu.sdk.container.widget.CircleTextProgressbar;
import com.baidu.sdk.container.widget.DisplayInfoView;
import com.baidu.sdk.container.widget.RectangleCountDownView;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
import com.baidu.tieba.bk1;
import com.baidu.tieba.c61;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.boxes.FreeSpaceBox;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class cm1 implements nm1, AdView.a, SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static final String i0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public int E;
    public int F;
    public String G;
    public String H;
    public boolean I;
    public int J;
    public JSONObject K;
    public boolean L;
    public boolean M;
    public boolean N;
    public SensorManager O;
    public boolean P;
    public boolean Q;
    public String R;
    public float S;

    /* renamed from: T  reason: collision with root package name */
    public int f1090T;
    public AtomicBoolean U;
    public float V;
    public LottieAnimationView W;
    public BDSplashActionView X;
    public long Y;
    public int Z;
    public Context a;
    public float a0;
    public int b;
    public int b0;
    public ImageView c;
    public float c0;
    public ImageView d;
    public int d0;
    public AbsCountDownView e;
    public boolean e0;
    public boolean f;
    public n f0;
    public boolean g;
    public final Handler g0;
    public zl1 h;
    public boolean h0;
    public JSONObject i;
    public JSONObject j;
    public AdView k;
    public wm1 l;
    public TextView m;
    public mm1 n;
    public om1 o;
    public int p;
    public String q;
    public String r;
    public int s;
    public String t;
    public boolean u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public boolean z;

    public abstract void B();

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048612, this, sensor, i2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements bk1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ cm1 c;

        /* renamed from: com.baidu.tieba.cm1$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC0270a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public View$OnClickListenerC0270a(a aVar) {
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

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.a.c.N();
                }
            }
        }

        public a(cm1 cm1Var, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cm1Var;
            this.a = i;
            this.b = i2;
        }

        @Override // com.baidu.tieba.bk1.f
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    try {
                        this.c.W.setVisibility(0);
                        this.c.W.setComposition(lottieComposition);
                        this.c.W.playAnimation();
                        this.c.o(this.c.W, this.a, this.b, "click_float_lottie", this.c.K);
                        this.c.W.setOnClickListener(new View$OnClickListenerC0270a(this));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable unused) {
                    this.c.i.put("displayMantle", true);
                    this.c.u();
                }
            }
        }

        @Override // com.baidu.tieba.bk1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                cm1 cm1Var = this.c;
                if (cm1Var.b != 2 && cm1Var.a != null) {
                    try {
                        cm1Var.i.put("displayMantle", true);
                        this.c.u();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements gm1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cm1 c;

        @Override // com.baidu.tieba.gm1
        public void onLoadingStarted(String str, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view2) == null) {
            }
        }

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    h hVar = this.a;
                    hVar.c.G(hVar.a, hVar.b);
                }
            }
        }

        public h(cm1 cm1Var, ImageView imageView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var, imageView, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cm1Var;
            this.a = imageView;
            this.b = str;
        }

        @Override // com.baidu.tieba.gm1
        public void a(String str, View view2, MaterialLoadErrorCode materialLoadErrorCode) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view2, materialLoadErrorCode) == null) {
                this.c.O("Fetch Ad icon image load failed.");
            }
        }

        @Override // com.baidu.tieba.gm1
        public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view2, bitmap) == null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    zk0.b(new a(this));
                } else {
                    this.c.G(this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements bk1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LottieAnimationView a;
        public final /* synthetic */ cm1 b;

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public float a;
            public float b;
            public final /* synthetic */ n c;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = nVar;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (motionEvent.getAction() == 0) {
                        this.a = motionEvent.getX();
                        this.b = motionEvent.getY();
                    } else if (motionEvent.getAction() == 2) {
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        float k = c61.c.k(this.c.b.a, x - this.a);
                        float k2 = c61.c.k(this.c.b.a, y - this.b);
                        cm1 cm1Var = this.c.b;
                        if ((cm1Var.f1090T & 1) == 1 && k2 <= (-cm1Var.S)) {
                            BaseVM.r("2");
                            this.c.b.N();
                        } else {
                            cm1 cm1Var2 = this.c.b;
                            if ((cm1Var2.f1090T & 2) == 2 && k2 >= cm1Var2.S) {
                                BaseVM.r("2");
                                this.c.b.N();
                            } else {
                                cm1 cm1Var3 = this.c.b;
                                if ((cm1Var3.f1090T & 4) == 4 && k <= (-cm1Var3.S)) {
                                    BaseVM.r("2");
                                    this.c.b.N();
                                } else {
                                    cm1 cm1Var4 = this.c.b;
                                    if ((cm1Var4.f1090T & 8) == 8 && k >= cm1Var4.S) {
                                        BaseVM.r("2");
                                        this.c.b.N();
                                    }
                                }
                            }
                        }
                    } else if (motionEvent.getAction() == 1) {
                        cm1 cm1Var5 = this.c.b;
                        if (cm1Var5.J == 0) {
                            cm1Var5.N();
                        }
                    }
                    return true;
                }
                return invokeLL.booleanValue;
            }
        }

        public n(cm1 cm1Var, LottieAnimationView lottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var, lottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cm1Var;
            this.a = lottieAnimationView;
        }

        @Override // com.baidu.tieba.bk1.f
        @SuppressLint({"ClickableViewAccessibility"})
        public void a(LottieComposition lottieComposition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lottieComposition) == null) {
                try {
                    this.a.setVisibility(0);
                    this.a.setComposition(lottieComposition);
                    this.a.playAnimation();
                    this.a.setRepeatCount(-1);
                    this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    if (this.a != null && (this.a.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.getParent()).removeView(this.a);
                    }
                    this.b.k.addView(this.a, layoutParams);
                    this.b.y();
                    if (!this.b.L) {
                        return;
                    }
                    this.a.setOnTouchListener(new a(this));
                } catch (Throwable unused) {
                    this.a.setVisibility(8);
                }
            }
        }

        @Override // com.baidu.tieba.bk1.f
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.b.L();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public b(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.N();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            }
        }

        public c(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public d(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.a0();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public e(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public f(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements DisplayInfoView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public g(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T();
            }
        }

        @Override // com.baidu.sdk.container.widget.DisplayInfoView.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.U();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public i(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.Q();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public j(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.a.f) {
                return;
            }
            this.a.f = true;
            this.a.Q();
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        public k(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X();
                this.a.V();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements AbsCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cm1 a;

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void onProgress(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public l(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cm1Var;
        }

        @Override // com.baidu.sdk.container.widget.AbsCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g) {
                this.a.A("time_end");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements LottieListener<Throwable> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
            }
        }

        public m(cm1 cm1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cm1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947679458, "Lcom/baidu/tieba/cm1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947679458, "Lcom/baidu/tieba/cm1;");
                return;
            }
        }
        i0 = cm1.class.getSimpleName();
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            w();
            u();
            m();
            D();
            s();
            r();
            C();
            t();
            p();
            x();
        }
    }

    public final int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.b0;
            if (i2 <= 0) {
                return 2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.Z;
            if (i2 <= 0) {
                return 67;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.P) {
            return;
        }
        mm1 mm1Var = this.n;
        if (mm1Var != null) {
            mm1Var.a();
        }
        a0();
        this.P = true;
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            om1 om1Var = this.o;
            if (om1Var != null) {
                om1Var.d();
            }
            this.Y = System.currentTimeMillis();
            BaseVM.q();
        }
    }

    public void Q() {
        mm1 mm1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (mm1Var = this.n) != null) {
            mm1Var.f();
        }
    }

    public void R() {
        om1 om1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (om1Var = this.o) != null) {
            om1Var.g();
        }
    }

    public void T() {
        mm1 mm1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (mm1Var = this.n) != null) {
            mm1Var.b();
        }
    }

    public void U() {
        mm1 mm1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (mm1Var = this.n) != null) {
            mm1Var.c();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            mm1 mm1Var = this.n;
            if (mm1Var != null) {
                mm1Var.e();
            }
            a0();
        }
    }

    public void X() {
        AbsCountDownView absCountDownView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (absCountDownView = this.e) != null) {
            absCountDownView.c();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            zk0.b(new e(this));
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.b = 2;
            zk0.b(new f(this));
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.c();
            }
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            SensorManager sensorManager = this.O;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
            this.g0.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.baidu.tieba.nm1
    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.k;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.nm1
    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.b = 1;
        }
    }

    @Override // com.baidu.sdk.container.widget.AdView.a
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            a0();
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            LottieAnimationView lottieAnimationView = this.W;
            if (lottieAnimationView != null) {
                lottieAnimationView.bringToFront();
            }
            BDSplashActionView bDSplashActionView = this.X;
            if (bDSplashActionView != null) {
                bDSplashActionView.bringToFront();
            }
            AbsCountDownView absCountDownView = this.e;
            if (absCountDownView != null) {
                absCountDownView.bringToFront();
            }
        }
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            int I = I();
            if (I >= 0 && I < 67) {
                return 1;
            }
            if ((I >= 67 && I < 200) || I < 200) {
                return 2;
            }
            return 3;
        }
        return invokeV.intValue;
    }

    public cm1(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = null;
        this.d = null;
        this.f = false;
        this.p = 4;
        this.q = "";
        this.r = "image";
        this.s = 5000;
        this.t = "";
        this.x = true;
        this.y = false;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.F = 16;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.U = new AtomicBoolean(false);
        this.c0 = 1.0f;
        this.g0 = new Handler(Looper.getMainLooper());
        this.h0 = false;
        this.a = context.getApplicationContext();
        this.i = jSONObject;
        AdView adView = new AdView(this.a);
        this.k = adView;
        adView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.k.setListener(this);
        this.h = new zl1(this.a);
        this.l = new wm1(this.a);
        W();
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            S(str);
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            AdImageView adImageView = new AdImageView(this.a);
            MaterialLoader.k(this.a).q(adImageView, str, new h(this, adImageView, str));
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            om1 om1Var = this.o;
            if (om1Var != null) {
                om1Var.onAdError(str);
            }
            a0();
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || this.h0) {
            return;
        }
        om1 om1Var = this.o;
        if (om1Var != null) {
            om1Var.h(str);
        }
        a0();
        this.h0 = true;
    }

    @Override // com.baidu.tieba.nm1
    public void a(om1 om1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, om1Var) == null) {
            this.o = om1Var;
        }
    }

    @Override // com.baidu.tieba.nm1
    public void c(mm1 mm1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, mm1Var) == null) {
            this.n = mm1Var;
        }
    }

    public void l(View view2, RelativeLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, view2, layoutParams) == null) {
            if (this.C) {
                this.k.addView(view2, layoutParams);
                return;
            }
            q();
            layoutParams.addRule(2, 15);
            this.k.addView(view2, layoutParams);
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && ym1.b && this.a != null) {
            TextView textView = new TextView(this.a);
            textView.setTextColor(BaseAnimatedElement.DEBUG_PAINT_COLOR);
            textView.setTextSize(15.0f);
            textView.setText("P : " + ym1.a);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = 10;
            layoutParams.addRule(13);
            this.k.addView(textView, layoutParams);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.e0) {
            return;
        }
        try {
            this.e0 = true;
            String str = "";
            str = (this.M || this.N) ? "shake_lottie.zip" : "shake_lottie.zip";
            if (this.L) {
                str = "slide_lottie.zip";
            }
            if (!TextUtils.isEmpty(str) && this.f0 != null) {
                bk1.d().b(this.a.getAssets().open(str), this.f0);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && this.z && !this.u && !TextUtils.isEmpty(this.w) && !TextUtils.isEmpty(this.v)) {
            RelativeLayout relativeLayout = new RelativeLayout(this.a);
            DisplayInfoView.c cVar = new DisplayInfoView.c(this.a);
            cVar.a(this.w, this.v);
            cVar.c(-10066330);
            cVar.b(new g(this));
            DisplayInfoView d2 = cVar.d();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            d2.setGravity(17);
            relativeLayout.addView(d2, layoutParams);
            n(relativeLayout, -1, -2, "download_desc");
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || !this.D) {
            return;
        }
        String optString = this.i.optString("host_small_logo_res_id");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        int optInt = this.i.optInt("small_logo_width", -2);
        int optInt2 = this.i.optInt("small_logo_height", -2);
        try {
            AdImageView adImageView = new AdImageView(this.a);
            adImageView.setImageResource(Integer.parseInt(optString));
            adImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            n(adImageView, c61.c.a(this.a, optInt), c61.c.a(this.a, optInt2), "logo");
        } catch (Throwable unused) {
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.i.optBoolean("displayMantle", false)) {
            String optString = this.i.optString("mantleActionText");
            int optInt = this.i.optInt("mantleBottomMargin");
            BDSplashActionView.a aVar = new BDSplashActionView.a();
            aVar.l(optString);
            aVar.m(optInt);
            aVar.o(this.C);
            aVar.n(new b(this));
            BDSplashActionView k2 = aVar.k(this.a);
            this.X = k2;
            k2.a(this.k);
        }
    }

    public void x() {
        Sensor defaultSensor;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (!this.M && !this.N) {
                return;
            }
            if (this.O == null) {
                try {
                    this.O = (SensorManager) this.a.getSystemService("sensor");
                } catch (Exception unused) {
                    return;
                }
            }
            SensorManager sensorManager = this.O;
            if (sensorManager != null && (defaultSensor = sensorManager.getDefaultSensor(1)) != null) {
                this.O.registerListener(this, defaultSensor, z());
            }
            this.g0.postDelayed(new d(this), 5000L);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.x) {
            v();
            this.e.setTimeMillis(this.s);
            this.e.b();
            int i2 = this.p;
            if (i2 == 5) {
                this.e.setVisibility(0);
            } else if (i2 == 1) {
                this.e.setVisibility(0);
            }
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || !this.Q) {
            return;
        }
        LottieAnimationView lottieAnimationView = new LottieAnimationView(this.a);
        lottieAnimationView.setFailureListener(new c(this));
        this.f0 = new n(this, lottieAnimationView);
        bk1.d().c(this.R, this.f0);
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || !this.A) {
            return;
        }
        String optString = this.i.optString("ad_label");
        if (!TextUtils.isEmpty(optString)) {
            k(optString);
        } else {
            M("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png");
        }
        if (this.B) {
            M("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png");
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && this.y) {
            TextView textView = new TextView(this.a);
            this.m = textView;
            textView.setText("已于Wi-Fi环境预加载");
            this.m.setTextColor(Color.parseColor("#999999"));
            this.m.setTextSize(0, c61.c.a(this.a, 11.0f));
            n(this.m, -2, -2, "wifi_tip");
        }
    }

    public final void G(ImageView imageView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, imageView, str) == null) && this.k != null && this.a != null) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setId(16972527);
            if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png")) {
                imageView.setTag("BAIDU_LOGO");
                n(imageView, c61.c.a(this.a, 13.0f), c61.c.a(this.a, 13.0f), "bd_logo");
            } else if (str.equals("https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png")) {
                imageView.setTag("AD_LOGO");
                n(imageView, c61.c.a(this.a, 25.0f), c61.c.a(this.a, 13.0f), "ad_logo");
            }
            this.c = (ImageView) this.k.findViewWithTag("BAIDU_LOGO");
            ImageView imageView2 = (ImageView) this.k.findViewWithTag("AD_LOGO");
            this.d = imageView2;
            this.f = false;
            if (this.c != null && imageView2 != null) {
                imageView2.setOnClickListener(new i(this));
                this.c.setOnClickListener(new j(this));
            }
        }
    }

    public final void J(@NonNull SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sensorEvent) == null) {
            float f2 = sensorEvent.values[1];
            if (this.U.compareAndSet(false, true)) {
                this.V = f2;
            }
            if (Math.abs(f2 - this.V) * 9.0f > this.S) {
                if (vh0.a) {
                    g51.a().showToast(this.k.getContext(), "摇一摇1.0");
                }
                BaseVM.r("1");
                N();
            }
        }
    }

    public final void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            int optInt = this.i.optInt("ad_label_width", 25);
            int optInt2 = this.i.optInt("ad_label_height", 13);
            TextView textView = new TextView(this.a);
            textView.setText(str);
            textView.setBackgroundColor(Color.parseColor("#33000000"));
            textView.setTextSize(10.0f);
            textView.setIncludeFontPadding(false);
            textView.setTextColor(-1);
            textView.setGravity(17);
            n(textView, c61.c.a(this.a, optInt), c61.c.a(this.a, optInt2), "label");
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, sensorEvent) == null) && sensorEvent != null && sensorEvent.values != null) {
            if (this.N) {
                if (this.Y > 0) {
                    float f2 = this.a0;
                    if (f2 > 0.0f && f2 < 5.0f && ((float) (System.currentTimeMillis() - this.Y)) < this.a0 * 1000.0f) {
                        return;
                    }
                }
                K(sensorEvent);
                return;
            }
            J(sensorEvent);
        }
    }

    public final void K(@NonNull SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, sensorEvent) == null) {
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            if (Math.pow(f2, 2.0d) + Math.pow(fArr[1], 2.0d) + Math.pow(fArr[2], 2.0d) < Math.pow(this.S, 2.0d)) {
                return;
            }
            if (this.c0 * f2 >= 0.0f) {
                this.c0 = f2;
                return;
            }
            this.c0 = f2;
            int i2 = this.d0 + 1;
            this.d0 = i2;
            if (i2 >= H()) {
                if (vh0.a) {
                    f51 a2 = g51.a();
                    Context context = this.k.getContext();
                    a2.showToast(context, "摇一摇 *3.0* 灵敏度配置：" + this.S + "_" + this.Z + "_" + this.b0 + "-" + this.a0);
                }
                BaseVM.r("7");
                N();
            }
        }
    }

    public void W() {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            try {
                this.q = this.i.optString("prod");
                this.t = this.i.optString("material_url");
                this.j = this.i.optJSONObject("style");
                this.K = this.i.optJSONObject("inner_style");
                this.g = this.i.optBoolean("countDownNew", true);
                this.z = this.i.optBoolean("Display_Down_Info");
                boolean z4 = false;
                this.u = this.i.optBoolean("popDialogIfDl", false);
                this.v = this.i.optString("publisher");
                this.w = this.i.optString("app_version");
                this.y = this.i.optBoolean("show_wifi_view", "video".equals(this.r));
                this.x = this.i.optBoolean("show_skip", "rsplash".equals(this.q));
                this.s = this.i.optInt("skipTime", 5000);
                this.A = this.i.optBoolean("hide_ad_logo", true);
                this.B = this.i.optBoolean("hide_bd_logo", false);
                this.C = this.i.optBoolean("full_screen", true);
                this.D = this.i.optBoolean("show_host_small_logo", false);
                this.E = this.i.optInt("skip_btn_type");
                this.p = this.i.optInt("close_type");
                this.F = this.i.optInt("bitmapDisplayMode");
                this.G = this.i.optString("host_big_logo_res_id");
                this.R = this.i.optString("gesture_lottie_url");
                if (this.i.optInt("gesture_lottie_type") == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.M = z;
                if (this.i.optInt("gesture_lottie_type") == 7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.N = z2;
                this.Z = this.i.optInt("shake_update_interval", 0);
                this.b0 = this.i.optInt("shake_direction_count", 0);
                this.a0 = (float) this.i.optDouble("shake_action_delay_time", -1.0d);
                if (this.i.optInt("gesture_lottie_type") == 2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.L = z3;
                if (this.M || this.N || (z3 && !TextUtils.isEmpty(this.R))) {
                    z4 = true;
                }
                this.Q = z4;
                this.S = (float) this.i.optDouble("gesture_lottie_sensitivity", 0.0d);
                this.f1090T = this.i.optInt("gesture_lottie_direction", 1);
            } catch (Exception unused) {
            }
        }
    }

    public void n(View view2, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            o(view2, i2, i3, str, this.j);
        }
    }

    public void o(View view2, int i2, int i3, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{view2, Integer.valueOf(i2), Integer.valueOf(i3), str, jSONObject}) == null) && this.k != null && view2 != null && view2.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i2, i3);
            this.l.g(layoutParams, new xm1().b(jSONObject, str, this.C));
            this.k.addView(view2, layoutParams);
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && !TextUtils.isEmpty(this.G)) {
            int optInt = this.i.optInt("bottom_logo_height", xm1.a);
            if (optInt != xm1.a) {
                xm1.a = optInt;
            }
            try {
                RelativeLayout relativeLayout = new RelativeLayout(this.a);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, c61.c.a(this.a, optInt));
                layoutParams.addRule(12);
                relativeLayout.setId(15);
                AdImageView adImageView = new AdImageView(this.a);
                adImageView.setImageResource(Integer.parseInt(this.G));
                adImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                relativeLayout.setClickable(true);
                relativeLayout.addView(adImageView, layoutParams2);
                this.k.addView(relativeLayout, layoutParams);
            } catch (Throwable unused) {
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.H = this.i.optString("lottie_url");
            this.I = this.i.optBoolean("lottie_show");
            int optInt = this.i.optInt("ad_click_opt");
            this.J = optInt;
            if (optInt == 1) {
                B();
            }
            if (!TextUtils.isEmpty(this.H) && this.I) {
                LottieAnimationView lottieAnimationView = new LottieAnimationView(this.a);
                this.W = lottieAnimationView;
                lottieAnimationView.setFailureListener(new m(this));
                JSONObject optJSONObject = this.K.optJSONObject("click_float_lottie");
                double d2 = 0.69d;
                if (optJSONObject != null) {
                    d2 = optJSONObject.optDouble("floatW_screenW_ratio", 0.69d);
                }
                double d3 = 0.419d;
                if (optJSONObject != null) {
                    d3 = optJSONObject.optDouble("floatH_floatW_ratio", 0.419d);
                }
                int e2 = (int) (c61.c.e(this.a) * d2);
                bk1.d().c(this.H, new a(this, e2, (int) (e2 * d3)));
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            try {
                if (this.E == 1) {
                    this.e = new RectangleCountDownView(this.a);
                } else {
                    this.e = new CircleTextProgressbar(this.a);
                }
                this.e.setVisibility(4);
                this.e.setOnClickListener(new k(this));
                this.e.setCountdownProgressListener(new l(this));
                n(this.e, c61.c.a(this.a, this.i.optInt("skip_btn_width", 40)), c61.c.a(this.a, this.i.optInt("skip_btn_height", 40)), FreeSpaceBox.TYPE);
            } catch (Exception unused) {
            }
        }
    }
}
