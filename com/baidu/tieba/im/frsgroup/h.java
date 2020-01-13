package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes8.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hxZ = BdUniqueId.gen();
    private Object Ms;
    private NoDataViewFactory.ImgType hya;
    private String hyb;
    private String hyc;
    private String hyd;
    private int hye;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hxZ;
    }

    public String bTr() {
        return this.hyb;
    }

    public void CM(String str) {
        this.hyb = str;
    }

    public String bTs() {
        return this.hyc;
    }

    public void CN(String str) {
        this.hyc = str;
    }

    public String bTt() {
        return this.hyd;
    }

    public void CO(String str) {
        this.hyd = str;
    }

    public int bTu() {
        return this.hye;
    }

    public void wm(int i) {
        this.hye = i;
    }

    public Object mZ() {
        return this.Ms;
    }

    public void setExtraData(Object obj) {
        this.Ms = obj;
    }

    public NoDataViewFactory.ImgType bTv() {
        return this.hya;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.hya = imgType;
    }
}
