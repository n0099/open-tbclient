package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements i {
    public static final BdUniqueId eaa = BdUniqueId.gen();
    private int cZC;
    private List<a> eab;
    private String eac;
    private String ead;

    public void a(Esport esport) {
        if (esport != null) {
            this.cZC = esport.floor_no.intValue();
            if (esport._static != null) {
                this.eac = esport._static.img;
                this.ead = esport._static.url;
            }
            this.eab = new ArrayList();
            if (!StringUtils.isNull(this.eac)) {
                a aVar = new a();
                aVar.mt(this.eac);
                aVar.mu(this.ead);
                this.eab.add(aVar);
            }
            if (!v.E(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eab.add(aVar2);
                }
            }
        }
    }

    public int aBe() {
        return this.cZC;
    }

    public List<a> aBf() {
        return this.eab;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eaa;
    }
}
