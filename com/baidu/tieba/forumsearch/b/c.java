package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.i;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dCS;
    private SearchForum dDo;
    private List<SearchForum> dDp;
    private ArrayList<i> dDq;

    public c(String str) {
        this.dCS = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dDo = dataRes.exact_match;
            this.dDp = dataRes.fuzzy_match;
            if (this.dDo != null && this.dDp != null) {
                this.dDq = new ArrayList<>();
                b bVar = new b(this.dCS);
                bVar.a(this.dDo);
                this.dDq.add(bVar);
                for (SearchForum searchForum : this.dDp) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dCS);
                        bVar2.a(searchForum);
                        this.dDq.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<i> aut() {
        return this.dDq;
    }
}
