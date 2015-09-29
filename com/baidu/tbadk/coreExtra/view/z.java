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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class z extends RelativeLayout implements View.OnClickListener {
    private static final String alU = TbadkCoreApplication.m411getInst().getString(i.h.original_img_look);
    private int Bo;
    private boolean akc;
    private b ake;
    protected com.baidu.tbadk.widget.a alV;
    protected TextView alW;
    protected SubsamplingScaleImageView alX;
    private a alY;
    private boolean alZ;
    private boolean ama;
    private ImageUrlData amb;
    private boolean amc;
    private boolean amd;
    private boolean ame;
    private com.baidu.tbadk.img.b amf;
    private Runnable amg;
    private SubsamplingScaleImageView.OnImageEventListener amh;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void zp();
    }

    public void setHeadImage(boolean z) {
        if (this.alV != null) {
            this.alV.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.alY = aVar;
    }

    public z(Context context) {
        super(context);
        this.mProgressBar = null;
        this.alV = null;
        this.mContext = null;
        this.alY = null;
        this.akc = false;
        this.amc = false;
        this.amd = false;
        this.ame = false;
        this.amg = new aa(this);
        this.amh = new ac(this);
        this.mContext = context;
        this.amf = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.alV;
    }

    public void setGifSetListener(a.d dVar) {
        this.alV.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.alV.setImageOnClickListener(onClickListener);
        this.alX.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alV.setImageOnLongClickListener(onLongClickListener);
        this.alX.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.alV.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.Bo = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(i.d.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.alV = new com.baidu.tbadk.widget.a(this.mContext);
        this.alV.setLayoutParams(layoutParams);
        addView(this.alV);
        this.alX = new SubsamplingScaleImageView(this.mContext);
        this.alX.setOnImageEventListener(this.amh);
        this.alX.setVisibility(4);
        addView(this.alX, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        this.alW = new TextView(this.mContext);
        am.i((View) this.alW, i.e.btn_percent_yuantu);
        this.alW.setText(i.h.original_img_look);
        this.alW.setTextSize(0, getResources().getDimensionPixelSize(i.d.fontsize28));
        am.b(this.alW, i.c.cp_cont_g, 1);
        this.alW.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds20);
        this.alW.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.alW.setMinWidth(getResources().getDimensionPixelSize(i.d.ds220));
        this.alW.setMinHeight(getResources().getDimensionPixelSize(i.d.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(i.d.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.alW.setOnClickListener(this);
        this.alW.setVisibility(8);
        addView(this.alW, layoutParams3);
    }

    public void p(String str, boolean z) {
        this.alV.setTag(str);
        this.alV.setLoadBigImage(false);
        this.alV.setImageDrawable(null);
        this.alZ = false;
        this.ama = false;
        boolean ev = ev(str);
        this.amc = aU(true);
        if (!this.amc) {
            q(str, ev);
        }
        if (ev) {
            r(str, z);
        }
    }

    public void zm() {
        if (!this.amd) {
            this.amd = true;
            if (this.amc && this.amb != null && !StringUtils.isNull(this.amb.originalUrl, true) && this.amb.originalSize > 0 && !this.alX.isImageLoaded() && Build.VERSION.SDK_INT >= 10) {
                String dm = at.dm(this.amb.originalUrl);
                this.alX.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + aq.uC().dh(dm) + "/" + dm));
                this.alX.setVisibility(0);
            }
        }
    }

    private boolean ev(String str) {
        return com.baidu.adp.lib.util.i.iM() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void q(String str, boolean z) {
        if (this.amb == null) {
            aS(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aS(z);
        } else if (!TextUtils.isEmpty(this.amb.imageUrl)) {
            com.baidu.adp.lib.f.c.ha().a(this.amb.imageUrl, this.amb.urlType, new ad(this, z), 0, 0, true, null, new Object[0]);
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
            com.baidu.adp.lib.f.c.ha().a(str, 27, new ae(this), 0, 0, false, null, Boolean.valueOf(z), this.alV.getImageData(), Boolean.valueOf(this.akc));
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bo, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.amf.a(imageFileInfo, false);
        if (a2 != null) {
            this.ama = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.amf.a(imageFileInfo, new af(this), false);
    }

    private boolean ew(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.alY != null) {
                this.alY.i(aVar.getUrl(), aVar.nf());
            }
            Bitmap na = aVar.na();
            if (na == null) {
                if (!this.alZ) {
                    this.alV.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fF()) {
                this.alV.a(aVar.nf(), na);
            } else {
                this.alV.setImageBitmap(na);
                this.alV.setImageData(aVar.nf());
                if (this.ame) {
                    this.alW.setVisibility(0);
                }
            }
            this.alV.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.alV.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.alV != null) {
            this.alV.onDestroy();
        }
        if (this.alX != null) {
            this.alX.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.alV != null) {
            this.alV.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zn() {
        if (this.alV != null && this.alV.getImageType() == 1) {
            this.alV.stop();
        }
    }

    public void aT(boolean z) {
        String str;
        if (this.alV != null && (str = (String) this.alV.getTag()) != null) {
            if ((!ew(str) || com.baidu.adp.lib.util.i.iM()) && this.alV != null) {
                if (this.alV.getImageType() == 1) {
                    if (this.alV.getGifCache() == null || !this.alV.EP()) {
                        r(str, z);
                    }
                } else if (this.alV.getImageType() == 2) {
                    r(str, z);
                } else if (this.alV.getImageBitmap() == null || !this.alV.EP()) {
                    r(str, z);
                }
            }
        }
    }

    public int getImageType() {
        if (this.alV != null) {
            return this.alV.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.amb = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.akc = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.alW) {
            String dm = at.dm(this.amb.originalUrl);
            if (this.amb.originalProcess >= 0) {
                com.baidu.tbadk.download.d.As().t(dm, 13);
                this.amb.originalProcess = -1;
                this.alW.setText(String.valueOf(alU) + "(" + ar.y(this.amb.originalSize) + ")");
                this.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.ake != null) {
                this.ake.zp();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                ex(dm);
            } else if (!com.baidu.adp.lib.util.i.iM() || com.baidu.adp.lib.util.i.iN() || com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("original_img_down_tip", false)) {
                ex(dm);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bF(i.h.original_img_down_no_wifi_tip);
                aVar.a(i.h.alert_yes_button, new ag(this, aVar, dm));
                aVar.b(i.h.alert_no_button, new ah(this, aVar));
                aVar.b(C);
                aVar.sR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(String str) {
        if (this.amb != null) {
            this.amb.originalProcess = 0;
        }
        this.alW.setText("0%");
        this.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.amb.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + aq.uC().dh(str) + "/" + str);
        downloadData.setCallback(new ai(this));
        com.baidu.tbadk.download.d.As().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(boolean z) {
        if (this.amb != null && !StringUtils.isNull(this.amb.originalUrl, true) && this.amb.originalSize > 0) {
            String dm = at.dm(this.amb.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + aq.uC().dh(dm) + "/" + dm).exists()) {
                this.amb.originalProcess = 100;
                if (z) {
                    this.alW.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.amb.originalProcess < 0) {
                this.alW.setText(String.valueOf(alU) + "(" + ar.y(this.amb.originalSize) + ")");
                this.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.alW.setText(String.valueOf(this.amb.originalProcess) + "%");
                this.alW.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
            }
            this.ame = true;
        } else {
            this.alW.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.ake = bVar;
    }
}
