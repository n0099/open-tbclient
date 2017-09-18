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
    private static final String axW = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private int Bn;
    private boolean avH;
    private b avJ;
    private boolean awy;
    protected com.baidu.tbadk.widget.a axX;
    protected TextView axY;
    protected TextView axZ;
    protected TextView aya;
    protected SubsamplingScaleImageView ayb;
    private a ayc;
    private boolean ayd;
    private boolean aye;
    private boolean ayf;
    private ImageUrlData ayg;
    private boolean ayh;
    private boolean ayi;
    private boolean ayj;
    private TextView ayk;
    private com.baidu.tbadk.img.b ayl;
    private Runnable aym;
    private SubsamplingScaleImageView.OnImageEventListener ayn;
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
            if (this.axY != null) {
                aj.j(this.axY, d.g.btn_percent_yuantu);
                aj.b(this.axY, d.e.cp_cont_g, 1, 0);
            }
            if (this.axZ != null) {
                aj.k(this.axZ, d.e.common_color_10022);
                aj.b(this.axZ, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axX != null) {
            this.axX.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayc = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.axX = null;
        this.mContext = null;
        this.ayc = null;
        this.avH = false;
        this.ayf = false;
        this.ayh = false;
        this.ayi = false;
        this.awy = false;
        this.ayj = false;
        this.ayk = null;
        this.aym = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
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
                        f.this.axY.setVisibility(8);
                    }
                });
                f.this.axY.startAnimation(alphaAnimation);
            }
        };
        this.ayn = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.2
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
                f.this.axX.HI();
                f.this.axX.setVisibility(4);
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BdLog.e(exc);
            }
        };
        this.mContext = context;
        this.ayl = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.axX;
    }

    public void setGifSetListener(a.d dVar) {
        this.axX.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.axX.setImageOnClickListener(onClickListener);
        this.ayb.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axX.setImageOnLongClickListener(onLongClickListener);
        this.ayb.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(final a.e eVar) {
        this.axX.setOnSizeChangedListener(new a.e() { // from class: com.baidu.tbadk.coreExtra.view.f.3
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
        this.Bn = k.ae(this.mContext);
        this.mMaxHeight = k.af(this.mContext) - ((int) this.mContext.getResources().getDimension(d.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.axX = new com.baidu.tbadk.widget.a(this.mContext);
        this.axX.setLayoutParams(layoutParams);
        addView(this.axX);
        this.ayb = new SubsamplingScaleImageView(this.mContext);
        this.ayb.setMaxScale(50.0f);
        this.ayb.setOnImageEventListener(this.ayn);
        this.ayb.setVisibility(4);
        addView(this.ayb, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BA();
        this.axY = new TextView(this.mContext);
        aj.j(this.axY, d.g.btn_percent_yuantu);
        this.axY.setText(d.l.original_img_look);
        this.axY.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        aj.b(this.axY, d.e.cp_cont_g, 1, 0);
        this.axY.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.axY.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.axY.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.axY.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.axY.setOnClickListener(this);
        this.axY.setVisibility(8);
        addView(this.axY, layoutParams3);
        BB();
    }

    private void BA() {
        this.ayk = new TextView(this.mContext);
        this.ayk.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.ayk, layoutParams);
        this.ayk.setVisibility(8);
    }

    private void BB() {
        this.axZ = new TextView(this.mContext);
        aj.k(this.axZ, d.e.common_color_10022);
        this.axZ.setText(d.l.goto_pb_floor);
        this.axZ.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        aj.b(this.axZ, d.e.cp_cont_g, 1, 0);
        this.axZ.setCompoundDrawablePadding(k.dip2px(this.mContext, 4.0f));
        this.axZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.axZ.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.axZ.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.axY.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.axZ.setOnClickListener(this);
        this.axZ.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.axZ, layoutParams);
        this.axZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC() {
        if (this.axZ != null) {
            boolean z = this.ayd || this.aye;
            if (!this.awy && z && this.ayg != null && this.ayg.threadId > 0 && this.ayg.postId > 0 && this.ayg.mThreadType != 33) {
                this.axZ.setVisibility(0);
                if (this.ayk != null) {
                    this.ayk.setVisibility(0);
                    return;
                }
                return;
            }
            this.axZ.setVisibility(8);
            if (this.ayk != null) {
                this.ayk.setVisibility(8);
            }
        }
    }

    private void BD() {
        if (this.axZ != null) {
            this.axZ.setVisibility(8);
            if (this.ayk != null) {
                this.ayk.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE() {
        if ((this.ayd || this.aye) && this.ayg != null && this.ayg.mPicType == 1 && !TextUtils.isEmpty(this.ayg.mTagName)) {
            if (this.aya != null) {
                this.aya.setVisibility(8);
                this.aya = null;
            }
            this.aya = new TextView(this.mContext);
            this.aya.setText(this.ayg.mTagName);
            this.aya.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            aj.b(this.aya, d.e.common_color_10013, 1, 0);
            aj.k(this.aya, d.e.common_color_10215);
            this.aya.setAlpha(0.75f);
            this.aya.setIncludeFontPadding(false);
            this.aya.setGravity(17);
            int f = k.f(this.mContext, d.f.ds2);
            this.aya.setPadding(f, f, f, f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.axX.getBottomOffset();
            layoutParams.leftMargin = this.axX.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aya, layoutParams);
            this.aya.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.awy = z;
        if (this.awy) {
            BD();
        } else {
            BC();
        }
    }

    public void o(String str, boolean z) {
        this.axX.setTag(str);
        this.axX.setLoadBigImage(false);
        this.axX.setImageDrawable(null);
        this.ayd = false;
        this.aye = false;
        boolean fj = fj(str);
        this.ayh = bs(true);
        if (!this.ayh) {
            p(str, fj);
        }
        if (fj) {
            q(str, z);
        }
    }

    private boolean bp(boolean z) {
        if (!this.ayi || z) {
            this.ayi = true;
            if (!this.ayh || this.ayg == null || StringUtils.isNull(this.ayg.originalUrl, true) || this.ayg.originalSize < 0 || this.ayb.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dX = ao.dX(this.ayg.originalUrl);
            this.ayb.setImage(ImageSource.uri(com.baidu.tbadk.core.util.k.uG() + al.vI().dP(dX) + "/" + dX));
            this.ayb.setVisibility(0);
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
        if (this.ayg == null) {
            bq(z);
        } else if (com.baidu.tbadk.core.util.c.c.em(str)) {
            bq(z);
        } else if (!TextUtils.isEmpty(this.ayg.imageUrl)) {
            com.baidu.adp.lib.f.c.fK().a(this.ayg.imageUrl, this.ayg.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                    f.this.bq(z);
                    if (!f.this.aye) {
                        if (aVar != null) {
                            Bitmap kO = aVar.kO();
                            if (kO != null) {
                                f.this.ayd = true;
                                if (aVar.isGif()) {
                                    byte[] kT = aVar.kT();
                                    if (kT == null) {
                                        kT = BitmapHelper.Bitmap2Bytes(kO, 100);
                                    }
                                    f.this.axX.a(kT, kO);
                                    f.this.axX.invalidate();
                                    f.this.axX.play();
                                    f.this.ayj = false;
                                } else {
                                    f.this.axX.setImageBitmap(kO);
                                    f.this.axX.setImageData(aVar.kT());
                                }
                                f.this.BC();
                                f.this.BE();
                            } else if (!z) {
                                f.this.axX.HF();
                            }
                        } else if (!z) {
                            f.this.axX.HF();
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
            this.axX.HF();
        }
    }

    private void q(String str, boolean z) {
        d(str, z, false);
    }

    private void d(String str, boolean z, boolean z2) {
        if (fk(str)) {
            if (z2 || (!this.ayf && !this.aye)) {
                if (!z2 || !bp(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.ayf = true;
                    com.baidu.adp.lib.f.c.fK().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayf = false;
                            f.this.axX.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayf = false;
                            f.this.aye = true;
                            f.this.mProgressBar.setVisibility(8);
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.axX.getImageData(), Boolean.valueOf(this.avH));
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
        com.baidu.adp.widget.a.a a2 = this.ayl.a(imageFileInfo, false);
        if (a2 != null) {
            this.aye = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ayl.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.aye = true;
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
            if (this.ayc != null) {
                this.ayc.j(aVar.getUrl(), aVar.kT());
            }
            Bitmap kO = aVar.kO();
            if (kO == null) {
                if (!this.ayd) {
                    this.axX.HF();
                    return;
                }
                this.aye = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.axX.a(aVar.kT(), kO);
                this.axX.invalidate();
                this.axX.play();
                this.ayj = false;
                this.axY.setVisibility(8);
            } else {
                this.axX.setImageBitmap(kO);
                this.axX.setImageData(aVar.kT());
                if (this.ayj) {
                    this.axY.setVisibility(0);
                }
            }
            BC();
            BE();
            this.axX.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.axX.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.axX != null) {
            this.axX.onDestroy();
        }
        if (this.ayb != null) {
            this.ayb.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.axX != null) {
            this.axX.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BG() {
        if (this.axX != null && this.axX.getImageType() == 1) {
            this.axX.stop();
        }
    }

    public void br(boolean z) {
        i(z, false);
    }

    public void i(boolean z, boolean z2) {
        String str;
        if (this.axX != null && (str = (String) this.axX.getTag()) != null) {
            if ((!fk(str) || i.hi()) && this.axX != null) {
                if (this.axX.getImageType() == 1) {
                    if (this.axX.getGifCache() == null || !this.axX.HM()) {
                        d(str, z, z2);
                    }
                } else if (this.axX.getImageType() == 2) {
                    d(str, z, z2);
                } else if (this.axX.getImageBitmap() == null || !this.axX.HM()) {
                    d(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.axX != null) {
            return this.axX.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayg = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avH = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axY) {
            final String dX = ao.dX(this.ayg.originalUrl);
            if (this.ayg.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CN().x(dX, 13);
                this.ayg.originalProcess = -1;
                if (this.ayg.originalSize > 0) {
                    this.axY.setText(axW + "(" + am.G(this.ayg.originalSize) + ")");
                } else {
                    this.axY.setText(axW);
                }
                this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.avJ != null) {
                this.avJ.BI();
            }
            com.baidu.adp.base.e<?> Y = com.baidu.adp.base.i.Y(this.mContext);
            if (Y == null) {
                fl(dX);
            } else if (!i.hi() || i.hj() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                fl(dX);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Y.getPageActivity());
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
                aVar.b(Y);
                aVar.to();
            }
        } else if (view == this.axZ && this.ayg != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayg.threadId), String.valueOf(this.ayg.postId), this.ayg.mIsSeeHost, this.ayg.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(String str) {
        if (this.ayg != null) {
            this.ayg.originalProcess = 0;
        }
        this.axY.setText("0%");
        this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayg.originalUrl);
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
                    if (f.this.ayg != null && f.this.ayg.originalProcess != -1) {
                        f.this.ayg.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayg == null || f.this.ayg.originalProcess != -1) {
                        f.this.axY.setText(downloadData2.getProcess() + "%");
                        f.this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.axY.setText(f.this.getResources().getString(d.l.done));
                f.this.axY.setClickable(false);
                f.this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fQ().postDelayed(f.this.aym, 1500L);
                f.this.ayi = false;
                f.this.ayh = f.this.bs(false);
                f.this.BF();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayi = false;
                BdToast.a(f.this.mContext, str2).tu().tw();
                f.this.ayg.originalProcess = -1;
                if (f.this.ayg.originalSize > 0) {
                    f.this.axY.setText(f.axW + "(" + am.G(f.this.ayg.originalSize) + ")");
                } else {
                    f.this.axY.setText(f.axW);
                }
                f.this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        com.baidu.tbadk.download.e.CN().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(boolean z) {
        if (this.ayg != null && !StringUtils.isNull(this.ayg.originalUrl, true) && this.ayg.originalSize >= 0) {
            String dX = ao.dX(this.ayg.originalUrl);
            if (new File(com.baidu.tbadk.core.util.k.uG() + al.vI().dP(dX) + "/" + dX).exists()) {
                this.ayg.originalProcess = 100;
                if (z) {
                    this.axY.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ayg.originalProcess < 0) {
                if (this.ayg.originalSize > 0) {
                    this.axY.setText(axW + "(" + am.G(this.ayg.originalSize) + ")");
                } else {
                    this.axY.setText(axW);
                }
                this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.axY.setText(this.ayg.originalProcess + "%");
                this.axY.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.ayj = true;
        } else {
            this.axY.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avJ = bVar;
    }
}
