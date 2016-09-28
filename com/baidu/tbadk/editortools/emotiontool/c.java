package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a auK;
    private com.baidu.adp.widget.a.a auL;
    private int auM;
    private int cols;

    public abstract boolean CZ();

    public abstract EmotionGroupType Da();

    public abstract String eB(int i);

    public abstract boolean fu(String str);

    public abstract com.baidu.adp.widget.a.a fv(String str);

    public abstract com.baidu.adp.widget.a.a fw(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Db() {
        return this.auK;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.auK = aVar;
    }

    public com.baidu.adp.widget.a.a Dc() {
        return this.auL;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.jV();
        }
        this.auL = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eC(int i) {
        this.cols = i;
    }

    public int Dd() {
        return this.auM;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eD(int i) {
        this.auM = i;
    }
}
