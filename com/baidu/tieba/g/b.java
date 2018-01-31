package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements i {
    public static final BdUniqueId dWa = BdUniqueId.gen();
    private int cXb;
    private List<a> dWb;
    private String dWc;
    private String dWd;

    public void a(Esport esport) {
        if (esport != null) {
            this.cXb = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dWc = esport._static.img;
                this.dWd = esport._static.url;
            }
            this.dWb = new ArrayList();
            if (!StringUtils.isNull(this.dWc)) {
                a aVar = new a();
                aVar.mj(this.dWc);
                aVar.mk(this.dWd);
                this.dWb.add(aVar);
            }
            if (!v.E(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dWb.add(aVar2);
                }
            }
        }
    }

    public int azL() {
        return this.cXb;
    }

    public List<a> azM() {
        return this.dWb;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dWa;
    }
}
