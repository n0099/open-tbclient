package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a avE;
    private com.baidu.adp.widget.a.a avF;
    private int avG;
    private int cols;

    public abstract boolean Dh();

    public abstract EmotionGroupType Di();

    public abstract String eE(int i);

    public abstract boolean fx(String str);

    public abstract com.baidu.adp.widget.a.a fy(String str);

    public abstract com.baidu.adp.widget.a.a fz(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Dj() {
        return this.avE;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.avE = aVar;
    }

    public com.baidu.adp.widget.a.a Dk() {
        return this.avF;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.avF = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eF(int i) {
        this.cols = i;
    }

    public int Dl() {
        return this.avG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(int i) {
        this.avG = i;
    }
}
