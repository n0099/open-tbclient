package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a csY;
    private com.baidu.adp.widget.ImageView.a csZ;
    private int rows;

    public abstract boolean asp();

    public abstract EmotionGroupType asq();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String kt(int i);

    public abstract boolean qi(String str);

    public abstract com.baidu.adp.widget.ImageView.a qj(String str);

    public abstract com.baidu.adp.widget.ImageView.a qk(String str);

    public com.baidu.adp.widget.ImageView.a asr() {
        return this.csY;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nK();
        }
        this.csY = aVar;
    }

    public com.baidu.adp.widget.ImageView.a ass() {
        return this.csZ;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.nK();
        }
        this.csZ = aVar;
    }

    public int ast() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ku(int i) {
        this.cols = i;
    }

    public int asu() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kv(int i) {
        this.rows = i;
    }
}
