package com.baidu.tieba.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
import java.util.List;
import tbclient.Esport;
import tbclient.EsportRank;
/* loaded from: classes.dex */
public class b implements q {
    public static final BdUniqueId imK = BdUniqueId.gen();
    private List<a> fSM;
    private int gZF;
    private String imL;
    private String imM;

    public void a(Esport esport) {
        if (esport != null) {
            this.gZF = esport.floor_no.intValue();
            if (esport._static != null) {
                this.imL = esport._static.img;
                this.imM = esport._static.url;
            }
            this.fSM = new ArrayList();
            if (!StringUtils.isNull(this.imL)) {
                a aVar = new a();
                aVar.GB(this.imL);
                aVar.GC(this.imM);
                this.fSM.add(aVar);
            }
            if (!x.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.fSM.add(aVar2);
                }
            }
        }
    }

    public int ckr() {
        return this.gZF;
    }

    public List<a> cks() {
        return this.fSM;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return imK;
    }
}
