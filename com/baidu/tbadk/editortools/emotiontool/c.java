package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a brg;
    private com.baidu.adp.widget.a.a brh;
    private int cols;
    private int rows;

    public abstract boolean KK();

    public abstract EmotionGroupType KL();

    public abstract boolean ge(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public abstract com.baidu.adp.widget.a.a gf(String str);

    public abstract com.baidu.adp.widget.a.a gg(String str);

    public abstract String hM(int i);

    public com.baidu.adp.widget.a.a KM() {
        return this.brg;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.sj();
        }
        this.brg = aVar;
    }

    public com.baidu.adp.widget.a.a KN() {
        return this.brh;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.sj();
        }
        this.brh = aVar;
    }

    public int getCols() {
        return this.cols;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hN(int i) {
        this.cols = i;
    }

    public int KO() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hO(int i) {
        this.rows = i;
    }
}
