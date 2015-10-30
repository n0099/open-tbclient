package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class z extends RelativeLayout implements View.OnClickListener {
    private static final String alV = TbadkCoreApplication.m411getInst().getString(i.h.original_img_look);
    private int Bo;
    private boolean akd;
    private b akf;
    protected com.baidu.tbadk.widget.a alW;
    protected TextView alX;
    protected SubsamplingScaleImageView alY;
    private a alZ;
    private boolean ama;
    private boolean amb;
    private ImageUrlData amc;
    private boolean amd;
    private boolean ame;
    private boolean amf;
    private com.baidu.tbadk.img.b amg;
    private Runnable amh;
    private SubsamplingScaleImageView.OnImageEventListener ami;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void zm();
    }

    public void setHeadImage(boolean z) {
        if (this.alW != null) {
            this.alW.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.alZ = aVar;
    }

    public z(Context context) {
        super(context);
        this.mProgressBar = null;
        this.alW = null;
        this.mContext = null;
        this.alZ = null;
        this.akd = false;
        this.amd = false;
        this.ame = false;
        this.amf = false;
        this.amh = new aa(this);
        this.ami = new ac(this);
        this.mContext = context;
        this.amg = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.alW;
    }

    public void setGifSetListener(a.d dVar) {
        this.alW.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.alW.setImageOnClickListener(onClickListener);
        this.alY.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alW.setImageOnLongClickListener(onLongClickListener);
        this.alY.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.alW.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.Bo = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(i.d.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.alW = new com.baidu.tbadk.widget.a(this.mContext);
        this.alW.setLayoutParams(layoutParams);
        addView(this.alW);
        this.alY = new SubsamplingScaleImageView(this.mContext);
        this.alY.setOnImageEventListener(this.ami);
        this.alY.setVisibility(4);
        addView(this.alY, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        this.alX = new TextView(this.mContext);
        an.i((View) this.alX, i.e.btn_percent_yuantu);
        this.alX.setText(i.h.original_img_look);
        this.alX.setTextSize(0, getResources().getDimensionPixelSize(i.d.fontsize28));
        an.b(this.alX, i.c.cp_cont_g, 1);
        this.alX.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds20);
        this.alX.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.alX.setMinWidth(getResources().getDimensionPixelSize(i.d.ds220));
        this.alX.setMinHeight(getResources().getDimensionPixelSize(i.d.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(i.d.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.alX.setOnClickListener(this);
        this.alX.setVisibility(8);
        addView(this.alX, layoutParams3);
    }

    public void p(String str, boolean z) {
        this.alW.setTag(str);
        this.alW.setLoadBigImage(false);
        this.alW.setImageDrawable(null);
        this.ama = false;
        this.amb = false;
        boolean ev = ev(str);
        this.amd = aU(true);
        if (!this.amd) {
            q(str, ev);
        }
        if (ev) {
            r(str, z);
        }
    }

    public void zj() {
        if (!this.ame) {
            this.ame = true;
            if (this.amd && this.amc != null && !StringUtils.isNull(this.amc.originalUrl, true) && this.amc.originalSize > 0 && !this.alY.isImageLoaded() && Build.VERSION.SDK_INT >= 10) {
                String dn = au.dn(this.amc.originalUrl);
                this.alY.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.n.tA()) + ar.uA().di(dn) + "/" + dn));
                this.alY.setVisibility(0);
            }
        }
    }

    private boolean ev(String str) {
        return com.baidu.adp.lib.util.i.iM() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void q(String str, boolean z) {
        if (this.amc == null) {
            aS(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aS(z);
        } else if (!TextUtils.isEmpty(this.amc.imageUrl)) {
            com.baidu.adp.lib.f.c.ha().a(this.amc.imageUrl, this.amc.urlType, new ad(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aS(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void r(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        if (ew(str)) {
            com.baidu.adp.lib.f.c.ha().a(str, 27, new ae(this), 0, 0, false, null, Boolean.valueOf(z), this.alW.getImageData(), Boolean.valueOf(this.akd));
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bo, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.amg.a(imageFileInfo, false);
        if (a2 != null) {
            this.amb = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.amg.a(imageFileInfo, new af(this), false);
    }

    private boolean ew(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.alZ != null) {
                this.alZ.i(aVar.getUrl(), aVar.nf());
            }
            Bitmap na = aVar.na();
            if (na == null) {
                if (!this.ama) {
                    this.alW.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fF()) {
                this.alW.a(aVar.nf(), na);
            } else {
                this.alW.setImageBitmap(na);
                this.alW.setImageData(aVar.nf());
                if (this.amf) {
                    this.alX.setVisibility(0);
                }
            }
            this.alW.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.alW.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.alW != null) {
            this.alW.onDestroy();
        }
        if (this.alY != null) {
            this.alY.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.alW != null) {
            this.alW.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zk() {
        if (this.alW != null && this.alW.getImageType() == 1) {
            this.alW.stop();
        }
    }

    public void aT(boolean z) {
        String str;
        if (this.alW != null && (str = (String) this.alW.getTag()) != null) {
            if ((!ew(str) || com.baidu.adp.lib.util.i.iM()) && this.alW != null) {
                if (this.alW.getImageType() == 1) {
                    if (this.alW.getGifCache() == null || !this.alW.EL()) {
                        r(str, z);
                    }
                } else if (this.alW.getImageType() == 2) {
                    r(str, z);
                } else if (this.alW.getImageBitmap() == null || !this.alW.EL()) {
                    r(str, z);
                }
            }
        }
    }

    public int getImageType() {
        if (this.alW != null) {
            return this.alW.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.amc = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.akd = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.alX) {
            String dn = au.dn(this.amc.originalUrl);
            if (this.amc.originalProcess >= 0) {
                com.baidu.tbadk.download.d.Ap().t(dn, 13);
                this.amc.originalProcess = -1;
                this.alX.setText(String.valueOf(alV) + "(" + as.w(this.amc.originalSize) + ")");
                this.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.akf != null) {
                this.akf.zm();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                ex(dn);
            } else if (!com.baidu.adp.lib.util.i.iM() || com.baidu.adp.lib.util.i.iN() || com.baidu.tbadk.core.sharedPref.b.tr().getBoolean("original_img_down_tip", false)) {
                ex(dn);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bF(i.h.original_img_down_no_wifi_tip);
                aVar.a(i.h.alert_yes_button, new ag(this, aVar, dn));
                aVar.b(i.h.alert_no_button, new ah(this, aVar));
                aVar.b(C);
                aVar.sO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(String str) {
        if (this.amc != null) {
            this.amc.originalProcess = 0;
        }
        this.alX.setText("0%");
        this.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.amc.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.n.tA()) + ar.uA().di(str) + "/" + str);
        downloadData.setCallback(new ai(this));
        com.baidu.tbadk.download.d.Ap().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(boolean z) {
        if (this.amc != null && !StringUtils.isNull(this.amc.originalUrl, true) && this.amc.originalSize > 0) {
            String dn = au.dn(this.amc.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.n.tA()) + ar.uA().di(dn) + "/" + dn).exists()) {
                this.amc.originalProcess = 100;
                if (z) {
                    this.alX.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.amc.originalProcess < 0) {
                this.alX.setText(String.valueOf(alV) + "(" + as.w(this.amc.originalSize) + ")");
                this.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.alX.setText(String.valueOf(this.amc.originalProcess) + "%");
                this.alX.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
            }
            this.amf = true;
        } else {
            this.alX.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.akf = bVar;
    }
}
