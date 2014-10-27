package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class au extends RelativeLayout {
    private boolean Ob;
    protected com.baidu.tbadk.widget.a Pi;
    private aw Pj;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.Pi != null) {
            this.Pi.setIsHeadImage(z);
        }
    }

    public void setCallback(aw awVar) {
        this.Pj = awVar;
    }

    public au(Context context) {
        super(context);
        this.mProgressBar = null;
        this.Pi = null;
        this.mContext = null;
        this.Pj = null;
        this.Ob = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.Pi;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.e eVar) {
        this.Pi.setGifSetListener(eVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.Pi.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.Pi.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.f fVar) {
        this.Pi.setOnSizeChangedListener(fVar);
    }

    protected void init() {
        this.Pi = new com.baidu.tbadk.widget.a(this.mContext);
        this.Pi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.Pi);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.u.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void k(String str, boolean z) {
        this.Pi.setTag(str);
        if (com.baidu.adp.lib.util.j.fi() || com.baidu.adp.lib.util.j.fl()) {
            l(str, z);
        }
    }

    private void l(String str, boolean z) {
        this.Pi.setImageDrawable(null);
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.ef().a(str, 27, new av(this), 0, 0, null, Boolean.valueOf(z), this.Pi.getImageData(), Boolean.valueOf(this.Ob));
    }

    public void setGifMaxUseableMem(int i) {
        this.Pi.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.Pi != null) {
            this.Pi.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.Pi != null) {
            this.Pi.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void qn() {
        if (this.Pi != null && this.Pi.getImageType() == 1) {
            this.Pi.stop();
        }
    }

    public void al(boolean z) {
        String str;
        if (this.Pi != null && (str = (String) this.Pi.getTag()) != null && this.Pi != null) {
            if (this.Pi.getImageType() == 1) {
                if (this.Pi.getGifCache() == null) {
                    l(str, z);
                }
            } else if (this.Pi.getImageType() == 2) {
                if (com.baidu.adp.lib.util.j.fh()) {
                    l(str, z);
                }
            } else if (this.Pi.getImageBitmap() == null) {
                l(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.Pi != null) {
            return this.Pi.getImageType();
        }
        return 0;
    }

    public void setIsCdn(boolean z) {
        this.Ob = z;
    }
}
