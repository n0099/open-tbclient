package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dYp = BdUniqueId.gen();
    private Object aXD;
    private NoDataViewFactory.ImgType dYq;
    private String dYr;
    private String dYs;
    private String dYt;
    private int dYu;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dYp;
    }

    public String aDI() {
        return this.dYr;
    }

    public void nx(String str) {
        this.dYr = str;
    }

    public String aDJ() {
        return this.dYs;
    }

    public void ny(String str) {
        this.dYs = str;
    }

    public String aDK() {
        return this.dYt;
    }

    public void nz(String str) {
        this.dYt = str;
    }

    public int aDL() {
        return this.dYu;
    }

    public void ny(int i) {
        this.dYu = i;
    }

    public Object KW() {
        return this.aXD;
    }

    public void setExtraData(Object obj) {
        this.aXD = obj;
    }

    public NoDataViewFactory.ImgType aDM() {
        return this.dYq;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.dYq = imgType;
    }
}
