package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId dhf = BdUniqueId.gen();
    private int cdj;
    private List<a> dhg;
    private String dhh;
    private String dhi;

    public void a(Esport esport) {
        if (esport != null) {
            this.cdj = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dhh = esport._static.img;
                this.dhi = esport._static.url;
            }
            this.dhg = new ArrayList();
            if (!StringUtils.isNull(this.dhh)) {
                a aVar = new a();
                aVar.lO(this.dhh);
                aVar.lP(this.dhi);
                this.dhg.add(aVar);
            }
            if (!v.w(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dhg.add(aVar2);
                }
            }
        }
    }

    public int aso() {
        return this.cdj;
    }

    public List<a> asp() {
        return this.dhg;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return dhf;
    }
}
