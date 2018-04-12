package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String cVN;
    private SearchForum cWj;
    private List<SearchForum> cWk;
    private ArrayList<h> cWl;

    public c(String str) {
        this.cVN = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cWj = dataRes.exact_match;
            this.cWk = dataRes.fuzzy_match;
            if (this.cWj != null && this.cWk != null) {
                this.cWl = new ArrayList<>();
                b bVar = new b(this.cVN);
                bVar.a(this.cWj);
                this.cWl.add(bVar);
                for (SearchForum searchForum : this.cWk) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.cVN);
                        bVar2.a(searchForum);
                        this.cWl.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> aoI() {
        return this.cWl;
    }
}
