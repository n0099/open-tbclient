package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aQr;
    private com.baidu.adp.widget.ImageView.a aQs;
    private int cols;
    private int rows;

    public abstract boolean IX();

    public abstract EmotionGroupType IY();

    public abstract String fc(int i);

    public abstract boolean gZ(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract com.baidu.adp.widget.ImageView.a ha(String str);

    public abstract com.baidu.adp.widget.ImageView.a hb(String str);

    public com.baidu.adp.widget.ImageView.a IZ() {
        return this.aQr;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oh();
        }
        this.aQr = aVar;
    }

    public com.baidu.adp.widget.ImageView.a Ja() {
        return this.aQs;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oh();
        }
        this.aQs = aVar;
    }

    public int Jb() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fd(int i) {
        this.cols = i;
    }

    public int Jc() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fe(int i) {
        this.rows = i;
    }
}
