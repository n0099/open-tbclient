package com.baidu.tieba;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;
/* loaded from: classes4.dex */
public class if9 {
    public static /* synthetic */ Interceptable $ic;
    public static HashSet<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public Canvas a;
    public float b;
    public SVG c;
    public h d;
    public Stack<h> e;
    public Stack<SVG.h0> f;
    public Stack<Matrix> g;
    public CSSParser.m h;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-720252368, "Lcom/baidu/tieba/if9$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-720252368, "Lcom/baidu/tieba/if9$a;");
                    return;
                }
            }
            int[] iArr = new int[SVG.Style.LineJoin.values().length];
            c = iArr;
            try {
                iArr[SVG.Style.LineJoin.Miter.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[SVG.Style.LineJoin.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[SVG.Style.LineCap.values().length];
            b = iArr2;
            try {
                iArr2[SVG.Style.LineCap.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[SVG.Style.LineCap.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[SVG.Style.LineCap.Square.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[PreserveAspectRatio.Alignment.values().length];
            a = iArr3;
            try {
                iArr3[PreserveAspectRatio.Alignment.xMidYMin.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMidYMid.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMidYMax.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMin.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMid.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMaxYMax.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMinYMid.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[PreserveAspectRatio.Alignment.xMinYMax.ordinal()] = 8;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<c> a;
        public float b;
        public float c;
        public c d;
        public boolean e;
        public boolean f;
        public int g;
        public boolean h;
        public final /* synthetic */ if9 i;

        public b(if9 if9Var, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = if9Var;
            this.a = new ArrayList();
            this.d = null;
            this.e = false;
            this.f = true;
            this.g = -1;
            if (vVar == null) {
                return;
            }
            vVar.h(this);
            if (this.h) {
                this.d.b(this.a.get(this.g));
                this.a.set(this.g, this.d);
                this.h = false;
            }
            c cVar = this.d;
            if (cVar != null) {
                this.a.add(cVar);
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                if (this.h) {
                    this.d.b(this.a.get(this.g));
                    this.a.set(this.g, this.d);
                    this.h = false;
                }
                c cVar = this.d;
                if (cVar != null) {
                    this.a.add(cVar);
                }
                this.b = f;
                this.c = f2;
                this.d = new c(this.i, f, f2, 0.0f, 0.0f);
                this.g = this.a.size();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.d.a(f, f2);
                this.a.add(this.d);
                if9 if9Var = this.i;
                c cVar = this.d;
                this.d = new c(if9Var, f, f2, f - cVar.a, f2 - cVar.b);
                this.h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                this.d.a(f, f2);
                this.a.add(this.d);
                this.d = new c(this.i, f3, f4, f3 - f, f4 - f2);
                this.h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.add(this.d);
                b(this.b, this.c);
                this.h = true;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                if (this.f || this.e) {
                    this.d.a(f, f2);
                    this.a.add(this.d);
                    this.e = false;
                }
                this.d = new c(this.i, f5, f6, f5 - f3, f6 - f4);
                this.h = false;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                this.e = true;
                this.f = false;
                c cVar = this.d;
                if9.m(cVar.a, cVar.b, f, f2, f3, z, z2, f4, f5, this);
                this.f = true;
                this.h = false;
            }
        }

        public List<c> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (List) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;
        public float d;
        public boolean e;

        public c(if9 if9Var, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = 0.0f;
            this.d = 0.0f;
            this.e = false;
            this.a = f;
            this.b = f2;
            double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
            if (sqrt != 0.0d) {
                this.c = (float) (f3 / sqrt);
                this.d = (float) (f4 / sqrt);
            }
        }

        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                float f3 = f - this.a;
                float f4 = f2 - this.b;
                double sqrt = Math.sqrt((f3 * f3) + (f4 * f4));
                if (sqrt != 0.0d) {
                    f3 = (float) (f3 / sqrt);
                    f4 = (float) (f4 / sqrt);
                }
                if (f3 == (-this.c) && f4 == (-this.d)) {
                    this.e = true;
                    this.c = -f4;
                    this.d = f3;
                    return;
                }
                this.c += f3;
                this.d += f4;
            }
        }

        public void b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                if (cVar.c == (-this.c)) {
                    float f = cVar.d;
                    if (f == (-this.d)) {
                        this.e = true;
                        this.c = -f;
                        this.d = cVar.c;
                        return;
                    }
                }
                this.c += cVar.c;
                this.d += cVar.d;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return "(" + this.a + "," + this.b + " " + this.c + "," + this.d + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements SVG.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Path a;
        public float b;
        public float c;

        public d(if9 if9Var, SVG.v vVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, vVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Path();
            if (vVar == null) {
                return;
            }
            vVar.h(this);
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void a(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.moveTo(f, f2);
                this.b = f;
                this.c = f2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void b(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.a.lineTo(f, f2);
                this.b = f;
                this.c = f2;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void c(float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                this.a.quadTo(f, f2, f3, f4);
                this.b = f3;
                this.c = f4;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void close() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.a.close();
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void d(float f, float f2, float f3, float f4, float f5, float f6) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)}) == null) {
                this.a.cubicTo(f, f2, f3, f4, f5, f6);
                this.b = f5;
                this.c = f6;
            }
        }

        @Override // com.caverock.androidsvg.SVG.w
        public void e(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
                if9.m(this.b, this.c, f, f2, f3, z, z2, f4, f5, this);
                this.b = f4;
                this.c = f5;
            }
        }

        public Path f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (Path) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Path d;
        public final /* synthetic */ if9 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(if9 if9Var, Path path, float f, float f2) {
            super(if9Var, f, f2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, path, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((if9) objArr2[0], ((Float) objArr2[1]).floatValue(), ((Float) objArr2[2]).floatValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = if9Var;
            this.d = path;
        }

        @Override // com.baidu.tieba.if9.f, com.baidu.tieba.if9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.e.g1()) {
                    if (this.e.d.b) {
                        this.e.a.drawTextOnPath(str, this.d, this.a, this.b, this.e.d.d);
                    }
                    if (this.e.d.c) {
                        this.e.a.drawTextOnPath(str, this.d, this.a, this.b, this.e.d.e);
                    }
                }
                this.a += this.e.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public final /* synthetic */ if9 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(if9 if9Var, float f, float f2) {
            super(if9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((if9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = if9Var;
            this.a = f;
            this.b = f2;
        }

        @Override // com.baidu.tieba.if9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if9.G("TextSequence render", new Object[0]);
                if (this.c.g1()) {
                    if (this.c.d.b) {
                        this.c.a.drawText(str, this.a, this.b, this.c.d.d);
                    }
                    if (this.c.d.c) {
                        this.c.a.drawText(str, this.a, this.b, this.c.d.e);
                    }
                }
                this.a += this.c.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public Path c;
        public final /* synthetic */ if9 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(if9 if9Var, float f, float f2, Path path) {
            super(if9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, Float.valueOf(f), Float.valueOf(f2), path};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((if9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = if9Var;
            this.a = f;
            this.b = f2;
            this.c = path;
        }

        @Override // com.baidu.tieba.if9.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (w0Var instanceof SVG.x0) {
                    if9.h1("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.if9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.d.g1()) {
                    Path path = new Path();
                    this.d.d.d.getTextPath(str, 0, str.length(), this.a, this.b, path);
                    this.c.addPath(path);
                }
                this.a += this.d.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public RectF c;
        public final /* synthetic */ if9 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(if9 if9Var, float f, float f2) {
            super(if9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((if9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = if9Var;
            this.c = new RectF();
            this.a = f;
            this.b = f2;
        }

        @Override // com.baidu.tieba.if9.j
        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                if (w0Var instanceof SVG.x0) {
                    SVG.x0 x0Var = (SVG.x0) w0Var;
                    SVG.l0 p = w0Var.a.p(x0Var.n);
                    if (p == null) {
                        if9.N("TextPath path reference '%s' not found", x0Var.n);
                        return false;
                    }
                    SVG.u uVar = (SVG.u) p;
                    Path f = new d(this.d, uVar.o).f();
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        f.transform(matrix);
                    }
                    RectF rectF = new RectF();
                    f.computeBounds(rectF, true);
                    this.c.union(rectF);
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.if9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.d.g1()) {
                    Rect rect = new Rect();
                    this.d.d.d.getTextBounds(str, 0, str.length(), rect);
                    RectF rectF = new RectF(rect);
                    rectF.offset(this.a, this.b);
                    this.c.union(rectF);
                }
                this.a += this.d.d.d.measureText(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public abstract class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j(if9 if9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public boolean a(SVG.w0 w0Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, w0Var)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public abstract void b(String str);

        public /* synthetic */ j(if9 if9Var, a aVar) {
            this(if9Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947851725, "Lcom/baidu/tieba/if9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947851725, "Lcom/baidu/tieba/if9;");
        }
    }

    public if9(Canvas canvas, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {canvas, Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = null;
        this.a = canvas;
        this.b = f2;
    }

    public static double B(double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (d2 < -1.0d) {
                return 3.141592653589793d;
            }
            if (d2 > 1.0d) {
                return 0.0d;
            }
            return Math.acos(d2);
        }
        return invokeCommon.doubleValue;
    }

    public static int C(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f2)) == null) {
            int i2 = (int) (f2 * 256.0f);
            if (i2 < 0) {
                return 0;
            }
            if (i2 > 255) {
                return 255;
            }
            return i2;
        }
        return invokeF.intValue;
    }

    public static int F(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int i3 = 255;
            int round = Math.round(((i2 >> 24) & 255) * f2);
            if (round < 0) {
                i3 = 0;
            } else if (round <= 255) {
                i3 = round;
            }
            return (i2 & 16777215) | (i3 << 24);
        }
        return invokeCommon.intValue;
    }

    public static void G(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, objArr) == null) {
        }
    }

    public static void N(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, objArr) == null) {
            Log.e("SVGAndroidRenderer", String.format(str, objArr));
        }
    }

    public static synchronized void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            synchronized (if9.class) {
                HashSet<String> hashSet = new HashSet<>();
                i = hashSet;
                hashSet.add("Structure");
                i.add("BasicStructure");
                i.add("ConditionalProcessing");
                i.add("Image");
                i.add("Style");
                i.add("ViewportAttribute");
                i.add("Shape");
                i.add("BasicText");
                i.add("PaintAttribute");
                i.add("BasicPaintAttribute");
                i.add("OpacityAttribute");
                i.add("BasicGraphicsAttribute");
                i.add("Marker");
                i.add("Gradient");
                i.add("Pattern");
                i.add("Clip");
                i.add("BasicClip");
                i.add("Mask");
                i.add("View");
            }
        }
    }

    public static void h1(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, objArr) == null) {
            Log.w("SVGAndroidRenderer", String.format(str, objArr));
        }
    }

    public static void m(float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, float f7, float f8, SVG.w wVar) {
        float f9;
        SVG.w wVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f7), Float.valueOf(f8), wVar}) == null) {
            if (f2 == f7 && f3 == f8) {
                return;
            }
            if (f4 == 0.0f) {
                f9 = f7;
                wVar2 = wVar;
            } else if (f5 != 0.0f) {
                float abs = Math.abs(f4);
                float abs2 = Math.abs(f5);
                double radians = Math.toRadians(f6 % 360.0d);
                double cos = Math.cos(radians);
                double sin = Math.sin(radians);
                double d2 = (f2 - f7) / 2.0d;
                double d3 = (f3 - f8) / 2.0d;
                double d4 = (cos * d2) + (sin * d3);
                double d5 = ((-sin) * d2) + (d3 * cos);
                double d6 = abs * abs;
                double d7 = abs2 * abs2;
                double d8 = d4 * d4;
                double d9 = d5 * d5;
                double d10 = (d8 / d6) + (d9 / d7);
                if (d10 > 0.99999d) {
                    double sqrt = Math.sqrt(d10) * 1.00001d;
                    abs = (float) (abs * sqrt);
                    abs2 = (float) (sqrt * abs2);
                    d6 = abs * abs;
                    d7 = abs2 * abs2;
                }
                double d11 = z == z2 ? -1.0d : 1.0d;
                double d12 = d6 * d7;
                double d13 = d6 * d9;
                double d14 = d7 * d8;
                double d15 = ((d12 - d13) - d14) / (d13 + d14);
                if (d15 < 0.0d) {
                    d15 = 0.0d;
                }
                double sqrt2 = d11 * Math.sqrt(d15);
                double d16 = abs;
                double d17 = abs2;
                double d18 = ((d16 * d5) / d17) * sqrt2;
                float f10 = abs;
                float f11 = abs2;
                double d19 = sqrt2 * (-((d17 * d4) / d16));
                double d20 = ((f2 + f7) / 2.0d) + ((cos * d18) - (sin * d19));
                double d21 = ((f3 + f8) / 2.0d) + (sin * d18) + (cos * d19);
                double d22 = (d4 - d18) / d16;
                double d23 = (d5 - d19) / d17;
                double d24 = ((-d4) - d18) / d16;
                double d25 = ((-d5) - d19) / d17;
                double d26 = (d22 * d22) + (d23 * d23);
                double acos = (d23 < 0.0d ? -1.0d : 1.0d) * Math.acos(d22 / Math.sqrt(d26));
                double B = ((d22 * d25) - (d23 * d24) >= 0.0d ? 1.0d : -1.0d) * B(((d22 * d24) + (d23 * d25)) / Math.sqrt(d26 * ((d24 * d24) + (d25 * d25))));
                if (!z2 && B > 0.0d) {
                    B -= 6.283185307179586d;
                } else if (z2 && B < 0.0d) {
                    B += 6.283185307179586d;
                }
                float[] n = n(acos % 6.283185307179586d, B % 6.283185307179586d);
                Matrix matrix = new Matrix();
                matrix.postScale(f10, f11);
                matrix.postRotate(f6);
                matrix.postTranslate((float) d20, (float) d21);
                matrix.mapPoints(n);
                n[n.length - 2] = f7;
                n[n.length - 1] = f8;
                for (int i2 = 0; i2 < n.length; i2 += 6) {
                    wVar.d(n[i2], n[i2 + 1], n[i2 + 2], n[i2 + 3], n[i2 + 4], n[i2 + 5]);
                }
                return;
            } else {
                wVar2 = wVar;
                f9 = f7;
            }
            wVar2.b(f9, f8);
        }
    }

    public static float[] n(double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Double.valueOf(d2), Double.valueOf(d3)})) == null) {
            int ceil = (int) Math.ceil((Math.abs(d3) * 2.0d) / 3.141592653589793d);
            double d4 = d3 / ceil;
            double d5 = d4 / 2.0d;
            double sin = (Math.sin(d5) * 1.3333333333333333d) / (Math.cos(d5) + 1.0d);
            float[] fArr = new float[ceil * 6];
            int i2 = 0;
            int i3 = 0;
            while (i2 < ceil) {
                double d6 = d2 + (i2 * d4);
                double cos = Math.cos(d6);
                double sin2 = Math.sin(d6);
                int i4 = i3 + 1;
                double d7 = d4;
                fArr[i3] = (float) (cos - (sin * sin2));
                int i5 = i4 + 1;
                fArr[i4] = (float) (sin2 + (cos * sin));
                double d8 = d6 + d7;
                double cos2 = Math.cos(d8);
                double sin3 = Math.sin(d8);
                int i6 = i5 + 1;
                fArr[i5] = (float) ((sin * sin3) + cos2);
                int i7 = i6 + 1;
                fArr[i6] = (float) (sin3 - (sin * cos2));
                int i8 = i7 + 1;
                fArr[i7] = (float) cos2;
                i3 = i8 + 1;
                fArr[i8] = (float) sin3;
                i2++;
                d4 = d7;
            }
            return fArr;
        }
        return (float[]) invokeCommon.objValue;
    }

    public final void A(SVG.l0 l0Var) {
        Boolean bool;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, l0Var) == null) && (l0Var instanceof SVG.j0) && (bool = ((SVG.j0) l0Var).d) != null) {
            this.d.h = bool.booleanValue();
        }
    }

    public final void A0(SVG.p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pVar) == null) {
            G("Line render", new Object[0]);
            e1(this.d, pVar);
            if (I() && g1() && this.d.c) {
                Matrix matrix = pVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path i0 = i0(pVar);
                c1(pVar);
                x(pVar);
                u(pVar);
                boolean u0 = u0();
                K(i0);
                Q0(pVar);
                if (u0) {
                    r0(pVar);
                }
            }
        }
    }

    public final void B0(SVG.u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uVar) == null) {
            G("Path render", new Object[0]);
            if (uVar.o == null) {
                return;
            }
            e1(this.d, uVar);
            if (I() && g1()) {
                h hVar = this.d;
                if (hVar.c || hVar.b) {
                    Matrix matrix = uVar.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    Path f2 = new d(this, uVar.o).f();
                    if (uVar.h == null) {
                        uVar.h = r(f2);
                    }
                    c1(uVar);
                    x(uVar);
                    u(uVar);
                    boolean u0 = u0();
                    if (this.d.b) {
                        f2.setFillType(c0());
                        J(uVar, f2);
                    }
                    if (this.d.c) {
                        K(f2);
                    }
                    Q0(uVar);
                    if (u0) {
                        r0(uVar);
                    }
                }
            }
        }
    }

    public final void C0(SVG.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yVar) == null) {
            G("PolyLine render", new Object[0]);
            e1(this.d, yVar);
            if (I() && g1()) {
                h hVar = this.d;
                if (hVar.c || hVar.b) {
                    Matrix matrix = yVar.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    if (yVar.o.length < 2) {
                        return;
                    }
                    Path j0 = j0(yVar);
                    c1(yVar);
                    j0.setFillType(c0());
                    x(yVar);
                    u(yVar);
                    boolean u0 = u0();
                    if (this.d.b) {
                        J(yVar, j0);
                    }
                    if (this.d.c) {
                        K(j0);
                    }
                    Q0(yVar);
                    if (u0) {
                        r0(yVar);
                    }
                }
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.a.restore();
            this.d = this.e.pop();
        }
    }

    public final void D0(SVG.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zVar) == null) {
            G("Polygon render", new Object[0]);
            e1(this.d, zVar);
            if (I() && g1()) {
                h hVar = this.d;
                if (hVar.c || hVar.b) {
                    Matrix matrix = zVar.n;
                    if (matrix != null) {
                        this.a.concat(matrix);
                    }
                    if (zVar.o.length < 2) {
                        return;
                    }
                    Path j0 = j0(zVar);
                    c1(zVar);
                    x(zVar);
                    u(zVar);
                    boolean u0 = u0();
                    if (this.d.b) {
                        J(zVar, j0);
                    }
                    if (this.d.c) {
                        K(j0);
                    }
                    Q0(zVar);
                    if (u0) {
                        r0(zVar);
                    }
                }
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ef9.a(this.a, ef9.a);
            this.e.push(this.d);
            this.d = new h(this, this.d);
        }
    }

    public final void E0(SVG.a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, a0Var) == null) {
            G("Rect render", new Object[0]);
            SVG.o oVar = a0Var.q;
            if (oVar == null || a0Var.r == null || oVar.h() || a0Var.r.h()) {
                return;
            }
            e1(this.d, a0Var);
            if (I() && g1()) {
                Matrix matrix = a0Var.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path k0 = k0(a0Var);
                c1(a0Var);
                x(a0Var);
                u(a0Var);
                boolean u0 = u0();
                if (this.d.b) {
                    J(a0Var, k0);
                }
                if (this.d.c) {
                    K(k0);
                }
                if (u0) {
                    r0(a0Var);
                }
            }
        }
    }

    public final void F0(SVG.d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, d0Var) == null) {
            H0(d0Var, n0(d0Var.p, d0Var.q, d0Var.r, d0Var.s), d0Var.o, d0Var.n);
        }
    }

    public final void G0(SVG.d0 d0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, d0Var, bVar) == null) {
            H0(d0Var, bVar, d0Var.o, d0Var.n);
        }
    }

    public final void H(boolean z, SVG.b bVar, SVG.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), bVar, tVar}) == null) {
            SVG.l0 p = this.c.p(tVar.a);
            if (p == null) {
                Object[] objArr = new Object[2];
                objArr[0] = z ? "Fill" : "Stroke";
                objArr[1] = tVar.a;
                N("%s reference '%s' not found", objArr);
                SVG.m0 m0Var = tVar.b;
                if (m0Var != null) {
                    X0(this.d, z, m0Var);
                } else if (z) {
                    this.d.b = false;
                } else {
                    this.d.c = false;
                }
            } else if (p instanceof SVG.k0) {
                f0(z, bVar, (SVG.k0) p);
            } else if (p instanceof SVG.o0) {
                m0(z, bVar, (SVG.o0) p);
            } else if (p instanceof SVG.b0) {
                Y0(z, (SVG.b0) p);
            }
        }
    }

    public final void H0(SVG.d0 d0Var, SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, d0Var, bVar, bVar2, preserveAspectRatio) == null) {
            G("Svg render", new Object[0]);
            if (bVar.c == 0.0f || bVar.d == 0.0f) {
                return;
            }
            if (preserveAspectRatio == null && (preserveAspectRatio = d0Var.n) == null) {
                preserveAspectRatio = PreserveAspectRatio.d;
            }
            e1(this.d, d0Var);
            if (I()) {
                h hVar = this.d;
                hVar.f = bVar;
                if (!hVar.a.v.booleanValue()) {
                    SVG.b bVar3 = this.d.f;
                    W0(bVar3.a, bVar3.b, bVar3.c, bVar3.d);
                }
                v(d0Var, this.d.f);
                if (bVar2 != null) {
                    this.a.concat(t(this.d.f, bVar2, preserveAspectRatio));
                    this.d.g = d0Var.o;
                } else {
                    Canvas canvas = this.a;
                    SVG.b bVar4 = this.d.f;
                    canvas.translate(bVar4.a, bVar4.b);
                }
                boolean u0 = u0();
                f1();
                N0(d0Var, true);
                if (u0) {
                    r0(d0Var);
                }
                c1(d0Var);
            }
        }
    }

    public final boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Boolean bool = this.d.a.A;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void I0(SVG.l0 l0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, l0Var) == null) || (l0Var instanceof SVG.s)) {
            return;
        }
        a1();
        A(l0Var);
        if (l0Var instanceof SVG.d0) {
            F0((SVG.d0) l0Var);
        } else if (l0Var instanceof SVG.b1) {
            M0((SVG.b1) l0Var);
        } else if (l0Var instanceof SVG.q0) {
            J0((SVG.q0) l0Var);
        } else if (l0Var instanceof SVG.l) {
            y0((SVG.l) l0Var);
        } else if (l0Var instanceof SVG.n) {
            z0((SVG.n) l0Var);
        } else if (l0Var instanceof SVG.u) {
            B0((SVG.u) l0Var);
        } else if (l0Var instanceof SVG.a0) {
            E0((SVG.a0) l0Var);
        } else if (l0Var instanceof SVG.d) {
            w0((SVG.d) l0Var);
        } else if (l0Var instanceof SVG.i) {
            x0((SVG.i) l0Var);
        } else if (l0Var instanceof SVG.p) {
            A0((SVG.p) l0Var);
        } else if (l0Var instanceof SVG.z) {
            D0((SVG.z) l0Var);
        } else if (l0Var instanceof SVG.y) {
            C0((SVG.y) l0Var);
        } else if (l0Var instanceof SVG.u0) {
            L0((SVG.u0) l0Var);
        }
        Z0();
    }

    public final void J(SVG.i0 i0Var, Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, i0Var, path) == null) {
            SVG.m0 m0Var = this.d.a.b;
            if (m0Var instanceof SVG.t) {
                SVG.l0 p = this.c.p(((SVG.t) m0Var).a);
                if (p instanceof SVG.x) {
                    T(i0Var, path, (SVG.x) p);
                    return;
                }
            }
            this.a.drawPath(path, this.d.d);
        }
    }

    public final void J0(SVG.q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, q0Var) == null) {
            G("Switch render", new Object[0]);
            e1(this.d, q0Var);
            if (I()) {
                Matrix matrix = q0Var.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                u(q0Var);
                boolean u0 = u0();
                S0(q0Var);
                if (u0) {
                    r0(q0Var);
                }
                c1(q0Var);
            }
        }
    }

    public final void K(Path path) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, path) == null) {
            h hVar = this.d;
            if (hVar.a.L == SVG.Style.VectorEffect.NonScalingStroke) {
                Matrix matrix = this.a.getMatrix();
                Path path2 = new Path();
                path.transform(matrix, path2);
                this.a.setMatrix(new Matrix());
                Shader shader = this.d.e.getShader();
                Matrix matrix2 = new Matrix();
                if (shader != null) {
                    shader.getLocalMatrix(matrix2);
                    Matrix matrix3 = new Matrix(matrix2);
                    matrix3.postConcat(matrix);
                    shader.setLocalMatrix(matrix3);
                }
                this.a.drawPath(path2, this.d.e);
                this.a.setMatrix(matrix);
                if (shader != null) {
                    shader.setLocalMatrix(matrix2);
                    return;
                }
                return;
            }
            this.a.drawPath(path, hVar.e);
        }
    }

    public final void K0(SVG.r0 r0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, r0Var, bVar) == null) {
            G("Symbol render", new Object[0]);
            if (bVar.c == 0.0f || bVar.d == 0.0f) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = r0Var.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.d;
            }
            e1(this.d, r0Var);
            h hVar = this.d;
            hVar.f = bVar;
            if (!hVar.a.v.booleanValue()) {
                SVG.b bVar2 = this.d.f;
                W0(bVar2.a, bVar2.b, bVar2.c, bVar2.d);
            }
            SVG.b bVar3 = r0Var.o;
            if (bVar3 != null) {
                this.a.concat(t(this.d.f, bVar3, preserveAspectRatio));
                this.d.g = r0Var.o;
            } else {
                Canvas canvas = this.a;
                SVG.b bVar4 = this.d.f;
                canvas.translate(bVar4.a, bVar4.b);
            }
            boolean u0 = u0();
            N0(r0Var, true);
            if (u0) {
                r0(r0Var);
            }
            c1(r0Var);
        }
    }

    public final float L(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) ? (f2 * f4) + (f3 * f5) : invokeCommon.floatValue;
    }

    public final void L0(SVG.u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, u0Var) == null) {
            G("Text render", new Object[0]);
            e1(this.d, u0Var);
            if (I()) {
                Matrix matrix = u0Var.r;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                List<SVG.o> list = u0Var.n;
                float f2 = 0.0f;
                float e2 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).e(this);
                List<SVG.o> list2 = u0Var.o;
                float f3 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).f(this);
                List<SVG.o> list3 = u0Var.p;
                float e3 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).e(this);
                List<SVG.o> list4 = u0Var.q;
                if (list4 != null && list4.size() != 0) {
                    f2 = u0Var.q.get(0).f(this);
                }
                SVG.Style.TextAnchor W = W();
                if (W != SVG.Style.TextAnchor.Start) {
                    float s = s(u0Var);
                    if (W == SVG.Style.TextAnchor.Middle) {
                        s /= 2.0f;
                    }
                    e2 -= s;
                }
                if (u0Var.h == null) {
                    i iVar = new i(this, e2, f3);
                    M(u0Var, iVar);
                    RectF rectF = iVar.c;
                    u0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
                }
                c1(u0Var);
                x(u0Var);
                u(u0Var);
                boolean u0 = u0();
                M(u0Var, new f(this, e2 + e3, f3 + f2));
                if (u0) {
                    r0(u0Var);
                }
            }
        }
    }

    public final void M(SVG.w0 w0Var, j jVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, w0Var, jVar) == null) && I()) {
            Iterator<SVG.l0> it = w0Var.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.a1) {
                    jVar.b(b1(((SVG.a1) next).c, z, !it.hasNext()));
                } else {
                    t0(next, jVar);
                }
                z = false;
            }
        }
    }

    public final void M0(SVG.b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, b1Var) == null) {
            G("Use render", new Object[0]);
            SVG.o oVar = b1Var.r;
            if (oVar == null || !oVar.h()) {
                SVG.o oVar2 = b1Var.s;
                if (oVar2 == null || !oVar2.h()) {
                    e1(this.d, b1Var);
                    if (I()) {
                        SVG.l0 p = b1Var.a.p(b1Var.o);
                        if (p == null) {
                            N("Use reference '%s' not found", b1Var.o);
                            return;
                        }
                        Matrix matrix = b1Var.n;
                        if (matrix != null) {
                            this.a.concat(matrix);
                        }
                        SVG.o oVar3 = b1Var.p;
                        float e2 = oVar3 != null ? oVar3.e(this) : 0.0f;
                        SVG.o oVar4 = b1Var.q;
                        this.a.translate(e2, oVar4 != null ? oVar4.f(this) : 0.0f);
                        u(b1Var);
                        boolean u0 = u0();
                        q0(b1Var);
                        if (p instanceof SVG.d0) {
                            SVG.b n0 = n0(null, null, b1Var.r, b1Var.s);
                            a1();
                            G0((SVG.d0) p, n0);
                            Z0();
                        } else if (p instanceof SVG.r0) {
                            SVG.o oVar5 = b1Var.r;
                            if (oVar5 == null) {
                                oVar5 = new SVG.o(100.0f, SVG.Unit.percent);
                            }
                            SVG.o oVar6 = b1Var.s;
                            if (oVar6 == null) {
                                oVar6 = new SVG.o(100.0f, SVG.Unit.percent);
                            }
                            SVG.b n02 = n0(null, null, oVar5, oVar6);
                            a1();
                            K0((SVG.r0) p, n02);
                            Z0();
                        } else {
                            I0(p);
                        }
                        p0();
                        if (u0) {
                            r0(b1Var);
                        }
                        c1(b1Var);
                    }
                }
            }
        }
    }

    public final void N0(SVG.h0 h0Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, h0Var, z) == null) {
            if (z) {
                q0(h0Var);
            }
            for (SVG.l0 l0Var : h0Var.getChildren()) {
                I0(l0Var);
            }
            if (z) {
                p0();
            }
        }
    }

    public final void O(SVG.w0 w0Var, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, w0Var, sb) == null) {
            Iterator<SVG.l0> it = w0Var.i.iterator();
            boolean z = true;
            while (it.hasNext()) {
                SVG.l0 next = it.next();
                if (next instanceof SVG.w0) {
                    O((SVG.w0) next, sb);
                } else if (next instanceof SVG.a1) {
                    sb.append(b1(((SVG.a1) next).c, z, !it.hasNext()));
                }
                z = false;
            }
        }
    }

    public void O0(SVG svg, hf9 hf9Var) {
        SVG.b bVar;
        PreserveAspectRatio preserveAspectRatio;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, svg, hf9Var) == null) {
            if (hf9Var != null) {
                this.c = svg;
                SVG.d0 l = svg.l();
                if (l == null) {
                    h1("Nothing to render. Document is empty.", new Object[0]);
                    return;
                }
                if (hf9Var.e()) {
                    SVG.j0 f2 = this.c.f(hf9Var.e);
                    if (f2 == null || !(f2 instanceof SVG.c1)) {
                        Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" not found.", hf9Var.e));
                        return;
                    }
                    SVG.c1 c1Var = (SVG.c1) f2;
                    bVar = c1Var.o;
                    if (bVar == null) {
                        Log.w("SVGAndroidRenderer", String.format("View element with id \"%s\" is missing a viewBox attribute.", hf9Var.e));
                        return;
                    }
                    preserveAspectRatio = c1Var.n;
                } else {
                    bVar = hf9Var.f() ? hf9Var.d : l.o;
                    preserveAspectRatio = hf9Var.c() ? hf9Var.b : l.n;
                }
                if (hf9Var.b()) {
                    svg.a(hf9Var.a);
                }
                if (hf9Var.d()) {
                    CSSParser.m mVar = new CSSParser.m();
                    this.h = mVar;
                    mVar.a = svg.f(hf9Var.c);
                }
                V0();
                A(l);
                a1();
                SVG.b bVar2 = new SVG.b(hf9Var.f);
                SVG.o oVar = l.r;
                if (oVar != null) {
                    bVar2.c = oVar.d(this, bVar2.c);
                }
                SVG.o oVar2 = l.s;
                if (oVar2 != null) {
                    bVar2.d = oVar2.d(this, bVar2.d);
                }
                H0(l, bVar2, bVar, preserveAspectRatio);
                Z0();
                if (hf9Var.b()) {
                    svg.b();
                    return;
                }
                return;
            }
            throw new NullPointerException("renderOptions shouldn't be null");
        }
    }

    public final void P(SVG.j jVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, jVar, str) == null) {
            SVG.l0 p = jVar.a.p(str);
            if (p == null) {
                h1("Gradient reference '%s' not found", str);
            } else if (!(p instanceof SVG.j)) {
                N("Gradient href attributes must point to other gradient elements", new Object[0]);
            } else if (p == jVar) {
                N("Circular reference in gradient href attribute '%s'", str);
            } else {
                SVG.j jVar2 = (SVG.j) p;
                if (jVar.i == null) {
                    jVar.i = jVar2.i;
                }
                if (jVar.j == null) {
                    jVar.j = jVar2.j;
                }
                if (jVar.k == null) {
                    jVar.k = jVar2.k;
                }
                if (jVar.h.isEmpty()) {
                    jVar.h = jVar2.h;
                }
                try {
                    if (jVar instanceof SVG.k0) {
                        Q((SVG.k0) jVar, (SVG.k0) p);
                    } else {
                        R((SVG.o0) jVar, (SVG.o0) p);
                    }
                } catch (ClassCastException unused) {
                }
                String str2 = jVar2.l;
                if (str2 != null) {
                    P(jVar, str2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x010c, code lost:
        if (r7 != 8) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P0(SVG.q qVar, c cVar) {
        float f2;
        SVG.b bVar;
        boolean u0;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, qVar, cVar) == null) {
            a1();
            Float f6 = qVar.u;
            float f7 = 0.0f;
            if (f6 != null) {
                if (Float.isNaN(f6.floatValue())) {
                    if (cVar.c != 0.0f || cVar.d != 0.0f) {
                        f2 = (float) Math.toDegrees(Math.atan2(cVar.d, cVar.c));
                    }
                } else {
                    f2 = qVar.u.floatValue();
                }
                float b2 = !qVar.p ? 1.0f : this.d.a.g.b(this.b);
                this.d = U(qVar);
                Matrix matrix = new Matrix();
                matrix.preTranslate(cVar.a, cVar.b);
                matrix.preRotate(f2);
                matrix.preScale(b2, b2);
                SVG.o oVar = qVar.q;
                float e2 = oVar == null ? oVar.e(this) : 0.0f;
                SVG.o oVar2 = qVar.r;
                float f8 = oVar2 == null ? oVar2.f(this) : 0.0f;
                SVG.o oVar3 = qVar.s;
                float e3 = oVar3 == null ? oVar3.e(this) : 3.0f;
                SVG.o oVar4 = qVar.t;
                float f9 = oVar4 != null ? oVar4.f(this) : 3.0f;
                bVar = qVar.o;
                if (bVar == null) {
                    float f10 = e3 / bVar.c;
                    float f11 = f9 / bVar.d;
                    PreserveAspectRatio preserveAspectRatio = qVar.n;
                    if (preserveAspectRatio == null) {
                        preserveAspectRatio = PreserveAspectRatio.d;
                    }
                    if (!preserveAspectRatio.equals(PreserveAspectRatio.c)) {
                        f10 = preserveAspectRatio.b() == PreserveAspectRatio.Scale.slice ? Math.max(f10, f11) : Math.min(f10, f11);
                        f11 = f10;
                    }
                    matrix.preTranslate((-e2) * f10, (-f8) * f11);
                    this.a.concat(matrix);
                    SVG.b bVar2 = qVar.o;
                    float f12 = bVar2.c * f10;
                    float f13 = bVar2.d * f11;
                    switch (a.a[preserveAspectRatio.a().ordinal()]) {
                        case 1:
                        case 2:
                        case 3:
                            f3 = (e3 - f12) / 2.0f;
                            f4 = 0.0f - f3;
                            break;
                        case 4:
                        case 5:
                        case 6:
                            f3 = e3 - f12;
                            f4 = 0.0f - f3;
                            break;
                        default:
                            f4 = 0.0f;
                            break;
                    }
                    int i2 = a.a[preserveAspectRatio.a().ordinal()];
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 5) {
                                if (i2 != 6) {
                                    if (i2 != 7) {
                                    }
                                }
                            }
                        }
                        f5 = f9 - f13;
                        f7 = 0.0f - f5;
                        if (!this.d.a.v.booleanValue()) {
                            W0(f4, f7, e3, f9);
                        }
                        matrix.reset();
                        matrix.preScale(f10, f11);
                        this.a.concat(matrix);
                    }
                    f5 = (f9 - f13) / 2.0f;
                    f7 = 0.0f - f5;
                    if (!this.d.a.v.booleanValue()) {
                    }
                    matrix.reset();
                    matrix.preScale(f10, f11);
                    this.a.concat(matrix);
                } else {
                    matrix.preTranslate(-e2, -f8);
                    this.a.concat(matrix);
                    if (!this.d.a.v.booleanValue()) {
                        W0(0.0f, 0.0f, e3, f9);
                    }
                }
                u0 = u0();
                N0(qVar, false);
                if (u0) {
                    r0(qVar);
                }
                Z0();
            }
            f2 = 0.0f;
            if (!qVar.p) {
            }
            this.d = U(qVar);
            Matrix matrix2 = new Matrix();
            matrix2.preTranslate(cVar.a, cVar.b);
            matrix2.preRotate(f2);
            matrix2.preScale(b2, b2);
            SVG.o oVar5 = qVar.q;
            if (oVar5 == null) {
            }
            SVG.o oVar22 = qVar.r;
            if (oVar22 == null) {
            }
            SVG.o oVar32 = qVar.s;
            if (oVar32 == null) {
            }
            SVG.o oVar42 = qVar.t;
            if (oVar42 != null) {
            }
            bVar = qVar.o;
            if (bVar == null) {
            }
            u0 = u0();
            N0(qVar, false);
            if (u0) {
            }
            Z0();
        }
    }

    public final void Q(SVG.k0 k0Var, SVG.k0 k0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, k0Var, k0Var2) == null) {
            if (k0Var.m == null) {
                k0Var.m = k0Var2.m;
            }
            if (k0Var.n == null) {
                k0Var.n = k0Var2.n;
            }
            if (k0Var.o == null) {
                k0Var.o = k0Var2.o;
            }
            if (k0Var.p == null) {
                k0Var.p = k0Var2.p;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q0(SVG.k kVar) {
        SVG.q qVar;
        String str;
        SVG.q qVar2;
        String str2;
        SVG.q qVar3;
        List<c> q;
        int size;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048604, this, kVar) != null) {
            return;
        }
        SVG.Style style = this.d.a;
        if (style.x == null && style.y == null && style.z == null) {
            return;
        }
        String str3 = this.d.a.x;
        if (str3 != null) {
            SVG.l0 p = kVar.a.p(str3);
            if (p != null) {
                qVar = (SVG.q) p;
                str = this.d.a.y;
                if (str != null) {
                    SVG.l0 p2 = kVar.a.p(str);
                    if (p2 != null) {
                        qVar2 = (SVG.q) p2;
                        str2 = this.d.a.z;
                        if (str2 != null) {
                            SVG.l0 p3 = kVar.a.p(str2);
                            if (p3 != null) {
                                qVar3 = (SVG.q) p3;
                                if (!(kVar instanceof SVG.u)) {
                                    q = new b(this, ((SVG.u) kVar).o).f();
                                } else if (kVar instanceof SVG.p) {
                                    q = p((SVG.p) kVar);
                                } else {
                                    q = q((SVG.y) kVar);
                                }
                                if (q == null && (size = q.size()) != 0) {
                                    SVG.Style style2 = this.d.a;
                                    style2.z = null;
                                    style2.y = null;
                                    style2.x = null;
                                    if (qVar != null) {
                                        P0(qVar, q.get(0));
                                    }
                                    if (qVar2 != null && q.size() > 2) {
                                        c cVar = q.get(1);
                                        i2 = 1;
                                        c cVar2 = q.get(0);
                                        c cVar3 = cVar;
                                        while (i2 < size - 1) {
                                            i2++;
                                            c cVar4 = q.get(i2);
                                            if (cVar3.e) {
                                                v0(cVar2, cVar3, cVar4);
                                            }
                                            P0(qVar2, cVar3);
                                            cVar2 = cVar3;
                                            cVar3 = cVar4;
                                        }
                                    }
                                    if (qVar3 == null) {
                                        P0(qVar3, q.get(size - 1));
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            N("Marker reference '%s' not found", this.d.a.z);
                        }
                        qVar3 = null;
                        if (!(kVar instanceof SVG.u)) {
                        }
                        if (q == null) {
                            return;
                        }
                        SVG.Style style22 = this.d.a;
                        style22.z = null;
                        style22.y = null;
                        style22.x = null;
                        if (qVar != null) {
                        }
                        if (qVar2 != null) {
                            c cVar5 = q.get(1);
                            i2 = 1;
                            c cVar22 = q.get(0);
                            c cVar32 = cVar5;
                            while (i2 < size - 1) {
                            }
                        }
                        if (qVar3 == null) {
                        }
                    } else {
                        N("Marker reference '%s' not found", this.d.a.y);
                    }
                }
                qVar2 = null;
                str2 = this.d.a.z;
                if (str2 != null) {
                }
                qVar3 = null;
                if (!(kVar instanceof SVG.u)) {
                }
                if (q == null) {
                }
            } else {
                N("Marker reference '%s' not found", this.d.a.x);
            }
        }
        qVar = null;
        str = this.d.a.y;
        if (str != null) {
        }
        qVar2 = null;
        str2 = this.d.a.z;
        if (str2 != null) {
        }
        qVar3 = null;
        if (!(kVar instanceof SVG.u)) {
        }
        if (q == null) {
        }
    }

    public final void R(SVG.o0 o0Var, SVG.o0 o0Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, o0Var, o0Var2) == null) {
            if (o0Var.m == null) {
                o0Var.m = o0Var2.m;
            }
            if (o0Var.n == null) {
                o0Var.n = o0Var2.n;
            }
            if (o0Var.o == null) {
                o0Var.o = o0Var2.o;
            }
            if (o0Var.p == null) {
                o0Var.p = o0Var2.p;
            }
            if (o0Var.q == null) {
                o0Var.q = o0Var2.q;
            }
        }
    }

    public final void R0(SVG.r rVar, SVG.i0 i0Var, SVG.b bVar) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048606, this, rVar, i0Var, bVar) == null) {
            G("Mask render", new Object[0]);
            Boolean bool = rVar.n;
            boolean z = true;
            if (bool != null && bool.booleanValue()) {
                SVG.o oVar = rVar.r;
                f2 = oVar != null ? oVar.e(this) : bVar.c;
                SVG.o oVar2 = rVar.s;
                f3 = oVar2 != null ? oVar2.f(this) : bVar.d;
            } else {
                SVG.o oVar3 = rVar.r;
                float d2 = oVar3 != null ? oVar3.d(this, 1.0f) : 1.2f;
                SVG.o oVar4 = rVar.s;
                float d3 = oVar4 != null ? oVar4.d(this, 1.0f) : 1.2f;
                f2 = d2 * bVar.c;
                f3 = d3 * bVar.d;
            }
            if (f2 == 0.0f || f3 == 0.0f) {
                return;
            }
            a1();
            h U = U(rVar);
            this.d = U;
            U.a.m = Float.valueOf(1.0f);
            boolean u0 = u0();
            this.a.save();
            Boolean bool2 = rVar.o;
            if (bool2 != null && !bool2.booleanValue()) {
                z = false;
            }
            if (!z) {
                this.a.translate(bVar.a, bVar.b);
                this.a.scale(bVar.c, bVar.d);
            }
            N0(rVar, false);
            this.a.restore();
            if (u0) {
                s0(i0Var, bVar);
            }
            Z0();
        }
    }

    public final void S(SVG.x xVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, xVar, str) == null) {
            SVG.l0 p = xVar.a.p(str);
            if (p == null) {
                h1("Pattern reference '%s' not found", str);
            } else if (!(p instanceof SVG.x)) {
                N("Pattern href attributes must point to other pattern elements", new Object[0]);
            } else if (p == xVar) {
                N("Circular reference in pattern href attribute '%s'", str);
            } else {
                SVG.x xVar2 = (SVG.x) p;
                if (xVar.p == null) {
                    xVar.p = xVar2.p;
                }
                if (xVar.q == null) {
                    xVar.q = xVar2.q;
                }
                if (xVar.r == null) {
                    xVar.r = xVar2.r;
                }
                if (xVar.s == null) {
                    xVar.s = xVar2.s;
                }
                if (xVar.t == null) {
                    xVar.t = xVar2.t;
                }
                if (xVar.u == null) {
                    xVar.u = xVar2.u;
                }
                if (xVar.v == null) {
                    xVar.v = xVar2.v;
                }
                if (xVar.i.isEmpty()) {
                    xVar.i = xVar2.i;
                }
                if (xVar.o == null) {
                    xVar.o = xVar2.o;
                }
                if (xVar.n == null) {
                    xVar.n = xVar2.n;
                }
                String str2 = xVar2.w;
                if (str2 != null) {
                    S(xVar, str2);
                }
            }
        }
    }

    public final void S0(SVG.q0 q0Var) {
        Set<String> f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, q0Var) == null) {
            String language = Locale.getDefault().getLanguage();
            jf9 g2 = SVG.g();
            for (SVG.l0 l0Var : q0Var.getChildren()) {
                if (l0Var instanceof SVG.e0) {
                    SVG.e0 e0Var = (SVG.e0) l0Var;
                    if (e0Var.a() == null && ((f2 = e0Var.f()) == null || (!f2.isEmpty() && f2.contains(language)))) {
                        Set<String> h2 = e0Var.h();
                        if (h2 != null) {
                            if (i == null) {
                                d0();
                            }
                            if (!h2.isEmpty() && i.containsAll(h2)) {
                            }
                        }
                        Set<String> e2 = e0Var.e();
                        if (e2 != null) {
                            if (!e2.isEmpty() && g2 != null) {
                                for (String str : e2) {
                                    if (!g2.a(str)) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> m = e0Var.m();
                        if (m != null) {
                            if (!m.isEmpty() && g2 != null) {
                                for (String str2 : m) {
                                    if (g2.c(str2, this.d.a.q.intValue(), String.valueOf(this.d.a.r)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        I0(l0Var);
                        return;
                    }
                }
            }
        }
    }

    public final void T(SVG.i0 i0Var, Path path, SVG.x xVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048609, this, i0Var, path, xVar) == null) {
            Boolean bool = xVar.p;
            boolean z = bool != null && bool.booleanValue();
            String str = xVar.w;
            if (str != null) {
                S(xVar, str);
            }
            if (z) {
                SVG.o oVar = xVar.s;
                f2 = oVar != null ? oVar.e(this) : 0.0f;
                SVG.o oVar2 = xVar.t;
                f4 = oVar2 != null ? oVar2.f(this) : 0.0f;
                SVG.o oVar3 = xVar.u;
                f5 = oVar3 != null ? oVar3.e(this) : 0.0f;
                SVG.o oVar4 = xVar.v;
                f3 = oVar4 != null ? oVar4.f(this) : 0.0f;
            } else {
                SVG.o oVar5 = xVar.s;
                float d2 = oVar5 != null ? oVar5.d(this, 1.0f) : 0.0f;
                SVG.o oVar6 = xVar.t;
                float d3 = oVar6 != null ? oVar6.d(this, 1.0f) : 0.0f;
                SVG.o oVar7 = xVar.u;
                float d4 = oVar7 != null ? oVar7.d(this, 1.0f) : 0.0f;
                SVG.o oVar8 = xVar.v;
                float d5 = oVar8 != null ? oVar8.d(this, 1.0f) : 0.0f;
                SVG.b bVar = i0Var.h;
                float f7 = bVar.a;
                float f8 = bVar.c;
                f2 = (d2 * f8) + f7;
                float f9 = bVar.b;
                float f10 = bVar.d;
                float f11 = d4 * f8;
                f3 = d5 * f10;
                f4 = (d3 * f10) + f9;
                f5 = f11;
            }
            if (f5 == 0.0f || f3 == 0.0f) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = xVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.d;
            }
            a1();
            this.a.clipPath(path);
            h hVar = new h(this);
            d1(hVar, SVG.Style.a());
            hVar.a.v = Boolean.FALSE;
            V(xVar, hVar);
            this.d = hVar;
            SVG.b bVar2 = i0Var.h;
            Matrix matrix = xVar.r;
            if (matrix != null) {
                this.a.concat(matrix);
                Matrix matrix2 = new Matrix();
                if (xVar.r.invert(matrix2)) {
                    SVG.b bVar3 = i0Var.h;
                    SVG.b bVar4 = i0Var.h;
                    SVG.b bVar5 = i0Var.h;
                    float[] fArr = {bVar3.a, bVar3.b, bVar3.b(), bVar4.b, bVar4.b(), i0Var.h.c(), bVar5.a, bVar5.c()};
                    matrix2.mapPoints(fArr);
                    RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
                    for (int i2 = 2; i2 <= 6; i2 += 2) {
                        if (fArr[i2] < rectF.left) {
                            rectF.left = fArr[i2];
                        }
                        if (fArr[i2] > rectF.right) {
                            rectF.right = fArr[i2];
                        }
                        int i3 = i2 + 1;
                        if (fArr[i3] < rectF.top) {
                            rectF.top = fArr[i3];
                        }
                        if (fArr[i3] > rectF.bottom) {
                            rectF.bottom = fArr[i3];
                        }
                    }
                    float f12 = rectF.left;
                    float f13 = rectF.top;
                    bVar2 = new SVG.b(f12, f13, rectF.right - f12, rectF.bottom - f13);
                }
            }
            float floor = f2 + (((float) Math.floor((bVar2.a - f2) / f5)) * f5);
            float b2 = bVar2.b();
            float c2 = bVar2.c();
            SVG.b bVar6 = new SVG.b(0.0f, 0.0f, f5, f3);
            boolean u0 = u0();
            for (float floor2 = f4 + (((float) Math.floor((bVar2.b - f4) / f3)) * f3); floor2 < c2; floor2 += f3) {
                float f14 = floor;
                while (f14 < b2) {
                    bVar6.a = f14;
                    bVar6.b = floor2;
                    a1();
                    if (this.d.a.v.booleanValue()) {
                        f6 = floor;
                    } else {
                        f6 = floor;
                        W0(bVar6.a, bVar6.b, bVar6.c, bVar6.d);
                    }
                    SVG.b bVar7 = xVar.o;
                    if (bVar7 != null) {
                        this.a.concat(t(bVar6, bVar7, preserveAspectRatio));
                    } else {
                        Boolean bool2 = xVar.q;
                        boolean z2 = bool2 == null || bool2.booleanValue();
                        this.a.translate(f14, floor2);
                        if (!z2) {
                            Canvas canvas = this.a;
                            SVG.b bVar8 = i0Var.h;
                            canvas.scale(bVar8.c, bVar8.d);
                        }
                    }
                    for (SVG.l0 l0Var : xVar.i) {
                        I0(l0Var);
                    }
                    Z0();
                    f14 += f5;
                    floor = f6;
                }
            }
            if (u0) {
                r0(xVar);
            }
            Z0();
        }
    }

    public final void T0(SVG.x0 x0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, x0Var) == null) {
            G("TextPath render", new Object[0]);
            e1(this.d, x0Var);
            if (I() && g1()) {
                SVG.l0 p = x0Var.a.p(x0Var.n);
                if (p == null) {
                    N("TextPath reference '%s' not found", x0Var.n);
                    return;
                }
                SVG.u uVar = (SVG.u) p;
                Path f2 = new d(this, uVar.o).f();
                Matrix matrix = uVar.n;
                if (matrix != null) {
                    f2.transform(matrix);
                }
                PathMeasure pathMeasure = new PathMeasure(f2, false);
                SVG.o oVar = x0Var.o;
                float d2 = oVar != null ? oVar.d(this, pathMeasure.getLength()) : 0.0f;
                SVG.Style.TextAnchor W = W();
                if (W != SVG.Style.TextAnchor.Start) {
                    float s = s(x0Var);
                    if (W == SVG.Style.TextAnchor.Middle) {
                        s /= 2.0f;
                    }
                    d2 -= s;
                }
                x((SVG.i0) x0Var.c());
                boolean u0 = u0();
                M(x0Var, new e(this, f2, d2, 0.0f));
                if (u0) {
                    r0(x0Var);
                }
            }
        }
    }

    public final h U(SVG.l0 l0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, l0Var)) == null) {
            h hVar = new h(this);
            d1(hVar, SVG.Style.a());
            V(l0Var, hVar);
            return hVar;
        }
        return (h) invokeL.objValue;
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.d.a.m.floatValue() < 1.0f || this.d.a.G != null : invokeV.booleanValue;
    }

    public final h V(SVG.l0 l0Var, h hVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048613, this, l0Var, hVar)) == null) {
            ArrayList<SVG.j0> arrayList = new ArrayList();
            while (true) {
                if (l0Var instanceof SVG.j0) {
                    arrayList.add(0, (SVG.j0) l0Var);
                }
                SVG.h0 h0Var = l0Var.b;
                if (h0Var == null) {
                    break;
                }
                l0Var = (SVG.l0) h0Var;
            }
            for (SVG.j0 j0Var : arrayList) {
                e1(hVar, j0Var);
            }
            h hVar2 = this.d;
            hVar.g = hVar2.g;
            hVar.f = hVar2.f;
            return hVar;
        }
        return (h) invokeLL.objValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.d = new h(this);
            this.e = new Stack<>();
            d1(this.d, SVG.Style.a());
            h hVar = this.d;
            hVar.f = null;
            hVar.h = false;
            this.e.push(new h(this, hVar));
            this.g = new Stack<>();
            this.f = new Stack<>();
        }
    }

    public final SVG.Style.TextAnchor W() {
        InterceptResult invokeV;
        SVG.Style.TextAnchor textAnchor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            SVG.Style style = this.d.a;
            if (style.t != SVG.Style.TextDirection.LTR && (textAnchor = style.u) != SVG.Style.TextAnchor.Middle) {
                SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
                return textAnchor == textAnchor2 ? SVG.Style.TextAnchor.End : textAnchor2;
            }
            return this.d.a.u;
        }
        return (SVG.Style.TextAnchor) invokeV.objValue;
    }

    public final void W0(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float f6 = f4 + f2;
            float f7 = f5 + f3;
            SVG.c cVar = this.d.a.w;
            if (cVar != null) {
                f2 += cVar.d.e(this);
                f3 += this.d.a.w.a.f(this);
                f6 -= this.d.a.w.b.e(this);
                f7 -= this.d.a.w.c.f(this);
            }
            this.a.clipRect(f2, f3, f6, f7);
        }
    }

    public final Path.FillType X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SVG.Style.FillRule fillRule = this.d.a.F;
            if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
                return Path.FillType.EVEN_ODD;
            }
            return Path.FillType.WINDING;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final void X0(h hVar, boolean z, SVG.m0 m0Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{hVar, Boolean.valueOf(z), m0Var}) == null) {
            SVG.Style style = hVar.a;
            float floatValue = (z ? style.d : style.f).floatValue();
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).a;
            } else if (!(m0Var instanceof SVG.g)) {
                return;
            } else {
                i2 = hVar.a.n.a;
            }
            int F = F(i2, floatValue);
            if (z) {
                hVar.d.setColor(F);
            } else {
                hVar.e.setColor(F);
            }
        }
    }

    public float Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.d.d.getTextSize() : invokeV.floatValue;
    }

    public final void Y0(boolean z, SVG.b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048620, this, z, b0Var) == null) {
            if (z) {
                if (e0(b0Var.e, 2147483648L)) {
                    h hVar = this.d;
                    SVG.Style style = hVar.a;
                    SVG.m0 m0Var = b0Var.e.H;
                    style.b = m0Var;
                    hVar.b = m0Var != null;
                }
                if (e0(b0Var.e, 4294967296L)) {
                    this.d.a.d = b0Var.e.I;
                }
                if (e0(b0Var.e, 6442450944L)) {
                    h hVar2 = this.d;
                    X0(hVar2, z, hVar2.a.b);
                    return;
                }
                return;
            }
            if (e0(b0Var.e, 2147483648L)) {
                h hVar3 = this.d;
                SVG.Style style2 = hVar3.a;
                SVG.m0 m0Var2 = b0Var.e.H;
                style2.e = m0Var2;
                hVar3.c = m0Var2 != null;
            }
            if (e0(b0Var.e, 4294967296L)) {
                this.d.a.f = b0Var.e.I;
            }
            if (e0(b0Var.e, 6442450944L)) {
                h hVar4 = this.d;
                X0(hVar4, z, hVar4.a.e);
            }
        }
    }

    public float Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.d.d.getTextSize() / 2.0f : invokeV.floatValue;
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.a.restore();
            this.d = this.e.pop();
        }
    }

    public SVG.b a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            h hVar = this.d;
            SVG.b bVar = hVar.g;
            return bVar != null ? bVar : hVar.f;
        }
        return (SVG.b) invokeV.objValue;
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.a.save();
            this.e.push(this.d);
            this.d = new h(this, this.d);
        }
    }

    public float b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.b : invokeV.floatValue;
    }

    public final String b1(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.d.h) {
                return str.replaceAll("[\\n\\t]", " ");
            }
            String replaceAll = str.replaceAll("\\n", "").replaceAll("\\t", " ");
            if (z) {
                replaceAll = replaceAll.replaceAll("^\\s+", "");
            }
            if (z2) {
                replaceAll = replaceAll.replaceAll("\\s+$", "");
            }
            return replaceAll.replaceAll("\\s{2,}", " ");
        }
        return (String) invokeCommon.objValue;
    }

    public final Path.FillType c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            SVG.Style.FillRule fillRule = this.d.a.c;
            if (fillRule != null && fillRule == SVG.Style.FillRule.EvenOdd) {
                return Path.FillType.EVEN_ODD;
            }
            return Path.FillType.WINDING;
        }
        return (Path.FillType) invokeV.objValue;
    }

    public final void c1(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, i0Var) == null) || i0Var.b == null || i0Var.h == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.g.peek().invert(matrix)) {
            SVG.b bVar = i0Var.h;
            SVG.b bVar2 = i0Var.h;
            SVG.b bVar3 = i0Var.h;
            float[] fArr = {bVar.a, bVar.b, bVar.b(), bVar2.b, bVar2.b(), i0Var.h.c(), bVar3.a, bVar3.c()};
            matrix.preConcat(this.a.getMatrix());
            matrix.mapPoints(fArr);
            RectF rectF = new RectF(fArr[0], fArr[1], fArr[0], fArr[1]);
            for (int i2 = 2; i2 <= 6; i2 += 2) {
                if (fArr[i2] < rectF.left) {
                    rectF.left = fArr[i2];
                }
                if (fArr[i2] > rectF.right) {
                    rectF.right = fArr[i2];
                }
                int i3 = i2 + 1;
                if (fArr[i3] < rectF.top) {
                    rectF.top = fArr[i3];
                }
                if (fArr[i3] > rectF.bottom) {
                    rectF.bottom = fArr[i3];
                }
            }
            SVG.i0 i0Var2 = (SVG.i0) this.f.peek();
            SVG.b bVar4 = i0Var2.h;
            if (bVar4 == null) {
                i0Var2.h = SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                bVar4.d(SVG.b.a(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    public final void d1(h hVar, SVG.Style style) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048629, this, hVar, style) == null) {
            if (e0(style, 4096L)) {
                hVar.a.n = style.n;
            }
            if (e0(style, 2048L)) {
                hVar.a.m = style.m;
            }
            if (e0(style, 1L)) {
                hVar.a.b = style.b;
                SVG.m0 m0Var = style.b;
                hVar.b = (m0Var == null || m0Var == SVG.f.c) ? false : true;
            }
            if (e0(style, 4L)) {
                hVar.a.d = style.d;
            }
            if (e0(style, 6149L)) {
                X0(hVar, true, hVar.a.b);
            }
            if (e0(style, 2L)) {
                hVar.a.c = style.c;
            }
            if (e0(style, 8L)) {
                hVar.a.e = style.e;
                SVG.m0 m0Var2 = style.e;
                hVar.c = (m0Var2 == null || m0Var2 == SVG.f.c) ? false : true;
            }
            if (e0(style, 16L)) {
                hVar.a.f = style.f;
            }
            if (e0(style, 6168L)) {
                X0(hVar, false, hVar.a.e);
            }
            if (e0(style, 34359738368L)) {
                hVar.a.L = style.L;
            }
            if (e0(style, 32L)) {
                SVG.Style style2 = hVar.a;
                SVG.o oVar = style.g;
                style2.g = oVar;
                hVar.e.setStrokeWidth(oVar.c(this));
            }
            if (e0(style, 64L)) {
                hVar.a.h = style.h;
                int i2 = a.b[style.h.ordinal()];
                if (i2 == 1) {
                    hVar.e.setStrokeCap(Paint.Cap.BUTT);
                } else if (i2 == 2) {
                    hVar.e.setStrokeCap(Paint.Cap.ROUND);
                } else if (i2 == 3) {
                    hVar.e.setStrokeCap(Paint.Cap.SQUARE);
                }
            }
            if (e0(style, 128L)) {
                hVar.a.i = style.i;
                int i3 = a.c[style.i.ordinal()];
                if (i3 == 1) {
                    hVar.e.setStrokeJoin(Paint.Join.MITER);
                } else if (i3 == 2) {
                    hVar.e.setStrokeJoin(Paint.Join.ROUND);
                } else if (i3 == 3) {
                    hVar.e.setStrokeJoin(Paint.Join.BEVEL);
                }
            }
            if (e0(style, 256L)) {
                hVar.a.j = style.j;
                hVar.e.setStrokeMiter(style.j.floatValue());
            }
            if (e0(style, 512L)) {
                hVar.a.k = style.k;
            }
            if (e0(style, 1024L)) {
                hVar.a.l = style.l;
            }
            Typeface typeface = null;
            if (e0(style, 1536L)) {
                SVG.o[] oVarArr = hVar.a.k;
                if (oVarArr == null) {
                    hVar.e.setPathEffect(null);
                } else {
                    int length = oVarArr.length;
                    int i4 = length % 2 == 0 ? length : length * 2;
                    float[] fArr = new float[i4];
                    float f2 = 0.0f;
                    for (int i5 = 0; i5 < i4; i5++) {
                        fArr[i5] = hVar.a.k[i5 % length].c(this);
                        f2 += fArr[i5];
                    }
                    if (f2 == 0.0f) {
                        hVar.e.setPathEffect(null);
                    } else {
                        float c2 = hVar.a.l.c(this);
                        if (c2 < 0.0f) {
                            c2 = (c2 % f2) + f2;
                        }
                        hVar.e.setPathEffect(new DashPathEffect(fArr, c2));
                    }
                }
            }
            if (e0(style, 16384L)) {
                float Y = Y();
                hVar.a.p = style.p;
                hVar.d.setTextSize(style.p.d(this, Y));
                hVar.e.setTextSize(style.p.d(this, Y));
            }
            if (e0(style, PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
                hVar.a.o = style.o;
            }
            if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                if (style.q.intValue() == -1 && hVar.a.q.intValue() > 100) {
                    SVG.Style style3 = hVar.a;
                    style3.q = Integer.valueOf(style3.q.intValue() - 100);
                } else if (style.q.intValue() == 1 && hVar.a.q.intValue() < 900) {
                    SVG.Style style4 = hVar.a;
                    style4.q = Integer.valueOf(style4.q.intValue() + 100);
                } else {
                    hVar.a.q = style.q;
                }
            }
            if (e0(style, 65536L)) {
                hVar.a.r = style.r;
            }
            if (e0(style, 106496L)) {
                if (hVar.a.o != null && this.c != null) {
                    jf9 g2 = SVG.g();
                    for (String str : hVar.a.o) {
                        SVG.Style style5 = hVar.a;
                        Typeface z = z(str, style5.q, style5.r);
                        if (z != null || g2 == null) {
                            typeface = z;
                            continue;
                        } else {
                            typeface = g2.c(str, hVar.a.q.intValue(), String.valueOf(hVar.a.r));
                            continue;
                        }
                        if (typeface != null) {
                            break;
                        }
                    }
                }
                if (typeface == null) {
                    SVG.Style style6 = hVar.a;
                    typeface = z(C.SERIF_NAME, style6.q, style6.r);
                }
                hVar.d.setTypeface(typeface);
                hVar.e.setTypeface(typeface);
            }
            if (e0(style, PlaybackStateCompat.ACTION_PREPARE_FROM_URI)) {
                hVar.a.s = style.s;
                hVar.d.setStrikeThruText(style.s == SVG.Style.TextDecoration.LineThrough);
                hVar.d.setUnderlineText(style.s == SVG.Style.TextDecoration.Underline);
                if (Build.VERSION.SDK_INT >= 17) {
                    hVar.e.setStrikeThruText(style.s == SVG.Style.TextDecoration.LineThrough);
                    hVar.e.setUnderlineText(style.s == SVG.Style.TextDecoration.Underline);
                }
            }
            if (e0(style, 68719476736L)) {
                hVar.a.t = style.t;
            }
            if (e0(style, 262144L)) {
                hVar.a.u = style.u;
            }
            if (e0(style, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)) {
                hVar.a.v = style.v;
            }
            if (e0(style, 2097152L)) {
                hVar.a.x = style.x;
            }
            if (e0(style, 4194304L)) {
                hVar.a.y = style.y;
            }
            if (e0(style, 8388608L)) {
                hVar.a.z = style.z;
            }
            if (e0(style, 16777216L)) {
                hVar.a.A = style.A;
            }
            if (e0(style, 33554432L)) {
                hVar.a.B = style.B;
            }
            if (e0(style, 1048576L)) {
                hVar.a.w = style.w;
            }
            if (e0(style, AccountConstants.TYPE_MODIFY_NICKNAME)) {
                hVar.a.E = style.E;
            }
            if (e0(style, 536870912L)) {
                hVar.a.F = style.F;
            }
            if (e0(style, 1073741824L)) {
                hVar.a.G = style.G;
            }
            if (e0(style, 67108864L)) {
                hVar.a.C = style.C;
            }
            if (e0(style, 134217728L)) {
                hVar.a.D = style.D;
            }
            if (e0(style, 8589934592L)) {
                hVar.a.J = style.J;
            }
            if (e0(style, 17179869184L)) {
                hVar.a.K = style.K;
            }
            if (e0(style, 137438953472L)) {
                hVar.a.M = style.M;
            }
        }
    }

    public final boolean e0(SVG.Style style, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048630, this, style, j2)) == null) ? (style.a & j2) != 0 : invokeLJ.booleanValue;
    }

    public final void e1(h hVar, SVG.j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, hVar, j0Var) == null) {
            hVar.a.b(j0Var.b == null);
            SVG.Style style = j0Var.e;
            if (style != null) {
                d1(hVar, style);
            }
            if (this.c.m()) {
                for (CSSParser.l lVar : this.c.d()) {
                    if (CSSParser.l(this.h, lVar.a, j0Var)) {
                        d1(hVar, lVar.b);
                    }
                }
            }
            SVG.Style style2 = j0Var.f;
            if (style2 != null) {
                d1(hVar, style2);
            }
        }
    }

    public final void f0(boolean z, SVG.b bVar, SVG.k0 k0Var) {
        float f2;
        float d2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048632, this, new Object[]{Boolean.valueOf(z), bVar, k0Var}) == null) {
            String str = k0Var.l;
            if (str != null) {
                P(k0Var, str);
            }
            Boolean bool = k0Var.i;
            int i2 = 0;
            boolean z2 = bool != null && bool.booleanValue();
            h hVar = this.d;
            Paint paint = z ? hVar.d : hVar.e;
            if (z2) {
                SVG.b a0 = a0();
                SVG.o oVar = k0Var.m;
                float e2 = oVar != null ? oVar.e(this) : 0.0f;
                SVG.o oVar2 = k0Var.n;
                float f5 = oVar2 != null ? oVar2.f(this) : 0.0f;
                SVG.o oVar3 = k0Var.o;
                float e3 = oVar3 != null ? oVar3.e(this) : a0.c;
                SVG.o oVar4 = k0Var.p;
                f4 = e3;
                f2 = e2;
                f3 = f5;
                d2 = oVar4 != null ? oVar4.f(this) : 0.0f;
            } else {
                SVG.o oVar5 = k0Var.m;
                float d3 = oVar5 != null ? oVar5.d(this, 1.0f) : 0.0f;
                SVG.o oVar6 = k0Var.n;
                float d4 = oVar6 != null ? oVar6.d(this, 1.0f) : 0.0f;
                SVG.o oVar7 = k0Var.o;
                float d5 = oVar7 != null ? oVar7.d(this, 1.0f) : 1.0f;
                SVG.o oVar8 = k0Var.p;
                f2 = d3;
                d2 = oVar8 != null ? oVar8.d(this, 1.0f) : 0.0f;
                f3 = d4;
                f4 = d5;
            }
            a1();
            this.d = U(k0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
            }
            Matrix matrix2 = k0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = k0Var.h.size();
            if (size == 0) {
                Z0();
                if (z) {
                    this.d.b = false;
                    return;
                } else {
                    this.d.c = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f6 = -1.0f;
            Iterator<SVG.l0> it = k0Var.h.iterator();
            while (it.hasNext()) {
                SVG.c0 c0Var = (SVG.c0) it.next();
                Float f7 = c0Var.h;
                float floatValue = f7 != null ? f7.floatValue() : 0.0f;
                if (i2 != 0 && floatValue < f6) {
                    fArr[i2] = f6;
                } else {
                    fArr[i2] = floatValue;
                    f6 = floatValue;
                }
                a1();
                e1(this.d, c0Var);
                SVG.f fVar = (SVG.f) this.d.a.C;
                if (fVar == null) {
                    fVar = SVG.f.b;
                }
                iArr[i2] = F(fVar.a, this.d.a.D.floatValue());
                i2++;
                Z0();
            }
            if ((f2 == f4 && f3 == d2) || size == 1) {
                Z0();
                paint.setColor(iArr[size - 1]);
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = k0Var.k;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            Z0();
            LinearGradient linearGradient = new LinearGradient(f2, f3, f4, d2, iArr, fArr, tileMode);
            linearGradient.setLocalMatrix(matrix);
            paint.setShader(linearGradient);
            paint.setAlpha(C(this.d.a.d.floatValue()));
        }
    }

    public final void f1() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            SVG.Style style = this.d.a;
            SVG.m0 m0Var = style.J;
            if (m0Var instanceof SVG.f) {
                i2 = ((SVG.f) m0Var).a;
            } else if (!(m0Var instanceof SVG.g)) {
                return;
            } else {
                i2 = style.n.a;
            }
            Float f2 = this.d.a.K;
            if (f2 != null) {
                i2 = F(i2, f2.floatValue());
            }
            this.a.drawColor(i2);
        }
    }

    public final Path g0(SVG.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, dVar)) == null) {
            SVG.o oVar = dVar.o;
            float e2 = oVar != null ? oVar.e(this) : 0.0f;
            SVG.o oVar2 = dVar.p;
            float f2 = oVar2 != null ? oVar2.f(this) : 0.0f;
            float c2 = dVar.q.c(this);
            float f3 = e2 - c2;
            float f4 = f2 - c2;
            float f5 = e2 + c2;
            float f6 = f2 + c2;
            if (dVar.h == null) {
                float f7 = 2.0f * c2;
                dVar.h = new SVG.b(f3, f4, f7, f7);
            }
            float f8 = 0.5522848f * c2;
            Path path = new Path();
            path.moveTo(e2, f4);
            float f9 = e2 + f8;
            float f10 = f2 - f8;
            path.cubicTo(f9, f4, f5, f10, f5, f2);
            float f11 = f2 + f8;
            path.cubicTo(f5, f11, f9, f6, e2, f6);
            float f12 = e2 - f8;
            path.cubicTo(f12, f6, f3, f11, f3, f2);
            path.cubicTo(f3, f10, f12, f4, e2, f4);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            Boolean bool = this.d.a.B;
            if (bool != null) {
                return bool.booleanValue();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void h(SVG.k kVar, Path path, Matrix matrix) {
        Path j0;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048636, this, kVar, path, matrix) == null) {
            e1(this.d, kVar);
            if (I() && g1()) {
                Matrix matrix2 = kVar.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                if (kVar instanceof SVG.a0) {
                    j0 = k0((SVG.a0) kVar);
                } else if (kVar instanceof SVG.d) {
                    j0 = g0((SVG.d) kVar);
                } else if (kVar instanceof SVG.i) {
                    j0 = h0((SVG.i) kVar);
                } else if (!(kVar instanceof SVG.y)) {
                    return;
                } else {
                    j0 = j0((SVG.y) kVar);
                }
                u(kVar);
                path.setFillType(X());
                path.addPath(j0, matrix);
            }
        }
    }

    public final Path h0(SVG.i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, iVar)) == null) {
            SVG.o oVar = iVar.o;
            float e2 = oVar != null ? oVar.e(this) : 0.0f;
            SVG.o oVar2 = iVar.p;
            float f2 = oVar2 != null ? oVar2.f(this) : 0.0f;
            float e3 = iVar.q.e(this);
            float f3 = iVar.r.f(this);
            float f4 = e2 - e3;
            float f5 = f2 - f3;
            float f6 = e2 + e3;
            float f7 = f2 + f3;
            if (iVar.h == null) {
                iVar.h = new SVG.b(f4, f5, e3 * 2.0f, 2.0f * f3);
            }
            float f8 = e3 * 0.5522848f;
            float f9 = 0.5522848f * f3;
            Path path = new Path();
            path.moveTo(e2, f5);
            float f10 = e2 + f8;
            float f11 = f2 - f9;
            path.cubicTo(f10, f5, f6, f11, f6, f2);
            float f12 = f9 + f2;
            path.cubicTo(f6, f12, f10, f7, e2, f7);
            float f13 = e2 - f8;
            path.cubicTo(f13, f7, f4, f12, f4, f2);
            path.cubicTo(f4, f11, f13, f5, e2, f5);
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void i(SVG.u uVar, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048638, this, uVar, path, matrix) == null) {
            e1(this.d, uVar);
            if (I() && g1()) {
                Matrix matrix2 = uVar.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                Path f2 = new d(this, uVar.o).f();
                if (uVar.h == null) {
                    uVar.h = r(f2);
                }
                u(uVar);
                path.setFillType(X());
                path.addPath(f2, matrix);
            }
        }
    }

    public final Path i0(SVG.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float e2 = oVar == null ? 0.0f : oVar.e(this);
            SVG.o oVar2 = pVar.p;
            float f2 = oVar2 == null ? 0.0f : oVar2.f(this);
            SVG.o oVar3 = pVar.q;
            float e3 = oVar3 == null ? 0.0f : oVar3.e(this);
            SVG.o oVar4 = pVar.r;
            float f3 = oVar4 != null ? oVar4.f(this) : 0.0f;
            if (pVar.h == null) {
                pVar.h = new SVG.b(Math.min(e2, e3), Math.min(f2, f3), Math.abs(e3 - e2), Math.abs(f3 - f2));
            }
            Path path = new Path();
            path.moveTo(e2, f2);
            path.lineTo(e3, f3);
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void j(SVG.l0 l0Var, boolean z, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{l0Var, Boolean.valueOf(z), path, matrix}) == null) && I()) {
            E();
            if (l0Var instanceof SVG.b1) {
                if (z) {
                    l((SVG.b1) l0Var, path, matrix);
                } else {
                    N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (l0Var instanceof SVG.u) {
                i((SVG.u) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.u0) {
                k((SVG.u0) l0Var, path, matrix);
            } else if (l0Var instanceof SVG.k) {
                h((SVG.k) l0Var, path, matrix);
            } else {
                N("Invalid %s element found in clipPath definition", l0Var.toString());
            }
            D();
        }
    }

    public final Path j0(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, yVar)) == null) {
            Path path = new Path();
            float[] fArr = yVar.o;
            path.moveTo(fArr[0], fArr[1]);
            int i2 = 2;
            while (true) {
                float[] fArr2 = yVar.o;
                if (i2 >= fArr2.length) {
                    break;
                }
                path.lineTo(fArr2[i2], fArr2[i2 + 1]);
                i2 += 2;
            }
            if (yVar instanceof SVG.z) {
                path.close();
            }
            if (yVar.h == null) {
                yVar.h = r(path);
            }
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void k(SVG.u0 u0Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048642, this, u0Var, path, matrix) == null) {
            e1(this.d, u0Var);
            if (I()) {
                Matrix matrix2 = u0Var.r;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                List<SVG.o> list = u0Var.n;
                float f2 = 0.0f;
                float e2 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).e(this);
                List<SVG.o> list2 = u0Var.o;
                float f3 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).f(this);
                List<SVG.o> list3 = u0Var.p;
                float e3 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).e(this);
                List<SVG.o> list4 = u0Var.q;
                if (list4 != null && list4.size() != 0) {
                    f2 = u0Var.q.get(0).f(this);
                }
                if (this.d.a.u != SVG.Style.TextAnchor.Start) {
                    float s = s(u0Var);
                    if (this.d.a.u == SVG.Style.TextAnchor.Middle) {
                        s /= 2.0f;
                    }
                    e2 -= s;
                }
                if (u0Var.h == null) {
                    i iVar = new i(this, e2, f3);
                    M(u0Var, iVar);
                    RectF rectF = iVar.c;
                    u0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
                }
                u(u0Var);
                Path path2 = new Path();
                M(u0Var, new g(this, e2 + e3, f3 + f2, path2));
                path.setFillType(X());
                path.addPath(path2, matrix);
            }
        }
    }

    public final Path k0(SVG.a0 a0Var) {
        InterceptResult invokeL;
        float e2;
        float f2;
        Path path;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, a0Var)) == null) {
            if (a0Var.s == null && a0Var.t == null) {
                e2 = 0.0f;
                f2 = 0.0f;
            } else {
                SVG.o oVar = a0Var.s;
                if (oVar == null) {
                    e2 = a0Var.t.f(this);
                } else if (a0Var.t == null) {
                    e2 = oVar.e(this);
                } else {
                    e2 = oVar.e(this);
                    f2 = a0Var.t.f(this);
                }
                f2 = e2;
            }
            float min = Math.min(e2, a0Var.q.e(this) / 2.0f);
            float min2 = Math.min(f2, a0Var.r.f(this) / 2.0f);
            SVG.o oVar2 = a0Var.o;
            float e3 = oVar2 != null ? oVar2.e(this) : 0.0f;
            SVG.o oVar3 = a0Var.p;
            float f3 = oVar3 != null ? oVar3.f(this) : 0.0f;
            float e4 = a0Var.q.e(this);
            float f4 = a0Var.r.f(this);
            if (a0Var.h == null) {
                a0Var.h = new SVG.b(e3, f3, e4, f4);
            }
            float f5 = e3 + e4;
            float f6 = f3 + f4;
            Path path2 = new Path();
            if (min != 0.0f && min2 != 0.0f) {
                float f7 = min * 0.5522848f;
                float f8 = 0.5522848f * min2;
                float f9 = f3 + min2;
                path2.moveTo(e3, f9);
                float f10 = f9 - f8;
                float f11 = e3 + min;
                float f12 = f11 - f7;
                path2.cubicTo(e3, f10, f12, f3, f11, f3);
                float f13 = f5 - min;
                path2.lineTo(f13, f3);
                float f14 = f13 + f7;
                path2.cubicTo(f14, f3, f5, f10, f5, f9);
                float f15 = f6 - min2;
                path2.lineTo(f5, f15);
                float f16 = f15 + f8;
                path = path2;
                path2.cubicTo(f5, f16, f14, f6, f13, f6);
                path.lineTo(f11, f6);
                path.cubicTo(f12, f6, e3, f16, e3, f15);
                path.lineTo(e3, f9);
            } else {
                path = path2;
                path.moveTo(e3, f3);
                path.lineTo(f5, f3);
                path.lineTo(f5, f6);
                path.lineTo(e3, f6);
                path.lineTo(e3, f3);
            }
            path.close();
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void l(SVG.b1 b1Var, Path path, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048644, this, b1Var, path, matrix) == null) {
            e1(this.d, b1Var);
            if (I() && g1()) {
                Matrix matrix2 = b1Var.n;
                if (matrix2 != null) {
                    matrix.preConcat(matrix2);
                }
                SVG.l0 p = b1Var.a.p(b1Var.o);
                if (p == null) {
                    N("Use reference '%s' not found", b1Var.o);
                    return;
                }
                u(b1Var);
                j(p, false, path, matrix);
            }
        }
    }

    public final Path l0(SVG.u0 u0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, u0Var)) == null) {
            List<SVG.o> list = u0Var.n;
            float f2 = 0.0f;
            float e2 = (list == null || list.size() == 0) ? 0.0f : u0Var.n.get(0).e(this);
            List<SVG.o> list2 = u0Var.o;
            float f3 = (list2 == null || list2.size() == 0) ? 0.0f : u0Var.o.get(0).f(this);
            List<SVG.o> list3 = u0Var.p;
            float e3 = (list3 == null || list3.size() == 0) ? 0.0f : u0Var.p.get(0).e(this);
            List<SVG.o> list4 = u0Var.q;
            if (list4 != null && list4.size() != 0) {
                f2 = u0Var.q.get(0).f(this);
            }
            if (this.d.a.u != SVG.Style.TextAnchor.Start) {
                float s = s(u0Var);
                if (this.d.a.u == SVG.Style.TextAnchor.Middle) {
                    s /= 2.0f;
                }
                e2 -= s;
            }
            if (u0Var.h == null) {
                i iVar = new i(this, e2, f3);
                M(u0Var, iVar);
                RectF rectF = iVar.c;
                u0Var.h = new SVG.b(rectF.left, rectF.top, rectF.width(), iVar.c.height());
            }
            Path path = new Path();
            M(u0Var, new g(this, e2 + e3, f3 + f2, path));
            return path;
        }
        return (Path) invokeL.objValue;
    }

    public final void m0(boolean z, SVG.b bVar, SVG.o0 o0Var) {
        float f2;
        float d2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{Boolean.valueOf(z), bVar, o0Var}) == null) {
            String str = o0Var.l;
            if (str != null) {
                P(o0Var, str);
            }
            Boolean bool = o0Var.i;
            int i2 = 0;
            boolean z2 = bool != null && bool.booleanValue();
            h hVar = this.d;
            Paint paint = z ? hVar.d : hVar.e;
            if (z2) {
                SVG.o oVar = new SVG.o(50.0f, SVG.Unit.percent);
                SVG.o oVar2 = o0Var.m;
                float e2 = oVar2 != null ? oVar2.e(this) : oVar.e(this);
                SVG.o oVar3 = o0Var.n;
                float f4 = oVar3 != null ? oVar3.f(this) : oVar.f(this);
                SVG.o oVar4 = o0Var.o;
                d2 = oVar4 != null ? oVar4.c(this) : oVar.c(this);
                f2 = e2;
                f3 = f4;
            } else {
                SVG.o oVar5 = o0Var.m;
                float d3 = oVar5 != null ? oVar5.d(this, 1.0f) : 0.5f;
                SVG.o oVar6 = o0Var.n;
                float d4 = oVar6 != null ? oVar6.d(this, 1.0f) : 0.5f;
                SVG.o oVar7 = o0Var.o;
                f2 = d3;
                d2 = oVar7 != null ? oVar7.d(this, 1.0f) : 0.5f;
                f3 = d4;
            }
            a1();
            this.d = U(o0Var);
            Matrix matrix = new Matrix();
            if (!z2) {
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
            }
            Matrix matrix2 = o0Var.j;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            int size = o0Var.h.size();
            if (size == 0) {
                Z0();
                if (z) {
                    this.d.b = false;
                    return;
                } else {
                    this.d.c = false;
                    return;
                }
            }
            int[] iArr = new int[size];
            float[] fArr = new float[size];
            float f5 = -1.0f;
            Iterator<SVG.l0> it = o0Var.h.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SVG.c0 c0Var = (SVG.c0) it.next();
                Float f6 = c0Var.h;
                float floatValue = f6 != null ? f6.floatValue() : 0.0f;
                if (i2 != 0 && floatValue < f5) {
                    fArr[i2] = f5;
                } else {
                    fArr[i2] = floatValue;
                    f5 = floatValue;
                }
                a1();
                e1(this.d, c0Var);
                SVG.f fVar = (SVG.f) this.d.a.C;
                if (fVar == null) {
                    fVar = SVG.f.b;
                }
                iArr[i2] = F(fVar.a, this.d.a.D.floatValue());
                i2++;
                Z0();
            }
            if (d2 != 0.0f && size != 1) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                SVG.GradientSpread gradientSpread = o0Var.k;
                if (gradientSpread != null) {
                    if (gradientSpread == SVG.GradientSpread.reflect) {
                        tileMode = Shader.TileMode.MIRROR;
                    } else if (gradientSpread == SVG.GradientSpread.repeat) {
                        tileMode = Shader.TileMode.REPEAT;
                    }
                }
                Z0();
                RadialGradient radialGradient = new RadialGradient(f2, f3, d2, iArr, fArr, tileMode);
                radialGradient.setLocalMatrix(matrix);
                paint.setShader(radialGradient);
                paint.setAlpha(C(this.d.a.d.floatValue()));
                return;
            }
            Z0();
            paint.setColor(iArr[size - 1]);
        }
    }

    public final SVG.b n0(SVG.o oVar, SVG.o oVar2, SVG.o oVar3, SVG.o oVar4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048647, this, oVar, oVar2, oVar3, oVar4)) == null) {
            float e2 = oVar != null ? oVar.e(this) : 0.0f;
            float f2 = oVar2 != null ? oVar2.f(this) : 0.0f;
            SVG.b a0 = a0();
            return new SVG.b(e2, f2, oVar3 != null ? oVar3.e(this) : a0.c, oVar4 != null ? oVar4.f(this) : a0.d);
        }
        return (SVG.b) invokeLLLL.objValue;
    }

    @TargetApi(19)
    public final Path o(SVG.i0 i0Var, SVG.b bVar) {
        InterceptResult invokeLL;
        Path o0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048648, this, i0Var, bVar)) == null) {
            SVG.l0 p = i0Var.a.p(this.d.a.E);
            boolean z = false;
            if (p == null) {
                N("ClipPath reference '%s' not found", this.d.a.E);
                return null;
            }
            SVG.e eVar = (SVG.e) p;
            this.e.push(this.d);
            this.d = U(eVar);
            Boolean bool = eVar.o;
            z = (bool == null || bool.booleanValue()) ? true : true;
            Matrix matrix = new Matrix();
            if (!z) {
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
            }
            Matrix matrix2 = eVar.n;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path path = new Path();
            for (SVG.l0 l0Var : eVar.i) {
                if ((l0Var instanceof SVG.i0) && (o0 = o0((SVG.i0) l0Var, true)) != null) {
                    path.op(o0, Path.Op.UNION);
                }
            }
            if (this.d.a.E != null) {
                if (eVar.h == null) {
                    eVar.h = r(path);
                }
                Path o = o(eVar, eVar.h);
                if (o != null) {
                    path.op(o, Path.Op.INTERSECT);
                }
            }
            path.transform(matrix);
            this.d = this.e.pop();
            return path;
        }
        return (Path) invokeLL.objValue;
    }

    @TargetApi(19)
    public final Path o0(SVG.i0 i0Var, boolean z) {
        InterceptResult invokeLZ;
        Path l0;
        Path o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048649, this, i0Var, z)) == null) {
            this.e.push(this.d);
            h hVar = new h(this, this.d);
            this.d = hVar;
            e1(hVar, i0Var);
            if (I() && g1()) {
                if (i0Var instanceof SVG.b1) {
                    if (!z) {
                        N("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                    }
                    SVG.b1 b1Var = (SVG.b1) i0Var;
                    SVG.l0 p = i0Var.a.p(b1Var.o);
                    if (p == null) {
                        N("Use reference '%s' not found", b1Var.o);
                        this.d = this.e.pop();
                        return null;
                    } else if (!(p instanceof SVG.i0)) {
                        this.d = this.e.pop();
                        return null;
                    } else {
                        l0 = o0((SVG.i0) p, false);
                        if (l0 == null) {
                            return null;
                        }
                        if (b1Var.h == null) {
                            b1Var.h = r(l0);
                        }
                        Matrix matrix = b1Var.n;
                        if (matrix != null) {
                            l0.transform(matrix);
                        }
                    }
                } else if (i0Var instanceof SVG.k) {
                    SVG.k kVar = (SVG.k) i0Var;
                    if (i0Var instanceof SVG.u) {
                        l0 = new d(this, ((SVG.u) i0Var).o).f();
                        if (i0Var.h == null) {
                            i0Var.h = r(l0);
                        }
                    } else {
                        l0 = i0Var instanceof SVG.a0 ? k0((SVG.a0) i0Var) : i0Var instanceof SVG.d ? g0((SVG.d) i0Var) : i0Var instanceof SVG.i ? h0((SVG.i) i0Var) : i0Var instanceof SVG.y ? j0((SVG.y) i0Var) : null;
                    }
                    if (l0 == null) {
                        return null;
                    }
                    if (kVar.h == null) {
                        kVar.h = r(l0);
                    }
                    Matrix matrix2 = kVar.n;
                    if (matrix2 != null) {
                        l0.transform(matrix2);
                    }
                    l0.setFillType(X());
                } else if (!(i0Var instanceof SVG.u0)) {
                    N("Invalid %s element found in clipPath definition", i0Var.n());
                    return null;
                } else {
                    SVG.u0 u0Var = (SVG.u0) i0Var;
                    l0 = l0(u0Var);
                    if (l0 == null) {
                        return null;
                    }
                    Matrix matrix3 = u0Var.r;
                    if (matrix3 != null) {
                        l0.transform(matrix3);
                    }
                    l0.setFillType(X());
                }
                if (this.d.a.E != null && (o = o(i0Var, i0Var.h)) != null) {
                    l0.op(o, Path.Op.INTERSECT);
                }
                this.d = this.e.pop();
                return l0;
            }
            this.d = this.e.pop();
            return null;
        }
        return (Path) invokeLZ.objValue;
    }

    public final List<c> p(SVG.p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, pVar)) == null) {
            SVG.o oVar = pVar.o;
            float e2 = oVar != null ? oVar.e(this) : 0.0f;
            SVG.o oVar2 = pVar.p;
            float f2 = oVar2 != null ? oVar2.f(this) : 0.0f;
            SVG.o oVar3 = pVar.q;
            float e3 = oVar3 != null ? oVar3.e(this) : 0.0f;
            SVG.o oVar4 = pVar.r;
            float f3 = oVar4 != null ? oVar4.f(this) : 0.0f;
            ArrayList arrayList = new ArrayList(2);
            float f4 = e3 - e2;
            float f5 = f3 - f2;
            arrayList.add(new c(this, e2, f2, f4, f5));
            arrayList.add(new c(this, e3, f3, f4, f5));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.f.pop();
            this.g.pop();
        }
    }

    public final List<c> q(SVG.y yVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, yVar)) == null) {
            int length = yVar.o.length;
            int i2 = 2;
            if (length < 2) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            float[] fArr = yVar.o;
            c cVar = new c(this, fArr[0], fArr[1], 0.0f, 0.0f);
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (i2 < length) {
                float[] fArr2 = yVar.o;
                float f4 = fArr2[i2];
                float f5 = fArr2[i2 + 1];
                cVar.a(f4, f5);
                arrayList.add(cVar);
                i2 += 2;
                cVar = new c(this, f4, f5, f4 - cVar.a, f5 - cVar.b);
                f3 = f5;
                f2 = f4;
            }
            if (yVar instanceof SVG.z) {
                float[] fArr3 = yVar.o;
                if (f2 != fArr3[0] && f3 != fArr3[1]) {
                    float f6 = fArr3[0];
                    float f7 = fArr3[1];
                    cVar.a(f6, f7);
                    arrayList.add(cVar);
                    c cVar2 = new c(this, f6, f7, f6 - cVar.a, f7 - cVar.b);
                    cVar2.b((c) arrayList.get(0));
                    arrayList.add(cVar2);
                    arrayList.set(0, cVar2);
                }
            } else {
                arrayList.add(cVar);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void q0(SVG.h0 h0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, h0Var) == null) {
            this.f.push(h0Var);
            this.g.push(this.a.getMatrix());
        }
    }

    public final SVG.b r(Path path) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048654, this, path)) == null) {
            RectF rectF = new RectF();
            path.computeBounds(rectF, true);
            return new SVG.b(rectF.left, rectF.top, rectF.width(), rectF.height());
        }
        return (SVG.b) invokeL.objValue;
    }

    public final void r0(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, i0Var) == null) {
            s0(i0Var, i0Var.h);
        }
    }

    public final float s(SVG.w0 w0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, w0Var)) == null) {
            k kVar = new k(this, null);
            M(w0Var, kVar);
            return kVar.a;
        }
        return invokeL.floatValue;
    }

    public final void s0(SVG.i0 i0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048657, this, i0Var, bVar) == null) {
            if (this.d.a.G != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                this.a.saveLayer(null, paint, 31);
                Paint paint2 = new Paint();
                paint2.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.2127f, 0.7151f, 0.0722f, 0.0f, 0.0f})));
                this.a.saveLayer(null, paint2, 31);
                SVG.r rVar = (SVG.r) this.c.p(this.d.a.G);
                R0(rVar, i0Var, bVar);
                this.a.restore();
                Paint paint3 = new Paint();
                paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                this.a.saveLayer(null, paint3, 31);
                R0(rVar, i0Var, bVar);
                this.a.restore();
                this.a.restore();
            }
            Z0();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r11 != 8) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Matrix t(SVG.b bVar, SVG.b bVar2, PreserveAspectRatio preserveAspectRatio) {
        InterceptResult invokeLLL;
        int i2;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048658, this, bVar, bVar2, preserveAspectRatio)) == null) {
            Matrix matrix = new Matrix();
            if (preserveAspectRatio != null && preserveAspectRatio.a() != null) {
                float f4 = bVar.c / bVar2.c;
                float f5 = bVar.d / bVar2.d;
                float f6 = -bVar2.a;
                float f7 = -bVar2.b;
                if (preserveAspectRatio.equals(PreserveAspectRatio.c)) {
                    matrix.preTranslate(bVar.a, bVar.b);
                    matrix.preScale(f4, f5);
                    matrix.preTranslate(f6, f7);
                    return matrix;
                }
                float max = preserveAspectRatio.b() == PreserveAspectRatio.Scale.slice ? Math.max(f4, f5) : Math.min(f4, f5);
                float f8 = bVar.c / max;
                float f9 = bVar.d / max;
                switch (a.a[preserveAspectRatio.a().ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        f3 = (bVar2.c - f8) / 2.0f;
                        f6 -= f3;
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 5) {
                                    if (i2 != 6) {
                                        if (i2 != 7) {
                                            break;
                                        }
                                    }
                                }
                            }
                            f2 = bVar2.d - f9;
                            f7 -= f2;
                            matrix.preTranslate(bVar.a, bVar.b);
                            matrix.preScale(max, max);
                            matrix.preTranslate(f6, f7);
                            break;
                        }
                        f2 = (bVar2.d - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.a, bVar.b);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                    case 4:
                    case 5:
                    case 6:
                        f3 = bVar2.c - f8;
                        f6 -= f3;
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.d - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.a, bVar.b);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                    default:
                        i2 = a.a[preserveAspectRatio.a().ordinal()];
                        if (i2 != 2) {
                        }
                        f2 = (bVar2.d - f9) / 2.0f;
                        f7 -= f2;
                        matrix.preTranslate(bVar.a, bVar.b);
                        matrix.preScale(max, max);
                        matrix.preTranslate(f6, f7);
                        break;
                }
            }
            return matrix;
        }
        return (Matrix) invokeLLL.objValue;
    }

    public final void t0(SVG.l0 l0Var, j jVar) {
        float f2;
        float f3;
        float f4;
        SVG.Style.TextAnchor W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048659, this, l0Var, jVar) == null) && jVar.a((SVG.w0) l0Var)) {
            if (l0Var instanceof SVG.x0) {
                a1();
                T0((SVG.x0) l0Var);
                Z0();
                return;
            }
            boolean z = true;
            if (l0Var instanceof SVG.t0) {
                G("TSpan render", new Object[0]);
                a1();
                SVG.t0 t0Var = (SVG.t0) l0Var;
                e1(this.d, t0Var);
                if (I()) {
                    List<SVG.o> list = t0Var.n;
                    z = (list == null || list.size() <= 0) ? false : false;
                    boolean z2 = jVar instanceof f;
                    float f5 = 0.0f;
                    if (z2) {
                        float e2 = !z ? ((f) jVar).a : t0Var.n.get(0).e(this);
                        List<SVG.o> list2 = t0Var.o;
                        f3 = (list2 == null || list2.size() == 0) ? ((f) jVar).b : t0Var.o.get(0).f(this);
                        List<SVG.o> list3 = t0Var.p;
                        f4 = (list3 == null || list3.size() == 0) ? 0.0f : t0Var.p.get(0).e(this);
                        List<SVG.o> list4 = t0Var.q;
                        if (list4 != null && list4.size() != 0) {
                            f5 = t0Var.q.get(0).f(this);
                        }
                        f2 = f5;
                        f5 = e2;
                    } else {
                        f2 = 0.0f;
                        f3 = 0.0f;
                        f4 = 0.0f;
                    }
                    if (z && (W = W()) != SVG.Style.TextAnchor.Start) {
                        float s = s(t0Var);
                        if (W == SVG.Style.TextAnchor.Middle) {
                            s /= 2.0f;
                        }
                        f5 -= s;
                    }
                    x((SVG.i0) t0Var.c());
                    if (z2) {
                        f fVar = (f) jVar;
                        fVar.a = f5 + f4;
                        fVar.b = f3 + f2;
                    }
                    boolean u0 = u0();
                    M(t0Var, jVar);
                    if (u0) {
                        r0(t0Var);
                    }
                }
                Z0();
            } else if (l0Var instanceof SVG.s0) {
                a1();
                SVG.s0 s0Var = (SVG.s0) l0Var;
                e1(this.d, s0Var);
                if (I()) {
                    x((SVG.i0) s0Var.c());
                    SVG.l0 p = l0Var.a.p(s0Var.n);
                    if (p == null || !(p instanceof SVG.w0)) {
                        N("Tref reference '%s' not found", s0Var.n);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        O((SVG.w0) p, sb);
                        if (sb.length() > 0) {
                            jVar.b(sb.toString());
                        }
                    }
                }
                Z0();
            }
        }
    }

    public final void u(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, i0Var) == null) {
            v(i0Var, i0Var.h);
        }
    }

    public final boolean u0() {
        InterceptResult invokeV;
        SVG.l0 p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (U0()) {
                this.a.saveLayerAlpha(null, C(this.d.a.m.floatValue()), 31);
                this.e.push(this.d);
                h hVar = new h(this, this.d);
                this.d = hVar;
                String str = hVar.a.G;
                if (str != null && ((p = this.c.p(str)) == null || !(p instanceof SVG.r))) {
                    N("Mask reference '%s' not found", this.d.a.G);
                    this.d.a.G = null;
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v(SVG.i0 i0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048662, this, i0Var, bVar) == null) || this.d.a.E == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Path o = o(i0Var, bVar);
            if (o != null) {
                this.a.clipPath(o);
                return;
            }
            return;
        }
        w(i0Var, bVar);
    }

    public final c v0(c cVar, c cVar2, c cVar3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048663, this, cVar, cVar2, cVar3)) == null) {
            float L = L(cVar2.c, cVar2.d, cVar2.a - cVar.a, cVar2.b - cVar.b);
            if (L == 0.0f) {
                L = L(cVar2.c, cVar2.d, cVar3.a - cVar2.a, cVar3.b - cVar2.b);
            }
            int i2 = (L > 0.0f ? 1 : (L == 0.0f ? 0 : -1));
            if (i2 > 0) {
                return cVar2;
            }
            if (i2 != 0 || (cVar2.c <= 0.0f && cVar2.d < 0.0f)) {
                cVar2.c = -cVar2.c;
                cVar2.d = -cVar2.d;
                return cVar2;
            }
            return cVar2;
        }
        return (c) invokeLLL.objValue;
    }

    public final void w(SVG.i0 i0Var, SVG.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048664, this, i0Var, bVar) == null) {
            SVG.l0 p = i0Var.a.p(this.d.a.E);
            if (p == null) {
                N("ClipPath reference '%s' not found", this.d.a.E);
                return;
            }
            SVG.e eVar = (SVG.e) p;
            if (eVar.i.isEmpty()) {
                this.a.clipRect(0, 0, 0, 0);
                return;
            }
            Boolean bool = eVar.o;
            boolean z = bool == null || bool.booleanValue();
            if ((i0Var instanceof SVG.l) && !z) {
                h1("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", i0Var.n());
                return;
            }
            E();
            if (!z) {
                Matrix matrix = new Matrix();
                matrix.preTranslate(bVar.a, bVar.b);
                matrix.preScale(bVar.c, bVar.d);
                this.a.concat(matrix);
            }
            Matrix matrix2 = eVar.n;
            if (matrix2 != null) {
                this.a.concat(matrix2);
            }
            this.d = U(eVar);
            u(eVar);
            Path path = new Path();
            for (SVG.l0 l0Var : eVar.i) {
                j(l0Var, true, path, new Matrix());
            }
            this.a.clipPath(path);
            D();
        }
    }

    public final void w0(SVG.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, dVar) == null) {
            G("Circle render", new Object[0]);
            SVG.o oVar = dVar.q;
            if (oVar == null || oVar.h()) {
                return;
            }
            e1(this.d, dVar);
            if (I() && g1()) {
                Matrix matrix = dVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path g0 = g0(dVar);
                c1(dVar);
                x(dVar);
                u(dVar);
                boolean u0 = u0();
                if (this.d.b) {
                    J(dVar, g0);
                }
                if (this.d.c) {
                    K(g0);
                }
                if (u0) {
                    r0(dVar);
                }
            }
        }
    }

    public final void x(SVG.i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, i0Var) == null) {
            SVG.m0 m0Var = this.d.a.b;
            if (m0Var instanceof SVG.t) {
                H(true, i0Var.h, (SVG.t) m0Var);
            }
            SVG.m0 m0Var2 = this.d.a.e;
            if (m0Var2 instanceof SVG.t) {
                H(false, i0Var.h, (SVG.t) m0Var2);
            }
        }
    }

    public final void x0(SVG.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, iVar) == null) {
            G("Ellipse render", new Object[0]);
            SVG.o oVar = iVar.q;
            if (oVar == null || iVar.r == null || oVar.h() || iVar.r.h()) {
                return;
            }
            e1(this.d, iVar);
            if (I() && g1()) {
                Matrix matrix = iVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                Path h0 = h0(iVar);
                c1(iVar);
                x(iVar);
                u(iVar);
                boolean u0 = u0();
                if (this.d.b) {
                    J(iVar, h0);
                }
                if (this.d.c) {
                    K(h0);
                }
                if (u0) {
                    r0(iVar);
                }
            }
        }
    }

    public final Bitmap y(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, str)) == null) {
            if (str.startsWith(WebGLImageLoader.DATA_URL) && str.length() >= 14 && (indexOf = str.indexOf(44)) >= 12 && DataUrlLoader.BASE64_TAG.equals(str.substring(indexOf - 7, indexOf))) {
                try {
                    byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
                    return BitmapFactory.decodeByteArray(decode, 0, decode.length);
                } catch (Exception e2) {
                    Log.e("SVGAndroidRenderer", "Could not decode bad Data URL", e2);
                    return null;
                }
            }
            return null;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void y0(SVG.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, lVar) == null) {
            G("Group render", new Object[0]);
            e1(this.d, lVar);
            if (I()) {
                Matrix matrix = lVar.n;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                u(lVar);
                boolean u0 = u0();
                N0(lVar, true);
                if (u0) {
                    r0(lVar);
                }
                c1(lVar);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003c, code lost:
        if (r7.equals(com.google.android.exoplayer2.C.SERIF_NAME) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Typeface z(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048670, this, str, num, fontStyle)) == null) {
            char c2 = 0;
            boolean z = fontStyle == SVG.Style.FontStyle.Italic;
            int i2 = num.intValue() > 500 ? z ? 3 : 1 : z ? 2 : 0;
            switch (str.hashCode()) {
                case -1536685117:
                    if (str.equals("sans-serif")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1431958525:
                    if (str.equals("monospace")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -1081737434:
                    if (str.equals("fantasy")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 109326717:
                    break;
                case 1126973893:
                    if (str.equals("cursive")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 != 4) {
                                return null;
                            }
                            return Typeface.create(Typeface.SANS_SERIF, i2);
                        }
                        return Typeface.create(Typeface.SANS_SERIF, i2);
                    }
                    return Typeface.create(Typeface.MONOSPACE, i2);
                }
                return Typeface.create(Typeface.SANS_SERIF, i2);
            }
            return Typeface.create(Typeface.SERIF, i2);
        }
        return (Typeface) invokeLLL.objValue;
    }

    public final void z0(SVG.n nVar) {
        SVG.o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, nVar) == null) {
            G("Image render", new Object[0]);
            SVG.o oVar2 = nVar.r;
            if (oVar2 == null || oVar2.h() || (oVar = nVar.s) == null || oVar.h() || nVar.o == null) {
                return;
            }
            PreserveAspectRatio preserveAspectRatio = nVar.n;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.d;
            }
            Bitmap y = y(nVar.o);
            if (y == null) {
                jf9 g2 = SVG.g();
                if (g2 == null) {
                    return;
                }
                y = g2.d(nVar.o);
            }
            if (y == null) {
                N("Could not locate image '%s'", nVar.o);
                return;
            }
            SVG.b bVar = new SVG.b(0.0f, 0.0f, y.getWidth(), y.getHeight());
            e1(this.d, nVar);
            if (I() && g1()) {
                Matrix matrix = nVar.t;
                if (matrix != null) {
                    this.a.concat(matrix);
                }
                SVG.o oVar3 = nVar.p;
                float e2 = oVar3 != null ? oVar3.e(this) : 0.0f;
                SVG.o oVar4 = nVar.q;
                this.d.f = new SVG.b(e2, oVar4 != null ? oVar4.f(this) : 0.0f, nVar.r.e(this), nVar.s.e(this));
                if (!this.d.a.v.booleanValue()) {
                    SVG.b bVar2 = this.d.f;
                    W0(bVar2.a, bVar2.b, bVar2.c, bVar2.d);
                }
                nVar.h = this.d.f;
                c1(nVar);
                u(nVar);
                boolean u0 = u0();
                f1();
                this.a.save();
                this.a.concat(t(this.d.f, bVar, preserveAspectRatio));
                this.a.drawBitmap(y, 0.0f, 0.0f, new Paint(this.d.a.M != SVG.Style.RenderQuality.optimizeSpeed ? 2 : 0));
                this.a.restore();
                if (u0) {
                    r0(nVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final /* synthetic */ if9 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(if9 if9Var) {
            super(if9Var, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((if9) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = if9Var;
            this.a = 0.0f;
        }

        @Override // com.baidu.tieba.if9.j
        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a += this.b.d.d.measureText(str);
            }
        }

        public /* synthetic */ k(if9 if9Var, a aVar) {
            this(if9Var);
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SVG.Style a;
        public boolean b;
        public boolean c;
        public Paint d;
        public Paint e;
        public SVG.b f;
        public SVG.b g;
        public boolean h;

        public h(if9 if9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Paint paint = new Paint();
            this.d = paint;
            paint.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.d.setHinting(0);
            }
            this.d.setStyle(Paint.Style.FILL);
            this.d.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.e = paint2;
            paint2.setFlags(193);
            if (Build.VERSION.SDK_INT >= 14) {
                this.e.setHinting(0);
            }
            this.e.setStyle(Paint.Style.STROKE);
            this.e.setTypeface(Typeface.DEFAULT);
            this.a = SVG.Style.a();
        }

        public h(if9 if9Var, h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if9Var, hVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = hVar.b;
            this.c = hVar.c;
            this.d = new Paint(hVar.d);
            this.e = new Paint(hVar.e);
            SVG.b bVar = hVar.f;
            if (bVar != null) {
                this.f = new SVG.b(bVar);
            }
            SVG.b bVar2 = hVar.g;
            if (bVar2 != null) {
                this.g = new SVG.b(bVar2);
            }
            this.h = hVar.h;
            try {
                this.a = (SVG.Style) hVar.a.clone();
            } catch (CloneNotSupportedException e) {
                Log.e("SVGAndroidRenderer", "Unexpected clone error", e);
                this.a = SVG.Style.a();
            }
        }
    }
}
