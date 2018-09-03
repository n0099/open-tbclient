package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aMZ;
    private com.baidu.adp.widget.ImageView.a aNa;
    private int cols;
    private int rows;

    public abstract boolean HH();

    public abstract EmotionGroupType HI();

    public abstract String eQ(int i);

    public abstract boolean gD(String str);

    public abstract com.baidu.adp.widget.ImageView.a gE(String str);

    public abstract com.baidu.adp.widget.ImageView.a gF(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.ImageView.a HJ() {
        return this.aMZ;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nb();
        }
        this.aMZ = aVar;
    }

    public com.baidu.adp.widget.ImageView.a HK() {
        return this.aNa;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nb();
        }
        this.aNa = aVar;
    }

    public int HL() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eR(int i) {
        this.cols = i;
    }

    public int HM() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(int i) {
        this.rows = i;
    }
}
