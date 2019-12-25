package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dtg;
    private com.baidu.adp.widget.ImageView.a dth;
    private int rows;

    public abstract boolean aLQ();

    public abstract EmotionGroupType aLR();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String ma(int i);

    public abstract boolean uI(String str);

    public abstract com.baidu.adp.widget.ImageView.a uJ(String str);

    public abstract com.baidu.adp.widget.ImageView.a uK(String str);

    public com.baidu.adp.widget.ImageView.a aLS() {
        return this.dtg;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dtg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aLT() {
        return this.dth;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dth = aVar;
    }

    public int aLU() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mb(int i) {
        this.cols = i;
    }

    public int aLV() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mc(int i) {
        this.rows = i;
    }
}
