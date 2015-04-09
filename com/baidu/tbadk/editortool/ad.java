package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ad {
    private com.baidu.adp.widget.a.a ake;
    private com.baidu.adp.widget.a.a akf;
    private int akg;
    private int akh;

    public abstract String dz(int i);

    public abstract boolean eg(String str);

    public abstract com.baidu.adp.widget.a.a eh(String str);

    public abstract com.baidu.adp.widget.a.a ei(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType yO();

    public abstract boolean yP();

    public com.baidu.adp.widget.a.a zj() {
        return this.ake;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mz();
        }
        this.ake = aVar;
    }

    public com.baidu.adp.widget.a.a zk() {
        return this.akf;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mz();
        }
        this.akf = aVar;
    }

    public int zl() {
        return this.akh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dA(int i) {
        this.akh = i;
    }

    public int zm() {
        return this.akg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dB(int i) {
        this.akg = i;
    }
}
