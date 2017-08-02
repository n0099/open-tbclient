package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aBG;
    private com.baidu.adp.widget.a.a aBH;
    private int aBI;
    private int cols;

    public abstract boolean Dg();

    public abstract EmotionGroupType Dh();

    public abstract String eF(int i);

    public abstract boolean fE(String str);

    public abstract com.baidu.adp.widget.a.a fF(String str);

    public abstract com.baidu.adp.widget.a.a fG(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Di() {
        return this.aBG;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.aBG = aVar;
    }

    public com.baidu.adp.widget.a.a Dj() {
        return this.aBH;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kN();
        }
        this.aBH = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(int i) {
        this.cols = i;
    }

    public int Dk() {
        return this.aBI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(int i) {
        this.aBI = i;
    }
}
