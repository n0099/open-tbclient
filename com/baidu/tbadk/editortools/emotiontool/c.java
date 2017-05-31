package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a azD;
    private com.baidu.adp.widget.a.a azE;
    private int azF;
    private int cols;

    public abstract EmotionGroupType CA();

    public abstract boolean Cz();

    public abstract String eB(int i);

    public abstract boolean fg(String str);

    public abstract com.baidu.adp.widget.a.a fh(String str);

    public abstract com.baidu.adp.widget.a.a fi(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a CB() {
        return this.azD;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kR();
        }
        this.azD = aVar;
    }

    public com.baidu.adp.widget.a.a CC() {
        return this.azE;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kR();
        }
        this.azE = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eC(int i) {
        this.cols = i;
    }

    public int CD() {
        return this.azF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eD(int i) {
        this.azF = i;
    }
}
