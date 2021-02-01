package com.baidu.tieba.i;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements n {
    public static final BdUniqueId jUc = BdUniqueId.gen();
    private List<a> aGx;
    private int iAe;
    private String jUd;
    private String jUe;

    public void a(Esport esport) {
        if (esport != null) {
            this.iAe = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jUd = esport._static.img;
                this.jUe = esport._static.url;
            }
            this.aGx = new ArrayList();
            if (!StringUtils.isNull(this.jUd)) {
                a aVar = new a();
                aVar.Lt(this.jUd);
                aVar.Lu(this.jUe);
                this.aGx.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aGx.add(aVar2);
                }
            }
        }
    }

    public int cNH() {
        return this.iAe;
    }

    public List<a> cNI() {
        return this.aGx;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jUc;
    }
}
