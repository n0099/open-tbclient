package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dJQ;
    private SearchForum dKm;
    private List<SearchForum> dKn;
    private ArrayList<h> dKo;

    public c(String str) {
        this.dJQ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dKm = dataRes.exact_match;
            this.dKn = dataRes.fuzzy_match;
            if (this.dKm != null && this.dKn != null) {
                this.dKo = new ArrayList<>();
                b bVar = new b(this.dJQ);
                bVar.a(this.dKm);
                this.dKo.add(bVar);
                for (SearchForum searchForum : this.dKn) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dJQ);
                        bVar2.a(searchForum);
                        this.dKo.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> aBe() {
        return this.dKo;
    }
}
