package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes23.dex */
public class h implements q {
    public static final BdUniqueId jMY = BdUniqueId.gen();
    private Object aiI;
    private NoDataViewFactory.ImgType jMZ;
    private String jNa;
    private String jNb;
    private String jNc;
    private int jNd;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jMY;
    }

    public String cMo() {
        return this.jNa;
    }

    public void LY(String str) {
        this.jNa = str;
    }

    public String cMp() {
        return this.jNb;
    }

    public void LZ(String str) {
        this.jNb = str;
    }

    public String cMq() {
        return this.jNc;
    }

    public void Ma(String str) {
        this.jNc = str;
    }

    public int cMr() {
        return this.jNd;
    }

    public void Co(int i) {
        this.jNd = i;
    }

    public Object ud() {
        return this.aiI;
    }

    public void setExtraData(Object obj) {
        this.aiI = obj;
    }

    public NoDataViewFactory.ImgType cMs() {
        return this.jMZ;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.jMZ = imgType;
    }
}
