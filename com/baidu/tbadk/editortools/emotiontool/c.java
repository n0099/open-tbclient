package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a euJ;
    private com.baidu.adp.widget.ImageView.a euK;
    private int rows;

    public abstract boolean bfp();

    public abstract EmotionGroupType bfq();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String nE(int i);

    public abstract boolean yu(String str);

    public abstract com.baidu.adp.widget.ImageView.a yv(String str);

    public abstract com.baidu.adp.widget.ImageView.a yw(String str);

    public com.baidu.adp.widget.ImageView.a bfr() {
        return this.euJ;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.euJ = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bfs() {
        return this.euK;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.euK = aVar;
    }

    public int bft() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nF(int i) {
        this.cols = i;
    }

    public int bfu() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nG(int i) {
        this.rows = i;
    }
}
