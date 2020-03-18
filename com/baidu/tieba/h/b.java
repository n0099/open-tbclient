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
    public static final BdUniqueId gSR = BdUniqueId.gen();
    private List<a> eJQ;
    private int fNo;
    private String gSS;
    private String gST;

    public void a(Esport esport) {
        if (esport != null) {
            this.fNo = esport.floor_no.intValue();
            if (esport._static != null) {
                this.gSS = esport._static.img;
                this.gST = esport._static.url;
            }
            this.eJQ = new ArrayList();
            if (!StringUtils.isNull(this.gSS)) {
                a aVar = new a();
                aVar.BU(this.gSS);
                aVar.BV(this.gST);
                this.eJQ.add(aVar);
            }
            if (!v.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.eJQ.add(aVar2);
                }
            }
        }
    }

    public int bMo() {
        return this.fNo;
    }

    public List<a> bMp() {
        return this.eJQ;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return gSR;
    }
}
