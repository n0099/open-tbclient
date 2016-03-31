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
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.t;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String aqx = TbadkCoreApplication.m411getInst().getString(t.j.original_img_look);
    private int Ca;
    private boolean aoj;
    private b aol;
    private boolean apb;
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
    protected com.baidu.tbadk.widget.a aqy;
    protected TextView aqz;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;

    /* loaded from: classes.dex */
    public interface a {
        void h(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void BW();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aqz != null) {
                at.k(this.aqz, t.f.btn_percent_yuantu);
                at.a(this.aqz, t.d.cp_cont_g, 1, 0);
            }
            if (this.aqA != null) {
                at.l(this.aqA, t.d.transparent);
                at.a(this.aqA, t.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aqy != null) {
            this.aqy.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aqC = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aqy = null;
        this.mContext = null;
        this.aqC = null;
        this.aoj = false;
        this.aqF = false;
        this.aqH = false;
        this.aqI = false;
        this.apb = false;
        this.aqJ = false;
        this.aqK = null;
        this.aqM = new v(this);
        this.aqN = new x(this);
        this.mContext = context;
        this.aqL = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aqy;
    }

    public void setGifSetListener(a.d dVar) {
        this.aqy.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqy.setImageOnClickListener(onClickListener);
        this.aqB.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aqy.setImageOnLongClickListener(onLongClickListener);
        this.aqB.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.aqy.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.Ca = com.baidu.adp.lib.util.k.B(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.C(this.mContext) - ((int) this.mContext.getResources().getDimension(t.e.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aqy = new com.baidu.tbadk.widget.a(this.mContext);
        this.aqy.setLayoutParams(layoutParams);
        addView(this.aqy);
        this.aqB = new SubsamplingScaleImageView(this.mContext);
        this.aqB.setMaxScale(50.0f);
        this.aqB.setOnImageEventListener(this.aqN);
        this.aqB.setVisibility(4);
        addView(this.aqB, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(t.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        BP();
        this.aqz = new TextView(this.mContext);
        at.k(this.aqz, t.f.btn_percent_yuantu);
        this.aqz.setText(t.j.original_img_look);
        this.aqz.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize28));
        at.a(this.aqz, t.d.cp_cont_g, 1, 0);
        this.aqz.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.aqz.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aqz.setMinWidth(getResources().getDimensionPixelSize(t.e.ds220));
        this.aqz.setMinHeight(getResources().getDimensionPixelSize(t.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(t.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.aqz.setOnClickListener(this);
        this.aqz.setVisibility(8);
        addView(this.aqz, layoutParams3);
        BQ();
    }

    private void BP() {
        this.aqK = new TextView(this.mContext);
        this.aqK.setBackgroundResource(t.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(t.e.ds180);
        layoutParams.addRule(12);
        addView(this.aqK, layoutParams);
        this.aqK.setVisibility(8);
    }

    private void BQ() {
        this.aqA = new TextView(this.mContext);
        at.l(this.aqA, t.d.transparent);
        this.aqA.setText(t.j.goto_pb_floor);
        this.aqA.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize24));
        at.a(this.aqA, t.d.cp_cont_g, 1, 0);
        this.aqA.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.aqA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(t.f.icon_see_arrow), (Drawable) null);
        this.aqA.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.aqA.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(t.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(t.e.ds20);
        layoutParams.addRule(1, this.aqz.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aqA.setOnClickListener(this);
        this.aqA.setMinHeight(getResources().getDimensionPixelSize(t.e.ds100));
        addView(this.aqA, layoutParams);
        this.aqA.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR() {
        if (this.aqA != null) {
            boolean z = this.aqD || this.aqE;
            if (!this.apb && z && this.aqG != null && this.aqG.threadId > 0 && this.aqG.postId > 0 && this.aqG.mThreadType != 33) {
                this.aqA.setVisibility(0);
                if (this.aqK != null) {
                    this.aqK.setVisibility(0);
                    return;
                }
                return;
            }
            this.aqA.setVisibility(8);
            if (this.aqK != null) {
                this.aqK.setVisibility(8);
            }
        }
    }

    private void BS() {
        if (this.aqA != null) {
            this.aqA.setVisibility(8);
            if (this.aqK != null) {
                this.aqK.setVisibility(8);
            }
        }
    }

    public void bc(boolean z) {
        this.apb = z;
        if (this.apb) {
            BS();
        } else {
            BR();
        }
    }

    public void o(String str, boolean z) {
        this.aqy.setTag(str);
        this.aqy.setLoadBigImage(false);
        this.aqy.setImageDrawable(null);
        this.aqD = false;
        this.aqE = false;
        boolean eO = eO(str);
        this.aqH = bg(true);
        if (!this.aqH) {
            p(str, eO);
        }
        if (eO) {
            q(str, z);
        }
    }

    private boolean bd(boolean z) {
        if (!this.aqI || z) {
            this.aqI = true;
            if (!this.aqH || this.aqG == null || StringUtils.isNull(this.aqG.originalUrl, true) || this.aqG.originalSize < 0 || this.aqB.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dB = ba.dB(this.aqG.originalUrl);
            this.aqB.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.vs()) + ax.ws().dv(dB) + "/" + dB));
            this.aqB.setVisibility(0);
            return true;
        }
        return false;
    }

    public void BT() {
        bd(false);
    }

    private boolean eO(String str) {
        return com.baidu.adp.lib.util.i.jf() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dP(str);
    }

    private void p(String str, boolean z) {
        if (this.aqG == null) {
            be(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dP(str)) {
            be(z);
        } else if (!TextUtils.isEmpty(this.aqG.imageUrl)) {
            com.baidu.adp.lib.g.c.hr().a(this.aqG.imageUrl, this.aqG.urlType, new y(this, z), 0, 0, true, null, new Object[0]);
        } else {
            be(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eP(str)) {
            if (z2 || (!this.aqF && !this.aqE)) {
                if (!z2 || !bd(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.aqF = true;
                    com.baidu.adp.lib.g.c.hr().a(str, 27, new z(this), 0, 0, false, null, Boolean.valueOf(z), this.aqy.getImageData(), Boolean.valueOf(this.aoj));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.Ca, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.aqL.a(imageFileInfo, false);
        if (a2 != null) {
            this.aqE = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.aqL.a(imageFileInfo, new aa(this), false);
    }

    private boolean eP(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.aqC != null) {
                this.aqC.h(aVar.getUrl(), aVar.mP());
            }
            Bitmap mK = aVar.mK();
            if (mK == null) {
                if (!this.aqD) {
                    this.aqy.setDefaultBitmap();
                    return;
                }
                this.aqE = false;
                p(null, false);
                return;
            }
            if (aVar.fO()) {
                this.aqy.a(aVar.mP(), mK);
                this.aqJ = false;
                this.aqz.setVisibility(8);
            } else {
                this.aqy.setImageBitmap(mK);
                this.aqy.setImageData(aVar.mP());
                if (this.aqJ) {
                    this.aqz.setVisibility(0);
                }
            }
            BR();
            this.aqy.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aqy.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aqy != null) {
            this.aqy.onDestroy();
        }
        if (this.aqB != null) {
            this.aqB.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aqy != null) {
            this.aqy.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void BU() {
        if (this.aqy != null && this.aqy.getImageType() == 1) {
            this.aqy.stop();
        }
    }

    public void bf(boolean z) {
        e(z, false);
    }

    public void e(boolean z, boolean z2) {
        String str;
        if (this.aqy != null && (str = (String) this.aqy.getTag()) != null) {
            if ((!eP(str) || com.baidu.adp.lib.util.i.jf()) && this.aqy != null) {
                if (this.aqy.getImageType() == 1) {
                    if (this.aqy.getGifCache() == null || !this.aqy.HP()) {
                        e(str, z, z2);
                    }
                } else if (this.aqy.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.aqy.getImageBitmap() == null || !this.aqy.HP()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aqy != null) {
            return this.aqy.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aqG = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aoj = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqz) {
            String dB = ba.dB(this.aqG.originalUrl);
            if (this.aqG.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Da().x(dB, 13);
                this.aqG.originalProcess = -1;
                if (this.aqG.originalSize > 0) {
                    this.aqz.setText(String.valueOf(aqx) + "(" + ay.H(this.aqG.originalSize) + ")");
                } else {
                    this.aqz.setText(aqx);
                }
                this.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.aol != null) {
                this.aol.BW();
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
            if (s == null) {
                eQ(dB);
            } else if (!com.baidu.adp.lib.util.i.jf() || com.baidu.adp.lib.util.i.jg() || com.baidu.tbadk.core.sharedPref.b.vk().getBoolean("original_img_down_tip", false)) {
                eQ(dB);
            } else {
                com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(s.getPageActivity());
                aVar.ca(t.j.original_img_down_no_wifi_tip);
                aVar.a(t.j.alert_yes_button, new ab(this, aVar, dB));
                aVar.b(t.j.alert_no_button, new ac(this, aVar));
                aVar.b(s);
                aVar.up();
            }
        } else if (view == this.aqA && this.aqG != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aqG.threadId), String.valueOf(this.aqG.postId), this.aqG.mIsSeeHost, this.aqG.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str) {
        if (this.aqG != null) {
            this.aqG.originalProcess = 0;
        }
        this.aqz.setText("0%");
        this.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aqG.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.vs()) + ax.ws().dv(str) + "/" + str);
        downloadData.setCallback(new ad(this));
        com.baidu.tbadk.download.e.Da().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bg(boolean z) {
        if (this.aqG != null && !StringUtils.isNull(this.aqG.originalUrl, true) && this.aqG.originalSize >= 0) {
            String dB = ba.dB(this.aqG.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.vs()) + ax.ws().dv(dB) + "/" + dB).exists()) {
                this.aqG.originalProcess = 100;
                if (z) {
                    this.aqz.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.aqG.originalProcess < 0) {
                if (this.aqG.originalSize > 0) {
                    this.aqz.setText(String.valueOf(aqx) + "(" + ay.H(this.aqG.originalSize) + ")");
                } else {
                    this.aqz.setText(aqx);
                }
                this.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aqz.setText(String.valueOf(this.aqG.originalProcess) + "%");
                this.aqz.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
            }
            this.aqJ = true;
        } else {
            this.aqz.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aol = bVar;
    }
}
