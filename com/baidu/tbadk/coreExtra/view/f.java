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
    private static final String ayN = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private boolean awx;
    private b awz;
    private boolean axp;
    protected com.baidu.tbadk.widget.a ayO;
    protected TextView ayP;
    protected TextView ayQ;
    protected TextView ayR;
    protected SubsamplingScaleImageView ayS;
    private a ayT;
    private boolean ayU;
    private boolean ayV;
    private boolean ayW;
    private ImageUrlData ayX;
    private boolean ayY;
    private boolean ayZ;
    private boolean aza;
    private TextView azb;
    private com.baidu.tbadk.img.b azc;
    private Runnable azd;
    private SubsamplingScaleImageView.OnImageEventListener aze;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int mp;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BN();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ayP != null) {
                ai.j(this.ayP, d.g.btn_percent_yuantu);
                ai.b(this.ayP, d.e.cp_cont_g, 1, 0);
            }
            if (this.ayQ != null) {
                ai.k(this.ayQ, d.e.common_color_10022);
                ai.b(this.ayQ, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayO != null) {
            this.ayO.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayT = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ayO = null;
        this.mContext = null;
        this.ayT = null;
        this.awx = false;
        this.ayW = false;
        this.ayY = false;
        this.ayZ = false;
        this.axp = false;
        this.aza = false;
        this.azb = null;
        this.azd = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
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
                        f.this.ayP.setVisibility(8);
                    }
                });
                f.this.ayP.startAnimation(alphaAnimation);
            }
        };
        this.aze = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.2
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
                f.this.ayO.HJ();
                f.this.ayO.setVisibility(4);
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BdLog.e(exc);
            }
        };
        this.mContext = context;
        this.azc = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.ayO;
    }

    public void setGifSetListener(a.d dVar) {
        this.ayO.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayO.setImageOnClickListener(onClickListener);
        this.ayS.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayO.setImageOnLongClickListener(onLongClickListener);
        this.ayS.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(final a.e eVar) {
        this.ayO.setOnSizeChangedListener(new a.e() { // from class: com.baidu.tbadk.coreExtra.view.f.3
            @Override // com.baidu.tbadk.widget.a.e
            public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
                if (eVar != null) {
                    eVar.a(aVar, z, z2);
                }
                f.this.BJ();
            }
        });
    }

    protected void init() {
        this.mp = k.ag(this.mContext);
        this.mMaxHeight = k.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(d.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.ayO = new com.baidu.tbadk.widget.a(this.mContext);
        this.ayO.setLayoutParams(layoutParams);
        addView(this.ayO);
        this.ayS = new SubsamplingScaleImageView(this.mContext);
        this.ayS.setMaxScale(50.0f);
        this.ayS.setOnImageEventListener(this.aze);
        this.ayS.setVisibility(4);
        addView(this.ayS, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BF();
        this.ayP = new TextView(this.mContext);
        ai.j(this.ayP, d.g.btn_percent_yuantu);
        this.ayP.setText(d.l.original_img_look);
        this.ayP.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.b(this.ayP, d.e.cp_cont_g, 1, 0);
        this.ayP.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayP.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayP.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.ayP.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.ayP.setOnClickListener(this);
        this.ayP.setVisibility(8);
        addView(this.ayP, layoutParams3);
        BG();
    }

    private void BF() {
        this.azb = new TextView(this.mContext);
        this.azb.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.azb, layoutParams);
        this.azb.setVisibility(8);
    }

    private void BG() {
        this.ayQ = new TextView(this.mContext);
        ai.k(this.ayQ, d.e.common_color_10022);
        this.ayQ.setText(d.l.goto_pb_floor);
        this.ayQ.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        ai.b(this.ayQ, d.e.cp_cont_g, 1, 0);
        this.ayQ.setCompoundDrawablePadding(k.dip2px(this.mContext, 4.0f));
        this.ayQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.ayQ.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayQ.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.ayP.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayQ.setOnClickListener(this);
        this.ayQ.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.ayQ, layoutParams);
        this.ayQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        if (this.ayQ != null) {
            boolean z = this.ayU || this.ayV;
            if (!this.axp && z && this.ayX != null && this.ayX.threadId > 0 && this.ayX.postId > 0 && this.ayX.mThreadType != 33) {
                this.ayQ.setVisibility(0);
                if (this.azb != null) {
                    this.azb.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayQ.setVisibility(8);
            if (this.azb != null) {
                this.azb.setVisibility(8);
            }
        }
    }

    private void BI() {
        if (this.ayQ != null) {
            this.ayQ.setVisibility(8);
            if (this.azb != null) {
                this.azb.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ() {
        if ((this.ayU || this.ayV) && this.ayX != null && this.ayX.mPicType == 1 && !TextUtils.isEmpty(this.ayX.mTagName)) {
            if (this.ayR != null) {
                this.ayR.setVisibility(8);
                this.ayR = null;
            }
            this.ayR = new TextView(this.mContext);
            this.ayR.setText(this.ayX.mTagName);
            this.ayR.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            ai.b(this.ayR, d.e.common_color_10013, 1, 0);
            ai.k(this.ayR, d.e.common_color_10215);
            this.ayR.setAlpha(0.75f);
            this.ayR.setIncludeFontPadding(false);
            this.ayR.setGravity(17);
            int g = k.g(this.mContext, d.f.ds2);
            this.ayR.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ayO.getBottomOffset();
            layoutParams.leftMargin = this.ayO.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ayR, layoutParams);
            this.ayR.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.axp = z;
        if (this.axp) {
            BI();
        } else {
            BH();
        }
    }

    public void o(String str, boolean z) {
        this.ayO.setTag(str);
        this.ayO.setLoadBigImage(false);
        this.ayO.setImageDrawable(null);
        this.ayU = false;
        this.ayV = false;
        boolean fk = fk(str);
        this.ayY = bt(true);
        if (!this.ayY) {
            p(str, fk);
        }
        if (fk) {
            q(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.ayZ || z) {
            this.ayZ = true;
            if (!this.ayY || this.ayX == null || StringUtils.isNull(this.ayX.originalUrl, true) || this.ayX.originalSize < 0 || this.ayS.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String eb = an.eb(this.ayX.originalUrl);
            this.ayS.setImage(ImageSource.uri(com.baidu.tbadk.core.util.k.uK() + ak.vK().dT(eb) + "/" + eb));
            this.ayS.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BK() {
        bq(false);
    }

    private boolean fk(String str) {
        return i.hr() || com.baidu.tbadk.core.util.c.c.eq(str);
    }

    private void p(String str, final boolean z) {
        if (this.ayX == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.eq(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.ayX.imageUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.ayX.imageUrl, this.ayX.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                    f.this.br(z);
                    if (!f.this.ayV) {
                        if (aVar != null) {
                            Bitmap kX = aVar.kX();
                            if (kX != null) {
                                f.this.ayU = true;
                                if (aVar.isGif()) {
                                    byte[] lc = aVar.lc();
                                    if (lc == null) {
                                        lc = BitmapHelper.Bitmap2Bytes(kX, 100);
                                    }
                                    f.this.ayO.a(lc, kX);
                                    f.this.ayO.invalidate();
                                    f.this.ayO.play();
                                    f.this.aza = false;
                                } else {
                                    f.this.ayO.setImageBitmap(kX);
                                    f.this.ayO.setImageData(aVar.lc());
                                }
                                f.this.BH();
                                f.this.BJ();
                            } else if (!z) {
                                f.this.ayO.HG();
                            }
                        } else if (!z) {
                            f.this.ayO.HG();
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
            this.ayO.HG();
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (fl(str)) {
            if (z2 || (!this.ayW && !this.ayV)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.ayW = true;
                    com.baidu.adp.lib.f.c.fU().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayW = false;
                            f.this.ayO.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayW = false;
                            f.this.ayV = true;
                            f.this.mProgressBar.setVisibility(8);
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ayO.getImageData(), Boolean.valueOf(this.awx));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.mp, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.azc.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayV = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.azc.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayV = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fl(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.ayT != null) {
                this.ayT.i(aVar.getUrl(), aVar.lc());
            }
            Bitmap kX = aVar.kX();
            if (kX == null) {
                if (!this.ayU) {
                    this.ayO.HG();
                    return;
                }
                this.ayV = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.ayO.a(aVar.lc(), kX);
                this.ayO.invalidate();
                this.ayO.play();
                this.aza = false;
                this.ayP.setVisibility(8);
            } else {
                this.ayO.setImageBitmap(kX);
                this.ayO.setImageData(aVar.lc());
                if (this.aza) {
                    this.ayP.setVisibility(0);
                }
            }
            BH();
            BJ();
            this.ayO.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.ayO.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ayO != null) {
            this.ayO.onDestroy();
        }
        if (this.ayS != null) {
            this.ayS.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.ayO != null) {
            this.ayO.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BL() {
        if (this.ayO != null && this.ayO.getImageType() == 1) {
            this.ayO.stop();
        }
    }

    public void bs(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.ayO != null && (str = (String) this.ayO.getTag()) != null) {
            if ((!fl(str) || i.hr()) && this.ayO != null) {
                if (this.ayO.getImageType() == 1) {
                    if (this.ayO.getGifCache() == null || !this.ayO.HN()) {
                        e(str, z, z2);
                    }
                } else if (this.ayO.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.ayO.getImageBitmap() == null || !this.ayO.HN()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.ayO != null) {
            return this.ayO.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayX = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.awx = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayP) {
            final String eb = an.eb(this.ayX.originalUrl);
            if (this.ayX.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CS().x(eb, 13);
                this.ayX.originalProcess = -1;
                if (this.ayX.originalSize > 0) {
                    this.ayP.setText(ayN + "(" + al.H(this.ayX.originalSize) + ")");
                } else {
                    this.ayP.setText(ayN);
                }
                this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.awz != null) {
                this.awz.BN();
            }
            com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(this.mContext);
            if (aa == null) {
                fm(eb);
            } else if (!i.hr() || i.hs() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                fm(eb);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aa.getPageActivity());
                aVar.cc(d.l.original_img_down_no_wifi_tip);
                aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        f.this.fm(eb);
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(aa);
                aVar.tr();
            }
        } else if (view == this.ayQ && this.ayX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayX.threadId), String.valueOf(this.ayX.postId), this.ayX.mIsSeeHost, this.ayX.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(String str) {
        if (this.ayX != null) {
            this.ayX.originalProcess = 0;
        }
        this.ayP.setText("0%");
        this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayX.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(com.baidu.tbadk.core.util.k.uK() + ak.vK().dT(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.9
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.ayX != null && f.this.ayX.originalProcess != -1) {
                        f.this.ayX.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayX == null || f.this.ayX.originalProcess != -1) {
                        f.this.ayP.setText(downloadData2.getProcess() + "%");
                        f.this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayP.setText(f.this.getResources().getString(d.l.done));
                f.this.ayP.setClickable(false);
                f.this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ga().postDelayed(f.this.azd, 1500L);
                f.this.ayZ = false;
                f.this.ayY = f.this.bt(false);
                f.this.BK();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayZ = false;
                BdToast.a(f.this.mContext, str2).tx().tz();
                f.this.ayX.originalProcess = -1;
                if (f.this.ayX.originalSize > 0) {
                    f.this.ayP.setText(f.ayN + "(" + al.H(f.this.ayX.originalSize) + ")");
                } else {
                    f.this.ayP.setText(f.ayN);
                }
                f.this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        com.baidu.tbadk.download.e.CS().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.ayX != null && !StringUtils.isNull(this.ayX.originalUrl, true) && this.ayX.originalSize >= 0) {
            String eb = an.eb(this.ayX.originalUrl);
            if (new File(com.baidu.tbadk.core.util.k.uK() + ak.vK().dT(eb) + "/" + eb).exists()) {
                this.ayX.originalProcess = 100;
                if (z) {
                    this.ayP.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ayX.originalProcess < 0) {
                if (this.ayX.originalSize > 0) {
                    this.ayP.setText(ayN + "(" + al.H(this.ayX.originalSize) + ")");
                } else {
                    this.ayP.setText(ayN);
                }
                this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.ayP.setText(this.ayX.originalProcess + "%");
                this.ayP.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.aza = true;
        } else {
            this.ayP.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.awz = bVar;
    }
}
