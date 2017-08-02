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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.d;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class f extends RelativeLayout implements View.OnClickListener {
    private static final String axv = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private int BS;
    private boolean avX;
    private boolean avf;
    private b avh;
    protected SubsamplingScaleImageView axA;
    private a axB;
    private boolean axC;
    private boolean axD;
    private boolean axE;
    private ImageUrlData axF;
    private boolean axG;
    private boolean axH;
    private boolean axI;
    private TextView axJ;
    private com.baidu.tbadk.img.b axK;
    private Runnable axL;
    private SubsamplingScaleImageView.OnImageEventListener axM;
    protected com.baidu.tbadk.widget.a axw;
    protected TextView axx;
    protected TextView axy;
    protected TextView axz;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BF();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.axx != null) {
                ai.j(this.axx, d.g.btn_percent_yuantu);
                ai.b(this.axx, d.e.cp_cont_g, 1, 0);
            }
            if (this.axy != null) {
                ai.k(this.axy, d.e.common_color_10022);
                ai.b(this.axy, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.axw != null) {
            this.axw.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.axB = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.axw = null;
        this.mContext = null;
        this.axB = null;
        this.avf = false;
        this.axE = false;
        this.axG = false;
        this.axH = false;
        this.avX = false;
        this.axI = false;
        this.axJ = null;
        this.axL = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
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
                        f.this.axx.setVisibility(8);
                    }
                });
                f.this.axx.startAnimation(alphaAnimation);
            }
        };
        this.axM = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.2
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
                f.this.axw.HB();
                f.this.axw.setVisibility(4);
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BdLog.e(exc);
            }
        };
        this.mContext = context;
        this.axK = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.axw;
    }

    public void setGifSetListener(a.d dVar) {
        this.axw.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.axw.setImageOnClickListener(onClickListener);
        this.axA.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.axw.setImageOnLongClickListener(onLongClickListener);
        this.axA.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(final a.e eVar) {
        this.axw.setOnSizeChangedListener(new a.e() { // from class: com.baidu.tbadk.coreExtra.view.f.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (eVar != null) {
                    eVar.a(aVar, z, z2);
                }
                f.this.BB();
            }
        });
    }

    protected void init() {
        this.BS = k.af(this.mContext);
        this.mMaxHeight = k.ag(this.mContext) - ((int) this.mContext.getResources().getDimension(d.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.axw = new com.baidu.tbadk.widget.a(this.mContext);
        this.axw.setLayoutParams(layoutParams);
        addView(this.axw);
        this.axA = new SubsamplingScaleImageView(this.mContext);
        this.axA.setMaxScale(50.0f);
        this.axA.setOnImageEventListener(this.axM);
        this.axA.setVisibility(4);
        addView(this.axA, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bx();
        this.axx = new TextView(this.mContext);
        ai.j(this.axx, d.g.btn_percent_yuantu);
        this.axx.setText(d.l.original_img_look);
        this.axx.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.b(this.axx, d.e.cp_cont_g, 1, 0);
        this.axx.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.axx.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.axx.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.axx.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.axx.setOnClickListener(this);
        this.axx.setVisibility(8);
        addView(this.axx, layoutParams3);
        By();
    }

    private void Bx() {
        this.axJ = new TextView(this.mContext);
        this.axJ.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.axJ, layoutParams);
        this.axJ.setVisibility(8);
    }

    private void By() {
        this.axy = new TextView(this.mContext);
        ai.k(this.axy, d.e.common_color_10022);
        this.axy.setText(d.l.goto_pb_floor);
        this.axy.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        ai.b(this.axy, d.e.cp_cont_g, 1, 0);
        this.axy.setCompoundDrawablePadding(k.dip2px(this.mContext, 4.0f));
        this.axy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.axy.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.axy.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.axx.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.axy.setOnClickListener(this);
        this.axy.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.axy, layoutParams);
        this.axy.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bz() {
        if (this.axy != null) {
            boolean z = this.axC || this.axD;
            if (!this.avX && z && this.axF != null && this.axF.threadId > 0 && this.axF.postId > 0 && this.axF.mThreadType != 33) {
                this.axy.setVisibility(0);
                if (this.axJ != null) {
                    this.axJ.setVisibility(0);
                    return;
                }
                return;
            }
            this.axy.setVisibility(8);
            if (this.axJ != null) {
                this.axJ.setVisibility(8);
            }
        }
    }

    private void BA() {
        if (this.axy != null) {
            this.axy.setVisibility(8);
            if (this.axJ != null) {
                this.axJ.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BB() {
        if ((this.axC || this.axD) && this.axF != null && this.axF.mPicType == 1 && !TextUtils.isEmpty(this.axF.mTagName)) {
            if (this.axz != null) {
                this.axz.setVisibility(8);
                this.axz = null;
            }
            this.axz = new TextView(this.mContext);
            this.axz.setText(this.axF.mTagName);
            this.axz.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            ai.b(this.axz, d.e.common_color_10013, 1, 0);
            ai.k(this.axz, d.e.common_color_10215);
            this.axz.setAlpha(0.75f);
            this.axz.setIncludeFontPadding(false);
            this.axz.setGravity(17);
            int g = k.g(this.mContext, d.f.ds2);
            this.axz.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.axw.getBottomOffset();
            layoutParams.leftMargin = this.axw.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.axz, layoutParams);
            this.axz.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.avX = z;
        if (this.avX) {
            BA();
        } else {
            Bz();
        }
    }

    public void o(String str, boolean z) {
        this.axw.setTag(str);
        this.axw.setLoadBigImage(false);
        this.axw.setImageDrawable(null);
        this.axC = false;
        this.axD = false;
        boolean fe = fe(str);
        this.axG = bt(true);
        if (!this.axG) {
            p(str, fe);
        }
        if (fe) {
            q(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.axH || z) {
            this.axH = true;
            if (!this.axG || this.axF == null || StringUtils.isNull(this.axF.originalUrl, true) || this.axF.originalSize < 0 || this.axA.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dV = an.dV(this.axF.originalUrl);
            this.axA.setImage(ImageSource.uri(com.baidu.tbadk.core.util.k.uA() + ak.vA().dN(dV) + "/" + dV));
            this.axA.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BC() {
        bq(false);
    }

    private boolean fe(String str) {
        return i.hh() || com.baidu.tbadk.core.util.c.c.ek(str);
    }

    private void p(String str, final boolean z) {
        if (this.axF == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.ek(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.axF.imageUrl)) {
            com.baidu.adp.lib.f.c.fJ().a(this.axF.imageUrl, this.axF.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                    f.this.br(z);
                    if (!f.this.axD) {
                        if (aVar != null) {
                            Bitmap kN = aVar.kN();
                            if (kN != null) {
                                f.this.axC = true;
                                if (aVar.isGif()) {
                                    byte[] kS = aVar.kS();
                                    if (kS == null) {
                                        kS = BitmapHelper.Bitmap2Bytes(kN, 100);
                                    }
                                    f.this.axw.a(kS, kN);
                                    f.this.axw.invalidate();
                                    f.this.axw.play();
                                    f.this.axI = false;
                                } else {
                                    f.this.axw.setImageBitmap(kN);
                                    f.this.axw.setImageData(aVar.kS());
                                }
                                f.this.Bz();
                                f.this.BB();
                            } else if (!z) {
                                f.this.axw.Hy();
                            }
                        } else if (!z) {
                            f.this.axw.Hy();
                        }
                    }
                }
            }, 0, 0, true, null, new Object[0]);
        } else {
            br(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.axw.Hy();
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (ff(str)) {
            if (z2 || (!this.axE && !this.axD)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.axE = true;
                    com.baidu.adp.lib.f.c.fJ().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.axE = false;
                            f.this.axw.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.axE = false;
                            f.this.axD = true;
                            f.this.mProgressBar.setVisibility(8);
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.axw.getImageData(), Boolean.valueOf(this.avf));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.L(this.BS, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.axK.a(imageFileInfo, false);
        if (a2 != null) {
            this.axD = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.axK.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.axD = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean ff(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.axB != null) {
                this.axB.i(aVar.getUrl(), aVar.kS());
            }
            Bitmap kN = aVar.kN();
            if (kN == null) {
                if (!this.axC) {
                    this.axw.Hy();
                    return;
                }
                this.axD = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.axw.a(aVar.kS(), kN);
                this.axw.invalidate();
                this.axw.play();
                this.axI = false;
                this.axx.setVisibility(8);
            } else {
                this.axw.setImageBitmap(kN);
                this.axw.setImageData(aVar.kS());
                if (this.axI) {
                    this.axx.setVisibility(0);
                }
            }
            Bz();
            BB();
            this.axw.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.axw.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.axw != null) {
            this.axw.onDestroy();
        }
        if (this.axA != null) {
            this.axA.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.axw != null) {
            this.axw.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BD() {
        if (this.axw != null && this.axw.getImageType() == 1) {
            this.axw.stop();
        }
    }

    public void bs(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.axw != null && (str = (String) this.axw.getTag()) != null) {
            if ((!ff(str) || i.hh()) && this.axw != null) {
                if (this.axw.getImageType() == 1) {
                    if (this.axw.getGifCache() == null || !this.axw.HF()) {
                        e(str, z, z2);
                    }
                } else if (this.axw.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.axw.getImageBitmap() == null || !this.axw.HF()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.axw != null) {
            return this.axw.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.axF = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.avf = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.axx) {
            final String dV = an.dV(this.axF.originalUrl);
            if (this.axF.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CK().x(dV, 13);
                this.axF.originalProcess = -1;
                if (this.axF.originalSize > 0) {
                    this.axx.setText(axv + "(" + al.H(this.axF.originalSize) + ")");
                } else {
                    this.axx.setText(axv);
                }
                this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.avh != null) {
                this.avh.BF();
            }
            com.baidu.adp.base.e<?> Z = com.baidu.adp.base.i.Z(this.mContext);
            if (Z == null) {
                fg(dV);
            } else if (!i.hh() || i.hi() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                fg(dV);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Z.getPageActivity());
                aVar.ca(d.l.original_img_down_no_wifi_tip);
                aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        f.this.fg(dV);
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(Z);
                aVar.th();
            }
        } else if (view == this.axy && this.axF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.axF.threadId), String.valueOf(this.axF.postId), this.axF.mIsSeeHost, this.axF.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fg(String str) {
        if (this.axF != null) {
            this.axF.originalProcess = 0;
        }
        this.axx.setText("0%");
        this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.axF.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(com.baidu.tbadk.core.util.k.uA() + ak.vA().dN(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.9
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.axF != null && f.this.axF.originalProcess != -1) {
                        f.this.axF.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.axF == null || f.this.axF.originalProcess != -1) {
                        f.this.axx.setText(downloadData2.getProcess() + "%");
                        f.this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.axx.setText(f.this.getResources().getString(d.l.done));
                f.this.axx.setClickable(false);
                f.this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.fP().postDelayed(f.this.axL, 1500L);
                f.this.axH = false;
                f.this.axG = f.this.bt(false);
                f.this.BC();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.axH = false;
                BdToast.a(f.this.mContext, str2).tn().tp();
                f.this.axF.originalProcess = -1;
                if (f.this.axF.originalSize > 0) {
                    f.this.axx.setText(f.axv + "(" + al.H(f.this.axF.originalSize) + ")");
                } else {
                    f.this.axx.setText(f.axv);
                }
                f.this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        com.baidu.tbadk.download.e.CK().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.axF != null && !StringUtils.isNull(this.axF.originalUrl, true) && this.axF.originalSize >= 0) {
            String dV = an.dV(this.axF.originalUrl);
            if (new File(com.baidu.tbadk.core.util.k.uA() + ak.vA().dN(dV) + "/" + dV).exists()) {
                this.axF.originalProcess = 100;
                if (z) {
                    this.axx.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.axF.originalProcess < 0) {
                if (this.axF.originalSize > 0) {
                    this.axx.setText(axv + "(" + al.H(this.axF.originalSize) + ")");
                } else {
                    this.axx.setText(axv);
                }
                this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.axx.setText(this.axF.originalProcess + "%");
                this.axx.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.axI = true;
        } else {
            this.axx.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.avh = bVar;
    }
}
