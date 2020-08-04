package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes17.dex */
public class h implements q {
    public static final BdUniqueId jas = BdUniqueId.gen();
    private Object agK;
    private NoDataViewFactory.ImgType jat;
    private String jau;
    private String jav;
    private String jaw;
    private int jax;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jas;
    }

    public String cuh() {
        return this.jau;
    }

    public void HO(String str) {
        this.jau = str;
    }

    public String cui() {
        return this.jav;
    }

    public void HP(String str) {
        this.jav = str;
    }

    public String cuj() {
        return this.jaw;
    }

    public void HQ(String str) {
        this.jaw = str;
    }

    public int cuk() {
        return this.jax;
    }

    public void yO(int i) {
        this.jax = i;
    }

    public Object sm() {
        return this.agK;
    }

    public void setExtraData(Object obj) {
        this.agK = obj;
    }

    public NoDataViewFactory.ImgType cul() {
        return this.jat;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jat = imgType;
    }
}
