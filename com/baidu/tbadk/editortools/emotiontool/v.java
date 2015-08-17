package com.baidu.tbadk.editortools.emotiontool;

import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* loaded from: classes.dex */
public abstract class v {
    private com.baidu.adp.widget.a.a aqS;
    private com.baidu.adp.widget.a.a aqT;
    private int aqU;
    private int aqV;

    public abstract EmotionGroupType AZ();

    public abstract boolean Ba();

    public abstract String dZ(int i);

    public abstract boolean eC(String str);

    public abstract com.baidu.adp.widget.a.a eD(String str);

    public abstract com.baidu.adp.widget.a.a eE(String str);

    public abstract int getEmotionsCount();

    public abstract String getGroupId();

    public abstract String getGroupName();

    public abstract int getHeight();

    public abstract int getWidth();

    public com.baidu.adp.widget.a.a Bg() {
        return this.aqS;
    }

    public void b(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.nc();
        }
        this.aqS = aVar;
    }

    public com.baidu.adp.widget.a.a Bh() {
        return this.aqT;
    }

    public void c(com.baidu.adp.widget.a.a aVar) {
        if (aVar != null) {
            aVar.nc();
        }
        this.aqT = aVar;
    }

    public int Bi() {
        return this.aqV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ea(int i) {
        this.aqV = i;
    }

    public int Bj() {
        return this.aqU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void eb(int i) {
        this.aqU = i;
    }
}
