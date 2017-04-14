package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a azR;
    private com.baidu.adp.widget.a.a azS;
    private int azT;
    private int cols;

    public abstract boolean DB();

    public abstract EmotionGroupType DC();

    public abstract String eE(int i);

    public abstract boolean fl(String str);

    public abstract com.baidu.adp.widget.a.a fm(String str);

    public abstract com.baidu.adp.widget.a.a fn(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a DD() {
        return this.azR;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kR();
        }
        this.azR = aVar;
    }

    public com.baidu.adp.widget.a.a DE() {
        return this.azS;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kR();
        }
        this.azS = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eF(int i) {
        this.cols = i;
    }

    public int DF() {
        return this.azT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(int i) {
        this.azT = i;
    }
}
