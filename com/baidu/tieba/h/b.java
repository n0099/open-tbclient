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
    public static final BdUniqueId dNm = BdUniqueId.gen();
    private int cBI;
    private List<a> dNn;
    private String dNo;
    private String dNp;

    public void a(Esport esport) {
        if (esport != null) {
            this.cBI = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dNo = esport._static.img;
                this.dNp = esport._static.url;
            }
            this.dNn = new ArrayList();
            if (!StringUtils.isNull(this.dNo)) {
                a aVar = new a();
                aVar.nl(this.dNo);
                aVar.nm(this.dNp);
                this.dNn.add(aVar);
            }
            if (!w.z(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dNn.add(aVar2);
                }
            }
        }
    }

    public int aCe() {
        return this.cBI;
    }

    public List<a> aCf() {
        return this.dNn;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dNm;
    }
}
