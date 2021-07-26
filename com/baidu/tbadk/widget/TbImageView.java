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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.newwidget.ImageView.BDImageView;
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
import d.a.d.a.i;
import d.a.d.a.j;
import d.a.d.f.a.a;
import d.a.q0.h2.i.c;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, SoftReference<d.a.d.k.d.a>> w0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public float E;
    public float F;
    public final int G;
    public int H;
    public int I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public float P;
    public float Q;
    public boolean R;
    public boolean S;
    public int T;
    public f U;
    public g V;
    public View.OnClickListener W;
    public d.a.q0.h2.i.c a0;
    public TbRichTextView.x b0;
    public boolean c0;
    public RectF i0;
    public Path j0;
    public RectF k0;
    public final Matrix l0;
    public d.a.p0.d1.c m0;
    public String n0;
    public int o0;
    public boolean p0;
    public int q0;
    public int r0;
    public final d.a.q0.h2.i.c s0;
    public final d.a.d.e.l.c<d.a.d.k.d.a> t0;
    public a.InterfaceC0565a u0;
    public BdUniqueId v;
    public CustomMessageListener v0;
    public boolean w;
    public HashMap<String, e> x;
    public HashMap<String, e> y;
    public String z;

    /* loaded from: classes3.dex */
    public class a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f13335a;

        public a(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13335a = tbImageView;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f13335a.getBdImage() != null || this.f13335a.getDrawable() != null || !this.f13335a.c0) {
                    if (this.f13335a.W != null) {
                        this.f13335a.W.onClick(view);
                        return true;
                    } else if (this.f13335a.a0 != null) {
                        this.f13335a.a0.a(view);
                        return this.f13335a.a0.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.f13335a.O();
                d.a.d.e.l.d h2 = d.a.d.e.l.d.h();
                TbImageView tbImageView = this.f13335a;
                h2.k(tbImageView.z, tbImageView.A, tbImageView.t0, tbImageView.B, tbImageView.C, tbImageView.v, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (this.f13335a.a0 != null) {
                    this.f13335a.a0.a(view);
                    return this.f13335a.a0.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.a.d.e.l.c<d.a.d.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f13336a;

        public b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13336a = tbImageView;
        }

        @Override // d.a.d.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.f13336a.Q();
                f fVar = this.f13336a.U;
                if (fVar != null) {
                    fVar.onCancel();
                }
            }
        }

        @Override // d.a.d.e.l.c
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.l.c
        public void onLoaded(d.a.d.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                if (aVar != null) {
                    this.f13336a.q0 = aVar.r();
                    this.f13336a.r0 = aVar.m();
                    d.a.d.e.l.d h2 = d.a.d.e.l.d.h();
                    TbImageView tbImageView = this.f13336a;
                    String g2 = h2.g(tbImageView.z, tbImageView.A);
                    e eVar = this.f13336a.y.get(g2);
                    if (eVar != null) {
                        d.a.d.e.l.a.d(i2 == 1, i2 == 2, i2 == 3);
                        if (i2 == 3) {
                            d.a.d.e.l.a.e(true, System.currentTimeMillis() - eVar.f13341c);
                        }
                        this.f13336a.y.remove(g2);
                    }
                }
                this.f13336a.Q();
                this.f13336a.H(aVar);
                f fVar = this.f13336a.U;
                if (fVar != null) {
                    fVar.a(str, aVar != null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC0565a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f13337a;

        public c(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13337a = tbImageView;
        }

        @Override // d.a.d.f.a.a.InterfaceC0565a
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.f13337a.getBdImage() == null && this.f13337a.p0) {
                    this.f13337a.u(canvas, drawable);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TbImageView f13338a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TbImageView tbImageView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13338a = tbImageView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                d.a.d.e.l.d h2 = d.a.d.e.l.d.h();
                TbImageView tbImageView = this.f13338a;
                String g2 = h2.g(tbImageView.z, tbImageView.A);
                if (g2 == null || !g2.equals(str)) {
                    return;
                }
                this.f13338a.destroyDrawingCache();
                this.f13338a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f13339a;

        /* renamed from: b  reason: collision with root package name */
        public int f13340b;

        /* renamed from: c  reason: collision with root package name */
        public long f13341c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TbImageView f13342d;

        public e(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13342d = tbImageView;
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface g {
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = false;
        this.A = 10;
        this.G = R.drawable.img_loading;
        this.H = R.color.transparent;
        this.I = R.color.CAM_X0205;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = false;
        this.S = true;
        this.T = 3;
        this.i0 = new RectF();
        this.j0 = new Path();
        this.k0 = new RectF();
        this.l0 = new Matrix();
        this.p0 = false;
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = new d.a.q0.h2.i.c(new a(this));
        this.t0 = new b(this);
        this.u0 = new c(this);
        this.v0 = new d(this, 2016308);
        v();
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.x = new HashMap<>();
            this.y = new HashMap<>();
            this.m0 = new d.a.p0.d1.c(this);
            R();
            this.E = 30.0f;
            setConrers(0);
            d.a.d.f.a.a aVar = this.f2229i;
            if (aVar == null) {
                return;
            }
            aVar.o(this.u0);
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
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, canvas) == null) || (gVar = this.V) == null) {
            return;
        }
        if (z) {
            gVar.b(this, canvas);
        } else {
            gVar.a(this, canvas);
        }
    }

    public final void F(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.N || getBdImage() != null) {
                if (this.o0 != 0 || getDrawCorner()) {
                    setDrawerType(1);
                    int i2 = this.o0 ^ 15;
                    this.k0.set(0.0f, 0.0f, getWidth(), getHeight());
                    if ((i2 & 1) != 0) {
                        float[] fArr = this.f2228h.f42106a;
                        canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.f2229i.f42092b);
                    }
                    if ((i2 & 2) != 0) {
                        float f2 = this.k0.right;
                        float[] fArr2 = this.f2228h.f42106a;
                        canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.f2229i.f42092b);
                    }
                    if ((i2 & 4) != 0) {
                        float f3 = this.k0.bottom;
                        float[] fArr3 = this.f2228h.f42106a;
                        canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.f2229i.f42092b);
                    }
                    if ((i2 & 8) != 0) {
                        RectF rectF = this.k0;
                        float f4 = rectF.right;
                        float[] fArr4 = this.f2228h.f42106a;
                        float f5 = rectF.bottom;
                        canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.f2229i.f42092b);
                    }
                }
            }
        }
    }

    public final void G(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.N || getBdImage() != null) {
                if (this.o0 != 0 || getDrawBorder()) {
                    setDrawerType(1);
                    int i2 = this.o0 ^ 15;
                    this.k0.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.f2229i.f42093c.setStrokeWidth(this.f2229i.f42093c.getStrokeWidth());
                    if ((i2 & 1) != 0) {
                        canvas.drawLine(0.0f, 0.0f, this.f2228h.f42106a[0], 0.0f, this.f2229i.f42093c);
                        canvas.drawLine(0.0f, 0.0f, 0.0f, this.f2228h.f42106a[1], this.f2229i.f42093c);
                    }
                    if ((i2 & 2) != 0) {
                        float f2 = this.k0.right;
                        canvas.drawLine(f2 - this.f2228h.f42106a[2], 0.0f, f2, 0.0f, this.f2229i.f42093c);
                        float f3 = this.k0.right;
                        canvas.drawLine(f3, 0.0f, f3, this.f2228h.f42106a[3], this.f2229i.f42093c);
                    }
                    if ((i2 & 4) != 0) {
                        float f4 = this.k0.bottom;
                        canvas.drawLine(0.0f, f4 - this.f2228h.f42106a[5], 0.0f, f4, this.f2229i.f42093c);
                        float f5 = this.k0.bottom;
                        canvas.drawLine(0.0f, f5, this.f2228h.f42106a[4], f5, this.f2229i.f42093c);
                    }
                    if ((i2 & 8) != 0) {
                        RectF rectF = this.k0;
                        float f6 = rectF.right;
                        float f7 = rectF.bottom;
                        canvas.drawLine(f6 - this.f2228h.f42106a[6], f7, f6, f7, this.f2229i.f42093c);
                        RectF rectF2 = this.k0;
                        float f8 = rectF2.right;
                        float f9 = rectF2.bottom;
                        canvas.drawLine(f8, f9, f8, f9 - this.f2228h.f42106a[7], this.f2229i.f42093c);
                    }
                }
            }
        }
    }

    public final void H(d.a.d.k.d.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        this.L = aVar.t();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            setTag(null);
            this.z = null;
            this.L = false;
            this.M = false;
            this.K = false;
        }
    }

    public void J(String str, int i2, int i3, int i4, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)}) == null) {
            i c2 = j.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.v;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                z2 = c2.isScroll();
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
                z2 = false;
            }
            K(str, i2, i3, i4, z, bdUniqueId, z2);
        }
    }

    public void K(String str, int i2, int i3, int i4, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
            if (TextUtils.isEmpty(str)) {
                this.z = str;
                int i5 = this.T;
                if (i5 == 3 || i5 == TbadkCoreApplication.getInst().getSkinType()) {
                    return;
                }
                invalidate();
                return;
            }
            boolean z3 = str.equals(this.z) && i2 == this.A && bdUniqueId == this.v;
            d.a.d.k.d.a bdImage = getBdImage();
            if (!z3) {
                t();
                this.l = true;
                this.L = false;
                requestLayout();
            } else if (bdImage != null) {
                invalidate();
                this.q0 = bdImage.r();
                this.r0 = bdImage.m();
                f fVar = this.U;
                if (fVar != null) {
                    fVar.a(str, true);
                    return;
                }
                return;
            }
            this.z = str;
            this.A = i2;
            this.v = bdUniqueId;
            this.l = true;
            if (!TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.B = i3;
                this.C = i4;
            }
            if (z2) {
                invalidate();
            } else if (!d.a.d.e.l.d.h().j(this.A) && this.R) {
                invalidate();
            } else if (z3 && !d.a.d.e.p.j.z()) {
                invalidate();
                f fVar2 = this.U;
                if (fVar2 != null) {
                    fVar2.a(str, false);
                }
            } else {
                if (z) {
                    O();
                }
                String g2 = d.a.d.e.l.d.h().g(str, i2);
                e eVar = new e(this);
                eVar.f13339a = str;
                eVar.f13340b = i2;
                eVar.f13341c = System.currentTimeMillis();
                this.y.put(g2, eVar);
                if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                    String g3 = d.a.d.e.l.d.h().g(str, i2);
                    if (this.x.containsKey(g3)) {
                        return;
                    }
                    e eVar2 = new e(this);
                    eVar2.f13339a = str;
                    eVar2.f13340b = i2;
                    this.x.put(g3, eVar2);
                    return;
                }
                d.a.d.e.l.d.h().k(this.z, this.A, this.t0, i3, i4, this.v, new Object[0]);
            }
        }
    }

    public void L(String str, int i2, int i3, int i4, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            i c2 = j.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.v;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
            }
            K(str, i2, i3, i4, z, bdUniqueId, z2);
        }
    }

    public void M(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            J(str, i2, 0, 0, z);
        }
    }

    public void N(String str, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            L(str, i2, 0, 0, z, z2);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.D = true;
            A();
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || TextUtils.isEmpty(this.z)) {
            return;
        }
        d.a.d.e.l.d.h().d(this.z, this.A, this.t0);
        this.y.remove(d.a.d.e.l.d.h().g(this.z, this.A));
        Q();
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.D = false;
            removeCallbacks(this);
            this.F = 0.0f;
            this.l0.reset();
            setExtraMatrix(this.l0);
            invalidate();
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            boolean z = false;
            if (this.S) {
                this.f2228h.f42111f = (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) ? true : true;
            } else {
                this.f2228h.f42111f = false;
            }
            int i2 = this.D ? this.G : this.H;
            if (i2 != this.J) {
                this.J = i2;
                this.l = true;
            }
            int i3 = this.I;
            if (i3 > 0) {
                if (this.S) {
                    setDefaultBg(SkinManager.getDrawable(i3));
                } else {
                    setDefaultBg(getResources().getDrawable(this.I));
                }
            } else {
                setDefaultBg(null);
            }
            if (this.S) {
                this.m0.j(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            TbRichTextView.x xVar = this.b0;
            if (xVar != null) {
                xVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void f(Canvas canvas, ImageView imageView) {
        d.a.d.f.a.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, canvas, imageView) == null) {
            super.f(canvas, imageView);
            if (this.m0 == null || (eVar = this.f2228h) == null) {
                return;
            }
            if (eVar.f42114i && (this.K || w())) {
                this.m0.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
            } else if (this.f2228h.f42113h && x()) {
                this.m0.a(canvas, getContext().getString(R.string.icon_tag_long), true);
            } else {
                String str = this.n0;
                if (str != null) {
                    this.m0.a(canvas, str, false);
                }
            }
            int i2 = this.f2228h.j;
            if (i2 == d.a.d.f.a.b.f42102c) {
                this.m0.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
            } else if (i2 == d.a.d.f.a.b.f42101b) {
                this.m0.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.d.k.d.a getBdImage() {
        InterceptResult invokeV;
        d.a.d.k.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (TextUtils.isEmpty(this.z)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    aVar = d.a.p0.b0.c.k().m(str);
                    if (aVar == null) {
                        aVar = d.a.p0.b0.c.k().l(str);
                    }
                } else {
                    aVar = null;
                }
            } else {
                aVar = (d.a.d.k.d.a) d.a.d.e.l.d.h().n(this.z, this.A, new Object[0]);
            }
            if (aVar != null) {
                H(aVar);
            }
            return aVar;
        }
        return (d.a.d.k.d.a) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public d.a.d.k.d.a getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<d.a.d.k.d.a> softReference;
        d.a.d.k.d.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (w0 == null) {
                w0 = new HashMap<>();
            }
            String valueOf = String.valueOf(this.J);
            if (this.S) {
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    valueOf = valueOf + SkinManager.nightSufix;
                } else if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                    valueOf = valueOf + SkinManager.darkSuffix;
                }
            }
            if (this.T != TbadkCoreApplication.getInst().getSkinType()) {
                this.l = true;
                this.T = TbadkCoreApplication.getInst().getSkinType();
            }
            if (!w0.containsKey(valueOf) || (softReference = w0.get(valueOf)) == null || (aVar = softReference.get()) == null || !aVar.w()) {
                Bitmap bitmap = null;
                int i2 = this.J;
                if (i2 > 0) {
                    if (this.S) {
                        if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                            bitmap = BitmapHelper.getCashBitmap(this.J);
                        } else {
                            bitmap = SkinManager.getBitmap(this.J);
                            if (bitmap == null) {
                                bitmap = BitmapHelper.getCashBitmap(this.J);
                            }
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(i2);
                    }
                }
                d.a.d.k.d.a aVar2 = new d.a.d.k.d.a(bitmap, false, String.valueOf(this.J));
                w0.put(valueOf, new SoftReference<>(aVar2));
                return aVar2;
            }
            return aVar;
        }
        return (d.a.d.k.d.a) invokeV.objValue;
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.p0 : invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            d.a.p0.d1.c cVar = this.m0;
            if (cVar != null) {
                return (int) cVar.d(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            d.a.p0.d1.c cVar = this.m0;
            if (cVar != null) {
                return (int) cVar.e(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.r0 : invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.q0 : invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.W : (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            d.a.d.f.a.e eVar = this.f2228h;
            return eVar == null ? BDImageView.j(0.0f) : eVar.f42106a;
        }
        return (float[]) invokeV.objValue;
    }

    public float getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.Q : invokeV.floatValue;
    }

    public float getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.P : invokeV.floatValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            super.onAttachedToWindow();
            d.a.d.a.f<?> a2 = j.a(getContext());
            if (this.v != null) {
                this.w = true;
            }
            if (a2 != null) {
                CustomMessageListener customMessageListener = this.v0;
                BdUniqueId bdUniqueId = this.v;
                if (bdUniqueId == null) {
                    bdUniqueId = a2.getUniqueId();
                }
                customMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.v0);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, view) == null) {
            if (getBdImage() == null && getDrawable() == null && this.c0) {
                O();
                d.a.d.e.l.d.h().k(this.z, this.A, this.t0, this.B, this.C, this.v, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.W;
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
            this.w = false;
            P();
            MessageManager.getInstance().unRegisterListener(this.v0);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, canvas) == null) {
            R();
            B(true, canvas);
            super.onDraw(canvas);
            F(canvas);
            G(canvas);
            B(false, canvas);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.B = getMeasuredWidth();
                this.C = getMeasuredHeight();
                Iterator<Map.Entry<String, e>> it = this.x.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, e> next = it.next();
                    next.getKey();
                    e value = next.getValue();
                    it.remove();
                    d.a.d.e.l.d.h().k(value.f13339a, value.f13340b, this.t0, this.B, this.C, this.v, new Object[0]);
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
            P();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            super.onWindowVisibilityChanged(i2);
            if (i2 != 8 && i2 != 4) {
                refresh();
            } else {
                P();
            }
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
            this.o0 = i2 | this.o0;
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            J(this.z, this.A, this.B, this.C, false);
            invalidate();
        }
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && this.D) {
            float f2 = this.F;
            float f3 = this.E;
            float f4 = f2 + f3;
            this.F = f4;
            if (f4 > 360.0f - f3) {
                this.F = 0.0f;
            }
            this.l0.reset();
            this.l0.postRotate(this.F, getWidth() / 2.0f, getHeight() / 2.0f);
            setExtraMatrix(this.l0);
            invalidate();
            A();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.o0 = 0;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z) == null) {
            this.S = z;
        }
    }

    public void setConrers(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.o0 = i2;
        }
    }

    public void setDefaultBgResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || this.I == i2) {
            return;
        }
        this.I = i2;
        invalidate();
    }

    public void setDefaultResource(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048619, this, i2) == null) || this.H == i2) {
            return;
        }
        this.H = i2;
        invalidate();
    }

    public void setDispatchTouchListener(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, xVar) == null) {
            this.b0 = xVar;
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
            this.p0 = z;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            super.setDrawerType(i2);
            d.a.d.f.a.a aVar = this.f2229i;
            if (aVar == null) {
                return;
            }
            aVar.o(this.u0);
        }
    }

    public void setEvent(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, fVar) == null) {
            this.U = fVar;
        }
    }

    public void setInterceptOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.c0 = z;
        }
    }

    public void setIsBitmapPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.N = z;
        }
    }

    public void setIsGifPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.K = z;
        }
    }

    public void setIsLongPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.M = z;
        }
    }

    public void setIsSmartCrop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.O = z;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, onClickListener) == null) {
            super.setOnTouchListener(this.s0);
            if (!isClickable()) {
                setClickable(true);
            }
            this.W = onClickListener;
        }
    }

    public void setOnDrawListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, gVar) == null) {
            this.V = gVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bdUniqueId) == null) {
            this.v = bdUniqueId;
            if (this.w || bdUniqueId == null) {
                return;
            }
            this.v0.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.v0);
            this.w = true;
        }
    }

    public void setPlaceHolder(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i2 == 0) {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.transparent_bg));
            } else if (i2 != 1) {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
            } else {
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
            }
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i2 == 0) {
                setDefaultBgResource(R.drawable.transparent_bg);
            } else if (i2 != 1) {
                setDefaultBgResource(R.drawable.pic_use_header_40_n);
            } else {
                setDefaultBgResource(R.drawable.pic_use_header_28_n);
            }
        }
    }

    public void setSmartCropCenterPointHeightRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048635, this, f2) == null) {
            this.Q = f2;
        }
    }

    public void setSmartCropCenterPointWidthRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048636, this, f2) == null) {
            this.P = f2;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.R = z;
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
                    this.l = true;
                    requestLayout();
                }
            } else if (obj.equals(tag)) {
            } else {
                this.l = true;
                requestLayout();
            }
        }
    }

    public void setTagColor(int i2) {
        d.a.p0.d1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i2) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.h(i2);
    }

    public void setTagPaddingDis(int i2, int i3) {
        d.a.p0.d1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048640, this, i2, i3) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.g(i2, i3);
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.n0 = str;
        }
    }

    public void setTagTextSize(int i2) {
        d.a.p0.d1.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i2) == null) || (cVar = this.m0) == null) {
            return;
        }
        cVar.i(i2);
    }

    public void setTbGestureDetector(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, cVar) == null) {
            super.setOnTouchListener(this.s0);
            this.a0 = cVar;
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048644, this) == null) || TextUtils.isEmpty(this.z)) {
            return;
        }
        d.a.d.e.l.d.h().d(this.z, this.A, this.t0);
        if (TextUtils.isEmpty(this.z) || y()) {
            Q();
        }
    }

    public void u(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048645, this, canvas, drawable) == null) {
            canvas.save();
            this.j0.reset();
            this.i0.right = getWidth();
            this.i0.bottom = getHeight();
            this.j0.addRoundRect(this.i0, this.f2228h.f42106a, Path.Direction.CW);
            int i2 = this.o0 ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i2 & 1) != 0) {
                Path path = this.j0;
                float[] fArr = this.f2228h.f42106a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i2 & 2) != 0) {
                Path path2 = this.j0;
                float f2 = rectF.right;
                float[] fArr2 = this.f2228h.f42106a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i2 & 4) != 0) {
                Path path3 = this.j0;
                float f3 = rectF.bottom;
                float[] fArr3 = this.f2228h.f42106a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i2 & 8) != 0) {
                Path path4 = this.j0;
                float f4 = rectF.right;
                float[] fArr4 = this.f2228h.f42106a;
                float f5 = rectF.bottom;
                path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
                canvas.clipPath(this.j0);
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.L : invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.O : invokeV.booleanValue;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TbImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.w = false;
        this.A = 10;
        this.G = R.drawable.img_loading;
        this.H = R.color.transparent;
        this.I = R.color.CAM_X0205;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.R = false;
        this.S = true;
        this.T = 3;
        this.i0 = new RectF();
        this.j0 = new Path();
        this.k0 = new RectF();
        this.l0 = new Matrix();
        this.p0 = false;
        this.q0 = 0;
        this.r0 = 0;
        this.s0 = new d.a.q0.h2.i.c(new a(this));
        this.t0 = new b(this);
        this.u0 = new c(this);
        this.v0 = new d(this, 2016308);
        v();
    }
}
