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
    public static final BdUniqueId fRw = BdUniqueId.gen();
    private int eAv;
    private List<a> fRx;
    private String fRy;
    private String fRz;

    public void a(Esport esport) {
        if (esport != null) {
            this.eAv = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fRy = esport._static.img;
                this.fRz = esport._static.url;
            }
            this.fRx = new ArrayList();
            if (!StringUtils.isNull(this.fRy)) {
                a aVar = new a();
                aVar.xi(this.fRy);
                aVar.xj(this.fRz);
                this.fRx.add(aVar);
            }
            if (!v.aa(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fRx.add(aVar2);
                }
            }
        }
    }

    public int brN() {
        return this.eAv;
    }

    public List<a> brO() {
        return this.fRx;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRw;
    }
}
