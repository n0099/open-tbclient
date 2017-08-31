package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class f extends RelativeLayout implements View.OnClickListener {
    private static final String axZ = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private int Bn;
    private boolean avK;
    private b avM;
    private boolean awB;
    protected com.baidu.tbadk.widget.a aya;
    protected TextView ayb;
    protected TextView ayc;
    protected TextView ayd;
    protected SubsamplingScaleImageView aye;
    private a ayf;
    private boolean ayg;
    private boolean ayh;
    private boolean ayi;
    private ImageUrlData ayj;
    private boolean ayk;
    private boolean ayl;
    private boolean aym;
    private TextView ayn;
    private com.baidu.tbadk.img.b ayo;
    private Runnable ayp;
    private SubsamplingScaleImageView.OnImageEventListener ayq;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void j(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BI();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ayb != null) {
                aj.j(this.ayb, d.g.btn_percent_yuantu);
                aj.b(this.ayb, d.e.cp_cont_g, 1, 0);
            }
            if (this.ayc != null) {
                aj.k(this.ayc, d.e.common_color_10022);
                aj.b(this.ayc, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aya != null) {
            this.aya.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayf = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aya = null;
        this.mContext = null;
        this.ayf = null;
        this.avK = false;
        this.ayi = false;
        this.ayk = false;
        this.ayl = false;
        this.awB = false;
        this.aym = false;
        this.ayn = null;
        this.ayp = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
            @Override // java.lang.Runnable
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.coreExtra.view.f.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        f.this.ayb.setVisibility(8);
                    }
                });
                f.this.ayb.startAnimation(alphaAnimation);
            }
        };
        this.ayq = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.2
            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onImageLoadError(Exception exc) {
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onImageLoaded() {
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onPreviewLoadError(Exception exc) {
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onReady() {
                f.this.mProgressBar.setVisibility(8);
                f.this.aya.HI();
                f.this.aya.setVisibility(4);
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BdLog.e(exc);
            }
        };
        this.mContext = context;
        this.ayo = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aya;
    }

    public void setGifSetListener(a.d dVar) {
        this.aya.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aya.setImageOnClickListener(onClickListener);
        this.aye.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aya.setImageOnLongClickListener(onLongClickListener);
        this.aye.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(final a.e eVar) {
        this.aya.setOnSizeChangedListener(new a.e() { // from class: com.baidu.tbadk.coreExtra.view.f.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (eVar != null) {
                    eVar.a(aVar, z, z2);
                }
                f.this.BE();
            }
        });
    }

    protected void init() {
        this.Bn = k.ad(this.mContext);
        this.mMaxHeight = k.ae(this.mContext) - ((int) this.mContext.getResources().getDimension(d.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aya = new com.baidu.tbadk.widget.a(this.mContext);
        this.aya.setLayoutParams(layoutParams);
        addView(this.aya);
        this.aye = new SubsamplingScaleImageView(this.mContext);
        this.aye.setMaxScale(50.0f);
        this.aye.setOnImageEventListener(this.ayq);
        this.aye.setVisibility(4);
        addView(this.aye, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BA();
        this.ayb = new TextView(this.mContext);
        aj.j(this.ayb, d.g.btn_percent_yuantu);
        this.ayb.setText(d.l.original_img_look);
        this.ayb.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.b(this.ayb, d.e.cp_cont_g, 1, 0);
        this.ayb.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayb.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayb.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.ayb.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.ayb.setOnClickListener(this);
        this.ayb.setVisibility(8);
        addView(this.ayb, layoutParams3);
        BB();
    }

    private void BA() {
        this.ayn = new TextView(this.mContext);
        this.ayn.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.ayn, layoutParams);
        this.ayn.setVisibility(8);
    }

    private void BB() {
        this.ayc = new TextView(this.mContext);
        aj.k(this.ayc, d.e.common_color_10022);
        this.ayc.setText(d.l.goto_pb_floor);
        this.ayc.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        aj.b(this.ayc, d.e.cp_cont_g, 1, 0);
        this.ayc.setCompoundDrawablePadding(k.dip2px(this.mContext, 4.0f));
        this.ayc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.ayc.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayc.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.ayb.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayc.setOnClickListener(this);
        this.ayc.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.ayc, layoutParams);
        this.ayc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC() {
        if (this.ayc != null) {
            boolean z = this.ayg || this.ayh;
            if (!this.awB && z && this.ayj != null && this.ayj.threadId > 0 && this.ayj.postId > 0 && this.ayj.mThreadType != 33) {
                this.ayc.setVisibility(0);
                if (this.ayn != null) {
                    this.ayn.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayc.setVisibility(8);
            if (this.ayn != null) {
                this.ayn.setVisibility(8);
            }
        }
    }

    private void BD() {
        if (this.ayc != null) {
            this.ayc.setVisibility(8);
            if (this.ayn != null) {
                this.ayn.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE() {
        if ((this.ayg || this.ayh) && this.ayj != null && this.ayj.mPicType == 1 && !TextUtils.isEmpty(this.ayj.mTagName)) {
            if (this.ayd != null) {
                this.ayd.setVisibility(8);
                this.ayd = null;
            }
            this.ayd = new TextView(this.mContext);
            this.ayd.setText(this.ayj.mTagName);
            this.ayd.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            aj.b(this.ayd, d.e.common_color_10013, 1, 0);
            aj.k(this.ayd, d.e.common_color_10215);
            this.ayd.setAlpha(0.75f);
            this.ayd.setIncludeFontPadding(false);
            this.ayd.setGravity(17);
            int g = k.g(this.mContext, d.f.ds2);
            this.ayd.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aya.getBottomOffset();
            layoutParams.leftMargin = this.aya.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ayd, layoutParams);
            this.ayd.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.awB = z;
        if (this.awB) {
            BD();
        } else {
            BC();
        }
    }

    public void o(String str, boolean z) {
        this.aya.setTag(str);
        this.aya.setLoadBigImage(false);
        this.aya.setImageDrawable(null);
        this.ayg = false;
        this.ayh = false;
        boolean fj = fj(str);
        this.ayk = bs(true);
        if (!this.ayk) {
            p(str, fj);
        }
        if (fj) {
            q(str, z);
        }
    }

    private boolean bp(boolean z) {
        if (!this.ayl || z) {
            this.ayl = true;
            if (!this.ayk || this.ayj == null || StringUtils.isNull(this.ayj.originalUrl, true) || this.ayj.originalSize < 0 || this.aye.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dX = ao.dX(this.ayj.originalUrl);
            this.aye.setImage(ImageSource.uri(com.baidu.tbadk.core.util.k.uG() + al.vI().dP(dX) + "/" + dX));
            this.aye.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BF() {
        bp(false);
    }

    private boolean fj(String str) {
        return i.hi() || com.baidu.tbadk.core.util.c.c.em(str);
    }

    private void p(String str, final boolean z) {
        if (this.ayj == null) {
            bq(z);
        } else if (com.baidu.tbadk.core.util.c.c.em(str)) {
            bq(z);
        } else if (!TextUtils.isEmpty(this.ayj.imageUrl)) {
            com.baidu.adp.lib.f.c.fK().a(this.ayj.imageUrl, this.ayj.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                    f.this.bq(z);
                    if (!f.this.ayh) {
                        if (aVar != null) {
                            Bitmap kO = aVar.kO();
                            if (kO != null) {
                                f.this.ayg = true;
                                if (aVar.isGif()) {
                                    byte[] kT = aVar.kT();
                                    if (kT == null) {
                                        kT = BitmapHelper.Bitmap2Bytes(kO, 100);
                                    }
                                    f.this.aya.a(kT, kO);
                                    f.this.aya.invalidate();
                                    f.this.aya.play();
                                    f.this.aym = false;
                                } else {
                                    f.this.aya.setImageBitmap(kO);
                                    f.this.aya.setImageData(aVar.kT());
                                }
                                f.this.BC();
                                f.this.BE();
                            } else if (!z) {
                                f.this.aya.HF();
                            }
                        } else if (!z) {
                            f.this.aya.HF();
                        }
                    }
                }
            }, 0, 0, true, null, new Object[0]);
        } else {
            bq(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.aya.HF();
        }
    }

    private void q(String str, boolean z) {
        d(str, z, false);
    }

    private void d(String str, boolean z, boolean z2) {
        if (fk(str)) {
            if (z2 || (!this.ayi && !this.ayh)) {
                if (!z2 || !bp(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.ayi = true;
                    com.baidu.adp.lib.f.c.fK().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayi = false;
                            f.this.aya.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayi = false;
                            f.this.ayh = true;
                            f.this.mProgressBar.setVisibility(8);
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.aya.getImageData(), Boolean.valueOf(this.avK));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bn, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.ayo.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayh = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ayo.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayh = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fk(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.ayf != null) {
                this.ayf.j(aVar.getUrl(), aVar.kT());
            }
            Bitmap kO = aVar.kO();
            if (kO == null) {
                if (!this.ayg) {
                    this.aya.HF();
                    return;
                }
                this.ayh = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.aya.a(aVar.kT(), kO);
                this.aya.invalidate();
                this.aya.play();
                this.aym = false;
                this.ayb.setVisibility(8);
            } else {
                this.aya.setImageBitmap(kO);
                this.aya.setImageData(aVar.kT());
                if (this.aym) {
                    this.ayb.setVisibility(0);
                }
            }
            BC();
            BE();
            this.aya.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aya.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aya != null) {
            this.aya.onDestroy();
        }
        if (this.aye != null) {
            this.aye.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aya != null) {
            this.aya.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BG() {
        if (this.aya != null && this.aya.getImageType() == 1) {
            this.aya.stop();
        }
    }

    public void br(boolean z) {
        i(z, false);
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.aya != null && (str = (String) this.aya.getTag()) != null) {
            if ((!fk(str) || i.hi()) && this.aya != null) {
                if (this.aya.getImageType() == 1) {
                    if (this.aya.getGifCache() == null || !this.aya.HM()) {
                        d(str, z, z2);
                    }
                } else if (this.aya.getImageType() == 2) {
                    d(str, z, z2);
                } else if (this.aya.getImageBitmap() == null || !this.aya.HM()) {
                    d(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aya != null) {
            return this.aya.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayj = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avK = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayb) {
            final String dX = ao.dX(this.ayj.originalUrl);
            if (this.ayj.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CN().x(dX, 13);
                this.ayj.originalProcess = -1;
                if (this.ayj.originalSize > 0) {
                    this.ayb.setText(axZ + "(" + am.G(this.ayj.originalSize) + ")");
                } else {
                    this.ayb.setText(axZ);
                }
                this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.avM != null) {
                this.avM.BI();
            }
            com.baidu.adp.base.e<?> X = com.baidu.adp.base.i.X(this.mContext);
            if (X == null) {
                fl(dX);
            } else if (!i.hi() || i.hj() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                fl(dX);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(X.getPageActivity());
                aVar.cc(d.l.original_img_down_no_wifi_tip);
                aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        f.this.fl(dX);
                    }
                });
                aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(X);
                aVar.to();
            }
        } else if (view == this.ayc && this.ayj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayj.threadId), String.valueOf(this.ayj.postId), this.ayj.mIsSeeHost, this.ayj.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(String str) {
        if (this.ayj != null) {
            this.ayj.originalProcess = 0;
        }
        this.ayb.setText("0%");
        this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayj.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(com.baidu.tbadk.core.util.k.uG() + al.vI().dP(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.9
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.ayj != null && f.this.ayj.originalProcess != -1) {
                        f.this.ayj.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayj == null || f.this.ayj.originalProcess != -1) {
                        f.this.ayb.setText(downloadData2.getProcess() + "%");
                        f.this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayb.setText(f.this.getResources().getString(d.l.done));
                f.this.ayb.setClickable(false);
                f.this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fQ().postDelayed(f.this.ayp, 1500L);
                f.this.ayl = false;
                f.this.ayk = f.this.bs(false);
                f.this.BF();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayl = false;
                BdToast.a(f.this.mContext, str2).tu().tw();
                f.this.ayj.originalProcess = -1;
                if (f.this.ayj.originalSize > 0) {
                    f.this.ayb.setText(f.axZ + "(" + am.G(f.this.ayj.originalSize) + ")");
                } else {
                    f.this.ayb.setText(f.axZ);
                }
                f.this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        com.baidu.tbadk.download.e.CN().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(boolean z) {
        if (this.ayj != null && !StringUtils.isNull(this.ayj.originalUrl, true) && this.ayj.originalSize >= 0) {
            String dX = ao.dX(this.ayj.originalUrl);
            if (new File(com.baidu.tbadk.core.util.k.uG() + al.vI().dP(dX) + "/" + dX).exists()) {
                this.ayj.originalProcess = 100;
                if (z) {
                    this.ayb.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ayj.originalProcess < 0) {
                if (this.ayj.originalSize > 0) {
                    this.ayb.setText(axZ + "(" + am.G(this.ayj.originalSize) + ")");
                } else {
                    this.ayb.setText(axZ);
                }
                this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.ayb.setText(this.ayj.originalProcess + "%");
                this.ayb.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.aym = true;
        } else {
            this.ayb.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avM = bVar;
    }
}
