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
    public static final BdUniqueId cYw = BdUniqueId.gen();
    private int bUP;
    private List<a> cYx;
    private String cYy;
    private String cYz;

    public void a(Esport esport) {
        if (esport != null) {
            this.bUP = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cYy = esport._static.img;
                this.cYz = esport._static.url;
            }
            this.cYx = new ArrayList();
            if (!StringUtils.isNull(this.cYy)) {
                a aVar = new a();
                aVar.lF(this.cYy);
                aVar.lG(this.cYz);
                this.cYx.add(aVar);
            }
            if (!v.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cYx.add(aVar2);
                }
            }
        }
    }

    public int aqu() {
        return this.bUP;
    }

    public List<a> aqv() {
        return this.cYx;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cYw;
    }
}
