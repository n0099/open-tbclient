package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ae {
    private com.baidu.adp.widget.a.a Za;
    private com.baidu.adp.widget.a.a Zb;
    private int Zc;
    private int Zd;

    public abstract boolean dU(String str);

    public abstract com.baidu.adp.widget.a.a dV(String str);

    public abstract com.baidu.adp.widget.a.a dW(String str);

    public abstract String de(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType uU();

    public abstract boolean uV();

    public com.baidu.adp.widget.a.a vs() {
        return this.Za;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.ji();
        }
        this.Za = aVar;
    }

    public com.baidu.adp.widget.a.a uT() {
        return this.Zb;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.ji();
        }
        this.Zb = aVar;
    }

    public int vt() {
        return this.Zd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dh(int i) {
        this.Zd = i;
    }

    public int vu() {
        return this.Zc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void di(int i) {
        this.Zc = i;
    }
}
