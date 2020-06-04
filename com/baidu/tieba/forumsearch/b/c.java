package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.o;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes11.dex */
public class c {
    private SearchForum hlU;
    private List<SearchForum> hlV;
    private ArrayList<o> hlW;
    private String hlt;

    public c(String str) {
        this.hlt = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hlU = dataRes.exact_match;
            this.hlV = dataRes.fuzzy_match;
            this.hlW = new ArrayList<>();
            b bVar = new b(this.hlt);
            if (this.hlU != null) {
                bVar.a(this.hlU);
                this.hlW.add(bVar);
            }
            if (this.hlV != null) {
                for (SearchForum searchForum : this.hlV) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hlt);
                        bVar2.a(searchForum);
                        this.hlW.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<o> bTX() {
        return this.hlW;
    }
}
