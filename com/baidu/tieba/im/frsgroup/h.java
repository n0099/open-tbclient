package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eHu = BdUniqueId.gen();
    private Object brz;
    private NoDataViewFactory.ImgType eHv;
    private String eHw;
    private String eHx;
    private String eHy;
    private int eHz;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eHu;
    }

    public String aPK() {
        return this.eHw;
    }

    public void pA(String str) {
        this.eHw = str;
    }

    public String aPL() {
        return this.eHx;
    }

    public void pB(String str) {
        this.eHx = str;
    }

    public String aPM() {
        return this.eHy;
    }

    public void pC(String str) {
        this.eHy = str;
    }

    public int aPN() {
        return this.eHz;
    }

    public void pf(int i) {
        this.eHz = i;
    }

    public Object SF() {
        return this.brz;
    }

    public void setExtraData(Object obj) {
        this.brz = obj;
    }

    public NoDataViewFactory.ImgType aPO() {
        return this.eHv;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eHv = imgType;
    }
}
