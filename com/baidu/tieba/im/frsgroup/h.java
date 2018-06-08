package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId ekG = BdUniqueId.gen();
    private Object bfL;
    private NoDataViewFactory.ImgType ekH;
    private String ekI;
    private String ekJ;
    private String ekK;
    private int ekL;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ekG;
    }

    public String aIB() {
        return this.ekI;
    }

    public void oo(String str) {
        this.ekI = str;
    }

    public String aIC() {
        return this.ekJ;
    }

    public void op(String str) {
        this.ekJ = str;
    }

    public String aID() {
        return this.ekK;
    }

    public void oq(String str) {
        this.ekK = str;
    }

    public int aIE() {
        return this.ekL;
    }

    public void nI(int i) {
        this.ekL = i;
    }

    public Object Ot() {
        return this.bfL;
    }

    public void setExtraData(Object obj) {
        this.bfL = obj;
    }

    public NoDataViewFactory.ImgType aIF() {
        return this.ekH;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ekH = imgType;
    }
}
