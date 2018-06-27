package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private String dhV;
    private SearchForum dir;
    private List<SearchForum> dis;
    private ArrayList<h> dit;

    public c(String str) {
        this.dhV = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dir = dataRes.exact_match;
            this.dis = dataRes.fuzzy_match;
            if (this.dir != null && this.dis != null) {
                this.dit = new ArrayList<>();
                b bVar = new b(this.dhV);
                bVar.a(this.dir);
                this.dit.add(bVar);
                for (SearchForum searchForum : this.dis) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dhV);
                        bVar2.a(searchForum);
                        this.dit.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> asX() {
        return this.dit;
    }
}
