package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId cOR = BdUniqueId.gen();
    private int bMY;
    private List<a> cOS;
    private String cOT;
    private String cOU;

    public void a(Esport esport) {
        if (esport != null) {
            this.bMY = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cOT = esport._static.img;
                this.cOU = esport._static.url;
            }
            this.cOS = new ArrayList();
            if (!StringUtils.isNull(this.cOT)) {
                a aVar = new a();
                aVar.lc(this.cOT);
                aVar.ld(this.cOU);
                this.cOS.add(aVar);
            }
            if (!v.u(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cOS.add(aVar2);
                }
            }
        }
    }

    public int ant() {
        return this.bMY;
    }

    public List<a> anu() {
        return this.cOS;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cOR;
    }
}
