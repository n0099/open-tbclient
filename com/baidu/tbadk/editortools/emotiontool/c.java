package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aNc;
    private com.baidu.adp.widget.ImageView.a aNd;
    private int cols;
    private int rows;

    public abstract boolean HM();

    public abstract EmotionGroupType HN();

    public abstract String eQ(int i);

    public abstract boolean gH(String str);

    public abstract com.baidu.adp.widget.ImageView.a gI(String str);

    public abstract com.baidu.adp.widget.ImageView.a gJ(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.ImageView.a HO() {
        return this.aNc;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.mZ();
        }
        this.aNc = aVar;
    }

    public com.baidu.adp.widget.ImageView.a HP() {
        return this.aNd;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.mZ();
        }
        this.aNd = aVar;
    }

    public int HQ() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eR(int i) {
        this.cols = i;
    }

    public int HR() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(int i) {
        this.rows = i;
    }
}
