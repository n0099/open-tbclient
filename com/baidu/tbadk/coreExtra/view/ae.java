package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ae extends RelativeLayout {
    private boolean akQ;
    protected com.baidu.tbadk.widget.a alR;
    private a alS;
    private boolean alT;
    private boolean alU;
    private ImageUrlData alV;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    public void setHeadImage(boolean z) {
        if (this.alR != null) {
            this.alR.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.alS = aVar;
    }

    public ae(Context context) {
        super(context);
        this.mProgressBar = null;
        this.alR = null;
        this.mContext = null;
        this.alS = null;
        this.akQ = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.alR;
    }

    public void setGifSetListener(a.d dVar) {
        this.alR.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.alR.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.alR.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.alR.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.alR = new com.baidu.tbadk.widget.a(this.mContext);
        this.alR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.alR);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.alR.setTag(str);
        this.alR.setLoadBigImage(false);
        this.alR.setImageDrawable(null);
        this.alT = false;
        this.alU = false;
        boolean el = el(str);
        o(str, el);
        if (el) {
            p(str, z);
        }
    }

    private boolean el(String str) {
        return com.baidu.adp.lib.util.i.iO() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void o(String str, boolean z) {
        if (this.alV == null) {
            aR(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aR(z);
        } else if (!TextUtils.isEmpty(this.alV.imageUrl)) {
            com.baidu.adp.lib.f.c.hc().a(this.alV.imageUrl, this.alV.urlType, new af(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aR(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void p(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.c.hc().a(str, 27, new ag(this), 0, 0, false, null, Boolean.valueOf(z), this.alR.getImageData(), Boolean.valueOf(this.akQ));
    }

    public void setGifMaxUseableMem(int i) {
        this.alR.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.alR != null) {
            this.alR.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.alR != null) {
            this.alR.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zn() {
        if (this.alR != null && this.alR.getImageType() == 1) {
            this.alR.stop();
        }
    }

    public void aS(boolean z) {
        String str;
        if (this.alR != null && (str = (String) this.alR.getTag()) != null && com.baidu.adp.lib.util.i.iO() && this.alR != null) {
            if (this.alR.getImageType() == 1) {
                if (this.alR.getGifCache() == null || !this.alR.EQ()) {
                    p(str, z);
                }
            } else if (this.alR.getImageType() == 2) {
                p(str, z);
            } else if (this.alR.getImageBitmap() == null || !this.alR.EQ()) {
                p(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.alR != null) {
            return this.alR.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.alV = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.akQ = z;
    }
}
