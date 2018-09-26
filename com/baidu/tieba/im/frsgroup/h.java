package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.h {
    public static final BdUniqueId ezJ = BdUniqueId.gen();
    private Object bnx;
    private NoDataViewFactory.ImgType ezK;
    private String ezL;
    private String ezM;
    private String ezN;
    private int ezO;

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ezJ;
    }

    public String aMv() {
        return this.ezL;
    }

    public void oY(String str) {
        this.ezL = str;
    }

    public String aMw() {
        return this.ezM;
    }

    public void oZ(String str) {
        this.ezM = str;
    }

    public String aMx() {
        return this.ezN;
    }

    public void pa(String str) {
        this.ezN = str;
    }

    public int aMy() {
        return this.ezO;
    }

    public void oH(int i) {
        this.ezO = i;
    }

    public Object QL() {
        return this.bnx;
    }

    public void setExtraData(Object obj) {
        this.bnx = obj;
    }

    public NoDataViewFactory.ImgType aMz() {
        return this.ezK;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.ezK = imgType;
    }
}
