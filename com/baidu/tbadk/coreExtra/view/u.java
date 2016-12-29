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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String aqT = TbadkCoreApplication.m9getInst().getString(r.j.original_img_look);
    private boolean aoD;
    private b aoF;
    private boolean apw;
    protected com.baidu.tbadk.widget.a aqU;
    protected TextView aqV;
    protected TextView aqW;
    protected TextView aqX;
    protected SubsamplingScaleImageView aqY;
    private a aqZ;
    private boolean ara;
    private boolean arb;
    private boolean arc;
    private ImageUrlData ard;
    private boolean are;
    private boolean arf;
    private boolean arg;
    private TextView arh;
    private com.baidu.tbadk.img.b ari;
    private Runnable arj;
    private SubsamplingScaleImageView.OnImageEventListener ark;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int vj;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Bj();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aqV != null) {
                ar.k(this.aqV, r.f.btn_percent_yuantu);
                ar.b(this.aqV, r.d.cp_cont_g, 1, 0);
            }
            if (this.aqW != null) {
                ar.l(this.aqW, r.d.common_color_10022);
                ar.b(this.aqW, r.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aqU != null) {
            this.aqU.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aqZ = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aqU = null;
        this.mContext = null;
        this.aqZ = null;
        this.aoD = false;
        this.arc = false;
        this.are = false;
        this.arf = false;
        this.apw = false;
        this.arg = false;
        this.arh = null;
        this.arj = new v(this);
        this.ark = new x(this);
        this.mContext = context;
        this.ari = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aqU;
    }

    public void setGifSetListener(a.d dVar) {
        this.aqU.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqU.setImageOnClickListener(onClickListener);
        this.aqY.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aqU.setImageOnLongClickListener(onLongClickListener);
        this.aqY.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.aqU.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.vj = com.baidu.adp.lib.util.k.I(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.J(this.mContext) - ((int) this.mContext.getResources().getDimension(r.e.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aqU = new com.baidu.tbadk.widget.a(this.mContext);
        this.aqU.setLayoutParams(layoutParams);
        addView(this.aqU);
        this.aqY = new SubsamplingScaleImageView(this.mContext);
        this.aqY.setMaxScale(50.0f);
        this.aqY.setOnImageEventListener(this.ark);
        this.aqY.setVisibility(4);
        addView(this.aqY, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(r.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bb();
        this.aqV = new TextView(this.mContext);
        ar.k(this.aqV, r.f.btn_percent_yuantu);
        this.aqV.setText(r.j.original_img_look);
        this.aqV.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize28));
        ar.b(this.aqV, r.d.cp_cont_g, 1, 0);
        this.aqV.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds20);
        this.aqV.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aqV.setMinWidth(getResources().getDimensionPixelSize(r.e.ds220));
        this.aqV.setMinHeight(getResources().getDimensionPixelSize(r.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(r.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.aqV.setOnClickListener(this);
        this.aqV.setVisibility(8);
        addView(this.aqV, layoutParams3);
        Bc();
    }

    private void Bb() {
        this.arh = new TextView(this.mContext);
        this.arh.setBackgroundResource(r.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(r.e.ds180);
        layoutParams.addRule(12);
        addView(this.arh, layoutParams);
        this.arh.setVisibility(8);
    }

    private void Bc() {
        this.aqW = new TextView(this.mContext);
        ar.l(this.aqW, r.d.common_color_10022);
        this.aqW.setText(r.j.goto_pb_floor);
        this.aqW.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize24));
        ar.b(this.aqW, r.d.cp_cont_g, 1, 0);
        this.aqW.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.aqW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(r.f.icon_see_arrow), (Drawable) null);
        this.aqW.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds20);
        this.aqW.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(r.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(r.e.ds20);
        layoutParams.addRule(1, this.aqV.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aqW.setOnClickListener(this);
        this.aqW.setMinHeight(getResources().getDimensionPixelSize(r.e.ds100));
        addView(this.aqW, layoutParams);
        this.aqW.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bd() {
        if (this.aqW != null) {
            boolean z = this.ara || this.arb;
            if (!this.apw && z && this.ard != null && this.ard.threadId > 0 && this.ard.postId > 0 && this.ard.mThreadType != 33) {
                this.aqW.setVisibility(0);
                if (this.arh != null) {
                    this.arh.setVisibility(0);
                    return;
                }
                return;
            }
            this.aqW.setVisibility(8);
            if (this.arh != null) {
                this.arh.setVisibility(8);
            }
        }
    }

    private void Be() {
        if (this.aqW != null) {
            this.aqW.setVisibility(8);
            if (this.arh != null) {
                this.arh.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bf() {
        if ((this.ara || this.arb) && this.ard != null && this.ard.mPicType == 1 && !TextUtils.isEmpty(this.ard.mTagName)) {
            if (this.aqX != null) {
                this.aqX.setVisibility(8);
                this.aqX = null;
            }
            this.aqX = new TextView(this.mContext);
            this.aqX.setText(this.ard.mTagName);
            this.aqX.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize26));
            ar.b(this.aqX, r.d.common_color_10013, 1, 0);
            ar.l(this.aqX, r.d.common_color_10215);
            this.aqX.setAlpha(0.75f);
            this.aqX.setIncludeFontPadding(false);
            this.aqX.setGravity(17);
            int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2);
            this.aqX.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aqU.getBottomOffset();
            layoutParams.leftMargin = this.aqU.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aqX, layoutParams);
            this.aqX.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.apw = z;
        if (this.apw) {
            Be();
        } else {
            Bd();
        }
    }

    public void q(String str, boolean z) {
        this.aqU.setTag(str);
        this.aqU.setLoadBigImage(false);
        this.aqU.setImageDrawable(null);
        this.ara = false;
        this.arb = false;
        boolean eR = eR(str);
        this.are = bs(true);
        if (!this.are) {
            r(str, eR);
        }
        if (eR) {
            s(str, z);
        }
    }

    private boolean bp(boolean z) {
        if (!this.arf || z) {
            this.arf = true;
            if (!this.are || this.ard == null || StringUtils.isNull(this.ard.originalUrl, true) || this.ard.originalSize < 0 || this.aqY.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dF = ax.dF(this.ard.originalUrl);
            this.aqY.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.uf()) + au.vg().dy(dF) + "/" + dF));
            this.aqY.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bg() {
        bp(false);
    }

    private boolean eR(String str) {
        return com.baidu.adp.lib.util.i.gm() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dT(str);
    }

    private void r(String str, boolean z) {
        if (this.ard == null) {
            bq(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dT(str)) {
            bq(z);
        } else if (!TextUtils.isEmpty(this.ard.imageUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.ard.imageUrl, this.ard.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bq(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.aqU.GR();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eS(str)) {
            if (z2 || (!this.arc && !this.arb)) {
                if (!z2 || !bp(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.arc = true;
                    com.baidu.adp.lib.g.c.eA().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.aqU.getImageData(), Boolean.valueOf(this.aoD));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.vj, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.ari.a(imageFileInfo, false);
        if (a2 != null) {
            this.arb = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.ari.a(imageFileInfo, new ab(this), false);
    }

    private boolean eS(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.aqZ != null) {
                this.aqZ.i(aVar.getUrl(), aVar.ka());
            }
            Bitmap jV = aVar.jV();
            if (jV == null) {
                if (!this.ara) {
                    this.aqU.GR();
                    return;
                }
                this.arb = false;
                r(null, false);
                return;
            }
            if (aVar.cY()) {
                this.aqU.a(aVar.ka(), jV);
                this.aqU.invalidate();
                this.aqU.play();
                this.arg = false;
                this.aqV.setVisibility(8);
            } else {
                this.aqU.setImageBitmap(jV);
                this.aqU.setImageData(aVar.ka());
                if (this.arg) {
                    this.aqV.setVisibility(0);
                }
            }
            Bd();
            Bf();
            this.aqU.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aqU.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aqU != null) {
            this.aqU.onDestroy();
        }
        if (this.aqY != null) {
            this.aqY.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aqU != null) {
            this.aqU.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bh() {
        if (this.aqU != null && this.aqU.getImageType() == 1) {
            this.aqU.stop();
        }
    }

    public void br(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.aqU != null && (str = (String) this.aqU.getTag()) != null) {
            if ((!eS(str) || com.baidu.adp.lib.util.i.gm()) && this.aqU != null) {
                if (this.aqU.getImageType() == 1) {
                    if (this.aqU.getGifCache() == null || !this.aqU.GY()) {
                        e(str, z, z2);
                    }
                } else if (this.aqU.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.aqU.getImageBitmap() == null || !this.aqU.GY()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aqU != null) {
            return this.aqU.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ard = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aoD = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqV) {
            String dF = ax.dF(this.ard.originalUrl);
            if (this.ard.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Ct().y(dF, 13);
                this.ard.originalProcess = -1;
                if (this.ard.originalSize > 0) {
                    this.aqV.setText(String.valueOf(aqT) + "(" + av.G(this.ard.originalSize) + ")");
                } else {
                    this.aqV.setText(aqT);
                }
                this.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.aoF != null) {
                this.aoF.Bj();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eT(dF);
            } else if (!com.baidu.adp.lib.util.i.gm() || com.baidu.adp.lib.util.i.gn() || com.baidu.tbadk.core.sharedPref.b.tW().getBoolean("original_img_down_tip", false)) {
                eT(dF);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.cb(r.j.original_img_down_no_wifi_tip);
                aVar.a(r.j.alert_yes_button, new ac(this, aVar, dF));
                aVar.b(r.j.alert_no_button, new ad(this, aVar));
                aVar.b(C);
                aVar.tb();
            }
        } else if (view == this.aqW && this.ard != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ard.threadId), String.valueOf(this.ard.postId), this.ard.mIsSeeHost, this.ard.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eT(String str) {
        if (this.ard != null) {
            this.ard.originalProcess = 0;
        }
        this.aqV.setText("0%");
        this.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ard.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.uf()) + au.vg().dy(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Ct().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(boolean z) {
        if (this.ard != null && !StringUtils.isNull(this.ard.originalUrl, true) && this.ard.originalSize >= 0) {
            String dF = ax.dF(this.ard.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.uf()) + au.vg().dy(dF) + "/" + dF).exists()) {
                this.ard.originalProcess = 100;
                if (z) {
                    this.aqV.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ard.originalProcess < 0) {
                if (this.ard.originalSize > 0) {
                    this.aqV.setText(String.valueOf(aqT) + "(" + av.G(this.ard.originalSize) + ")");
                } else {
                    this.aqV.setText(aqT);
                }
                this.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aqV.setText(String.valueOf(this.ard.originalProcess) + "%");
                this.aqV.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
            }
            this.arg = true;
        } else {
            this.aqV.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aoF = bVar;
    }
}
