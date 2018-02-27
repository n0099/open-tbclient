package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a btg;
    private com.baidu.adp.widget.a.a bth;
    private int cols;
    private int rows;

    public abstract boolean Lp();

    public abstract EmotionGroupType Lq();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean gn(String str);

    public abstract com.baidu.adp.widget.a.a go(String str);

    public abstract com.baidu.adp.widget.a.a gp(String str);

    public abstract String hL(int i);

    public com.baidu.adp.widget.a.a Lr() {
        return this.btg;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.sh();
        }
        this.btg = aVar;
    }

    public com.baidu.adp.widget.a.a Ls() {
        return this.bth;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.sh();
        }
        this.bth = aVar;
    }

    public int Lt() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hM(int i) {
        this.cols = i;
    }

    public int Lu() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hN(int i) {
        this.rows = i;
    }
}
