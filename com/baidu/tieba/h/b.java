package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements o {
    public static final BdUniqueId hRz = BdUniqueId.gen();
    private List<a> fBZ;
    private int gGQ;
    private String hRA;
    private String hRB;

    public void a(Esport esport) {
        if (esport != null) {
            this.gGQ = esport.floor_no.intValue();
            if (esport._static != null) {
                this.hRA = esport._static.img;
                this.hRB = esport._static.url;
            }
            this.fBZ = new ArrayList();
            if (!StringUtils.isNull(this.hRA)) {
                a aVar = new a();
                aVar.Fp(this.hRA);
                aVar.Fq(this.hRB);
                this.fBZ.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fBZ.add(aVar2);
                }
            }
        }
    }

    public int cdm() {
        return this.gGQ;
    }

    public List<a> cdn() {
        return this.fBZ;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hRz;
    }
}
