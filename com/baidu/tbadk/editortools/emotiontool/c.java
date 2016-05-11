package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aqv;
    private com.baidu.adp.widget.a.a aqw;
    private int aqx;
    private int cols;

    public abstract boolean Bu();

    public abstract EmotionGroupType Bv();

    public abstract String el(int i);

    public abstract boolean fl(String str);

    public abstract com.baidu.adp.widget.a.a fm(String str);

    public abstract com.baidu.adp.widget.a.a fn(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Bw() {
        return this.aqv;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.iY();
        }
        this.aqv = aVar;
    }

    public com.baidu.adp.widget.a.a Bx() {
        return this.aqw;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.iY();
        }
        this.aqw = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setCols(int i) {
        this.cols = i;
    }

    public int By() {
        return this.aqx;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void em(int i) {
        this.aqx = i;
    }
}
