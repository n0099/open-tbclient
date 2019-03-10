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
    public static final BdUniqueId fAJ = BdUniqueId.gen();
    private int ekX;
    private List<a> fAK;
    private String fAL;
    private String fAM;

    public void a(Esport esport) {
        if (esport != null) {
            this.ekX = esport.floor_no.intValue();
            if (esport._static != null) {
                this.fAL = esport._static.img;
                this.fAM = esport._static.url;
            }
            this.fAK = new ArrayList();
            if (!StringUtils.isNull(this.fAL)) {
                a aVar = new a();
                aVar.vU(this.fAL);
                aVar.vV(this.fAM);
                this.fAK.add(aVar);
            }
            if (!v.T(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fAK.add(aVar2);
                }
            }
        }
    }

    public int bkt() {
        return this.ekX;
    }

    public List<a> bku() {
        return this.fAK;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return fAJ;
    }
}
