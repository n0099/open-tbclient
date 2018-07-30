package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId est = BdUniqueId.gen();
    private Object bhE;
    private NoDataViewFactory.ImgType esu;
    private String esv;
    private String esw;
    private String esx;
    private int esy;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return est;
    }

    public String aKj() {
        return this.esv;
    }

    public void or(String str) {
        this.esv = str;
    }

    public String aKk() {
        return this.esw;
    }

    public void os(String str) {
        this.esw = str;
    }

    public String aKl() {
        return this.esx;
    }

    public void ot(String str) {
        this.esx = str;
    }

    public int aKm() {
        return this.esy;
    }

    public void od(int i) {
        this.esy = i;
    }

    public Object OS() {
        return this.bhE;
    }

    public void setExtraData(Object obj) {
        this.bhE = obj;
    }

    public NoDataViewFactory.ImgType aKn() {
        return this.esu;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.esu = imgType;
    }
}
