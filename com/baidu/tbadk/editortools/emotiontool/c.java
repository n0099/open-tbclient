package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dxL;
    private com.baidu.adp.widget.ImageView.a dxM;
    private int rows;

    public abstract boolean aOI();

    public abstract EmotionGroupType aOJ();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String ms(int i);

    public abstract boolean vf(String str);

    public abstract com.baidu.adp.widget.ImageView.a vg(String str);

    public abstract com.baidu.adp.widget.ImageView.a vh(String str);

    public com.baidu.adp.widget.ImageView.a aOK() {
        return this.dxL;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dxL = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aOL() {
        return this.dxM;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dxM = aVar;
    }

    public int aOM() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mt(int i) {
        this.cols = i;
    }

    public int aON() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mu(int i) {
        this.rows = i;
    }
}
