package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private String fmY;
    private SearchForum fnw;
    private List<SearchForum> fnx;
    private ArrayList<m> fny;

    public c(String str) {
        this.fmY = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fnw = dataRes.exact_match;
            this.fnx = dataRes.fuzzy_match;
            this.fny = new ArrayList<>();
            b bVar = new b(this.fmY);
            if (this.fnw != null) {
                bVar.a(this.fnw);
                this.fny.add(bVar);
            }
            if (this.fnx != null) {
                for (SearchForum searchForum : this.fnx) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.fmY);
                        bVar2.a(searchForum);
                        this.fny.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> biR() {
        return this.fny;
    }
}
