package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ae {
    private com.baidu.adp.widget.a.a ZB;
    private com.baidu.adp.widget.a.a ZC;
    private int ZD;
    private int ZE;

    public abstract boolean dU(String str);

    public abstract com.baidu.adp.widget.a.a dV(String str);

    public abstract com.baidu.adp.widget.a.a dW(String str);

    public abstract String dl(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType vl();

    public abstract boolean vm();

    public com.baidu.adp.widget.a.a vK() {
        return this.ZB;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jj();
        }
        this.ZB = aVar;
    }

    public com.baidu.adp.widget.a.a vk() {
        return this.ZC;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jj();
        }
        this.ZC = aVar;
    }

    public int vL() {
        return this.ZE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dp(int i) {
        this.ZE = i;
    }

    public int vM() {
        return this.ZD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dq(int i) {
        this.ZD = i;
    }
}
