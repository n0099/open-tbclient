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
    public static final BdUniqueId dwa = BdUniqueId.gen();
    private int csJ;
    private List<a> dwb;
    private String dwc;
    private String dwd;

    public void a(Esport esport) {
        if (esport != null) {
            this.csJ = esport.floor_no.intValue();
            if (esport._static != null) {
                this.dwc = esport._static.img;
                this.dwd = esport._static.url;
            }
            this.dwb = new ArrayList();
            if (!StringUtils.isNull(this.dwc)) {
                a aVar = new a();
                aVar.mz(this.dwc);
                aVar.mA(this.dwd);
                this.dwb.add(aVar);
            }
            if (!v.w(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.dwb.add(aVar2);
                }
            }
        }
    }

    public int awa() {
        return this.csJ;
    }

    public List<a> awb() {
        return this.dwb;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return dwa;
    }
}
