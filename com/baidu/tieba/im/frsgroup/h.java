package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gjn = BdUniqueId.gen();
    private Object Zw;
    private NoDataViewFactory.ImgType gjo;
    private String gjp;
    private String gjq;
    private String gjr;
    private int gjs;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gjn;
    }

    public String bsR() {
        return this.gjp;
    }

    public void xa(String str) {
        this.gjp = str;
    }

    public String bsS() {
        return this.gjq;
    }

    public void xb(String str) {
        this.gjq = str;
    }

    public String bsT() {
        return this.gjr;
    }

    public void xc(String str) {
        this.gjr = str;
    }

    public int bsU() {
        return this.gjs;
    }

    public void tQ(int i) {
        this.gjs = i;
    }

    public Object rD() {
        return this.Zw;
    }

    public void setExtraData(Object obj) {
        this.Zw = obj;
    }

    public NoDataViewFactory.ImgType bsV() {
        return this.gjo;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gjo = imgType;
    }
}
