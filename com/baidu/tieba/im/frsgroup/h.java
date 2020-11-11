package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.NoDataViewFactory;
/* loaded from: classes23.dex */
public class h implements q {
    public static final BdUniqueId kfu = BdUniqueId.gen();
    private Object aiJ;
    private NoDataViewFactory.ImgType kfv;
    private String kfw;
    private String kfx;
    private String kfy;
    private int kfz;

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return kfu;
    }

    public String cRW() {
        return this.kfw;
    }

    public void MN(String str) {
        this.kfw = str;
    }

    public String cRX() {
        return this.kfx;
    }

    public void MO(String str) {
        this.kfx = str;
    }

    public String cRY() {
        return this.kfy;
    }

    public void MP(String str) {
        this.kfy = str;
    }

    public int cRZ() {
        return this.kfz;
    }

    public void CU(int i) {
        this.kfz = i;
    }

    public Object ud() {
        return this.aiJ;
    }

    public void setExtraData(Object obj) {
        this.aiJ = obj;
    }

    public NoDataViewFactory.ImgType cSa() {
        return this.kfv;
    }

    public void c(NoDataViewFactory.ImgType imgType) {
        this.kfv = imgType;
    }
}
