package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a eBc;
    private com.baidu.adp.widget.ImageView.a eBd;
    private int rows;

    public abstract boolean biZ();

    public abstract EmotionGroupType bja();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String nW(int i);

    public abstract boolean zA(String str);

    public abstract com.baidu.adp.widget.ImageView.a zB(String str);

    public abstract com.baidu.adp.widget.ImageView.a zC(String str);

    public com.baidu.adp.widget.ImageView.a bjb() {
        return this.eBc;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eBc = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bjc() {
        return this.eBd;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eBd = aVar;
    }

    public int bjd() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nX(int i) {
        this.cols = i;
    }

    public int bje() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nY(int i) {
        this.rows = i;
    }
}
