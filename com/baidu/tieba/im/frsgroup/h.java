package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId hBM = BdUniqueId.gen();
    private Object MV;
    private NoDataViewFactory.ImgType hBN;
    private String hBO;
    private String hBP;
    private String hBQ;
    private int hBR;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hBM;
    }

    public String bVn() {
        return this.hBO;
    }

    public void Dc(String str) {
        this.hBO = str;
    }

    public String bVo() {
        return this.hBP;
    }

    public void Dd(String str) {
        this.hBP = str;
    }

    public String bVp() {
        return this.hBQ;
    }

    public void De(String str) {
        this.hBQ = str;
    }

    public int bVq() {
        return this.hBR;
    }

    public void wA(int i) {
        this.hBR = i;
    }

    public Object nq() {
        return this.MV;
    }

    public void setExtraData(Object obj) {
        this.MV = obj;
    }

    public NoDataViewFactory.ImgType bVr() {
        return this.hBN;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.hBN = imgType;
    }
}
