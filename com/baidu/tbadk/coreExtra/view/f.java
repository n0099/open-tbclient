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
    private int Bp;
    private boolean auR;
    private b auT;
    private boolean avI;
    private View.OnLongClickListener axA;
    private Runnable axB;
    private Runnable axC;
    private View.OnTouchListener axD;
    protected com.baidu.tbadk.widget.a axh;
    protected TextView axi;
    protected TextView axj;
    protected TextView axk;
    protected SubsamplingScaleImageView axl;
    private SubsamplingScaleImageView.OnImageEventListener axm;
    private a axn;
    private boolean axo;
    private boolean axp;
    private boolean axq;
    private ImageUrlData axr;
    private boolean axs;
    private boolean axt;
    public boolean axu;
    private TextView axv;
    private com.baidu.tbadk.img.b axw;
    private View.OnTouchListener axx;
    private boolean axy;
    private float axz;
    protected Context mContext;
    private int mMaxHeight;
    private View.OnClickListener mOnClickListener;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private static final String axf = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private static long axg = 52428800;
    private static final String TAG = f.class.getSimpleName();
    private static final int TOUCH_SLOP = ViewConfiguration.get(TbadkCoreApplication.getInst()).getScaledTouchSlop();

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Bl();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.axi != null) {
                aj.j(this.axi, d.g.btn_percent_yuantu);
                aj.b(this.axi, d.e.cp_cont_g, 1, 0);
            }
            if (this.axj != null) {
                aj.k(this.axj, d.e.common_color_10022);
                aj.b(this.axj, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axh != null) {
            this.axh.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.axn = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.axh = null;
        this.mContext = null;
        this.axn = null;
        this.auR = false;
        this.axq = false;
        this.axs = false;
        this.axt = false;
        this.avI = false;
        this.axu = false;
        this.axv = null;
        this.axy = true;
        this.axz = 0.0f;
        this.mOnClickListener = null;
        this.axA = null;
        this.axB = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.this.axy = true;
            }
        };
        this.axC = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.5
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
                        f.this.axi.setVisibility(8);
                        f.this.axu = false;
                    }
                });
                f.this.axi.startAnimation(alphaAnimation);
            }
        };
        this.axD = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (f.this.axx != null) {
                    f.this.axx.onTouch(view, motionEvent);
                    return false;
                }
                return false;
            }
        };
        this.mContext = context;
        this.axw = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.axh;
    }

    public void setGifSetListener(a.e eVar) {
        this.axh.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.axh.setImageOnClickListener(onClickListener);
        this.axl.setOnClickListener(onClickListener);
        this.mOnClickListener = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axh.setImageOnLongClickListener(onLongClickListener);
        this.axl.setOnLongClickListener(onLongClickListener);
        this.axA = onLongClickListener;
    }

    public void setOnSizeChangedListener(final a.f fVar) {
        this.axh.setOnSizeChangedListener(new a.f() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.widget.a.f
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (fVar != null) {
                    fVar.a(aVar, z, z2);
                }
                f.this.Bc();
            }
        });
    }

    protected void init() {
        this.Bp = l.ad(this.mContext);
        this.mMaxHeight = l.af(this.mContext) - ((int) this.mContext.getResources().getDimension(d.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.axh = new com.baidu.tbadk.widget.a(this.mContext);
        this.axh.setLayoutParams(layoutParams);
        this.axh.setOnTouchListener(this.axD);
        addView(this.axh);
        this.axl = new SubsamplingScaleImageView(this.mContext);
        this.axl.setMaxScale(50.0f);
        this.axl.setOnTouchListener(this.axD);
        this.axl.setVisibility(4);
        addView(this.axl, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        AY();
        this.axi = new TextView(this.mContext);
        aj.j(this.axi, d.g.btn_percent_yuantu);
        this.axi.setText(d.l.original_img_look);
        this.axi.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.b(this.axi, d.e.cp_cont_g, 1, 0);
        this.axi.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.axi.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.axi.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.axi.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.axi.setOnClickListener(this);
        this.axi.setVisibility(8);
        addView(this.axi, layoutParams3);
        AZ();
    }

    public void setOuterOnTouchListener(View.OnTouchListener onTouchListener) {
        this.axx = onTouchListener;
    }

    private void AY() {
        this.axv = new TextView(this.mContext);
        this.axv.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.axv, layoutParams);
        this.axv.setVisibility(8);
    }

    private void AZ() {
        this.axj = new TextView(this.mContext);
        aj.k(this.axj, d.e.common_color_10022);
        this.axj.setText(d.l.goto_pb_floor);
        this.axj.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        aj.b(this.axj, d.e.cp_cont_g, 1, 0);
        this.axj.setCompoundDrawablePadding(l.dip2px(this.mContext, 4.0f));
        this.axj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.axj.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.axj.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.axi.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.axj.setOnClickListener(this);
        this.axj.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.axj, layoutParams);
        this.axj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if (this.axj != null) {
            boolean z = this.axo || this.axp;
            if (!this.avI && z && this.axr != null && this.axr.threadId > 0 && this.axr.postId > 0 && this.axr.mThreadType != 33 && !this.axr.isBlockedPic) {
                this.axj.setVisibility(0);
                if (this.axv != null) {
                    this.axv.setVisibility(0);
                    return;
                }
                return;
            }
            this.axj.setVisibility(8);
            if (this.axv != null) {
                this.axv.setVisibility(8);
            }
        }
    }

    private void Bb() {
        if (this.axj != null) {
            this.axj.setVisibility(8);
            if (this.axv != null) {
                this.axv.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        if ((this.axo || this.axp) && this.axr != null && this.axr.mPicType == 1 && !TextUtils.isEmpty(this.axr.mTagName)) {
            if (this.axk != null) {
                this.axk.setVisibility(8);
                this.axk = null;
            }
            this.axk = new TextView(this.mContext);
            this.axk.setText(this.axr.mTagName);
            this.axk.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            aj.b(this.axk, d.e.common_color_10013, 1, 0);
            aj.k(this.axk, d.e.common_color_10215);
            this.axk.setAlpha(0.75f);
            this.axk.setIncludeFontPadding(false);
            this.axk.setGravity(17);
            int f = l.f(this.mContext, d.f.ds2);
            this.axk.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.axh.getBottomOffset();
            layoutParams.leftMargin = this.axh.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.axk, layoutParams);
            this.axk.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.avI = z;
        if (this.avI) {
            Bb();
        } else {
            Ba();
        }
    }

    public void n(String str, boolean z) {
        if (str.contains("*")) {
            str = str.split("[*]")[0];
        }
        this.axh.setTag(str);
        this.axh.setLoadBigImage(false);
        this.axh.setImageDrawable(null);
        this.axo = false;
        this.axp = false;
        boolean fc = fc(str);
        this.axs = br(true);
        if (!this.axs) {
            o(str, fc);
        }
        if (fc) {
            p(str, z);
        }
    }

    private boolean bo(boolean z) {
        String dQ;
        if (!this.axt || z) {
            this.axt = true;
            if (!this.axs || this.axr == null || StringUtils.isNull(this.axr.originalUrl, true) || this.axr.originalSize < 0 || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String str = k.uj() + al.vm().dI(dQ) + "/" + ao.dQ(this.axr.originalUrl);
            final int[] dm = k.dm(str);
            this.axl.setVisibility(0);
            if (this.axm == null) {
                this.axm = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.8
                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onReady() {
                        f.this.mProgressBar.setVisibility(8);
                        f.this.axh.Hp();
                        f.this.axh.setVisibility(4);
                    }

                    @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
                    public void onImageLoaded() {
                        if (f.this.axr.isLongPic && dm[0] > 0) {
                            f.this.axh.onDestroy();
                            final float measuredWidth = (f.this.getMeasuredWidth() * 1.0f) / dm[0];
                            final PointF pointF = new PointF((dm[0] * 1.0f) / 2.0f, 0.0f);
                            f.this.axl.setScaleAndCenter(measuredWidth, pointF);
                            f.this.axl.setMaxScale(2.0f * measuredWidth);
                            f.this.axl.setDoubleTapZoomScale(2.0f * measuredWidth);
                            f.this.axl.setInitScale(measuredWidth);
                            f.this.axl.setDoubleTapZoomStyle(4);
                            f.this.axl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.f.8.1
                                @Override // android.view.View.OnTouchListener
                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                    if (f.this.axx != null) {
                                        f.this.axx.onTouch(view, motionEvent);
                                    }
                                    switch (motionEvent.getAction() & CompatibleUtile.getActionMask()) {
                                        case 0:
                                            f.this.axz = motionEvent.getY();
                                            f.this.axl.setOnClickListener(f.this.axy ? f.this.mOnClickListener : null);
                                            f.this.axl.setOnLongClickListener(f.this.axy ? f.this.axA : null);
                                            break;
                                        case 1:
                                        case 3:
                                            if (f.this.axl.getScale() < measuredWidth) {
                                                f.this.axl.setScaleAndCenter(measuredWidth, pointF);
                                            }
                                            com.baidu.adp.lib.g.e.fP().removeCallbacks(f.this.axB);
                                            com.baidu.adp.lib.g.e.fP().postDelayed(f.this.axB, 1000L);
                                            break;
                                        case 2:
                                            if (Math.abs(motionEvent.getY() - f.this.axz) > f.TOUCH_SLOP) {
                                                f.this.axy = false;
                                                f.this.axl.setOnClickListener(null);
                                                f.this.axl.setOnLongClickListener(null);
                                            }
                                            f.this.axz = motionEvent.getY();
                                            break;
                                    }
                                    return false;
                                }
                            });
                            f.this.axh.setVisibility(4);
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
            this.axl.setOnImageEventListener(this.axm);
            if (this.axl.isImageLoaded() && this.axr.isLongPic) {
                this.axm.onImageLoaded();
            } else {
                this.axl.setImage(ImageSource.uri(str));
            }
            return true;
        }
        return false;
    }

    public void setDragToExitListener(a.d dVar) {
        if (this.axh != null) {
            this.axh.setDragToExitListener(dVar);
        }
    }

    public void Bd() {
        bo(false);
    }

    private boolean fc(String str) {
        return j.hh() || com.baidu.tbadk.core.util.c.c.ee(str);
    }

    private void o(String str, final boolean z) {
        if (this.axr == null) {
            bp(z);
        } else if (com.baidu.tbadk.core.util.c.c.ee(str)) {
            bp(z);
        } else if (!TextUtils.isEmpty(this.axr.imageUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.axr.imageUrl, this.axr.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.9
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                    f.this.bp(z);
                    if (!f.this.axp) {
                        if (aVar != null) {
                            Bitmap kN = aVar.kN();
                            if (kN != null) {
                                f.this.axo = true;
                                if (!aVar.isGif()) {
                                    if (f.this.axr != null && f.this.axr.isLongPic) {
                                        f.this.axh.Hg();
                                        f.this.axh.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.9.1
                                            @Override // com.baidu.tbadk.widget.a.b.a
                                            public void Bk() {
                                                f.this.mProgressBar.setVisibility(8);
                                            }
                                        });
                                    } else {
                                        f.this.mProgressBar.setVisibility(8);
                                    }
                                    f.this.axh.setImageUrlData(f.this.axr);
                                    f.this.axh.a(kN, aVar.kS());
                                } else {
                                    byte[] kS = aVar.kS();
                                    if (kS == null) {
                                        kS = BitmapHelper.Bitmap2Bytes(kN, 100);
                                    }
                                    f.this.axh.a(kS, kN);
                                    f.this.axh.invalidate();
                                    f.this.axh.play();
                                    f.this.mProgressBar.setVisibility(8);
                                    f.this.axu = false;
                                }
                                f.this.Ba();
                                f.this.Bc();
                            } else if (!z) {
                                f.this.axh.Hm();
                            }
                        } else if (!z) {
                            f.this.axh.Hm();
                        }
                    }
                }
            }, 0, 0, true, null, new Object[0]);
        } else {
            bp(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.axh.Hm();
        }
    }

    private void p(String str, boolean z) {
        d(str, z, false);
    }

    private void d(String str, boolean z, boolean z2) {
        if (fd(str)) {
            if (z2 || (!this.axq && !this.axp)) {
                if (!z2 || !bo(true)) {
                    this.axq = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.10
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.axq = false;
                            f.this.axh.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i) {
                            f.this.axq = false;
                            f.this.axp = true;
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.axh.getImageData(), Boolean.valueOf(this.auR));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bp, this.mMaxHeight));
        com.baidu.adp.widget.ImageView.a a2 = this.axw.a(imageFileInfo, false);
        if (a2 != null) {
            this.axp = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.axw.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.11
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.ImageView.a aVar, String str2, boolean z3) {
                f.this.axp = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fd(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            if (this.axn != null) {
                this.axn.j(aVar.getUrl(), aVar.kS());
            }
            Bitmap kN = aVar.kN();
            if (kN == null) {
                if (!this.axo) {
                    this.axh.Hm();
                    return;
                }
                this.axp = false;
                o(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.axh.a(aVar.kS(), kN);
                this.axh.invalidate();
                this.axh.play();
                this.axu = false;
                this.mProgressBar.setVisibility(8);
                this.axi.setVisibility(8);
            } else {
                if (this.axr != null && this.axr.isLongPic) {
                    this.axh.Hg();
                    this.axh.setImageLoadCallBack(new com.baidu.tbadk.widget.a.b.a() { // from class: com.baidu.tbadk.coreExtra.view.f.12
                        @Override // com.baidu.tbadk.widget.a.b.a
                        public void Bk() {
                            f.this.mProgressBar.setVisibility(8);
                        }
                    });
                } else {
                    this.mProgressBar.setVisibility(8);
                }
                this.axh.setImageUrlData(this.axr);
                this.axh.a(kN, aVar.kS());
                if (this.axu) {
                    if (Bh()) {
                        this.axi.setVisibility(0);
                    } else {
                        this.axi.setVisibility(8);
                    }
                }
            }
            Ba();
            Bc();
            this.axh.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.axh.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.axh != null) {
            this.axh.onDestroy();
        }
        if (this.axl != null) {
            this.axl.recycle();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.axB);
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.axh != null) {
            this.axh.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Be() {
        if (this.axh != null && this.axh.getImageType() == 1) {
            this.axh.stop();
        }
    }

    public void bq(boolean z) {
        j(z, false);
    }

    public void j(boolean z, boolean z2) {
        String str;
        if (this.axh != null && (str = (String) this.axh.getTag()) != null) {
            if ((!fd(str) || j.hh()) && this.axh != null) {
                if (this.axh.getImageType() == 1) {
                    if (this.axh.getGifCache() == null || !this.axh.Ht()) {
                        d(str, z, z2);
                    }
                } else if (this.axh.getImageType() == 2) {
                    d(str, z, z2);
                } else if (Bf()) {
                    d(str, z, z2);
                }
            }
        }
    }

    private boolean Bf() {
        if (this.axh.getImageBitmap() != null && this.axh.Ht()) {
            if (this.axr == null || !this.axr.isLongPic || this.axh.Hh()) {
                return false;
            }
            this.axp = false;
            this.axt = false;
            return true;
        }
        return true;
    }

    public int getImageType() {
        if (this.axh != null) {
            return this.axh.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.axr = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.auR = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axi) {
            if (!(this.axi.getTag() instanceof Boolean) || ((Boolean) this.axi.getTag()).booleanValue()) {
                final String dQ = ao.dQ(this.axr.originalUrl);
                if (this.axr.originalProcess >= 0) {
                    com.baidu.tbadk.download.e.Cr().x(dQ, 13);
                    this.axr.originalProcess = -1;
                    Bg();
                    return;
                }
                if (this.auT != null) {
                    this.auT.Bl();
                }
                com.baidu.adp.base.e<?> Y = i.Y(this.mContext);
                if (Y == null) {
                    fe(dQ);
                } else if (!j.hh() || j.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                    fe(dQ);
                } else {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
                    aVar.cd(d.l.original_img_down_no_wifi_tip);
                    aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                            f.this.fe(dQ);
                        }
                    });
                    aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.3
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(Y);
                    aVar.ti();
                }
            }
        } else if (view == this.axj && this.axr != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.axr.threadId), String.valueOf(this.axr.postId), this.axr.mIsSeeHost, this.axr.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(String str) {
        if (this.axr != null) {
            this.axr.originalProcess = 0;
        }
        this.axi.setText("0%");
        this.axi.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.axr.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(k.uj() + al.vm().dI(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.4
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.axr != null && f.this.axr.originalProcess != -1) {
                        f.this.axr.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.axr == null || f.this.axr.originalProcess != -1) {
                        f.this.axi.setText(downloadData2.getProcess() + "%");
                        f.this.axi.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.axi.setText(f.this.getResources().getString(d.l.done));
                f.this.axi.setTag(false);
                f.this.axi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.axC, 1500L);
                f.this.axt = false;
                f.this.axs = f.this.br(false);
                f.this.Bd();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.axt = false;
                BdToast.a(f.this.mContext, str2).to().tq();
                f.this.axr.originalProcess = -1;
                f.this.Bg();
            }
        });
        com.baidu.tbadk.download.e.Cr().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean br(boolean z) {
        if (this.axr != null && !StringUtils.isNull(this.axr.originalUrl, true) && this.axr.originalSize >= 0 && !this.axr.isBlockedPic) {
            String dQ = ao.dQ(this.axr.originalUrl);
            if (new File(k.uj() + al.vm().dI(dQ) + "/" + dQ).exists()) {
                this.axr.originalProcess = 100;
                if (z) {
                    this.axi.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.axr.originalProcess < 0) {
                Bg();
            } else {
                this.axi.setText(this.axr.originalProcess + "%");
                this.axi.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.axu = true;
        } else {
            this.axi.setVisibility(8);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg() {
        if (this.axr != null) {
            if (!Bh() || !this.axu) {
                this.axi.setVisibility(8);
            } else {
                this.axi.setVisibility(0);
            }
            if (this.axr.originalSize > 0 && !N(this.axr.originalSize)) {
                this.axi.setText(axf + "(" + am.F(this.axr.originalSize) + ")");
            } else {
                this.axi.setText(axf);
            }
            this.axi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    private boolean Bh() {
        return (this.axr == null || !this.axr.mIsShowOrigonButton || this.axr.isBlockedPic || StringUtils.isNull(this.axr.originalUrl)) ? false : true;
    }

    public boolean Bi() {
        return this.axu && Bh();
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.auT = bVar;
    }

    private boolean N(long j) {
        return j > axg;
    }
}
