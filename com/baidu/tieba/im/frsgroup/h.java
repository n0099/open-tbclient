package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    public static final BdUniqueId eDv = BdUniqueId.gen();
    private Object bNC;
    private int eDA;
    private NoDataViewFactory.ImgType eDw;
    private String eDx;
    private String eDy;
    private String eDz;

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eDv;
    }

    public String aIK() {
        return this.eDx;
    }

    public void nt(String str) {
        this.eDx = str;
    }

    public String aIL() {
        return this.eDy;
    }

    public void nu(String str) {
        this.eDy = str;
    }

    public String aIM() {
        return this.eDz;
    }

    public void nv(String str) {
        this.eDz = str;
    }

    public int aIN() {
        return this.eDA;
    }

    public void pZ(int i) {
        this.eDA = i;
    }

    public Object Sx() {
        return this.bNC;
    }

    public void setExtraData(Object obj) {
        this.bNC = obj;
    }

    public NoDataViewFactory.ImgType aIO() {
        return this.eDw;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eDw = imgType;
    }
}
