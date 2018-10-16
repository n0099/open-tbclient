package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eHt = BdUniqueId.gen();
    private Object brz;
    private NoDataViewFactory.ImgType eHu;
    private String eHv;
    private String eHw;
    private String eHx;
    private int eHy;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eHt;
    }

    public String aPK() {
        return this.eHv;
    }

    public void pA(String str) {
        this.eHv = str;
    }

    public String aPL() {
        return this.eHw;
    }

    public void pB(String str) {
        this.eHw = str;
    }

    public String aPM() {
        return this.eHx;
    }

    public void pC(String str) {
        this.eHx = str;
    }

    public int aPN() {
        return this.eHy;
    }

    public void pf(int i) {
        this.eHy = i;
    }

    public Object SF() {
        return this.brz;
    }

    public void setExtraData(Object obj) {
        this.brz = obj;
    }

    public NoDataViewFactory.ImgType aPO() {
        return this.eHu;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eHu = imgType;
    }
}
