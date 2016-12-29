package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a avb;
    private com.baidu.adp.widget.a.a avc;
    private int avd;
    private int cols;

    public abstract boolean CQ();

    public abstract EmotionGroupType CR();

    public abstract String eF(int i);

    public abstract boolean ft(String str);

    public abstract com.baidu.adp.widget.a.a fu(String str);

    public abstract com.baidu.adp.widget.a.a fv(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a CS() {
        return this.avb;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.avb = aVar;
    }

    public com.baidu.adp.widget.a.a CT() {
        return this.avc;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.avc = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(int i) {
        this.cols = i;
    }

    public int CU() {
        return this.avd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(int i) {
        this.avd = i;
    }
}
