package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ae {
    private int ZA;
    private int ZB;
    private com.baidu.adp.widget.a.a Zy;
    private com.baidu.adp.widget.a.a Zz;

    public abstract boolean dR(String str);

    public abstract com.baidu.adp.widget.a.a dS(String str);

    public abstract com.baidu.adp.widget.a.a dT(String str);

    public abstract String dl(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType vf();

    public abstract boolean vg();

    public com.baidu.adp.widget.a.a vE() {
        return this.Zy;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jc();
        }
        this.Zy = aVar;
    }

    public com.baidu.adp.widget.a.a ve() {
        return this.Zz;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jc();
        }
        this.Zz = aVar;
    }

    public int vF() {
        return this.ZB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dp(int i) {
        this.ZB = i;
    }

    public int vG() {
        return this.ZA;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dq(int i) {
        this.ZA = i;
    }
}
