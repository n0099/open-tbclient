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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.u;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String amR = TbadkCoreApplication.m9getInst().getString(u.j.original_img_look);
    private boolean akD;
    private b akF;
    private boolean alw;
    protected com.baidu.tbadk.widget.a amS;
    protected TextView amT;
    protected TextView amU;
    protected SubsamplingScaleImageView amV;
    private a amW;
    private boolean amX;
    private boolean amY;
    private boolean amZ;
    private ImageUrlData ana;
    private boolean anb;
    private boolean anc;
    private boolean and;
    private TextView ane;
    private com.baidu.tbadk.img.b anf;
    private Runnable ang;
    private SubsamplingScaleImageView.OnImageEventListener anh;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int so;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void zW();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.amT != null) {
                av.k(this.amT, u.f.btn_percent_yuantu);
                av.b(this.amT, u.d.cp_cont_g, 1, 0);
            }
            if (this.amU != null) {
                av.l(this.amU, u.d.common_color_10022);
                av.b(this.amU, u.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.amS != null) {
            this.amS.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.amW = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.amS = null;
        this.mContext = null;
        this.amW = null;
        this.akD = false;
        this.amZ = false;
        this.anb = false;
        this.anc = false;
        this.alw = false;
        this.and = false;
        this.ane = null;
        this.ang = new v(this);
        this.anh = new x(this);
        this.mContext = context;
        this.anf = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.amS;
    }

    public void setGifSetListener(a.d dVar) {
        this.amS.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.amS.setImageOnClickListener(onClickListener);
        this.amV.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.amS.setImageOnLongClickListener(onLongClickListener);
        this.amV.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.amS.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.so = com.baidu.adp.lib.util.k.A(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.B(this.mContext) - ((int) this.mContext.getResources().getDimension(u.e.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.amS = new com.baidu.tbadk.widget.a(this.mContext);
        this.amS.setLayoutParams(layoutParams);
        addView(this.amS);
        this.amV = new SubsamplingScaleImageView(this.mContext);
        this.amV.setMaxScale(50.0f);
        this.amV.setOnImageEventListener(this.anh);
        this.amV.setVisibility(4);
        addView(this.amV, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(u.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        zP();
        this.amT = new TextView(this.mContext);
        av.k(this.amT, u.f.btn_percent_yuantu);
        this.amT.setText(u.j.original_img_look);
        this.amT.setTextSize(0, getResources().getDimensionPixelSize(u.e.fontsize28));
        av.b(this.amT, u.d.cp_cont_g, 1, 0);
        this.amT.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds20);
        this.amT.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.amT.setMinWidth(getResources().getDimensionPixelSize(u.e.ds220));
        this.amT.setMinHeight(getResources().getDimensionPixelSize(u.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(u.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.amT.setOnClickListener(this);
        this.amT.setVisibility(8);
        addView(this.amT, layoutParams3);
        zQ();
    }

    private void zP() {
        this.ane = new TextView(this.mContext);
        this.ane.setBackgroundResource(u.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(u.e.ds180);
        layoutParams.addRule(12);
        addView(this.ane, layoutParams);
        this.ane.setVisibility(8);
    }

    private void zQ() {
        this.amU = new TextView(this.mContext);
        av.l(this.amU, u.d.common_color_10022);
        this.amU.setText(u.j.goto_pb_floor);
        this.amU.setTextSize(0, getResources().getDimensionPixelSize(u.e.fontsize24));
        av.b(this.amU, u.d.cp_cont_g, 1, 0);
        this.amU.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.amU.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(u.f.icon_see_arrow), (Drawable) null);
        this.amU.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds20);
        this.amU.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(u.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(u.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(u.e.ds20);
        layoutParams.addRule(1, this.amT.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.amU.setOnClickListener(this);
        this.amU.setMinHeight(getResources().getDimensionPixelSize(u.e.ds100));
        addView(this.amU, layoutParams);
        this.amU.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR() {
        if (this.amU != null) {
            boolean z = this.amX || this.amY;
            if (!this.alw && z && this.ana != null && this.ana.threadId > 0 && this.ana.postId > 0 && this.ana.mThreadType != 33) {
                this.amU.setVisibility(0);
                if (this.ane != null) {
                    this.ane.setVisibility(0);
                    return;
                }
                return;
            }
            this.amU.setVisibility(8);
            if (this.ane != null) {
                this.ane.setVisibility(8);
            }
        }
    }

    private void zS() {
        if (this.amU != null) {
            this.amU.setVisibility(8);
            if (this.ane != null) {
                this.ane.setVisibility(8);
            }
        }
    }

    public void bf(boolean z) {
        this.alw = z;
        if (this.alw) {
            zS();
        } else {
            zR();
        }
    }

    public void o(String str, boolean z) {
        this.amS.setTag(str);
        this.amS.setLoadBigImage(false);
        this.amS.setImageDrawable(null);
        this.amX = false;
        this.amY = false;
        boolean eP = eP(str);
        this.anb = bk(true);
        if (!this.anb) {
            p(str, eP);
        }
        if (eP) {
            q(str, z);
        }
    }

    private boolean bh(boolean z) {
        if (!this.anc || z) {
            this.anc = true;
            if (!this.anb || this.ana == null || StringUtils.isNull(this.ana.originalUrl, true) || this.ana.originalSize < 0 || this.amV.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dB = bc.dB(this.ana.originalUrl);
            this.amV.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.tY().dv(dB) + "/" + dB));
            this.amV.setVisibility(0);
            return true;
        }
        return false;
    }

    public void zT() {
        bh(false);
    }

    private boolean eP(String str) {
        return com.baidu.adp.lib.util.i.fr() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dP(str);
    }

    private void p(String str, boolean z) {
        if (this.ana == null) {
            bi(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dP(str)) {
            bi(z);
        } else if (!TextUtils.isEmpty(this.ana.imageUrl)) {
            com.baidu.adp.lib.g.c.dG().a(this.ana.imageUrl, this.ana.urlType, new y(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bi(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bi(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void q(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eQ(str)) {
            if (z2 || (!this.amZ && !this.amY)) {
                if (!z2 || !bh(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.amZ = true;
                    com.baidu.adp.lib.g.c.dG().a(str, 27, new z(this), 0, 0, false, null, Boolean.valueOf(z), this.amS.getImageData(), Boolean.valueOf(this.akD));
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
        com.baidu.adp.widget.a.a a2 = this.anf.a(imageFileInfo, false);
        if (a2 != null) {
            this.amY = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.anf.a(imageFileInfo, new aa(this), false);
    }

    private boolean eQ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.amW != null) {
                this.amW.i(aVar.getUrl(), aVar.jg());
            }
            Bitmap jb = aVar.jb();
            if (jb == null) {
                if (!this.amX) {
                    this.amS.FW();
                    return;
                }
                this.amY = false;
                p(null, false);
                return;
            }
            if (aVar.ce()) {
                this.amS.a(aVar.jg(), jb);
                this.and = false;
                this.amT.setVisibility(8);
            } else {
                this.amS.setImageBitmap(jb);
                this.amS.setImageData(aVar.jg());
                if (this.and) {
                    this.amT.setVisibility(0);
                }
            }
            zR();
            this.amS.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.amS.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.amS != null) {
            this.amS.onDestroy();
        }
        if (this.amV != null) {
            this.amV.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.amS != null) {
            this.amS.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zU() {
        if (this.amS != null && this.amS.getImageType() == 1) {
            this.amS.stop();
        }
    }

    public void bj(boolean z) {
        f(z, false);
    }

    public void f(boolean z, boolean z2) {
        String str;
        if (this.amS != null && (str = (String) this.amS.getTag()) != null) {
            if ((!eQ(str) || com.baidu.adp.lib.util.i.fr()) && this.amS != null) {
                if (this.amS.getImageType() == 1) {
                    if (this.amS.getGifCache() == null || !this.amS.Gd()) {
                        e(str, z, z2);
                    }
                } else if (this.amS.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.amS.getImageBitmap() == null || !this.amS.Gd()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.amS != null) {
            return this.amS.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.ana = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.akD = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amT) {
            String dB = bc.dB(this.ana.originalUrl);
            if (this.ana.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Bd().A(dB, 13);
                this.ana.originalProcess = -1;
                if (this.ana.originalSize > 0) {
                    this.amT.setText(String.valueOf(amR) + "(" + ba.L(this.ana.originalSize) + ")");
                } else {
                    this.amT.setText(amR);
                }
                this.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.akF != null) {
                this.akF.zW();
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
            if (s == null) {
                eR(dB);
            } else if (!com.baidu.adp.lib.util.i.fr() || com.baidu.adp.lib.util.i.fs() || com.baidu.tbadk.core.sharedPref.b.sO().getBoolean("original_img_down_tip", false)) {
                eR(dB);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(s.getPageActivity());
                aVar.bM(u.j.original_img_down_no_wifi_tip);
                aVar.a(u.j.alert_yes_button, new ab(this, aVar, dB));
                aVar.b(u.j.alert_no_button, new ac(this, aVar));
                aVar.b(s);
                aVar.rT();
            }
        } else if (view == this.amU && this.ana != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.ana.threadId), String.valueOf(this.ana.postId), this.ana.mIsSeeHost, this.ana.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(String str) {
        if (this.ana != null) {
            this.ana.originalProcess = 0;
        }
        this.amT.setText("0%");
        this.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.ana.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.tY().dv(str) + "/" + str);
        downloadData.setCallback(new ad(this));
        com.baidu.tbadk.download.e.Bd().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bk(boolean z) {
        if (this.ana != null && !StringUtils.isNull(this.ana.originalUrl, true) && this.ana.originalSize >= 0) {
            String dB = bc.dB(this.ana.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.tY().dv(dB) + "/" + dB).exists()) {
                this.ana.originalProcess = 100;
                if (z) {
                    this.amT.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.ana.originalProcess < 0) {
                if (this.ana.originalSize > 0) {
                    this.amT.setText(String.valueOf(amR) + "(" + ba.L(this.ana.originalSize) + ")");
                } else {
                    this.amT.setText(amR);
                }
                this.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.amT.setText(String.valueOf(this.ana.originalProcess) + "%");
                this.amT.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_close_yuantu, 0);
            }
            this.and = true;
        } else {
            this.amT.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.akF = bVar;
    }
}
