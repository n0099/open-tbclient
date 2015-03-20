package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ad {
    private com.baidu.adp.widget.a.a ajW;
    private com.baidu.adp.widget.a.a ajX;
    private int ajY;
    private int ajZ;

    public abstract String dz(int i);

    public abstract boolean ed(String str);

    public abstract com.baidu.adp.widget.a.a ee(String str);

    public abstract com.baidu.adp.widget.a.a ef(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType yI();

    public abstract boolean yJ();

    public com.baidu.adp.widget.a.a zd() {
        return this.ajW;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mz();
        }
        this.ajW = aVar;
    }

    public com.baidu.adp.widget.a.a ze() {
        return this.ajX;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mz();
        }
        this.ajX = aVar;
    }

    public int zf() {
        return this.ajZ;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dA(int i) {
        this.ajZ = i;
    }

    public int zg() {
        return this.ajY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dB(int i) {
        this.ajY = i;
    }
}
