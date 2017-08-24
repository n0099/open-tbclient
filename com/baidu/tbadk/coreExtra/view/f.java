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
    private static final String ayO = TbadkCoreApplication.getInst().getString(d.l.original_img_look);
    private b awA;
    private boolean awy;
    private boolean axq;
    protected com.baidu.tbadk.widget.a ayP;
    protected TextView ayQ;
    protected TextView ayR;
    protected TextView ayS;
    protected SubsamplingScaleImageView ayT;
    private a ayU;
    private boolean ayV;
    private boolean ayW;
    private boolean ayX;
    private ImageUrlData ayY;
    private boolean ayZ;
    private boolean aza;
    private boolean azb;
    private TextView azc;
    private com.baidu.tbadk.img.b azd;
    private Runnable aze;
    private SubsamplingScaleImageView.OnImageEventListener azf;
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
            if (this.ayQ != null) {
                ai.j(this.ayQ, d.g.btn_percent_yuantu);
                ai.b(this.ayQ, d.e.cp_cont_g, 1, 0);
            }
            if (this.ayR != null) {
                ai.k(this.ayR, d.e.common_color_10022);
                ai.b(this.ayR, d.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.ayP != null) {
            this.ayP.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ayU = aVar;
    }

    public f(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.ayP = null;
        this.mContext = null;
        this.ayU = null;
        this.awy = false;
        this.ayX = false;
        this.ayZ = false;
        this.aza = false;
        this.axq = false;
        this.azb = false;
        this.azc = null;
        this.aze = new Runnable() { // from class: com.baidu.tbadk.coreExtra.view.f.1
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
                        f.this.ayQ.setVisibility(8);
                    }
                });
                f.this.ayQ.startAnimation(alphaAnimation);
            }
        };
        this.azf = new SubsamplingScaleImageView.OnImageEventListener() { // from class: com.baidu.tbadk.coreExtra.view.f.2
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
                f.this.ayP.HJ();
                f.this.ayP.setVisibility(4);
            }

            @Override // com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.OnImageEventListener
            public void onTileLoadError(Exception exc) {
                BdLog.e(exc);
            }
        };
        this.mContext = context;
        this.azd = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.ayP;
    }

    public void setGifSetListener(a.d dVar) {
        this.ayP.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.ayP.setImageOnClickListener(onClickListener);
        this.ayT.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.ayP.setImageOnLongClickListener(onLongClickListener);
        this.ayT.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(final a.e eVar) {
        this.ayP.setOnSizeChangedListener(new a.e() { // from class: com.baidu.tbadk.coreExtra.view.f.3
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
        this.ayP = new com.baidu.tbadk.widget.a(this.mContext);
        this.ayP.setLayoutParams(layoutParams);
        addView(this.ayP);
        this.ayT = new SubsamplingScaleImageView(this.mContext);
        this.ayT.setMaxScale(50.0f);
        this.ayT.setOnImageEventListener(this.azf);
        this.ayT.setVisibility(4);
        addView(this.ayT, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(d.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BF();
        this.ayQ = new TextView(this.mContext);
        ai.j(this.ayQ, d.g.btn_percent_yuantu);
        this.ayQ.setText(d.l.original_img_look);
        this.ayQ.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize28));
        ai.b(this.ayQ, d.e.cp_cont_g, 1, 0);
        this.ayQ.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayQ.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ayQ.setMinWidth(getResources().getDimensionPixelSize(d.f.ds220));
        this.ayQ.setMinHeight(getResources().getDimensionPixelSize(d.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(d.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.ayQ.setOnClickListener(this);
        this.ayQ.setVisibility(8);
        addView(this.ayQ, layoutParams3);
        BG();
    }

    private void BF() {
        this.azc = new TextView(this.mContext);
        this.azc.setBackgroundResource(d.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(d.f.ds180);
        layoutParams.addRule(12);
        addView(this.azc, layoutParams);
        this.azc.setVisibility(8);
    }

    private void BG() {
        this.ayR = new TextView(this.mContext);
        ai.k(this.ayR, d.e.common_color_10022);
        this.ayR.setText(d.l.goto_pb_floor);
        this.ayR.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize24));
        ai.b(this.ayR, d.e.cp_cont_g, 1, 0);
        this.ayR.setCompoundDrawablePadding(k.dip2px(this.mContext, 4.0f));
        this.ayR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.getDrawable(d.g.icon_see_arrow), (Drawable) null);
        this.ayR.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds20);
        this.ayR.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(d.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(d.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(d.f.ds20);
        layoutParams.addRule(1, this.ayQ.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.ayR.setOnClickListener(this);
        this.ayR.setMinHeight(getResources().getDimensionPixelSize(d.f.ds100));
        addView(this.ayR, layoutParams);
        this.ayR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        if (this.ayR != null) {
            boolean z = this.ayV || this.ayW;
            if (!this.axq && z && this.ayY != null && this.ayY.threadId > 0 && this.ayY.postId > 0 && this.ayY.mThreadType != 33) {
                this.ayR.setVisibility(0);
                if (this.azc != null) {
                    this.azc.setVisibility(0);
                    return;
                }
                return;
            }
            this.ayR.setVisibility(8);
            if (this.azc != null) {
                this.azc.setVisibility(8);
            }
        }
    }

    private void BI() {
        if (this.ayR != null) {
            this.ayR.setVisibility(8);
            if (this.azc != null) {
                this.azc.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BJ() {
        if ((this.ayV || this.ayW) && this.ayY != null && this.ayY.mPicType == 1 && !TextUtils.isEmpty(this.ayY.mTagName)) {
            if (this.ayS != null) {
                this.ayS.setVisibility(8);
                this.ayS = null;
            }
            this.ayS = new TextView(this.mContext);
            this.ayS.setText(this.ayY.mTagName);
            this.ayS.setTextSize(0, getResources().getDimensionPixelSize(d.f.fontsize26));
            ai.b(this.ayS, d.e.common_color_10013, 1, 0);
            ai.k(this.ayS, d.e.common_color_10215);
            this.ayS.setAlpha(0.75f);
            this.ayS.setIncludeFontPadding(false);
            this.ayS.setGravity(17);
            int g = k.g(this.mContext, d.f.ds2);
            this.ayS.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.ayP.getBottomOffset();
            layoutParams.leftMargin = this.ayP.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.ayS, layoutParams);
            this.ayS.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.axq = z;
        if (this.axq) {
            BI();
        } else {
            BH();
        }
    }

    public void o(String str, boolean z) {
        this.ayP.setTag(str);
        this.ayP.setLoadBigImage(false);
        this.ayP.setImageDrawable(null);
        this.ayV = false;
        this.ayW = false;
        boolean fo = fo(str);
        this.ayZ = bt(true);
        if (!this.ayZ) {
            p(str, fo);
        }
        if (fo) {
            q(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.aza || z) {
            this.aza = true;
            if (!this.ayZ || this.ayY == null || StringUtils.isNull(this.ayY.originalUrl, true) || this.ayY.originalSize < 0 || this.ayT.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String ef = an.ef(this.ayY.originalUrl);
            this.ayT.setImage(ImageSource.uri(com.baidu.tbadk.core.util.k.uL() + ak.vL().dX(ef) + "/" + ef));
            this.ayT.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BK() {
        bq(false);
    }

    private boolean fo(String str) {
        return i.hr() || com.baidu.tbadk.core.util.c.c.eu(str);
    }

    private void p(String str, final boolean z) {
        if (this.ayY == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.eu(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.ayY.imageUrl)) {
            com.baidu.adp.lib.f.c.fU().a(this.ayY.imageUrl, this.ayY.urlType, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                    f.this.br(z);
                    if (!f.this.ayW) {
                        if (aVar != null) {
                            Bitmap kW = aVar.kW();
                            if (kW != null) {
                                f.this.ayV = true;
                                if (aVar.isGif()) {
                                    byte[] lb = aVar.lb();
                                    if (lb == null) {
                                        lb = BitmapHelper.Bitmap2Bytes(kW, 100);
                                    }
                                    f.this.ayP.a(lb, kW);
                                    f.this.ayP.invalidate();
                                    f.this.ayP.play();
                                    f.this.azb = false;
                                } else {
                                    f.this.ayP.setImageBitmap(kW);
                                    f.this.ayP.setImageData(aVar.lb());
                                }
                                f.this.BH();
                                f.this.BJ();
                            } else if (!z) {
                                f.this.ayP.HG();
                            }
                        } else if (!z) {
                            f.this.ayP.HG();
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
            this.ayP.HG();
        }
    }

    private void q(String str, boolean z) {
        d(str, z, false);
    }

    private void d(String str, boolean z, boolean z2) {
        if (fp(str)) {
            if (z2 || (!this.ayX && !this.ayW)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.ayX = true;
                    com.baidu.adp.lib.f.c.fU().a(str, 27, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.coreExtra.view.f.5
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onCancelled(String str2) {
                            f.this.ayX = false;
                            f.this.ayP.setVisibility(0);
                            f.this.mProgressBar.setVisibility(8);
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                            f.this.ayX = false;
                            f.this.ayW = true;
                            f.this.mProgressBar.setVisibility(8);
                            f.this.b(aVar);
                        }
                    }, 0, 0, false, null, Boolean.valueOf(z), this.ayP.getImageData(), Boolean.valueOf(this.awy));
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
        com.baidu.adp.widget.a.a a2 = this.azd.a(imageFileInfo, false);
        if (a2 != null) {
            this.ayW = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.azd.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tbadk.coreExtra.view.f.6
            @Override // com.baidu.tbadk.imageManager.b
            public void a(com.baidu.adp.widget.a.a aVar, String str2, boolean z3) {
                f.this.ayW = true;
                f.this.mProgressBar.setVisibility(8);
                f.this.b(aVar);
            }
        }, false);
    }

    private boolean fp(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.ayU != null) {
                this.ayU.i(aVar.getUrl(), aVar.lb());
            }
            Bitmap kW = aVar.kW();
            if (kW == null) {
                if (!this.ayV) {
                    this.ayP.HG();
                    return;
                }
                this.ayW = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.ayP.a(aVar.lb(), kW);
                this.ayP.invalidate();
                this.ayP.play();
                this.azb = false;
                this.ayQ.setVisibility(8);
            } else {
                this.ayP.setImageBitmap(kW);
                this.ayP.setImageData(aVar.lb());
                if (this.azb) {
                    this.ayQ.setVisibility(0);
                }
            }
            BH();
            BJ();
            this.ayP.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.ayP.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.ayP != null) {
            this.ayP.onDestroy();
        }
        if (this.ayT != null) {
            this.ayT.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.ayP != null) {
            this.ayP.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BL() {
        if (this.ayP != null && this.ayP.getImageType() == 1) {
            this.ayP.stop();
        }
    }

    public void bs(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.ayP != null && (str = (String) this.ayP.getTag()) != null) {
            if ((!fp(str) || i.hr()) && this.ayP != null) {
                if (this.ayP.getImageType() == 1) {
                    if (this.ayP.getGifCache() == null || !this.ayP.HN()) {
                        d(str, z, z2);
                    }
                } else if (this.ayP.getImageType() == 2) {
                    d(str, z, z2);
                } else if (this.ayP.getImageBitmap() == null || !this.ayP.HN()) {
                    d(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.ayP != null) {
            return this.ayP.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ayY = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.awy = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ayQ) {
            final String ef = an.ef(this.ayY.originalUrl);
            if (this.ayY.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CS().x(ef, 13);
                this.ayY.originalProcess = -1;
                if (this.ayY.originalSize > 0) {
                    this.ayQ.setText(ayO + "(" + al.H(this.ayY.originalSize) + ")");
                } else {
                    this.ayQ.setText(ayO);
                }
                this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.awA != null) {
                this.awA.BN();
            }
            com.baidu.adp.base.e<?> aa = com.baidu.adp.base.i.aa(this.mContext);
            if (aa == null) {
                fq(ef);
            } else if (!i.hr() || i.hs() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                fq(ef);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aa.getPageActivity());
                aVar.cc(d.l.original_img_down_no_wifi_tip);
                aVar.a(d.l.alert_yes_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.7
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                        f.this.fq(ef);
                    }
                });
                aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tbadk.coreExtra.view.f.8
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar.dismiss();
                    }
                });
                aVar.b(aa);
                aVar.ts();
            }
        } else if (view == this.ayR && this.ayY != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ayY.threadId), String.valueOf(this.ayY.postId), this.ayY.mIsSeeHost, this.ayY.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(String str) {
        if (this.ayY != null) {
            this.ayY.originalProcess = 0;
        }
        this.ayQ.setText("0%");
        this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ayY.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(com.baidu.tbadk.core.util.k.uL() + ak.vL().dX(str) + "/" + str);
        downloadData.setCallback(new com.baidu.tbadk.download.d() { // from class: com.baidu.tbadk.coreExtra.view.f.9
            @Override // com.baidu.tbadk.download.d
            public boolean onPreDownload(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileUpdateProgress(DownloadData downloadData2) {
                if (downloadData2 != null) {
                    if (f.this.ayY != null && f.this.ayY.originalProcess != -1) {
                        f.this.ayY.originalProcess = downloadData2.getProcess();
                    }
                    if (f.this.ayY == null || f.this.ayY.originalProcess != -1) {
                        f.this.ayQ.setText(downloadData2.getProcess() + "%");
                        f.this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
                    }
                }
            }

            @Override // com.baidu.tbadk.download.d
            public boolean onFileDownloaded(DownloadData downloadData2) {
                return true;
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadSucceed(DownloadData downloadData2) {
                f.this.ayQ.setText(f.this.getResources().getString(d.l.done));
                f.this.ayQ.setClickable(false);
                f.this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                com.baidu.adp.lib.g.e.ga().postDelayed(f.this.aze, 1500L);
                f.this.aza = false;
                f.this.ayZ = f.this.bt(false);
                f.this.BK();
            }

            @Override // com.baidu.tbadk.download.d
            public void onFileDownloadFailed(DownloadData downloadData2, int i, String str2) {
                f.this.aza = false;
                BdToast.a(f.this.mContext, str2).ty().tA();
                f.this.ayY.originalProcess = -1;
                if (f.this.ayY.originalSize > 0) {
                    f.this.ayQ.setText(f.ayO + "(" + al.H(f.this.ayY.originalSize) + ")");
                } else {
                    f.this.ayQ.setText(f.ayO);
                }
                f.this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        });
        com.baidu.tbadk.download.e.CS().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.ayY != null && !StringUtils.isNull(this.ayY.originalUrl, true) && this.ayY.originalSize >= 0) {
            String ef = an.ef(this.ayY.originalUrl);
            if (new File(com.baidu.tbadk.core.util.k.uL() + ak.vL().dX(ef) + "/" + ef).exists()) {
                this.ayY.originalProcess = 100;
                if (z) {
                    this.ayQ.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ayY.originalProcess < 0) {
                if (this.ayY.originalSize > 0) {
                    this.ayQ.setText(ayO + "(" + al.H(this.ayY.originalSize) + ")");
                } else {
                    this.ayQ.setText(ayO);
                }
                this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.ayQ.setText(this.ayY.originalProcess + "%");
                this.ayQ.setCompoundDrawablesWithIntrinsicBounds(0, 0, d.g.icon_close_yuantu, 0);
            }
            this.azb = true;
        } else {
            this.ayQ.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.awA = bVar;
    }
}
