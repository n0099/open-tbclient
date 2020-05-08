package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ilG = BdUniqueId.gen();
    private Object afJ;
    private NoDataViewFactory.ImgType ilH;
    private String ilI;
    private String ilJ;
    private String ilK;
    private int ilL;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ilG;
    }

    public String cfM() {
        return this.ilI;
    }

    public void EO(String str) {
        this.ilI = str;
    }

    public String cfN() {
        return this.ilJ;
    }

    public void EP(String str) {
        this.ilJ = str;
    }

    public String cfO() {
        return this.ilK;
    }

    public void EQ(String str) {
        this.ilK = str;
    }

    public int cfP() {
        return this.ilL;
    }

    public void wY(int i) {
        this.ilL = i;
    }

    public Object rJ() {
        return this.afJ;
    }

    public void setExtraData(Object obj) {
        this.afJ = obj;
    }

    public NoDataViewFactory.ImgType cfQ() {
        return this.ilH;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ilH = imgType;
    }
}
