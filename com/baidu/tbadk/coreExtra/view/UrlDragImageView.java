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
import d.a.r0.r.s.a;
import java.io.File;
/* loaded from: classes4.dex */
public class UrlDragImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final String q0;
    public static long r0;
    public static final int s0;
    public static final int t0;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect A;
    public RectF B;
    public RectF C;
    public Rect D;
    public Rect E;
    public Rect F;
    public DragImageView.h G;
    public String H;
    public float I;
    public float J;
    public float K;
    public float L;
    public float M;
    public ImageUrlData N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public d.a.r0.b0.b R;
    public int S;
    public int T;
    public p U;
    public View.OnTouchListener V;
    public boolean W;
    public float a0;
    public View.OnClickListener b0;
    public View.OnLongClickListener c0;

    /* renamed from: e  reason: collision with root package name */
    public int f12905e;

    /* renamed from: f  reason: collision with root package name */
    public Context f12906f;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f12907g;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView f12908h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12909i;
    public String i0;
    public SubsamplingScaleImageView j;
    public String j0;
    public SubsamplingScaleImageView.OnImageEventListener k;
    public CircleProgressView k0;
    public o l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public boolean n;
    public Runnable n0;
    public boolean o;
    public Runnable o0;
    public boolean p;
    public View.OnTouchListener p0;
    public boolean q;
    public float r;
    public float s;
    public boolean t;
    public boolean u;
    public Bitmap v;
    public boolean w;
    public float x;
    public float y;
    public final Matrix z;

    /* loaded from: classes4.dex */
    public class a implements d.a.r0.a0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12910e;

        public a(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12910e = urlDragImageView;
        }

        @Override // d.a.r0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                this.f12910e.o = true;
                this.f12910e.f12907g.setVisibility(8);
                this.f12910e.i0 = null;
                this.f12910e.M(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.r0.b1.i.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12911a;

        public b(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12911a = urlDragImageView;
        }

        @Override // d.a.r0.b1.i.b.a
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12911a.f12907g.setVisibility(8);
                this.f12911a.i0 = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f12912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12914g;

        public c(UrlDragImageView urlDragImageView, d.a.r0.r.s.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12914g = urlDragImageView;
            this.f12912e = aVar;
            this.f12913f = str;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f12912e.dismiss();
                this.f12914g.c0(this.f12913f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f12915e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12916f;

        public d(UrlDragImageView urlDragImageView, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12916f = urlDragImageView;
            this.f12915e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f12915e.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements d.a.r0.v.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12917a;

        public e(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12917a = urlDragImageView;
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                this.f12917a.k0.setVisibility(8);
                this.f12917a.P = false;
                BdToast c2 = BdToast.c(this.f12917a.f12906f, str);
                c2.a();
                c2.q();
                this.f12917a.N.originalProcess = -1;
                this.f12917a.b0();
            }
        }

        @Override // d.a.r0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.f12917a.k0.setVisibility(8);
                d.a.c.e.m.e.a().postDelayed(this.f12917a.o0, 1500L);
                this.f12917a.P = false;
                UrlDragImageView urlDragImageView = this.f12917a;
                urlDragImageView.O = urlDragImageView.E();
                this.f12917a.F();
            }
        }

        @Override // d.a.r0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // d.a.r0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
                return;
            }
            if (this.f12917a.N != null && this.f12917a.N.originalProcess != -1) {
                this.f12917a.N.originalProcess = downloadData.getProcess();
            }
            if (this.f12917a.N == null || this.f12917a.N.originalProcess != -1) {
                this.f12917a.k0.setProgress(downloadData.getProcess());
            }
        }

        @Override // d.a.r0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12918e;

        public f(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12918e = urlDragImageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f12918e.W = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12919e;

        /* loaded from: classes4.dex */
        public class a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f12920a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12920a = gVar;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                    this.f12920a.f12919e.k0.setVisibility(8);
                    this.f12920a.f12919e.i0 = null;
                    this.f12920a.f12919e.Q = false;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12919e = urlDragImageView;
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

    /* loaded from: classes4.dex */
    public class h implements DragImageView.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragImageView.k f12921a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12922b;

        public h(UrlDragImageView urlDragImageView, DragImageView.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12922b = urlDragImageView;
            this.f12921a = kVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{dragImageView, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                DragImageView.k kVar = this.f12921a;
                if (kVar != null) {
                    kVar.a(dragImageView, z, z2);
                }
                this.f12922b.a0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f12923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Rect f12924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12925g;

        public i(UrlDragImageView urlDragImageView, Rect rect, Rect rect2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, rect, rect2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12925g = urlDragImageView;
            this.f12923e = rect;
            this.f12924f = rect2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null || this.f12923e == null || this.f12924f == null) {
                return;
            }
            this.f12925g.A(valueAnimator.getAnimatedFraction());
            this.f12925g.B(this.f12924f, valueAnimator.getAnimatedFraction(), this.f12925g.m0);
            this.f12925g.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12926e;

        public j(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12926e = urlDragImageView;
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
                this.f12926e.w = false;
                this.f12926e.invalidate();
                if (this.f12926e.G != null) {
                    this.f12926e.G.b();
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

    /* loaded from: classes4.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12927e;

        public k(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12927e = urlDragImageView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f12927e.V != null) {
                    this.f12927e.V.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements SubsamplingScaleImageView.OnImageEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f12928a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12929b;

        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f12930e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PointF f12931f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ l f12932g;

            public a(l lVar, float f2, PointF pointF) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Float.valueOf(f2), pointF};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f12932g = lVar;
                this.f12930e = f2;
                this.f12931f = pointF;
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
                    if (this.f12932g.f12929b.V != null) {
                        this.f12932g.f12929b.V.onTouch(view, motionEvent);
                    }
                    int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                    if (action == 0) {
                        this.f12932g.f12929b.a0 = motionEvent.getY();
                        UrlDragImageView urlDragImageView = this.f12932g.f12929b;
                        urlDragImageView.j.setOnClickListener(urlDragImageView.W ? this.f12932g.f12929b.b0 : null);
                        UrlDragImageView urlDragImageView2 = this.f12932g.f12929b;
                        urlDragImageView2.j.setOnLongClickListener(urlDragImageView2.W ? this.f12932g.f12929b.c0 : null);
                    } else {
                        if (action != 1) {
                            if (action == 2) {
                                if (Math.abs(motionEvent.getY() - this.f12932g.f12929b.a0) > UrlDragImageView.t0) {
                                    this.f12932g.f12929b.W = false;
                                    this.f12932g.f12929b.j.setOnClickListener(null);
                                    this.f12932g.f12929b.j.setOnLongClickListener(null);
                                }
                                this.f12932g.f12929b.a0 = motionEvent.getY();
                            }
                        }
                        float scale = this.f12932g.f12929b.j.getScale();
                        float f2 = this.f12930e;
                        if (scale < f2) {
                            this.f12932g.f12929b.j.setScaleAndCenter(f2, this.f12931f);
                        }
                        d.a.c.e.m.e.a().removeCallbacks(this.f12932g.f12929b.n0);
                        d.a.c.e.m.e.a().postDelayed(this.f12932g.f12929b.n0, 1000L);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12929b = urlDragImageView;
            this.f12928a = iArr;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f12929b.N.isLongPic && this.f12928a[0] > 0) {
                this.f12929b.f12908h.c0();
                float measuredWidth = (this.f12929b.getMeasuredWidth() * 1.0f) / this.f12928a[0];
                PointF pointF = new PointF((this.f12928a[0] * 1.0f) / 2.0f, 0.0f);
                this.f12929b.j.setScaleAndCenter(measuredWidth, pointF);
                float f2 = 2.0f * measuredWidth;
                this.f12929b.j.setMaxScale(f2);
                this.f12929b.j.setDoubleTapZoomScale(f2);
                this.f12929b.j.setInitScale(measuredWidth);
                this.f12929b.j.setDoubleTapZoomStyle(4);
                this.f12929b.j.setOnTouchListener(new a(this, measuredWidth, pointF));
                this.f12929b.f12908h.setVisibility(4);
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
                this.f12929b.i0 = null;
                this.f12929b.f12907g.setVisibility(8);
                this.f12929b.f12908h.p0();
                this.f12929b.f12908h.setVisibility(4);
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.a.r0.b1.i.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12933a;

        public m(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12933a = urlDragImageView;
        }

        @Override // d.a.r0.b1.i.b.a
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n extends d.a.c.e.l.c<d.a.c.k.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f12934a;

        public n(UrlDragImageView urlDragImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12934a = urlDragImageView;
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f12934a.p = false;
                this.f12934a.f12908h.setVisibility(0);
                this.f12934a.f12907g.setVisibility(8);
                this.f12934a.i0 = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.f12934a.p = false;
                this.f12934a.o = true;
                this.f12934a.M(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface o {
        void a(String str, byte[] bArr);
    }

    /* loaded from: classes4.dex */
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
        q0 = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
        r0 = 52428800L;
        s0 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst()) / 5;
        t0 = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
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
        this.f12905e = 3;
        this.f12907g = null;
        this.f12908h = null;
        this.l = null;
        this.m = false;
        this.p = false;
        this.w = false;
        this.x = 1.0f;
        this.y = 0.0f;
        this.z = new Matrix();
        this.B = new RectF();
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 1.0f;
        this.L = 1.0f;
        this.M = 0.0f;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.W = true;
        this.a0 = 0.0f;
        this.b0 = null;
        this.c0 = null;
        this.i0 = null;
        this.n0 = new f(this);
        this.o0 = new g(this);
        this.p0 = new k(this);
        this.f12906f = context;
        this.R = new d.a.r0.b0.b();
        N();
    }

    private void setThumbBitmapToView(d.a.c.k.d.a aVar) {
        Bitmap p2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, aVar) == null) || this.o || aVar == null || (p2 = aVar.p()) == null) {
            return;
        }
        this.n = true;
        if (aVar.t()) {
            this.f12908h.setImageUrlData(this.N);
            this.f12908h.setImageBitmap(p2);
            this.i0 = null;
            this.Q = false;
        } else {
            ImageUrlData imageUrlData = this.N;
            if (imageUrlData != null && imageUrlData.isLongPic) {
                this.f12908h.T();
                this.f12908h.setImageLoadCallBack(new m(this));
            }
            this.f12908h.setImageUrlData(this.N);
            this.f12908h.setImageData(p2, aVar.k());
        }
        a0();
    }

    public final void A(float f2) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (rect = this.E) == null) {
            return;
        }
        Rect rect2 = this.F;
        rect.left = (int) (rect2.left + (rect2.width() * this.I * f2));
        Rect rect3 = this.E;
        Rect rect4 = this.F;
        rect3.top = (int) (rect4.top + (rect4.height() * this.J * f2));
        Rect rect5 = this.E;
        Rect rect6 = this.F;
        float f3 = this.K;
        float f4 = 1.0f - f2;
        rect5.right = (int) (rect6.left + (rect6.width() * (((1.0f - f3) * f4) + f3)));
        Rect rect7 = this.E;
        Rect rect8 = this.F;
        float f5 = this.L;
        rect7.bottom = (int) (rect8.top + (rect8.height() * (((1.0f - f5) * f4) + f5)));
    }

    public final void B(Rect rect, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rect, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            int g2 = z ? d.a.c.e.p.l.g(getContext(), R.dimen.tbds80) : 0;
            RectF rectF = this.B;
            if (rectF == null || rect == null) {
                return;
            }
            RectF rectF2 = this.C;
            float f3 = rectF2.left;
            rectF.left = f3 + ((rect.left - f3) * f2);
            float f4 = rectF2.top;
            rectF.top = (f4 + ((rect.top - f4) * f2)) - g2;
            float f5 = rectF2.right;
            rectF.right = f5 + ((rect.right - f5) * f2);
            float f6 = rectF2.bottom;
            rectF.bottom = f6 + ((rect.bottom - f6) * f2);
        }
    }

    public final void C(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rect, rect2) == null) {
            this.I = 0.0f;
            this.J = 0.0f;
            this.K = 1.0f;
            this.L = 1.0f;
            if (rect == null || rect2 == null || !rect.contains(rect2)) {
                return;
            }
            this.I = (rect2.left - rect.left) / rect.width();
            this.J = (rect2.top - rect.top) / rect.height();
            this.K = (rect2.right - rect.left) / rect.width();
            this.L = (rect2.bottom - rect.top) / rect.height();
        }
    }

    public void D(boolean z, boolean z2) {
        DragImageView dragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (dragImageView = this.f12908h) == null || (str = (String) dragImageView.getTag()) == null) {
            return;
        }
        if (this.f12908h.getImageType() == 1) {
            if (this.f12908h.getGifCache() == null || !this.f12908h.Z()) {
                U(str, z, z2);
            }
        } else if (this.f12908h.getImageType() == 2) {
            U(str, z, z2);
        } else if (S()) {
            U(str, z, z2);
        }
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageUrlData imageUrlData = this.N;
            if (imageUrlData != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.N;
                if (imageUrlData2.originalSize >= 0 && !imageUrlData2.isBlockedPic) {
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    if (new File(this.H + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + nameMd5FromUrl).exists()) {
                        this.N.originalProcess = 100;
                        return true;
                    }
                    int i2 = this.N.originalProcess;
                    if (i2 < 0) {
                        b0();
                    } else {
                        this.k0.setProgress(i2);
                    }
                    this.Q = true;
                    return false;
                }
            }
            this.i0 = null;
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
            if (!this.P || z) {
                this.P = true;
                if (this.O && (imageUrlData = this.N) != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                    ImageUrlData imageUrlData2 = this.N;
                    if (imageUrlData2.originalSize >= 0 && Build.VERSION.SDK_INT >= 10) {
                        String str = this.H + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        this.j.setVisibility(0);
                        if (this.k == null) {
                            this.k = new l(this, imageFileWH);
                        }
                        this.j.setOnImageEventListener(this.k);
                        if (this.j.isImageLoaded() && this.N.isLongPic) {
                            this.k.onImageLoaded();
                        } else {
                            this.j.setImage(ImageSource.uri(str));
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.N == null || P()) {
            return;
        }
        ImageUrlData imageUrlData = this.N;
        String str = imageUrlData.imageUrl;
        int i2 = imageUrlData.urlType;
        d.a.c.k.d.a loadBdImageFromLocal = AbstractImageLoaderProc.isImageFileExist(str, i2) ? AbstractImageLoaderProc.loadBdImageFromLocal(str, i2) : null;
        if (loadBdImageFromLocal != null) {
            setThumbBitmapToView(loadBdImageFromLocal);
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(this.N.originalUrl);
            if (this.N.originalProcess >= 0) {
                d.a.r0.v.d.j().f(nameMd5FromUrl, 13);
                this.N.originalProcess = -1;
                b0();
                return;
            }
            p pVar = this.U;
            if (pVar != null) {
                pVar.a();
            }
            d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f12906f);
            if (a2 == null) {
                c0(nameMd5FromUrl);
            } else if (d.a.c.e.p.j.z() && !d.a.c.e.p.j.H() && !d.a.r0.r.d0.b.j().g("original_img_down_tip", false)) {
                d.a.r0.r.d0.b.j().t("original_img_down_tip", true);
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(a2.getPageActivity());
                aVar.setMessageId(R.string.original_img_down_no_wifi_tip);
                aVar.setPositiveButton(R.string.alert_yes_button, new c(this, aVar, nameMd5FromUrl));
                aVar.setNegativeButton(R.string.cancel, new d(this, aVar));
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
            if (this.j.getVisibility() != 0 || this.j.isCanDrag()) {
                ImageUrlData imageUrlData = this.N;
                if (imageUrlData == null || !imageUrlData.isLongPic || this.j.getVisibility() != 0 || this.j.isViewTop()) {
                    ImageUrlData imageUrlData2 = this.N;
                    if (imageUrlData2 == null || !imageUrlData2.isLongPic || this.j.getVisibility() == 0 || this.f12908h.Y() || this.f12908h.a0()) {
                        if (this.j.getVisibility() == 0 || this.f12908h.f0()) {
                            if (this.v != null && getScrollY() == 0) {
                                ImageUrlData imageUrlData3 = this.N;
                                boolean z = (imageUrlData3 == null || !imageUrlData3.isLongPic) && ((f3 < -15.0f && !this.w) || (f3 > 15.0f && !this.w));
                                ImageUrlData imageUrlData4 = this.N;
                                boolean z2 = imageUrlData4 != null && imageUrlData4.isLongPic && f3 < 0.0f && !this.w;
                                if (z || (z2 && this.f12908h.b0())) {
                                    this.f12908h.setImageOnLongClickListener(null);
                                    this.j.setOnLongClickListener(null);
                                    this.w = true;
                                    this.y = 0.0f;
                                    this.x = 1.0f;
                                    DragImageView.h hVar = this.G;
                                    if (hVar != null) {
                                        hVar.a();
                                    }
                                }
                            }
                            if (!this.w || this.v == null) {
                                return false;
                            }
                            this.y -= f3;
                            float measuredHeight = getMeasuredHeight();
                            if (this.y > measuredHeight) {
                                this.y = measuredHeight;
                            }
                            float f4 = f3 / measuredHeight;
                            Matrix matrix = this.z;
                            float f5 = this.x;
                            matrix.postTranslate((-f2) * 1.5f * f5, f3 * (-1.5f) * f5);
                            if (this.x * (f4 + 1.0f) > 1.0f || this.y < 0.0f) {
                                f4 = -f4;
                            }
                            float f6 = f4 + 1.0f;
                            this.z.preScale(f6, f6, (this.x * this.v.getWidth()) / 2.0f, this.x * (this.v.getHeight() / 2));
                            this.x *= f6;
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
        RectF rectF = this.B;
        float f3 = f2 * (rectF.right - rectF.left);
        rectF.top += rectF.height() * this.M;
        RectF rectF2 = this.B;
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

    public final void M(d.a.c.k.d.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            if (aVar != null && (oVar = this.l) != null) {
                oVar.a(aVar.q(), aVar.k());
            }
            if (aVar != null && aVar.p() != null) {
                Bitmap p2 = aVar.p();
                this.f12908h.setLoadBigImage(true);
                if (aVar.t()) {
                    this.f12908h.setGifData(aVar.k(), p2);
                    this.f12908h.invalidate();
                    this.f12908h.h0();
                    this.Q = false;
                    this.i0 = null;
                    this.f12907g.setVisibility(8);
                } else {
                    ImageUrlData imageUrlData = this.N;
                    if (imageUrlData != null && imageUrlData.isLongPic) {
                        this.f12908h.T();
                        this.f12908h.setImageLoadCallBack(new b(this));
                    } else {
                        this.f12907g.setVisibility(8);
                        this.i0 = null;
                    }
                    this.f12908h.setImageUrlData(this.N);
                    this.f12908h.setImageData(p2, aVar.k());
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
            this.H = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
            this.S = d.a.c.e.p.l.k(this.f12906f);
            this.T = d.a.c.e.p.l.i(this.f12906f) - ((int) this.f12906f.getResources().getDimension(R.dimen.ds166));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            DragImageView dragImageView = new DragImageView(this.f12906f);
            this.f12908h = dragImageView;
            dragImageView.setLayoutParams(layoutParams);
            this.f12908h.setOnTouchListener(this.p0);
            addView(this.f12908h);
            SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(this.f12906f);
            this.j = subsamplingScaleImageView;
            subsamplingScaleImageView.setMaxScale(50.0f);
            this.j.setOnTouchListener(this.p0);
            this.j.setVisibility(4);
            addView(this.j, layoutParams);
            ProgressBar progressBar = new ProgressBar(this.f12906f, null, 16843399);
            this.f12907g = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.f12907g.setLayoutParams(layoutParams2);
            this.f12907g.setIndeterminate(true);
            addView(this.f12907g);
            O();
            this.m0 = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CircleProgressView circleProgressView = new CircleProgressView(this.f12906f);
            this.k0 = circleProgressView;
            circleProgressView.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            this.k0.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.k0.setProgress(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a.c.e.p.l.g(getContext(), R.dimen.tbds80), d.a.c.e.p.l.g(getContext(), R.dimen.tbds80));
            layoutParams.addRule(13);
            this.k0.setVisibility(8);
            addView(this.k0, layoutParams);
        }
    }

    public final boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            DragImageView dragImageView = this.f12908h;
            return dragImageView != null && dragImageView.Z();
        }
        return invokeV.booleanValue;
    }

    public final boolean Q(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j2)) == null) ? j2 > r0 : invokeJ.booleanValue;
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
            if (this.f12908h.getImageBitmap() != null && this.f12908h.Z()) {
                ImageUrlData imageUrlData = this.N;
                if (imageUrlData == null || !imageUrlData.isLongPic || this.f12908h.W()) {
                    return false;
                }
                this.o = false;
                this.P = false;
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ImageUrlData imageUrlData = this.N;
            return (imageUrlData == null || !imageUrlData.mIsShowOrigonButton || imageUrlData.isBlockedPic || StringUtils.isNull(imageUrlData.originalUrl)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void U(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (R(str)) {
                if (z2 || !(this.p || this.o)) {
                    if (z2 && G(true)) {
                        return;
                    }
                    this.p = true;
                    d.a.c.e.l.d.h().l(str, 27, new n(this), 0, 0, false, null, Boolean.valueOf(z), this.f12908h.getImageData(), Boolean.valueOf(this.m));
                    return;
                }
                return;
            }
            this.f12907g.setVisibility(0);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(d.a.r0.b0.g.d.g(this.S, this.T));
            d.a.c.k.d.a c2 = this.R.c(imageFileInfo, false);
            if (c2 != null) {
                this.o = true;
                this.f12907g.setVisibility(8);
                this.i0 = null;
                M(c2);
                return;
            }
            this.R.d(imageFileInfo, new a(this), false);
        }
    }

    public final boolean V(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) ? d.a.c.e.p.j.z() || BigImageLoaderProc.checkBigImageFileExist(str) : invokeL.booleanValue;
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || this.f12905e == i2) {
            return;
        }
        this.f12905e = i2;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            DragImageView dragImageView = this.f12908h;
            if (dragImageView != null) {
                dragImageView.c0();
            }
            SubsamplingScaleImageView subsamplingScaleImageView = this.j;
            if (subsamplingScaleImageView != null) {
                subsamplingScaleImageView.recycle();
            }
            Bitmap bitmap = this.v;
            if (bitmap != null) {
                bitmap.recycle();
                this.v = null;
            }
            ProgressBar progressBar = this.f12907g;
            if (progressBar != null) {
                this.i0 = null;
                progressBar.setVisibility(8);
            }
            d.a.c.e.m.e.a().removeCallbacks(this.n0);
            d.a.s0.z3.c.a().d(-1);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            DragImageView dragImageView = this.f12908h;
            if (dragImageView != null) {
                dragImageView.l0();
            }
            ProgressBar progressBar = this.f12907g;
            if (progressBar != null) {
                this.i0 = null;
                progressBar.setVisibility(8);
            }
            this.i0 = null;
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (!this.n) {
                this.f12908h.setDefaultBitmap();
            } else {
                this.o = false;
            }
            this.i0 = null;
            this.f12907g.setVisibility(8);
        }
    }

    public final void a0() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!(this.n || this.o) || (imageUrlData = this.N) == null || imageUrlData.mPicType != 1 || TextUtils.isEmpty(imageUrlData.mTagName)) {
                return;
            }
            TextView textView = this.f12909i;
            if (textView != null) {
                textView.setVisibility(8);
                this.f12909i = null;
            }
            TextView textView2 = new TextView(this.f12906f);
            this.f12909i = textView2;
            textView2.setText(this.N.mTagName);
            this.f12909i.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            SkinManager.setViewTextColor(this.f12909i, R.color.common_color_10013, 1, 0);
            SkinManager.setBackgroundColor(this.f12909i, R.color.common_color_10215);
            this.f12909i.setAlpha(0.75f);
            this.f12909i.setIncludeFontPadding(false);
            this.f12909i.setGravity(17);
            int g2 = d.a.c.e.p.l.g(this.f12906f, R.dimen.ds2);
            this.f12909i.setPadding(g2, g2, g2, g2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.f12908h.getBottomOffset();
            layoutParams.leftMargin = this.f12908h.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.f12909i, layoutParams);
            this.f12909i.setVisibility(0);
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.N == null) {
            return;
        }
        if (T() && this.Q) {
            long j2 = this.N.originalSize;
            if (j2 > 0 && !Q(j2)) {
                this.i0 = q0 + "(" + StringHelper.getFormatSize(this.N.originalSize) + SmallTailInfo.EMOTION_SUFFIX;
                return;
            }
            this.i0 = q0;
            return;
        }
        this.i0 = null;
    }

    public final void c0(String str) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (imageUrlData = this.N) == null) {
            return;
        }
        imageUrlData.originalProcess = 0;
        this.k0.setProgress(0);
        this.k0.setVisibility(0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.N.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.H + StorageFile.getInstance().getDirectoryName(str) + "/" + str);
        downloadData.setCallback(new e(this));
        d.a.r0.v.d.j().l(downloadData, 100);
        this.l0 = true;
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ImageUrlData imageUrlData = this.N;
            if (imageUrlData == null) {
                DragImageView.h hVar = this.G;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            Rect dstRectInScreen = this.N.getDstRectInScreen();
            if (sourceImageRectInScreen != null && dstRectInScreen != null) {
                C(sourceImageRectInScreen, dstRectInScreen);
                K(sourceImageRectInScreen);
                this.C = new RectF(this.B);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(150L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.addUpdateListener(new i(this, sourceImageRectInScreen, dstRectInScreen));
                ofFloat.addListener(new j(this));
                ofFloat.start();
                return;
            }
            DragImageView.h hVar2 = this.G;
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
            if (this.t && (bitmap2 = this.v) != null && !bitmap2.isRecycled() && this.w) {
                canvas.drawColor(Color.argb((int) (this.x * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.B == null) {
                    this.B = new RectF();
                }
                this.z.mapRect(this.B, new RectF(this.A));
                canvas.drawBitmap(this.v, this.D, this.B, (Paint) null);
            } else if (this.u && (bitmap = this.v) != null && !bitmap.isRecycled()) {
                canvas.drawColor(Color.argb((int) (this.x * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                ImageUrlData imageUrlData = this.N;
                if (imageUrlData != null && imageUrlData.getSourceImageRectInScreen() != null) {
                    canvas.drawBitmap(this.v, this.E, this.B, (Paint) null);
                } else {
                    canvas.drawBitmap(this.v, this.D, this.B, (Paint) null);
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
            if (this.O && !this.l0 && this.j.getVisibility() == 0 && !this.j.isImageLoaded()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.q && this.o) {
                if (!this.t && motionEvent.getPointerCount() >= 2) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.t || this.u) {
                    requestDisallowInterceptTouchEvent(true);
                }
                int action = motionEvent.getAction();
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                int i3 = action & 255;
                if (i3 == 0) {
                    if (this.v == null) {
                        if (this.j.getVisibility() == 0) {
                            this.v = d.a.r0.z0.h.c(this.j);
                        } else {
                            this.v = d.a.r0.z0.h.c(this.f12908h);
                        }
                    }
                    if (this.A == null && this.v != null) {
                        int measuredWidth = getMeasuredWidth();
                        float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.v.getWidth()) * this.v.getHeight();
                        if (measuredWidth2 > getMeasuredHeight()) {
                            measuredWidth2 = getMeasuredHeight();
                        }
                        RectF L = L(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                        this.A = new Rect((int) L.left, (int) L.top, (int) L.right, (int) L.bottom);
                    }
                    if (this.E == null && this.v != null) {
                        if (this.j.getVisibility() == 0) {
                            i2 = this.j.getSHeight();
                            width = this.j.getSWidth();
                        } else {
                            if (this.f12908h.getImageType() == 1) {
                                imageBitmap = (this.f12908h.getCurrentFrame() == null || this.f12908h.getCurrentFrame().f13206a == null) ? this.v : this.f12908h.getCurrentFrame().f13206a;
                            } else {
                                imageBitmap = this.f12908h.getImageBitmap() == null ? this.v : this.f12908h.getImageBitmap();
                            }
                            int height = imageBitmap.getHeight();
                            width = imageBitmap.getWidth();
                            i2 = height;
                        }
                        float h2 = d.a.c.e.p.l.h(getContext());
                        int i4 = (int) (i2 * h2);
                        int i5 = (int) (width * h2);
                        if (i5 > this.v.getWidth() && this.v.getWidth() != 0) {
                            i4 = (int) (i4 / ((i5 * 1.0f) / this.v.getWidth()));
                            i5 = this.v.getWidth();
                        }
                        if (i4 > this.v.getHeight() && this.v.getHeight() != 0) {
                            i5 = (int) (i5 / ((i4 * 1.0f) / this.v.getHeight()));
                            i4 = this.v.getHeight();
                        }
                        int i6 = (d.a.c.e.p.l.i(getContext()) - i4) / 2;
                        int k2 = (d.a.c.e.p.l.k(getContext()) - i5) / 2;
                        this.E = new Rect(k2, i6, i5 + k2, i4 + i6);
                        this.F = new Rect(this.E);
                        this.M = i6 / d.a.c.e.p.l.i(getContext());
                        this.D = new Rect(0, 0, this.v.getWidth(), this.v.getHeight());
                    }
                    this.r = x;
                    this.s = y;
                }
                if (i3 == 2) {
                    this.t = J(this.r - x, this.s - y);
                    this.r = x;
                    this.s = y;
                }
                if (!this.t && !this.u) {
                    this.f12908h.setImageOnLongClickListener(this.c0);
                    this.j.setOnLongClickListener(this.c0);
                    z = super.dispatchTouchEvent(motionEvent);
                } else {
                    this.f12908h.setImageOnLongClickListener(null);
                    this.j.setOnLongClickListener(null);
                    z = true;
                }
                if (i3 == 1 || i3 == 3) {
                    this.r = 0.0f;
                    this.s = 0.0f;
                    boolean z2 = (-this.y) > ((float) (s0 * 2));
                    boolean z3 = this.y > ((float) s0);
                    if (!z2 && !z3) {
                        if (this.t && (hVar = this.G) != null) {
                            hVar.c();
                        }
                        this.x = 1.0f;
                        invalidate();
                    } else {
                        this.u = true;
                        d0();
                        if (z2) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "3"));
                        } else if (z3) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "2"));
                        }
                    }
                    this.w = false;
                    this.z.reset();
                    this.t = false;
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
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (dragImageView = this.f12908h) != null && dragImageView.getImageType() == 1) {
            this.f12908h.s0();
        }
    }

    public DragImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f12908h : (DragImageView) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.j0 : (String) invokeV.objValue;
    }

    public ImageUrlData getmAssistUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.N : (ImageUrlData) invokeV.objValue;
    }

    public String getmCheckOriginPicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, imageUrlData) == null) {
            this.N = imageUrlData;
        }
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, oVar) == null) {
            this.l = oVar;
        }
    }

    public void setCanScale(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || (dragImageView = this.f12908h) == null) {
            return;
        }
        dragImageView.setCanScale(z);
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hVar) == null) {
            this.G = hVar;
            DragImageView dragImageView = this.f12908h;
            if (dragImageView != null) {
                dragImageView.setDragToExitListener(hVar);
            }
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.f12908h.setGifMaxUseableMem(i2);
        }
    }

    public void setGifSetListener(DragImageView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, iVar) == null) {
            this.f12908h.setGifSetListener(iVar);
        }
    }

    public void setHeadImage(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (dragImageView = this.f12908h) == null) {
            return;
        }
        dragImageView.setIsHeadImage(z);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.f12908h.setImageOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
            this.b0 = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.c0 = onLongClickListener;
            if (this.q) {
                return;
            }
            this.f12908h.setImageOnLongClickListener(onLongClickListener);
            this.j.setOnLongClickListener(this.c0);
        }
    }

    public void setIsCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.q = z;
        }
    }

    public void setIsCdn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.m = z;
        }
    }

    public void setOnSizeChangedListener(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) {
            this.f12908h.setOnSizeChangedListener(new h(this, kVar));
        }
    }

    public void setOriImgSelectedCallback(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, pVar) == null) {
            this.U = pVar;
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onTouchListener) == null) {
            this.V = onTouchListener;
        }
    }

    public void setUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, str, z) == null) {
            if (str.contains("*")) {
                str = str.split("[*]")[0];
            }
            this.f12908h.setTag(str);
            this.f12908h.setLoadBigImage(false);
            this.f12908h.setImageDrawable(null);
            this.n = false;
            this.o = false;
            this.O = E();
            this.i0 = null;
            if (V(str)) {
                U(str, z, false);
            }
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.j0 = str;
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
        this.f12905e = 3;
        this.f12907g = null;
        this.f12908h = null;
        this.l = null;
        this.m = false;
        this.p = false;
        this.w = false;
        this.x = 1.0f;
        this.y = 0.0f;
        this.z = new Matrix();
        this.B = new RectF();
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 1.0f;
        this.L = 1.0f;
        this.M = 0.0f;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.W = true;
        this.a0 = 0.0f;
        this.b0 = null;
        this.c0 = null;
        this.i0 = null;
        this.n0 = new f(this);
        this.o0 = new g(this);
        this.p0 = new k(this);
        this.f12906f = context;
        this.R = new d.a.r0.b0.b();
        N();
    }
}
