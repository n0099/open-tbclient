package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a dxY;
    private com.baidu.adp.widget.ImageView.a dxZ;
    private int rows;

    public abstract boolean aOM();

    public abstract EmotionGroupType aON();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String mu(int i);

    public abstract boolean ve(String str);

    public abstract com.baidu.adp.widget.ImageView.a vf(String str);

    public abstract com.baidu.adp.widget.ImageView.a vg(String str);

    public com.baidu.adp.widget.ImageView.a aOO() {
        return this.dxY;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dxY = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aOP() {
        return this.dxZ;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.dxZ = aVar;
    }

    public int aOQ() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mv(int i) {
        this.cols = i;
    }

    public int aOR() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mw(int i) {
        this.rows = i;
    }
}
