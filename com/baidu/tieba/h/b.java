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
    public static final BdUniqueId gRw = BdUniqueId.gen();
    private List<a> eJg;
    private int fMr;
    private String gRx;
    private String gRy;

    public void a(Esport esport) {
        if (esport != null) {
            this.fMr = esport.floor_no.intValue();
            if (esport._static != null) {
                this.gRx = esport._static.img;
                this.gRy = esport._static.url;
            }
            this.eJg = new ArrayList();
            if (!StringUtils.isNull(this.gRx)) {
                a aVar = new a();
                aVar.BU(this.gRx);
                aVar.BV(this.gRy);
                this.eJg.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eJg.add(aVar2);
                }
            }
        }
    }

    public int bLX() {
        return this.fMr;
    }

    public List<a> bLY() {
        return this.eJg;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gRw;
    }
}
