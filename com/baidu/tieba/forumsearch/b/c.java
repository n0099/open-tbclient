package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class c {
    private String imJ;
    private SearchForum inj;
    private List<SearchForum> ink;
    private ArrayList<q> inl;

    public c(String str) {
        this.imJ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.inj = dataRes.exact_match;
            this.ink = dataRes.fuzzy_match;
            this.inl = new ArrayList<>();
            b bVar = new b(this.imJ);
            if (this.inj != null) {
                bVar.a(this.inj);
                this.inl.add(bVar);
            }
            if (this.ink != null) {
                for (SearchForum searchForum : this.ink) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.imJ);
                        bVar2.a(searchForum);
                        this.inl.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> crv() {
        return this.inl;
    }
}
