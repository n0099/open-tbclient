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
    public static final BdUniqueId jUq = BdUniqueId.gen();
    private List<a> aGx;
    private int iAs;
    private String jUr;
    private String jUs;

    public void a(Esport esport) {
        if (esport != null) {
            this.iAs = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jUr = esport._static.img;
                this.jUs = esport._static.url;
            }
            this.aGx = new ArrayList();
            if (!StringUtils.isNull(this.jUr)) {
                a aVar = new a();
                aVar.Lu(this.jUr);
                aVar.Lv(this.jUs);
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

    public int cNO() {
        return this.iAs;
    }

    public List<a> cNP() {
        return this.aGx;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jUq;
    }
}
