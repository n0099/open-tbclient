package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eSs = BdUniqueId.gen();
    private Object bvN;
    private NoDataViewFactory.ImgType eSt;
    private String eSu;
    private String eSv;
    private String eSw;
    private int eSx;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eSs;
    }

    public String aRM() {
        return this.eSu;
    }

    public void qg(String str) {
        this.eSu = str;
    }

    public String aRN() {
        return this.eSv;
    }

    public void qh(String str) {
        this.eSv = str;
    }

    public String aRO() {
        return this.eSw;
    }

    public void qi(String str) {
        this.eSw = str;
    }

    public int aRP() {
        return this.eSx;
    }

    public void qf(int i) {
        this.eSx = i;
    }

    public Object TW() {
        return this.bvN;
    }

    public void setExtraData(Object obj) {
        this.bvN = obj;
    }

    public NoDataViewFactory.ImgType aRQ() {
        return this.eSt;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eSt = imgType;
    }
}
