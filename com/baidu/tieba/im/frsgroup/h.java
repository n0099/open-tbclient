package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId eoB = BdUniqueId.gen();
    private Object bgZ;
    private NoDataViewFactory.ImgType eoC;
    private String eoD;
    private String eoE;
    private String eoF;
    private int eoG;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eoB;
    }

    public String aJi() {
        return this.eoD;
    }

    public void op(String str) {
        this.eoD = str;
    }

    public String aJj() {
        return this.eoE;
    }

    public void oq(String str) {
        this.eoE = str;
    }

    public String aJk() {
        return this.eoF;
    }

    public void or(String str) {
        this.eoF = str;
    }

    public int aJl() {
        return this.eoG;
    }

    public void nP(int i) {
        this.eoG = i;
    }

    public Object OM() {
        return this.bgZ;
    }

    public void setExtraData(Object obj) {
        this.bgZ = obj;
    }

    public NoDataViewFactory.ImgType aJm() {
        return this.eoC;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.eoC = imgType;
    }
}
