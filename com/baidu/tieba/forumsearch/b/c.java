package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes18.dex */
public class c {
    private SearchForum hDP;
    private List<SearchForum> hDQ;
    private ArrayList<q> hDR;
    private String hDo;

    public c(String str) {
        this.hDo = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hDP = dataRes.exact_match;
            this.hDQ = dataRes.fuzzy_match;
            this.hDR = new ArrayList<>();
            b bVar = new b(this.hDo);
            if (this.hDP != null) {
                bVar.a(this.hDP);
                this.hDR.add(bVar);
            }
            if (this.hDQ != null) {
                for (SearchForum searchForum : this.hDQ) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hDo);
                        bVar2.a(searchForum);
                        this.hDR.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> can() {
        return this.hDR;
    }
}
