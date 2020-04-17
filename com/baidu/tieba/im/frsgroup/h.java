package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId ilA = BdUniqueId.gen();
    private Object afG;
    private NoDataViewFactory.ImgType ilB;
    private String ilC;
    private String ilD;
    private String ilE;
    private int ilF;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return ilA;
    }

    public String cfO() {
        return this.ilC;
    }

    public void EL(String str) {
        this.ilC = str;
    }

    public String cfP() {
        return this.ilD;
    }

    public void EM(String str) {
        this.ilD = str;
    }

    public String cfQ() {
        return this.ilE;
    }

    public void EN(String str) {
        this.ilE = str;
    }

    public int cfR() {
        return this.ilF;
    }

    public void wY(int i) {
        this.ilF = i;
    }

    public Object rJ() {
        return this.afG;
    }

    public void setExtraData(Object obj) {
        this.afG = obj;
    }

    public NoDataViewFactory.ImgType cfS() {
        return this.ilB;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ilB = imgType;
    }
}
