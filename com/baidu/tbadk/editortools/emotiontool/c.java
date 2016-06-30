package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a arl;
    private com.baidu.adp.widget.a.a arm;
    private int arn;
    private int cols;

    public abstract boolean BE();

    public abstract EmotionGroupType BF();

    public abstract String eo(int i);

    public abstract boolean fr(String str);

    public abstract com.baidu.adp.widget.a.a fs(String str);

    public abstract com.baidu.adp.widget.a.a ft(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a BG() {
        return this.arl;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jb();
        }
        this.arl = aVar;
    }

    public com.baidu.adp.widget.a.a BH() {
        return this.arm;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jb();
        }
        this.arm = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ep(int i) {
        this.cols = i;
    }

    public int BI() {
        return this.arn;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eq(int i) {
        this.arn = i;
    }
}
