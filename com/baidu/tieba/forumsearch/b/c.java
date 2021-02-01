package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class c {
    private String jdX;
    private SearchForum jex;
    private List<SearchForum> jey;
    private ArrayList<n> jez;

    public c(String str) {
        this.jdX = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jex = dataRes.exact_match;
            this.jey = dataRes.fuzzy_match;
            this.jez = new ArrayList<>();
            b bVar = new b(this.jdX);
            if (this.jex != null) {
                bVar.a(this.jex);
                this.jez.add(bVar);
            }
            if (this.jey != null) {
                for (SearchForum searchForum : this.jey) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.jdX);
                        bVar2.a(searchForum);
                        this.jez.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<n> cBi() {
        return this.jez;
    }
}
