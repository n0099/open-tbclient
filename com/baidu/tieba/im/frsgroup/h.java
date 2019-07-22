package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gGB = BdUniqueId.gen();
    private Object XJ;
    private NoDataViewFactory.ImgType gGC;
    private String gGD;
    private String gGE;
    private String gGF;
    private int gGG;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gGB;
    }

    public String bDl() {
        return this.gGD;
    }

    public void zb(String str) {
        this.gGD = str;
    }

    public String bDm() {
        return this.gGE;
    }

    public void zc(String str) {
        this.gGE = str;
    }

    public String bDn() {
        return this.gGF;
    }

    public void zd(String str) {
        this.gGF = str;
    }

    public int bDo() {
        return this.gGG;
    }

    public void vu(int i) {
        this.gGG = i;
    }

    public Object qV() {
        return this.XJ;
    }

    public void setExtraData(Object obj) {
        this.XJ = obj;
    }

    public NoDataViewFactory.ImgType bDp() {
        return this.gGC;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gGC = imgType;
    }
}
