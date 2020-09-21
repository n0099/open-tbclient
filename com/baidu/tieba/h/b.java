package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements q {
    public static final BdUniqueId iIr = BdUniqueId.gen();
    private List<a> aDV;
    private int htF;
    private String iIs;
    private String iIt;

    public void a(Esport esport) {
        if (esport != null) {
            this.htF = esport.floor_no.intValue();
            if (esport._static != null) {
                this.iIs = esport._static.img;
                this.iIt = esport._static.url;
            }
            this.aDV = new ArrayList();
            if (!StringUtils.isNull(this.iIs)) {
                a aVar = new a();
                aVar.JC(this.iIs);
                aVar.JD(this.iIt);
                this.aDV.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aDV.add(aVar2);
                }
            }
        }
    }

    public int cyp() {
        return this.htF;
    }

    public List<a> cyq() {
        return this.aDV;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iIr;
    }
}
