package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aNc;
    private com.baidu.adp.widget.ImageView.a aNd;
    private int cols;
    private int rows;

    public abstract boolean HH();

    public abstract EmotionGroupType HI();

    public abstract String eR(int i);

    public abstract boolean gD(String str);

    public abstract com.baidu.adp.widget.ImageView.a gE(String str);

    public abstract com.baidu.adp.widget.ImageView.a gF(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.ImageView.a HJ() {
        return this.aNc;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nb();
        }
        this.aNc = aVar;
    }

    public com.baidu.adp.widget.ImageView.a HK() {
        return this.aNd;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nb();
        }
        this.aNd = aVar;
    }

    public int HL() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(int i) {
        this.cols = i;
    }

    public int HM() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eT(int i) {
        this.rows = i;
    }
}
