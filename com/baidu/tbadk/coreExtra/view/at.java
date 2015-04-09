package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class at extends RelativeLayout {
    private boolean aeF;
    protected com.baidu.tbadk.widget.a afK;
    private aw afL;
    private boolean afM;
    private boolean afN;
    private ImageUrlData afO;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.afK != null) {
            this.afK.setIsHeadImage(z);
        }
    }

    public void setCallback(aw awVar) {
        this.afL = awVar;
    }

    public at(Context context) {
        super(context);
        this.mProgressBar = null;
        this.afK = null;
        this.mContext = null;
        this.afL = null;
        this.aeF = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.afK;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.g gVar) {
        this.afK.setGifSetListener(gVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.afK.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.afK.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.h hVar) {
        this.afK.setOnSizeChangedListener(hVar);
    }

    protected void init() {
        this.afK = new com.baidu.tbadk.widget.a(this.mContext);
        this.afK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.afK);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.afK.setTag(str);
        this.afK.setLoadBigImage(false);
        this.afK.setImageDrawable(null);
        this.afM = false;
        this.afN = false;
        boolean dR = dR(str);
        o(str, dR);
        if (dR) {
            p(str, z);
        }
    }

    private boolean dR(String str) {
        return com.baidu.adp.lib.util.k.iH() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void o(String str, boolean z) {
        if (this.afO == null) {
            aG(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aG(z);
        } else if (!TextUtils.isEmpty(this.afO.imageUrl)) {
            com.baidu.adp.lib.f.d.hB().a(this.afO.imageUrl, this.afO.urlType, new au(this, z), 0, 0, true, null, new Object[0]);
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
        com.baidu.adp.lib.f.d.hB().a(str, 27, new av(this), 0, 0, false, null, Boolean.valueOf(z), this.afK.getImageData(), Boolean.valueOf(this.aeF));
    }

    public void setGifMaxUseableMem(int i) {
        this.afK.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.afK != null) {
            this.afK.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.afK != null) {
            this.afK.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void xq() {
        if (this.afK != null && this.afK.getImageType() == 1) {
            this.afK.stop();
        }
    }

    public void aH(boolean z) {
        String str;
        if (this.afK != null && (str = (String) this.afK.getTag()) != null && com.baidu.adp.lib.util.k.iH() && this.afK != null) {
            if (this.afK.getImageType() == 1) {
                if (this.afK.getGifCache() == null || !this.afK.Dw()) {
                    p(str, z);
                }
            } else if (this.afK.getImageType() == 2) {
                p(str, z);
            } else if (this.afK.getImageBitmap() == null || !this.afK.Dw()) {
                p(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.afK != null) {
            return this.afK.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.afO = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.aeF = z;
    }
}
