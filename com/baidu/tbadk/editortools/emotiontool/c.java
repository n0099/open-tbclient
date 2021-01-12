package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fAe;
    private com.baidu.adp.widget.ImageView.a fAf;
    private int rows;

    public abstract com.baidu.adp.widget.ImageView.a CA(String str);

    public abstract boolean Cy(String str);

    public abstract com.baidu.adp.widget.ImageView.a Cz(String str);

    public abstract boolean bBi();

    public abstract EmotionGroupType bBj();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qS(int i);

    public com.baidu.adp.widget.ImageView.a bBk() {
        return this.fAe;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fAe = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bBl() {
        return this.fAf;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fAf = aVar;
    }

    public int bBm() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qT(int i) {
        this.cols = i;
    }

    public int bBn() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qU(int i) {
        this.rows = i;
    }
}
