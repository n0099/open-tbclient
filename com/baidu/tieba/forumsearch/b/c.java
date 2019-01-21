package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dJR;
    private SearchForum dKn;
    private List<SearchForum> dKo;
    private ArrayList<h> dKp;

    public c(String str) {
        this.dJR = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dKn = dataRes.exact_match;
            this.dKo = dataRes.fuzzy_match;
            if (this.dKn != null && this.dKo != null) {
                this.dKp = new ArrayList<>();
                b bVar = new b(this.dJR);
                bVar.a(this.dKn);
                this.dKp.add(bVar);
                for (SearchForum searchForum : this.dKo) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dJR);
                        bVar2.a(searchForum);
                        this.dKp.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> aBe() {
        return this.dKp;
    }
}
