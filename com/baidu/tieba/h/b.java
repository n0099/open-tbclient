package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements h {
    public static final BdUniqueId enB = BdUniqueId.gen();
    private int daz;
    private List<a> enC;
    private String enD;
    private String enE;

    public void a(Esport esport) {
        if (esport != null) {
            this.daz = esport.floor_no.intValue();
            if (esport._static != null) {
                this.enD = esport._static.img;
                this.enE = esport._static.url;
            }
            this.enC = new ArrayList();
            if (!StringUtils.isNull(this.enD)) {
                a aVar = new a();
                aVar.pa(this.enD);
                aVar.pb(this.enE);
                this.enC.add(aVar);
            }
            if (!v.I(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.enC.add(aVar2);
                }
            }
        }
    }

    public int aJN() {
        return this.daz;
    }

    public List<a> aJO() {
        return this.enC;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return enB;
    }
}
