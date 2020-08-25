package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes2.dex */
public class b implements q {
    public static final BdUniqueId iAQ = BdUniqueId.gen();
    private List<a> geL;
    private int hmy;
    private String iAR;
    private String iAS;

    public void a(Esport esport) {
        if (esport != null) {
            this.hmy = esport.floor_no.intValue();
            if (esport._static != null) {
                this.iAR = esport._static.img;
                this.iAS = esport._static.url;
            }
            this.geL = new ArrayList();
            if (!StringUtils.isNull(this.iAR)) {
                a aVar = new a();
                aVar.Jd(this.iAR);
                aVar.Je(this.iAS);
                this.geL.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.geL.add(aVar2);
                }
            }
        }
    }

    public int cuV() {
        return this.hmy;
    }

    public List<a> cuW() {
        return this.geL;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iAQ;
    }
}
