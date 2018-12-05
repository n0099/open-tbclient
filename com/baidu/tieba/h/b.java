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
    public static final BdUniqueId ekK = BdUniqueId.gen();
    private int cXH;
    private List<a> ekL;
    private String ekM;
    private String ekN;

    public void a(Esport esport) {
        if (esport != null) {
            this.cXH = esport.floor_no.intValue();
            if (esport._static != null) {
                this.ekM = esport._static.img;
                this.ekN = esport._static.url;
            }
            this.ekL = new ArrayList();
            if (!StringUtils.isNull(this.ekM)) {
                a aVar = new a();
                aVar.oX(this.ekM);
                aVar.oY(this.ekN);
                this.ekL.add(aVar);
            }
            if (!v.I(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.ekL.add(aVar2);
                }
            }
        }
    }

    public int aIY() {
        return this.cXH;
    }

    public List<a> aIZ() {
        return this.ekL;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return ekK;
    }
}
