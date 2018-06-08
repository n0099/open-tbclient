package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aMg;
    private com.baidu.adp.widget.ImageView.a aMh;
    private int cols;
    private int rows;

    public abstract boolean Hu();

    public abstract EmotionGroupType Hv();

    public abstract String eP(int i);

    public abstract boolean gD(String str);

    public abstract com.baidu.adp.widget.ImageView.a gE(String str);

    public abstract com.baidu.adp.widget.ImageView.a gF(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.ImageView.a Hw() {
        return this.aMg;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.mZ();
        }
        this.aMg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Hx() {
        return this.aMh;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.mZ();
        }
        this.aMh = aVar;
    }

    public int Hy() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eQ(int i) {
        this.cols = i;
    }

    public int Hz() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eR(int i) {
        this.rows = i;
    }
}
