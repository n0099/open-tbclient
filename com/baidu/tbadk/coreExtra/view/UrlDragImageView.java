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
import c.a.q0.r.t.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_IMAGE_ACTIVITY_FINISH = "c13377";
    public static final String f0;
    public static long g0;
    public static final int h0;
    public static final int i0;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect A;
    public DragImageView.h B;
    public String C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public ImageUrlData I;
    public boolean J;
    public boolean K;
    public c.a.q0.c0.b L;
    public int M;
    public int N;
    public p O;
    public View.OnTouchListener P;
    public boolean Q;
    public float R;
    public View.OnClickListener S;
    public View.OnLongClickListener T;
    public String U;
    public String V;
    public CircleProgressView W;
    public boolean a0;
    public boolean b0;
    public Runnable c0;
    public Runnable d0;

    /* renamed from: e  reason: collision with root package name */
    public int f39509e;
    public View.OnTouchListener e0;

    /* renamed from: f  reason: collision with root package name */
    public SubsamplingScaleImageView.OnImageEventListener f39510f;

    /* renamed from: g  reason: collision with root package name */
    public o f39511g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39512h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f39513i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f39514j;
    public boolean k;
    public boolean l;
    public float m;
    public SubsamplingScaleImageView mBigImageView;
    public Context mContext;
    public TextView mImageTag;
    public DragImageView mImageView;
    public ProgressBar mProgressBar;
    public float n;
    public boolean needShowProcessView;
    public boolean o;
    public boolean p;
    public Bitmap q;
    public boolean r;
    public float s;
    public float t;
    public final Matrix u;
    public Rect v;
    public RectF w;
    public RectF x;
    public Rect y;
    public Rect z;

    /* loaded from: classes5.dex */
    public class a implements c.a.q0.b0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39515e;

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
            this.f39515e = urlDragImageView;
        }

        @Override // c.a.q0.b0.b
        public void imageLoaded(c.a.d.o.d.a aVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, aVar, str, z) == null) {
                this.f39515e.f39514j = true;
                this.f39515e.mProgressBar.setVisibility(8);
                this.f39515e.U = null;
                UrlDragImageView urlDragImageView = this.f39515e;
                DragImageView dragImageView = urlDragImageView.mImageView;
                if (dragImageView == null || dragImageView.isThreadStoped) {
                    return;
                }
                urlDragImageView.I(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.q0.e1.i.b.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.q0.e1.i.b.a
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mProgressBar.setVisibility(8);
                this.a.U = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f39516e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f39517f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39518g;

        public c(UrlDragImageView urlDragImageView, c.a.q0.r.t.a aVar, String str) {
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
            this.f39518g = urlDragImageView;
            this.f39516e = aVar;
            this.f39517f = str;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f39516e.dismiss();
                this.f39518g.T(this.f39517f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.r.t.a f39519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39520f;

        public d(UrlDragImageView urlDragImageView, c.a.q0.r.t.a aVar) {
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
            this.f39520f = urlDragImageView;
            this.f39519e = aVar;
        }

        @Override // c.a.q0.r.t.a.e
        public void onClick(c.a.q0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f39519e.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements c.a.q0.v.e {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.q0.v.e
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i2, str) == null) {
                this.a.W.setVisibility(8);
                this.a.K = false;
                BdToast c2 = BdToast.c(this.a.mContext, str);
                c2.a();
                c2.q();
                this.a.I.originalProcess = -1;
                this.a.showProcessView();
            }
        }

        @Override // c.a.q0.v.e
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.W.setVisibility(8);
                c.a.d.f.m.e.a().postDelayed(this.a.d0, 1500L);
                this.a.K = false;
                UrlDragImageView urlDragImageView = this.a;
                urlDragImageView.J = urlDragImageView.D();
                this.a.checkOriginalImg();
            }
        }

        @Override // c.a.q0.v.e
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.q0.v.e
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, downloadData) == null) || downloadData == null) {
                return;
            }
            if (this.a.I != null && this.a.I.originalProcess != -1) {
                this.a.I.originalProcess = downloadData.getProcess();
            }
            if (this.a.I == null || this.a.I.originalProcess != -1) {
                this.a.W.setProgress(downloadData.getProcess());
            }
        }

        @Override // c.a.q0.v.e
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39521e;

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
            this.f39521e = urlDragImageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f39521e.Q = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39522e;

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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    this.a.f39522e.W.setVisibility(8);
                    this.a.f39522e.U = null;
                    this.a.f39522e.needShowProcessView = false;
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
            this.f39522e = urlDragImageView;
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
        public final /* synthetic */ UrlDragImageView f39523b;

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
            this.f39523b = urlDragImageView;
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
                this.f39523b.S();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f39524e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Rect f39525f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39526g;

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
            this.f39526g = urlDragImageView;
            this.f39524e = rect;
            this.f39525f = rect2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) || valueAnimator == null || this.f39524e == null || this.f39525f == null) {
                return;
            }
            this.f39526g.A(valueAnimator.getAnimatedFraction());
            this.f39526g.B(this.f39525f, valueAnimator.getAnimatedFraction(), this.f39526g.b0);
            this.f39526g.invalidate();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39527e;

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
            this.f39527e = urlDragImageView;
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
                this.f39527e.r = false;
                this.f39527e.invalidate();
                if (this.f39527e.B != null) {
                    this.f39527e.B.b();
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UrlDragImageView f39528e;

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
            this.f39528e = urlDragImageView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (this.f39528e.P != null) {
                    this.f39528e.P.onTouch(view, motionEvent);
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
        public final /* synthetic */ UrlDragImageView f39529b;

        /* loaded from: classes5.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f39530e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PointF f39531f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ l f39532g;

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
                this.f39532g = lVar;
                this.f39530e = f2;
                this.f39531f = pointF;
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
                    if (this.f39532g.f39529b.P != null) {
                        this.f39532g.f39529b.P.onTouch(view, motionEvent);
                    }
                    int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                    if (action == 0) {
                        this.f39532g.f39529b.R = motionEvent.getY();
                        UrlDragImageView urlDragImageView = this.f39532g.f39529b;
                        urlDragImageView.mBigImageView.setOnClickListener(urlDragImageView.Q ? this.f39532g.f39529b.S : null);
                        UrlDragImageView urlDragImageView2 = this.f39532g.f39529b;
                        urlDragImageView2.mBigImageView.setOnLongClickListener(urlDragImageView2.Q ? this.f39532g.f39529b.T : null);
                    } else {
                        if (action != 1) {
                            if (action == 2) {
                                if (Math.abs(motionEvent.getY() - this.f39532g.f39529b.R) > UrlDragImageView.i0) {
                                    this.f39532g.f39529b.Q = false;
                                    this.f39532g.f39529b.mBigImageView.setOnClickListener(null);
                                    this.f39532g.f39529b.mBigImageView.setOnLongClickListener(null);
                                }
                                this.f39532g.f39529b.R = motionEvent.getY();
                            }
                        }
                        float scale = this.f39532g.f39529b.mBigImageView.getScale();
                        float f2 = this.f39530e;
                        if (scale < f2) {
                            this.f39532g.f39529b.mBigImageView.setScaleAndCenter(f2, this.f39531f);
                        }
                        c.a.d.f.m.e.a().removeCallbacks(this.f39532g.f39529b.c0);
                        c.a.d.f.m.e.a().postDelayed(this.f39532g.f39529b.c0, 1000L);
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
            this.f39529b = urlDragImageView;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f39529b.I.isLongPic && this.a[0] > 0) {
                this.f39529b.mImageView.onDestroy();
                float measuredWidth = (this.f39529b.getMeasuredWidth() * 1.0f) / this.a[0];
                PointF pointF = new PointF((this.a[0] * 1.0f) / 2.0f, 0.0f);
                this.f39529b.mBigImageView.setScaleAndCenter(measuredWidth, pointF);
                float f2 = 2.0f * measuredWidth;
                this.f39529b.mBigImageView.setMaxScale(f2);
                this.f39529b.mBigImageView.setDoubleTapZoomScale(f2);
                this.f39529b.mBigImageView.setInitScale(measuredWidth);
                this.f39529b.mBigImageView.setDoubleTapZoomStyle(4);
                this.f39529b.mBigImageView.setOnTouchListener(new a(this, measuredWidth, pointF));
                this.f39529b.mImageView.setVisibility(4);
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
                this.f39529b.U = null;
                this.f39529b.mProgressBar.setVisibility(8);
                this.f39529b.mImageView.restoreSize();
                this.f39529b.mImageView.setVisibility(4);
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
    public class m implements c.a.q0.e1.i.b.a {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = urlDragImageView;
        }

        @Override // c.a.q0.e1.i.b.a
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.a.k = false;
                this.a.mImageView.setVisibility(0);
                this.a.mProgressBar.setVisibility(8);
                this.a.U = null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.l.c
        public void onLoaded(c.a.d.o.d.a aVar, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar, str, i2) == null) {
                this.a.k = false;
                this.a.f39514j = true;
                UrlDragImageView urlDragImageView = this.a;
                DragImageView dragImageView = urlDragImageView.mImageView;
                if (dragImageView == null || dragImageView.isThreadStoped) {
                    return;
                }
                urlDragImageView.I(aVar);
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
        f0 = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
        g0 = 52428800L;
        h0 = c.a.d.f.p.n.i(TbadkCoreApplication.getInst()) / 5;
        i0 = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
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
        this.f39509e = 3;
        this.mProgressBar = null;
        this.mImageView = null;
        this.f39511g = null;
        this.f39512h = false;
        this.k = false;
        this.r = false;
        this.s = 1.0f;
        this.t = 0.0f;
        this.u = new Matrix();
        this.w = new RectF();
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 1.0f;
        this.G = 1.0f;
        this.H = 0.0f;
        this.J = false;
        this.K = false;
        this.needShowProcessView = false;
        this.Q = true;
        this.R = 0.0f;
        this.S = null;
        this.T = null;
        this.U = null;
        this.c0 = new f(this);
        this.d0 = new g(this);
        this.e0 = new k(this);
        this.mContext = context;
        this.L = new c.a.q0.c0.b();
        init();
    }

    private void setThumbBitmapToView(c.a.d.o.d.a aVar) {
        Bitmap p2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65558, this, aVar) == null) || this.f39514j || aVar == null || (p2 = aVar.p()) == null) {
            return;
        }
        this.f39513i = true;
        if (aVar.t()) {
            this.mImageView.setImageUrlData(this.I);
            this.mImageView.setImageBitmap(p2);
            this.U = null;
            this.needShowProcessView = false;
        } else {
            ImageUrlData imageUrlData = this.I;
            if (imageUrlData != null && imageUrlData.isLongPic) {
                this.mImageView.createLargeImageDelegate();
                this.mImageView.setImageLoadCallBack(new m(this));
            }
            this.mImageView.setImageUrlData(this.I);
            this.mImageView.setImageData(p2, aVar.k());
        }
        S();
    }

    public final void A(float f2) {
        Rect rect;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048576, this, f2) == null) || (rect = this.z) == null) {
            return;
        }
        Rect rect2 = this.A;
        rect.left = (int) (rect2.left + (rect2.width() * this.D * f2));
        Rect rect3 = this.z;
        Rect rect4 = this.A;
        rect3.top = (int) (rect4.top + (rect4.height() * this.E * f2));
        Rect rect5 = this.z;
        Rect rect6 = this.A;
        float f3 = this.F;
        float f4 = 1.0f - f2;
        rect5.right = (int) (rect6.left + (rect6.width() * (((1.0f - f3) * f4) + f3)));
        Rect rect7 = this.z;
        Rect rect8 = this.A;
        float f5 = this.G;
        rect7.bottom = (int) (rect8.top + (rect8.height() * (((1.0f - f5) * f4) + f5)));
    }

    public final void B(Rect rect, float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rect, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            int f3 = z ? c.a.d.f.p.n.f(getContext(), R.dimen.tbds80) : 0;
            RectF rectF = this.w;
            if (rectF == null || rect == null) {
                return;
            }
            RectF rectF2 = this.x;
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
            this.D = 0.0f;
            this.E = 0.0f;
            this.F = 1.0f;
            this.G = 1.0f;
            if (rect == null || rect2 == null || !rect.contains(rect2)) {
                return;
            }
            this.D = (rect2.left - rect.left) / rect.width();
            this.E = (rect2.top - rect.top) / rect.height();
            this.F = (rect2.right - rect.left) / rect.width();
            this.G = (rect2.bottom - rect.top) / rect.height();
        }
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageUrlData imageUrlData = this.I;
            if (imageUrlData != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.I;
                if (imageUrlData2.originalSize >= 0 && !imageUrlData2.isBlockedPic) {
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    if (new File(this.C + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + nameMd5FromUrl).exists()) {
                        this.I.originalProcess = 100;
                        return true;
                    }
                    int i2 = this.I.originalProcess;
                    if (i2 < 0) {
                        showProcessView();
                    } else {
                        this.W.setProgress(i2);
                    }
                    this.needShowProcessView = true;
                    return false;
                }
            }
            this.U = null;
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean E(boolean z) {
        InterceptResult invokeZ;
        ImageUrlData imageUrlData;
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            if (!this.K || z) {
                this.K = true;
                if (this.J && (imageUrlData = this.I) != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                    ImageUrlData imageUrlData2 = this.I;
                    if (imageUrlData2.originalSize >= 0 && Build.VERSION.SDK_INT >= 10) {
                        String str = this.C + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                        int[] imageFileWH = FileHelper.getImageFileWH(str);
                        this.mBigImageView.setVisibility(0);
                        if (this.f39510f == null) {
                            this.f39510f = new l(this, imageFileWH);
                        }
                        this.mBigImageView.setOnImageEventListener(this.f39510f);
                        if (this.mBigImageView.isImageLoaded() && this.I.isLongPic) {
                            this.f39510f.onImageLoaded();
                        } else {
                            this.mBigImageView.setImage(ImageSource.uri(str));
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

    public final boolean F(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.mBigImageView.getVisibility() != 0 || this.mBigImageView.isCanDrag()) {
                ImageUrlData imageUrlData = this.I;
                if (imageUrlData == null || !imageUrlData.isLongPic || this.mBigImageView.getVisibility() != 0 || this.mBigImageView.isViewTop()) {
                    ImageUrlData imageUrlData2 = this.I;
                    if (imageUrlData2 == null || !imageUrlData2.isLongPic || this.mBigImageView.getVisibility() == 0 || this.mImageView.isAtViewTop() || this.mImageView.isViewBottom()) {
                        if (this.mBigImageView.getVisibility() == 0 || this.mImageView.pagerCantScroll()) {
                            if (this.q != null && getScrollY() == 0) {
                                ImageUrlData imageUrlData3 = this.I;
                                boolean z = (imageUrlData3 == null || !imageUrlData3.isLongPic) && ((f3 < -15.0f && !this.r) || (f3 > 15.0f && !this.r));
                                ImageUrlData imageUrlData4 = this.I;
                                boolean z2 = imageUrlData4 != null && imageUrlData4.isLongPic && f3 < 0.0f && !this.r;
                                if (z || (z2 && this.mImageView.isViewTop())) {
                                    this.mImageView.setImageOnLongClickListener(null);
                                    this.mBigImageView.setOnLongClickListener(null);
                                    this.r = true;
                                    this.t = 0.0f;
                                    this.s = 1.0f;
                                    DragImageView.h hVar = this.B;
                                    if (hVar != null) {
                                        hVar.a();
                                    }
                                }
                            }
                            if (!this.r || this.q == null) {
                                return false;
                            }
                            this.t -= f3;
                            float measuredHeight = getMeasuredHeight();
                            if (this.t > measuredHeight) {
                                this.t = measuredHeight;
                            }
                            float f4 = f3 / measuredHeight;
                            Matrix matrix = this.u;
                            float f5 = this.s;
                            matrix.postTranslate((-f2) * 1.5f * f5, f3 * (-1.5f) * f5);
                            if (this.s * (f4 + 1.0f) > 1.0f || this.t < 0.0f) {
                                f4 = -f4;
                            }
                            float f6 = f4 + 1.0f;
                            this.u.preScale(f6, f6, (this.s * this.q.getWidth()) / 2.0f, this.s * (this.q.getHeight() / 2));
                            this.s *= f6;
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

    public final void G(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, rect) == null) || rect == null) {
            return;
        }
        float f2 = (rect.bottom - rect.top) / (rect.right - rect.left);
        RectF rectF = this.w;
        float f3 = f2 * (rectF.right - rectF.left);
        rectF.top += rectF.height() * this.H;
        RectF rectF2 = this.w;
        rectF2.bottom = rectF2.top + f3;
    }

    public final RectF H(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            float f6 = f4 / 2.0f;
            float f7 = f5 / 2.0f;
            return new RectF(f2 - f6, f3 - f7, f2 + f6, f3 + f7);
        }
        return (RectF) invokeCommon.objValue;
    }

    public final void I(c.a.d.o.d.a aVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && (oVar = this.f39511g) != null) {
                oVar.a(aVar.q(), aVar.k());
            }
            if (aVar != null && aVar.p() != null) {
                Bitmap p2 = aVar.p();
                this.mImageView.setLoadBigImage(true);
                if (aVar.t()) {
                    this.mImageView.setGifData(aVar.k(), p2);
                    this.mImageView.invalidate();
                    this.mImageView.play();
                    this.needShowProcessView = false;
                    this.U = null;
                    this.mProgressBar.setVisibility(8);
                } else {
                    ImageUrlData imageUrlData = this.I;
                    if (imageUrlData != null && imageUrlData.isLongPic) {
                        this.mImageView.createLargeImageDelegate();
                        this.mImageView.setImageLoadCallBack(new b(this));
                    } else {
                        this.mProgressBar.setVisibility(8);
                        this.U = null;
                    }
                    this.mImageView.setImageUrlData(this.I);
                    this.mImageView.setImageData(p2, aVar.k());
                    showProcessView();
                }
                S();
                return;
            }
            R();
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            CircleProgressView circleProgressView = new CircleProgressView(this.mContext);
            this.W = circleProgressView;
            circleProgressView.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            this.W.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.W.setProgress(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds80), c.a.d.f.p.n.f(getContext(), R.dimen.tbds80));
            layoutParams.addRule(13);
            this.W.setVisibility(8);
            addView(this.W, layoutParams);
        }
    }

    public final boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            DragImageView dragImageView = this.mImageView;
            return dragImageView != null && dragImageView.isLoadBigImage();
        }
        return invokeV.booleanValue;
    }

    public final boolean L(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048587, this, j2)) == null) ? j2 > g0 : invokeJ.booleanValue;
    }

    public final boolean M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://")) : invokeL.booleanValue;
    }

    public final boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!this.k && !this.f39514j) {
                if (this.mImageView.getImageBitmap() == null || !this.mImageView.isLoadBigImage()) {
                    return true;
                }
                ImageUrlData imageUrlData = this.I;
                if (imageUrlData != null && imageUrlData.isLongPic && !this.mImageView.hasLoadLongImage()) {
                    this.f39514j = false;
                    this.K = false;
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ImageUrlData imageUrlData = this.I;
            return (imageUrlData == null || !imageUrlData.mIsShowOrigonButton || imageUrlData.isBlockedPic || StringUtils.isNull(imageUrlData.originalUrl)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void P(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (M(str)) {
                if (z2 || !(this.k || this.f39514j)) {
                    if (z2 && E(true)) {
                        return;
                    }
                    this.k = true;
                    c.a.d.f.l.d.h().l(str, 27, new n(this), 0, 0, false, null, Boolean.valueOf(z), this.mImageView.getImageData(), Boolean.valueOf(this.f39512h));
                    return;
                }
                return;
            }
            this.mProgressBar.setVisibility(0);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(c.a.q0.c0.i.d.g(this.M, this.N));
            c.a.d.o.d.a c2 = this.L.c(imageFileInfo, false);
            if (c2 != null) {
                this.f39514j = true;
                this.mProgressBar.setVisibility(8);
                this.U = null;
                I(c2);
                return;
            }
            this.L.d(imageFileInfo, new a(this), false);
        }
    }

    public final boolean Q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? c.a.d.f.p.l.z() || BigImageLoaderProc.checkBigImageFileExist(str) : invokeL.booleanValue;
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!this.f39513i) {
                this.mImageView.setDefaultBitmap();
            } else {
                this.f39514j = false;
            }
            this.U = null;
            this.mProgressBar.setVisibility(8);
        }
    }

    public final void S() {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (!(this.f39513i || this.f39514j) || (imageUrlData = this.I) == null || imageUrlData.mPicType != 1 || TextUtils.isEmpty(imageUrlData.mTagName)) {
                return;
            }
            TextView textView = this.mImageTag;
            if (textView != null) {
                textView.setVisibility(8);
                this.mImageTag = null;
            }
            TextView textView2 = new TextView(this.mContext);
            this.mImageTag = textView2;
            textView2.setText(this.I.mTagName);
            this.mImageTag.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
            SkinManager.setViewTextColor(this.mImageTag, R.color.common_color_10013, 1, 0);
            SkinManager.setBackgroundColor(this.mImageTag, R.color.common_color_10215);
            this.mImageTag.setAlpha(0.75f);
            this.mImageTag.setIncludeFontPadding(false);
            this.mImageTag.setGravity(17);
            int f2 = c.a.d.f.p.n.f(this.mContext, R.dimen.ds2);
            this.mImageTag.setPadding(f2, f2, f2, f2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.mImageView.getBottomOffset();
            layoutParams.leftMargin = this.mImageView.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.mImageTag, layoutParams);
            this.mImageTag.setVisibility(0);
        }
    }

    public final void T(String str) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || (imageUrlData = this.I) == null) {
            return;
        }
        imageUrlData.originalProcess = 0;
        this.W.setProgress(0);
        this.W.setVisibility(0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.I.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.C + StorageFile.getInstance().getDirectoryName(str) + "/" + str);
        downloadData.setCallback(new e(this));
        c.a.q0.v.f.k().m(downloadData, 100);
        this.a0 = true;
    }

    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ImageUrlData imageUrlData = this.I;
            if (imageUrlData == null) {
                DragImageView.h hVar = this.B;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            Rect dstRectInScreen = this.I.getDstRectInScreen();
            if (sourceImageRectInScreen != null && dstRectInScreen != null) {
                C(sourceImageRectInScreen, dstRectInScreen);
                G(sourceImageRectInScreen);
                this.x = new RectF(this.w);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(150L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.addUpdateListener(new i(this, sourceImageRectInScreen, dstRectInScreen));
                ofFloat.addListener(new j(this));
                ofFloat.start();
                return;
            }
            DragImageView.h hVar2 = this.B;
            if (hVar2 != null) {
                hVar2.b();
            }
        }
    }

    public void checkImage(boolean z, boolean z2) {
        DragImageView dragImageView;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (dragImageView = this.mImageView) == null || (str = (String) dragImageView.getTag()) == null) {
            return;
        }
        if (this.mImageView.getImageType() == 1) {
            if (this.mImageView.getGifCache() == null || !this.mImageView.isLoadBigImage()) {
                P(str, z, z2);
            }
        } else if (this.mImageView.getImageType() == 2) {
            P(str, z, z2);
        } else if (N()) {
            P(str, z, z2);
        }
    }

    public void checkOriginalImg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            E(false);
        }
    }

    public void checkThumbImage() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.I == null || K()) {
            return;
        }
        ImageUrlData imageUrlData = this.I;
        String str = imageUrlData.imageUrl;
        int i2 = imageUrlData.urlType;
        c.a.d.o.d.a loadBdImageFromLocal = AbstractImageLoaderProc.isImageFileExist(str, i2) ? AbstractImageLoaderProc.loadBdImageFromLocal(str, i2) : null;
        if (loadBdImageFromLocal != null) {
            setThumbBitmapToView(loadBdImageFromLocal);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, canvas) == null) {
            if (this.o && (bitmap2 = this.q) != null && !bitmap2.isRecycled() && this.r) {
                canvas.drawColor(Color.argb((int) (this.s * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.w == null) {
                    this.w = new RectF();
                }
                this.u.mapRect(this.w, new RectF(this.v));
                canvas.drawBitmap(this.q, this.y, this.w, (Paint) null);
            } else if (this.p && (bitmap = this.q) != null && !bitmap.isRecycled()) {
                canvas.drawColor(Color.argb((int) (this.s * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                ImageUrlData imageUrlData = this.I;
                if (imageUrlData != null && imageUrlData.getSourceImageRectInScreen() != null) {
                    canvas.drawBitmap(this.q, this.z, this.w, (Paint) null);
                } else {
                    canvas.drawBitmap(this.q, this.y, this.w, (Paint) null);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            if (this.J && !this.a0 && this.mBigImageView.getVisibility() == 0 && !this.mBigImageView.isImageLoaded()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.l && this.f39514j) {
                if (!this.o && motionEvent.getPointerCount() >= 2) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.o || this.p) {
                    requestDisallowInterceptTouchEvent(true);
                }
                int action = motionEvent.getAction();
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                int i3 = action & 255;
                if (i3 == 0) {
                    if (this.q == null) {
                        if (this.mBigImageView.getVisibility() == 0) {
                            this.q = c.a.q0.c1.m.c(this.mBigImageView);
                        } else {
                            this.q = c.a.q0.c1.m.c(this.mImageView);
                        }
                    }
                    if (this.v == null && this.q != null) {
                        int measuredWidth = getMeasuredWidth();
                        float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.q.getWidth()) * this.q.getHeight();
                        if (measuredWidth2 > getMeasuredHeight()) {
                            measuredWidth2 = getMeasuredHeight();
                        }
                        RectF H = H(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                        this.v = new Rect((int) H.left, (int) H.top, (int) H.right, (int) H.bottom);
                    }
                    if (this.z == null && this.q != null) {
                        if (this.mBigImageView.getVisibility() == 0) {
                            i2 = this.mBigImageView.getSHeight();
                            width = this.mBigImageView.getSWidth();
                        } else {
                            if (this.mImageView.getImageType() == 1) {
                                imageBitmap = (this.mImageView.getCurrentFrame() == null || this.mImageView.getCurrentFrame().a == null) ? this.q : this.mImageView.getCurrentFrame().a;
                            } else {
                                imageBitmap = this.mImageView.getImageBitmap() == null ? this.q : this.mImageView.getImageBitmap();
                            }
                            int height = imageBitmap.getHeight();
                            width = imageBitmap.getWidth();
                            i2 = height;
                        }
                        float h2 = c.a.d.f.p.n.h(getContext());
                        int i4 = (int) (i2 * h2);
                        int i5 = (int) (width * h2);
                        if (i5 > this.q.getWidth() && this.q.getWidth() != 0) {
                            i4 = (int) (i4 / ((i5 * 1.0f) / this.q.getWidth()));
                            i5 = this.q.getWidth();
                        }
                        if (i4 > this.q.getHeight() && this.q.getHeight() != 0) {
                            i5 = (int) (i5 / ((i4 * 1.0f) / this.q.getHeight()));
                            i4 = this.q.getHeight();
                        }
                        int i6 = (c.a.d.f.p.n.i(getContext()) - i4) / 2;
                        int k2 = (c.a.d.f.p.n.k(getContext()) - i5) / 2;
                        this.z = new Rect(k2, i6, i5 + k2, i4 + i6);
                        this.A = new Rect(this.z);
                        this.H = i6 / c.a.d.f.p.n.i(getContext());
                        this.y = new Rect(0, 0, this.q.getWidth(), this.q.getHeight());
                    }
                    this.m = x;
                    this.n = y;
                }
                if (i3 == 2) {
                    this.o = F(this.m - x, this.n - y);
                    this.m = x;
                    this.n = y;
                }
                if (!this.o && !this.p) {
                    this.mImageView.setImageOnLongClickListener(this.T);
                    this.mBigImageView.setOnLongClickListener(this.T);
                    z = super.dispatchTouchEvent(motionEvent);
                } else {
                    this.mImageView.setImageOnLongClickListener(null);
                    this.mBigImageView.setOnLongClickListener(null);
                    z = true;
                }
                if (i3 == 1 || i3 == 3) {
                    this.m = 0.0f;
                    this.n = 0.0f;
                    boolean z2 = (-this.t) > ((float) (h0 * 2));
                    boolean z3 = this.t > ((float) h0);
                    if (!z2 && !z3) {
                        if (this.o && (hVar = this.B) != null) {
                            hVar.c();
                        }
                        this.s = 1.0f;
                        invalidate();
                    } else {
                        this.p = true;
                        U();
                        if (z2) {
                            TiebaStatic.log(new StatisticItem(KEY_IMAGE_ACTIVITY_FINISH).param("obj_type", "3"));
                        } else if (z3) {
                            TiebaStatic.log(new StatisticItem(KEY_IMAGE_ACTIVITY_FINISH).param("obj_type", "2"));
                        }
                    }
                    this.r = false;
                    this.u.reset();
                    this.o = false;
                }
                return z;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void downloadOriginPic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(this.I.originalUrl);
            if (this.I.originalProcess >= 0) {
                c.a.q0.v.f.k().f(nameMd5FromUrl, 13);
                this.I.originalProcess = -1;
                showProcessView();
                return;
            }
            p pVar = this.O;
            if (pVar != null) {
                pVar.a();
            }
            c.a.d.a.f<?> a2 = c.a.d.a.j.a(this.mContext);
            if (a2 == null) {
                T(nameMd5FromUrl);
            } else if (c.a.d.f.p.l.z() && !c.a.d.f.p.l.H() && !c.a.q0.r.j0.b.k().h("original_img_down_tip", false)) {
                c.a.q0.r.j0.b.k().u("original_img_down_tip", true);
                c.a.q0.r.t.a aVar = new c.a.q0.r.t.a(a2.getPageActivity());
                aVar.setMessageId(R.string.original_img_down_no_wifi_tip);
                aVar.setPositiveButton(R.string.alert_yes_button, new c(this, aVar, nameMd5FromUrl));
                aVar.setNegativeButton(R.string.cancel, new d(this, aVar));
                aVar.create(a2);
                aVar.show();
            } else {
                T(nameMd5FromUrl);
            }
        }
    }

    public DragImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mImageView : (DragImageView) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public ImageUrlData getmAssistUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.I : (ImageUrlData) invokeV.objValue;
    }

    public String getmCheckOriginPicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.U : (String) invokeV.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.C = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
            this.M = c.a.d.f.p.n.k(this.mContext);
            this.N = c.a.d.f.p.n.i(this.mContext) - ((int) this.mContext.getResources().getDimension(R.dimen.ds166));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            DragImageView dragImageView = new DragImageView(this.mContext);
            this.mImageView = dragImageView;
            dragImageView.setLayoutParams(layoutParams);
            this.mImageView.setOnTouchListener(this.e0);
            addView(this.mImageView);
            SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(this.mContext);
            this.mBigImageView = subsamplingScaleImageView;
            subsamplingScaleImageView.setMaxScale(50.0f);
            this.mBigImageView.setOnTouchListener(this.e0);
            this.mBigImageView.setVisibility(4);
            addView(this.mBigImageView, layoutParams);
            ProgressBar progressBar = new ProgressBar(this.mContext, null, 16843399);
            this.mProgressBar = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.mProgressBar.setLayoutParams(layoutParams2);
            this.mProgressBar.setIndeterminate(true);
            addView(this.mProgressBar);
            J();
            this.b0 = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
        }
    }

    public void jumpToPB() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.I == null) {
            return;
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
        String valueOf = String.valueOf(this.I.threadId);
        String valueOf2 = String.valueOf(this.I.postId);
        ImageUrlData imageUrlData = this.I;
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig.createHistoryCfg(valueOf, valueOf2, imageUrlData.mIsSeeHost, imageUrlData.mIsReserver, null)));
    }

    public void notifyIsFullScreenMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048610, this, i2) == null) || this.f39509e == i2) {
            return;
        }
        this.f39509e = i2;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            DragImageView dragImageView = this.mImageView;
            if (dragImageView != null) {
                dragImageView.onDestroy();
            }
            SubsamplingScaleImageView subsamplingScaleImageView = this.mBigImageView;
            if (subsamplingScaleImageView != null) {
                subsamplingScaleImageView.recycle();
            }
            Bitmap bitmap = this.q;
            if (bitmap != null) {
                bitmap.recycle();
                this.q = null;
            }
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar != null) {
                this.U = null;
                progressBar.setVisibility(8);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.c0);
            c.a.r0.o4.b.a().d(-1);
            ImageUrlData imageUrlData = this.I;
            if (imageUrlData != null) {
                c.a.q0.v.f.k().f(TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl), 13);
            }
        }
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            DragImageView dragImageView = this.mImageView;
            if (dragImageView != null) {
                dragImageView.release();
            }
            ProgressBar progressBar = this.mProgressBar;
            if (progressBar != null) {
                this.U = null;
                progressBar.setVisibility(8);
            }
            this.U = null;
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, imageUrlData) == null) {
            this.I = imageUrlData;
        }
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, oVar) == null) {
            this.f39511g = oVar;
        }
    }

    public void setCanScale(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048615, this, z) == null) || (dragImageView = this.mImageView) == null) {
            return;
        }
        dragImageView.setCanScale(z);
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, hVar) == null) {
            this.B = hVar;
            DragImageView dragImageView = this.mImageView;
            if (dragImageView != null) {
                dragImageView.setDragToExitListener(hVar);
            }
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.mImageView.setGifMaxUseableMem(i2);
        }
    }

    public void setGifSetListener(DragImageView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, iVar) == null) {
            this.mImageView.setGifSetListener(iVar);
        }
    }

    public void setHeadImage(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048619, this, z) == null) || (dragImageView = this.mImageView) == null) {
            return;
        }
        dragImageView.setIsHeadImage(z);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, onClickListener) == null) {
            this.mImageView.setImageOnClickListener(onClickListener);
            this.mBigImageView.setOnClickListener(onClickListener);
            this.S = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onLongClickListener) == null) {
            this.T = onLongClickListener;
            if (this.l) {
                return;
            }
            this.mImageView.setImageOnLongClickListener(onLongClickListener);
            this.mBigImageView.setOnLongClickListener(this.T);
        }
    }

    public void setIsCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.l = z;
        }
    }

    public void setIsCdn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.f39512h = z;
        }
    }

    public void setOnSizeChangedListener(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, kVar) == null) {
            this.mImageView.setOnSizeChangedListener(new h(this, kVar));
        }
    }

    public void setOriImgSelectedCallback(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, pVar) == null) {
            this.O = pVar;
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onTouchListener) == null) {
            this.P = onTouchListener;
        }
    }

    public void setUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048627, this, str, z) == null) {
            if (str.contains("*")) {
                str = str.split("[*]")[0];
            }
            this.mImageView.setTag(str);
            this.mImageView.setLoadBigImage(false);
            this.mImageView.setImageDrawable(null);
            this.f39513i = false;
            this.f39514j = false;
            this.J = D();
            this.U = null;
            if (Q(str)) {
                P(str, z, false);
            }
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.V = str;
        }
    }

    public void showProcessView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || this.I == null) {
            return;
        }
        if (O() && this.needShowProcessView) {
            long j2 = this.I.originalSize;
            if (j2 > 0 && !L(j2)) {
                this.U = f0 + "(" + StringHelper.getFormatSize(this.I.originalSize) + SmallTailInfo.EMOTION_SUFFIX;
                return;
            }
            this.U = f0;
            return;
        }
        this.U = null;
    }

    public void stopGif() {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && (dragImageView = this.mImageView) != null && dragImageView.getImageType() == 1) {
            this.mImageView.stop();
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
        this.f39509e = 3;
        this.mProgressBar = null;
        this.mImageView = null;
        this.f39511g = null;
        this.f39512h = false;
        this.k = false;
        this.r = false;
        this.s = 1.0f;
        this.t = 0.0f;
        this.u = new Matrix();
        this.w = new RectF();
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = 1.0f;
        this.G = 1.0f;
        this.H = 0.0f;
        this.J = false;
        this.K = false;
        this.needShowProcessView = false;
        this.Q = true;
        this.R = 0.0f;
        this.S = null;
        this.T = null;
        this.U = null;
        this.c0 = new f(this);
        this.d0 = new g(this);
        this.e0 = new k(this);
        this.mContext = context;
        this.L = new c.a.q0.c0.b();
        init();
    }
}
