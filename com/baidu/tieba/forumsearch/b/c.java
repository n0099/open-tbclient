package com.baidu.tieba.forumsearch.b;

import com.baidu.adp.widget.ListView.q;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchPostForum.DataRes;
import tbclient.SearchPostForum.SearchForum;
/* loaded from: classes18.dex */
public class c {
    private String hQD;
    private SearchForum hRd;
    private List<SearchForum> hRe;
    private ArrayList<q> hRf;

    public c(String str) {
        this.hQD = str;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.hRd = dataRes.exact_match;
            this.hRe = dataRes.fuzzy_match;
            this.hRf = new ArrayList<>();
            b bVar = new b(this.hQD);
            if (this.hRd != null) {
                bVar.a(this.hRd);
                this.hRf.add(bVar);
            }
            if (this.hRe != null) {
                for (SearchForum searchForum : this.hRe) {
                    if (searchForum != null) {
                        b bVar2 = new b(this.hQD);
                        bVar2.a(searchForum);
                        this.hRf.add(bVar2);
                    }
                }
            }
        }
    }

    public ArrayList<q> ckJ() {
        return this.hRf;
    }
}
