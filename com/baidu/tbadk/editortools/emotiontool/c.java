package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aCa;
    private com.baidu.adp.widget.a.a aCb;
    private int cols;
    private int rows;

    public abstract boolean CV();

    public abstract EmotionGroupType CW();

    public abstract String eS(int i);

    public abstract boolean fI(String str);

    public abstract com.baidu.adp.widget.a.a fJ(String str);

    public abstract com.baidu.adp.widget.a.a fK(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a CX() {
        return this.aCa;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kK();
        }
        this.aCa = aVar;
    }

    public com.baidu.adp.widget.a.a CY() {
        return this.aCb;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kK();
        }
        this.aCb = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eT(int i) {
        this.cols = i;
    }

    public int CZ() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eU(int i) {
        this.rows = i;
    }
}
