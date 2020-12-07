package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class c {
    private String iQJ;
    private SearchForum iRj;
    private List<SearchForum> iRk;
    private ArrayList<q> iRl;

    public c(String str) {
        this.iQJ = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iRj = dataRes.exact_match;
            this.iRk = dataRes.fuzzy_match;
            this.iRl = new ArrayList<>();
            b bVar = new b(this.iQJ);
            if (this.iRj != null) {
                bVar.a(this.iRj);
                this.iRl.add(bVar);
            }
            if (this.iRk != null) {
                for (SearchForum searchForum : this.iRk) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.iQJ);
                        bVar2.a(searchForum);
                        this.iRl.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> cAU() {
        return this.iRl;
    }
}
