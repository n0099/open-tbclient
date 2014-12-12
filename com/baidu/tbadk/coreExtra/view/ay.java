package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ay extends RelativeLayout {
    private boolean TS;
    protected com.baidu.tbadk.widget.a UY;
    private ba UZ;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.UY != null) {
            this.UY.setIsHeadImage(z);
        }
    }

    public void setCallback(ba baVar) {
        this.UZ = baVar;
    }

    public ay(Context context) {
        super(context);
        this.mProgressBar = null;
        this.UY = null;
        this.mContext = null;
        this.UZ = null;
        this.TS = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.UY;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.g gVar) {
        this.UY.setGifSetListener(gVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.UY.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.UY.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.h hVar) {
        this.UY.setOnSizeChangedListener(hVar);
    }

    protected void init() {
        this.UY = new com.baidu.tbadk.widget.a(this.mContext);
        this.UY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.UY);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.UY.setTag(str);
        if (com.baidu.adp.lib.util.i.fh() || com.baidu.adp.lib.util.i.fk()) {
            o(str, z);
        }
    }

    private void o(String str, boolean z) {
        this.UY.setImageDrawable(null);
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.ee().a(str, 27, new az(this), 0, 0, null, Boolean.valueOf(z), this.UY.getImageData(), Boolean.valueOf(this.TS));
    }

    public void setGifMaxUseableMem(int i) {
        this.UY.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.UY != null) {
            this.UY.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.UY != null) {
            this.UY.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void tI() {
        if (this.UY != null && this.UY.getImageType() == 1) {
            this.UY.stop();
        }
    }

    public void az(boolean z) {
        String str;
        if (this.UY != null && (str = (String) this.UY.getTag()) != null && this.UY != null) {
            if (this.UY.getImageType() == 1) {
                if (this.UY.getGifCache() == null) {
                    o(str, z);
                }
            } else if (this.UY.getImageType() == 2) {
                if (com.baidu.adp.lib.util.i.fg()) {
                    o(str, z);
                }
            } else if (this.UY.getImageBitmap() == null) {
                o(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.UY != null) {
            return this.UY.getImageType();
        }
        return 0;
    }

    public void setIsCdn(boolean z) {
        this.TS = z;
    }
}
