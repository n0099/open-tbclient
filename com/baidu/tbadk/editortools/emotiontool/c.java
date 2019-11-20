package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a cFm;
    private com.baidu.adp.widget.ImageView.a cFn;
    private int cols;
    private int rows;

    public abstract boolean aul();

    public abstract EmotionGroupType aum();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String jN(int i);

    public abstract boolean pC(String str);

    public abstract com.baidu.adp.widget.ImageView.a pD(String str);

    public abstract com.baidu.adp.widget.ImageView.a pE(String str);

    public com.baidu.adp.widget.ImageView.a aun() {
        return this.cFm;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.cFm = aVar;
    }

    public com.baidu.adp.widget.ImageView.a auo() {
        return this.cFn;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.cFn = aVar;
    }

    public int aup() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jO(int i) {
        this.cols = i;
    }

    public int auq() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jP(int i) {
        this.rows = i;
    }
}
