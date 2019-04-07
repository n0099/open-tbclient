package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a cju;
    private com.baidu.adp.widget.ImageView.a cjv;
    private int cols;
    private int rows;

    public abstract boolean ame();

    public abstract EmotionGroupType amf();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String jy(int i);

    public abstract boolean oK(String str);

    public abstract com.baidu.adp.widget.ImageView.a oL(String str);

    public abstract com.baidu.adp.widget.ImageView.a oM(String str);

    public com.baidu.adp.widget.ImageView.a amg() {
        return this.cju;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oy();
        }
        this.cju = aVar;
    }

    public com.baidu.adp.widget.ImageView.a amh() {
        return this.cjv;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.oy();
        }
        this.cjv = aVar;
    }

    public int ami() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jz(int i) {
        this.cols = i;
    }

    public int amj() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jA(int i) {
        this.rows = i;
    }
}
