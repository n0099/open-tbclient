package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes23.dex */
public class h implements q {
    public static final BdUniqueId jZw = BdUniqueId.gen();
    private Object aiJ;
    private String jZA;
    private int jZB;
    private NoDataViewFactory.ImgType jZx;
    private String jZy;
    private String jZz;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jZw;
    }

    public String cPv() {
        return this.jZy;
    }

    public void Mw(String str) {
        this.jZy = str;
    }

    public String cPw() {
        return this.jZz;
    }

    public void Mx(String str) {
        this.jZz = str;
    }

    public String cPx() {
        return this.jZA;
    }

    public void My(String str) {
        this.jZA = str;
    }

    public int cPy() {
        return this.jZB;
    }

    public void CH(int i) {
        this.jZB = i;
    }

    public Object ud() {
        return this.aiJ;
    }

    public void setExtraData(Object obj) {
        this.aiJ = obj;
    }

    public NoDataViewFactory.ImgType cPz() {
        return this.jZx;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jZx = imgType;
    }
}
