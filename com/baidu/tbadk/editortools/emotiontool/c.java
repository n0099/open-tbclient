package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aZf;
    private com.baidu.adp.widget.ImageView.a aZg;
    private int cols;
    private int rows;

    public abstract boolean Ml();

    public abstract EmotionGroupType Mm();

    public abstract String fN(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean hG(String str);

    public abstract com.baidu.adp.widget.ImageView.a hH(String str);

    public abstract com.baidu.adp.widget.ImageView.a hI(String str);

    public com.baidu.adp.widget.ImageView.a Mn() {
        return this.aZf;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.op();
        }
        this.aZf = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Mo() {
        return this.aZg;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.op();
        }
        this.aZg = aVar;
    }

    public int Mp() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fO(int i) {
        this.cols = i;
    }

    public int Mq() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fP(int i) {
        this.rows = i;
    }
}
