package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aAG;
    private com.baidu.adp.widget.a.a aAH;
    private int aAI;
    private int cols;

    public abstract boolean CU();

    public abstract EmotionGroupType CV();

    public abstract String eD(int i);

    public abstract boolean fA(String str);

    public abstract com.baidu.adp.widget.a.a fB(String str);

    public abstract com.baidu.adp.widget.a.a fC(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a CW() {
        return this.aAG;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kP();
        }
        this.aAG = aVar;
    }

    public com.baidu.adp.widget.a.a CX() {
        return this.aAH;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kP();
        }
        this.aAH = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eE(int i) {
        this.cols = i;
    }

    public int CY() {
        return this.aAI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eF(int i) {
        this.aAI = i;
    }
}
