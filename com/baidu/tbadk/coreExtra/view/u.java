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
    private static final String avK = TbadkCoreApplication.m9getInst().getString(w.l.original_img_look);
    private int BP;
    private boolean atu;
    private b atw;
    private boolean aum;
    protected com.baidu.tbadk.widget.a avL;
    protected TextView avM;
    protected TextView avN;
    protected TextView avO;
    protected SubsamplingScaleImageView avP;
    private a avQ;
    private boolean avR;
    private boolean avS;
    private boolean avT;
    private ImageUrlData avU;
    private boolean avV;
    private boolean avW;
    private boolean avX;
    private TextView avY;
    private com.baidu.tbadk.img.b avZ;
    private Runnable awa;
    private SubsamplingScaleImageView.OnImageEventListener awb;
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
        void BV();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.avM != null) {
                aq.j(this.avM, w.g.btn_percent_yuantu);
                aq.b(this.avM, w.e.cp_cont_g, 1, 0);
            }
            if (this.avN != null) {
                aq.k(this.avN, w.e.common_color_10022);
                aq.b(this.avN, w.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avL != null) {
            this.avL.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.avQ = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.avL = null;
        this.mContext = null;
        this.avQ = null;
        this.atu = false;
        this.avT = false;
        this.avV = false;
        this.avW = false;
        this.aum = false;
        this.avX = false;
        this.avY = null;
        this.awa = new v(this);
        this.awb = new x(this);
        this.mContext = context;
        this.avZ = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.avL;
    }

    public void setGifSetListener(a.d dVar) {
        this.avL.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.avL.setImageOnClickListener(onClickListener);
        this.avP.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avL.setImageOnLongClickListener(onLongClickListener);
        this.avP.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.avL.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.BP = com.baidu.adp.lib.util.k.af(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.mContext) - ((int) this.mContext.getResources().getDimension(w.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.avL = new com.baidu.tbadk.widget.a(this.mContext);
        this.avL.setLayoutParams(layoutParams);
        addView(this.avL);
        this.avP = new SubsamplingScaleImageView(this.mContext);
        this.avP.setMaxScale(50.0f);
        this.avP.setOnImageEventListener(this.awb);
        this.avP.setVisibility(4);
        addView(this.avP, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(w.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BN();
        this.avM = new TextView(this.mContext);
        aq.j(this.avM, w.g.btn_percent_yuantu);
        this.avM.setText(w.l.original_img_look);
        this.avM.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize28));
        aq.b(this.avM, w.e.cp_cont_g, 1, 0);
        this.avM.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avM.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.avM.setMinWidth(getResources().getDimensionPixelSize(w.f.ds220));
        this.avM.setMinHeight(getResources().getDimensionPixelSize(w.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(w.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.avM.setOnClickListener(this);
        this.avM.setVisibility(8);
        addView(this.avM, layoutParams3);
        BO();
    }

    private void BN() {
        this.avY = new TextView(this.mContext);
        this.avY.setBackgroundResource(w.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(w.f.ds180);
        layoutParams.addRule(12);
        addView(this.avY, layoutParams);
        this.avY.setVisibility(8);
    }

    private void BO() {
        this.avN = new TextView(this.mContext);
        aq.k(this.avN, w.e.common_color_10022);
        this.avN.setText(w.l.goto_pb_floor);
        this.avN.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize24));
        aq.b(this.avN, w.e.cp_cont_g, 1, 0);
        this.avN.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.avN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_see_arrow), (Drawable) null);
        this.avN.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avN.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(w.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(w.f.ds20);
        layoutParams.addRule(1, this.avM.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.avN.setOnClickListener(this);
        this.avN.setMinHeight(getResources().getDimensionPixelSize(w.f.ds100));
        addView(this.avN, layoutParams);
        this.avN.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP() {
        if (this.avN != null) {
            boolean z = this.avR || this.avS;
            if (!this.aum && z && this.avU != null && this.avU.threadId > 0 && this.avU.postId > 0 && this.avU.mThreadType != 33) {
                this.avN.setVisibility(0);
                if (this.avY != null) {
                    this.avY.setVisibility(0);
                    return;
                }
                return;
            }
            this.avN.setVisibility(8);
            if (this.avY != null) {
                this.avY.setVisibility(8);
            }
        }
    }

    private void BQ() {
        if (this.avN != null) {
            this.avN.setVisibility(8);
            if (this.avY != null) {
                this.avY.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR() {
        if ((this.avR || this.avS) && this.avU != null && this.avU.mPicType == 1 && !TextUtils.isEmpty(this.avU.mTagName)) {
            if (this.avO != null) {
                this.avO.setVisibility(8);
                this.avO = null;
            }
            this.avO = new TextView(this.mContext);
            this.avO.setText(this.avU.mTagName);
            this.avO.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize26));
            aq.b(this.avO, w.e.common_color_10013, 1, 0);
            aq.k(this.avO, w.e.common_color_10215);
            this.avO.setAlpha(0.75f);
            this.avO.setIncludeFontPadding(false);
            this.avO.setGravity(17);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            this.avO.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.avL.getBottomOffset();
            layoutParams.leftMargin = this.avL.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.avO, layoutParams);
            this.avO.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.aum = z;
        if (this.aum) {
            BQ();
        } else {
            BP();
        }
    }

    public void q(String str, boolean z) {
        this.avL.setTag(str);
        this.avL.setLoadBigImage(false);
        this.avL.setImageDrawable(null);
        this.avR = false;
        this.avS = false;
        boolean eJ = eJ(str);
        this.avV = bt(true);
        if (!this.avV) {
            r(str, eJ);
        }
        if (eJ) {
            s(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.avW || z) {
            this.avW = true;
            if (!this.avV || this.avU == null || StringUtils.isNull(this.avU.originalUrl, true) || this.avU.originalSize < 0 || this.avP.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dD = aw.dD(this.avU.originalUrl);
            this.avP.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.l.uU()) + at.vU().dv(dD) + "/" + dD));
            this.avP.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BS() {
        bq(false);
    }

    private boolean eJ(String str) {
        return com.baidu.adp.lib.util.i.hj() || com.baidu.tbadk.core.util.c.c.dR(str);
    }

    private void r(String str, boolean z) {
        if (this.avU == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.dR(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.avU.imageUrl)) {
            com.baidu.adp.lib.f.c.fL().a(this.avU.imageUrl, this.avU.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            br(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.avL.HH();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eK(str)) {
            if (z2 || (!this.avT && !this.avS)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.avT = true;
                    com.baidu.adp.lib.f.c.fL().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.avL.getImageData(), Boolean.valueOf(this.atu));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.BP, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.avZ.a(imageFileInfo, false);
        if (a2 != null) {
            this.avS = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.avZ.a(imageFileInfo, new ab(this), false);
    }

    private boolean eK(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.avQ != null) {
                this.avQ.i(aVar.getUrl(), aVar.kW());
            }
            Bitmap kR = aVar.kR();
            if (kR == null) {
                if (!this.avR) {
                    this.avL.HH();
                    return;
                }
                this.avS = false;
                r(null, false);
                return;
            }
            if (aVar.ee()) {
                this.avL.a(aVar.kW(), kR);
                this.avL.invalidate();
                this.avL.play();
                this.avX = false;
                this.avM.setVisibility(8);
            } else {
                this.avL.setImageBitmap(kR);
                this.avL.setImageData(aVar.kW());
                if (this.avX) {
                    this.avM.setVisibility(0);
                }
            }
            BP();
            BR();
            this.avL.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.avL.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.avL != null) {
            this.avL.onDestroy();
        }
        if (this.avP != null) {
            this.avP.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.avL != null) {
            this.avL.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BT() {
        if (this.avL != null && this.avL.getImageType() == 1) {
            this.avL.stop();
        }
    }

    public void bs(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.avL != null && (str = (String) this.avL.getTag()) != null) {
            if ((!eK(str) || com.baidu.adp.lib.util.i.hj()) && this.avL != null) {
                if (this.avL.getImageType() == 1) {
                    if (this.avL.getGifCache() == null || !this.avL.HO()) {
                        e(str, z, z2);
                    }
                } else if (this.avL.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.avL.getImageBitmap() == null || !this.avL.HO()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.avL != null) {
            return this.avL.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.avU = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.atu = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.avM) {
            String dD = aw.dD(this.avU.originalUrl);
            if (this.avU.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Df().w(dD, 13);
                this.avU.originalProcess = -1;
                if (this.avU.originalSize > 0) {
                    this.avM.setText(String.valueOf(avK) + "(" + au.E(this.avU.originalSize) + ")");
                } else {
                    this.avM.setText(avK);
                }
                this.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.atw != null) {
                this.atw.BV();
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.mContext);
            if (Z == null) {
                eL(dD);
            } else if (!com.baidu.adp.lib.util.i.hj() || com.baidu.adp.lib.util.i.hk() || com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("original_img_down_tip", false)) {
                eL(dD);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Z.getPageActivity());
                aVar.bZ(w.l.original_img_down_no_wifi_tip);
                aVar.a(w.l.alert_yes_button, new ac(this, aVar, dD));
                aVar.b(w.l.alert_no_button, new ad(this, aVar));
                aVar.b(Z);
                aVar.tQ();
            }
        } else if (view == this.avN && this.avU != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.avU.threadId), String.valueOf(this.avU.postId), this.avU.mIsSeeHost, this.avU.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(String str) {
        if (this.avU != null) {
            this.avU.originalProcess = 0;
        }
        this.avM.setText("0%");
        this.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.avU.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.l.uU()) + at.vU().dv(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Df().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.avU != null && !StringUtils.isNull(this.avU.originalUrl, true) && this.avU.originalSize >= 0) {
            String dD = aw.dD(this.avU.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.l.uU()) + at.vU().dv(dD) + "/" + dD).exists()) {
                this.avU.originalProcess = 100;
                if (z) {
                    this.avM.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.avU.originalProcess < 0) {
                if (this.avU.originalSize > 0) {
                    this.avM.setText(String.valueOf(avK) + "(" + au.E(this.avU.originalSize) + ")");
                } else {
                    this.avM.setText(avK);
                }
                this.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.avM.setText(String.valueOf(this.avU.originalProcess) + "%");
                this.avM.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
            }
            this.avX = true;
        } else {
            this.avM.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.atw = bVar;
    }
}
