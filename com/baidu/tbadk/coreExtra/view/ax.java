package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ax extends RelativeLayout {
    private boolean Uu;
    protected com.baidu.tbadk.widget.a VA;
    private az VB;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.VA != null) {
            this.VA.setIsHeadImage(z);
        }
    }

    public void setCallback(az azVar) {
        this.VB = azVar;
    }

    public ax(Context context) {
        super(context);
        this.mProgressBar = null;
        this.VA = null;
        this.mContext = null;
        this.VB = null;
        this.Uu = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.VA;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.g gVar) {
        this.VA.setGifSetListener(gVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.VA.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.VA.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.h hVar) {
        this.VA.setOnSizeChangedListener(hVar);
    }

    protected void init() {
        this.VA = new com.baidu.tbadk.widget.a(this.mContext);
        this.VA.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.VA);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.VA.setTag(str);
        if (com.baidu.adp.lib.util.i.fg() || com.baidu.adp.lib.util.i.fj()) {
            o(str, z);
        }
    }

    private void o(String str, boolean z) {
        this.VA.setImageDrawable(null);
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.ec().a(str, 27, new ay(this), 0, 0, null, Boolean.valueOf(z), this.VA.getImageData(), Boolean.valueOf(this.Uu));
    }

    public void setGifMaxUseableMem(int i) {
        this.VA.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.VA != null) {
            this.VA.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.VA != null) {
            this.VA.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void tT() {
        if (this.VA != null && this.VA.getImageType() == 1) {
            this.VA.stop();
        }
    }

    public void aB(boolean z) {
        String str;
        if (this.VA != null && (str = (String) this.VA.getTag()) != null && this.VA != null) {
            if (this.VA.getImageType() == 1) {
                if (this.VA.getGifCache() == null) {
                    o(str, z);
                }
            } else if (this.VA.getImageType() == 2) {
                if (com.baidu.adp.lib.util.i.ff()) {
                    o(str, z);
                }
            } else if (this.VA.getImageBitmap() == null) {
                o(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.VA != null) {
            return this.VA.getImageType();
        }
        return 0;
    }

    public void setIsCdn(boolean z) {
        this.Uu = z;
    }
}
