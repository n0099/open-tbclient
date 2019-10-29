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
    public static final BdUniqueId fYv = BdUniqueId.gen();
    private int ePN;
    private List<a> fYw;
    private String fYx;
    private String fYy;

    public void a(Esport esport) {
        if (esport != null) {
            this.ePN = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fYx = esport._static.img;
                this.fYy = esport._static.url;
            }
            this.fYw = new ArrayList();
            if (!StringUtils.isNull(this.fYx)) {
                a aVar = new a();
                aVar.wF(this.fYx);
                aVar.wG(this.fYy);
                this.fYw.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fYw.add(aVar2);
                }
            }
        }
    }

    public int brR() {
        return this.ePN;
    }

    public List<a> brS() {
        return this.fYw;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fYv;
    }
}
