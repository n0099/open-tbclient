package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private int cols;
    private com.baidu.adp.widget.ImageView.a eNX;
    private com.baidu.adp.widget.ImageView.a eNY;
    private int rows;

    public abstract boolean Cn(String str);

    public abstract com.baidu.adp.widget.ImageView.a Co(String str);

    public abstract com.baidu.adp.widget.ImageView.a Cp(String str);

    public abstract boolean bsO();

    public abstract EmotionGroupType bsP();

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract String qu(int i);

    public com.baidu.adp.widget.ImageView.a bsQ() {
        return this.eNX;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eNX = aVar;
    }

    public com.baidu.adp.widget.ImageView.a bsR() {
        return this.eNY;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.getRawBitmap();
        }
        this.eNY = aVar;
    }

    public int bsS() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qv(int i) {
        this.cols = i;
    }

    public int bsT() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void qw(int i) {
        this.rows = i;
    }
}
