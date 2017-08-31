package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aCm;
    private com.baidu.adp.widget.a.a aCn;
    private int aCo;
    private int cols;

    public abstract boolean Dj();

    public abstract EmotionGroupType Dk();

    public abstract String eH(int i);

    public abstract boolean fJ(String str);

    public abstract com.baidu.adp.widget.a.a fK(String str);

    public abstract com.baidu.adp.widget.a.a fL(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Dl() {
        return this.aCm;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kO();
        }
        this.aCm = aVar;
    }

    public com.baidu.adp.widget.a.a Dm() {
        return this.aCn;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kO();
        }
        this.aCn = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eI(int i) {
        this.cols = i;
    }

    public int Dn() {
        return this.aCo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eJ(int i) {
        this.aCo = i;
    }
}
