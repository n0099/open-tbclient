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
    public static final BdUniqueId fZa = BdUniqueId.gen();
    private int eHh;
    private List<a> fZb;
    private String fZc;
    private String fZd;

    public void a(Esport esport) {
        if (esport != null) {
            this.eHh = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fZc = esport._static.img;
                this.fZd = esport._static.url;
            }
            this.fZb = new ArrayList();
            if (!StringUtils.isNull(this.fZc)) {
                a aVar = new a();
                aVar.yn(this.fZc);
                aVar.yo(this.fZd);
                this.fZb.add(aVar);
            }
            if (!v.aa(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fZb.add(aVar2);
                }
            }
        }
    }

    public int buP() {
        return this.eHh;
    }

    public List<a> buQ() {
        return this.fZb;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fZa;
    }
}
