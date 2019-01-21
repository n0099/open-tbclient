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
    public static final BdUniqueId eoj = BdUniqueId.gen();
    private int dbl;
    private List<a> eok;
    private String eol;
    private String eom;

    public void a(Esport esport) {
        if (esport != null) {
            this.dbl = esport.floor_no.intValue();
            if (esport._static != null) {
                this.eol = esport._static.img;
                this.eom = esport._static.url;
            }
            this.eok = new ArrayList();
            if (!StringUtils.isNull(this.eol)) {
                a aVar = new a();
                aVar.pq(this.eol);
                aVar.pr(this.eom);
                this.eok.add(aVar);
            }
            if (!v.I(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eok.add(aVar2);
                }
            }
        }
    }

    public int aKl() {
        return this.dbl;
    }

    public List<a> aKm() {
        return this.eok;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return eoj;
    }
}
