package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements o {
    public static final BdUniqueId iAo = BdUniqueId.gen();
    private Object agg;
    private NoDataViewFactory.ImgType iAp;
    private String iAq;
    private String iAr;
    private String iAs;
    private int iAt;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return iAo;
    }

    public String cmk() {
        return this.iAq;
    }

    public void Gx(String str) {
        this.iAq = str;
    }

    public String cml() {
        return this.iAr;
    }

    public void Gy(String str) {
        this.iAr = str;
    }

    public String cmm() {
        return this.iAs;
    }

    public void Gz(String str) {
        this.iAs = str;
    }

    public int cmn() {
        return this.iAt;
    }

    public void xE(int i) {
        this.iAt = i;
    }

    public Object rS() {
        return this.agg;
    }

    public void setExtraData(Object obj) {
        this.agg = obj;
    }

    public NoDataViewFactory.ImgType cmo() {
        return this.iAp;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.iAp = imgType;
    }
}
