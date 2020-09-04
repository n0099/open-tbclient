package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a eLF;
    private com.baidu.adp.widget.ImageView.a eLG;
    private int rows;

    public abstract boolean BR(String str);

    public abstract com.baidu.adp.widget.ImageView.a BS(String str);

    public abstract com.baidu.adp.widget.ImageView.a BT(String str);

    public abstract boolean brM();

    public abstract EmotionGroupType brN();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qh(int i);

    public com.baidu.adp.widget.ImageView.a brO() {
        return this.eLF;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eLF = aVar;
    }

    public com.baidu.adp.widget.ImageView.a brP() {
        return this.eLG;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eLG = aVar;
    }

    public int brQ() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qi(int i) {
        this.cols = i;
    }

    public int brR() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qj(int i) {
        this.rows = i;
    }
}
