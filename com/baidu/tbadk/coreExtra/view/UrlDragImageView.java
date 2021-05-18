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
import com.baidu.adp.lib.util.StringUtils;
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
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import d.a.j0.r.s.a;
import java.io.File;
/* loaded from: classes3.dex */
public class UrlDragImageView extends RelativeLayout {
    public static final String l0 = TbadkCoreApplication.getInst().getString(R.string.original_img_look);
    public static long m0 = 52428800;
    public static final int n0 = d.a.c.e.p.l.i(TbadkCoreApplication.getInst()) / 5;
    public static final int o0 = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();
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
    public d.a.j0.b0.b R;
    public int S;
    public int T;
    public p U;
    public View.OnTouchListener V;
    public boolean W;
    public float a0;
    public View.OnClickListener b0;
    public View.OnLongClickListener c0;
    public String d0;

    /* renamed from: e  reason: collision with root package name */
    public int f12768e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public Context f12769f;
    public CircleProgressView f0;

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f12770g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public DragImageView f12771h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public TextView f12772i;
    public Runnable i0;
    public SubsamplingScaleImageView j;
    public Runnable j0;
    public SubsamplingScaleImageView.OnImageEventListener k;
    public View.OnTouchListener k0;
    public o l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
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

    /* loaded from: classes3.dex */
    public class a implements d.a.j0.a0.b {
        public a() {
        }

