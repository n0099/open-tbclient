package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eTg = BdUniqueId.gen();
    private Object bwC;
    private NoDataViewFactory.ImgType eTh;
    private String eTi;
    private String eTj;
    private String eTk;
    private int eTl;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eTg;
    }

    public String aSm() {
        return this.eTi;
    }

    public void qw(String str) {
        this.eTi = str;
    }

    public String aSn() {
        return this.eTj;
    }

    public void qx(String str) {
        this.eTj = str;
    }

    public String aSo() {
        return this.eTk;
    }

    public void qy(String str) {
        this.eTk = str;
    }

    public int aSp() {
        return this.eTl;
    }

    public void qg(int i) {
        this.eTl = i;
    }

    public Object Us() {
        return this.bwC;
    }

    public void setExtraData(Object obj) {
        this.bwC = obj;
    }

    public NoDataViewFactory.ImgType aSq() {
        return this.eTh;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eTh = imgType;
    }
}
