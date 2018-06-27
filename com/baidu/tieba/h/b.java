package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements h {
    public static final BdUniqueId dKD = BdUniqueId.gen();
    private int czg;
    private List<a> dKE;
    private String dKF;
    private String dKG;

    public void a(Esport esport) {
        if (esport != null) {
            this.czg = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dKF = esport._static.img;
                this.dKG = esport._static.url;
            }
            this.dKE = new ArrayList();
            if (!StringUtils.isNull(this.dKF)) {
                a aVar = new a();
                aVar.nl(this.dKF);
                aVar.nm(this.dKG);
                this.dKE.add(aVar);
            }
            if (!w.A(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dKE.add(aVar2);
                }
            }
        }
    }

    public int aBy() {
        return this.czg;
    }

    public List<a> aBz() {
        return this.dKE;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dKD;
    }
}
