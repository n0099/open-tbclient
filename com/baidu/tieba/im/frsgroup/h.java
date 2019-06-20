package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gAr = BdUniqueId.gen();
    private Object Xo;
    private NoDataViewFactory.ImgType gAs;
    private String gAt;
    private String gAu;
    private String gAv;
    private int gAw;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gAr;
    }

    public String bAE() {
        return this.gAt;
    }

    public void yq(String str) {
        this.gAt = str;
    }

    public String bAF() {
        return this.gAu;
    }

    public void yr(String str) {
        this.gAu = str;
    }

    public String bAG() {
        return this.gAv;
    }

    public void ys(String str) {
        this.gAv = str;
    }

    public int bAH() {
        return this.gAw;
    }

    public void uT(int i) {
        this.gAw = i;
    }

    public Object qy() {
        return this.Xo;
    }

    public void setExtraData(Object obj) {
        this.Xo = obj;
    }

    public NoDataViewFactory.ImgType bAI() {
        return this.gAs;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gAs = imgType;
    }
}
