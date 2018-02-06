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
    public static final BdUniqueId eam = BdUniqueId.gen();
    private int cZO;
    private List<a> ean;
    private String eao;
    private String eap;

    public void a(Esport esport) {
        if (esport != null) {
            this.cZO = esport.floor_no.intValue();
            if (esport._static != null) {
                this.eao = esport._static.img;
                this.eap = esport._static.url;
            }
            this.ean = new ArrayList();
            if (!StringUtils.isNull(this.eao)) {
                a aVar = new a();
                aVar.mt(this.eao);
                aVar.mu(this.eap);
                this.ean.add(aVar);
            }
            if (!v.E(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.ean.add(aVar2);
                }
            }
        }
    }

    public int aBf() {
        return this.cZO;
    }

    public List<a> aBg() {
        return this.ean;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eam;
    }
}