        @Override // d.a.j0.a0.b
        public void a(d.a.c.j.d.a aVar, String str, boolean z) {
            UrlDragImageView.this.o = true;
            UrlDragImageView.this.f12770g.setVisibility(8);
            UrlDragImageView.this.d0 = null;
            UrlDragImageView.this.M(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.j0.b1.i.b.a {
        public b() {
        }

        @Override // d.a.j0.b1.i.b.a
        public void onLoadFinished() {
            UrlDragImageView.this.f12770g.setVisibility(8);
            UrlDragImageView.this.d0 = null;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f12775e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12776f;

        public c(d.a.j0.r.s.a aVar, String str) {
            this.f12775e = aVar;
            this.f12776f = str;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f12775e.dismiss();
            UrlDragImageView.this.c0(this.f12776f);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f12778e;

        public d(d.a.j0.r.s.a aVar) {
            this.f12778e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f12778e.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.a.j0.v.c {
        public e() {
        }

        @Override // d.a.j0.v.c
        public void onFileDownloadFailed(DownloadData downloadData, int i2, String str) {
            UrlDragImageView.this.f0.setVisibility(8);
            UrlDragImageView.this.P = false;
            BdToast c2 = BdToast.c(UrlDragImageView.this.f12769f, str);
            c2.a();
            c2.q();
            UrlDragImageView.this.N.originalProcess = -1;
            UrlDragImageView.this.b0();
        }

        @Override // d.a.j0.v.c
        public void onFileDownloadSucceed(DownloadData downloadData) {
            UrlDragImageView.this.f0.setVisibility(8);
            d.a.c.e.m.e.a().postDelayed(UrlDragImageView.this.j0, 1500L);
            UrlDragImageView.this.P = false;
            UrlDragImageView urlDragImageView = UrlDragImageView.this;
            urlDragImageView.O = urlDragImageView.E();
            UrlDragImageView.this.F();
        }

        @Override // d.a.j0.v.c
        public boolean onFileDownloaded(DownloadData downloadData) {
            return true;
        }

        @Override // d.a.j0.v.c
        public void onFileUpdateProgress(DownloadData downloadData) {
            if (downloadData == null) {
                return;
            }
            if (UrlDragImageView.this.N != null && UrlDragImageView.this.N.originalProcess != -1) {
                UrlDragImageView.this.N.originalProcess = downloadData.getProcess();
            }
            if (UrlDragImageView.this.N == null || UrlDragImageView.this.N.originalProcess != -1) {
                UrlDragImageView.this.f0.setProgress(downloadData.getProcess());
            }
        }

        @Override // d.a.j0.v.c
        public boolean onPreDownload(DownloadData downloadData) {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UrlDragImageView.this.W = true;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* loaded from: classes3.dex */
        public class a implements Animation.AnimationListener {
            public a() {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                UrlDragImageView.this.f0.setVisibility(8);
                UrlDragImageView.this.d0 = null;
                UrlDragImageView.this.Q = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        }

        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(200L);
            alphaAnimation.setAnimationListener(new a());
        }
    }

    /* loaded from: classes3.dex */
    public class h implements DragImageView.k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ DragImageView.k f12784a;

        public h(DragImageView.k kVar) {
            this.f12784a = kVar;
        }

        @Override // com.baidu.tbadk.widget.DragImageView.k
        public void a(DragImageView dragImageView, boolean z, boolean z2) {
            DragImageView.k kVar = this.f12784a;
            if (kVar != null) {
                kVar.a(dragImageView, z, z2);
            }
            UrlDragImageView.this.a0();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Rect f12786e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Rect f12787f;

        public i(Rect rect, Rect rect2) {
            this.f12786e = rect;
            this.f12787f = rect2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null || this.f12786e == null || this.f12787f == null) {
                return;
            }
            UrlDragImageView.this.A(valueAnimator.getAnimatedFraction());
            UrlDragImageView.this.B(this.f12787f, valueAnimator.getAnimatedFraction(), UrlDragImageView.this.h0);
            UrlDragImageView.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Animator.AnimatorListener {
        public j() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            UrlDragImageView.this.w = false;
            UrlDragImageView.this.invalidate();
            if (UrlDragImageView.this.G != null) {
                UrlDragImageView.this.G.b();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class k implements View.OnTouchListener {
        public k() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (UrlDragImageView.this.V != null) {
                UrlDragImageView.this.V.onTouch(view, motionEvent);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements SubsamplingScaleImageView.OnImageEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int[] f12791a;

        /* loaded from: classes3.dex */
        public class a implements View.OnTouchListener {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ float f12793e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PointF f12794f;

            public a(float f2, PointF pointF) {
                this.f12793e = f2;
                this.f12794f = pointF;
            }

            /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
                if (r4 != 3) goto L12;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (UrlDragImageView.this.V != null) {
                    UrlDragImageView.this.V.onTouch(view, motionEvent);
                }
                int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
                if (action == 0) {
                    UrlDragImageView.this.a0 = motionEvent.getY();
                    UrlDragImageView urlDragImageView = UrlDragImageView.this;
                    urlDragImageView.j.setOnClickListener(urlDragImageView.W ? UrlDragImageView.this.b0 : null);
                    UrlDragImageView urlDragImageView2 = UrlDragImageView.this;
                    urlDragImageView2.j.setOnLongClickListener(urlDragImageView2.W ? UrlDragImageView.this.c0 : null);
                } else {
                    if (action != 1) {
                        if (action == 2) {
                            if (Math.abs(motionEvent.getY() - UrlDragImageView.this.a0) > UrlDragImageView.o0) {
                                UrlDragImageView.this.W = false;
                                UrlDragImageView.this.j.setOnClickListener(null);
                                UrlDragImageView.this.j.setOnLongClickListener(null);
                            }
                            UrlDragImageView.this.a0 = motionEvent.getY();
                        }
                    }
                    float scale = UrlDragImageView.this.j.getScale();
                    float f2 = this.f12793e;
                    if (scale < f2) {
                        UrlDragImageView.this.j.setScaleAndCenter(f2, this.f12794f);
                    }
                    d.a.c.e.m.e.a().removeCallbacks(UrlDragImageView.this.i0);
                    d.a.c.e.m.e.a().postDelayed(UrlDragImageView.this.i0, 1000L);
                }
                return false;
            }
        }

        public l(int[] iArr) {
            this.f12791a = iArr;
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
            if (!UrlDragImageView.this.N.isLongPic || this.f12791a[0] <= 0) {
                return;
            }
            UrlDragImageView.this.f12771h.c0();
            float measuredWidth = (UrlDragImageView.this.getMeasuredWidth() * 1.0f) / this.f12791a[0];
            PointF pointF = new PointF((this.f12791a[0] * 1.0f) / 2.0f, 0.0f);
            UrlDragImageView.this.j.setScaleAndCenter(measuredWidth, pointF);
            float f2 = 2.0f * measuredWidth;
            UrlDragImageView.this.j.setMaxScale(f2);
            UrlDragImageView.this.j.setDoubleTapZoomScale(f2);
            UrlDragImageView.this.j.setInitScale(measuredWidth);
            UrlDragImageView.this.j.setDoubleTapZoomStyle(4);
            UrlDragImageView.this.j.setOnTouchListener(new a(measuredWidth, pointF));
            UrlDragImageView.this.f12771h.setVisibility(4);
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
            UrlDragImageView.this.d0 = null;
            UrlDragImageView.this.f12770g.setVisibility(8);
            UrlDragImageView.this.f12771h.p0();
            UrlDragImageView.this.f12771h.setVisibility(4);
        }

        @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }

    /* loaded from: classes3.dex */
    public class m implements d.a.j0.b1.i.b.a {
        public m() {
        }

        @Override // d.a.j0.b1.i.b.a
        public void onLoadFinished() {
        }
    }

    /* loaded from: classes3.dex */
    public class n extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public n() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            UrlDragImageView.this.p = false;
            UrlDragImageView.this.f12771h.setVisibility(0);
            UrlDragImageView.this.f12770g.setVisibility(8);
            UrlDragImageView.this.d0 = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            UrlDragImageView.this.p = false;
            UrlDragImageView.this.o = true;
            UrlDragImageView.this.M(aVar);
        }
    }

    /* loaded from: classes3.dex */
    public interface o {
        void a(String str, byte[] bArr);
    }

    /* loaded from: classes3.dex */
    public interface p {
        void a();
    }

    public UrlDragImageView(Context context) {
        super(context);
        this.f12768e = 3;
        this.f12770g = null;
        this.f12771h = null;
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
        this.d0 = null;
        this.i0 = new f();
        this.j0 = new g();
        this.k0 = new k();
        this.f12769f = context;
        this.R = new d.a.j0.b0.b();
        N();
    }

    private void setThumbBitmapToView(d.a.c.j.d.a aVar) {
        Bitmap p2;
        if (this.o || aVar == null || (p2 = aVar.p()) == null) {
            return;
        }
        this.n = true;
        if (aVar.t()) {
            this.f12771h.setImageUrlData(this.N);
            this.f12771h.setImageBitmap(p2);
            this.d0 = null;
            this.Q = false;
        } else {
            ImageUrlData imageUrlData = this.N;
            if (imageUrlData != null && imageUrlData.isLongPic) {
                this.f12771h.T();
                this.f12771h.setImageLoadCallBack(new m());
            }
            this.f12771h.setImageUrlData(this.N);
            this.f12771h.setImageData(p2, aVar.k());
        }
        a0();
    }

    public final void A(float f2) {
        Rect rect = this.E;
        if (rect != null) {
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
    }

    public final void B(Rect rect, float f2, boolean z) {
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

    public final void C(Rect rect, Rect rect2) {
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

    public void D(boolean z, boolean z2) {
        String str;
        DragImageView dragImageView = this.f12771h;
        if (dragImageView == null || (str = (String) dragImageView.getTag()) == null) {
            return;
        }
        if (this.f12771h.getImageType() == 1) {
            if (this.f12771h.getGifCache() == null || !this.f12771h.Z()) {
                U(str, z, z2);
            }
        } else if (this.f12771h.getImageType() == 2) {
            U(str, z, z2);
        } else if (S()) {
            U(str, z, z2);
        }
    }

    public final boolean E() {
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
                    this.f0.setProgress(i2);
                }
                this.Q = true;
                return false;
            }
        }
        this.d0 = null;
        return false;
    }

    public void F() {
        G(false);
    }

    public final boolean G(boolean z) {
        ImageUrlData imageUrlData;
        String nameMd5FromUrl;
        if (!this.P || z) {
            this.P = true;
            if (this.O && (imageUrlData = this.N) != null && !StringUtils.isNull(imageUrlData.originalUrl, true)) {
                ImageUrlData imageUrlData2 = this.N;
                if (imageUrlData2.originalSize >= 0 && Build.VERSION.SDK_INT >= 10) {
                    String str = this.H + StorageFile.getInstance().getDirectoryName(nameMd5FromUrl) + "/" + TbMd5.getNameMd5FromUrl(imageUrlData2.originalUrl);
                    int[] imageFileWH = FileHelper.getImageFileWH(str);
                    this.j.setVisibility(0);
                    if (this.k == null) {
                        this.k = new l(imageFileWH);
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

    public void H() {
        if (this.N == null || P()) {
            return;
        }
        ImageUrlData imageUrlData = this.N;
        String str = imageUrlData.imageUrl;
        int i2 = imageUrlData.urlType;
        d.a.c.j.d.a loadBdImageFromLocal = AbstractImageLoaderProc.isImageFileExist(str, i2) ? AbstractImageLoaderProc.loadBdImageFromLocal(str, i2) : null;
        if (loadBdImageFromLocal != null) {
            setThumbBitmapToView(loadBdImageFromLocal);
        }
    }

    public void I() {
        String nameMd5FromUrl = TbMd5.getNameMd5FromUrl(this.N.originalUrl);
        if (this.N.originalProcess >= 0) {
            d.a.j0.v.d.j().f(nameMd5FromUrl, 13);
            this.N.originalProcess = -1;
            b0();
            return;
        }
        p pVar = this.U;
        if (pVar != null) {
            pVar.a();
        }
        d.a.c.a.f<?> a2 = d.a.c.a.j.a(this.f12769f);
        if (a2 == null) {
            c0(nameMd5FromUrl);
        } else if (d.a.c.e.p.j.z() && !d.a.c.e.p.j.H() && !d.a.j0.r.d0.b.j().g("original_img_down_tip", false)) {
            d.a.j0.r.d0.b.j().t("original_img_down_tip", true);
            d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(a2.getPageActivity());
            aVar.setMessageId(R.string.original_img_down_no_wifi_tip);
            aVar.setPositiveButton(R.string.alert_yes_button, new c(aVar, nameMd5FromUrl));
            aVar.setNegativeButton(R.string.cancel, new d(aVar));
            aVar.create(a2);
            aVar.show();
        } else {
            c0(nameMd5FromUrl);
        }
    }

    public final boolean J(float f2, float f3) {
        if (this.j.getVisibility() != 0 || this.j.isCanDrag()) {
            ImageUrlData imageUrlData = this.N;
            if (imageUrlData == null || !imageUrlData.isLongPic || this.j.getVisibility() != 0 || this.j.isViewTop()) {
                ImageUrlData imageUrlData2 = this.N;
                if (imageUrlData2 == null || !imageUrlData2.isLongPic || this.j.getVisibility() == 0 || this.f12771h.Y() || this.f12771h.a0()) {
                    if (this.j.getVisibility() == 0 || this.f12771h.f0()) {
                        if (this.v != null && getScrollY() == 0) {
                            ImageUrlData imageUrlData3 = this.N;
                            boolean z = (imageUrlData3 == null || !imageUrlData3.isLongPic) && ((f3 < -15.0f && !this.w) || (f3 > 15.0f && !this.w));
                            ImageUrlData imageUrlData4 = this.N;
                            boolean z2 = imageUrlData4 != null && imageUrlData4.isLongPic && f3 < 0.0f && !this.w;
                            if (z || (z2 && this.f12771h.b0())) {
                                this.f12771h.setImageOnLongClickListener(null);
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

    public final void K(Rect rect) {
        if (rect == null) {
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
        float f6 = f4 / 2.0f;
        float f7 = f5 / 2.0f;
        return new RectF(f2 - f6, f3 - f7, f2 + f6, f3 + f7);
    }

    public final void M(d.a.c.j.d.a aVar) {
        o oVar;
        if (aVar != null && (oVar = this.l) != null) {
            oVar.a(aVar.q(), aVar.k());
        }
        if (aVar != null && aVar.p() != null) {
            Bitmap p2 = aVar.p();
            this.f12771h.setLoadBigImage(true);
            if (aVar.t()) {
                this.f12771h.setGifData(aVar.k(), p2);
                this.f12771h.invalidate();
                this.f12771h.h0();
                this.Q = false;
                this.d0 = null;
                this.f12770g.setVisibility(8);
            } else {
                ImageUrlData imageUrlData = this.N;
                if (imageUrlData != null && imageUrlData.isLongPic) {
                    this.f12771h.T();
                    this.f12771h.setImageLoadCallBack(new b());
                } else {
                    this.f12770g.setVisibility(8);
                    this.d0 = null;
                }
                this.f12771h.setImageUrlData(this.N);
                this.f12771h.setImageData(p2, aVar.k());
                b0();
            }
            a0();
            return;
        }
        Z();
    }

    public void N() {
        this.H = TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath();
        this.S = d.a.c.e.p.l.k(this.f12769f);
        this.T = d.a.c.e.p.l.i(this.f12769f) - ((int) this.f12769f.getResources().getDimension(R.dimen.ds166));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        DragImageView dragImageView = new DragImageView(this.f12769f);
        this.f12771h = dragImageView;
        dragImageView.setLayoutParams(layoutParams);
        this.f12771h.setOnTouchListener(this.k0);
        addView(this.f12771h);
        SubsamplingScaleImageView subsamplingScaleImageView = new SubsamplingScaleImageView(this.f12769f);
        this.j = subsamplingScaleImageView;
        subsamplingScaleImageView.setMaxScale(50.0f);
        this.j.setOnTouchListener(this.k0);
        this.j.setVisibility(4);
        addView(this.j, layoutParams);
        ProgressBar progressBar = new ProgressBar(this.f12769f, null, 16843399);
        this.f12770g = progressBar;
        progressBar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.f12770g.setLayoutParams(layoutParams2);
        this.f12770g.setIndeterminate(true);
        addView(this.f12770g);
        O();
        this.h0 = TbSingleton.getInstance().isCutoutScreen(TbadkApplication.getInst().getCurrentActivity());
    }

    public final void O() {
        CircleProgressView circleProgressView = new CircleProgressView(this.f12769f);
        this.f0 = circleProgressView;
        circleProgressView.setCircleBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
        this.f0.setCircleForegroundColor(SkinManager.getColor(R.color.CAM_X0302));
        this.f0.setProgress(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a.c.e.p.l.g(getContext(), R.dimen.tbds80), d.a.c.e.p.l.g(getContext(), R.dimen.tbds80));
        layoutParams.addRule(13);
        this.f0.setVisibility(8);
        addView(this.f0, layoutParams);
    }

    public final boolean P() {
        DragImageView dragImageView = this.f12771h;
        return dragImageView != null && dragImageView.Z();
    }

    public final boolean Q(long j2) {
        return j2 > m0;
    }

    public final boolean R(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    public final boolean S() {
        if (this.f12771h.getImageBitmap() != null && this.f12771h.Z()) {
            ImageUrlData imageUrlData = this.N;
            if (imageUrlData == null || !imageUrlData.isLongPic || this.f12771h.W()) {
                return false;
            }
            this.o = false;
            this.P = false;
            return true;
        }
        return true;
    }

    public final boolean T() {
        ImageUrlData imageUrlData = this.N;
        return (imageUrlData == null || !imageUrlData.mIsShowOrigonButton || imageUrlData.isBlockedPic || StringUtils.isNull(imageUrlData.originalUrl)) ? false : true;
    }

    public final void U(String str, boolean z, boolean z2) {
        if (R(str)) {
            if (z2 || !(this.p || this.o)) {
                if (z2 && G(true)) {
                    return;
                }
                this.p = true;
                d.a.c.e.l.d.h().l(str, 27, new n(), 0, 0, false, null, Boolean.valueOf(z), this.f12771h.getImageData(), Boolean.valueOf(this.m));
                return;
            }
            return;
        }
        this.f12770g.setVisibility(0);
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(d.a.j0.b0.g.d.g(this.S, this.T));
        d.a.c.j.d.a c2 = this.R.c(imageFileInfo, false);
        if (c2 != null) {
            this.o = true;
            this.f12770g.setVisibility(8);
            this.d0 = null;
            M(c2);
            return;
        }
        this.R.d(imageFileInfo, new a(), false);
    }

    public final boolean V(String str) {
        return d.a.c.e.p.j.z() || BigImageLoaderProc.checkBigImageFileExist(str);
    }

    public void W(int i2) {
        if (this.f12768e != i2) {
            this.f12768e = i2;
        }
    }

    public void X() {
        DragImageView dragImageView = this.f12771h;
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
        ProgressBar progressBar = this.f12770g;
        if (progressBar != null) {
            this.d0 = null;
            progressBar.setVisibility(8);
        }
        d.a.c.e.m.e.a().removeCallbacks(this.i0);
        d.a.k0.u3.c.a().d(-1);
    }

    public void Y() {
        DragImageView dragImageView = this.f12771h;
        if (dragImageView != null) {
            dragImageView.l0();
        }
        ProgressBar progressBar = this.f12770g;
        if (progressBar != null) {
            this.d0 = null;
            progressBar.setVisibility(8);
        }
        this.d0 = null;
    }

    public final void Z() {
        if (!this.n) {
            this.f12771h.setDefaultBitmap();
        } else {
            this.o = false;
        }
        this.d0 = null;
        this.f12770g.setVisibility(8);
    }

    public final void a0() {
        ImageUrlData imageUrlData;
        if (!(this.n || this.o) || (imageUrlData = this.N) == null || imageUrlData.mPicType != 1 || TextUtils.isEmpty(imageUrlData.mTagName)) {
            return;
        }
        TextView textView = this.f12772i;
        if (textView != null) {
            textView.setVisibility(8);
            this.f12772i = null;
        }
        TextView textView2 = new TextView(this.f12769f);
        this.f12772i = textView2;
        textView2.setText(this.N.mTagName);
        this.f12772i.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize26));
        SkinManager.setViewTextColor(this.f12772i, R.color.common_color_10013, 1, 0);
        SkinManager.setBackgroundColor(this.f12772i, R.color.common_color_10215);
        this.f12772i.setAlpha(0.75f);
        this.f12772i.setIncludeFontPadding(false);
        this.f12772i.setGravity(17);
        int g2 = d.a.c.e.p.l.g(this.f12769f, R.dimen.ds2);
        this.f12772i.setPadding(g2, g2, g2, g2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = this.f12771h.getBottomOffset();
        layoutParams.leftMargin = this.f12771h.getLeftOffset();
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        addView(this.f12772i, layoutParams);
        this.f12772i.setVisibility(0);
    }

    public void b0() {
        if (this.N == null) {
            return;
        }
        if (T() && this.Q) {
            long j2 = this.N.originalSize;
            if (j2 > 0 && !Q(j2)) {
                this.d0 = l0 + "(" + StringHelper.getFormatSize(this.N.originalSize) + SmallTailInfo.EMOTION_SUFFIX;
                return;
            }
            this.d0 = l0;
            return;
        }
        this.d0 = null;
    }

    public final void c0(String str) {
        ImageUrlData imageUrlData = this.N;
        if (imageUrlData == null) {
            return;
        }
        imageUrlData.originalProcess = 0;
        this.f0.setProgress(0);
        this.f0.setVisibility(0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.N.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(this.H + StorageFile.getInstance().getDirectoryName(str) + "/" + str);
        downloadData.setCallback(new e());
        d.a.j0.v.d.j().l(downloadData, 100);
        this.g0 = true;
    }

    public final void d0() {
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
            ofFloat.addUpdateListener(new i(sourceImageRectInScreen, dstRectInScreen));
            ofFloat.addListener(new j());
            ofFloat.start();
            return;
        }
        DragImageView.h hVar2 = this.G;
        if (hVar2 != null) {
            hVar2.b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
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

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        DragImageView.h hVar;
        Bitmap imageBitmap;
        int width;
        int i2;
        if (this.O && !this.g0 && this.j.getVisibility() == 0 && !this.j.isImageLoaded()) {
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
                        this.v = d.a.j0.z0.h.a(this.j);
                    } else {
                        this.v = d.a.j0.z0.h.a(this.f12771h);
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
                        if (this.f12771h.getImageType() == 1) {
                            imageBitmap = (this.f12771h.getCurrentFrame() == null || this.f12771h.getCurrentFrame().f13067a == null) ? this.v : this.f12771h.getCurrentFrame().f13067a;
                        } else {
                            imageBitmap = this.f12771h.getImageBitmap() == null ? this.v : this.f12771h.getImageBitmap();
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
                this.f12771h.setImageOnLongClickListener(this.c0);
                this.j.setOnLongClickListener(this.c0);
                z = super.dispatchTouchEvent(motionEvent);
            } else {
                this.f12771h.setImageOnLongClickListener(null);
                this.j.setOnLongClickListener(null);
                z = true;
            }
            if (i3 == 1 || i3 == 3) {
                this.r = 0.0f;
                this.s = 0.0f;
                boolean z2 = (-this.y) > ((float) (n0 * 2));
                boolean z3 = this.y > ((float) n0);
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

    public void e0() {
        DragImageView dragImageView = this.f12771h;
        if (dragImageView == null || dragImageView.getImageType() != 1) {
            return;
        }
        this.f12771h.s0();
    }

    public DragImageView getImageView() {
        return this.f12771h;
    }

    public String getUserId() {
        return this.e0;
    }

    public ImageUrlData getmAssistUrlData() {
        return this.N;
    }

    public String getmCheckOriginPicText() {
        return this.d0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.N = imageUrlData;
    }

    public void setCallback(o oVar) {
        this.l = oVar;
    }

    public void setCanScale(boolean z) {
        DragImageView dragImageView = this.f12771h;
        if (dragImageView != null) {
            dragImageView.setCanScale(z);
        }
    }

    public void setDragToExitListener(DragImageView.h hVar) {
        this.G = hVar;
        DragImageView dragImageView = this.f12771h;
        if (dragImageView != null) {
            dragImageView.setDragToExitListener(hVar);
        }
    }

    public void setGifMaxUseableMem(int i2) {
        this.f12771h.setGifMaxUseableMem(i2);
    }

    public void setGifSetListener(DragImageView.i iVar) {
        this.f12771h.setGifSetListener(iVar);
    }

    public void setHeadImage(boolean z) {
        DragImageView dragImageView = this.f12771h;
        if (dragImageView != null) {
            dragImageView.setIsHeadImage(z);
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.f12771h.setImageOnClickListener(onClickListener);
        this.j.setOnClickListener(onClickListener);
        this.b0 = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c0 = onLongClickListener;
        if (this.q) {
            return;
        }
        this.f12771h.setImageOnLongClickListener(onLongClickListener);
        this.j.setOnLongClickListener(this.c0);
    }

    public void setIsCanDrag(boolean z) {
        this.q = z;
    }

    public void setIsCdn(boolean z) {
        this.m = z;
    }

    public void setOnSizeChangedListener(DragImageView.k kVar) {
        this.f12771h.setOnSizeChangedListener(new h(kVar));
    }

    public void setOriImgSelectedCallback(p pVar) {
        this.U = pVar;
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.V = onTouchListener;
    }

    public void setUrl(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.f12771h.setTag(str);
        this.f12771h.setLoadBigImage(false);
        this.f12771h.setImageDrawable(null);
        this.n = false;
        this.o = false;
        this.O = E();
        this.d0 = null;
        if (V(str)) {
            U(str, z, false);
        }
    }

    public void setUserId(String str) {
        this.e0 = str;
    }

    public UrlDragImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12768e = 3;
        this.f12770g = null;
        this.f12771h = null;
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
        this.d0 = null;
        this.i0 = new f();
        this.j0 = new g();
        this.k0 = new k();
        this.f12769f = context;
        this.R = new d.a.j0.b0.b();
        N();
    }
}
