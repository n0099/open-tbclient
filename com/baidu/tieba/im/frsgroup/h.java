package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eIM = BdUniqueId.gen();
    private Object bsl;
    private NoDataViewFactory.ImgType eIN;
    private String eIO;
    private String eIP;
    private String eIQ;
    private int eIR;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eIM;
    }

    public String aPh() {
        return this.eIO;
    }

    public void pB(String str) {
        this.eIO = str;
    }

    public String aPi() {
        return this.eIP;
    }

    public void pC(String str) {
        this.eIP = str;
    }

    public String aPj() {
        return this.eIQ;
    }

    public void pD(String str) {
        this.eIQ = str;
    }

    public int aPk() {
        return this.eIR;
    }

    public void py(int i) {
        this.eIR = i;
    }

    public Object SO() {
        return this.bsl;
    }

    public void setExtraData(Object obj) {
        this.bsl = obj;
    }

    public NoDataViewFactory.ImgType aPl() {
        return this.eIN;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eIN = imgType;
    }
}
