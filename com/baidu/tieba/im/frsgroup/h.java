package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes17.dex */
public class h implements q {
    public static final BdUniqueId jpy = BdUniqueId.gen();
    private Object ahV;
    private String jpA;
    private String jpB;
    private String jpC;
    private int jpD;
    private NoDataViewFactory.ImgType jpz;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jpy;
    }

    public String cEZ() {
        return this.jpA;
    }

    public void KH(String str) {
        this.jpA = str;
    }

    public String cFa() {
        return this.jpB;
    }

    public void KI(String str) {
        this.jpB = str;
    }

    public String cFb() {
        return this.jpC;
    }

    public void KJ(String str) {
        this.jpC = str;
    }

    public int cFc() {
        return this.jpD;
    }

    public void Bh(int i) {
        this.jpD = i;
    }

    public Object tX() {
        return this.ahV;
    }

    public void setExtraData(Object obj) {
        this.ahV = obj;
    }

    public NoDataViewFactory.ImgType cFd() {
        return this.jpz;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jpz = imgType;
    }
}
