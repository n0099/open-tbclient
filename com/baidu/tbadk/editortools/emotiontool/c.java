package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fae;
    private com.baidu.adp.widget.ImageView.a faf;
    private int rows;

    public abstract boolean CZ(String str);

    public abstract com.baidu.adp.widget.ImageView.a Da(String str);

    public abstract com.baidu.adp.widget.ImageView.a Db(String str);

    public abstract boolean bvy();

    public abstract EmotionGroupType bvz();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qS(int i);

    public com.baidu.adp.widget.ImageView.a bvA() {
        return this.fae;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fae = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bvB() {
        return this.faf;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.faf = aVar;
    }

    public int bvC() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qT(int i) {
        this.cols = i;
    }

    public int bvD() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qU(int i) {
        this.rows = i;
    }
}
