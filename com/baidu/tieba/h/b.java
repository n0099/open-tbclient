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
    public static final BdUniqueId gPw = BdUniqueId.gen();
    private List<a> eFm;
    private int fJU;
    private String gPx;
    private String gPy;

    public void a(Esport esport) {
        if (esport != null) {
            this.fJU = esport.floor_no.intValue();
            if (esport._static != null) {
                this.gPx = esport._static.img;
                this.gPy = esport._static.url;
            }
            this.eFm = new ArrayList();
            if (!StringUtils.isNull(this.gPx)) {
                a aVar = new a();
                aVar.BE(this.gPx);
                aVar.BF(this.gPy);
                this.eFm.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eFm.add(aVar2);
                }
            }
        }
    }

    public int bKv() {
        return this.fJU;
    }

    public List<a> bKw() {
        return this.eFm;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gPw;
    }
}
