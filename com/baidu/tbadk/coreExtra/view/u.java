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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.r;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String arq = TbadkCoreApplication.m9getInst().getString(r.j.original_img_look);
    private boolean apU;
    private boolean apb;
    private b apd;
    private ImageUrlData arA;
    private boolean arB;
    private boolean arC;
    private boolean arD;
    private TextView arE;
    private com.baidu.tbadk.img.b arF;
    private Runnable arG;
    private SubsamplingScaleImageView.OnImageEventListener arH;
    protected com.baidu.tbadk.widget.a arr;
    protected TextView ars;
    protected TextView art;
    protected TextView aru;
    protected SubsamplingScaleImageView arv;
    private a arw;
    private boolean arx;
    private boolean ary;
    private boolean arz;
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
        void Bw();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.ars != null) {
                at.k(this.ars, r.f.btn_percent_yuantu);
                at.b(this.ars, r.d.cp_cont_g, 1, 0);
            }
            if (this.art != null) {
                at.l(this.art, r.d.common_color_10022);
                at.b(this.art, r.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.arr != null) {
            this.arr.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.arw = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.arr = null;
        this.mContext = null;
        this.arw = null;
        this.apb = false;
        this.arz = false;
        this.arB = false;
        this.arC = false;
        this.apU = false;
        this.arD = false;
        this.arE = null;
        this.arG = new v(this);
        this.arH = new x(this);
        this.mContext = context;
        this.arF = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.arr;
    }

    public void setGifSetListener(a.d dVar) {
        this.arr.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.arr.setImageOnClickListener(onClickListener);
        this.arv.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.arr.setImageOnLongClickListener(onLongClickListener);
        this.arv.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.arr.setOnSizeChangedListener(new y(this, eVar));
    }

    protected void init() {
        this.vj = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(r.e.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.arr = new com.baidu.tbadk.widget.a(this.mContext);
        this.arr.setLayoutParams(layoutParams);
        addView(this.arr);
        this.arv = new SubsamplingScaleImageView(this.mContext);
        this.arv.setMaxScale(50.0f);
        this.arv.setOnImageEventListener(this.arH);
        this.arv.setVisibility(4);
        addView(this.arv, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(r.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bo();
        this.ars = new TextView(this.mContext);
        at.k(this.ars, r.f.btn_percent_yuantu);
        this.ars.setText(r.j.original_img_look);
        this.ars.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize28));
        at.b(this.ars, r.d.cp_cont_g, 1, 0);
        this.ars.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds20);
        this.ars.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.ars.setMinWidth(getResources().getDimensionPixelSize(r.e.ds220));
        this.ars.setMinHeight(getResources().getDimensionPixelSize(r.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(r.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.ars.setOnClickListener(this);
        this.ars.setVisibility(8);
        addView(this.ars, layoutParams3);
        Bp();
    }

    private void Bo() {
        this.arE = new TextView(this.mContext);
        this.arE.setBackgroundResource(r.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(r.e.ds180);
        layoutParams.addRule(12);
        addView(this.arE, layoutParams);
        this.arE.setVisibility(8);
    }

    private void Bp() {
        this.art = new TextView(this.mContext);
        at.l(this.art, r.d.common_color_10022);
        this.art.setText(r.j.goto_pb_floor);
        this.art.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize24));
        at.b(this.art, r.d.cp_cont_g, 1, 0);
        this.art.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.art.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(r.f.icon_see_arrow), (Drawable) null);
        this.art.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds20);
        this.art.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(r.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(r.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(r.e.ds20);
        layoutParams.addRule(1, this.ars.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.art.setOnClickListener(this);
        this.art.setMinHeight(getResources().getDimensionPixelSize(r.e.ds100));
        addView(this.art, layoutParams);
        this.art.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bq() {
        if (this.art != null) {
            boolean z = this.arx || this.ary;
            if (!this.apU && z && this.arA != null && this.arA.threadId > 0 && this.arA.postId > 0 && this.arA.mThreadType != 33) {
                this.art.setVisibility(0);
                if (this.arE != null) {
                    this.arE.setVisibility(0);
                    return;
                }
                return;
            }
            this.art.setVisibility(8);
            if (this.arE != null) {
                this.arE.setVisibility(8);
            }
        }
    }

    private void Br() {
        if (this.art != null) {
            this.art.setVisibility(8);
            if (this.arE != null) {
                this.arE.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bs() {
        if ((this.arx || this.ary) && this.arA != null && this.arA.mPicType == 1 && !TextUtils.isEmpty(this.arA.mTagName)) {
            if (this.aru != null) {
                this.aru.setVisibility(8);
                this.aru = null;
            }
            this.aru = new TextView(this.mContext);
            this.aru.setText(this.arA.mTagName);
            this.aru.setTextSize(0, getResources().getDimensionPixelSize(r.e.fontsize26));
            at.b(this.aru, r.d.common_color_10013, 1, 0);
            at.l(this.aru, r.d.common_color_10215);
            this.aru.setAlpha(0.75f);
            this.aru.setIncludeFontPadding(false);
            this.aru.setGravity(17);
            int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds2);
            this.aru.setPadding(e, e, e, e);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.bottomMargin = this.arr.getBottomOffset();
            layoutParams.leftMargin = this.arr.getLeftOffset();
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            addView(this.aru, layoutParams);
            this.aru.setVisibility(0);
        }
    }

    public void bn(boolean z) {
        this.apU = z;
        if (this.apU) {
            Br();
        } else {
            Bq();
        }
    }

    public void q(String str, boolean z) {
        this.arr.setTag(str);
        this.arr.setLoadBigImage(false);
        this.arr.setImageDrawable(null);
        this.arx = false;
        this.ary = false;
        boolean eV = eV(str);
        this.arB = bs(true);
        if (!this.arB) {
            r(str, eV);
        }
        if (eV) {
            s(str, z);
        }
    }

    private boolean bp(boolean z) {
        if (!this.arC || z) {
            this.arC = true;
            if (!this.arB || this.arA == null || StringUtils.isNull(this.arA.originalUrl, true) || this.arA.originalSize < 0 || this.arv.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dH = az.dH(this.arA.originalUrl);
            this.arv.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + aw.vw().dB(dH) + "/" + dH));
            this.arv.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bt() {
        bp(false);
    }

    private boolean eV(String str) {
        return com.baidu.adp.lib.util.i.gm() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dV(str);
    }

    private void r(String str, boolean z) {
        if (this.arA == null) {
            bq(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dV(str)) {
            bq(z);
        } else if (!TextUtils.isEmpty(this.arA.imageUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.arA.imageUrl, this.arA.urlType, new z(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bq(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bq(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
            this.arr.Hv();
        }
    }

    private void s(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eW(str)) {
            if (z2 || (!this.arz && !this.ary)) {
                if (!z2 || !bp(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.arz = true;
                    com.baidu.adp.lib.g.c.eA().a(str, 27, new aa(this), 0, 0, false, null, Boolean.valueOf(z), this.arr.getImageData(), Boolean.valueOf(this.apb));
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
        com.baidu.adp.widget.a.a a2 = this.arF.a(imageFileInfo, false);
        if (a2 != null) {
            this.ary = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.arF.a(imageFileInfo, new ab(this), false);
    }

    private boolean eW(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.arw != null) {
                this.arw.i(aVar.getUrl(), aVar.ka());
            }
            Bitmap jV = aVar.jV();
            if (jV == null) {
                if (!this.arx) {
                    this.arr.Hv();
                    return;
                }
                this.ary = false;
                r(null, false);
                return;
            }
            if (aVar.cY()) {
                this.arr.a(aVar.ka(), jV);
                this.arD = false;
                this.ars.setVisibility(8);
            } else {
                this.arr.setImageBitmap(jV);
                this.arr.setImageData(aVar.ka());
                if (this.arD) {
                    this.ars.setVisibility(0);
                }
            }
            Bq();
            Bs();
            this.arr.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.arr.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.arr != null) {
            this.arr.onDestroy();
        }
        if (this.arv != null) {
            this.arv.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.arr != null) {
            this.arr.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bu() {
        if (this.arr != null && this.arr.getImageType() == 1) {
            this.arr.stop();
        }
    }

    public void br(boolean z) {
        g(z, false);
    }

    public void g(boolean z, boolean z2) {
        String str;
        if (this.arr != null && (str = (String) this.arr.getTag()) != null) {
            if ((!eW(str) || com.baidu.adp.lib.util.i.gm()) && this.arr != null) {
                if (this.arr.getImageType() == 1) {
                    if (this.arr.getGifCache() == null || !this.arr.HC()) {
                        e(str, z, z2);
                    }
                } else if (this.arr.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.arr.getImageBitmap() == null || !this.arr.HC()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.arr != null) {
            return this.arr.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.arA = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.apb = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ars) {
            String dH = az.dH(this.arA.originalUrl);
            if (this.arA.originalProcess >= 0) {
                com.baidu.tbadk.download.e.CG().y(dH, 13);
                this.arA.originalProcess = -1;
                if (this.arA.originalSize > 0) {
                    this.ars.setText(String.valueOf(arq) + "(" + ax.H(this.arA.originalSize) + ")");
                } else {
                    this.ars.setText(arq);
                }
                this.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.apd != null) {
                this.apd.Bw();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eX(dH);
            } else if (!com.baidu.adp.lib.util.i.gm() || com.baidu.adp.lib.util.i.gn() || com.baidu.tbadk.core.sharedPref.b.um().getBoolean("original_img_down_tip", false)) {
                eX(dH);
            } else {
                com.baidu.tbadk.core.sharedPref.b.um().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.ca(r.j.original_img_down_no_wifi_tip);
                aVar.a(r.j.alert_yes_button, new ac(this, aVar, dH));
                aVar.b(r.j.alert_no_button, new ad(this, aVar));
                aVar.b(C);
                aVar.tq();
            }
        } else if (view == this.art && this.arA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.arA.threadId), String.valueOf(this.arA.postId), this.arA.mIsSeeHost, this.arA.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        if (this.arA != null) {
            this.arA.originalProcess = 0;
        }
        this.ars.setText("0%");
        this.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.arA.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + aw.vw().dB(str) + "/" + str);
        downloadData.setCallback(new ae(this));
        com.baidu.tbadk.download.e.CG().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs(boolean z) {
        if (this.arA != null && !StringUtils.isNull(this.arA.originalUrl, true) && this.arA.originalSize >= 0) {
            String dH = az.dH(this.arA.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + aw.vw().dB(dH) + "/" + dH).exists()) {
                this.arA.originalProcess = 100;
                if (z) {
                    this.ars.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.arA.originalProcess < 0) {
                if (this.arA.originalSize > 0) {
                    this.ars.setText(String.valueOf(arq) + "(" + ax.H(this.arA.originalSize) + ")");
                } else {
                    this.ars.setText(arq);
                }
                this.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.ars.setText(String.valueOf(this.arA.originalProcess) + "%");
                this.ars.setCompoundDrawablesWithIntrinsicBounds(0, 0, r.f.icon_close_yuantu, 0);
            }
            this.arD = true;
        } else {
            this.ars.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.apd = bVar;
    }
}
