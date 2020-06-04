package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements o {
    public static final BdUniqueId hSm = BdUniqueId.gen();
    private List<a> fCk;
    private int gHb;
    private String hSn;
    private String hSo;

    public void a(Esport esport) {
        if (esport != null) {
            this.gHb = esport.floor_no.intValue();
            if (esport._static != null) {
                this.hSn = esport._static.img;
                this.hSo = esport._static.url;
            }
            this.fCk = new ArrayList();
            if (!StringUtils.isNull(this.hSn)) {
                a aVar = new a();
                aVar.Fp(this.hSn);
                aVar.Fq(this.hSo);
                this.fCk.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fCk.add(aVar2);
                }
            }
        }
    }

    public int cdu() {
        return this.gHb;
    }

    public List<a> cdv() {
        return this.fCk;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return hSm;
    }
}
