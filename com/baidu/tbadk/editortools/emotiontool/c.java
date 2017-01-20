package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a aug;
    private com.baidu.adp.widget.a.a auh;
    private int aui;
    private int cols;

    public abstract boolean CL();

    public abstract EmotionGroupType CM();

    public abstract String eG(int i);

    public abstract boolean fq(String str);

    public abstract com.baidu.adp.widget.a.a fr(String str);

    public abstract com.baidu.adp.widget.a.a fs(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a CN() {
        return this.aug;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jT();
        }
        this.aug = aVar;
    }

    public com.baidu.adp.widget.a.a CO() {
        return this.auh;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jT();
        }
        this.auh = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eH(int i) {
        this.cols = i;
    }

    public int CP() {
        return this.aui;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eI(int i) {
        this.aui = i;
    }
}
