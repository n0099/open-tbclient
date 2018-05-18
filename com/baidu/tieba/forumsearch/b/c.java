package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String cWR;
    private SearchForum cXn;
    private List<SearchForum> cXo;
    private ArrayList<h> cXp;

    public c(String str) {
        this.cWR = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.cXn = dataRes.exact_match;
            this.cXo = dataRes.fuzzy_match;
            if (this.cXn != null && this.cXo != null) {
                this.cXp = new ArrayList<>();
                b bVar = new b(this.cWR);
                bVar.a(this.cXn);
                this.cXp.add(bVar);
                for (SearchForum searchForum : this.cXo) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.cWR);
                        bVar2.a(searchForum);
                        this.cXp.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> aoH() {
        return this.cXp;
    }
}
