package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes23.dex */
public class h implements q {
    public static final BdUniqueId ktC = BdUniqueId.gen();
    private Object ajN;
    private NoDataViewFactory.ImgType ktD;
    private String ktE;
    private String ktF;
    private String ktG;
    private int ktH;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return ktC;
    }

    public String cWO() {
        return this.ktE;
    }

    public void Nw(String str) {
        this.ktE = str;
    }

    public String cWP() {
        return this.ktF;
    }

    public void Nx(String str) {
        this.ktF = str;
    }

    public String cWQ() {
        return this.ktG;
    }

    public void Ny(String str) {
        this.ktG = str;
    }

    public int cWR() {
        return this.ktH;
    }

    public void Eh(int i) {
        this.ktH = i;
    }

    public Object ug() {
        return this.ajN;
    }

    public void setExtraData(Object obj) {
        this.ajN = obj;
    }

    public NoDataViewFactory.ImgType cWS() {
        return this.ktD;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ktD = imgType;
    }
}
