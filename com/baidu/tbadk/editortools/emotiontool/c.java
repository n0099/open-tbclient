package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dXK;
    private com.baidu.adp.widget.ImageView.a dXL;
    private int rows;

    public abstract boolean aXb();

    public abstract EmotionGroupType aXc();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String mG(int i);

    public abstract boolean wv(String str);

    public abstract com.baidu.adp.widget.ImageView.a ww(String str);

    public abstract com.baidu.adp.widget.ImageView.a wx(String str);

    public com.baidu.adp.widget.ImageView.a aXd() {
        return this.dXK;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dXK = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aXe() {
        return this.dXL;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dXL = aVar;
    }

    public int aXf() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mH(int i) {
        this.cols = i;
    }

    public int aXg() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mI(int i) {
        this.rows = i;
    }
}
