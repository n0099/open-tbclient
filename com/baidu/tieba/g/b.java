package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements i {
    public static final BdUniqueId dVF = BdUniqueId.gen();
    private int cWG;
    private List<a> dVG;
    private String dVH;
    private String dVI;

    public void a(Esport esport) {
        if (esport != null) {
            this.cWG = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dVH = esport._static.img;
                this.dVI = esport._static.url;
            }
            this.dVG = new ArrayList();
            if (!StringUtils.isNull(this.dVH)) {
                a aVar = new a();
                aVar.mc(this.dVH);
                aVar.md(this.dVI);
                this.dVG.add(aVar);
            }
            if (!v.E(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dVG.add(aVar2);
                }
            }
        }
    }

    public int azG() {
        return this.cWG;
    }

    public List<a> azH() {
        return this.dVG;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dVF;
    }
}
