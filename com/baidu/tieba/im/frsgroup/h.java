package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes10.dex */
public class h implements q {
    public static final BdUniqueId iSg = BdUniqueId.gen();
    private Object agT;
    private NoDataViewFactory.ImgType iSh;
    private String iSi;
    private String iSj;
    private String iSk;
    private int iSl;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iSg;
    }

    public String cqj() {
        return this.iSi;
    }

    public void GZ(String str) {
        this.iSi = str;
    }

    public String cqk() {
        return this.iSj;
    }

    public void Ha(String str) {
        this.iSj = str;
    }

    public String cql() {
        return this.iSk;
    }

    public void Hb(String str) {
        this.iSk = str;
    }

    public int cqm() {
        return this.iSl;
    }

    public void yq(int i) {
        this.iSl = i;
    }

    public Object sk() {
        return this.agT;
    }

    public void setExtraData(Object obj) {
        this.agT = obj;
    }

    public NoDataViewFactory.ImgType cqn() {
        return this.iSh;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.iSh = imgType;
    }
}
