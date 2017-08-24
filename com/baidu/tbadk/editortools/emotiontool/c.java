package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aCZ;
    private com.baidu.adp.widget.a.a aDa;
    private int aDb;
    private int cols;

    public abstract boolean Do();

    public abstract EmotionGroupType Dp();

    public abstract String eH(int i);

    public abstract boolean fO(String str);

    public abstract com.baidu.adp.widget.a.a fP(String str);

    public abstract com.baidu.adp.widget.a.a fQ(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Dq() {
        return this.aCZ;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kW();
        }
        this.aCZ = aVar;
    }

    public com.baidu.adp.widget.a.a Dr() {
        return this.aDa;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kW();
        }
        this.aDa = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eI(int i) {
        this.cols = i;
    }

    public int Ds() {
        return this.aDb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eJ(int i) {
        this.aDb = i;
    }
}
