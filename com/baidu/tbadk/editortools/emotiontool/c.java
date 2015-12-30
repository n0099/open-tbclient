package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a atd;
    private com.baidu.adp.widget.a.a ate;
    private int atf;
    private int atg;

    public abstract boolean BB();

    public abstract EmotionGroupType BC();

    public abstract String ef(int i);

    public abstract boolean fh(String str);

    public abstract com.baidu.adp.widget.a.a fi(String str);

    public abstract com.baidu.adp.widget.a.a fj(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a BD() {
        return this.atd;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mE();
        }
        this.atd = aVar;
    }

    public com.baidu.adp.widget.a.a BE() {
        return this.ate;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mE();
        }
        this.ate = aVar;
    }

    public int BF() {
        return this.atg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eg(int i) {
        this.atg = i;
    }

    public int BG() {
        return this.atf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eh(int i) {
        this.atf = i;
    }
}
