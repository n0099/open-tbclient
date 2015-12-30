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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.n;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
/* loaded from: classes.dex */
public class z extends RelativeLayout implements View.OnClickListener {
    private static final String apn = TbadkCoreApplication.m411getInst().getString(n.j.original_img_look);
    private int Bx;
    private boolean amZ;
    private boolean anT;
    private b anb;
    private boolean apA;
    private TextView apB;
    private com.baidu.tbadk.img.b apC;
    private Runnable apD;
    private SubsamplingScaleImageView.OnImageEventListener apE;
    protected com.baidu.tbadk.widget.a apo;
    protected TextView apq;
    protected TextView apr;
    protected SubsamplingScaleImageView aps;
    private a apt;
    private boolean apu;
    private boolean apv;
    private boolean apw;
    private ImageUrlData apx;
    private boolean apy;
    private boolean apz;
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
        void Ad();
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            if (this.apq != null) {
                as.i((View) this.apq, n.f.btn_percent_yuantu);
                as.a(this.apq, n.d.cp_cont_g, 1, 0);
            }
            if (this.apr != null) {
                as.j((View) this.apr, n.d.transparent);
                as.a(this.apr, n.d.cp_cont_g, 1, 0);
            }
            this.mSkinType = i;
        }
    }

    public void setHeadImage(boolean z) {
        if (this.apo != null) {
            this.apo.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.apt = aVar;
    }

    public z(Context context) {
        super(context);
        this.mSkinType = 3;
        this.mProgressBar = null;
        this.apo = null;
        this.mContext = null;
        this.apt = null;
        this.amZ = false;
        this.apw = false;
        this.apy = false;
        this.apz = false;
        this.anT = false;
        this.apA = false;
        this.apB = null;
        this.apD = new aa(this);
        this.apE = new ac(this);
        this.mContext = context;
        this.apC = new com.baidu.tbadk.img.b();
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.apo;
    }

    public void setGifSetListener(a.d dVar) {
        this.apo.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.apo.setImageOnClickListener(onClickListener);
        this.aps.setOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.apo.setImageOnLongClickListener(onLongClickListener);
        this.aps.setOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.apo.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.Bx = com.baidu.adp.lib.util.k.K(this.mContext);
        this.mMaxHeight = com.baidu.adp.lib.util.k.L(this.mContext) - ((int) this.mContext.getResources().getDimension(n.e.album_bottom_height));
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.apo = new com.baidu.tbadk.widget.a(this.mContext);
        this.apo.setLayoutParams(layoutParams);
        addView(this.apo);
        this.aps = new SubsamplingScaleImageView(this.mContext);
        this.aps.setMaxScale(50.0f);
        this.aps.setOnImageEventListener(this.apE);
        this.aps.setVisibility(4);
        addView(this.aps, layoutParams);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(n.f.progressbar));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams2);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
        zW();
        this.apq = new TextView(this.mContext);
        as.i((View) this.apq, n.f.btn_percent_yuantu);
        this.apq.setText(n.j.original_img_look);
        this.apq.setTextSize(0, getResources().getDimensionPixelSize(n.e.fontsize28));
        as.a(this.apq, n.d.cp_cont_g, 1, 0);
        this.apq.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.ds20);
        this.apq.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.apq.setMinWidth(getResources().getDimensionPixelSize(n.e.ds220));
        this.apq.setMinHeight(getResources().getDimensionPixelSize(n.e.ds68));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.bottomMargin = getResources().getDimensionPixelSize(n.e.fontsize40);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        this.apq.setOnClickListener(this);
        this.apq.setVisibility(8);
        addView(this.apq, layoutParams3);
        zX();
    }

    private void zW() {
        this.apB = new TextView(this.mContext);
        this.apB.setBackgroundResource(n.f.bg_url_drag_imagview_fade_view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(n.e.ds180);
        layoutParams.addRule(12);
        addView(this.apB, layoutParams);
        this.apB.setVisibility(8);
    }

    private void zX() {
        this.apr = new TextView(this.mContext);
        as.j((View) this.apr, n.d.transparent);
        this.apr.setText(n.j.goto_pb_floor);
        this.apr.setTextSize(0, getResources().getDimensionPixelSize(n.e.fontsize24));
        as.a(this.apr, n.d.cp_cont_g, 1, 0);
        this.apr.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(this.mContext, 4.0f));
        this.apr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, as.getDrawable(n.f.icon_see_arrow), (Drawable) null);
        this.apr.setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.ds20);
        this.apr.setPadding(dimensionPixelSize * 3, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = getResources().getDimensionPixelSize(n.e.ds30);
        layoutParams.rightMargin = getResources().getDimensionPixelSize(n.e.ds10);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(n.e.ds20);
        layoutParams.addRule(1, this.apq.getId());
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.apr.setOnClickListener(this);
        this.apr.setMinHeight(getResources().getDimensionPixelSize(n.e.ds100));
        addView(this.apr, layoutParams);
        this.apr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zY() {
        if (this.apr != null) {
            boolean z = this.apu || this.apv;
            if (!this.anT && z && this.apx != null && this.apx.threadId > 0 && this.apx.postId > 0) {
                this.apr.setVisibility(0);
                if (this.apB != null) {
                    this.apB.setVisibility(0);
                    return;
                }
                return;
            }
            this.apr.setVisibility(8);
            if (this.apB != null) {
                this.apB.setVisibility(8);
            }
        }
    }

    private void zZ() {
        if (this.apr != null) {
            this.apr.setVisibility(8);
            if (this.apB != null) {
                this.apB.setVisibility(8);
            }
        }
    }

    public void aU(boolean z) {
        this.anT = z;
        if (this.anT) {
            zZ();
        } else {
            zY();
        }
    }

    public void p(String str, boolean z) {
        this.apo.setTag(str);
        this.apo.setLoadBigImage(false);
        this.apo.setImageDrawable(null);
        this.apu = false;
        this.apv = false;
        boolean eI = eI(str);
        this.apy = aY(true);
        if (!this.apy) {
            q(str, eI);
        }
        if (eI) {
            r(str, z);
        }
    }

    private boolean aV(boolean z) {
        if (!this.apz || z) {
            this.apz = true;
            if (!this.apy || this.apx == null || StringUtils.isNull(this.apx.originalUrl, true) || this.apx.originalSize < 0 || this.aps.isImageLoaded() || Build.VERSION.SDK_INT < 10) {
                return false;
            }
            String dB = az.dB(this.apx.originalUrl);
            this.aps.setImage(ImageSource.uri(String.valueOf(com.baidu.tbadk.core.util.n.tS()) + aw.uU().dv(dB) + "/" + dB));
            this.aps.setVisibility(0);
            return true;
        }
        return false;
    }

    public void Aa() {
        aV(false);
    }

    private boolean eI(String str) {
        return com.baidu.adp.lib.util.i.iQ() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void q(String str, boolean z) {
        if (this.apx == null) {
            aW(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aW(z);
        } else if (!TextUtils.isEmpty(this.apx.imageUrl)) {
            com.baidu.adp.lib.g.c.hd().a(this.apx.imageUrl, this.apx.urlType, new ad(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aW(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void r(String str, boolean z) {
        d(str, z, false);
    }

    private void d(String str, boolean z, boolean z2) {
        if (eJ(str)) {
            if (z2 || (!this.apw && !this.apv)) {
                if (!z2 || !aV(true)) {
                    this.mProgressBar.setVisibility(0);
                    this.apw = true;
                    com.baidu.adp.lib.g.c.hd().a(str, 27, new ae(this), 0, 0, false, null, Boolean.valueOf(z), this.apo.getImageData(), Boolean.valueOf(this.amZ));
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
        imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.K(this.Bx, this.mMaxHeight));
        com.baidu.adp.widget.a.a a2 = this.apC.a(imageFileInfo, false);
        if (a2 != null) {
            this.apv = true;
            this.mProgressBar.setVisibility(8);
            b(a2);
            return;
        }
        this.apC.a(imageFileInfo, new af(this), false);
    }

    private boolean eJ(String str) {
        return !TextUtils.isEmpty(str) && (str.startsWith("http://") || str.startsWith("https://"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            if (this.apt != null) {
                this.apt.i(aVar.getUrl(), aVar.mJ());
            }
            Bitmap mE = aVar.mE();
            if (mE == null) {
                if (!this.apu) {
                    this.apo.setDefaultBitmap();
                    return;
                }
                this.apv = false;
                q(null, false);
                return;
            }
            if (aVar.fF()) {
                this.apo.a(aVar.mJ(), mE);
                this.apA = false;
                this.apq.setVisibility(8);
            } else {
                this.apo.setImageBitmap(mE);
                this.apo.setImageData(aVar.mJ());
                if (this.apA) {
                    this.apq.setVisibility(0);
                }
            }
            zY();
            this.apo.setLoadBigImage(true);
        }
    }

    public void setGifMaxUseableMem(int i) {
        this.apo.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.apo != null) {
            this.apo.onDestroy();
        }
        if (this.aps != null) {
            this.aps.recycle();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.apo != null) {
            this.apo.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void Ab() {
        if (this.apo != null && this.apo.getImageType() == 1) {
            this.apo.stop();
        }
    }

    public void aX(boolean z) {
        f(z, false);
    }

    public void f(boolean z, boolean z2) {
        String str;
        if (this.apo != null && (str = (String) this.apo.getTag()) != null) {
            if ((!eJ(str) || com.baidu.adp.lib.util.i.iQ()) && this.apo != null) {
                if (this.apo.getImageType() == 1) {
                    if (this.apo.getGifCache() == null || !this.apo.Fv()) {
                        d(str, z, z2);
                    }
                } else if (this.apo.getImageType() == 2) {
                    d(str, z, z2);
                } else if (this.apo.getImageBitmap() == null || !this.apo.Fv()) {
                    d(str, z, z2);
                }
            }
        }
    }

    public int getImageType() {
        if (this.apo != null) {
            return this.apo.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.apx = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.amZ = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.apq) {
            String dB = az.dB(this.apx.originalUrl);
            if (this.apx.originalProcess >= 0) {
                com.baidu.tbadk.download.d.Be().v(dB, 13);
                this.apx.originalProcess = -1;
                if (this.apx.originalSize > 0) {
                    this.apq.setText(String.valueOf(apn) + "(" + ax.D(this.apx.originalSize) + ")");
                } else {
                    this.apq.setText(apn);
                }
                this.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                return;
            }
            if (this.anb != null) {
                this.anb.Ad();
            }
            com.baidu.adp.base.h<?> C = com.baidu.adp.base.l.C(this.mContext);
            if (C == null) {
                eK(dB);
            } else if (!com.baidu.adp.lib.util.i.iQ() || com.baidu.adp.lib.util.i.iR() || com.baidu.tbadk.core.sharedPref.b.tJ().getBoolean("original_img_down_tip", false)) {
                eK(dB);
            } else {
                com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("original_img_down_tip", true);
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(C.getPageActivity());
                aVar.bG(n.j.original_img_down_no_wifi_tip);
                aVar.a(n.j.alert_yes_button, new ag(this, aVar, dB));
                aVar.b(n.j.alert_no_button, new ah(this, aVar));
                aVar.b(C);
                aVar.tf();
            }
        } else if (view == this.apr && this.apx != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createHistoryCfg(String.valueOf(this.apx.threadId), String.valueOf(this.apx.postId), this.apx.mIsSeeHost, this.apx.mIsReserver, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eK(String str) {
        if (this.apx != null) {
            this.apx.originalProcess = 0;
        }
        this.apq.setText("0%");
        this.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.f.icon_close_yuantu, 0);
        DownloadData downloadData = new DownloadData(str);
        downloadData.setStatus(1);
        downloadData.setUrl(this.apx.originalUrl);
        downloadData.setType(13);
        downloadData.setPath(String.valueOf(com.baidu.tbadk.core.util.n.tS()) + aw.uU().dv(str) + "/" + str);
        downloadData.setCallback(new ai(this));
        com.baidu.tbadk.download.d.Be().a(downloadData, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aY(boolean z) {
        if (this.apx != null && !StringUtils.isNull(this.apx.originalUrl, true) && this.apx.originalSize >= 0) {
            String dB = az.dB(this.apx.originalUrl);
            if (new File(String.valueOf(com.baidu.tbadk.core.util.n.tS()) + aw.uU().dv(dB) + "/" + dB).exists()) {
                this.apx.originalProcess = 100;
                if (z) {
                    this.apq.setVisibility(8);
                    return true;
                }
                return true;
            }
            if (this.apx.originalProcess < 0) {
                if (this.apx.originalSize > 0) {
                    this.apq.setText(String.valueOf(apn) + "(" + ax.D(this.apx.originalSize) + ")");
                } else {
                    this.apq.setText(apn);
                }
                this.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.apq.setText(String.valueOf(this.apx.originalProcess) + "%");
                this.apq.setCompoundDrawablesWithIntrinsicBounds(0, 0, n.f.icon_close_yuantu, 0);
            }
            this.apA = true;
        } else {
            this.apq.setVisibility(8);
        }
        return false;
    }

    public void setOriImgSelectedCallback(b bVar) {
        this.anb = bVar;
    }
}
