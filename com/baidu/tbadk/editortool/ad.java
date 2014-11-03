package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ad {
    private com.baidu.adp.widget.a.a SZ;
    private com.baidu.adp.widget.a.a Ta;
    private int Tb;
    private int Tc;

    public abstract String cG(int i);

    public abstract boolean cY(String str);

    public abstract com.baidu.adp.widget.a.a cZ(String str);

    public abstract com.baidu.adp.widget.a.a da(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType rt();

    public abstract boolean ru();

    public com.baidu.adp.widget.a.a rR() {
        return this.SZ;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.hl();
        }
        this.SZ = aVar;
    }

    public com.baidu.adp.widget.a.a rr() {
        return this.Ta;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.hl();
        }
        this.Ta = aVar;
    }

    public int rS() {
        return this.Tc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJ(int i) {
        this.Tc = i;
    }

    public int rT() {
        return this.Tb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cK(int i) {
        this.Tb = i;
    }
}
