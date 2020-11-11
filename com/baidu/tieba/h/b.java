package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements q {
    public static final BdUniqueId jpE = BdUniqueId.gen();
    private List<a> aIb;
    private int iaT;
    private String jpF;
    private String jpG;

    public void a(Esport esport) {
        if (esport != null) {
            this.iaT = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jpF = esport._static.img;
                this.jpG = esport._static.url;
            }
            this.aIb = new ArrayList();
            if (!StringUtils.isNull(this.jpF)) {
                a aVar = new a();
                aVar.Lf(this.jpF);
                aVar.Lg(this.jpG);
                this.aIb.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aIb.add(aVar2);
                }
            }
        }
    }

    public int cHu() {
        return this.iaT;
    }

    public List<a> cHv() {
        return this.aIb;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jpE;
    }
}
