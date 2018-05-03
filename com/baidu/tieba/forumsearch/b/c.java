package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String cVK;
    private SearchForum cWg;
    private List<SearchForum> cWh;
    private ArrayList<h> cWi;

    public c(String str) {
        this.cVK = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cWg = dataRes.exact_match;
            this.cWh = dataRes.fuzzy_match;
            if (this.cWg != null && this.cWh != null) {
                this.cWi = new ArrayList<>();
                b bVar = new b(this.cVK);
                bVar.a(this.cWg);
                this.cWi.add(bVar);
                for (SearchForum searchForum : this.cWh) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.cVK);
                        bVar2.a(searchForum);
                        this.cWi.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> aoI() {
        return this.cWi;
    }
}
