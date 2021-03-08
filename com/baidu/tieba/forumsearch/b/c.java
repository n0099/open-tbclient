package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes7.dex */
public class c {
    private String jfU;
    private SearchForum jgu;
    private List<SearchForum> jgv;
    private ArrayList<n> jgw;

    public c(String str) {
        this.jfU = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jgu = dataRes.exact_match;
            this.jgv = dataRes.fuzzy_match;
            this.jgw = new ArrayList<>();
            b bVar = new b(this.jfU);
            if (this.jgu != null) {
                bVar.a(this.jgu);
                this.jgw.add(bVar);
            }
            if (this.jgv != null) {
                for (SearchForum searchForum : this.jgv) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.jfU);
                        bVar2.a(searchForum);
                        this.jgw.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<n> cBv() {
        return this.jgw;
    }
}
