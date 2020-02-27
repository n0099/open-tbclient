package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dxx;
    private com.baidu.adp.widget.ImageView.a dxy;
    private int rows;

    public abstract boolean aOF();

    public abstract EmotionGroupType aOG();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String ms(int i);

    public abstract boolean ve(String str);

    public abstract com.baidu.adp.widget.ImageView.a vf(String str);

    public abstract com.baidu.adp.widget.ImageView.a vg(String str);

    public com.baidu.adp.widget.ImageView.a aOH() {
        return this.dxx;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dxx = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aOI() {
        return this.dxy;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dxy = aVar;
    }

    public int aOJ() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mt(int i) {
        this.cols = i;
    }

    public int aOK() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mu(int i) {
        this.rows = i;
    }
}
