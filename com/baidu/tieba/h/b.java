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
    public static final BdUniqueId fWt = BdUniqueId.gen();
    private int eFr;
    private List<a> fWu;
    private String fWv;
    private String fWw;

    public void a(Esport esport) {
        if (esport != null) {
            this.eFr = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fWv = esport._static.img;
                this.fWw = esport._static.url;
            }
            this.fWu = new ArrayList();
            if (!StringUtils.isNull(this.fWv)) {
                a aVar = new a();
                aVar.xN(this.fWv);
                aVar.xO(this.fWw);
                this.fWu.add(aVar);
            }
            if (!v.aa(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fWu.add(aVar2);
                }
            }
        }
    }

    public int btO() {
        return this.eFr;
    }

    public List<a> btP() {
        return this.fWu;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fWt;
    }
}
