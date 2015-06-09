package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    private boolean afJ;
    protected com.baidu.tbadk.widget.a agL;
    private ax agM;
    private boolean agN;
    private boolean agO;
    private ImageUrlData agP;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.agL != null) {
            this.agL.setIsHeadImage(z);
        }
    }

    public void setCallback(ax axVar) {
        this.agM = axVar;
    }

    public au(Context context) {
        super(context);
        this.mProgressBar = null;
        this.agL = null;
        this.mContext = null;
        this.agM = null;
        this.afJ = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.agL;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.g gVar) {
        this.agL.setGifSetListener(gVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.agL.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.agL.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.h hVar) {
        this.agL.setOnSizeChangedListener(hVar);
    }

    protected void init() {
        this.agL = new com.baidu.tbadk.widget.a(this.mContext);
        this.agL.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.agL);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.p.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.agL.setTag(str);
        this.agL.setLoadBigImage(false);
        this.agL.setImageDrawable(null);
        this.agN = false;
        this.agO = false;
        boolean ei = ei(str);
        o(str, ei);
        if (ei) {
            p(str, z);
        }
    }

    private boolean ei(String str) {
        return com.baidu.adp.lib.util.k.iX() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void o(String str, boolean z) {
        if (this.agP == null) {
            aN(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aN(z);
        } else if (!TextUtils.isEmpty(this.agP.imageUrl)) {
            com.baidu.adp.lib.f.d.hl().a(this.agP.imageUrl, this.agP.urlType, new av(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aN(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void p(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.hl().a(str, 27, new aw(this), 0, 0, false, null, Boolean.valueOf(z), this.agL.getImageData(), Boolean.valueOf(this.afJ));
    }

    public void setGifMaxUseableMem(int i) {
        this.agL.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.agL != null) {
            this.agL.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.agL != null) {
            this.agL.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void ye() {
        if (this.agL != null && this.agL.getImageType() == 1) {
            this.agL.stop();
        }
    }

    public void aO(boolean z) {
        String str;
        if (this.agL != null && (str = (String) this.agL.getTag()) != null && com.baidu.adp.lib.util.k.iX() && this.agL != null) {
            if (this.agL.getImageType() == 1) {
                if (this.agL.getGifCache() == null || !this.agL.Eh()) {
                    p(str, z);
                }
            } else if (this.agL.getImageType() == 2) {
                p(str, z);
            } else if (this.agL.getImageBitmap() == null || !this.agL.Eh()) {
                p(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.agL != null) {
            return this.agL.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.agP = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.afJ = z;
    }
}
