package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements q {
    public static final BdUniqueId iXj = BdUniqueId.gen();
    private List<a> aGZ;
    private int hIz;
    private String iXk;
    private String iXl;

    public void a(Esport esport) {
        if (esport != null) {
            this.hIz = esport.floor_no.intValue();
            if (esport._static != null) {
                this.iXk = esport._static.img;
                this.iXl = esport._static.url;
            }
            this.aGZ = new ArrayList();
            if (!StringUtils.isNull(this.iXk)) {
                a aVar = new a();
                aVar.Kp(this.iXk);
                aVar.Kq(this.iXl);
                this.aGZ.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.aGZ.add(aVar2);
                }
            }
        }
    }

    public int cBM() {
        return this.hIz;
    }

    public List<a> cBN() {
        return this.aGZ;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iXj;
    }
}
