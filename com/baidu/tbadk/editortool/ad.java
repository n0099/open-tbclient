package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ad {
    private com.baidu.adp.widget.a.a alf;
    private com.baidu.adp.widget.a.a alg;
    private int alh;
    private int ali;

    public abstract String dI(int i);

    public abstract boolean ex(String str);

    public abstract com.baidu.adp.widget.a.a ey(String str);

    public abstract com.baidu.adp.widget.a.a ez(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType zC();

    public abstract boolean zD();

    public com.baidu.adp.widget.a.a zX() {
        return this.alf;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mS();
        }
        this.alf = aVar;
    }

    public com.baidu.adp.widget.a.a zY() {
        return this.alg;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mS();
        }
        this.alg = aVar;
    }

    public int zZ() {
        return this.ali;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dJ(int i) {
        this.ali = i;
    }

    public int Aa() {
        return this.alh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dK(int i) {
        this.alh = i;
    }
}
