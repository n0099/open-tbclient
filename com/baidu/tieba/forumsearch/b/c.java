package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.n;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes7.dex */
public class c {
    private SearchForum iYQ;
    private List<SearchForum> iYR;
    private ArrayList<n> iYS;
    private String iYq;

    public c(String str) {
        this.iYq = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iYQ = dataRes.exact_match;
            this.iYR = dataRes.fuzzy_match;
            this.iYS = new ArrayList<>();
            b bVar = new b(this.iYq);
            if (this.iYQ != null) {
                bVar.a(this.iYQ);
                this.iYS.add(bVar);
            }
            if (this.iYR != null) {
                for (SearchForum searchForum : this.iYR) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.iYq);
                        bVar2.a(searchForum);
                        this.iYS.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<n> czX() {
        return this.iYS;
    }
}
