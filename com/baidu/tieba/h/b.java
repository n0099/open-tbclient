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
    public static final BdUniqueId gRy = BdUniqueId.gen();
    private List<a> eJh;
    private int fMt;
    private String gRA;
    private String gRz;

    public void a(Esport esport) {
        if (esport != null) {
            this.fMt = esport.floor_no.intValue();
            if (esport._static != null) {
                this.gRz = esport._static.img;
                this.gRA = esport._static.url;
            }
            this.eJh = new ArrayList();
            if (!StringUtils.isNull(this.gRz)) {
                a aVar = new a();
                aVar.BU(this.gRz);
                aVar.BV(this.gRA);
                this.eJh.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eJh.add(aVar2);
                }
            }
        }
    }

    public int bLZ() {
        return this.fMt;
    }

    public List<a> bMa() {
        return this.eJh;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gRy;
    }
}
