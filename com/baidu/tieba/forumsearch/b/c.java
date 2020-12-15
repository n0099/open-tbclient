package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes24.dex */
public class c {
    private String iQL;
    private SearchForum iRl;
    private List<SearchForum> iRm;
    private ArrayList<q> iRn;

    public c(String str) {
        this.iQL = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.iRl = dataRes.exact_match;
            this.iRm = dataRes.fuzzy_match;
            this.iRn = new ArrayList<>();
            b bVar = new b(this.iQL);
            if (this.iRl != null) {
                bVar.a(this.iRl);
                this.iRn.add(bVar);
            }
            if (this.iRm != null) {
                for (SearchForum searchForum : this.iRm) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.iQL);
                        bVar2.a(searchForum);
                        this.iRn.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> cAV() {
        return this.iRn;
    }
}
