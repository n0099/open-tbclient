package com.baidu.tbadk.editortool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class ad {
    private com.baidu.adp.widget.a.a SV;
    private com.baidu.adp.widget.a.a SW;
    private int SX;
    private int SY;

    public abstract String cG(int i);

    public abstract boolean cY(String str);

    public abstract com.baidu.adp.widget.a.a cZ(String str);

    public abstract com.baidu.adp.widget.a.a da(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract EmotionGroupType rr();

    public abstract boolean rs();

    public com.baidu.adp.widget.a.a rP() {
        return this.SV;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.hl();
        }
        this.SV = aVar;
    }

    public com.baidu.adp.widget.a.a rp() {
        return this.SW;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.hl();
        }
        this.SW = aVar;
    }

    public int rQ() {
        return this.SY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cJ(int i) {
        this.SY = i;
    }

    public int rR() {
        return this.SX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cK(int i) {
        this.SX = i;
    }
}
