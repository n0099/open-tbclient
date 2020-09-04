package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes18.dex */
public class c {
    private String hQJ;
    private SearchForum hRj;
    private List<SearchForum> hRk;
    private ArrayList<q> hRl;

    public c(String str) {
        this.hQJ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hRj = dataRes.exact_match;
            this.hRk = dataRes.fuzzy_match;
            this.hRl = new ArrayList<>();
            b bVar = new b(this.hQJ);
            if (this.hRj != null) {
                bVar.a(this.hRj);
                this.hRl.add(bVar);
            }
            if (this.hRk != null) {
                for (SearchForum searchForum : this.hRk) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hQJ);
                        bVar2.a(searchForum);
                        this.hRl.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> ckK() {
        return this.hRl;
    }
}
