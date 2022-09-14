package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class f3 extends b1 implements t2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public final float[] D;
    public final float[] E;
    public boolean F;
    public g1 G;
    public final i2 H;
    public final Input.Orientation I;
    public SensorEventListener J;
    public SensorEventListener K;
    public SensorEventListener L;
    public SensorEventListener M;
    public final ArrayList<View.OnGenericMotionListener> N;
    public final v2 O;
    public boolean P;
    public a8<d> f;
    public a8<f> g;
    public ArrayList<View.OnKeyListener> h;
    public ArrayList<d> i;
    public ArrayList<f> j;
    public int[] k;
    public int[] l;
    public int[] m;
    public int[] n;
    public boolean[] o;
    public int[] p;
    public int[] q;
    public float[] r;
    public boolean[] s;
    public SensorManager t;
    public boolean u;
    public final float[] v;
    public final float[] w;
    public final Application x;
    public final Context y;
    public final a3 z;

    /* loaded from: classes4.dex */
    public class a extends a8<d> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f3 f3Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f3Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8
        /* renamed from: g */
        public d d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new d() : (d) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a8<f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(f3 f3Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f3Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8
        /* renamed from: g */
        public f d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new f() : (f) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(249552545, "Lcom/baidu/tieba/f3$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(249552545, "Lcom/baidu/tieba/f3$c;");
                    return;
                }
            }
            int[] iArr = new int[Input.OnscreenKeyboardType.values().length];
            a = iArr;
            try {
                iArr[Input.OnscreenKeyboardType.NumberPad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Input.OnscreenKeyboardType.PhonePad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Input.OnscreenKeyboardType.Email.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Input.OnscreenKeyboardType.Password.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Input.OnscreenKeyboardType.URI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public int c;
        public char d;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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

    /* loaded from: classes4.dex */
    public class e implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f3 a;

        public e(f3 f3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f3Var;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent.sensor.getType() == 1) {
                    f3 f3Var = this.a;
                    if (f3Var.I == Input.Orientation.Portrait) {
                        float[] fArr = sensorEvent.values;
                        float[] fArr2 = f3Var.v;
                        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
                    } else {
                        float[] fArr3 = f3Var.v;
                        float[] fArr4 = sensorEvent.values;
                        fArr3[0] = fArr4[1];
                        fArr3[1] = -fArr4[0];
                        fArr3[2] = fArr4[2];
                    }
                }
                if (sensorEvent.sensor.getType() == 2) {
                    float[] fArr5 = sensorEvent.values;
                    float[] fArr6 = this.a.D;
                    System.arraycopy(fArr5, 0, fArr6, 0, fArr6.length);
                }
                if (sensorEvent.sensor.getType() == 4) {
                    f3 f3Var2 = this.a;
                    if (f3Var2.I == Input.Orientation.Portrait) {
                        float[] fArr7 = sensorEvent.values;
                        float[] fArr8 = f3Var2.w;
                        System.arraycopy(fArr7, 0, fArr8, 0, fArr8.length);
                    } else {
                        float[] fArr9 = f3Var2.w;
                        float[] fArr10 = sensorEvent.values;
                        fArr9[0] = fArr10[1];
                        fArr9[1] = -fArr10[0];
                        fArr9[2] = fArr10[2];
                    }
                }
                if (sensorEvent.sensor.getType() == 11) {
                    f3 f3Var3 = this.a;
                    if (f3Var3.I == Input.Orientation.Portrait) {
                        float[] fArr11 = sensorEvent.values;
                        float[] fArr12 = f3Var3.E;
                        System.arraycopy(fArr11, 0, fArr12, 0, fArr12.length);
                        return;
                    }
                    float[] fArr13 = f3Var3.E;
                    float[] fArr14 = sensorEvent.values;
                    fArr13[0] = fArr14[1];
                    fArr13[1] = -fArr14[0];
                    fArr13[2] = fArr14[2];
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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

    public f3(Application application, Context context, Object obj, i2 i2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {application, context, obj, i2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this, 16, 1000);
        this.g = new b(this, 16, 1000);
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = new int[20];
        this.l = new int[20];
        this.m = new int[20];
        this.n = new int[20];
        this.o = new boolean[20];
        this.p = new int[20];
        this.q = new int[20];
        this.r = new float[20];
        this.s = new boolean[20];
        int i3 = 0;
        this.u = false;
        this.v = new float[3];
        this.w = new float[3];
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = new float[3];
        this.E = new float[3];
        this.F = false;
        this.N = new ArrayList<>();
        this.P = true;
        if (obj instanceof View) {
            View view2 = (View) obj;
            view2.setOnKeyListener(this);
            view2.setOnTouchListener(this);
            view2.setFocusable(true);
            view2.setFocusableInTouchMode(true);
            view2.requestFocus();
            view2.setOnGenericMotionListener(this);
        }
        this.H = i2Var;
        this.O = new v2();
        while (true) {
            int[] iArr = this.q;
            if (i3 >= iArr.length) {
                break;
            }
            iArr[i3] = -1;
            i3++;
        }
        new Handler();
        this.x = application;
        this.y = context;
        this.A = i2Var.m;
        a3 a3Var = new a3();
        this.z = a3Var;
        a3Var.c(context);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        int e2 = e();
        Graphics.a f2 = this.x.getGraphics().f();
        if (((e2 != 0 && e2 != 180) || f2.a < f2.b) && ((e2 != 90 && e2 != 270) || f2.a > f2.b)) {
            this.I = Input.Orientation.Portrait;
        } else {
            this.I = Input.Orientation.Landscape;
        }
        b(255, true);
    }

    public static int c(Input.OnscreenKeyboardType onscreenKeyboardType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, onscreenKeyboardType)) == null) {
            int i = c.a[onscreenKeyboardType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return Cea708Decoder.COMMAND_SPA;
                            }
                            return 17;
                        }
                        return 129;
                    }
                    return 33;
                }
                return 3;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.t2
    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            g();
        }
    }

    @Override // com.baidu.tieba.t2
    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (this.F) {
                    this.F = false;
                    for (int i = 0; i < this.s.length; i++) {
                        this.s[i] = false;
                    }
                }
                if (this.e) {
                    this.e = false;
                    for (int i2 = 0; i2 < this.b.length; i2++) {
                        this.b[i2] = false;
                    }
                }
                if (this.G != null) {
                    g1 g1Var = this.G;
                    int size = this.i.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = this.i.get(i3);
                        long j = dVar.a;
                        int i4 = dVar.b;
                        if (i4 == 0) {
                            g1Var.g(dVar.c);
                            this.e = true;
                            this.b[dVar.c] = true;
                        } else if (i4 == 1) {
                            g1Var.f(dVar.c);
                        } else if (i4 == 2) {
                            g1Var.h(dVar.d);
                        }
                        this.f.c(dVar);
                    }
                    int size2 = this.j.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        f fVar = this.j.get(i5);
                        long j2 = fVar.a;
                        int i6 = fVar.b;
                        if (i6 == 0) {
                            g1Var.b(fVar.c, fVar.d, fVar.h, fVar.g);
                            this.F = true;
                            this.s[fVar.g] = true;
                        } else if (i6 == 1) {
                            g1Var.a(fVar.c, fVar.d, fVar.h, fVar.g);
                        } else if (i6 == 2) {
                            g1Var.d(fVar.c, fVar.d, fVar.h);
                        } else if (i6 == 3) {
                            g1Var.c(fVar.e, fVar.f);
                        } else if (i6 == 4) {
                            g1Var.e(fVar.c, fVar.d);
                        }
                        this.g.c(fVar);
                    }
                } else {
                    int size3 = this.j.size();
                    for (int i7 = 0; i7 < size3; i7++) {
                        f fVar2 = this.j.get(i7);
                        if (fVar2.b == 0) {
                            this.F = true;
                        }
                        this.g.c(fVar2);
                    }
                    int size4 = this.i.size();
                    for (int i8 = 0; i8 < size4; i8++) {
                        this.f.c(this.i.get(i8));
                    }
                }
                if (this.j.isEmpty()) {
                    for (int i9 = 0; i9 < this.m.length; i9++) {
                        this.m[0] = 0;
                        this.n[0] = 0;
                    }
                }
                this.i.clear();
                this.j.clear();
            }
        }
    }

    @Override // com.baidu.tieba.t2
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            k();
            Arrays.fill(this.q, -1);
            Arrays.fill(this.o, false);
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int length = this.q.length;
            for (int i = 0; i < length; i++) {
                if (this.q[i] == -1) {
                    return i;
                }
            }
            this.r = h(this.r);
            this.q = i(this.q);
            this.k = i(this.k);
            this.l = i(this.l);
            this.m = i(this.m);
            this.n = i(this.n);
            this.o = j(this.o);
            this.p = i(this.p);
            return length;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        int rotation;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Context context = this.y;
            if (context instanceof Activity) {
                rotation = ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
            } else {
                rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
            }
            if (rotation != 1) {
                if (rotation != 2) {
                    return rotation != 3 ? 0 : 270;
                }
                return 180;
            }
            return 90;
        }
        return invokeV.intValue;
    }

    public int f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            int length = this.q.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.q[i2] == i) {
                    return i2;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < length; i3++) {
                sb.append(i3 + ":" + this.q[i3] + " ");
            }
            Application application = f1.a;
            application.log("AndroidInput", "Pointer ID lookup failed: " + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + sb.toString());
            return -1;
        }
        return invokeI.intValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.H.h) {
                SensorManager sensorManager = (SensorManager) this.y.getSystemService("sensor");
                this.t = sensorManager;
                if (sensorManager.getSensorList(1).isEmpty()) {
                    this.u = false;
                } else {
                    e eVar = new e(this);
                    this.J = eVar;
                    this.u = this.t.registerListener(eVar, this.t.getSensorList(1).get(0), this.H.l);
                }
            } else {
                this.u = false;
            }
            if (this.H.i) {
                SensorManager sensorManager2 = (SensorManager) this.y.getSystemService("sensor");
                this.t = sensorManager2;
                if (!sensorManager2.getSensorList(4).isEmpty()) {
                    e eVar2 = new e(this);
                    this.K = eVar2;
                    this.t.registerListener(eVar2, this.t.getSensorList(4).get(0), this.H.l);
                }
            }
            this.C = false;
            if (this.H.k) {
                if (this.t == null) {
                    this.t = (SensorManager) this.y.getSystemService("sensor");
                }
                List<Sensor> sensorList = this.t.getSensorList(11);
                if (!sensorList.isEmpty()) {
                    this.M = new e(this);
                    Iterator<Sensor> it = sensorList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Sensor next = it.next();
                        if (next.getVendor().equals("Google Inc.") && next.getVersion() == 3) {
                            this.C = this.t.registerListener(this.M, next, this.H.l);
                            break;
                        }
                    }
                    if (!this.C) {
                        this.C = this.t.registerListener(this.M, sensorList.get(0), this.H.l);
                    }
                }
            }
            if (this.H.j && !this.C) {
                if (this.t == null) {
                    this.t = (SensorManager) this.y.getSystemService("sensor");
                }
                Sensor defaultSensor = this.t.getDefaultSensor(2);
                if (defaultSensor != null) {
                    boolean z = this.u;
                    this.B = z;
                    if (z) {
                        e eVar3 = new e(this);
                        this.L = eVar3;
                        this.B = this.t.registerListener(eVar3, defaultSensor, this.H.l);
                    }
                } else {
                    this.B = false;
                }
            } else {
                this.B = false;
            }
            f1.a.log("AndroidInput", "sensor listener setup");
        }
    }

    public final float[] h(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, fArr)) == null) {
            float[] fArr2 = new float[fArr.length + 2];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            return fArr2;
        }
        return (float[]) invokeL.objValue;
    }

    public final int[] i(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iArr)) == null) {
            int[] iArr2 = new int[iArr.length + 2];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            return iArr2;
        }
        return (int[]) invokeL.objValue;
    }

    public final boolean[] j(boolean[] zArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, zArr)) == null) {
            boolean[] zArr2 = new boolean[zArr.length + 2];
            System.arraycopy(zArr, 0, zArr2, 0, zArr.length);
            return zArr2;
        }
        return (boolean[]) invokeL.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            SensorManager sensorManager = this.t;
            if (sensorManager != null) {
                SensorEventListener sensorEventListener = this.J;
                if (sensorEventListener != null) {
                    sensorManager.unregisterListener(sensorEventListener);
                    this.J = null;
                }
                SensorEventListener sensorEventListener2 = this.K;
                if (sensorEventListener2 != null) {
                    this.t.unregisterListener(sensorEventListener2);
                    this.K = null;
                }
                SensorEventListener sensorEventListener3 = this.M;
                if (sensorEventListener3 != null) {
                    this.t.unregisterListener(sensorEventListener3);
                    this.M = null;
                }
                SensorEventListener sensorEventListener4 = this.L;
                if (sensorEventListener4 != null) {
                    this.t.unregisterListener(sensorEventListener4);
                    this.L = null;
                }
                this.t = null;
            }
            f1.a.log("AndroidInput", "sensor listener tear down");
        }
    }

    @Override // android.view.View.OnGenericMotionListener
    public boolean onGenericMotion(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, view2, motionEvent)) == null) {
            if (this.O.a(motionEvent, this)) {
                return true;
            }
            int size = this.N.size();
            for (int i = 0; i < size; i++) {
                if (this.N.get(i).onGenericMotion(view2, motionEvent)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view2, int i, KeyEvent keyEvent) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048588, this, view2, i, keyEvent)) == null) {
            int size = this.h.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.h.get(i2).onKey(view2, i, keyEvent)) {
                    return true;
                }
            }
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() > 0) {
                return a(i);
            }
            synchronized (this) {
                if (keyEvent.getKeyCode() == 0 && keyEvent.getAction() == 2) {
                    String characters = keyEvent.getCharacters();
                    for (int i3 = 0; i3 < characters.length(); i3++) {
                        d e2 = this.f.e();
                        e2.a = System.nanoTime();
                        e2.c = 0;
                        e2.d = characters.charAt(i3);
                        e2.b = 2;
                        this.i.add(e2);
                    }
                    return false;
                }
                char unicodeChar = (char) keyEvent.getUnicodeChar();
                if (i == 67) {
                    unicodeChar = '\b';
                }
                if (keyEvent.getKeyCode() >= 0 && keyEvent.getKeyCode() <= 255) {
                    int action = keyEvent.getAction();
                    if (action == 0) {
                        d e3 = this.f.e();
                        e3.a = System.nanoTime();
                        e3.d = (char) 0;
                        e3.c = keyEvent.getKeyCode();
                        e3.b = 0;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            e3.c = 255;
                            i = 255;
                        }
                        this.i.add(e3);
                        if (!this.a[e3.c]) {
                            this.d++;
                            this.a[e3.c] = true;
                        }
                    } else if (action == 1) {
                        long nanoTime = System.nanoTime();
                        d e4 = this.f.e();
                        e4.a = nanoTime;
                        e4.d = (char) 0;
                        e4.c = keyEvent.getKeyCode();
                        e4.b = 1;
                        if (i == 4 && keyEvent.isAltPressed()) {
                            e4.c = 255;
                            i = 255;
                        }
                        this.i.add(e4);
                        d e5 = this.f.e();
                        e5.a = nanoTime;
                        e5.d = unicodeChar;
                        e5.c = 0;
                        e5.b = 2;
                        this.i.add(e5);
                        if (i == 255) {
                            if (this.a[255]) {
                                this.d--;
                                this.a[255] = false;
                            }
                        } else if (this.a[keyEvent.getKeyCode()]) {
                            this.d--;
                            this.a[keyEvent.getKeyCode()] = false;
                        }
                    }
                    this.x.getGraphics().c();
                    return a(i);
                }
                return false;
            }
        }
        return invokeLIL.booleanValue;
    }

    @Override // com.baidu.tieba.t2
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            k();
            Arrays.fill(this.q, -1);
            Arrays.fill(this.o, false);
        }
    }

    @Override // com.baidu.tieba.t2
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            g();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view2, motionEvent)) == null) {
            if (this.P && view2 != null) {
                view2.setFocusableInTouchMode(true);
                view2.requestFocus();
                this.P = false;
            }
            this.z.a(motionEvent, this);
            int i = this.A;
            if (i != 0) {
                try {
                    Thread.sleep(i);
                } catch (InterruptedException unused) {
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.t2
    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }
}
