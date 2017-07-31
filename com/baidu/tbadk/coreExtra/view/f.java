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
    private static final String ayM = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private boolean aww;
    private b awy;
    private boolean axo;
    protected com.baidu.tbadk.widget.a ayN;
    protected TextView ayO;
    protected TextView ayP;
    protected TextView ayQ;
    protected SubsamplingScaleImageView ayR;
    private a ayS;
    private boolean ayT;
    private boolean ayU;
    private boolean ayV;
    private ImageUrlData ayW;
    private boolean ayX;
    private boolean ayY;
    private boolean ayZ;
    private TextView aza;
    private com.baidu.tbadk.img.b azb;
    private Runnable azc;
    private SubsamplingScaleImageView.OnImageEventListener azd;
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
            if (this.ayO != null) {
                ai.j(this.ayO, d.g.btn_percent_yuantu);
                ai.b(this.ayO, d.e.cp_cont_g, 1, 0);
            }
            if (this.ayP != null) {
                ai.k(this.ayP, d.e.common_color_10022);
                ai.b(this.ayP, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayN != null) {
            this.ayN.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayS = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ayN = null;
        this.mContext = null;
        this.ayS = null;
        this.aww = false;
        this.ayV = false;
        this.ayX = false;
        this.ayY = false;
        this.axo = false;
        this.ayZ = false;
        this.aza = null;
        this.azc = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
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
                        f.this.ayO.setVisibility(8);
                    }
                });
                f.this.ayO.startAnimation(alphaAnimation);
            }
        };
        this.azd = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.2
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
                f.this.ayN.HJ();
                f.this.ayN.setVisibility(4);
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BdLog.e(exc);
            }
        };
        this.mContext = context;
        this.azb = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.ayN;
    }

    public void setGifSetListener(a.d dVar) {
        this.ayN.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayN.setImageOnClickListener(onClickListener);
        this.ayR.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayN.setImageOnLongClickListener(onLongClickListener);
        this.ayR.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(final a.e eVar) {
        this.ayN.setOnSizeChangedListener(new a.e() { // from class: com.baidu.tbadk.coreExtra.view.f.3
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
        this.ayN = new com.baidu.tbadk.widget.a(this.mContext);
        this.ayN.setLayoutParams(layoutParams);
        addView(this.ayN);
        this.ayR = new SubsamplingScaleImageView(this.mContext);
        this.ayR.setMaxScale(50.0f);
        this.ayR.setOnImageEventListener(this.azd);
        this.ayR.setVisibility(4);
        addView(this.ayR, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BF();
        this.ayO = new TextView(this.mContext);
        ai.j(this.ayO, d.g.btn_percent_yuantu);
        this.ayO.setText(d.l.original_img_look);
        this.ayO.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.b(this.ayO, d.e.cp_cont_g, 1, 0);
        this.ayO.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayO.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayO.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.ayO.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.ayO.setOnClickListener(this);
        this.ayO.setVisibility(8);
        addView(this.ayO, layoutParams3);
        BG();
    }

    private void BF() {
        this.aza = new TextView(this.mContext);
        this.aza.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.aza, layoutParams);
        this.aza.setVisibility(8);
    }

    private void BG() {
        this.ayP = new TextView(this.mContext);
        ai.k(this.ayP, d.e.common_color_10022);
        this.ayP.setText(d.l.goto_pb_floor);
        this.ayP.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        ai.b(this.ayP, d.e.cp_cont_g, 1, 0);
        this.ayP.setCompoundDrawablePadding(k.dip2px(this.mContext, 4.0f));
        this.ayP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.ayP.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayP.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.ayO.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayP.setOnClickListener(this);
        this.ayP.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.ayP, layoutParams);
        this.ayP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        if (this.ayP != null) {
            boolean z = this.ayT || this.ayU;
            if (!this.axo && z && this.ayW != null && this.ayW.threadId > 0 && this.ayW.postId > 0 && this.ayW.mThreadType != 33) {
                this.ayP.setVisibility(0);
                if (this.aza != null) {
                    this.aza.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayP.setVisibility(8);
            if (this.aza != null) {
                this.aza.setVisibility(8);
            }
        }
    }

    private void BI() {
        if (this.ayP != null) {
            this.ayP.setVisibility(8);
            if (this.aza != null) {
                this.aza.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ() {
        if ((this.ayT || this.ayU) && this.ayW != null && this.ayW.mPicType == 1 && !TextUtils.isEmpty(this.ayW.mTagName)) {
            if (this.ayQ != null) {
                this.ayQ.setVisibility(8);
                this.ayQ = null;
            }
            this.ayQ = new TextView(this.mContext);
            this.ayQ.setText(this.ayW.mTagName);
            this.ayQ.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            ai.b(this.ayQ, d.e.common_color_10013, 1, 0);
            ai.k(this.ayQ, d.e.common_color_10215);
            this.ayQ.setAlpha(0.75f);
            this.ayQ.setIncludeFontPadding(false);
            this.ayQ.setGravity(17);
            int g = k.g(this.mContext, d.f.ds2);
            this.ayQ.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ayN.getBottomOffset();
            layoutParams.leftMargin = this.ayN.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ayQ, layoutParams);
            this.ayQ.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.axo = z;
        if (this.axo) {
            BI();
        } else {
            BH();
        }
    }

    public void o(String str, boolean z) {
        this.ayN.setTag(str);
        this.ayN.setLoadBigImage(false);
        this.ayN.setImageDrawable(null);
        this.ayT = false;
        this.ayU = false;
        boolean fk = fk(str);
        this.ayX = bt(true);
        if (!this.ayX) {
            p(str, fk);
        }
        if (fk) {
            q(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.ayY || z) {
            this.ayY = true;
            if (!this.ayX || this.ayW == null || StringUtils.isNull(this.ayW.originalUrl, true) || this.ayW.originalSize < 0 || this.ayR.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String eb = an.eb(this.ayW.originalUrl);
            this.ayR.setImage(ImageSource.uri(com.baidu.tbadk.core.util.k.uK() + ak.vK().dT(eb) + "/" + eb));
            this.ayR.setVisibility(0);
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
        if (this.ayW == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.eq(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.ayW.imageUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.ayW.imageUrl, this.ayW.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                    f.this.br(z);
                    if (!f.this.ayU) {
                        if (aVar != null) {
                            Bitmap kX = aVar.kX();
                            if (kX != null) {
                                f.this.ayT = true;
                                if (aVar.isGif()) {
                                    byte[] lc = aVar.lc();
                                    if (lc == null) {
                                        lc = BitmapHelper.Bitmap2Bytes(kX, 100);
                                    }
                                    f.this.ayN.a(lc, kX);
                                    f.this.ayN.invalidate();
                                    f.this.ayN.play();
                                    f.this.ayZ = false;
                                } else {
                                    f.this.ayN.setImageBitmap(kX);
                                    f.this.ayN.setImageData(aVar.lc());
                                }
                                f.this.BH();
                                f.this.BJ();
                            } else if (!z) {
                                f.this.ayN.HG();
                            }
                        } else if (!z) {
                            f.this.ayN.HG();
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
            this.ayN.HG();
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (fl(str)) {
            if (z2 || (!this.ayV && !this.ayU)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.ayV = true;
                    com.baidu.adp.lib.f.c.fU().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayV = false;
                            f.this.ayN.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayV = false;
                            f.this.ayU = true;
                            f.this.mProgressBar.setVisibility(8);
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ayN.getImageData(), Boolean.valueOf(this.aww));
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
        com.baidu.adp.widget.a.a a2 = this.azb.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayU = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.azb.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayU = true;
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
            if (this.ayS != null) {
                this.ayS.i(aVar.getUrl(), aVar.lc());
            }
            Bitmap kX = aVar.kX();
            if (kX == null) {
                if (!this.ayT) {
                    this.ayN.HG();
                    return;
                }
                this.ayU = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.ayN.a(aVar.lc(), kX);
                this.ayN.invalidate();
                this.ayN.play();
                this.ayZ = false;
                this.ayO.setVisibility(8);
            } else {
                this.ayN.setImageBitmap(kX);
                this.ayN.setImageData(aVar.lc());
                if (this.ayZ) {
                    this.ayO.setVisibility(0);
                }
            }
            BH();
            BJ();
            this.ayN.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.ayN.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ayN != null) {
            this.ayN.onDestroy();
        }
        if (this.ayR != null) {
            this.ayR.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.ayN != null) {
            this.ayN.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BL() {
        if (this.ayN != null && this.ayN.getImageType() == 1) {
            this.ayN.stop();
        }
    }

    public void bs(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.ayN != null && (str = (String) this.ayN.getTag()) != null) {
            if ((!fl(str) || i.hr()) && this.ayN != null) {
                if (this.ayN.getImageType() == 1) {
                    if (this.ayN.getGifCache() == null || !this.ayN.HN()) {
                        e(str, z, z2);
                    }
                } else if (this.ayN.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.ayN.getImageBitmap() == null || !this.ayN.HN()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.ayN != null) {
            return this.ayN.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayW = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aww = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayO) {
            final String eb = an.eb(this.ayW.originalUrl);
            if (this.ayW.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CS().x(eb, 13);
                this.ayW.originalProcess = -1;
                if (this.ayW.originalSize > 0) {
                    this.ayO.setText(ayM + "(" + al.H(this.ayW.originalSize) + ")");
                } else {
                    this.ayO.setText(ayM);
                }
                this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.awy != null) {
                this.awy.BN();
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
        } else if (view == this.ayP && this.ayW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayW.threadId), String.valueOf(this.ayW.postId), this.ayW.mIsSeeHost, this.ayW.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fm(String str) {
        if (this.ayW != null) {
            this.ayW.originalProcess = 0;
        }
        this.ayO.setText("0%");
        this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayW.originalUrl);
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
                    if (f.this.ayW != null && f.this.ayW.originalProcess != -1) {
                        f.this.ayW.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayW == null || f.this.ayW.originalProcess != -1) {
                        f.this.ayO.setText(downloadData2.getProcess() + "%");
                        f.this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayO.setText(f.this.getResources().getString(d.l.done));
                f.this.ayO.setClickable(false);
                f.this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ga().postDelayed(f.this.azc, 1500L);
                f.this.ayY = false;
                f.this.ayX = f.this.bt(false);
                f.this.BK();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.ayY = false;
                BdToast.a(f.this.mContext, str2).tx().tz();
                f.this.ayW.originalProcess = -1;
                if (f.this.ayW.originalSize > 0) {
                    f.this.ayO.setText(f.ayM + "(" + al.H(f.this.ayW.originalSize) + ")");
                } else {
                    f.this.ayO.setText(f.ayM);
                }
                f.this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        com.baidu.tbadk.download.e.CS().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.ayW != null && !StringUtils.isNull(this.ayW.originalUrl, true) && this.ayW.originalSize >= 0) {
            String eb = an.eb(this.ayW.originalUrl);
            if (new File(com.baidu.tbadk.core.util.k.uK() + ak.vK().dT(eb) + "/" + eb).exists()) {
                this.ayW.originalProcess = 100;
                if (z) {
                    this.ayO.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ayW.originalProcess < 0) {
                if (this.ayW.originalSize > 0) {
                    this.ayO.setText(ayM + "(" + al.H(this.ayW.originalSize) + ")");
                } else {
                    this.ayO.setText(ayM);
                }
                this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.ayO.setText(this.ayW.originalProcess + "%");
                this.ayO.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.ayZ = true;
        } else {
            this.ayO.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.awy = bVar;
    }
}
