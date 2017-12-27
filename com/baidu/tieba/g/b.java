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
    public static final BdUniqueId dUw = BdUniqueId.gen();
    private int cSe;
    private List<a> dUx;
    private String dUy;
    private String dUz;

    public void a(Esport esport) {
        if (esport != null) {
            this.cSe = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dUy = esport._static.img;
                this.dUz = esport._static.url;
            }
            this.dUx = new ArrayList();
            if (!StringUtils.isNull(this.dUy)) {
                a aVar = new a();
                aVar.lX(this.dUy);
                aVar.lY(this.dUz);
                this.dUx.add(aVar);
            }
            if (!v.G(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dUx.add(aVar2);
                }
            }
        }
    }

    public int azE() {
        return this.cSe;
    }

    public List<a> azF() {
        return this.dUx;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return dUw;
    }
}
