package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.widget.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class ab extends RelativeLayout {
    private boolean ali;
    protected com.baidu.tbadk.widget.a anD;
    private a anE;
    private boolean anF;
    private boolean anG;
    private ImageUrlData anH;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    /* loaded from: classes.dex */
    public interface a {
        void i(String str, byte[] bArr);
    }

    public void setHeadImage(boolean z) {
        if (this.anD != null) {
            this.anD.setIsHeadImage(z);
        }
    }

    public void setCallback(a aVar) {
        this.anE = aVar;
    }

    public ab(Context context) {
        super(context);
        this.mProgressBar = null;
        this.anD = null;
        this.mContext = null;
        this.anE = null;
        this.ali = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.anD;
    }

    public void setGifSetListener(a.d dVar) {
        this.anD.setGifSetListener(dVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.anD.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.anD.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(a.e eVar) {
        this.anD.setOnSizeChangedListener(eVar);
    }

    protected void init() {
        this.anD = new com.baidu.tbadk.widget.a(this.mContext);
        this.anD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.anD);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void p(String str, boolean z) {
        this.anD.setTag(str);
        this.anD.setLoadBigImage(false);
        this.anD.setImageDrawable(null);
        this.anF = false;
        this.anG = false;
        boolean et = et(str);
        q(str, et);
        if (et) {
            r(str, z);
        }
    }

    private boolean et(String str) {
        return com.baidu.adp.lib.util.i.iL() || com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str);
    }

    private void q(String str, boolean z) {
        if (this.anH == null) {
            aY(z);
        } else if (com.baidu.tbadk.core.util.resourceLoaderProc.c.checkFileExist(str)) {
            aY(z);
        } else if (!TextUtils.isEmpty(this.anH.imageUrl)) {
            com.baidu.adp.lib.f.c.gZ().a(this.anH.imageUrl, this.anH.urlType, new ac(this, z), 0, 0, true, null, new Object[0]);
        } else {
            aY(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(boolean z) {
        if (!z) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void r(String str, boolean z) {
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.c.gZ().a(str, 27, new ad(this), 0, 0, false, null, Boolean.valueOf(z), this.anD.getImageData(), Boolean.valueOf(this.ali));
    }

    public void setGifMaxUseableMem(int i) {
        this.anD.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.anD != null) {
            this.anD.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.anD != null) {
            this.anD.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void zA() {
        if (this.anD != null && this.anD.getImageType() == 1) {
            this.anD.stop();
        }
    }

    public void aZ(boolean z) {
        String str;
        if (this.anD != null && (str = (String) this.anD.getTag()) != null && com.baidu.adp.lib.util.i.iL() && this.anD != null) {
            if (this.anD.getImageType() == 1) {
                if (this.anD.getGifCache() == null || !this.anD.Fa()) {
                    r(str, z);
                }
            } else if (this.anD.getImageType() == 2) {
                r(str, z);
            } else if (this.anD.getImageBitmap() == null || !this.anD.Fa()) {
                r(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.anD != null) {
            return this.anD.getImageType();
        }
        return 0;
    }

    public void setAssistUrl(ImageUrlData imageUrlData) {
        this.anH = imageUrlData;
    }

    public void setIsCdn(boolean z) {
        this.ali = z;
    }
}
