package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId cPd = BdUniqueId.gen();
    private int bNk;
    private List<a> cPe;
    private String cPf;
    private String cPg;

    public void a(Esport esport) {
        if (esport != null) {
            this.bNk = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cPf = esport._static.img;
                this.cPg = esport._static.url;
            }
            this.cPe = new ArrayList();
            if (!StringUtils.isNull(this.cPf)) {
                a aVar = new a();
                aVar.ld(this.cPf);
                aVar.le(this.cPg);
                this.cPe.add(aVar);
            }
            if (!v.u(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cPe.add(aVar2);
                }
            }
        }
    }

    public int any() {
        return this.bNk;
    }

    public List<a> anz() {
        return this.cPe;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cPd;
    }
}
