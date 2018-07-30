package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements h {
    public static final BdUniqueId dNq = BdUniqueId.gen();
    private int cBL;
    private List<a> dNr;
    private String dNs;
    private String dNt;

    public void a(Esport esport) {
        if (esport != null) {
            this.cBL = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dNs = esport._static.img;
                this.dNt = esport._static.url;
            }
            this.dNr = new ArrayList();
            if (!StringUtils.isNull(this.dNs)) {
                a aVar = new a();
                aVar.nj(this.dNs);
                aVar.nk(this.dNt);
                this.dNr.add(aVar);
            }
            if (!w.z(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dNr.add(aVar2);
                }
            }
        }
    }

    public int aCh() {
        return this.cBL;
    }

    public List<a> aCi() {
        return this.dNr;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dNq;
    }
}
