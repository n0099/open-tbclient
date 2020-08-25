package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes2.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a eLB;
    private com.baidu.adp.widget.ImageView.a eLC;
    private int rows;

    public abstract boolean BQ(String str);

    public abstract com.baidu.adp.widget.ImageView.a BR(String str);

    public abstract com.baidu.adp.widget.ImageView.a BS(String str);

    public abstract boolean brL();

    public abstract EmotionGroupType brM();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qh(int i);

    public com.baidu.adp.widget.ImageView.a brN() {
        return this.eLB;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eLB = aVar;
    }

    public com.baidu.adp.widget.ImageView.a brO() {
        return this.eLC;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eLC = aVar;
    }

    public int brP() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qi(int i) {
        this.cols = i;
    }

    public int brQ() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qj(int i) {
        this.rows = i;
    }
}
