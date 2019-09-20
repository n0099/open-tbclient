package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.m;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes6.dex */
public class c {
    private SearchForum fuI;
    private List<SearchForum> fuJ;
    private ArrayList<m> fuK;
    private String fuk;

    public c(String str) {
        this.fuk = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.fuI = dataRes.exact_match;
            this.fuJ = dataRes.fuzzy_match;
            this.fuK = new ArrayList<>();
            b bVar = new b(this.fuk);
            if (this.fuI != null) {
                bVar.a(this.fuI);
                this.fuK.add(bVar);
            }
            if (this.fuJ != null) {
                for (SearchForum searchForum : this.fuJ) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.fuk);
                        bVar2.a(searchForum);
                        this.fuK.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<m> blO() {
        return this.fuK;
    }
}
