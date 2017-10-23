package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class f extends RelativeLayout implements View.OnClickListener {
    private int Bq;
    private boolean auF;
    private b auH;
    private boolean avw;
    protected com.baidu.tbadk.widget.a awV;
    protected TextView awW;
    protected TextView awX;
    protected TextView awY;
    protected SubsamplingScaleImageView awZ;
    private SubsamplingScaleImageView.OnImageEventListener axa;
    private a axb;
    private boolean axc;
    private boolean axd;
    private boolean axe;
    private ImageUrlData axf;
    private boolean axg;
    private boolean axh;
    public boolean axi;
    private TextView axj;
    private com.baidu.tbadk.img.b axk;
    private View.OnTouchListener axl;
    private boolean axm;
    private float axn;
    private View.OnLongClickListener axo;
    private Runnable axp;
    private Runnable axq;
    private View.OnTouchListener axr;
    protected Context mContext;
    private int mMaxHeight;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private static final String awT = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private static long awU = 52428800;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Bf();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.awW != null) {
                aj.j(this.awW, d.g.btn_percent_yuantu);
                aj.b(this.awW, d.e.cp_cont_g, 1, 0);
            }
            if (this.awX != null) {
                aj.k(this.awX, d.e.common_color_10022);
                aj.b(this.awX, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awV != null) {
            this.awV.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.axb = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.awV = null;
        this.mContext = null;
        this.axb = null;
        this.auF = false;
        this.axe = false;
        this.axg = false;
        this.axh = false;
        this.avw = false;
        this.axi = false;
        this.axj = null;
        this.axm = true;
        this.axn = 0.0f;
        this.mOnClickListener = null;
        this.axo = null;
        this.axp = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axm = true;
            }
        };
        this.axq = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.5
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.f.5.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.awW.setVisibility(8);
                        f.this.axi = false;
                    }
                });
                f.this.awW.startAnimation(alphaAnimation);
            }
        };
        this.axr = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.axl != null) {
                    f.this.axl.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.axk = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.awV;
    }

    public void setGifSetListener(a.e eVar) {
        this.awV.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.awV.setImageOnClickListener(onClickListener);
        this.awZ.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awV.setImageOnLongClickListener(onLongClickListener);
        this.awZ.setOnLongClickListener(onLongClickListener);
        this.axo = onLongClickListener;
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.awV.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.AW();
            }
        });
    }

    protected void init() {
        this.Bq = l.ad(this.mContext);
        this.mMaxHeight = l.af(this.mContext) - ((int) this.mContext.getResources().getDimension(d.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.awV = new com.baidu.tbadk.widget.a(this.mContext);
        this.awV.setLayoutParams(layoutParams);
        this.awV.setOnTouchListener(this.axr);
        addView(this.awV);
        this.awZ = new SubsamplingScaleImageView(this.mContext);
        this.awZ.setMaxScale(50.0f);
        this.awZ.setOnTouchListener(this.axr);
        this.awZ.setVisibility(4);
        addView(this.awZ, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        AS();
        this.awW = new TextView(this.mContext);
        aj.j(this.awW, d.g.btn_percent_yuantu);
        this.awW.setText(d.l.original_img_look);
        this.awW.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.b(this.awW, d.e.cp_cont_g, 1, 0);
        this.awW.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.awW.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.awW.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.awW.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.awW.setOnClickListener(this);
        this.awW.setVisibility(8);
        addView(this.awW, layoutParams3);
        AT();
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.axl = onTouchListener;
    }

    private void AS() {
        this.axj = new TextView(this.mContext);
        this.axj.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.axj, layoutParams);
        this.axj.setVisibility(8);
    }

    private void AT() {
        this.awX = new TextView(this.mContext);
        aj.k(this.awX, d.e.common_color_10022);
        this.awX.setText(d.l.goto_pb_floor);
        this.awX.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        aj.b(this.awX, d.e.cp_cont_g, 1, 0);
        this.awX.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.awX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.awX.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.awX.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.awW.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.awX.setOnClickListener(this);
        this.awX.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.awX, layoutParams);
        this.awX.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AU() {
        if (this.awX != null) {
            boolean z = this.axc || this.axd;
            if (!this.avw && z && this.axf != null && this.axf.threadId > 0 && this.axf.postId > 0 && this.axf.mThreadType != 33 && !this.axf.isBlockedPic) {
                this.awX.setVisibility(0);
                if (this.axj != null) {
                    this.axj.setVisibility(0);
                    return;
                }
                return;
            }
            this.awX.setVisibility(8);
            if (this.axj != null) {
                this.axj.setVisibility(8);
            }
        }
    }

    private void AV() {
        if (this.awX != null) {
            this.awX.setVisibility(8);
            if (this.axj != null) {
                this.axj.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW() {
        if ((this.axc || this.axd) && this.axf != null && this.axf.mPicType == 1 && !TextUtils.isEmpty(this.axf.mTagName)) {
            if (this.awY != null) {
                this.awY.setVisibility(8);
                this.awY = null;
            }
            this.awY = new TextView(this.mContext);
            this.awY.setText(this.axf.mTagName);
            this.awY.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            aj.b(this.awY, d.e.common_color_10013, 1, 0);
            aj.k(this.awY, d.e.common_color_10215);
            this.awY.setAlpha(0.75f);
            this.awY.setIncludeFontPadding(false);
            this.awY.setGravity(17);
            int f = l.f(this.mContext, d.f.ds2);
            this.awY.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.awV.getBottomOffset();
            layoutParams.leftMargin = this.awV.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.awY, layoutParams);
            this.awY.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        this.avw = z;
        if (this.avw) {
            AV();
        } else {
            AU();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.awV.setTag(str);
        this.awV.setLoadBigImage(false);
        this.awV.setImageDrawable(null);
        this.axc = false;
        this.axd = false;
        boolean fb = fb(str);
        this.axg = bq(true);
        if (!this.axg) {
            o(str, fb);
        }
        if (fb) {
            p(str, z);
        }
    }

    private boolean bn(boolean z) {
        String dP;
        if (!this.axh || z) {
            this.axh = true;
            if (!this.axg || this.axf == null || StringUtils.isNull(this.axf.originalUrl, true) || this.axf.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.uc() + al.vf().dH(dP) + "/" + ao.dP(this.axf.originalUrl);
            final int[] dl = k.dl(str);
            this.awZ.setVisibility(0);
            if (this.axa == null) {
                this.axa = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.8
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.awV.Hj();
                        f.this.awV.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.axf.isLongPic && dl[0] > 0) {
                            f.this.awV.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dl[0];
                            final PointF pointF = new PointF((dl[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.awZ.setScaleAndCenter(measuredWidth, pointF);
                            f.this.awZ.setMaxScale(2.0f * measuredWidth);
                            f.this.awZ.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.awZ.setInitScale(measuredWidth);
                            f.this.awZ.setDoubleTapZoomStyle(4);
                            f.this.awZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.8.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.axl != null) {
                                        f.this.axl.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.axn = motionEvent.getY();
                                            f.this.awZ.setOnClickListener(f.this.axm ? f.this.mOnClickListener : null);
                                            f.this.awZ.setOnLongClickListener(f.this.axm ? f.this.axo : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.awZ.getScale() < measuredWidth) {
                                                f.this.awZ.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.axp);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.axp, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.axn) > f.TOUCH_SLOP) {
                                                f.this.axm = false;
                                                f.this.awZ.setOnClickListener(null);
                                                f.this.awZ.setOnLongClickListener(null);
                                            }
                                            f.this.axn = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.awV.setVisibility(4);
                        }
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onPreviewLoadError(Exception exc) {
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoadError(Exception exc) {
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onTileLoadError(Exception exc) {
                    }
                };
            }
            this.awZ.setOnImageEventListener(this.axa);
            if (this.awZ.isImageLoaded() && this.axf.isLongPic) {
                this.axa.onImageLoaded();
            } else {
                this.awZ.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        if (this.awV != null) {
            this.awV.setDragToExitListener(dVar);
        }
    }

    public void AX() {
        bn(false);
    }

    private boolean fb(String str) {
        return j.hh() || com.baidu.tbadk.core.util.c.c.ed(str);
    }

    private void o(String str, final boolean z) {
        if (this.axf == null) {
            bo(z);
        } else if (com.baidu.tbadk.core.util.c.c.ed(str)) {
            bo(z);
        } else if (!TextUtils.isEmpty(this.axf.imageUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.axf.imageUrl, this.axf.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    f.this.bo(z);
                    if (!f.this.axd) {
                        if (aVar != null) {
                            Bitmap kN = aVar.kN();
                            if (kN != null) {
                                f.this.axc = true;
                                if (!aVar.isGif()) {
                                    if (f.this.axf != null && f.this.axf.isLongPic) {
                                        f.this.awV.Ha();
                                        f.this.awV.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.9.1
                                            @Override // com.baidu.tbadk.widget.a.b.a
                                            public void Be() {
                                                f.this.mProgressBar.setVisibility(8);
                                            }
                                        });
                                    } else {
                                        f.this.mProgressBar.setVisibility(8);
                                    }
                                    f.this.awV.setImageUrlData(f.this.axf);
                                    f.this.awV.a(kN, aVar.kS());
                                } else {
                                    byte[] kS = aVar.kS();
                                    if (kS == null) {
                                        kS = BitmapHelper.Bitmap2Bytes(kN, 100);
                                    }
                                    f.this.awV.a(kS, kN);
                                    f.this.awV.invalidate();
                                    f.this.awV.play();
                                    f.this.mProgressBar.setVisibility(8);
                                    f.this.axi = false;
                                }
                                f.this.AU();
                                f.this.AW();
                            } else if (!z) {
                                f.this.awV.Hg();
                            }
                        } else if (!z) {
                            f.this.awV.Hg();
                        }
                    }
                }
            }, 0, 0, true, null, new Object[0]);
        } else {
            bo(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.awV.Hg();
        }
    }

    private void p(String str, boolean z) {
        d(str, z, false);
    }

    private void d(String str, boolean z, boolean z2) {
        if (fc(str)) {
            if (z2 || (!this.axe && !this.axd)) {
                if (!z2 || !bn(true)) {
                    this.axe = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.10
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.axe = false;
                            f.this.awV.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            f.this.axe = false;
                            f.this.axd = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.awV.getImageData(), Boolean.valueOf(this.auF));
                    return;
                }
                return;
            }
            return;
        }
        this.mProgressBar.setVisibility(0);
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bq, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.axk.a(imageFileInfo, false);
        if (a2 != null) {
            this.axd = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.axk.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                f.this.axd = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fc(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            if (this.axb != null) {
                this.axb.j(aVar.getUrl(), aVar.kS());
            }
            Bitmap kN = aVar.kN();
            if (kN == null) {
                if (!this.axc) {
                    this.awV.Hg();
                    return;
                }
                this.axd = false;
                o(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.awV.a(aVar.kS(), kN);
                this.awV.invalidate();
                this.awV.play();
                this.axi = false;
                this.mProgressBar.setVisibility(8);
                this.awW.setVisibility(8);
            } else {
                if (this.axf != null && this.axf.isLongPic) {
                    this.awV.Ha();
                    this.awV.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void Be() {
                            f.this.mProgressBar.setVisibility(8);
                        }
                    });
                } else {
                    this.mProgressBar.setVisibility(8);
                }
                this.awV.setImageUrlData(this.axf);
                this.awV.a(kN, aVar.kS());
                if (this.axi) {
                    if (Bb()) {
                        this.awW.setVisibility(0);
                    } else {
                        this.awW.setVisibility(8);
                    }
                }
            }
            AU();
            AW();
            this.awV.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.awV.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.awV != null) {
            this.awV.onDestroy();
        }
        if (this.awZ != null) {
            this.awZ.recycle();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.axp);
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.awV != null) {
            this.awV.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void AY() {
        if (this.awV != null && this.awV.getImageType() == 1) {
            this.awV.stop();
        }
    }

    public void bp(boolean z) {
        j(z, false);
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.awV != null && (str = (String) this.awV.getTag()) != null) {
            if ((!fc(str) || j.hh()) && this.awV != null) {
                if (this.awV.getImageType() == 1) {
                    if (this.awV.getGifCache() == null || !this.awV.Hn()) {
                        d(str, z, z2);
                    }
                } else if (this.awV.getImageType() == 2) {
                    d(str, z, z2);
                } else if (AZ()) {
                    d(str, z, z2);
                }
            }
        }
    }

    private boolean AZ() {
        if (this.awV.getImageBitmap() != null && this.awV.Hn()) {
            if (this.axf == null || !this.axf.isLongPic || this.awV.Hb()) {
                return false;
            }
            this.axd = false;
            this.axh = false;
            return true;
        }
        return true;
    }

    public int getImageType() {
        if (this.awV != null) {
            return this.awV.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.axf = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.auF = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awW) {
            if (!(this.awW.getTag() instanceof Boolean) || ((Boolean) this.awW.getTag()).booleanValue()) {
                final String dP = ao.dP(this.axf.originalUrl);
                if (this.axf.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Cl().x(dP, 13);
                    this.axf.originalProcess = -1;
                    Ba();
                    return;
                }
                if (this.auH != null) {
                    this.auH.Bf();
                }
                com.baidu.adp.base.e<?> Y = i.Y(this.mContext);
                if (Y == null) {
                    fd(dP);
                } else if (!j.hh() || j.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fd(dP);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
                    aVar.cc(d.l.original_img_down_no_wifi_tip);
                    aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fd(dP);
                        }
                    });
                    aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(Y);
                    aVar.tb();
                }
            }
        } else if (view == this.awX && this.axf != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.axf.threadId), String.valueOf(this.axf.postId), this.axf.mIsSeeHost, this.axf.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(String str) {
        if (this.axf != null) {
            this.axf.originalProcess = 0;
        }
        this.awW.setText("0%");
        this.awW.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.axf.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.uc() + al.vf().dH(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.4
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.axf != null && f.this.axf.originalProcess != -1) {
                        f.this.axf.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.axf == null || f.this.axf.originalProcess != -1) {
                        f.this.awW.setText(downloadData2.getProcess() + "%");
                        f.this.awW.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.awW.setText(f.this.getResources().getString(d.l.done));
                f.this.awW.setTag(false);
                f.this.awW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.axq, 1500L);
                f.this.axh = false;
                f.this.axg = f.this.bq(false);
                f.this.AX();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.axh = false;
                BdToast.a(f.this.mContext, str2).th().tj();
                f.this.axf.originalProcess = -1;
                f.this.Ba();
            }
        });
        com.baidu.tbadk.download.e.Cl().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bq(boolean z) {
        if (this.axf != null && !StringUtils.isNull(this.axf.originalUrl, true) && this.axf.originalSize >= 0 && !this.axf.isBlockedPic) {
            String dP = ao.dP(this.axf.originalUrl);
            if (new File(k.uc() + al.vf().dH(dP) + "/" + dP).exists()) {
                this.axf.originalProcess = 100;
                if (z) {
                    this.awW.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.axf.originalProcess < 0) {
                Ba();
            } else {
                this.awW.setText(this.axf.originalProcess + "%");
                this.awW.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.axi = true;
        } else {
            this.awW.setVisibility(8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if (this.axf != null) {
            if (!Bb() || !this.axi) {
                this.awW.setVisibility(8);
            } else {
                this.awW.setVisibility(0);
            }
            if (this.axf.originalSize > 0 && !O(this.axf.originalSize)) {
                this.awW.setText(awT + "(" + am.G(this.axf.originalSize) + ")");
            } else {
                this.awW.setText(awT);
            }
            this.awW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Bb() {
        return (this.axf == null || !this.axf.mIsShowOrigonButton || this.axf.isBlockedPic || StringUtils.isNull(this.axf.originalUrl)) ? false : true;
    }

    public boolean Bc() {
        return this.axi && Bb();
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.auH = bVar;
    }

    private boolean O(long j) {
        return j > awU;
    }
}
