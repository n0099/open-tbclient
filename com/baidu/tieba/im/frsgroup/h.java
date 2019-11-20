package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gGs = BdUniqueId.gen();
    private Object Hc;
    private NoDataViewFactory.ImgType gGt;
    private String gGu;
    private String gGv;
    private String gGw;
    private int gGx;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gGs;
    }

    public String bAW() {
        return this.gGu;
    }

    public void xT(String str) {
        this.gGu = str;
    }

    public String bAX() {
        return this.gGv;
    }

    public void xU(String str) {
        this.gGv = str;
    }

    public String bAY() {
        return this.gGw;
    }

    public void xV(String str) {
        this.gGw = str;
    }

    public int bAZ() {
        return this.gGx;
    }

    public void uf(int i) {
        this.gGx = i;
    }

    public Object mb() {
        return this.Hc;
    }

    public void setExtraData(Object obj) {
        this.Hc = obj;
    }

    public NoDataViewFactory.ImgType bBa() {
        return this.gGt;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gGt = imgType;
    }
}
