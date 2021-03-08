package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fDS;
    private com.baidu.adp.widget.ImageView.a fDT;
    private int rows;

    public abstract boolean CU(String str);

    public abstract com.baidu.adp.widget.ImageView.a CV(String str);

    public abstract com.baidu.adp.widget.ImageView.a CW(String str);

    public abstract boolean bBD();

    public abstract EmotionGroupType bBE();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qY(int i);

    public com.baidu.adp.widget.ImageView.a bBF() {
        return this.fDS;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fDS = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bBG() {
        return this.fDT;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fDT = aVar;
    }

    public int bBH() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qZ(int i) {
        this.cols = i;
    }

    public int bBI() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ra(int i) {
        this.rows = i;
    }
}
