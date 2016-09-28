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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String aqw = TbadkCoreApplication.m9getInst().getString(r.j.original_img_look);
    private boolean aoZ;
    private boolean aoh;
    private b aoj;
    protected TextView aqA;
    protected SubsamplingScaleImageView aqB;
    private a aqC;
    private boolean aqD;
    private boolean aqE;
    private boolean aqF;
    private ImageUrlData aqG;
    private boolean aqH;
    private boolean aqI;
    private boolean aqJ;
    private TextView aqK;
    private com.baidu.tbadk.img.b aqL;
    private Runnable aqM;
    private SubsamplingScaleImageView.OnImageEventListener aqN;
    protected com.baidu.tbadk.widget.a aqx;
    protected TextView aqy;
    protected TextView aqz;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int vi;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void Bp();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aqy != null) {
                av.k(this.aqy, r.f.btn_percent_yuantu);
                av.b(this.aqy, r.d.cp_cont_g, 1, 0);
            }
            if (this.aqz != null) {
                av.l(this.aqz, r.d.common_color_10022);
                av.b(this.aqz, r.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aqx != null) {
            this.aqx.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aqC = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aqx = null;
        this.mContext = null;
        this.aqC = null;
        this.aoh = false;
        this.aqF = false;
        this.aqH = false;
        this.aqI = false;
        this.aoZ = false;
        this.aqJ = false;
        this.aqK = null;
        this.aqM = new v(this);
        this.aqN = new x(this);
        this.mContext = context;
        this.aqL = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aqx;
    }

    public void setGifSetListener(a.d dVar) {
        this.aqx.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqx.setImageOnClickListener(onClickListener);
        this.aqB.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aqx.setImageOnLongClickListener(onLongClickListener);
        this.aqB.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.aqx.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.vi = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(r.e.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aqx = new com.baidu.tbadk.widget.a(this.mContext);
        this.aqx.setLayoutParams(layoutParams);
        addView(this.aqx);
        this.aqB = new SubsamplingScaleImageView(this.mContext);
        this.aqB.setMaxScale(50.0f);
        this.aqB.setOnImageEventListener(this.aqN);
        this.aqB.setVisibility(4);
        addView(this.aqB, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(r.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bh();
        this.aqy = new TextView(this.mContext);
        av.k(this.aqy, r.f.btn_percent_yuantu);
        this.aqy.setText(r.j.original_img_look);
        this.aqy.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize28));
        av.b(this.aqy, r.d.cp_cont_g, 1, 0);
        this.aqy.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds20);
        this.aqy.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aqy.setMinWidth(getResources().getDimensionPixelSize(r.e.ds220));
        this.aqy.setMinHeight(getResources().getDimensionPixelSize(r.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(r.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.aqy.setOnClickListener(this);
        this.aqy.setVisibility(8);
        addView(this.aqy, layoutParams3);
        Bi();
    }

    private void Bh() {
        this.aqK = new TextView(this.mContext);
        this.aqK.setBackgroundResource(r.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(r.e.ds180);
        layoutParams.addRule(12);
        addView(this.aqK, layoutParams);
        this.aqK.setVisibility(8);
    }

    private void Bi() {
        this.aqz = new TextView(this.mContext);
        av.l(this.aqz, r.d.common_color_10022);
        this.aqz.setText(r.j.goto_pb_floor);
        this.aqz.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize24));
        av.b(this.aqz, r.d.cp_cont_g, 1, 0);
        this.aqz.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.aqz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(r.f.icon_see_arrow), (Drawable) null);
        this.aqz.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds20);
        this.aqz.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(r.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(r.e.ds20);
        layoutParams.addRule(1, this.aqy.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aqz.setOnClickListener(this);
        this.aqz.setMinHeight(getResources().getDimensionPixelSize(r.e.ds100));
        addView(this.aqz, layoutParams);
        this.aqz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bj() {
        if (this.aqz != null) {
            boolean z = this.aqD || this.aqE;
            if (!this.aoZ && z && this.aqG != null && this.aqG.threadId > 0 && this.aqG.postId > 0 && this.aqG.mThreadType != 33) {
                this.aqz.setVisibility(0);
                if (this.aqK != null) {
                    this.aqK.setVisibility(0);
                    return;
                }
                return;
            }
            this.aqz.setVisibility(8);
            if (this.aqK != null) {
                this.aqK.setVisibility(8);
            }
        }
    }

    private void Bk() {
        if (this.aqz != null) {
            this.aqz.setVisibility(8);
            if (this.aqK != null) {
                this.aqK.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl() {
        if ((this.aqD || this.aqE) && this.aqG != null && this.aqG.mPicType == 1 && !TextUtils.isEmpty(this.aqG.mTagName)) {
            if (this.aqA != null) {
                this.aqA.setVisibility(8);
                this.aqA = null;
            }
            this.aqA = new TextView(this.mContext);
            this.aqA.setText(this.aqG.mTagName);
            this.aqA.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize26));
            av.b(this.aqA, r.d.common_color_10013, 1, 0);
            av.l(this.aqA, r.d.common_color_10215);
            this.aqA.setAlpha(0.75f);
            this.aqA.setIncludeFontPadding(false);
            this.aqA.setGravity(17);
            int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2);
            this.aqA.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.aqx.getBottomOffset();
            layoutParams.leftMargin = this.aqx.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aqA, layoutParams);
            this.aqA.setVisibility(0);
        }
    }

    public void bj(boolean z) {
        this.aoZ = z;
        if (this.aoZ) {
            Bk();
        } else {
            Bj();
        }
    }

    public void q(String str, boolean z) {
        this.aqx.setTag(str);
        this.aqx.setLoadBigImage(false);
        this.aqx.setImageDrawable(null);
        this.aqD = false;
        this.aqE = false;
        boolean eT = eT(str);
        this.aqH = bo(true);
        if (!this.aqH) {
            r(str, eT);
        }
        if (eT) {
            s(str, z);
        }
    }

    private boolean bl(boolean z) {
        if (!this.aqI || z) {
            this.aqI = true;
            if (!this.aqH || this.aqG == null || StringUtils.isNull(this.aqG.originalUrl, true) || this.aqG.originalSize < 0 || this.aqB.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dF = bb.dF(this.aqG.originalUrl);
            this.aqB.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + ay.vs().dz(dF) + "/" + dF));
            this.aqB.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bm() {
        bl(false);
    }

    private boolean eT(String str) {
        return com.baidu.adp.lib.util.i.gm() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dT(str);
    }

    private void r(String str, boolean z) {
        if (this.aqG == null) {
            bm(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dT(str)) {
            bm(z);
        } else if (!TextUtils.isEmpty(this.aqG.imageUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.aqG.imageUrl, this.aqG.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bm(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bm(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.aqx.Hs();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eU(str)) {
            if (z2 || (!this.aqF && !this.aqE)) {
                if (!z2 || !bl(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.aqF = true;
                    com.baidu.adp.lib.g.c.eA().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.aqx.getImageData(), Boolean.valueOf(this.aoh));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.F(this.vi, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.aqL.a(imageFileInfo, false);
        if (a2 != null) {
            this.aqE = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aqL.a(imageFileInfo, new ab(this), false);
    }

    private boolean eU(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.aqC != null) {
                this.aqC.i(aVar.getUrl(), aVar.ka());
            }
            Bitmap jV = aVar.jV();
            if (jV == null) {
                if (!this.aqD) {
                    this.aqx.Hs();
                    return;
                }
                this.aqE = false;
                r(null, false);
                return;
            }
            if (aVar.cY()) {
                this.aqx.a(aVar.ka(), jV);
                this.aqJ = false;
                this.aqy.setVisibility(8);
            } else {
                this.aqx.setImageBitmap(jV);
                this.aqx.setImageData(aVar.ka());
                if (this.aqJ) {
                    this.aqy.setVisibility(0);
                }
            }
            Bj();
            Bl();
            this.aqx.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aqx.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aqx != null) {
            this.aqx.onDestroy();
        }
        if (this.aqB != null) {
            this.aqB.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aqx != null) {
            this.aqx.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bn() {
        if (this.aqx != null && this.aqx.getImageType() == 1) {
            this.aqx.stop();
        }
    }

    public void bn(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.aqx != null && (str = (String) this.aqx.getTag()) != null) {
            if ((!eU(str) || com.baidu.adp.lib.util.i.gm()) && this.aqx != null) {
                if (this.aqx.getImageType() == 1) {
                    if (this.aqx.getGifCache() == null || !this.aqx.Hz()) {
                        e(str, z, z2);
                    }
                } else if (this.aqx.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.aqx.getImageBitmap() == null || !this.aqx.Hz()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aqx != null) {
            return this.aqx.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aqG = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aoh = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqy) {
            String dF = bb.dF(this.aqG.originalUrl);
            if (this.aqG.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Cy().y(dF, 13);
                this.aqG.originalProcess = -1;
                if (this.aqG.originalSize > 0) {
                    this.aqy.setText(String.valueOf(aqw) + "(" + az.I(this.aqG.originalSize) + ")");
                } else {
                    this.aqy.setText(aqw);
                }
                this.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.aoj != null) {
                this.aoj.Bp();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eV(dF);
            } else if (!com.baidu.adp.lib.util.i.gm() || com.baidu.adp.lib.util.i.gn() || com.baidu.tbadk.core.sharedPref.b.uh().getBoolean("original_img_down_tip", false)) {
                eV(dF);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bZ(r.j.original_img_down_no_wifi_tip);
                aVar.a(r.j.alert_yes_button, new ac(this, aVar, dF));
                aVar.b(r.j.alert_no_button, new ad(this, aVar));
                aVar.b(C);
                aVar.tm();
            }
        } else if (view == this.aqz && this.aqG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aqG.threadId), String.valueOf(this.aqG.postId), this.aqG.mIsSeeHost, this.aqG.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eV(String str) {
        if (this.aqG != null) {
            this.aqG.originalProcess = 0;
        }
        this.aqy.setText("0%");
        this.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aqG.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + ay.vs().dz(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.Cy().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bo(boolean z) {
        if (this.aqG != null && !StringUtils.isNull(this.aqG.originalUrl, true) && this.aqG.originalSize >= 0) {
            String dF = bb.dF(this.aqG.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + ay.vs().dz(dF) + "/" + dF).exists()) {
                this.aqG.originalProcess = 100;
                if (z) {
                    this.aqy.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.aqG.originalProcess < 0) {
                if (this.aqG.originalSize > 0) {
                    this.aqy.setText(String.valueOf(aqw) + "(" + az.I(this.aqG.originalSize) + ")");
                } else {
                    this.aqy.setText(aqw);
                }
                this.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aqy.setText(String.valueOf(this.aqG.originalProcess) + "%");
                this.aqy.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
            }
            this.aqJ = true;
        } else {
            this.aqy.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aoj = bVar;
    }
}
