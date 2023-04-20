package com.baidu.tbadk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.newwidget.ImageView.BDImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.switchs.ImageAddRequestLayoutSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a9;
import com.baidu.tieba.bg;
import com.baidu.tieba.cg;
import com.baidu.tieba.f9;
import com.baidu.tieba.g9;
import com.baidu.tieba.hs5;
import com.baidu.tieba.jk;
import com.baidu.tieba.kk;
import com.baidu.tieba.ku8;
import com.baidu.tieba.tm;
import com.baidu.tieba.zf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbImageView extends BDImageView implements Runnable, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, SoftReference<tm>> v0;
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
    public f R;
    public h S;
    public View.OnClickListener T;
    public ku8 U;
    public TbRichTextView.y V;
    public boolean W;
    public RectF a0;
    public Path b0;
    public RectF c0;
    public final Matrix d0;
    public hs5 e0;
    public String f0;
    public int g0;
    public boolean h0;
    public int i0;
    public int j0;
    public BdUniqueId r;
    public ku8 r0;
    public boolean s;
    public final bg<tm> s0;
    public HashMap<String, e> t;
    public jk.b t0;
    public HashMap<String, e> u;
    public CustomMessageListener u0;
    public String v;
    public int w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface f {
        void a(String str, boolean z);

        void onCancel();
    }

    /* loaded from: classes3.dex */
    public interface h {
        void a(TbImageView tbImageView, Canvas canvas);

        void b(TbImageView tbImageView, Canvas canvas);
    }

    /* loaded from: classes3.dex */
    public class a extends bg<tm> {
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

        @Override // com.baidu.tieba.bg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                this.a.R();
                f fVar = this.a.R;
                if (fVar != null) {
                    fVar.onCancel();
                }
            }
        }

        @Override // com.baidu.tieba.bg
        public void onProgressUpdate(Object... objArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, objArr) == null) {
                super.onProgressUpdate(objArr);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(tm tmVar, String str, int i) {
            boolean z;
            boolean z2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tmVar, str, i) == null) {
                boolean z4 = false;
                if (tmVar != null) {
                    this.a.i0 = tmVar.r();
                    this.a.j0 = tmVar.m();
                    cg h = cg.h();
                    TbImageView tbImageView = this.a;
                    String g = h.g(tbImageView.v, tbImageView.w);
                    e eVar = this.a.u.get(g);
                    if (eVar != null) {
                        if (i == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (i == 2) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (i == 3) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        zf.d(z, z2, z3);
                        if (i == 3) {
                            zf.e(true, System.currentTimeMillis() - eVar.c);
                        }
                        this.a.u.remove(g);
                    }
                }
                this.a.R();
                if (UbsABTestHelper.isImageCacheOptimize()) {
                    this.a.invalidate();
                }
                if (ImageAddRequestLayoutSwitch.isOn() && this.a.getWidth() * this.a.getHeight() == 0) {
                    this.a.requestLayout();
                }
                this.a.G(tmVar);
                f fVar = this.a.R;
                if (fVar != null) {
                    if (tmVar != null) {
                        z4 = true;
                    }
                    fVar.a(str, z4);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements jk.b {
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

        @Override // com.baidu.tieba.jk.b
        public boolean a(Canvas canvas, Drawable drawable) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, canvas, drawable)) == null) {
                if (this.a.getBdImage() != null || !this.a.h0) {
                    return false;
                }
                this.a.u(canvas, drawable);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ku8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        @Override // com.baidu.tieba.ku8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        public c(TbImageView tbImageView) {
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

        @Override // com.baidu.tieba.ku8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.getBdImage() == null && this.a.getDrawable() == null && this.a.W) {
                    this.a.P();
                    cg h = cg.h();
                    TbImageView tbImageView = this.a;
                    h.k(tbImageView.v, tbImageView.w, tbImageView.s0, tbImageView.x, tbImageView.y, tbImageView.r, new Object[0]);
                    return true;
                } else if (this.a.T != null) {
                    this.a.T.onClick(view2);
                    return true;
                } else if (this.a.U == null) {
                    return false;
                } else {
                    this.a.U.a(view2);
                    return this.a.U.onSingleTapConfirmed(motionEvent);
                }
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ku8.a
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
    public class d implements ku8.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbImageView a;

        @Override // com.baidu.tieba.ku8.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

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

        @Override // com.baidu.tieba.ku8.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.getBdImage() == null && this.a.getDrawable() == null && this.a.W) {
                    this.a.P();
                    cg h = cg.h();
                    TbImageView tbImageView = this.a;
                    h.k(tbImageView.v, tbImageView.w, tbImageView.s0, tbImageView.x, tbImageView.y, tbImageView.r, new Object[0]);
                    return true;
                } else if (this.a.T != null) {
                    this.a.T.onClick(view2);
                    return true;
                } else if (this.a.U == null) {
                    return false;
                } else {
                    this.a.U.a(view2);
                    return this.a.U.onSingleTapConfirmed(motionEvent);
                }
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.tieba.ku8.a
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
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public int b;
        public long c;
        public final /* synthetic */ TbImageView d;

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
            this.d = tbImageView;
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<TbImageView> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(TbImageView tbImageView, int i) {
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
            this.a = new WeakReference<>(tbImageView);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbImageView tbImageView;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String) || (tbImageView = this.a.get()) == null) {
                return;
            }
            String str = tbImageView.v;
            int i = tbImageView.w;
            String str2 = (String) customResponsedMessage.getData();
            String g = cg.h().g(str, i);
            if (g != null && g.equals(str2)) {
                tbImageView.destroyDrawingCache();
                tbImageView.invalidate();
            }
        }
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
        this.a0 = new RectF();
        this.b0 = new Path();
        this.c0 = new RectF();
        this.d0 = new Matrix();
        this.h0 = false;
        this.i0 = 0;
        this.j0 = 0;
        this.s0 = new a(this);
        this.t0 = new b(this);
        this.u0 = new g(this, 2016308);
        x();
    }

    public final void E(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (!this.J && getBdImage() == null) {
                return;
            }
            if (this.g0 == 0 && !getDrawCorner()) {
                return;
            }
            setDrawerType(1);
            int i = this.g0 ^ 15;
            this.c0.set(0.0f, 0.0f, getWidth(), getHeight());
            if ((i & 1) != 0) {
                float[] fArr = this.d.a;
                canvas.drawRect(0.0f, 0.0f, fArr[0], fArr[1], this.e.c);
            }
            if ((i & 2) != 0) {
                float f2 = this.c0.right;
                float[] fArr2 = this.d.a;
                canvas.drawRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], this.e.c);
            }
            if ((i & 4) != 0) {
                float f3 = this.c0.bottom;
                float[] fArr3 = this.d.a;
                canvas.drawRect(0.0f, f3 - fArr3[5], fArr3[4], f3, this.e.c);
            }
            if ((i & 8) != 0) {
                RectF rectF = this.c0;
                float f4 = rectF.right;
                float[] fArr4 = this.d.a;
                float f5 = rectF.bottom;
                canvas.drawRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, this.e.c);
            }
        }
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
        this.a0 = new RectF();
        this.b0 = new Path();
        this.c0 = new RectF();
        this.d0 = new Matrix();
        this.h0 = false;
        this.i0 = 0;
        this.j0 = 0;
        this.s0 = new a(this);
        this.t0 = new b(this);
        this.u0 = new g(this, 2016308);
        x();
    }

    public final void D(boolean z, Canvas canvas) {
        h hVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZL(1048579, this, z, canvas) != null) || (hVar = this.S) == null) {
            return;
        }
        if (z) {
            hVar.b(this, canvas);
        } else {
            hVar.a(this, canvas);
        }
    }

    public void setTagPaddingDis(int i, int i2) {
        hs5 hs5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048645, this, i, i2) == null) && (hs5Var = this.e0) != null) {
            hs5Var.f(i, i2);
        }
    }

    public final void G(tm tmVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, tmVar) != null) || tmVar == null) {
            return;
        }
        this.H = tmVar.t();
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            J(str, 10, 0, 0, false);
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            TbRichTextView.y yVar = this.V;
            if (yVar != null) {
                yVar.dispatchTouchEvent(motionEvent);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, canvas) == null) {
            S();
            D(true, canvas);
            super.onDraw(canvas);
            E(canvas);
            F(canvas);
            D(false, canvas);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            super.onWindowVisibilityChanged(i);
            if (i != 8 && i != 4) {
                refresh();
            } else {
                Q();
            }
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.g0 = i | this.g0;
        }
    }

    public void setAutoChangeStyle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z) == null) {
            this.O = z;
        }
    }

    public void setConrers(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.g0 = i;
        }
    }

    public void setContentColorFilter(ColorFilter colorFilter) {
        jk jkVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, colorFilter) == null) && (jkVar = this.e) != null) {
            jkVar.n(colorFilter);
        }
    }

    public void setDefaultBgResource(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048622, this, i) == null) && this.E != i) {
            this.E = i;
            invalidate();
        }
    }

    public void setDefaultResource(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048623, this, i) == null) && this.D != i) {
            this.D = i;
            invalidate();
        }
    }

    public void setDispatchTouchListener(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, yVar) == null) {
            this.V = yVar;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawBorder(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            super.setDrawBorder(z);
        }
    }

    public void setDrawCorner(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
            this.h0 = z;
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void setDrawerType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i) == null) {
            super.setDrawerType(i);
            jk jkVar = this.e;
            if (jkVar == null) {
                return;
            }
            jkVar.q(this.t0);
        }
    }

    public void setEvent(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, fVar) == null) {
            this.R = fVar;
        }
    }

    public void setInterceptOnClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.W = z;
        }
    }

    public void setIsBitmapPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.J = z;
        }
    }

    public void setIsGifPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.G = z;
        }
    }

    public void setIsLongPic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.I = z;
        }
    }

    public void setIsSmartCrop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.K = z;
        }
    }

    public void setNeedNightShade(boolean z) {
        jk jkVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048634, this, z) == null) && (jkVar = this.e) != null) {
            jkVar.p(z);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, onClickListener) == null) {
            if (this.r0 == null) {
                this.r0 = new ku8(new c(this));
            }
            super.setOnTouchListener(this.r0);
            if (!isClickable()) {
                setClickable(true);
            }
            this.T = onClickListener;
        }
    }

    public void setOnDrawListener(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, hVar) == null) {
            this.S = hVar;
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bdUniqueId) == null) {
            this.r = bdUniqueId;
            if (!this.s && bdUniqueId != null) {
                this.u0.setTag(bdUniqueId);
                MessageManager.getInstance().registerListener(this.u0);
                this.s = true;
            }
        }
    }

    public void setSmartCropCenterPointHeightRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048640, this, f2) == null) {
            this.M = f2;
        }
    }

    public void setSmartCropCenterPointWidthRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048641, this, f2) == null) {
            this.L = f2;
        }
    }

    public void setSupportNoImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.N = z;
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, obj) == null) {
            Object tag = getTag();
            super.setTag(obj);
            if (obj == null) {
                if (tag != null) {
                    this.h = true;
                    requestLayout();
                }
            } else if (!obj.equals(tag)) {
                this.h = true;
                requestLayout();
            }
        }
    }

    public void setTagColor(int i) {
        hs5 hs5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048644, this, i) == null) && (hs5Var = this.e0) != null) {
            hs5Var.g(i);
        }
    }

    public void setTagStr(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
            this.f0 = str;
        }
    }

    public void setTagTextSize(int i) {
        hs5 hs5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048647, this, i) == null) && (hs5Var = this.e0) != null) {
            hs5Var.h(i);
        }
    }

    public void setTbGestureDetector(ku8 ku8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, ku8Var) == null) {
            if (this.r0 == null) {
                this.r0 = new ku8(new d(this));
            }
            super.setOnTouchListener(this.r0);
            this.U = ku8Var;
        }
    }

    public void setUseNightOrDarkMask(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048649, this, z) == null) {
            this.P = z;
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.t = new HashMap<>();
            this.u = new HashMap<>();
            this.e0 = new hs5(this);
            S();
            this.A = 30.0f;
            setConrers(0);
            jk jkVar = this.e;
            if (jkVar == null) {
                return;
            }
            jkVar.q(this.t0);
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || TextUtils.isEmpty(this.v)) {
            return;
        }
        cg.h().d(this.v, this.w, this.s0);
        this.u.remove(cg.h().g(this.v, this.w));
        R();
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (UbsABTestHelper.isImageCacheOptimize() && !this.z) {
                return;
            }
            this.z = false;
            removeCallbacks(this);
            this.B = 0.0f;
            this.d0.reset();
            setExtraMatrix(this.d0);
            if (!UbsABTestHelper.isImageCacheOptimize()) {
                invalidate();
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            super.onAttachedToWindow();
            a9<?> a2 = g9.a(getContext());
            if (this.r != null) {
                this.s = true;
            }
            if (a2 != null) {
                CustomMessageListener customMessageListener = this.u0;
                BdUniqueId bdUniqueId = this.r;
                if (bdUniqueId == null) {
                    bdUniqueId = a2.getUniqueId();
                }
                customMessageListener.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.u0);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeOnPreDrawListener(this);
            this.s = false;
            if (!UbsABTestHelper.isImageNotCancel()) {
                Q();
            } else {
                R();
            }
            MessageManager.getInstance().unRegisterListener(this.u0);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048650, this) != null) || TextUtils.isEmpty(this.v)) {
            return;
        }
        cg.h().d(this.v, this.w, this.s0);
        if (TextUtils.isEmpty(this.v) || A()) {
            R();
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.K;
        }
        return invokeV.booleanValue;
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeCallbacks(this);
            postDelayed(this, 150L);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            setTag(null);
            this.v = null;
            this.H = false;
            this.I = false;
            this.G = false;
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.z = true;
            C();
        }
    }

    public boolean getDrawCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.h0;
        }
        return invokeV.booleanValue;
    }

    public int getGifIconHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            hs5 hs5Var = this.e0;
            if (hs5Var != null) {
                return (int) hs5Var.c(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getGifIconWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            hs5 hs5Var = this.e0;
            if (hs5Var != null) {
                return (int) hs5Var.d(getContext().getString(R.string.icon_tag_gif));
            }
            return -1;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.j0;
        }
        return invokeV.intValue;
    }

    @Deprecated
    public int getLoadedWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.i0;
        }
        return invokeV.intValue;
    }

    public View.OnClickListener getOnClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.T;
        }
        return (View.OnClickListener) invokeV.objValue;
    }

    public float[] getRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            DrawerArgs drawerArgs = this.d;
            if (drawerArgs == null) {
                return BDImageView.j(0.0f);
            }
            return drawerArgs.a;
        }
        return (float[]) invokeV.objValue;
    }

    public float getSmartCropCenterPointHeightRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.M;
        }
        return invokeV.floatValue;
    }

    public float getSmartCropCenterPointWidthRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.L;
        }
        return invokeV.floatValue;
    }

    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onStartTemporaryDetach();
            Q();
        }
    }

    public void refresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            J(this.v, this.w, this.x, this.y, false);
            invalidate();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.g0 = 0;
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.I;
        }
        return invokeV.booleanValue;
    }

    public final void F(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            if (!this.J && getBdImage() == null) {
                return;
            }
            if (this.g0 == 0 && !getDrawBorder()) {
                return;
            }
            setDrawerType(1);
            int i = this.g0 ^ 15;
            this.c0.set(0.0f, 0.0f, getWidth(), getHeight());
            this.e.d.setStrokeWidth(this.e.d.getStrokeWidth());
            if ((i & 1) != 0) {
                canvas.drawLine(0.0f, 0.0f, this.d.a[0], 0.0f, this.e.d);
                canvas.drawLine(0.0f, 0.0f, 0.0f, this.d.a[1], this.e.d);
            }
            if ((i & 2) != 0) {
                float f2 = this.c0.right;
                canvas.drawLine(f2 - this.d.a[2], 0.0f, f2, 0.0f, this.e.d);
                float f3 = this.c0.right;
                canvas.drawLine(f3, 0.0f, f3, this.d.a[3], this.e.d);
            }
            if ((i & 4) != 0) {
                float f4 = this.c0.bottom;
                canvas.drawLine(0.0f, f4 - this.d.a[5], 0.0f, f4, this.e.d);
                float f5 = this.c0.bottom;
                canvas.drawLine(0.0f, f5, this.d.a[4], f5, this.e.d);
            }
            if ((i & 8) != 0) {
                RectF rectF = this.c0;
                float f6 = rectF.right;
                float f7 = rectF.bottom;
                canvas.drawLine(f6 - this.d.a[6], f7, f6, f7, this.e.d);
                RectF rectF2 = this.c0;
                float f8 = rectF2.right;
                float f9 = rectF2.bottom;
                canvas.drawLine(f8, f9, f8, f9 - this.d.a[7], this.e.d);
            }
        }
    }

    public void J(String str, int i, int i2, int i3, boolean z) {
        BdUniqueId bdUniqueId;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            f9 c2 = g9.c(getContext());
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
            K(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void K(String str, int i, int i2, int i3, boolean z, BdUniqueId bdUniqueId, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), bdUniqueId, Boolean.valueOf(z2)}) == null) {
            if (TextUtils.isEmpty(str)) {
                this.v = str;
                int i4 = this.Q;
                if (i4 != 3 && i4 != TbadkCoreApplication.getInst().getSkinType()) {
                    invalidate();
                    return;
                }
                return;
            }
            if (str.equals(this.v) && i == this.w && bdUniqueId == this.r) {
                z3 = true;
            } else {
                z3 = false;
            }
            tm bdImage = getBdImage();
            if (!z3) {
                t();
                this.h = true;
                this.H = false;
                requestLayout();
            } else if (bdImage != null) {
                invalidate();
                this.i0 = bdImage.r();
                this.j0 = bdImage.m();
                f fVar = this.R;
                if (fVar != null) {
                    fVar.a(str, true);
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
            } else if (!cg.h().j(this.w) && this.N) {
                invalidate();
            } else if (!UbsABTestHelper.isImageCacheOptimize() && z3 && !BdNetTypeUtil.isNetWorkAvailable()) {
                invalidate();
                f fVar2 = this.R;
                if (fVar2 != null) {
                    fVar2.a(str, false);
                }
            } else {
                if (z) {
                    P();
                }
                String g2 = cg.h().g(str, i);
                e eVar = new e(this);
                eVar.a = str;
                eVar.b = i;
                eVar.c = System.currentTimeMillis();
                this.u.put(g2, eVar);
                if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                    String g3 = cg.h().g(str, i);
                    if (!this.t.containsKey(g3)) {
                        e eVar2 = new e(this);
                        eVar2.a = str;
                        eVar2.b = i;
                        this.t.put(g3, eVar2);
                        return;
                    }
                    return;
                }
                cg.h().k(this.v, this.w, this.s0, i2, i3, this.r, new Object[0]);
            }
        }
    }

    public void M(String str, int i, int i2, int i3, boolean z, boolean z2) {
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            f9 c2 = g9.c(getContext());
            if (c2 != null) {
                BdUniqueId bdUniqueId2 = this.r;
                if (bdUniqueId2 == null) {
                    bdUniqueId2 = c2.getUniqueId();
                }
                bdUniqueId = bdUniqueId2;
            } else {
                bdUniqueId = null;
            }
            K(str, i, i2, i3, z, bdUniqueId, z2);
        }
    }

    public void N(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            J(str, i, 0, 0, z);
        }
    }

    public void O(String str, int i, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            M(str, i, 0, 0, z, z2);
        }
    }

    public final void S() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (this.O && this.P) {
                if (TbadkCoreApplication.getInst().getSkinType() != 4) {
                    this.d.f = DrawerArgs.SkinType.DAY;
                } else {
                    this.d.f = DrawerArgs.SkinType.DARK;
                }
            } else {
                this.d.f = DrawerArgs.SkinType.DAY;
            }
            if (this.z) {
                i = this.C;
            } else {
                i = this.D;
            }
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
                this.e0.i(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (TbadkCoreApplication.getInst().isPicReqSwitchOn()) {
                this.x = getMeasuredWidth();
                this.y = getMeasuredHeight();
                Iterator<Map.Entry<String, e>> it = this.t.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, e> next = it.next();
                    next.getKey();
                    e value = next.getValue();
                    it.remove();
                    cg.h().k(value.a, value.b, this.s0, this.x, this.y, this.r, new Object[0]);
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public void f(Canvas canvas, ImageView imageView) {
        DrawerArgs drawerArgs;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, canvas, imageView) == null) {
            super.f(canvas, imageView);
            if (this.e0 != null && (drawerArgs = this.d) != null) {
                if (drawerArgs.i && (this.G || y())) {
                    this.e0.a(canvas, getContext().getString(R.string.icon_tag_gif), true);
                } else if (this.d.h && z()) {
                    this.e0.a(canvas, getContext().getString(R.string.icon_tag_long), true);
                } else {
                    String str = this.f0;
                    if (str != null) {
                        this.e0.a(canvas, str, false);
                    }
                }
                int i = this.d.j;
                if (i == kk.c) {
                    this.e0.b(canvas, getContext().getString(R.string.wonderful_comment), R.color.CAM_X0305);
                } else if (i == kk.b) {
                    this.e0.b(canvas, getContext().getString(R.string.god_level_comment), R.color.CAM_X0310);
                }
            }
        }
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public tm getBdImage() {
        InterceptResult invokeV;
        tm tmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (TextUtils.isEmpty(this.v)) {
                Object tag = getTag();
                if (tag instanceof String) {
                    String str = (String) tag;
                    tmVar = TbImageMemoryCache.s().w(str);
                    if (tmVar == null) {
                        tmVar = TbImageMemoryCache.s().t(str);
                    }
                } else {
                    tmVar = null;
                }
            } else {
                tmVar = (tm) cg.h().n(this.v, this.w, new Object[0]);
            }
            if (tmVar != null) {
                G(tmVar);
            }
            return tmVar;
        }
        return (tm) invokeV.objValue;
    }

    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || !this.z) {
            return;
        }
        float f2 = this.B;
        float f3 = this.A;
        float f4 = f2 + f3;
        this.B = f4;
        if (f4 > 360.0f - f3) {
            this.B = 0.0f;
        }
        this.d0.reset();
        this.d0.postRotate(this.B, getWidth() / 2.0f, getHeight() / 2.0f);
        setExtraMatrix(this.d0);
        invalidate();
        C();
    }

    @Override // com.baidu.adp.newwidget.ImageView.BDImageView
    public tm getDefaultBdImage() {
        InterceptResult invokeV;
        SoftReference<tm> softReference;
        tm tmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (v0 == null) {
                v0 = new HashMap<>();
            }
            String valueOf = String.valueOf(this.F);
            if (this.O && TbadkCoreApplication.getInst().getSkinType() == 4) {
                valueOf = valueOf + SkinManager.darkSuffix;
            }
            if (this.Q != TbadkCoreApplication.getInst().getSkinType()) {
                this.h = true;
                this.Q = TbadkCoreApplication.getInst().getSkinType();
            }
            if (v0.containsKey(valueOf) && (softReference = v0.get(valueOf)) != null && (tmVar = softReference.get()) != null && tmVar.w()) {
                return tmVar;
            }
            Bitmap bitmap = null;
            int i = this.F;
            if (i > 0) {
                if (this.O) {
                    if (TbadkCoreApplication.getInst().getSkinType() == 4) {
                        int i2 = this.F;
                        if (i2 == R.color.transparent) {
                            bitmap = SkinManager.getTbDefaultBitmap();
                        } else {
                            bitmap = SkinManager.getBitmap(i2);
                        }
                        if (bitmap == null) {
                            bitmap = BitmapHelper.getCashBitmap(this.F);
                        }
                    } else {
                        bitmap = BitmapHelper.getCashBitmap(this.F);
                    }
                } else {
                    bitmap = BitmapHelper.getCashBitmap(i);
                }
            }
            tm tmVar2 = new tm(bitmap, false, String.valueOf(this.F));
            v0.put(valueOf, new SoftReference<>(tmVar2));
            return tmVar2;
        }
        return (tm) invokeV.objValue;
    }

    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, view2) == null) {
            if (getBdImage() == null && getDrawable() == null && this.W) {
                P();
                cg.h().k(this.v, this.w, this.s0, this.x, this.y, this.r, new Object[0]);
                return;
            }
            View.OnClickListener onClickListener = this.T;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }

    public void setPlaceHolder(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i != 0) {
                if (i != 1) {
                    setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_40_n));
                    return;
                } else {
                    setDefaultBgResource(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
                    return;
                }
            }
            setDefaultBgResource(SkinManager.getResourceId(R.drawable.transparent_bg));
        }
    }

    public void setPlaceHolderAutoChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            setDefaultResource(SkinManager.getColor(R.color.CAM_X0202));
            if (i != 0) {
                if (i != 1) {
                    setDefaultBgResource(R.drawable.pic_use_header_40_n);
                    return;
                } else {
                    setDefaultBgResource(R.drawable.pic_use_header_28_n);
                    return;
                }
            }
            setDefaultBgResource(R.drawable.transparent_bg);
        }
    }

    public void u(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048651, this, canvas, drawable) == null) {
            canvas.save();
            this.b0.reset();
            this.a0.right = getWidth();
            this.a0.bottom = getHeight();
            this.b0.addRoundRect(this.a0, this.d.a, Path.Direction.CW);
            int i = this.g0 ^ 15;
            RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
            if ((i & 1) != 0) {
                Path path = this.b0;
                float[] fArr = this.d.a;
                path.addRect(0.0f, 0.0f, fArr[0], fArr[1], Path.Direction.CW);
            }
            if ((i & 2) != 0) {
                Path path2 = this.b0;
                float f2 = rectF.right;
                float[] fArr2 = this.d.a;
                path2.addRect(f2 - fArr2[2], 0.0f, f2, fArr2[3], Path.Direction.CW);
            }
            if ((i & 4) != 0) {
                Path path3 = this.b0;
                float f3 = rectF.bottom;
                float[] fArr3 = this.d.a;
                path3.addRect(0.0f, f3 - fArr3[5], fArr3[4], f3, Path.Direction.CW);
            }
            if ((i & 8) != 0) {
                Path path4 = this.b0;
                float f4 = rectF.right;
                float[] fArr4 = this.d.a;
                float f5 = rectF.bottom;
                path4.addRect(f4 - fArr4[6], f5 - fArr4[7], f4, f5, Path.Direction.CW);
            }
            if (!canvas.isHardwareAccelerated() || !UtilHelper.isHuaWeiU9508Device()) {
                canvas.clipPath(this.b0);
            }
            drawable.draw(canvas);
            canvas.restore();
        }
    }
}
