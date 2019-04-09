package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private String eWU;
    private SearchForum eXq;
    private List<SearchForum> eXr;
    private ArrayList<m> eXs;

    public c(String str) {
        this.eWU = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eXq = dataRes.exact_match;
            this.eXr = dataRes.fuzzy_match;
            this.eXs = new ArrayList<>();
            b bVar = new b(this.eWU);
            if (this.eXq != null) {
                bVar.a(this.eXq);
                this.eXs.add(bVar);
            }
            if (this.eXr != null) {
                for (SearchForum searchForum : this.eXr) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.eWU);
                        bVar2.a(searchForum);
                        this.eXs.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bbB() {
        return this.eXs;
    }
}
