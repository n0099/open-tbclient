package com.baidu.tieba.i;

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
    public static final BdUniqueId jql = BdUniqueId.gen();
    private List<a> aGq;
    private int ibH;
    private String jqm;
    private String jqn;

    public void a(Esport esport) {
        if (esport != null) {
            this.ibH = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jqm = esport._static.img;
                this.jqn = esport._static.url;
            }
            this.aGq = new ArrayList();
            if (!StringUtils.isNull(this.jqm)) {
                a aVar = new a();
                aVar.KG(this.jqm);
                aVar.KH(this.jqn);
                this.aGq.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aGq.add(aVar2);
                }
            }
        }
    }

    public int cGZ() {
        return this.ibH;
    }

    public List<a> cHa() {
        return this.aGq;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jql;
    }
}
