package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
public class ax extends RelativeLayout {
    private boolean Ux;
    protected com.baidu.tbadk.widget.a VD;
    private az VE;
    protected Context mContext;
    protected ProgressBar mProgressBar;

    public void setHeadImage(boolean z) {
        if (this.VD != null) {
            this.VD.setIsHeadImage(z);
        }
    }

    public void setCallback(az azVar) {
        this.VE = azVar;
    }

    public ax(Context context) {
        super(context);
        this.mProgressBar = null;
        this.VD = null;
        this.mContext = null;
        this.VE = null;
        this.Ux = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tbadk.widget.a getImageView() {
        return this.VD;
    }

    public void setGifSetListener(com.baidu.tbadk.widget.g gVar) {
        this.VD.setGifSetListener(gVar);
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.VD.setImageOnClickListener(onClickListener);
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.VD.setImageOnLongClickListener(onLongClickListener);
    }

    public void setOnSizeChangedListener(com.baidu.tbadk.widget.h hVar) {
        this.VD.setOnSizeChangedListener(hVar);
    }

    protected void init() {
        this.VD = new com.baidu.tbadk.widget.a(this.mContext);
        this.VD.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.VD);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(com.baidu.tieba.v.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        addView(this.mProgressBar);
    }

    public void n(String str, boolean z) {
        this.VD.setTag(str);
        if (com.baidu.adp.lib.util.i.fg() || com.baidu.adp.lib.util.i.fj()) {
            o(str, z);
        }
    }

    private void o(String str, boolean z) {
        this.VD.setImageDrawable(null);
        this.mProgressBar.setVisibility(0);
        com.baidu.adp.lib.f.d.ec().a(str, 27, new ay(this), 0, 0, null, Boolean.valueOf(z), this.VD.getImageData(), Boolean.valueOf(this.Ux));
    }

    public void setGifMaxUseableMem(int i) {
        this.VD.setGifMaxUseableMem(i);
    }

    public void onDestroy() {
        if (this.VD != null) {
            this.VD.onDestroy();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void release() {
        if (this.VD != null) {
            this.VD.release();
        }
        this.mProgressBar.setVisibility(8);
    }

    public void tZ() {
        if (this.VD != null && this.VD.getImageType() == 1) {
            this.VD.stop();
        }
    }

    public void aB(boolean z) {
        String str;
        if (this.VD != null && (str = (String) this.VD.getTag()) != null && this.VD != null) {
            if (this.VD.getImageType() == 1) {
                if (this.VD.getGifCache() == null) {
                    o(str, z);
                }
            } else if (this.VD.getImageType() == 2) {
                if (com.baidu.adp.lib.util.i.ff()) {
                    o(str, z);
                }
            } else if (this.VD.getImageBitmap() == null) {
                o(str, z);
            }
        }
    }

    public int getImageType() {
        if (this.VD != null) {
            return this.VD.getImageType();
        }
        return 0;
    }

    public void setIsCdn(boolean z) {
        this.Ux = z;
    }
}
