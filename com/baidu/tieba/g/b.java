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
    public static final BdUniqueId dik = BdUniqueId.gen();
    private int cdx;
    private List<a> dil;
    private String dim;
    private String din;

    public void a(Esport esport) {
        if (esport != null) {
            this.cdx = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dim = esport._static.img;
                this.din = esport._static.url;
            }
            this.dil = new ArrayList();
            if (!StringUtils.isNull(this.dim)) {
                a aVar = new a();
                aVar.lO(this.dim);
                aVar.lP(this.din);
                this.dil.add(aVar);
            }
            if (!v.w(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dil.add(aVar2);
                }
            }
        }
    }

    public int asx() {
        return this.cdx;
    }

    public List<a> asy() {
        return this.dil;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return dik;
    }
}
