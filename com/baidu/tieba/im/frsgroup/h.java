package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hAm = BdUniqueId.gen();
    private Object MU;
    private NoDataViewFactory.ImgType hAn;
    private String hAo;
    private String hAp;
    private String hAq;
    private int hAr;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hAm;
    }

    public String bUV() {
        return this.hAo;
    }

    public void Dd(String str) {
        this.hAo = str;
    }

    public String bUW() {
        return this.hAp;
    }

    public void De(String str) {
        this.hAp = str;
    }

    public String bUX() {
        return this.hAq;
    }

    public void Df(String str) {
        this.hAq = str;
    }

    public int bUY() {
        return this.hAr;
    }

    public void ws(int i) {
        this.hAr = i;
    }

    public Object nq() {
        return this.MU;
    }

    public void setExtraData(Object obj) {
        this.MU = obj;
    }

    public NoDataViewFactory.ImgType bUZ() {
        return this.hAn;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.hAn = imgType;
    }
}
