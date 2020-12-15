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
    public static final BdUniqueId jDN = BdUniqueId.gen();
    private List<a> aIZ;
    private int imG;
    private String jDO;
    private String jDP;

    public void a(Esport esport) {
        if (esport != null) {
            this.imG = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jDO = esport._static.img;
                this.jDP = esport._static.url;
            }
            this.aIZ = new ArrayList();
            if (!StringUtils.isNull(this.jDO)) {
                a aVar = new a();
                aVar.LN(this.jDO);
                aVar.LO(this.jDP);
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

    public int cMo() {
        return this.imG;
    }

    public List<a> cMp() {
        return this.aIZ;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jDN;
    }
}
