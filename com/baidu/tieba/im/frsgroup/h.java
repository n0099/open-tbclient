package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gHt = BdUniqueId.gen();
    private Object XJ;
    private NoDataViewFactory.ImgType gHu;
    private String gHv;
    private String gHw;
    private String gHx;
    private int gHy;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gHt;
    }

    public String bDz() {
        return this.gHv;
    }

    public void zc(String str) {
        this.gHv = str;
    }

    public String bDA() {
        return this.gHw;
    }

    public void zd(String str) {
        this.gHw = str;
    }

    public String bDB() {
        return this.gHx;
    }

    public void ze(String str) {
        this.gHx = str;
    }

    public int bDC() {
        return this.gHy;
    }

    public void vw(int i) {
        this.gHy = i;
    }

    public Object qV() {
        return this.XJ;
    }

    public void setExtraData(Object obj) {
        this.XJ = obj;
    }

    public NoDataViewFactory.ImgType bDD() {
        return this.gHu;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gHu = imgType;
    }
}
