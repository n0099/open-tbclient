package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    private boolean Of;
    protected com.baidu.tbadk.widget.a Pm;
    private aw Pn;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.Pm != null) {
            this.Pm.setIsHeadImage(z);
        }
    }

    public void setCallback(aw awVar) {
        this.Pn = awVar;
    }

    public au(Context context) {
        super(context);
        this.mProgressBar = null;
        this.Pm = null;
        this.mContext = null;
        this.Pn = null;
        this.Of = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.Pm;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.e eVar) {
        this.Pm.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.Pm.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Pm.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.f fVar) {
        this.Pm.setOnSizeChangedListener(fVar);
    }

    protected void init() {
        this.Pm = new com.baidu.tbadk.widget.a(this.mContext);
        this.Pm.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.Pm);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void k(String str, boolean z) {
        this.Pm.setTag(str);
        if (com.baidu.adp.lib.util.j.fi() || com.baidu.adp.lib.util.j.fl()) {
            l(str, z);
        }
    }

    private void l(String str, boolean z) {
        this.Pm.setImageDrawable(null);
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.ef().a(str, 27, new av(this), 0, 0, null, Boolean.valueOf(z), this.Pm.getImageData(), Boolean.valueOf(this.Of));
    }

    public void setGifMaxUseableMem(int i) {
        this.Pm.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.Pm != null) {
            this.Pm.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.Pm != null) {
            this.Pm.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void qp() {
        if (this.Pm != null && this.Pm.getImageType() == 1) {
            this.Pm.stop();
        }
    }

    public void al(boolean z) {
        String str;
        if (this.Pm != null && (str = (String) this.Pm.getTag()) != null && this.Pm != null) {
            if (this.Pm.getImageType() == 1) {
                if (this.Pm.getGifCache() == null) {
                    l(str, z);
                }
            } else if (this.Pm.getImageType() == 2) {
                if (com.baidu.adp.lib.util.j.fh()) {
                    l(str, z);
                }
            } else if (this.Pm.getImageBitmap() == null) {
                l(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.Pm != null) {
            return this.Pm.getImageType();
        }
        return 0;
    }

    public void setIsCdn(boolean z) {
        this.Of = z;
    }
}
