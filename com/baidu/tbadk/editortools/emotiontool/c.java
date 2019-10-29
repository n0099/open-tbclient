package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a cGd;
    private com.baidu.adp.widget.ImageView.a cGe;
    private int cols;
    private int rows;

    public abstract boolean aun();

    public abstract EmotionGroupType auo();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String jO(int i);

    public abstract boolean pC(String str);

    public abstract com.baidu.adp.widget.ImageView.a pD(String str);

    public abstract com.baidu.adp.widget.ImageView.a pE(String str);

    public com.baidu.adp.widget.ImageView.a aup() {
        return this.cGd;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.cGd = aVar;
    }

    public com.baidu.adp.widget.ImageView.a auq() {
        return this.cGe;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.cGe = aVar;
    }

    public int aur() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jP(int i) {
        this.cols = i;
    }

    public int aus() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jQ(int i) {
        this.rows = i;
    }
}
