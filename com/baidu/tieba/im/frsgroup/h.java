package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId ePB = BdUniqueId.gen();
    private Object bvK;
    private NoDataViewFactory.ImgType ePC;
    private String ePD;
    private String ePE;
    private String ePF;
    private int ePG;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ePB;
    }

    public String aQZ() {
        return this.ePD;
    }

    public void qd(String str) {
        this.ePD = str;
    }

    public String aRa() {
        return this.ePE;
    }

    public void qe(String str) {
        this.ePE = str;
    }

    public String aRb() {
        return this.ePF;
    }

    public void qf(String str) {
        this.ePF = str;
    }

    public int aRc() {
        return this.ePG;
    }

    public void pS(int i) {
        this.ePG = i;
    }

    public Object TU() {
        return this.bvK;
    }

    public void setExtraData(Object obj) {
        this.bvK = obj;
    }

    public NoDataViewFactory.ImgType aRd() {
        return this.ePC;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ePC = imgType;
    }
}
