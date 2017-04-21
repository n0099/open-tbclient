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
    private static final String avM = TbadkCoreApplication.m9getInst().getString(w.l.original_img_look);
    private int BS;
    private boolean atw;
    private b aty;
    private boolean auo;
    protected com.baidu.tbadk.widget.a avN;
    protected TextView avO;
    protected TextView avP;
    protected TextView avQ;
    protected SubsamplingScaleImageView avR;
    private a avS;
    private boolean avT;
    private boolean avU;
    private boolean avV;
    private ImageUrlData avW;
    private boolean avX;
    private boolean avY;
    private boolean avZ;
    private TextView awa;
    private com.baidu.tbadk.img.b awb;
    private Runnable awc;
    private SubsamplingScaleImageView.OnImageEventListener awd;
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
            if (this.avO != null) {
                aq.j(this.avO, w.g.btn_percent_yuantu);
                aq.b(this.avO, w.e.cp_cont_g, 1, 0);
            }
            if (this.avP != null) {
                aq.k(this.avP, w.e.common_color_10022);
                aq.b(this.avP, w.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avN != null) {
            this.avN.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.avS = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.avN = null;
        this.mContext = null;
        this.avS = null;
        this.atw = false;
        this.avV = false;
        this.avX = false;
        this.avY = false;
        this.auo = false;
        this.avZ = false;
        this.awa = null;
        this.awc = new v(this);
        this.awd = new x(this);
        this.mContext = context;
        this.awb = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.avN;
    }

    public void setGifSetListener(a.d dVar) {
        this.avN.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.avN.setImageOnClickListener(onClickListener);
        this.avR.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avN.setImageOnLongClickListener(onLongClickListener);
        this.avR.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.avN.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.BS = com.baidu.adp.lib.util.k.af(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.mContext) - ((int) this.mContext.getResources().getDimension(w.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.avN = new com.baidu.tbadk.widget.a(this.mContext);
        this.avN.setLayoutParams(layoutParams);
        addView(this.avN);
        this.avR = new SubsamplingScaleImageView(this.mContext);
        this.avR.setMaxScale(50.0f);
        this.avR.setOnImageEventListener(this.awd);
        this.avR.setVisibility(4);
        addView(this.avR, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(w.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BN();
        this.avO = new TextView(this.mContext);
        aq.j(this.avO, w.g.btn_percent_yuantu);
        this.avO.setText(w.l.original_img_look);
        this.avO.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize28));
        aq.b(this.avO, w.e.cp_cont_g, 1, 0);
        this.avO.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avO.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.avO.setMinWidth(getResources().getDimensionPixelSize(w.f.ds220));
        this.avO.setMinHeight(getResources().getDimensionPixelSize(w.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(w.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.avO.setOnClickListener(this);
        this.avO.setVisibility(8);
        addView(this.avO, layoutParams3);
        BO();
    }

    private void BN() {
        this.awa = new TextView(this.mContext);
        this.awa.setBackgroundResource(w.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(w.f.ds180);
        layoutParams.addRule(12);
        addView(this.awa, layoutParams);
        this.awa.setVisibility(8);
    }

    private void BO() {
        this.avP = new TextView(this.mContext);
        aq.k(this.avP, w.e.common_color_10022);
        this.avP.setText(w.l.goto_pb_floor);
        this.avP.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize24));
        aq.b(this.avP, w.e.cp_cont_g, 1, 0);
        this.avP.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.avP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_see_arrow), (Drawable) null);
        this.avP.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avP.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(w.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(w.f.ds20);
        layoutParams.addRule(1, this.avO.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.avP.setOnClickListener(this);
        this.avP.setMinHeight(getResources().getDimensionPixelSize(w.f.ds100));
        addView(this.avP, layoutParams);
        this.avP.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP() {
        if (this.avP != null) {
            boolean z = this.avT || this.avU;
            if (!this.auo && z && this.avW != null && this.avW.threadId > 0 && this.avW.postId > 0 && this.avW.mThreadType != 33) {
                this.avP.setVisibility(0);
                if (this.awa != null) {
                    this.awa.setVisibility(0);
                    return;
                }
                return;
            }
            this.avP.setVisibility(8);
            if (this.awa != null) {
                this.awa.setVisibility(8);
            }
        }
    }

    private void BQ() {
        if (this.avP != null) {
            this.avP.setVisibility(8);
            if (this.awa != null) {
                this.awa.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR() {
        if ((this.avT || this.avU) && this.avW != null && this.avW.mPicType == 1 && !TextUtils.isEmpty(this.avW.mTagName)) {
            if (this.avQ != null) {
                this.avQ.setVisibility(8);
                this.avQ = null;
            }
            this.avQ = new TextView(this.mContext);
            this.avQ.setText(this.avW.mTagName);
            this.avQ.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize26));
            aq.b(this.avQ, w.e.common_color_10013, 1, 0);
            aq.k(this.avQ, w.e.common_color_10215);
            this.avQ.setAlpha(0.75f);
            this.avQ.setIncludeFontPadding(false);
            this.avQ.setGravity(17);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            this.avQ.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.avN.getBottomOffset();
            layoutParams.leftMargin = this.avN.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.avQ, layoutParams);
            this.avQ.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.auo = z;
        if (this.auo) {
            BQ();
        } else {
            BP();
        }
    }

    public void q(String str, boolean z) {
        this.avN.setTag(str);
        this.avN.setLoadBigImage(false);
        this.avN.setImageDrawable(null);
        this.avT = false;
        this.avU = false;
        boolean eJ = eJ(str);
        this.avX = bt(true);
        if (!this.avX) {
            r(str, eJ);
        }
        if (eJ) {
            s(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.avY || z) {
            this.avY = true;
            if (!this.avX || this.avW == null || StringUtils.isNull(this.avW.originalUrl, true) || this.avW.originalSize < 0 || this.avR.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dD = aw.dD(this.avW.originalUrl);
            this.avR.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.l.uU()) + at.vU().dv(dD) + "/" + dD));
            this.avR.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BS() {
        bq(false);
    }

    private boolean eJ(String str) {
        return com.baidu.adp.lib.util.i.hk() || com.baidu.tbadk.core.util.c.c.dR(str);
    }

    private void r(String str, boolean z) {
        if (this.avW == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.dR(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.avW.imageUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.avW.imageUrl, this.avW.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            br(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.avN.HH();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eK(str)) {
            if (z2 || (!this.avV && !this.avU)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.avV = true;
                    com.baidu.adp.lib.f.c.fM().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.avN.getImageData(), Boolean.valueOf(this.atw));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.M(this.BS, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.awb.a(imageFileInfo, false);
        if (a2 != null) {
            this.avU = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.awb.a(imageFileInfo, new ab(this), false);
    }

    private boolean eK(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.avS != null) {
                this.avS.i(aVar.getUrl(), aVar.kX());
            }
            Bitmap kS = aVar.kS();
            if (kS == null) {
                if (!this.avT) {
                    this.avN.HH();
                    return;
                }
                this.avU = false;
                r(null, false);
                return;
            }
            if (aVar.ef()) {
                this.avN.a(aVar.kX(), kS);
                this.avN.invalidate();
                this.avN.play();
                this.avZ = false;
                this.avO.setVisibility(8);
            } else {
                this.avN.setImageBitmap(kS);
                this.avN.setImageData(aVar.kX());
                if (this.avZ) {
                    this.avO.setVisibility(0);
                }
            }
            BP();
            BR();
            this.avN.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.avN.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.avN != null) {
            this.avN.onDestroy();
        }
        if (this.avR != null) {
            this.avR.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.avN != null) {
            this.avN.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BT() {
        if (this.avN != null && this.avN.getImageType() == 1) {
            this.avN.stop();
        }
    }

    public void bs(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.avN != null && (str = (String) this.avN.getTag()) != null) {
            if ((!eK(str) || com.baidu.adp.lib.util.i.hk()) && this.avN != null) {
                if (this.avN.getImageType() == 1) {
                    if (this.avN.getGifCache() == null || !this.avN.HO()) {
                        e(str, z, z2);
                    }
                } else if (this.avN.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.avN.getImageBitmap() == null || !this.avN.HO()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.avN != null) {
            return this.avN.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.avW = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.atw = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.avO) {
            String dD = aw.dD(this.avW.originalUrl);
            if (this.avW.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Df().x(dD, 13);
                this.avW.originalProcess = -1;
                if (this.avW.originalSize > 0) {
                    this.avO.setText(String.valueOf(avM) + "(" + au.E(this.avW.originalSize) + ")");
                } else {
                    this.avO.setText(avM);
                }
                this.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.aty != null) {
                this.aty.BV();
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.mContext);
            if (Z == null) {
                eL(dD);
            } else if (!com.baidu.adp.lib.util.i.hk() || com.baidu.adp.lib.util.i.hl() || com.baidu.tbadk.core.sharedPref.b.uL().getBoolean("original_img_down_tip", false)) {
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
        } else if (view == this.avP && this.avW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.avW.threadId), String.valueOf(this.avW.postId), this.avW.mIsSeeHost, this.avW.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(String str) {
        if (this.avW != null) {
            this.avW.originalProcess = 0;
        }
        this.avO.setText("0%");
        this.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.avW.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.l.uU()) + at.vU().dv(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Df().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.avW != null && !StringUtils.isNull(this.avW.originalUrl, true) && this.avW.originalSize >= 0) {
            String dD = aw.dD(this.avW.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.l.uU()) + at.vU().dv(dD) + "/" + dD).exists()) {
                this.avW.originalProcess = 100;
                if (z) {
                    this.avO.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.avW.originalProcess < 0) {
                if (this.avW.originalSize > 0) {
                    this.avO.setText(String.valueOf(avM) + "(" + au.E(this.avW.originalSize) + ")");
                } else {
                    this.avO.setText(avM);
                }
                this.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.avO.setText(String.valueOf(this.avW.originalProcess) + "%");
                this.avO.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
            }
            this.avZ = true;
        } else {
            this.avO.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aty = bVar;
    }
}
