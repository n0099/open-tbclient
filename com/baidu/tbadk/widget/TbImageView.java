package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.i;
import c.a.d.a.j;
import c.a.d.f.p.l;
import c.a.d.h.a.a;
import c.a.p0.w2.j.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes5.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, SoftReference<c.a.d.o.d.a>> u0;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public final int C;
    public int D;
    public int E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public float L;
    public float M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public g R;
    public h S;
    public View.OnClickListener T;
    public c.a.p0.w2.j.c U;
    public TbRichTextView.w V;
    public boolean W;
    public RectF g0;
    public Path h0;
    public RectF i0;
    public final Matrix j0;
    public c.a.o0.e1.c k0;
    public String l0;
    public int m0;
    public boolean n0;
    public int o0;
    public int p0;
    public c.a.p0.w2.j.c q0;
    public BdUniqueId r;
    public final c.a.d.f.l.c<c.a.d.o.d.a> r0;
    public boolean s;
    public a.b s0;
    public HashMap<String, f> t;
    public CustomMessageListener t0;
    public HashMap<String, f> u;
    public String v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes5.dex */
    public class a extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public a(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.a.N();
                g gVar = this.a.R;
                if (gVar != null) {
                    gVar.onCancel();
                }
            }
        }

        @Override // c.a.d.f.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) {
                if (aVar != null) {
                    this.a.o0 = aVar.r();
                    this.a.p0 = aVar.m();
                    c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                    TbImageView tbImageView = this.a;
                    String g2 = h2.g(tbImageView.v, tbImageView.w);
                    f fVar = this.a.u.get(g2);
                    if (fVar != null) {
                        c.a.d.f.l.a.d(i == 1, i == 2, i == 3);
                        if (i == 3) {
                            c.a.d.f.l.a.e(true, System.currentTimeMillis() - fVar.f30743c);
                        }
                        this.a.u.remove(g2);
                    }
                }
                this.a.N();
                this.a.E(aVar);
                g gVar = this.a.R;
                if (gVar != null) {
                    gVar.a(str, aVar != null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // c.a.d.h.a.a.b
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.a.getBdImage() == null && this.a.n0) {
                    this.a.u(canvas, drawable);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(TbImageView tbImageView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                TbImageView tbImageView = this.a;
                String g2 = h2.g(tbImageView.v, tbImageView.w);
                if (g2 == null || !g2.equals(str)) {
                    return;
                }
                this.a.destroyDrawingCache();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public d(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.getBdImage() != null || this.a.getDrawable() != null || !this.a.W) {
                    if (this.a.T != null) {
                        this.a.T.onClick(view);
                        return true;
                    } else if (this.a.U != null) {
                        this.a.U.a(view);
                        return this.a.U.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.a.L();
                c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                TbImageView tbImageView = this.a;
                h2.k(tbImageView.v, tbImageView.w, tbImageView.r0, tbImageView.x, tbImageView.y, tbImageView.r, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.U != null) {
                    this.a.U.a(view);
                    return this.a.U.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        public e(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbImageView;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.a.getBdImage() != null || this.a.getDrawable() != null || !this.a.W) {
                    if (this.a.T != null) {
                        this.a.T.onClick(view);
                        return true;
                    } else if (this.a.U != null) {
                        this.a.U.a(view);
                        return this.a.U.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.a.L();
                c.a.d.f.l.d h2 = c.a.d.f.l.d.h();
                TbImageView tbImageView = this.a;
                h2.k(tbImageView.v, tbImageView.w, tbImageView.r0, tbImageView.x, tbImageView.y, tbImageView.r, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // c.a.p0.w2.j.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.a.U != null) {
                    this.a.U.a(view);
                    return this.a.U.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public int f30742b;

        /* renamed from: c  reason: collision with root package name */
        public long f30743c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TbImageView f30744d;

        public f(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30744d = tbImageView;
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = false;
        this.w = 10;
        this.C = R.drawable.img_loading;
        this.D = R.color.transparent;
        this.E = R.color.CAM_X0205;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = true;
        this.P = true;
        this.Q = 3;
        this.g0 = new RectF();
        this.h0 = new Path();
        this.i0 = new RectF();
        this.j0 = new Matrix();
        this.n0 = false;
        this.o0 = 0;
        this.p0 = 0;
        this.r0 = new a(this);
        this.s0 = new b(this);
        this.t0 = new c(this, 2016308);
        v();
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.t = new HashMap<>();
            this.u = new HashMap<>();
            this.k0 = new c.a.o0.e1.c(this);
            O();
            this.A = 30.0f;
            setConrers(0);
            c.a.d.h.a.a aVar = this.f23846e;
            if (aVar == null) {
                return;
            }
            aVar.o(this.s0);
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public final void B(boolean z, Canvas canvas) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, canvas) == null) || (hVar = this.S) == null) {
            return;
        }
        if (z) {
            hVar.b(this, canvas);
        } else {
            hVar.a(this, canvas);
        }
    }

    public final void C(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.J || getBdImage() != null) {
                if (this.m0 != 0 || getDrawCorner()) {
                    setDrawerType(1);
                    int i = this.m0 ^ 15;
                    this.i0.set(0.0f, 0.0f, getWidth(), getHeight());
                    if ((i & 1) != 0) {
                        float[] fArr = this.f23845d.a;
                        canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.f23846e.f2433b);
                    }
                    if ((i & 2) != 0) {
                        float f2 = this.i0.right;
                        float[] fArr2 = this.f23845d.a;
                        canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.f23846e.f2433b);
                    }
                    if ((i & 4) != 0) {
                        float f3 = this.i0.bottom;
                        float[] fArr3 = this.f23845d.a;
                        canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.f23846e.f2433b);
                    }
                    if ((i & 8) != 0) {
                        RectF rectF = this.i0;
                        float f4 = rectF.right;
                        float[] fArr4 = this.f23845d.a;
                        float f5 = rectF.bottom;
                        canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.f23846e.f2433b);
                    }
                }
            }
        }
    }

    public final void D(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.J || getBdImage() != null) {
                if (this.m0 != 0 || getDrawBorder()) {
                    setDrawerType(1);
                    int i = this.m0 ^ 15;
                    this.i0.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.f23846e.f2434c.setStrokeWidth(this.f23846e.f2434c.getStrokeWidth());
                    if ((i & 1) != 0) {
                        canvas.drawLine(0.0f, 0.0f, this.f23845d.a[0], 0.0f, this.f23846e.f2434c);
                        canvas.drawLine(0.0f, 0.0f, 0.0f, this.f23845d.a[1], this.f23846e.f2434c);
                    }
                    if ((i & 2) != 0) {
                        float f2 = this.i0.right;
                        canvas.drawLine(f2 - this.f23845d.a[2], 0.0f, f2, 0.0f, this.f23846e.f2434c);
                        float f3 = this.i0.right;
                        canvas.drawLine(f3, 0.0f, f3, this.f23845d.a[3], this.f23846e.f2434c);
                    }
                    if ((i & 4) != 0) {
                        float f4 = this.i0.bottom;
                        canvas.drawLine(0.0f, f4 - this.f23845d.a[5], 0.0f, f4, this.f23846e.f2434c);
                        float f5 = this.i0.bottom;
                        canvas.drawLine(0.0f, f5, this.f23845d.a[4], f5, this.f23846e.f2434c);
                    }
                    if ((i & 8) != 0) {
                        RectF rectF = this.i0;
                        float f6 = rectF.right;
                        float f7 = rectF.bottom;
                        canvas.drawLine(f6 - this.f23845d.a[6], f7, f6, f7, this.f23846e.f2434c);
                        RectF rectF2 = this.i0;
                        float f8 = rectF2.right;
                        float f9 = rectF2.bottom;
                        canvas.drawLine(f8, f9, f8, f9 - this.f23845d.a[7], this.f23846e.f2434c);
                    }
                }
            }
        }
    }

    public final void E(c.a.d.o.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        this.H = aVar.t();
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setTag(null);
            this.v = null;
            this.H = false;
            this.I = false;
            this.G = false;
        }
    }

    public void G(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            i c2 = j.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.r;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                z2 = c2.isScroll();
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            H(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void H(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
            if (TextUtils.isEmpty(str)) {
                this.v = str;
                int i4 = this.Q;
                if (i4 == 3 || i4 == TbadkCoreApplication.getInst().getSkinType()) {
                    return;
                }
                invalidate();
                return;
            }
            boolean z3 = str.equals(this.v) && i == this.w && bdUniqueId == this.r;
            c.a.d.o.d.a bdImage = getBdImage();
            if (!z3) {
                t();
                this.f23849h = true;
                this.H = false;
                requestLayout();
            } else if (bdImage != null) {
                invalidate();
                this.o0 = bdImage.r();
                this.p0 = bdImage.m();
                g gVar = this.R;
                if (gVar != null) {
                    gVar.a(str, true);
                    return;
                }
                return;
            }
            this.v = str;
            this.w = i;
            this.r = bdUniqueId;
            this.f23849h = true;
            if (!TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.x = i2;
                this.y = i3;
            }
            if (z2) {
                invalidate();
            } else if (!c.a.d.f.l.d.h().j(this.w) && this.N) {
                invalidate();
            } else if (z3 && !l.z()) {
                invalidate();
                g gVar2 = this.R;
                if (gVar2 != null) {
                    gVar2.a(str, false);
                }
            } else {
                if (z) {
                    L();
                }
                String g2 = c.a.d.f.l.d.h().g(str, i);
                f fVar = new f(this);
                fVar.a = str;
                fVar.f30742b = i;
                fVar.f30743c = System.currentTimeMillis();
                this.u.put(g2, fVar);
                if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                    String g3 = c.a.d.f.l.d.h().g(str, i);
                    if (this.t.containsKey(g3)) {
                        return;
                    }
                    f fVar2 = new f(this);
                    fVar2.a = str;
                    fVar2.f30742b = i;
                    this.t.put(g3, fVar2);
                    return;
                }
                c.a.d.f.l.d.h().k(this.v, this.w, this.r0, i2, i3, this.r, new Object[0]);
            }
        }
    }

    public void I(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i c2 = j.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.r;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
            }
            H(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void J(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            G(str, i, 0, 0, z);
        }
    }

    public void K(String str, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            I(str, i, 0, 0, z, z2);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.z = true;
            A();
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.v)) {
            return;
        }
        c.a.d.f.l.d.h().d(this.v, this.w, this.r0);
        this.u.remove(c.a.d.f.l.d.h().g(this.v, this.w));
        N();
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.z = false;
            removeCallbacks(this);
            this.B = 0.0f;
            this.j0.reset();
            setExtraMatrix(this.j0);
            invalidate();
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.O && this.P) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 1) {
                    this.f23845d.f23854f = DrawerArgs.SkinType.NIGHT;
                } else if (skinType != 4) {
                    this.f23845d.f23854f = DrawerArgs.SkinType.DAY;
                } else {
                    this.f23845d.f23854f = DrawerArgs.SkinType.DARK;
                }
            } else {
                this.f23845d.f23854f = DrawerArgs.SkinType.DAY;
            }
            int i = this.z ? this.C : this.D;
            if (i != this.F) {
                this.F = i;
                this.f23849h = true;
            }
            int i2 = this.E;
            if (i2 > 0) {
                if (this.O) {
                    setDefaultBg(SkinManager.getDrawable(i2));
                } else {
                    setDefaultBg(getResources().getDrawable(this.E));
                }
            } else {
                setDefaultBg(null);
            }
            if (this.O) {
                this.k0.i(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            TbRichTextView.w wVar = this.V;
            if (wVar != null) {
                wVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void f(Canvas canvas, ImageView imageView) {
        DrawerArgs drawerArgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, canvas, imageView) == null) {
            super.f(canvas, imageView);
            if (this.k0 == null || (drawerArgs = this.f23845d) == null) {
                return;
            }
            if (drawerArgs.i && (this.G || w())) {
                this.k0.a(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f0897), true);
            } else if (this.f23845d.f23856h && x()) {
                this.k0.a(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f0898), true);
            } else {
                String str = this.l0;
                if (str != null) {
                    this.k0.a(canvas, str, false);
                }
            }
            int i = this.f23845d.j;
            if (i == c.a.d.h.a.b.f2441c) {
                this.k0.b(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f1567), R.color.CAM_X0305);
            } else if (i == c.a.d.h.a.b.f2440b) {
                this.k0.b(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f07bb), R.color.CAM_X0310);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.d.o.d.a getBdImage() {
        InterceptResult invokeV;
        c.a.d.o.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TextUtils.isEmpty(this.v)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    aVar = c.a.o0.b0.c.k().m(str);
                    if (aVar == null) {
                        aVar = c.a.o0.b0.c.k().l(str);
                    }
                } else {
                    aVar = null;
                }
            } else {
                aVar = (c.a.d.o.d.a) c.a.d.f.l.d.h().n(this.v, this.w, new Object[0]);
            }
            if (aVar != null) {
                E(aVar);
            }
            return aVar;
        }
        return (c.a.d.o.d.a) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public c.a.d.o.d.a getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<c.a.d.o.d.a> softReference;
        c.a.d.o.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (u0 == null) {
                u0 = new HashMap<>();
            }
            String valueOf = String.valueOf(this.F);
            if (this.O) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    valueOf = valueOf + SkinManager.nightSufix;
                } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    valueOf = valueOf + SkinManager.darkSuffix;
                }
            }
            if (this.Q != TbadkCoreApplication.getInst().getSkinType()) {
                this.f23849h = true;
                this.Q = TbadkCoreApplication.getInst().getSkinType();
            }
            if (!u0.containsKey(valueOf) || (softReference = u0.get(valueOf)) == null || (aVar = softReference.get()) == null || !aVar.w()) {
                Bitmap bitmap = null;
                int i = this.F;
                if (i > 0) {
                    if (this.O) {
                        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                            bitmap = BitmapHelper.getCashBitmap(this.F);
                        } else {
                            bitmap = SkinManager.getBitmap(this.F);
                            if (bitmap == null) {
                                bitmap = BitmapHelper.getCashBitmap(this.F);
                            }
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(i);
                    }
                }
                c.a.d.o.d.a aVar2 = new c.a.d.o.d.a(bitmap, false, String.valueOf(this.F));
                u0.put(valueOf, new SoftReference<>(aVar2));
                return aVar2;
            }
            return aVar;
        }
        return (c.a.d.o.d.a) invokeV.objValue;
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            c.a.o0.e1.c cVar = this.k0;
            if (cVar != null) {
                return (int) cVar.c(getContext().getString(R.string.obfuscated_res_0x7f0f0897));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            c.a.o0.e1.c cVar = this.k0;
            if (cVar != null) {
                return (int) cVar.d(getContext().getString(R.string.obfuscated_res_0x7f0f0897));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.p0 : invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.o0 : invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.T : (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            DrawerArgs drawerArgs = this.f23845d;
            return drawerArgs == null ? BDImageView.j(0.0f) : drawerArgs.a;
        }
        return (float[]) invokeV.objValue;
    }

    public float getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.M : invokeV.floatValue;
    }

    public float getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.L : invokeV.floatValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onAttachedToWindow();
            c.a.d.a.f<?> a2 = j.a(getContext());
            if (this.r != null) {
                this.s = true;
            }
            if (a2 != null) {
                CustomMessageListener customMessageListener = this.t0;
                BdUniqueId bdUniqueId = this.r;
                if (bdUniqueId == null) {
                    bdUniqueId = a2.getUniqueId();
                }
                customMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.t0);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            if (getBdImage() == null && getDrawable() == null && this.W) {
                L();
                c.a.d.f.l.d.h().k(this.v, this.w, this.r0, this.x, this.y, this.r, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.T;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.s = false;
            M();
            MessageManager.getInstance().unRegisterListener(this.t0);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, canvas) == null) {
            O();
            B(true, canvas);
            super.onDraw(canvas);
            C(canvas);
            D(canvas);
            B(false, canvas);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.x = getMeasuredWidth();
                this.y = getMeasuredHeight();
                Iterator<Map.Entry<String, f>> it = this.t.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, f> next = it.next();
                    next.getKey();
                    f value = next.getValue();
                    it.remove();
                    c.a.d.f.l.d.h().k(value.a, value.f30742b, this.r0, this.x, this.y, this.r, new Object[0]);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onStartTemporaryDetach();
            M();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i != 8 && i != 4) {
                refresh();
            } else {
                M();
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.m0 = i | this.m0;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            G(this.v, this.w, this.x, this.y, false);
            invalidate();
        }
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.z) {
            float f2 = this.B;
            float f3 = this.A;
            float f4 = f2 + f3;
            this.B = f4;
            if (f4 > 360.0f - f3) {
                this.B = 0.0f;
            }
            this.j0.reset();
            this.j0.postRotate(this.B, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.j0);
            invalidate();
            A();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.m0 = 0;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.O = z;
        }
    }

    public void setConrers(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.m0 = i;
        }
    }

    public void setDefaultBgResource(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i) == null) || this.E == i) {
            return;
        }
        this.E = i;
        invalidate();
    }

    public void setDefaultResource(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i) == null) || this.D == i) {
            return;
        }
        this.D = i;
        invalidate();
    }

    public void setDispatchTouchListener(TbRichTextView.w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, wVar) == null) {
            this.V = wVar;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            super.setDrawBorder(z);
        }
    }

    public void setDrawCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.n0 = z;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            super.setDrawerType(i);
            c.a.d.h.a.a aVar = this.f23846e;
            if (aVar == null) {
                return;
            }
            aVar.o(this.s0);
        }
    }

    public void setEvent(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, gVar) == null) {
            this.R = gVar;
        }
    }

    public void setInterceptOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.W = z;
        }
    }

    public void setIsBitmapPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.J = z;
        }
    }

    public void setIsGifPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.G = z;
        }
    }

    public void setIsLongPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.I = z;
        }
    }

    public void setIsSmartCrop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.K = z;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            if (this.q0 == null) {
                this.q0 = new c.a.p0.w2.j.c(new d(this));
            }
            super.setOnTouchListener(this.q0);
            if (!isClickable()) {
                setClickable(true);
            }
            this.T = onClickListener;
        }
    }

    public void setOnDrawListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, hVar) == null) {
            this.S = hVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            if (this.s || bdUniqueId == null) {
                return;
            }
            this.t0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.t0);
            this.s = true;
        }
    }

    public void setPlaceHolder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i == 0) {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f081200));
            } else if (i != 1) {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            } else {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
            }
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i == 0) {
                setDefaultBgResource(R.drawable.obfuscated_res_0x7f081200);
            } else if (i != 1) {
                setDefaultBgResource(R.drawable.pic_use_header_40_n);
            } else {
                setDefaultBgResource(R.drawable.pic_use_header_28_n);
            }
        }
    }

    public void setSmartCropCenterPointHeightRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f2) == null) {
            this.M = f2;
        }
    }

    public void setSmartCropCenterPointWidthRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f2) == null) {
            this.L = f2;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.N = z;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, obj) == null) {
            Object tag = getTag();
            super.setTag(obj);
            if (obj == null) {
                if (tag != null) {
                    this.f23849h = true;
                    requestLayout();
                }
            } else if (obj.equals(tag)) {
            } else {
                this.f23849h = true;
                requestLayout();
            }
        }
    }

    public void setTagColor(int i) {
        c.a.o0.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i) == null) || (cVar = this.k0) == null) {
            return;
        }
        cVar.g(i);
    }

    public void setTagPaddingDis(int i, int i2) {
        c.a.o0.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048640, this, i, i2) == null) || (cVar = this.k0) == null) {
            return;
        }
        cVar.f(i, i2);
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.l0 = str;
        }
    }

    public void setTagTextSize(int i) {
        c.a.o0.e1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i) == null) || (cVar = this.k0) == null) {
            return;
        }
        cVar.h(i);
    }

    public void setTbGestureDetector(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, cVar) == null) {
            if (this.q0 == null) {
                this.q0 = new c.a.p0.w2.j.c(new e(this));
            }
            super.setOnTouchListener(this.q0);
            this.U = cVar;
        }
    }

    public void setUseNightOrDarkMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.P = z;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048645, this) == null) || TextUtils.isEmpty(this.v)) {
            return;
        }
        c.a.d.f.l.d.h().d(this.v, this.w, this.r0);
        if (TextUtils.isEmpty(this.v) || y()) {
            N();
        }
    }

    public void u(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, canvas, drawable) == null) {
            canvas.save();
            this.h0.reset();
            this.g0.right = getWidth();
            this.g0.bottom = getHeight();
            this.h0.addRoundRect(this.g0, this.f23845d.a, Path.Direction.CW);
            int i = this.m0 ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i & 1) != 0) {
                Path path = this.h0;
                float[] fArr = this.f23845d.a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i & 2) != 0) {
                Path path2 = this.h0;
                float f2 = rectF.right;
                float[] fArr2 = this.f23845d.a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i & 4) != 0) {
                Path path3 = this.h0;
                float f3 = rectF.bottom;
                float[] fArr3 = this.f23845d.a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i & 8) != 0) {
                Path path4 = this.h0;
                float f4 = rectF.right;
                float[] fArr4 = this.f23845d.a;
                float f5 = rectF.bottom;
                path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
                canvas.clipPath(this.h0);
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.K : invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.s = false;
        this.w = 10;
        this.C = R.drawable.img_loading;
        this.D = R.color.transparent;
        this.E = R.color.CAM_X0205;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = true;
        this.P = true;
        this.Q = 3;
        this.g0 = new RectF();
        this.h0 = new Path();
        this.i0 = new RectF();
        this.j0 = new Matrix();
        this.n0 = false;
        this.o0 = 0;
        this.p0 = 0;
        this.r0 = new a(this);
        this.s0 = new b(this);
        this.t0 = new c(this, 2016308);
        v();
    }
}
