package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId coD = BdUniqueId.gen();
    private int bCY;
    private List<a> coE;
    private String coF;
    private String coG;

    public void a(Esport esport) {
        if (esport != null) {
            this.bCY = esport.floor_no.intValue();
            if (esport._static != null) {
                this.coF = esport._static.img;
                this.coG = esport._static.url;
            }
            this.coE = new ArrayList();
            if (!StringUtils.isNull(this.coF)) {
                a aVar = new a();
                aVar.jr(this.coF);
                aVar.js(this.coG);
                this.coE.add(aVar);
            }
            if (!x.r(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.coE.add(aVar2);
                }
            }
        }
    }

    public int afE() {
        return this.bCY;
    }

    public List<a> afF() {
        return this.coE;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return coD;
    }
}
