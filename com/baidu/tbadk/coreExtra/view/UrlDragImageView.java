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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.bn5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.en5;
import com.baidu.tieba.fxa;
import com.baidu.tieba.ki5;
import com.baidu.tieba.li5;
import com.baidu.tieba.m9;
import com.baidu.tieba.on5;
import com.baidu.tieba.q06;
import com.baidu.tieba.tw5;
import com.baidu.tieba.z45;
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
/* loaded from: classes4.dex */
public class UrlDragImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final String i0;
    public static long j0;
    public static final int r0;
    public static final int s0;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect A;
    public Rect B;
    public Rect C;
    public DragImageView.h D;
    public String E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public ImageUrlData K;
    public boolean L;
    public boolean M;
    public boolean N;
    public en5 O;
    public int P;
    public int Q;
    public p R;
    public View.OnTouchListener S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1081T;
    public float U;
    public View.OnClickListener V;
    public View.OnLongClickListener W;
    public int a;
    public String a0;
    public Context b;
    public String b0;
    public ProgressBar c;
    public CircleProgressView c0;
    public DragImageView d;
    public boolean d0;
    public DragImageView e;
    public boolean e0;
    public TextView f;
    public Runnable f0;
    public SubsamplingScaleImageView g;
    public Runnable g0;
    public SubsamplingScaleImageView.OnImageEventListener h;
    public View.OnTouchListener h0;
    public o i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public boolean q;
    public boolean r;
    public Bitmap s;
    public int t;
    public float u;
    public float v;
    public final Matrix w;
    public Rect x;
    public RectF y;
    public RectF z;

    /* loaded from: classes4.dex */
    public interface o {
        void a(String str, byte[] bArr);
    }

    /* loaded from: classes4.dex */
    public interface p {
        void a();
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        /* loaded from: classes4.dex */
        public class a implements Animation.AnimationListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

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
                    this.a.a.c0.setVisibility(8);
                    this.a.a.a0 = null;
                    this.a.a.N = false;
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

    /* loaded from: classes4.dex */
    public class l implements SubsamplingScaleImageView.OnImageEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int[] a;
        public final /* synthetic */ UrlDragImageView b;

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, exc) == null) {
            }
        }

        /* loaded from: classes4.dex */
        public class a implements View.OnTouchListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ float a;
            public final /* synthetic */ PointF b;
            public final /* synthetic */ l c;

            public a(l lVar, float f, PointF pointF) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {lVar, Float.valueOf(f), pointF};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = lVar;
                this.a = f;
                this.b = pointF;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
                if (r5 != 3) goto L14;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                InterceptResult invokeLL;
                View.OnClickListener onClickListener;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                    if (this.c.b.S != null) {
                        this.c.b.S.onTouch(view2, motionEvent);
                    }
                    int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                    View.OnLongClickListener onLongClickListener = null;
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (Math.abs(motionEvent.getY() - this.c.b.U) > UrlDragImageView.s0) {
                                    this.c.b.f1081T = false;
                                    this.c.b.g.setOnClickListener(null);
                                    this.c.b.g.setOnLongClickListener(null);
                                }
                                this.c.b.U = motionEvent.getY();
                            }
                        }
                        float scale = this.c.b.g.getScale();
                        float f = this.a;
                        if (scale < f) {
                            this.c.b.g.setScaleAndCenter(f, this.b);
                        }
                        SafeHandler.getInst().removeCallbacks(this.c.b.f0);
                        SafeHandler.getInst().postDelayed(this.c.b.f0, 1000L);
                    } else {
                        this.c.b.U = motionEvent.getY();
                        UrlDragImageView urlDragImageView = this.c.b;
                        SubsamplingScaleImageView subsamplingScaleImageView = urlDragImageView.g;
                        if (!urlDragImageView.f1081T) {
                            onClickListener = null;
                        } else {
                            onClickListener = this.c.b.V;
                        }
                        subsamplingScaleImageView.setOnClickListener(onClickListener);
                        UrlDragImageView urlDragImageView2 = this.c.b;
                        SubsamplingScaleImageView subsamplingScaleImageView2 = urlDragImageView2.g;
                        if (urlDragImageView2.f1081T) {
                            onLongClickListener = this.c.b.W;
                        }
                        subsamplingScaleImageView2.setOnLongClickListener(onLongClickListener);
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
            this.b = urlDragImageView;
            this.a = iArr;
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.K.isLongPic && this.a[0] > 0) {
                this.b.d.d0();
                float measuredWidth = (this.b.getMeasuredWidth() * 1.0f) / this.a[0];
                PointF pointF = new PointF((this.a[0] * 1.0f) / 2.0f, 0.0f);
                this.b.g.setScaleAndCenter(measuredWidth, pointF);
                float f = 2.0f * measuredWidth;
                this.b.g.setMaxScale(f);
                this.b.g.setDoubleTapZoomScale(f);
                this.b.g.setInitScale(measuredWidth);
                this.b.g.setDoubleTapZoomStyle(4);
                this.b.g.setOnTouchListener(new a(this, measuredWidth, pointF));
                this.b.d.setVisibility(4);
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.b.a0 = null;
            this.b.c.setVisibility(8);
            this.b.e.setVisibility(8);
            this.b.d.q0();
            this.b.d.setVisibility(4);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements bn5 {
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

        @Override // com.baidu.tieba.bn5
        public void a(BdImage bdImage, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLZ(1048576, this, bdImage, str, z) != null) {
                return;
            }
            this.a.l = true;
            this.a.c.setVisibility(8);
            this.a.e.setVisibility(8);
            this.a.a0 = null;
            UrlDragImageView urlDragImageView = this.a;
            DragImageView dragImageView = urlDragImageView.d;
            if (dragImageView == null || dragImageView.r0) {
                return;
            }
            urlDragImageView.M(bdImage);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements q06 {
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

        @Override // com.baidu.tieba.q06
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.setVisibility(8);
                this.a.e.setVisibility(8);
                this.a.a0 = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z45 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ UrlDragImageView c;

        public c(UrlDragImageView urlDragImageView, z45 z45Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, z45Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = urlDragImageView;
            this.a = z45Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                this.a.dismiss();
                this.c.d0(this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements z45.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z45 a;
        public final /* synthetic */ UrlDragImageView b;

        public d(UrlDragImageView urlDragImageView, z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, z45Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = urlDragImageView;
            this.a = z45Var;
        }

        @Override // com.baidu.tieba.z45.e
        public void onClick(z45 z45Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ki5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        @Override // com.baidu.tieba.ki5
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.ki5
        public boolean onPreDownload(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

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

        @Override // com.baidu.tieba.ki5
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                this.a.c0.setVisibility(8);
                this.a.M = false;
                BdToast.makeText(this.a.b, str).show();
                this.a.K.originalProcess = -1;
                this.a.c0();
            }
        }

        @Override // com.baidu.tieba.ki5
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.c0.setVisibility(8);
                SafeHandler.getInst().postDelayed(this.a.g0, 1500L);
                this.a.M = false;
                UrlDragImageView urlDragImageView = this.a;
                urlDragImageView.L = urlDragImageView.E();
                this.a.F();
            }
        }

        @Override // com.baidu.tieba.ki5
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) || downloadData == null) {
                return;
            }
            if (this.a.K != null && this.a.K.originalProcess != -1) {
                this.a.K.originalProcess = downloadData.getProcess();
            }
            if (this.a.K == null || this.a.K.originalProcess != -1) {
                this.a.c0.setProgress(downloadData.getProcess());
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.f1081T = true;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements DragImageView.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DragImageView.k a;
        public final /* synthetic */ UrlDragImageView b;

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
            this.b = urlDragImageView;
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
                this.b.b0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Rect a;
        public final /* synthetic */ Rect b;
        public final /* synthetic */ UrlDragImageView c;

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
            this.c = urlDragImageView;
            this.a = rect;
            this.b = rect2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, valueAnimator) != null) || valueAnimator == null || this.a == null || this.b == null) {
                return;
            }
            this.c.A(valueAnimator.getAnimatedFraction());
            this.c.B(this.b, valueAnimator.getAnimatedFraction(), this.c.e0);
            this.c.invalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) != null) {
                return;
            }
            this.a.t = 0;
            this.a.invalidate();
            if (this.a.D != null) {
                this.a.D.b();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.S != null) {
                    this.a.S.onTouch(view2, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements q06 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        @Override // com.baidu.tieba.q06
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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
    }

    /* loaded from: classes4.dex */
    public class n extends BdResourceCallback<BdImage> {
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

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.m = false;
            this.a.d.setVisibility(0);
            this.a.c.setVisibility(8);
            this.a.a0 = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) != null) {
                return;
            }
            this.a.m = false;
            this.a.l = true;
            UrlDragImageView urlDragImageView = this.a;
            DragImageView dragImageView = urlDragImageView.d;
            if (dragImageView == null || dragImageView.r0) {
                return;
            }
            urlDragImageView.M(bdImage);
        }
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
        i0 = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
        j0 = 52428800L;
        r0 = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst()) / 5;
        s0 = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            String str = (String) this.d.getTag();
            if (str == null || T()) {
                return false;
            }
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(on5.g(this.P, this.Q));
            if (this.O.c(imageFileInfo, false) != null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            CircleProgressView circleProgressView = new CircleProgressView(this.b);
            this.c0 = circleProgressView;
            circleProgressView.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            this.c0.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.c0.setProgress(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BdUtilHelper.getDimens(getContext(), R.dimen.tbds80), BdUtilHelper.getDimens(getContext(), R.dimen.tbds80));
            layoutParams.addRule(13);
            this.c0.setVisibility(8);
            addView(this.c0, layoutParams);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            DragImageView dragImageView = this.d;
            if (dragImageView != null) {
                dragImageView.d0();
            }
            SubsamplingScaleImageView subsamplingScaleImageView = this.g;
            if (subsamplingScaleImageView != null) {
                subsamplingScaleImageView.recycle();
            }
            Bitmap bitmap = this.s;
            if (bitmap != null) {
                bitmap.recycle();
                this.s = null;
            }
            ProgressBar progressBar = this.c;
            if (progressBar != null) {
                this.a0 = null;
                progressBar.setVisibility(8);
            }
            DragImageView dragImageView2 = this.e;
            if (dragImageView2 != null) {
                dragImageView2.setVisibility(8);
            }
            SafeHandler.getInst().removeCallbacks(this.f0);
            fxa.a().d(-1);
            ImageUrlData imageUrlData = this.K;
            if (imageUrlData != null) {
                li5.k().f(TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl), 13);
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || this.K == null) {
            return;
        }
        if (U() && this.N) {
            long j2 = this.K.originalSize;
            if (j2 > 0 && !R(j2)) {
                this.a0 = i0 + "(" + StringHelper.getFormatSize(this.K.originalSize) + SmallTailInfo.EMOTION_SUFFIX;
                return;
            }
            this.a0 = i0;
            return;
        }
        this.a0 = null;
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
        this.c = null;
        this.d = null;
        this.e = null;
        this.i = null;
        this.j = false;
        this.m = false;
        this.t = 0;
        this.u = 1.0f;
        this.v = 0.0f;
        this.w = new Matrix();
        this.y = new RectF();
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 1.0f;
        this.I = 1.0f;
        this.J = 0.0f;
        this.L = false;
        this.M = false;
        this.N = false;
        this.f1081T = true;
        this.U = 0.0f;
        this.V = null;
        this.W = null;
        this.a0 = null;
        this.f0 = new f(this);
        this.g0 = new g(this);
        this.h0 = new k(this);
        this.b = context;
        this.O = new en5();
        O();
    }

    public final boolean G(boolean z) {
        InterceptResult invokeZ;
        ImageUrlData imageUrlData;
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (this.M && !z) {
                return false;
            }
            this.M = true;
            if (this.L && (imageUrlData = this.K) != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.K;
                if (imageUrlData2.originalSize >= 0 && Build.VERSION.SDK_INT >= 10) {
                    String str = this.E + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    int[] imageFileWH = FileHelper.getImageFileWH(str);
                    this.g.setVisibility(0);
                    if (this.h == null) {
                        this.h = new l(this, imageFileWH);
                    }
                    this.g.setOnImageEventListener(this.h);
                    if (this.g.isImageLoaded() && this.K.isLongPic) {
                        this.h.onImageLoaded();
                    } else {
                        this.g.setImage(ImageSource.uri(str));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void M(BdImage bdImage) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdImage) == null) {
            if (bdImage != null && (oVar = this.i) != null) {
                oVar.a(bdImage.getUrl(), bdImage.getByteData());
            }
            if (bdImage != null && bdImage.getRawBitmap() != null) {
                Bitmap rawBitmap = bdImage.getRawBitmap();
                this.d.setLoadBigImage(true);
                if (bdImage.isGif()) {
                    this.d.setGifData(bdImage.getByteData(), rawBitmap);
                    this.d.setImageUrlData(this.K);
                    this.d.invalidate();
                    this.d.i0();
                    this.N = false;
                    this.a0 = null;
                    this.c.setVisibility(8);
                    this.e.setVisibility(8);
                } else {
                    ImageUrlData imageUrlData = this.K;
                    if (imageUrlData != null && imageUrlData.isLongPic) {
                        this.d.U();
                        this.d.setImageLoadCallBack(new b(this));
                    } else {
                        this.c.setVisibility(8);
                        this.e.setVisibility(8);
                        this.a0 = null;
                    }
                    this.d.setImageUrlData(this.K);
                    this.d.setImageData(rawBitmap, bdImage.getByteData());
                    c0();
                }
                b0();
                return;
            }
            a0();
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
        this.c = null;
        this.d = null;
        this.e = null;
        this.i = null;
        this.j = false;
        this.m = false;
        this.t = 0;
        this.u = 1.0f;
        this.v = 0.0f;
        this.w = new Matrix();
        this.y = new RectF();
        this.F = 0.0f;
        this.G = 0.0f;
        this.H = 1.0f;
        this.I = 1.0f;
        this.J = 0.0f;
        this.L = false;
        this.M = false;
        this.N = false;
        this.f1081T = true;
        this.U = 0.0f;
        this.V = null;
        this.W = null;
        this.a0 = null;
        this.f0 = new f(this);
        this.g0 = new g(this);
        this.h0 = new k(this);
        this.b = context;
        this.O = new en5();
        O();
    }

    public final boolean R(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
            if (j2 > j0) {
                return true;
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public final boolean S(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable() && !BigImageLoaderProc.checkBigImageFileExist(str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && this.a != i2) {
            this.a = i2;
        }
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, imageUrlData) == null) {
            this.K = imageUrlData;
        }
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, oVar) == null) {
            this.i = oVar;
        }
    }

    public void setCanScale(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048616, this, z) == null) && (dragImageView = this.d) != null) {
            dragImageView.setCanScale(z);
        }
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, hVar) == null) {
            this.D = hVar;
            DragImageView dragImageView = this.d;
            if (dragImageView != null) {
                dragImageView.setDragToExitListener(hVar);
            }
        }
    }

    public void setGifMaxUseableMem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.d.setGifMaxUseableMem(i2);
        }
    }

    public void setGifSetListener(DragImageView.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, iVar) == null) {
            this.d.setGifSetListener(iVar);
        }
    }

    public void setHeadImage(boolean z) {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z) == null) && (dragImageView = this.d) != null) {
            dragImageView.setIsHeadImage(z);
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, onClickListener) == null) {
            this.d.setImageOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.V = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onLongClickListener) == null) {
            this.W = onLongClickListener;
            if (!this.n) {
                this.d.setImageOnLongClickListener(onLongClickListener);
                this.g.setOnLongClickListener(this.W);
            }
        }
    }

    public void setIsCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.n = z;
        }
    }

    public void setIsCdn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.j = z;
        }
    }

    public void setOnSizeChangedListener(DragImageView.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, kVar) == null) {
            this.d.setOnSizeChangedListener(new h(this, kVar));
        }
    }

    public void setOriImgSelectedCallback(p pVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, pVar) == null) {
            this.R = pVar;
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onTouchListener) == null) {
            this.S = onTouchListener;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.b0 = str;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G(false);
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DragImageView dragImageView = this.d;
            if (dragImageView != null && dragImageView.a0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ImageUrlData imageUrlData = this.K;
            if (imageUrlData == null || !imageUrlData.mIsShowOrigonButton || imageUrlData.isBlockedPic || StringUtils.isNull(imageUrlData.originalUrl)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            DragImageView dragImageView = this.d;
            if (dragImageView != null) {
                dragImageView.m0();
            }
            ProgressBar progressBar = this.c;
            if (progressBar != null) {
                this.a0 = null;
                progressBar.setVisibility(8);
            }
            DragImageView dragImageView2 = this.e;
            if (dragImageView2 != null) {
                dragImageView2.setVisibility(8);
                this.e.m0();
            }
            this.a0 = null;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!this.k) {
                this.d.setDefaultBitmap();
            } else {
                this.l = false;
            }
            this.a0 = null;
            this.c.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void f0() {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (dragImageView = this.d) != null && dragImageView.getImageType() == 1) {
            this.d.t0();
        }
    }

    public DragImageView getImageView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.d;
        }
        return (DragImageView) invokeV.objValue;
    }

    public String getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.b0;
        }
        return (String) invokeV.objValue;
    }

    public ImageUrlData getmAssistUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.K;
        }
        return (ImageUrlData) invokeV.objValue;
    }

    public String getmCheckOriginPicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.a0;
        }
        return (String) invokeV.objValue;
    }

    private void setThumbBitmapToView(BdImage bdImage) {
        Bitmap rawBitmap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, this, bdImage) == null) && !this.l && bdImage != null && (rawBitmap = bdImage.getRawBitmap()) != null) {
            this.k = true;
            if (bdImage.isGif()) {
                this.e.setImageUrlData(this.K);
                this.e.setImageBitmap(rawBitmap);
                this.a0 = null;
                this.N = false;
            } else {
                ImageUrlData imageUrlData = this.K;
                if (imageUrlData != null && imageUrlData.isLongPic) {
                    this.e.U();
                    this.e.setImageLoadCallBack(new m(this));
                }
                this.e.setImageUrlData(this.K);
                this.e.setImageData(rawBitmap, bdImage.getByteData());
            }
            b0();
        }
    }

    public final void A(float f2) {
        Rect rect;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048576, this, f2) == null) && (rect = this.B) != null) {
            Rect rect2 = this.C;
            rect.left = (int) (rect2.left + (rect2.width() * this.F * f2));
            Rect rect3 = this.B;
            Rect rect4 = this.C;
            rect3.top = (int) (rect4.top + (rect4.height() * this.G * f2));
            Rect rect5 = this.B;
            Rect rect6 = this.C;
            float f3 = this.H;
            float f4 = 1.0f - f2;
            rect5.right = (int) (rect6.left + (rect6.width() * (((1.0f - f3) * f4) + f3)));
            Rect rect7 = this.B;
            Rect rect8 = this.C;
            float f5 = this.I;
            rect7.bottom = (int) (rect8.top + (rect8.height() * (((1.0f - f5) * f4) + f5)));
        }
    }

    public final void d0(String str) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, str) != null) || (imageUrlData = this.K) == null) {
            return;
        }
        imageUrlData.originalProcess = 0;
        this.c0.setProgress(0);
        this.c0.setVisibility(0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.K.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.E + StorageFile.getInstance().getDirectoryName(str) + "/" + str);
        downloadData.setCallback(new e(this));
        li5.k().m(downloadData, 100);
        this.d0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, canvas) == null) {
            if (this.q && (bitmap2 = this.s) != null && !bitmap2.isRecycled() && this.t >= 2) {
                canvas.drawColor(Color.argb((int) (this.u * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                if (this.y == null) {
                    this.y = new RectF();
                }
                this.w.mapRect(this.y, new RectF(this.x));
                canvas.drawBitmap(this.s, this.A, this.y, (Paint) null);
            } else if (this.r && (bitmap = this.s) != null && !bitmap.isRecycled()) {
                canvas.drawColor(Color.argb((int) (this.u * 255.0f), 0, 0, 0), PorterDuff.Mode.SRC);
                ImageUrlData imageUrlData = this.K;
                if (imageUrlData != null && imageUrlData.getSourceImageRectInScreen() != null) {
                    canvas.drawBitmap(this.s, this.B, this.y, (Paint) null);
                } else {
                    canvas.drawBitmap(this.s, this.A, this.y, (Paint) null);
                }
            } else {
                super.dispatchDraw(canvas);
            }
        }
    }

    public final void B(Rect rect, float f2, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rect, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                i2 = BdUtilHelper.getDimens(getContext(), R.dimen.tbds80);
            } else {
                i2 = 0;
            }
            RectF rectF = this.y;
            if (rectF != null && rect != null) {
                RectF rectF2 = this.z;
                float f3 = rectF2.left;
                rectF.left = f3 + ((rect.left - f3) * f2);
                float f4 = rectF2.top;
                rectF.top = (f4 + ((rect.top - f4) * f2)) - i2;
                float f5 = rectF2.right;
                rectF.right = f5 + ((rect.right - f5) * f2);
                float f6 = rectF2.bottom;
                rectF.bottom = f6 + ((rect.bottom - f6) * f2);
            }
        }
    }

    public final void C(Rect rect, Rect rect2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rect, rect2) == null) {
            this.F = 0.0f;
            this.G = 0.0f;
            this.H = 1.0f;
            this.I = 1.0f;
            if (rect != null && rect2 != null && rect.contains(rect2)) {
                this.F = (rect2.left - rect.left) / rect.width();
                this.G = (rect2.top - rect.top) / rect.height();
                this.H = (rect2.right - rect.left) / rect.width();
                this.I = (rect2.bottom - rect.top) / rect.height();
            }
        }
    }

    public void D(boolean z, boolean z2) {
        DragImageView dragImageView;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || (dragImageView = this.d) == null || (str = (String) dragImageView.getTag()) == null) {
            return;
        }
        if (this.d.getImageType() == 1) {
            if (this.d.getGifCache() == null || !this.d.a0()) {
                V(str, z, z2);
            }
        } else if (this.d.getImageType() == 2) {
            V(str, z, z2);
        } else if (T()) {
            V(str, z, z2);
        }
        E();
    }

    public final boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ImageUrlData imageUrlData = this.K;
            if (imageUrlData != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.K;
                if (imageUrlData2.originalSize >= 0 && !imageUrlData2.isBlockedPic) {
                    String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    if (new File(this.E + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + nameMd5FromUrl).exists()) {
                        this.K.originalProcess = 100;
                        return true;
                    }
                    int i2 = this.K.originalProcess;
                    if (i2 < 0) {
                        c0();
                    } else {
                        this.c0.setProgress(i2);
                    }
                    this.N = true;
                    return false;
                }
            }
            this.a0 = null;
            return false;
        }
        return invokeV.booleanValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(this.K.originalUrl);
            if (this.K.originalProcess >= 0) {
                li5.k().f(nameMd5FromUrl, 13);
                this.K.originalProcess = -1;
                c0();
                return;
            }
            p pVar = this.R;
            if (pVar != null) {
                pVar.a();
            }
            BdPageContext<?> a2 = m9.a(this.b);
            if (a2 == null) {
                d0(nameMd5FromUrl);
            } else if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && !SharedPrefHelper.getInstance().getBoolean("original_img_down_tip", false)) {
                SharedPrefHelper.getInstance().putBoolean("original_img_down_tip", true);
                z45 z45Var = new z45(a2.getPageActivity());
                z45Var.setMessageId(R.string.original_img_down_no_wifi_tip);
                z45Var.setPositiveButton(R.string.alert_yes_button, new c(this, z45Var, nameMd5FromUrl));
                z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d0, new d(this, z45Var));
                z45Var.create(a2);
                z45Var.show();
            } else {
                d0(nameMd5FromUrl);
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            ImageUrlData imageUrlData = this.K;
            if (imageUrlData == null) {
                DragImageView.h hVar = this.D;
                if (hVar != null) {
                    hVar.b();
                    return;
                }
                return;
            }
            Rect sourceImageRectInScreen = imageUrlData.getSourceImageRectInScreen();
            Rect dstRectInScreen = this.K.getDstRectInScreen();
            if (sourceImageRectInScreen != null && dstRectInScreen != null) {
                C(sourceImageRectInScreen, dstRectInScreen);
                K(sourceImageRectInScreen);
                this.z = new RectF(this.y);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setDuration(150L);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.addUpdateListener(new i(this, sourceImageRectInScreen, dstRectInScreen));
                ofFloat.addListener(new j(this));
                ofFloat.start();
                return;
            }
            DragImageView.h hVar2 = this.D;
            if (hVar2 != null) {
                hVar2.b();
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.K != null && !Q()) {
            String str = this.K.imageThumbUrl;
            if (TextUtils.isEmpty(str)) {
                str = this.K.imageUrl;
            }
            ImageUrlData imageUrlData = this.K;
            int i2 = imageUrlData.urlThumbType;
            if (i2 < 0) {
                i2 = imageUrlData.urlType;
            }
            BdImage bdImage = null;
            if (AbstractImageLoaderProc.isImageFileExist(str, i2)) {
                bdImage = AbstractImageLoaderProc.loadBdImageFromLocal(str, i2);
            }
            if (bdImage != null) {
                setThumbBitmapToView(bdImage);
            }
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!this.m && !this.l) {
                if (this.d.getImageBitmap() == null || !this.d.a0()) {
                    return true;
                }
                ImageUrlData imageUrlData = this.K;
                if (imageUrlData != null && imageUrlData.isLongPic && !this.d.X()) {
                    this.l = false;
                    this.M = false;
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean J(float f2, float f3) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.g.getVisibility() == 0 && !this.g.isCanDrag()) {
                return false;
            }
            ImageUrlData imageUrlData = this.K;
            if (imageUrlData != null && imageUrlData.isLongPic && this.g.getVisibility() == 0 && !this.g.isViewTop()) {
                return false;
            }
            ImageUrlData imageUrlData2 = this.K;
            if (imageUrlData2 != null && imageUrlData2.isLongPic && this.g.getVisibility() != 0 && !this.d.Z() && !this.d.b0()) {
                return false;
            }
            if (this.g.getVisibility() != 0 && !this.d.g0()) {
                return false;
            }
            if (this.s != null && getScrollY() == 0) {
                ImageUrlData imageUrlData3 = this.K;
                if ((imageUrlData3 == null || !imageUrlData3.isLongPic) && Math.abs(f2 / f3) < 0.4d && f2 != 0.0f && this.t < 2) {
                    z = true;
                } else {
                    z = false;
                }
                ImageUrlData imageUrlData4 = this.K;
                if (imageUrlData4 != null && imageUrlData4.isLongPic && Math.abs(f2 / f3) < 0.4d && f2 != 0.0f && this.t < 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z || (z2 && this.d.c0())) {
                    this.d.setImageOnLongClickListener(null);
                    this.g.setOnLongClickListener(null);
                    this.t++;
                    this.v = 0.0f;
                    this.u = 1.0f;
                    DragImageView.h hVar = this.D;
                    if (hVar != null) {
                        hVar.a();
                    }
                }
            }
            if (this.t < 2 || this.s == null) {
                return false;
            }
            this.v -= f3;
            float measuredHeight = getMeasuredHeight();
            if (this.v > measuredHeight) {
                this.v = measuredHeight;
            }
            float f4 = f3 / measuredHeight;
            Matrix matrix = this.w;
            float f5 = this.u;
            matrix.postTranslate((-f2) * 1.5f * f5, f3 * (-1.5f) * f5);
            if (this.u * (f4 + 1.0f) > 1.0f || this.v < 0.0f) {
                f4 = -f4;
            }
            float f6 = f4 + 1.0f;
            this.w.preScale(f6, f6, (this.u * this.s.getWidth()) / 2.0f, this.u * (this.s.getHeight() / 2));
            this.u *= f6;
            invalidate();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public final void K(Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, rect) != null) || rect == null) {
            return;
        }
        float f2 = (rect.bottom - rect.top) / (rect.right - rect.left);
        RectF rectF = this.y;
        float f3 = f2 * (rectF.right - rectF.left);
        rectF.top += rectF.height() * this.J;
        RectF rectF2 = this.y;
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

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.E = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
            this.P = BdUtilHelper.getEquipmentWidth(this.b);
            this.Q = BdUtilHelper.getEquipmentHeight(this.b) - ((int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070381));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            DragImageView dragImageView = new DragImageView(this.b);
            this.d = dragImageView;
            dragImageView.setLayoutParams(layoutParams);
            this.d.setOnTouchListener(this.h0);
            addView(this.d);
            SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(this.b);
            this.g = subsamplingScaleImageView;
            subsamplingScaleImageView.setMaxScale(50.0f);
            this.g.setOnTouchListener(this.h0);
            this.g.setVisibility(4);
            addView(this.g, layoutParams);
            ProgressBar progressBar = new ProgressBar(this.b, null, 16843399);
            this.c = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f08128c));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.c.setLayoutParams(layoutParams2);
            this.c.setIndeterminate(true);
            addView(this.c);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            DragImageView dragImageView2 = new DragImageView(this.b);
            this.e = dragImageView2;
            dragImageView2.setLayoutParams(layoutParams3);
            this.e.setVisibility(0);
            addView(this.e);
            P();
            this.e0 = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
        }
    }

    public final void V(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            BdUniqueId bdUniqueId = null;
            if (S(str)) {
                if (!z2 && (this.m || this.l)) {
                    return;
                }
                if (z2 && G(true)) {
                    return;
                }
                this.m = true;
                BdPageContext<?> a2 = m9.a(this.b);
                if (a2 != null) {
                    bdUniqueId = a2.getUniqueId();
                }
                BdResourceLoader.getInstance().loadResource(str, 27, new n(this), 0, 0, false, bdUniqueId, Boolean.valueOf(z), this.d.getImageData(), Boolean.valueOf(this.j));
                return;
            }
            this.e.setVisibility(0);
            this.c.setVisibility(0);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(on5.g(this.P, this.Q));
            BdImage c2 = this.O.c(imageFileInfo, false);
            if (c2 != null) {
                this.l = true;
                this.c.setVisibility(8);
                this.e.setVisibility(8);
                this.a0 = null;
                M(c2);
                return;
            }
            this.O.d(imageFileInfo, new a(this), false);
        }
    }

    public final void b0() {
        boolean z;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (!this.k && !this.l) {
                z = false;
            } else {
                z = true;
            }
            if (z && (imageUrlData = this.K) != null && imageUrlData.mPicType == 1 && !TextUtils.isEmpty(imageUrlData.mTagName)) {
                TextView textView = this.f;
                if (textView != null) {
                    textView.setVisibility(8);
                    this.f = null;
                }
                TextView textView2 = new TextView(this.b);
                this.f = textView2;
                textView2.setText(this.K.mTagName);
                this.f.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07045d));
                SkinManager.setViewTextColor(this.f, R.color.common_color_10013, 1, 0);
                SkinManager.setBackgroundColor(this.f, R.color.common_color_10215);
                this.f.setAlpha(0.75f);
                this.f.setIncludeFontPadding(false);
                this.f.setGravity(17);
                int dimens = BdUtilHelper.getDimens(this.b, R.dimen.obfuscated_res_0x7f0701d4);
                this.f.setPadding(dimens, dimens, dimens, dimens);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.bottomMargin = this.d.getBottomOffset();
                layoutParams.leftMargin = this.d.getLeftOffset();
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                addView(this.f, layoutParams);
                this.f.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        DragImageView.h hVar;
        Bitmap imageBitmap;
        int width;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            if (this.L && !this.d0 && this.g.getVisibility() == 0 && !this.g.isImageLoaded()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.n && this.l) {
                if (!this.q && motionEvent.getPointerCount() >= 2) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (this.q || this.r) {
                    requestDisallowInterceptTouchEvent(true);
                }
                int action = motionEvent.getAction();
                float y = motionEvent.getY();
                float x = motionEvent.getX();
                int i3 = action & 255;
                if (i3 == 0) {
                    if (this.s == null) {
                        if (this.g.getVisibility() == 0) {
                            this.s = tw5.c(this.g);
                        } else {
                            this.s = tw5.c(this.d);
                        }
                    }
                    if (this.x == null && this.s != null) {
                        int measuredWidth = getMeasuredWidth();
                        float measuredWidth2 = ((getMeasuredWidth() * 1.0f) / this.s.getWidth()) * this.s.getHeight();
                        if (measuredWidth2 > getMeasuredHeight()) {
                            measuredWidth2 = getMeasuredHeight();
                        }
                        RectF L = L(getMeasuredWidth() / 2, getMeasuredHeight() / 2, measuredWidth, measuredWidth2);
                        this.x = new Rect((int) L.left, (int) L.top, (int) L.right, (int) L.bottom);
                    }
                    if (this.B == null && this.s != null) {
                        if (this.g.getVisibility() == 0) {
                            i2 = this.g.getSHeight();
                            width = this.g.getSWidth();
                        } else {
                            if (this.d.getImageType() == 1) {
                                if (this.d.getCurrentFrame() != null && this.d.getCurrentFrame().a != null) {
                                    imageBitmap = this.d.getCurrentFrame().a;
                                } else {
                                    imageBitmap = this.s;
                                }
                            } else if (this.d.getImageBitmap() == null) {
                                imageBitmap = this.s;
                            } else {
                                imageBitmap = this.d.getImageBitmap();
                            }
                            int height = imageBitmap.getHeight();
                            width = imageBitmap.getWidth();
                            i2 = height;
                        }
                        float equipmentDensity = BdUtilHelper.getEquipmentDensity(getContext());
                        int i4 = (int) (i2 * equipmentDensity);
                        int i5 = (int) (width * equipmentDensity);
                        if (i5 > this.s.getWidth() && this.s.getWidth() != 0) {
                            i4 = (int) (i4 / ((i5 * 1.0f) / this.s.getWidth()));
                            i5 = this.s.getWidth();
                        }
                        if (i4 > this.s.getHeight() && this.s.getHeight() != 0) {
                            i5 = (int) (i5 / ((i4 * 1.0f) / this.s.getHeight()));
                            i4 = this.s.getHeight();
                        }
                        int equipmentHeight = (BdUtilHelper.getEquipmentHeight(getContext()) - i4) / 2;
                        int equipmentWidth = (BdUtilHelper.getEquipmentWidth(getContext()) - i5) / 2;
                        this.B = new Rect(equipmentWidth, equipmentHeight, i5 + equipmentWidth, i4 + equipmentHeight);
                        this.C = new Rect(this.B);
                        this.J = equipmentHeight / BdUtilHelper.getEquipmentHeight(getContext());
                        this.A = new Rect(0, 0, this.s.getWidth(), this.s.getHeight());
                    }
                    this.o = x;
                    this.p = y;
                }
                if (i3 == 2) {
                    this.q = J(this.o - x, this.p - y);
                    this.o = x;
                    this.p = y;
                }
                if (!this.q && !this.r) {
                    this.d.setImageOnLongClickListener(this.W);
                    this.g.setOnLongClickListener(this.W);
                    z = super.dispatchTouchEvent(motionEvent);
                } else {
                    this.d.setImageOnLongClickListener(null);
                    this.g.setOnLongClickListener(null);
                    z = true;
                }
                if (i3 == 1 || i3 == 3) {
                    this.o = 0.0f;
                    this.p = 0.0f;
                    if ((-this.v) > r0 * 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (this.v > r0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z2 && !z3) {
                        if (this.q && (hVar = this.D) != null) {
                            hVar.c();
                        }
                        this.u = 1.0f;
                        invalidate();
                    } else {
                        this.r = true;
                        e0();
                        if (z2) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "3"));
                        } else if (z3) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "2"));
                        }
                    }
                    this.t = 0;
                    this.w.reset();
                    this.q = false;
                }
                return z;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setUrl(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048628, this, str, z) == null) {
            if (str.contains("*")) {
                str = str.split("[*]")[0];
            }
            this.d.setTag(str);
            this.d.setLoadBigImage(false);
            this.d.setImageDrawable(null);
            this.k = false;
            this.l = false;
            this.L = E();
            this.a0 = null;
            if (W(str)) {
                V(str, z, false);
            }
        }
    }
}
