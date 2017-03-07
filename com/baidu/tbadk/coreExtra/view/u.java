package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.w;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String avu = TbadkCoreApplication.m9getInst().getString(w.l.original_img_look);
    private int Co;
    private boolean atW;
    private boolean ate;
    private b atg;
    private a avA;
    private boolean avB;
    private boolean avC;
    private boolean avD;
    private ImageUrlData avE;
    private boolean avF;
    private boolean avG;
    private boolean avH;
    private TextView avI;
    private com.baidu.tbadk.img.b avJ;
    private Runnable avK;
    private SubsamplingScaleImageView.OnImageEventListener avL;
    protected com.baidu.tbadk.widget.a avv;
    protected TextView avw;
    protected TextView avx;
    protected TextView avy;
    protected SubsamplingScaleImageView avz;
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
        void Bx();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.avw != null) {
                aq.j(this.avw, w.g.btn_percent_yuantu);
                aq.b(this.avw, w.e.cp_cont_g, 1, 0);
            }
            if (this.avx != null) {
                aq.k(this.avx, w.e.common_color_10022);
                aq.b(this.avx, w.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avv != null) {
            this.avv.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.avA = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.avv = null;
        this.mContext = null;
        this.avA = null;
        this.ate = false;
        this.avD = false;
        this.avF = false;
        this.avG = false;
        this.atW = false;
        this.avH = false;
        this.avI = null;
        this.avK = new v(this);
        this.avL = new x(this);
        this.mContext = context;
        this.avJ = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.avv;
    }

    public void setGifSetListener(a.d dVar) {
        this.avv.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.avv.setImageOnClickListener(onClickListener);
        this.avz.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avv.setImageOnLongClickListener(onLongClickListener);
        this.avz.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.avv.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.Co = com.baidu.adp.lib.util.k.ag(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.ah(this.mContext) - ((int) this.mContext.getResources().getDimension(w.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.avv = new com.baidu.tbadk.widget.a(this.mContext);
        this.avv.setLayoutParams(layoutParams);
        addView(this.avv);
        this.avz = new SubsamplingScaleImageView(this.mContext);
        this.avz.setMaxScale(50.0f);
        this.avz.setOnImageEventListener(this.avL);
        this.avz.setVisibility(4);
        addView(this.avz, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(w.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bp();
        this.avw = new TextView(this.mContext);
        aq.j(this.avw, w.g.btn_percent_yuantu);
        this.avw.setText(w.l.original_img_look);
        this.avw.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize28));
        aq.b(this.avw, w.e.cp_cont_g, 1, 0);
        this.avw.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avw.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.avw.setMinWidth(getResources().getDimensionPixelSize(w.f.ds220));
        this.avw.setMinHeight(getResources().getDimensionPixelSize(w.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(w.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.avw.setOnClickListener(this);
        this.avw.setVisibility(8);
        addView(this.avw, layoutParams3);
        Bq();
    }

    private void Bp() {
        this.avI = new TextView(this.mContext);
        this.avI.setBackgroundResource(w.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(w.f.ds180);
        layoutParams.addRule(12);
        addView(this.avI, layoutParams);
        this.avI.setVisibility(8);
    }

    private void Bq() {
        this.avx = new TextView(this.mContext);
        aq.k(this.avx, w.e.common_color_10022);
        this.avx.setText(w.l.goto_pb_floor);
        this.avx.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize24));
        aq.b(this.avx, w.e.cp_cont_g, 1, 0);
        this.avx.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.avx.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_see_arrow), (Drawable) null);
        this.avx.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avx.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(w.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(w.f.ds20);
        layoutParams.addRule(1, this.avw.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.avx.setOnClickListener(this);
        this.avx.setMinHeight(getResources().getDimensionPixelSize(w.f.ds100));
        addView(this.avx, layoutParams);
        this.avx.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Br() {
        if (this.avx != null) {
            boolean z = this.avB || this.avC;
            if (!this.atW && z && this.avE != null && this.avE.threadId > 0 && this.avE.postId > 0 && this.avE.mThreadType != 33) {
                this.avx.setVisibility(0);
                if (this.avI != null) {
                    this.avI.setVisibility(0);
                    return;
                }
                return;
            }
            this.avx.setVisibility(8);
            if (this.avI != null) {
                this.avI.setVisibility(8);
            }
        }
    }

    private void Bs() {
        if (this.avx != null) {
            this.avx.setVisibility(8);
            if (this.avI != null) {
                this.avI.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        if ((this.avB || this.avC) && this.avE != null && this.avE.mPicType == 1 && !TextUtils.isEmpty(this.avE.mTagName)) {
            if (this.avy != null) {
                this.avy.setVisibility(8);
                this.avy = null;
            }
            this.avy = new TextView(this.mContext);
            this.avy.setText(this.avE.mTagName);
            this.avy.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize26));
            aq.b(this.avy, w.e.common_color_10013, 1, 0);
            aq.k(this.avy, w.e.common_color_10215);
            this.avy.setAlpha(0.75f);
            this.avy.setIncludeFontPadding(false);
            this.avy.setGravity(17);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            this.avy.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.avv.getBottomOffset();
            layoutParams.leftMargin = this.avv.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.avy, layoutParams);
            this.avy.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.atW = z;
        if (this.atW) {
            Bs();
        } else {
            Br();
        }
    }

    public void q(String str, boolean z) {
        this.avv.setTag(str);
        this.avv.setLoadBigImage(false);
        this.avv.setImageDrawable(null);
        this.avB = false;
        this.avC = false;
        boolean eD = eD(str);
        this.avF = br(true);
        if (!this.avF) {
            r(str, eD);
        }
        if (eD) {
            s(str, z);
        }
    }

    private boolean bo(boolean z) {
        if (!this.avG || z) {
            this.avG = true;
            if (!this.avF || this.avE == null || StringUtils.isNull(this.avE.originalUrl, true) || this.avE.originalSize < 0 || this.avz.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dx = aw.dx(this.avE.originalUrl);
            this.avz.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.l.ux()) + at.vx().dp(dx) + "/" + dx));
            this.avz.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bu() {
        bo(false);
    }

    private boolean eD(String str) {
        return com.baidu.adp.lib.util.i.he() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dL(str);
    }

    private void r(String str, boolean z) {
        if (this.avE == null) {
            bp(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dL(str)) {
            bp(z);
        } else if (!TextUtils.isEmpty(this.avE.imageUrl)) {
            com.baidu.adp.lib.f.c.fG().a(this.avE.imageUrl, this.avE.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bp(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.avv.Hi();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eE(str)) {
            if (z2 || (!this.avD && !this.avC)) {
                if (!z2 || !bo(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.avD = true;
                    com.baidu.adp.lib.f.c.fG().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.avv.getImageData(), Boolean.valueOf(this.ate));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.Co, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.avJ.a(imageFileInfo, false);
        if (a2 != null) {
            this.avC = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.avJ.a(imageFileInfo, new ab(this), false);
    }

    private boolean eE(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.avA != null) {
                this.avA.i(aVar.getUrl(), aVar.kS());
            }
            Bitmap kN = aVar.kN();
            if (kN == null) {
                if (!this.avB) {
                    this.avv.Hi();
                    return;
                }
                this.avC = false;
                r(null, false);
                return;
            }
            if (aVar.ef()) {
                this.avv.a(aVar.kS(), kN);
                this.avv.invalidate();
                this.avv.play();
                this.avH = false;
                this.avw.setVisibility(8);
            } else {
                this.avv.setImageBitmap(kN);
                this.avv.setImageData(aVar.kS());
                if (this.avH) {
                    this.avw.setVisibility(0);
                }
            }
            Br();
            Bt();
            this.avv.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.avv.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.avv != null) {
            this.avv.onDestroy();
        }
        if (this.avz != null) {
            this.avz.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.avv != null) {
            this.avv.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bv() {
        if (this.avv != null && this.avv.getImageType() == 1) {
            this.avv.stop();
        }
    }

    public void bq(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.avv != null && (str = (String) this.avv.getTag()) != null) {
            if ((!eE(str) || com.baidu.adp.lib.util.i.he()) && this.avv != null) {
                if (this.avv.getImageType() == 1) {
                    if (this.avv.getGifCache() == null || !this.avv.Hp()) {
                        e(str, z, z2);
                    }
                } else if (this.avv.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.avv.getImageBitmap() == null || !this.avv.Hp()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.avv != null) {
            return this.avv.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.avE = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.ate = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.avw) {
            String dx = aw.dx(this.avE.originalUrl);
            if (this.avE.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CH().w(dx, 13);
                this.avE.originalProcess = -1;
                if (this.avE.originalSize > 0) {
                    this.avw.setText(String.valueOf(avu) + "(" + au.E(this.avE.originalSize) + ")");
                } else {
                    this.avw.setText(avu);
                }
                this.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.atg != null) {
                this.atg.Bx();
            }
            com.baidu.adp.base.g<?> aa = com.baidu.adp.base.k.aa(this.mContext);
            if (aa == null) {
                eF(dx);
            } else if (!com.baidu.adp.lib.util.i.he() || com.baidu.adp.lib.util.i.hf() || com.baidu.tbadk.core.sharedPref.b.uo().getBoolean("original_img_down_tip", false)) {
                eF(dx);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(aa.getPageActivity());
                aVar.bW(w.l.original_img_down_no_wifi_tip);
                aVar.a(w.l.alert_yes_button, new ac(this, aVar, dx));
                aVar.b(w.l.alert_no_button, new ad(this, aVar));
                aVar.b(aa);
                aVar.ts();
            }
        } else if (view == this.avx && this.avE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.avE.threadId), String.valueOf(this.avE.postId), this.avE.mIsSeeHost, this.avE.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(String str) {
        if (this.avE != null) {
            this.avE.originalProcess = 0;
        }
        this.avw.setText("0%");
        this.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.avE.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.l.ux()) + at.vx().dp(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.CH().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean br(boolean z) {
        if (this.avE != null && !StringUtils.isNull(this.avE.originalUrl, true) && this.avE.originalSize >= 0) {
            String dx = aw.dx(this.avE.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.l.ux()) + at.vx().dp(dx) + "/" + dx).exists()) {
                this.avE.originalProcess = 100;
                if (z) {
                    this.avw.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.avE.originalProcess < 0) {
                if (this.avE.originalSize > 0) {
                    this.avw.setText(String.valueOf(avu) + "(" + au.E(this.avE.originalSize) + ")");
                } else {
                    this.avw.setText(avu);
                }
                this.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.avw.setText(String.valueOf(this.avE.originalProcess) + "%");
                this.avw.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
            }
            this.avH = true;
        } else {
            this.avw.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.atg = bVar;
    }
}
