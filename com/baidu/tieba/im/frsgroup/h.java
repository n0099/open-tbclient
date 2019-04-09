package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gjb = BdUniqueId.gen();
    private Object Zx;
    private NoDataViewFactory.ImgType gjc;
    private String gjd;
    private String gje;
    private String gjf;
    private int gjg;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gjb;
    }

    public String bsO() {
        return this.gjd;
    }

    public void wZ(String str) {
        this.gjd = str;
    }

    public String bsP() {
        return this.gje;
    }

    public void xa(String str) {
        this.gje = str;
    }

    public String bsQ() {
        return this.gjf;
    }

    public void xb(String str) {
        this.gjf = str;
    }

    public int bsR() {
        return this.gjg;
    }

    public void tM(int i) {
        this.gjg = i;
    }

    public Object rD() {
        return this.Zx;
    }

    public void setExtraData(Object obj) {
        this.Zx = obj;
    }

    public NoDataViewFactory.ImgType bsS() {
        return this.gjc;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gjc = imgType;
    }
}
