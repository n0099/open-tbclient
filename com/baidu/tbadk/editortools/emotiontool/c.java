package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fCt;
    private com.baidu.adp.widget.ImageView.a fCu;
    private int rows;

    public abstract boolean CN(String str);

    public abstract com.baidu.adp.widget.ImageView.a CO(String str);

    public abstract com.baidu.adp.widget.ImageView.a CP(String str);

    public abstract boolean bBA();

    public abstract EmotionGroupType bBB();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qX(int i);

    public com.baidu.adp.widget.ImageView.a bBC() {
        return this.fCt;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fCt = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bBD() {
        return this.fCu;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fCu = aVar;
    }

    public int bBE() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qY(int i) {
        this.cols = i;
    }

    public int bBF() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qZ(int i) {
        this.rows = i;
    }
}
