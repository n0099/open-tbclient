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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.n;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class z extends RelativeLayout implements View.OnClickListener {
    private static final String anN = TbadkCoreApplication.m411getInst().getString(n.i.original_img_look);
    private int Bv;
    private boolean alT;
    private b alV;
    protected com.baidu.tbadk.widget.a anO;
    protected TextView anP;
    protected SubsamplingScaleImageView anQ;
    private a anR;
    private boolean anS;
    private boolean anT;
    private ImageUrlData anU;
    private boolean anV;
    private boolean anW;
    private boolean anX;
    private com.baidu.tbadk.img.b anY;
    private Runnable anZ;
    private SubsamplingScaleImageView.OnImageEventListener aoa;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void An();
    }

    public void setHeadImage(boolean z) {
        if (this.anO != null) {
            this.anO.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.anR = aVar;
    }

    public z(Context context) {
        super(context);
        this.mProgressBar = null;
        this.anO = null;
        this.mContext = null;
        this.anR = null;
        this.alT = false;
        this.anV = false;
        this.anW = false;
        this.anX = false;
        this.anZ = new aa(this);
        this.aoa = new ac(this);
        this.mContext = context;
        this.anY = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.anO;
    }

    public void setGifSetListener(a.d dVar) {
        this.anO.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.anO.setImageOnClickListener(onClickListener);
        this.anQ.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anO.setImageOnLongClickListener(onLongClickListener);
        this.anQ.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.anO.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.Bv = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(n.d.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.anO = new com.baidu.tbadk.widget.a(this.mContext);
        this.anO.setLayoutParams(layoutParams);
        addView(this.anO);
        this.anQ = new SubsamplingScaleImageView(this.mContext);
        this.anQ.setOnImageEventListener(this.aoa);
        this.anQ.setVisibility(4);
        addView(this.anQ, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(n.e.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        this.anP = new TextView(this.mContext);
        as.i((View) this.anP, n.e.btn_percent_yuantu);
        this.anP.setText(n.i.original_img_look);
        this.anP.setTextSize(0, getResources().getDimensionPixelSize(n.d.fontsize28));
        as.b(this.anP, n.c.cp_cont_g, 1);
        this.anP.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.ds20);
        this.anP.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.anP.setMinWidth(getResources().getDimensionPixelSize(n.d.ds220));
        this.anP.setMinHeight(getResources().getDimensionPixelSize(n.d.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(n.d.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.anP.setOnClickListener(this);
        this.anP.setVisibility(8);
        addView(this.anP, layoutParams3);
    }

    public void p(String str, boolean z) {
        this.anO.setTag(str);
        this.anO.setLoadBigImage(false);
        this.anO.setImageDrawable(null);
        this.anS = false;
        this.anT = false;
        boolean eF = eF(str);
        this.anV = aZ(true);
        if (!this.anV) {
            q(str, eF);
        }
        if (eF) {
            r(str, z);
        }
    }

    public void Ak() {
        if (!this.anW) {
            this.anW = true;
            if (this.anV && this.anU != null && !StringUtils.isNull(this.anU.originalUrl, true) && this.anU.originalSize >= 0 && !this.anQ.isImageLoaded() && Build.VERSION.SDK_INT >= 10) {
                String dy = az.dy(this.anU.originalUrl);
                this.anQ.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.n.ui()) + aw.vk().ds(dy) + "/" + dy));
                this.anQ.setVisibility(0);
            }
        }
    }

    private boolean eF(String str) {
        return com.baidu.adp.lib.util.i.iP() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void q(String str, boolean z) {
        if (this.anU == null) {
            aX(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aX(z);
        } else if (!TextUtils.isEmpty(this.anU.imageUrl)) {
            com.baidu.adp.lib.g.c.hd().a(this.anU.imageUrl, this.anU.urlType, new ad(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aX(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void r(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        if (eG(str)) {
            com.baidu.adp.lib.g.c.hd().a(str, 27, new ae(this), 0, 0, false, null, Boolean.valueOf(z), this.anO.getImageData(), Boolean.valueOf(this.alT));
            return;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.setTempFile(true);
        imageFileInfo.clearPageActions();
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bv, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.anY.a(imageFileInfo, false);
        if (a2 != null) {
            this.anT = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.anY.a(imageFileInfo, new af(this), false);
    }

    private boolean eG(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.anR != null) {
                this.anR.i(aVar.getUrl(), aVar.nl());
            }
            Bitmap ng = aVar.ng();
            if (ng == null) {
                if (!this.anS) {
                    this.anO.setDefaultBitmap();
                    return;
                }
                return;
            }
            if (aVar.fF()) {
                this.anO.a(aVar.nl(), ng);
            } else {
                this.anO.setImageBitmap(ng);
                this.anO.setImageData(aVar.nl());
                if (this.anX) {
                    this.anP.setVisibility(0);
                }
            }
            this.anO.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.anO.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.anO != null) {
            this.anO.onDestroy();
        }
        if (this.anQ != null) {
            this.anQ.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.anO != null) {
            this.anO.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Al() {
        if (this.anO != null && this.anO.getImageType() == 1) {
            this.anO.stop();
        }
    }

    public void aY(boolean z) {
        String str;
        if (this.anO != null && (str = (String) this.anO.getTag()) != null) {
            if ((!eG(str) || com.baidu.adp.lib.util.i.iP()) && this.anO != null) {
                if (this.anO.getImageType() == 1) {
                    if (this.anO.getGifCache() == null || !this.anO.FH()) {
                        r(str, z);
                    }
                } else if (this.anO.getImageType() == 2) {
                    r(str, z);
                } else if (this.anO.getImageBitmap() == null || !this.anO.FH()) {
                    r(str, z);
                }
            }
        }
    }

    public int getImageType() {
        if (this.anO != null) {
            return this.anO.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.anU = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.alT = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anP) {
            String dy = az.dy(this.anU.originalUrl);
            if (this.anU.originalProcess >= 0) {
                com.baidu.tbadk.download.d.Bp().u(dy, 13);
                this.anU.originalProcess = -1;
                if (this.anU.originalSize > 0) {
                    this.anP.setText(String.valueOf(anN) + "(" + ax.C(this.anU.originalSize) + ")");
                } else {
                    this.anP.setText(anN);
                }
                this.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.alV != null) {
                this.alV.An();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eH(dy);
            } else if (!com.baidu.adp.lib.util.i.iP() || com.baidu.adp.lib.util.i.iQ() || com.baidu.tbadk.core.sharedPref.b.tZ().getBoolean("original_img_down_tip", false)) {
                eH(dy);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bN(n.i.original_img_down_no_wifi_tip);
                aVar.a(n.i.alert_yes_button, new ag(this, aVar, dy));
                aVar.b(n.i.alert_no_button, new ah(this, aVar));
                aVar.b(C);
                aVar.tv();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(String str) {
        if (this.anU != null) {
            this.anU.originalProcess = 0;
        }
        this.anP.setText("0%");
        this.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.e.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.anU.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.n.ui()) + aw.vk().ds(str) + "/" + str);
        downloadData.setCallback(new ai(this));
        com.baidu.tbadk.download.d.Bp().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aZ(boolean z) {
        if (this.anU != null && !StringUtils.isNull(this.anU.originalUrl, true) && this.anU.originalSize >= 0) {
            String dy = az.dy(this.anU.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.n.ui()) + aw.vk().ds(dy) + "/" + dy).exists()) {
                this.anU.originalProcess = 100;
                if (z) {
                    this.anP.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.anU.originalProcess < 0) {
                if (this.anU.originalSize > 0) {
                    this.anP.setText(String.valueOf(anN) + "(" + ax.C(this.anU.originalSize) + ")");
                } else {
                    this.anP.setText(anN);
                }
                this.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.anP.setText(String.valueOf(this.anU.originalProcess) + "%");
                this.anP.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.e.icon_close_yuantu, 0);
            }
            this.anX = true;
        } else {
            this.anP.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.alV = bVar;
    }
}
