package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dtr;
    private com.baidu.adp.widget.ImageView.a dts;
    private int rows;

    public abstract boolean aMj();

    public abstract EmotionGroupType aMk();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String ma(int i);

    public abstract boolean uN(String str);

    public abstract com.baidu.adp.widget.ImageView.a uO(String str);

    public abstract com.baidu.adp.widget.ImageView.a uP(String str);

    public com.baidu.adp.widget.ImageView.a aMl() {
        return this.dtr;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dtr = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aMm() {
        return this.dts;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dts = aVar;
    }

    public int aMn() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mb(int i) {
        this.cols = i;
    }

    public int aMo() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mc(int i) {
        this.rows = i;
    }
}
