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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String apZ = TbadkCoreApplication.m9getInst().getString(r.l.original_img_look);
    private boolean anJ;
    private b anL;
    private boolean aoB;
    protected com.baidu.tbadk.widget.a aqa;
    protected TextView aqb;
    protected TextView aqc;
    protected TextView aqd;
    protected SubsamplingScaleImageView aqe;
    private a aqf;
    private boolean aqg;
    private boolean aqh;
    private boolean aqi;
    private ImageUrlData aqj;
    private boolean aqk;
    private boolean aql;
    private boolean aqm;
    private TextView aqn;
    private com.baidu.tbadk.img.b aqo;
    private Runnable aqp;
    private SubsamplingScaleImageView.OnImageEventListener aqq;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int va;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Be();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aqb != null) {
                ap.j((View) this.aqb, r.g.btn_percent_yuantu);
                ap.b(this.aqb, r.e.cp_cont_g, 1, 0);
            }
            if (this.aqc != null) {
                ap.k(this.aqc, r.e.common_color_10022);
                ap.b(this.aqc, r.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aqa != null) {
            this.aqa.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aqf = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aqa = null;
        this.mContext = null;
        this.aqf = null;
        this.anJ = false;
        this.aqi = false;
        this.aqk = false;
        this.aql = false;
        this.aoB = false;
        this.aqm = false;
        this.aqn = null;
        this.aqp = new v(this);
        this.aqq = new x(this);
        this.mContext = context;
        this.aqo = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aqa;
    }

    public void setGifSetListener(a.d dVar) {
        this.aqa.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqa.setImageOnClickListener(onClickListener);
        this.aqe.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aqa.setImageOnLongClickListener(onLongClickListener);
        this.aqe.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.aqa.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.va = com.baidu.adp.lib.util.k.I(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.J(this.mContext) - ((int) this.mContext.getResources().getDimension(r.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aqa = new com.baidu.tbadk.widget.a(this.mContext);
        this.aqa.setLayoutParams(layoutParams);
        addView(this.aqa);
        this.aqe = new SubsamplingScaleImageView(this.mContext);
        this.aqe.setMaxScale(50.0f);
        this.aqe.setOnImageEventListener(this.aqq);
        this.aqe.setVisibility(4);
        addView(this.aqe, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(r.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        AW();
        this.aqb = new TextView(this.mContext);
        ap.j((View) this.aqb, r.g.btn_percent_yuantu);
        this.aqb.setText(r.l.original_img_look);
        this.aqb.setTextSize(0, getResources().getDimensionPixelSize(r.f.fontsize28));
        ap.b(this.aqb, r.e.cp_cont_g, 1, 0);
        this.aqb.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.f.ds20);
        this.aqb.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aqb.setMinWidth(getResources().getDimensionPixelSize(r.f.ds220));
        this.aqb.setMinHeight(getResources().getDimensionPixelSize(r.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(r.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.aqb.setOnClickListener(this);
        this.aqb.setVisibility(8);
        addView(this.aqb, layoutParams3);
        AX();
    }

    private void AW() {
        this.aqn = new TextView(this.mContext);
        this.aqn.setBackgroundResource(r.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(r.f.ds180);
        layoutParams.addRule(12);
        addView(this.aqn, layoutParams);
        this.aqn.setVisibility(8);
    }

    private void AX() {
        this.aqc = new TextView(this.mContext);
        ap.k(this.aqc, r.e.common_color_10022);
        this.aqc.setText(r.l.goto_pb_floor);
        this.aqc.setTextSize(0, getResources().getDimensionPixelSize(r.f.fontsize24));
        ap.b(this.aqc, r.e.cp_cont_g, 1, 0);
        this.aqc.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.aqc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(r.g.icon_see_arrow), (Drawable) null);
        this.aqc.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.f.ds20);
        this.aqc.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(r.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(r.f.ds20);
        layoutParams.addRule(1, this.aqb.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aqc.setOnClickListener(this);
        this.aqc.setMinHeight(getResources().getDimensionPixelSize(r.f.ds100));
        addView(this.aqc, layoutParams);
        this.aqc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AY() {
        if (this.aqc != null) {
            boolean z = this.aqg || this.aqh;
            if (!this.aoB && z && this.aqj != null && this.aqj.threadId > 0 && this.aqj.postId > 0 && this.aqj.mThreadType != 33) {
                this.aqc.setVisibility(0);
                if (this.aqn != null) {
                    this.aqn.setVisibility(0);
                    return;
                }
                return;
            }
            this.aqc.setVisibility(8);
            if (this.aqn != null) {
                this.aqn.setVisibility(8);
            }
        }
    }

    private void AZ() {
        if (this.aqc != null) {
            this.aqc.setVisibility(8);
            if (this.aqn != null) {
                this.aqn.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if ((this.aqg || this.aqh) && this.aqj != null && this.aqj.mPicType == 1 && !TextUtils.isEmpty(this.aqj.mTagName)) {
            if (this.aqd != null) {
                this.aqd.setVisibility(8);
                this.aqd = null;
            }
            this.aqd = new TextView(this.mContext);
            this.aqd.setText(this.aqj.mTagName);
            this.aqd.setTextSize(0, getResources().getDimensionPixelSize(r.f.fontsize26));
            ap.b(this.aqd, r.e.common_color_10013, 1, 0);
            ap.k(this.aqd, r.e.common_color_10215);
            this.aqd.setAlpha(0.75f);
            this.aqd.setIncludeFontPadding(false);
            this.aqd.setGravity(17);
            int e = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds2);
            this.aqd.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aqa.getBottomOffset();
            layoutParams.leftMargin = this.aqa.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aqd, layoutParams);
            this.aqd.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.aoB = z;
        if (this.aoB) {
            AZ();
        } else {
            AY();
        }
    }

    public void q(String str, boolean z) {
        this.aqa.setTag(str);
        this.aqa.setLoadBigImage(false);
        this.aqa.setImageDrawable(null);
        this.aqg = false;
        this.aqh = false;
        boolean eO = eO(str);
        this.aqk = bs(true);
        if (!this.aqk) {
            r(str, eO);
        }
        if (eO) {
            s(str, z);
        }
    }

    private boolean bp(boolean z) {
        if (!this.aql || z) {
            this.aql = true;
            if (!this.aqk || this.aqj == null || StringUtils.isNull(this.aqj.originalUrl, true) || this.aqj.originalSize < 0 || this.aqe.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dD = av.dD(this.aqj.originalUrl);
            this.aqe.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.l.tZ()) + as.va().dw(dD) + "/" + dD));
            this.aqe.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bb() {
        bp(false);
    }

    private boolean eO(String str) {
        return com.baidu.adp.lib.util.i.gk() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dR(str);
    }

    private void r(String str, boolean z) {
        if (this.aqj == null) {
            bq(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dR(str)) {
            bq(z);
        } else if (!TextUtils.isEmpty(this.aqj.imageUrl)) {
            com.baidu.adp.lib.f.c.ey().a(this.aqj.imageUrl, this.aqj.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bq(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.aqa.GJ();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eP(str)) {
            if (z2 || (!this.aqi && !this.aqh)) {
                if (!z2 || !bp(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.aqi = true;
                    com.baidu.adp.lib.f.c.ey().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.aqa.getImageData(), Boolean.valueOf(this.anJ));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.va, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.aqo.a(imageFileInfo, false);
        if (a2 != null) {
            this.aqh = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aqo.a(imageFileInfo, new ab(this), false);
    }

    private boolean eP(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.aqf != null) {
                this.aqf.i(aVar.getUrl(), aVar.jY());
            }
            Bitmap jT = aVar.jT();
            if (jT == null) {
                if (!this.aqg) {
                    this.aqa.GJ();
                    return;
                }
                this.aqh = false;
                r(null, false);
                return;
            }
            if (aVar.cW()) {
                this.aqa.a(aVar.jY(), jT);
                this.aqa.invalidate();
                this.aqa.play();
                this.aqm = false;
                this.aqb.setVisibility(8);
            } else {
                this.aqa.setImageBitmap(jT);
                this.aqa.setImageData(aVar.jY());
                if (this.aqm) {
                    this.aqb.setVisibility(0);
                }
            }
            AY();
            Ba();
            this.aqa.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aqa.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aqa != null) {
            this.aqa.onDestroy();
        }
        if (this.aqe != null) {
            this.aqe.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aqa != null) {
            this.aqa.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bc() {
        if (this.aqa != null && this.aqa.getImageType() == 1) {
            this.aqa.stop();
        }
    }

    public void br(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.aqa != null && (str = (String) this.aqa.getTag()) != null) {
            if ((!eP(str) || com.baidu.adp.lib.util.i.gk()) && this.aqa != null) {
                if (this.aqa.getImageType() == 1) {
                    if (this.aqa.getGifCache() == null || !this.aqa.GQ()) {
                        e(str, z, z2);
                    }
                } else if (this.aqa.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.aqa.getImageBitmap() == null || !this.aqa.GQ()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aqa != null) {
            return this.aqa.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aqj = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.anJ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqb) {
            String dD = av.dD(this.aqj.originalUrl);
            if (this.aqj.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Co().y(dD, 13);
                this.aqj.originalProcess = -1;
                if (this.aqj.originalSize > 0) {
                    this.aqb.setText(String.valueOf(apZ) + "(" + at.E(this.aqj.originalSize) + ")");
                } else {
                    this.aqb.setText(apZ);
                }
                this.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.anL != null) {
                this.anL.Be();
            }
            com.baidu.adp.base.g<?> C = com.baidu.adp.base.k.C(this.mContext);
            if (C == null) {
                eQ(dD);
            } else if (!com.baidu.adp.lib.util.i.gk() || com.baidu.adp.lib.util.i.gl() || com.baidu.tbadk.core.sharedPref.b.tQ().getBoolean("original_img_down_tip", false)) {
                eQ(dD);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.ca(r.l.original_img_down_no_wifi_tip);
                aVar.a(r.l.alert_yes_button, new ac(this, aVar, dD));
                aVar.b(r.l.alert_no_button, new ad(this, aVar));
                aVar.b(C);
                aVar.sV();
            }
        } else if (view == this.aqc && this.aqj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aqj.threadId), String.valueOf(this.aqj.postId), this.aqj.mIsSeeHost, this.aqj.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str) {
        if (this.aqj != null) {
            this.aqj.originalProcess = 0;
        }
        this.aqb.setText("0%");
        this.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aqj.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.l.tZ()) + as.va().dw(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Co().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(boolean z) {
        if (this.aqj != null && !StringUtils.isNull(this.aqj.originalUrl, true) && this.aqj.originalSize >= 0) {
            String dD = av.dD(this.aqj.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.l.tZ()) + as.va().dw(dD) + "/" + dD).exists()) {
                this.aqj.originalProcess = 100;
                if (z) {
                    this.aqb.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.aqj.originalProcess < 0) {
                if (this.aqj.originalSize > 0) {
                    this.aqb.setText(String.valueOf(apZ) + "(" + at.E(this.aqj.originalSize) + ")");
                } else {
                    this.aqb.setText(apZ);
                }
                this.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aqb.setText(String.valueOf(this.aqj.originalProcess) + "%");
                this.aqb.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.g.icon_close_yuantu, 0);
            }
            this.aqm = true;
        } else {
            this.aqb.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.anL = bVar;
    }
}
