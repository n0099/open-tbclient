package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a fvg;
    private com.baidu.adp.widget.ImageView.a fvh;
    private int rows;

    public abstract boolean DN(String str);

    public abstract com.baidu.adp.widget.ImageView.a DO(String str);

    public abstract com.baidu.adp.widget.ImageView.a DP(String str);

    public abstract boolean bCG();

    public abstract EmotionGroupType bCH();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String sm(int i);

    public com.baidu.adp.widget.ImageView.a bCI() {
        return this.fvg;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fvg = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bCJ() {
        return this.fvh;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.fvh = aVar;
    }

    public int bCK() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sn(int i) {
        this.cols = i;
    }

    public int bCL() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void so(int i) {
        this.rows = i;
    }
}
