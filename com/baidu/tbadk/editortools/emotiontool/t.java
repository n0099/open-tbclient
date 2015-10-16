package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class t {
    private com.baidu.adp.widget.a.a aqZ;
    private com.baidu.adp.widget.a.a ara;
    private int arb;
    private int arc;

    public abstract EmotionGroupType AZ();

    public abstract boolean Ba();

    public abstract boolean eP(String str);

    public abstract com.baidu.adp.widget.a.a eQ(String str);

    public abstract com.baidu.adp.widget.a.a eR(String str);

    public abstract String ei(int i);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Bg() {
        return this.aqZ;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.na();
        }
        this.aqZ = aVar;
    }

    public com.baidu.adp.widget.a.a Bh() {
        return this.ara;
    }

    public void d(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.na();
        }
        this.ara = aVar;
    }

    public int Bi() {
        return this.arc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ej(int i) {
        this.arc = i;
    }

    public int Bj() {
        return this.arb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ek(int i) {
        this.arb = i;
    }
}
