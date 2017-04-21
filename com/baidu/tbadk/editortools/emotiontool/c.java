package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a azT;
    private com.baidu.adp.widget.a.a azU;
    private int azV;
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
        return this.azT;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kS();
        }
        this.azT = aVar;
    }

    public com.baidu.adp.widget.a.a DE() {
        return this.azU;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.kS();
        }
        this.azU = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eF(int i) {
        this.cols = i;
    }

    public int DF() {
        return this.azV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(int i) {
        this.azV = i;
    }
}
