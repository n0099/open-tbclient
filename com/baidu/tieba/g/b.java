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
    public static final BdUniqueId dio = BdUniqueId.gen();
    private int cdB;
    private List<a> dip;
    private String diq;
    private String dir;

    public void a(Esport esport) {
        if (esport != null) {
            this.cdB = esport.floor_no.intValue();
            if (esport._static != null) {
                this.diq = esport._static.img;
                this.dir = esport._static.url;
            }
            this.dip = new ArrayList();
            if (!StringUtils.isNull(this.diq)) {
                a aVar = new a();
                aVar.lO(this.diq);
                aVar.lP(this.dir);
                this.dip.add(aVar);
            }
            if (!v.w(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dip.add(aVar2);
                }
            }
        }
    }

    public int asy() {
        return this.cdB;
    }

    public List<a> asz() {
        return this.dip;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return dio;
    }
}
