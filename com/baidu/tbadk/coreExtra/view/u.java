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
    private static final String anG = TbadkCoreApplication.m10getInst().getString(u.j.original_img_look);
    private boolean alt;
    private b alv;
    private boolean aml;
    protected com.baidu.tbadk.widget.a anH;
    protected TextView anI;
    protected TextView anJ;
    protected SubsamplingScaleImageView anK;
    private a anL;
    private boolean anM;
    private boolean anN;
    private boolean anO;
    private ImageUrlData anP;
    private boolean anQ;
    private boolean anR;
    private boolean anS;
    private TextView anT;
    private com.baidu.tbadk.img.b anU;
    private Runnable anV;
    private SubsamplingScaleImageView.OnImageEventListener anW;
    protected Context mContext;
    private int mMaxHeight;
    protected ProgressBar mProgressBar;
    private int mSkinType;
    private int sS;

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
            if (this.anI != null) {
                av.k(this.anI, u.f.btn_percent_yuantu);
                av.b(this.anI, u.d.cp_cont_g, 1, 0);
            }
            if (this.anJ != null) {
                av.l(this.anJ, u.d.common_color_10022);
                av.b(this.anJ, u.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.anH != null) {
            this.anH.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.anL = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.anH = null;
        this.mContext = null;
        this.anL = null;
        this.alt = false;
        this.anO = false;
        this.anQ = false;
        this.anR = false;
        this.aml = false;
        this.anS = false;
        this.anT = null;
        this.anV = new v(this);
        this.anW = new x(this);
        this.mContext = context;
        this.anU = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.anH;
    }

    public void setGifSetListener(a.d dVar) {
        this.anH.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.anH.setImageOnClickListener(onClickListener);
        this.anK.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anH.setImageOnLongClickListener(onLongClickListener);
        this.anK.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.anH.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.sS = com.baidu.adp.lib.util.k.A(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.B(this.mContext) - ((int) this.mContext.getResources().getDimension(u.e.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.anH = new com.baidu.tbadk.widget.a(this.mContext);
        this.anH.setLayoutParams(layoutParams);
        addView(this.anH);
        this.anK = new SubsamplingScaleImageView(this.mContext);
        this.anK.setMaxScale(50.0f);
        this.anK.setOnImageEventListener(this.anW);
        this.anK.setVisibility(4);
        addView(this.anK, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(u.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        zP();
        this.anI = new TextView(this.mContext);
        av.k(this.anI, u.f.btn_percent_yuantu);
        this.anI.setText(u.j.original_img_look);
        this.anI.setTextSize(0, getResources().getDimensionPixelSize(u.e.fontsize28));
        av.b(this.anI, u.d.cp_cont_g, 1, 0);
        this.anI.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds20);
        this.anI.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.anI.setMinWidth(getResources().getDimensionPixelSize(u.e.ds220));
        this.anI.setMinHeight(getResources().getDimensionPixelSize(u.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(u.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.anI.setOnClickListener(this);
        this.anI.setVisibility(8);
        addView(this.anI, layoutParams3);
        zQ();
    }

    private void zP() {
        this.anT = new TextView(this.mContext);
        this.anT.setBackgroundResource(u.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(u.e.ds180);
        layoutParams.addRule(12);
        addView(this.anT, layoutParams);
        this.anT.setVisibility(8);
    }

    private void zQ() {
        this.anJ = new TextView(this.mContext);
        av.l(this.anJ, u.d.common_color_10022);
        this.anJ.setText(u.j.goto_pb_floor);
        this.anJ.setTextSize(0, getResources().getDimensionPixelSize(u.e.fontsize24));
        av.b(this.anJ, u.d.cp_cont_g, 1, 0);
        this.anJ.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.anJ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(u.f.icon_see_arrow), (Drawable) null);
        this.anJ.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds20);
        this.anJ.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(u.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(u.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(u.e.ds20);
        layoutParams.addRule(1, this.anI.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.anJ.setOnClickListener(this);
        this.anJ.setMinHeight(getResources().getDimensionPixelSize(u.e.ds100));
        addView(this.anJ, layoutParams);
        this.anJ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR() {
        if (this.anJ != null) {
            boolean z = this.anM || this.anN;
            if (!this.aml && z && this.anP != null && this.anP.threadId > 0 && this.anP.postId > 0 && this.anP.mThreadType != 33) {
                this.anJ.setVisibility(0);
                if (this.anT != null) {
                    this.anT.setVisibility(0);
                    return;
                }
                return;
            }
            this.anJ.setVisibility(8);
            if (this.anT != null) {
                this.anT.setVisibility(8);
            }
        }
    }

    private void zS() {
        if (this.anJ != null) {
            this.anJ.setVisibility(8);
            if (this.anT != null) {
                this.anT.setVisibility(8);
            }
        }
    }

    public void bi(boolean z) {
        this.aml = z;
        if (this.aml) {
            zS();
        } else {
            zR();
        }
    }

    public void o(String str, boolean z) {
        this.anH.setTag(str);
        this.anH.setLoadBigImage(false);
        this.anH.setImageDrawable(null);
        this.anM = false;
        this.anN = false;
        boolean eN = eN(str);
        this.anQ = bn(true);
        if (!this.anQ) {
            p(str, eN);
        }
        if (eN) {
            q(str, z);
        }
    }

    private boolean bk(boolean z) {
        if (!this.anR || z) {
            this.anR = true;
            if (!this.anQ || this.anP == null || StringUtils.isNull(this.anP.originalUrl, true) || this.anP.originalSize < 0 || this.anK.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dA = bc.dA(this.anP.originalUrl);
            this.anK.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.tX().du(dA) + "/" + dA));
            this.anK.setVisibility(0);
            return true;
        }
        return false;
    }

    public void zT() {
        bk(false);
    }

    private boolean eN(String str) {
        return com.baidu.adp.lib.util.i.fq() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dO(str);
    }

    private void p(String str, boolean z) {
        if (this.anP == null) {
            bl(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dO(str)) {
            bl(z);
        } else if (!TextUtils.isEmpty(this.anP.imageUrl)) {
            com.baidu.adp.lib.g.c.dF().a(this.anP.imageUrl, this.anP.urlType, new y(this, z), 0, 0, true, null, new Object[0]);
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
        if (eO(str)) {
            if (z2 || (!this.anO && !this.anN)) {
                if (!z2 || !bk(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.anO = true;
                    com.baidu.adp.lib.g.c.dF().a(str, 27, new z(this), 0, 0, false, null, Boolean.valueOf(z), this.anH.getImageData(), Boolean.valueOf(this.alt));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.D(this.sS, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.anU.a(imageFileInfo, false);
        if (a2 != null) {
            this.anN = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.anU.a(imageFileInfo, new aa(this), false);
    }

    private boolean eO(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.anL != null) {
                this.anL.i(aVar.getUrl(), aVar.jf());
            }
            Bitmap ja = aVar.ja();
            if (ja == null) {
                if (!this.anM) {
                    this.anH.FZ();
                    return;
                }
                this.anN = false;
                p(null, false);
                return;
            }
            if (aVar.cd()) {
                this.anH.a(aVar.jf(), ja);
                this.anS = false;
                this.anI.setVisibility(8);
            } else {
                this.anH.setImageBitmap(ja);
                this.anH.setImageData(aVar.jf());
                if (this.anS) {
                    this.anI.setVisibility(0);
                }
            }
            zR();
            this.anH.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.anH.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.anH != null) {
            this.anH.onDestroy();
        }
        if (this.anK != null) {
            this.anK.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.anH != null) {
            this.anH.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zU() {
        if (this.anH != null && this.anH.getImageType() == 1) {
            this.anH.stop();
        }
    }

    public void bm(boolean z) {
        f(z, false);
    }

    public void f(boolean z, boolean z2) {
        String str;
        if (this.anH != null && (str = (String) this.anH.getTag()) != null) {
            if ((!eO(str) || com.baidu.adp.lib.util.i.fq()) && this.anH != null) {
                if (this.anH.getImageType() == 1) {
                    if (this.anH.getGifCache() == null || !this.anH.Gg()) {
                        e(str, z, z2);
                    }
                } else if (this.anH.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.anH.getImageBitmap() == null || !this.anH.Gg()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.anH != null) {
            return this.anH.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.anP = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.alt = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.anI) {
            String dA = bc.dA(this.anP.originalUrl);
            if (this.anP.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Bd().A(dA, 13);
                this.anP.originalProcess = -1;
                if (this.anP.originalSize > 0) {
                    this.anI.setText(String.valueOf(anG) + "(" + ba.G(this.anP.originalSize) + ")");
                } else {
                    this.anI.setText(anG);
                }
                this.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.alv != null) {
                this.alv.zW();
            }
            com.baidu.adp.base.h<?> s = com.baidu.adp.base.l.s(this.mContext);
            if (s == null) {
                eP(dA);
            } else if (!com.baidu.adp.lib.util.i.fq() || com.baidu.adp.lib.util.i.fr() || com.baidu.tbadk.core.sharedPref.b.sN().getBoolean("original_img_down_tip", false)) {
                eP(dA);
            } else {
                com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(s.getPageActivity());
                aVar.bM(u.j.original_img_down_no_wifi_tip);
                aVar.a(u.j.alert_yes_button, new ab(this, aVar, dA));
                aVar.b(u.j.alert_no_button, new ac(this, aVar));
                aVar.b(s);
                aVar.rS();
            }
        } else if (view == this.anJ && this.anP != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.anP.threadId), String.valueOf(this.anP.postId), this.anP.mIsSeeHost, this.anP.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(String str) {
        if (this.anP != null) {
            this.anP.originalProcess = 0;
        }
        this.anI.setText("0%");
        this.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.anP.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.tX().du(str) + "/" + str);
        downloadData.setCallback(new ad(this));
        com.baidu.tbadk.download.e.Bd().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bn(boolean z) {
        if (this.anP != null && !StringUtils.isNull(this.anP.originalUrl, true) && this.anP.originalSize >= 0) {
            String dA = bc.dA(this.anP.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.tX().du(dA) + "/" + dA).exists()) {
                this.anP.originalProcess = 100;
                if (z) {
                    this.anI.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.anP.originalProcess < 0) {
                if (this.anP.originalSize > 0) {
                    this.anI.setText(String.valueOf(anG) + "(" + ba.G(this.anP.originalSize) + ")");
                } else {
                    this.anI.setText(anG);
                }
                this.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.anI.setText(String.valueOf(this.anP.originalProcess) + "%");
                this.anI.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.f.icon_close_yuantu, 0);
            }
            this.anS = true;
        } else {
            this.anI.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.alv = bVar;
    }
}
