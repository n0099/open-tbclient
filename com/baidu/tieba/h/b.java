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
    public static final BdUniqueId hCM = BdUniqueId.gen();
    private List<a> fom;
    private int gsb;
    private String hCN;
    private String hCO;

    public void a(Esport esport) {
        if (esport != null) {
            this.gsb = esport.floor_no.intValue();
            if (esport._static != null) {
                this.hCN = esport._static.img;
                this.hCO = esport._static.url;
            }
            this.fom = new ArrayList();
            if (!StringUtils.isNull(this.hCN)) {
                a aVar = new a();
                aVar.DG(this.hCN);
                aVar.DH(this.hCO);
                this.fom.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fom.add(aVar2);
                }
            }
        }
    }

    public int bWO() {
        return this.gsb;
    }

    public List<a> bWP() {
        return this.fom;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return hCM;
    }
}
