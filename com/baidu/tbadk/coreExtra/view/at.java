package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class at extends RelativeLayout {
    private boolean aex;
    protected com.baidu.tbadk.widget.a afC;
    private aw afD;
    private boolean afE;
    private boolean afF;
    private ImageUrlData afG;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.afC != null) {
            this.afC.setIsHeadImage(z);
        }
    }

    public void setCallback(aw awVar) {
        this.afD = awVar;
    }

    public at(Context context) {
        super(context);
        this.mProgressBar = null;
        this.afC = null;
        this.mContext = null;
        this.afD = null;
        this.aex = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.afC;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.g gVar) {
        this.afC.setGifSetListener(gVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.afC.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afC.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.h hVar) {
        this.afC.setOnSizeChangedListener(hVar);
    }

    protected void init() {
        this.afC = new com.baidu.tbadk.widget.a(this.mContext);
        this.afC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.afC);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.afC.setTag(str);
        this.afC.setLoadBigImage(false);
        this.afC.setImageDrawable(null);
        this.afE = false;
        this.afF = false;
        boolean dO = dO(str);
        o(str, dO);
        if (dO) {
            p(str, z);
        }
    }

    private boolean dO(String str) {
        return com.baidu.adp.lib.util.k.iH() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void o(String str, boolean z) {
        if (this.afG == null) {
            aG(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aG(z);
        } else if (!TextUtils.isEmpty(this.afG.imageUrl)) {
            com.baidu.adp.lib.f.d.hB().a(this.afG.imageUrl, this.afG.urlType, new au(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aG(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void p(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.hB().a(str, 27, new av(this), 0, 0, false, null, Boolean.valueOf(z), this.afC.getImageData(), Boolean.valueOf(this.aex));
    }

    public void setGifMaxUseableMem(int i) {
        this.afC.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.afC != null) {
            this.afC.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.afC != null) {
            this.afC.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void xk() {
        if (this.afC != null && this.afC.getImageType() == 1) {
            this.afC.stop();
        }
    }

    public void aH(boolean z) {
        String str;
        if (this.afC != null && (str = (String) this.afC.getTag()) != null && com.baidu.adp.lib.util.k.iH() && this.afC != null) {
            if (this.afC.getImageType() == 1) {
                if (this.afC.getGifCache() == null || !this.afC.Dq()) {
                    p(str, z);
                }
            } else if (this.afC.getImageType() == 2) {
                p(str, z);
            } else if (this.afC.getImageBitmap() == null || !this.afC.Dq()) {
                p(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.afC != null) {
            return this.afC.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.afG = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aex = z;
    }
}
