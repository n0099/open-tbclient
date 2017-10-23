package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aBr;
    private com.baidu.adp.widget.ImageView.a aBs;
    private int cols;
    private int rows;

    public abstract boolean CH();

    public abstract EmotionGroupType CI();

    public abstract String eR(int i);

    public abstract boolean fB(String str);

    public abstract com.baidu.adp.widget.ImageView.a fC(String str);

    public abstract com.baidu.adp.widget.ImageView.a fD(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.ImageView.a CJ() {
        return this.aBr;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.aBr = aVar;
    }

    public com.baidu.adp.widget.ImageView.a CK() {
        return this.aBs;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.aBs = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(int i) {
        this.cols = i;
    }

    public int CL() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eT(int i) {
        this.rows = i;
    }
}
