package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hAa = BdUniqueId.gen();
    private Object MU;
    private NoDataViewFactory.ImgType hAb;
    private String hAc;
    private String hAd;
    private String hAe;
    private int hAf;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hAa;
    }

    public String bUU() {
        return this.hAc;
    }

    public void Dc(String str) {
        this.hAc = str;
    }

    public String bUV() {
        return this.hAd;
    }

    public void Dd(String str) {
        this.hAd = str;
    }

    public String bUW() {
        return this.hAe;
    }

    public void De(String str) {
        this.hAe = str;
    }

    public int bUX() {
        return this.hAf;
    }

    public void ws(int i) {
        this.hAf = i;
    }

    public Object nq() {
        return this.MU;
    }

    public void setExtraData(Object obj) {
        this.MU = obj;
    }

    public NoDataViewFactory.ImgType bUY() {
        return this.hAb;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.hAb = imgType;
    }
}
