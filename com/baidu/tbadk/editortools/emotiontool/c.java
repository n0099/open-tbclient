package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aCi;
    private com.baidu.adp.widget.a.a aCj;
    private int cols;
    private int rows;

    public abstract boolean Dh();

    public abstract EmotionGroupType Di();

    public abstract String eR(int i);

    public abstract boolean fJ(String str);

    public abstract com.baidu.adp.widget.a.a fK(String str);

    public abstract com.baidu.adp.widget.a.a fL(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Dj() {
        return this.aCi;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kK();
        }
        this.aCi = aVar;
    }

    public com.baidu.adp.widget.a.a Dk() {
        return this.aCj;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kK();
        }
        this.aCj = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eS(int i) {
        this.cols = i;
    }

    public int Dl() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eT(int i) {
        this.rows = i;
    }
}
