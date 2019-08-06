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
    public static final BdUniqueId fXj = BdUniqueId.gen();
    private int eFy;
    private List<a> fXk;
    private String fXl;
    private String fXm;

    public void a(Esport esport) {
        if (esport != null) {
            this.eFy = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fXl = esport._static.img;
                this.fXm = esport._static.url;
            }
            this.fXk = new ArrayList();
            if (!StringUtils.isNull(this.fXl)) {
                a aVar = new a();
                aVar.xO(this.fXl);
                aVar.xP(this.fXm);
                this.fXk.add(aVar);
            }
            if (!v.aa(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fXk.add(aVar2);
                }
            }
        }
    }

    public int bub() {
        return this.eFy;
    }

    public List<a> buc() {
        return this.fXk;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fXj;
    }
}
