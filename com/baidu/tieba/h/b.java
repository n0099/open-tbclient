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
    public static final BdUniqueId duT = BdUniqueId.gen();
    private int crA;
    private List<a> duU;
    private String duV;
    private String duW;

    public void a(Esport esport) {
        if (esport != null) {
            this.crA = esport.floor_no.intValue();
            if (esport._static != null) {
                this.duV = esport._static.img;
                this.duW = esport._static.url;
            }
            this.duU = new ArrayList();
            if (!StringUtils.isNull(this.duV)) {
                a aVar = new a();
                aVar.mw(this.duV);
                aVar.mx(this.duW);
                this.duU.add(aVar);
            }
            if (!v.w(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.duU.add(aVar2);
                }
            }
        }
    }

    public int awb() {
        return this.crA;
    }

    public List<a> awc() {
        return this.duU;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return duT;
    }
}
