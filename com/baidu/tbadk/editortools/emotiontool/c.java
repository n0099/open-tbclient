package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aCQ;
    private com.baidu.adp.widget.a.a aCR;
    private int cols;
    private int rows;

    public abstract boolean Ds();

    public abstract EmotionGroupType Dt();

    public abstract String eS(int i);

    public abstract boolean fO(String str);

    public abstract com.baidu.adp.widget.a.a fP(String str);

    public abstract com.baidu.adp.widget.a.a fQ(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Du() {
        return this.aCQ;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kK();
        }
        this.aCQ = aVar;
    }

    public com.baidu.adp.widget.a.a Dv() {
        return this.aCR;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kK();
        }
        this.aCR = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eT(int i) {
        this.cols = i;
    }

    public int Dw() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eU(int i) {
        this.rows = i;
    }
}
