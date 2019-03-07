package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a cjs;
    private com.baidu.adp.widget.ImageView.a cjt;
    private int cols;
    private int rows;

    public abstract boolean ami();

    public abstract EmotionGroupType amj();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String jz(int i);

    public abstract boolean oJ(String str);

    public abstract com.baidu.adp.widget.ImageView.a oK(String str);

    public abstract com.baidu.adp.widget.ImageView.a oL(String str);

    public com.baidu.adp.widget.ImageView.a amk() {
        return this.cjs;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oy();
        }
        this.cjs = aVar;
    }

    public com.baidu.adp.widget.ImageView.a aml() {
        return this.cjt;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oy();
        }
        this.cjt = aVar;
    }

    public int amm() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jA(int i) {
        this.cols = i;
    }

    public int amn() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jB(int i) {
        this.rows = i;
    }
}
