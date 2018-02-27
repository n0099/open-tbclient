package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dCP;
    private SearchForum dDl;
    private List<SearchForum> dDm;
    private ArrayList<i> dDn;

    public c(String str) {
        this.dCP = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dDl = dataRes.exact_match;
            this.dDm = dataRes.fuzzy_match;
            if (this.dDl != null && this.dDm != null) {
                this.dDn = new ArrayList<>();
                b bVar = new b(this.dCP);
                bVar.a(this.dDl);
                this.dDn.add(bVar);
                for (SearchForum searchForum : this.dDm) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dCP);
                        bVar2.a(searchForum);
                        this.dDn.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<i> aus() {
        return this.dDn;
    }
}
