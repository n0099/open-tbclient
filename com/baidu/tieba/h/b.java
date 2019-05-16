package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements m {
    public static final BdUniqueId fRt = BdUniqueId.gen();
    private int eAu;
    private List<a> fRu;
    private String fRv;
    private String fRw;

    public void a(Esport esport) {
        if (esport != null) {
            this.eAu = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fRv = esport._static.img;
                this.fRw = esport._static.url;
            }
            this.fRu = new ArrayList();
            if (!StringUtils.isNull(this.fRv)) {
                a aVar = new a();
                aVar.xg(this.fRv);
                aVar.xh(this.fRw);
                this.fRu.add(aVar);
            }
            if (!v.aa(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fRu.add(aVar2);
                }
            }
        }
    }

    public int brI() {
        return this.eAu;
    }

    public List<a> brJ() {
        return this.fRu;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRt;
    }
}
