package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId cDC = BdUniqueId.gen();
    private int bId;
    private List<a> cDD;
    private String cDE;
    private String cDF;

    public void a(Esport esport) {
        if (esport != null) {
            this.bId = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cDE = esport._static.img;
                this.cDF = esport._static.url;
            }
            this.cDD = new ArrayList();
            if (!StringUtils.isNull(this.cDE)) {
                a aVar = new a();
                aVar.kC(this.cDE);
                aVar.kD(this.cDF);
                this.cDD.add(aVar);
            }
            if (!u.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cDD.add(aVar2);
                }
            }
        }
    }

    public int akO() {
        return this.bId;
    }

    public List<a> akP() {
        return this.cDD;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cDC;
    }
}
