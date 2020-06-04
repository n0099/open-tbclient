package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements o {
    public static final BdUniqueId iBb = BdUniqueId.gen();
    private Object agg;
    private NoDataViewFactory.ImgType iBc;
    private String iBd;
    private String iBe;
    private String iBf;
    private int iBg;

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return iBb;
    }

    public String cmt() {
        return this.iBd;
    }

    public void Gx(String str) {
        this.iBd = str;
    }

    public String cmu() {
        return this.iBe;
    }

    public void Gy(String str) {
        this.iBe = str;
    }

    public String cmv() {
        return this.iBf;
    }

    public void Gz(String str) {
        this.iBf = str;
    }

    public int cmw() {
        return this.iBg;
    }

    public void xG(int i) {
        this.iBg = i;
    }

    public Object rS() {
        return this.agg;
    }

    public void setExtraData(Object obj) {
        this.agg = obj;
    }

    public NoDataViewFactory.ImgType cmx() {
        return this.iBc;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.iBc = imgType;
    }
}
