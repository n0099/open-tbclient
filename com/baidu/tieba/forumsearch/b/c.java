package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.h;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes3.dex */
public class c {
    private SearchForum dJD;
    private List<SearchForum> dJE;
    private ArrayList<h> dJF;
    private String dJh;

    public c(String str) {
        this.dJh = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.dJD = dataRes.exact_match;
            this.dJE = dataRes.fuzzy_match;
            if (this.dJD != null && this.dJE != null) {
                this.dJF = new ArrayList<>();
                b bVar = new b(this.dJh);
                bVar.a(this.dJD);
                this.dJF.add(bVar);
                for (SearchForum searchForum : this.dJE) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.dJh);
                        bVar2.a(searchForum);
                        this.dJF.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<h> aAH() {
        return this.dJF;
    }
}
