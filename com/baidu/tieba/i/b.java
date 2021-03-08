package com.baidu.tieba.i;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements n {
    public static final BdUniqueId jWs = BdUniqueId.gen();
    private List<a> aHX;
    private int iCb;
    private String jWt;
    private String jWu;

    public void a(Esport esport) {
        if (esport != null) {
            this.iCb = esport.floor_no.intValue();
            if (esport._static != null) {
                this.jWt = esport._static.img;
                this.jWu = esport._static.url;
            }
            this.aHX = new ArrayList();
            if (!StringUtils.isNull(this.jWt)) {
                a aVar = new a();
                aVar.LA(this.jWt);
                aVar.LB(this.jWu);
                this.aHX.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aHX.add(aVar2);
                }
            }
        }
    }

    public int cNV() {
        return this.iCb;
    }

    public List<a> cNW() {
        return this.aHX;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return jWs;
    }
}
