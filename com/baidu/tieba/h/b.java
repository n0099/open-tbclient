package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements m {
    public static final BdUniqueId fAI = BdUniqueId.gen();
    private int ekT;
    private List<a> fAJ;
    private String fAK;
    private String fAL;

    public void a(Esport esport) {
        if (esport != null) {
            this.ekT = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fAK = esport._static.img;
                this.fAL = esport._static.url;
            }
            this.fAJ = new ArrayList();
            if (!StringUtils.isNull(this.fAK)) {
                a aVar = new a();
                aVar.vS(this.fAK);
                aVar.vT(this.fAL);
                this.fAJ.add(aVar);
            }
            if (!v.T(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fAJ.add(aVar2);
                }
            }
        }
    }

    public int bks() {
        return this.ekT;
    }

    public List<a> bkt() {
        return this.fAJ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fAI;
    }
}
