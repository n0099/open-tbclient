package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a bqO;
    private com.baidu.adp.widget.a.a bqP;
    private int cols;
    private int rows;

    public abstract boolean KT();

    public abstract EmotionGroupType KU();

    public abstract boolean fV(String str);

    public abstract com.baidu.adp.widget.a.a fW(String str);

    public abstract com.baidu.adp.widget.a.a fX(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String hQ(int i);

    public com.baidu.adp.widget.a.a KV() {
        return this.bqO;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.si();
        }
        this.bqO = aVar;
    }

    public com.baidu.adp.widget.a.a KW() {
        return this.bqP;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.si();
        }
        this.bqP = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hR(int i) {
        this.cols = i;
    }

    public int KX() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hS(int i) {
        this.rows = i;
    }
}
