package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements h {
    public static final BdUniqueId ecx = BdUniqueId.gen();
    private int cPU;
    private String ecA;
    private List<a> ecy;
    private String ecz;

    public void a(Esport esport) {
        if (esport != null) {
            this.cPU = esport.floor_no.intValue();
            if (esport._static != null) {
                this.ecz = esport._static.img;
                this.ecA = esport._static.url;
            }
            this.ecy = new ArrayList();
            if (!StringUtils.isNull(this.ecz)) {
                a aVar = new a();
                aVar.ou(this.ecz);
                aVar.ov(this.ecA);
                this.ecy.add(aVar);
            }
            if (!v.J(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.ecy.add(aVar2);
                }
            }
        }
    }

    public int aHJ() {
        return this.cPU;
    }

    public List<a> aHK() {
        return this.ecy;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ecx;
    }
}
