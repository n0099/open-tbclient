package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fEM;
    private com.baidu.adp.widget.ImageView.a fEN;
    private int rows;

    public abstract boolean DK(String str);

    public abstract com.baidu.adp.widget.ImageView.a DL(String str);

    public abstract com.baidu.adp.widget.ImageView.a DM(String str);

    public abstract boolean bFb();

    public abstract EmotionGroupType bFc();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String sy(int i);

    public com.baidu.adp.widget.ImageView.a bFd() {
        return this.fEM;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fEM = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bFe() {
        return this.fEN;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fEN = aVar;
    }

    public int bFf() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sz(int i) {
        this.cols = i;
    }

    public int bFg() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sA(int i) {
        this.rows = i;
    }
}
