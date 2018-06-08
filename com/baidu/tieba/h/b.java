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
    public static final BdUniqueId dHk = BdUniqueId.gen();
    private int cBm;
    private List<a> dHl;
    private String dHm;
    private String dHn;

    public void a(Esport esport) {
        if (esport != null) {
            this.cBm = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dHm = esport._static.img;
                this.dHn = esport._static.url;
            }
            this.dHl = new ArrayList();
            if (!StringUtils.isNull(this.dHm)) {
                a aVar = new a();
                aVar.nk(this.dHm);
                aVar.nl(this.dHn);
                this.dHl.add(aVar);
            }
            if (!w.z(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dHl.add(aVar2);
                }
            }
        }
    }

    public int aAS() {
        return this.cBm;
    }

    public List<a> aAT() {
        return this.dHl;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dHk;
    }
}
