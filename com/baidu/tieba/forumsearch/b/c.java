package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private SearchForum dAq;
    private List<SearchForum> dAr;
    private ArrayList<h> dAs;
    private String dzU;

    public c(String str) {
        this.dzU = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dAq = dataRes.exact_match;
            this.dAr = dataRes.fuzzy_match;
            if (this.dAq != null && this.dAr != null) {
                this.dAs = new ArrayList<>();
                b bVar = new b(this.dzU);
                bVar.a(this.dAq);
                this.dAs.add(bVar);
                for (SearchForum searchForum : this.dAr) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dzU);
                        bVar2.a(searchForum);
                        this.dAs.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> ayi() {
        return this.dAs;
    }
}
