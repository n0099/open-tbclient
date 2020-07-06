package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements q {
    public static final BdUniqueId igG = BdUniqueId.gen();
    private List<a> fNt;
    private int gUb;
    private String igH;
    private String igI;

    public void a(Esport esport) {
        if (esport != null) {
            this.gUb = esport.floor_no.intValue();
            if (esport._static != null) {
                this.igH = esport._static.img;
                this.igI = esport._static.url;
            }
            this.fNt = new ArrayList();
            if (!StringUtils.isNull(this.igH)) {
                a aVar = new a();
                aVar.FP(this.igH);
                aVar.FQ(this.igI);
                this.fNt.add(aVar);
            }
            if (!w.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fNt.add(aVar2);
                }
            }
        }
    }

    public int cgS() {
        return this.gUb;
    }

    public List<a> cgT() {
        return this.fNt;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return igG;
    }
}
