package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a avh;
    private com.baidu.adp.widget.a.a avi;
    private int avj;
    private int cols;

    public abstract boolean CZ();

    public abstract EmotionGroupType Da();

    public abstract String eC(int i);

    public abstract boolean fs(String str);

    public abstract com.baidu.adp.widget.a.a ft(String str);

    public abstract com.baidu.adp.widget.a.a fu(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Db() {
        return this.avh;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.avh = aVar;
    }

    public com.baidu.adp.widget.a.a Dc() {
        return this.avi;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.avi = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eD(int i) {
        this.cols = i;
    }

    public int Dd() {
        return this.avj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eE(int i) {
        this.avj = i;
    }
}
