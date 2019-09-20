package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a ctU;
    private com.baidu.adp.widget.ImageView.a ctV;
    private int rows;

    public abstract boolean asB();

    public abstract EmotionGroupType asC();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String kw(int i);

    public abstract boolean qt(String str);

    public abstract com.baidu.adp.widget.ImageView.a qu(String str);

    public abstract com.baidu.adp.widget.ImageView.a qv(String str);

    public com.baidu.adp.widget.ImageView.a asD() {
        return this.ctU;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nK();
        }
        this.ctU = aVar;
    }

    public com.baidu.adp.widget.ImageView.a asE() {
        return this.ctV;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nK();
        }
        this.ctV = aVar;
    }

    public int asF() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kx(int i) {
        this.cols = i;
    }

    public int asG() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ky(int i) {
        this.rows = i;
    }
}
