package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aVI;
    private com.baidu.adp.widget.ImageView.a aVJ;
    private int cols;
    private int rows;

    public abstract boolean Lh();

    public abstract EmotionGroupType Li();

    public abstract String fz(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean ho(String str);

    public abstract com.baidu.adp.widget.ImageView.a hp(String str);

    public abstract com.baidu.adp.widget.ImageView.a hq(String str);

    public com.baidu.adp.widget.ImageView.a Lj() {
        return this.aVI;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oq();
        }
        this.aVI = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Lk() {
        return this.aVJ;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oq();
        }
        this.aVJ = aVar;
    }

    public int Ll() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fA(int i) {
        this.cols = i;
    }

    public int Lm() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fB(int i) {
        this.rows = i;
    }
}
