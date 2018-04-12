package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aDJ;
    private com.baidu.adp.widget.ImageView.a aDK;
    private int cols;
    private int rows;

    public abstract boolean DT();

    public abstract EmotionGroupType DU();

    public abstract String eL(int i);

    public abstract boolean ge(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract com.baidu.adp.widget.ImageView.a gf(String str);

    public abstract com.baidu.adp.widget.ImageView.a gg(String str);

    public com.baidu.adp.widget.ImageView.a DV() {
        return this.aDJ;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.km();
        }
        this.aDJ = aVar;
    }

    public com.baidu.adp.widget.ImageView.a DW() {
        return this.aDK;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.km();
        }
        this.aDK = aVar;
    }

    public int DX() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eM(int i) {
        this.cols = i;
    }

    public int DY() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eN(int i) {
        this.rows = i;
    }
}
