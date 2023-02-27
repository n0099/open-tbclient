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
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tieba.b55;
import com.baidu.tieba.cg5;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.ct5;
import com.baidu.tieba.da;
import com.baidu.tieba.ej;
import com.baidu.tieba.fi9;
import com.baidu.tieba.gh;
import com.baidu.tieba.lg5;
import com.baidu.tieba.on;
import com.baidu.tieba.q15;
import com.baidu.tieba.sp5;
import com.baidu.tieba.tc5;
import com.baidu.tieba.uc5;
import com.baidu.tieba.x9;
import com.baidu.tieba.yg;
import com.baidu.tieba.zf5;
import com.baidu.tieba.zg;
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
/* loaded from: classes3.dex */
public class UrlDragImageView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public static final String h0;
    public static long i0;
    public static final int j0;
    public static final int r0;
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
    public cg5 N;
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
    public String a0;
    public Context b;
    public CircleProgressView b0;
    public ProgressBar c;
    public boolean c0;
    public DragImageView d;
    public boolean d0;
    public TextView e;
    public Runnable e0;
    public SubsamplingScaleImageView f;
    public Runnable f0;
    public SubsamplingScaleImageView.OnImageEventListener g;
    public View.OnTouchListener g0;
    public o h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public float n;
    public float o;
    public boolean p;
    public boolean q;
    public Bitmap r;
    public int s;
    public float t;
    public float u;
    public final Matrix v;
    public Rect w;
    public RectF x;
    public RectF y;
    public Rect z;

    /* loaded from: classes3.dex */
    public interface o {
        void a(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface p {
        void a();
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        /* loaded from: classes3.dex */
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
                    this.a.a.b0.setVisibility(8);
                    this.a.a.W = null;
                    this.a.a.M = false;
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

    /* loaded from: classes3.dex */
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

        /* loaded from: classes3.dex */
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
                    if (this.c.b.R != null) {
                        this.c.b.R.onTouch(view2, motionEvent);
                    }
                    int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                    View.OnLongClickListener onLongClickListener = null;
                    if (action != 0) {
                        if (action != 1) {
                            if (action == 2) {
                                if (Math.abs(motionEvent.getY() - this.c.b.T) > UrlDragImageView.r0) {
                                    this.c.b.S = false;
                                    this.c.b.f.setOnClickListener(null);
                                    this.c.b.f.setOnLongClickListener(null);
                                }
                                this.c.b.T = motionEvent.getY();
                            }
                        }
                        float scale = this.c.b.f.getScale();
                        float f = this.a;
                        if (scale < f) {
                            this.c.b.f.setScaleAndCenter(f, this.b);
                        }
                        gh.a().removeCallbacks(this.c.b.e0);
                        gh.a().postDelayed(this.c.b.e0, 1000L);
                    } else {
                        this.c.b.T = motionEvent.getY();
                        UrlDragImageView urlDragImageView = this.c.b;
                        SubsamplingScaleImageView subsamplingScaleImageView = urlDragImageView.f;
                        if (!urlDragImageView.S) {
                            onClickListener = null;
                        } else {
                            onClickListener = this.c.b.U;
                        }
                        subsamplingScaleImageView.setOnClickListener(onClickListener);
                        UrlDragImageView urlDragImageView2 = this.c.b;
                        SubsamplingScaleImageView subsamplingScaleImageView2 = urlDragImageView2.f;
                        if (urlDragImageView2.S) {
                            onLongClickListener = this.c.b.V;
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
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b.J.isLongPic && this.a[0] > 0) {
                this.b.d.c0();
                float measuredWidth = (this.b.getMeasuredWidth() * 1.0f) / this.a[0];
                PointF pointF = new PointF((this.a[0] * 1.0f) / 2.0f, 0.0f);
                this.b.f.setScaleAndCenter(measuredWidth, pointF);
                float f = 2.0f * measuredWidth;
                this.b.f.setMaxScale(f);
                this.b.f.setDoubleTapZoomScale(f);
                this.b.f.setInitScale(measuredWidth);
                this.b.f.setDoubleTapZoomStyle(4);
                this.b.f.setOnTouchListener(new a(this, measuredWidth, pointF));
                this.b.d.setVisibility(4);
            }
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.b.W = null;
            this.b.c.setVisibility(8);
            this.b.d.p0();
            this.b.d.setVisibility(4);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements zf5 {
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

        @Override // com.baidu.tieba.zf5
        public void a(on onVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLZ(1048576, this, onVar, str, z) != null) {
                return;
            }
            this.a.k = true;
            this.a.c.setVisibility(8);
            this.a.W = null;
            UrlDragImageView urlDragImageView = this.a;
            DragImageView dragImageView = urlDragImageView.d;
            if (dragImageView == null || dragImageView.r0) {
                return;
            }
            urlDragImageView.M(onVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ct5 {
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

        @Override // com.baidu.tieba.ct5
        public void onLoadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.setVisibility(8);
                this.a.W = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q15 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ UrlDragImageView c;

        public c(UrlDragImageView urlDragImageView, q15 q15Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, q15Var, str};
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
            this.a = q15Var;
            this.b = str;
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                this.a.dismiss();
                this.c.d0(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements q15.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q15 a;
        public final /* synthetic */ UrlDragImageView b;

        public d(UrlDragImageView urlDragImageView, q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {urlDragImageView, q15Var};
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
            this.a = q15Var;
        }

        @Override // com.baidu.tieba.q15.e
        public void onClick(q15 q15Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q15Var) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements tc5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        @Override // com.baidu.tieba.tc5
        public boolean onFileDownloaded(DownloadData downloadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadData)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.tieba.tc5
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

        @Override // com.baidu.tieba.tc5
        public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, downloadData, i, str) == null) {
                this.a.b0.setVisibility(8);
                this.a.L = false;
                BdToast.b(this.a.b, str).k();
                this.a.J.originalProcess = -1;
                this.a.c0();
            }
        }

        @Override // com.baidu.tieba.tc5
        public void onFileDownloadSucceed(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadData) == null) {
                this.a.b0.setVisibility(8);
                gh.a().postDelayed(this.a.f0, 1500L);
                this.a.L = false;
                UrlDragImageView urlDragImageView = this.a;
                urlDragImageView.K = urlDragImageView.E();
                this.a.F();
            }
        }

        @Override // com.baidu.tieba.tc5
        public void onFileUpdateProgress(DownloadData downloadData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, downloadData) != null) || downloadData == null) {
                return;
            }
            if (this.a.J != null && this.a.J.originalProcess != -1) {
                this.a.J.originalProcess = downloadData.getProcess();
            }
            if (this.a.J == null || this.a.J.originalProcess != -1) {
                this.a.b0.setProgress(downloadData.getProcess());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            this.a.S = true;
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            this.c.B(this.b, valueAnimator.getAnimatedFraction(), this.c.d0);
            this.c.invalidate();
        }
    }

    /* loaded from: classes3.dex */
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
            this.a.s = 0;
            this.a.invalidate();
            if (this.a.C != null) {
                this.a.C.b();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                if (this.a.R != null) {
                    this.a.R.onTouch(view2, motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class m implements ct5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UrlDragImageView a;

        @Override // com.baidu.tieba.ct5
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

    /* loaded from: classes3.dex */
    public class n extends yg<on> {
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

        @Override // com.baidu.tieba.yg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.a.l = false;
            this.a.d.setVisibility(0);
            this.a.c.setVisibility(8);
            this.a.W = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yg
        public void onLoaded(on onVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onVar, str, i) != null) {
                return;
            }
            this.a.l = false;
            this.a.k = true;
            UrlDragImageView urlDragImageView = this.a;
            DragImageView dragImageView = urlDragImageView.d;
            if (dragImageView == null || dragImageView.r0) {
                return;
            }
            urlDragImageView.M(onVar);
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
        h0 = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
        i0 = 52428800L;
        j0 = ej.j(TbadkCoreApplication.getInst()) / 5;
        r0 = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
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
            imageFileInfo.addPageAction(lg5.g(this.O, this.P));
            if (this.N.c(imageFileInfo, false) != null) {
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
            this.b0 = circleProgressView;
            circleProgressView.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
            this.b0.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
            this.b0.setProgress(0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ej.g(getContext(), R.dimen.tbds80), ej.g(getContext(), R.dimen.tbds80));
            layoutParams.addRule(13);
            this.b0.setVisibility(8);
            addView(this.b0, layoutParams);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            DragImageView dragImageView = this.d;
            if (dragImageView != null) {
                dragImageView.c0();
            }
            SubsamplingScaleImageView subsamplingScaleImageView = this.f;
            if (subsamplingScaleImageView != null) {
                subsamplingScaleImageView.recycle();
            }
            Bitmap bitmap = this.r;
            if (bitmap != null) {
                bitmap.recycle();
                this.r = null;
            }
            ProgressBar progressBar = this.c;
            if (progressBar != null) {
                this.W = null;
                progressBar.setVisibility(8);
            }
            gh.a().removeCallbacks(this.e0);
            fi9.a().d(-1);
            ImageUrlData imageUrlData = this.J;
            if (imageUrlData != null) {
                uc5.k().f(TbMd5.getNameMd5FromUrl(imageUrlData.originalUrl), 13);
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || this.J == null) {
            return;
        }
        if (U() && this.M) {
            long j2 = this.J.originalSize;
            if (j2 > 0 && !R(j2)) {
                this.W = h0 + "(" + StringHelper.getFormatSize(this.J.originalSize) + SmallTailInfo.EMOTION_SUFFIX;
                return;
            }
            this.W = h0;
            return;
        }
        this.W = null;
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
        this.h = null;
        this.i = false;
        this.l = false;
        this.s = 0;
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
        this.e0 = new f(this);
        this.f0 = new g(this);
        this.g0 = new k(this);
        this.b = context;
        this.N = new cg5();
        O();
    }

    public final boolean G(boolean z) {
        InterceptResult invokeZ;
        ImageUrlData imageUrlData;
        String nameMd5FromUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            if (this.L && !z) {
                return false;
            }
            this.L = true;
            if (this.K && (imageUrlData = this.J) != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.J;
                if (imageUrlData2.originalSize >= 0 && Build.VERSION.SDK_INT >= 10) {
                    String str = this.D + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    int[] imageFileWH = FileHelper.getImageFileWH(str);
                    this.f.setVisibility(0);
                    if (this.g == null) {
                        this.g = new l(this, imageFileWH);
                    }
                    this.f.setOnImageEventListener(this.g);
                    if (this.f.isImageLoaded() && this.J.isLongPic) {
                        this.g.onImageLoaded();
                    } else {
                        this.f.setImage(ImageSource.uri(str));
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeZ.booleanValue;
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
        this.h = null;
        this.i = false;
        this.l = false;
        this.s = 0;
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
        this.e0 = new f(this);
        this.f0 = new g(this);
        this.g0 = new k(this);
        this.b = context;
        this.N = new cg5();
        O();
    }

    public final boolean R(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j2)) == null) {
            if (j2 > i0) {
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
            this.J = imageUrlData;
        }
    }

    public void setCallback(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, oVar) == null) {
            this.h = oVar;
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
            this.C = hVar;
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
            this.f.setOnClickListener(onClickListener);
            this.U = onClickListener;
        }
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, onLongClickListener) == null) {
            this.V = onLongClickListener;
            if (!this.m) {
                this.d.setImageOnLongClickListener(onLongClickListener);
                this.f.setOnLongClickListener(this.V);
            }
        }
    }

    public void setIsCanDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.m = z;
        }
    }

    public void setIsCdn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.i = z;
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
            this.Q = pVar;
        }
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onTouchListener) == null) {
            this.R = onTouchListener;
        }
    }

    public void setUserId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
            this.a0 = str;
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G(false);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.J != null && !Q()) {
            ImageUrlData imageUrlData = this.J;
            String str = imageUrlData.imageUrl;
            int i2 = imageUrlData.urlType;
            on onVar = null;
            if (AbstractImageLoaderProc.isImageFileExist(str, i2)) {
                onVar = AbstractImageLoaderProc.loadBdImageFromLocal(str, i2);
            }
            if (onVar != null) {
                setThumbBitmapToView(onVar);
            }
        }
    }

    public final boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            DragImageView dragImageView = this.d;
            if (dragImageView != null && dragImageView.Z()) {
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
            ImageUrlData imageUrlData = this.J;
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
                dragImageView.l0();
            }
            ProgressBar progressBar = this.c;
            if (progressBar != null) {
                this.W = null;
                progressBar.setVisibility(8);
            }
            this.W = null;
        }
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (!this.j) {
                this.d.setDefaultBitmap();
            } else {
                this.k = false;
            }
            this.W = null;
            this.c.setVisibility(8);
        }
    }

    public void f0() {
        DragImageView dragImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (dragImageView = this.d) != null && dragImageView.getImageType() == 1) {
            this.d.s0();
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
            return this.a0;
        }
        return (String) invokeV.objValue;
    }

    public ImageUrlData getmAssistUrlData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.J;
        }
        return (ImageUrlData) invokeV.objValue;
    }

    public String getmCheckOriginPicText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.W;
        }
        return (String) invokeV.objValue;
    }

    private void setThumbBitmapToView(on onVar) {
        Bitmap p2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65558, this, onVar) == null) && !this.k && onVar != null && (p2 = onVar.p()) != null) {
            this.j = true;
            if (onVar.t()) {
                this.d.setImageUrlData(this.J);
                this.d.setImageBitmap(p2);
                this.W = null;
                this.M = false;
            } else {
                ImageUrlData imageUrlData = this.J;
                if (imageUrlData != null && imageUrlData.isLongPic) {
                    this.d.T();
                    this.d.setImageLoadCallBack(new m(this));
                }
                this.d.setImageUrlData(this.J);
                this.d.setImageData(p2, onVar.k());
            }
            b0();
        }
    }

    public final void A(float f2) {
        Rect rect;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048576, this, f2) == null) && (rect = this.A) != null) {
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
    }

    public final void M(on onVar) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, onVar) == null) {
            if (onVar != null && (oVar = this.h) != null) {
                oVar.a(onVar.q(), onVar.k());
            }
            if (onVar != null && onVar.p() != null) {
                Bitmap p2 = onVar.p();
                this.d.setLoadBigImage(true);
                if (onVar.t()) {
                    this.d.setGifData(onVar.k(), p2);
                    this.d.invalidate();
                    this.d.h0();
                    this.M = false;
                    this.W = null;
                    this.c.setVisibility(8);
                } else {
                    ImageUrlData imageUrlData = this.J;
                    if (imageUrlData != null && imageUrlData.isLongPic) {
                        this.d.T();
                        this.d.setImageLoadCallBack(new b(this));
                    } else {
                        this.c.setVisibility(8);
                        this.W = null;
                    }
                    this.d.setImageUrlData(this.J);
                    this.d.setImageData(p2, onVar.k());
                    c0();
                }
                b0();
                return;
            }
            a0();
        }
    }

    public final void d0(String str) {
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, str) != null) || (imageUrlData = this.J) == null) {
            return;
        }
        imageUrlData.originalProcess = 0;
        this.b0.setProgress(0);
        this.b0.setVisibility(0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.J.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.D + StorageFile.getInstance().getDirectoryName(str) + "/" + str);
        downloadData.setCallback(new e(this));
        uc5.k().m(downloadData, 100);
        this.c0 = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, canvas) == null) {
            if (this.p && (bitmap2 = this.r) != null && !bitmap2.isRecycled() && this.s >= 2) {
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

    public final void B(Rect rect, float f2, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rect, Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                i2 = ej.g(getContext(), R.dimen.tbds80);
            } else {
                i2 = 0;
            }
            RectF rectF = this.x;
            if (rectF != null && rect != null) {
                RectF rectF2 = this.y;
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
            this.E = 0.0f;
            this.F = 0.0f;
            this.G = 1.0f;
            this.H = 1.0f;
            if (rect != null && rect2 != null && rect.contains(rect2)) {
                this.E = (rect2.left - rect.left) / rect.width();
                this.F = (rect2.top - rect.top) / rect.height();
                this.G = (rect2.right - rect.left) / rect.width();
                this.H = (rect2.bottom - rect.top) / rect.height();
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
            if (this.d.getGifCache() == null || !this.d.Z()) {
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
                        c0();
                    } else {
                        this.b0.setProgress(i2);
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

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(this.J.originalUrl);
            if (this.J.originalProcess >= 0) {
                uc5.k().f(nameMd5FromUrl, 13);
                this.J.originalProcess = -1;
                c0();
                return;
            }
            p pVar = this.Q;
            if (pVar != null) {
                pVar.a();
            }
            x9<?> a2 = da.a(this.b);
            if (a2 == null) {
                d0(nameMd5FromUrl);
            } else if (BdNetTypeUtil.isNetWorkAvailable() && !BdNetTypeUtil.isWifiNet() && !b55.m().i("original_img_down_tip", false)) {
                b55.m().w("original_img_down_tip", true);
                q15 q15Var = new q15(a2.getPageActivity());
                q15Var.setMessageId(R.string.original_img_down_no_wifi_tip);
                q15Var.setPositiveButton(R.string.alert_yes_button, new c(this, q15Var, nameMd5FromUrl));
                q15Var.setNegativeButton(R.string.obfuscated_res_0x7f0f038d, new d(this, q15Var));
                q15Var.create(a2);
                q15Var.show();
            } else {
                d0(nameMd5FromUrl);
            }
        }
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
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

    public final boolean J(float f2, float f3) {
        InterceptResult invokeCommon;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (this.f.getVisibility() == 0 && !this.f.isCanDrag()) {
                return false;
            }
            ImageUrlData imageUrlData = this.J;
            if (imageUrlData != null && imageUrlData.isLongPic && this.f.getVisibility() == 0 && !this.f.isViewTop()) {
                return false;
            }
            ImageUrlData imageUrlData2 = this.J;
            if (imageUrlData2 != null && imageUrlData2.isLongPic && this.f.getVisibility() != 0 && !this.d.Y() && !this.d.a0()) {
                return false;
            }
            if (this.f.getVisibility() != 0 && !this.d.f0()) {
                return false;
            }
            if (this.r != null && getScrollY() == 0) {
                ImageUrlData imageUrlData3 = this.J;
                if ((imageUrlData3 == null || !imageUrlData3.isLongPic) && Math.abs(f2 / f3) < 0.4d && f2 != 0.0f && this.s < 2) {
                    z = true;
                } else {
                    z = false;
                }
                ImageUrlData imageUrlData4 = this.J;
                if (imageUrlData4 != null && imageUrlData4.isLongPic && Math.abs(f2 / f3) < 0.4d && f2 != 0.0f && this.s < 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z || (z2 && this.d.b0())) {
                    this.d.setImageOnLongClickListener(null);
                    this.f.setOnLongClickListener(null);
                    this.s++;
                    this.u = 0.0f;
                    this.t = 1.0f;
                    DragImageView.h hVar = this.C;
                    if (hVar != null) {
                        hVar.a();
                    }
                }
            }
            if (this.s < 2 || this.r == null) {
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
        return invokeCommon.booleanValue;
    }

    public final void K(Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, rect) != null) || rect == null) {
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

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.D = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
            this.O = ej.l(this.b);
            this.P = ej.j(this.b) - ((int) this.b.getResources().getDimension(R.dimen.obfuscated_res_0x7f070257));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            DragImageView dragImageView = new DragImageView(this.b);
            this.d = dragImageView;
            dragImageView.setLayoutParams(layoutParams);
            this.d.setOnTouchListener(this.g0);
            addView(this.d);
            SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(this.b);
            this.f = subsamplingScaleImageView;
            subsamplingScaleImageView.setMaxScale(50.0f);
            this.f.setOnTouchListener(this.g0);
            this.f.setVisibility(4);
            addView(this.f, layoutParams);
            ProgressBar progressBar = new ProgressBar(this.b, null, 16843399);
            this.c = progressBar;
            progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081053));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13);
            this.c.setLayoutParams(layoutParams2);
            this.c.setIndeterminate(true);
            addView(this.c);
            P();
            this.d0 = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
        }
    }

    public final void b0() {
        boolean z;
        ImageUrlData imageUrlData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (!this.j && !this.k) {
                z = false;
            } else {
                z = true;
            }
            if (z && (imageUrlData = this.J) != null && imageUrlData.mPicType == 1 && !TextUtils.isEmpty(imageUrlData.mTagName)) {
                TextView textView = this.e;
                if (textView != null) {
                    textView.setVisibility(8);
                    this.e = null;
                }
                TextView textView2 = new TextView(this.b);
                this.e = textView2;
                textView2.setText(this.J.mTagName);
                this.e.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07032e));
                SkinManager.setViewTextColor(this.e, R.color.common_color_10013, 1, 0);
                SkinManager.setBackgroundColor(this.e, R.color.common_color_10215);
                this.e.setAlpha(0.75f);
                this.e.setIncludeFontPadding(false);
                this.e.setGravity(17);
                int g2 = ej.g(this.b, R.dimen.obfuscated_res_0x7f0701d4);
                this.e.setPadding(g2, g2, g2, g2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.bottomMargin = this.d.getBottomOffset();
                layoutParams.leftMargin = this.d.getLeftOffset();
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                addView(this.e, layoutParams);
                this.e.setVisibility(0);
            }
        }
    }

    public final boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!this.l && !this.k) {
                if (this.d.getImageBitmap() == null || !this.d.Z()) {
                    return true;
                }
                ImageUrlData imageUrlData = this.J;
                if (imageUrlData != null && imageUrlData.isLongPic && !this.d.W()) {
                    this.k = false;
                    this.L = false;
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void V(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            BdUniqueId bdUniqueId = null;
            if (S(str)) {
                if (!z2 && (this.l || this.k)) {
                    return;
                }
                if (z2 && G(true)) {
                    return;
                }
                this.l = true;
                x9<?> a2 = da.a(this.b);
                if (a2 != null) {
                    bdUniqueId = a2.getUniqueId();
                }
                zg.h().l(str, 27, new n(this), 0, 0, false, bdUniqueId, Boolean.valueOf(z), this.d.getImageData(), Boolean.valueOf(this.i));
                return;
            }
            this.c.setVisibility(0);
            ImageFileInfo imageFileInfo = new ImageFileInfo();
            imageFileInfo.setFilePath(str);
            imageFileInfo.setTempFile(true);
            imageFileInfo.clearPageActions();
            imageFileInfo.addPageAction(lg5.g(this.O, this.P));
            on c2 = this.N.c(imageFileInfo, false);
            if (c2 != null) {
                this.k = true;
                this.c.setVisibility(8);
                this.W = null;
                M(c2);
                return;
            }
            this.N.d(imageFileInfo, new a(this), false);
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
            if (this.K && !this.c0 && this.f.getVisibility() == 0 && !this.f.isImageLoaded()) {
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
                        if (this.f.getVisibility() == 0) {
                            this.r = sp5.c(this.f);
                        } else {
                            this.r = sp5.c(this.d);
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
                        if (this.f.getVisibility() == 0) {
                            i2 = this.f.getSHeight();
                            width = this.f.getSWidth();
                        } else {
                            if (this.d.getImageType() == 1) {
                                if (this.d.getCurrentFrame() != null && this.d.getCurrentFrame().a != null) {
                                    imageBitmap = this.d.getCurrentFrame().a;
                                } else {
                                    imageBitmap = this.r;
                                }
                            } else if (this.d.getImageBitmap() == null) {
                                imageBitmap = this.r;
                            } else {
                                imageBitmap = this.d.getImageBitmap();
                            }
                            int height = imageBitmap.getHeight();
                            width = imageBitmap.getWidth();
                            i2 = height;
                        }
                        float i4 = ej.i(getContext());
                        int i5 = (int) (i2 * i4);
                        int i6 = (int) (width * i4);
                        if (i6 > this.r.getWidth() && this.r.getWidth() != 0) {
                            i5 = (int) (i5 / ((i6 * 1.0f) / this.r.getWidth()));
                            i6 = this.r.getWidth();
                        }
                        if (i5 > this.r.getHeight() && this.r.getHeight() != 0) {
                            i6 = (int) (i6 / ((i5 * 1.0f) / this.r.getHeight()));
                            i5 = this.r.getHeight();
                        }
                        int j2 = (ej.j(getContext()) - i5) / 2;
                        int l2 = (ej.l(getContext()) - i6) / 2;
                        this.A = new Rect(l2, j2, i6 + l2, i5 + j2);
                        this.B = new Rect(this.A);
                        this.I = j2 / ej.j(getContext());
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
                    this.d.setImageOnLongClickListener(this.V);
                    this.f.setOnLongClickListener(this.V);
                    z = super.dispatchTouchEvent(motionEvent);
                } else {
                    this.d.setImageOnLongClickListener(null);
                    this.f.setOnLongClickListener(null);
                    z = true;
                }
                if (i3 == 1 || i3 == 3) {
                    this.n = 0.0f;
                    this.o = 0.0f;
                    if ((-this.u) > j0 * 2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (this.u > j0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z2 && !z3) {
                        if (this.p && (hVar = this.C) != null) {
                            hVar.c();
                        }
                        this.t = 1.0f;
                        invalidate();
                    } else {
                        this.q = true;
                        e0();
                        if (z2) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "3"));
                        } else if (z3) {
                            TiebaStatic.log(new StatisticItem("c13377").param("obj_type", "2"));
                        }
                    }
                    this.s = 0;
                    this.v.reset();
                    this.p = false;
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
            this.j = false;
            this.k = false;
            this.K = E();
            this.W = null;
            if (W(str)) {
                V(str, z, false);
            }
        }
    }
}
