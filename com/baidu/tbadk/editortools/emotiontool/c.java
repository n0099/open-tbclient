package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dXF;
    private com.baidu.adp.widget.ImageView.a dXG;
    private int rows;

    public abstract boolean aXd();

    public abstract EmotionGroupType aXe();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String mG(int i);

    public abstract boolean ws(String str);

    public abstract com.baidu.adp.widget.ImageView.a wt(String str);

    public abstract com.baidu.adp.widget.ImageView.a wu(String str);

    public com.baidu.adp.widget.ImageView.a aXf() {
        return this.dXF;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dXF = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aXg() {
        return this.dXG;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dXG = aVar;
    }

    public int aXh() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mH(int i) {
        this.cols = i;
    }

    public int aXi() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mI(int i) {
        this.rows = i;
    }
}
