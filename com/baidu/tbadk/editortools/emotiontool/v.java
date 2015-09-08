package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class v {
    private com.baidu.adp.widget.a.a asC;
    private com.baidu.adp.widget.a.a asD;
    private int asE;
    private int asF;

    public abstract EmotionGroupType Bm();

    public abstract boolean Bn();

    public abstract boolean eK(String str);

    public abstract com.baidu.adp.widget.a.a eL(String str);

    public abstract com.baidu.adp.widget.a.a eM(String str);

    public abstract String eh(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Bt() {
        return this.asC;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mZ();
        }
        this.asC = aVar;
    }

    public com.baidu.adp.widget.a.a Bu() {
        return this.asD;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mZ();
        }
        this.asD = aVar;
    }

    public int Bv() {
        return this.asF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ei(int i) {
        this.asF = i;
    }

    public int Bw() {
        return this.asE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ej(int i) {
        this.asE = i;
    }
}
