package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gJl = BdUniqueId.gen();
    private Object XI;
    private NoDataViewFactory.ImgType gJm;
    private String gJn;
    private String gJo;
    private String gJp;
    private int gJq;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gJl;
    }

    public String bEn() {
        return this.gJn;
    }

    public void zB(String str) {
        this.gJn = str;
    }

    public String bEo() {
        return this.gJo;
    }

    public void zC(String str) {
        this.gJo = str;
    }

    public String bEp() {
        return this.gJp;
    }

    public void zD(String str) {
        this.gJp = str;
    }

    public int bEq() {
        return this.gJq;
    }

    public void vA(int i) {
        this.gJq = i;
    }

    public Object qW() {
        return this.XI;
    }

    public void setExtraData(Object obj) {
        this.XI = obj;
    }

    public NoDataViewFactory.ImgType bEr() {
        return this.gJm;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gJm = imgType;
    }
}
