package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements h {
    public static final BdUniqueId edS = BdUniqueId.gen();
    private int cRa;
    private List<a> edT;
    private String edU;
    private String edV;

    public void a(Esport esport) {
        if (esport != null) {
            this.cRa = esport.floor_no.intValue();
            if (esport._static != null) {
                this.edU = esport._static.img;
                this.edV = esport._static.url;
            }
            this.edT = new ArrayList();
            if (!StringUtils.isNull(this.edU)) {
                a aVar = new a();
                aVar.ov(this.edU);
                aVar.ow(this.edV);
                this.edT.add(aVar);
            }
            if (!v.I(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.edT.add(aVar2);
                }
            }
        }
    }

    public int aHh() {
        return this.cRa;
    }

    public List<a> aHi() {
        return this.edT;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return edS;
    }
}
