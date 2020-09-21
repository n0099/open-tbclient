package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes23.dex */
public class c {
    private String hXJ;
    private SearchForum hYj;
    private List<SearchForum> hYk;
    private ArrayList<q> hYl;

    public c(String str) {
        this.hXJ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hYj = dataRes.exact_match;
            this.hYk = dataRes.fuzzy_match;
            this.hYl = new ArrayList<>();
            b bVar = new b(this.hXJ);
            if (this.hYj != null) {
                bVar.a(this.hYj);
                this.hYl.add(bVar);
            }
            if (this.hYk != null) {
                for (SearchForum searchForum : this.hYk) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hXJ);
                        bVar2.a(searchForum);
                        this.hYl.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> cnX() {
        return this.hYl;
    }
}
