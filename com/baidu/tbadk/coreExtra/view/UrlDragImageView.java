package com.baidu.tbadk.coreExtra.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.r.t.a;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StorageFile;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes5.dex */
public class UrlDragImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final String n0;
    public static long o0;
    public static final int p0;
    public static final int q0;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect A;
    public Rect B;
    public DragImageView.h C;
    public String D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public ImageUrlData J;
    public boolean K;
    public boolean L;
    public boolean M;
    public c.a.o0.c0.b N;
    public int O;
    public int P;
    public p Q;
    public View.OnTouchListener R;
    public boolean S;
    public float T;
    public View.OnClickListener U;
    public View.OnLongClickListener V;
    public String W;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public Context f30433b;

    /* renamed from: c  reason: collision with root package name */
    public ProgressBar f30434c;

    /* renamed from: d  reason: collision with root package name */
    public DragImageView f30435d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f30436e;

    /* renamed from: f  reason: collision with root package name */
    public SubsamplingScaleImageView f30437f;

    /* renamed from: g  reason: collision with root package name */
    public SubsamplingScaleImageView.OnImageEventListener f30438g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public o f30439h;
    public CircleProgressView h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public boolean j0;
    public boolean k;
    public Runnable k0;
    public boolean l;
    public Runnable l0;
    public boolean m;
    public View.OnTouchListener m0;
    public float n;
    public float o;
    public boolean p;
    public boolean q;
    public Bitmap r;
    public boolean s;
    public float t;
    public float u;
    public final Matrix v;
    public Rect w;
    public RectF x;
    public RectF y;
    public Rect z;

    /* loaded from: classes5.dex */
    public class a implements c.a.o0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public a(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.o0.b0.b
        public void a(c.a.d.o.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                this.a.k = true;
                this.a.f30434c.setVisibility(8);
                this.a.W = null;
                UrlDragImageView urlDragImageView = this.a;
                DragImageView dragImageView = urlDragImageView.f30435d;
                if (dragImageView == null || dragImageView.q0) {
                    return;
                }
                urlDragImageView.M(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.o0.e1.i.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public b(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.o0.e1.i.b.a
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f30434c.setVisibility(8);
                this.a.W = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f30440b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f30441c;

        public c(UrlDragImageView urlDragImageView, c.a.o0.r.t.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30441c = urlDragImageView;
            this.a = aVar;
            this.f30440b = str;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
                this.f30441c.c0(this.f30440b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.o0.r.t.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f30442b;

        public d(UrlDragImageView urlDragImageView, c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30442b = urlDragImageView;
            this.a = aVar;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.o0.v.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public e(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.o0.v.e
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                this.a.h0.setVisibility(8);
                this.a.L = false;
                BdToast c2 = BdToast.c(this.a.f30433b, str);
                c2.a();
                c2.q();
                this.a.J.originalProcess = -1;
                this.a.b0();
            }
        }

        @Override // c.a.o0.v.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.h0.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(this.a.l0, 1500L);
                this.a.L = false;
                UrlDragImageView urlDragImageView = this.a;
                urlDragImageView.K = urlDragImageView.E();
                this.a.F();
            }
        }

        @Override // c.a.o0.v.e
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.o0.v.e
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
                return;
            }
            if (this.a.J != null && this.a.J.originalProcess != -1) {
                this.a.J.originalProcess = downloadData.getProcess();
            }
            if (this.a.J == null || this.a.J.originalProcess != -1) {
                this.a.h0.setProgress(downloadData.getProcess());
            }
        }

        @Override // c.a.o0.v.e
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public f(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        /* loaded from: classes5.dex */
        public class a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    this.a.a.h0.setVisibility(8);
                    this.a.a.W = null;
                    this.a.a.M = false;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }
        }

        public g(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements DragImageView.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragImageView.k a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f30443b;

        public h(UrlDragImageView urlDragImageView, DragImageView.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30443b = urlDragImageView;
            this.a = kVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                DragImageView.k kVar = this.a;
                if (kVar != null) {
                    kVar.a(dragImageView, z, z2);
                }
                this.f30443b.a0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Rect a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Rect f30444b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f30445c;

        public i(UrlDragImageView urlDragImageView, Rect rect, Rect rect2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, rect, rect2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30445c = urlDragImageView;
            this.a = rect;
            this.f30444b = rect2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null || this.a == null || this.f30444b == null) {
                return;
            }
            this.f30445c.A(valueAnimator.getAnimatedFraction());
            this.f30445c.B(this.f30444b, valueAnimator.getAnimatedFraction(), this.f30445c.j0);
            this.f30445c.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public j(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.s = false;
                this.a.invalidate();
                if (this.a.C != null) {
                    this.a.C.b();
                }
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
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public k(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.a.R != null) {
                    this.a.R.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements SubsamplingScaleImageView.OnImageEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f30446b;

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PointF f30447b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ l f30448c;

            public a(l lVar, float f2, PointF pointF) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Float.valueOf(f2), pointF};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f30448c = lVar;
                this.a = f2;
                this.f30447b = pointF;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
                if (r5 != 3) goto L14;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                    if (this.f30448c.f30446b.R != null) {
                        this.f30448c.f30446b.R.onTouch(view, motionEvent);
                    }
                    int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                    if (action == 0) {
                        this.f30448c.f30446b.T = motionEvent.getY();
                        UrlDragImageView urlDragImageView = this.f30448c.f30446b;
                        urlDragImageView.f30437f.setOnClickListener(urlDragImageView.S ? this.f30448c.f30446b.U : null);
                        UrlDragImageView urlDragImageView2 = this.f30448c.f30446b;
                        urlDragImageView2.f30437f.setOnLongClickListener(urlDragImageView2.S ? this.f30448c.f30446b.V : null);
                    } else {
                        if (action != 1) {
                            if (action == 2) {
                                if (Math.abs(motionEvent.getY() - this.f30448c.f30446b.T) > UrlDragImageView.q0) {
                                    this.f30448c.f30446b.S = false;
                                    this.f30448c.f30446b.f30437f.setOnClickListener(null);
                                    this.f30448c.f30446b.f30437f.setOnLongClickListener(null);
                                }
                                this.f30448c.f30446b.T = motionEvent.getY();
                            }
                        }
                        float scale = this.f30448c.f30446b.f30437f.getScale();
                        float f2 = this.a;
                        if (scale < f2) {
                            this.f30448c.f30446b.f30437f.setScaleAndCenter(f2, this.f30447b);
                        }
                        c.a.d.f.m.e.a().removeCallbacks(this.f30448c.f30446b.k0);
                        c.a.d.f.m.e.a().postDelayed(this.f30448c.f30446b.k0, 1000L);
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }
        }

        public l(UrlDragImageView urlDragImageView, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30446b = urlDragImageView;
            this.a = iArr;
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f30446b.J.isLongPic && this.a[0] > 0) {
                this.f30446b.f30435d.c0();
                float measuredWidth = (this.f30446b.getMeasuredWidth() * 1.0f) / this.a[0];
                PointF pointF = new PointF((this.a[0] * 1.0f) / 2.0f, 0.0f);
                this.f30446b.f30437f.setScaleAndCenter(measuredWidth, pointF);
                float f2 = 2.0f * measuredWidth;
                this.f30446b.f30437f.setMaxScale(f2);
                this.f30446b.f30437f.setDoubleTapZoomScale(f2);
                this.f30446b.f30437f.setInitScale(measuredWidth);
                this.f30446b.f30437f.setDoubleTapZoomStyle(4);
                this.f30446b.f30437f.setOnTouchListener(new a(this, measuredWidth, pointF));
                this.f30446b.f30435d.setVisibility(4);
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f30446b.W = null;
                this.f30446b.f30434c.setVisibility(8);
                this.f30446b.f30435d.p0();
                this.f30446b.f30435d.setVisibility(4);
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements c.a.o0.e1.i.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public m(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.o0.e1.i.b.a
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends c.a.d.f.l.c<c.a.d.o.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        public n(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.d.f.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.l = false;
                this.a.f30435d.setVisibility(0);
                this.a.f30434c.setVisibility(8);
                this.a.W = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i) == null) {
                this.a.l = false;
                this.a.k = true;
                UrlDragImageView urlDragImageView = this.a;
                DragImageView dragImageView = urlDragImageView.f30435d;
                if (dragImageView == null || dragImageView.q0) {
                    return;
                }
                urlDragImageView.M(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface o {
        void a(String str, byte[] bArr);
    }

    /* loaded from: classes5.dex */
    public interface p {
        void a();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1559183147, "Lcom/baidu/tbadk/coreExtra/view/UrlDragImageView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1559183147, "Lcom/baidu/tbadk/coreExtra/view/UrlDragImageView;");
                return;
            }
        }
        n0 = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ce5);
        o0 = 52428800L;
        p0 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst()) / 5;
        q0 = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlDragImageView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f30434c = null;
        this.f30435d = null;
        this.f30439h = null;
        this.i = false;
        this.l = false;
        this.s = false;
        this.t = 1.0f;
        this.u = 0.0f;
        this.v = new Matrix();
        this.x = new RectF();
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 1.0f;
        this.H = 1.0f;
        this.I = 0.0f;
        this.K = false;
        this.L = false;
        this.M = false;
        this.S = true;
        this.T = 0.0f;
        this.U = null;
        this.V = null;
        this.W = null;
        this.k0 = new f(this);
        this.l0 = new g(this);
        this.m0 = new k(this);
        this.f30433b = context;
        this.N = new c.a.o0.c0.b();
        N();
    }

    private void setThumbBitmapToView(c.a.d.o.d.a aVar) {
        Bitmap p2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, aVar) == null) || this.k || aVar == null || (p2 = aVar.p()) == null) {
            return;
        }
        this.j = true;
        if (aVar.t()) {
            this.f30435d.setImageUrlData(this.J);
            this.f30435d.setImageBitmap(p2);
            this.W = null;
            this.M = false;
        } else {
            ImageUrlData imageUrlData = this.J;
            if (imageUrlData != null && imageUrlData.isLongPic) {
                this.f30435d.T();
                this.f30435d.setImageLoadCallBack(new m(this));
            }
            this.f30435d.setImageUrlData(this.J);
            this.f30435d.setImageData(p2, aVar.k());
        }
        a0();
    }

    public final void A(float f2) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (rect = this.A) == null) {
            return;
        }
        Rect rect2 = this.B;
        rect.left = (int) (rect2.left + (rect2.width() * this.E * f2));
        Rect rect3 = this.A;
        Rect rect4 = this.B;
        rect3.top = (int) (rect4.top + (rect4.height() * this.F * f2));
        Rect rect5 = this.A;
        Rect rect6 = this.B;
        float f3 = this.G;
        float f4 = 1.0f - f2;
        rect5.right = (int) (rect6.left + (rect6.width() * (((1.0f - f3) * f4) + f3)));
        Rect rect7 = this.A;
        Rect rect8 = this.B;
        float f5 = this.H;
        rect7.bottom = (int) (rect8.top + (rect8.height() * (((1.0f - f5) * f4) + f5)));
    }

    public final void B(Rect rect, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rect, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            int f3 = z ? c.a.d.f.p.n.f(getContext(), R.dimen.tbds80) : 0;
            RectF rectF = this.x;
            if (rectF == null || rect == null) {
                return;
            }
            RectF rectF2 = this.y;
            float f4 = rectF2.left;
            rectF.left = f4 + ((rect.left - f4) * f2);
            float f5 = rectF2.top;
            rectF.top = (f5 + ((rect.top - f5) * f2)) - f3;
            float f6 = rectF2.right;
            rectF.right = f6 + ((rect.right - f6) * f2);
            float f7 = rectF2.bottom;
            rectF.bottom = f7 + ((rect.bottom - f7) * f2);
        }
    }

    public final void C(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rect, rect2) == null) {
            this.E = 0.0f;
            this.F = 0.0f;
            this.G = 1.0f;
            this.H = 1.0f;
            if (rect == null || rect2 == null || !rect.contains(rect2)) {
                return;
            }
            this.E = (rect2.left - rect.left) / rect.width();
            this.F = (rect2.top - rect.top) / rect.height();
            this.G = (rect2.right - rect.left) / rect.width();
            this.H = (rect2.bottom - rect.top) / rect.height();
        }
    }

    public void D(boolean z, boolean z2) {
        DragImageView dragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (dragImageView = this.f30435d) == null || (str = (String) dragImageView.getTag()) == null) {
            return;
        }
        if (this.f30435d.getImageType() == 1) {
            if (this.f30435d.getGifCache() == null || !this.f30435d.Z()) {
                U(str, z, z2);
            }
        } else if (this.f30435d.getImageType() == 2) {
            U(str, z, z2);
        } else if (S()) {
            U(str, z, z2);
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageUrlData imageUrlData = this.J;
            if (imageUrlData != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.J;
                if (imageUrlData2.originalSize >= 0 && !imageUrlData2.isBlockedPic) {
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    if (new File(this.D + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + nameMd5FromUrl).exists()) {
                        this.J.originalProcess = 100;
                        return true;
                    }
                    int i2 = this.J.originalProcess;
                    if (i2 < 0) {
                        b0();
                    } else {
                        this.h0.setProgress(i2);
                    }
                    this.M = true;
                    return false;
                }
            }
            this.W = null;
            return false;
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G(false);
        }
    }

    public final boolean G(boolean z) {
        InterceptResult invokeZ;
        ImageUrlData imageUrlData;
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (!this.L || z) {
                this.L = true;
                if (this.K && (imageUrlData = this.J) != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                    ImageUrlData imageUrlData2 = this.J;
                    if (imageUrlData2.originalSize >= 0 && Build.VERSION.SDK_INT >= 10) {
                        String str = this.D + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        this.f30437f.setVisibility(0);
                        if (this.f30438g == null) {
                            this.f30438g = new l(this, imageFileWH);
                        }
                        this.f30437f.setOnImageEventListener(this.f30438g);
                        if (this.f30437f.isImageLoaded() && this.J.isLongPic) {
                            this.f30438g.onImageLoaded();
                        } else {
                            this.f30437f.setImage(ImageSource.uri(str));
                        }
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.J == null || P()) {
            return;
        }
        ImageUrlData imageUrlData = this.J;
        String str = imageUrlData.imageUrl;
        int i2 = imageUrlData.urlType;
        c.a.d.o.d.a loadBdImageFromLocal = AbstractImageLoaderProc.isImageFileExist(str, i2) ? AbstractImageLoaderProc.loadBdImageFromLocal(str, i2) : null;
        if (loadBdImageFromLocal != null) {
            setThumbBitmapToView(loadBdImageFromLocal);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(this.J.originalUrl);
            if (this.J.originalProcess >= 0) {
                c.a.o0.v.f.k().f(nameMd5FromUrl, 13);
                this.J.originalProcess = -1;
                b0();
                return;
            }
            p pVar = this.Q;
            if (pVar != null) {
                pVar.a();
            }
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(this.f30433b);
            if (a2 == null) {
                c0(nameMd5FromUrl);
            } else if (c.a.d.f.p.l.z() && !c.a.d.f.p.l.H() && !c.a.o0.r.j0.b.k().h("original_img_down_tip", false)) {
                c.a.o0.r.j0.b.k().u("original_img_down_tip", true);
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(a2.getPageActivity());
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f0ce4);
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f025c, new c(this, aVar, nameMd5FromUrl));
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new d(this, aVar));
                aVar.create(a2);
                aVar.show();
            } else {
                c0(nameMd5FromUrl);
            }
        }
    }

    public final boolean J(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f30437f.getVisibility() != 0 || this.f30437f.isCanDrag()) {
                ImageUrlData imageUrlData = this.J;
                if (imageUrlData == null || !imageUrlData.isLongPic || this.f30437f.getVisibility() != 0 || this.f30437f.isViewTop()) {
                    ImageUrlData imageUrlData2 = this.J;
                    if (imageUrlData2 == null || !imageUrlData2.isLongPic || this.f30437f.getVisibility() == 0 || this.f30435d.Y() || this.f30435d.a0()) {
                        if (this.f30437f.getVisibility() == 0 || this.f30435d.f0()) {
                            if (this.r != null && getScrollY() == 0) {
                                ImageUrlData imageUrlData3 = this.J;
                                boolean z = (imageUrlData3 == null || !imageUrlData3.isLongPic) && ((f3 < -15.0f && !this.s) || (f3 > 15.0f && !this.s));
                                ImageUrlData imageUrlData4 = this.J;
                                boolean z2 = imageUrlData4 != null && imageUrlData4.isLongPic && f3 < 0.0f && !this.s;
                                if (z || (z2 && this.f30435d.b0())) {
                                    this.f30435d.setImageOnLongClickListener(null);
                                    this.f30437f.setOnLongClickListener(null);
                                    this.s = true;
                                    this.u = 0.0f;
                                    this.t = 1.0f;
                                    DragImageView.h hVar = this.C;
                                    if (hVar != null) {
                                        hVar.a();
                                    }
                                }
                            }
                            if (!this.s || this.r == null) {
                                return false;
                            }
                            this.u -= f3;
                            float measuredHeight = getMeasuredHeight();
                            if (this.u > measuredHeight) {
                                this.u = measuredHeight;
                            }
                            float f4 = f3 / measuredHeight;
                            Matrix matrix = this.v;
                            float f5 = this.t;
                            matrix.postTranslate((-f2) * 1.5f * f5, f3 * (-1.5f) * f5);
                            if (this.t * (f4 + 1.0f) > 1.0f || this.u < 0.0f) {
                                f4 = -f4;
                            }
                            float f6 = f4 + 1.0f;
                            this.v.preScale(f6, f6, (this.t * this.r.getWidth()) / 2.0f, this.t * (this.r.getHeight() / 2));
                            this.t *= f6;
                            invalidate();
                            return true;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final void K(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, rect) == null) || rect == null) {
            return;
        }
        float f2 = (rect.bottom - rect.top) / (rect.right - rect.left);
        RectF rectF = this.x;
        float f3 = f2 * (rectF.right - rectF.left);
        rectF.top += rectF.height() * this.I;
        RectF rectF2 = this.x;
        rectF2.bottom = rectF2.top + f3;
    }

    public final RectF L(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 / 2.0f;
            float f7 = f5 / 2.0f;
            return new RectF(f2 - f6, f3 - f7, f2 + f6, f3 + f7);
        }
        return (RectF) invokeCommon.objValue;
    }

    public final void M(c.a.d.o.d.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            if (aVar != null && (oVar = this.f30439h) != null) {
                oVar.a(aVar.q(), aVar.k());
            }
            if (aVar != null && aVar.p() != null) {
                Bitmap p2 = aVar.p();
                this.f30435d.setLoadBigImage(true);
                if (aVar.t()) {
                    this.f30435d.setGifData(aVar.k(), p2);
                    this.f30435d.invalidate();
                    this.f30435d.h0();
                    this.M = false;
                    this.W = null;
                    this.f30434c.setVisibility(8);
                } else {
                    ImageUrlData imageUrlData = this.J;
                    if (imageUrlData != null && imageUrlData.isLongPic) {
                        this.f30435d.T();
                        this.f30435d.setImageLoadCallBack(new b(this));
                    } else {
                        this.f30434c.setVisibility(8);
                        this.W = null;
                    }
                    this.f30435d.setImageUrlData(this.J);
                    this.f30435d.setImageData(p2, aVar.k());
                    b0();
                }
                a0();
                return;
            }
            Z();
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.D = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
            this.O = c.a.d.f.p.n.k(this.f30433b);
            this.P = c.a.d.f.p.n.i(this.f30433b) - ((int) this.f30433b.getResources().getDimension(R.dimen.obfuscated_res_0x7f07024e));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            DragImageView dragImageView = new DragImageView(this.f30433b);
            this.f30435d = dragImageView;
            dragImageView.setLayoutParams(layoutParams);
            this.f30435d.setOnTouchListener(this.m0);
            addView(this.f30435d);
            SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(this.f30433b);
            this.f30437f = subsamplingScaleImageView;
            subsamplingScaleImageView.setMaxScale(50.0f);
            this.f30437f.setOnTouchListener(this.m0);
            this.f30437f.setVisibility(4);
            addView(this.f30437f, layoutParams);
            ProgressBar progressBar = new ProgressBar(this.f30433b, null, 16843399);
            this.f30434c = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f080f90));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.f30434c.setLayoutParams(layoutParams2);
            this.f30434c.setIndeterminate(true);
            addView(this.f30434c);
            O();
            this.j0 = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CircleProgressView circleProgressView = new CircleProgressView(this.f30433b);
            this.h0 = circleProgressView;
            circleProgressView.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            this.h0.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.h0.setProgress(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds80), c.a.d.f.p.n.f(getContext(), R.dimen.tbds80));
            layoutParams.addRule(13);
            this.h0.setVisibility(8);
            addView(this.h0, layoutParams);
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            DragImageView dragImageView = this.f30435d;
            return dragImageView != null && dragImageView.Z();
        }
        return invokeV.booleanValue;
    }

    public final boolean Q(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) ? j2 > o0 : invokeJ.booleanValue;
    }

    public final boolean R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://")) : invokeL.booleanValue;
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (!this.l && !this.k) {
                if (this.f30435d.getImageBitmap() == null || !this.f30435d.Z()) {
                    return true;
                }
                ImageUrlData imageUrlData = this.J;
                if (imageUrlData != null && imageUrlData.isLongPic && !this.f30435d.W()) {
                    this.k = false;
                    this.L = false;
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ImageUrlData imageUrlData = this.J;
            return (imageUrlData == null || !imageUrlData.mIsShowOrigonButton || imageUrlData.isBlockedPic || StringUtils.isNull(imageUrlData.originalUrl)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void U(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (R(str)) {
                if (z2 || !(this.l || this.k)) {
                    if (z2 && G(true)) {
                        return;
                    }
                    this.l = true;
                    c.a.d.f.l.d.h().l(str, 27, new n(this), 0, 0, false, null, Boolean.valueOf(z), this.f30435d.getImageData(), Boolean.valueOf(this.i));
                    return;
                }
                return;
            }
            this.f30434c.setVisibility(0);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(c.a.o0.c0.i.d.g(this.O, this.P));
            c.a.d.o.d.a c2 = this.N.c(imageFileInfo, false);
            if (c2 != null) {
                this.k = true;
                this.f30434c.setVisibility(8);
                this.W = null;
                M(c2);
                return;
            }
            this.N.d(imageFileInfo, new a(this), false);
        }
    }

    public final boolean V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? c.a.d.f.p.l.z() || BigImageLoaderProc.checkBigImageFileExist(str) : invokeL.booleanValue;
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || this.a == i2) {
            return;
        }
        this.a = i2;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            DragImageView dragImageView = this.f30435d;
            if (dragImageView != null) {
                dragImageView.c0();
            }
            SubsamplingScaleImageView subsamplingScaleImageView = this.f30437f;
            if (subsamplingScaleImageView != null) {
                subsamplingScaleImageView.recycle();
            }
            Bitmap bitmap = this.r;
            if (bitmap != null) {
                bitmap.recycle();
                this.r = null;
            }
            ProgressBar progressBar = this.f30434c;
            if (progressBar != null) {
                this.W = null;
                progressBar.setVisibility(8);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.k0);
            c.a.p0.q4.c.a().d(-1);
            ImageUrlData imageUrlData = this.J;
            if (imageUrlData != null) {
                c.a.o0.v.f.k().f(TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl), 13);
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            DragImageView dragImageView = this.f30435d;
            if (dragImageView != null) {
                dragImageView.l0();
            }
            ProgressBar progressBar = this.f30434c;
            if (progressBar != null) {
                this.W = null;
                progressBar.setVisibility(8);
            }
            this.W = null;
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!this.j) {
                this.f30435d.setDefaultBitmap();
            } else {
                this.k = false;
            }
            this.W = null;
            this.f30434c.setVisibility(8);
        }
    }

    public final void a0() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!(this.j || this.k) || (imageUrlData = this.J) == null || imageUrlData.mPicType != 1 || TextUtils.isEmpty(imageUrlData.mTagName)) {
                return;
            }
            TextView textView = this.f30436e;
            if (textView != null) {
                textView.setVisibility(8);
                this.f30436e = null;
            }
            TextView textView2 = new TextView(this.f30433b);
            this.f30436e = textView2;
            textView2.setText(this.J.mTagName);
            this.f30436e.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070326));
            SkinManager.setViewTextColor(this.f30436e, R.color.common_color_10013, 1, 0);
            SkinManager.setBackgroundColor(this.f30436e, R.color.common_color_10215);
            this.f30436e.setAlpha(0.75f);
            this.f30436e.setIncludeFontPadding(false);
            this.f30436e.setGravity(17);
            int f2 = c.a.d.f.p.n.f(this.f30433b, R.dimen.obfuscated_res_0x7f0701d4);
            this.f30436e.setPadding(f2, f2, f2, f2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.f30435d.getBottomOffset();
            layoutParams.leftMargin = this.f30435d.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.f30436e, layoutParams);
            this.f30436e.setVisibility(0);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.J == null) {
            return;
        }
        if (T() && this.M) {
            long j2 = this.J.originalSize;
            if (j2 > 0 && !Q(j2)) {
                this.W = n0 + "(" + StringHelper.getFormatSize(this.J.originalSize) + SmallTailInfo.EMOTION_SUFFIX;
                return;
            }
            this.W = n0;
            return;
        }
        this.W = null;
    }

    public final void c0(String str) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (imageUrlData = this.J) == null) {
            return;
        }
        imageUrlData.originalProcess = 0;
        this.h0.setProgress(0);
        this.h0.setVisibility(0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.J.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.D + StorageFile.getInstance().getDirectoryName(str) + "/" + str);
        downloadData.setCallback(new e(this));
        c.a.o0.v.f.k().m(downloadData, 100);
        this.i0 = true;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ImageUrlData imageUrlData = this.J;
            if (imageUrlData == null) {
                DragImageView.h hVar = this.C;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            Rect dstRectInScreen = this.J.getDstRectInScreen();
            if (sourceImageRectInScreen != null && dstRectInScreen != null) {
                C(sourceImageRectInScreen, dstRectInScreen);
                K(sourceImageRectInScreen);
                this.y = new RectF(this.x);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(150L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.addUpdateListener(new i(this, sourceImageRectInScreen, dstRectInScreen));
                ofFloat.addListener(new j(this));
                ofFloat.start();
                return;
            }
            DragImageView.h hVar2 = this.C;
            if (hVar2 != null) {
                hVar2.b();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, canvas) == null) {
            if (this.p && (bitmap2 = this.r) != null && !bitmap2.isRecycled() && this.s) {
                canvas.drawColor(Color.argb((int) (this.t * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.x == null) {
                    this.x = new RectF();
                }
                this.v.mapRect(this.x, new RectF(this.w));
                canvas.drawBitmap(this.r, this.z, this.x, (Paint) null);
            } else if (this.q && (bitmap = this.r) != null && !bitmap.isRecycled()) {
                canvas.drawColor(Color.argb((int) (this.t * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                ImageUrlData imageUrlData = this.J;
                if (imageUrlData != null && imageUrlData.getSourceImageRectInScreen() != null) {
                    canvas.drawBitmap(this.r, this.A, this.x, (Paint) null);
                } else {
                    canvas.drawBitmap(this.r, this.z, this.x, (Paint) null);
                }
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        DragImageView.h hVar;
        Bitmap imageBitmap;
        int width;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            if (this.K && !this.i0 && this.f30437f.getVisibility() == 0 && !this.f30437f.isImageLoaded()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.m && this.k) {
                if (!this.p && motionEvent.getPointerCount() >= 2) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.p || this.q) {
                    requestDisallowInterceptTouchEvent(true);
                }
                int action = motionEvent.getAction();
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                int i3 = action & 255;
                if (i3 == 0) {
                    if (this.r == null) {
                        if (this.f30437f.getVisibility() == 0) {
                            this.r = c.a.o0.c1.m.c(this.f30437f);
                        } else {
                            this.r = c.a.o0.c1.m.c(this.f30435d);
                        }
                    }
                    if (this.w == null && this.r != null) {
                        int measuredWidth = getMeasuredWidth();
                        float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.r.getWidth()) * this.r.getHeight();
                        if (measuredWidth2 > getMeasuredHeight()) {
                            measuredWidth2 = getMeasuredHeight();
                        }
                        RectF L = L(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                        this.w = new Rect((int) L.left, (int) L.top, (int) L.right, (int) L.bottom);
                    }
                    if (this.A == null && this.r != null) {
                        if (this.f30437f.getVisibility() == 0) {
                            i2 = this.f30437f.getSHeight();
                            width = this.f30437f.getSWidth();
                        } else {
                            if (this.f30435d.getImageType() == 1) {
                                imageBitmap = (this.f30435d.getCurrentFrame() == null || this.f30435d.getCurrentFrame().a == null) ? this.r : this.f30435d.getCurrentFrame().a;
                            } else {
                                imageBitmap = this.f30435d.getImageBitmap() == null ? this.r : this.f30435d.getImageBitmap();
                            }
                            int height = imageBitmap.getHeight();
                            width = imageBitmap.getWidth();
                            i2 = height;
                        }
                        float h2 = c.a.d.f.p.n.h(getContext());
                        int i4 = (int) (i2 * h2);
                        int i5 = (int) (width * h2);
                        if (i5 > this.r.getWidth() && this.r.getWidth() != 0) {
                            i4 = (int) (i4 / ((i5 * 1.0f) / this.r.getWidth()));
                            i5 = this.r.getWidth();
                        }
                        if (i4 > this.r.getHeight() && this.r.getHeight() != 0) {
                            i5 = (int) (i5 / ((i4 * 1.0f) / this.r.getHeight()));
                            i4 = this.r.getHeight();
                        }
                        int i6 = (c.a.d.f.p.n.i(getContext()) - i4) / 2;
                        int k2 = (c.a.d.f.p.n.k(getContext()) - i5) / 2;
                        this.A = new Rect(k2, i6, i5 + k2, i4 + i6);
                        this.B = new Rect(this.A);
                        this.I = i6 / c.a.d.f.p.n.i(getContext());
                        this.z = new Rect(0, 0, this.r.getWidth(), this.r.getHeight());
                    }
                    this.n = x;
                    this.o = y;
                }
                if (i3 == 2) {
                    this.p = J(this.n - x, this.o - y);
                    this.n = x;
                    this.o = y;
                }
                if (!this.p && !this.q) {
                    this.f30435d.setImageOnLongClickListener(this.V);
                    this.f30437f.setOnLongClickListener(this.V);
                    z = super.dispatchTouchEvent(motionEvent);
                } else {
                    this.f30435d.setImageOnLongClickListener(null);
                    this.f30437f.setOnLongClickListener(null);
                    z = true;
                }
                if (i3 == 1 || i3 == 3) {
                    this.n = 0.0f;
                    this.o = 0.0f;
                    boolean z2 = (-this.u) > ((float) (p0 * 2));
                    boolean z3 = this.u > ((float) p0);
                    if (!z2 && !z3) {
                        if (this.p && (hVar = this.C) != null) {
                            hVar.c();
                        }
                        this.t = 1.0f;
                        invalidate();
                    } else {
                        this.q = true;
                        d0();
                        if (z2) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "3"));
                        } else if (z3) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "2"));
                        }
                    }
                    this.s = false;
                    this.v.reset();
                    this.p = false;
                }
                return z;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void e0() {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (dragImageView = this.f30435d) != null && dragImageView.getImageType() == 1) {
            this.f30435d.s0();
        }
    }

    public DragImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f30435d : (DragImageView) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.g0 : (String) invokeV.objValue;
    }

    public ImageUrlData getmAssistUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.J : (ImageUrlData) invokeV.objValue;
    }

    public String getmCheckOriginPicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, imageUrlData) == null) {
            this.J = imageUrlData;
        }
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, oVar) == null) {
            this.f30439h = oVar;
        }
    }

    public void setCanScale(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || (dragImageView = this.f30435d) == null) {
            return;
        }
        dragImageView.setCanScale(z);
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hVar) == null) {
            this.C = hVar;
            DragImageView dragImageView = this.f30435d;
            if (dragImageView != null) {
                dragImageView.setDragToExitListener(hVar);
            }
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.f30435d.setGifMaxUseableMem(i2);
        }
    }

    public void setGifSetListener(DragImageView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, iVar) == null) {
            this.f30435d.setGifSetListener(iVar);
        }
    }

    public void setHeadImage(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (dragImageView = this.f30435d) == null) {
            return;
        }
        dragImageView.setIsHeadImage(z);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.f30435d.setImageOnClickListener(onClickListener);
            this.f30437f.setOnClickListener(onClickListener);
            this.U = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.V = onLongClickListener;
            if (this.m) {
                return;
            }
            this.f30435d.setImageOnLongClickListener(onLongClickListener);
            this.f30437f.setOnLongClickListener(this.V);
        }
    }

    public void setIsCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsCdn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.i = z;
        }
    }

    public void setOnSizeChangedListener(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) {
            this.f30435d.setOnSizeChangedListener(new h(this, kVar));
        }
    }

    public void setOriImgSelectedCallback(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, pVar) == null) {
            this.Q = pVar;
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onTouchListener) == null) {
            this.R = onTouchListener;
        }
    }

    public void setUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, str, z) == null) {
            if (str.contains("*")) {
                str = str.split("[*]")[0];
            }
            this.f30435d.setTag(str);
            this.f30435d.setLoadBigImage(false);
            this.f30435d.setImageDrawable(null);
            this.j = false;
            this.k = false;
            this.K = E();
            this.W = null;
            if (V(str)) {
                U(str, z, false);
            }
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.g0 = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.f30434c = null;
        this.f30435d = null;
        this.f30439h = null;
        this.i = false;
        this.l = false;
        this.s = false;
        this.t = 1.0f;
        this.u = 0.0f;
        this.v = new Matrix();
        this.x = new RectF();
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = 1.0f;
        this.H = 1.0f;
        this.I = 0.0f;
        this.K = false;
        this.L = false;
        this.M = false;
        this.S = true;
        this.T = 0.0f;
        this.U = null;
        this.V = null;
        this.W = null;
        this.k0 = new f(this);
        this.l0 = new g(this);
        this.m0 = new k(this);
        this.f30433b = context;
        this.N = new c.a.o0.c0.b();
        N();
    }
}
