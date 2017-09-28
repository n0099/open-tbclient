package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aBD;
    private com.baidu.adp.widget.ImageView.a aBE;
    private int aBF;
    private int cols;

    public abstract boolean CN();

    public abstract EmotionGroupType CO();

    public abstract String eS(int i);

    public abstract boolean fC(String str);

    public abstract com.baidu.adp.widget.ImageView.a fD(String str);

    public abstract com.baidu.adp.widget.ImageView.a fE(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.ImageView.a CP() {
        return this.aBD;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.aBD = aVar;
    }

    public com.baidu.adp.widget.ImageView.a CQ() {
        return this.aBE;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.aBE = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eT(int i) {
        this.cols = i;
    }

    public int CR() {
        return this.aBF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eU(int i) {
        this.aBF = i;
    }
}
