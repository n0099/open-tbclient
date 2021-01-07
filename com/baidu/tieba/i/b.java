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
    public static final BdUniqueId jRf = BdUniqueId.gen();
    private List<a> aJx;
    private int izb;
    private String jRg;
    private String jRh;

    public void a(Esport esport) {
        if (esport != null) {
            this.izb = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jRg = esport._static.img;
                this.jRh = esport._static.url;
            }
            this.aJx = new ArrayList();
            if (!StringUtils.isNull(this.jRg)) {
                a aVar = new a();
                aVar.LN(this.jRg);
                aVar.LO(this.jRh);
                this.aJx.add(aVar);
            }
            if (!x.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aJx.add(aVar2);
                }
            }
        }
    }

    public int cPC() {
        return this.izb;
    }

    public List<a> cPD() {
        return this.aJx;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jRf;
    }
}
