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
import com.baidu.tieba.t;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class u extends RelativeLayout implements View.OnClickListener {
    private static final String aqN = TbadkCoreApplication.m9getInst().getString(t.j.original_img_look);
    private b aoB;
    private boolean aoz;
    private boolean aps;
    protected com.baidu.tbadk.widget.a aqO;
    protected TextView aqP;
    protected TextView aqQ;
    protected SubsamplingScaleImageView aqR;
    private a aqS;
    private boolean aqT;
    private boolean aqU;
    private boolean aqV;
    private ImageUrlData aqW;
    private boolean aqX;
    private boolean aqY;
    private boolean aqZ;
    private TextView ara;
    private com.baidu.tbadk.img.b arb;
    private Runnable arc;
    private SubsamplingScaleImageView.OnImageEventListener ard;
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
        void Bl();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.aqP != null) {
                av.k(this.aqP, t.f.btn_percent_yuantu);
                av.b(this.aqP, t.d.cp_cont_g, 1, 0);
            }
            if (this.aqQ != null) {
                av.l(this.aqQ, t.d.common_color_10022);
                av.b(this.aqQ, t.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.aqO != null) {
            this.aqO.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.aqS = aVar;
    }

    public u(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.aqO = null;
        this.mContext = null;
        this.aqS = null;
        this.aoz = false;
        this.aqV = false;
        this.aqX = false;
        this.aqY = false;
        this.aps = false;
        this.aqZ = false;
        this.ara = null;
        this.arc = new v(this);
        this.ard = new x(this);
        this.mContext = context;
        this.arb = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.aqO;
    }

    public void setGifSetListener(a.d dVar) {
        this.aqO.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aqO.setImageOnClickListener(onClickListener);
        this.aqR.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aqO.setImageOnLongClickListener(onLongClickListener);
        this.aqR.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.aqO.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.vi = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(t.e.ds166));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.aqO = new com.baidu.tbadk.widget.a(this.mContext);
        this.aqO.setLayoutParams(layoutParams);
        addView(this.aqO);
        this.aqR = new SubsamplingScaleImageView(this.mContext);
        this.aqR.setMaxScale(50.0f);
        this.aqR.setOnImageEventListener(this.ard);
        this.aqR.setVisibility(4);
        addView(this.aqR, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(t.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        Be();
        this.aqP = new TextView(this.mContext);
        av.k(this.aqP, t.f.btn_percent_yuantu);
        this.aqP.setText(t.j.original_img_look);
        this.aqP.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize28));
        av.b(this.aqP, t.d.cp_cont_g, 1, 0);
        this.aqP.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.aqP.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.aqP.setMinWidth(getResources().getDimensionPixelSize(t.e.ds220));
        this.aqP.setMinHeight(getResources().getDimensionPixelSize(t.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(t.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.aqP.setOnClickListener(this);
        this.aqP.setVisibility(8);
        addView(this.aqP, layoutParams3);
        Bf();
    }

    private void Be() {
        this.ara = new TextView(this.mContext);
        this.ara.setBackgroundResource(t.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(t.e.ds180);
        layoutParams.addRule(12);
        addView(this.ara, layoutParams);
        this.ara.setVisibility(8);
    }

    private void Bf() {
        this.aqQ = new TextView(this.mContext);
        av.l(this.aqQ, t.d.common_color_10022);
        this.aqQ.setText(t.j.goto_pb_floor);
        this.aqQ.setTextSize(0, getResources().getDimensionPixelSize(t.e.fontsize24));
        av.b(this.aqQ, t.d.cp_cont_g, 1, 0);
        this.aqQ.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.aqQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, av.getDrawable(t.f.icon_see_arrow), (Drawable) null);
        this.aqQ.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds20);
        this.aqQ.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(t.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(t.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(t.e.ds20);
        layoutParams.addRule(1, this.aqP.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.aqQ.setOnClickListener(this);
        this.aqQ.setMinHeight(getResources().getDimensionPixelSize(t.e.ds100));
        addView(this.aqQ, layoutParams);
        this.aqQ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bg() {
        if (this.aqQ != null) {
            boolean z = this.aqT || this.aqU;
            if (!this.aps && z && this.aqW != null && this.aqW.threadId > 0 && this.aqW.postId > 0 && this.aqW.mThreadType != 33) {
                this.aqQ.setVisibility(0);
                if (this.ara != null) {
                    this.ara.setVisibility(0);
                    return;
                }
                return;
            }
            this.aqQ.setVisibility(8);
            if (this.ara != null) {
                this.ara.setVisibility(8);
            }
        }
    }

    private void Bh() {
        if (this.aqQ != null) {
            this.aqQ.setVisibility(8);
            if (this.ara != null) {
                this.ara.setVisibility(8);
            }
        }
    }

    public void bk(boolean z) {
        this.aps = z;
        if (this.aps) {
            Bh();
        } else {
            Bg();
        }
    }

    public void p(String str, boolean z) {
        this.aqO.setTag(str);
        this.aqO.setLoadBigImage(false);
        this.aqO.setImageDrawable(null);
        this.aqT = false;
        this.aqU = false;
        boolean eQ = eQ(str);
        this.aqX = bp(true);
        if (!this.aqX) {
            q(str, eQ);
        }
        if (eQ) {
            r(str, z);
        }
    }

    private boolean bm(boolean z) {
        if (!this.aqY || z) {
            this.aqY = true;
            if (!this.aqX || this.aqW == null || StringUtils.isNull(this.aqW.originalUrl, true) || this.aqW.originalSize < 0 || this.aqR.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dC = bc.dC(this.aqW.originalUrl);
            this.aqR.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.vd().dx(dC) + "/" + dC));
            this.aqR.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Bi() {
        bm(false);
    }

    private boolean eQ(String str) {
        return com.baidu.adp.lib.util.i.gm() || com.baidu.tbadk.core.util.resourceLoaderProc.c.dQ(str);
    }

    private void q(String str, boolean z) {
        if (this.aqW == null) {
            bn(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.dQ(str)) {
            bn(z);
        } else if (!TextUtils.isEmpty(this.aqW.imageUrl)) {
            com.baidu.adp.lib.g.c.eA().a(this.aqW.imageUrl, this.aqW.urlType, new y(this, z), 0, 0, true, null, new Object[0]);
        } else {
            bn(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bn(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void r(String str, boolean z) {
        e(str, z, false);
    }

    private void e(String str, boolean z, boolean z2) {
        if (eR(str)) {
            if (z2 || (!this.aqV && !this.aqU)) {
                if (!z2 || !bm(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.aqV = true;
                    com.baidu.adp.lib.g.c.eA().a(str, 27, new z(this), 0, 0, false, null, Boolean.valueOf(z), this.aqO.getImageData(), Boolean.valueOf(this.aoz));
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
        com.baidu.adp.widget.a.a a2 = this.arb.a(imageFileInfo, false);
        if (a2 != null) {
            this.aqU = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.arb.a(imageFileInfo, new aa(this), false);
    }

    private boolean eR(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.aqS != null) {
                this.aqS.i(aVar.getUrl(), aVar.ka());
            }
            Bitmap jV = aVar.jV();
            if (jV == null) {
                if (!this.aqT) {
                    this.aqO.Ht();
                    return;
                }
                this.aqU = false;
                q(null, false);
                return;
            }
            if (aVar.cY()) {
                this.aqO.a(aVar.ka(), jV);
                this.aqZ = false;
                this.aqP.setVisibility(8);
            } else {
                this.aqO.setImageBitmap(jV);
                this.aqO.setImageData(aVar.ka());
                if (this.aqZ) {
                    this.aqP.setVisibility(0);
                }
            }
            Bg();
            this.aqO.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.aqO.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.aqO != null) {
            this.aqO.onDestroy();
        }
        if (this.aqR != null) {
            this.aqR.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.aqO != null) {
            this.aqO.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Bj() {
        if (this.aqO != null && this.aqO.getImageType() == 1) {
            this.aqO.stop();
        }
    }

    public void bo(boolean z) {
        h(z, false);
    }

    public void h(boolean z, boolean z2) {
        String str;
        if (this.aqO != null && (str = (String) this.aqO.getTag()) != null) {
            if ((!eR(str) || com.baidu.adp.lib.util.i.gm()) && this.aqO != null) {
                if (this.aqO.getImageType() == 1) {
                    if (this.aqO.getGifCache() == null || !this.aqO.HA()) {
                        e(str, z, z2);
                    }
                } else if (this.aqO.getImageType() == 2) {
                    e(str, z, z2);
                } else if (this.aqO.getImageBitmap() == null || !this.aqO.HA()) {
                    e(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.aqO != null) {
            return this.aqO.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.aqW = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aoz = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aqP) {
            String dC = bc.dC(this.aqW.originalUrl);
            if (this.aqW.originalProcess >= 0) {
                com.baidu.tbadk.download.e.Cy().z(dC, 13);
                this.aqW.originalProcess = -1;
                if (this.aqW.originalSize > 0) {
                    this.aqP.setText(String.valueOf(aqN) + "(" + ba.H(this.aqW.originalSize) + ")");
                } else {
                    this.aqP.setText(aqN);
                }
                this.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.aoB != null) {
                this.aoB.Bl();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eS(dC);
            } else if (!com.baidu.adp.lib.util.i.gm() || com.baidu.adp.lib.util.i.gn() || com.baidu.tbadk.core.sharedPref.b.tS().getBoolean("original_img_down_tip", false)) {
                eS(dC);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bZ(t.j.original_img_down_no_wifi_tip);
                aVar.a(t.j.alert_yes_button, new ab(this, aVar, dC));
                aVar.b(t.j.alert_no_button, new ac(this, aVar));
                aVar.b(C);
                aVar.sX();
            }
        } else if (view == this.aqQ && this.aqW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.aqW.threadId), String.valueOf(this.aqW.postId), this.aqW.mIsSeeHost, this.aqW.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(String str) {
        if (this.aqW != null) {
            this.aqW.originalProcess = 0;
        }
        this.aqP.setText("0%");
        this.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.aqW.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.vd().dx(str) + "/" + str);
        downloadData.setCallback(new ad(this));
        com.baidu.tbadk.download.e.Cy().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bp(boolean z) {
        if (this.aqW != null && !StringUtils.isNull(this.aqW.originalUrl, true) && this.aqW.originalSize >= 0) {
            String dC = bc.dC(this.aqW.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.m.getCacheDir()) + az.vd().dx(dC) + "/" + dC).exists()) {
                this.aqW.originalProcess = 100;
                if (z) {
                    this.aqP.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.aqW.originalProcess < 0) {
                if (this.aqW.originalSize > 0) {
                    this.aqP.setText(String.valueOf(aqN) + "(" + ba.H(this.aqW.originalSize) + ")");
                } else {
                    this.aqP.setText(aqN);
                }
                this.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aqP.setText(String.valueOf(this.aqW.originalProcess) + "%");
                this.aqP.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.f.icon_close_yuantu, 0);
            }
            this.aqZ = true;
        } else {
            this.aqP.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.aoB = bVar;
    }
}
