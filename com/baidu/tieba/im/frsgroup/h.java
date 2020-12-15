package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes23.dex */
public class h implements q {
    public static final BdUniqueId ktE = BdUniqueId.gen();
    private Object ajN;
    private NoDataViewFactory.ImgType ktF;
    private String ktG;
    private String ktH;
    private String ktI;
    private int ktJ;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ktE;
    }

    public String cWP() {
        return this.ktG;
    }

    public void Nw(String str) {
        this.ktG = str;
    }

    public String cWQ() {
        return this.ktH;
    }

    public void Nx(String str) {
        this.ktH = str;
    }

    public String cWR() {
        return this.ktI;
    }

    public void Ny(String str) {
        this.ktI = str;
    }

    public int cWS() {
        return this.ktJ;
    }

    public void Eh(int i) {
        this.ktJ = i;
    }

    public Object ug() {
        return this.ajN;
    }

    public void setExtraData(Object obj) {
        this.ajN = obj;
    }

    public NoDataViewFactory.ImgType cWT() {
        return this.ktF;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ktF = imgType;
    }
}
