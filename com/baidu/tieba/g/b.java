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
    public static final BdUniqueId eaq = BdUniqueId.gen();
    private int cZF;
    private List<a> ear;
    private String eas;
    private String eat;

    public void a(Esport esport) {
        if (esport != null) {
            this.cZF = esport.floor_no.intValue();
            if (esport._static != null) {
                this.eas = esport._static.img;
                this.eat = esport._static.url;
            }
            this.ear = new ArrayList();
            if (!StringUtils.isNull(this.eas)) {
                a aVar = new a();
                aVar.mt(this.eas);
                aVar.mu(this.eat);
                this.ear.add(aVar);
            }
            if (!v.E(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.ear.add(aVar2);
                }
            }
        }
    }

    public int aBf() {
        return this.cZF;
    }

    public List<a> aBg() {
        return this.ear;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return eaq;
    }
}
