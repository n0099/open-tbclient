package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId esp = BdUniqueId.gen();
    private Object bhF;
    private NoDataViewFactory.ImgType esq;
    private String esr;
    private String ess;
    private String est;
    private int esu;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return esp;
    }

    public String aKg() {
        return this.esr;
    }

    public void ot(String str) {
        this.esr = str;
    }

    public String aKh() {
        return this.ess;
    }

    public void ou(String str) {
        this.ess = str;
    }

    public String aKi() {
        return this.est;
    }

    public void ov(String str) {
        this.est = str;
    }

    public int aKj() {
        return this.esu;
    }

    public void od(int i) {
        this.esu = i;
    }

    public Object OR() {
        return this.bhF;
    }

    public void setExtraData(Object obj) {
        this.bhF = obj;
    }

    public NoDataViewFactory.ImgType aKk() {
        return this.esq;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.esq = imgType;
    }
}
