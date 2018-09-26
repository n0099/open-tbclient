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
    public static final BdUniqueId dUE = BdUniqueId.gen();
    private int cHA;
    private List<a> dUF;
    private String dUG;
    private String dUH;

    public void a(Esport esport) {
        if (esport != null) {
            this.cHA = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dUG = esport._static.img;
                this.dUH = esport._static.url;
            }
            this.dUF = new ArrayList();
            if (!StringUtils.isNull(this.dUG)) {
                a aVar = new a();
                aVar.nQ(this.dUG);
                aVar.nR(this.dUH);
                this.dUF.add(aVar);
            }
            if (!v.z(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dUF.add(aVar2);
                }
            }
        }
    }

    public int aEr() {
        return this.cHA;
    }

    public List<a> aEs() {
        return this.dUF;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dUE;
    }
}
