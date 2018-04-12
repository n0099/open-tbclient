package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements h {
    public static final BdUniqueId duW = BdUniqueId.gen();
    private int crD;
    private List<a> duX;
    private String duY;
    private String duZ;

    public void a(Esport esport) {
        if (esport != null) {
            this.crD = esport.floor_no.intValue();
            if (esport._static != null) {
                this.duY = esport._static.img;
                this.duZ = esport._static.url;
            }
            this.duX = new ArrayList();
            if (!StringUtils.isNull(this.duY)) {
                a aVar = new a();
                aVar.mw(this.duY);
                aVar.mx(this.duZ);
                this.duX.add(aVar);
            }
            if (!v.w(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.duX.add(aVar2);
                }
            }
        }
    }

    public int awb() {
        return this.crD;
    }

    public List<a> awc() {
        return this.duX;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return duW;
    }
}
