package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fnC;
    private com.baidu.adp.widget.ImageView.a fnD;
    private int rows;

    public abstract boolean Df(String str);

    public abstract com.baidu.adp.widget.ImageView.a Dg(String str);

    public abstract com.baidu.adp.widget.ImageView.a Dh(String str);

    public abstract boolean bzg();

    public abstract EmotionGroupType bzh();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String rL(int i);

    public com.baidu.adp.widget.ImageView.a bzi() {
        return this.fnC;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fnC = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bzj() {
        return this.fnD;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fnD = aVar;
    }

    public int bzk() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rM(int i) {
        this.cols = i;
    }

    public int bzl() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rN(int i) {
        this.rows = i;
    }
}
