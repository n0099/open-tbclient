package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a azB;
    private com.baidu.adp.widget.a.a azC;
    private int azD;
    private int cols;

    public abstract boolean Dd();

    public abstract EmotionGroupType De();

    public abstract String eB(int i);

    public abstract boolean ff(String str);

    public abstract com.baidu.adp.widget.a.a fg(String str);

    public abstract com.baidu.adp.widget.a.a fh(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Df() {
        return this.azB;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.azB = aVar;
    }

    public com.baidu.adp.widget.a.a Dg() {
        return this.azC;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.azC = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eC(int i) {
        this.cols = i;
    }

    public int Dh() {
        return this.azD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eD(int i) {
        this.azD = i;
    }
}
