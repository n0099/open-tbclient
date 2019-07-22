package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a csR;
    private com.baidu.adp.widget.ImageView.a csS;
    private int rows;

    public abstract boolean asn();

    public abstract EmotionGroupType aso();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String ks(int i);

    public abstract boolean qi(String str);

    public abstract com.baidu.adp.widget.ImageView.a qj(String str);

    public abstract com.baidu.adp.widget.ImageView.a qk(String str);

    public com.baidu.adp.widget.ImageView.a asp() {
        return this.csR;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nK();
        }
        this.csR = aVar;
    }

    public com.baidu.adp.widget.ImageView.a asq() {
        return this.csS;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nK();
        }
        this.csS = aVar;
    }

    public int asr() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kt(int i) {
        this.cols = i;
    }

    public int ass() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ku(int i) {
        this.rows = i;
    }
}
