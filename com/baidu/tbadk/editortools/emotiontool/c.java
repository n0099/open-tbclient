package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aZi;
    private com.baidu.adp.widget.ImageView.a aZj;
    private int cols;
    private int rows;

    public abstract boolean Mm();

    public abstract EmotionGroupType Mn();

    public abstract String fO(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean hH(String str);

    public abstract com.baidu.adp.widget.ImageView.a hI(String str);

    public abstract com.baidu.adp.widget.ImageView.a hJ(String str);

    public com.baidu.adp.widget.ImageView.a Mo() {
        return this.aZi;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.op();
        }
        this.aZi = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Mp() {
        return this.aZj;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.op();
        }
        this.aZj = aVar;
    }

    public int Mq() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fP(int i) {
        this.cols = i;
    }

    public int Mr() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fQ(int i) {
        this.rows = i;
    }
}
