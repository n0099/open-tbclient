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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String awD = TbadkCoreApplication.m9getInst().getString(w.l.original_img_look);
    private int BS;
    private boolean aun;
    private b aup;
    private boolean avf;
    protected com.baidu.tbadk.widget.b awE;
    protected TextView awF;
    protected TextView awG;
    protected TextView awH;
    protected SubsamplingScaleImageView awI;
    private a awJ;
    private boolean awK;
    private boolean awL;
    private boolean awM;
    private ImageUrlData awN;
    private boolean awO;
    private boolean awP;
    private boolean awQ;
    private TextView awR;
    private com.baidu.tbadk.img.b awS;
    private Runnable awT;
    private SubsamplingScaleImageView.OnImageEventListener awU;
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
        void Bu();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.awF != null) {
                as.j(this.awF, w.g.btn_percent_yuantu);
                as.b(this.awF, w.e.cp_cont_g, 1, 0);
            }
            if (this.awG != null) {
                as.k(this.awG, w.e.common_color_10022);
                as.b(this.awG, w.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.awE != null) {
            this.awE.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.awJ = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.awE = null;
        this.mContext = null;
        this.awJ = null;
        this.aun = false;
        this.awM = false;
        this.awO = false;
        this.awP = false;
        this.avf = false;
        this.awQ = false;
        this.awR = null;
        this.awT = new v(this);
        this.awU = new x(this);
        this.mContext = context;
        this.awS = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.b getImageView() {
        return this.awE;
    }

    public void setGifSetListener(b.d dVar) {
        this.awE.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.awE.setImageOnClickListener(onClickListener);
        this.awI.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.awE.setImageOnLongClickListener(onLongClickListener);
        this.awI.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(b.e eVar) {
        this.awE.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.BS = com.baidu.adp.lib.util.k.af(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.mContext) - ((int) this.mContext.getResources().getDimension(w.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.awE = new com.baidu.tbadk.widget.b(this.mContext);
        this.awE.setLayoutParams(layoutParams);
        addView(this.awE);
        this.awI = new SubsamplingScaleImageView(this.mContext);
        this.awI.setMaxScale(50.0f);
        this.awI.setOnImageEventListener(this.awU);
        this.awI.setVisibility(4);
        addView(this.awI, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(w.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bm();
        this.awF = new TextView(this.mContext);
        as.j(this.awF, w.g.btn_percent_yuantu);
        this.awF.setText(w.l.original_img_look);
        this.awF.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize28));
        as.b(this.awF, w.e.cp_cont_g, 1, 0);
        this.awF.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.awF.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.awF.setMinWidth(getResources().getDimensionPixelSize(w.f.ds220));
        this.awF.setMinHeight(getResources().getDimensionPixelSize(w.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(w.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.awF.setOnClickListener(this);
        this.awF.setVisibility(8);
        addView(this.awF, layoutParams3);
        Bn();
    }

    private void Bm() {
        this.awR = new TextView(this.mContext);
        this.awR.setBackgroundResource(w.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(w.f.ds180);
        layoutParams.addRule(12);
        addView(this.awR, layoutParams);
        this.awR.setVisibility(8);
    }

    private void Bn() {
        this.awG = new TextView(this.mContext);
        as.k(this.awG, w.e.common_color_10022);
        this.awG.setText(w.l.goto_pb_floor);
        this.awG.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize24));
        as.b(this.awG, w.e.cp_cont_g, 1, 0);
        this.awG.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.awG.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(w.g.icon_see_arrow), (Drawable) null);
        this.awG.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.awG.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(w.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(w.f.ds20);
        layoutParams.addRule(1, this.awF.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.awG.setOnClickListener(this);
        this.awG.setMinHeight(getResources().getDimensionPixelSize(w.f.ds100));
        addView(this.awG, layoutParams);
        this.awG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bo() {
        if (this.awG != null) {
            boolean z = this.awK || this.awL;
            if (!this.avf && z && this.awN != null && this.awN.threadId > 0 && this.awN.postId > 0 && this.awN.mThreadType != 33) {
                this.awG.setVisibility(0);
                if (this.awR != null) {
                    this.awR.setVisibility(0);
                    return;
                }
                return;
            }
            this.awG.setVisibility(8);
            if (this.awR != null) {
                this.awR.setVisibility(8);
            }
        }
    }

    private void Bp() {
        if (this.awG != null) {
            this.awG.setVisibility(8);
            if (this.awR != null) {
                this.awR.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq() {
        if ((this.awK || this.awL) && this.awN != null && this.awN.mPicType == 1 && !TextUtils.isEmpty(this.awN.mTagName)) {
            if (this.awH != null) {
                this.awH.setVisibility(8);
                this.awH = null;
            }
            this.awH = new TextView(this.mContext);
            this.awH.setText(this.awN.mTagName);
            this.awH.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize26));
            as.b(this.awH, w.e.common_color_10013, 1, 0);
            as.k(this.awH, w.e.common_color_10215);
            this.awH.setAlpha(0.75f);
            this.awH.setIncludeFontPadding(false);
            this.awH.setGravity(17);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            this.awH.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.awE.getBottomOffset();
            layoutParams.leftMargin = this.awE.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.awH, layoutParams);
            this.awH.setVisibility(0);
        }
    }

    public void bm(boolean z) {
        this.avf = z;
        if (this.avf) {
            Bp();
        } else {
            Bo();
        }
    }

    public void o(String str, boolean z) {
        this.awE.setTag(str);
        this.awE.setLoadBigImage(false);
        this.awE.setImageDrawable(null);
        this.awK = false;
        this.awL = false;
        boolean fa = fa(str);
        this.awO = br(true);
        if (!this.awO) {
            p(str, fa);
        }
        if (fa) {
            q(str, z);
        }
    }

    private boolean bo(boolean z) {
        if (!this.awP || z) {
            this.awP = true;
            if (!this.awO || this.awN == null || StringUtils.isNull(this.awN.originalUrl, true) || this.awN.originalSize < 0 || this.awI.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dS = ay.dS(this.awN.originalUrl);
            this.awI.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.n.uu()) + av.vu().dK(dS) + "/" + dS));
            this.awI.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Br() {
        bo(false);
    }

    private boolean fa(String str) {
        return com.baidu.adp.lib.util.i.hj() || com.baidu.tbadk.core.util.c.c.eh(str);
    }

    private void p(String str, boolean z) {
        if (this.awN == null) {
            bp(z);
        } else if (com.baidu.tbadk.core.util.c.c.eh(str)) {
            bp(z);
        } else if (!TextUtils.isEmpty(this.awN.imageUrl)) {
            com.baidu.adp.lib.f.c.fL().a(this.awN.imageUrl, this.awN.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bp(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.awE.Hj();
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (fb(str)) {
            if (z2 || (!this.awM && !this.awL)) {
                if (!z2 || !bo(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.awM = true;
                    com.baidu.adp.lib.f.c.fL().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.awE.getImageData(), Boolean.valueOf(this.aun));
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
        com.baidu.adp.widget.a.a a2 = this.awS.a(imageFileInfo, false);
        if (a2 != null) {
            this.awL = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.awS.a(imageFileInfo, new ab(this), false);
    }

    private boolean fb(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.awJ != null) {
                this.awJ.i(aVar.getUrl(), aVar.kU());
            }
            Bitmap kP = aVar.kP();
            if (kP == null) {
                if (!this.awK) {
                    this.awE.Hj();
                    return;
                }
                this.awL = false;
                p(null, false);
                return;
            }
            if (aVar.isGif()) {
                this.awE.a(aVar.kU(), kP);
                this.awE.invalidate();
                this.awE.play();
                this.awQ = false;
                this.awF.setVisibility(8);
            } else {
                this.awE.setImageBitmap(kP);
                this.awE.setImageData(aVar.kU());
                if (this.awQ) {
                    this.awF.setVisibility(0);
                }
            }
            Bo();
            Bq();
            this.awE.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.awE.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.awE != null) {
            this.awE.onDestroy();
        }
        if (this.awI != null) {
            this.awI.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.awE != null) {
            this.awE.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bs() {
        if (this.awE != null && this.awE.getImageType() == 1) {
            this.awE.stop();
        }
    }

    public void bq(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.awE != null && (str = (String) this.awE.getTag()) != null) {
            if ((!fb(str) || com.baidu.adp.lib.util.i.hj()) && this.awE != null) {
                if (this.awE.getImageType() == 1) {
                    if (this.awE.getGifCache() == null || !this.awE.Hq()) {
                        e(str, z, z2);
                    }
                } else if (this.awE.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.awE.getImageBitmap() == null || !this.awE.Hq()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.awE != null) {
            return this.awE.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.awN = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aun = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.awF) {
            String dS = ay.dS(this.awN.originalUrl);
            if (this.awN.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Cy().w(dS, 13);
                this.awN.originalProcess = -1;
                if (this.awN.originalSize > 0) {
                    this.awF.setText(String.valueOf(awD) + "(" + aw.G(this.awN.originalSize) + ")");
                } else {
                    this.awF.setText(awD);
                }
                this.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.aup != null) {
                this.aup.Bu();
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.mContext);
            if (Z == null) {
                fc(dS);
            } else if (!com.baidu.adp.lib.util.i.hj() || com.baidu.adp.lib.util.i.hk() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                fc(dS);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Z.getPageActivity());
                aVar.bY(w.l.original_img_down_no_wifi_tip);
                aVar.a(w.l.alert_yes_button, new ac(this, aVar, dS));
                aVar.b(w.l.alert_no_button, new ad(this, aVar));
                aVar.b(Z);
                aVar.ta();
            }
        } else if (view == this.awG && this.awN != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.awN.threadId), String.valueOf(this.awN.postId), this.awN.mIsSeeHost, this.awN.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(String str) {
        if (this.awN != null) {
            this.awN.originalProcess = 0;
        }
        this.awF.setText("0%");
        this.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.awN.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.n.uu()) + av.vu().dK(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Cy().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean br(boolean z) {
        if (this.awN != null && !StringUtils.isNull(this.awN.originalUrl, true) && this.awN.originalSize >= 0) {
            String dS = ay.dS(this.awN.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.n.uu()) + av.vu().dK(dS) + "/" + dS).exists()) {
                this.awN.originalProcess = 100;
                if (z) {
                    this.awF.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.awN.originalProcess < 0) {
                if (this.awN.originalSize > 0) {
                    this.awF.setText(String.valueOf(awD) + "(" + aw.G(this.awN.originalSize) + ")");
                } else {
                    this.awF.setText(awD);
                }
                this.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.awF.setText(String.valueOf(this.awN.originalProcess) + "%");
                this.awF.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
            }
            this.awQ = true;
        } else {
            this.awF.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aup = bVar;
    }
}
