package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes5.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final BdUniqueId gHj = BdUniqueId.gen();
    private Object HC;
    private NoDataViewFactory.ImgType gHk;
    private String gHl;
    private String gHm;
    private String gHn;
    private int gHo;

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gHj;
    }

    public String bAY() {
        return this.gHl;
    }

    public void xT(String str) {
        this.gHl = str;
    }

    public String bAZ() {
        return this.gHm;
    }

    public void xU(String str) {
        this.gHm = str;
    }

    public String bBa() {
        return this.gHn;
    }

    public void xV(String str) {
        this.gHn = str;
    }

    public int bBb() {
        return this.gHo;
    }

    public void ug(int i) {
        this.gHo = i;
    }

    public Object mb() {
        return this.HC;
    }

    public void setExtraData(Object obj) {
        this.HC = obj;
    }

    public NoDataViewFactory.ImgType bBc() {
        return this.gHk;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.gHk = imgType;
    }
}
