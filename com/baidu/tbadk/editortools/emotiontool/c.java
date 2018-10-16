package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.ImageView.a aUS;
    private com.baidu.adp.widget.ImageView.a aUT;
    private int cols;
    private int rows;

    public abstract boolean KV();

    public abstract EmotionGroupType KW();

    public abstract String fl(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract boolean hn(String str);

    public abstract com.baidu.adp.widget.ImageView.a ho(String str);

    public abstract com.baidu.adp.widget.ImageView.a hp(String str);

    public com.baidu.adp.widget.ImageView.a KX() {
        return this.aUS;
    }

    public void c(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.os();
        }
        this.aUS = aVar;
    }

    public com.baidu.adp.widget.ImageView.a KY() {
        return this.aUT;
    }

    public void d(com.baidu.adp.widget.ImageView.a aVar) {
        if (aVar != null) {
            aVar.os();
        }
        this.aUT = aVar;
    }

    public int KZ() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fm(int i) {
        this.cols = i;
    }

    public int La() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fn(int i) {
        this.rows = i;
    }
}
