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
    public static final BdUniqueId cEX = BdUniqueId.gen();
    private int bJn;
    private List<a> cEY;
    private String cEZ;
    private String cFa;

    public void a(Esport esport) {
        if (esport != null) {
            this.bJn = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cEZ = esport._static.img;
                this.cFa = esport._static.url;
            }
            this.cEY = new ArrayList();
            if (!StringUtils.isNull(this.cEZ)) {
                a aVar = new a();
                aVar.kG(this.cEZ);
                aVar.kH(this.cFa);
                this.cEY.add(aVar);
            }
            if (!u.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cEY.add(aVar2);
                }
            }
        }
    }

    public int alb() {
        return this.bJn;
    }

    public List<a> alc() {
        return this.cEY;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cEX;
    }
}
