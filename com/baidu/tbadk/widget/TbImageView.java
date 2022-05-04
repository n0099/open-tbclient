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
import com.repackage.b9;
import com.repackage.dt7;
import com.repackage.e9;
import com.repackage.f9;
import com.repackage.fg;
import com.repackage.fo;
import com.repackage.h35;
import com.repackage.hg;
import com.repackage.ig;
import com.repackage.mi;
import com.repackage.pk;
import com.repackage.qk;
import com.repackage.td5;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, SoftReference<fo>> u0;
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
    public dt7 U;
    public TbRichTextView.w V;
    public boolean W;
    public RectF g0;
    public Path h0;
    public RectF i0;
    public final Matrix j0;
    public td5 k0;
    public String l0;
    public int m0;
    public boolean n0;
    public int o0;
    public int p0;
    public dt7 q0;
    public BdUniqueId r;
    public final hg<fo> r0;
    public boolean s;
    public pk.b s0;
    public HashMap<String, f> t;
    public CustomMessageListener t0;
    public HashMap<String, f> u;
    public String v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a extends hg<fo> {
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

        @Override // com.repackage.hg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.a.O();
                g gVar = this.a.R;
                if (gVar != null) {
                    gVar.onCancel();
                }
            }
        }

        @Override // com.repackage.hg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.hg
        public void onLoaded(fo foVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, foVar, str, i) == null) {
                if (foVar != null) {
                    this.a.o0 = foVar.r();
                    this.a.p0 = foVar.m();
                    ig h = ig.h();
                    TbImageView tbImageView = this.a;
                    String g = h.g(tbImageView.v, tbImageView.w);
                    f fVar = this.a.u.get(g);
                    if (fVar != null) {
                        fg.d(i == 1, i == 2, i == 3);
                        if (i == 3) {
                            fg.e(true, System.currentTimeMillis() - fVar.c);
                        }
                        this.a.u.remove(g);
                    }
                }
                this.a.O();
                this.a.F(foVar);
                g gVar = this.a.R;
                if (gVar != null) {
                    gVar.a(str, foVar != null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements pk.b {
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

        @Override // com.repackage.pk.b
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.a.getBdImage() == null && this.a.n0) {
                    this.a.v(canvas, drawable);
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
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
                ig h = ig.h();
                TbImageView tbImageView = this.a;
                String g = h.g(tbImageView.v, tbImageView.w);
                if (g == null || !g.equals(str)) {
                    return;
                }
                this.a.destroyDrawingCache();
                this.a.invalidate();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements dt7.a {
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

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.getBdImage() != null || this.a.getDrawable() != null || !this.a.W) {
                    if (this.a.T != null) {
                        this.a.T.onClick(view2);
                        return true;
                    } else if (this.a.U != null) {
                        this.a.U.a(view2);
                        return this.a.U.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.a.M();
                ig h = ig.h();
                TbImageView tbImageView = this.a;
                h.k(tbImageView.v, tbImageView.w, tbImageView.r0, tbImageView.x, tbImageView.y, tbImageView.r, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.U != null) {
                    this.a.U.a(view2);
                    return this.a.U.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements dt7.a {
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

        @Override // com.repackage.dt7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.getBdImage() != null || this.a.getDrawable() != null || !this.a.W) {
                    if (this.a.T != null) {
                        this.a.T.onClick(view2);
                        return true;
                    } else if (this.a.U != null) {
                        this.a.U.a(view2);
                        return this.a.U.onSingleTapConfirmed(motionEvent);
                    } else {
                        return false;
                    }
                }
                this.a.M();
                ig h = ig.h();
                TbImageView tbImageView = this.a;
                h.k(tbImageView.v, tbImageView.w, tbImageView.r0, tbImageView.x, tbImageView.y, tbImageView.r, new Object[0]);
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.dt7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (this.a.U != null) {
                    this.a.U.a(view2);
                    return this.a.U.onDoubleTap(motionEvent);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public long c;
        public final /* synthetic */ TbImageView d;

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
            this.d = tbImageView;
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes3.dex */
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
        w();
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.t = new HashMap<>();
            this.u = new HashMap<>();
            this.k0 = new td5(this);
            P();
            this.A = 30.0f;
            setConrers(0);
            pk pkVar = this.e;
            if (pkVar == null) {
                return;
            }
            pkVar.o(this.s0);
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.K : invokeV.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public final void C(boolean z, Canvas canvas) {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, canvas) == null) || (hVar = this.S) == null) {
            return;
        }
        if (z) {
            hVar.b(this, canvas);
        } else {
            hVar.a(this, canvas);
        }
    }

    public final void D(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            if (this.J || getBdImage() != null) {
                if (this.m0 != 0 || getDrawCorner()) {
                    setDrawerType(1);
                    int i = this.m0 ^ 15;
                    this.i0.set(0.0f, 0.0f, getWidth(), getHeight());
                    if ((i & 1) != 0) {
                        float[] fArr = this.d.a;
                        canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.e.b);
                    }
                    if ((i & 2) != 0) {
                        float f2 = this.i0.right;
                        float[] fArr2 = this.d.a;
                        canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.e.b);
                    }
                    if ((i & 4) != 0) {
                        float f3 = this.i0.bottom;
                        float[] fArr3 = this.d.a;
                        canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.e.b);
                    }
                    if ((i & 8) != 0) {
                        RectF rectF = this.i0;
                        float f4 = rectF.right;
                        float[] fArr4 = this.d.a;
                        float f5 = rectF.bottom;
                        canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.e.b);
                    }
                }
            }
        }
    }

    public final void E(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.J || getBdImage() != null) {
                if (this.m0 != 0 || getDrawBorder()) {
                    setDrawerType(1);
                    int i = this.m0 ^ 15;
                    this.i0.set(0.0f, 0.0f, getWidth(), getHeight());
                    this.e.c.setStrokeWidth(this.e.c.getStrokeWidth());
                    if ((i & 1) != 0) {
                        canvas.drawLine(0.0f, 0.0f, this.d.a[0], 0.0f, this.e.c);
                        canvas.drawLine(0.0f, 0.0f, 0.0f, this.d.a[1], this.e.c);
                    }
                    if ((i & 2) != 0) {
                        float f2 = this.i0.right;
                        canvas.drawLine(f2 - this.d.a[2], 0.0f, f2, 0.0f, this.e.c);
                        float f3 = this.i0.right;
                        canvas.drawLine(f3, 0.0f, f3, this.d.a[3], this.e.c);
                    }
                    if ((i & 4) != 0) {
                        float f4 = this.i0.bottom;
                        canvas.drawLine(0.0f, f4 - this.d.a[5], 0.0f, f4, this.e.c);
                        float f5 = this.i0.bottom;
                        canvas.drawLine(0.0f, f5, this.d.a[4], f5, this.e.c);
                    }
                    if ((i & 8) != 0) {
                        RectF rectF = this.i0;
                        float f6 = rectF.right;
                        float f7 = rectF.bottom;
                        canvas.drawLine(f6 - this.d.a[6], f7, f6, f7, this.e.c);
                        RectF rectF2 = this.i0;
                        float f8 = rectF2.right;
                        float f9 = rectF2.bottom;
                        canvas.drawLine(f8, f9, f8, f9 - this.d.a[7], this.e.c);
                    }
                }
            }
        }
    }

    public final void F(fo foVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, foVar) == null) || foVar == null) {
            return;
        }
        this.H = foVar.t();
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setTag(null);
            this.v = null;
            this.H = false;
            this.I = false;
            this.G = false;
        }
    }

    public void H(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            e9 c2 = f9.c(getContext());
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
            I(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void I(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
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
            fo bdImage = getBdImage();
            if (!z3) {
                u();
                this.h = true;
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
            this.h = true;
            if (!TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.x = i2;
                this.y = i3;
            }
            if (z2) {
                invalidate();
            } else if (!ig.h().j(this.w) && this.N) {
                invalidate();
            } else if (z3 && !mi.z()) {
                invalidate();
                g gVar2 = this.R;
                if (gVar2 != null) {
                    gVar2.a(str, false);
                }
            } else {
                if (z) {
                    M();
                }
                String g2 = ig.h().g(str, i);
                f fVar = new f(this);
                fVar.a = str;
                fVar.b = i;
                fVar.c = System.currentTimeMillis();
                this.u.put(g2, fVar);
                if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                    String g3 = ig.h().g(str, i);
                    if (this.t.containsKey(g3)) {
                        return;
                    }
                    f fVar2 = new f(this);
                    fVar2.a = str;
                    fVar2.b = i;
                    this.t.put(g3, fVar2);
                    return;
                }
                ig.h().k(this.v, this.w, this.r0, i2, i3, this.r, new Object[0]);
            }
        }
    }

    public void J(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            e9 c2 = f9.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.r;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
            }
            I(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void K(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            H(str, i, 0, 0, z);
        }
    }

    public void L(String str, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            J(str, i, 0, 0, z, z2);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.z = true;
            B();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || TextUtils.isEmpty(this.v)) {
            return;
        }
        ig.h().d(this.v, this.w, this.r0);
        this.u.remove(ig.h().g(this.v, this.w));
        O();
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.z = false;
            removeCallbacks(this);
            this.B = 0.0f;
            this.j0.reset();
            setExtraMatrix(this.j0);
            invalidate();
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.O && this.P) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (skinType == 1) {
                    this.d.f = DrawerArgs.SkinType.NIGHT;
                } else if (skinType != 4) {
                    this.d.f = DrawerArgs.SkinType.DAY;
                } else {
                    this.d.f = DrawerArgs.SkinType.DARK;
                }
            } else {
                this.d.f = DrawerArgs.SkinType.DAY;
            }
            int i = this.z ? this.C : this.D;
            if (i != this.F) {
                this.F = i;
                this.h = true;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeLL(1048593, this, canvas, imageView) == null) {
            super.f(canvas, imageView);
            if (this.k0 == null || (drawerArgs = this.d) == null) {
                return;
            }
            if (drawerArgs.i && (this.G || x())) {
                this.k0.a(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f0897), true);
            } else if (this.d.h && y()) {
                this.k0.a(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f0898), true);
            } else {
                String str = this.l0;
                if (str != null) {
                    this.k0.a(canvas, str, false);
                }
            }
            int i = this.d.j;
            if (i == qk.c) {
                this.k0.b(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f156e), R.color.CAM_X0305);
            } else if (i == qk.b) {
                this.k0.b(canvas, getContext().getString(R.string.obfuscated_res_0x7f0f07c0), R.color.CAM_X0310);
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public fo getBdImage() {
        InterceptResult invokeV;
        fo foVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (TextUtils.isEmpty(this.v)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    foVar = h35.k().m(str);
                    if (foVar == null) {
                        foVar = h35.k().l(str);
                    }
                } else {
                    foVar = null;
                }
            } else {
                foVar = (fo) ig.h().n(this.v, this.w, new Object[0]);
            }
            if (foVar != null) {
                F(foVar);
            }
            return foVar;
        }
        return (fo) invokeV.objValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public fo getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<fo> softReference;
        fo foVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
                this.h = true;
                this.Q = TbadkCoreApplication.getInst().getSkinType();
            }
            if (!u0.containsKey(valueOf) || (softReference = u0.get(valueOf)) == null || (foVar = softReference.get()) == null || !foVar.w()) {
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
                fo foVar2 = new fo(bitmap, false, String.valueOf(this.F));
                u0.put(valueOf, new SoftReference<>(foVar2));
                return foVar2;
            }
            return foVar;
        }
        return (fo) invokeV.objValue;
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            td5 td5Var = this.k0;
            if (td5Var != null) {
                return (int) td5Var.c(getContext().getString(R.string.obfuscated_res_0x7f0f0897));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            td5 td5Var = this.k0;
            if (td5Var != null) {
                return (int) td5Var.d(getContext().getString(R.string.obfuscated_res_0x7f0f0897));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.p0 : invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.o0 : invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.T : (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            DrawerArgs drawerArgs = this.d;
            return drawerArgs == null ? BDImageView.j(0.0f) : drawerArgs.a;
        }
        return (float[]) invokeV.objValue;
    }

    public float getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.M : invokeV.floatValue;
    }

    public float getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.L : invokeV.floatValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onAttachedToWindow();
            b9<?> a2 = f9.a(getContext());
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

    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, view2) == null) {
            if (getBdImage() == null && getDrawable() == null && this.W) {
                M();
                ig.h().k(this.v, this.w, this.r0, this.x, this.y, this.r, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.T;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.s = false;
            N();
            MessageManager.getInstance().unRegisterListener(this.t0);
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, canvas) == null) {
            P();
            C(true, canvas);
            super.onDraw(canvas);
            D(canvas);
            E(canvas);
            C(false, canvas);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.x = getMeasuredWidth();
                this.y = getMeasuredHeight();
                Iterator<Map.Entry<String, f>> it = this.t.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, f> next = it.next();
                    next.getKey();
                    f value = next.getValue();
                    it.remove();
                    ig.h().k(value.a, value.b, this.r0, this.x, this.y, this.r, new Object[0]);
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
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onStartTemporaryDetach();
            N();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i != 8 && i != 4) {
                refresh();
            } else {
                N();
            }
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            H(this.v, this.w, this.x, this.y, false);
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
            B();
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.m0 = i | this.m0;
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
            pk pkVar = this.e;
            if (pkVar == null) {
                return;
            }
            pkVar.o(this.s0);
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
                this.q0 = new dt7(new d(this));
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
                setDefaultBgResource(SkinManager.getResourceId(R.drawable.obfuscated_res_0x7f08120b));
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
                setDefaultBgResource(R.drawable.obfuscated_res_0x7f08120b);
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
                    this.h = true;
                    requestLayout();
                }
            } else if (obj.equals(tag)) {
            } else {
                this.h = true;
                requestLayout();
            }
        }
    }

    public void setTagColor(int i) {
        td5 td5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i) == null) || (td5Var = this.k0) == null) {
            return;
        }
        td5Var.g(i);
    }

    public void setTagPaddingDis(int i, int i2) {
        td5 td5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048640, this, i, i2) == null) || (td5Var = this.k0) == null) {
            return;
        }
        td5Var.f(i, i2);
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.l0 = str;
        }
    }

    public void setTagTextSize(int i) {
        td5 td5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048642, this, i) == null) || (td5Var = this.k0) == null) {
            return;
        }
        td5Var.h(i);
    }

    public void setTbGestureDetector(dt7 dt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, dt7Var) == null) {
            if (this.q0 == null) {
                this.q0 = new dt7(new e(this));
            }
            super.setOnTouchListener(this.q0);
            this.U = dt7Var;
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
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            this.m0 = 0;
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048646, this) == null) || TextUtils.isEmpty(this.v)) {
            return;
        }
        ig.h().d(this.v, this.w, this.r0);
        if (TextUtils.isEmpty(this.v) || z()) {
            O();
        }
    }

    public void v(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, canvas, drawable) == null) {
            canvas.save();
            this.h0.reset();
            this.g0.right = getWidth();
            this.g0.bottom = getHeight();
            this.h0.addRoundRect(this.g0, this.d.a, Path.Direction.CW);
            int i = this.m0 ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i & 1) != 0) {
                Path path = this.h0;
                float[] fArr = this.d.a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i & 2) != 0) {
                Path path2 = this.h0;
                float f2 = rectF.right;
                float[] fArr2 = this.d.a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i & 4) != 0) {
                Path path3 = this.h0;
                float f3 = rectF.bottom;
                float[] fArr3 = this.d.a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i & 8) != 0) {
                Path path4 = this.h0;
                float f4 = rectF.right;
                float[] fArr4 = this.d.a;
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

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.I : invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.z : invokeV.booleanValue;
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
        w();
    }
}
