package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a elT;
    private com.baidu.adp.widget.ImageView.a elU;
    private int rows;

    public abstract boolean bdk();

    public abstract EmotionGroupType bdl();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String ni(int i);

    public abstract boolean yb(String str);

    public abstract com.baidu.adp.widget.ImageView.a yc(String str);

    public abstract com.baidu.adp.widget.ImageView.a yd(String str);

    public com.baidu.adp.widget.ImageView.a bdm() {
        return this.elT;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.elT = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bdn() {
        return this.elU;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.elU = aVar;
    }

    public int bdo() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(int i) {
        this.cols = i;
    }

    public int bdp() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nk(int i) {
        this.rows = i;
    }
}
