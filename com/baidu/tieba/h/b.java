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
    public static final BdUniqueId gRK = BdUniqueId.gen();
    private List<a> eJu;
    private int fMG;
    private String gRL;
    private String gRM;

    public void a(Esport esport) {
        if (esport != null) {
            this.fMG = esport.floor_no.intValue();
            if (esport._static != null) {
                this.gRL = esport._static.img;
                this.gRM = esport._static.url;
            }
            this.eJu = new ArrayList();
            if (!StringUtils.isNull(this.gRL)) {
                a aVar = new a();
                aVar.BV(this.gRL);
                aVar.BW(this.gRM);
                this.eJu.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eJu.add(aVar2);
                }
            }
        }
    }

    public int bMa() {
        return this.fMG;
    }

    public List<a> bMb() {
        return this.eJu;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gRK;
    }
}
