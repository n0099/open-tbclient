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
    public static final BdUniqueId eoi = BdUniqueId.gen();
    private int dbk;
    private List<a> eoj;
    private String eok;
    private String eol;

    public void a(Esport esport) {
        if (esport != null) {
            this.dbk = esport.floor_no.intValue();
            if (esport._static != null) {
                this.eok = esport._static.img;
                this.eol = esport._static.url;
            }
            this.eoj = new ArrayList();
            if (!StringUtils.isNull(this.eok)) {
                a aVar = new a();
                aVar.pq(this.eok);
                aVar.pr(this.eol);
                this.eoj.add(aVar);
            }
            if (!v.I(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eoj.add(aVar2);
                }
            }
        }
    }

    public int aKl() {
        return this.dbk;
    }

    public List<a> aKm() {
        return this.eoj;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eoi;
    }
}
