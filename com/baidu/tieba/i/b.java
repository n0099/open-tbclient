package com.baidu.tieba.i;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements n {
    public static final BdUniqueId jMA = BdUniqueId.gen();
    private List<a> aEK;
    private int iuu;
    private String jMB;
    private String jMC;

    public void a(Esport esport) {
        if (esport != null) {
            this.iuu = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jMB = esport._static.img;
                this.jMC = esport._static.url;
            }
            this.aEK = new ArrayList();
            if (!StringUtils.isNull(this.jMB)) {
                a aVar = new a();
                aVar.KG(this.jMB);
                aVar.KH(this.jMC);
                this.aEK.add(aVar);
            }
            if (!x.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aEK.add(aVar2);
                }
            }
        }
    }

    public int cLK() {
        return this.iuu;
    }

    public List<a> cLL() {
        return this.aEK;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jMA;
    }
}
