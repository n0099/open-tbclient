package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a arA;
    private int arB;
    private int arC;
    private com.baidu.adp.widget.a.a arz;

    public abstract boolean BM();

    public abstract EmotionGroupType BN();

    public abstract String el(int i);

    public abstract boolean fd(String str);

    public abstract com.baidu.adp.widget.a.a fe(String str);

    public abstract com.baidu.adp.widget.a.a ff(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a BO() {
        return this.arz;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.ng();
        }
        this.arz = aVar;
    }

    public com.baidu.adp.widget.a.a BP() {
        return this.arA;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.ng();
        }
        this.arA = aVar;
    }

    public int BQ() {
        return this.arC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void em(int i) {
        this.arC = i;
    }

    public int BR() {
        return this.arB;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void en(int i) {
        this.arB = i;
    }
}
