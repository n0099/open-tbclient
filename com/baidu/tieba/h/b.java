package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements m {
    public static final BdUniqueId fAw = BdUniqueId.gen();
    private int ekF;
    private List<a> fAx;
    private String fAy;
    private String fAz;

    public void a(Esport esport) {
        if (esport != null) {
            this.ekF = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fAy = esport._static.img;
                this.fAz = esport._static.url;
            }
            this.fAx = new ArrayList();
            if (!StringUtils.isNull(this.fAy)) {
                a aVar = new a();
                aVar.vR(this.fAy);
                aVar.vS(this.fAz);
                this.fAx.add(aVar);
            }
            if (!v.T(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fAx.add(aVar2);
                }
            }
        }
    }

    public int bkq() {
        return this.ekF;
    }

    public List<a> bkr() {
        return this.fAx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fAw;
    }
}
