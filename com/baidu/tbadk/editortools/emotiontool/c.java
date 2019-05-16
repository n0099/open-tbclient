package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a crD;
    private com.baidu.adp.widget.ImageView.a crE;
    private int rows;

    public abstract boolean arh();

    public abstract EmotionGroupType ari();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String km(int i);

    public abstract boolean pS(String str);

    public abstract com.baidu.adp.widget.ImageView.a pT(String str);

    public abstract com.baidu.adp.widget.ImageView.a pU(String str);

    public com.baidu.adp.widget.ImageView.a arj() {
        return this.crD;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.ns();
        }
        this.crD = aVar;
    }

    public com.baidu.adp.widget.ImageView.a ark() {
        return this.crE;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.ns();
        }
        this.crE = aVar;
    }

    public int arl() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kn(int i) {
        this.cols = i;
    }

    public int arm() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ko(int i) {
        this.rows = i;
    }
}
