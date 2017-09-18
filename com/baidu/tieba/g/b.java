package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements f {
    public static final BdUniqueId cOd = BdUniqueId.gen();
    private int bNG;
    private List<a> cOe;
    private String cOf;
    private String cOg;

    public void a(Esport esport) {
        if (esport != null) {
            this.bNG = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cOf = esport._static.img;
                this.cOg = esport._static.url;
            }
            this.cOe = new ArrayList();
            if (!StringUtils.isNull(this.cOf)) {
                a aVar = new a();
                aVar.lg(this.cOf);
                aVar.lh(this.cOg);
                this.cOe.add(aVar);
            }
            if (!v.v(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cOe.add(aVar2);
                }
            }
        }
    }

    public int anu() {
        return this.bNG;
    }

    public List<a> anv() {
        return this.cOe;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return cOd;
    }
}
