package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fou;
    private com.baidu.adp.widget.ImageView.a fov;
    private int rows;

    public abstract boolean DG(String str);

    public abstract com.baidu.adp.widget.ImageView.a DH(String str);

    public abstract com.baidu.adp.widget.ImageView.a DI(String str);

    public abstract boolean bzQ();

    public abstract EmotionGroupType bzR();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String rn(int i);

    public com.baidu.adp.widget.ImageView.a bzS() {
        return this.fou;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fou = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bzT() {
        return this.fov;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fov = aVar;
    }

    public int bzU() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ro(int i) {
        this.cols = i;
    }

    public int bzV() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void rp(int i) {
        this.rows = i;
    }
}
