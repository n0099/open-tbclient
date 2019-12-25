package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes7.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId huw = BdUniqueId.gen();
    private Object Mn;
    private String huA;
    private int huB;
    private NoDataViewFactory.ImgType hux;
    private String huy;
    private String huz;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return huw;
    }

    public String bSi() {
        return this.huy;
    }

    public void CC(String str) {
        this.huy = str;
    }

    public String bSj() {
        return this.huz;
    }

    public void CD(String str) {
        this.huz = str;
    }

    public String bSk() {
        return this.huA;
    }

    public void CE(String str) {
        this.huA = str;
    }

    public int bSl() {
        return this.huB;
    }

    public void wh(int i) {
        this.huB = i;
    }

    public Object mY() {
        return this.Mn;
    }

    public void setExtraData(Object obj) {
        this.Mn = obj;
    }

    public NoDataViewFactory.ImgType bSm() {
        return this.hux;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.hux = imgType;
    }
}
