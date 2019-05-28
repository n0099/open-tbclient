package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gAp = BdUniqueId.gen();
    private Object Xp;
    private NoDataViewFactory.ImgType gAq;
    private String gAr;
    private String gAs;
    private String gAt;
    private int gAu;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gAp;
    }

    public String bAD() {
        return this.gAr;
    }

    public void yo(String str) {
        this.gAr = str;
    }

    public String bAE() {
        return this.gAs;
    }

    public void yp(String str) {
        this.gAs = str;
    }

    public String bAF() {
        return this.gAt;
    }

    public void yq(String str) {
        this.gAt = str;
    }

    public int bAG() {
        return this.gAu;
    }

    public void uT(int i) {
        this.gAu = i;
    }

    public Object qy() {
        return this.Xp;
    }

    public void setExtraData(Object obj) {
        this.Xp = obj;
    }

    public NoDataViewFactory.ImgType bAH() {
        return this.gAq;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gAq = imgType;
    }
}
