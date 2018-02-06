package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dDb;
    private SearchForum dDx;
    private List<SearchForum> dDy;
    private ArrayList<i> dDz;

    public c(String str) {
        this.dDb = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dDx = dataRes.exact_match;
            this.dDy = dataRes.fuzzy_match;
            if (this.dDx != null && this.dDy != null) {
                this.dDz = new ArrayList<>();
                b bVar = new b(this.dDb);
                bVar.a(this.dDx);
                this.dDz.add(bVar);
                for (SearchForum searchForum : this.dDy) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dDb);
                        bVar2.a(searchForum);
                        this.dDz.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<i> aut() {
        return this.dDz;
    }
}
