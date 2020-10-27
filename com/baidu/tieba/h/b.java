package com.baidu.tieba.h;

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
    public static final BdUniqueId jjG = BdUniqueId.gen();
    private List<a> aHk;
    private int hUW;
    private String jjH;
    private String jjI;

    public void a(Esport esport) {
        if (esport != null) {
            this.hUW = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jjH = esport._static.img;
                this.jjI = esport._static.url;
            }
            this.aHk = new ArrayList();
            if (!StringUtils.isNull(this.jjH)) {
                a aVar = new a();
                aVar.KO(this.jjH);
                aVar.KP(this.jjI);
                this.aHk.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aHk.add(aVar2);
                }
            }
        }
    }

    public int cET() {
        return this.hUW;
    }

    public List<a> cEU() {
        return this.aHk;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return jjG;
    }
}
