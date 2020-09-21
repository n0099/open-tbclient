package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes22.dex */
public class h implements q {
    public static final BdUniqueId jyb = BdUniqueId.gen();
    private Object aiq;
    private NoDataViewFactory.ImgType jyc;
    private String jyd;
    private String jye;
    private String jyf;
    private int jyg;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jyb;
    }

    public String cIF() {
        return this.jyd;
    }

    public void Lj(String str) {
        this.jyd = str;
    }

    public String cIG() {
        return this.jye;
    }

    public void Lk(String str) {
        this.jye = str;
    }

    public String cIH() {
        return this.jyf;
    }

    public void Ll(String str) {
        this.jyf = str;
    }

    public int cII() {
        return this.jyg;
    }

    public void BI(int i) {
        this.jyg = i;
    }

    public Object ud() {
        return this.aiq;
    }

    public void setExtraData(Object obj) {
        this.aiq = obj;
    }

    public NoDataViewFactory.ImgType cIJ() {
        return this.jyc;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jyc = imgType;
    }
}
