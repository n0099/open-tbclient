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
    public static final BdUniqueId fRu = BdUniqueId.gen();
    private int eAv;
    private List<a> fRv;
    private String fRw;
    private String fRx;

    public void a(Esport esport) {
        if (esport != null) {
            this.eAv = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fRw = esport._static.img;
                this.fRx = esport._static.url;
            }
            this.fRv = new ArrayList();
            if (!StringUtils.isNull(this.fRw)) {
                a aVar = new a();
                aVar.xg(this.fRw);
                aVar.xh(this.fRx);
                this.fRv.add(aVar);
            }
            if (!v.aa(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fRv.add(aVar2);
                }
            }
        }
    }

    public int brL() {
        return this.eAv;
    }

    public List<a> brM() {
        return this.fRv;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fRu;
    }
}
