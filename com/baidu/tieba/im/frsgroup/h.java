package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes17.dex */
public class h implements q {
    public static final BdUniqueId jps = BdUniqueId.gen();
    private Object ahT;
    private NoDataViewFactory.ImgType jpt;
    private String jpu;
    private String jpv;
    private String jpw;
    private int jpx;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jps;
    }

    public String cEY() {
        return this.jpu;
    }

    public void KG(String str) {
        this.jpu = str;
    }

    public String cEZ() {
        return this.jpv;
    }

    public void KH(String str) {
        this.jpv = str;
    }

    public String cFa() {
        return this.jpw;
    }

    public void KI(String str) {
        this.jpw = str;
    }

    public int cFb() {
        return this.jpx;
    }

    public void Bh(int i) {
        this.jpx = i;
    }

    public Object tX() {
        return this.ahT;
    }

    public void setExtraData(Object obj) {
        this.ahT = obj;
    }

    public NoDataViewFactory.ImgType cFc() {
        return this.jpt;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jpt = imgType;
    }
}
