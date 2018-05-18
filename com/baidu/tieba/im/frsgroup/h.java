package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dZt = BdUniqueId.gen();
    private Object aXE;
    private NoDataViewFactory.ImgType dZu;
    private String dZv;
    private String dZw;
    private String dZx;
    private int dZy;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dZt;
    }

    public String aDG() {
        return this.dZv;
    }

    public void nA(String str) {
        this.dZv = str;
    }

    public String aDH() {
        return this.dZw;
    }

    public void nB(String str) {
        this.dZw = str;
    }

    public String aDI() {
        return this.dZx;
    }

    public void nC(String str) {
        this.dZx = str;
    }

    public int aDJ() {
        return this.dZy;
    }

    public void nw(int i) {
        this.dZy = i;
    }

    public Object KU() {
        return this.aXE;
    }

    public void setExtraData(Object obj) {
        this.aXE = obj;
    }

    public NoDataViewFactory.ImgType aDK() {
        return this.dZu;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.dZu = imgType;
    }
}
