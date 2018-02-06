package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId eDH = BdUniqueId.gen();
    private Object bNP;
    private NoDataViewFactory.ImgType eDI;
    private String eDJ;
    private String eDK;
    private String eDL;
    private int eDM;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eDH;
    }

    public String aIL() {
        return this.eDJ;
    }

    public void nt(String str) {
        this.eDJ = str;
    }

    public String aIM() {
        return this.eDK;
    }

    public void nu(String str) {
        this.eDK = str;
    }

    public String aIN() {
        return this.eDL;
    }

    public void nv(String str) {
        this.eDL = str;
    }

    public int aIO() {
        return this.eDM;
    }

    public void pZ(int i) {
        this.eDM = i;
    }

    public Object Sy() {
        return this.bNP;
    }

    public void setExtraData(Object obj) {
        this.bNP = obj;
    }

    public NoDataViewFactory.ImgType aIP() {
        return this.eDI;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eDI = imgType;
    }
}
