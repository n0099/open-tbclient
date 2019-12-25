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
    public static final BdUniqueId gMc = BdUniqueId.gen();
    private List<a> eEb;
    private int fGK;
    private String gMd;
    private String gMe;

    public void a(Esport esport) {
        if (esport != null) {
            this.fGK = esport.floor_no.intValue();
            if (esport._static != null) {
                this.gMd = esport._static.img;
                this.gMe = esport._static.url;
            }
            this.eEb = new ArrayList();
            if (!StringUtils.isNull(this.gMd)) {
                a aVar = new a();
                aVar.Bu(this.gMd);
                aVar.Bv(this.gMe);
                this.eEb.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eEb.add(aVar2);
                }
            }
        }
    }

    public int bJq() {
        return this.fGK;
    }

    public List<a> bJr() {
        return this.eEb;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gMc;
    }
}
