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
    private static final String ama = TbadkCoreApplication.m411getInst().getString(i.h.original_img_look);
    private int Bo;
    private boolean aki;
    private b akk;
    protected com.baidu.tbadk.widget.a amb;
    protected TextView amc;
    protected SubsamplingScaleImageView amd;
    private a ame;
    private boolean amf;
    private boolean amg;
    private ImageUrlData amh;
    private boolean ami;
    private boolean amj;
    private boolean amk;
    private com.baidu.tbadk.img.b aml;
    private Runnable amm;
    private SubsamplingScaleImageView.OnImageEventListener amn;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void zr();
    }

    public void setHeadImage(boolean z) {
        if (this.amb != null) {
            this.amb.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.ame = aVar;
    }

    public z(Context context) {
        super(context);
        this.mProgressBar = null;
        this.amb = null;
        this.mContext = null;
        this.ame = null;
        this.aki = false;
        this.ami = false;
        this.amj = false;
        this.amk = false;
        this.amm = new aa(this);
        this.amn = new ac(this);
        this.mContext = context;
        this.aml = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.amb;
    }

    public void setGifSetListener(a.d dVar) {
        this.amb.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.amb.setImageOnClickListener(onClickListener);
        this.amd.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amb.setImageOnLongClickListener(onLongClickListener);
        this.amd.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.amb.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.Bo = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(i.d.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.amb = new com.baidu.tbadk.widget.a(this.mContext);
        this.amb.setLayoutParams(layoutParams);
        addView(this.amb);
        this.amd = new SubsamplingScaleImageView(this.mContext);
        this.amd.setOnImageEventListener(this.amn);
        this.amd.setVisibility(4);
        addView(this.amd, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        this.amc = new TextView(this.mContext);
        an.i((View) this.amc, i.e.btn_percent_yuantu);
        this.amc.setText(i.h.original_img_look);
        this.amc.setTextSize(0, getResources().getDimensionPixelSize(i.d.fontsize28));
        an.b(this.amc, i.c.cp_cont_g, 1);
        this.amc.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.ds20);
        this.amc.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.amc.setMinWidth(getResources().getDimensionPixelSize(i.d.ds220));
        this.amc.setMinHeight(getResources().getDimensionPixelSize(i.d.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(i.d.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.amc.setOnClickListener(this);
        this.amc.setVisibility(8);
        addView(this.amc, layoutParams3);
    }

    public void o(String str, boolean z) {
        this.amb.setTag(str);
        this.amb.setLoadBigImage(false);
        this.amb.setImageDrawable(null);
        this.amf = false;
        this.amg = false;
        boolean ev = ev(str);
        this.ami = aU(true);
        if (!this.ami) {
            p(str, ev);
        }
        if (ev) {
            q(str, z);
        }
    }

    public void zo() {
        if (!this.amj) {
            this.amj = true;
            if (this.ami && this.amh != null && !StringUtils.isNull(this.amh.originalUrl, true) && this.amh.originalSize > 0 && !this.amd.isImageLoaded() && Build.VERSION.SDK_INT >= 10) {
                String dn = au.dn(this.amh.originalUrl);
                this.amd.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uE().di(dn) + "/" + dn));
                this.amd.setVisibility(0);
            }
        }
    }

    private boolean ev(String str) {
        return com.baidu.adp.lib.util.i.iN() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void p(String str, boolean z) {
        if (this.amh == null) {
            aS(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aS(z);
        } else if (!TextUtils.isEmpty(this.amh.imageUrl)) {
            com.baidu.adp.lib.f.c.hb().a(this.amh.imageUrl, this.amh.urlType, new ad(this, z), 0, 0, true, null, new Object[0]);
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

    private void q(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        if (ew(str)) {
            com.baidu.adp.lib.f.c.hb().a(str, 27, new ae(this), 0, 0, false, null, Boolean.valueOf(z), this.amb.getImageData(), Boolean.valueOf(this.aki));
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.J(this.Bo, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.aml.a(imageFileInfo, false);
        if (a2 != null) {
            this.amg = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aml.a(imageFileInfo, new af(this), false);
    }

    private boolean ew(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.ame != null) {
                this.ame.i(aVar.getUrl(), aVar.ng());
            }
            Bitmap nb = aVar.nb();
            if (nb == null) {
                if (!this.amf) {
                    this.amb.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fF()) {
                this.amb.a(aVar.ng(), nb);
            } else {
                this.amb.setImageBitmap(nb);
                this.amb.setImageData(aVar.ng());
                if (this.amk) {
                    this.amc.setVisibility(0);
                }
            }
            this.amb.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.amb.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.amb != null) {
            this.amb.onDestroy();
        }
        if (this.amd != null) {
            this.amd.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.amb != null) {
            this.amb.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zp() {
        if (this.amb != null && this.amb.getImageType() == 1) {
            this.amb.stop();
        }
    }

    public void aT(boolean z) {
        String str;
        if (this.amb != null && (str = (String) this.amb.getTag()) != null) {
            if ((!ew(str) || com.baidu.adp.lib.util.i.iN()) && this.amb != null) {
                if (this.amb.getImageType() == 1) {
                    if (this.amb.getGifCache() == null || !this.amb.EE()) {
                        q(str, z);
                    }
                } else if (this.amb.getImageType() == 2) {
                    q(str, z);
                } else if (this.amb.getImageBitmap() == null || !this.amb.EE()) {
                    q(str, z);
                }
            }
        }
    }

    public int getImageType() {
        if (this.amb != null) {
            return this.amb.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.amh = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aki = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amc) {
            String dn = au.dn(this.amh.originalUrl);
            if (this.amh.originalProcess >= 0) {
                com.baidu.tbadk.download.d.Au().t(dn, 13);
                this.amh.originalProcess = -1;
                this.amc.setText(String.valueOf(ama) + "(" + as.w(this.amh.originalSize) + ")");
                this.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.akk != null) {
                this.akk.zr();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                ex(dn);
            } else if (!com.baidu.adp.lib.util.i.iN() || com.baidu.adp.lib.util.i.iO() || com.baidu.tbadk.core.sharedPref.b.tu().getBoolean("original_img_down_tip", false)) {
                ex(dn);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tu().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bF(i.h.original_img_down_no_wifi_tip);
                aVar.a(i.h.alert_yes_button, new ag(this, aVar, dn));
                aVar.b(i.h.alert_no_button, new ah(this, aVar));
                aVar.b(C);
                aVar.sR();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ex(String str) {
        if (this.amh != null) {
            this.amh.originalProcess = 0;
        }
        this.amc.setText("0%");
        this.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.amh.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uE().di(str) + "/" + str);
        downloadData.setCallback(new ai(this));
        com.baidu.tbadk.download.d.Au().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aU(boolean z) {
        if (this.amh != null && !StringUtils.isNull(this.amh.originalUrl, true) && this.amh.originalSize > 0) {
            String dn = au.dn(this.amh.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.n.tD()) + ar.uE().di(dn) + "/" + dn).exists()) {
                this.amh.originalProcess = 100;
                if (z) {
                    this.amc.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.amh.originalProcess < 0) {
                this.amc.setText(String.valueOf(ama) + "(" + as.w(this.amh.originalSize) + ")");
                this.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.amc.setText(String.valueOf(this.amh.originalProcess) + "%");
                this.amc.setCompoundDrawablesWithIntrinsicBounds(0, 0, i.e.icon_close_yuantu, 0);
            }
            this.amk = true;
        } else {
            this.amc.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.akk = bVar;
    }
}
