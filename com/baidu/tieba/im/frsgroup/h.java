package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hzY = BdUniqueId.gen();
    private Object MU;
    private String hAa;
    private String hAb;
    private String hAc;
    private int hAd;
    private NoDataViewFactory.ImgType hzZ;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hzY;
    }

    public String bUS() {
        return this.hAa;
    }

    public void Dc(String str) {
        this.hAa = str;
    }

    public String bUT() {
        return this.hAb;
    }

    public void Dd(String str) {
        this.hAb = str;
    }

    public String bUU() {
        return this.hAc;
    }

    public void De(String str) {
        this.hAc = str;
    }

    public int bUV() {
        return this.hAd;
    }

    public void ws(int i) {
        this.hAd = i;
    }

    public Object nq() {
        return this.MU;
    }

    public void setExtraData(Object obj) {
        this.MU = obj;
    }

    public NoDataViewFactory.ImgType bUW() {
        return this.hzZ;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.hzZ = imgType;
    }
}
