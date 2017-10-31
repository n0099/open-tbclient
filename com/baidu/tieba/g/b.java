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
    public static final BdUniqueId cYc = BdUniqueId.gen();
    private int bUC;
    private List<a> cYd;
    private String cYe;
    private String cYf;

    public void a(Esport esport) {
        if (esport != null) {
            this.bUC = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cYe = esport._static.img;
                this.cYf = esport._static.url;
            }
            this.cYd = new ArrayList();
            if (!StringUtils.isNull(this.cYe)) {
                a aVar = new a();
                aVar.lD(this.cYe);
                aVar.lE(this.cYf);
                this.cYd.add(aVar);
            }
            if (!v.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cYd.add(aVar2);
                }
            }
        }
    }

    public int aqe() {
        return this.bUC;
    }

    public List<a> aqf() {
        return this.cYd;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cYc;
    }
}
