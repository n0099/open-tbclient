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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.t;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String aqg = TbadkCoreApplication.m411getInst().getString(t.j.original_img_look);
    private int BF;
    private boolean anS;
    private b anU;
    private boolean aoK;
    protected com.baidu.tbadk.widget.a aqh;
    protected TextView aqi;
    protected TextView aqj;
    protected SubsamplingScaleImageView aqk;
    private a aql;
    private boolean aqm;
    private boolean aqn;
    private boolean aqo;
    private ImageUrlData aqp;
    private boolean aqq;
    private boolean aqr;
    private boolean aqs;
    private TextView aqt;
    private com.baidu.tbadk.img.b aqu;
    private Runnable aqv;
    private SubsamplingScaleImageView.OnImageEventListener aqw;
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
        void Bt();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aqi != null) {
                ar.k(this.aqi, t.f.btn_percent_yuantu);
                ar.a(this.aqi, t.d.cp_cont_g, 1, 0);
            }
            if (this.aqj != null) {
                ar.l(this.aqj, t.d.transparent);
                ar.a(this.aqj, t.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aqh != null) {
            this.aqh.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aql = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aqh = null;
        this.mContext = null;
        this.aql = null;
        this.anS = false;
        this.aqo = false;
        this.aqq = false;
        this.aqr = false;
        this.aoK = false;
        this.aqs = false;
        this.aqt = null;
        this.aqv = new v(this);
        this.aqw = new x(this);
        this.mContext = context;
        this.aqu = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aqh;
    }

    public void setGifSetListener(a.d dVar) {
        this.aqh.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqh.setImageOnClickListener(onClickListener);
        this.aqk.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aqh.setImageOnLongClickListener(onLongClickListener);
        this.aqk.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.aqh.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.BF = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(t.e.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aqh = new com.baidu.tbadk.widget.a(this.mContext);
        this.aqh.setLayoutParams(layoutParams);
        addView(this.aqh);
        this.aqk = new SubsamplingScaleImageView(this.mContext);
        this.aqk.setMaxScale(50.0f);
        this.aqk.setOnImageEventListener(this.aqw);
        this.aqk.setVisibility(4);
        addView(this.aqk, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(t.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Bm();
        this.aqi = new TextView(this.mContext);
        ar.k(this.aqi, t.f.btn_percent_yuantu);
        this.aqi.setText(t.j.original_img_look);
        this.aqi.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize28));
        ar.a(this.aqi, t.d.cp_cont_g, 1, 0);
        this.aqi.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.aqi.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aqi.setMinWidth(getResources().getDimensionPixelSize(t.e.ds220));
        this.aqi.setMinHeight(getResources().getDimensionPixelSize(t.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(t.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.aqi.setOnClickListener(this);
        this.aqi.setVisibility(8);
        addView(this.aqi, layoutParams3);
        Bn();
    }

    private void Bm() {
        this.aqt = new TextView(this.mContext);
        this.aqt.setBackgroundResource(t.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(t.e.ds180);
        layoutParams.addRule(12);
        addView(this.aqt, layoutParams);
        this.aqt.setVisibility(8);
    }

    private void Bn() {
        this.aqj = new TextView(this.mContext);
        ar.l(this.aqj, t.d.transparent);
        this.aqj.setText(t.j.goto_pb_floor);
        this.aqj.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize24));
        ar.a(this.aqj, t.d.cp_cont_g, 1, 0);
        this.aqj.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.aqj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ar.getDrawable(t.f.icon_see_arrow), (Drawable) null);
        this.aqj.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.aqj.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(t.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(t.e.ds20);
        layoutParams.addRule(1, this.aqi.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aqj.setOnClickListener(this);
        this.aqj.setMinHeight(getResources().getDimensionPixelSize(t.e.ds100));
        addView(this.aqj, layoutParams);
        this.aqj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bo() {
        if (this.aqj != null) {
            boolean z = this.aqm || this.aqn;
            if (!this.aoK && z && this.aqp != null && this.aqp.threadId > 0 && this.aqp.postId > 0 && this.aqp.mThreadType != 33) {
                this.aqj.setVisibility(0);
                if (this.aqt != null) {
                    this.aqt.setVisibility(0);
                    return;
                }
                return;
            }
            this.aqj.setVisibility(8);
            if (this.aqt != null) {
                this.aqt.setVisibility(8);
            }
        }
    }

    private void Bp() {
        if (this.aqj != null) {
            this.aqj.setVisibility(8);
            if (this.aqt != null) {
                this.aqt.setVisibility(8);
            }
        }
    }

    public void aW(boolean z) {
        this.aoK = z;
        if (this.aoK) {
            Bp();
        } else {
            Bo();
        }
    }

    public void p(String str, boolean z) {
        this.aqh.setTag(str);
        this.aqh.setLoadBigImage(false);
        this.aqh.setImageDrawable(null);
        this.aqm = false;
        this.aqn = false;
        boolean eH = eH(str);
        this.aqq = ba(true);
        if (!this.aqq) {
            q(str, eH);
        }
        if (eH) {
            r(str, z);
        }
    }

    private boolean aX(boolean z) {
        if (!this.aqr || z) {
            this.aqr = true;
            if (!this.aqq || this.aqp == null || StringUtils.isNull(this.aqp.originalUrl, true) || this.aqp.originalSize < 0 || this.aqk.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dy = ay.dy(this.aqp.originalUrl);
            this.aqk.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.uW()) + av.vZ().ds(dy) + "/" + dy));
            this.aqk.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bq() {
        aX(false);
    }

    private boolean eH(String str) {
        return com.baidu.adp.lib.util.i.iZ() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void q(String str, boolean z) {
        if (this.aqp == null) {
            aY(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aY(z);
        } else if (!TextUtils.isEmpty(this.aqp.imageUrl)) {
            com.baidu.adp.lib.g.c.hl().a(this.aqp.imageUrl, this.aqp.urlType, new y(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void r(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eI(str)) {
            if (z2 || (!this.aqo && !this.aqn)) {
                if (!z2 || !aX(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.aqo = true;
                    com.baidu.adp.lib.g.c.hl().a(str, 27, new z(this), 0, 0, false, null, Boolean.valueOf(z), this.aqh.getImageData(), Boolean.valueOf(this.anS));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.G(this.BF, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.aqu.a(imageFileInfo, false);
        if (a2 != null) {
            this.aqn = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aqu.a(imageFileInfo, new aa(this), false);
    }

    private boolean eI(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.aql != null) {
                this.aql.i(aVar.getUrl(), aVar.mX());
            }
            Bitmap mS = aVar.mS();
            if (mS == null) {
                if (!this.aqm) {
                    this.aqh.setDefaultBitmap();
                    return;
                }
                this.aqn = false;
                q(null, false);
                return;
            }
            if (aVar.fN()) {
                this.aqh.a(aVar.mX(), mS);
                this.aqs = false;
                this.aqi.setVisibility(8);
            } else {
                this.aqh.setImageBitmap(mS);
                this.aqh.setImageData(aVar.mX());
                if (this.aqs) {
                    this.aqi.setVisibility(0);
                }
            }
            Bo();
            this.aqh.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aqh.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aqh != null) {
            this.aqh.onDestroy();
        }
        if (this.aqk != null) {
            this.aqk.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aqh != null) {
            this.aqh.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Br() {
        if (this.aqh != null && this.aqh.getImageType() == 1) {
            this.aqh.stop();
        }
    }

    public void aZ(boolean z) {
        f(z, false);
    }

    public void f(boolean z, boolean z2) {
        String str;
        if (this.aqh != null && (str = (String) this.aqh.getTag()) != null) {
            if ((!eI(str) || com.baidu.adp.lib.util.i.iZ()) && this.aqh != null) {
                if (this.aqh.getImageType() == 1) {
                    if (this.aqh.getGifCache() == null || !this.aqh.GN()) {
                        e(str, z, z2);
                    }
                } else if (this.aqh.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.aqh.getImageBitmap() == null || !this.aqh.GN()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aqh != null) {
            return this.aqh.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aqp = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.anS = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqi) {
            String dy = ay.dy(this.aqp.originalUrl);
            if (this.aqp.originalProcess >= 0) {
                com.baidu.tbadk.download.d.Cu().w(dy, 13);
                this.aqp.originalProcess = -1;
                if (this.aqp.originalSize > 0) {
                    this.aqi.setText(String.valueOf(aqg) + "(" + aw.F(this.aqp.originalSize) + ")");
                } else {
                    this.aqi.setText(aqg);
                }
                this.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.anU != null) {
                this.anU.Bt();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eJ(dy);
            } else if (!com.baidu.adp.lib.util.i.iZ() || com.baidu.adp.lib.util.i.ja() || com.baidu.tbadk.core.sharedPref.b.uO().getBoolean("original_img_down_tip", false)) {
                eJ(dy);
            } else {
                com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bY(t.j.original_img_down_no_wifi_tip);
                aVar.a(t.j.alert_yes_button, new ab(this, aVar, dy));
                aVar.b(t.j.alert_no_button, new ac(this, aVar));
                aVar.b(C);
                aVar.uj();
            }
        } else if (view == this.aqj && this.aqp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aqp.threadId), String.valueOf(this.aqp.postId), this.aqp.mIsSeeHost, this.aqp.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eJ(String str) {
        if (this.aqp != null) {
            this.aqp.originalProcess = 0;
        }
        this.aqi.setText("0%");
        this.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aqp.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.uW()) + av.vZ().ds(str) + "/" + str);
        downloadData.setCallback(new ad(this));
        com.baidu.tbadk.download.d.Cu().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ba(boolean z) {
        if (this.aqp != null && !StringUtils.isNull(this.aqp.originalUrl, true) && this.aqp.originalSize >= 0) {
            String dy = ay.dy(this.aqp.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.uW()) + av.vZ().ds(dy) + "/" + dy).exists()) {
                this.aqp.originalProcess = 100;
                if (z) {
                    this.aqi.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.aqp.originalProcess < 0) {
                if (this.aqp.originalSize > 0) {
                    this.aqi.setText(String.valueOf(aqg) + "(" + aw.F(this.aqp.originalSize) + ")");
                } else {
                    this.aqi.setText(aqg);
                }
                this.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aqi.setText(String.valueOf(this.aqp.originalProcess) + "%");
                this.aqi.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
            }
            this.aqs = true;
        } else {
            this.aqi.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.anU = bVar;
    }
}
