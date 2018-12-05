package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private SearchForum dGP;
    private List<SearchForum> dGQ;
    private ArrayList<h> dGR;
    private String dGt;

    public c(String str) {
        this.dGt = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dGP = dataRes.exact_match;
            this.dGQ = dataRes.fuzzy_match;
            if (this.dGP != null && this.dGQ != null) {
                this.dGR = new ArrayList<>();
                b bVar = new b(this.dGt);
                bVar.a(this.dGP);
                this.dGR.add(bVar);
                for (SearchForum searchForum : this.dGQ) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dGt);
                        bVar2.a(searchForum);
                        this.dGR.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> azS() {
        return this.dGR;
    }
}
