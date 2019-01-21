package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aZT;
    private com.baidu.adp.widget.ImageView.a aZU;
    private int cols;
    private int rows;

    public abstract boolean MD();

    public abstract EmotionGroupType ME();

    public abstract String fO(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean hV(String str);

    public abstract com.baidu.adp.widget.ImageView.a hW(String str);

    public abstract com.baidu.adp.widget.ImageView.a hX(String str);

    public com.baidu.adp.widget.ImageView.a MF() {
        return this.aZT;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.ot();
        }
        this.aZT = aVar;
    }

    public com.baidu.adp.widget.ImageView.a MG() {
        return this.aZU;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.ot();
        }
        this.aZU = aVar;
    }

    public int MH() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fP(int i) {
        this.cols = i;
    }

    public int MI() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fQ(int i) {
        this.rows = i;
    }
}
