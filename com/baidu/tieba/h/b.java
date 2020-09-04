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
    public static final BdUniqueId iAW = BdUniqueId.gen();
    private List<a> geP;
    private int hmC;
    private String iAX;
    private String iAY;

    public void a(Esport esport) {
        if (esport != null) {
            this.hmC = esport.floor_no.intValue();
            if (esport._static != null) {
                this.iAX = esport._static.img;
                this.iAY = esport._static.url;
            }
            this.geP = new ArrayList();
            if (!StringUtils.isNull(this.iAX)) {
                a aVar = new a();
                aVar.Je(this.iAX);
                aVar.Jf(this.iAY);
                this.geP.add(aVar);
            }
            if (!y.isEmpty(esport.billboard)) {
                for (EsportRank esportRank : esport.billboard) {
                    a aVar2 = new a();
                    aVar2.a(esportRank);
                    this.geP.add(aVar2);
                }
            }
        }
    }

    public int cuW() {
        return this.hmC;
    }

    public List<a> cuX() {
        return this.geP;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return iAW;
    }
}
