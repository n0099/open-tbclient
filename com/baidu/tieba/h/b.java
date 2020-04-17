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
    public static final BdUniqueId hCG = BdUniqueId.gen();
    private List<a> foh;
    private int grV;
    private String hCH;
    private String hCI;

    public void a(Esport esport) {
        if (esport != null) {
            this.grV = esport.floor_no.intValue();
            if (esport._static != null) {
                this.hCH = esport._static.img;
                this.hCI = esport._static.url;
            }
            this.foh = new ArrayList();
            if (!StringUtils.isNull(this.hCH)) {
                a aVar = new a();
                aVar.DD(this.hCH);
                aVar.DE(this.hCI);
                this.foh.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.foh.add(aVar2);
                }
            }
        }
    }

    public int bWP() {
        return this.grV;
    }

    public List<a> bWQ() {
        return this.foh;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hCG;
    }
}
