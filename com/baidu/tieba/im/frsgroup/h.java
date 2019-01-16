package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eTf = BdUniqueId.gen();
    private Object bwB;
    private NoDataViewFactory.ImgType eTg;
    private String eTh;
    private String eTi;
    private String eTj;
    private int eTk;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eTf;
    }

    public String aSm() {
        return this.eTh;
    }

    public void qw(String str) {
        this.eTh = str;
    }

    public String aSn() {
        return this.eTi;
    }

    public void qx(String str) {
        this.eTi = str;
    }

    public String aSo() {
        return this.eTj;
    }

    public void qy(String str) {
        this.eTj = str;
    }

    public int aSp() {
        return this.eTk;
    }

    public void qg(int i) {
        this.eTk = i;
    }

    public Object Us() {
        return this.bwB;
    }

    public void setExtraData(Object obj) {
        this.bwB = obj;
    }

    public NoDataViewFactory.ImgType aSq() {
        return this.eTg;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eTg = imgType;
    }
}
