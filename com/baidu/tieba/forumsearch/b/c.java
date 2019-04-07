package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private String eWT;
    private SearchForum eXp;
    private List<SearchForum> eXq;
    private ArrayList<m> eXr;

    public c(String str) {
        this.eWT = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.eXp = dataRes.exact_match;
            this.eXq = dataRes.fuzzy_match;
            this.eXr = new ArrayList<>();
            b bVar = new b(this.eWT);
            if (this.eXp != null) {
                bVar.a(this.eXp);
                this.eXr.add(bVar);
            }
            if (this.eXq != null) {
                for (SearchForum searchForum : this.eXq) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.eWT);
                        bVar2.a(searchForum);
                        this.eXr.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> bbB() {
        return this.eXr;
    }
}
