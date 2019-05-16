package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gAo = BdUniqueId.gen();
    private Object Xp;
    private NoDataViewFactory.ImgType gAp;
    private String gAq;
    private String gAr;
    private String gAs;
    private int gAt;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gAo;
    }

    public String bAA() {
        return this.gAq;
    }

    public void yo(String str) {
        this.gAq = str;
    }

    public String bAB() {
        return this.gAr;
    }

    public void yp(String str) {
        this.gAr = str;
    }

    public String bAC() {
        return this.gAs;
    }

    public void yq(String str) {
        this.gAs = str;
    }

    public int bAD() {
        return this.gAt;
    }

    public void uT(int i) {
        this.gAt = i;
    }

    public Object qy() {
        return this.Xp;
    }

    public void setExtraData(Object obj) {
        this.Xp = obj;
    }

    public NoDataViewFactory.ImgType bAE() {
        return this.gAp;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gAp = imgType;
    }
}
