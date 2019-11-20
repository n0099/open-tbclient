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
    public static final BdUniqueId fXE = BdUniqueId.gen();
    private int eOW;
    private List<a> fXF;
    private String fXG;
    private String fXH;

    public void a(Esport esport) {
        if (esport != null) {
            this.eOW = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fXG = esport._static.img;
                this.fXH = esport._static.url;
            }
            this.fXF = new ArrayList();
            if (!StringUtils.isNull(this.fXG)) {
                a aVar = new a();
                aVar.wF(this.fXG);
                aVar.wG(this.fXH);
                this.fXF.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fXF.add(aVar2);
                }
            }
        }
    }

    public int brP() {
        return this.eOW;
    }

    public List<a> brQ() {
        return this.fXF;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fXE;
    }
}
