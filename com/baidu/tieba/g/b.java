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
    public static final BdUniqueId cNj = BdUniqueId.gen();
    private int bMP;
    private List<a> cNk;
    private String cNl;
    private String cNm;

    public void a(Esport esport) {
        if (esport != null) {
            this.bMP = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cNl = esport._static.img;
                this.cNm = esport._static.url;
            }
            this.cNk = new ArrayList();
            if (!StringUtils.isNull(this.cNl)) {
                a aVar = new a();
                aVar.le(this.cNl);
                aVar.lf(this.cNm);
                this.cNk.add(aVar);
            }
            if (!v.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cNk.add(aVar2);
                }
            }
        }
    }

    public int anj() {
        return this.bMP;
    }

    public List<a> ank() {
        return this.cNk;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cNj;
    }
}
