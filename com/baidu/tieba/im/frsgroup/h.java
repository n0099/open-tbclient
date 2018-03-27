package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId eDL = BdUniqueId.gen();
    private Object bNF;
    private NoDataViewFactory.ImgType eDM;
    private String eDN;
    private String eDO;
    private String eDP;
    private int eDQ;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eDL;
    }

    public String aIL() {
        return this.eDN;
    }

    public void nt(String str) {
        this.eDN = str;
    }

    public String aIM() {
        return this.eDO;
    }

    public void nu(String str) {
        this.eDO = str;
    }

    public String aIN() {
        return this.eDP;
    }

    public void nv(String str) {
        this.eDP = str;
    }

    public int aIO() {
        return this.eDQ;
    }

    public void qa(int i) {
        this.eDQ = i;
    }

    public Object Sy() {
        return this.bNF;
    }

    public void setExtraData(Object obj) {
        this.bNF = obj;
    }

    public NoDataViewFactory.ImgType aIP() {
        return this.eDM;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eDM = imgType;
    }
}
