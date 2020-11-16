package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes22.dex */
public class h implements q {
    public static final BdUniqueId kge = BdUniqueId.gen();
    private Object aiO;
    private NoDataViewFactory.ImgType kgf;
    private String kgg;
    private String kgh;
    private String kgi;
    private int kgj;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kge;
    }

    public String cRC() {
        return this.kgg;
    }

    public void Mo(String str) {
        this.kgg = str;
    }

    public String cRD() {
        return this.kgh;
    }

    public void Mp(String str) {
        this.kgh = str;
    }

    public String cRE() {
        return this.kgi;
    }

    public void Mq(String str) {
        this.kgi = str;
    }

    public int cRF() {
        return this.kgj;
    }

    public void Ds(int i) {
        this.kgj = i;
    }

    public Object ud() {
        return this.aiO;
    }

    public void setExtraData(Object obj) {
        this.aiO = obj;
    }

    public NoDataViewFactory.ImgType cRG() {
        return this.kgf;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.kgf = imgType;
    }
}
