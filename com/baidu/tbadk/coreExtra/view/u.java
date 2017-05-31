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
    private static final String avA = TbadkCoreApplication.m9getInst().getString(w.l.original_img_look);
    private int BS;
    private boolean atk;
    private b atm;
    private boolean auc;
    protected com.baidu.tbadk.widget.b avB;
    protected TextView avC;
    protected TextView avD;
    protected TextView avE;
    protected SubsamplingScaleImageView avF;
    private a avG;
    private boolean avH;
    private boolean avI;
    private boolean avJ;
    private ImageUrlData avK;
    private boolean avL;
    private boolean avM;
    private boolean avN;
    private TextView avO;
    private com.baidu.tbadk.img.b avP;
    private Runnable avQ;
    private SubsamplingScaleImageView.OnImageEventListener avR;
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
        void AZ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.avC != null) {
                aq.j(this.avC, w.g.btn_percent_yuantu);
                aq.b(this.avC, w.e.cp_cont_g, 1, 0);
            }
            if (this.avD != null) {
                aq.k(this.avD, w.e.common_color_10022);
                aq.b(this.avD, w.e.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.avB != null) {
            this.avB.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.avG = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.avB = null;
        this.mContext = null;
        this.avG = null;
        this.atk = false;
        this.avJ = false;
        this.avL = false;
        this.avM = false;
        this.auc = false;
        this.avN = false;
        this.avO = null;
        this.avQ = new v(this);
        this.avR = new x(this);
        this.mContext = context;
        this.avP = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.b getImageView() {
        return this.avB;
    }

    public void setGifSetListener(b.d dVar) {
        this.avB.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.avB.setImageOnClickListener(onClickListener);
        this.avF.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.avB.setImageOnLongClickListener(onLongClickListener);
        this.avF.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(b.e eVar) {
        this.avB.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.BS = com.baidu.adp.lib.util.k.af(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.ag(this.mContext) - ((int) this.mContext.getResources().getDimension(w.f.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.avB = new com.baidu.tbadk.widget.b(this.mContext);
        this.avB.setLayoutParams(layoutParams);
        addView(this.avB);
        this.avF = new SubsamplingScaleImageView(this.mContext);
        this.avF.setMaxScale(50.0f);
        this.avF.setOnImageEventListener(this.avR);
        this.avF.setVisibility(4);
        addView(this.avF, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(getResources().getDrawable(w.g.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        AR();
        this.avC = new TextView(this.mContext);
        aq.j(this.avC, w.g.btn_percent_yuantu);
        this.avC.setText(w.l.original_img_look);
        this.avC.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize28));
        aq.b(this.avC, w.e.cp_cont_g, 1, 0);
        this.avC.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avC.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.avC.setMinWidth(getResources().getDimensionPixelSize(w.f.ds220));
        this.avC.setMinHeight(getResources().getDimensionPixelSize(w.f.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(w.f.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.avC.setOnClickListener(this);
        this.avC.setVisibility(8);
        addView(this.avC, layoutParams3);
        AS();
    }

    private void AR() {
        this.avO = new TextView(this.mContext);
        this.avO.setBackgroundResource(w.g.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(w.f.ds180);
        layoutParams.addRule(12);
        addView(this.avO, layoutParams);
        this.avO.setVisibility(8);
    }

    private void AS() {
        this.avD = new TextView(this.mContext);
        aq.k(this.avD, w.e.common_color_10022);
        this.avD.setText(w.l.goto_pb_floor);
        this.avD.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize24));
        aq.b(this.avD, w.e.cp_cont_g, 1, 0);
        this.avD.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.avD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aq.getDrawable(w.g.icon_see_arrow), (Drawable) null);
        this.avD.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds20);
        this.avD.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(w.f.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(w.f.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(w.f.ds20);
        layoutParams.addRule(1, this.avC.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.avD.setOnClickListener(this);
        this.avD.setMinHeight(getResources().getDimensionPixelSize(w.f.ds100));
        addView(this.avD, layoutParams);
        this.avD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AT() {
        if (this.avD != null) {
            boolean z = this.avH || this.avI;
            if (!this.auc && z && this.avK != null && this.avK.threadId > 0 && this.avK.postId > 0 && this.avK.mThreadType != 33) {
                this.avD.setVisibility(0);
                if (this.avO != null) {
                    this.avO.setVisibility(0);
                    return;
                }
                return;
            }
            this.avD.setVisibility(8);
            if (this.avO != null) {
                this.avO.setVisibility(8);
            }
        }
    }

    private void AU() {
        if (this.avD != null) {
            this.avD.setVisibility(8);
            if (this.avO != null) {
                this.avO.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV() {
        if ((this.avH || this.avI) && this.avK != null && this.avK.mPicType == 1 && !TextUtils.isEmpty(this.avK.mTagName)) {
            if (this.avE != null) {
                this.avE.setVisibility(8);
                this.avE = null;
            }
            this.avE = new TextView(this.mContext);
            this.avE.setText(this.avK.mTagName);
            this.avE.setTextSize(0, getResources().getDimensionPixelSize(w.f.fontsize26));
            aq.b(this.avE, w.e.common_color_10013, 1, 0);
            aq.k(this.avE, w.e.common_color_10215);
            this.avE.setAlpha(0.75f);
            this.avE.setIncludeFontPadding(false);
            this.avE.setGravity(17);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds2);
            this.avE.setPadding(g, g, g, g);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.avB.getBottomOffset();
            layoutParams.leftMargin = this.avB.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.avE, layoutParams);
            this.avE.setVisibility(0);
        }
    }

    public void bl(boolean z) {
        this.auc = z;
        if (this.auc) {
            AU();
        } else {
            AT();
        }
    }

    public void n(String str, boolean z) {
        this.avB.setTag(str);
        this.avB.setLoadBigImage(false);
        this.avB.setImageDrawable(null);
        this.avH = false;
        this.avI = false;
        boolean eG = eG(str);
        this.avL = bq(true);
        if (!this.avL) {
            o(str, eG);
        }
        if (eG) {
            p(str, z);
        }
    }

    private boolean bn(boolean z) {
        if (!this.avM || z) {
            this.avM = true;
            if (!this.avL || this.avK == null || StringUtils.isNull(this.avK.originalUrl, true) || this.avK.originalSize < 0 || this.avF.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dy = aw.dy(this.avK.originalUrl);
            this.avF.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.l.uc()) + at.vf().dq(dy) + "/" + dy));
            this.avF.setVisibility(0);
            return true;
        }
        return false;
    }

    public void AW() {
        bn(false);
    }

    private boolean eG(String str) {
        return com.baidu.adp.lib.util.i.hk() || com.baidu.tbadk.core.util.c.c.dM(str);
    }

    private void o(String str, boolean z) {
        if (this.avK == null) {
            bo(z);
        } else if (com.baidu.tbadk.core.util.c.c.dM(str)) {
            bo(z);
        } else if (!TextUtils.isEmpty(this.avK.imageUrl)) {
            com.baidu.adp.lib.f.c.fM().a(this.avK.imageUrl, this.avK.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bo(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bo(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.avB.GM();
        }
    }

    private void p(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eH(str)) {
            if (z2 || (!this.avJ && !this.avI)) {
                if (!z2 || !bn(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.avJ = true;
                    com.baidu.adp.lib.f.c.fM().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.avB.getImageData(), Boolean.valueOf(this.atk));
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
        com.baidu.adp.widget.a.a a2 = this.avP.a(imageFileInfo, false);
        if (a2 != null) {
            this.avI = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.avP.a(imageFileInfo, new ab(this), false);
    }

    private boolean eH(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.avG != null) {
                this.avG.i(aVar.getUrl(), aVar.kW());
            }
            Bitmap kR = aVar.kR();
            if (kR == null) {
                if (!this.avH) {
                    this.avB.GM();
                    return;
                }
                this.avI = false;
                o(null, false);
                return;
            }
            if (aVar.ef()) {
                this.avB.a(aVar.kW(), kR);
                this.avB.invalidate();
                this.avB.play();
                this.avN = false;
                this.avC.setVisibility(8);
            } else {
                this.avB.setImageBitmap(kR);
                this.avB.setImageData(aVar.kW());
                if (this.avN) {
                    this.avC.setVisibility(0);
                }
            }
            AT();
            AV();
            this.avB.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.avB.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.avB != null) {
            this.avB.onDestroy();
        }
        if (this.avF != null) {
            this.avF.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.avB != null) {
            this.avB.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void AX() {
        if (this.avB != null && this.avB.getImageType() == 1) {
            this.avB.stop();
        }
    }

    public void bp(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.avB != null && (str = (String) this.avB.getTag()) != null) {
            if ((!eH(str) || com.baidu.adp.lib.util.i.hk()) && this.avB != null) {
                if (this.avB.getImageType() == 1) {
                    if (this.avB.getGifCache() == null || !this.avB.GT()) {
                        e(str, z, z2);
                    }
                } else if (this.avB.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.avB.getImageBitmap() == null || !this.avB.GT()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.avB != null) {
            return this.avB.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.avK = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.atk = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.avC) {
            String dy = aw.dy(this.avK.originalUrl);
            if (this.avK.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Ce().w(dy, 13);
                this.avK.originalProcess = -1;
                if (this.avK.originalSize > 0) {
                    this.avC.setText(String.valueOf(avA) + "(" + au.F(this.avK.originalSize) + ")");
                } else {
                    this.avC.setText(avA);
                }
                this.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.atm != null) {
                this.atm.AZ();
            }
            com.baidu.adp.base.g<?> Z = com.baidu.adp.base.k.Z(this.mContext);
            if (Z == null) {
                eI(dy);
            } else if (!com.baidu.adp.lib.util.i.hk() || com.baidu.adp.lib.util.i.hl() || com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("original_img_down_tip", false)) {
                eI(dy);
            } else {
                com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(Z.getPageActivity());
                aVar.bY(w.l.original_img_down_no_wifi_tip);
                aVar.a(w.l.alert_yes_button, new ac(this, aVar, dy));
                aVar.b(w.l.alert_no_button, new ad(this, aVar));
                aVar.b(Z);
                aVar.tc();
            }
        } else if (view == this.avD && this.avK != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.avK.threadId), String.valueOf(this.avK.postId), this.avK.mIsSeeHost, this.avK.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str) {
        if (this.avK != null) {
            this.avK.originalProcess = 0;
        }
        this.avC.setText("0%");
        this.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.avK.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.l.uc()) + at.vf().dq(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Ce().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bq(boolean z) {
        if (this.avK != null && !StringUtils.isNull(this.avK.originalUrl, true) && this.avK.originalSize >= 0) {
            String dy = aw.dy(this.avK.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.l.uc()) + at.vf().dq(dy) + "/" + dy).exists()) {
                this.avK.originalProcess = 100;
                if (z) {
                    this.avC.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.avK.originalProcess < 0) {
                if (this.avK.originalSize > 0) {
                    this.avC.setText(String.valueOf(avA) + "(" + au.F(this.avK.originalSize) + ")");
                } else {
                    this.avC.setText(avA);
                }
                this.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.avC.setText(String.valueOf(this.avK.originalProcess) + "%");
                this.avC.setCompoundDrawablesWithIntrinsicBounds(0, 0, w.g.icon_close_yuantu, 0);
            }
            this.avN = true;
        } else {
            this.avC.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.atm = bVar;
    }
}
