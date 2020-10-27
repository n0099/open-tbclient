package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fiD;
    private com.baidu.adp.widget.ImageView.a fiE;
    private int rows;

    public abstract boolean Ds(String str);

    public abstract com.baidu.adp.widget.ImageView.a Dt(String str);

    public abstract com.baidu.adp.widget.ImageView.a Du(String str);

    public abstract boolean bxr();

    public abstract EmotionGroupType bxs();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String rd(int i);

    public com.baidu.adp.widget.ImageView.a bxt() {
        return this.fiD;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fiD = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bxu() {
        return this.fiE;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fiE = aVar;
    }

    public int bxv() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void re(int i) {
        this.cols = i;
    }

    public int bxw() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rf(int i) {
        this.rows = i;
    }
}
