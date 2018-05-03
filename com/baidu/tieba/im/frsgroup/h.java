package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId dYm = BdUniqueId.gen();
    private Object aXD;
    private NoDataViewFactory.ImgType dYn;
    private String dYo;
    private String dYp;
    private String dYq;
    private int dYr;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dYm;
    }

    public String aDI() {
        return this.dYo;
    }

    public void nx(String str) {
        this.dYo = str;
    }

    public String aDJ() {
        return this.dYp;
    }

    public void ny(String str) {
        this.dYp = str;
    }

    public String aDK() {
        return this.dYq;
    }

    public void nz(String str) {
        this.dYq = str;
    }

    public int aDL() {
        return this.dYr;
    }

    public void nx(int i) {
        this.dYr = i;
    }

    public Object KW() {
        return this.aXD;
    }

    public void setExtraData(Object obj) {
        this.aXD = obj;
    }

    public NoDataViewFactory.ImgType aDM() {
        return this.dYn;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.dYn = imgType;
    }
}
