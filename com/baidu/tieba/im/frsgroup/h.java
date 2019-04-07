package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gja = BdUniqueId.gen();
    private Object Zw;
    private NoDataViewFactory.ImgType gjb;
    private String gjc;
    private String gjd;
    private String gje;
    private int gjf;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gja;
    }

    public String bsO() {
        return this.gjc;
    }

    public void wZ(String str) {
        this.gjc = str;
    }

    public String bsP() {
        return this.gjd;
    }

    public void xa(String str) {
        this.gjd = str;
    }

    public String bsQ() {
        return this.gje;
    }

    public void xb(String str) {
        this.gje = str;
    }

    public int bsR() {
        return this.gjf;
    }

    public void tM(int i) {
        this.gjf = i;
    }

    public Object rD() {
        return this.Zw;
    }

    public void setExtraData(Object obj) {
        this.Zw = obj;
    }

    public NoDataViewFactory.ImgType bsS() {
        return this.gjb;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gjb = imgType;
    }
}
