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
    private static final String aml = TbadkCoreApplication.m11getInst().getString(t.j.original_img_look);
    private boolean ajX;
    private b ajZ;
    private boolean akP;
    private Runnable amA;
    private SubsamplingScaleImageView.OnImageEventListener amB;
    protected com.baidu.tbadk.widget.a amm;
    protected TextView amn;
    protected TextView amo;
    protected SubsamplingScaleImageView amp;
    private a amq;
    private boolean amr;
    private boolean ams;
    private boolean amt;
    private ImageUrlData amu;
    private boolean amv;
    private boolean amw;
    private boolean amx;
    private TextView amy;
    private com.baidu.tbadk.img.b amz;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int so;

    /* loaded from: classes.dex */
    public interface a {
        void h(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void zQ();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.amn != null) {
                at.k(this.amn, t.f.btn_percent_yuantu);
                at.b(this.amn, t.d.cp_cont_g, 1, 0);
            }
            if (this.amo != null) {
                at.l(this.amo, t.d.transparent);
                at.b(this.amo, t.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.amm != null) {
            this.amm.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.amq = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.amm = null;
        this.mContext = null;
        this.amq = null;
        this.ajX = false;
        this.amt = false;
        this.amv = false;
        this.amw = false;
        this.akP = false;
        this.amx = false;
        this.amy = null;
        this.amA = new v(this);
        this.amB = new x(this);
        this.mContext = context;
        this.amz = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.amm;
    }

    public void setGifSetListener(a.d dVar) {
        this.amm.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.amm.setImageOnClickListener(onClickListener);
        this.amp.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amm.setImageOnLongClickListener(onLongClickListener);
        this.amp.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.amm.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.so = com.baidu.adp.lib.util.k.B(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.C(this.mContext) - ((int) this.mContext.getResources().getDimension(t.e.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.amm = new com.baidu.tbadk.widget.a(this.mContext);
        this.amm.setLayoutParams(layoutParams);
        addView(this.amm);
        this.amp = new SubsamplingScaleImageView(this.mContext);
        this.amp.setMaxScale(50.0f);
        this.amp.setOnImageEventListener(this.amB);
        this.amp.setVisibility(4);
        addView(this.amp, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(t.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        zJ();
        this.amn = new TextView(this.mContext);
        at.k(this.amn, t.f.btn_percent_yuantu);
        this.amn.setText(t.j.original_img_look);
        this.amn.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize28));
        at.b(this.amn, t.d.cp_cont_g, 1, 0);
        this.amn.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.amn.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.amn.setMinWidth(getResources().getDimensionPixelSize(t.e.ds220));
        this.amn.setMinHeight(getResources().getDimensionPixelSize(t.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(t.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.amn.setOnClickListener(this);
        this.amn.setVisibility(8);
        addView(this.amn, layoutParams3);
        zK();
    }

    private void zJ() {
        this.amy = new TextView(this.mContext);
        this.amy.setBackgroundResource(t.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(t.e.ds180);
        layoutParams.addRule(12);
        addView(this.amy, layoutParams);
        this.amy.setVisibility(8);
    }

    private void zK() {
        this.amo = new TextView(this.mContext);
        at.l(this.amo, t.d.transparent);
        this.amo.setText(t.j.goto_pb_floor);
        this.amo.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize24));
        at.b(this.amo, t.d.cp_cont_g, 1, 0);
        this.amo.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.amo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, at.getDrawable(t.f.icon_see_arrow), (Drawable) null);
        this.amo.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.amo.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(t.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(t.e.ds20);
        layoutParams.addRule(1, this.amn.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.amo.setOnClickListener(this);
        this.amo.setMinHeight(getResources().getDimensionPixelSize(t.e.ds100));
        addView(this.amo, layoutParams);
        this.amo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL() {
        if (this.amo != null) {
            boolean z = this.amr || this.ams;
            if (!this.akP && z && this.amu != null && this.amu.threadId > 0 && this.amu.postId > 0 && this.amu.mThreadType != 33) {
                this.amo.setVisibility(0);
                if (this.amy != null) {
                    this.amy.setVisibility(0);
                    return;
                }
                return;
            }
            this.amo.setVisibility(8);
            if (this.amy != null) {
                this.amy.setVisibility(8);
            }
        }
    }

    private void zM() {
        if (this.amo != null) {
            this.amo.setVisibility(8);
            if (this.amy != null) {
                this.amy.setVisibility(8);
            }
        }
    }

    public void bi(boolean z) {
        this.akP = z;
        if (this.akP) {
            zM();
        } else {
            zL();
        }
    }

    public void o(String str, boolean z) {
        this.amm.setTag(str);
        this.amm.setLoadBigImage(false);
        this.amm.setImageDrawable(null);
        this.amr = false;
        this.ams = false;
        boolean eL = eL(str);
        this.amv = bn(true);
        if (!this.amv) {
            p(str, eL);
        }
        if (eL) {
            q(str, z);
        }
    }

    private boolean bk(boolean z) {
        if (!this.amw || z) {
            this.amw = true;
            if (!this.amv || this.amu == null || StringUtils.isNull(this.amu.originalUrl, true) || this.amu.originalSize < 0 || this.amp.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dy = ba.dy(this.amu.originalUrl);
            this.amp.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + ax.tY().ds(dy) + "/" + dy));
            this.amp.setVisibility(0);
            return true;
        }
        return false;
    }

    public void zN() {
        bk(false);
    }

    private boolean eL(String str) {
        return com.baidu.adp.lib.util.i.fq() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dM(str);
    }

    private void p(String str, boolean z) {
        if (this.amu == null) {
            bl(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dM(str)) {
            bl(z);
        } else if (!TextUtils.isEmpty(this.amu.imageUrl)) {
            com.baidu.adp.lib.g.c.dF().a(this.amu.imageUrl, this.amu.urlType, new y(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bl(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eM(str)) {
            if (z2 || (!this.amt && !this.ams)) {
                if (!z2 || !bk(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.amt = true;
                    com.baidu.adp.lib.g.c.dF().a(str, 27, new z(this), 0, 0, false, null, Boolean.valueOf(z), this.amm.getImageData(), Boolean.valueOf(this.ajX));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.so, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.amz.a(imageFileInfo, false);
        if (a2 != null) {
            this.ams = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.amz.a(imageFileInfo, new aa(this), false);
    }

    private boolean eM(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.amq != null) {
                this.amq.h(aVar.getUrl(), aVar.jd());
            }
            Bitmap iY = aVar.iY();
            if (iY == null) {
                if (!this.amr) {
                    this.amm.FT();
                    return;
                }
                this.ams = false;
                p(null, false);
                return;
            }
            if (aVar.cd()) {
                this.amm.a(aVar.jd(), iY);
                this.amx = false;
                this.amn.setVisibility(8);
            } else {
                this.amm.setImageBitmap(iY);
                this.amm.setImageData(aVar.jd());
                if (this.amx) {
                    this.amn.setVisibility(0);
                }
            }
            zL();
            this.amm.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.amm.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.amm != null) {
            this.amm.onDestroy();
        }
        if (this.amp != null) {
            this.amp.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.amm != null) {
            this.amm.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zO() {
        if (this.amm != null && this.amm.getImageType() == 1) {
            this.amm.stop();
        }
    }

    public void bm(boolean z) {
        e(z, false);
    }

    public void e(boolean z, boolean z2) {
        String str;
        if (this.amm != null && (str = (String) this.amm.getTag()) != null) {
            if ((!eM(str) || com.baidu.adp.lib.util.i.fq()) && this.amm != null) {
                if (this.amm.getImageType() == 1) {
                    if (this.amm.getGifCache() == null || !this.amm.Ga()) {
                        e(str, z, z2);
                    }
                } else if (this.amm.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.amm.getImageBitmap() == null || !this.amm.Ga()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.amm != null) {
            return this.amm.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.amu = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.ajX = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amn) {
            String dy = ba.dy(this.amu.originalUrl);
            if (this.amu.originalProcess >= 0) {
                com.baidu.tbadk.download.e.AT().y(dy, 13);
                this.amu.originalProcess = -1;
                if (this.amu.originalSize > 0) {
                    this.amn.setText(String.valueOf(aml) + "(" + ay.I(this.amu.originalSize) + ")");
                } else {
                    this.amn.setText(aml);
                }
                this.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.ajZ != null) {
                this.ajZ.zQ();
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
            if (s == null) {
                eN(dy);
            } else if (!com.baidu.adp.lib.util.i.fq() || com.baidu.adp.lib.util.i.fr() || com.baidu.tbadk.core.sharedPref.b.sQ().getBoolean("original_img_down_tip", false)) {
                eN(dy);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sQ().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(s.getPageActivity());
                aVar.bM(t.j.original_img_down_no_wifi_tip);
                aVar.a(t.j.alert_yes_button, new ab(this, aVar, dy));
                aVar.b(t.j.alert_no_button, new ac(this, aVar));
                aVar.b(s);
                aVar.rU();
            }
        } else if (view == this.amo && this.amu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.amu.threadId), String.valueOf(this.amu.postId), this.amu.mIsSeeHost, this.amu.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eN(String str) {
        if (this.amu != null) {
            this.amu.originalProcess = 0;
        }
        this.amn.setText("0%");
        this.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.amu.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + ax.tY().ds(str) + "/" + str);
        downloadData.setCallback(new ad(this));
        com.baidu.tbadk.download.e.AT().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bn(boolean z) {
        if (this.amu != null && !StringUtils.isNull(this.amu.originalUrl, true) && this.amu.originalSize >= 0) {
            String dy = ba.dy(this.amu.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + ax.tY().ds(dy) + "/" + dy).exists()) {
                this.amu.originalProcess = 100;
                if (z) {
                    this.amn.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.amu.originalProcess < 0) {
                if (this.amu.originalSize > 0) {
                    this.amn.setText(String.valueOf(aml) + "(" + ay.I(this.amu.originalSize) + ")");
                } else {
                    this.amn.setText(aml);
                }
                this.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.amn.setText(String.valueOf(this.amu.originalProcess) + "%");
                this.amn.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
            }
            this.amx = true;
        } else {
            this.amn.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.ajZ = bVar;
    }
}
