package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a bqX;
    private com.baidu.adp.widget.a.a bqY;
    private int cols;
    private int rows;

    public abstract boolean KI();

    public abstract EmotionGroupType KJ();

    public abstract boolean fW(String str);

    public abstract com.baidu.adp.widget.a.a fX(String str);

    public abstract com.baidu.adp.widget.a.a fY(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String hM(int i);

    public com.baidu.adp.widget.a.a KK() {
        return this.bqX;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.si();
        }
        this.bqX = aVar;
    }

    public com.baidu.adp.widget.a.a KL() {
        return this.bqY;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.si();
        }
        this.bqY = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hN(int i) {
        this.cols = i;
    }

    public int KM() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hO(int i) {
        this.rows = i;
    }
}
