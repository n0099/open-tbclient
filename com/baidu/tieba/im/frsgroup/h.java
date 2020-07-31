package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes17.dex */
public class h implements q {
    public static final BdUniqueId jaq = BdUniqueId.gen();
    private Object agK;
    private NoDataViewFactory.ImgType jar;
    private String jas;
    private String jat;
    private String jau;
    private int jav;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jaq;
    }

    public String cuh() {
        return this.jas;
    }

    public void HO(String str) {
        this.jas = str;
    }

    public String cui() {
        return this.jat;
    }

    public void HP(String str) {
        this.jat = str;
    }

    public String cuj() {
        return this.jau;
    }

    public void HQ(String str) {
        this.jau = str;
    }

    public int cuk() {
        return this.jav;
    }

    public void yO(int i) {
        this.jav = i;
    }

    public Object sm() {
        return this.agK;
    }

    public void setExtraData(Object obj) {
        this.agK = obj;
    }

    public NoDataViewFactory.ImgType cul() {
        return this.jar;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jar = imgType;
    }
}
