package com.baidu.tieba.g;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.util.z;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements v {
    public static final BdUniqueId cws = BdUniqueId.gen();
    private int bDR;
    private List<a> cwt;
    private String cwu;
    private String cwv;

    public void a(Esport esport) {
        if (esport != null) {
            this.bDR = esport.floor_no.intValue();
            if (esport._static != null) {
                this.cwu = esport._static.img;
                this.cwv = esport._static.url;
            }
            this.cwt = new ArrayList();
            if (!StringUtils.isNull(this.cwu)) {
                a aVar = new a();
                aVar.kp(this.cwu);
                aVar.kq(this.cwv);
                this.cwt.add(aVar);
            }
            if (!z.t(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.cwt.add(aVar2);
                }
            }
        }
    }

    public int ajo() {
        return this.bDR;
    }

    public List<a> ajp() {
        return this.cwt;
    }

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return cws;
    }
}
