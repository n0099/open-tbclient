package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class c {
    private com.baidu.adp.widget.a.a atW;
    private com.baidu.adp.widget.a.a atX;
    private int atY;
    private int rows;

    public abstract boolean CS();

    public abstract EmotionGroupType CT();

    public abstract String eA(int i);

    public abstract boolean fg(String str);

    public abstract com.baidu.adp.widget.a.a fh(String str);

    public abstract com.baidu.adp.widget.a.a fi(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a CU() {
        return this.atW;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mS();
        }
        this.atW = aVar;
    }

    public com.baidu.adp.widget.a.a CV() {
        return this.atX;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.mS();
        }
        this.atX = aVar;
    }

    public int CW() {
        return this.atY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eB(int i) {
        this.atY = i;
    }

    public int getRows() {
        return this.rows;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRows(int i) {
        this.rows = i;
    }
}
