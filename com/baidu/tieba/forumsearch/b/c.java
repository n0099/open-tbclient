package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes8.dex */
public class c {
    private String jcX;
    private SearchForum jdx;
    private List<SearchForum> jdy;
    private ArrayList<n> jdz;

    public c(String str) {
        this.jcX = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jdx = dataRes.exact_match;
            this.jdy = dataRes.fuzzy_match;
            this.jdz = new ArrayList<>();
            b bVar = new b(this.jcX);
            if (this.jdx != null) {
                bVar.a(this.jdx);
                this.jdz.add(bVar);
            }
            if (this.jdy != null) {
                for (SearchForum searchForum : this.jdy) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.jcX);
                        bVar2.a(searchForum);
                        this.jdz.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<n> cDP() {
        return this.jdz;
    }
}
