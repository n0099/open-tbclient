package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a auw;
    private com.baidu.adp.widget.a.a aux;
    private int auy;
    private int rows;

    public abstract boolean DA();

    public abstract EmotionGroupType DB();

    public abstract String eF(int i);

    public abstract boolean fo(String str);

    public abstract com.baidu.adp.widget.a.a fp(String str);

    public abstract com.baidu.adp.widget.a.a fq(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a DC() {
        return this.auw;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mK();
        }
        this.auw = aVar;
    }

    public com.baidu.adp.widget.a.a DD() {
        return this.aux;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mK();
        }
        this.aux = aVar;
    }

    public int DE() {
        return this.auy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eG(int i) {
        this.auy = i;
    }

    public int getRows() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRows(int i) {
        this.rows = i;
    }
}
