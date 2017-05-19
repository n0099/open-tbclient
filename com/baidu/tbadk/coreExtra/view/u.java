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
import com.baidu.tbadk.widget.b;
import com.baidu.tieba.w;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String avQ = TbadkCoreApplication.m9getInst().getString(w.l.original_img_look);
    private int BS;
    private boolean atA;
    private b atC;
    private boolean aus;
    protected com.baidu.tbadk.widget.b avR;
    protected TextView avS;
    protected TextView avT;
    protected TextView avU;
    protected SubsamplingScaleImageView avV;
    private a avW;
    private boolean avX;
    private boolean avY;
    private boolean avZ;
    private ImageUrlData awa;
    private boolean awb;
    private boolean awc;
    private boolean awd;
    private TextView awe;
    private com.baidu.tbadk.img.b awf;
    private Runnable awg;
    private SubsamplingScaleImageView.OnImageEventListener awh;
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
        void Bg();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.avS != null) {
                aq.j(this.avS, w.g.btn_percent_yuantu);
                aq.b(this.avS, w.e.cp_cont_g, 1, 0);
            }
            if (this.avT != null) {
                aq.k(this.avT, w.e.common_color_10022);
                aq.b(this.avT, w.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avR != null) {
            this.avR.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.avW = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.avR = null;
        this.mContext = null;
        this.avW = null;
        this.atA = false;
        this.avZ = false;
        this.awb = false;
        this.awc = false;
        this.aus = false;
        this.awd = false;
        this.awe = null;
        this.awg = new v(this);
        this.awh = new x(this);
        this.mContext = context;
        this.awf = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.b getImageView() {
        return this.avR;
    }

    public void setGifSetListener(b.d dVar) {
        this.avR.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.avR.setImageOnClickListener(onClickListener);
        this.avV.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avR.setImageOnLongClickListener(onLongClickListener);
        this.avV.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(b.e eVar) {
        this.avR.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.BS = com.baidu.adp.lib.util.k.af(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.mContext) - ((int) this.mContext.getResources().getDimension(w.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.avR = new com.baidu.tbadk.widget.b(this.mContext);
        this.avR.setLayoutParams(layoutParams);
        addView(this.avR);
        this.avV = new SubsamplingScaleImageView(this.mContext);
        this.avV.setMaxScale(50.0f);
        this.avV.setOnImageEventListener(this.awh);
        this.avV.setVisibility(4);
        addView(this.avV, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(w.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        AY();
        this.avS = new TextView(this.mContext);
        aq.j(this.avS, w.g.btn_percent_yuantu);
        this.avS.setText(w.l.original_img_look);
        this.avS.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize28));
        aq.b(this.avS, w.e.cp_cont_g, 1, 0);
        this.avS.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avS.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.avS.setMinWidth(getResources().getDimensionPixelSize(w.f.ds220));
        this.avS.setMinHeight(getResources().getDimensionPixelSize(w.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(w.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.avS.setOnClickListener(this);
        this.avS.setVisibility(8);
        addView(this.avS, layoutParams3);
        AZ();
    }

    private void AY() {
        this.awe = new TextView(this.mContext);
        this.awe.setBackgroundResource(w.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(w.f.ds180);
        layoutParams.addRule(12);
        addView(this.awe, layoutParams);
        this.awe.setVisibility(8);
    }

    private void AZ() {
        this.avT = new TextView(this.mContext);
        aq.k(this.avT, w.e.common_color_10022);
        this.avT.setText(w.l.goto_pb_floor);
        this.avT.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize24));
        aq.b(this.avT, w.e.cp_cont_g, 1, 0);
        this.avT.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.avT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_see_arrow), (Drawable) null);
        this.avT.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avT.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(w.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(w.f.ds20);
        layoutParams.addRule(1, this.avS.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.avT.setOnClickListener(this);
        this.avT.setMinHeight(getResources().getDimensionPixelSize(w.f.ds100));
        addView(this.avT, layoutParams);
        this.avT.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        if (this.avT != null) {
            boolean z = this.avX || this.avY;
            if (!this.aus && z && this.awa != null && this.awa.threadId > 0 && this.awa.postId > 0 && this.awa.mThreadType != 33) {
                this.avT.setVisibility(0);
                if (this.awe != null) {
                    this.awe.setVisibility(0);
                    return;
                }
                return;
            }
            this.avT.setVisibility(8);
            if (this.awe != null) {
                this.awe.setVisibility(8);
            }
        }
    }

    private void Bb() {
        if (this.avT != null) {
            this.avT.setVisibility(8);
            if (this.awe != null) {
                this.awe.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bc() {
        if ((this.avX || this.avY) && this.awa != null && this.awa.mPicType == 1 && !TextUtils.isEmpty(this.awa.mTagName)) {
            if (this.avU != null) {
                this.avU.setVisibility(8);
                this.avU = null;
            }
            this.avU = new TextView(this.mContext);
            this.avU.setText(this.awa.mTagName);
            this.avU.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize26));
            aq.b(this.avU, w.e.common_color_10013, 1, 0);
            aq.k(this.avU, w.e.common_color_10215);
            this.avU.setAlpha(0.75f);
            this.avU.setIncludeFontPadding(false);
            this.avU.setGravity(17);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            this.avU.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.avR.getBottomOffset();
            layoutParams.leftMargin = this.avR.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.avU, layoutParams);
            this.avU.setVisibility(0);
        }
    }

    public void bo(boolean z) {
        this.aus = z;
        if (this.aus) {
            Bb();
        } else {
            Ba();
        }
    }

    public void q(String str, boolean z) {
        this.avR.setTag(str);
        this.avR.setLoadBigImage(false);
        this.avR.setImageDrawable(null);
        this.avX = false;
        this.avY = false;
        boolean eI = eI(str);
        this.awb = bt(true);
        if (!this.awb) {
            r(str, eI);
        }
        if (eI) {
            s(str, z);
        }
    }

    private boolean bq(boolean z) {
        if (!this.awc || z) {
            this.awc = true;
            if (!this.awb || this.awa == null || StringUtils.isNull(this.awa.originalUrl, true) || this.awa.originalSize < 0 || this.avV.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dB = aw.dB(this.awa.originalUrl);
            this.avV.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.l.ug()) + at.vi().dt(dB) + "/" + dB));
            this.avV.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bd() {
        bq(false);
    }

    private boolean eI(String str) {
        return com.baidu.adp.lib.util.i.hk() || com.baidu.tbadk.core.util.c.c.dP(str);
    }

    private void r(String str, boolean z) {
        if (this.awa == null) {
            br(z);
        } else if (com.baidu.tbadk.core.util.c.c.dP(str)) {
            br(z);
        } else if (!TextUtils.isEmpty(this.awa.imageUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.awa.imageUrl, this.awa.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            br(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void br(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.avR.GS();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eJ(str)) {
            if (z2 || (!this.avZ && !this.avY)) {
                if (!z2 || !bq(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.avZ = true;
                    com.baidu.adp.lib.f.c.fM().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.avR.getImageData(), Boolean.valueOf(this.atA));
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
        com.baidu.adp.widget.a.a a2 = this.awf.a(imageFileInfo, false);
        if (a2 != null) {
            this.avY = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.awf.a(imageFileInfo, new ab(this), false);
    }

    private boolean eJ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.avW != null) {
                this.avW.i(aVar.getUrl(), aVar.kW());
            }
            Bitmap kR = aVar.kR();
            if (kR == null) {
                if (!this.avX) {
                    this.avR.GS();
                    return;
                }
                this.avY = false;
                r(null, false);
                return;
            }
            if (aVar.ef()) {
                this.avR.a(aVar.kW(), kR);
                this.avR.invalidate();
                this.avR.play();
                this.awd = false;
                this.avS.setVisibility(8);
            } else {
                this.avR.setImageBitmap(kR);
                this.avR.setImageData(aVar.kW());
                if (this.awd) {
                    this.avS.setVisibility(0);
                }
            }
            Ba();
            Bc();
            this.avR.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.avR.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.avR != null) {
            this.avR.onDestroy();
        }
        if (this.avV != null) {
            this.avV.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.avR != null) {
            this.avR.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Be() {
        if (this.avR != null && this.avR.getImageType() == 1) {
            this.avR.stop();
        }
    }

    public void bs(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.avR != null && (str = (String) this.avR.getTag()) != null) {
            if ((!eJ(str) || com.baidu.adp.lib.util.i.hk()) && this.avR != null) {
                if (this.avR.getImageType() == 1) {
                    if (this.avR.getGifCache() == null || !this.avR.GZ()) {
                        e(str, z, z2);
                    }
                } else if (this.avR.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.avR.getImageBitmap() == null || !this.avR.GZ()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.avR != null) {
            return this.avR.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.awa = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.atA = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.avS) {
            String dB = aw.dB(this.awa.originalUrl);
            if (this.awa.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Ck().x(dB, 13);
                this.awa.originalProcess = -1;
                if (this.awa.originalSize > 0) {
                    this.avS.setText(String.valueOf(avQ) + "(" + au.F(this.awa.originalSize) + ")");
                } else {
                    this.avS.setText(avQ);
                }
                this.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.atC != null) {
                this.atC.Bg();
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.mContext);
            if (Z == null) {
                eK(dB);
            } else if (!com.baidu.adp.lib.util.i.hk() || com.baidu.adp.lib.util.i.hl() || com.baidu.tbadk.core.sharedPref.b.tX().getBoolean("original_img_down_tip", false)) {
                eK(dB);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Z.getPageActivity());
                aVar.bX(w.l.original_img_down_no_wifi_tip);
                aVar.a(w.l.alert_yes_button, new ac(this, aVar, dB));
                aVar.b(w.l.alert_no_button, new ad(this, aVar));
                aVar.b(Z);
                aVar.td();
            }
        } else if (view == this.avT && this.awa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.awa.threadId), String.valueOf(this.awa.postId), this.awa.mIsSeeHost, this.awa.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(String str) {
        if (this.awa != null) {
            this.awa.originalProcess = 0;
        }
        this.avS.setText("0%");
        this.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.awa.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.l.ug()) + at.vi().dt(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Ck().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bt(boolean z) {
        if (this.awa != null && !StringUtils.isNull(this.awa.originalUrl, true) && this.awa.originalSize >= 0) {
            String dB = aw.dB(this.awa.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.l.ug()) + at.vi().dt(dB) + "/" + dB).exists()) {
                this.awa.originalProcess = 100;
                if (z) {
                    this.avS.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.awa.originalProcess < 0) {
                if (this.awa.originalSize > 0) {
                    this.avS.setText(String.valueOf(avQ) + "(" + au.F(this.awa.originalSize) + ")");
                } else {
                    this.avS.setText(avQ);
                }
                this.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.avS.setText(String.valueOf(this.awa.originalProcess) + "%");
                this.avS.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
            }
            this.awd = true;
        } else {
            this.avS.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.atC = bVar;
    }
}
