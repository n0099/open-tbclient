package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId cGU = BdUniqueId.gen();
    private int bJW;
    private List<a> cGV;
    private String cGW;
    private String cGX;

    public void a(Esport esport) {
        if (esport != null) {
            this.bJW = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cGW = esport._static.img;
                this.cGX = esport._static.url;
            }
            this.cGV = new ArrayList();
            if (!StringUtils.isNull(this.cGW)) {
                a aVar = new a();
                aVar.kK(this.cGW);
                aVar.kL(this.cGX);
                this.cGV.add(aVar);
            }
            if (!u.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cGV.add(aVar2);
                }
            }
        }
    }

    public int alH() {
        return this.bJW;
    }

    public List<a> alI() {
        return this.cGV;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cGU;
    }
}
