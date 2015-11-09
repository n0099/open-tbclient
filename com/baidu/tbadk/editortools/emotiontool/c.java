package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a apC;
    private com.baidu.adp.widget.a.a apD;
    private int apE;
    private int apF;

    public abstract boolean AO();

    public abstract EmotionGroupType AP();

    public abstract String dX(int i);

    public abstract boolean eP(String str);

    public abstract com.baidu.adp.widget.a.a eQ(String str);

    public abstract com.baidu.adp.widget.a.a eR(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a AQ() {
        return this.apC;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.nb();
        }
        this.apC = aVar;
    }

    public com.baidu.adp.widget.a.a AR() {
        return this.apD;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.nb();
        }
        this.apD = aVar;
    }

    public int AS() {
        return this.apF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dY(int i) {
        this.apF = i;
    }

    public int AT() {
        return this.apE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dZ(int i) {
        this.apE = i;
    }
}
