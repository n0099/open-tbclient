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
    public static final BdUniqueId jDL = BdUniqueId.gen();
    private List<a> aIZ;
    private int imE;
    private String jDM;
    private String jDN;

    public void a(Esport esport) {
        if (esport != null) {
            this.imE = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jDM = esport._static.img;
                this.jDN = esport._static.url;
            }
            this.aIZ = new ArrayList();
            if (!StringUtils.isNull(this.jDM)) {
                a aVar = new a();
                aVar.LN(this.jDM);
                aVar.LO(this.jDN);
                this.aIZ.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aIZ.add(aVar2);
                }
            }
        }
    }

    public int cMn() {
        return this.imE;
    }

    public List<a> cMo() {
        return this.aIZ;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jDL;
    }
}
